// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.d;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity

class b
    implements d
{

    final SearchActivity a;
    private boolean b;

    public void a(PLA_AbsListView pla_abslistview, int i)
    {
        if (i == 0)
        {
            b = false;
            return;
        } else
        {
            b = true;
            return;
        }
    }

    public void a(PLA_AbsListView pla_abslistview, int i, int j, int k)
    {
        boolean flag;
        for (flag = false; !b || j <= 0 || SearchActivity.r(a) == null;)
        {
            return;
        }

        if (i == 0)
        {
            SearchActivity.c(a, false);
        } else
        {
            flag = true;
        }
        SearchActivity.b(a, SearchActivity.r(a), flag);
    }

    (SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
        b = false;
    }
}
