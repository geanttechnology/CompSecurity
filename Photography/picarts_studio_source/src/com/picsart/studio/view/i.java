// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.picsart.studio.view:
//            SlidingTabLayout, SlidingTabStrip

final class i
    implements android.view.View.OnClickListener
{

    private SlidingTabLayout a;

    private i(SlidingTabLayout slidingtablayout)
    {
        a = slidingtablayout;
        super();
    }

    i(SlidingTabLayout slidingtablayout, byte byte0)
    {
        this(slidingtablayout);
    }

    public final void onClick(View view)
    {
        int j = 0;
        do
        {
label0:
            {
                if (j < SlidingTabLayout.a(a).getChildCount())
                {
                    if (view != SlidingTabLayout.a(a).getChildAt(j))
                    {
                        break label0;
                    }
                    SlidingTabLayout.c(a).setCurrentItem(j, false);
                }
                return;
            }
            j++;
        } while (true);
    }
}
