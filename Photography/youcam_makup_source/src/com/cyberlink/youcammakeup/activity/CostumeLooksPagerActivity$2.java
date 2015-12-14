// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.widgetpool.common.LockableViewPager;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            CostumeLooksPagerActivity

class a
    implements android.view.meLooksPagerActivity._cls2
{

    final CostumeLooksPagerActivity a;

    public void onClick(View view)
    {
        int i = CostumeLooksPagerActivity.b(a).getCurrentItem();
        CostumeLooksPagerActivity.b(a).setCurrentItem(i - 1, true);
    }

    (CostumeLooksPagerActivity costumelookspageractivity)
    {
        a = costumelookspageractivity;
        super();
    }
}
