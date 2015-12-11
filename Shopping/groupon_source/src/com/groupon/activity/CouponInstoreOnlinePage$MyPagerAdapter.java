// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            CouponInstoreOnlinePage

public class this._cls0 extends FragmentPagerAdapter
{

    final CouponInstoreOnlinePage this$0;

    public int getCount()
    {
        return titles.length;
    }

    public Fragment getItem(int i)
    {
        return (Fragment)pages.get(i);
    }

    public CharSequence getPageTitle(int i)
    {
        return titles[i];
    }

    public A(FragmentManager fragmentmanager)
    {
        this$0 = CouponInstoreOnlinePage.this;
        super(fragmentmanager);
    }
}
