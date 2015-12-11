// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.c;

import com.shazam.android.aq.c;
import com.shazam.android.j.o;
import com.shazam.android.persistence.n.b;
import com.shazam.model.configuration.AuthConfiguration;
import com.shazam.server.response.config.AmpAccount;
import com.shazam.server.response.config.AmpApis;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpHref;
import java.net.URL;
import java.util.Map;

public final class a
    implements AuthConfiguration
{

    private final c a;
    private final b b;
    private final o c;

    public a(c c1, b b1, o o1)
    {
        a = c1;
        b = b1;
        c = o1;
    }

    private URL a(a a1)
    {
    /* block-local class not found */
    class a {}

        a1 = (AmpHref)a.a().getAmpApis().getAmpAccount().getHrefMap().get(a1.k);
        if (a1 != null)
        {
            a1 = c.a(a1.getHref());
        } else
        {
            a1 = null;
        }
        if (a1 != null)
        {
            return com.shazam.b.c.a.a(a1);
        } else
        {
            return null;
        }
    }

    public final URL a()
    {
        return com.shazam.b.c.a.a(b.h("pk_registration"));
    }

    public final URL a(String s)
    {
        return com.shazam.b.c.a.a((new StringBuilder()).append(b.h("pk_registration_upgrade")).append("/").append(s).toString());
    }

    public final URL b()
    {
        return a(a.e);
    }

    public final URL c()
    {
        return a(a.f);
    }

    public final URL d()
    {
        return a(a.g);
    }

    public final URL e()
    {
        return a(a.h);
    }

    public final URL f()
    {
        return a(a.i);
    }

    public final URL g()
    {
        return a(com.shazam.android.j.c.a.c);
    }

    public final URL h()
    {
        return a(a.j);
    }

    public final URL i()
    {
        return a(a.a);
    }
}
