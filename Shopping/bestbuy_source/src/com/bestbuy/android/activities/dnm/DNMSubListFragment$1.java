// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.widget.AbsListView;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import ir;
import nb;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMSubListFragment

class a
    implements android.widget.istener
{

    final DNMSubListFragment a;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (DNMSubListFragment.a(a) && k > DNMSubListFragment.b(a))
        {
            DNMSubListFragment.a(a, k);
            DNMSubListFragment.a(a, false);
        }
        if (!DNMSubListFragment.a(a) && i == k - j && k - DNMSubListFragment.c(a) < DNMSubListFragment.d(a))
        {
            DNMSubListFragment.b(a, DNMSubListFragment.e(a) + 1);
            (new ir(DNMSubListFragment.f(a), a, null, DNMSubListFragment.g(a), DNMSubListFragment.h(a), DNMSubListFragment.i(a), 50, DNMSubListFragment.j(a), DNMSubListFragment.k(a).getSkuId(), DNMSubListFragment.e(a), 20, DNMSubListFragment.l(a), DNMSubListFragment.m(a), DNMSubListFragment.n(a))).executeOnExecutor(nb.h, new Void[0]);
            DNMSubListFragment.a(a, true);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    BBYProduct(DNMSubListFragment dnmsublistfragment)
    {
        a = dnmsublistfragment;
        super();
    }
}
