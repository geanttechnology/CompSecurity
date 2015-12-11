// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.content.Intent;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.utils.CustomSwipeToRefresh;
import java.util.HashMap;
import lu;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragment

class a
    implements Runnable
{

    final PDPFragment a;

    public void run()
    {
        PDPFragment.b(a).setRefreshing(false);
        if (a.getActivity() != null)
        {
            Intent intent = new Intent(a.getActivity(), com/bestbuy/android/activities/askexpert/HelpMenuActivity);
            intent.putExtra("fromPDPFragment", true);
            HashMap hashmap = new HashMap();
            hashmap.put("bb.prevPageLink", (new StringBuilder()).append(PDPFragment.c(a)).append("pdp: Blue Assist").toString());
            lu.b(lu.aT, hashmap);
            a.startActivityForResult(intent, 8998);
        }
    }

    (PDPFragment pdpfragment)
    {
        a = pdpfragment;
        super();
    }
}
