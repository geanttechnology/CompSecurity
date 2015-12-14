// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkSearch;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            s, SearchActivity, t

class d extends s
{

    final SearchActivity a;

    protected void a()
    {
    }

    protected void a(String s1)
    {
        super.a(s1);
        s1 = NetworkSearch.a();
        s1.a(new t(this, "listTopPostKeyword", false));
        a.o = s1;
    }

    protected void b()
    {
    }

    protected void b(String s1)
    {
    }

    (SearchActivity searchactivity)
    {
        a = searchactivity;
        super(searchactivity, null);
        b = m.bc_search_header_trending;
        c = m.bc_search_header_trending;
        d = m.bc_search_hint;
    }
}
