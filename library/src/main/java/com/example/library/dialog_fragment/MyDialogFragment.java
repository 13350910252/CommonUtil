package com.example.library.dialog_fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.library.R;

public class MyDialogFragment extends DialogFragment {
    private View contentView;
    private int backgroundID = R.drawable.dialog_bg_white;//背景的资源id
    private int location = Gravity.CENTER;//位置上下左右中,默认居中
    private int width = WindowManager.LayoutParams.WRAP_CONTENT;
    private int height = WindowManager.LayoutParams.WRAP_CONTENT;
    private boolean isCustom = false;

    public static MyDialogFragment getInstance(View view, boolean isCustom) {
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.contentView = view;
        myDialogFragment.isCustom = isCustom;
        return myDialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (isCustom) {
            return contentView;
        } else {
            contentView = inflater.inflate(R.layout.dialog_fragment_normal, null, false);
            return contentView;
        }
    }

    public View getContentView() {
        return contentView;
    }

    private TextView tv_dialog_fragment_title;
    private TextView tv_dialog_fragment_content;
    private Button btn_dialog_fragment_left;
    private Button btn_dialog_fragment_right;
    private OnViewCreatedListener onViewCreatedListener;
    public interface OnViewCreatedListener{
        void onViewCreated(View view);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!isCustom) {
            tv_dialog_fragment_title = view.findViewById(R.id.tv_dialog_fragment_title);
            tv_dialog_fragment_content = view.findViewById(R.id.tv_dialog_fragment_content);
            btn_dialog_fragment_left = view.findViewById(R.id.btn_dialog_fragment_left);
            btn_dialog_fragment_right = view.findViewById(R.id.btn_dialog_fragment_right);
            view.setTag(R.id.right_key, btn_dialog_fragment_right);
            view.setTag(R.id.left_key, btn_dialog_fragment_left);
            onViewCreatedListener = (OnViewCreatedListener) getContext();
            if (onViewCreatedListener != null){
                onViewCreatedListener.onViewCreated(view);
            }
        }
    }

    //如果需要全屏，则必须设置background
    public void setBackgroundID(int backgroundID) {
        this.backgroundID = backgroundID;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.getDecorView().setBackgroundResource(backgroundID);
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.width = width;
                lp.height = height;
                lp.gravity = location;
                setAnimation();
                lp.windowAnimations = style;
                window.setAttributes(lp);
            }
        }

    }

    private int style;

    //根据位置来设置进入和退出时的动画
    public void setAnimation() {
        switch (location) {
            case Gravity.CENTER:
                style = R.style.DialogCenter;
                break;
            case Gravity.START:

                break;
            case Gravity.END:

                break;
            case Gravity.TOP:

                break;
            case Gravity.BOTTOM:
                style = R.style.DialogBottom;
                break;
            default:
        }
    }

}
