package com.dialog.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * 加载弹窗
 */
public class PopDIalogLoading extends BasePopUpWindow {

    public PopDIalogLoading(Context context, Activity activity) {
        super(context, activity);
    }

    @Override
    public View getView() {

        return LayoutInflater.from(mContext).inflate(R.layout.dialog_loading, null);
    }

    @Override
    protected void initView() {

    }
}
