// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class DynamicHeightImageView extends ImageView
{

    public boolean a;
    private double b;

    public DynamicHeightImageView(Context context)
    {
        super(context);
    }

    public DynamicHeightImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onMeasure(int i, int j)
    {
        if (b > 0.0D)
        {
            j = android.view.View.MeasureSpec.getSize(i);
            int k = (int)((double)j * b);
            i = k;
            if (a)
            {
                i = k;
                if (k > j)
                {
                    i = j;
                }
            }
            setMeasuredDimension(j, i);
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }

    public void setHeightRatio(double d)
    {
        if (d != b)
        {
            b = d;
            requestLayout();
        }
    }
}
