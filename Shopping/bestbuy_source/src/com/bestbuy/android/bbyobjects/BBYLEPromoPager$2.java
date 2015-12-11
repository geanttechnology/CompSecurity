// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.os.Handler;
import android.support.v4.view.ViewPager;

// Referenced classes of package com.bestbuy.android.bbyobjects:
//            BBYLEPromoPager

class a
    implements Runnable
{

    final BBYLEPromoPager a;

    public void run()
    {
        if (BBYLEPromoPager.a())
        {
            BBYLEPromoPager.a(a).setCurrentItem(BBYLEPromoPager.a(a).getCurrentItem() + 1);
            BBYLEPromoPager.c(a).postDelayed(BBYLEPromoPager.b(a), 3000L);
        }
    }

    (BBYLEPromoPager bbylepromopager)
    {
        a = bbylepromopager;
        super();
    }
}
