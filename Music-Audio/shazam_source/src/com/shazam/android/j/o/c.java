// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.o;

import android.os.Build;
import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.android.persistence.n.b;
import com.shazam.model.configuration.InstallationIdRepository;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;

// Referenced classes of package com.shazam.android.j.o:
//            a

public final class c
    implements a
{

    private static final String a;
    private final h b;
    private final InstallationIdRepository c;
    private final b d;

    public c(h h1, InstallationIdRepository installationidrepository, b b1)
    {
        b = h1;
        c = installationidrepository;
        d = b1;
    }

    public final String a()
    {
        return d.h("pk_locale");
    }

    public final String b()
    {
        return b.a().b().getStringConfigEntry("service");
    }

    public final String c()
    {
        return d.h("pk_appId");
    }

    public final String d()
    {
        return c.b();
    }

    public final String e()
    {
        return b.a().b().getStringConfigEntry("model", a);
    }

    public final String f()
    {
        return "72E5E40F";
    }

    public final String g()
    {
        return Build.FINGERPRINT;
    }

    public final String h()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    static 
    {
        a = (new StringBuilder()).append(Build.BRAND).append("_").append(Build.MODEL).toString();
    }
}
