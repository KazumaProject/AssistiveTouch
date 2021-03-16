package com.pythontaro.assistivetouchpro.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.content.FileProvider;
import androidx.core.internal.view.SupportMenu;
import com.pythontaro.assistivetouchpro.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenShotActivity extends Activity {

    private static final int NOTIFICATION_ID = 121;

    public int IMAGES_PRODUCED = 0;

    public String STORE_DIRECTORY;
    private int VIRTUAL_DISPLAY_FLAGS = 9;
    private int mDensity;
    private Display mDisplay;

    public int mHeight;

    public ImageReader mImageReader;
    private MediaProjection mMediaProjection;
    private MediaProjectionManager mMediaProjectionManager;
    private NotificationManager mNotificationManager;
    private int mResultCode = 0;
    private Intent mResultData = null;
    private VirtualDisplay mVirtualDisplay;

    public int mWidth;
    private DisplayMetrics metrics;

    private class ImageAvailableListener implements OnImageAvailableListener {
        private ImageAvailableListener() {
        }

        public void onImageAvailable(ImageReader imageReader) {
            Image acquireLatestImage;
            Bitmap createBitmap;
            FileOutputStream fileOutputStream;
            OutputStream outputStream = null;
            try {
                acquireLatestImage = ScreenShotActivity.this.mImageReader.acquireLatestImage();
                if (acquireLatestImage != null) {
                    try {
                        Plane[] planes = acquireLatestImage.getPlanes();
                        ByteBuffer buffer = planes[0].getBuffer();
                        int pixelStride = planes[0].getPixelStride();
                        createBitmap = Bitmap.createBitmap(ScreenShotActivity.this.mWidth + ((planes[0].getRowStride() - (ScreenShotActivity.this.mWidth * pixelStride)) / pixelStride), ScreenShotActivity.this.mHeight, Config.ARGB_8888);
                        try {
                            createBitmap.copyPixelsFromBuffer(buffer);
                            if (acquireLatestImage != null) {
                                acquireLatestImage.close();
                            }
                            if (ScreenShotActivity.this.IMAGES_PRODUCED == 0) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(ScreenShotActivity.this.STORE_DIRECTORY);
                                sb.append("/Screenshot_");
                                sb.append(ScreenShotActivity.this.getDateTime());
                                sb.append(".png");
                                String sb2 = sb.toString();
                                fileOutputStream = new FileOutputStream(sb2);
                                try {
                                    Bitmap.createBitmap(createBitmap, 0, 0, ScreenShotActivity.this.mWidth, ScreenShotActivity.this.mHeight).compress(CompressFormat.JPEG, 100, fileOutputStream);
                                    acquireLatestImage.close();
                                    ScreenShotActivity.this.IMAGES_PRODUCED = ScreenShotActivity.this.IMAGES_PRODUCED + 1;
                                    ScreenShotActivity.this.showNotificationScreenshot(sb2);
                                    ScreenShotActivity.this.stopScreenCapture();
                                    ScreenShotActivity.this.tearDownMediaProjection();
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("file://");
                                    sb3.append(sb2);
                                    ScreenShotActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(sb3.toString())));
                                    ScreenShotActivity.this.IMAGES_PRODUCED = 0;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    if (imageReader != null) {
                                        try {
                                            imageReader.close();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                        fileOutputStream.close();
                                        if (createBitmap != null) {
                                        }
                                        if (acquireLatestImage != null) {
                                        }
                                    }
                                    if (createBitmap != null) {
                                        createBitmap.recycle();
                                    }
                                    if (acquireLatestImage != null) {
                                        acquireLatestImage.close();
                                    } else {
                                        return;
                                    }
                                }
                                try {
                                    fileOutputStream.close();
                                    if (createBitmap != null) {
                                        createBitmap.recycle();
                                    }
                                    if (acquireLatestImage != null) {
                                        acquireLatestImage.close();
                                    }
                                    outputStream = fileOutputStream;
                                } catch (Exception e3) {
                                } catch (Throwable unused) {
                                }
                            }
                            ScreenShotActivity.this.IMAGES_PRODUCED = ScreenShotActivity.this.IMAGES_PRODUCED + 1;
                        } catch (Exception e4) {
                        } catch (Throwable unused2) {
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (acquireLatestImage != null) {
                            acquireLatestImage.close();
                        } else {
                            return;
                        }
                    } catch (Throwable unused22) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (acquireLatestImage != null) {
                    acquireLatestImage.close();
                }
                return;

            } catch (Exception e7) {
                e7.printStackTrace();
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = "android.permission.WRITE_EXTERNAL_STORAGE";
        if (checkSelfPermission(str) != 0) {
            ActivityCompat.requestPermissions(this, new String[]{str}, 131);
            Toast.makeText(this, R.string.str_permission_remind, Toast.LENGTH_SHORT).show();
            return;
        }
        this.metrics = getResources().getDisplayMetrics();
        this.mDensity = this.metrics.densityDpi;
        this.mDisplay = getWindowManager().getDefaultDisplay();
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        this.mMediaProjectionManager = (MediaProjectionManager) getSystemService(MEDIA_PROJECTION_SERVICE);
        activeScreenCapture();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setUpMediaProjection() {

        if (this.mMediaProjection == null) {
            this.mMediaProjection = this.mMediaProjectionManager.getMediaProjection(this.mResultCode, this.mResultData);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void activeScreenCapture() {
        startActivityForResult(this.mMediaProjectionManager.createScreenCaptureIntent(), 100);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setUpVirtualDisplay() {
        Point point = new Point();
        this.mDisplay.getSize(point);
        this.mWidth = point.x;
        this.mHeight = point.y;
        StringBuilder sb = new StringBuilder();
        sb.append("Size: ");
        sb.append(this.mWidth);
        sb.append(" ");
        sb.append(this.mHeight);
        this.mImageReader = ImageReader.newInstance(this.mWidth, this.mHeight, 1, 2);
        this.mVirtualDisplay = this.mMediaProjection.createVirtualDisplay("screencap", this.mWidth, this.mHeight, this.mDensity, this.VIRTUAL_DISPLAY_FLAGS, this.mImageReader.getSurface(), null, null);
        this.IMAGES_PRODUCED = 0;
        this.mImageReader.setOnImageAvailableListener(new ImageAvailableListener(), null);
    }

    public String getDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(Calendar.getInstance().getTime());
    }


    public void showNotificationScreenshot(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(FileProvider.getUriForFile(this, "com.pythontaro.assistivetouchpro.provider", new File(str)), "image/*");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 0);
        Builder builder = new Builder(this, "");
        builder.setSmallIcon(android.R.color.transparent);
        builder.setContentTitle(getString(R.string.title_notification_screenshot));
        builder.setContentText(getString(R.string.content_notification_screenshot));
        builder.setLargeIcon(decodeFile);
        builder.setContentIntent(activity);
        builder.setAutoCancel(true);
        this.mNotificationManager.cancel(NOTIFICATION_ID);
        if (Build.VERSION.SDK_INT >= 26) {
            String str2 = "my_channel_id";
            NotificationChannel notificationChannel = new NotificationChannel(str2, "NOTIFICATION_CHANNEL_NAME", NotificationManager.IMPORTANCE_LOW);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            builder.setChannelId(str2);
            this.mNotificationManager.createNotificationChannel(notificationChannel);
        }
        this.mNotificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        try {
            finish();
        } catch (Exception unused) {
        }
    }


    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 != -1) {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                stopScreenCapture();
                tearDownMediaProjection();
                finish();
                return;
            }
            this.mResultData = intent;
            this.mResultCode = i2;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ScreenShotActivity.this.startCaptureScreen();
                }
            }, 250);
            finish();
        }
    }

    public void startCaptureScreen() {
        if (this.mResultCode != 0 && this.mResultData != null) {
            if (this.mMediaProjection != null) {
                tearDownMediaProjection();
            }
            setUpMediaProjection();
            if (this.mMediaProjection != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                sb.append("/Screenshots/");
                this.STORE_DIRECTORY = sb.toString();
                File file = new File(this.STORE_DIRECTORY);
                if (file.exists() || file.mkdirs()) {
                    setUpVirtualDisplay();
                    return;
                }
                Log.e(NotificationCompat.CATEGORY_STATUS, "Failed to create file storage directory.");
                stopScreenCapture();
                tearDownMediaProjection();
            }
        }
    }


    public void stopScreenCapture() {
        VirtualDisplay virtualDisplay = this.mVirtualDisplay;
        if (virtualDisplay != null) {
            virtualDisplay.release();
            this.mVirtualDisplay = null;
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                imageReader.setOnImageAvailableListener(null, null);
            }
        }
    }


    public void tearDownMediaProjection() {
        MediaProjection mediaProjection = this.mMediaProjection;
        if (mediaProjection != null) {
            mediaProjection.stop();
            this.mMediaProjection = null;
        }
    }

    public boolean isScreenshotActived() {
        return this.mResultCode == -1 && this.mResultData != null;
    }
}
