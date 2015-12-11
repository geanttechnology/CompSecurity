// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.view.View;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import com.bestbuy.android.activities.stores.DialogSpinner;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import hi;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPReviewsListFragment

class a
    implements android.widget.dListener
{

    final PDPReviewsListFragment a;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        PDPReviewsListFragment.a(a, true);
        PDPReviewsListFragment.a(a, 0);
        PDPReviewsListFragment.b(a, 0);
        adapterview = (String)PDPReviewsListFragment.a(a).getAdapter().getItem(i);
        if (!adapterview.equals("Newest")) goto _L2; else goto _L1
_L1:
        PDPReviewsListFragment.a(a, "SubmissionTime:desc");
_L4:
        (new hi(a.d, a, PDPReviewsListFragment.b(a), PDPReviewsListFragment.c(a).getSkuId(), PDPReviewsListFragment.d(a), PDPReviewsListFragment.e(a), PDPReviewsListFragment.f(a))).executeOnExecutor(nb.h, new Void[0]);
        return;
_L2:
        if (adapterview.equals("Oldest"))
        {
            PDPReviewsListFragment.a(a, "SubmissionTime:asc");
        } else
        if (adapterview.equals("Most Helpful"))
        {
            PDPReviewsListFragment.a(a, "Helpfulness:desc,SubmissionTime:desc");
        } else
        if (adapterview.equals("Highest Rated"))
        {
            PDPReviewsListFragment.a(a, "Rating:desc,SubmissionTime:desc");
        } else
        if (adapterview.equals("Lowest Rated"))
        {
            PDPReviewsListFragment.a(a, "Rating:asc,SubmissionTime:desc");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        PDPReviewsListFragment.a(a, false);
    }

    (PDPReviewsListFragment pdpreviewslistfragment)
    {
        a = pdpreviewslistfragment;
        super();
    }
}
