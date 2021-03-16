package com.pythontaro.assistivetouchpro.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.pythontaro.assistivetouchpro.R;

public class SharedPreferenceController {

    private final Context context;
    private final SharedPreferences sharedPreferences;
    private SharedPreferences customLayoutSharedPreference_1;
    private SharedPreferences.Editor customLayoutEditor_1;
    private SharedPreferences customLayoutSharedPreference_2;
    private SharedPreferences.Editor customLayoutEditor_2;
    private SharedPreferences customLayoutSharedPreference_3;
    private SharedPreferences.Editor customLayoutEditor_3;
    private SharedPreferences customLayoutSharedPreference_4;
    private SharedPreferences.Editor customLayoutEditor_4;
    private SharedPreferences customLayoutSharedPreference_5;
    private SharedPreferences.Editor customLayoutEditor_5;
    private SharedPreferences customLayoutSharedPreference_6;
    private SharedPreferences.Editor customLayoutEditor_6;
    private SharedPreferences customLayoutSharedPreference_7;
    private SharedPreferences.Editor customLayoutEditor_7;
    private SharedPreferences customLayoutSharedPreference_8;
    private SharedPreferences.Editor customLayoutEditor_8;

    private SharedPreferences appShortCut1;
    private SharedPreferences.Editor appShortCut1_Editor;
    private SharedPreferences appShortCut2;
    private SharedPreferences.Editor appShortCut2_Editor;
    private SharedPreferences appShortCut3;
    private SharedPreferences.Editor appShortCut3_Editor;
    private SharedPreferences appShortCut4;
    private SharedPreferences.Editor appShortCut4_Editor;
    private SharedPreferences appShortCut6;
    private SharedPreferences.Editor appShortCut6_Editor;
    private SharedPreferences appShortCut7;
    private SharedPreferences.Editor appShortCut7_Editor;
    private SharedPreferences appShortCut8;
    private SharedPreferences.Editor appShortCut8_Editor;
    private SharedPreferences appShortCut9;
    private SharedPreferences.Editor appShortCut9_Editor;

    private SharedPreferences flashLightState;
    private SharedPreferences.Editor flashLightState_Editor;

    private SharedPreferences longPressPref;
    private SharedPreferences.Editor longPressPref_Editor;

    private SharedPreferences doubleTapPref;
    private SharedPreferences.Editor doubleTapEditor;

    private SharedPreferences itemCount;
    private SharedPreferences.Editor itemCountEditor;

    public SharedPreferenceController(Context context) {
        this.context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        InitCustomLayoutActions();
        initCustomLayoutCount();
        InitAppShortcuts();
        InitFlashLightState();
        InitGestureStates();
    }

    public  int getIdleOpacity(){
        return sharedPreferences.getInt("IdleOpacityKey",5);
    }

    public boolean GetMainSwitchState(){
        return sharedPreferences.getBoolean(context.getString(R.string.main_switch_key),false);
    }

    public int getIconSize(){
        return sharedPreferences.getInt("iconSizeKey",0);
    }

    public String GetIconType(){
        return sharedPreferences.getString(context.getString(R.string.icon_type_list_key),"Circle");
    }

    public String GetAnimationType(){
        return sharedPreferences.getString(context.getString(R.string.animation_type_list_key),"Default");
    }

    public String GetSpeed(){
        return sharedPreferences.getString(context.getString(R.string.speed_key),"Default");
    }

    public String getControlCenterPref1(){
        return sharedPreferences.getString("Control Center Custom 1","0");
    }

    public String getControlCenterPref2(){
        return sharedPreferences.getString("Control Center Custom 2","0");
    }

    public String getControlCenterPref3(){
        return sharedPreferences.getString("Control Center Custom 3","0");
    }

    public String getControlCenterPref4(){
        return sharedPreferences.getString("Control Center Custom 4","0");
    }

    @SuppressLint("CommitPrefEdits")
    private void InitGestureStates(){
        longPressPref = context.getSharedPreferences("Long Press Action",Context.MODE_PRIVATE);
        longPressPref_Editor = longPressPref.edit();
        doubleTapPref = context.getSharedPreferences("Double Tap Action",Context.MODE_PRIVATE);
        doubleTapEditor = doubleTapPref.edit();
    }

    @SuppressLint("CommitPrefEdits")
    private void InitFlashLightState(){
        flashLightState = context.getSharedPreferences("Light State",Context.MODE_PRIVATE);
        flashLightState_Editor = flashLightState.edit();
    }

    @SuppressLint("CommitPrefEdits")
    private void initCustomLayoutCount(){
        itemCount = context.getSharedPreferences("Item Count Pref",Context.MODE_PRIVATE);
        itemCountEditor = itemCount.edit();
    }


