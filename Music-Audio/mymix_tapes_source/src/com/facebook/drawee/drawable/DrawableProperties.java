// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.drawable;

import android.graphics.ColorFilter;

public class DrawableProperties
{

    private int mAlpha;
    private ColorFilter mColorFilter;
    private boolean mDither;
    private boolean mFilterBitmap;

    public DrawableProperties()
    {
        mAlpha = 255;
        mColorFilter = null;
        mDither = true;
        mFilterBitmap = true;
    }

    public int getAlpha()
    {
        return mAlpha;
    }

    public ColorFilter getColorFilter()
    {
        return mColorFilter;
    }

    public boolean isDither()
    {
        return mDither;
    }

    public boolean isFilterBitmap()
    {
        return mFilterBitmap;
    }

    public void setAlpha(int i)
    {
        mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mColorFilter = colorfilter;
    }

    public void setDither(boolean flag)
    {
        mDither = flag;
    }

    public void setFilterBitmap(boolean flag)
    {
        mFilterBitmap = flag;
    }
}
