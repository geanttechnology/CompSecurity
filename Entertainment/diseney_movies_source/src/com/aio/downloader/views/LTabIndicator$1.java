// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.aio.downloader.views:
//            LTabIndicator

class val.position
    implements android.view.ener
{

    final LTabIndicator this$0;
    private final int val$position;

    public void onClick(View view)
    {
        if (LTabIndicator.access$6(LTabIndicator.this).getCurrentItem() != val$position && LTabIndicator.access$8(LTabIndicator.this) != null)
        {
            LTabIndicator.access$8(LTabIndicator.this).onTabSelected(val$position);
        }
        LTabIndicator.access$6(LTabIndicator.this).setCurrentItem(val$position, LTabIndicator.access$9(LTabIndicator.this));
    }

    TabSelectedListener()
    {
        this$0 = final_ltabindicator;
        val$position = I.this;
        super();
    }
}
