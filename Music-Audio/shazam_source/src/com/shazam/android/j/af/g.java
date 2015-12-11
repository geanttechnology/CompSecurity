// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.af;

import com.shazam.android.ah.d;
import com.shazam.android.aq.c;
import com.shazam.android.ay.a.h;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpSetting;
import com.shazam.server.response.config.AmpSettings;

// Referenced classes of package com.shazam.android.j.af:
//            c

public final class g
    implements com.shazam.android.j.af.c
{

    private final c a;
    private final h b;
    private final d c;
    private final d d;

    public g(c c1, h h1, d d1, d d2)
    {
        a = c1;
        b = h1;
        c = d1;
        d = d2;
    }

    public final void a()
    {
        b.b(d);
        b.b(c);
        if (a.a().getSettings().getWatermarking().isEnabled())
        {
            b.a(c);
        }
    }
}
