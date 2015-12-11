// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.a;

import com.shazam.android.advert.g.a;
import com.shazam.android.advert.g.d;
import com.shazam.android.advert.l;
import com.shazam.android.advert.m;
import com.shazam.model.advert.AdType;

// Referenced classes of package com.shazam.android.advert.a:
//            c

final class a
    implements Runnable
{

    final c a;

    public final void run()
    {
        c.b(a).a(c.b(), m.c, com.shazam.android.advert.a.c.a(a));
        d d1 = com.shazam.android.advert.a.c.d(a);
        com.shazam.model.advert.uilder uilder = com.shazam.model.advert.uilder.a();
        uilder.adType = AdType.AD_COLONY;
        com.shazam.android.advert.g.er er = new com.shazam.android.advert.g.<init>();
        er.b = com.shazam.android.advert.a.c.a(a);
        er.a = c.c(a);
        uilder.adData = new a(er, (byte)0);
        d1.a(uilder.b());
    }

    er(c c1)
    {
        a = c1;
        super();
    }
}
