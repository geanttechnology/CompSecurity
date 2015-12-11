// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.content.Intent;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.utils.CustomSwipeToRefresh;
import java.util.HashMap;
import lu;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.plp:
//            PLPFragment

class a
    implements Runnable
{

    final PLPFragment a;

    public void run()
    {
        PLPFragment.v(a).setRefreshing(false);
        if (a.getActivity() != null)
        {
            Intent intent = new Intent(a.getActivity(), com/bestbuy/android/activities/askexpert/HelpMenuActivity);
            HashMap hashmap = new HashMap();
            if (PLPFragment.w(a))
            {
                if (PLPFragment.x(a))
                {
                    hashmap.put("bb.prevPageLink", (new StringBuilder()).append(PLPFragment.y(a)).append(": Faceted : Blue Assist").toString());
                } else
                {
                    hashmap.put("bb.prevPageLink", (new StringBuilder()).append(lu.f).append(": Blue Assist").toString());
                }
            } else
            if (PLPFragment.x(a))
            {
                hashmap.put("bb.prevPageLink", (new StringBuilder()).append(PLPFragment.y(a)).append(": Blue Assist").toString());
            } else
            {
                hashmap.put("bb.prevPageLink", (new StringBuilder()).append(lu.e).append(": Blue Assist").toString());
            }
            lu.b(lu.aT, hashmap);
            a.startActivityForResult(intent, 8998);
        }
    }

    (PLPFragment plpfragment)
    {
        a = plpfragment;
        super();
    }
}
