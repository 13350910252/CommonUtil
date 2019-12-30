package com.example.commonutil.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.commonutil.R;
import com.example.library.livedata.MyViewModel;

public class TestLiveDataActivity extends AppCompatActivity {
    MyViewModel myViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        myViewModel = ViewModelProviders.of(TestLiveDataActivity.this).get(MyViewModel.class);
        final MutableLiveData<String> mutableLiveData = myViewModel.<String>get();
        final MutableLiveData<Integer> mutableLiveData1 = myViewModel.<Integer>get();
        findViewById(R.id.btn_live_data_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mutableLiveData.setValue("fdfdf");
                mutableLiveData1.setValue(222);
            }
        });
        Log.d("abcd", "onCreate: ");
        mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String o) {
                Log.d("abcd", "onChanged: " + o);
            }
        });
        mutableLiveData1.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer o) {
                Log.d("abcd", "onChanged: "+o);
            }
        });
    }
}
