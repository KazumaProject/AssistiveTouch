package com.pythontaro.assistivetouchpro.service;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pythontaro.assistivetouchpro.R;
import com.pythontaro.assistivetouchpro.adapter.InstalledAppListAdapter;
import com.pythontaro.assistivetouchpro.controller.ServiceController;
import com.pythontaro.assistivetouchpro.controller.SharedPreferenceController;
import com.pythontaro.assistivetouchpro.controller.TaskController;
import com.pythontaro.assistivetouchpro.custom.BoxedVertical;
import com.pythontaro.assistivetouchpro.custom.Techniques;
import com.pythontaro.assistivetouchpro.custom.YoYo;
import com.pythontaro.assistivetouchpro.model.AppDetails;
import com.pythontaro.assistivetouchpro.ui.SettingsActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static android.app.PendingIntent.FLAG_CANCEL_CURRENT;
import static android.view.View.VISIBLE;

public class MainService extends Service {

    private ServiceController serviceController;
    private SharedPreferenceController preferenceController;
    private TaskController taskController;

    private Context context;

    private WindowManager mWindowManager;
    private WindowManager.LayoutParams params;
    private WindowManager.LayoutParams params2;

    private View floatingRootView;
    private ImageView assitiveTouch;
    private RelativeLayout expandRootView;

    private View expand_1_icons_menu;
    private View expand_2_icons_menu;
    private View expand_3_icons_menu;
    private View expand_4_icons_menu;
    private View expand_5_icons_menu;
    private View expand_6_icons_menu;
    private View expand_7_icons_menu;
    private View expand_8_icons_menu;

    private View expand_custom_menu;
    private View expand_device_menu;
    private View expand_device_sub_menu;
    private View control_center_view;
    private View expand_gesture_menu;

    private ConstraintLayout deviceMenuIconView;

    //Item1
    private RelativeLayout parent_1_1;
    private ImageButton btn_1_1;
    private TextView text_1_1;

    //Item2
    private RelativeLayout parent_1_2;
    private RelativeLayout parent_2_2;
    private ImageButton btn_1_2;
    private ImageButton btn_2_2;
    private TextView text_1_2;
    private TextView text_2_2;
    
    //Item3
    private RelativeLayout parent_1_3;
    private RelativeLayout parent_2_3;
    private RelativeLayout parent_3_3;
    private ImageButton btn_1_3;
    private ImageButton btn_2_3;
    private ImageButton btn_3_3;
    private TextView text_1_3;
    private TextView text_2_3;
    private TextView text_3_3;

    //Item4
    private RelativeLayout parent_1_4;
    private RelativeLayout parent_2_4;
    private RelativeLayout parent_3_4;
    private RelativeLayout parent_4_4;
    private ImageButton btn_1_4;
    private ImageButton btn_2_4;
    private ImageButton btn_3_4;
    private ImageButton btn_4_4;
    private TextView text_1_4;
    private TextView text_2_4;
    private TextView text_3_4;
    private TextView text_4_4;
    
    //Item5
    private RelativeLayout parent_1_5;
    private RelativeLayout parent_2_5;
    private RelativeLayout parent_3_5;
    private RelativeLayout parent_4_5;
    private RelativeLayout parent_5_5;
    private ImageButton btn_1_5;
    private ImageButton btn_2_5;
    private ImageButton btn_3_5;
    private ImageButton btn_4_5;
    private ImageButton btn_5_5;
    private TextView text_1_5;
    private TextView text_2_5;
    private TextView text_3_5;
    private TextView text_4_5;
    private TextView text_5_5;

    //Item6
    private RelativeLayout parent_1;
    private RelativeLayout parent_2;
    private RelativeLayout parent_3;
    private RelativeLayout parent_4;
    private RelativeLayout parent_6;
    private RelativeLayout parent_7;

    private ImageButton btn_1;
    private ImageButton btn_2;
    private ImageButton btn_3;
    private ImageButton btn_4;
    private ImageButton btn_6;
    private ImageButton btn_7;
    private TextView text_1;
    private TextView text_2;
    private TextView text_3;
    private TextView text_4;
    private TextView text_6;
    private TextView text_7;

    //Item7
    private RelativeLayout parent_1_7;
    private RelativeLayout parent_2_7;
    private RelativeLayout parent_3_7;
    private RelativeLayout parent_4_7;
    private RelativeLayout parent_5_7;
    private RelativeLayout parent_6_7;
    private RelativeLayout parent_7_7;
    private ImageButton btn_1_7;
    private ImageButton btn_2_7;
    private ImageButton btn_3_7;
    private ImageButton btn_4_7;
    private ImageButton btn_5_7;
    private ImageButton btn_6_7;
    private ImageButton btn_7_7;
    private TextView text_1_7;
    private TextView text_2_7;
    private TextView text_3_7;
    private TextView text_4_7;
    private TextView text_5_7;
    private TextView text_6_7;
    private TextView text_7_7;

    //Item 8
    private RelativeLayout parent_1_8;
    private RelativeLayout parent_2_8;
    private RelativeLayout parent_3_8;
    private RelativeLayout parent_4_8;
    private RelativeLayout parent_5_8;
    private RelativeLayout parent_6_8;
    private RelativeLayout parent_7_8;
    private RelativeLayout parent_8_8;
    private ImageButton btn_1_8;
    private ImageButton btn_2_8;
    private ImageButton btn_3_8;
    private ImageButton btn_4_8;
    private ImageButton btn_5_8;
    private ImageButton btn_6_8;
    private ImageButton btn_7_8;
    private ImageButton btn_8_8;
    private TextView text_1_8;
    private TextView text_2_8;
    private TextView text_3_8;
    private TextView text_4_8;
    private TextView text_5_8;
    private TextView text_6_8;
    private TextView text_7_8;
    private TextView text_8_8;

    private RelativeLayout parent_1_custom;
    private RelativeLayout parent_2_custom;
    private RelativeLayout parent_3_custom;
    private RelativeLayout parent_4_custom;
    private RelativeLayout parent_6_custom;
    private RelativeLayout parent_7_custom;
    private RelativeLayout parent_8_custom;
    private RelativeLayout parent_9_custom;

    private ImageButton btn_1_custom;
    private ImageButton btn_2_custom;
    private ImageButton btn_3_custom;
    private ImageButton btn_4_custom;
    private ImageButton btn_5_custom;
    private ImageButton btn_6_custom;
    private ImageButton btn_7_custom;
    private ImageButton btn_8_custom;
    private ImageButton btn_9_custom;
    private TextView text_1_custom;
    private TextView text_2_custom;
    private TextView text_3_custom;
    private TextView text_4_custom;
    private TextView text_6_custom;
    private TextView text_7_custom;
    private TextView text_8_custom;
    private TextView text_9_custom;

    private RelativeLayout parent_1_device;
    private RelativeLayout parent_2_device;
    private RelativeLayout parent_3_device;
    private RelativeLayout parent_5_device;
    private RelativeLayout parent_6_device;
    private RelativeLayout parent_7_device;

    private ImageButton btn_1_device;
    private ImageButton btn_2_device;
    private ImageButton btn_3_device;
    private ImageButton btn_4_device;
    private ImageButton btn_5_device;
    private ImageButton btn_6_device;
    private ImageButton btn_7_device;
    private TextView text_1_device;
    private TextView text_2_device;
    private TextView text_3_device;
    private TextView text_5_device;
    private TextView text_6_device;
    private TextView text_7_device;

    private RelativeLayout parent_1_device_sub;
    private RelativeLayout parent_2_device_sub;
    private RelativeLayout parent_3_device_sub;
    private RelativeLayout parent_5_device_sub;
    private RelativeLayout parent_6_device_sub;
    private RelativeLayout parent7_device_sub;

    private ImageButton btn_1_device_sub;
    private ImageButton btn_2_device_sub;
    private ImageButton btn_3_device_sub;
    private ImageButton btn_4_device_sub;
    private ImageButton btn_5_device_sub;
    private ImageButton btn_6_device_sub;
    private ImageButton btn_7_device_sub;

    private TextView text_1_device_sub;
    private TextView text_2_device_sub;
    private TextView text_3_device_sub;
    private TextView text_5_device_sub;
    private TextView text_6_device_sub;
    private TextView text_7_device_sub;

    private ImageButton btn_airPlaneMode;
    private ImageButton btn_wifi;
    private ImageButton btn_bluetooth;
    private ImageButton btn_mobile;
    private ImageView play_music;
    private ImageView pause_music;
    private ImageButton rotate_control_center;
    private ImageButton btn_doNotDisturb;
    private ConstraintLayout screen_recording_control_center;
    private BoxedVertical brightness_seekBar;
    private BoxedVertical volume_seekBar;
    private ImageButton control_center_custom_1;
    private ImageButton control_center_custom_2;
    private ImageButton control_center_custom_3;
    private ImageButton control_center_custom_4;

    private ImageButton btn_1_gesture;
    private TextView text_1_gesture;
    private RelativeLayout parent_1_gesture;
    private ImageButton btn_2_gesture;
    private TextView text_2_gesture;
    private RelativeLayout parent_2_gesture;
    private ImageButton btn_4_gesture;

    private final HandlerWithID handlerWithID = new HandlerWithID();

    private Runnable runnable;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();

        switch (preferenceController.getIdleOpacity()){
            case 0:
                setOpacity(0f);
                break;
            case 1:
                setOpacity(0.1f);
                break;
            case 2:
                setOpacity(0.2f);
                break;
            case 3:
                setOpacity(0.3f);
                break;
            case 4:
                setOpacity(0.4f);
                break;
            default:
            case 5:
                setOpacity(0.5f);
                break;
            case 6:
                setOpacity(0.6f);
                break;
            case 7:
                setOpacity(0.7f);
                break;
            case 8:
                setOpacity(0.8f);
                break;
            case 9:
                setOpacity(0.9f);
                break;
            case 10:
                setOpacity(1.0f);
                break;
        }

        setWindowManagerAssitiveTouch();
        setWindowManagerExpandMain();

        setInitMain_1_items_menu();
        setInitMain_2_items_menu();
        setInitMain_3_items_menu();
        setInitMain_4_items_menu();
        setInitMain_5_items_menu();
        setInitMain_6_items_menu();
        setInitMain_7_items_menu();
        setInitMain_8_items_menu();

        setExpandCustomMenu();
        setExpandDeviceMenu();
        setExpand_device_sub_menu();
        setControlCenter();
        setGestureMenu();
        setIconSize();
        setReceivers();

        runHandlerOneTime();

