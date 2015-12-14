// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.controller.adapter.w;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkSearch;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            s, SearchActivity, t

class d extends s
{

    final SearchActivity a;

    protected void a()
    {
        c("User");
    }

    protected void a(String s1)
    {
        super.a(s1);
        s1 = NetworkSearch.a(s1, AccountManager.c());
        s1.a(new t(this, "listPeopleSuggestion", false));
        a.o = s1;
    }

    protected void b()
    {
        d("User");
    }

    protected void b(String s1)
    {
        a("User", s1);
        SearchActivity.a(a).a(1);
        Object obj = AccountManager.c();
        SearchActivity searchactivity = a;
        CLMultiColumnListView clmulticolumnlistview = SearchActivity.a(a);
        int i = k.bc_view_item_search_result;
        long l;
        if (obj != null)
        {
            l = ((Long) (obj)).longValue();
        } else
        {
            l = -1L;
        }
        obj = new w(searchactivity, clmulticolumnlistview, i, l, -1L, com.cyberlink.beautycircle.model.network.stType.d, SearchActivity.g(a), null);
        ((w) (obj)).a(s1);
        ((w) (obj)).c();
    }

    (SearchActivity searchactivity)
    {
        a = searchactivity;
        super(searchactivity, null);
        b = m.bc_search_header_recent_people;
        c = m.bc_search_suggestions_people;
        d = m.bc_search_hint_people;
    }
}
