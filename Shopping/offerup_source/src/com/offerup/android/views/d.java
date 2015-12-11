// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.support.v4.view.co;
import android.view.View;

// Referenced classes of package com.offerup.android.views:
//            SlidingTabLayout, g

class d
    implements co
{

    final SlidingTabLayout a;
    private int b;

    private d(SlidingTabLayout slidingtablayout)
    {
        a = slidingtablayout;
        super();
    }

    d(SlidingTabLayout slidingtablayout, byte byte0)
    {
        this(slidingtablayout);
    }

    public void a(int i)
    {
        if (b == 0)
        {
            SlidingTabLayout.a(a).a(i, 0.0F);
            SlidingTabLayout.a(a, i, 0);
        }
        int j = 0;
        while (j < SlidingTabLayout.a(a).getChildCount()) 
        {
            View view = SlidingTabLayout.a(a).getChildAt(j);
            boolean flag;
            if (i == j)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            j++;
        }
        if (SlidingTabLayout.b(a) != null)
        {
            SlidingTabLayout.b(a).a(i);
        }
    }

    public void a(int i, float f, int j)
    {
        int k = SlidingTabLayout.a(a).getChildCount();
        if (k != 0 && i >= 0 && i < k)
        {
            SlidingTabLayout.a(a).a(i, f);
            View view = SlidingTabLayout.a(a).getChildAt(i);
            int l;
            if (view != null)
            {
                l = (int)((float)view.getWidth() * f);
            } else
            {
                l = 0;
            }
            SlidingTabLayout.a(a, i, l);
            if (SlidingTabLayout.b(a) != null)
            {
                SlidingTabLayout.b(a).a(i, f, j);
                return;
            }
        }
    }

    public void b(int i)
    {
        b = i;
        if (SlidingTabLayout.b(a) != null)
        {
            SlidingTabLayout.b(a).b(i);
        }
    }
}
