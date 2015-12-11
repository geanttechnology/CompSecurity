// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import ail;
import aim;
import android.content.SharedPreferences;
import ani;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.HashMap;
import jy;
import jz;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.stores:
//            StoreSearchMapFragment

class a
    implements android.support.v4.view.tener
{

    final StoreSearchMapFragment a;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        if (StoreSearchMapFragment.a(a) != null && !StoreSearchMapFragment.b(a))
        {
            Object obj1 = (BBYStore)StoreSearchMapFragment.c(a).get(i);
            Object obj = Double.valueOf(((BBYStore) (obj1)).getStoreDetails().getLatitude());
            obj1 = Double.valueOf(((BBYStore) (obj1)).getStoreDetails().getLongitude());
            obj1 = new LatLng(((Double) (obj)).doubleValue(), ((Double) (obj1)).doubleValue());
            StoreSearchMapFragment.a(a).a(ail.a(((LatLng) (obj1)), StoreSearchMapFragment.d(a)));
            obj = StoreSearchMapFragment.a(a).a().a;
            obj1 = StoreSearchMapFragment.a(a).a((new MarkerOptions()).a(((LatLng) (obj1))).a(ani.a(0x7f020183)));
            StoreSearchMapFragment.a(a, ((ank) (obj1)), ((LatLng) (obj)));
        }
        if (i == StoreSearchMapFragment.c(a).size() - 1 && StoreSearchMapFragment.e(a))
        {
            StoreSearchMapFragment.a(a, StoreSearchMapFragment.f(a) + 10);
            StoreSearchMapFragment.a(a, nb.a().b().getBoolean("IS_MAP_VIEW", false));
            if (StoreSearchMapFragment.g(a))
            {
                String s = StoreSearchMapFragment.h(a).getText().toString();
                HashMap hashmap = new HashMap();
                hashmap.put("bb.searchTerm", s);
                hashmap.put("bb.numResults", "25");
                lu.a(lu.ad, hashmap);
                if (s.length() > 0)
                {
                    StoreSearchMapFragment.b(a, true);
                    (new jy(a.d, a, StoreSearchMapFragment.i(a), s, StoreSearchMapFragment.f(a), 50)).executeOnExecutor(nb.h, new Void[0]);
                }
            } else
            if (StoreSearchMapFragment.j(a) != null)
            {
                StoreSearchMapFragment.a(a, new jz(a.d, a, StoreSearchMapFragment.i(a), StoreSearchMapFragment.k(a), StoreSearchMapFragment.l(a), StoreSearchMapFragment.f(a), 50));
                StoreSearchMapFragment.j(a).executeOnExecutor(nb.h, new Void[0]);
                return;
            }
        }
    }

    (StoreSearchMapFragment storesearchmapfragment)
    {
        a = storesearchmapfragment;
        super();
    }
}
