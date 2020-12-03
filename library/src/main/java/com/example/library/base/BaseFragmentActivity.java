package com.example.library.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.example.library.R;

public class BaseFragmentActivity extends FragmentActivity {
    public Context mContext;
    public Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivity = this;
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.pl_right_in, R.anim.pl_left_out);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.pl_right_in, R.anim.pl_left_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pl_left_in, R.anim.pl_right_out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.pl_left_in, R.anim.pl_right_out);
    }
}
