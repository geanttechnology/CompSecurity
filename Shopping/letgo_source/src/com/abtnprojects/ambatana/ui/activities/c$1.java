// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.support.v7.aqo;
import android.support.v7.dy;
import android.support.v7.ea;
import android.support.v7.eb;
import android.support.v7.ee;
import android.support.v7.ei;
import android.support.v7.eq;
import android.support.v7.iv;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            c

class a
{

    final c a;

    public void on(dy dy)
    {
        a.a(dy);
    }

    public void on(ea ea1)
    {
        a.a(ea1.a);
    }

    public void on(eb eb)
    {
        a.invalidateOptionsMenu();
    }

    public void on(ee ee1)
    {
        aqo.a("LocationChangedEvent %s", new Object[] {
            ee1.a
        });
        iv.a(a.s);
    }

    public void on(ei ei)
    {
        aqo.a("NoProvidersAvailableEvent", new Object[0]);
        a.u();
    }

    public void on(eq eq)
    {
        iv.a(a.s);
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
