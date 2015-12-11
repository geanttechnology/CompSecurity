// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TwoTraitViewPager extends ViewPager
{

    private boolean checkScrollingLogic;
    private boolean enabled;

    public TwoTraitViewPager(Context context)
    {
        this(context, null);
    }

    public TwoTraitViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        checkScrollingLogic = false;
        init();
    }

    private void init()
    {
        enabled = true;
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

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        boolean flag1;
label0:
        {
            flag1 = false;
            super.onLayout(flag, i, j, k, l);
            if (checkScrollingLogic)
            {
                i = getAdapter().getCount();
                if (i != 0)
                {
                    break label0;
                }
            }
            return;
        }
        View view = getChildAt(0);
        flag = flag1;
        if (getWidth() < (view.getWidth() + getPageMargin()) * i + getPageMargin())
        {
            flag = true;
        }
        setPagingEnabled(flag);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (enabled)
        {
            return super.onTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public void setAdapter(PagerAdapter pageradapter)
    {
        super.setAdapter(pageradapter);
        boolean flag;
        if (pageradapter != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        checkScrollingLogic = flag;
    }

    public void setPagingEnabled(boolean flag)
    {
        enabled = flag;
    }
}
