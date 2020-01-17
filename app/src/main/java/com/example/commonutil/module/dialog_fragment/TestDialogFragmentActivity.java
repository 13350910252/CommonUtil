package com.example.commonutil.module.dialog_fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.commonutil.R;
import com.example.commonutil.base.AppBaseFragmentActivity;
import com.example.library.dialog_fragment.MyDialogFragment;

public class TestDialogFragmentActivity extends AppBaseFragmentActivity implements MyDialogFragment.OnViewCreatedListener {
    Button btn_dialog_fragment_one;
    Button btn_dialog_fragment_two;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);
        initViews();
    }

    @Override
    public void initViews() {
        super.initViews();
        btn_dialog_fragment_one = findViewById(R.id.btn_dialog_fragment_one);
        btn_dialog_fragment_two = findViewById(R.id.btn_dialog_fragment_two);

        btn_dialog_fragment_one.setOnClickListener(this);
        btn_dialog_fragment_two.setOnClickListener(this);
    }

    Button btn_dialog_fragment_left;
    Button btn_dialog_fragment_right;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dialog_fragment_one:
                View view = LayoutInflater.from(TestDialogFragmentActivity.this)
                        .inflate(R.layout.dialog_one, null, false);
                btn_dialog_fragment_left = view.findViewById(R.id.btn_dialog_fragment_left);
                btn_dialog_fragment_right = view.findViewById(R.id.btn_dialog_fragment_right);
                final MyDialogFragment dialogFragment = MyDialogFragment.getInstance(view, true);
                dialogFragment.setLocation(Gravity.BOTTOM);
                dialogFragment.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
                dialogFragment.show(getSupportFragmentManager(), "one");
                btn_dialog_fragment_left.setText("取消");
                btn_dialog_fragment_right.setText("确定");
                btn_dialog_fragment_left.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogFragment.dismiss();
                    }
                });
                btn_dialog_fragment_right.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "ok", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_dialog_fragment_two:
                dialogFragment1 = MyDialogFragment.getInstance(null, false);
                dialogFragment1.show(getSupportFragmentManager(), "two");

                break;
            default:
        }
    }

    MyDialogFragment dialogFragment1;

    @Override
    public void onViewCreated(View view) {
        Button cancel = (Button) view.getTag(R.id.left_key);
        Button sure = (Button) view.getTag(R.id.right_key);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFragment1.dismiss();
            }
        });
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "ssss", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
