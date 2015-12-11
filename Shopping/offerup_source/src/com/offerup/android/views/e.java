// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.offerup.android.views:
//            SlidingTabLayout, g

final class e
    implements android.view.View.OnClickListener
{

    private SlidingTabLayout a;

    private e(SlidingTabLayout slidingtablayout)
    {
        a = slidingtablayout;
        super();
    }

    e(SlidingTabLayout slidingtablayout, byte byte0)
    {
        this(slidingtablayout);
    }

    public final void onClick(View view)
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < SlidingTabLayout.a(a).getChildCount())
                {
                    if (view != SlidingTabLayout.a(a).getChildAt(i))
                    {
                        break label0;
                    }
                    SlidingTabLayout.c(a).setCurrentItem(i);
                }
                return;
            }
            i++;
        } while (true);
    }
}
