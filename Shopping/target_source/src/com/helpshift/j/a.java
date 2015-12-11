// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.j;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;

public final class a extends ViewPager
{

    private boolean a;

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
