// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.adapter;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class ScrollerCustomDuration extends Scroller
{

    private double mScrollFactor;

    public ScrollerCustomDuration(Context context)
    {
        super(context);
        mScrollFactor = 1.0D;
    }

    public ScrollerCustomDuration(Context context, Interpolator interpolator)
    {
        super(context, interpolator);
        mScrollFactor = 1.0D;
    }

    public ScrollerCustomDuration(Context context, Interpolator interpolator, boolean flag)
    {
        super(context, interpolator, flag);
        mScrollFactor = 1.0D;
    }

    public void setScrollDurationFactor(double d)
    {
        mScrollFactor = d;
    }

    public void startScroll(int i, int j, int k, int l, int i1)
    {
        super.startScroll(i, j, k, l, (int)((double)i1 * mScrollFactor));
    }
}
