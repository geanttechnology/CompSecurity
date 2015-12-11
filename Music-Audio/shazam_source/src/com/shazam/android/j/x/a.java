// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.x;

import com.shazam.android.persistence.n.b;
import com.shazam.model.configuration.PlayWithConfiguration;
import com.shazam.model.configuration.RdioConfiguration;

public final class a
    implements RdioConfiguration
{

    private final PlayWithConfiguration a;
    private final b b;

    public a(PlayWithConfiguration playwithconfiguration, b b1)
    {
        a = playwithconfiguration;
        b = b1;
    }

    public final boolean a()
    {
        return a.b("rdio");
    }

    public final boolean b()
    {
        return b.a("pk_has_never_been_shown", true);
    }

    public final void c()
    {
        b.b("pk_has_never_been_shown", false);
    }
}
