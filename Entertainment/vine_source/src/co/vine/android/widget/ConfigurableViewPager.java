// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ConfigurableViewPager extends ViewPager
{

    private boolean mSwipingEnabled;

    public ConfigurableViewPager(Context context)
    {
        this(context, null);
    }

    public ConfigurableViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSwipingEnabled = true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (mSwipingEnabled)
        {
            return super.onInterceptTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mSwipingEnabled)
        {
            return super.onTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public void setSwipingEnabled(boolean flag)
    {
        mSwipingEnabled = flag;
    }
}
