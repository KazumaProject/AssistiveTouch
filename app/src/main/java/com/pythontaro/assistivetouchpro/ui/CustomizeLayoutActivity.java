package com.pythontaro.assistivetouchpro.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pythontaro.assistivetouchpro.R;
import com.pythontaro.assistivetouchpro.controller.ActivityController;
import com.pythontaro.assistivetouchpro.controller.ServiceController;
import com.pythontaro.assistivetouchpro.controller.SharedPreferenceController;

public class CustomizeLayoutActivity extends AppCompatActivity {

    private ActivityController activityController;
    private SharedPreferenceController sharedPreferenceController;
    private ServiceController serviceController;

    private TextView itemCount;
    private ImageView arrow_plus;
    private ImageView arrow_minus;

    //Item 1
    private View item1;
    private ImageButton btn_1_1;
    private TextView text_1_1;

    //Item 2
    private View item2;
    private ImageButton btn_1_2;
    private ImageButton btn_2_2;
    private TextView text_1_2;
    private TextView text_2_2;

    //Item 3
    private View item3;
    private ImageButton btn_1_3;
    private ImageButton btn_2_3;
    private ImageButton btn_3_3;
    private TextView text_1_3;
    private TextView text_2_3;
    private TextView text_3_3;

    //Item 4
    private View item4;
    private ImageButton btn_1_4;
    private ImageButton btn_2_4;
    private ImageButton btn_3_4;
    private ImageButton btn_4_4;
    private TextView text_1_4;
    private TextView text_2_4;
    private TextView text_3_4;
    private TextView text_4_4;

    //Item 5
    private View item5;

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

    //Item 6
    private View item6;

    private ImageButton btn_1;
    private ImageButton btn_2;
    private ImageButton btn_3;
    private ImageButton btn_4;
    private ImageButton btn_5;
    private ImageButton btn_6;
    private ImageButton btn_7;

    private TextView text_1;
    private TextView text_2;
    private TextView text_3;
    private TextView text_4;
    private TextView text_6;
    private TextView text_7;

