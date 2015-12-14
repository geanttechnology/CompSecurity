// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.d;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g

class b
    implements d
{

    final g a;
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

    (g g1)
    {
        a = g1;
        super();
        b = false;
    }
}
