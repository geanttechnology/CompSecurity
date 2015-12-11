// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.r;

import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;

// Referenced classes of package com.shazam.android.j.r:
//            a

public final class b
    implements a
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

    public final String a()
    {
        return a("messageko");
    }

    public final String b()
    {
        return a("messageok");
    }

    public final String c()
    {
        return a("upgrade");
    }

    public final String d()
    {
        return a("messageurl");
    }

    public final String e()
    {
        return a("messageurly");
    }

    public final String f()
    {
        return a("messageurln");
    }
}
