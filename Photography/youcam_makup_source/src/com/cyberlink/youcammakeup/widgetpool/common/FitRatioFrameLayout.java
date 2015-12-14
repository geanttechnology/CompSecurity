// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cyberlink.youcammakeup.j;
import com.cyberlink.youcammakeup.utility.g;

public class FitRatioFrameLayout extends FrameLayout
{

    private int a;
    private int b;

    public FitRatioFrameLayout(Context context)
    {
        super(context);
        a = -1;
        b = -1;
    }

    public FitRatioFrameLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FitRatioFrameLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = -1;
        b = -1;
        context = context.obtainStyledAttributes(attributeset, j.FixedAspectRatioLayoutArgs);
        a = context.getInteger(0, -1);
        b = context.getInteger(1, -1);
        context.recycle();
    }

    protected void measureChildren(int i, int k)
    {
        int k1 = android.view.View.MeasureSpec.getSize(i);
        int l1 = android.view.View.MeasureSpec.getSize(k);
        int i2 = getChildCount();
        int l = 0;
        while (l < i2) 
        {
            View view = getChildAt(l);
            if (view.getVisibility() != 8)
            {
                android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
                int i1;
                int j1;
                if (marginlayoutparams.width == -1)
                {
                    i1 = android.view.View.MeasureSpec.makeMeasureSpec(k1 - marginlayoutparams.leftMargin - marginlayoutparams.rightMargin, 0x40000000);
                } else
                {
                    i1 = getChildMeasureSpec(i, marginlayoutparams.leftMargin + marginlayoutparams.rightMargin, marginlayoutparams.width);
                }
                if (marginlayoutparams.height == -1)
                {
                    j1 = android.view.View.MeasureSpec.makeMeasureSpec(l1 - marginlayoutparams.topMargin - marginlayoutparams.bottomMargin, 0x40000000);
                } else
                {
                    j1 = getChildMeasureSpec(k, marginlayoutparams.topMargin + marginlayoutparams.bottomMargin, marginlayoutparams.height);
                }
                view.measure(i1, j1);
            }
            l++;
        }
    }

    protected void onMeasure(int i, int k)
    {
        super.onMeasure(i, k);
        if (a == -1 && b == -1)
        {
            return;
        } else
        {
            Point point = g.a(getMeasuredWidth(), getMeasuredHeight(), a, b);
            setMeasuredDimension(point.x, point.y);
            measureChildren(android.view.View.MeasureSpec.makeMeasureSpec(point.x, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(point.y, 0x40000000));
            return;
        }
    }
}
