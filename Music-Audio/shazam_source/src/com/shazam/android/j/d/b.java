// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.d;

import com.shazam.a.a.f;
import com.shazam.android.aq.h;
import com.shazam.android.testmode.e;
import com.shazam.b.e.a;
import com.shazam.model.configuration.InstallationIdRepository;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import java.net.URL;

// Referenced classes of package com.shazam.android.j.d:
//            a

public final class b
    implements com.shazam.android.j.d.a
{

    private final h a;
    private final f b;
    private final InstallationIdRepository c;
    private final e d;
    private final com.shazam.android.persistence.n.b e;

    public b(h h1, f f1, InstallationIdRepository installationidrepository, e e1, com.shazam.android.persistence.n.b b1)
    {
        a = h1;
        b = f1;
        c = installationidrepository;
        d = e1;
        e = b1;
    }

    private String b()
    {
        String s = d.j();
        if (com.shazam.b.e.a.c(s))
        {
            return s;
        } else
        {
            return a.a().b().getStringConfigEntry("continuousrecognise");
        }
    }

    public final URL a(String s)
    {
        String s1 = b();
        if (com.shazam.b.e.a.a(s1))
        {
            return null;
        } else
        {
            return com.shazam.b.c.a.a(b.a(s1, new String[] {
                c.b(), s
            }));
        }
    }

    public final boolean a()
    {
        return e.a("autotag", true) && com.shazam.b.e.a.c(b());
    }
}
