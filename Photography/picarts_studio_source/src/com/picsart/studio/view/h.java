// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.view.View;

// Referenced classes of package com.picsart.studio.view:
//            SlidingTabLayout, SlidingTabStrip

final class h
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    private int a;
    private SlidingTabLayout b;

    private h(SlidingTabLayout slidingtablayout)
    {
        b = slidingtablayout;
        super();
    }

    h(SlidingTabLayout slidingtablayout, byte byte0)
    {
        this(slidingtablayout);
    }

    public final void onPageScrollStateChanged(int i)
    {
        a = i;
        if (SlidingTabLayout.b(b) != null)
        {
            SlidingTabLayout.b(b).onPageScrollStateChanged(i);
        }
    }

    public final void onPageScrolled(int i, float f, int j)
    {
        int k = SlidingTabLayout.a(b).getChildCount();
        if (k != 0 && i >= 0 && i < k)
        {
            SlidingTabLayout.a(b).a(i, f);
            View view = SlidingTabLayout.a(b).getChildAt(i);
            int l;
            if (view != null)
            {
                l = (int)((float)view.getWidth() * f);
            } else
            {
                l = 0;
            }
            SlidingTabLayout.a(b, i, l);
            if (SlidingTabLayout.b(b) != null)
            {
                SlidingTabLayout.b(b).onPageScrolled(i, f, j);
                return;
            }
        }
    }

    public final void onPageSelected(int i)
    {
        if (a == 0)
        {
            SlidingTabLayout.a(b).a(i, 0.0F);
            SlidingTabLayout.a(b, i, 0);
        }
        if (SlidingTabLayout.b(b) != null)
        {
            SlidingTabLayout.b(b).onPageSelected(i);
        }
        int j = 0;
        while (j < SlidingTabLayout.a(b).getChildCount()) 
        {
            View view = SlidingTabLayout.a(b).getChildAt(j);
            boolean flag;
            if (j == i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            j++;
        }
    }
}
