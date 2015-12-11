// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.m;

import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.b.c.a;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import java.net.URL;

// Referenced classes of package com.shazam.android.j.m:
//            a

public final class b
    implements com.shazam.android.j.m.a
{

    private final h a;

    public b(h h1)
    {
        a = h1;
    }

    private String a(String s)
    {
        return a.a().b().getStringConfigEntry(s);
    }

    public final URL a()
    {
        return com.shazam.b.c.a.a(a("actorlookup"));
    }

    public final URL b()
    {
        return com.shazam.b.c.a.a(a("actorpage"));
    }

    public final URL c()
    {
        return com.shazam.b.c.a.a(a("actorsearch"));
    }
}
