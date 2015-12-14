// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryToast

private class ns_AviaryToast
{

    final Runnable mHide = new Runnable() {

        final AviaryToast.TN this$1;

        public void run()
        {
            handleHide();
        }

            
            {
                this$1 = AviaryToast.TN.this;
                super();
            }
    };
    android.view.ayoutParams mParams;
    final Runnable mShow = new Runnable() {

        final AviaryToast.TN this$1;

        public void run()
        {
            handleShow();
        }

            
            {
                this$1 = AviaryToast.TN.this;
                super();
            }
    };
    WindowManager mWm;
    final AviaryToast this$0;

    public void handleHide()
    {
        removeView();
        if (AviaryToast.access$000(AviaryToast.this) != null)
        {
            AviaryToast.access$000(AviaryToast.this).onHidden();
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
            if (AviaryToast.access$000(AviaryToast.this) != null)
            {
                AviaryToast.access$000(AviaryToast.this).onShown(mView);
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

    _cls2.this._cls1()
    {
        this$0 = AviaryToast.this;
        super();
        mParams = new android.view.ayoutParams();
        aviarytoast = mParams;
        height = -2;
        width = -2;
        flags = 152;
        format = -3;
        type = 2005;
        windowAnimations = com.aviary.android.feather.sdk.nimations_AviaryToast;
        setTitle("Toast");
    }
}
