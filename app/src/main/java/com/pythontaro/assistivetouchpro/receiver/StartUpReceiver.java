package com.pythontaro.assistivetouchpro.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.pythontaro.assistivetouchpro.controller.SharedPreferenceController;
import com.pythontaro.assistivetouchpro.service.MainService;

public class StartUpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
            SharedPreferenceController preferenceController = new SharedPreferenceController(context);
            boolean mainSwitchState = preferenceController.GetMainSwitchState();
            if (mainSwitchState){
                Intent intent1 = new Intent(context, MainService.class);
                context.startForegroundService(intent1);
            }
        }
    }
}
