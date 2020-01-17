package com.example.library.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    MutableLiveData<?> mStringLive;
    @SuppressWarnings("unchecked")
    public <T> MutableLiveData<T> get() {
        if (mStringLive == null) {
            mStringLive = new MutableLiveData<T>();
        }
        return (MutableLiveData<T>) mStringLive;
    }
}
