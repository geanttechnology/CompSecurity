// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.s;

import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.b.c.a;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import java.net.URL;

// Referenced classes of package com.shazam.android.j.s:
//            b

public final class c
    implements b
{

    private final h a;

    public c(h h1)
    {
        a = h1;
    }

    public final URL a()
    {
        return com.shazam.b.c.a.a(a.a().b().getStringConfigEntry("newsfeed"));
    }
}
