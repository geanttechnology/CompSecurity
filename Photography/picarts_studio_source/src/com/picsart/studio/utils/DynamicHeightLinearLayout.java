// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class DynamicHeightLinearLayout extends LinearLayout
{

    private double a;

    public DynamicHeightLinearLayout(Context context)
    {
        super(context);
        a = 0.0D;
    }

    public DynamicHeightLinearLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 0.0D;
    }

    protected void onMeasure(int i, int j)
    {
        if (a > 0.0D)
        {
            super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec((int)((double)android.view.View.MeasureSpec.getSize(i) * a), 0x40000000));
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }

    public void setHeightRatio(double d)
    {
        if (d != a)
        {
            a = d;
            requestLayout();
        }
    }
}
