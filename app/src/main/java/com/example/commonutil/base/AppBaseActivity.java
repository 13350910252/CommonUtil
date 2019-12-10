package com.example.commonutil.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.library.base.BaseActivity;

public class AppBaseActivity extends BaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {

    }
}
