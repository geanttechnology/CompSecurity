// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.os.Handler;
import android.support.v4.view.ViewPager;

// Referenced classes of package com.bestbuy.android.bbyobjects:
//            BBYPromoPager

class a
    implements Runnable
{

    final BBYPromoPager a;

    public void run()
    {
        if (BBYPromoPager.a())
        {
            BBYPromoPager.a(a).setCurrentItem(BBYPromoPager.a(a).getCurrentItem() + 1);
            BBYPromoPager.c(a).postDelayed(BBYPromoPager.b(a), 3000L);
        }
    }

    (BBYPromoPager bbypromopager)
    {
        a = bbypromopager;
        super();
    }
}
