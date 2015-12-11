// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.widget.AbsListView;
import hf;
import id;
import jh;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.plp:
//            PLPFragment

class a
    implements android.widget.ScrollListener
{

    final PLPFragment a;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (PLPFragment.h(a) && k > PLPFragment.i(a))
        {
            PLPFragment.a(a, k);
            PLPFragment.a(a, false);
        }
        if (!PLPFragment.h(a) && i == k - j && (long)(k - PLPFragment.j(a)) < PLPFragment.k(a))
        {
            a.a(k);
            PLPFragment.b(a, PLPFragment.l(a) + 1);
            if (PLPFragment.d(a))
            {
                if (PLPFragment.m(a) != null)
                {
                    (new id(a.d, a, null, PLPFragment.m(a), PLPFragment.n(a), PLPFragment.o(a), PLPFragment.p(a), null, PLPFragment.l(a), PLPFragment.q(a), true)).executeOnExecutor(nb.h, new Void[0]);
                }
            } else
            if (PLPFragment.g(a))
            {
                (new jh(a.d, a, null, PLPFragment.r(a), PLPFragment.l(a))).executeOnExecutor(nb.g, new Void[0]);
            } else
            if (PLPFragment.s(a))
            {
                if (PLPFragment.t(a) != null)
                {
                    (new hf(a.d, a, PLPFragment.u(a), "Best-Match", 20, PLPFragment.l(a), false, null, PLPFragment.b(a), PLPFragment.t(a))).execute(new Void[0]);
                } else
                {
                    (new hf(a.d, a, PLPFragment.u(a), "Best-Match", 20, PLPFragment.l(a), false, null, PLPFragment.b(a))).execute(new Void[0]);
                }
            } else
            {
                PLPFragment.b(a, false);
            }
            PLPFragment.a(a, true);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    (PLPFragment plpfragment)
    {
        a = plpfragment;
        super();
    }
}
