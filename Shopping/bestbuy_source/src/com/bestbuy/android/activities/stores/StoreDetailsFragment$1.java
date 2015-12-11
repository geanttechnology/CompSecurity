// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.api.lib.models.deals.StoreDeals;
import ih;
import java.util.ArrayList;
import java.util.Map;
import nb;

// Referenced classes of package com.bestbuy.android.activities.stores:
//            StoreDetailsFragment

class a
    implements android.widget.tedListener
{

    final StoreDetailsFragment a;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (String)StoreDetailsFragment.a(a).get(i);
        (new ih(a.d, a, StoreDetailsFragment.b(a), (ArrayList)StoreDetailsFragment.c(a).getDeals().get(adapterview))).executeOnExecutor(nb.h, new Void[0]);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    (StoreDetailsFragment storedetailsfragment)
    {
        a = storedetailsfragment;
        super();
    }
}
