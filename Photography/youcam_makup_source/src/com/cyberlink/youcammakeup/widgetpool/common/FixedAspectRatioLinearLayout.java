// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.cyberlink.youcammakeup.j;

public class FixedAspectRatioLinearLayout extends LinearLayout
{

    private int a;
    private int b;

    public FixedAspectRatioLinearLayout(Context context)
    {
        super(context);
        a = -1;
        b = -1;
    }

    public FixedAspectRatioLinearLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = -1;
        b = -1;
        context = context.obtainStyledAttributes(attributeset, j.FixedAspectRatioLayoutArgs);
        a = context.getInteger(0, 1);
        b = context.getInteger(1, 1);
        context.recycle();
    }

    public FixedAspectRatioLinearLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = -1;
        b = -1;
        context = context.obtainStyledAttributes(attributeset, j.FixedAspectRatioLayoutArgs);
        a = context.getInteger(0, 1);
        b = context.getInteger(1, 1);
        context.recycle();
    }

    protected void onMeasure(int i, int k)
    {
        super.onMeasure(i, k);
        if (a != 0 && b != 0)
        {
            int l = getMeasuredWidth();
            int i1 = getMeasuredHeight();
            if (i1 == 0 && l != 0)
            {
                k = (int)(((double)b / (double)a) * (double)l);
                setMeasuredDimension(l, k);
                measureChildren(i, android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000));
            } else
            if (l == 0 && i1 != 0)
            {
                i = (int)(((double)a / (double)b) * (double)i1);
                setMeasuredDimension(i, i1);
                measureChildren(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), k);
                return;
            }
        }
    }
}
