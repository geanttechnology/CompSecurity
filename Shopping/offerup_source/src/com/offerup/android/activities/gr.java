// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.OfferUpLocation;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            SearchActivity, a, SortAndFilterActivity

final class gr
    implements android.view.View.OnClickListener
{

    private SearchActivity a;

    gr(SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }

    public final void onClick(View view)
    {
        if (StringUtils.isNotEmpty(com.offerup.android.activities.SearchActivity.a(a)) || SearchActivity.b(a))
        {
            com.offerup.android.tracker.a.a("ou_search_filter", com.offerup.android.activities.SearchActivity.a(a));
        }
        view = a.f;
        OfferUpLocation offeruplocation = SearchActivity.p();
        java.util.ArrayList arraylist = SearchActivity.c(a);
        java.util.ArrayList arraylist1 = SearchActivity.d(a);
        Intent intent = new Intent(((com.offerup.android.activities.a) (view)).a, com/offerup/android/activities/SortAndFilterActivity);
        if (offeruplocation != null)
        {
            offeruplocation.a(null);
            intent.putExtra("location", offeruplocation);
        }
        intent.putParcelableArrayListExtra("sortList", arraylist);
        intent.putParcelableArrayListExtra("filterList", arraylist1);
        ((com.offerup.android.activities.a) (view)).a.startActivityForResult(intent, 7);
    }
}
