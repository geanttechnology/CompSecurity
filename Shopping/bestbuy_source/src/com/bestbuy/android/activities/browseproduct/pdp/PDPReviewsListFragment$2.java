// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponse;
import hi;
import ig;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPReviewsListFragment

class a
    implements android.widget.ner
{

    final PDPReviewsListFragment a;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (PDPReviewsListFragment.g(a) != null && !PDPReviewsListFragment.g(a).isEmpty())
        {
            PDPReviewsListFragment.h(a).setVisibility(8);
        } else
        {
            PDPReviewsListFragment.h(a).setVisibility(0);
        }
        PDPReviewsListFragment.a(a, false);
        if (PDPReviewsListFragment.i(a) && k - (PDPReviewsListFragment.j(a).getHeaderViewsCount() + PDPReviewsListFragment.j(a).getFooterViewsCount()) < PDPReviewsListFragment.k(a))
        {
            PDPReviewsListFragment.a(a, PDPReviewsListFragment.e(a) + PDPReviewsListFragment.d(a));
            (new hi(a.d, a, null, PDPReviewsListFragment.c(a).getSkuId(), PDPReviewsListFragment.d(a), PDPReviewsListFragment.e(a), PDPReviewsListFragment.f(a))).executeOnExecutor(nb.h, new Void[0]);
            PDPReviewsListFragment.b(a, false);
        } else
        if (PDPReviewsListFragment.i(a) && PDPReviewsListFragment.l(a) != null && i == k - PDPReviewsListFragment.m(a) - j)
        {
            (new ig(a.d, a, null, PDPReviewsListFragment.n(a).getOverview().getSkuId(), PDPReviewsListFragment.g(a), PDPReviewsListFragment.e(a), PDPReviewsListFragment.l(a))).executeOnExecutor(nb.h, new Void[0]);
            PDPReviewsListFragment.o(a);
            PDPReviewsListFragment.b(a, false);
            return;
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i == 0)
        {
            PDPReviewsListFragment.b(a, false);
            return;
        } else
        {
            PDPReviewsListFragment.b(a, true);
            return;
        }
    }

    (PDPReviewsListFragment pdpreviewslistfragment)
    {
        a = pdpreviewslistfragment;
        super();
    }
}
