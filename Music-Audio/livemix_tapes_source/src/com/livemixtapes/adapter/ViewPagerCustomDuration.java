// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import java.lang.reflect.Field;

// Referenced classes of package com.livemixtapes.adapter:
//            ScrollerCustomDuration

public class ViewPagerCustomDuration extends ViewPager
{

    private ScrollerCustomDuration mScroller;

    public ViewPagerCustomDuration(Context context)
    {
        super(context);
        mScroller = null;
        postInitViewPager();
    }

    public ViewPagerCustomDuration(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mScroller = null;
        postInitViewPager();
    }

    private void postInitViewPager()
    {
        try
        {
            Field field = android/support/v4/view/ViewPager.getDeclaredField("mScroller");
            field.setAccessible(true);
            Field field1 = android/support/v4/view/ViewPager.getDeclaredField("sInterpolator");
            field1.setAccessible(true);
            mScroller = new ScrollerCustomDuration(getContext(), (Interpolator)field1.get(null));
            field.set(this, mScroller);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void setScrollDurationFactor(double d)
    {
        mScroller.setScrollDurationFactor(d);
    }
}
