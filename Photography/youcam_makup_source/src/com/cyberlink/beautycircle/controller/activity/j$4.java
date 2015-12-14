// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.LinearLayout;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            j

class a
    implements android.support.v4.widget.eRefreshLayout.OnRefreshListener
{

    final j a;

    public void onRefresh()
    {
        if (j.i(a) != null)
        {
            j.i(a).removeAllViews();
        }
        if (j.j(a) != null)
        {
            j.j(a).setVisibility(8);
        }
        j.c(a, 0);
        j.a(a);
    }

    eshListener(j j1)
    {
        a = j1;
        super();
    }
}
