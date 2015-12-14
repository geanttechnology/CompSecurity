// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            CostumeLooksPagerActivity

class a
    implements android.support.v4.view.er
{

    final CostumeLooksPagerActivity a;

    public void onPageScrollStateChanged(int i)
    {
        m.b("CostumeLooksPagerActivity", (new StringBuilder()).append("onPageScrollStateChanged").append(i).toString());
        if (i == 1)
        {
            CostumeLooksPagerActivity.b(a, true);
        } else
        if (i == 0)
        {
            CostumeLooksPagerActivity.b(a, false);
            return;
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        m.b("CostumeLooksPagerActivity", "onPageScrolled");
    }

    public void onPageSelected(int i)
    {
        m.b("CostumeLooksPagerActivity", "onPageSelected");
    }

    (CostumeLooksPagerActivity costumelookspageractivity)
    {
        a = costumelookspageractivity;
        super();
    }
}
