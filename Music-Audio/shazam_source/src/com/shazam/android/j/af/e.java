// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.af;

import com.shazam.android.aq.h;
import com.shazam.o.q;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.shazam.android.j.af:
//            f

public final class e
    implements f
{

    private final h a;
    private final com.shazam.android.testmode.e b;
    private Integer c;

    public e(h h1, com.shazam.android.testmode.e e1)
    {
        a = h1;
        b = e1;
    }

    private OrbitConfig h()
    {
        return a.a().b();
    }

    public final int a()
    {
        if (c == null)
        {
            int i = h().getIntegerConfigEntry("samplerate", Integer.valueOf(44100)).intValue();
            c = Integer.valueOf(b.a(i));
        }
        return c.intValue();
    }

    public final int b()
    {
        OrbitConfig orbitconfig = h();
        if (orbitconfig.getIntegerConfigEntry("progressiveseconds") != null)
        {
            return orbitconfig.getIntegerConfigEntry("progressiveseconds", Integer.valueOf(2)).intValue();
        } else
        {
            return orbitconfig.getIntegerConfigEntry("sampleseconds", Integer.valueOf(10)).intValue();
        }
    }

    public final int c()
    {
        return h().getIntegerConfigEntry("silentrecordingseconds", Integer.valueOf(2)).intValue();
    }

    public final q d()
    {
        return new q(h().getIntegerConfigEntry("sampleseconds", Integer.valueOf(10)).intValue(), TimeUnit.SECONDS);
    }

    public final q e()
    {
        return d();
    }

    public final q f()
    {
        return new q(h().getIntegerConfigEntry("maxtagseconds", Integer.valueOf(45)).intValue(), TimeUnit.SECONDS);
    }

    public final int g()
    {
        return !"voice_recognition".equals(h().getStringConfigEntry("micmode")) ? 1 : 6;
    }
}
