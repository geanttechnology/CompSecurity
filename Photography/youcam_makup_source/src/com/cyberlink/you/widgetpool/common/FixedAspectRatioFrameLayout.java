// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.cyberlink.you.t;

public class FixedAspectRatioFrameLayout extends FrameLayout
{

    private int a;
    private int b;

    public FixedAspectRatioFrameLayout(Context context)
    {
        super(context);
        a = -1;
        b = -1;
    }

    public FixedAspectRatioFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = -1;
        b = -1;
        context = context.obtainStyledAttributes(attributeset, t.FixedAspectRatioLayoutArgs);
        a = context.getInteger(t.FixedAspectRatioLayoutArgs_guideline_width, 1);
        b = context.getInteger(t.FixedAspectRatioLayoutArgs_guideline_height, 1);
        context.recycle();
    }

    public FixedAspectRatioFrameLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = -1;
        b = -1;
        context = context.obtainStyledAttributes(attributeset, t.FixedAspectRatioLayoutArgs);
        a = context.getInteger(t.FixedAspectRatioLayoutArgs_guideline_width, 1);
        b = context.getInteger(t.FixedAspectRatioLayoutArgs_guideline_height, 1);
        context.recycle();
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (a != 0 && b != 0)
        {
            int k = getMeasuredWidth();
            int l = getMeasuredHeight();
            if (l == 0 && k != 0)
            {
                j = (int)(((double)b / (double)a) * (double)k);
                setMeasuredDimension(k, j);
                measureChildren(i, android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000));
            } else
            if (k == 0 && l != 0)
            {
                i = (int)(((double)a / (double)b) * (double)l);
                setMeasuredDimension(i, l);
                measureChildren(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), j);
                return;
            }
        }
    }
}
