// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkSearch;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            s, SearchActivity, t, p

class d extends s
{

    final SearchActivity a;

    protected void a()
    {
        c("Post");
    }

    protected void a(String s1)
    {
        super.a(s1);
        s1 = NetworkSearch.b(s1);
        s1.a(new t(this, "listPostKeywordSuggestion", false));
        a.o = s1;
    }

    protected void b()
    {
        d("Post");
    }

    protected void b(String s1)
    {
        a("Post", s1);
        com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).a(com.cyberlink.beautycircle.a.a());
        com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a, new p(a, a, com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a), k.bc_view_item_discover_list, s1, SearchActivity.g(a)));
        SearchActivity.h(a).c();
    }

    istView(SearchActivity searchactivity)
    {
        a = searchactivity;
        super(searchactivity, null);
        b = m.bc_search_header_recent_posts;
        c = m.bc_search_suggestions_posts;
        d = m.bc_search_hint_posts;
    }
}
