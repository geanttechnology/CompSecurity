// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class AdView extends View
{

    public AdView(Context context)
    {
        super(context);
        initAdView();
    }

    public AdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initAdView();
    }

    private final void initAdView()
    {
    }

    private int measureHeight(int i)
    {
        int j = android.view.View.MeasureSpec.getMode(i);
        i = android.view.View.MeasureSpec.getSize(i);
        if (j == 0x40000000)
        {
            return i;
        } else
        {
            return 0;
        }
    }

    private int measureWidth(int i)
    {
        int j = android.view.View.MeasureSpec.getMode(i);
        i = android.view.View.MeasureSpec.getSize(i);
        if (j == 0x40000000)
        {
            return i;
        } else
        {
            return 0;
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int j)
    {
        setMeasuredDimension(measureWidth(i), measureHeight(j));
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
    }
}
