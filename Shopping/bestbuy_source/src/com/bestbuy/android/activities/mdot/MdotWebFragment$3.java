// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mdot;

import android.content.Intent;
import android.widget.ImageView;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.utils.CustomSwipeToRefresh;
import java.util.HashMap;
import lu;

// Referenced classes of package com.bestbuy.android.activities.mdot:
//            MdotWebFragment

class a
    implements Runnable
{

    final MdotWebFragment a;

    public void run()
    {
        MdotWebFragment.f(a).setRefreshing(false);
        MdotWebFragment.a(a).setVisibility(8);
        if (a.getActivity() != null)
        {
            Intent intent = new Intent(a.getActivity(), com/bestbuy/android/activities/askexpert/HelpMenuActivity);
            HashMap hashmap = new HashMap();
            hashmap.put("bb.prevPageLink", "From Web Page: Blue Assist");
            lu.b(lu.aT, hashmap);
            a.startActivity(intent);
        }
    }

    ity(MdotWebFragment mdotwebfragment)
    {
        a = mdotwebfragment;
        super();
    }
}
