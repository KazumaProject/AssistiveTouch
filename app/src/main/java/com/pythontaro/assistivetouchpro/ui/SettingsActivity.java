package com.pythontaro.assistivetouchpro.ui;

import android.annotation.SuppressLint;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SeekBarPreference;

import com.pythontaro.assistivetouchpro.R;
import com.pythontaro.assistivetouchpro.controller.ActivityController;
import com.pythontaro.assistivetouchpro.controller.PermissionController;
import com.pythontaro.assistivetouchpro.controller.ServiceController;
import com.pythontaro.assistivetouchpro.controller.SharedPreferenceController;
import com.pythontaro.assistivetouchpro.controller.TaskController;
import com.pythontaro.assistivetouchpro.custom.CListPreference;
import com.pythontaro.assistivetouchpro.custom.CPreference;
import com.pythontaro.assistivetouchpro.custom.CSeekbarPref;
import com.pythontaro.assistivetouchpro.custom.CSwitchCompat;

public class SettingsActivity extends AppCompatActivity {

    private PermissionController permissionController;
    private ServiceController serviceController;
    private ComponentName mAdminName;
    private DevicePolicyManager mDPM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
       init();
       ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (!permissionController.CanDisplayOverOtherApp() || !permissionController.CanSystemWrite()){
           finish();
       }
    }

    private void init(){
        permissionController = new PermissionController(this);
        serviceController = new ServiceController(this);
        permissionController.CheckCanDisplayOverOtherApp();
        permissionController.CheckCanSystemWrite();
        setActionBar();
        initViews();
    }

    @SuppressLint("WrongConstant")
    private void initViews() {
        this.mDPM = (DevicePolicyManager) getSystemService("device_policy");
        this.mAdminName = new ComponentName(this, TaskController.MyAdmin.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("adminRequired")) {
            Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
            intent.putExtra("android.app.extra.DEVICE_ADMIN", this.mAdminName);
            intent.putExtra("android.app.extra.ADD_EXPLANATION", getString(R.string.device_admin_description));
            startActivityForResult(intent, 1);
        }

        // StartSwitch.setChecked(false);
        //onOffService(false);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            finish();
        } else if (i != 12) {
        } else {

        }
    }

    private void setActionBar(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DarkWindow);
        builder.setMessage("Close app?");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SettingsActivity.super.onBackPressed();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {

        private ActivityController activityController;
        private ServiceController serviceController;
        private SharedPreferenceController sharedPreferenceController;
        private PermissionController permissionController;
        private View root;
        //Main Switch
        private CSwitchCompat mainSwitch;
        //Move to Customize Layout Activity
        private CPreference customizeLayoutActivityPref;
        //Icon Type List
        private CListPreference iconTypeList;
        //Animation Type List
        private CListPreference animationTypeList;
        //Speed List
        private CListPreference speedList;
        private CSeekbarPref seekBarPreference;
        private CSeekbarPref iconSizeSeekBarPreference;
        private CListPreference control_center_custom1;
        private CListPreference control_center_custom2;
        private CListPreference control_center_custom3;
        private CListPreference control_center_custom4;

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            root = super.onCreateView(inflater, container, savedInstanceState);
            init();
            setMainSwitch();
            setIconTypeList();
            setAnimationTypeList();
            setCustomizeLayoutActivityPref();
            setSpeedList();
            setIconSizeSeekBar();
            setSeekBarPreference();
            setControlCenterCustoms();

            if (sharedPreferenceController.GetMainSwitchState() && permissionController.CanDisplayOverOtherApp() && permissionController.CanSystemWrite()){
                serviceController.StartService();
            }
            return root;
        }

        private void init(){
            activityController = new ActivityController(requireContext());
            serviceController = new ServiceController(requireContext());
            sharedPreferenceController = new SharedPreferenceController(requireContext());
            permissionController = new PermissionController(requireContext());

            mainSwitch = findPreference(getString(R.string.main_switch_key));
            customizeLayoutActivityPref = findPreference(getString(R.string.layout_key));
            iconTypeList = findPreference(getString(R.string.icon_type_list_key));
            animationTypeList = findPreference(getString(R.string.animation_type_list_key));
            speedList = findPreference(getString(R.string.speed_key));
            seekBarPreference = findPreference("IdleOpacityKey");
            iconSizeSeekBarPreference = findPreference("iconSizeKey");

            control_center_custom1 = findPreference("Control Center Custom 1");
            control_center_custom2 = findPreference("Control Center Custom 2");
            control_center_custom3 = findPreference("Control Center Custom 3");
            control_center_custom4 = findPreference("Control Center Custom 4");

            if (root != null) {
                root.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.black));
            }

        }

        private void setMainSwitch(){
            mainSwitch.setTitle("Assistive Touch");

            mainSwitch.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    boolean newValueBool = (boolean) newValue;
                    if (newValueBool){
                        mainSwitch.setTitle("Assistive Touch");
                        startServiceChecked();
                    }else {
                        mainSwitch.setTitle("Assistive Touch");
                        serviceController.stopMainService();
                    }
                    return true;
                }
            });
        }

        private void startServiceChecked(){
            if (permissionController.CanSystemWrite()&&permissionController.CanDisplayOverOtherApp()){
                serviceController.StartService();
            }else if (!permissionController.CanSystemWrite()){
                permissionController.CheckCanSystemWrite();
            }else if (!permissionController.CanDisplayOverOtherApp()){
                permissionController.CheckCanDisplayOverOtherApp();
            }else if (!permissionController.CanSystemWrite() && !permissionController.CanDisplayOverOtherApp()){
                permissionController.CheckCanDisplayOverOtherApp();
                permissionController.CheckCanSystemWrite();
            }
        }

        private void setCustomizeLayoutActivityPref(){
            customizeLayoutActivityPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    activityController.MoveToCustomizeLayoutActivity(R.anim.slide_in_right,R.anim.slide_out_left);
                    return true;
                }
            });
        }

        private void setIconTypeList(){
            switch (iconType()){
                case "Circle":
                    iconTypeList.setTitle("Icon Type");
                    iconTypeList.setSummary("Current: Circle");
                    break;
                case "Square":
                    iconTypeList.setTitle("Icon Type");
                    iconTypeList.setSummary("Current: Square");
                    break;
            }

            iconTypeList.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    String newValueStr = (String) newValue;
                    switch (newValueStr){
                        case "Circle":
                            iconTypeList.setTitle("Icon Type");
                            iconTypeList.setSummary("Current: Circle");
                            break;
                        case "Square":
                            iconTypeList.setTitle("Icon Type");
                            iconTypeList.setSummary("Current: Square");
                            break;
                    }
                    serviceController.restartService();
                    return true;
                }
            });
        }

        private void setAnimationTypeList(){
            switch (animationType()){
                case "Default":
                    animationTypeList.setTitle("Window Animation Type");
                    animationTypeList.setSummary("Current: Default");
                    break;
                case "Slide In":
                    animationTypeList.setTitle("Window Animation Type");
                    animationTypeList.setSummary("Current: Slide in");
                    break;
            }

            animationTypeList.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    String newValueStr = (String) newValue;
                    switch (newValueStr){
                        case "Default":
                            animationTypeList.setTitle("Window Animation Type");
                            animationTypeList.setSummary("Current: Default");
                            break;
                        case "Slide In":
                            animationTypeList.setTitle("Window Animation Type");
                            animationTypeList.setSummary("Current: Slide in");
                            break;
                    }
                    serviceController.restartService();
                    return true;
                }
            });
        }

        private void setSpeedList(){
            switch (speedType()){
                case "Default":
                    speedList.setTitle("Icon Move Speed");
                    speedList.setSummary("Current: Default");
                    break;
                case "Medium":
                    speedList.setTitle("Icon Move Speed");
                    speedList.setSummary("Current: Medium");
                    break;
                case "Slow":
                    speedList.setTitle("Icon Move Speed");
                    speedList.setSummary("Current: Slow");
                    break;
            }

            speedList.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    String newValueStr = (String) newValue;
                    switch (newValueStr){
                        case "Default":
                            speedList.setTitle("Icon Move Speed");
                            speedList.setSummary("Current: Default");
                            break;
                        case "Medium":
                            speedList.setTitle("Icon Move Speed");
                            speedList.setSummary("Current: Medium");
                            break;
                        case "Slow":
                            speedList.setTitle("Icon Move Speed");
                            speedList.setSummary("Current: Slow");
                            break;
                    }
                    serviceController.restartService();
                    return true;
                }
            });
        }

        private void setIconSizeSeekBar(){
            switch (sharedPreferenceController.getIconSize()){
                case 1:
                    iconSizeSeekBarPreference.setSummary("Size: default (145 px)");
                    break;
                case 2:
                    iconSizeSeekBarPreference.setSummary("Size: default (155 px)");
                    break;
                case 3:
                    iconSizeSeekBarPreference.setSummary("Size: default (175 px)");
                    break;
                case 4:
                    iconSizeSeekBarPreference.setSummary("Size: default (185 px)");
                    break;
                case 5:
                    iconSizeSeekBarPreference.setSummary("Size: default (200 px)");
                    break;
                default:
                    iconSizeSeekBarPreference.setSummary("Size: default (128 px)");
                    break;
            }

            iconSizeSeekBarPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {

                    int newValueInt = (int) newValue;

                    switch (newValueInt){
                        case 1:
                            iconSizeSeekBarPreference.setSummary("Size: default (145 px)");
                            break;
                        case 2:
                            iconSizeSeekBarPreference.setSummary("Size: default (155 px)");
                            break;
                        case 3:
                            iconSizeSeekBarPreference.setSummary("Size: default (175 px)");
                            break;
                        case 4:
                            iconSizeSeekBarPreference.setSummary("Size: default (185 px)");
                            break;
                        case 5:
                            iconSizeSeekBarPreference.setSummary("Size: default (200 px)");
                            break;
                        default:
                            iconSizeSeekBarPreference.setSummary("Size: default (128 px)");
                            break;
                    }

                    serviceController.restartService();
                    return true;
                }
            });
        }

        private void setSeekBarPreference(){

            switch (sharedPreferenceController.getIdleOpacity()){
                case 0:
                    seekBarPreference.setSummary("Opacity: 0");
                    break;
                case 1:
                    seekBarPreference.setSummary("Opacity: 0.1");
                    break;
                case 2:
                    seekBarPreference.setSummary("Opacity: 0.2");
                    break;
                case 3:
                    seekBarPreference.setSummary("Opacity: 0.3");
                    break;
                case 4:
                    seekBarPreference.setSummary("Opacity: 0.4");
                    break;
                default:
                case 5:
                    seekBarPreference.setSummary("Opacity: 0.5");
                    break;
                case 6:
                    seekBarPreference.setSummary("Opacity: 0.6");
                    break;
                case 7:
                    seekBarPreference.setSummary("Opacity: 0.7");
                    break;
                case 8:
                    seekBarPreference.setSummary("Opacity: 0.8");
                    break;
                case 9:
                    seekBarPreference.setSummary("Opacity: 0.9");
                    break;
                case 10:
                    seekBarPreference.setSummary("Opacity: 1");
                    break;
            }

            seekBarPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    Log.d("Seek bar", String.valueOf(newValue));

                    int newValueStr = (int) newValue;

                    switch (newValueStr){
                        case 0:
                            preference.setSummary("Opacity: 0");
                            break;
                        case 1:
                            preference.setSummary("Opacity: 0.1");
                            break;
                        case 2:
                            preference.setSummary("Opacity: 0.2");
                            break;
                        case 3:
                            preference.setSummary("Opacity: 0.3");
                            break;
                        case 4:
                            preference.setSummary("Opacity: 0.4");
                            break;
                        default:
                        case 5:
                            preference.setSummary("Opacity: 0.5");
                            break;
                        case 6:
                            preference.setSummary("Opacity: 0.6");
                            break;
                        case 7:
                            preference.setSummary("Opacity: 0.7");
                            break;
                        case 8:
                            preference.setSummary("Opacity: 0.8");
                            break;
                        case 9:
                            preference.setSummary("Opacity: 0.9");
                            break;
                        case 10:
                            preference.setSummary("Opacity: 1");
                            break;
                    }

                    serviceController.restartService();
                    return true;
                }
            });
        }

        private void setControlCenterCustoms(){
            switch (sharedPreferenceController.getControlCenterPref1()){
                default:
                case "0":
                    control_center_custom1.setSummary("None");
                    break;
                case "1":
                    control_center_custom1.setSummary("Flash");
                    break;
                case "2":
                    control_center_custom1.setSummary("Split Window");
                    break;
                case "3":
                    control_center_custom1.setSummary("Volume");
                    break;
                case "4":
                    control_center_custom1.setSummary("Camera");
                    break;
                case "5":
                    control_center_custom1.setSummary("Setting");
                    break;
            }
            control_center_custom1.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    String newValueStr = (String) newValue;
                    switch (newValueStr){
                        default:
                        case "0":
                            control_center_custom1.setSummary("None");
                            break;
                        case "1":
                            control_center_custom1.setSummary("Flash");
                            break;
                        case "2":
                            control_center_custom1.setSummary("Split Window");
                            break;
                        case "3":
                            control_center_custom1.setSummary("Volume");
                            break;
                        case "4":
                            control_center_custom1.setSummary("Camera");
                            break;
                        case "5":
                            control_center_custom1.setSummary("Setting");
                            break;
                    }
                    serviceController.restartService();
                    return true;
                }
            });

            switch (sharedPreferenceController.getControlCenterPref2()){
                default:
                case "0":
                    control_center_custom2.setSummary("None");
                    break;
                case "1":
                    control_center_custom2.setSummary("Flash");
                    break;
                case "2":
                    control_center_custom2.setSummary("Split Window");
                    break;
                case "3":
                    control_center_custom2.setSummary("Volume");
                    break;
                case "4":
                    control_center_custom2.setSummary("Camera");
                    break;
                case "5":
                    control_center_custom2.setSummary("Setting");
                    break;
            }
            control_center_custom2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    String newValueStr = (String) newValue;
                    switch (newValueStr){
                        default:
                        case "0":
                            control_center_custom2.setSummary("None");
                            break;
                        case "1":
                            control_center_custom2.setSummary("Flash");
                            break;
                        case "2":
                            control_center_custom2.setSummary("Split Window");
                            break;
                        case "3":
                            control_center_custom2.setSummary("Volume");
                            break;
                        case "4":
                            control_center_custom2.setSummary("Camera");
                            break;
                        case "5":
                            control_center_custom2.setSummary("Setting");
                            break;
                    }
                    serviceController.restartService();
                    return true;
                }
            });

            switch (sharedPreferenceController.getControlCenterPref3()){
                default:
                case "0":
                    control_center_custom3.setSummary("None");
                    break;
                case "1":
                    control_center_custom3.setSummary("Flash");
                    break;
                case "2":
                    control_center_custom3.setSummary("Split Window");
                    break;
                case "3":
                    control_center_custom3.setSummary("Volume");
                    break;
                case "4":
                    control_center_custom3.setSummary("Camera");
                    break;
                case "5":
                    control_center_custom3.setSummary("Setting");
                    break;
            }
            control_center_custom3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    String newValueStr = (String) newValue;
                    switch (newValueStr){
                        default:
                        case "0":
                            control_center_custom3.setSummary("None");
                            break;
                        case "1":
                            control_center_custom3.setSummary("Flash");
                            break;
                        case "2":
                            control_center_custom3.setSummary("Split Window");
                            break;
                        case "3":
                            control_center_custom3.setSummary("Volume");
                            break;
                        case "4":
                            control_center_custom3.setSummary("Camera");
                            break;
                        case "5":
                            control_center_custom3.setSummary("Setting");
                            break;
                    }
                    serviceController.restartService();
                    return true;
                }
            });

            switch (sharedPreferenceController.getControlCenterPref4()){
                default:
                case "0":
                    control_center_custom4.setSummary("None");
                    break;
                case "1":
                    control_center_custom4.setSummary("Flash");
                    break;
                case "2":
                    control_center_custom4.setSummary("Split Window");
                    break;
                case "3":
                    control_center_custom4.setSummary("Volume");
                    break;
                case "4":
                    control_center_custom4.setSummary("Camera");
                    break;
                case "5":
                    control_center_custom4.setSummary("Setting");
                    break;
            }
            control_center_custom4.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    String newValueStr = (String) newValue;
                    switch (newValueStr){
                        default:
                        case "0":
                            control_center_custom4.setSummary("None");
                            break;
                        case "1":
                            control_center_custom4.setSummary("Flash");
                            break;
                        case "2":
                            control_center_custom4.setSummary("Split Window");
                            break;
                        case "3":
                            control_center_custom4.setSummary("Volume");
                            break;
                        case "4":
                            control_center_custom4.setSummary("Camera");
                            break;
                        case "5":
                            control_center_custom4.setSummary("Setting");
                            break;
                    }
                    serviceController.restartService();
                    return true;
                }
            });
        }

        private String iconType(){
            return sharedPreferenceController.GetIconType();
        }

        private String animationType(){
            return sharedPreferenceController.GetAnimationType();
        }

        private String speedType(){
            return sharedPreferenceController.GetSpeed();
        }
    }
}