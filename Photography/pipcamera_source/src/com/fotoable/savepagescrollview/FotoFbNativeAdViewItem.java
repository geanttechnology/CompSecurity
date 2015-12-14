// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.savepagescrollview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class FotoFbNativeAdViewItem extends FrameLayout
{

    FrameLayout divLine;
    private Context mContext;
    private View view;

    public FotoFbNativeAdViewItem(Context context)
    {
        super(context);
        mContext = context;
        view = inflate(mContext, com.fotoable.fotoadpackage.R.layout.fb_native_adview, this);
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final FotoFbNativeAdViewItem a;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = FotoFbNativeAdViewItem.this;
                super();
            }
        });
    }

    private void resetView(View view1)
    {
        float f1 = mContext.getResources().getDisplayMetrics().widthPixels;
        float f = f1 / 16F;
        f1 -= f;
        float f2 = (207F * f1) / 300F;
        f2 = f / 2.0F;
        f /= 2.0F;
        divLine = (FrameLayout)view1.findViewById(com.fotoable.fotoadpackage.R.id.divider_line);
        view1 = (android.widget.FrameLayout.LayoutParams)divLine.getLayoutParams();
        view1.width = (int)f1;
        view1.height = 1;
        view1.leftMargin = (int)f2;
        view1.rightMargin = (int)f;
        divLine.setLayoutParams(view1);
        hideDivLine();
    }

    public void hideDivLine()
    {
        divLine.setVisibility(4);
    }

    public void setData()
    {
        resetView(view);
    }
}
