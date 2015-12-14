// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.m;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.d;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class b
    implements d
{

    final g a;
    private int b;

    public void a(PLA_AbsListView pla_abslistview, int i)
    {
        if (i == 0)
        {
            g.k(a);
        }
    }

    public void a(PLA_AbsListView pla_abslistview, int i, int j, int k)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        if (b != 0)
        {
            a.b.b().d(false);
            a.b.b().h(true);
        }
_L4:
        b = i;
        return;
_L2:
        if (b == 0)
        {
            a.b.b().d(true);
            a.b.b().c(a.b.getString(m.bc_post_related_posts));
            a.b.b().h(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    rFragment(g g1)
    {
        a = g1;
        super();
        b = -1;
    }
}