        switch (preferenceController.getItemCount()){
            case 1:
                expand_1_icons_menu.setVisibility(VISIBLE);
                expand_2_icons_menu.setVisibility(View.GONE);
                expand_3_icons_menu.setVisibility(View.GONE);
                expand_4_icons_menu.setVisibility(View.GONE);
                expand_5_icons_menu.setVisibility(View.GONE);
                expand_6_icons_menu.setVisibility(View.GONE);
                expand_7_icons_menu.setVisibility(View.GONE);
                expand_8_icons_menu.setVisibility(View.GONE);
                break;
            case 2:
                expand_1_icons_menu.setVisibility(View.GONE);
                expand_2_icons_menu.setVisibility(VISIBLE);
                expand_3_icons_menu.setVisibility(View.GONE);
                expand_4_icons_menu.setVisibility(View.GONE);
                expand_5_icons_menu.setVisibility(View.GONE);
                expand_6_icons_menu.setVisibility(View.GONE);
                expand_7_icons_menu.setVisibility(View.GONE);
                expand_8_icons_menu.setVisibility(View.GONE);
                break;
            case 3:
                expand_1_icons_menu.setVisibility(View.GONE);
                expand_2_icons_menu.setVisibility(View.GONE);
                expand_3_icons_menu.setVisibility(VISIBLE);
                expand_4_icons_menu.setVisibility(View.GONE);
                expand_5_icons_menu.setVisibility(View.GONE);
                expand_6_icons_menu.setVisibility(View.GONE);
                expand_7_icons_menu.setVisibility(View.GONE);
                expand_8_icons_menu.setVisibility(View.GONE);
                break;
            case 4:
                expand_1_icons_menu.setVisibility(View.GONE);
                expand_2_icons_menu.setVisibility(View.GONE);
                expand_3_icons_menu.setVisibility(View.GONE);
                expand_4_icons_menu.setVisibility(VISIBLE);
                expand_5_icons_menu.setVisibility(View.GONE);
                expand_6_icons_menu.setVisibility(View.GONE);
                expand_7_icons_menu.setVisibility(View.GONE);
                expand_8_icons_menu.setVisibility(View.GONE);
                break;
            case 5:
                expand_1_icons_menu.setVisibility(View.GONE);
                expand_2_icons_menu.setVisibility(View.GONE);
                expand_3_icons_menu.setVisibility(View.GONE);
                expand_4_icons_menu.setVisibility(View.GONE);
                expand_5_icons_menu.setVisibility(VISIBLE);
                expand_6_icons_menu.setVisibility(View.GONE);
                expand_7_icons_menu.setVisibility(View.GONE);
                expand_8_icons_menu.setVisibility(View.GONE);
                break;
            default:
            case 6:
                expand_1_icons_menu.setVisibility(View.GONE);
                expand_2_icons_menu.setVisibility(View.GONE);
                expand_3_icons_menu.setVisibility(View.GONE);
                expand_4_icons_menu.setVisibility(View.GONE);
                expand_5_icons_menu.setVisibility(View.GONE);
                expand_6_icons_menu.setVisibility(View.VISIBLE);
                expand_7_icons_menu.setVisibility(View.GONE);
                expand_8_icons_menu.setVisibility(View.GONE);
                break;
            case 7:
                expand_1_icons_menu.setVisibility(View.GONE);
                expand_2_icons_menu.setVisibility(View.GONE);
                expand_3_icons_menu.setVisibility(View.GONE);
                expand_4_icons_menu.setVisibility(View.GONE);
                expand_5_icons_menu.setVisibility(View.GONE);
                expand_6_icons_menu.setVisibility(View.GONE);
                expand_7_icons_menu.setVisibility(VISIBLE);
                expand_8_icons_menu.setVisibility(View.GONE);
                break;
            case 8:
                expand_1_icons_menu.setVisibility(View.GONE);
                expand_2_icons_menu.setVisibility(View.GONE);
                expand_3_icons_menu.setVisibility(View.GONE);
                expand_4_icons_menu.setVisibility(View.GONE);
                expand_5_icons_menu.setVisibility(View.GONE);
                expand_6_icons_menu.setVisibility(View.GONE);
                expand_7_icons_menu.setVisibility(View.GONE);
                expand_8_icons_menu.setVisibility(VISIBLE);
                break;
}
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        removeServiceView();
        unregisterReceiver(wifiReceiver);
        unregisterReceiver(bluetoothChangeReceiver);
        stopSelf();
        stopForeground(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startServiceForeground();
        return START_STICKY;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            serviceController.restartService();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            serviceController.restartService();
        }
    }

    private GestureDetector gestureDetector;
    private final GestureDetector.SimpleOnGestureListener gestureListener = new GestureDetector.SimpleOnGestureListener(){
        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
            YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(assitiveTouch);
            setCollapsedToExpandLongPress();
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(assitiveTouch);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setCollapsedToExpand();
                }
            },500);
            runHandlerOneTime();
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(assitiveTouch);
            setCollapsedToExpandDoublePress();
            return true;
        }
    };

    @SuppressLint("InflateParams")
    private void init(){
        context = MainService.this;
        serviceController = new ServiceController(context);
        preferenceController = new SharedPreferenceController(context);
        taskController = new TaskController(context);

        gestureDetector = new GestureDetector(context,this.gestureListener);

        floatingRootView = LayoutInflater.from(this).inflate(R.layout.main_service,null);
        floatingRootView.findViewById(R.id.rootView);
        assitiveTouch = floatingRootView.findViewById(R.id.collapsed_image);
        expandRootView = floatingRootView.findViewById(R.id.expandRootView);

        expand_1_icons_menu = floatingRootView.findViewById(R.id.expand_1_icons_menu);
        expand_2_icons_menu = floatingRootView.findViewById(R.id.expand_2_icons_menu);
        expand_3_icons_menu = floatingRootView.findViewById(R.id.expand_3_icons_menu);
        expand_4_icons_menu = floatingRootView.findViewById(R.id.expand_4_icons_menu);
        expand_5_icons_menu = floatingRootView.findViewById(R.id.expand_5_icons_menu);
        expand_6_icons_menu  = floatingRootView.findViewById(R.id.expand_6_icons_menu);
        expand_7_icons_menu = floatingRootView.findViewById(R.id.expand_7_icons_menu);
        expand_8_icons_menu = floatingRootView.findViewById(R.id.expand_8_icons_menu);

        expand_custom_menu = floatingRootView.findViewById(R.id.expand_custom_menu);
        expand_device_menu = floatingRootView.findViewById(R.id.expand_device_menu);
        expand_device_sub_menu = expand_device_menu.findViewById(R.id.device_sub_view);
        control_center_view = floatingRootView.findViewById(R.id.control_center_layout);
        expand_gesture_menu = floatingRootView.findViewById(R.id.expand_gesture_menu);

        deviceMenuIconView = expand_device_menu.findViewById(R.id.device_main_view);

        cResolver = this.getApplicationContext().getContentResolver();

        //Item 1
        parent_1_1 = expand_1_icons_menu.findViewById(R.id.parent_1_item_service);
        btn_1_1 = expand_1_icons_menu.findViewById(R.id.center_1_item_img_service);
        text_1_1 = expand_1_icons_menu.findViewById(R.id.center_1_text_service);
        
        //Item 2
        parent_1_2 = expand_2_icons_menu.findViewById(R.id.item_1_2_service);
        parent_2_2 = expand_2_icons_menu.findViewById(R.id.item_2_2_service);
        btn_1_2 = expand_2_icons_menu.findViewById(R.id.item_1_2_img_service);
        btn_2_2 = expand_2_icons_menu.findViewById(R.id.item_2_2_img_service);
        text_1_2 = expand_2_icons_menu.findViewById(R.id.item_1_2_text_service);
        text_2_2 = expand_2_icons_menu.findViewById(R.id.item_2_2_text_service);
        
        //Item 3
        parent_1_3 = expand_3_icons_menu.findViewById(R.id.item_1_3_service);
        parent_2_3 = expand_3_icons_menu.findViewById(R.id.item_2_3_service);
        parent_3_3 = expand_3_icons_menu.findViewById(R.id.item_3_3_service);
        btn_1_3 = expand_3_icons_menu.findViewById(R.id.item_1_3_img_service);
        btn_2_3 = expand_3_icons_menu.findViewById(R.id.item_2_3_img_service);
        btn_3_3 = expand_3_icons_menu.findViewById(R.id.item_3_3_img_service);
        text_1_3 = expand_3_icons_menu.findViewById(R.id.item_1_3_text_service);
        text_2_3 = expand_3_icons_menu.findViewById(R.id.item_2_3_text_service);
        text_3_3 = expand_3_icons_menu.findViewById(R.id.item_3_3_text_service);
        
        //Item 4
        parent_1_4 = expand_4_icons_menu.findViewById(R.id.item_1_4_service);
        parent_2_4 = expand_4_icons_menu.findViewById(R.id.item_2_4_service);
        parent_3_4 = expand_4_icons_menu.findViewById(R.id.item_3_4_service);
        parent_4_4 = expand_4_icons_menu.findViewById(R.id.item_4_4_service);
        btn_1_4 = expand_4_icons_menu.findViewById(R.id.item_1_4_img_service);
        btn_2_4 = expand_4_icons_menu.findViewById(R.id.item_2_4_img_service);
        btn_3_4 = expand_4_icons_menu.findViewById(R.id.item_3_4_img_service);
        btn_4_4 = expand_4_icons_menu.findViewById(R.id.item_4_4_img_service);
        text_1_4 = expand_4_icons_menu.findViewById(R.id.item_1_4_text_service);
        text_2_4 = expand_4_icons_menu.findViewById(R.id.item_2_4_text_service);
        text_3_4 = expand_4_icons_menu.findViewById(R.id.item_3_4_text_service);
        text_4_4 = expand_4_icons_menu.findViewById(R.id.item_4_4_text_service);
        
        //Item 5
        parent_1_5 = expand_5_icons_menu.findViewById(R.id.parent_1_5_service);
        parent_2_5 = expand_5_icons_menu.findViewById(R.id.parent_2_5_service);
        parent_3_5 = expand_5_icons_menu.findViewById(R.id.parent_3_5_service);
        parent_4_5 = expand_5_icons_menu.findViewById(R.id.parent_4_5_service);
        parent_5_5 = expand_5_icons_menu.findViewById(R.id.parent_5_5_service);
        btn_1_5 = expand_5_icons_menu.findViewById(R.id.item_1_5_img_service);
        btn_2_5 = expand_5_icons_menu.findViewById(R.id.item_2_5_img_service);
        btn_3_5 = expand_5_icons_menu.findViewById(R.id.item_3_5_img_service);
        btn_4_5 = expand_5_icons_menu.findViewById(R.id.item_4_5_img_service);
        btn_5_5 = expand_5_icons_menu.findViewById(R.id.item_5_5_img_service);
        text_1_5 = expand_5_icons_menu.findViewById(R.id.item_1_5_text_service);
        text_2_5 = expand_5_icons_menu.findViewById(R.id.item_2_5_text_service);
        text_3_5 = expand_5_icons_menu.findViewById(R.id.item_3_5_text_service);
        text_4_5 = expand_5_icons_menu.findViewById(R.id.item_4_5_text_service);
        text_5_5 = expand_5_icons_menu.findViewById(R.id.item_5_5_text_service);

        //Item 6
        parent_1 = expand_6_icons_menu.findViewById(R.id.parent_1_service);
        parent_2 = expand_6_icons_menu.findViewById(R.id.parent_2_service);
        parent_3 = expand_6_icons_menu.findViewById(R.id.parent_3_service);
        parent_4 = expand_6_icons_menu.findViewById(R.id.parent_4_service);
        parent_6 = expand_6_icons_menu.findViewById(R.id.parent_6_service);
        parent_7 = expand_6_icons_menu.findViewById(R.id.parent_7_service);

        btn_1 = expand_6_icons_menu.findViewById(R.id.btn_1_service);
        btn_2 = expand_6_icons_menu.findViewById(R.id.btn_2_service);
        btn_3 = expand_6_icons_menu.findViewById(R.id.btn_3_service);
        btn_4 = expand_6_icons_menu.findViewById(R.id.btn_4_service);
        btn_6 = expand_6_icons_menu.findViewById(R.id.btn_6_serivce);
        btn_7 = expand_6_icons_menu.findViewById(R.id.btn_7_service);

        text_1 = expand_6_icons_menu.findViewById(R.id.text_1_service);
        text_2 = expand_6_icons_menu.findViewById(R.id.text_2_service);
        text_3 = expand_6_icons_menu.findViewById(R.id.text_3_service);
        text_4 = expand_6_icons_menu.findViewById(R.id.text_4_service);
        text_6 = expand_6_icons_menu.findViewById(R.id.text_6_service);
        text_7 = expand_6_icons_menu.findViewById(R.id.text_7_service);

        //Item 7
        parent_1_7 = expand_7_icons_menu.findViewById(R.id.item_1_7_service);
        parent_2_7 = expand_7_icons_menu.findViewById(R.id.item_2_7_service);
        parent_3_7 = expand_7_icons_menu.findViewById(R.id.item_3_7_service);
        parent_4_7 = expand_7_icons_menu.findViewById(R.id.item_4_7_service);
        parent_5_7 = expand_7_icons_menu.findViewById(R.id.item_5_7_service);
        parent_6_7 = expand_7_icons_menu.findViewById(R.id.item_6_7_service);
        parent_7_7 = expand_7_icons_menu.findViewById(R.id.item_7_7_service);

        btn_1_7 = expand_7_icons_menu.findViewById(R.id.item_1_7_img_service);
        btn_2_7 = expand_7_icons_menu.findViewById(R.id.item_2_7_img_service);
        btn_3_7 = expand_7_icons_menu.findViewById(R.id.item_3_7_img_service);
        btn_4_7 = expand_7_icons_menu.findViewById(R.id.item_4_7_img_service);
        btn_5_7 = expand_7_icons_menu.findViewById(R.id.item_5_7_img_service);
        btn_6_7 = expand_7_icons_menu.findViewById(R.id.item_6_7_img_service);
        btn_7_7 = expand_7_icons_menu.findViewById(R.id.item_7_7_img_service);

        text_1_7 = expand_7_icons_menu.findViewById(R.id.item_1_7_text_service);
        text_2_7 = expand_7_icons_menu.findViewById(R.id.item_2_7_text_service);
        text_3_7 = expand_7_icons_menu.findViewById(R.id.item_3_7_text_service);
        text_4_7 = expand_7_icons_menu.findViewById(R.id.item_4_7_text_service);
        text_5_7 = expand_7_icons_menu.findViewById(R.id.item_5_7_text_service);
        text_6_7 = expand_7_icons_menu.findViewById(R.id.item_6_7_text_service);
        text_7_7 = expand_7_icons_menu.findViewById(R.id.item_7_7_text_service);

        //Item 8
        parent_1_8 = expand_8_icons_menu.findViewById(R.id.item_1_8_service);
        parent_2_8 = expand_8_icons_menu.findViewById(R.id.item_2_8_service);
        parent_3_8 = expand_8_icons_menu.findViewById(R.id.item_3_8_service);
        parent_4_8 = expand_8_icons_menu.findViewById(R.id.item_4_8_service);
        parent_5_8 = expand_8_icons_menu.findViewById(R.id.item_5_8_service);
        parent_6_8 = expand_8_icons_menu.findViewById(R.id.item_6_8_service);
        parent_7_8 = expand_8_icons_menu.findViewById(R.id.item_7_8_service);
        parent_8_8 = expand_8_icons_menu.findViewById(R.id.item_8_8_service);

        btn_1_8 = expand_8_icons_menu.findViewById(R.id.item_1_8_img_service);
        btn_2_8 = expand_8_icons_menu.findViewById(R.id.item_2_8_img_service);
        btn_3_8 = expand_8_icons_menu.findViewById(R.id.item_3_8_img_service);
        btn_4_8 = expand_8_icons_menu.findViewById(R.id.item_4_8_img_service);
        btn_5_8 = expand_8_icons_menu.findViewById(R.id.item_5_8_img_service);
        btn_6_8 = expand_8_icons_menu.findViewById(R.id.item_6_8_img_service);
        btn_7_8 = expand_8_icons_menu.findViewById(R.id.item_7_8_img_service);
        btn_8_8 = expand_8_icons_menu.findViewById(R.id.item_8_8_img_service);

        text_1_8 = expand_8_icons_menu.findViewById(R.id.item_1_8_text_service);
        text_2_8 = expand_8_icons_menu.findViewById(R.id.item_2_8_text_service);
        text_3_8 = expand_8_icons_menu.findViewById(R.id.item_3_8_text_service);
        text_4_8 = expand_8_icons_menu.findViewById(R.id.item_4_8_text_service);
        text_5_8 = expand_8_icons_menu.findViewById(R.id.item_5_8_text_service);
        text_6_8 = expand_8_icons_menu.findViewById(R.id.item_6_8_text_service);
        text_7_8 = expand_8_icons_menu.findViewById(R.id.item_7_8_text_service);
        text_8_8 = expand_8_icons_menu.findViewById(R.id.item_8_8_text_service);

        //Custom
        parent_1_custom = expand_custom_menu.findViewById(R.id.parent_1_custom);
        parent_2_custom = expand_custom_menu.findViewById(R.id.parent_2_custom);
        parent_3_custom = expand_custom_menu.findViewById(R.id.parent_3_custom);
        parent_4_custom = expand_custom_menu.findViewById(R.id.parent_4_custom);
        parent_6_custom = expand_custom_menu.findViewById(R.id.parent_6_custom);
        parent_7_custom = expand_custom_menu.findViewById(R.id.parent_7_custom);
        parent_8_custom = expand_custom_menu.findViewById(R.id.parent_8_custom);
        parent_9_custom = expand_custom_menu.findViewById(R.id.parent_9_custom);

        btn_1_custom = expand_custom_menu.findViewById(R.id.btn_1_custom);
        btn_2_custom = expand_custom_menu.findViewById(R.id.btn_2_custom);
        btn_3_custom = expand_custom_menu.findViewById(R.id.btn_3_custom);
        btn_4_custom = expand_custom_menu.findViewById(R.id.btn_4_custom);
        btn_5_custom = expand_custom_menu.findViewById(R.id.btn_5_custom);
        btn_6_custom = expand_custom_menu.findViewById(R.id.btn_6_custom);
        btn_7_custom = expand_custom_menu.findViewById(R.id.btn_7_custom);
        btn_8_custom = expand_custom_menu.findViewById(R.id.btn_8_custom);
        btn_9_custom = expand_custom_menu.findViewById(R.id.btn_9_custom);

        text_1_custom = expand_custom_menu.findViewById(R.id.text_1_custom);
        text_2_custom = expand_custom_menu.findViewById(R.id.text_2_custom);
        text_3_custom = expand_custom_menu.findViewById(R.id.text_3_custom);
        text_4_custom = expand_custom_menu.findViewById(R.id.text_4_custom);
        text_6_custom = expand_custom_menu.findViewById(R.id.text_6_custom);
        text_7_custom = expand_custom_menu.findViewById(R.id.text_7_custom);
        text_8_custom = expand_custom_menu.findViewById(R.id.text_8_custom);
        text_9_custom = expand_custom_menu.findViewById(R.id.text_9_custom);

        parent_1_device = expand_device_menu.findViewById(R.id.parent_1_device);
        parent_2_device = expand_device_menu.findViewById(R.id.parent_2_device);
        parent_3_device = expand_device_menu.findViewById(R.id.parent_3_device);
        parent_5_device = expand_device_menu.findViewById(R.id.parent_5_device);
        parent_6_device = expand_device_menu.findViewById(R.id.parent_6_device);
        parent_7_device = expand_device_menu.findViewById(R.id.parent_7_device);

        btn_1_device = expand_device_menu.findViewById(R.id.btn_1_device);
        btn_2_device = expand_device_menu.findViewById(R.id.btn_2_device);
        btn_3_device = expand_device_menu.findViewById(R.id.btn_3_device);
        btn_4_device = expand_device_menu.findViewById(R.id.btn_4_device);
        btn_5_device = expand_device_menu.findViewById(R.id.btn_5_device);
        btn_6_device = expand_device_menu.findViewById(R.id.btn_6_device);
        btn_7_device = expand_device_menu.findViewById(R.id.btn_7_device);

        text_1_device = expand_device_menu.findViewById(R.id.text_1_device);
        text_2_device = expand_device_menu.findViewById(R.id.text_2_device);
        text_3_device = expand_device_menu.findViewById(R.id.text_3_device);
        text_5_device = expand_device_menu.findViewById(R.id.text_5_device);
        text_6_device = expand_device_menu.findViewById(R.id.text_6_device);
        text_7_device = expand_device_menu.findViewById(R.id.text_7_device);

        parent_1_device_sub = expand_device_sub_menu.findViewById(R.id.parent_1_sub_device);
        parent_2_device_sub = expand_device_sub_menu.findViewById(R.id.parent_2_sub_device);
        parent_3_device_sub = expand_device_sub_menu.findViewById(R.id.parent_3_sub_device);
        parent_5_device_sub = expand_device_sub_menu.findViewById(R.id.parent_5_sub_device);
        parent_6_device_sub = expand_device_sub_menu.findViewById(R.id.parent_6_sub_device);
        parent7_device_sub = expand_device_sub_menu.findViewById(R.id.parent_7_sub_device);

        btn_1_device_sub = expand_device_sub_menu.findViewById(R.id.btn_1_sub_device);
        btn_2_device_sub = expand_device_sub_menu.findViewById(R.id.btn_2_sub_device);
        btn_3_device_sub = expand_device_sub_menu.findViewById(R.id.btn_3_sub_device);
        btn_4_device_sub = expand_device_sub_menu.findViewById(R.id.btn_4_sub_device);
        btn_5_device_sub = expand_device_sub_menu.findViewById(R.id.btn_5_sub_device);
        btn_6_device_sub = expand_device_sub_menu.findViewById(R.id.btn_6_sub_device);
        btn_7_device_sub = expand_device_sub_menu.findViewById(R.id.btn_7_sub_device);

        text_1_device_sub = expand_device_sub_menu.findViewById(R.id.text_1_sub_device);
        text_2_device_sub = expand_device_sub_menu.findViewById(R.id.text_2_sub_device);
        text_3_device_sub = expand_device_sub_menu.findViewById(R.id.text_3_sub_device);
        text_5_device_sub = expand_device_sub_menu.findViewById(R.id.text_5_sub_device);
        text_6_device_sub = expand_device_sub_menu.findViewById(R.id.text_6_sub_device);
        text_7_device_sub = expand_device_sub_menu.findViewById(R.id.text_7_sub_device);

        btn_airPlaneMode = control_center_view.findViewById(R.id.air_plane_mode_btn);
        btn_wifi = control_center_view.findViewById(R.id.wifi_btn);
        btn_bluetooth = control_center_view.findViewById(R.id.blueTooth_btn);
        btn_mobile = control_center_view.findViewById(R.id.mobile_data_btn);
        play_music = control_center_view.findViewById(R.id.play_music_control_center);
        pause_music = control_center_view.findViewById(R.id.pause_music_control_center);
        rotate_control_center = control_center_view.findViewById(R.id.rotate_control_center);
        btn_doNotDisturb = control_center_view.findViewById(R.id.btn_doNotDisturb);
        screen_recording_control_center = control_center_view.findViewById(R.id.screen_recording_control_center);
        brightness_seekBar = control_center_view.findViewById(R.id.seekBar_brightness);
        volume_seekBar = control_center_view.findViewById(R.id.seekBar_volume);
        control_center_custom_1 = control_center_view.findViewById(R.id.btn_control_custom1);
        control_center_custom_2 = control_center_view.findViewById(R.id.btn_control_custom2);
        control_center_custom_3 = control_center_view.findViewById(R.id.btn_control_custom3);
        control_center_custom_4 = control_center_view.findViewById(R.id.btn_control_custom4);

        btn_1_gesture = expand_gesture_menu.findViewById(R.id.btn_1_gesture);
        text_1_gesture = expand_gesture_menu.findViewById(R.id.text_1_gesture);
        parent_1_gesture = expand_gesture_menu.findViewById(R.id.parent_1_gesture);
        btn_2_gesture = expand_gesture_menu.findViewById(R.id.btn_2_gesture);
        text_2_gesture = expand_gesture_menu.findViewById(R.id.text_2_gesture);
        parent_2_gesture = expand_gesture_menu.findViewById(R.id.parent_2_gesture);
        btn_4_gesture = expand_gesture_menu.findViewById(R.id.btn_4_gesture);

        setParams();
        setAssistiveIconImage();
    }

    private void setReceivers(){
        IntentFilter wifiIntentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiReceiver, wifiIntentFilter);
        IntentFilter intentFilter_bluetooth = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(bluetoothChangeReceiver, intentFilter_bluetooth);

    }

    private void setIconSize(){
        switch (preferenceController.getIconSize()){
            case 1:
                assitiveTouch.getLayoutParams().height = 145;
                assitiveTouch.getLayoutParams().width = 145;
                break;
            case 2:
                assitiveTouch.getLayoutParams().height = 155;
                assitiveTouch.getLayoutParams().width = 155;
                break;
            case 3:
                assitiveTouch.getLayoutParams().height = 175;
                assitiveTouch.getLayoutParams().width = 175;
                break;
            case 4:
                assitiveTouch.getLayoutParams().height = 185;
                assitiveTouch.getLayoutParams().width = 185;
                break;
            case 5:
                assitiveTouch.getLayoutParams().height = 200;
                assitiveTouch.getLayoutParams().width = 200;
                break;
            default:
                assitiveTouch.getLayoutParams().height = 128;
                assitiveTouch.getLayoutParams().width = 128;
                break;
        }
    }

    private void setInitMain_1_items_menu(){
        switch (getActionBtn1()){
            case 0:
                btn_1_1.setVisibility(View.INVISIBLE);
                text_1_1.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_1_1);
                setOpenHomeScreen(text_1_1);
                setOpenHomeScreen(parent_1_1);
                break;
            case 2:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_1_1);
                setOpenNotification(text_1_1);
                setOpenNotification(parent_1_1);
                break;
            case 3:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_1_1);
                setOpenControlPanel(text_1_1);
                setOpenControlPanel(parent_1_1);
                break;
            case 4:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_1_1);
                setOpenCustomMenu(text_1_1);
                setOpenCustomMenu(parent_1_1);
                break;
            case 5:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_1_1);
                setOpenGesture(text_1_1);
                setOpenGesture(parent_1_1);
                break;
            case 6:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_1_1);
                setOpenDeviceMenu(text_1_1);
                setOpenDeviceMenu(parent_1_1);
                break;
            case 7:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_1_1);
                setOpenScreenShot(text_1_1);
                setOpenScreenShot(parent_1_1);
                break;
            case 8:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_1_1);
                setOpenScreenRecord(text_1_1);
                setOpenScreenRecord(parent_1_1);
                break;
            case 9:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.boost));
                setBoost(btn_1_1);
                setBoost(text_1_1);
                setBoost(parent_1_1);
                break;
            case 10:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_1_1);
                setOpenLockScreen(text_1_1);
                setOpenLockScreen(parent_1_1);
                break;
            case 11:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.power));
                setOpenPower(btn_1_1);
                setOpenPower(text_1_1);
                setOpenPower(parent_1_1);
                break;
            case 12:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.stratus_bar));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_1_1);
                setOpenStatusBar(text_1_1);
                setOpenStatusBar(parent_1_1);
                break;
            case 13:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_1_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_1);
                text_1_1.setText(context.getText(R.string.recent));
                setOpenRecent(btn_1_1);
                setOpenRecent(text_1_1);
                setOpenRecent(parent_1_1);
                break;
        }
    }

    private void setInitMain_2_items_menu(){
        switch (getActionBtn1()){
            case 0:
                btn_1_2.setVisibility(View.INVISIBLE);
                text_1_2.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_1_2);
                setOpenHomeScreen(text_1_2);
                setOpenHomeScreen(parent_1_2);
                break;
            case 2:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_1_2);
                setOpenNotification(text_1_2);
                setOpenNotification(parent_1_2);
                break;
            case 3:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_1_2);
                setOpenControlPanel(text_1_2);
                setOpenControlPanel(parent_1_2);
                break;
            case 4:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_1_2);
                setOpenCustomMenu(text_1_2);
                setOpenCustomMenu(parent_1_2);
                break;
            case 5:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_1_2);
                setOpenGesture(text_1_2);
                setOpenGesture(parent_1_2);
                break;
            case 6:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_1_2);
                setOpenDeviceMenu(text_1_2);
                setOpenDeviceMenu(parent_1_2);
                break;
            case 7:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_1_2);
                setOpenScreenShot(text_1_2);
                setOpenScreenShot(parent_1_2);
                break;
            case 8:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_1_2);
                setOpenScreenRecord(text_1_2);
                setOpenScreenRecord(parent_1_2);
                break;
            case 9:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.boost));
                setBoost(btn_1_2);
                setBoost(text_1_2);
                setBoost(parent_1_2);
                break;
            case 10:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_1_2);
                setOpenLockScreen(text_1_2);
                setOpenLockScreen(parent_1_2);
                break;
            case 11:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.power));
                setOpenPower(btn_1_2);
                setOpenPower(text_1_2);
                setOpenPower(parent_1_2);
                break;
            case 12:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.stratus_bar));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_1_2);
                setOpenStatusBar(text_1_2);
                setOpenStatusBar(parent_1_2);
                break;
            case 13:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_1_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_2);
                text_1_2.setText(context.getText(R.string.recent));
                setOpenRecent(btn_1_2);
                setOpenRecent(text_1_2);
                setOpenRecent(parent_1_2);
                break;
        }

        switch (getActionBtn2()){
            case 0:
                btn_2_2.setVisibility(View.INVISIBLE);
                text_2_2.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_2_2);
                setOpenHomeScreen(text_2_2);
                setOpenHomeScreen(parent_2_2);
                break;
            case 2:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_2_2);
                setOpenNotification(text_2_2);
                setOpenNotification(parent_2_2);
                break;
            case 3:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_2_2);
                setOpenControlPanel(text_2_2);
                setOpenControlPanel(parent_2_2);
                break;
            case 4:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_2_2);
                setOpenCustomMenu(text_2_2);
                setOpenCustomMenu(parent_2_2);
                break;
            case 5:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_2_2);
                setOpenGesture(text_2_2);
                setOpenGesture(parent_2_2);
                break;
            case 6:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_2_2);
                setOpenDeviceMenu(text_2_2);
                setOpenDeviceMenu(parent_2_2);
                break;
            case 7:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_2_2);
                setOpenScreenShot(text_2_2);
                setOpenScreenShot(parent_2_2);
                break;
            case 8:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_2_2);
                setOpenScreenRecord(text_2_2);
                setOpenScreenRecord(parent_2_2);
                break;
            case 9:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.boost));
                setBoost(btn_2_2);
                setBoost(text_2_2);
                setBoost(parent_2_2);
                break;
            case 10:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_2_2);
                setOpenLockScreen(text_2_2);
                setOpenLockScreen(parent_2_2);
                break;
            case 11:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.power));
                setOpenPower(btn_2_2);
                setOpenPower(text_2_2);
                setOpenPower(parent_2_2);
                break;
            case 12:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.stratus_bar));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_2_2);
                setOpenStatusBar(text_2_2);
                setOpenStatusBar(parent_2_2);
                break;
            case 13:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_2_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_2);
                text_2_2.setText(context.getText(R.string.recent));
                setOpenRecent(btn_2_2);
                setOpenRecent(text_2_2);
                setOpenRecent(parent_2_2);
                break;
        }
    }

    private void setInitMain_3_items_menu(){
        switch (getActionBtn1()){
            case 0:
                btn_1_3.setVisibility(View.INVISIBLE);
                text_1_3.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_1_3);
                setOpenHomeScreen(text_1_3);
                setOpenHomeScreen(parent_1_3);
                break;
            case 2:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_1_3);
                setOpenNotification(text_1_3);
                setOpenNotification(parent_1_3);
                break;
            case 3:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_1_3);
                setOpenControlPanel(text_1_3);
                setOpenControlPanel(parent_1_3);
                break;
            case 4:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_1_3);
                setOpenCustomMenu(text_1_3);
                setOpenCustomMenu(parent_1_3);
                break;
            case 5:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_1_3);
                setOpenGesture(text_1_3);
                setOpenGesture(parent_1_3);
                break;
            case 6:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_1_3);
                setOpenDeviceMenu(text_1_3);
                setOpenDeviceMenu(parent_1_3);
                break;
            case 7:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_1_3);
                setOpenScreenShot(text_1_3);
                setOpenScreenShot(parent_1_3);
                break;
            case 8:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_1_3);
                setOpenScreenRecord(text_1_3);
                setOpenScreenRecord(parent_1_3);
                break;
            case 9:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.boost));
                setBoost(btn_1_3);
                setBoost(text_1_3);
                setBoost(parent_1_3);
                break;
            case 10:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_1_3);
                setOpenLockScreen(text_1_3);
                setOpenLockScreen(parent_1_3);
                break;
            case 11:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.power));
                setOpenPower(btn_1_3);
                setOpenPower(text_1_3);
                setOpenPower(parent_1_3);
                break;
            case 12:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.stratus_bar));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_1_3);
                setOpenStatusBar(text_1_3);
                setOpenStatusBar(parent_1_3);
                break;
            case 13:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_1_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_3);
                text_1_3.setText(context.getText(R.string.recent));
                setOpenRecent(btn_1_3);
                setOpenRecent(text_1_3);
                setOpenRecent(parent_1_3);
                break;
        }

        switch (getActionBtn2()){
            case 0:
                btn_2_3.setVisibility(View.INVISIBLE);
                text_2_3.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_2_3);
                setOpenHomeScreen(text_2_3);
                setOpenHomeScreen(parent_2_3);
                break;
            case 2:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_2_3);
                setOpenNotification(text_2_3);
                setOpenNotification(parent_2_3);
                break;
            case 3:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_2_3);
                setOpenControlPanel(text_2_3);
                setOpenControlPanel(parent_2_3);
                break;
            case 4:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_2_3);
                setOpenCustomMenu(text_2_3);
                setOpenCustomMenu(parent_2_3);
                break;
            case 5:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_2_3);
                setOpenGesture(text_2_3);
                setOpenGesture(parent_2_3);
                break;
            case 6:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_2_3);
                setOpenDeviceMenu(text_2_3);
                setOpenDeviceMenu(parent_2_3);
                break;
            case 7:    
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_2_3);
                setOpenScreenShot(text_2_3);
                setOpenScreenShot(parent_2_3);
                break;
            case 8:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_2_3);
                setOpenScreenRecord(text_2_3);
                setOpenScreenRecord(parent_2_3);
                break;
            case 9:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.boost));
                setBoost(btn_2_3);
                setBoost(text_2_3);
                setBoost(parent_2_3);
                break;
            case 10:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_2_3);
                setOpenLockScreen(text_2_3);
                setOpenLockScreen(parent_2_3);
                break;
            case 11:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.power));
                setOpenPower(btn_2_3);
                setOpenPower(text_2_3);
                setOpenPower(parent_2_3);
                break;
            case 12:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.stratus_bar));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_2_3);
                setOpenStatusBar(text_2_3);
                setOpenStatusBar(parent_2_3);
                break;
            case 13:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_2_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_3);
                text_2_3.setText(context.getText(R.string.recent));
                setOpenRecent(btn_2_3);
                setOpenRecent(text_2_3);
                setOpenRecent(parent_2_3);
                break;
        }

        switch (getActionBtn3()){
            case 0:
                btn_3_3.setVisibility(View.INVISIBLE);
                text_3_3.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_3_3);
                setOpenHomeScreen(text_3_3);
                setOpenHomeScreen(parent_3_3);
                break;
            case 2:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_3_3);
                setOpenNotification(text_3_3);
                setOpenNotification(parent_3_3);
                break;
            case 3:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_3_3);
                setOpenControlPanel(text_3_3);
                setOpenControlPanel(parent_3_3);
                break;
            case 4:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_3_3);
                setOpenCustomMenu(text_3_3);
                setOpenCustomMenu(parent_3_3);
                break;
            case 5:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_3_3);
                setOpenGesture(text_3_3);
                setOpenGesture(parent_3_3);
                break;
            case 6:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_3_3);
                setOpenDeviceMenu(text_3_3);
                setOpenDeviceMenu(parent_3_3);
                break;
            case 7:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_3_3);
                setOpenScreenShot(text_3_3);
                setOpenScreenShot(parent_3_3);
                break;
            case 8:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_3_3);
                setOpenScreenRecord(text_3_3);
                setOpenScreenRecord(parent_3_3);
                break;
            case 9:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.boost));
                setBoost(btn_3_3);
                setBoost(text_3_3);
                setBoost(parent_3_3);
                break;
            case 10:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_3_3);
                setOpenLockScreen(text_3_3);
                setOpenLockScreen(parent_3_3);
                break;
            case 11:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.power));
                setOpenPower(btn_3_3);
                setOpenPower(text_3_3);
                setOpenPower(parent_3_3);
                break;
            case 12:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.stratus_bar));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_3_3);
                setOpenStatusBar(text_3_3);
                setOpenStatusBar(parent_3_3);
                break;
            case 13:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_3_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_3);
                text_3_3.setText(context.getText(R.string.recent));
                setOpenRecent(btn_3_3);
                setOpenRecent(text_3_3);
                setOpenRecent(parent_3_3);
                break;
        }
        
    }

    private void setInitMain_4_items_menu(){
        switch (getActionBtn1()){
            case 0:
                btn_1_4.setVisibility(View.INVISIBLE);
                text_1_4.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_1_4);
                setOpenHomeScreen(text_1_4);
                setOpenHomeScreen(parent_1_4);
                break;
            case 2:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_1_4);
                setOpenNotification(text_1_4);
                setOpenNotification(parent_1_4);
                break;
            case 3:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_1_4);
                setOpenControlPanel(text_1_4);
                setOpenControlPanel(parent_1_4);
                break;
            case 4:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_1_4);
                setOpenCustomMenu(text_1_4);
                setOpenCustomMenu(parent_1_4);
                break;
            case 5:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_1_4);
                setOpenGesture(text_1_4);
                setOpenGesture(parent_1_4);
                break;
            case 6:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_1_4);
                setOpenDeviceMenu(text_1_4);
                setOpenDeviceMenu(parent_1_4);
                break;
            case 7:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_1_4);
                setOpenScreenShot(text_1_4);
                setOpenScreenShot(parent_1_4);
                break;
            case 8:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_1_4);
                setOpenScreenRecord(text_1_4);
                setOpenScreenRecord(parent_1_4);
                break;
            case 9:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.boost));
                setBoost(btn_1_4);
                setBoost(text_1_4);
                setBoost(parent_1_4);
                break;
            case 10:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_1_4);
                setOpenLockScreen(text_1_4);
                setOpenLockScreen(parent_1_4);
                break;
            case 11:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.power));
                setOpenPower(btn_1_4);
                setOpenPower(text_1_4);
                setOpenPower(parent_1_4);
                break;
            case 12:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_1_4);
                setOpenStatusBar(text_1_4);
                setOpenStatusBar(parent_1_4);
                break;
            case 13:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_1_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_4);
                text_1_4.setText(context.getText(R.string.recent));
                setOpenRecent(btn_1_4);
                setOpenRecent(text_1_4);
                setOpenRecent(parent_1_4);
                break;
        }

        switch (getActionBtn2()){
            case 0:
                btn_2_4.setVisibility(View.INVISIBLE);
                text_2_4.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_2_4);
                setOpenHomeScreen(text_2_4);
                setOpenHomeScreen(parent_2_4);
                break;
            case 2:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_2_4);
                setOpenNotification(text_2_4);
                setOpenNotification(parent_2_4);
                break;
            case 3:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_2_4);
                setOpenControlPanel(text_2_4);
                setOpenControlPanel(parent_2_4);
                break;
            case 4:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_2_4);
                setOpenCustomMenu(text_2_4);
                setOpenCustomMenu(parent_2_4);
                break;
            case 5:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_2_4);
                setOpenGesture(text_2_4);
                setOpenGesture(parent_2_4);
                break;
            case 6:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_2_4);
                setOpenDeviceMenu(text_2_4);
                setOpenDeviceMenu(parent_2_4);
                break;
            case 7:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_2_4);
                setOpenScreenShot(text_2_4);
                setOpenScreenShot(parent_2_4);
                break;
            case 8:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_2_4);
                setOpenScreenRecord(text_2_4);
                setOpenScreenRecord(parent_2_4);
                break;
            case 9:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.boost));
                setBoost(btn_2_4);
                setBoost(text_2_4);
                setBoost(parent_2_4);
                break;
            case 10:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_2_4);
                setOpenLockScreen(text_2_4);
                setOpenLockScreen(parent_2_4);
                break;
            case 11:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.power));
                setOpenPower(btn_2_4);
                setOpenPower(text_2_4);
                setOpenPower(parent_2_4);
                break;
            case 12:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_2_4);
                setOpenStatusBar(text_2_4);
                setOpenStatusBar(parent_2_4);
                break;
            case 13:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_2_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_4);
                text_2_4.setText(context.getText(R.string.recent));
                setOpenRecent(btn_2_4);
                setOpenRecent(text_2_4);
                setOpenRecent(parent_2_4);
                break;
        }

        switch (getActionBtn3()){
            case 0:
                btn_3_4.setVisibility(View.INVISIBLE);
                text_3_4.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_3_4);
                setOpenHomeScreen(text_3_4);
                setOpenHomeScreen(parent_3_4);
                break;
            case 2:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_3_4);
                setOpenNotification(text_3_4);
                setOpenNotification(parent_3_4);
                break;
            case 3:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_3_4);
                setOpenControlPanel(text_3_4);
                setOpenControlPanel(parent_3_4);
                break;
            case 4:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_3_4);
                setOpenCustomMenu(text_3_4);
                setOpenCustomMenu(parent_3_4);
                break;
            case 5:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_3_4);
                setOpenGesture(text_3_4);
                setOpenGesture(parent_3_4);
                break;
            case 6:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_3_4);
                setOpenDeviceMenu(text_3_4);
                setOpenDeviceMenu(parent_3_4);
                break;
            case 7:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_3_4);
                setOpenScreenShot(text_3_4);
                setOpenScreenShot(parent_3_4);
                break;
            case 8:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_3_4);
                setOpenScreenRecord(text_3_4);
                setOpenScreenRecord(parent_3_4);
                break;
            case 9:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.boost));
                setBoost(btn_3_4);
                setBoost(text_3_4);
                setBoost(parent_3_4);
                break;
            case 10:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_3_4);
                setOpenLockScreen(text_3_4);
                setOpenLockScreen(parent_3_4);
                break;
            case 11:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.power));
                setOpenPower(btn_3_4);
                setOpenPower(text_3_4);
                setOpenPower(parent_3_4);
                break;
            case 12:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_3_4);
                setOpenStatusBar(text_3_4);
                setOpenStatusBar(parent_3_4);
                break;
            case 13:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_3_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_4);
                text_3_4.setText(context.getText(R.string.recent));
                setOpenRecent(btn_3_4);
                setOpenRecent(text_3_4);
                setOpenRecent(parent_3_4);
                break;
        }

        switch (getActionBtn4()){
            case 0:
                btn_4_4.setVisibility(View.INVISIBLE);
                text_4_4.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_4_4);
                setOpenHomeScreen(text_4_4);
                setOpenHomeScreen(parent_4_4);
                break;
            case 2:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_4_4);
                setOpenNotification(text_4_4);
                setOpenNotification(parent_4_4);
                break;
            case 3:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_4_4);
                setOpenControlPanel(text_4_4);
                setOpenControlPanel(parent_4_4);
                break;
            case 4:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_4_4);
                setOpenCustomMenu(text_4_4);
                setOpenCustomMenu(parent_4_4);
                break;
            case 5:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_4_4);
                setOpenGesture(text_4_4);
                setOpenGesture(parent_4_4);
                break;
            case 6:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_4_4);
                setOpenDeviceMenu(text_4_4);
                setOpenDeviceMenu(parent_4_4);
                break;
            case 7:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_4_4);
                setOpenScreenShot(text_4_4);
                setOpenScreenShot(parent_4_4);
                break;
            case 8:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_4_4);
                setOpenScreenRecord(text_4_4);
                setOpenScreenRecord(parent_4_4);
                break;
            case 9:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.boost));
                setBoost(btn_4_4);
                setBoost(text_4_4);
                setBoost(parent_4_4);
                break;
            case 10:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_4_4);
                setOpenLockScreen(text_4_4);
                setOpenLockScreen(parent_4_4);
                break;
            case 11:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.power));
                setOpenPower(btn_4_4);
                setOpenPower(text_4_4);
                setOpenPower(parent_4_4);
                break;
            case 12:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_4_4);
                setOpenStatusBar(text_4_4);
                setOpenStatusBar(parent_4_4);
                break;
            case 13:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_4_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_4);
                text_4_4.setText(context.getText(R.string.recent));
                setOpenRecent(btn_4_4);
                setOpenRecent(text_4_4);
                setOpenRecent(parent_4_4);
                break;
        }
        
    }

    private void setInitMain_5_items_menu(){
        switch (getActionBtn1()){
            case 0:
                btn_1_5.setVisibility(View.INVISIBLE);
                text_1_5.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_1_5);
                setOpenHomeScreen(text_1_5);
                setOpenHomeScreen(parent_1_5);
                break;
            case 2:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_1_5);
                setOpenNotification(text_1_5);
                setOpenNotification(parent_1_5);
                break;
            case 3:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_1_5);
                setOpenControlPanel(text_1_5);
                setOpenControlPanel(parent_1_5);
                break;
            case 4:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_1_5);
                setOpenCustomMenu(text_1_5);
                setOpenCustomMenu(parent_1_5);
                break;
            case 5:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_1_5);
                setOpenGesture(text_1_5);
                setOpenGesture(parent_1_5);
                break;
            case 6:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_1_5);
                setOpenDeviceMenu(text_1_5);
                setOpenDeviceMenu(parent_1_5);
                break;
            case 7:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_1_5);
                setOpenScreenShot(text_1_5);
                setOpenScreenShot(parent_1_5);
                break;
            case 8:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_1_5);
                setOpenScreenRecord(text_1_5);
                setOpenScreenRecord(parent_1_5);
                break;
            case 9:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.boost));
                setBoost(btn_1_5);
                setBoost(text_1_5);
                setBoost(parent_1_5);
                break;
            case 10:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_1_5);
                setOpenLockScreen(text_1_5);
                setOpenLockScreen(parent_1_5);
                break;
            case 11:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.power));
                setOpenPower(btn_1_5);
                setOpenPower(text_1_5);
                setOpenPower(parent_1_5);
                break;
            case 12:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_1_5);
                setOpenStatusBar(text_1_5);
                setOpenStatusBar(parent_1_5);
                break;
            case 13:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_1_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_5);
                text_1_5.setText(context.getText(R.string.recent));
                setOpenRecent(btn_1_5);
                setOpenRecent(text_1_5);
                setOpenRecent(parent_1_5);
                break;
        }

        switch (getActionBtn2()){
            case 0:
                btn_2_5.setVisibility(View.INVISIBLE);
                text_2_5.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_2_5);
                setOpenHomeScreen(text_2_5);
                setOpenHomeScreen(parent_2_5);
                break;
            case 2:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_2_5);
                setOpenNotification(text_2_5);
                setOpenNotification(parent_2_5);
                break;
            case 3:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_2_5);
                setOpenControlPanel(text_2_5);
                setOpenControlPanel(parent_2_5);
                break;
            case 4:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_2_5);
                setOpenCustomMenu(text_2_5);
                setOpenCustomMenu(parent_2_5);
                break;
            case 5:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_2_5);
                setOpenGesture(text_2_5);
                setOpenGesture(parent_2_5);
                break;
            case 6:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_2_5);
                setOpenDeviceMenu(text_2_5);
                setOpenDeviceMenu(parent_2_5);
                break;
            case 7:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_2_5);
                setOpenScreenShot(text_2_5);
                setOpenScreenShot(parent_2_5);
                break;
            case 8:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_2_5);
                setOpenScreenRecord(text_2_5);
                setOpenScreenRecord(parent_2_5);
                break;
            case 9:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.boost));
                setBoost(btn_2_5);
                setBoost(text_2_5);
                setBoost(parent_2_5);
                break;
            case 10:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_2_5);
                setOpenLockScreen(text_2_5);
                setOpenLockScreen(parent_2_5);
                break;
            case 11:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.power));
                setOpenPower(btn_2_5);
                setOpenPower(text_2_5);
                setOpenPower(parent_2_5);
                break;
            case 12:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_2_5);
                setOpenStatusBar(text_2_5);
                setOpenStatusBar(parent_2_5);
                break;
            case 13:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_2_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_5);
                text_2_5.setText(context.getText(R.string.recent));
                setOpenRecent(btn_2_5);
                setOpenRecent(text_2_5);
                setOpenRecent(parent_2_5);
                break;
        }

        switch (getActionBtn3()){
            case 0:
                btn_3_5.setVisibility(View.INVISIBLE);
                text_3_5.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_3_5);
                setOpenHomeScreen(text_3_5);
                setOpenHomeScreen(parent_3_5);
                break;
            case 2:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_3_5);
                setOpenNotification(text_3_5);
                setOpenNotification(parent_3_5);
                break;
            case 3:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_3_5);
                setOpenControlPanel(text_3_5);
                setOpenControlPanel(parent_3_5);
                break;
            case 4:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_3_5);
                setOpenCustomMenu(text_3_5);
                setOpenCustomMenu(parent_3_5);
                break;
            case 5:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_3_5);
                setOpenGesture(text_3_5);
                setOpenGesture(parent_3_5);
                break;
            case 6:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_3_5);
                setOpenDeviceMenu(text_3_5);
                setOpenDeviceMenu(parent_3_5);
                break;
            case 7:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_3_5);
                setOpenScreenShot(text_3_5);
                setOpenScreenShot(parent_3_5);
                break;
            case 8:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_3_5);
                setOpenScreenRecord(text_3_5);
                setOpenScreenRecord(parent_3_5);
                break;
            case 9:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.boost));
                setBoost(btn_3_5);
                setBoost(text_3_5);
                setBoost(parent_3_5);
                break;
            case 10:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_3_5);
                setOpenLockScreen(text_3_5);
                setOpenLockScreen(parent_3_5);
                break;
            case 11:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.power));
                setOpenPower(btn_3_5);
                setOpenPower(text_3_5);
                setOpenPower(parent_3_5);
                break;
            case 12:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_3_5);
                setOpenStatusBar(text_3_5);
                setOpenStatusBar(parent_3_5);
                break;
            case 13:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_3_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_5);
                text_3_5.setText(context.getText(R.string.recent));
                setOpenRecent(btn_3_5);
                setOpenRecent(text_3_5);
                setOpenRecent(parent_3_5);
                break;
        }

        switch (getActionBtn4()){
            case 0:
                btn_4_5.setVisibility(View.INVISIBLE);
                text_4_5.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_4_5);
                setOpenHomeScreen(text_4_5);
                setOpenHomeScreen(parent_4_5);
                break;
            case 2:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_4_5);
                setOpenNotification(text_4_5);
                setOpenNotification(parent_4_5);
                break;
            case 3:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_4_5);
                setOpenControlPanel(text_4_5);
                setOpenControlPanel(parent_4_5);
                break;
            case 4:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_4_5);
                setOpenCustomMenu(text_4_5);
                setOpenCustomMenu(parent_4_5);
                break;
            case 5:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_4_5);
                setOpenGesture(text_4_5);
                setOpenGesture(parent_4_5);
                break;
            case 6:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_4_5);
                setOpenDeviceMenu(text_4_5);
                setOpenDeviceMenu(parent_4_5);
                break;
            case 7:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_4_5);
                setOpenScreenShot(text_4_5);
                setOpenScreenShot(parent_4_5);
                break;
            case 8:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_4_5);
                setOpenScreenRecord(text_4_5);
                setOpenScreenRecord(parent_4_5);
                break;
            case 9:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.boost));
                setBoost(btn_4_5);
                setBoost(text_4_5);
                setBoost(parent_4_5);
                break;
            case 10:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_4_5);
                setOpenLockScreen(text_4_5);
                setOpenLockScreen(parent_4_5);
                break;
            case 11:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.power));
                setOpenPower(btn_4_5);
                setOpenPower(text_4_5);
                setOpenPower(parent_4_5);
                break;
            case 12:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_4_5);
                setOpenStatusBar(text_4_5);
                setOpenStatusBar(parent_4_5);
                break;
            case 13:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_4_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_5);
                text_4_5.setText(context.getText(R.string.recent));
                setOpenRecent(btn_4_5);
                setOpenRecent(text_4_5);
                setOpenRecent(parent_4_5);
                break;
        }

        switch (getActionBtn5()){
            case 0:
                btn_5_5.setVisibility(View.INVISIBLE);
                text_5_5.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_5_5);
                setOpenHomeScreen(text_5_5);
                setOpenHomeScreen(parent_5_5);
                break;
            case 2:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_5_5);
                setOpenNotification(text_5_5);
                setOpenNotification(parent_5_5);
                break;
            case 3:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_5_5);
                setOpenControlPanel(text_5_5);
                setOpenControlPanel(parent_5_5);
                break;
            case 4:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_5_5);
                setOpenCustomMenu(text_5_5);
                setOpenCustomMenu(parent_5_5);
                break;
            case 5:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_5_5);
                setOpenGesture(text_5_5);
                setOpenGesture(parent_5_5);
                break;
            case 6:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_5_5);
                setOpenDeviceMenu(text_5_5);
                setOpenDeviceMenu(parent_5_5);
                break;
            case 7:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_5_5);
                setOpenScreenShot(text_5_5);
                setOpenScreenShot(parent_5_5);
                break;
            case 8:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_5_5);
                setOpenScreenRecord(text_5_5);
                setOpenScreenRecord(parent_5_5);
                break;
            case 9:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.boost));
                setBoost(btn_5_5);
                setBoost(text_5_5);
                setBoost(parent_5_5);
                break;
            case 10:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_5_5);
                setOpenLockScreen(text_5_5);
                setOpenLockScreen(parent_5_5);
                break;
            case 11:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.power));
                setOpenPower(btn_5_5);
                setOpenPower(text_5_5);
                setOpenPower(parent_5_5);
                break;
            case 12:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_5_5);
                setOpenStatusBar(text_5_5);
                setOpenStatusBar(parent_5_5);
                break;
            case 13:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_5_5.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_5);
                text_5_5.setText(context.getText(R.string.recent));
                setOpenRecent(btn_5_5);
                setOpenRecent(text_5_5);
                setOpenRecent(parent_5_5);
                break;
        }
        
    }

    private void setInitMain_6_items_menu(){
        switch (getActionBtn1()){
            case 0:
                btn_1.setVisibility(View.INVISIBLE);
                text_1.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_1);
                setOpenHomeScreen(text_1);
                setOpenHomeScreen(parent_1);
                break;
            case 2:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_1);
                setOpenNotification(text_1);
                setOpenNotification(parent_1);
                break;
            case 3:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_1);
                setOpenControlPanel(text_1);
                setOpenControlPanel(parent_1);
                break;
            case 4:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_1);
                setOpenCustomMenu(text_1);
                setOpenCustomMenu(parent_1);
                break;
            case 5:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_1);
                setOpenGesture(text_1);
                setOpenGesture(parent_1);
                break;
            case 6:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_1);
                setOpenDeviceMenu(text_1);
                setOpenDeviceMenu(parent_1);
                break;
            case 7:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_1);
                setOpenScreenShot(text_1);
                setOpenScreenShot(parent_1);
                break;
            case 8:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_1);
                setOpenScreenRecord(text_1);
                setOpenScreenRecord(parent_1);
                break;
            case 9:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.boost));
                setBoost(btn_1);
                setBoost(text_1);
                setBoost(parent_1);
                break;
            case 10:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_1);
                setOpenLockScreen(text_1);
                setOpenLockScreen(parent_1);
                break;
            case 11:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.power));
                setOpenPower(btn_1);
                setOpenPower(text_1);
                setOpenPower(parent_1);
                break;
            case 12:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_1);
                setOpenStatusBar(text_1);
                setOpenStatusBar(parent_1);
                break;
            case 13:
                btn_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_1.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1);
                text_1.setText(context.getText(R.string.recent));
                setOpenRecent(btn_1);
                setOpenRecent(text_1);
                setOpenRecent(parent_1);
                break;
        }
        
        switch (getActionBtn2()){
            case 0:
                btn_2.setVisibility(View.INVISIBLE);
                text_2.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_2);
                setOpenHomeScreen(text_2);
                setOpenHomeScreen(parent_2);
                break;
            case 2:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_2);
                setOpenNotification(text_2);
                setOpenNotification(parent_2);
                break;
            case 3:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_2);
                setOpenControlPanel(text_2);
                setOpenControlPanel(parent_2);
                break;
            case 4:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_2);
                setOpenCustomMenu(text_2);
                setOpenCustomMenu(parent_2);
                break;
            case 5:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_2);
                setOpenGesture(text_2);
                setOpenGesture(parent_2);
                break;
            case 6:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_2);
                setOpenDeviceMenu(text_2);
                setOpenDeviceMenu(parent_2);
                break;
            case 7:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_2);
                setOpenScreenShot(text_2);
                setOpenScreenShot(parent_2);
                break;
            case 8:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_2);
                setOpenScreenRecord(text_2);
                setOpenScreenRecord(parent_2);
                break;
            case 9:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.boost));
                setBoost(btn_2);
                setBoost(text_2);
                setBoost(parent_2);
                break;
            case 10:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_2);
                setOpenLockScreen(text_2);
                setOpenLockScreen(parent_2);
                break;
            case 11:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.power));
                setOpenPower(btn_2);
                setOpenPower(text_2);
                setOpenPower(parent_2);
                break;
            case 12:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_2);
                setOpenStatusBar(text_2);
                setOpenStatusBar(parent_2);
                break;
            case 13:
                btn_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2);
                text_2.setText(context.getText(R.string.recent));
                setOpenRecent(btn_2);
                setOpenRecent(text_2);
                setOpenRecent(parent_2);
                break;
        }
        
        switch (getActionBtn3()){
            case 0:
                btn_3.setVisibility(View.INVISIBLE);
                text_3.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_3);
                setOpenHomeScreen(text_3);
                setOpenHomeScreen(parent_3);
                break;
            case 2:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_3);
                setOpenNotification(text_3);
                setOpenNotification(parent_3);
                break;
            case 3:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_3);
                setOpenControlPanel(text_3);
                setOpenControlPanel(parent_3);
                break;
            case 4:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_3);
                setOpenCustomMenu(text_3);
                setOpenCustomMenu(parent_3);
                break;
            case 5:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_3);
                setOpenGesture(text_3);
                setOpenGesture(parent_3);
                break;
            case 6:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_3);
                setOpenDeviceMenu(text_3);
                setOpenDeviceMenu(parent_3);
                break;
            case 7:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_3);
                setOpenScreenShot(text_3);
                setOpenScreenShot(parent_3);
                break;
            case 8:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_3);
                setOpenScreenRecord(text_3);
                setOpenScreenRecord(parent_3);
                break;
            case 9:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.boost));
                setBoost(btn_3);
                setBoost(text_3);
                setBoost(parent_3);
                break;
            case 10:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_3);
                setOpenLockScreen(text_3);
                setOpenLockScreen(parent_3);
                break;
            case 11:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.power));
                setOpenPower(btn_3);
                setOpenPower(text_3);
                setOpenPower(parent_3);
                break;
            case 12:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_3);
                setOpenStatusBar(text_3);
                setOpenStatusBar(parent_3);
                break;
            case 13:
                btn_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3);
                text_3.setText(context.getText(R.string.recent));
                setOpenRecent(btn_3);
                setOpenRecent(text_3);
                setOpenRecent(parent_3);
                break;
        }
        
        switch (getActionBtn4()){
            case 0:
                btn_4.setVisibility(View.INVISIBLE);
                text_4.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_4);
                setOpenHomeScreen(text_4);
                setOpenHomeScreen(parent_4);
                break;
            case 2:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_4);
                setOpenNotification(text_4);
                setOpenNotification(parent_4);
                break;
            case 3:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_4);
                setOpenControlPanel(text_4);
                setOpenControlPanel(parent_4);
                break;
            case 4:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_4);
                setOpenCustomMenu(text_4);
                setOpenCustomMenu(parent_4);
                break;
            case 5:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_4);
                setOpenGesture(text_4);
                setOpenGesture(parent_4);
                break;
            case 6:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_4);
                setOpenDeviceMenu(text_4);
                setOpenDeviceMenu(parent_4);
                break;
            case 7:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_4);
                setOpenScreenShot(text_4);
                setOpenScreenShot(parent_4);
                break;
            case 8:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_4);
                setOpenScreenRecord(text_4);
                setOpenScreenRecord(parent_4);
                break;
            case 9:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.boost));
                setBoost(btn_4);
                setBoost(text_4);
                setBoost(parent_4);
                break;
            case 10:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_4);
                setOpenLockScreen(text_4);
                setOpenLockScreen(parent_4);
                break;
            case 11:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.power));
                setOpenPower(btn_4);
                setOpenPower(text_4);
                setOpenPower(parent_4);
                break;
            case 12:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_4);
                setOpenStatusBar(text_4);
                setOpenStatusBar(parent_4);
                break;
            case 13:
                btn_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4);
                text_4.setText(context.getText(R.string.recent));
                setOpenRecent(btn_4);
                setOpenRecent(text_4);
                setOpenRecent(parent_4);
                break;
        }
        
        switch (getActionBtn6()){
            case 0:
                btn_6.setVisibility(View.INVISIBLE);
                text_6.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_6);
                setOpenHomeScreen(text_6);
                setOpenHomeScreen(parent_6);
                break;
            case 2:
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_6);
                setOpenNotification(text_6);
                setOpenNotification(parent_6);
                break;
            case 3:
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_6);
                setOpenControlPanel(text_6);
                setOpenControlPanel(parent_6);
                break;
            case 4:
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_6);
                setOpenCustomMenu(text_6);
                setOpenCustomMenu(parent_6);
                break;
            case 5:
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_6);
                setOpenGesture(text_6);
                setOpenGesture(parent_6);
                break;
            case 6:
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_6);
                setOpenDeviceMenu(text_6);
                setOpenDeviceMenu(parent_6);
                break;
            case 7: 
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_6);
                setOpenScreenShot(text_6);
                setOpenScreenShot(parent_6);
                break;
            case 8:
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_6);
                setOpenScreenRecord(text_6);
                setOpenScreenRecord(parent_6);
                break;
            case 9:
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.boost));
                setBoost(btn_6);
                setBoost(text_6);
                setBoost(parent_6);
                break;
            case 10:
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_6);
                setOpenLockScreen(text_6);
                setOpenLockScreen(parent_6);
                break;
            case 11:
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.power));
                setOpenPower(btn_6);
                setOpenPower(text_6);
                setOpenPower(parent_6);
                break;
            case 12:
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_6);
                setOpenStatusBar(text_6);
                setOpenStatusBar(parent_6);
                break;
            case 13:
                btn_6.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_6.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6);
                text_6.setText(context.getText(R.string.recent));
                setOpenRecent(btn_6);
                setOpenRecent(text_6);
                setOpenRecent(parent_6);
                break;
        }
        
        switch (getActionBtn7()){
            case 0:
                btn_7.setVisibility(View.INVISIBLE);
                text_7.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_7);
                setOpenHomeScreen(text_7);
                setOpenHomeScreen(parent_7);
                break;
            case 2:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_7);
                setOpenNotification(text_7);
                setOpenNotification(parent_7);
                break;
            case 3:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_7);
                setOpenControlPanel(text_7);
                setOpenControlPanel(parent_7);
                break;
            case 4:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_7);
                setOpenCustomMenu(text_7);
                setOpenCustomMenu(parent_7);
                break;
            case 5:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_7);
                setOpenGesture(text_7);
                setOpenGesture(parent_7);
                break;
            case 6:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_7);
                setOpenDeviceMenu(text_7);
                setOpenDeviceMenu(parent_7);
                break;
            case 7:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_7);
                setOpenScreenShot(text_7);
                setOpenScreenShot(parent_7);
                break;
            case 8:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_7);
                setOpenScreenRecord(text_7);
                setOpenScreenRecord(parent_7);
                break;
            case 9:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.boost));
                setBoost(btn_7);
                setBoost(text_7);
                setBoost(parent_7);
                break;
            case 10:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_7);
                setOpenLockScreen(text_7);
                setOpenLockScreen(parent_7);
                break;
            case 11:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.power));
                setOpenPower(btn_7);
                setOpenPower(text_7);
                setOpenPower(parent_7);
                break;
            case 12:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_7);
                setOpenStatusBar(text_7);
                setOpenStatusBar(parent_7);
                break;
            case 13:
                btn_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7);
                text_7.setText(context.getText(R.string.recent));
                setOpenRecent(btn_7);
                setOpenRecent(text_7);
                setOpenRecent(parent_7);
                break;
        }
    }

    private void setInitMain_7_items_menu(){
        switch (getActionBtn1()){
            case 0:
                btn_1_7.setVisibility(View.INVISIBLE);
                text_1_7.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_1_7);
                setOpenHomeScreen(text_1_7);
                setOpenHomeScreen(parent_1_7);
                break;
            case 2:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_1_7);
                setOpenNotification(text_1_7);
                setOpenNotification(parent_1_7);
                break;
            case 3:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_1_7);
                setOpenControlPanel(text_1_7);
                setOpenControlPanel(parent_1_7);
                break;
            case 4:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_1_7);
                setOpenCustomMenu(text_1_7);
                setOpenCustomMenu(parent_1_7);
                break;
            case 5:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_1_7);
                setOpenGesture(text_1_7);
                setOpenGesture(parent_1_7);
                break;
            case 6:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_1_7);
                setOpenDeviceMenu(text_1_7);
                setOpenDeviceMenu(parent_1_7);
                break;
            case 7:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_1_7);
                setOpenScreenShot(text_1_7);
                setOpenScreenShot(parent_1_7);
                break;
            case 8:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_1_7);
                setOpenScreenRecord(text_1_7);
                setOpenScreenRecord(parent_1_7);
                break;
            case 9:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.boost));
                setBoost(btn_1_7);
                setBoost(text_1_7);
                setBoost(parent_1_7);
                break;
            case 10:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_1_7);
                setOpenLockScreen(text_1_7);
                setOpenLockScreen(parent_1_7);
                break;
            case 11:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.power));
                setOpenPower(btn_1_7);
                setOpenPower(text_1_7);
                setOpenPower(parent_1_7);
                break;
            case 12:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_1_7);
                setOpenStatusBar(text_1_7);
                setOpenStatusBar(parent_1_7);
                break;
            case 13:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_1_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_7);
                text_1_7.setText(context.getText(R.string.recent));
                setOpenRecent(btn_1_7);
                setOpenRecent(text_1_7);
                setOpenRecent(parent_1_7);
                break;
        }

        switch (getActionBtn2()){
            case 0:
                btn_2_7.setVisibility(View.INVISIBLE);
                text_2_7.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_2_7);
                setOpenHomeScreen(text_2_7);
                setOpenHomeScreen(parent_2_7);
                break;
            case 2:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_2_7);
                setOpenNotification(text_2_7);
                setOpenNotification(parent_2_7);
                break;
            case 3:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_2_7);
                setOpenControlPanel(text_2_7);
                setOpenControlPanel(parent_2_7);
                break;
            case 4:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_2_7);
                setOpenCustomMenu(text_2_7);
                setOpenCustomMenu(parent_2_7);
                break;
            case 5:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_2_7);
                setOpenGesture(text_2_7);
                setOpenGesture(parent_2_7);
                break;
            case 6:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_2_7);
                setOpenDeviceMenu(text_2_7);
                setOpenDeviceMenu(parent_2_7);
                break;
            case 7:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_2_7);
                setOpenScreenShot(text_2_7);
                setOpenScreenShot(parent_2_7);
                break;
            case 8:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_2_7);
                setOpenScreenRecord(text_2_7);
                setOpenScreenRecord(parent_2_7);
                break;
            case 9:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.boost));
                setBoost(btn_2_7);
                setBoost(text_2_7);
                setBoost(parent_2_7);
                break;
            case 10:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_2_7);
                setOpenLockScreen(text_2_7);
                setOpenLockScreen(parent_2_7);
                break;
            case 11:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.power));
                setOpenPower(btn_2_7);
                setOpenPower(text_2_7);
                setOpenPower(parent_2_7);
                break;
            case 12:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_2_7);
                setOpenStatusBar(text_2_7);
                setOpenStatusBar(parent_2_7);
                break;
            case 13:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_2_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_7);
                text_2_7.setText(context.getText(R.string.recent));
                setOpenRecent(btn_2_7);
                setOpenRecent(text_2_7);
                setOpenRecent(parent_2_7);
                break;
        }

        switch (getActionBtn3()){
            case 0:
                btn_3_7.setVisibility(View.INVISIBLE);
                text_3_7.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_3_7);
                setOpenHomeScreen(text_3_7);
                setOpenHomeScreen(parent_3_7);
                break;
            case 2:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_3_7);
                setOpenNotification(text_3_7);
                setOpenNotification(parent_3_7);
                break;
            case 3:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_3_7);
                setOpenControlPanel(text_3_7);
                setOpenControlPanel(parent_3_7);
                break;
            case 4:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_3_7);
                setOpenCustomMenu(text_3_7);
                setOpenCustomMenu(parent_3_7);
                break;
            case 5:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_3_7);
                setOpenGesture(text_3_7);
                setOpenGesture(parent_3_7);
                break;
            case 6:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_3_7);
                setOpenDeviceMenu(text_3_7);
                setOpenDeviceMenu(parent_3_7);
                break;
            case 7:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_3_7);
                setOpenScreenShot(text_3_7);
                setOpenScreenShot(parent_3_7);
                break;
            case 8:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_3_7);
                setOpenScreenRecord(text_3_7);
                setOpenScreenRecord(parent_3_7);
                break;
            case 9:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.boost));
                setBoost(btn_3_7);
                setBoost(text_3_7);
                setBoost(parent_3_7);
                break;
            case 10:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_3_7);
                setOpenLockScreen(text_3_7);
                setOpenLockScreen(parent_3_7);
                break;
            case 11:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.power));
                setOpenPower(btn_3_7);
                setOpenPower(text_3_7);
                setOpenPower(parent_3_7);
                break;
            case 12:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_3_7);
                setOpenStatusBar(text_3_7);
                setOpenStatusBar(parent_3_7);
                break;
            case 13:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_3_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_7);
                text_3_7.setText(context.getText(R.string.recent));
                setOpenRecent(btn_3_7);
                setOpenRecent(text_3_7);
                setOpenRecent(parent_3_7);
                break;
        }

        switch (getActionBtn4()){
            case 0:
                btn_4_7.setVisibility(View.INVISIBLE);
                text_4_7.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_4_7);
                setOpenHomeScreen(text_4_7);
                setOpenHomeScreen(parent_4_7);
                break;
            case 2:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_4_7);
                setOpenNotification(text_4_7);
                setOpenNotification(parent_4_7);
                break;
            case 3:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_4_7);
                setOpenControlPanel(text_4_7);
                setOpenControlPanel(parent_4_7);
                break;
            case 4:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_4_7);
                setOpenCustomMenu(text_4_7);
                setOpenCustomMenu(parent_4_7);
                break;
            case 5:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_4_7);
                setOpenGesture(text_4_7);
                setOpenGesture(parent_4_7);
                break;
            case 6:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_4_7);
                setOpenDeviceMenu(text_4_7);
                setOpenDeviceMenu(parent_4_7);
                break;
            case 7:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_4_7);
                setOpenScreenShot(text_4_7);
                setOpenScreenShot(parent_4_7);
                break;
            case 8:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_4_7);
                setOpenScreenRecord(text_4_7);
                setOpenScreenRecord(parent_4_7);
                break;
            case 9:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.boost));
                setBoost(btn_4_7);
                setBoost(text_4_7);
                setBoost(parent_4_7);
                break;
            case 10:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_4_7);
                setOpenLockScreen(text_4_7);
                setOpenLockScreen(parent_4_7);
                break;
            case 11:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.power));
                setOpenPower(btn_4_7);
                setOpenPower(text_4_7);
                setOpenPower(parent_4_7);
                break;
            case 12:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_4_7);
                setOpenStatusBar(text_4_7);
                setOpenStatusBar(parent_4_7);
                break;
            case 13:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_4_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_7);
                text_4_7.setText(context.getText(R.string.recent));
                setOpenRecent(btn_4_7);
                setOpenRecent(text_4_7);
                setOpenRecent(parent_4_7);
                break;
        }

        switch (getActionBtn5()){
            case 0:
                btn_5_7.setVisibility(View.INVISIBLE);
                text_5_7.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_5_7);
                setOpenHomeScreen(text_5_7);
                setOpenHomeScreen(parent_5_7);
                break;
            case 2:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_5_7);
                setOpenNotification(text_5_7);
                setOpenNotification(parent_5_7);
                break;
            case 3:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_5_7);
                setOpenControlPanel(text_5_7);
                setOpenControlPanel(parent_5_7);
                break;
            case 4:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_5_7);
                setOpenCustomMenu(text_5_7);
                setOpenCustomMenu(parent_5_7);
                break;
            case 5:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_5_7);
                setOpenGesture(text_5_7);
                setOpenGesture(parent_5_7);
                break;
            case 6:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_5_7);
                setOpenDeviceMenu(text_5_7);
                setOpenDeviceMenu(parent_5_7);
                break;
            case 7:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_5_7);
                setOpenScreenShot(text_5_7);
                setOpenScreenShot(parent_5_7);
                break;
            case 8:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_5_7);
                setOpenScreenRecord(text_5_7);
                setOpenScreenRecord(parent_5_7);
                break;
            case 9:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.boost));
                setBoost(btn_5_7);
                setBoost(text_5_7);
                setBoost(parent_5_7);
                break;
            case 10:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_5_7);
                setOpenLockScreen(text_5_7);
                setOpenLockScreen(parent_5_7);
                break;
            case 11:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.power));
                setOpenPower(btn_5_7);
                setOpenPower(text_5_7);
                setOpenPower(parent_5_7);
                break;
            case 12:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_5_7);
                setOpenStatusBar(text_5_7);
                setOpenStatusBar(parent_5_7);
                break;
            case 13:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_5_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_7);
                text_5_7.setText(context.getText(R.string.recent));
                setOpenRecent(btn_5_7);
                setOpenRecent(text_5_7);
                setOpenRecent(parent_5_7);
                break;
        }

        switch (getActionBtn6()){
            case 0:
                btn_6_7.setVisibility(View.INVISIBLE);
                text_6_7.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_6_7);
                setOpenHomeScreen(text_6_7);
                setOpenHomeScreen(parent_6_7);
                break;
            case 2:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_6_7);
                setOpenNotification(text_6_7);
                setOpenNotification(parent_6_7);
                break;
            case 3:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_6_7);
                setOpenControlPanel(text_6_7);
                setOpenControlPanel(parent_6_7);
                break;
            case 4:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_6_7);
                setOpenCustomMenu(text_6_7);
                setOpenCustomMenu(parent_6_7);
                break;
            case 5:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_6_7);
                setOpenGesture(text_6_7);
                setOpenGesture(parent_6_7);
                break;
            case 6:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_6_7);
                setOpenDeviceMenu(text_6_7);
                setOpenDeviceMenu(parent_6_7);
                break;
            case 7:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_6_7);
                setOpenScreenShot(text_6_7);
                setOpenScreenShot(parent_6_7);
                break;
            case 8:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_6_7);
                setOpenScreenRecord(text_6_7);
                setOpenScreenRecord(parent_6_7);
                break;
            case 9:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.boost));
                setBoost(btn_6_7);
                setBoost(text_6_7);
                setBoost(parent_6_7);
                break;
            case 10:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_6_7);
                setOpenLockScreen(text_6_7);
                setOpenLockScreen(parent_6_7);
                break;
            case 11:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.power));
                setOpenPower(btn_6_7);
                setOpenPower(text_6_7);
                setOpenPower(parent_6_7);
                break;
            case 12:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_6_7);
                setOpenStatusBar(text_6_7);
                setOpenStatusBar(parent_6_7);
                break;
            case 13:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_6_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_7);
                text_6_7.setText(context.getText(R.string.recent));
                setOpenRecent(btn_6_7);
                setOpenRecent(text_6_7);
                setOpenRecent(parent_6_7);
                break;
        }

        switch (getActionBtn7()){
            case 0:
                btn_7_7.setVisibility(View.INVISIBLE);
                text_7_7.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_7_7);
                setOpenHomeScreen(text_7_7);
                setOpenHomeScreen(parent_7_7);
                break;
            case 2:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_7_7);
                setOpenNotification(text_7_7);
                setOpenNotification(parent_7_7);
                break;
            case 3:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_7_7);
                setOpenControlPanel(text_7_7);
                setOpenControlPanel(parent_7_7);
                break;
            case 4:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_7_7);
                setOpenCustomMenu(text_7_7);
                setOpenCustomMenu(parent_7_7);
                break;
            case 5:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_7_7);
                setOpenGesture(text_7_7);
                setOpenGesture(parent_7_7);
                break;
            case 6:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_7_7);
                setOpenDeviceMenu(text_7_7);
                setOpenDeviceMenu(parent_7_7);
                break;
            case 7:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_7_7);
                setOpenScreenShot(text_7_7);
                setOpenScreenShot(parent_7_7);
                break;
            case 8:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_7_7);
                setOpenScreenRecord(text_7_7);
                setOpenScreenRecord(parent_7_7);
                break;
            case 9:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.boost));
                setBoost(btn_7_7);
                setBoost(text_7_7);
                setBoost(parent_7_7);
                break;
            case 10:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_7_7);
                setOpenLockScreen(text_7_7);
                setOpenLockScreen(parent_7_7);
                break;
            case 11:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.power));
                setOpenPower(btn_7_7);
                setOpenPower(text_7_7);
                setOpenPower(parent_7_7);
                break;
            case 12:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_7_7);
                setOpenStatusBar(text_7_7);
                setOpenStatusBar(parent_7_7);
                break;
            case 13:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_7_7.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_7);
                text_7_7.setText(context.getText(R.string.recent));
                setOpenRecent(btn_7_7);
                setOpenRecent(text_7_7);
                setOpenRecent(parent_7_7);
                break;
        }
    }

    private void setInitMain_8_items_menu(){
        switch (getActionBtn1()){
            case 0:
                btn_1_8.setVisibility(View.INVISIBLE);
                text_1_8.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_1_8);
                setOpenHomeScreen(text_1_8);
                setOpenHomeScreen(parent_1_8);
                break;
            case 2:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_1_8);
                setOpenNotification(text_1_8);
                setOpenNotification(parent_1_8);
                break;
            case 3:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_1_8);
                setOpenControlPanel(text_1_8);
                setOpenControlPanel(parent_1_8);
                break;
            case 4:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_1_8);
                setOpenCustomMenu(text_1_8);
                setOpenCustomMenu(parent_1_8);
                break;
            case 5:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_1_8);
                setOpenGesture(text_1_8);
                setOpenGesture(parent_1_8);
                break;
            case 6:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_1_8);
                setOpenDeviceMenu(text_1_8);
                setOpenDeviceMenu(parent_1_8);
                break;
            case 7:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_1_8);
                setOpenScreenShot(text_1_8);
                setOpenScreenShot(parent_1_8);
                break;
            case 8:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_1_8);
                setOpenScreenRecord(text_1_8);
                setOpenScreenRecord(parent_1_8);
                break;
            case 9:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.boost));
                setBoost(btn_1_8);
                setBoost(text_1_8);
                setBoost(parent_1_8);
                break;
            case 10:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_1_8);
                setOpenLockScreen(text_1_8);
                setOpenLockScreen(parent_1_8);
                break;
            case 11:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.power));
                setOpenPower(btn_1_8);
                setOpenPower(text_1_8);
                setOpenPower(parent_1_8);
                break;
            case 12:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_1_8);
                setOpenStatusBar(text_1_8);
                setOpenStatusBar(parent_1_8);
                break;
            case 13:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_1_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_1_8);
                text_1_8.setText(context.getText(R.string.recent));
                setOpenRecent(btn_1_8);
                setOpenRecent(text_1_8);
                setOpenRecent(parent_1_8);
                break;
        }

        switch (getActionBtn2()){
            case 0:
                btn_2_8.setVisibility(View.INVISIBLE);
                text_2_8.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_2_8);
                setOpenHomeScreen(text_2_8);
                setOpenHomeScreen(parent_2_8);
                break;
            case 2:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_2_8);
                setOpenNotification(text_2_8);
                setOpenNotification(parent_2_8);
                break;
            case 3:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_2_8);
                setOpenControlPanel(text_2_8);
                setOpenControlPanel(parent_2_8);
                break;
            case 4:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_2_8);
                setOpenCustomMenu(text_2_8);
                setOpenCustomMenu(parent_2_8);
                break;
            case 5:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_2_8);
                setOpenGesture(text_2_8);
                setOpenGesture(parent_2_8);
                break;
            case 6:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_2_8);
                setOpenDeviceMenu(text_2_8);
                setOpenDeviceMenu(parent_2_8);
                break;
            case 7:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_2_8);
                setOpenScreenShot(text_2_8);
                setOpenScreenShot(parent_2_8);
                break;
            case 8:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_2_8);
                setOpenScreenRecord(text_2_8);
                setOpenScreenRecord(parent_2_8);
                break;
            case 9:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.boost));
                setBoost(btn_2_8);
                setBoost(text_2_8);
                setBoost(parent_2_8);
                break;
            case 10:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_2_8);
                setOpenLockScreen(text_2_8);
                setOpenLockScreen(parent_2_8);
                break;
            case 11:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.power));
                setOpenPower(btn_2_8);
                setOpenPower(text_2_8);
                setOpenPower(parent_2_8);
                break;
            case 12:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_2_8);
                setOpenStatusBar(text_2_8);
                setOpenStatusBar(parent_2_8);
                break;
            case 13:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_2_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_2_8);
                text_2_8.setText(context.getText(R.string.recent));
                setOpenRecent(btn_2_8);
                setOpenRecent(text_2_8);
                setOpenRecent(parent_2_8);
                break;
        }

        switch (getActionBtn3()){
            case 0:
                btn_3_8.setVisibility(View.INVISIBLE);
                text_3_8.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_3_8);
                setOpenHomeScreen(text_3_8);
                setOpenHomeScreen(parent_3_8);
                break;
            case 2:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_3_8);
                setOpenNotification(text_3_8);
                setOpenNotification(parent_3_8);
                break;
            case 3:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_3_8);
                setOpenControlPanel(text_3_8);
                setOpenControlPanel(parent_3_8);
                break;
            case 4:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_3_8);
                setOpenCustomMenu(text_3_8);
                setOpenCustomMenu(parent_3_8);
                break;
            case 5:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_3_8);
                setOpenGesture(text_3_8);
                setOpenGesture(parent_3_8);
                break;
            case 6:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_3_8);
                setOpenDeviceMenu(text_3_8);
                setOpenDeviceMenu(parent_3_8);
                break;
            case 7:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_3_8);
                setOpenScreenShot(text_3_8);
                setOpenScreenShot(parent_3_8);
                break;
            case 8:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_3_8);
                setOpenScreenRecord(text_3_8);
                setOpenScreenRecord(parent_3_8);
                break;
            case 9:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.boost));
                setBoost(btn_3_8);
                setBoost(text_3_8);
                setBoost(parent_3_8);
                break;
            case 10:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_3_8);
                setOpenLockScreen(text_3_8);
                setOpenLockScreen(parent_3_8);
                break;
            case 11:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.power));
                setOpenPower(btn_3_8);
                setOpenPower(text_3_8);
                setOpenPower(parent_3_8);
                break;
            case 12:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_3_8);
                setOpenStatusBar(text_3_8);
                setOpenStatusBar(parent_3_8);
                break;
            case 13:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_3_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_3_8);
                text_3_8.setText(context.getText(R.string.recent));
                setOpenRecent(btn_3_8);
                setOpenRecent(text_3_8);
                setOpenRecent(parent_3_8);
                break;
        }

        switch (getActionBtn4()){
            case 0:
                btn_4_8.setVisibility(View.INVISIBLE);
                text_4_8.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_4_8);
                setOpenHomeScreen(text_4_8);
                setOpenHomeScreen(parent_4_8);
                break;
            case 2:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_4_8);
                setOpenNotification(text_4_8);
                setOpenNotification(parent_4_8);
                break;
            case 3:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_4_8);
                setOpenControlPanel(text_4_8);
                setOpenControlPanel(parent_4_8);
                break;
            case 4:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_4_8);
                setOpenCustomMenu(text_4_8);
                setOpenCustomMenu(parent_4_8);
                break;
            case 5:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_4_8);
                setOpenGesture(text_4_8);
                setOpenGesture(parent_4_8);
                break;
            case 6:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_4_8);
                setOpenDeviceMenu(text_4_8);
                setOpenDeviceMenu(parent_4_8);
                break;
             case 7:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_4_8);
                setOpenScreenShot(text_4_8);
                setOpenScreenShot(parent_4_8);
                break;
            case 8:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_4_8);
                setOpenScreenRecord(text_4_8);
                setOpenScreenRecord(parent_4_8);
                break;
            case 9:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.boost));
                setBoost(btn_4_8);
                setBoost(text_4_8);
                setBoost(parent_4_8);
                break;
            case 10:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_4_8);
                setOpenLockScreen(text_4_8);
                setOpenLockScreen(parent_4_8);
                break;
            case 11:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.power));
                setOpenPower(btn_4_8);
                setOpenPower(text_4_8);
                setOpenPower(parent_4_8);
                break;
            case 12:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_4_8);
                setOpenStatusBar(text_4_8);
                setOpenStatusBar(parent_4_8);
                break;
            case 13:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_4_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_4_8);
                text_4_8.setText(context.getText(R.string.recent));
                setOpenRecent(btn_4_8);
                setOpenRecent(text_4_8);
                setOpenRecent(parent_4_8);
                break;
        }

        switch (getActionBtn5()){
            case 0:
                btn_5_8.setVisibility(View.INVISIBLE);
                text_5_8.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_5_8);
                setOpenHomeScreen(text_5_8);
                setOpenHomeScreen(parent_5_8);
                break;
            case 2:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_5_8);
                setOpenNotification(text_5_8);
                setOpenNotification(parent_5_8);
                break;
            case 3:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_5_8);
                setOpenControlPanel(text_5_8);
                setOpenControlPanel(parent_5_8);
                break;
            case 4:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_5_8);
                setOpenCustomMenu(text_5_8);
                setOpenCustomMenu(parent_5_8);
                break;
            case 5:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_5_8);
                setOpenGesture(text_5_8);
                setOpenGesture(parent_5_8);
                break;
            case 6:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_5_8);
                setOpenDeviceMenu(text_5_8);
                setOpenDeviceMenu(parent_5_8);
                break;
            case 7:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_5_8);
                setOpenScreenShot(text_5_8);
                setOpenScreenShot(parent_5_8);
                break;
            case 8:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_5_8);
                setOpenScreenRecord(text_5_8);
                setOpenScreenRecord(parent_5_8);
                break;
            case 9:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.boost));
                setBoost(btn_5_8);
                setBoost(text_5_8);
                setBoost(parent_5_8);
                break;
            case 10:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_5_8);
                setOpenLockScreen(text_5_8);
                setOpenLockScreen(parent_5_8);
                break;
            case 11:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.power));
                setOpenPower(btn_5_8);
                setOpenPower(text_5_8);
                setOpenPower(parent_5_8);
                break;
            case 12:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_5_8);
                setOpenStatusBar(text_5_8);
                setOpenStatusBar(parent_5_8);
                break;
            case 13:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_5_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_5_8);
                text_5_8.setText(context.getText(R.string.recent));
                setOpenRecent(btn_5_8);
                setOpenRecent(text_5_8);
                setOpenRecent(parent_5_8);
                break;
        }

        switch (getActionBtn6()){
            case 0:
                btn_6_8.setVisibility(View.INVISIBLE);
                text_6_8.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_6_8);
                setOpenHomeScreen(text_6_8);
                setOpenHomeScreen(parent_6_8);
                break;
            case 2:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_6_8);
                setOpenNotification(text_6_8);
                setOpenNotification(parent_6_8);
                break;
            case 3:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_6_8);
                setOpenControlPanel(text_6_8);
                setOpenControlPanel(parent_6_8);
                break;
            case 4:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_6_8);
                setOpenCustomMenu(text_6_8);
                setOpenCustomMenu(parent_6_8);
                break;
            case 5:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_6_8);
                setOpenGesture(text_6_8);
                setOpenGesture(parent_6_8);
                break;
            case 6:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_6_8);
                setOpenDeviceMenu(text_6_8);
                setOpenDeviceMenu(parent_6_8);
                break;
            case 7:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_6_8);
                setOpenScreenShot(text_6_8);
                setOpenScreenShot(parent_6_8);
                break;
            case 8:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_6_8);
                setOpenScreenRecord(text_6_8);
                setOpenScreenRecord(parent_6_8);
                break;
            case 9:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.boost));
                setBoost(btn_6_8);
                setBoost(text_6_8);
                setBoost(parent_6_8);
                break;
            case 10:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_6_8);
                setOpenLockScreen(text_6_8);
                setOpenLockScreen(parent_6_8);
                break;
            case 11:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.power));
                setOpenPower(btn_6_8);
                setOpenPower(text_6_8);
                setOpenPower(parent_6_8);
                break;
            case 12:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_6_8);
                setOpenStatusBar(text_6_8);
                setOpenStatusBar(parent_6_8);
                break;
            case 13:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_6_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_6_8);
                text_6_8.setText(context.getText(R.string.recent));
                setOpenRecent(btn_6_8);
                setOpenRecent(text_6_8);
                setOpenRecent(parent_6_8);
                break;
        }

        switch (getActionBtn7()){
            case 0:
                btn_7_8.setVisibility(View.INVISIBLE);
                text_7_8.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_7_8);
                setOpenHomeScreen(text_7_8);
                setOpenHomeScreen(parent_7_8);
                break;
            case 2:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_7_8);
                setOpenNotification(text_7_8);
                setOpenNotification(parent_7_8);
                break;
            case 3:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_7_8);
                setOpenControlPanel(text_7_8);
                setOpenControlPanel(parent_7_8);
                break;
            case 4:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_7_8);
                setOpenCustomMenu(text_7_8);
                setOpenCustomMenu(parent_7_8);
                break;
            case 5:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_7_8);
                setOpenGesture(text_7_8);
                setOpenGesture(parent_7_8);
                break;
            case 6:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_7_8);
                setOpenDeviceMenu(text_7_8);
                setOpenDeviceMenu(parent_7_8);
                break;
            case 7:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_7_8);
                setOpenScreenShot(text_7_8);
                setOpenScreenShot(parent_7_8);
                break;
            case 8:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_7_8);
                setOpenScreenRecord(text_7_8);
                setOpenScreenRecord(parent_7_8);
                break;
            case 9:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.boost));
                setBoost(btn_7_8);
                setBoost(text_7_8);
                setBoost(parent_7_8);
                break;
            case 10:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_7_8);
                setOpenLockScreen(text_7_8);
                setOpenLockScreen(parent_7_8);
                break;
            case 11:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.power));
                setOpenPower(btn_7_8);
                setOpenPower(text_7_8);
                setOpenPower(parent_7_8);
                break;
            case 12:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_7_8);
                setOpenStatusBar(text_7_8);
                setOpenStatusBar(parent_7_8);
                break;
            case 13:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_7_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_7_8);
                text_7_8.setText(context.getText(R.string.recent));
                setOpenRecent(btn_7_8);
                setOpenRecent(text_7_8);
                setOpenRecent(parent_7_8);
                break;
        }

        switch (getActionBtn8()){
            case 0:
                btn_8_8.setVisibility(View.INVISIBLE);
                text_8_8.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.home_img));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.Home));
                setOpenHomeScreen(btn_8_8);
                setOpenHomeScreen(text_8_8);
                setOpenHomeScreen(parent_8_8);
                break;
            case 2:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.notification_icon1));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.Notifications));
                setOpenNotification(btn_8_8);
                setOpenNotification(text_8_8);
                setOpenNotification(parent_8_8);
                break;
            case 3:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.Control_Center));
                setOpenControlPanel(btn_8_8);
                setOpenControlPanel(text_8_8);
                setOpenControlPanel(parent_8_8);
                break;
            case 4:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.favorite_2));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.Custom));
                setOpenCustomMenu(btn_8_8);
                setOpenCustomMenu(text_8_8);
                setOpenCustomMenu(parent_8_8);
                break;
            case 5:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.gesture));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.Gesture));
                setOpenGesture(btn_8_8);
                setOpenGesture(text_8_8);
                setOpenGesture(parent_8_8);
                break;
            case 6:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.device));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.Device));
                setOpenDeviceMenu(btn_8_8);
                setOpenDeviceMenu(text_8_8);
                setOpenDeviceMenu(parent_8_8);
                break;
            case 7:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.screen_shot));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.screenshot));
                setOpenScreenShot(btn_8_8);
                setOpenScreenShot(text_8_8);
                setOpenScreenShot(parent_8_8);
                break;
            case 8:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.record1));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.screen_nrecording));
                setOpenScreenRecord(btn_8_8);
                setOpenScreenRecord(text_8_8);
                setOpenScreenRecord(parent_8_8);
                break;
            case 9:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_boost_large_1));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.boost));
                setBoost(btn_8_8);
                setBoost(text_8_8);
                setBoost(parent_8_8);
                break;
            case 10:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_lock_24));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.lock_nscreen));
                setOpenLockScreen(btn_8_8);
                setOpenLockScreen(text_8_8);
                setOpenLockScreen(parent_8_8);
                break;
            case 11:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_power_settings_new_24));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.power));
                setOpenPower(btn_8_8);
                setOpenPower(text_8_8);
                setOpenPower(parent_8_8);
                break;
            case 12:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.control_center));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.open_nstatusbar));
                setOpenStatusBar(btn_8_8);
                setOpenStatusBar(text_8_8);
                setOpenStatusBar(parent_8_8);
                break;
            case 13:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_recent_white));
                btn_8_8.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                setScaleDefault(btn_8_8);
                text_8_8.setText(context.getText(R.string.recent));
                setOpenRecent(btn_8_8);
                setOpenRecent(text_8_8);
                setOpenRecent(parent_8_8);
                break;
        }
    }

    private void setExpandCustomMenu(){
        setCloseCustomMenu(btn_5_custom);

        if (!getAppPref1().equals("empty")){
            btn_1_custom.setImageDrawable(getDrawableFromPackageName(getAppPref1()));
            btn_1_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
            text_1_custom.setText(getAppLabelFromPackageName(getAppPref1()));
        }

        if (!getAppPref2().equals("empty")){
            btn_2_custom.setImageDrawable(getDrawableFromPackageName(getAppPref2()));
            btn_2_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
            text_2_custom.setText(getAppLabelFromPackageName(getAppPref2()));
        }

        if (!getAppPref3().equals("empty")){
            btn_3_custom.setImageDrawable(getDrawableFromPackageName(getAppPref3()));
            btn_3_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
            text_3_custom.setText(getAppLabelFromPackageName(getAppPref3()));
        }

        if (!getAppPref4().equals("empty")){
            btn_4_custom.setImageDrawable(getDrawableFromPackageName(getAppPref4()));
            btn_4_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
            text_4_custom.setText(getAppLabelFromPackageName(getAppPref4()));
        }

        if (!getAppPref6().equals("empty")){
            btn_6_custom.setImageDrawable(getDrawableFromPackageName(getAppPref6()));
            btn_6_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
            text_6_custom.setText(getAppLabelFromPackageName(getAppPref6()));
        }

        if (!getAppPref7().equals("empty")){
            btn_7_custom.setImageDrawable(getDrawableFromPackageName(getAppPref7()));
            btn_7_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
            text_7_custom.setText(getAppLabelFromPackageName(getAppPref7()));
        }

        if (!getAppPref8().equals("empty")){
            btn_8_custom.setImageDrawable(getDrawableFromPackageName(getAppPref8()));
            btn_8_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
            text_8_custom.setText(getAppLabelFromPackageName(getAppPref8()));
        }

        if (!getAppPref9().equals("empty")){
            btn_9_custom.setImageDrawable(getDrawableFromPackageName(getAppPref9()));
            btn_9_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
            text_9_custom.setText(getAppLabelFromPackageName(getAppPref9()));
        }

        btn_1_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref1().equals("empty")){
                    setCustomAlertDialog(1);
                }else {
                    setLaunchAppFromPackageName(getAppPref1());
                    setExpandToCollapsed();
                }
            }
        });

        btn_2_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref2().equals("empty")){
                    setCustomAlertDialog(2);
                }else {
                    setLaunchAppFromPackageName(getAppPref2());
                    setExpandToCollapsed();
                }
            }
        });

        btn_3_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref3().equals("empty")){
                    setCustomAlertDialog(3);
                }else {
                    setLaunchAppFromPackageName(getAppPref3());
                    setExpandToCollapsed();
                }
            }
        });

        btn_4_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref4().equals("empty")){
                    setCustomAlertDialog(4);
                }else {
                    setLaunchAppFromPackageName(getAppPref4());
                    setExpandToCollapsed();
                }
            }
        });

        btn_6_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref6().equals("empty")){
                    setCustomAlertDialog(6);
                }else {
                    setLaunchAppFromPackageName(getAppPref6());
                    setExpandToCollapsed();
                }
            }
        });

        btn_7_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref7().equals("empty")){
                    setCustomAlertDialog(7);
                }else {
                    setLaunchAppFromPackageName(getAppPref7());
                    setExpandToCollapsed();
                }
            }
        });

        btn_8_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref8().equals("empty")){
                    setCustomAlertDialog(8);
                }else {
                    setLaunchAppFromPackageName(getAppPref8());
                    setExpandToCollapsed();
                }
            }
        });

        btn_9_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref9().equals("empty")){
                    setCustomAlertDialog(9);
                }else {
                    setLaunchAppFromPackageName(getAppPref9());
                    setExpandToCollapsed();
                }
            }
        });

        parent_1_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref1().equals("empty")){
                    setCustomAlertDialog(1);
                }else {
                    setLaunchAppFromPackageName(getAppPref1());
                    setExpandToCollapsed();
                }
            }
        });

        parent_2_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref2().equals("empty")){
                    setCustomAlertDialog(2);
                }else {
                    setLaunchAppFromPackageName(getAppPref2());
                    setExpandToCollapsed();
                }
            }
        });

        parent_3_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref3().equals("empty")){
                    setCustomAlertDialog(3);
                }else {
                    setLaunchAppFromPackageName(getAppPref3());
                    setExpandToCollapsed();
                }
            }
        });

        parent_4_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref4().equals("empty")){
                    setCustomAlertDialog(4);
                }else {
                    setLaunchAppFromPackageName(getAppPref4());
                    setExpandToCollapsed();
                }
            }
        });

        parent_6_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref6().equals("empty")){
                    setCustomAlertDialog(6);
                }else {
                    setLaunchAppFromPackageName(getAppPref6());
                    setExpandToCollapsed();
                }
            }
        });

        parent_7_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref7().equals("empty")){
                    setCustomAlertDialog(7);
                }else {
                    setLaunchAppFromPackageName(getAppPref7());
                    setExpandToCollapsed();
                }
            }
        });

        parent_8_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref8().equals("empty")){
                    setCustomAlertDialog(8);
                }else {
                    setLaunchAppFromPackageName(getAppPref8());
                    setExpandToCollapsed();
                }
            }
        });

        parent_9_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAppPref9().equals("empty")){
                    setCustomAlertDialog(9);
                }else {
                    setLaunchAppFromPackageName(getAppPref9());
                    setExpandToCollapsed();
                }
            }
        });

        btn_1_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref1().equals("empty")){
                    preferenceController.setAppPref1("empty");
                    btn_1_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_1_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_1_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        btn_2_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref2().equals("empty")){
                    preferenceController.setAppPref2("empty");
                    btn_2_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_2_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_2_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        btn_3_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref3().equals("empty")){
                    preferenceController.setAppPref3("empty");
                    btn_3_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_3_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_3_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        btn_4_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref4().equals("empty")){
                    preferenceController.setAppPref4("empty");
                    btn_4_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_4_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_4_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        btn_6_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref6().equals("empty")){
                    preferenceController.setAppPref6("empty");
                    btn_6_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_6_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_6_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        btn_7_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref7().equals("empty")){
                    preferenceController.setAppPref7("empty");
                    btn_7_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_7_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_7_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        btn_8_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref8().equals("empty")){
                    preferenceController.setAppPref8("empty");
                    btn_8_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_8_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_8_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        btn_9_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref9().equals("empty")){
                    preferenceController.setAppPref9("empty");
                    btn_9_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_9_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_9_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        parent_1_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref1().equals("empty")){
                    preferenceController.setAppPref1("empty");
                    btn_1_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_1_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_1_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        parent_2_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref2().equals("empty")){
                    preferenceController.setAppPref2("empty");
                    btn_2_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_2_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_2_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        parent_3_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref3().equals("empty")){
                    preferenceController.setAppPref3("empty");
                    btn_3_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_3_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_3_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        parent_4_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref4().equals("empty")){
                    preferenceController.setAppPref4("empty");
                    btn_4_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_4_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_4_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        parent_6_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref6().equals("empty")){
                    preferenceController.setAppPref6("empty");
                    btn_6_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_6_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_6_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        parent_7_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref7().equals("empty")){
                    preferenceController.setAppPref7("empty");
                    btn_7_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_7_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_7_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        parent_8_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref8().equals("empty")){
                    preferenceController.setAppPref8("empty");
                    btn_8_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_8_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_8_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        parent_9_custom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!getAppPref9().equals("empty")){
                    preferenceController.setAppPref9("empty");
                    btn_9_custom.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_add_24));
                    btn_9_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg));
                    text_9_custom.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

    }

    private void setExpandDeviceMenu(){
        setCloseDeviceMenu(btn_4_device);

        //LockScreen
        btn_1_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.lockScreen();
                setExpandToCollapsed();
            }
        });
        text_1_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.lockScreen();
                setExpandToCollapsed();
            }
        });

        parent_1_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.lockScreen();
                setExpandToCollapsed();
            }
        });

        //Power
        btn_2_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.openPowerAction();
            }
        });

        text_2_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.openPowerAction();
            }
        });

        parent_2_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.openPowerAction();
            }
        });

        //Volume Up
        btn_3_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setVolumeUp();
            }
        });

        text_3_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setVolumeUp();
            }
        });

        parent_3_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setVolumeUp();
            }
        });

        //Volume Down
        btn_6_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setVolumeDown();
            }
        });

        text_6_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setVolumeDown();
            }
        });

        parent_6_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setVolumeDown();
            }
        });

        //Rotation
        if (taskController.isAutoRotateModeOn(context)){
            text_5_device.setText(context.getString(R.string.unlock_nrotation));
        }else {
            text_5_device.setText(context.getString(R.string.lock_nrotation));
        }
        btn_5_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str3 = "accelerometer_rotation";
                if (taskController.isAutoRotateModeOn(MainService.this)) {
                    Settings.System.putInt(MainService.this.getContentResolver(), str3, 0);
                } else {
                    Settings.System.putInt(MainService.this.getContentResolver(), str3, 1);
                }
            }
        });
        text_5_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str3 = "accelerometer_rotation";
                if (taskController.isAutoRotateModeOn(MainService.this)) {
                    Settings.System.putInt(MainService.this.getContentResolver(), str3, 0);
                } else {
                    Settings.System.putInt(MainService.this.getContentResolver(), str3, 1);
                }
            }
        });
        parent_5_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str3 = "accelerometer_rotation";
                if (taskController.isAutoRotateModeOn(MainService.this)) {
                    Settings.System.putInt(MainService.this.getContentResolver(), str3, 0);
                } else {
                    Settings.System.putInt(MainService.this.getContentResolver(), str3, 1);
                }
            }
        });
        getContentResolver().registerContentObserver(Settings.System.getUriFor
                        (Settings.System.ACCELEROMETER_ROTATION),
                true,rotationObserver );

        //More
        btn_7_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOpenDeviceSubMenu();
            }
        });
        text_7_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOpenDeviceSubMenu();
            }
        });
        parent_7_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOpenDeviceSubMenu();
            }
        });
    }

    private void setExpand_device_sub_menu(){
        //Screenshot
        btn_1_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpandToCollapsed();
                assitiveTouch.setVisibility(View.INVISIBLE);
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        taskController.setScreenShot();
                    }
                };
                Handler handler = new Handler();
                Handler handler1 = new Handler();
                handler1.postDelayed(runnable,1000);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        assitiveTouch.setVisibility(VISIBLE);
                    }
                },3000);
            }
        });
        text_1_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpandToCollapsed();
                assitiveTouch.setVisibility(View.INVISIBLE);
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        taskController.setScreenShot();
                    }
                };
                Handler handler = new Handler();
                Handler handler1 = new Handler();
                handler1.postDelayed(runnable,1000);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        assitiveTouch.setVisibility(VISIBLE);
                    }
                },3000);
            }
        });
        parent_1_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpandToCollapsed();
                assitiveTouch.setVisibility(View.INVISIBLE);
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        taskController.setScreenShot();
                    }
                };
                Handler handler = new Handler();
                Handler handler1 = new Handler();
                handler1.postDelayed(runnable,1000);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        assitiveTouch.setVisibility(VISIBLE);
                    }
                },3000);
            }
        });

        //Open StatusBar
        btn_2_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.OpenStatusBar();
                setExpandToCollapsed();
            }
        });
        text_2_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.OpenStatusBar();
                setExpandToCollapsed();
            }
        });
        parent_2_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.OpenStatusBar();
                setExpandToCollapsed();
            }
        });

        //Record
        btn_3_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setStartRecord();
                setExpandToCollapsed();
            }
        });

        text_3_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setStartRecord();
                setExpandToCollapsed();
            }
        });
        parent_3_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setStartRecord();
                setExpandToCollapsed();
            }
        });

        //Return to Device Icon Menu
        btn_4_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCloseDeviceSubMenu();
            }
        });

        //Open Recent
        btn_5_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.openRecentAction();
                setExpandToCollapsed();
            }
        });

        text_5_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.openRecentAction();
                setExpandToCollapsed();
            }
        });

        parent_5_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.openRecentAction();
                setExpandToCollapsed();
            }
        });

        //Location
        btn_6_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.openLocation();
                setExpandToCollapsed();
            }
        });

        text_6_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.openLocation();
                setExpandToCollapsed();
            }
        });

        parent_6_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.openLocation();
                setExpandToCollapsed();
            }
        });

        //Boost
        btn_7_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.progressBooster();
                setExpandToCollapsed();
            }
        });
        text_7_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.progressBooster();
                setExpandToCollapsed();
            }
        });
        parent7_device_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.progressBooster();
                setExpandToCollapsed();
            }
        });
    }

    private void setControlCenter(){
        //Air Plane Mode
        btn_airPlaneMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setOpenAirPlaneMode();
                setExpandToCollapsed();
            }
        });

        //Wifi
        btn_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.startWifiIntent();
            }
        });

        //BlueTooth
        final BluetoothAdapter bluetoothAdapter =BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter.isEnabled()){
            btn_bluetooth.setBackground(ContextCompat.getDrawable(MainService.this,R.drawable.icon_circle_enable_bg));
        }else {
            btn_bluetooth.setBackground(ContextCompat.getDrawable(MainService.this,R.drawable.control_center_circle_bg));
        }
        btn_bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bluetoothAdapter.isEnabled()){
                    bluetoothAdapter.disable();
                }else {
                    bluetoothAdapter.enable();
                }
            }
        });

        //Mobile Data
        btn_mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskController.goToMobileData();
                setExpandToCollapsed();
            }
        });


        //Rotation
        if (taskController.isAutoRotateModeOn(context)){
            rotate_control_center.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg_2));
            rotate_control_center.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.orientation_default_white));
        }else {
            rotate_control_center.setBackground(ContextCompat.getDrawable(context,R.drawable.active_rotation_control_center_bg));
            rotate_control_center.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.orientation_active));
        }
        rotate_control_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str3 = "accelerometer_rotation";
                if (taskController.isAutoRotateModeOn(MainService.this)) {
                    Settings.System.putInt(MainService.this.getContentResolver(), str3, 0);
                } else {
                    Settings.System.putInt(MainService.this.getContentResolver(), str3, 1);
                }
            }
        });

        //Do not disturb
        if (taskController.isDoNotDisturb()){
            btn_doNotDisturb.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_remove_circle_outline_24_white));
            btn_doNotDisturb.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg_2));
        }else {
            btn_doNotDisturb.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_remove_circle_outline_24_red));
            btn_doNotDisturb.setBackground(ContextCompat.getDrawable(context,R.drawable.active_rotation_control_center_bg));
        }

        btn_doNotDisturb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (taskController.isDoNotDisturb()){
                    btn_doNotDisturb.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_remove_circle_outline_24_red));
                    btn_doNotDisturb.setBackground(ContextCompat.getDrawable(context,R.drawable.active_rotation_control_center_bg));
                }else {
                    btn_doNotDisturb.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_remove_circle_outline_24_white));
                    btn_doNotDisturb.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg_2));
                }
                taskController.setDoNotDisturb();
            }
        });

        //Screen Recording
        screen_recording_control_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setStartRecord();
                setExpandToCollapsed();
            }
        });

        //Brightness
        int brightness_default = 200;
        if(Settings.System.canWrite(this)){
            Settings.System.putInt(
                    cResolver,
                    Settings.System.SCREEN_BRIGHTNESS_MODE,
                    Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
            try {
                brightness_default = Settings.System.getInt(cResolver, Settings.System.SCREEN_BRIGHTNESS);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        }
        brightness_seekBar.setValue(brightness_default);
        brightness_seekBar.setOnBoxedPointsChangeListener(new BoxedVertical.OnValuesChangeListener() {
            @Override
            public void onPointsChanged(BoxedVertical boxedPoints, int points) {
                setBrightness(points);
            }

            @Override
            public void onStartTrackingTouch(BoxedVertical boxedPoints) {

            }

            @Override
            public void onStopTrackingTouch(BoxedVertical boxedPoints) {

            }
        });

        //Volume
        taskController.setVolumeToSeekBar(volume_seekBar);

        //Custom
        switch (preferenceController.getControlCenterPref1()){
            default:
            case "0":
                control_center_custom_1.setVisibility(View.INVISIBLE);
                break;
            case "1":
                control_center_custom_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_flash_on_white));
                control_center_custom_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (preferenceController.getFlashLightState()){
                            default:
                            case 0:
                                preferenceController.setFlashLightState(1);
                                break;
                            case 1:
                                preferenceController.setFlashLightState(0);
                                break;
                        }
                        taskController.setFlashLight();
                    }
                });
                break;
            case "2":
                control_center_custom_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_sensor_window_24));
                control_center_custom_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.splitWindow();
                        setExpandToCollapsed();
                    }
                });
                break;
            case "3":
                control_center_custom_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_ring_volume_24));
                control_center_custom_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.openVolumePanel();
                        setExpandToCollapsed();
                    }
                });
                break;
            case "4":
                control_center_custom_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_camera_alt_24));
                control_center_custom_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.openCamera();
                        setExpandToCollapsed();
                    }
                });
                break;
            case "5":
                control_center_custom_1.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_settings_24_white));
                control_center_custom_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.openSetting();
                        setExpandToCollapsed();
                    }
                });
                break;
        }

        switch (preferenceController.getControlCenterPref2()){
            default:
            case "0":
                control_center_custom_2.setVisibility(View.INVISIBLE);
                break;
            case "1":
                control_center_custom_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_flash_on_white));
                control_center_custom_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (preferenceController.getFlashLightState()){
                            default:
                            case 0:
                                preferenceController.setFlashLightState(1);
                                break;
                            case 1:
                                preferenceController.setFlashLightState(0);
                                break;
                        }
                        taskController.setFlashLight();
                    }
                });
                break;
            case "2":
                control_center_custom_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_sensor_window_24));
                control_center_custom_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.splitWindow();
                        setExpandToCollapsed();
                    }
                });
                break;
            case "3":
                control_center_custom_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_ring_volume_24));
                control_center_custom_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.openVolumePanel();
                        setExpandToCollapsed();
                    }
                });
                break;
            case "4":
                control_center_custom_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_camera_alt_24));
                control_center_custom_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.openCamera();
                        setExpandToCollapsed();
                    }
                });
                break;
            case "5":
                control_center_custom_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_settings_24_white));
                control_center_custom_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.openSetting();
                        setExpandToCollapsed();
                    }
                });
                break;
        }

        switch (preferenceController.getControlCenterPref3()){
            default:
            case "0":
                control_center_custom_3.setVisibility(View.INVISIBLE);
                break;
            case "1":
                control_center_custom_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_flash_on_white));
                control_center_custom_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (preferenceController.getFlashLightState()){
                            default:
                            case 0:
                                preferenceController.setFlashLightState(1);
                                break;
                            case 1:
                                preferenceController.setFlashLightState(0);
                                break;
                        }
                        taskController.setFlashLight();
                    }
                });
                break;
            case "2":
                control_center_custom_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_sensor_window_24));
                control_center_custom_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.splitWindow();
                        setExpandToCollapsed();
                    }
                });
                break;
            case "3":
                control_center_custom_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_ring_volume_24));
                control_center_custom_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.openVolumePanel();
                        setExpandToCollapsed();
                    }
                });
                break;
            case "4":
                control_center_custom_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_camera_alt_24));
                control_center_custom_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.openCamera();
                        setExpandToCollapsed();
                    }
                });
                break;
            case "5":
                control_center_custom_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_settings_24_white));
                control_center_custom_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.openSetting();
                        setExpandToCollapsed();
                    }
                });
                break;
        }

        switch (preferenceController.getControlCenterPref4()){
            default:
            case "0":
                control_center_custom_4.setVisibility(View.INVISIBLE);
                break;
            case "1":
                control_center_custom_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_flash_on_white));
                control_center_custom_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (preferenceController.getFlashLightState()){
                            default:
                            case 0:
                                preferenceController.setFlashLightState(1);
                                break;
                            case 1:
                                preferenceController.setFlashLightState(0);
                                break;
                        }
                        taskController.setFlashLight();
                    }
                });
                break;
            case "2":
                control_center_custom_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_sensor_window_24));
                control_center_custom_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.splitWindow();
                        setExpandToCollapsed();
                    }
                });
                break;
            case "3":
                control_center_custom_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_ring_volume_24));
                control_center_custom_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.openVolumePanel();
                        setExpandToCollapsed();
                    }
                });
                break;
            case "4":
                control_center_custom_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_camera_alt_24));
                control_center_custom_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.openCamera();
                        setExpandToCollapsed();
                    }
                });
                break;
            case "5":
                control_center_custom_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_settings_24_white));
                control_center_custom_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskController.openSetting();
                        setExpandToCollapsed();
                    }
                });
                break;
        }

    }

    private void setGestureMenu(){
        btn_1_gesture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGestureDialog(1);
            }
        });

        text_1_gesture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGestureDialog(1);
            }
        });

        parent_1_gesture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGestureDialog(1);
            }
        });

        btn_2_gesture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setGestureDialog(2);
            }
        });

        text_2_gesture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setGestureDialog(2);
            }
        });

        parent_2_gesture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setGestureDialog(2);
            }
        });

        btn_4_gesture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideGestureMenu();
            }
        });
    }

    private final BroadcastReceiver wifiReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                    WifiManager.WIFI_STATE_UNKNOWN);
            switch (wifiStateExtra) {
                case WifiManager.WIFI_STATE_ENABLED:
                    btn_wifi.setBackground(ContextCompat.getDrawable(MainService.this,R.drawable.icon_circle_enable_bg));
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    btn_wifi.setBackground(ContextCompat.getDrawable(MainService.this,R.drawable.control_center_circle_bg));
                    break;
            }
        }
    };

    private final BroadcastReceiver bluetoothChangeReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if (Objects.equals(action, BluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
                switch(state) {
                    case BluetoothAdapter.STATE_OFF:
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        btn_bluetooth.setBackground(ContextCompat.getDrawable(MainService.this, R.drawable.control_center_circle_bg));
                        break;
                    case BluetoothAdapter.STATE_ON:
                    case BluetoothAdapter.STATE_TURNING_ON:
                        btn_bluetooth.setBackground(ContextCompat.getDrawable(MainService.this, R.drawable.icon_circle_enable_bg));
                        break;
                }

            }
        }
    };


    private final ContentObserver rotationObserver = new ContentObserver(new Handler()) {
        @Override
        public void onChange(boolean selfChange) {
            if (taskController.isAutoRotateModeOn(context)){
                text_5_device.setText(context.getString(R.string.unlock_nrotation));
                rotate_control_center.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_bg_2));
                rotate_control_center.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.orientation_default_white));
            }else {
                text_5_device.setText(context.getString(R.string.lock_nrotation));
                rotate_control_center.setBackground(ContextCompat.getDrawable(context,R.drawable.active_rotation_control_center_bg));
                rotate_control_center.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.orientation_active));
            }
        }
    };

    private ContentResolver cResolver;

    private void setBrightness(int brightness){

        if(Settings.System.canWrite(this)){
            //constrain the value of brightness
            if(brightness < 0)
                brightness = 0;
            else if(brightness > 255)
                brightness = 255;

            Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
        }

    }

    private void removeServiceView() {
        if (floatingRootView != null) mWindowManager.removeView(floatingRootView);
    }

    private void setWindowManagerAssitiveTouch(){
        assert mWindowManager != null;
        mWindowManager.addView(floatingRootView, params);

        floatingRootView.findViewById(R.id.collapsed_image).setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                gestureDetector.onTouchEvent(event);

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        setAssitiveTouchHeavy();

                        return true;

                    case MotionEvent.ACTION_UP:
                        final int Xdiff = (int) (event.getRawX() - initialTouchX);
                        int Ydiff = (int) (event.getRawY() - initialTouchY);

                        runHandlerOneTime();

                        //Place Assitive Touch only boarder
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
                        if (mWindowManager != null) {
                            mWindowManager.getDefaultDisplay().getMetrics(displayMetrics);
                        }
                        final int height = displayMetrics.heightPixels;
                        final int heightSize = 4;
                        final int heightDif = height - heightSize;
                        final int width = displayMetrics.widthPixels;
                        final int detectionX = width /2;

                        final int negativeDetectionX= detectionX * -1;

                        ValueAnimator va = null;

                        if (event.getRawX() > detectionX && event.getRawY() > heightSize && event.getRawY() < heightDif){

                            va = ValueAnimator.ofFloat(params.x, width);
                            int mDuration = 500;
                            switch (getSpeedType()){
                                case "Default":
                                    mDuration = 500;
                                    break;
                                case "Medium":
                                    mDuration = 800;
                                    break;
                                case "Slow":
                                    mDuration = 1100;
                                    break;
                            }
                            va.setDuration(mDuration);
                            va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                public void onAnimationUpdate(ValueAnimator animation) {
                                    params.x = Math.round((Float) animation.getAnimatedValue());
                                    if (params.x == width && Xdiff < -100 || params.x == width && Xdiff > detectionX - 100){
                                        taskController.animation_BounceLeft(assitiveTouch);
                                    }

                                    mWindowManager.updateViewLayout(floatingRootView, params);
                                }
                            });
                            va.start();



                        }else if (event.getRawX() < detectionX && event.getRawY() > heightSize && event.getRawY() < heightDif){

                            va = ValueAnimator.ofFloat(params.x, 0);
                            int mDuration = 500;
                            switch (getSpeedType()){
                                case "Default":
                                    mDuration = 500;
                                    break;
                                case "Medium":
                                    mDuration = 800;
                                    break;
                                case "Slow":
                                    mDuration = 1100;
                                    break;
                            }
                            va.setDuration(mDuration);
                            va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                public void onAnimationUpdate(ValueAnimator animation) {
                                    params.x = Math.round((Float) animation.getAnimatedValue());
                                    if (params.x == 0 && Xdiff > 50 || params.x == 0 && Xdiff < negativeDetectionX + 100){
                                        taskController.animation_BounceRight(assitiveTouch);
                                    }
                                    mWindowManager.updateViewLayout(floatingRootView, params);
                                }
                            });

                            va.start();
                        }

                        if (Xdiff < 10 && Ydiff < 10 && Xdiff >-10 && Ydiff >-10) {
                            if (va != null) {
                                va.cancel();
                            }

                        }

                        return true;

                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        mWindowManager.updateViewLayout(floatingRootView, params);
                        setAssitiveTouchHeavy();
                        return true;
                }
                return false;
            }
        });
    }

    private void setWindowManagerExpandMain(){
        floatingRootView.findViewById(R.id.expandRootView).setOnTouchListener(new View.OnTouchListener() {
            private float initialTouchX;
            private float initialTouchY;
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        int Xdiff = (int) (event.getRawX() - initialTouchX);
                        int Ydiff = (int) (event.getRawY() - initialTouchY);

                        if (Xdiff < 10 && Ydiff < 10 && Xdiff >-10 && Ydiff >-10) {

                            if (!(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q)){
                                if (expandRootView.getVisibility()== VISIBLE){
                                    expandRootView.setVisibility(View.GONE);
                                }else {
                                    setExpandToCollapsed();
                                }
                            }else {
                                if (expandRootView.getVisibility()== VISIBLE){
                                    expandRootView.setVisibility(View.GONE);
                                }
                                setExpandToCollapsed();
                            }

                            if (expandRootView.getVisibility()== VISIBLE){
                                expandRootView.setVisibility(View.GONE);
                            }else {
                                setExpandToCollapsed();
                            }
                        }

                        setAssitiveTouchHeavy();
                        return true;
                }
                return false;
            }
        });
    }

    private void setCollapsedToExpand(){
        if (isViewCollapsedAssistive()) {
            hideAssistive();
            show();
            mWindowManager.updateViewLayout(floatingRootView,params2);
        }
    }

    private void showControlCenterFirst(){
        hideAssistive();
        show();
        setInvisible_MainMenu_With_Pref();

        mWindowManager.removeViewImmediate(floatingRootView);
        mWindowManager.addView(floatingRootView,params2);
        mWindowManager.updateViewLayout(floatingRootView,params2);
        showControlCenter();

        if (taskController.isOtherAudioPlaying()){
            Log.d("Music State","Music is On");
            try {
                setPause_music();
            }catch (Exception ignored){}
        }else {
            Log.d("Music State","Music is Off");
            try {
                setPlay_music();
            }catch (Exception ignored){}
        }
    }

    private void showCustomFirst(){
        hideAssistive();
        show();
        setInvisible_MainMenu_With_Pref();
        mWindowManager.removeViewImmediate(floatingRootView);
        mWindowManager.addView(floatingRootView,params2);
        mWindowManager.updateViewLayout(floatingRootView,params2);
        set6IconsToCustom();
    }

    private void showGestuewFirst(){
        hideAssistive();
        show();
        setInvisible_MainMenu_With_Pref();
        mWindowManager.removeViewImmediate(floatingRootView);
        mWindowManager.addView(floatingRootView,params2);
        mWindowManager.updateViewLayout(floatingRootView,params2);
        showGestureMenu();
    }

    private void showDeviceFirst(){
        hideAssistive();
        show();
        setInvisible_MainMenu_With_Pref();
        mWindowManager.removeViewImmediate(floatingRootView);
        mWindowManager.addView(floatingRootView,params2);
        mWindowManager.updateViewLayout(floatingRootView,params2);
        setOpenDeviceMenu();
    }

    /*
    "0. None","1. Home","2. Notification","3. Control Center","4. Custom","5. Gesture", "6. Device", "7. Screenshot",
    "8. Screen Record", "9. Boost Device" , "10. Lock Device", "11. Power", "12. Status Bar"
     */

    private void setCollapsedToExpandLongPress(){
        if (isViewCollapsedAssistive()){
            switch (preferenceController.getLongPressActionState()){
                case 0:
                    break;
                case 1:
                    taskController.OpenHomeScreen();
                    break;
                case 2:
                    taskController.OpenNotification();
                    break;
                case 3:
                    showControlCenterFirst();
                    break;
                case 4:
                    showCustomFirst();
                    break;
                case 5:
                    showGestuewFirst();
                    break;
                case 6:
                    showDeviceFirst();
                    break;
                case 7:
                    Handler handler = new Handler();
                    Handler handler1 = new Handler();
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            taskController.setScreenShot();
                        }
                    };
                    handler1.postDelayed(runnable,1000);
                    assitiveTouch.setVisibility(View.GONE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            assitiveTouch.setVisibility(VISIBLE);
                        }
                    },3000);
                    break;
                case 8:
                    taskController.setStartRecord();
                    break;
                case 9:
                    taskController.progressBooster();
                    break;
                case 10:
                    taskController.lockScreen();
                    break;
                case 11:
                    taskController.openPowerAction();
                    break;
                case 12:
                    taskController.OpenStatusBar();
                    break;
                case 13:
                    taskController.openRecentAction();
                    break;
                case 14:
                    taskController.splitWindow();
                    break;
            }
        }
    }

    /*
    "0. None","1. Home","2. Notification","3. Control Center","4. Custom","5. Gesture", "6. Device", "7. Screenshot",
    "8. Screen Record", "9. Boost Device" , "10. Lock Device", "11. Power", "12. Status Bar"
     */

    private void setCollapsedToExpandDoublePress(){
        if (isViewCollapsedAssistive()){
            switch (preferenceController.getDoubleTapActionState()){
                case 0:
                    break;
                case 1:
                    taskController.OpenHomeScreen();
                    break;
                case 2:
                    taskController.OpenNotification();
                    break;
                case 3:
                    showControlCenterFirst();
                    break;
                case 4:
                    showCustomFirst();
                    break;
                case 5:
                    showGestuewFirst();
                    break;
                case 6:
                    showDeviceFirst();
                    break;
                case 7:
                    Handler handler = new Handler();
                    Handler handler1 = new Handler();
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            taskController.setScreenShot();
                        }
                    };
                    handler1.postDelayed(runnable,1000);
                    assitiveTouch.setVisibility(View.GONE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            assitiveTouch.setVisibility(VISIBLE);
                        }
                    },3000);
                    break;
                case 8:
                    taskController.setStartRecord();
                    break;
                case 9:
                    taskController.progressBooster();
                    break;
                case 10:
                    taskController.lockScreen();
                    break;
                case 11:
                    taskController.openPowerAction();
                    break;
                case 12:
                    taskController.OpenStatusBar();
                    break;
                case 13:
                    taskController.openRecentAction();
                    break;
                case 14:
                    taskController.splitWindow();
                    break;
            }
        }
    }

    private void initFromCustomMenu(){
        if (expand_custom_menu.getVisibility()==VISIBLE){
            expand_custom_menu.setVisibility(View.GONE);
            setVisible_MainMenu_With_Pref2();
        }
    }

    private void setVisibilityDeviceMenu(){
        if (expand_device_menu.getVisibility() == VISIBLE){
            expand_device_menu.setVisibility(View.GONE);
            setVisible_MainMenu_With_Pref2();
        }
    }

    private void setSubDeviceMenuVisibility(){
        if (expand_device_sub_menu.getVisibility() == VISIBLE){
            expand_device_sub_menu.setVisibility(View.GONE);
            deviceMenuIconView.setVisibility(VISIBLE);
        }
    }

    private void setControlCenterVIsibility(){
        if (control_center_view.getVisibility() == VISIBLE){
            control_center_view.setVisibility(View.GONE);
            setVisible_MainMenu_With_Pref2();
        }
    }

    private void setGestureVisibility(){
        if (expand_gesture_menu.getVisibility()==VISIBLE){
            expand_gesture_menu.setVisibility(View.GONE);
            setVisible_MainMenu_With_Pref2();
        }
    }

    private void setExpandToCollapsed(){
        if (!isViewCollapsedAssistive()) {
            initFromCustomMenu();
            setVisibilityDeviceMenu();
            setSubDeviceMenuVisibility();
            setControlCenterVIsibility();
            setGestureVisibility();
            expandRootView.setVisibility(View.GONE);
            showAssistive();
            mWindowManager.updateViewLayout(floatingRootView,params);
            runHandlerOneTime();
        }
    }

    private void showAssistive(){
        final Animation in = AnimationUtils.loadAnimation(MainService.this, android.R.anim.fade_in);
        in.setDuration(300);
        assitiveTouch.setVisibility(VISIBLE);
        assitiveTouch.setAnimation(in);
    }

    private void show(){
        final Animation in;
        switch (preferenceController.GetAnimationType()){
            default:
            case "Fade In":
                in  = AnimationUtils.loadAnimation(MainService.this, R.anim.pulse_reverse);
                in.setDuration(300);
                break;
            case "Slide In":
                in  = AnimationUtils.loadAnimation(MainService.this, R.anim.slide_in_down);
                in.setDuration(300);
                break;
        }
        expandRootView.setVisibility(VISIBLE);
        expandRootView.startAnimation(in);
    }

    private void showControlCenter(){
        final Animation in = AnimationUtils.loadAnimation(MainService.this, R.anim.slide_in_down);
        in.setDuration(300);
        control_center_view.setAnimation(in);
        control_center_view.setVisibility(VISIBLE);
        setInvisible_MainMenu_With_Pref();
    }

    private void showGestureMenu(){
        final Animation in = AnimationUtils.loadAnimation(MainService.this, R.anim.pulse_reverse);
        in.setDuration(300);
        expand_gesture_menu.setAnimation(in);
        expand_gesture_menu.setVisibility(VISIBLE);
        setGone_MainMenu_With_Pref();
    }

    private void hideGestureMenu(){
        final Animation in = AnimationUtils.loadAnimation(MainService.this, R.anim.pulse_reverse);
        in.setDuration(300);

        setVisible_MainMenu_With_Pref(in);

        expand_gesture_menu.setVisibility(View.GONE);
    }
    private void hideAssistive(){
        assitiveTouch.setVisibility(View.GONE);
    }

    private boolean isViewCollapsedAssistive() {
        return floatingRootView == null || floatingRootView.findViewById(R.id.collapsed_image).getVisibility() == VISIBLE;
    }

    private void setParams(){
        //Windows params
        DisplayMetrics displayMetrics = new DisplayMetrics();
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        if (mWindowManager != null) {
            mWindowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        //Integers
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        params = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP|Gravity.START;

        params2 = new WindowManager.LayoutParams(
                width,
                height,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                0,
                PixelFormat.TRANSLUCENT
        );
        params2.gravity = Gravity.CENTER;
    }

    private void setAssistiveIconImage(){
        if (preferenceController.GetIconType().equals("Circle")){
            assitiveTouch.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.logo_circle));
        }else if (preferenceController.GetIconType().equals("Square")){
            assitiveTouch.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.logo_square));
        }
    }

    private void setOpacity(final float floatAlpha){
        //Runnable
        runnable = new Runnable() {
            @Override
            public void run() {
                floatingRootView.findViewById(R.id.collapsed_image).setAlpha(floatAlpha);
            }
        };
    }

    private void setAssitiveTouchHeavy(){
        floatingRootView.findViewById(R.id.collapsed_image).setAlpha(1f);
    }

    private void setAssitiveTouchTransparentLight(){
        handlerWithID.postDelayed(1,5000, runnable);
    }

    private void runHandlerOneTime(){
        if (handlerWithID.hasActiveRunnable(1)){
            handlerWithID.removeCallbacks(runnable);
        }
        setAssitiveTouchTransparentLight();
    }

    private void setOpenNotification(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.OpenNotification();
                setExpandToCollapsed();
            }
        });
    }

    private void setOpenControlPanel(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showControlCenter();
                if (taskController.isOtherAudioPlaying()){
                    Log.d("Music State","Music is On");
                    try {
                        setPause_music();
                    }catch (Exception ignored){}
                }else {
                    Log.d("Music State","Music is Off");
                    try {
                        setPlay_music();
                    }catch (Exception ignored){}
                }
            }
        });
    }

    private void setPlay_music(){
        pause_music.setVisibility(View.INVISIBLE);
        play_music.setVisibility(View.VISIBLE);
        play_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setResumeMusic();
                pause_music.setVisibility(VISIBLE);
                play_music.setVisibility(View.INVISIBLE);
                pause_music.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        taskController.setStopMusic();
                        pause_music.setVisibility(View.INVISIBLE);
                        play_music.setVisibility(View.VISIBLE);
                    }
                });
            }
        });

    }

    private void setPause_music(){
        pause_music.setVisibility(VISIBLE);
        play_music.setVisibility(View.INVISIBLE);
        pause_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.setStopMusic();
                pause_music.setVisibility(View.INVISIBLE);
                play_music.setVisibility(View.VISIBLE);
                play_music.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        taskController.setResumeMusic();
                        pause_music.setVisibility(VISIBLE);
                        play_music.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });


    }

    private void setOpenGesture(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGestureMenu();
            }
        });
    }

    private void setOpenHomeScreen(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskController.OpenHomeScreen();
                setExpandToCollapsed();
            }
        });
    }

    private void setOpenScreenShot(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        setExpandToCollapsed();
                        assitiveTouch.setAlpha(0f);
                    }
                };
                Handler handler2 = new Handler();
                Runnable runnable2 = new Runnable() {
                    @Override
                    public void run() {
                        assitiveTouch.setAlpha(1.0f);

                    }
                };
                Handler handler3 = new Handler();
                Runnable runnable3 = new Runnable() {
                    @Override
                    public void run() {
                        taskController.setScreenShot();
                    }
                };
                handler.post(runnable);
                handler3.postDelayed(runnable3,1000);
                handler2.postDelayed(runnable2,3000);

            }
        });
    }

    private void setOpenScreenRecord(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskController.setStartRecord();
                setExpandToCollapsed();
            }
        });
    }

    private void setBoost(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskController.progressBooster();
                setExpandToCollapsed();
            }
        });
    }

    private void setOpenLockScreen(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskController.lockScreen();
                setExpandToCollapsed();
            }
        });
    }

    private void setOpenPower(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskController.openPowerAction();
                setExpandToCollapsed();
            }
        });
    }

    private void setOpenStatusBar(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskController.OpenStatusBar();
                setExpandToCollapsed();
            }
        });
    }

    private void setOpenRecent(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskController.openRecentAction();
                setExpandToCollapsed();
            }
        });
    }

    private void setOpenCustomMenu(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               set6IconsToCustom();
            }
        });
    }

    private void setCloseCustomMenu(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCustomTo6Icons();
            }
        });
    }

    private void setOpenDeviceMenu(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOpenDeviceMenu();
            }
        });
    }

    private void setCloseDeviceMenu(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCloseDeviceMenu();
            }
        });
    }

    private void set6IconsToCustom(){
        final Animation in = AnimationUtils.loadAnimation(MainService.this, R.anim.pulse_reverse);
        in.setDuration(300);
        expand_custom_menu.setAnimation(in);

        setGone_MainMenu_With_Pref();

        expand_custom_menu.setVisibility(VISIBLE);
    }

    private void setCustomTo6Icons(){
        final Animation in = AnimationUtils.loadAnimation(MainService.this, R.anim.pulse_reverse);
        in.setDuration(300);

       setVisible_MainMenu_With_Pref(in);

        expand_custom_menu.setVisibility(View.GONE);
    }



    private void setOpenDeviceMenu(){
        final Animation in = AnimationUtils.loadAnimation(MainService.this, R.anim.pulse_reverse);
        in.setDuration(300);
        expand_device_menu.setAnimation(in);

        setGone_MainMenu_With_Pref();

        expand_device_menu.setVisibility(VISIBLE);
    }

    private void setCloseDeviceMenu(){
        final Animation in = AnimationUtils.loadAnimation(MainService.this, R.anim.pulse_reverse);
        in.setDuration(300);

        setVisible_MainMenu_With_Pref(in);

        expand_device_menu.setVisibility(View.GONE);
    }

    private void setVisible_MainMenu_With_Pref(Animation in){
        switch (preferenceController.getItemCount()){
            case 1:
                expand_1_icons_menu.setAnimation(in);
                expand_1_icons_menu.setVisibility(VISIBLE);
                break;
            case 2:
                expand_2_icons_menu.setAnimation(in);
                expand_2_icons_menu.setVisibility(VISIBLE);
                break;
            case 3:
                expand_3_icons_menu.setAnimation(in);
                expand_3_icons_menu.setVisibility(VISIBLE);
                break;
            case 4:
                expand_4_icons_menu.setAnimation(in);
                expand_4_icons_menu.setVisibility(VISIBLE);
                break;
            case 5:
                expand_5_icons_menu.setAnimation(in);
                expand_5_icons_menu.setVisibility(VISIBLE);
                break;
            case 6:
                expand_6_icons_menu.setAnimation(in);
                expand_6_icons_menu.setVisibility(VISIBLE);
                break;
            case 7:
                expand_7_icons_menu.setAnimation(in);
                expand_7_icons_menu.setVisibility(VISIBLE);
                break;
            case 8:
                expand_8_icons_menu.setAnimation(in);
                expand_8_icons_menu.setVisibility(VISIBLE);
                break;
        }
    }

    private void setVisible_MainMenu_With_Pref2(){
        switch (preferenceController.getItemCount()){
            case 1:
                expand_1_icons_menu.setVisibility(VISIBLE);
                break;
            case 2:
                expand_2_icons_menu.setVisibility(VISIBLE);
                break;
            case 3:
                expand_3_icons_menu.setVisibility(VISIBLE);
                break;
            case 4:
                expand_4_icons_menu.setVisibility(VISIBLE);
                break;
            case 5:
                expand_5_icons_menu.setVisibility(VISIBLE);
                break;
            case 6:
                expand_6_icons_menu.setVisibility(VISIBLE);
                break;
            case 7:
                expand_7_icons_menu.setVisibility(VISIBLE);
                break;
            case 8:
                expand_8_icons_menu.setVisibility(VISIBLE);
                break;
        }
    }

    private void setGone_MainMenu_With_Pref(){
        switch (preferenceController.getItemCount()){
            case 1:
                expand_1_icons_menu.setVisibility(View.GONE);
                break;
            case 2:
                expand_2_icons_menu.setVisibility(View.GONE);
                break;
            case 3:
                expand_3_icons_menu.setVisibility(View.GONE);
                break;
            case 4:
                expand_4_icons_menu.setVisibility(View.GONE);
                break;
            case 5:
                expand_5_icons_menu.setVisibility(View.GONE);
                break;
            case 6:
                expand_6_icons_menu.setVisibility(View.GONE);
                break;
            case 7:
                expand_7_icons_menu.setVisibility(View.GONE);
                break;
            case 8:
                expand_8_icons_menu.setVisibility(View.GONE);
                break;
        }
    }

    private void setInvisible_MainMenu_With_Pref(){
        switch (preferenceController.getItemCount()){
            case 1:
                expand_1_icons_menu.setVisibility(View.INVISIBLE);
                break;
            case 2:
                expand_2_icons_menu.setVisibility(View.INVISIBLE);
                break;
            case 3:
                expand_3_icons_menu.setVisibility(View.INVISIBLE);
                break;
            case 4:
                expand_4_icons_menu.setVisibility(View.INVISIBLE);
                break;
            case 5:
                expand_5_icons_menu.setVisibility(View.INVISIBLE);
                break;
            case 6:
                expand_6_icons_menu.setVisibility(View.INVISIBLE);
                break;
            case 7:
                expand_7_icons_menu.setVisibility(View.INVISIBLE);
                break;
            case 8:
                expand_8_icons_menu.setVisibility(View.INVISIBLE);
                break;
        }
    }

    private String getSpeedType(){
        return preferenceController.GetSpeed();
    }

    private void setOpenDeviceSubMenu(){
        final Animation in = AnimationUtils.loadAnimation(MainService.this, R.anim.pulse_reverse);
        in.setDuration(300);
        expand_device_sub_menu.setAnimation(in);
        deviceMenuIconView.setVisibility(View.GONE);
        expand_device_sub_menu.setVisibility(VISIBLE);
    }

    private void setCloseDeviceSubMenu(){
        final Animation in = AnimationUtils.loadAnimation(MainService.this, R.anim.pulse_reverse);
        in.setDuration(300);
        expand_device_menu.setAnimation(in);
        expand_device_sub_menu.setVisibility(View.GONE);
        deviceMenuIconView.setVisibility(VISIBLE);
    }

    private int getActionBtn1(){
        return preferenceController.getActionsPref1();
    }

    private int getActionBtn2(){
        return preferenceController.getActionsPref2();
    }

    private int getActionBtn3(){
        return preferenceController.getActionsPref3();
    }

    private int getActionBtn4(){
        return preferenceController.getActionsPref4();
    }

    private int getActionBtn5(){
        return preferenceController.getActionsPref5();
    }

    private int getActionBtn6(){
        return preferenceController.getActionsPref6();
    }

    private int getActionBtn7(){
        return preferenceController.getActionsPref7();
    }

    private int getActionBtn8(){
        return preferenceController.getActionsPref8();
    }

    private String getAppPref1(){
        return preferenceController.getAppPref1();
    }

    private String getAppPref2(){
        return preferenceController.getAppPref2();
    }

    private String getAppPref3(){
        return preferenceController.getAppPref3();
    }

    private String getAppPref4(){
        return preferenceController.getAppPref4();
    }

    private String getAppPref6(){
        return preferenceController.getAppPref6();
    }

    private String getAppPref7(){
        return preferenceController.getAppPref7();
    }

    private String getAppPref8(){
        return preferenceController.getAppPref8();
    }

    private String getAppPref9(){
        return preferenceController.getAppPref9();
    }

    private void setScaleDefault(ImageButton imageButton){
        imageButton.setScaleY(0.7f);
        imageButton.setScaleX(0.7f);
    }

    private void loadApps() {
        PackageManager manager = context.getPackageManager();
        appDetails = new ArrayList<>();
        Intent i = new Intent(Intent.ACTION_MAIN,null);
        i.addCategory(Intent.CATEGORY_LAUNCHER );
        @SuppressLint("QueryPermissionsNeeded") List<ResolveInfo> availableActivities = manager.queryIntentActivities(i,0);
        for (ResolveInfo ri : availableActivities){
            AppDetails app = new AppDetails();
            app.appLabel = (String) ri.loadLabel(manager);
            app.packageName = ri.activityInfo.packageName;
            app.appIcon = ri.activityInfo.loadIcon(manager);
            Log.d("MainService",app.packageName);
            appDetails.add(app);
        }
    }


    // 1: long press
    private void setGestureDialog(final int action){
        ListView listView = new ListView(context);
        String[] actionList = new String[]{
                "1. None","2. Home","3. Notification","4. Control Center","5. Custom","6. Gesture", "7. Device", "8. Screenshot",
                "9. Screen Record", "10. Boost Device" , "11. Lock Device", "12. Power", "13. Status Bar","14. Open Recent","15. Split Window"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,actionList){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(ContextCompat.getColor(context,R.color.white));
                return textView;
            }
        };
        listView.setAdapter(adapter);

        final AlertDialog alertDialog = new AlertDialog.Builder(this,R.style.DarkWindow)
                .setTitle("Select Action")
                .setView(listView)
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
                .create();
        Objects.requireNonNull(alertDialog.getWindow()).setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
        alertDialog.show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (action){
                    case 1:
                            switch (position){
                                case 0:
                                    preferenceController.setLongPressActionState(0);
                                    Toast.makeText(context,"Long Press: None",Toast.LENGTH_SHORT).show();
                                    break;
                                case 1:
                                    preferenceController.setLongPressActionState(1);
                                    Toast.makeText(context,"Long Press: Home",Toast.LENGTH_SHORT).show();
                                    break;
                                case 2:
                                    preferenceController.setLongPressActionState(2);
                                    Toast.makeText(context,"Long Press: Notification",Toast.LENGTH_SHORT).show();
                                    break;
                                case 3:
                                    preferenceController.setLongPressActionState(3);
                                    Toast.makeText(context,"Long Press: Control Center",Toast.LENGTH_SHORT).show();
                                    break;
                                case 4:
                                    preferenceController.setLongPressActionState(4);
                                    Toast.makeText(context,"Long Press: Custom",Toast.LENGTH_SHORT).show();
                                    break;
                                case 5:
                                    preferenceController.setLongPressActionState(5);
                                    Toast.makeText(context,"Long Press: Gesture",Toast.LENGTH_SHORT).show();
                                    break;
                                case 6:
                                    preferenceController.setLongPressActionState(6);
                                    Toast.makeText(context,"Long Press: Device",Toast.LENGTH_SHORT).show();
                                    break;
                                case 7:
                                    preferenceController.setLongPressActionState(7);
                                    Toast.makeText(context,"Long Press: Screenshot",Toast.LENGTH_SHORT).show();
                                    break;
                                case 8:
                                    preferenceController.setLongPressActionState(8);
                                    Toast.makeText(context,"Long Press: Screen Record",Toast.LENGTH_SHORT).show();
                                    break;
                                case 9:
                                    preferenceController.setLongPressActionState(9);
                                    Toast.makeText(context,"Long Press: Boost Device",Toast.LENGTH_SHORT).show();
                                    break;
                                case 10:
                                    preferenceController.setLongPressActionState(10);
                                    Toast.makeText(context,"Long Press: Lock Device",Toast.LENGTH_SHORT).show();
                                    break;
                                case 11:
                                    preferenceController.setLongPressActionState(11);
                                    Toast.makeText(context,"Long Press: Power",Toast.LENGTH_SHORT).show();
                                    break;
                                case 12:
                                    preferenceController.setLongPressActionState(12);
                                    Toast.makeText(context,"Long Press: Status Bar",Toast.LENGTH_SHORT).show();
                                    break;
                                case 13:
                                    preferenceController.setLongPressActionState(13);
                                    Toast.makeText(context,"Long Press: Open Recent",Toast.LENGTH_SHORT).show();
                                    break;
                                case 14:
                                    preferenceController.setLongPressActionState(14);
                                    Toast.makeText(context,"Long Press: Split Window",Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        break;
                    case 2:
                        switch (position){
                            case 0:
                                preferenceController.setDoubleTapActionState(0);
                                Toast.makeText(context,"Double Tap: None",Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                preferenceController.setDoubleTapActionState(1);
                                Toast.makeText(context,"Double Tap: Home",Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                preferenceController.setDoubleTapActionState(2);
                                Toast.makeText(context,"Double Tap: Notification",Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                preferenceController.setDoubleTapActionState(3);
                                Toast.makeText(context,"Double Tap: Control Center",Toast.LENGTH_SHORT).show();
                                break;
                            case 4:
                                preferenceController.setDoubleTapActionState(4);
                                Toast.makeText(context,"Double Tap: Custom",Toast.LENGTH_SHORT).show();
                                break;
                            case 5:
                                preferenceController.setDoubleTapActionState(5);
                                Toast.makeText(context,"Double Tap: Gesture",Toast.LENGTH_SHORT).show();
                                break;
                            case 6:
                                preferenceController.setDoubleTapActionState(6);
                                Toast.makeText(context,"Double Tap: Device",Toast.LENGTH_SHORT).show();
                                break;
                            case 7:
                                preferenceController.setDoubleTapActionState(7);
                                Toast.makeText(context,"Double Tap: Screenshot",Toast.LENGTH_SHORT).show();
                                break;
                            case 8:
                                preferenceController.setDoubleTapActionState(8);
                                Toast.makeText(context,"Double Tap: Screen Record",Toast.LENGTH_SHORT).show();
                                break;
                            case 9:
                                preferenceController.setDoubleTapActionState(9);
                                Toast.makeText(context,"Double Tap: Boost Device",Toast.LENGTH_SHORT).show();
                                break;
                            case 10:
                                preferenceController.setDoubleTapActionState(10);
                                Toast.makeText(context,"Double Tap: Lock Device",Toast.LENGTH_SHORT).show();
                                break;
                            case 11:
                                preferenceController.setDoubleTapActionState(11);
                                Toast.makeText(context,"Double Tap: Power",Toast.LENGTH_SHORT).show();
                                break;
                            case 12:
                                preferenceController.setDoubleTapActionState(12);
                                Toast.makeText(context,"Double Tap: Status Bar",Toast.LENGTH_SHORT).show();
                                break;
                            case 13:
                                preferenceController.setDoubleTapActionState(13);
                                Toast.makeText(context,"Double Tap: Open Recent",Toast.LENGTH_SHORT).show();
                                break;
                            case 14:
                                preferenceController.setDoubleTapActionState(14);
                                Toast.makeText(context,"Double Tap: Split Window",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                }
                alertDialog.dismiss();
            }
        });
    }

    private InstalledAppListAdapter adapter2;
    private List<AppDetails> appDetails;

    private void setCustomAlertDialog(final int btn_num){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("InflateParams") View dialogView = inflater.inflate(R.layout.dialog_layout, null);
        final RecyclerView recyclerView_InstalledApps = dialogView.findViewById(R.id.dialog_recyclerView);
        SearchView searchView = dialogView.findViewById(R.id.dialog_search);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setQueryHint("Search in apps...");
        searchView.setIconifiedByDefault(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter2.getFilter().filter(newText);
                return false;
            }
        });
        recyclerView_InstalledApps.setLayoutManager(new GridLayoutManager(context,4));
        recyclerView_InstalledApps.setHasFixedSize(true);
        recyclerView_InstalledApps.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(context,R.anim.layout_installed));
        loadApps();

        Collections.sort(appDetails, new Comparator<AppDetails>() {
            @Override
            public int compare(AppDetails o1, AppDetails o2) {
                return o1.appLabel.compareToIgnoreCase(o2.appLabel);
            }
        });

        adapter2 = new InstalledAppListAdapter(context,appDetails);
        recyclerView_InstalledApps.setAdapter(adapter2);



        final AlertDialog alertDialog = new AlertDialog.Builder(this,R.style.DarkWindow)
                .setTitle("Select App")
                .setView(dialogView)
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
                .create();
        Objects.requireNonNull(alertDialog.getWindow()).setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
        alertDialog.show();


        adapter2.setOnItemClickListener(new InstalledAppListAdapter.RecyclerOnClickListener() {
            @Override
            public void onItemClick(int position, View view, String label, String packageName) {
                Log.d("Dialog label","Label: " + label);
                Log.d("Dialog packageName","PackageName: " + packageName);
                switch (btn_num){
                    case 1:
                        preferenceController.setAppPref1(packageName);
                        btn_1_custom.setImageDrawable(getDrawableFromPackageName(packageName));
                        btn_1_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
                        text_1_custom.setVisibility(VISIBLE);
                        text_1_custom.setText(label);
                        alertDialog.dismiss();
                        Toast.makeText(context,label + " is selected",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        preferenceController.setAppPref2(packageName);
                        btn_2_custom.setImageDrawable(getDrawableFromPackageName(packageName));
                        btn_2_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
                        text_2_custom.setVisibility(VISIBLE);
                        text_2_custom.setText(label);
                        alertDialog.dismiss();
                        Toast.makeText(context,label + " is selected",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        preferenceController.setAppPref3(packageName);
                        btn_3_custom.setImageDrawable(getDrawableFromPackageName(packageName));
                        btn_3_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
                        text_3_custom.setVisibility(VISIBLE);
                        text_3_custom.setText(label);
                        alertDialog.dismiss();
                        Toast.makeText(context,label + " is selected",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        preferenceController.setAppPref4(packageName);
                        btn_4_custom.setImageDrawable(getDrawableFromPackageName(packageName));
                        btn_4_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
                        text_4_custom.setVisibility(VISIBLE);
                        text_4_custom.setText(label);
                        alertDialog.dismiss();
                        Toast.makeText(context,label + " is selected",Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        preferenceController.setAppPref6(packageName);
                        btn_6_custom.setImageDrawable(getDrawableFromPackageName(packageName));
                        btn_6_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
                        text_6_custom.setVisibility(VISIBLE);
                        text_6_custom.setText(label);
                        alertDialog.dismiss();
                        Toast.makeText(context,label + " is selected",Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        preferenceController.setAppPref7(packageName);
                        btn_7_custom.setImageDrawable(getDrawableFromPackageName(packageName));
                        btn_7_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
                        text_7_custom.setVisibility(VISIBLE);
                        text_7_custom.setText(label);
                        alertDialog.dismiss();
                        Toast.makeText(context,label + " is selected",Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        preferenceController.setAppPref8(packageName);
                        btn_8_custom.setImageDrawable(getDrawableFromPackageName(packageName));
                        btn_8_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
                        text_8_custom.setVisibility(VISIBLE);
                        text_8_custom.setText(label);
                        alertDialog.dismiss();
                        Toast.makeText(context,label + " is selected",Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        preferenceController.setAppPref9(packageName);
                        btn_9_custom.setImageDrawable(getDrawableFromPackageName(packageName));
                        btn_9_custom.setBackground(ContextCompat.getDrawable(context,R.drawable.icon_select_cirlcle_bg));
                        text_9_custom.setVisibility(VISIBLE);
                        text_9_custom.setText(label);
                        alertDialog.dismiss();
                        Toast.makeText(context,label + " is selected",Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onItemLongClick(int position, View view, String label, String packageName) {
                Log.d("Dialog label","Label: " + label);
                Log.d("Dialog packageName","PackageName: " + packageName);
            }
        });


    }

    private Drawable getDrawableFromPackageName(String packageName){
        try {
            return context.getPackageManager().getApplicationIcon(packageName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getAppLabelFromPackageName(String packageName){
        PackageManager packageManager= context.getPackageManager();

        try {
            return (String) context.getPackageManager().getApplicationLabel(packageManager.getApplicationInfo(packageName,PackageManager.GET_META_DATA));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setLaunchAppFromPackageName(String packageName){
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        context.startActivity(intent);
    }

    private void startServiceForeground() {
        String NOTIFICATION_CHANNEL_ID = "Assistive Touch";
        String ChannelName = "Assistive Touch";
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,ChannelName, NotificationManager.IMPORTANCE_NONE);
        notificationChannel.setLightColor(R.color.colorAccent);
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.createNotificationChannel(notificationChannel);

        Intent intent = new Intent(MainService.this, SettingsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID);
        Notification notification = notificationBuilder.setOngoing(true)
                .setContentTitle("Assistive Touch is active.")
                .setSubText("Tap to open app")
                .setPriority(NotificationManager.IMPORTANCE_MIN)
                .setCategory(Notification.CATEGORY_SERVICE)
                .setSmallIcon(android.R.color.transparent)
                .setShowWhen(false)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.logo_circle,"Setting",pendingIntent)
                .build();

        startForeground(1,notification);
    }

    public static class HandlerWithID extends Handler {

        public final void postDelayed (int runnableID, long delayMillis, Runnable r) {
            Message m = Message.obtain(this, r);
            m.what = runnableID;
            sendMessageDelayed(m, delayMillis);
        }
        public final boolean hasActiveRunnable(int runnableID) {
            return hasMessages(runnableID);
        }
    }
}
