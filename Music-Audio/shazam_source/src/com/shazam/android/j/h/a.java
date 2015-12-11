// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.h;

import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.model.configuration.ExploreConfiguration;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import java.net.URL;

public final class a
    implements ExploreConfiguration
{

    private final h a;

    public a(h h1)
    {
        a = h1;
    }

    private URL a(String s)
    {
        return com.shazam.b.c.a.a(a.a().b().getStringConfigEntry(s));
    }

    public final URL a()
    {
        return a("gettopcitytracks");
    }

    public final URL b()
    {
        return a("gettopcountrytracks");
    }

    public final URL c()
    {
        return a("gettopcontinenttracks");
    }

    public final URL d()
    {
        return a("mapstrackart");
    }

    public final boolean e()
    {
        return f() != null;
    }

    public final URL f()
    {
        return com.shazam.b.c.a.a(a.a().b().getStringConfigEntry("gettoptracks"));
    }
}
