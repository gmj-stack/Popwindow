package com.dialog.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import org.w3c.dom.Text;

/**
 * 自定义多样化的dialog
 */
public class PopWindowUtils extends BasePopUpWindow {

    private AppCompatTextView actvTitle;
    private View inflate;
    private RelativeLayout mRelativeLayout;
    private AppCompatButton btnCancel;
    private AppCompatButton btnCommit;
    private String content;

//    public static PopWindowUtils getInstance(Context context) {
//
//        return Singleton.mPopWindowUtils;
//    }
//
//    private static class Singleton {
//        private static PopWindowUtils mPopWindowUtils = new PopWindowUtils();
//
//    }

//    private PopWindowUtils() {
//    }

    public PopWindowUtils(Context context) {
        super(context);

    }

    public PopWindowUtils(Context context, Activity activity) {
        super(context, activity);

    }


    @Override
    public View getView() {
        if (mContext != null) {
            inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog, null);
        }
        return inflate;
    }

    @Override
    public void initView() {
        actvTitle = (AppCompatTextView) inflate.findViewById(R.id.actv_title);
        btnCancel = (AppCompatButton) inflate.findViewById(R.id.btn_cancel);
        btnCommit = (AppCompatButton) inflate.findViewById(R.id.btn_commit);
        mRelativeLayout = inflate.findViewById(R.id.rl_addview);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getOnCickListener() != null) {
                    dismiss();
                    getOnCickListener().onLeftClickListener(content);
                }
            }
        });

        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getOnCickListener() != null) {
                    dismiss();
                    getOnCickListener().onRightClickListener(content);
                }
            }
        });

    }

    /**
     * 设置头部文字
     *
     * @param title 头部文字
     */
    public PopWindowUtils setTvTitle(String title, float size, String color) {
        if (actvTitle != null) {
            actvTitle.setText(title);
            if (size != 0) {
                actvTitle.setTextSize(size);
            }
            if (color != null && !color.isEmpty()) {
                actvTitle.setTextColor(Color.parseColor(color));
            }

        }
        return this;
    }


    public PopWindowUtils addView(View view) {
        //当添加的是edittext时  将获取输入的内容
        if (view instanceof EditText) {
            setFocusable(true);
            content = ((EditText) view).getText().toString().trim();
        }
        //当添加的是edittext时  将获取输入的内容
        if (view instanceof TextView) {
            content = ((TextView) view).getText().toString().trim();
        }
        mRelativeLayout.addView(view);
        return this;
    }

    /**
     * 设置按钮背景颜色
     */
    public PopWindowUtils setBtnBackColor(int cancel, int commit) {
        if (btnCancel != null) {
            btnCancel.setBackgroundColor(cancel);
        }
        if (btnCommit != null) {
            btnCommit.setBackgroundColor(commit);
        }
        return this;
    }

    /**
     * 设置按钮文字
     */
    public PopWindowUtils setBtnTextString(String cancel, String commit) {
        if (btnCancel != null) {
            btnCancel.setText(cancel);
        }
        if (btnCommit != null) {
            btnCommit.setText(commit);
        }
        return this;
    }

    /**
     * 设置内容模块
     *
     * @param content
     * @return
     */
//    public PopWindowUtils setContent(String content) {
//        if (actvContent != null) {
//            actvContent.setText(content);
//        }
//        return this;
//
//    }


}
