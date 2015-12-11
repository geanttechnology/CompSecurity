// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.u;

import com.shazam.android.k.f.t;
import com.shazam.android.k.f.v;
import com.shazam.android.persistence.n.b;
import com.shazam.model.facebook.FacebookConnectionState;

public final class f
    implements FacebookConnectionState
{

    private final b a;
    private final v b;
    private final t c;

    public f(b b1, v v1, t t1)
    {
        a = b1;
        b = v1;
        c = t1;
    }

    private void d()
    {
        b.a(c.i());
    }

    public final boolean a()
    {
        return a.a("pk_s_su", false);
    }

    public final void b()
    {
        a.b("pk_s_su", true);
        d();
    }

    public final void c()
    {
        a.b("pk_s_su", false);
        d();
    }
}
