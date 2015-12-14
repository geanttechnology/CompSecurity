// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.widget.LinearLayout;
import com.cyberlink.beautycircle.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g

class a
    implements android.support.v4.widget.RefreshLayout.OnRefreshListener
{

    final g a;

    public void onRefresh()
    {
        LinearLayout linearlayout = (LinearLayout)g.o(a).findViewById(j.post_layout);
        if (linearlayout != null)
        {
            int i = linearlayout.getChildCount();
            if (i > 1)
            {
                linearlayout.removeViews(1, i - 1);
            }
        }
        if (g.q(a) != null)
        {
            g.q(a).removeAllViews();
        }
        a.a = 0;
        g.c(a);
    }

    shListener(g g1)
    {
        a = g1;
        super();
    }
}
