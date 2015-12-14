// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.widget.AbsListView;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g

class b
    implements android.widget.istView.OnScrollListener
{

    final g a;
    private boolean b;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        boolean flag = false;
        if (!b || j <= 0 || a.k == null)
        {
            return;
        }
        if (i == 0)
        {
            g.a(a, false);
        } else
        {
            flag = true;
        }
        g.a(a, a.k, flag);
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
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

    (g g1)
    {
        a = g1;
        super();
        b = false;
    }
}
