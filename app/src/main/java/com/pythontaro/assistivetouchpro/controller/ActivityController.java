package com.pythontaro.assistivetouchpro.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.pythontaro.assistivetouchpro.ui.CustomizeLayoutActivity;
import com.pythontaro.assistivetouchpro.ui.SettingsActivity;

public class ActivityController {

    private Context context;

    public ActivityController(Context context) {
        this.context = context;
    }

    public void MoveToSettingActivity(int enterAnim, int exitAnim){
        Intent intent = new Intent(context, SettingsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
        ((Activity)context).overridePendingTransition(enterAnim,exitAnim);
        ((Activity)context).finishAffinity();
    }

    public void MoveToCustomizeLayoutActivity(int enterAnim, int exitAnim){
        Intent intent = new Intent(context, CustomizeLayoutActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
        ((Activity)context).overridePendingTransition(enterAnim,exitAnim);
    }
}
