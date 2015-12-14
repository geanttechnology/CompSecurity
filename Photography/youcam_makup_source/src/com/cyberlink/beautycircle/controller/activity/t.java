// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.view.widgetpool.common.BiDirectionSwipeRefreshLayout;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            s, SearchActivity, q

public class t extends m
{

    final s a;
    private final String b;
    private final boolean c;

    public t(s s1, String s2, boolean flag)
    {
        a = s1;
        super();
        b = s2;
        c = flag;
    }

    protected void a()
    {
        a(0x80000005);
    }

    protected void a(int i)
    {
        SearchActivity.b(a.e).b();
        e.e(new Object[] {
            "[", b, "]: ", Integer.valueOf(i)
        });
        if (e.a)
        {
            Globals.a((new StringBuilder()).append("[").append(b).append("] error: ").append(i).toString());
        }
    }

    protected void b(Object obj)
    {
        SearchActivity.b(a.e).b();
        SearchActivity.f(a.e).setRefreshing(false);
        Class class1 = null;
        if (obj != null)
        {
            class1 = obj.getClass();
            e.b(new Object[] {
                "[", b, "]: ", class1
            });
        }
        SearchActivity.b(a.e).clear();
        if (class1 != null)
        {
            if (obj.getClass().isAssignableFrom(com/cyberlink/beautycircle/model/network/NetworkSearch$SuggestionKeywords))
            {
                SearchActivity.b(a.e).addAll(((com.cyberlink.beautycircle.model.network.NetworkSearch.SuggestionKeywords)obj).results);
            } else
            if (obj.getClass().isAssignableFrom(com/cyberlink/beautycircle/model/network/d))
            {
                SearchActivity.b(a.e).addAll(((d)obj).b);
            } else
            {
                e.e(new Object[] {
                    "[", b, "] Unsupported result type: ", obj.getClass()
                });
                b(0x80000002);
            }
        }
        if (c)
        {
            SearchActivity.a(a.e, SearchActivity.b(a.e).isEmpty());
        }
        SearchActivity.b(a.e).notifyDataSetChanged();
    }
}
