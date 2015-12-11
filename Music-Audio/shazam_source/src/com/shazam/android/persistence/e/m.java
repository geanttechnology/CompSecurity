// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.e;

import com.shazam.android.persistence.n.b;
import com.shazam.b.e.a;
import com.shazam.model.configuration.InstallationIdRepository;

public final class m
    implements InstallationIdRepository
{

    private final b a;

    public m(b b1)
    {
        a = b1;
    }

    public final void a(String s)
    {
        a.b("inid", s);
    }

    public final boolean a()
    {
        String s = b();
        return com.shazam.b.e.a.c(s) && !"unknown".equals(s);
    }

    public final String b()
    {
        return a.a("inid", "unknown");
    }
}
