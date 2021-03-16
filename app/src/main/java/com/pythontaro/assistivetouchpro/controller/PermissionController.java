package com.pythontaro.assistivetouchpro.controller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

public class PermissionController {

    private final Context context;

    public PermissionController(Context context) {
        this.context = context;
    }

    public boolean CanDisplayOverOtherApp(){
        return Settings.canDrawOverlays(context);
    }

    public void CheckCanDisplayOverOtherApp(){
        if (!Settings.canDrawOverlays(context)){
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }
    }

    public boolean CanSystemWrite(){
        return Settings.System.canWrite(context);
    }

    public void CheckCanSystemWrite(){
        if(!Settings.System.canWrite(context)){
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }
    }
}
