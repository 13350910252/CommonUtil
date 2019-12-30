package com.example.library.livedata;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    MutableLiveData<?> mStringLive;

    public <T> MutableLiveData get() {
        if (mStringLive == null) {
            mStringLive = new MutableLiveData<T>();
        }
        return mStringLive;
    }
}
