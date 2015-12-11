// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class GalleryViewPager extends ViewPager
{

    private boolean a;

    public GalleryViewPager(Context context)
    {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (!a)
        {
            return false;
        } else
        {
            return super.onInterceptTouchEvent(motionevent);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!a)
        {
            return false;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void setSwipeble(boolean flag)
    {
        a = flag;
    }
}
