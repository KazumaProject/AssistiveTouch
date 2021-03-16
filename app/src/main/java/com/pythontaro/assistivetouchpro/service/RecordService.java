package com.pythontaro.assistivetouchpro.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.display.VirtualDisplay;
import android.media.MediaRecorder;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import com.pythontaro.assistivetouchpro.R;
import com.pythontaro.assistivetouchpro.ui.ScreenRecorderActiivty;
import java.io.IOException;
import static android.app.Activity.RESULT_OK;
import static android.hardware.display.DisplayManager.VIRTUAL_DISPLAY_FLAG_PRESENTATION;
import static android.os.Environment.DIRECTORY_DOWNLOADS;


public final class RecordService extends Service {

    private ServiceHandler mServiceHandler;
    private MediaProjection mMediaProjection;
    private VirtualDisplay mVirtualDisplay;
    private MediaRecorder mMediaRecorder;
    private int resultCode;
    private Intent data;
    private BroadcastReceiver mScreenStateReceiver;
    public  static String datapath ;

    private static final String TAG = "RECORDERSERVICE";
    private static final String EXTRA_RESULT_CODE = "resultcode";
    private static final String EXTRA_DATA = "data";
    private static final int ONGOING_NOTIFICATION_ID = 23;


    public static Intent newIntent(Context context, int resultCode, Intent data) {
        Intent intent = new Intent(context,RecordService.class);
        intent.putExtra(EXTRA_RESULT_CODE, resultCode);
        intent.putExtra(EXTRA_DATA, data);
        return intent;
    }

    public class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch(action){
                case Intent.ACTION_SCREEN_ON:
                    startRecording(resultCode, data);
                    break;
                case Intent.ACTION_SCREEN_OFF:
                    stopRecording();
                    break;
                case Intent.ACTION_CONFIGURATION_CHANGED:
                    stopRecording();
                    startRecording(resultCode, data);
                    break;
            }
        }
    }

    // Handler that receives messages from the thread
    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {
            if (resultCode == RESULT_OK) {
                startRecording(resultCode, data);
            }else{
            }
        }
    }

    @Override
    public void onCreate() {

        showNotification();

        // register receiver to check if the phone screen is on or off
        mScreenStateReceiver = new MyBroadcastReceiver();
        IntentFilter screenStateFilter = new IntentFilter();
        screenStateFilter.addAction(Intent.ACTION_SCREEN_ON);
        screenStateFilter.addAction(Intent.ACTION_SCREEN_OFF);
        screenStateFilter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        registerReceiver(mScreenStateReceiver, screenStateFilter);

        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        Looper mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        resultCode = intent.getIntExtra(EXTRA_RESULT_CODE, 0);
        data = intent.getParcelableExtra(EXTRA_DATA);

        if (resultCode == 0 || data == null) {
            throw new IllegalStateException("Result code or data missing.");
        }

        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        return START_REDELIVER_INTENT;
    }

    private void startRecording(int resultCode, Intent data) {

        MediaProjectionManager mProjectionManager = (MediaProjectionManager) getApplicationContext().getSystemService (Context.MEDIA_PROJECTION_SERVICE);
        mMediaRecorder = new MediaRecorder();

        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(WINDOW_SERVICE);
        wm.getDefaultDisplay().getRealMetrics(metrics);

        int mScreenDensity = metrics.densityDpi;
        int displayWidth = metrics.widthPixels;
        int displayHeight = metrics.heightPixels;

        mMediaRecorder.setVideoSource(MediaRecorder.VideoSource.SURFACE);
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mMediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
        mMediaRecorder.setVideoEncodingBitRate(8 * 1000 * 1000);
        mMediaRecorder.setVideoFrameRate(15);
        mMediaRecorder.setVideoSize(displayWidth, displayHeight);

        String videoDir = Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).getAbsolutePath();

        Long timestamp = System.currentTimeMillis();

        String orientation = "portrait";
        if( displayWidth > displayHeight ) {
            orientation = "landscape";
        }
        String filePathAndName = videoDir + "/Assistive Screen Record_" + timestamp.toString() + "_" + orientation + ".mp4";

        datapath = filePathAndName;

        mMediaRecorder.setOutputFile( filePathAndName );

        try {
            mMediaRecorder.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mMediaProjection = mProjectionManager.getMediaProjection(resultCode, data);
        Surface surface = mMediaRecorder.getSurface();
        mVirtualDisplay = mMediaProjection.createVirtualDisplay("MainActivity",
                displayWidth, displayHeight, mScreenDensity, VIRTUAL_DISPLAY_FLAG_PRESENTATION,
                surface, null, null);
        mMediaRecorder.start();

        Log.v(TAG, "Started recording");
    }

    private void stopRecording() {
        mMediaRecorder.stop();
        mMediaProjection.stop();
        mMediaRecorder.release();
        mVirtualDisplay.release();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy() {
        stopRecording();
        unregisterReceiver(mScreenStateReceiver);
        stopSelf();
//        Toast.makeText(this, "Recorder service stopped", Toast.LENGTH_SHORT).show();
//        DialogService(servicecontext,"datapath","Screen Recoder Stop");
    }


    private void showNotification() {

        try {
           Intent intent =  new Intent(this, ScreenRecorderActiivty.class);
           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(android.R.color.transparent);
            builder.setPriority(-3);
            builder.setLargeIcon(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.srpng), 52, 52, false));
            builder.setOngoing(true);
            builder.setContentTitle("Screen Recorder").setTicker("App running smothly");
            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification_sr);
            remoteViews.setOnClickPendingIntent(R.id.stpimg, activity);
            remoteViews.setTextViewText(R.id.notification_layout_tv_first, "Assistive Screen Recorder");
            remoteViews.setTextViewText(R.id.notification_layout_tv_second, "recording screen in background");
            if ( Build.VERSION.SDK_INT >= 26) {
                createChanelID();
                builder.setChannelId("sr_channal");
            }
            builder.setCustomContentView(remoteViews);
            startForeground(ONGOING_NOTIFICATION_ID, builder.build());
        } catch (Exception ignored) {
        }
    }

//    Intent notificationIntent =  new Intent(this, RecordService.class);
//    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

    @SuppressLint("WrongConstant")
    @TargetApi(26)
    private void createChanelID() {
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel("sr_channal", "Screen Recorder", 3);
            notificationChannel.setDescription("recording screen in background");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            notificationManager.createNotificationChannel(notificationChannel);
        } catch (Exception ignored) {
        }
    }

}
