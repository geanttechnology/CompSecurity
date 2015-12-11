// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.g;

import com.shazam.model.advert.Ad;
import com.shazam.model.advert.AdType;

// Referenced classes of package com.shazam.android.advert.g:
//            d, g, c

private final class c
    implements d
{

    final g b;
    private final int c;

    public final void a()
    {
        if (!g.c(b) && g.b(b, c))
        {
            c c1 = g.b(b);
            com.shazam.model.advert.uilder uilder = com.shazam.model.advert.uilder.a();
            uilder.adType = AdType.FALLBACK;
            c1.b(uilder.b());
        }
    }

    public final void a(Ad ad)
    {
        if (g.a(b) > c)
        {
            g.a(b, c);
            g.b(b).a(ad);
        }
    }

    public er(g g1, int i)
    {
        b = g1;
        super();
        c = i;
    }
}
