// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.view.View;
import com.bestbuy.android.api.lib.models.dnm.DNMFacetFilter;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMListFragment

class a
    implements android.view.er
{

    final DNMFacetFilter a;
    final DNMListFragment b;

    public void onClick(View view)
    {
        DNMListFragment.a(b, a);
    }

    (DNMListFragment dnmlistfragment, DNMFacetFilter dnmfacetfilter)
    {
        b = dnmlistfragment;
        a = dnmfacetfilter;
        super();
    }
}
