package com.pythontaro.assistivetouchpro.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.pythontaro.assistivetouchpro.R;
import com.pythontaro.assistivetouchpro.controller.ActivityController;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    @Override
    public void onBackPressed() {

    }

    private void init(){
        final ActivityController controller = new ActivityController(this);
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                controller.MoveToSettingActivity(0,0);
            }
        };
        handler.postDelayed(runnable,1000);
    }
}