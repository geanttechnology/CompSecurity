// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.ftue;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class FixedViewPager extends ViewPager
{

    private boolean enabled;

    public FixedViewPager(Context context)
    {
        super(context);
        enabled = false;
    }

    public FixedViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        enabled = false;
    }

    public boolean isSwipeEnabled()
    {
        return enabled;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (enabled)
        {
            return super.onInterceptTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public void setSwipeEnabled(boolean flag)
    {
        enabled = flag;
    }

    public void toggleSwipe()
    {
        boolean flag;
        if (!enabled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        enabled = flag;
    }
}
