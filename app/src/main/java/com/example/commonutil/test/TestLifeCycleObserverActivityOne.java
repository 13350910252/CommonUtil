package com.example.commonutil.test;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

import com.example.commonutil.R;
import com.example.library.util.TestLifeCycleObserver;

//在Activity中的使用方法
public class TestLifeCycleObserverActivityOne extends Activity implements LifecycleOwner {
    private LifecycleRegistry mLifecycleRegistry;

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        //返回Lifecycles
        return mLifecycleRegistry;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建Lifecycle对象
        mLifecycleRegistry = new LifecycleRegistry(this);
        //标记状态
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        //添加观察者
        getLifecycle().addObserver(new TestLifeCycleObserver());
    }

    @Override
    public void onStart() {
        super.onStart();
        //标记状态
        mLifecycleRegistry.markState(Lifecycle.State.STARTED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //标记状态
        mLifecycleRegistry.markState(Lifecycle.State.RESUMED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //标记状态
        mLifecycleRegistry.markState(Lifecycle.State.DESTROYED);
    }
}
