package com.dialog.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class TestDialog extends BasePopUpWindow {

    public TestDialog(Context context) {
        super(context);
    }

    @Override
    public View getView() {
        return LayoutInflater.from(mContext).inflate(R.layout.test, null);
    }

    @Override
    protected void initView() {
        View viewById = mView.findViewById(R.id.button5);
    }
}
