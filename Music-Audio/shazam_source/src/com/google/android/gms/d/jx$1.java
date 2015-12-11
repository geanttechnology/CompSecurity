// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.e.b;

// Referenced classes of package com.google.android.gms.d:
//            jx, jv

public final class a
    implements h
{

    final jx a;

    public final void a(g g)
    {
        g = (b)g;
        if (g.a().b())
        {
            g = g.c();
        } else
        {
            g = null;
        }
        g = new jv(jx.a(a), g, a.a());
        jx.a(a, ((jv) (g)).a);
        com.google.android.gms.d.jx.b(a);
    }

    public api.g(jx jx1)
    {
        a = jx1;
        super();
    }
}
