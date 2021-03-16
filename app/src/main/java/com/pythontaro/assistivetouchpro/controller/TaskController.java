package com.pythontaro.assistivetouchpro.controller;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.pythontaro.assistivetouchpro.R;
import com.pythontaro.assistivetouchpro.custom.BoxedVertical;
import com.pythontaro.assistivetouchpro.ui.ScreenRecorderActiivty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

import static android.net.ConnectivityManager.RESTRICT_BACKGROUND_STATUS_DISABLED;
import static android.net.ConnectivityManager.RESTRICT_BACKGROUND_STATUS_ENABLED;
import static android.net.ConnectivityManager.RESTRICT_BACKGROUND_STATUS_WHITELISTED;

//All Tasks from Service
public class TaskController {

    private final Context context;
    ComponentName mAdminName;
    DevicePolicyManager mDPM;
    private final AudioManager audioManager;
    private final SharedPreferenceController sharedPreferenceController;
    private final NotificationManager notificationManager;

    public TaskController(Context context) {
        this.context = context;
        this.mDPM = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        this.mAdminName = new ComponentName(context, MyAdmin.class);
        this.audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        this.sharedPreferenceController = new SharedPreferenceController(context);
        this.notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void OpenStatusBar(){
        try {
            NavigationService.navigationService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_QUICK_SETTINGS);
        } catch (Exception e) {
            Log.e("Error", String.valueOf(e));
            gotoAccessibility();
        }
    }

