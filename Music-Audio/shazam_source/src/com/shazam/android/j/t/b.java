// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.t;

import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;

// Referenced classes of package com.shazam.android.j.t:
//            a

public final class b
    implements a
{

    private final h a;

    public b(h h1)
    {
        a = h1;
    }

    public final String a()
    {
        return a.a().b().getStringConfigEntry("c2dmNotificationEmail");
    }
}
