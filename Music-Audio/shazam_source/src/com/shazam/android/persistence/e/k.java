// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.e;

import com.shazam.android.j.e;

// Referenced classes of package com.shazam.android.persistence.e:
//            f, b, c

public final class k extends b.a
{

    private final b a;
    private final c b;

    public k(b b1, c c1)
    {
        a = b1;
        b = c1;
    }

    public final Object a()
    {
        return b();
    }

    public final e b()
    {
        Object obj;
        try
        {
            obj = (e)a.a();
        }
        catch (f f1)
        {
            f1 = new com.shazam.android.j.e.a();
            f1.b = com.shazam.server.legacy.orbitconfig.OrbitConfig.Builder.anOrbitConfig().build();
            f1.a = com.shazam.server.response.config.AmpConfig.Builder.ampConfig().build();
            f1 = f1.a();
        }
        return b.a(((e) (obj)));
    }
}