    //Item 7
    private View item7;

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
    private View item8;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_layout);
        init();

        setItemCount();
        setActionBar();

        setViewsInit();

        setInitActionIcons1();
        setBtnClickListener1();

        setInitActionIcons2();
        setBtnClickListener2();

        setInitActionIcons3();
        setBtnClickListener3();

        setInitActionIcons4();
        setBtnClickListener4();

        setInitActionIcons5();
        setBtnClickListener5();

        setInitActionIcons();
        setBtnClickListener();

        setInitActionIcons7();
        setBtnClickListener7();

        setInitActionIcons8();
        setBtnClickListener8();

    }

    private void setViewsInit(){
        switch (sharedPreferenceController.getItemCount()){
            case 1:
                item1.setVisibility(View.VISIBLE);
                item2.setVisibility(View.GONE);
                item3.setVisibility(View.GONE);
                item4.setVisibility(View.GONE);
                item5.setVisibility(View.GONE);
                item6.setVisibility(View.GONE);
                item7.setVisibility(View.GONE);
                item8.setVisibility(View.GONE);
                break;
            case 2:
                item1.setVisibility(View.GONE);
                item2.setVisibility(View.VISIBLE);
                item3.setVisibility(View.GONE);
                item4.setVisibility(View.GONE);
                item5.setVisibility(View.GONE);
                item6.setVisibility(View.GONE);
                item7.setVisibility(View.GONE);
                item8.setVisibility(View.GONE);
                break;
            case 3:
                item1.setVisibility(View.GONE);
                item2.setVisibility(View.GONE);
                item3.setVisibility(View.VISIBLE);
                item4.setVisibility(View.GONE);
                item5.setVisibility(View.GONE);
                item6.setVisibility(View.GONE);
                item7.setVisibility(View.GONE);
                item8.setVisibility(View.GONE);
                break;
            case 4:
                item1.setVisibility(View.GONE);
                item2.setVisibility(View.GONE);
                item3.setVisibility(View.GONE);
                item4.setVisibility(View.VISIBLE);
                item5.setVisibility(View.GONE);
                item6.setVisibility(View.GONE);
                item7.setVisibility(View.GONE);
                item8.setVisibility(View.GONE);
                break;
            case 5:
                item1.setVisibility(View.GONE);
                item2.setVisibility(View.GONE);
                item3.setVisibility(View.GONE);
                item5.setVisibility(View.VISIBLE);
                item6.setVisibility(View.GONE);
                item7.setVisibility(View.GONE);
                item8.setVisibility(View.GONE);
                break;
            default:
            case 6:
                item1.setVisibility(View.GONE);
                item2.setVisibility(View.GONE);
                item3.setVisibility(View.GONE);
                item5.setVisibility(View.GONE);
                item6.setVisibility(View.VISIBLE);
                item7.setVisibility(View.GONE);
                item8.setVisibility(View.GONE);
                break;
            case 7:
                item1.setVisibility(View.GONE);
                item2.setVisibility(View.GONE);
                item3.setVisibility(View.GONE);
                item5.setVisibility(View.GONE);
                item6.setVisibility(View.GONE);
                item7.setVisibility(View.VISIBLE);
                item8.setVisibility(View.GONE);
                break;
            case 8:
                item1.setVisibility(View.GONE);
                item2.setVisibility(View.GONE);
                item3.setVisibility(View.GONE);
                item5.setVisibility(View.GONE);
                item6.setVisibility(View.GONE);
                item7.setVisibility(View.GONE);
                item8.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        activityController.MoveToSettingActivity(R.anim.slide_in_left,R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            activityController.MoveToSettingActivity(R.anim.slide_in_left, R.anim.slide_out_right);
        }
        return super.onOptionsItemSelected(item);
    }

    private void init(){
        activityController = new ActivityController(this);
        sharedPreferenceController = new SharedPreferenceController(this);
        serviceController = new ServiceController(this);

        itemCount = findViewById(R.id.itemCount_Text);
        arrow_plus = findViewById(R.id.arrow_plus);
        arrow_minus = findViewById(R.id.arrow_minus);

        // Item 1
        item1 = findViewById(R.id.item_1);
        btn_1_1 = findViewById(R.id.center_1_item_img);
        text_1_1 = findViewById(R.id.center_1_text);

        // Item 2
        item2 = findViewById(R.id.item_2);
        btn_1_2 = findViewById(R.id.item_1_2_img);
        btn_2_2 = findViewById(R.id.item_2_2_img);
        text_1_2 = findViewById(R.id.item_1_2_text);
        text_2_2 = findViewById(R.id.item_2_2_text);

        // Item 3
        item3 = findViewById(R.id.item_3);
        btn_1_3 = findViewById(R.id.item_1_3_img);
        btn_2_3 = findViewById(R.id.item_2_3_img);
        btn_3_3 = findViewById(R.id.item_3_3_img);
        text_1_3 = findViewById(R.id.item_1_3_text);
        text_2_3 = findViewById(R.id.item_2_3_text);
        text_3_3 = findViewById(R.id.item_3_3_text);

        // Item 4
        item4 = findViewById(R.id.item_4);
        btn_1_4 = findViewById(R.id.item_1_4_img);
        btn_2_4 = findViewById(R.id.item_2_4_img);
        btn_3_4 = findViewById(R.id.item_3_4_img);
        btn_4_4 = findViewById(R.id.item_4_4_img);
        text_1_4 = findViewById(R.id.item_1_4_text);
        text_2_4 = findViewById(R.id.item_2_4_text);
        text_3_4 = findViewById(R.id.item_3_4_text);
        text_4_4 = findViewById(R.id.item_4_4_text);

        //item 5
        item5 = findViewById(R.id.item_5);
        btn_1_5 = findViewById(R.id.item_1_5_img);
        btn_2_5 = findViewById(R.id.item_2_5_img);
        btn_3_5 = findViewById(R.id.item_3_5_img);
        btn_4_5 = findViewById(R.id.item_4_5_img);
        btn_5_5 = findViewById(R.id.item_5_5_img);
        text_1_5 = findViewById(R.id.item_1_5_text);
        text_2_5 = findViewById(R.id.item_2_5_text);
        text_3_5 = findViewById(R.id.item_3_5_text);
        text_4_5 = findViewById(R.id.item_4_5_text);
        text_5_5 = findViewById(R.id.item_5_5_text);

        //Item 6
        item6 = findViewById(R.id.item_6_default);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        text_1 = findViewById(R.id.text_1);
        text_2 = findViewById(R.id.text_2);
        text_3 = findViewById(R.id.text_3);
        text_4 = findViewById(R.id.text_4);
        text_6 = findViewById(R.id.text_6);
        text_7 = findViewById(R.id.text_7);

        //Item 7
        item7 = findViewById(R.id.item_7);
        btn_1_7 = findViewById(R.id.item_1_7_img);
        btn_2_7 = findViewById(R.id.item_2_7_img);
        btn_3_7 = findViewById(R.id.item_3_7_img);
        btn_4_7 = findViewById(R.id.item_4_7_img);
        btn_5_7 = findViewById(R.id.item_5_7_img);
        btn_6_7 = findViewById(R.id.item_6_7_img);
        btn_7_7 = findViewById(R.id.item_7_7_img);
        text_1_7 = findViewById(R.id.item_1_7_text);
        text_2_7 = findViewById(R.id.item_2_7_text);
        text_3_7 = findViewById(R.id.item_3_7_text);
        text_4_7 = findViewById(R.id.item_4_7_text);
        text_5_7 = findViewById(R.id.item_5_7_text);
        text_6_7 = findViewById(R.id.item_6_7_text);
        text_7_7 = findViewById(R.id.item_7_7_text);

        //Item 8
        item8 = findViewById(R.id.item_8);
        btn_1_8 = findViewById(R.id.item_1_8_img);
        btn_2_8 = findViewById(R.id.item_2_8_img);
        btn_3_8 = findViewById(R.id.item_3_8_img);
        btn_4_8 = findViewById(R.id.item_4_8_img);
        btn_5_8 = findViewById(R.id.item_5_8_img);
        btn_6_8 = findViewById(R.id.item_6_8_img);
        btn_7_8 = findViewById(R.id.item_7_8_img);
        btn_8_8 = findViewById(R.id.item_8_8_img);
        text_1_8 = findViewById(R.id.item_1_8_text);
        text_2_8 = findViewById(R.id.item_2_8_text);
        text_3_8 = findViewById(R.id.item_3_8_text);
        text_4_8 = findViewById(R.id.item_4_8_text);
        text_5_8 = findViewById(R.id.item_5_8_text);
        text_6_8 = findViewById(R.id.item_6_8_text);
        text_7_8 = findViewById(R.id.item_7_8_text);
        text_8_8 = findViewById(R.id.item_8_8_text);
    }

    private void restartService(){
        serviceController.restartService();
    }

    private void restartActivity(){
        Intent intent = new Intent(this,CustomizeLayoutActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();
        startActivity(intent);
        overridePendingTransition(0,0);
    }

    private void setItemCount(){
        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

        arrow_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (sharedPreferenceController.getItemCount()){
                    case 1:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() + 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.VISIBLE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.GONE);

                        restartService();
                        restartActivity();
                        break;
                    case 2:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() + 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.VISIBLE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.GONE);

                        restartService();
                        restartActivity();
                        break;
                    case 3:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() + 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.VISIBLE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.GONE);

                        restartService();
                        restartActivity();
                        break;
                    case 4:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() + 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.VISIBLE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.GONE);

                        restartService();
                        restartActivity();
                        break;
                    case 5:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() + 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.VISIBLE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.GONE);

                        restartService();
                        restartActivity();
                        break;
                    case 6:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() + 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.VISIBLE);
                        item8.setVisibility(View.GONE);

                        restartService();
                        restartActivity();
                        break;
                    case 7:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() + 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.VISIBLE);

                        restartService();
                        restartActivity();
                        break;
                    case 8:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount());
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.GONE);
                        break;
                }
            }
        });

        arrow_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (sharedPreferenceController.getItemCount()){
                    case 1:
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.VISIBLE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.GONE);

                        break;
                    case 2:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() - 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.VISIBLE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.GONE);

                        sharedPreferenceController.setActionsPref2(0);
                        restartService();
                        restartActivity();
                        break;
                    case 3:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() - 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.VISIBLE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.GONE);

                        sharedPreferenceController.setActionsPref3(0);
                        restartService();
                        restartActivity();
                        break;
                    case 4:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() - 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.VISIBLE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.GONE);

                        sharedPreferenceController.setActionsPref4(0);
                        restartService();
                        restartActivity();
                        break;
                    case 5:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() - 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.VISIBLE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.GONE);

                        sharedPreferenceController.setActionsPref5(0);
                        restartService();
                        restartActivity();
                        break;
                    case 6:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() - 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.VISIBLE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.GONE);

                        sharedPreferenceController.setActionsPref6(0);
                        restartService();
                        restartActivity();
                        break;
                    case 7:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() - 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.VISIBLE);
                        item7.setVisibility(View.GONE);
                        item8.setVisibility(View.GONE);

                        sharedPreferenceController.setActionsPref7(0);
                        restartService();
                        restartActivity();
                        break;
                    case 8:
                        sharedPreferenceController.setItemCount(sharedPreferenceController.getItemCount() - 1);
                        itemCount.setText(String.valueOf(sharedPreferenceController.getItemCount()));

                        item1.setVisibility(View.GONE);
                        item2.setVisibility(View.GONE);
                        item3.setVisibility(View.GONE);
                        item4.setVisibility(View.GONE);
                        item5.setVisibility(View.GONE);
                        item6.setVisibility(View.GONE);
                        item7.setVisibility(View.VISIBLE);
                        item8.setVisibility(View.GONE);

                        sharedPreferenceController.setActionsPref8(0);
                        restartService();
                        restartActivity();
                        break;
                }
            }
        });
    }

    private void setInitActionIcons1(){
        switch (pref_1_action()){
            case 0:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_1_1);
                text_1_1.setText(getString(R.string.None));
                break;
            case 1:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_1_1);
                text_1_1.setText(getString(R.string.Home));
                break;
            case 2:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_1_1);
                text_1_1.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_1_1);
                text_1_1.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_1_1);
                text_1_1.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_1_1);
                text_1_1.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_1_1);
                text_1_1.setText(getString(R.string.Device));
                break;
            case 7:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.screen_shot));
                setScaleOne(btn_1_1);
                text_1_1.setText(getText(R.string.screenshot));
                sharedPreferenceController.setActionsPref1(7);
                break;
            case 8:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.record1));
                setScaleOne(btn_1_1);
                text_1_1.setText(getText(R.string.screen_nrecording));
                sharedPreferenceController.setActionsPref1(8);
                break;
            case 9:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_boost_large_1));
                setScaleOne(btn_1_1);
                text_1_1.setText(getText(R.string.boost));
                sharedPreferenceController.setActionsPref1(9);
                break;
            case 10:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_1_1);
                text_1_1.setText(getText(R.string.lock_nscreen));
                sharedPreferenceController.setActionsPref1(10);
                break;
            case 11:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_1_1);
                text_1_1.setText(getText(R.string.power));
                sharedPreferenceController.setActionsPref1(11);
                break;
            case 12:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.control_center));
                setScaleOne(btn_1_1);
                text_1_1.setText(getText(R.string.open_nstatusbar));
                sharedPreferenceController.setActionsPref1(12);
                break;
            case 13:
                btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_recent_white));
                setScaleOne(btn_1_1);
                text_1_1.setText(getText(R.string.recent));
                sharedPreferenceController.setActionsPref1(13);
                break;
        }
    }
    
    private void setInitActionIcons2(){
        switch (pref_1_action()){
            case 0:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_1_2);
                text_1_2.setText(getString(R.string.None));
                break;
            case 1:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_1_2);
                text_1_2.setText(getString(R.string.Home));
                break;
            case 2:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_1_2);
                text_1_2.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_1_2);
                text_1_2.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_1_2);
                text_1_2.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_1_2);
                text_1_2.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_1_2);
                text_1_2.setText(getString(R.string.Device));
                break;
            case 7:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.screen_shot));
                setScaleOne(btn_1_2);
                text_1_2.setText(getText(R.string.screenshot));
                break;
            case 8:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.record1));
                setScaleOne(btn_1_2);
                text_1_2.setText(getText(R.string.screen_nrecording));
                break;
            case 9:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_boost_large_1));
                setScaleOne(btn_1_2);
                text_1_2.setText(getText(R.string.boost));
                break;
            case 10:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_1_2);
                text_1_2.setText(getText(R.string.lock_nscreen));
                break;
            case 11:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_1_2);
                text_1_2.setText(getText(R.string.power));
                break;
            case 12:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.control_center));
                setScaleOne(btn_1_2);
                text_1_2.setText(getText(R.string.open_nstatusbar));
                break;
            case 13:
                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_recent_white));
                setScaleOne(btn_1_2);
                text_1_2.setText(getText(R.string.recent));
                break;
        }

        switch (pref_2_action()){
            case 0:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_2_2);
                text_2_2.setText(getString(R.string.None));
                break;
            case 1:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_2_2);
                text_2_2.setText(getString(R.string.Home));
                break;
            case 2:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_2_2);
                text_2_2.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_2_2);
                text_2_2.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_2_2);
                text_2_2.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_2_2);
                text_2_2.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_2_2);
                text_2_2.setText(getString(R.string.Device));
                break;
            case 7:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.screen_shot));
                setScaleOne(btn_2_2);
                text_2_2.setText(getText(R.string.screenshot));
                break;
            case 8:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.record1));
                setScaleOne(btn_2_2);
                text_2_2.setText(getText(R.string.screen_nrecording));
                break;
            case 9:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_boost_large_1));
                setScaleOne(btn_2_2);
                text_2_2.setText(getText(R.string.boost));
                break;
            case 10:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_2_2);
                text_2_2.setText(getText(R.string.lock_nscreen));
                break;
            case 11:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_2_2);
                text_2_2.setText(getText(R.string.power));
                break;
            case 12:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.control_center));
                setScaleOne(btn_2_2);
                text_2_2.setText(getText(R.string.open_nstatusbar));
                break;
            case 13:
                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_recent_white));
                setScaleOne(btn_2_2);
                text_2_2.setText(getText(R.string.recent));
                break;
        }

    }

    private void setInitActionIcons3(){
        switch (pref_1_action()){
            case 0:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_1_3);
                text_1_3.setText(getString(R.string.None));
                break;
            case 1:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_1_3);
                text_1_3.setText(getString(R.string.Home));
                break;
            case 2:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_1_3);
                text_1_3.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_1_3);
                text_1_3.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_1_3);
                text_1_3.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_1_3);
                text_1_3.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_1_3);
                text_1_3.setText(getString(R.string.Device));
                break;
            case 7:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_1_3);
                text_1_3.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_1_3);
                text_1_3.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_1_3);
                text_1_3.setText(getString(R.string.boost));
                break;
            case 10:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_1_3);
                text_1_3.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_1_3);
                text_1_3.setText(getString(R.string.power));
                break;
            case 12:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_1_3);
                text_1_3.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_1_3);
                text_1_3.setText(getString(R.string.recent));
                break;
        }

        switch (pref_2_action()){
            case 0:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_2_3);
                text_2_3.setText(getString(R.string.None));
                break;
            case 1:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_2_3);
                text_2_3.setText(getString(R.string.Home));
                break;
            case 2:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_2_3);
                text_2_3.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_2_3);
                text_2_3.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_2_3);
                text_2_3.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_2_3);
                text_2_3.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_2_3);
                text_2_3.setText(getString(R.string.Device));
                break;
            case 7:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_2_3);
                text_2_3.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_2_3);
                text_2_3.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_2_3);
                text_2_3.setText(getString(R.string.boost));
                break;
            case 10:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_2_3);
                text_2_3.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_2_3);
                text_2_3.setText(getString(R.string.power));
                break;
            case 12:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_2_3);
                text_2_3.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_2_3);
                text_2_3.setText(getString(R.string.recent));
                break;
        }

        switch (pref_3_action()){
            case 0:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_3_3);
                text_3_3.setText(getString(R.string.None));
                break;
            case 1:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_3_3);
                text_3_3.setText(getString(R.string.Home));
                break;
            case 2:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_3_3);
                text_3_3.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_3_3);
                text_3_3.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_3_3);
                text_3_3.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_3_3);
                text_3_3.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_3_3);
                text_3_3.setText(getString(R.string.Device));
                break;
            case 7:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_3_3);
                text_3_3.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_3_3);
                text_3_3.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_3_3);
                text_3_3.setText(getString(R.string.boost));
                break;
            case 10:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_3_3);
                text_3_3.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_3_3);
                text_3_3.setText(getString(R.string.power));
                break;
            case 12:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_3_3);
                text_3_3.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_3_3);
                text_3_3.setText(getString(R.string.recent));
                break;
        }
        
    }

    private void setInitActionIcons4(){
        switch (pref_1_action()){
            case 0:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_1_4);
                text_1_4.setText(getString(R.string.None));
                break;
            case 1:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_1_4);
                text_1_4.setText(getString(R.string.Home));
                break;
            case 2:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_1_4);
                text_1_4.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_1_4);
                text_1_4.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_1_4);
                text_1_4.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_1_4);
                text_1_4.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_1_4);
                text_1_4.setText(getString(R.string.Device));
                break;
            case 7:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_1_4);
                text_1_4.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_1_4);
                text_1_4.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_1_4);
                text_1_4.setText(getString(R.string.boost));
                break;
            case 10:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_1_4);
                text_1_4.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_1_4);
                text_1_4.setText(getString(R.string.power));
                break;
            case 12:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_1_4);
                text_1_4.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_1_4);
                text_1_4.setText(getString(R.string.recent));
                break;
        }

        switch (pref_2_action()){
            case 0:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_2_4);
                text_2_4.setText(getString(R.string.None));
                break;
            case 1:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_2_4);
                text_2_4.setText(getString(R.string.Home));
                break;
            case 2:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_2_4);
                text_2_4.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_2_4);
                text_2_4.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_2_4);
                text_2_4.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_2_4);
                text_2_4.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_2_4);
                text_2_4.setText(getString(R.string.Device));
                break;
            case 7:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_2_4);
                text_2_4.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_2_4);
                text_2_4.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_2_4);
                text_2_4.setText(getString(R.string.boost));
                break;
            case 10:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_2_4);
                text_2_4.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_2_4);
                text_2_4.setText(getString(R.string.power));
                break;
            case 12:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_2_4);
                text_2_4.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_2_4);
                text_2_4.setText(getString(R.string.recent));
                break;
        }

        switch (pref_3_action()){
            case 0:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_3_4);
                text_3_4.setText(getString(R.string.None));
                break;
            case 1:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_3_4);
                text_3_4.setText(getString(R.string.Home));
                break;
            case 2:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_3_4);
                text_3_4.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_3_4);
                text_3_4.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_3_4);
                text_3_4.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_3_4);
                text_3_4.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_3_4);
                text_3_4.setText(getString(R.string.Device));
                break;
            case 7:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_3_4);
                text_3_4.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_3_4);
                text_3_4.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_3_4);
                text_3_4.setText(getString(R.string.boost));
                break;
            case 10:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_3_4);
                text_3_4.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_3_4);
                text_3_4.setText(getString(R.string.power));
                break;
            case 12:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_3_4);
                text_3_4.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_3_4);
                text_3_4.setText(getString(R.string.recent));
                break;
        }

        switch (pref_4_action()){
            case 0:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_4_4);
                text_4_4.setText(getString(R.string.None));
                break;
            case 1:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_4_4);
                text_4_4.setText(getString(R.string.Home));
                break;
            case 2:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_4_4);
                text_4_4.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_4_4);
                text_4_4.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_4_4);
                text_4_4.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_4_4);
                text_4_4.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_4_4);
                text_4_4.setText(getString(R.string.Device));
                break;
            case 7:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_4_4);
                text_4_4.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_4_4);
                text_4_4.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_4_4);
                text_4_4.setText(getString(R.string.boost));
                break;
            case 10:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_4_4);
                text_4_4.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_4_4);
                text_4_4.setText(getString(R.string.power));
                break;
            case 12:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_4_4);
                text_4_4.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_4_4);
                text_4_4.setText(getString(R.string.recent));
                break;
        }
        
    }

    private void setInitActionIcons5(){
        switch (pref_1_action()){
            case 0:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_1_5);
                text_1_5.setText(getString(R.string.None));
                break;
            case 1:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_1_5);
                text_1_5.setText(getString(R.string.Home));
                break;
            case 2:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_1_5);
                text_1_5.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_1_5);
                text_1_5.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_1_5);
                text_1_5.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_1_5);
                text_1_5.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_1_5);
                text_1_5.setText(getString(R.string.Device));
                break;
            case 7:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_1_5);
                text_1_5.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_1_5);
                text_1_5.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_1_5);
                text_1_5.setText(getString(R.string.boost));
                break;
            case 10:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_1_5);
                text_1_5.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_1_5);
                text_1_5.setText(getString(R.string.power));
                break;
            case 12:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_1_5);
                text_1_5.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_1_5);
                text_1_5.setText(getString(R.string.recent));
                break;
        }

        switch (pref_2_action()){
            case 0:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_2_5);
                text_2_5.setText(getString(R.string.None));
                break;
            case 1:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_2_5);
                text_2_5.setText(getString(R.string.Home));
                break;
            case 2:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_2_5);
                text_2_5.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_2_5);
                text_2_5.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_2_5);
                text_2_5.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_2_5);
                text_2_5.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_2_5);
                text_2_5.setText(getString(R.string.Device));
                break;
            case 7:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_2_5);
                text_2_5.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_2_5);
                text_2_5.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_2_5);
                text_2_5.setText(getString(R.string.boost));
                break;
            case 10:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_2_5);
                text_2_5.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_2_5);
                text_2_5.setText(getString(R.string.power));
                break;
            case 12:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_2_5);
                text_2_5.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_2_5);
                text_2_5.setText(getString(R.string.recent));
                break;
        }

        switch (pref_3_action()){
            case 0:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_3_5);
                text_3_5.setText(getString(R.string.None));
                break;
            case 1:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_3_5);
                text_3_5.setText(getString(R.string.Home));
                break;
            case 2:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_3_5);
                text_3_5.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_3_5);
                text_3_5.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_3_5);
                text_3_5.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_3_5);
                text_3_5.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_3_5);
                text_3_5.setText(getString(R.string.Device));
                break;
            case 7:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_3_5);
                text_3_5.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_3_5);
                text_3_5.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_3_5);
                text_3_5.setText(getString(R.string.boost));
                break;
            case 10:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_3_5);
                text_3_5.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_3_5);
                text_3_5.setText(getString(R.string.power));
                break;
            case 12:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_3_5);
                text_3_5.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_3_5);
                text_3_5.setText(getString(R.string.recent));
                break;
        }

        switch (pref_4_action()){
            case 0:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_4_5);
                text_4_5.setText(getString(R.string.None));
                break;
            case 1:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_4_5);
                text_4_5.setText(getString(R.string.Home));
                break;
            case 2:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_4_5);
                text_4_5.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_4_5);
                text_4_5.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_4_5);
                text_4_5.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_4_5);
                text_4_5.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_4_5);
                text_4_5.setText(getString(R.string.Device));
                break;
            case 7:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_4_5);
                text_4_5.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_4_5);
                text_4_5.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_4_5);
                text_4_5.setText(getString(R.string.boost));
                break;
            case 10:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_4_5);
                text_4_5.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_4_5);
                text_4_5.setText(getString(R.string.power));
                break;
            case 12:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_4_5);
                text_4_5.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_4_5);
                text_4_5.setText(getString(R.string.recent));
                break;
        }

        switch (pref_5_action()){
            case 0:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_5_5);
                text_5_5.setText(getString(R.string.None));
                break;
            case 1:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_5_5);
                text_5_5.setText(getString(R.string.Home));
                break;
            case 2:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_5_5);
                text_5_5.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_5_5);
                text_5_5.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_5_5);
                text_5_5.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_5_5);
                text_5_5.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_5_5);
                text_5_5.setText(getString(R.string.Device));
                break;
            case 7:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_5_5);
                text_5_5.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_5_5);
                text_5_5.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_5_5);
                text_5_5.setText(getString(R.string.boost));
                break;
            case 10:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_5_5);
                text_5_5.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_5_5);
                text_5_5.setText(getString(R.string.power));
                break;
            case 12:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_5_5);
                text_5_5.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_5_5);
                text_5_5.setText(getString(R.string.recent));
                break;
        }
    }

    //Item6
    private void setInitActionIcons(){
        switch (pref_1_action()){
            case 0:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_1);
                text_1.setText(getString(R.string.None));
                break;
            case 1:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_1);
                text_1.setText(getString(R.string.Home));
                break;
            case 2:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_1);
                text_1.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_1);
                text_1.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_1);
                text_1.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_1);
                text_1.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_1);
                text_1.setText(getString(R.string.Device));
                break;
            case 7:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_1);
                text_1.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_1);
                text_1.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_1);
                text_1.setText(getString(R.string.boost));
                break;
            case 10:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_1);
                text_1.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_1);
                text_1.setText(getString(R.string.power));
                break;
            case 12:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_1);
                text_1.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_1);
                text_1.setText(getString(R.string.recent));
                break;
        }

        switch (pref_2_action()){
            case 0:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_2);
                text_2.setText(getString(R.string.None));
                break;
            case 1:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_2);
                text_2.setText(getString(R.string.Home));
                break;
            case 2:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_2);
                text_2.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_2);
                text_2.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_2);
                text_2.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_2);
                text_2.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_2);
                text_2.setText(getString(R.string.Device));
                break;
            case 7:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_2);
                text_2.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_2);
                text_2.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_2);
                text_2.setText(getString(R.string.boost));
                break;
            case 10:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_2);
                text_2.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_2);
                text_2.setText(getString(R.string.power));
                break;
            case 12:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_2);
                text_2.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_2);
                text_2.setText(getString(R.string.recent));
                break;
        }

        switch (pref_3_action()){
            case 0:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_3);
                text_3.setText(getString(R.string.None));
                break;
            case 1:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_3);
                text_3.setText(getString(R.string.Home));
                break;
            case 2:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_3);
                text_3.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_3);
                text_3.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_3);
                text_3.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_3);
                text_3.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_3);
                text_3.setText(getString(R.string.Device));
                break;
            case 7:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_3);
                text_3.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_3);
                text_3.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_3);
                text_3.setText(getString(R.string.boost));
                break;
            case 10:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_3);
                text_3.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_3);
                text_3.setText(getString(R.string.power));
                break;
            case 12:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_3);
                text_3.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_3);
                text_3.setText(getString(R.string.recent));
                break;
        }

        switch (pref_4_action()){
            case 0:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_4);
                text_4.setText(getString(R.string.None));
                break;
            case 1:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_4);
                text_4.setText(getString(R.string.Home));
                break;
            case 2:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_4);
                text_4.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_4);
                text_4.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_4);
                text_4.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_4);
                text_4.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_4);
                text_4.setText(getString(R.string.Device));
                break;
            case 7:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_4);
                text_4.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_4);
                text_4.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_4);
                text_4.setText(getString(R.string.boost));
                break;
            case 10:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_4);
                text_4.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_4);
                text_4.setText(getString(R.string.power));
                break;
            case 12:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_4);
                text_4.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_4);
                text_4.setText(getString(R.string.recent));
                break;
        }

        switch (pref_5_action()){
            case 0:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_5);
                break;
            case 1:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_5);
                break;
            case 2:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_5);
                break;
            case 3:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_5);
                break;
            case 4:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_5);
                break;
            case 5:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_5);
                break;
            case 6:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_5);
                break;
            case 7:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_5);
                break;
            case 8:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_5);
                break;
            case 9:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_5);
                break;
            case 10:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_5);
                break;
            case 11:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_5);
                break;
            case 12:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_5);
                break;
            case 13:
                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_5);
                break;
        }

        switch (pref_6_action()){
            case 0:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_6);
                text_6.setText(getString(R.string.None));
                break;
            case 1:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_6);
                text_6.setText(getString(R.string.Home));
                break;
            case 2:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_6);
                text_6.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_6);
                text_6.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_6);
                text_6.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_6);
                text_6.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_6);
                text_6.setText(getString(R.string.Device));
                break;
            case 7:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_6);
                text_6.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_6);
                text_6.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_6);
                text_6.setText(getString(R.string.boost));
                break;
            case 10:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_6);
                text_6.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_6);
                text_6.setText(getString(R.string.power));
                break;
            case 12:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_6);
                text_6.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_6);
                text_6.setText(getString(R.string.recent));
                break;
        }

        switch (pref_7_action()){
            case 0:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_7);
                text_7.setText(getString(R.string.None));
                break;
            case 1:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_7);
                text_7.setText(getString(R.string.Home));
                break;
            case 2:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_7);
                text_7.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_7);
                text_7.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_7);
                text_7.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_7);
                text_7.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_7);
                text_7.setText(getString(R.string.Device));
                break;
            case 7:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_7);
                text_7.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_7);
                text_7.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_7);
                text_7.setText(getString(R.string.boost));
                break;
            case 10:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_7);
                text_7.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_7);
                text_7.setText(getString(R.string.power));
                break;
            case 12:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_7);
                text_7.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_7);
                text_7.setText(getString(R.string.recent));
                break;
        }
    }

    private void setInitActionIcons7(){
        switch (pref_1_action()){
            case 0:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_1_7);
                text_1_7.setText(getString(R.string.None));
                break;
            case 1:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_1_7);
                text_1_7.setText(getString(R.string.Home));
                break;
            case 2:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_1_7);
                text_1_7.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_1_7);
                text_1_7.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_1_7);
                text_1_7.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_1_7);
                text_1_7.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_1_7);
                text_1_7.setText(getString(R.string.Device));
                break;
            case 7:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_1_7);
                text_1_7.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_1_7);
                text_1_7.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_1_7);
                text_1_7.setText(getString(R.string.boost));
                break;
            case 10:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_1_7);
                text_1_7.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_1_7);
                text_1_7.setText(getString(R.string.power));
                break;
            case 12:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_1_7);
                text_1_7.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_1_7);
                text_1_7.setText(getString(R.string.recent));
                break;
        }

        switch (pref_2_action()){
            case 0:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_2_7);
                text_2_7.setText(getString(R.string.None));
                break;
            case 1:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_2_7);
                text_2_7.setText(getString(R.string.Home));
                break;
            case 2:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_2_7);
                text_2_7.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_2_7);
                text_2_7.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_2_7);
                text_2_7.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_2_7);
                text_2_7.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_2_7);
                text_2_7.setText(getString(R.string.Device));
                break;
            case 7:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_2_7);
                text_2_7.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_2_7);
                text_2_7.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_2_7);
                text_2_7.setText(getString(R.string.boost));
                break;
            case 10:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_2_7);
                text_2_7.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_2_7);
                text_2_7.setText(getString(R.string.power));
                break;
            case 12:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_2_7);
                text_2_7.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_2_7);
                text_2_7.setText(getString(R.string.recent));
                break;
        }

        switch (pref_3_action()){
            case 0:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_3_7);
                text_3_7.setText(getString(R.string.None));
                break;
            case 1:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_3_7);
                text_3_7.setText(getString(R.string.Home));
                break;
            case 2:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_3_7);
                text_3_7.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_3_7);
                text_3_7.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_3_7);
                text_3_7.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_3_7);
                text_3_7.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_3_7);
                text_3_7.setText(getString(R.string.Device));
                break;
            case 7:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_3_7);
                text_3_7.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_3_7);
                text_3_7.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_3_7);
                text_3_7.setText(getString(R.string.boost));
                break;
            case 10:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_3_7);
                text_3_7.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_3_7);
                text_3_7.setText(getString(R.string.power));
                break;
            case 12:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_3_7);
                text_3_7.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_3_7);
                text_3_7.setText(getString(R.string.recent));
                break;
        }

        switch (pref_4_action()){
            case 0:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_4_7);
                text_4_7.setText(getString(R.string.None));
                break;
            case 1:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_4_7);
                text_4_7.setText(getString(R.string.Home));
                break;
            case 2:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_4_7);
                text_4_7.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_4_7);
                text_4_7.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_4_7);
                text_4_7.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_4_7);
                text_4_7.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_4_7);
                text_4_7.setText(getString(R.string.Device));
                break;
            case 7:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_4_7);
                text_4_7.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_4_7);
                text_4_7.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_4_7);
                text_4_7.setText(getString(R.string.boost));
                break;
            case 10:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_4_7);
                text_4_7.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_4_7);
                text_4_7.setText(getString(R.string.power));
                break;
            case 12:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_4_7);
                text_4_7.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_4_7);
                text_4_7.setText(getString(R.string.recent));
                break;
        }

        switch (pref_5_action()){
            case 0:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_5_7);
                text_5_7.setText(getString(R.string.None));
                break;
            case 1:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_5_7);
                text_5_7.setText(getString(R.string.Home));
                break;
            case 2:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_5_7);
                text_5_7.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_5_7);
                text_5_7.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_5_7);
                text_5_7.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_5_7);
                text_5_7.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_5_7);
                text_5_7.setText(getString(R.string.Device));
                break;
            case 7:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_5_7);
                text_5_7.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_5_7);
                text_5_7.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_5_7);
                text_5_7.setText(getString(R.string.boost));
                break;
            case 10:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_5_7);
                text_5_7.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_5_7);
                text_5_7.setText(getString(R.string.power));
                break;
            case 12:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_5_7);
                text_5_7.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_5_7);
                text_5_7.setText(getString(R.string.recent));
                break;
        }

        switch (pref_6_action()){
            case 0:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_6_7);
                text_6_7.setText(getString(R.string.None));
                break;
            case 1:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_6_7);
                text_6_7.setText(getString(R.string.Home));
                break;
            case 2:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_6_7);
                text_6_7.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_6_7);
                text_6_7.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_6_7);
                text_6_7.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_6_7);
                text_6_7.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_6_7);
                text_6_7.setText(getString(R.string.Device));
                break;
            case 7:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_6_7);
                text_6_7.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_6_7);
                text_6_7.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_6_7);
                text_6_7.setText(getString(R.string.boost));
                break;
            case 10:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_6_7);
                text_6_7.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_6_7);
                text_6_7.setText(getString(R.string.power));
                break;
            case 12:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_6_7);
                text_6_7.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_6_7);
                text_6_7.setText(getString(R.string.recent));
                break;
        }

        switch (pref_7_action()){
            case 0:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_7_7);
                text_7_7.setText(getString(R.string.None));
                break;
            case 1:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_7_7);
                text_7_7.setText(getString(R.string.Home));
                break;
            case 2:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_7_7);
                text_7_7.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_7_7);
                text_7_7.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_7_7);
                text_7_7.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_7_7);
                text_7_7.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_7_7);
                text_7_7.setText(getString(R.string.Device));
                break;
            case 7:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_7_7);
                text_7_7.setText(getString(R.string.screenshot));
                break;
            case 8:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_7_7);
                text_7_7.setText(getString(R.string.screen_nrecording));
                break;
            case 9:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_7_7);
                text_7_7.setText(getString(R.string.boost));
                break;
            case 10:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_7_7);
                text_7_7.setText(getString(R.string.lock_nscreen));
                break;
            case 11:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_7_7);
                text_7_7.setText(getString(R.string.power));
                break;
            case 12:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_7_7);
                text_7_7.setText(getString(R.string.open_nstatusbar));
                break;
            case 13:
                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_7_7);
                text_7_7.setText(getString(R.string.recent));
                break;
        }
    }

    private void setInitActionIcons8(){
        switch (pref_1_action()){
            case 0:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_1_8);
                text_1_8.setText(getString(R.string.None));
                break;
            case 1:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_1_8);
                text_1_8.setText(getString(R.string.Home));
                break;
            case 2:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_1_8);
                text_1_8.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_1_8);
                text_1_8.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_1_8);
                text_1_8.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_1_8);
                text_1_8.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_1_8);
                text_1_8.setText(getString(R.string.Device));
                break;
            case 7:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_1_8);
                text_1_8.setText(getText(R.string.screenshot));
                break;
            case 8:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_1_8);
                text_1_8.setText(getText(R.string.screen_nrecording));
                break;
            case 9:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_1_8);
                text_1_8.setText(getText(R.string.boost));
                break;
            case 10:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_1_8);
                text_1_8.setText(getText(R.string.lock_nscreen));
                break;
            case 11:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_1_8);
                text_1_8.setText(getText(R.string.power));
                break;
            case 12:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_1_8);
                text_1_8.setText(getText(R.string.open_nstatusbar));
                break;
            case 13:
                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_1_8);
                text_1_8.setText(getText(R.string.recent));
                break;
        }

        switch (pref_2_action()){
            case 0:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_2_8);
                text_2_8.setText(getString(R.string.None));
                break;
            case 1:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_2_8);
                text_2_8.setText(getString(R.string.Home));
                break;
            case 2:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_2_8);
                text_2_8.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_2_8);
                text_2_8.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_2_8);
                text_2_8.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_2_8);
                text_2_8.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_2_8);
                text_2_8.setText(getString(R.string.Device));
                break;
            case 7:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_2_8);
                text_2_8.setText(getText(R.string.screenshot));
                break;
            case 8:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_2_8);
                text_2_8.setText(getText(R.string.screen_nrecording));
                break;
            case 9:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_2_8);
                text_2_8.setText(getText(R.string.boost));
                break;
            case 10:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_2_8);
                text_2_8.setText(getText(R.string.lock_nscreen));
                break;
            case 11:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_2_8);
                text_2_8.setText(getText(R.string.power));
                break;
            case 12:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_2_8);
                text_2_8.setText(getText(R.string.open_nstatusbar));
                break;
            case 13:
                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_2_8);
                text_2_8.setText(getText(R.string.recent));
                break;
        }

        switch (pref_3_action()){
            case 0:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_3_8);
                text_3_8.setText(getString(R.string.None));
                break;
            case 1:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_3_8);
                text_3_8.setText(getString(R.string.Home));
                break;
            case 2:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_3_8);
                text_3_8.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_3_8);
                text_3_8.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_3_8);
                text_3_8.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_3_8);
                text_3_8.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_3_8);
                text_3_8.setText(getString(R.string.Device));
                break;
            case 7:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_3_8);
                text_3_8.setText(getText(R.string.screenshot));
                break;
            case 8:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_3_8);
                text_3_8.setText(getText(R.string.screen_nrecording));
                break;
            case 9:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_3_8);
                text_3_8.setText(getText(R.string.boost));
                break;
            case 10:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_3_8);
                text_3_8.setText(getText(R.string.lock_nscreen));
                break;
            case 11:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_3_8);
                text_3_8.setText(getText(R.string.power));
                break;
            case 12:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_3_8);
                text_3_8.setText(getText(R.string.open_nstatusbar));
                break;
            case 13:
                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_3_8);
                text_3_8.setText(getText(R.string.recent));
                break;
        }

        switch (pref_4_action()){
            case 0:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_4_8);
                text_4_8.setText(getString(R.string.None));
                break;
            case 1:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_4_8);
                text_4_8.setText(getString(R.string.Home));
                break;
            case 2:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_4_8);
                text_4_8.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_4_8);
                text_4_8.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_4_8);
                text_4_8.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_4_8);
                text_4_8.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_4_8);
                text_4_8.setText(getString(R.string.Device));
                break;
            case 7:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_4_8);
                text_4_8.setText(getText(R.string.screenshot));
                break;
            case 8:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_4_8);
                text_4_8.setText(getText(R.string.screen_nrecording));
                break;
            case 9:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_4_8);
                text_4_8.setText(getText(R.string.boost));
                break;
            case 10:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_4_8);
                text_4_8.setText(getText(R.string.lock_nscreen));
                break;
            case 11:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_4_8);
                text_4_8.setText(getText(R.string.power));
                break;
            case 12:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_4_8);
                text_4_8.setText(getText(R.string.open_nstatusbar));
                break;
            case 13:
                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_4_8);
                text_4_8.setText(getText(R.string.recent));
                break;
        }

        switch (pref_5_action()){
            case 0:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_5_8);
                text_5_8.setText(getString(R.string.None));
                break;
            case 1:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_5_8);
                text_5_8.setText(getString(R.string.Home));
                break;
            case 2:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_5_8);
                text_5_8.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_5_8);
                text_5_8.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_5_8);
                text_5_8.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_5_8);
                text_5_8.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_5_8);
                text_5_8.setText(getString(R.string.Device));
                break;
            case 7:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_5_8);
                text_5_8.setText(getText(R.string.screenshot));
                break;
            case 8:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_5_8);
                text_5_8.setText(getText(R.string.screen_nrecording));
                break;
            case 9:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_5_8);
                text_5_8.setText(getText(R.string.boost));
                break;
            case 10:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_5_8);
                text_5_8.setText(getText(R.string.lock_nscreen));
                break;
            case 11:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_5_8);
                text_5_8.setText(getText(R.string.power));
                break;
            case 12:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_5_8);
                text_5_8.setText(getText(R.string.open_nstatusbar));
                break;
            case 13:
                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_5_8);
                text_5_8.setText(getText(R.string.recent));
                break;
        }

        switch (pref_6_action()){
            case 0:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_6_8);
                text_6_8.setText(getString(R.string.None));
                break;
            case 1:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_6_8);
                text_6_8.setText(getString(R.string.Home));
                break;
            case 2:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_6_8);
                text_6_8.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_6_8);
                text_6_8.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_6_8);
                text_6_8.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_6_8);
                text_6_8.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_6_8);
                text_6_8.setText(getString(R.string.Device));
                break;
            case 7:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_6_8);
                text_6_8.setText(getText(R.string.screenshot));
                break;
            case 8:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_6_8);
                text_6_8.setText(getText(R.string.screen_nrecording));
                break;
            case 9:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_6_8);
                text_6_8.setText(getText(R.string.boost));
                break;
            case 10:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_6_8);
                text_6_8.setText(getText(R.string.lock_nscreen));
                break;
            case 11:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_6_8);
                text_6_8.setText(getText(R.string.power));
                break;
            case 12:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_6_8);
                text_6_8.setText(getText(R.string.open_nstatusbar));
                break;
            case 13:
                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_6_8);
                text_6_8.setText(getText(R.string.recent));
                break;
        }

        switch (pref_7_action()){
            case 0:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_7_8);
                text_7_8.setText(getString(R.string.None));
                break;
            case 1:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_7_8);
                text_7_8.setText(getString(R.string.Home));
                break;
            case 2:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_7_8);
                text_7_8.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_7_8);
                text_7_8.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_7_8);
                text_7_8.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_7_8);
                text_7_8.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_7_8);
                text_7_8.setText(getString(R.string.Device));
                break;
            case 7:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_7_8);
                text_7_8.setText(getText(R.string.screenshot));
                break;
            case 8:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_7_8);
                text_7_8.setText(getText(R.string.screen_nrecording));
                break;
            case 9:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_7_8);
                text_7_8.setText(getText(R.string.boost));
                break;
            case 10:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_7_8);
                text_7_8.setText(getText(R.string.lock_nscreen));
                break;
            case 11:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_7_8);
                text_7_8.setText(getText(R.string.power));
                break;
            case 12:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_7_8);
                text_7_8.setText(getText(R.string.open_nstatusbar));
                break;
            case 13:
                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_7_8);
                text_7_8.setText(getText(R.string.recent));
                break;
        }

        switch (pref_8_action()){
            case 0:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                setScaleSmall(btn_8_8);
                text_8_8.setText(getString(R.string.None));
                break;
            case 1:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                setScaleSmall(btn_8_8);
                text_8_8.setText(getString(R.string.Home));
                break;
            case 2:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                setScaleDefault(btn_8_8);
                text_8_8.setText(getString(R.string.Notifications));
                break;
            case 3:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                serScaleLarge(btn_8_8);
                text_8_8.setText(getString(R.string.Control_Center));
                break;
            case 4:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                setScaleOne(btn_8_8);
                text_8_8.setText(getString(R.string.Custom));
                break;
            case 5:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                setScaleOne(btn_8_8);
                text_8_8.setText(getString(R.string.Gesture));
                break;
            case 6:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                setScaleOne(btn_8_8);
                text_8_8.setText(getString(R.string.Device));
                break;
            case 7:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                setScaleOne(btn_8_8);
                text_8_8.setText(getText(R.string.screenshot));
                break;
            case 8:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                setScaleOne(btn_8_8);
                text_8_8.setText(getText(R.string.screen_nrecording));
                break;
            case 9:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                setScaleOne(btn_8_8);
                text_8_8.setText(getText(R.string.boost));
                break;
            case 10:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                setScaleOne(btn_8_8);
                text_8_8.setText(getText(R.string.lock_nscreen));
                break;
            case 11:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                setScaleOne(btn_8_8);
                text_8_8.setText(getText(R.string.power));
                break;
            case 12:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                setScaleOne(btn_8_8);
                text_8_8.setText(getText(R.string.open_nstatusbar));
                break;
            case 13:
                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                setScaleOne(btn_8_8);
                text_8_8.setText(getText(R.string.recent));
                break;
        }
    }

    private void setBtnClickListener1(){
        btn_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog1();
            }
        });

        text_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog1();
            }
        });
    }

    private void setBtnClickListener2(){
        btn_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog2(1);
            }
        });

        text_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog2(1);
            }
        });

        btn_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog2(2);
            }
        });

        text_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog2(2);
            }
        });
    }
    
    private void setBtnClickListener3(){
        btn_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog3(1);
            }
        });

        text_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog3(1);
            }
        });

        btn_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog3(2);
            }
        });

        text_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog3(2);
            }
        });

        btn_3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog3(3);
            }
        });

        text_3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog3(3);
            }
        });
    }

    private void setBtnClickListener4(){
        btn_1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog4(1);
            }
        });

        text_1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog4(1);
            }
        });

        btn_2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog4(2);
            }
        });

        text_2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog4(2);
            }
        });

        btn_3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog4(3);
            }
        });

        text_3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog4(3);
            }
        });

        btn_4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog4(4);
            }
        });

        text_4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog4(4);
            }
        });
    }

    private void setBtnClickListener5(){
        btn_1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog5(1);
            }
        });

        text_1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog5(1);
            }
        });

        btn_2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog5(2);
            }
        });

        text_2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog5(2);
            }
        });

        btn_3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog5(3);
            }
        });

        text_3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog5(3);
            }
        });

        btn_4_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog5(4);
            }
        });

        text_4_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog5(4);
            }
        });

        btn_5_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog5(5);
            }
        });

    }
    
    private void setBtnClickListener(){
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(1);
            }
        });

        text_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(1);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(2);
            }
        });

        text_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(2);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(3);
            }
        });

        text_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(3);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(4);
            }
        });

        text_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(4);
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(5);
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(6);
            }
        });

        text_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(6);
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(7);
            }
        });

        text_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog(7);
            }
        });

    }

    private void setBtnClickListener7(){
        btn_1_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(1);
            }
        });

        text_1_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(1);
            }
        });

        btn_2_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(2);
            }
        });

        text_2_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(2);
            }
        });

        btn_3_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(3);
            }
        });

        text_3_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(3);
            }
        });

        btn_4_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(4);
            }
        });

        text_4_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(4);
            }
        });

        btn_5_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(5);
            }
        });

        btn_6_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(6);
            }
        });

        text_6_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(6);
            }
        });

        btn_7_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(7);
            }
        });

        text_7_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog7(7);
            }
        });

    }

    private void setBtnClickListener8(){
        btn_1_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(1);
            }
        });

        text_1_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(1);
            }
        });

        btn_2_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(2);
            }
        });

        text_2_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(2);
            }
        });

        btn_3_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(3);
            }
        });

        text_3_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(3);
            }
        });

        btn_4_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(4);
            }
        });

        text_4_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(4);
            }
        });

        btn_5_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(5);
            }
        });

        btn_6_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(6);
            }
        });

        text_6_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(6);
            }
        });

        btn_7_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(7);
            }
        });

        text_7_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(7);
            }
        });

        btn_8_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(8);
            }
        });

        text_8_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectActionAlertDialog8(8);
            }
        });

    }

    private void setSelectActionAlertDialog1(){
        ListView listView = new ListView(this);
        String[] actions = new String[]{
                "1. None","2. Home","3. Notification","4. Control Center","5. Custom","6. Gesture", "7. Device", "8. Screenshot",
                "9. Screen Record", "10. Boost Device" , "11. Lock Device", "12. Power", "13. Status Bar","14. Open Recent"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,actions){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(ContextCompat.getColor(CustomizeLayoutActivity.this,R.color.white));
                return textView;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_baseline_add_24));
                        setScaleSmall(btn_1_1);
                        text_1_1.setText(getText(R.string.None));
                        sharedPreferenceController.setActionsPref1(0);
                        break;
                    case 1:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.home_img));
                        setScaleSmall(btn_1_1);
                        text_1_1.setText(getText(R.string.Home));
                        sharedPreferenceController.setActionsPref1(1);
                        break;
                    case 2:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.notification_icon1));
                        setScaleDefault(btn_1_1);
                        text_1_1.setText(getText(R.string.Notifications));
                        sharedPreferenceController.setActionsPref1(2);
                        break;
                    case 3:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.control_center));
                        serScaleLarge(btn_1_1);
                        text_1_1.setText(getText(R.string.Control_Center));
                        sharedPreferenceController.setActionsPref1(3);
                        break;
                    case 4:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.favorite_2));
                        setScaleOne(btn_1_1);
                        text_1_1.setText(getText(R.string.Custom));
                        sharedPreferenceController.setActionsPref1(4);
                        break;
                    case 5:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.gesture));
                        setScaleOne(btn_1_1);
                        text_1_1.setText(getText(R.string.Gesture));
                        sharedPreferenceController.setActionsPref1(5);
                        break;
                    case 6:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.device));
                        setScaleOne(btn_1_1);
                        text_1_1.setText(getText(R.string.Device));
                        sharedPreferenceController.setActionsPref1(6);
                        break;
                    case 7:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.screen_shot));
                        setScaleOne(btn_1_1);
                        text_1_1.setText(getText(R.string.screenshot));
                        sharedPreferenceController.setActionsPref1(7);
                        break;
                    case 8:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.record1));
                        setScaleOne(btn_1_1);
                        text_1_1.setText(getText(R.string.screen_nrecording));
                        sharedPreferenceController.setActionsPref1(8);
                        break;
                    case 9:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_boost_large_1));
                        setScaleOne(btn_1_1);
                        text_1_1.setText(getText(R.string.boost));
                        sharedPreferenceController.setActionsPref1(9);
                        break;
                    case 10:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_baseline_lock_24));
                        setScaleOne(btn_1_1);
                        text_1_1.setText(getText(R.string.lock_nscreen));
                        sharedPreferenceController.setActionsPref1(10);
                        break;
                    case 11:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_baseline_power_settings_new_24));
                        setScaleOne(btn_1_1);
                        text_1_1.setText(getText(R.string.power));
                        sharedPreferenceController.setActionsPref1(11);
                        break;
                    case 12:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.control_center));
                        setScaleOne(btn_1_1);
                        text_1_1.setText(getText(R.string.open_nstatusbar));
                        sharedPreferenceController.setActionsPref1(12);
                        break;
                    case 13:
                        btn_1_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this, R.drawable.ic_recent_white));
                        setScaleOne(btn_1_1);
                        text_1_1.setText(getText(R.string.recent));
                        sharedPreferenceController.setActionsPref1(13);
                        break;
                }
                restartService();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DarkWindow);
        builder.setTitle("Select Action");
        builder.setView(listView);
        builder.setCancelable(true);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void setSelectActionAlertDialog2(final int btn_position){
        ListView listView = new ListView(this);
        String[] actions = new String[]{
                "1. None","2. Home","3. Notification","4. Control Center","5. Custom","6. Gesture", "7. Device", "8. Screenshot",
                "9. Screen Record", "10. Boost Device" , "11. Lock Device", "12. Power", "13. Status Bar","14. Open Recent"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,actions){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(ContextCompat.getColor(CustomizeLayoutActivity.this,R.color.white));
                return textView;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_1_2);
                                text_1_2.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref1(0);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_2_2);
                                text_2_2.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref2(0);
                                break;
                        }
                        break;
                    case 1:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_1_2);
                                text_1_2.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref1(1);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_2_2);
                                text_2_2.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref2(1);
                                break;
                        }
                        break;
                    case 2:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_1_2);
                                text_1_2.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref1(2);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_2_2);
                                text_2_2.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref2(2);
                                break;
                        }
                        break;
                    case 3:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_1_2);
                                text_1_2.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref1(3);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_2_2);
                                text_2_2.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref2(3);
                                break;
                        }
                        break;
                    case 4:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_1_2);
                                text_1_2.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref1(4);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_2_2);
                                text_2_2.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref2(4);
                                break;
                        }
                        break;
                    case 5:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_1_2);
                                text_1_2.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref1(5);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_2_2);
                                text_2_2.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref2(5);
                                break;
                        }
                        break;
                    case 6:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_1_2);
                                text_1_2.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref1(6);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_2_2);
                                text_2_2.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref2(6);
                                break;
                        }
                        break;
                    case 7:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_1_2);
                                text_1_2.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref1(7);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_2_2);
                                text_2_2.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref2(7);
                                break;
                        }
                        break;
                    case 8:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_1_2);
                                text_1_2.setText(getText(R.string.screen_recoder));
                                sharedPreferenceController.setActionsPref1(8);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_2_2);
                                text_2_2.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref2(8);
                                break;
                        }
                        break;
                    case 9:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_1_2);
                                text_1_2.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref1(9);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_2_2);
                                text_2_2.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref2(9);
                                break;
                        }
                        break;
                    case 10:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_1_2);
                                text_1_2.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref1(10);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_2_2);
                                text_2_2.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref2(10);
                                break;
                        }
                        break;
                    case 11:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_1_2);
                                text_1_2.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref1(11);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_2_2);
                                text_2_2.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref2(11);
                                break;
                        }
                        break;
                    case 12:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_1_2);
                                text_1_2.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref1(12);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_2_2);
                                text_2_2.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref2(12);
                                break;
                        }
                        break;
                    case 13:
                        switch (btn_position){
                            case 1:
                                btn_1_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_1_2);
                                text_1_2.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref1(13);
                                break;
                            case 2:
                                btn_2_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_2_2);
                                text_2_2.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref2(13);
                                break;
                        }
                        break;
                }
                restartService();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DarkWindow);
        builder.setTitle("Select Action");
        builder.setView(listView);
        builder.setCancelable(true);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void setSelectActionAlertDialog3(final int btn_position){
        ListView listView = new ListView(this);
        String[] actions = new String[]{
                "1. None","2. Home","3. Notification","4. Control Center","5. Custom","6. Gesture", "7. Device", "8. Screenshot",
                "9. Screen Record", "10. Boost Device" , "11. Lock Device", "12. Power", "13. Status Bar","14. Open Recent"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,actions){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(ContextCompat.getColor(CustomizeLayoutActivity.this,R.color.white));
                return textView;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_1_3);
                                text_1_3.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref1(0);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_2_3);
                                text_2_3.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref2(0);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_3_3);
                                text_3_3.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref3(0);
                                break;
                        }
                        break;
                    case 1:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_1_3);
                                text_1_3.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref1(1);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_2_3);
                                text_2_3.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref2(1);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_3_3);
                                text_3_3.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref3(1);
                                break;
                        }
                        break;
                    case 2:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_1_3);
                                text_1_3.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref1(2);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_2_3);
                                text_2_3.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref2(2);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_3_3);
                                text_3_3.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref3(2);
                                break;
                        }
                        break;
                    case 3:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_1_3);
                                text_1_3.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref1(3);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_2_3);
                                text_2_3.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref2(3);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_3_3);
                                text_3_3.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref3(3);
                                break;
                        }
                        break;
                    case 4:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_1_3);
                                text_1_3.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref1(4);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_2_3);
                                text_2_3.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref2(4);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_3_3);
                                text_3_3.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref3(4);
                                break;
                        }
                        break;
                    case 5:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_1_3);
                                text_1_3.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref1(5);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_2_3);
                                text_2_3.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref2(5);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_3_3);
                                text_3_3.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref3(5);
                                break;
                        }
                        break;
                    case 6:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_1_3);
                                text_1_3.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref1(6);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_2_3);
                                text_2_3.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref2(6);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_3_3);
                                text_3_3.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref3(6);
                                break;
                        }
                        break;
                    case 7:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_1_3);
                                text_1_3.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref1(7);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_2_3);
                                text_2_3.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref2(7);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_3_3);
                                text_3_3.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref3(7);
                                break;
                        }
                        break;
                    case 8:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_1_3);
                                text_1_3.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref1(8);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_2_3);
                                text_2_3.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref2(8);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_3_3);
                                text_3_3.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref3(8);
                                break;
                        }
                        break;
                    case 9:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_1_3);
                                text_1_3.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref1(9);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_2_3);
                                text_2_3.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref2(9);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_3_3);
                                text_3_3.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref3(9);
                                break;
                        }
                        break;
                    case 10:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_1_3);
                                text_1_3.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref1(10);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_2_3);
                                text_2_3.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref2(10);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_3_3);
                                text_3_3.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref3(10);
                                break;
                        }
                        break;
                    case 11:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_1_3);
                                text_1_3.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref1(11);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_2_3);
                                text_2_3.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref2(11);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_3_3);
                                text_3_3.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref3(11);
                                break;
                        }
                        break;
                    case 12:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_1_3);
                                text_1_3.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref1(12);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_2_3);
                                text_2_3.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref2(12);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_3_3);
                                text_3_3.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref3(12);
                                break;
                        }
                        break;
                    case 13:
                        switch (btn_position){
                            case 1:
                                btn_1_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_1_3);
                                text_1_3.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref1(13);
                                break;
                            case 2:
                                btn_2_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_2_3);
                                text_2_3.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref2(13);
                                break;
                            case 3:
                                btn_3_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_3_3);
                                text_3_3.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref3(13);
                                break;
                        }
                        break;
                }
                restartService();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DarkWindow);
        builder.setTitle("Select Action");
        builder.setView(listView);
        builder.setCancelable(true);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void setSelectActionAlertDialog4(final int btn_position){
        ListView listView = new ListView(this);
        String[] actions = new String[]{
                "1. None","2. Home","3. Notification","4. Control Center","5. Custom","6. Gesture", "7. Device", "8. Screenshot",
                "9. Screen Record", "10. Boost Device" , "11. Lock Device", "12. Power", "13. Status Bar","14. Open Recent"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,actions){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(ContextCompat.getColor(CustomizeLayoutActivity.this,R.color.white));
                return textView;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_1_4);
                                text_1_4.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref1(0);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_2_4);
                                text_2_4.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref2(0);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_3_4);
                                text_3_4.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref3(0);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_4_4);
                                text_4_4.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref4(0);
                                break;
                        }
                        break;
                    case 1:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_1_4);
                                text_1_4.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref1(1);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_2_4);
                                text_2_4.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref2(1);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_3_4);
                                text_3_4.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref3(1);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_4_4);
                                text_4_4.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref4(1);
                                break;
                        }
                        break;
                    case 2:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_1_4);
                                text_1_4.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref1(2);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_2_4);
                                text_2_4.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref2(2);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_3_4);
                                text_3_4.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref3(2);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_4_4);
                                text_4_4.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref4(2);
                                break;
                        }
                        break;
                    case 3:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_1_4);
                                text_1_4.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref1(3);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_2_4);
                                text_2_4.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref2(3);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_3_4);
                                text_3_4.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref3(3);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_4_4);
                                text_4_4.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref4(3);
                                break;
                        }
                        break;
                    case 4:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_1_4);
                                text_1_4.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref1(4);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_2_4);
                                text_2_4.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref2(4);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_3_4);
                                text_3_4.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref3(4);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_4_4);
                                text_4_4.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref4(4);
                                break;
                        }
                        break;
                    case 5:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_1_4);
                                text_1_4.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref1(5);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_2_4);
                                text_2_4.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref2(5);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_3_4);
                                text_3_4.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref3(5);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_4_4);
                                text_4_4.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref4(5);
                                break;
                        }
                        break;
                    case 6:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_1_4);
                                text_1_4.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref1(6);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_2_4);
                                text_2_4.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref2(6);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_3_4);
                                text_3_4.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref3(6);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_4_4);
                                text_4_4.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref4(6);
                                break;
                        }
                        break;
                    case 7:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_1_4);
                                text_1_4.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref1(7);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_2_4);
                                text_2_4.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref2(7);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_3_4);
                                text_3_4.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref3(7);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_4_4);
                                text_4_4.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref4(7);
                                break;
                        }
                        break;
                    case 8:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_1_4);
                                text_1_4.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref1(8);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_2_4);
                                text_2_4.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref2(8);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_3_4);
                                text_3_4.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref3(8);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_4_4);
                                text_4_4.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref4(8);
                                break;
                        }
                        break;
                    case 9:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_1_4);
                                text_1_4.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref1(9);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_2_4);
                                text_2_4.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref2(9);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_3_4);
                                text_3_4.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref3(9);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_4_4);
                                text_4_4.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref4(9);
                                break;
                        }
                        break;
                    case 10:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_1_4);
                                text_1_4.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref1(10);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_2_4);
                                text_2_4.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref2(10);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_3_4);
                                text_3_4.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref3(10);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_4_4);
                                text_4_4.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref4(10);
                                break;
                        }
                        break;
                    case 11:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_1_4);
                                text_1_4.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref1(11);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_2_4);
                                text_2_4.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref2(11);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_3_4);
                                text_3_4.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref3(11);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_4_4);
                                text_4_4.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref4(11);
                                break;
                        }
                        break;
                    case 12:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_1_4);
                                text_1_4.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref1(12);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_2_4);
                                text_2_4.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref2(12);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_3_4);
                                text_3_4.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref3(12);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_4_4);
                                text_4_4.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref4(12);
                                break;
                        }
                        break;
                    case 13:
                        switch (btn_position){
                            case 1:
                                btn_1_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_1_4);
                                text_1_4.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref1(13);
                                break;
                            case 2:
                                btn_2_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_2_4);
                                text_2_4.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref2(13);
                                break;
                            case 3:
                                btn_3_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_3_4);
                                text_3_4.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref3(13);
                                break;
                            case 4:
                                btn_4_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_4_4);
                                text_4_4.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref4(13);
                                break;
                        }
                        break;
                }
                restartService();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DarkWindow);
        builder.setTitle("Select Action");
        builder.setView(listView);
        builder.setCancelable(true);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
    
    private void setSelectActionAlertDialog5(final int btn_position){
        ListView listView = new ListView(this);
        String[] actions = new String[]{
                "1. None","2. Home","3. Notification","4. Control Center","5. Custom","6. Gesture", "7. Device", "8. Screenshot",
                "9. Screen Record", "10. Boost Device" , "11. Lock Device", "12. Power", "13. Status Bar","14. Open Recent"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,actions){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(ContextCompat.getColor(CustomizeLayoutActivity.this,R.color.white));
                return textView;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_1_5);
                                text_1_5.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref1(0);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_2_5);
                                text_2_5.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref2(0);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_3_5);
                                text_3_5.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref3(0);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_4_5);
                                text_4_5.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref4(0);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_5_5);
                                text_5_5.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref5(0);
                                break;
                        }
                        break;
                    case 1:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_1_5);
                                text_1_5.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref1(1);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_2_5);
                                text_2_5.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref2(1);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_3_5);
                                text_3_5.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref3(1);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_4_5);
                                text_4_5.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref4(1);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_5_5);
                                text_5_5.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref5(1);
                                break;
                        }
                        break;
                    case 2:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_1_5);
                                text_1_5.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref1(2);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_2_5);
                                text_2_5.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref2(2);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_3_5);
                                text_3_5.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref3(2);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_4_5);
                                text_4_5.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref4(2);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_5_5);
                                text_5_5.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref5(2);
                                break;
                        }
                        break;
                    case 3:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_1_5);
                                text_1_5.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref1(3);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_2_5);
                                text_2_5.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref2(3);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_3_5);
                                text_3_5.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref3(3);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_4_5);
                                text_4_5.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref4(3);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_5_5);
                                text_5_5.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref5(3);
                                break;
                        }
                        break;
                    case 4:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_1_5);
                                text_1_5.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref1(4);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_2_5);
                                text_2_5.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref2(4);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_3_5);
                                text_3_5.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref3(4);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_4_5);
                                text_4_5.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref4(4);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_5_5);
                                text_5_5.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref5(4);
                                break;
                        }
                        break;
                    case 5:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_1_5);
                                text_1_5.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref1(5);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_2_5);
                                text_2_5.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref2(5);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_3_5);
                                text_3_5.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref3(5);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_4_5);
                                text_4_5.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref4(5);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_5_5);
                                text_5_5.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref5(5);
                                break;
                        }
                        break;
                    case 6:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_1_5);
                                text_1_5.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref1(6);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_2_5);
                                text_2_5.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref2(6);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_3_5);
                                text_3_5.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref3(6);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_4_5);
                                text_4_5.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref4(6);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_5_5);
                                text_5_5.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref5(6);
                                break;
                        }
                        break;
                    case 7:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_1_5);
                                text_1_5.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref1(7);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_2_5);
                                text_2_5.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref2(7);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_3_5);
                                text_3_5.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref3(7);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_4_5);
                                text_4_5.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref4(7);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_5_5);
                                text_5_5.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref5(7);
                                break;
                        }
                        break;
                    case 8:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_1_5);
                                text_1_5.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref1(8);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_2_5);
                                text_2_5.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref2(8);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_3_5);
                                text_3_5.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref3(8);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_4_5);
                                text_4_5.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref4(8);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_5_5);
                                text_5_5.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref5(8);
                                break;
                        }
                        break;
                    case 9:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_1_5);
                                text_1_5.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref1(9);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_2_5);
                                text_2_5.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref2(9);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_3_5);
                                text_3_5.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref3(9);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_4_5);
                                text_4_5.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref4(9);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_5_5);
                                text_5_5.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref5(9);
                                break;
                        }
                        break;
                    case 10:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_1_5);
                                text_1_5.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref1(10);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_2_5);
                                text_2_5.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref2(10);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_3_5);
                                text_3_5.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref3(10);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_4_5);
                                text_4_5.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref4(10);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_5_5);
                                text_5_5.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref5(10);
                                break;
                        }
                        break;
                    case 11:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_1_5);
                                text_1_5.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref1(11);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_2_5);
                                text_2_5.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref2(11);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_3_5);
                                text_3_5.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref3(11);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_4_5);
                                text_4_5.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref4(11);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_5_5);
                                text_5_5.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref5(11);
                                break;
                        }
                        break;
                    case 12:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_1_5);
                                text_1_5.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref1(12);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_2_5);
                                text_2_5.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref2(12);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_3_5);
                                text_3_5.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref3(12);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_4_5);
                                text_4_5.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref4(12);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_5_5);
                                text_5_5.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref5(12);
                                break;
                        }
                        break;
                    case 13:
                        switch (btn_position){
                            case 1:
                                btn_1_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_1_5);
                                text_1_5.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref1(13);
                                break;
                            case 2:
                                btn_2_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_2_5);
                                text_2_5.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref2(13);
                                break;
                            case 3:
                                btn_3_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_3_5);
                                text_3_5.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref3(13);
                                break;
                            case 4:
                                btn_4_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_4_5);
                                text_4_5.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref4(13);
                                break;
                            case 5:
                                btn_5_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_5_5);
                                text_5_5.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref5(13);
                                break;
                        }
                        break;
                }
                restartService();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DarkWindow);
        builder.setTitle("Select Action");
        builder.setView(listView);
        builder.setCancelable(true);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void setSelectActionAlertDialog(final int btn_position){
        ListView listView = new ListView(this);
        String[] actions = new String[]{
                "1. None","2. Home","3. Notification","4. Control Center","5. Custom","6. Gesture", "7. Device", "8. Screenshot",
                "9. Screen Record", "10. Boost Device" , "11. Lock Device", "12. Power", "13. Status Bar","14. Open Recent"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,actions){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(ContextCompat.getColor(CustomizeLayoutActivity.this,R.color.white));
                return textView;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_1);
                                text_1.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref1(0);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_2);
                                text_2.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref2(0);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_3);
                                text_3.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref3(0);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_4);
                                text_4.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref4(0);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_5);
                                sharedPreferenceController.setActionsPref5(0);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_6);
                                text_6.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref6(0);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_7);
                                text_7.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref7(0);
                                break;
                        }
                        break;
                    case 1:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_1);
                                text_1.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref1(1);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_2);
                                text_2.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref2(1);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_3);
                                text_3.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref3(1);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_4);
                                text_4.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref4(1);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_5);
                                sharedPreferenceController.setActionsPref5(1);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_6);
                                text_6.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref6(1);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_7);
                                text_7.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref7(1);
                                break;
                        }
                        break;
                    case 2:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_1);
                                text_1.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref1(2);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_2);
                                text_2.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref2(2);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_3);
                                text_3.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref3(2);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_4);
                                text_4.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref4(2);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_5);
                                sharedPreferenceController.setActionsPref5(2);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_6);
                                text_6.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref6(2);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_7);
                                text_7.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref7(2);
                                break;
                        }
                        break;
                    case 3:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_1);
                                text_1.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref1(3);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_2);
                                text_2.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref2(3);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_3);
                                text_3.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref3(3);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_4);
                                text_4.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref4(3);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_5);
                                sharedPreferenceController.setActionsPref5(3);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_6);
                                text_6.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref6(3);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_7);
                                text_7.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref7(3);
                                break;
                        }
                        break;
                    case 4:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_1);
                                text_1.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref1(4);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_2);
                                text_2.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref2(4);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_3);
                                text_3.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref3(4);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_4);
                                text_4.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref4(4);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_5);
                                sharedPreferenceController.setActionsPref5(4);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_6);
                                text_6.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref6(4);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_7);
                                text_7.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref7(4);
                                break;
                        }
                        break;
                    case 5:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_1);
                                text_1.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref1(5);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_2);
                                text_2.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref2(5);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_3);
                                text_3.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref3(5);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_4);
                                text_4.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref4(5);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_5);
                                sharedPreferenceController.setActionsPref5(5);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_6);
                                text_6.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref6(5);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_7);
                                text_7.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref7(5);
                                break;
                        }
                        break;
                    case 6:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_1);
                                text_1.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref1(6);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_2);
                                text_2.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref2(6);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_3);
                                text_3.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref3(6);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_4);
                                text_4.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref4(6);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_5);
                                sharedPreferenceController.setActionsPref5(6);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_6);
                                text_6.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref6(6);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_7);
                                text_7.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref7(6);
                                break;
                        }
                        break;
                    case 7:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_1);
                                text_1.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref1(7);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_2);
                                text_2.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref2(7);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_3);
                                text_3.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref3(7);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_4);
                                text_4.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref4(7);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_5);
                                sharedPreferenceController.setActionsPref5(7);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_6);
                                text_6.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref6(7);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_7);
                                text_7.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref7(7);
                                break;
                        }
                        break;
                    case 8:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_1);
                                text_1.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref1(8);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_2);
                                text_2.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref2(8);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_3);
                                text_3.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref3(8);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_4);
                                text_4.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref4(8);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_5);
                                sharedPreferenceController.setActionsPref5(8);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_6);
                                text_6.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref6(8);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_7);
                                text_7.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref7(8);
                                break;
                        }
                        break;
                    case 9:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_1);
                                text_1.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref1(9);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_2);
                                text_2.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref2(9);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_3);
                                text_3.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref3(9);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_4);
                                text_4.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref4(9);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_5);
                                sharedPreferenceController.setActionsPref5(9);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_6);
                                text_6.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref6(9);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_7);
                                text_7.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref7(9);
                                break;
                        }
                        break;
                    case 10:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_1);
                                text_1.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref1(10);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_2);
                                text_2.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref2(10);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_3);
                                text_3.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref3(10);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_4);
                                text_4.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref4(10);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_5);
                                sharedPreferenceController.setActionsPref5(10);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_6);
                                text_6.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref6(10);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_7);
                                text_7.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref7(10);
                                break;
                        }
                        break;
                    case 11:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_1);
                                text_1.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref1(11);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_2);
                                text_2.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref2(11);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_3);
                                text_3.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref3(11);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_4);
                                text_4.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref4(11);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_5);
                                sharedPreferenceController.setActionsPref5(11);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_6);
                                text_6.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref6(11);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_7);
                                text_7.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref7(11);
                                break;
                        }
                        break;
                    case 12:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_1);
                                text_1.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref1(12);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_2);
                                text_2.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref2(12);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_3);
                                text_3.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref3(12);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_4);
                                text_4.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref4(12);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_5);
                                sharedPreferenceController.setActionsPref5(12);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_6);
                                text_6.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref6(12);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_7);
                                text_7.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref7(12);
                                break;
                        }
                        break;
                    case 13:
                        switch (btn_position){
                            case 1:
                                btn_1.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_1);
                                text_1.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref1(13);
                                break;
                            case 2:
                                btn_2.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_2);
                                text_2.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref2(13);
                                break;
                            case 3:
                                btn_3.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_3);
                                text_3.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref3(13);
                                break;
                            case 4:
                                btn_4.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_4);
                                text_4.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref4(13);
                                break;
                            case 5:
                                btn_5.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_5);
                                sharedPreferenceController.setActionsPref5(13);
                                break;
                            case 6:
                                btn_6.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_6);
                                text_6.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref6(13);
                                break;
                            case 7:
                                btn_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_7);
                                text_7.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref7(13);
                                break;
                        }
                        break;
                }
                restartService();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DarkWindow);
        builder.setTitle("Select Action");
        builder.setView(listView);
        builder.setCancelable(true);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void setSelectActionAlertDialog7(final int btn_position){
        ListView listView = new ListView(this);
        String[] actions = new String[]{
                "1. None","2. Home","3. Notification","4. Control Center","5. Custom","6. Gesture", "7. Device", "8. Screenshot",
                "9. Screen Record", "10. Boost Device" , "11. Lock Device", "12. Power", "13. Status Bar","14. Open Recent"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,actions){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(ContextCompat.getColor(CustomizeLayoutActivity.this,R.color.white));
                return textView;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_1_7);
                                text_1_7.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref1(0);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_2_7);
                                text_2_7.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref2(0);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_3_7);
                                text_3_7.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref3(0);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_4_7);
                                text_4_7.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref4(0);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_5_7);
                                text_5_7.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref5(0);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_6_7);
                                text_6_7.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref6(0);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_7_7);
                                text_7_7.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref7(0);
                                break;
                        }
                        break;
                    case 1:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_1_7);
                                text_1_7.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref1(1);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_2_7);
                                text_2_7.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref2(1);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_3_7);
                                text_3_7.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref3(1);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_4_7);
                                text_4_7.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref4(1);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_5_7);
                                text_5_7.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref5(1);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_6_7);
                                text_6_7.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref6(1);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_7_7);
                                text_7_7.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref7(1);
                                break;
                        }
                        break;
                    case 2:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_1_7);
                                text_1_7.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref1(2);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_2_7);
                                text_2_7.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref2(2);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_3_7);
                                text_3_7.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref3(2);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_4_7);
                                text_4_7.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref4(2);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_5_7);
                                text_5_7.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref5(2);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_6_7);
                                text_6_7.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref6(2);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_7_7);
                                text_7_7.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref7(2);
                                break;
                        }
                        break;
                    case 3:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_1_7);
                                text_1_7.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref1(3);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_2_7);
                                text_2_7.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref2(3);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_3_7);
                                text_3_7.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref3(3);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_4_7);
                                text_4_7.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref4(3);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_5_7);
                                text_5_7.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref5(3);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_6_7);
                                text_6_7.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref6(3);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_7_7);
                                text_7_7.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref7(3);
                                break;
                        }
                        break;
                    case 4:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_1_7);
                                text_1_7.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref1(4);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_2_7);
                                text_2_7.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref2(4);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_3_7);
                                text_3_7.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref3(4);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_4_7);
                                text_4_7.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref4(4);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_5_7);
                                text_5_7.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref5(4);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_6_7);
                                text_6_7.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref6(4);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_7_7);
                                text_7_7.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref7(4);
                                break;
                        }
                        break;
                    case 5:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_1_7);
                                text_1_7.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref1(5);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_2_7);
                                text_2_7.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref2(5);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_3_7);
                                text_3_7.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref3(5);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_4_7);
                                text_4_7.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref4(5);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_5_7);
                                text_5_7.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref5(5);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_6_7);
                                text_6_7.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref6(5);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_7_7);
                                text_7_7.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref7(5);
                                break;
                        }
                        break;
                    case 6:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_1_7);
                                text_1_7.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref1(6);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_2_7);
                                text_2_7.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref2(6);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_3_7);
                                text_3_7.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref3(6);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_4_7);
                                text_4_7.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref4(6);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_5_7);
                                text_5_7.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref5(6);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_6_7);
                                text_6_7.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref6(6);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_7_7);
                                text_7_7.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref7(6);
                                break;
                        }
                        break;
                    case 7:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_1_7);
                                text_1_7.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref1(7);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_2_7);
                                text_2_7.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref2(7);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_3_7);
                                text_3_7.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref3(7);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_4_7);
                                text_4_7.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref4(7);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_5_7);
                                text_5_7.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref5(7);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_6_7);
                                text_6_7.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref6(7);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_7_7);
                                text_7_7.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref7(7);
                                break;
                        }
                        break;
                    case 8:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_1_7);
                                text_1_7.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref1(8);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_2_7);
                                text_2_7.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref2(8);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_3_7);
                                text_3_7.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref3(8);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_4_7);
                                text_4_7.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref4(8);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_5_7);
                                text_5_7.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref5(8);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_6_7);
                                text_6_7.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref6(8);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_7_7);
                                text_7_7.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref7(8);
                                break;
                        }
                        break;
                    case 9:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_1_7);
                                text_1_7.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref1(9);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_2_7);
                                text_2_7.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref2(9);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_3_7);
                                text_3_7.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref3(9);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_4_7);
                                text_4_7.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref4(9);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_5_7);
                                text_5_7.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref5(9);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_6_7);
                                text_6_7.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref6(9);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_7_7);
                                text_7_7.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref7(9);
                                break;
                        }
                        break;
                    case 10:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_1_7);
                                text_1_7.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref1(10);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_2_7);
                                text_2_7.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref2(10);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_3_7);
                                text_3_7.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref3(10);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_4_7);
                                text_4_7.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref4(10);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_5_7);
                                text_5_7.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref5(10);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_6_7);
                                text_6_7.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref6(10);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_7_7);
                                text_7_7.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref7(10);
                                break;
                        }
                        break;
                    case 11:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_1_7);
                                text_1_7.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref1(11);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_2_7);
                                text_2_7.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref2(11);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_3_7);
                                text_3_7.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref3(11);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_4_7);
                                text_4_7.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref4(11);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_5_7);
                                text_5_7.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref5(11);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_6_7);
                                text_6_7.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref6(11);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_7_7);
                                text_7_7.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref7(11);
                                break;
                        }
                        break;
                    case 12:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_1_7);
                                text_1_7.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref1(12);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_2_7);
                                text_2_7.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref2(12);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_3_7);
                                text_3_7.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref3(12);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_4_7);
                                text_4_7.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref4(12);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_5_7);
                                text_5_7.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref5(12);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_6_7);
                                text_6_7.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref6(12);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_7_7);
                                text_7_7.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref7(12);
                                break;
                        }
                        break;
                    case 13:
                        switch (btn_position){
                            case 1:
                                btn_1_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_1_7);
                                text_1_7.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref1(13);
                                break;
                            case 2:
                                btn_2_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_2_7);
                                text_2_7.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref2(13);
                                break;
                            case 3:
                                btn_3_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_3_7);
                                text_3_7.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref3(13);
                                break;
                            case 4:
                                btn_4_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_4_7);
                                text_4_7.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref4(13);
                                break;
                            case 5:
                                btn_5_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_5_7);
                                text_5_7.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref5(13);
                                break;
                            case 6:
                                btn_6_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_6_7);
                                text_6_7.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref6(13);
                                break;
                            case 7:
                                btn_7_7.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_7_7);
                                text_7_7.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref7(13);
                                break;
                        }
                        break;
                }
                restartService();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DarkWindow);
        builder.setTitle("Select Action");
        builder.setView(listView);
        builder.setCancelable(true);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void setSelectActionAlertDialog8(final int btn_position){
        ListView listView = new ListView(this);
        String[] actions = new String[]{
                "1. None","2. Home","3. Notification","4. Control Center","5. Custom","6. Gesture", "7. Device", "8. Screenshot",
                "9. Screen Record", "10. Boost Device" , "11. Lock Device", "12. Power", "13. Status Bar","14. Open Recent"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,actions){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(ContextCompat.getColor(CustomizeLayoutActivity.this,R.color.white));
                return textView;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_1_8);
                                text_1_8.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref1(0);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_2_8);
                                text_2_8.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref2(0);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_3_8);
                                text_3_8.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref3(0);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_4_8);
                                text_4_8.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref4(0);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_5_8);
                                text_5_8.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref5(0);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_6_8);
                                text_6_8.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref6(0);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_7_8);
                                text_7_8.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref7(0);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_add_24));
                                setScaleSmall(btn_8_8);
                                text_8_8.setText(getText(R.string.None));
                                sharedPreferenceController.setActionsPref8(0);
                                break;
                        }
                        break;
                    case 1:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_1_8);
                                text_1_8.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref1(1);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_2_8);
                                text_2_8.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref2(1);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_3_8);
                                text_3_8.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref3(1);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_4_8);
                                text_4_8.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref4(1);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_5_8);
                                text_5_8.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref5(1);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_6_8);
                                text_6_8.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref6(1);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_7_8);
                                text_7_8.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref7(1);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.home_img));
                                setScaleSmall(btn_8_8);
                                text_8_8.setText(getText(R.string.Home));
                                sharedPreferenceController.setActionsPref8(1);
                                break;
                        }
                        break;
                    case 2:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_1_8);
                                text_1_8.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref1(2);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_2_8);
                                text_2_8.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref2(2);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_3_8);
                                text_3_8.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref3(2);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_4_8);
                                text_4_8.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref4(2);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_5_8);
                                text_5_8.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref5(2);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_6_8);
                                text_6_8.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref6(2);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_7_8);
                                text_7_8.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref7(2);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.notification_icon1));
                                setScaleDefault(btn_8_8);
                                text_8_8.setText(getText(R.string.Notifications));
                                sharedPreferenceController.setActionsPref8(2);
                                break;
                        }
                        break;
                    case 3:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_1_8);
                                text_1_8.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref1(3);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_2_8);
                                text_2_8.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref2(3);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_3_8);
                                text_3_8.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref3(3);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_4_8);
                                text_4_8.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref4(3);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_5_8);
                                text_5_8.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref5(3);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_6_8);
                                text_6_8.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref6(3);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_7_8);
                                text_7_8.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref7(3);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                serScaleLarge(btn_8_8);
                                text_8_8.setText(getText(R.string.Control_Center));
                                sharedPreferenceController.setActionsPref8(3);
                                break;
                        }
                        break;
                    case 4:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_1_8);
                                text_1_8.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref1(4);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_2_8);
                                text_2_8.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref2(4);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_3_8);
                                text_3_8.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref3(4);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_4_8);
                                text_4_8.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref4(4);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_5_8);
                                text_5_8.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref5(4);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_6_8);
                                text_6_8.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref6(4);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_7_8);
                                text_7_8.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref7(4);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.favorite_2));
                                setScaleOne(btn_8_8);
                                text_8_8.setText(getText(R.string.Custom));
                                sharedPreferenceController.setActionsPref8(4);
                                break;
                        }
                        break;
                    case 5:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_1_8);
                                text_1_8.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref1(5);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_2_8);
                                text_2_8.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref2(5);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_3_8);
                                text_3_8.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref3(5);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_4_8);
                                text_4_8.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref4(5);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_5_8);
                                text_5_8.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref5(5);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_6_8);
                                text_6_8.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref6(5);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_7_8);
                                text_7_8.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref7(5);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.gesture));
                                setScaleOne(btn_8_8);
                                text_8_8.setText(getText(R.string.Gesture));
                                sharedPreferenceController.setActionsPref8(5);
                                break;
                        }
                        break;
                    case 6:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_1_8);
                                text_1_8.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref1(6);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_2_8);
                                text_2_8.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref2(6);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_3_8);
                                text_3_8.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref3(6);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_4_8);
                                text_4_8.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref4(6);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_5_8);
                                text_5_8.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref5(6);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_6_8);
                                text_6_8.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref6(6);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_7_8);
                                text_7_8.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref7(6);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.device));
                                setScaleOne(btn_8_8);
                                text_8_8.setText(getText(R.string.Device));
                                sharedPreferenceController.setActionsPref8(6);
                                break;
                        }
                        break;
                    case 7:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_1_8);
                                text_1_8.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref1(7);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_2_8);
                                text_2_8.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref2(7);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_3_8);
                                text_3_8.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref3(7);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_4_8);
                                text_4_8.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref4(7);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_5_8);
                                text_5_8.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref5(7);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_6_8);
                                text_6_8.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref6(7);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_7_8);
                                text_7_8.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref7(7);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.screen_shot));
                                setScaleOne(btn_8_8);
                                text_8_8.setText(getText(R.string.screenshot));
                                sharedPreferenceController.setActionsPref8(7);
                                break;
                        }
                        break;
                    case 8:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_1_8);
                                text_1_8.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref1(8);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_2_8);
                                text_2_8.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref2(8);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_3_8);
                                text_3_8.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref3(8);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_4_8);
                                text_4_8.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref4(8);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_5_8);
                                text_5_8.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref5(8);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_6_8);
                                text_6_8.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref6(8);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_7_8);
                                text_7_8.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref7(8);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.record1));
                                setScaleOne(btn_8_8);
                                text_8_8.setText(getText(R.string.screen_nrecording));
                                sharedPreferenceController.setActionsPref8(8);
                                break;
                        }
                        break;
                    case 9:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_1_8);
                                text_1_8.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref1(9);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_2_8);
                                text_2_8.setText(getText(R.string.screen_recoder));
                                sharedPreferenceController.setActionsPref2(9);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_3_8);
                                text_3_8.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref3(9);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_4_8);
                                text_4_8.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref4(9);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_5_8);
                                text_5_8.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref5(9);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_6_8);
                                text_6_8.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref6(9);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_7_8);
                                text_7_8.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref7(9);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_boost_large_1));
                                setScaleOne(btn_8_8);
                                text_8_8.setText(getText(R.string.boost));
                                sharedPreferenceController.setActionsPref8(9);
                                break;
                        }
                        break;
                    case 10:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_1_8);
                                text_1_8.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref1(10);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_2_8);
                                text_2_8.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref2(10);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_3_8);
                                text_3_8.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref3(10);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_4_8);
                                text_4_8.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref4(10);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_5_8);
                                text_5_8.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref5(10);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_6_8);
                                text_6_8.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref6(10);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_7_8);
                                text_7_8.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref7(10);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_lock_24));
                                setScaleOne(btn_8_8);
                                text_8_8.setText(getText(R.string.lock_nscreen));
                                sharedPreferenceController.setActionsPref8(10);
                                break;
                        }
                        break;
                    case 11:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_1_8);
                                text_1_8.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref1(11);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_2_8);
                                text_2_8.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref2(11);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_3_8);
                                text_3_8.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref3(11);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_4_8);
                                text_4_8.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref4(11);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_5_8);
                                text_5_8.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref5(11);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_6_8);
                                text_6_8.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref6(11);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_7_8);
                                text_7_8.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref7(11);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_baseline_power_settings_new_24));
                                setScaleOne(btn_8_8);
                                text_8_8.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref8(11);
                                break;
                        }
                        break;
                    case 12:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_1_8);
                                text_1_8.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref1(12);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_2_8);
                                text_2_8.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref2(12);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_3_8);
                                text_3_8.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref3(12);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_4_8);
                                text_4_8.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref4(12);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_5_8);
                                text_5_8.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref5(12);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_6_8);
                                text_6_8.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref6(12);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_7_8);
                                text_7_8.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref7(12);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.control_center));
                                setScaleOne(btn_8_8);
                                text_8_8.setText(getText(R.string.open_nstatusbar));
                                sharedPreferenceController.setActionsPref8(12);
                                break;
                        }
                        break;
                    case 13:
                        switch (btn_position){
                            case 1:
                                btn_1_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_1_8);
                                text_1_8.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref1(13);
                                break;
                            case 2:
                                btn_2_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_2_8);
                                text_2_8.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref2(13);
                                break;
                            case 3:
                                btn_3_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_3_8);
                                text_3_8.setText(getText(R.string.power));
                                sharedPreferenceController.setActionsPref3(13);
                                break;
                            case 4:
                                btn_4_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_4_8);
                                text_4_8.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref4(13);
                                break;
                            case 5:
                                btn_5_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_5_8);
                                text_5_8.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref5(13);
                                break;
                            case 6:
                                btn_6_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_6_8);
                                text_6_8.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref6(13);
                                break;
                            case 7:
                                btn_7_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_7_8);
                                text_7_8.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref7(13);
                                break;
                            case 8:
                                btn_8_8.setImageDrawable(ContextCompat.getDrawable(CustomizeLayoutActivity.this,R.drawable.ic_recent_white));
                                setScaleOne(btn_8_8);
                                text_8_8.setText(getText(R.string.recent));
                                sharedPreferenceController.setActionsPref8(13);
                                break;
                        }
                        break;
                }
                restartService();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DarkWindow);
        builder.setTitle("Select Action");
        builder.setView(listView);
        builder.setCancelable(true);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private int pref_1_action(){
        return sharedPreferenceController.getActionsPref1();
    }

    private int pref_2_action(){
        return sharedPreferenceController.getActionsPref2();
    }

    private int pref_3_action(){
        return sharedPreferenceController.getActionsPref3();
    }

    private int pref_4_action(){
        return sharedPreferenceController.getActionsPref4();
    }

    private int pref_5_action(){
        return sharedPreferenceController.getActionsPref5();
    }

    private int pref_6_action(){
        return sharedPreferenceController.getActionsPref6();
    }

    private int pref_7_action(){
        return sharedPreferenceController.getActionsPref7();
    }

    private int pref_8_action(){
        return sharedPreferenceController.getActionsPref8();
    }

    private void setActionBar(){
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setScaleSmall(ImageButton imageButton){
        imageButton.setScaleY(0.7f);
        imageButton.setScaleX(0.7f);
    }

    private void setScaleDefault(ImageButton imageButton){
        imageButton.setScaleY(0.7f);
        imageButton.setScaleX(0.7f);
    }

    private void serScaleLarge(ImageButton imageButton){
        imageButton.setScaleY(0.7f);
        imageButton.setScaleX(0.7f);
    }

    private void setScaleOne(ImageButton imageButton){
        imageButton.setScaleY(0.7f);
        imageButton.setScaleX(0.7f);
    }
}