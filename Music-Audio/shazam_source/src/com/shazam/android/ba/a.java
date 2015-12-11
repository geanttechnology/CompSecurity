// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ba;

import com.shazam.android.persistence.n.b;
import com.shazam.i.b.ah.c.d;
import com.shazam.i.b.ah.f;
import com.shazam.k.t;
import com.shazam.model.configuration.InstallationIdRepository;

public final class a
{

    public final b a;
    public final t b;
    public final InstallationIdRepository c;

    public a()
    {
        this(f.a(), com.shazam.i.b.ad.a.a.a(), d.a());
    }

    private a(b b1, t t, InstallationIdRepository installationidrepository)
    {
        a = b1;
        b = t;
        c = installationidrepository;
    }

    public final void a()
    {
        a.a("pk_lCU", 0L);
        a.b("pk_f_rc", true);
        a.a("pk_knowCode", 0x7d064L);
    }
}
