// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.widget.AbsListView;
import iq;
import nb;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMListFragment

class a
    implements android.widget.llListener
{

    final DNMListFragment a;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (DNMListFragment.m(a) && k > DNMListFragment.n(a))
        {
            DNMListFragment.a(a, k);
            DNMListFragment.a(a, false);
        }
        if (!DNMListFragment.m(a) && i == k - j && k - DNMListFragment.o(a) < DNMListFragment.p(a))
        {
            DNMListFragment.b(a, DNMListFragment.q(a) + 1);
            (new iq(DNMListFragment.j(a), a, null, DNMListFragment.f(a), DNMListFragment.d(a), DNMListFragment.e(a), 50, DNMListFragment.q(a), 20, DNMListFragment.c(a), DNMListFragment.g(a), DNMListFragment.h(a), DNMListFragment.i(a))).executeOnExecutor(nb.h, new Void[0]);
            DNMListFragment.a(a, true);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    (DNMListFragment dnmlistfragment)
    {
        a = dnmlistfragment;
        super();
    }
}
