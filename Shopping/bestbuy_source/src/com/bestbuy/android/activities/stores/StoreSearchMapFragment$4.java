// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import android.content.SharedPreferences;
import android.widget.AbsListView;
import com.bestbuy.android.bbyobjects.BBYTextView;
import jy;
import jz;
import nb;

// Referenced classes of package com.bestbuy.android.activities.stores:
//            StoreSearchMapFragment

class a
    implements android.widget.ner
{

    final StoreSearchMapFragment a;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (StoreSearchMapFragment.m(a) && k > StoreSearchMapFragment.n(a))
        {
            StoreSearchMapFragment.b(a, k);
            StoreSearchMapFragment.c(a, false);
        }
        if (StoreSearchMapFragment.m(a) || i != k - j || !StoreSearchMapFragment.e(a)) goto _L2; else goto _L1
_L1:
        StoreSearchMapFragment.a(a, StoreSearchMapFragment.f(a) + 10);
        StoreSearchMapFragment.a(a, nb.a().b().getBoolean("IS_MAP_VIEW", false));
        if (!StoreSearchMapFragment.g(a)) goto _L4; else goto _L3
_L3:
        abslistview = StoreSearchMapFragment.o(a).getText().toString();
        if (abslistview.length() > 0)
        {
            StoreSearchMapFragment.b(a, true);
            (new jy(a.d, a, null, abslistview, StoreSearchMapFragment.f(a), 50)).executeOnExecutor(nb.h, new Void[0]);
        }
_L6:
        StoreSearchMapFragment.c(a, true);
_L2:
        return;
_L4:
        if (StoreSearchMapFragment.j(a) != null)
        {
            StoreSearchMapFragment.a(a, new jz(a.d, a, null, StoreSearchMapFragment.k(a), StoreSearchMapFragment.l(a), StoreSearchMapFragment.f(a), 50));
            StoreSearchMapFragment.j(a).executeOnExecutor(nb.h, new Void[0]);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    (StoreSearchMapFragment storesearchmapfragment)
    {
        a = storesearchmapfragment;
        super();
    }
}
