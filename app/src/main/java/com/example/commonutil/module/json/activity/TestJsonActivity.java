package com.example.commonutil.module.json.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.commonutil.R;
import com.example.commonutil.base.AppBaseActivity;

public class TestJsonActivity extends AppBaseActivity {
    TextView tv_json_one;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        initViews();

    }

    @Override
    public void initViews() {
        super.initViews();
        tv_json_one = findViewById(R.id.tv_json_one);

        tv_json_one.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.tv_json_one:
                startActivity(new Intent(mContext, TestJsonOneActivity.class));
                break;
            default:
        }
    }
}
