package com.dialog.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * 扩展弹窗继承即可
 */
public abstract class BasePopUpWindow extends PopupWindow {

    private View mView;
    public Context mContext;
    public Activity mActivity;


    /**
     * 单纯弹窗  无背景
     *
     * @param context
     */
    public BasePopUpWindow(Context context) {
        super(context);
        mContext = context;
        init();

    }

    /**
     * 是否设置背景
     *
     * @param context
     * @param activity
     */
    public BasePopUpWindow(Context context, Activity activity) {
        super(context);
        mContext = context;
        mActivity = activity;
        init();
    }

    /**
     * 设置宽高
     *
     * @param width
     * @param height
     * @param context
     * @param activity
     */
    public BasePopUpWindow(int width, int height, Context context, Activity activity) {
        super(width, height);
        mContext = context;
        mActivity = activity;
        init();
    }

    public abstract View getView();

    private void init() {

        mView = getView();

        if (mView != null) {

            setContentView(mView);
        }

        //去除黑边
        setBackgroundDrawable(new ColorDrawable(0x00000000));

        initView();
    }

    protected abstract void initView();


    /**
     * 设置view位置
     *
     * @param location
     * @param x
     * @param y
     * @param is       是否点击空白区域和返回键消失  true 消失 并且监听返回键
     */

    public void showAtLocation(int location, int x, int y, boolean is) {
        setAlpha(0.5f);
        setFocusable(is);
        if (mView != null) {
            showAtLocation(mView, location, x, y);
        }

    }

    @Override
    public void dismiss() {
        super.dismiss();
        setAlpha(1f);//重置背景透明度
    }

    /**
     * 设置背景透明度
     */
    private void setAlpha(float f) {
        if (mActivity != null) {
            //设置背景半透明
            WindowManager.LayoutParams attributes = mActivity.getWindow().getAttributes();

            attributes.alpha = f;

            mActivity.getWindow().setAttributes(attributes);
        }


    }

    private OnCickListener mOnCickListener;

    public OnCickListener getOnCickListener() {
        return mOnCickListener;
    }

    public BasePopUpWindow setOnCickListener(OnCickListener onCickListener) {
        mOnCickListener = onCickListener;
        return this;
    }

    public interface OnCickListener {

        void onLeftClickListener(String content);

        void onRightClickListener(String content);

        void onCancelClickLietener();
    }
}
