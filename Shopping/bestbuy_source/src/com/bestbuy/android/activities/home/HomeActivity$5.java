// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.view.View;
import android.widget.SearchView;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeActivity

class a
    implements android.view.tener
{

    final HomeActivity a;

    public void onClick(View view)
    {
        if ((HomeActivity.access$600(a) || HomeActivity.inLifeEventsFragment || HomeActivity.inStoresFragment || HomeActivity.inDNMFragment) && HomeActivity.access$700(a) != null)
        {
            HomeActivity.access$200(a).setQuery(HomeActivity.access$700(a), false);
        }
    }

    (HomeActivity homeactivity)
    {
        a = homeactivity;
        super();
    }
}
