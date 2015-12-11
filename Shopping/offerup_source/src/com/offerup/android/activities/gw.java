// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            SearchActivity, hb

final class gw
    implements android.support.v7.widget.SearchView.OnQueryTextListener
{

    private SearchActivity a;

    gw(SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }

    public final boolean onQueryTextChange(String s)
    {
        if (SearchActivity.i(a))
        {
            SearchActivity.c(a, false);
        }
        return false;
    }

    public final boolean onQueryTextSubmit(String s)
    {
        com.offerup.android.tracker.a.a("ou_search_history_select", com.offerup.android.activities.SearchActivity.a(a));
        SearchActivity.b(a, false);
        SearchActivity.b(a, s);
        com.offerup.android.activities.SearchActivity.a(a, hb.b);
        SearchActivity.h(a);
        com.offerup.android.activities.SearchActivity.a(a, true);
        return true;
    }
}