    @SuppressLint("CommitPrefEdits")
    private void InitCustomLayoutActions(){
        customLayoutSharedPreference_1 = context.getSharedPreferences("Custom Layout Pref 1",Context.MODE_PRIVATE);
        customLayoutEditor_1 = customLayoutSharedPreference_1.edit();
        customLayoutSharedPreference_2 = context.getSharedPreferences("Custom Layout Pref 2",Context.MODE_PRIVATE);
        customLayoutEditor_2 = customLayoutSharedPreference_2.edit();
        customLayoutSharedPreference_3 = context.getSharedPreferences("Custom Layout Pref 3",Context.MODE_PRIVATE);
        customLayoutEditor_3 = customLayoutSharedPreference_3.edit();
        customLayoutSharedPreference_4 = context.getSharedPreferences("Custom Layout Pref 4",Context.MODE_PRIVATE);
        customLayoutEditor_4 = customLayoutSharedPreference_4.edit();
        customLayoutSharedPreference_5 = context.getSharedPreferences("Custom Layout Pref 5",Context.MODE_PRIVATE);
        customLayoutEditor_5 = customLayoutSharedPreference_5.edit();
        customLayoutSharedPreference_6 = context.getSharedPreferences("Custom Layout Pref 6",Context.MODE_PRIVATE);
        customLayoutEditor_6 = customLayoutSharedPreference_6.edit();
        customLayoutSharedPreference_7 = context.getSharedPreferences("Custom Layout Pref 7",Context.MODE_PRIVATE);
        customLayoutEditor_7 = customLayoutSharedPreference_7.edit();
        customLayoutSharedPreference_8 = context.getSharedPreferences("Custom Layout Pref 8",Context.MODE_PRIVATE);
        customLayoutEditor_8 = customLayoutSharedPreference_8.edit();
    }

    @SuppressLint("CommitPrefEdits")
    private void InitAppShortcuts(){
        appShortCut1 = context.getSharedPreferences("App Shortcut Pref 1",Context.MODE_PRIVATE);
        appShortCut1_Editor = appShortCut1.edit();
        appShortCut2 = context.getSharedPreferences("App Shortcut Pref 2",Context.MODE_PRIVATE);
        appShortCut2_Editor = appShortCut2.edit();
        appShortCut3 = context.getSharedPreferences("App Shortcut Pref 3",Context.MODE_PRIVATE);
        appShortCut3_Editor = appShortCut3.edit();
        appShortCut4 = context.getSharedPreferences("App Shortcut Pref 4",Context.MODE_PRIVATE);
        appShortCut4_Editor = appShortCut4.edit();
        appShortCut6 = context.getSharedPreferences("App Shortcut Pref 6",Context.MODE_PRIVATE);
        appShortCut6_Editor = appShortCut6.edit();
        appShortCut7 = context.getSharedPreferences("App Shortcut Pref 7",Context.MODE_PRIVATE);
        appShortCut7_Editor = appShortCut7.edit();
        appShortCut8 = context.getSharedPreferences("App Shortcut Pref 8",Context.MODE_PRIVATE);
        appShortCut8_Editor = appShortCut8.edit();
        appShortCut9 = context.getSharedPreferences("App Shortcut Pref 9",Context.MODE_PRIVATE);
        appShortCut9_Editor = appShortCut9.edit();
    }

    public int getItemCount(){
        return itemCount.getInt("Item Count",6);
    }

    public void setItemCount(int item_count){
        itemCountEditor.putInt("Item Count",item_count);
        itemCountEditor.apply();
    }

    public int getActionsPref1(){
        return customLayoutSharedPreference_1.getInt(context.getString(R.string.custom_action_1_1_key),2);
    }

    public void setActionsPref1(int action_num){
        customLayoutEditor_1.putInt(context.getString(R.string.custom_action_1_1_key),action_num);
        customLayoutEditor_1.apply();
    }

    public int getActionsPref2(){
        return customLayoutSharedPreference_2.getInt(context.getString(R.string.custom_action_1_2_key),4);
    }

    public void setActionsPref2(int action_num){
        customLayoutEditor_2.putInt(context.getString(R.string.custom_action_1_2_key),action_num);
        customLayoutEditor_2.apply();
    }

    public int getActionsPref3(){
        return customLayoutSharedPreference_3.getInt(context.getString(R.string.custom_action_1_3_key),6);
    }

    public void setActionsPref3(int action_num){
        customLayoutEditor_3.putInt(context.getString(R.string.custom_action_1_3_key),action_num);
        customLayoutEditor_3.apply();
    }

    public int getActionsPref4(){
        return customLayoutSharedPreference_4.getInt(context.getString(R.string.custom_action_1_4_key),1);
    }

    public void setActionsPref4(int action_num){
        customLayoutEditor_4.putInt(context.getString(R.string.custom_action_1_4_key),action_num);
        customLayoutEditor_4.apply();
    }

    public int getActionsPref5(){
        return customLayoutSharedPreference_5.getInt(context.getString(R.string.custom_action_1_5_key),0);
    }

