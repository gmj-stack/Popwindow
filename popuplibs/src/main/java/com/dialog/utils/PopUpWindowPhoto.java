package com.dialog.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * 拍照 相册
 */
public class PopUpWindowPhoto extends BasePopUpWindow {

    private View convertView;
    private AppCompatTextView mBtnTake;
    private AppCompatTextView mBtnPhoto;
    private AppCompatTextView mBtnCancel;


    public PopUpWindowPhoto(Context context, Activity activity) {
        super(context, activity);
    }

    public PopUpWindowPhoto(int width, int height, Context context) {
        super(width, height, context);
    }

    public PopUpWindowPhoto(int width, int height, Context context, Activity activity) {
        super(width, height, context, activity);
    }

    @Override
    public View getView() {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.dialog_photo, null);
        return convertView;
    }

    @Override
    protected void initView() {
        mBtnTake = (AppCompatTextView) convertView.findViewById(R.id.btn_take);
        mBtnPhoto = (AppCompatTextView) convertView.findViewById(R.id.btn_photo);
        mBtnCancel = (AppCompatTextView) convertView.findViewById(R.id.btn_cancel);

        mBtnTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (getOnCickListener() != null) {
                    getOnCickListener().onLeftClickListener("");
                }
            }
        });

        mBtnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (getOnCickListener() != null) {
                    getOnCickListener().onRightClickListener("");
                }
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }
}
