// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class MaxSizeHelper
{
    public static interface MaxSizeWidget
    {

        public static final int NO_MAXIMUM = -1;

        public abstract int getMaxHeight();

        public abstract int getMaxWidth();

        public abstract void setMaxHeight(int i);

        public abstract void setMaxWidth(int i);
    }


    private int maxHeight;
    private int maxWidth;

    MaxSizeHelper()
    {
        maxWidth = -1;
        maxHeight = -1;
    }

    MaxSizeHelper(Context context, AttributeSet attributeset)
    {
        context = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.MaxSizeHelper);
        int i = context.getDimensionPixelSize(0, -1);
        int j = context.getDimensionPixelSize(1, -1);
        context.recycle();
        maxWidth = i;
        maxHeight = j;
    }

    public int getHeightMeasureSpec(int i)
    {
        int k = android.view.View.MeasureSpec.getSize(i);
        int j = i;
        if (maxHeight > -1)
        {
            j = i;
            if (maxHeight < k)
            {
                i = android.view.View.MeasureSpec.getMode(i);
                j = android.view.View.MeasureSpec.makeMeasureSpec(maxHeight, i);
            }
        }
        return j;
    }

    public int getMaxHeight()
    {
        return maxHeight;
    }

    public int getMaxWidth()
    {
        return maxWidth;
    }

    public int getWidthMeasureSpec(int i)
    {
        int k = android.view.View.MeasureSpec.getSize(i);
        int j = i;
        if (maxWidth > -1)
        {
            j = i;
            if (maxWidth < k)
            {
                i = android.view.View.MeasureSpec.getMode(i);
                j = android.view.View.MeasureSpec.makeMeasureSpec(maxWidth, i);
            }
        }
        return j;
    }

    public void setMaxHeight(int i)
    {
        int j = i;
        if (i <= -1)
        {
            j = -1;
        }
        maxHeight = j;
    }

    public void setMaxWidth(int i)
    {
        int j = i;
        if (i <= -1)
        {
            j = -1;
        }
        maxWidth = j;
    }
}
