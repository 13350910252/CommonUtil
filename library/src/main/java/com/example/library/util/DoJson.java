package com.example.library.util;

import android.util.Log;

/**
 * android中存储的json字符串中会出现一些多余的\和"，需要做一些处理
 */
public class DoJson {
    //将普通的字符串转换为json类型的字符串
    public static String StringToJsonString(String temp) {
        while (temp.contains("\\")) {
            temp = temp.replace("\\", "");
        }
        while (temp.contains("\"[\"{")) {
            int index = temp.indexOf("\"[\"{");
            temp = temp.substring(0, index) + "[{" + temp.substring(index + 4, temp.length());
            int index1 = temp.indexOf("}\"]\"");
            temp = temp.substring(0, index1) + "}]" + temp.substring(index1 + 4, temp.length());
        }
//        Log.d("abcd", "StringToJsonString: "+temp);
        while (temp.contains("\"[")) {
            int index = temp.indexOf("\"[");
            temp = temp.substring(0, index) + "[" + temp.substring(index + 2, temp.length());
            int index1 = temp.indexOf("]\"");
            temp = temp.substring(0, index1) + "]" + temp.substring(index1 + 2, temp.length());
        }
        while (temp.contains("\"}\"")) {
            int index2 = temp.indexOf("\"}\"");
            temp = temp.substring(0, index2 + 2) + "," + temp.substring(index2 + 5, temp.length());
        }
        return temp;
    }
}
