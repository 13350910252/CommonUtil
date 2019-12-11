package com.example.commonutil.test;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.commonutil.R;
import com.example.library.util.TestLifeCycleObserver;

//Fragment和Activity中的使用方法一致，此处只展示如何使用，Activity必须继承自AppCompatActivity
public class TestLifeCycleObserverActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new TestLifeCycleObserver());
    }
}
