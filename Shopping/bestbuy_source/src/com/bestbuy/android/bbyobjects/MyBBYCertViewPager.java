// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import kk;

public class MyBBYCertViewPager extends ViewPager
{

    public MyBBYCertViewPager(Context context)
    {
        super(context);
        a();
    }

    public MyBBYCertViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    private void a()
    {
        setPageTransformer(true, new kk(this));
        setOverScrollMode(2);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.setLocation(motionevent.getY(), motionevent.getX());
        return super.onTouchEvent(motionevent);
    }
}
