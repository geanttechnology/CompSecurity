// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class BBYProductViewPager extends ViewPager
{

    private boolean a;

    public BBYProductViewPager(Context context)
    {
        super(context);
        a = true;
    }

    public BBYProductViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (a)
        {
            return super.onInterceptTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (a)
        {
            return super.onTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public void setPagingEnabled(boolean flag)
    {
        a = flag;
    }
}
