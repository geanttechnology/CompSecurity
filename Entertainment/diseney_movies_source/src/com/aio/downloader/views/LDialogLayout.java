// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

public class LDialogLayout extends LinearLayout
{

    private float mMaxWidthWeight;
    private float mMinWidthWeight;
    private DisplayMetrics metrics;

    public LDialogLayout(Context context)
    {
        super(context);
        mMaxWidthWeight = 0.9F;
        mMinWidthWeight = 0.55F;
    }

    public LDialogLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mMaxWidthWeight = 0.9F;
        mMinWidthWeight = 0.55F;
        metrics = getContext().getResources().getDisplayMetrics();
    }

    protected void onMeasure(int i, int j)
    {
        float f;
        if (metrics.widthPixels < metrics.heightPixels)
        {
            f = mMaxWidthWeight;
        } else
        {
            f = mMinWidthWeight;
        }
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec((int)((float)metrics.widthPixels * f), 0x40000000), j);
    }
}
