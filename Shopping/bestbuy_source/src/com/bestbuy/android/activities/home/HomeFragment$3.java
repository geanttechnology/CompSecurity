// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.content.Intent;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.utils.CustomSwipeToRefresh;
import java.util.HashMap;
import lu;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeFragment

class a
    implements Runnable
{

    final HomeFragment a;

    public void run()
    {
        HomeFragment.g(a).setRefreshing(false);
        if (a.getActivity() != null)
        {
            Intent intent = new Intent(a.getActivity(), com/bestbuy/android/activities/askexpert/HelpMenuActivity);
            HashMap hashmap = new HashMap();
            hashmap.put("bb.prevPageLink", "Best Buy : Blue Assist");
            lu.b(lu.aT, hashmap);
            a.startActivityForResult(intent, 8998);
        }
    }

    tivity(HomeFragment homefragment)
    {
        a = homefragment;
        super();
    }
}
