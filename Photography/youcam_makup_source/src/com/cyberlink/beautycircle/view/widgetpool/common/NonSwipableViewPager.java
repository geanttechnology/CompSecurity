// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NonSwipableViewPager extends ViewPager
{

    protected boolean a;

    public NonSwipableViewPager(Context context)
    {
        super(context);
        a = false;
    }

    public NonSwipableViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (a)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = super.onInterceptTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            return false;
        }
        return flag;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (a)
        {
            return false;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        super.requestDisallowInterceptTouchEvent(flag);
        a = flag;
    }
}