    public void OpenNotification(){
        try {
            NavigationService.navigationService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS);
        } catch (Exception e) {
            Log.e("Error", String.valueOf(e));
            gotoAccessibility();
        }
    }

    public void OpenHomeScreen(){
        try {
            NavigationService.navigationService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME);
        } catch (Exception e) {
            Log.e("Error", String.valueOf(e));
            gotoAccessibility();
        }
    }

    public void lockScreen() {
        try {
            NavigationService.navigationService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_LOCK_SCREEN);
        } catch (Exception e) {
            Log.e("Error", String.valueOf(e));
            gotoAccessibility();
        }
    }

    public void splitWindow(){
        try {
            NavigationService.navigationService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN);
        }catch (Exception e){
            Log.e("Error", String.valueOf(e));
            gotoAccessibility();
        }
    }

    public void openPowerAction() {
        try {
            NavigationService.navigationService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_POWER_DIALOG);
        } catch (Exception e) {
            e.printStackTrace();
            gotoAccessibility();
        }
    }

    public void setVolumeUp(){
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
    }

    public void setVolumeDown(){
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
    }

    public boolean isAutoRotateModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 0;
    }

    public void goToMobileData(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(
                "com.android.settings",
                "com.android.settings.Settings$DataUsageSummaryActivity"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void openVolumePanel(){
        Intent intent;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            intent = new Intent(Settings.Panel.ACTION_VOLUME);
        }else {
            intent = new Intent(Settings.ACTION_SOUND_SETTINGS);
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void openSetting(){
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void openDeveloper(){
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void openCamera(){
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @SuppressLint("WrongConstant")
    private void gotoAccessibility() {
        try {
            Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception ignored) {
        }
    }

    private boolean isBoosting = false;

    public void progressBooster() {
        try {
            if (!isBoosting) {
                isBoosting = true;
                new TaskMemoryBoost(this.context, true, new TaskMemoryBoost.OnTaskMemoryBoostListener() {
                    public void onMemoryBoostSuccess(boolean z, long j) {
                        if (z) {
                            Toast.makeText(context, String.format(context.getString(R.string.free_ram), new Object[]{Utils.formatSize(j)}), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, context.getString(R.string.device_has_been_boosted), Toast.LENGTH_SHORT).show();
                        }
                        isBoosting = false;
                    }
                }).execute(new Void[0]);
            }
        } catch (Exception ignored) {}
    }

    public void openRecentAction() {
        try {
            NavigationService.navigationService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_RECENTS);
        } catch (Exception e) {
            gotoAccessibility();
            e.printStackTrace();
        }
    }

    public void openLocation(){
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void setStartRecord(){
        Intent intent = new Intent(context, ScreenRecorderActiivty.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void setScreenShot(){
        try {
            NavigationService.navigationService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_TAKE_SCREENSHOT);
        } catch (Exception e) {
            Log.e("Error", String.valueOf(e));
            gotoAccessibility();
        }
    }

    public void setOpenAirPlaneMode(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            Intent air_plane_intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);
            air_plane_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(air_plane_intent);
        }else {
            Intent intent2 = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.context.startActivity(intent2);
        }
    }

    public void startWifiIntent(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            Intent intent = new Intent(Settings.Panel.ACTION_WIFI);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else {
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            boolean wifiEnabled = Objects.requireNonNull(wifiManager).isWifiEnabled();
            if (wifiEnabled){
                wifiManager.setWifiEnabled(false);
                Toast.makeText(context,"turning Off Wifi",Toast.LENGTH_SHORT).show();
            }else {
                wifiManager.setWifiEnabled(true);
                Toast.makeText(context,"turning On Wifi",Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void setFlashLight(){
        switch (sharedPreferenceController.getFlashLightState()){
            default:
            case 0:
                turnOffCameraFlash();
                break;
            case 1:
                turnOnCameraFlash();
                break;
        }
    }

    private void turnOnCameraFlash() {
        try {
            try {
                CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
                assert cameraManager != null;
                cameraManager.setTorchMode(cameraManager.getCameraIdList()[0], true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ignored) {
        }
    }

    private void turnOffCameraFlash() {
        try {
            try {
                CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
                assert cameraManager != null;
                cameraManager.setTorchMode(cameraManager.getCameraIdList()[0], false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ignored) {
        }
    }


    public void animation_BounceLeft(View view) {
        final Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.bounse_left);
        view.startAnimation(myAnim);
        BounceInterpolator interpolator = new BounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        view.startAnimation(myAnim);
    }

    public void animation_BounceRight(View view) {
        final Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce_right);
        view.startAnimation(myAnim);
        BounceInterpolator interpolator = new BounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        view.startAnimation(myAnim);
    }


    public static final String SERVICECMD = "com.android.music.musicservicecommand";

    public boolean isOtherAudioPlaying(){
        return audioManager.isMusicActive();
    }

    public void setStopMusic(){
        audioManager.requestAudioFocus(null,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
    }

    public void setVolumeToSeekBar(BoxedVertical seekBar){
        try {
            seekBar.setValue(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            seekBar.setStep(1);
            seekBar.setOnBoxedPointsChangeListener(new BoxedVertical.OnValuesChangeListener() {
                @Override
                public void onPointsChanged(BoxedVertical boxedPoints, int points) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,points,0);
                    Log.d("Volume Amount", String.valueOf(points));
                    Log.d("Volume Amount manager", String.valueOf(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)));
                    Log.d("Volume Amount manager", String.valueOf(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)));
                }

                @Override
                public void onStartTrackingTouch(BoxedVertical boxedPoints) {

                }

                @Override
                public void onStopTrackingTouch(BoxedVertical boxedPoints) {

                }
            });
        }catch (Exception ignored){}

    }

    public void setDoNotDisturb(){
        if (!Objects.requireNonNull(notificationManager).isNotificationPolicyAccessGranted()){
            Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else {
            if (notificationManager.getCurrentInterruptionFilter() == NotificationManager.INTERRUPTION_FILTER_ALL) {
                notificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE);
            } else {
                notificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_ALL);
            }
        }
    }

    public boolean isDoNotDisturb(){
        return notificationManager.getCurrentInterruptionFilter() == NotificationManager.INTERRUPTION_FILTER_ALL;
    }

    public void setResumeMusic(){
        audioManager.abandonAudioFocus(null);
    }

    public boolean checkBackgroundDataRestricted() {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        switch (Objects.requireNonNull(connMgr).getRestrictBackgroundStatus()) {
            case RESTRICT_BACKGROUND_STATUS_ENABLED:
                // Background data usage and push notifications are blocked for this app
                return true;

            default:
            case RESTRICT_BACKGROUND_STATUS_WHITELISTED:
            case RESTRICT_BACKGROUND_STATUS_DISABLED:
                // Data Saver is disabled or the app is whitelisted
                return false;
        }
    }

    public static class TaskMemoryBoost extends AsyncTask<Void, Void, Boolean> {
        private long beforeMemory;
        boolean isDelay;
        private Context mContext;
        private OnTaskMemoryBoostListener mOnTaskMemoryBoostListener;

        public interface OnTaskMemoryBoostListener {
            void onMemoryBoostSuccess(boolean z, long j);
        }


        public void onPreExecute() {
        }

        public TaskMemoryBoost(Context context, boolean z, OnTaskMemoryBoostListener onTaskMemoryBoostListener) {
            this.mOnTaskMemoryBoostListener = onTaskMemoryBoostListener;
            this.mContext = context;
            this.isDelay = z;
        }


        public Boolean doInBackground(Void... voidArr) {
            if (this.isDelay) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return Boolean.valueOf(false);
                }
            }
            return Boolean.valueOf(isMemBoost());
        }


        public void onPostExecute(Boolean bool) {
            long j;
            ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService(Context.ACTIVITY_SERVICE);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.availMem;
            long j3 = this.beforeMemory;
            if (j2 > j3) {
                j = (long) ((int) (j2 - j3));
            } else {
                j = 0;
                bool = Boolean.valueOf(false);
            }
            this.mOnTaskMemoryBoostListener.onMemoryBoostSuccess(bool.booleanValue(), j);
        }

        @SuppressLint("WrongConstant")
        private boolean isMemBoost() {
            PackageManager packageManager = this.mContext.getPackageManager();
            int length = packageManager.getClass().getDeclaredMethods().length;
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("CACHE", 0);
            String str = "date_last";
            long currentTimeMillis = System.currentTimeMillis() - sharedPreferences.getLong(str, 0);
            if (currentTimeMillis <= 600000 && currentTimeMillis <= 7200000) {
                return false;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(str, currentTimeMillis2);
            edit.apply();
            Method[] declaredMethods = packageManager.getClass().getDeclaredMethods();
            if (length > 0 && !declaredMethods[0].getName().equals("freeStorage")) {
                try {
                    Object[] objArr = {Long.valueOf(0), Integer.valueOf(0)};
                } catch (Exception unused) {
                }
            }
            ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService(Context.ACTIVITY_SERVICE);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            this.beforeMemory = memoryInfo.availMem;
            List runningAppProcesses = activityManager.getRunningAppProcesses();
            for (int i = 0; i < runningAppProcesses.size(); i++) {
                String str2 = ((ActivityManager.RunningAppProcessInfo) runningAppProcesses.get(i)).processName;
                if (!str2.equals(this.mContext.getPackageName())) {
                    ApplicationInfo applicationInfo = null;
                    try {
                        applicationInfo = packageManager.getApplicationInfo(str2, 128);
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (applicationInfo == null || !Utils.isUserApp(applicationInfo)) {
                        for (int i2 = 0; i2 < 3; i2++) {
                            activityManager.killBackgroundProcesses(((ActivityManager.RunningAppProcessInfo) runningAppProcesses.get(i)).processName);
                        }
                    }
                }
            }
            return true;
        }
    }

    public static class Utils {
        @SuppressLint("WrongConstant")

        public static int getScreenWidth(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            return displayMetrics.widthPixels;
        }

        public static float dp2px(Resources resources, float f) {
            return (f * resources.getDisplayMetrics().density) + 0.5f;
        }

        public static float sp2px(Resources resources, float f) {
            return f * resources.getDisplayMetrics().scaledDensity;
        }

        public static void setTextFromSize(long j, TextView textView, TextView textView2) {
            String str = "MB";
            if (j <= 0) {
                textView.setText(String.valueOf(0.0d));
                textView2.setText(str);
                return;
            }
            String[] strArr = {"B", "KB", str, "GB", "TB"};
            double d = (double) j;
            int log10 = (int) (Math.log10(d) / Math.log10(1024.0d));
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.#");
            double pow = Math.pow(1024.0d, (double) log10);
            Double.isNaN(d);
            textView.setText(String.valueOf(decimalFormat.format(d / pow)));
            textView2.setText(strArr[log10]);
        }


        public static void openURL(Context context, String str) {
            try {
                context.getApplicationContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
            }
        }

        public static String getAppUrl(Context context) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://play.google.com/store/apps/details?id=");
            sb.append(context.getPackageName());
            return sb.toString();
        }

        public static String formatSize(long j) {
            if (j <= 0) {
                return "0 MB";
            }
            String[] strArr = {"B", "KB", "MB", "GB", "TB"};
            double d = (double) j;
            int log10 = (int) (Math.log10(d) / Math.log10(1024.0d));
            StringBuilder sb = new StringBuilder();
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.#");
            double pow = Math.pow(1024.0d, (double) log10);
            Double.isNaN(d);
            sb.append(decimalFormat.format(d / pow));
            sb.append(" ");
            sb.append(strArr[log10]);
            return sb.toString();
        }

        public static boolean isUserApp(ApplicationInfo applicationInfo) {
            return (applicationInfo.flags & 129) == 0;
        }

        public static long getTotalRam() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                String readLine = bufferedReader.readLine();
                String[] split = readLine.split("\\s+");
                for (String str : split) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("\t");
                    Log.i(readLine, sb.toString());
                }
                long intValue = (long) (Integer.valueOf(split[1]).intValue() * 1024);
                bufferedReader.close();
                return intValue;
            } catch (IOException unused) {
                return -1;
            }
        }


    }

    public static class MyAdmin extends DeviceAdminReceiver {
    }

    public static class NavigationService extends AccessibilityService {

        public static NavigationService navigationService;

        public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        }

        public void onInterrupt() {
        }


        public void onServiceConnected() {
            super.onServiceConnected();
            navigationService = this;
        }
    }

    public static class BounceInterpolator implements android.view.animation.Interpolator{
        private double mAmplitude = 1;
        private double mFrequency = 10;

        public BounceInterpolator(double amplitude, double frequency) {
            mAmplitude = amplitude;
            mFrequency = frequency;
        }

        @Override
        public float getInterpolation(float input) {
            return (float) (-1 * Math.pow(Math.E, -input/ mAmplitude) * Math.cos(mFrequency * input) + 1);
        }
    }

}
