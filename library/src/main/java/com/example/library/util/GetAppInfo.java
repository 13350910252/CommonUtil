package com.example.library.util;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;

public class GetAppInfo {
    /**
     * 获取本app的版本信息
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {//如果报名不存在
            e.printStackTrace();
        }
//        PackageItemInfo
//        ActivityInfo
        String version = packInfo.versionName;
        int versionCode = packInfo.versionCode;
        return version;
    }
}
