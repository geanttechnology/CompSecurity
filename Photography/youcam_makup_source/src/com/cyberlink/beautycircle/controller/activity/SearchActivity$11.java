// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.controller.adapter.c;
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
        c("Circle");
    }

    protected void a(String s1)
    {
        super.a(s1);
        s1 = NetworkSearch.a(s1);
        s1.a(new t(this, "listCircleSuggestion", false));
        a.o = s1;
    }

    protected void b()
    {
        d("Circle");
    }

    protected void b(String s1)
    {
        a("Circle", s1);
        com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).a(com.cyberlink.beautycircle.a.b());
        Object obj = AccountManager.c();
        SearchActivity searchactivity = a;
        CLMultiColumnListView clmulticolumnlistview = com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a);
        long l;
        if (obj != null)
        {
            l = ((Long) (obj)).longValue();
        } else
        {
            l = -1L;
        }
        obj = new c(searchactivity, clmulticolumnlistview, l, 3, SearchActivity.g(a));
        ((c) (obj)).a(s1);
        ((c) (obj)).c();
    }

    stView(SearchActivity searchactivity)
    {
        a = searchactivity;
        super(searchactivity, null);
        b = m.bc_search_header_recent_circles;
        c = m.bc_search_suggestions_circles;
        d = m.bc_search_hint_circles;
    }
}
