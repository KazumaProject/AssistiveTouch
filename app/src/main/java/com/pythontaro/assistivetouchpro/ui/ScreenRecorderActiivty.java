package com.pythontaro.assistivetouchpro.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.pythontaro.assistivetouchpro.R;
import com.pythontaro.assistivetouchpro.service.RecordService;

import java.util.ArrayList;

public class ScreenRecorderActiivty extends AppCompatActivity {

    RunTimePermission runTimePermission;
    private static final String TAG = "DATARECORDER";
    private static final int PERMISSION_CODE = 1;
    private MediaProjectionManager mProjectionManager;

    public void init(){
        mProjectionManager = (MediaProjectionManager) getSystemService (Context.MEDIA_PROJECTION_SERVICE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView((int) R.layout.activity_screen_recorder_actiivty);
        super.onCreate(savedInstanceState);

        init();
        boolean isRecording = isServiceRunning(RecordService.class);

        if(isRecording){
            stopRecordingService();
        }else {
            startActivityForResult(mProjectionManager.createScreenCaptureIntent(), PERMISSION_CODE);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != PERMISSION_CODE) {
            Log.e(TAG, "Unknown request code: " + requestCode);
            return;
        }
        if (resultCode == RESULT_OK) {
            startRecordingService(resultCode, data);
        } else {
            Toast.makeText(this, "Screen Cast Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    public void onToggleScreenShare(View view) {
        if ( ((ToggleButton)view).isChecked() ) {
            // ask for permission to capture screen and act on result after
            startActivityForResult(mProjectionManager.createScreenCaptureIntent(), PERMISSION_CODE);
            Log.v(TAG, "onToggleScreenShare");
        } else {
            Log.v(TAG, "onToggleScreenShare: Recording Stopped");
            stopRecordingService();
        }
    }

    private void startRecordingService(int resultCode, Intent data){
        Intent intent = RecordService.newIntent(ScreenRecorderActiivty.this, resultCode, data);
        startService(intent);


        DialogService(ScreenRecorderActiivty.this,"Screen Recorder Start","Data will save in storage");

    }

    private void stopRecordingService(){
        Intent intent = new Intent(ScreenRecorderActiivty.this, RecordService.class);
        stopService(intent);
        //Log.d("datapath"," activty :  "+sharedPrefranceChecker.loaddatapath());
        DialogService(ScreenRecorderActiivty.this,"Screen Recorder Stop","Data store in download directory");

    }

    private boolean isServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        runTimePermission = new RunTimePermission(ScreenRecorderActiivty.this);
        runTimePermission.requestPermission(new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, new RunTimePermission.RunTimePermissionListener() {

            @Override
            public void permissionGranted() {

            }

            @Override
            public void permissionDenied() {
                Toast.makeText(getApplicationContext(),"Please grant the Permission",Toast.LENGTH_SHORT).show();


            }
        });


    }

        public void DialogService(Context context,String title,String data){
            final Dialog dialogService = new Dialog(context, R.style.WideDialog);
            dialogService.setCancelable(true);
            dialogService.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialogService.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialogService.setContentView(R.layout.dialog_service);

            TextView RecorderTitle,RecorderData;

            RecorderData = dialogService.findViewById(R.id.recoderdata);

            RecorderTitle = dialogService.findViewById(R.id.recodertitle);

            RecorderTitle.setText(title);

            RecorderData.setText(data);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialogService.dismiss();
                }
            }, 2000);

            dialogService.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {

                    finish();
                }
            });

        dialogService.show();
    }

    @SuppressLint("Registered")
    public static class RunTimePermission extends AppCompatActivity {

        private AppCompatActivity activity;
        private ArrayList<PermissionBean> arrayListPermission;
        private String[] arrayPermissions;
        private RunTimePermissionListener runTimePermissionListener;

        public RunTimePermission(AppCompatActivity activity)
        {
            this.activity = activity;
        }

        public class PermissionBean {
            String permission;
            boolean isAccept;
        }

        public void requestPermission(String[] permissions, RunTimePermissionListener runTimePermissionListener) {
            this.runTimePermissionListener = runTimePermissionListener;
            arrayListPermission = new ArrayList<PermissionBean>();


            for (int i = 0; i < permissions.length; i++)
            {
                PermissionBean permissionBean = new PermissionBean();
                if (ContextCompat.checkSelfPermission(activity, permissions[i]) == PackageManager.PERMISSION_GRANTED)
                {
                    permissionBean.isAccept = true;
                }
                else
                {
                    permissionBean.isAccept = false;
                    permissionBean.permission = permissions[i];
                    arrayListPermission.add(permissionBean);
                }
            }

            if (arrayListPermission.size() <= 0)
            {
                runTimePermissionListener.permissionGranted();
                return;
            }
            arrayPermissions = new String[arrayListPermission.size()];
            for (int i = 0; i < arrayListPermission.size(); i++)
            {
                arrayPermissions[i] = arrayListPermission.get(i).permission;
            }
            activity.requestPermissions(arrayPermissions, 10);
        }

        public interface RunTimePermissionListener
        {

            void permissionGranted();

            void permissionDenied();
        }

        private void callSettingActivity()
        {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
            intent.setData(uri);
            activity.startActivity(intent);

        }

        private void checkUpdate()
        {
            boolean isGranted = true;
            int deniedCount = 0;
            for (int i = 0; i < arrayListPermission.size(); i++) {
                if (!arrayListPermission.get(i).isAccept) {
                    isGranted = false;
                    deniedCount++;
                }
            }

            if (isGranted) {
                if (runTimePermissionListener != null) {
                    runTimePermissionListener.permissionGranted();
                }
            }
            else {
                if (runTimePermissionListener != null) {

                    runTimePermissionListener.permissionDenied();
                }
            }
        }

        private void updatePermissionResult(String permissions, int grantResults) {

            for (int i = 0; i < arrayListPermission.size(); i++) {
                if (arrayListPermission.get(i).permission.equals(permissions)) {
                    if (grantResults == 0) {
                        arrayListPermission.get(i).isAccept = true;
                    }
                    else {
                        arrayListPermission.get(i).isAccept = false;
                    }
                    break;
                }
            }
        }

        public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
            for (int i = 0; i < permissions.length; i++) {
                updatePermissionResult(permissions[i], grantResults[i]);
            }
            checkUpdate();
        }
    }
}
