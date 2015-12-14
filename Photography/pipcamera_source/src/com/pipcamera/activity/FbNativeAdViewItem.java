// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class FbNativeAdViewItem extends FrameLayout
{

    private Context mContext;
    private View view;

    public FbNativeAdViewItem(Context context)
    {
        super(context);
        mContext = context;
        view = inflate(mContext, 0x7f03003b, this);
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final FbNativeAdViewItem a;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = FbNativeAdViewItem.this;
                super();
            }
        });
    }

    private void resetView(View view1)
    {
        float f1 = mContext.getResources().getDisplayMetrics().widthPixels;
        float f = f1 / 8F;
        f1 -= f;
        float f2 = (207F * f1) / 300F;
        float f3 = f / 2.0F;
        f /= 2.0F;
        Object obj = (FrameLayout)view1.findViewById(0x7f0c0076);
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)((FrameLayout) (obj)).getLayoutParams();
        layoutparams.width = (int)f1;
        layoutparams.height = (int)f2;
        layoutparams.leftMargin = (int)f3;
        layoutparams.rightMargin = (int)f;
        layoutparams.topMargin = (int)f3;
        layoutparams.bottomMargin = (int)f;
        ((FrameLayout) (obj)).setLayoutParams(layoutparams);
        view1 = (FrameLayout)view1.findViewById(0x7f0c010d);
        obj = (android.widget.FrameLayout.LayoutParams)view1.getLayoutParams();
        obj.width = (int)f1;
        obj.height = 1;
        obj.leftMargin = (int)f3;
        obj.rightMargin = (int)f;
        view1.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
    }

    public void setData()
    {
        resetView(view);
    }
}
