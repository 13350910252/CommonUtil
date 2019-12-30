package com.example.commonutil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.commonutil.base.AppBaseActivity;
import com.example.commonutil.module.dialog_fragment.TestDialogFragmentActivity;
import com.example.commonutil.module.json.activity.TestJsonActivity;
import com.example.commonutil.module.json.activity.TestJsonOneActivity;
import com.example.library.util.DoJson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppBaseActivity {
    TextView tv_main_json;
    TextView tv_test_dialog_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        bindData();
//        startActivity(new Intent(MainActivity.this, TestLiveDataActivity.class));
    }

    @Override
    public void initViews() {
        super.initViews();
        tv_main_json = findViewById(R.id.tv_main_json);
        tv_test_dialog_fragment = findViewById(R.id.tv_test_dialog_fragment);

        tv_main_json.setOnClickListener(this);
        tv_test_dialog_fragment.setOnClickListener(this);
    }

    @Override
    public void bindData() {
        super.bindData();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.tv_main_json:
                startActivity(new Intent(mContext, TestJsonActivity.class));
                break;
            case R.id.tv_test_dialog_fragment:
                startActivity(new Intent(mContext, TestDialogFragmentActivity.class));
                break;
            default:
        }
    }
}
