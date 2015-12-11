// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import com.bestbuy.android.base.BBYBaseFragment;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeFragment

class b
    implements Runnable
{

    final LinearLayout a;
    final BBYBaseFragment b;
    final HomeFragment c;

    public void run()
    {
        c.getChildFragmentManager().beginTransaction().add(a.getId(), b).commitAllowingStateLoss();
    }

    (HomeFragment homefragment, LinearLayout linearlayout, BBYBaseFragment bbybasefragment)
    {
        c = homefragment;
        a = linearlayout;
        b = bbybasefragment;
        super();
    }
}
