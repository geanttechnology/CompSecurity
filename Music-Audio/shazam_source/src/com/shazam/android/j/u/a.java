// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.u;

import com.shazam.android.aq.c;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpNtp;
import java.util.List;

// Referenced classes of package com.shazam.android.j.u:
//            b

public final class a
    implements b
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public final List a()
    {
        return a.a().getAmpNtp().getServers();
    }
}
