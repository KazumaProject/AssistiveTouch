package com.pythontaro.assistivetouchpro.controller;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.pythontaro.assistivetouchpro.service.MainService;

public class ServiceController {

    private final Context context;

    public ServiceController(Context context) {
        this.context = context;
    }

    public void StartService(){
        Intent intent = new Intent(context, MainService.class);
        context.startForegroundService(intent);
    }

    public void stopMainService(){
        Intent intent_service = new Intent(context,MainService.class);
        context.stopService(intent_service);
    }

    public void restartService(){
        try {

            if (isServiceRunning()){
                stopMainService();
                StartService();
            }

        }catch (Exception e){
            Log.d("Service Restart",e.toString());
        }

    }

    private boolean isServiceRunning() {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (MainService.class.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

}
