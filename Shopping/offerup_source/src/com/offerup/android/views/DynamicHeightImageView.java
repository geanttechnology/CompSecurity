// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class DynamicHeightImageView extends ImageView
{

    private double a;

    public DynamicHeightImageView(Context context)
    {
        super(context);
    }

    public DynamicHeightImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public double getHeightRatio()
    {
        return a;
    }

    protected void onMeasure(int i, int j)
    {
        if (a > 0.0D)
        {
            i = android.view.View.MeasureSpec.getSize(i);
            setMeasuredDimension(i, (int)((double)i * a));
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
