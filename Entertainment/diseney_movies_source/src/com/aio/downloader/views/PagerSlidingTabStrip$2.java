// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.aio.downloader.views:
//            PagerSlidingTabStrip

class val.position
    implements android.view.gTabStrip._cls2
{

    final PagerSlidingTabStrip this$0;
    private final int val$position;

    public void onClick(View view)
    {
        if (PagerSlidingTabStrip.access$8(PagerSlidingTabStrip.this).getCurrentItem() != val$position)
        {
            view = PagerSlidingTabStrip.access$0(PagerSlidingTabStrip.this).getChildAt(PagerSlidingTabStrip.access$8(PagerSlidingTabStrip.this).getCurrentItem());
            PagerSlidingTabStrip.access$16(PagerSlidingTabStrip.this, view);
            PagerSlidingTabStrip.access$8(PagerSlidingTabStrip.this).setCurrentItem(val$position);
        } else
        if (PagerSlidingTabStrip.access$17(PagerSlidingTabStrip.this) != null)
        {
            PagerSlidingTabStrip.access$17(PagerSlidingTabStrip.this).onTabReselected(val$position);
            return;
        }
    }

    TabReselectedListener()
    {
        this$0 = final_pagerslidingtabstrip;
        val$position = I.this;
        super();
    }
}
