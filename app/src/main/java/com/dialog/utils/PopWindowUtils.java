package com.dialog.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * 自定义多样化的dialog
 */
public class PopWindowUtils extends BasePopUpWindow {

    private AppCompatTextView actvTitle;
    private View inflate;

    private AppCompatTextView actvContent;
    private AppCompatButton btnCancel;
    private AppCompatButton btnCommit;

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
        actvContent = (AppCompatTextView) inflate.findViewById(R.id.actv_content);
        btnCancel = (AppCompatButton) inflate.findViewById(R.id.btn_cancel);
        btnCommit = (AppCompatButton) inflate.findViewById(R.id.btn_commit);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getOnCickListener() != null) {
                    dismiss();
                    getOnCickListener().onLeftClickListener(actvContent.getText().toString());
                }
            }
        });

        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getOnCickListener() != null) {
                    dismiss();
                    getOnCickListener().onRightClickListener(actvContent.getText().toString());
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

    /**
     * 设置内容模块
     *
     * @param content
     * @return
     */
    public PopWindowUtils setContent(String content) {
        if (actvContent != null) {
            actvContent.setText(content);
        }
        return this;

    }


//    /**
//     * 设置view位置
//     *
//     * @param location
//     * @param x
//     * @param y
//     * @param is       是否点击空白区域和返回键消失
//     */
//
//    public void showAtLocation(int location, int x, int y, boolean is) {
//        setAlpha(0.5f);
//        setFocusable(is);
//        showAtLocation(inflate, location, x, y);
//    }


//    @Override
//    public void dismiss() {
//        super.dismiss();
//        setAlpha(1f);//重置背景透明度
//    }

//    /**
//     * 设置背景透明度
//     */
//    private void setAlpha(float f) {
//        if (mActivity != null) {
//            //设置背景半透明
//            WindowManager.LayoutParams attributes = mActivity.getWindow().getAttributes();
//
//            attributes.alpha = f;
//
//            mActivity.getWindow().setAttributes(attributes);
//        }
//
//
//    }


}
