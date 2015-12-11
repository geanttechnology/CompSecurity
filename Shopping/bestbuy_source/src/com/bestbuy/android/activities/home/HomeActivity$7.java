// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import java.util.List;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeActivity, HomeTabFragment

class a
    implements android.support.v4.app..OnBackStackChangedListener
{

    final HomeActivity a;

    public void onBackStackChanged()
    {
        FragmentManager fragmentmanager = a.getSupportFragmentManager();
        if (fragmentmanager != null)
        {
            int i = fragmentmanager.getBackStackEntryCount();
            if (i == 0)
            {
                a.finish();
            } else
            if (((Fragment)fragmentmanager.getFragments().get(i - 1) instanceof HomeTabFragment) && HomeActivity.access$800(a).b().getCurrentTab() == 2)
            {
                a.onStoresFramentLaunch();
                return;
            }
        }
    }

    (HomeActivity homeactivity)
    {
        a = homeactivity;
        super();
    }
}
