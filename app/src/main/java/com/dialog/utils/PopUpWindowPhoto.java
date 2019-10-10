package com.dialog.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class PopUpWindowPhoto extends BasePopUpWindow {

    private View inflate;

    public PopUpWindowPhoto(Context context, Activity activity) {
        super(context, activity);
    }

    @Override
    public View getView() {
        inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_photo, null);
        return inflate;
    }

    @Override
    protected void initView() {

    }
}
