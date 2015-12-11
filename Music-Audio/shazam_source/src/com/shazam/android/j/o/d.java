// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.o;

import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.android.persistence.n.b;
import com.shazam.b.c.a;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import java.net.URL;

// Referenced classes of package com.shazam.android.j.o:
//            b

public final class d
    implements com.shazam.android.j.o.b
{

    private final h a;
    private final b b;

    public d(h h1, b b1)
    {
        a = h1;
        b = b1;
    }

    private URL a(String s)
    {
        return com.shazam.b.c.a.a(a.a().b().getStringConfigEntry(s));
    }

    public final URL a()
    {
        return com.shazam.b.c.a.a(b.h("pk_requestConfig"));
    }

    public final URL b()
    {
        return a("dorecognition");
    }

    public final URL c()
    {
        return a("registeruserevent");
    }
}
