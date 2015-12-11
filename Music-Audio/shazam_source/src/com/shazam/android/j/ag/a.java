// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.ag;

import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;

// Referenced classes of package com.shazam.android.j.ag:
//            b

public final class a
    implements b
{

    private final h a;

    public a(h h1)
    {
        a = h1;
    }

    public final int a()
    {
        return a.a().b().getIntegerConfigEntry("mediaunittimeoutseconds", Integer.valueOf(15)).intValue();
    }
}
