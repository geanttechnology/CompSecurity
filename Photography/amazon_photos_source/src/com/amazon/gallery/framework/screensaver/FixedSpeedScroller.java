// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.screensaver;

import android.content.Context;
import android.widget.Scroller;

public class FixedSpeedScroller extends Scroller
{

    private int mDuration;

    public FixedSpeedScroller(Context context)
    {
        super(context);
        mDuration = 5000;
    }

    public void setDuration(int i)
    {
        mDuration = i;
    }

    public void startScroll(int i, int j, int k, int l)
    {
        super.startScroll(i, j, k, l, mDuration);
    }

    public void startScroll(int i, int j, int k, int l, int i1)
    {
        super.startScroll(i, j, k, l, mDuration);
    }
}