    public void setActionsPref5(int action_num){
        customLayoutEditor_5.putInt(context.getString(R.string.custom_action_1_5_key),action_num);
        customLayoutEditor_5.apply();
    }

    public int getActionsPref6(){
        return customLayoutSharedPreference_6.getInt(context.getString(R.string.custom_action_1_6_key),5);
    }

    public void setActionsPref6(int action_num){
        customLayoutEditor_6.putInt(context.getString(R.string.custom_action_1_6_key),action_num);
        customLayoutEditor_6.apply();
    }

    public int getActionsPref7(){
        return customLayoutSharedPreference_7.getInt(context.getString(R.string.custom_action_1_7_key),3);
    }

    public void setActionsPref7(int action_num){
        customLayoutEditor_7.putInt(context.getString(R.string.custom_action_1_7_key),action_num);
        customLayoutEditor_7.apply();
    }

    public int getActionsPref8(){
        return customLayoutSharedPreference_8.getInt(context.getString(R.string.custom_action_1_8_key),3);
    }

    public void setActionsPref8(int action_num){
        customLayoutEditor_8.putInt(context.getString(R.string.custom_action_1_8_key),action_num);
        customLayoutEditor_8.apply();
    }

    public String getAppPref1(){
        return appShortCut1.getString(context.getString(R.string.app_shortcut_pref_key_1),"empty");
    }

    public void setAppPref1(String packageName){
        appShortCut1_Editor.putString(context.getString(R.string.app_shortcut_pref_key_1),packageName);
        appShortCut1_Editor.apply();
    }

    public String getAppPref2(){
        return appShortCut2.getString(context.getString(R.string.app_shortcut_pref_key_2),"empty");
    }

    public void setAppPref2(String packageName){
        appShortCut2_Editor.putString(context.getString(R.string.app_shortcut_pref_key_2),packageName);
        appShortCut2_Editor.apply();
    }

    public String getAppPref3(){
        return appShortCut3.getString(context.getString(R.string.app_shortcut_pref_key_3),"empty");
    }

    public void setAppPref3(String packageName){
        appShortCut3_Editor.putString(context.getString(R.string.app_shortcut_pref_key_3),packageName);
        appShortCut3_Editor.apply();
    }

    public String getAppPref4(){
        return appShortCut4.getString(context.getString(R.string.app_shortcut_pref_key_4),"empty");
    }

    public void setAppPref4(String packageName){
        appShortCut4_Editor.putString(context.getString(R.string.app_shortcut_pref_key_4),packageName);
        appShortCut4_Editor.apply();
    }


    public String getAppPref6(){
        return appShortCut6.getString(context.getString(R.string.app_shortcut_pref_key_6),"empty");
    }

    public void setAppPref6(String packageName){
        appShortCut6_Editor.putString(context.getString(R.string.app_shortcut_pref_key_6),packageName);
        appShortCut6_Editor.apply();
    }

    public String getAppPref7(){
        return appShortCut7.getString(context.getString(R.string.app_shortcut_pref_key_7),"empty");
    }

    public void setAppPref7(String packageName){
        appShortCut7_Editor.putString(context.getString(R.string.app_shortcut_pref_key_7),packageName);
        appShortCut7_Editor.apply();
    }

    public String getAppPref8(){
        return appShortCut8.getString(context.getString(R.string.app_shortcut_pref_key_8),"empty");
    }

    public void setAppPref8(String packageName){
        appShortCut8_Editor.putString(context.getString(R.string.app_shortcut_pref_key_8),packageName);
        appShortCut8_Editor.apply();
    }

    public String getAppPref9(){
        return appShortCut9.getString(context.getString(R.string.app_shortcut_pref_key_9),"empty");
    }

    public void setAppPref9(String packageName){
        appShortCut9_Editor.putString(context.getString(R.string.app_shortcut_pref_key_9),packageName);
        appShortCut9_Editor.apply();
    }

    public int getFlashLightState(){
        return flashLightState.getInt(context.getString(R.string.flash_light_pref_key),0);
    }

    public void setFlashLightState(int flashLight_State){
        flashLightState_Editor.putInt(context.getString(R.string.flash_light_pref_key),flashLight_State);
        flashLightState_Editor.apply();
    }

    public int getLongPressActionState(){
        return longPressPref.getInt(context.getString(R.string.long_press_action_pref_key),0);
    }

    public void setLongPressActionState(int long_press_action_state){
        longPressPref_Editor.putInt(context.getString(R.string.long_press_action_pref_key),long_press_action_state);
        longPressPref_Editor.apply();
    }

    public int getDoubleTapActionState(){
        return doubleTapPref.getInt(context.getString(R.string.double_tap_action_pref_key),0);
    }

    public void setDoubleTapActionState(int double_tap_action_state){
        doubleTapEditor.putInt(context.getString(R.string.double_tap_action_pref_key),double_tap_action_state);
        doubleTapEditor.apply();
    }

}
