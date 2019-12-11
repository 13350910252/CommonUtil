package com.example.library.util;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

public class ViewIsEmpty {
    /**
     * 可以传入多个TextView，只要有一个为null，就返回false
     *
     * @param textViews
     * @return
     */
    public static boolean isTextViewEmpty(TextView... textViews) {
        for (TextView textView : textViews) {
            if (TextUtils.isEmpty(textView.getText())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 可以传入多个TextView，只要有一个为null，就返回false
     *
     * @param editTexts
     * @return
     */
    public static boolean isEditTextEmpty(EditText... editTexts) {
        for (EditText editText : editTexts) {
            if (TextUtils.isEmpty(editText.getText())) {
                return false;
            }
        }
        return true;
    }
}
