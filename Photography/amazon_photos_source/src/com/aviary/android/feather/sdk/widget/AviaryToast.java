// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

public class AviaryToast
{
    public static interface LayoutListener
    {

        public abstract void onHidden();

        public abstract void onShown(View view);
    }

    private class TN
    {

        final Runnable mHide = new _cls2();
        android.view.WindowManager.LayoutParams mParams;
        final Runnable mShow = new _cls1();
        WindowManager mWm;
        final AviaryToast this$0;

        public void handleHide()
        {
            removeView();
            if (mLayoutListener != null)
            {
                mLayoutListener.onHidden();
            }
        }

        public void handleShow()
        {
            if (mView != mNextView)
            {
                handleHide();
                mView = mNextView;
                int i = mGravity;
                mParams.gravity = i;
                if ((i & 7) == 7)
                {
                    mParams.horizontalWeight = 1.0F;
                }
                if ((i & 0x70) == 112)
                {
                    mParams.verticalWeight = 1.0F;
                }
                mParams.x = mX;
                mParams.y = mY;
                mParams.verticalMargin = mVerticalMargin;
                mParams.horizontalMargin = mHorizontalMargin;
                if (mView.getParent() != null)
                {
                    mView.setVisibility(8);
                    mWm.removeView(mView);
                }
                mWm.addView(mView, mParams);
                mView.setVisibility(0);
                if (mLayoutListener != null)
                {
                    mLayoutListener.onShown(mView);
                }
            }
        }

        public void hide()
        {
            mHandler.post(mHide);
        }

        void removeView()
        {
            if (mView != null)
            {
                if (mView.getParent() != null)
                {
                    mView.setVisibility(8);
                    mWm.removeView(mView);
                }
                mView = null;
            }
        }

        public void show()
        {
            mHandler.post(mShow);
        }

        TN()
        {
            this$0 = AviaryToast.this;
            super();
            mParams = new android.view.WindowManager.LayoutParams();
            aviarytoast = mParams;
            height = -2;
            width = -2;
            flags = 152;
            format = -3;
            type = 2005;
            windowAnimations = com.aviary.android.feather.sdk.R.style.AviaryAnimations_AviaryToast;
            setTitle("Toast");
        }
    }


    static final String LOG_TAG = "AviaryToast";
    Context mContext;
    int mDuration;
    int mGravity;
    final Handler mHandler = new Handler();
    float mHorizontalMargin;
    private LayoutListener mLayoutListener;
    View mNextView;
    final TN mTN = new TN();
    float mVerticalMargin;
    View mView;
    WindowManager mWindowManager;
    int mX;
    int mY;

    public AviaryToast(Context context)
    {
        mGravity = 17;
        mContext = context;
        mWindowManager = (WindowManager)context.getSystemService("window");
        mTN.mWm = mWindowManager;
        mY = 0;
        mX = 0;
    }

    public static AviaryToast make(Context context, int i, int j)
    {
        AviaryToast aviarytoast = new AviaryToast(context);
        aviarytoast.mNextView = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(i, null);
        aviarytoast.mDuration = j;
        return aviarytoast;
    }

    public View getView()
    {
        return mNextView;
    }

    public void hide()
    {
        mTN.hide();
    }

    public void setLayoutListener(LayoutListener layoutlistener)
    {
        mLayoutListener = layoutlistener;
    }

    public void setView(View view)
    {
        mNextView = view;
    }

    public void show()
    {
        if (mNextView == null)
        {
            throw new RuntimeException("setView must be called first");
        } else
        {
            mTN.show();
            return;
        }
    }

    public void update()
    {
    }


    // Unreferenced inner class com/aviary/android/feather/sdk/widget/AviaryToast$TN$1

/* anonymous class */
    class TN._cls1
        implements Runnable
    {

        final TN this$1;

        public void run()
        {
            handleShow();
        }

            
            {
                this$1 = TN.this;
                super();
            }
    }


    // Unreferenced inner class com/aviary/android/feather/sdk/widget/AviaryToast$TN$2

/* anonymous class */
    class TN._cls2
        implements Runnable
    {

        final TN this$1;

        public void run()
        {
            handleHide();
        }

            
            {
                this$1 = TN.this;
                super();
            }
    }

}
