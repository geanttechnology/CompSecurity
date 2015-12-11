// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.b;


public class a
{

    private final double mAspectRatio;
    private Integer mMeasuredHeight;
    private Integer mMeasuredWidth;

    public a(double d)
    {
        mMeasuredWidth = null;
        mMeasuredHeight = null;
        mAspectRatio = d;
    }

    public int a()
    {
        if (mMeasuredWidth == null)
        {
            throw new IllegalStateException("You need to run measure() before trying to get measured dimensions");
        } else
        {
            return mMeasuredWidth.intValue();
        }
    }

    public void a(int i, int j)
    {
        a(i, j, mAspectRatio);
    }

    public void a(int i, int j, double d)
    {
        int k = 0x7fffffff;
        int l = android.view.View.MeasureSpec.getMode(i);
        int i1;
        if (l == 0)
        {
            i = 0x7fffffff;
        } else
        {
            i = android.view.View.MeasureSpec.getSize(i);
        }
        i1 = android.view.View.MeasureSpec.getMode(j);
        if (i1 == 0)
        {
            j = k;
        } else
        {
            j = android.view.View.MeasureSpec.getSize(j);
        }
        if (i1 == 0x40000000 && l == 0x40000000)
        {
            mMeasuredWidth = Integer.valueOf(i);
            mMeasuredHeight = Integer.valueOf(j);
            return;
        }
        if (i1 == 0x40000000)
        {
            mMeasuredWidth = Integer.valueOf((int)Math.min(i, (double)j * d));
            mMeasuredHeight = Integer.valueOf((int)((double)mMeasuredWidth.intValue() / d));
            return;
        }
        if (l == 0x40000000)
        {
            mMeasuredHeight = Integer.valueOf((int)Math.min(j, (double)i / d));
            mMeasuredWidth = Integer.valueOf((int)((double)mMeasuredHeight.intValue() * d));
            return;
        }
        if ((double)i > (double)j * d)
        {
            mMeasuredHeight = Integer.valueOf(j);
            mMeasuredWidth = Integer.valueOf((int)((double)mMeasuredHeight.intValue() * d));
            return;
        } else
        {
            mMeasuredWidth = Integer.valueOf(i);
            mMeasuredHeight = Integer.valueOf((int)((double)mMeasuredWidth.intValue() / d));
            return;
        }
    }

    public int b()
    {
        if (mMeasuredHeight == null)
        {
            throw new IllegalStateException("You need to run measure() before trying to get measured dimensions");
        } else
        {
            return mMeasuredHeight.intValue();
        }
    }
}
