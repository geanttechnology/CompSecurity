// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.e;

import com.shazam.android.advert.g.d;
import com.shazam.android.advert.l;
import com.shazam.model.Factory;
import com.shazam.model.advert.AdvertSiteIdKey;

// Referenced classes of package com.shazam.android.advert.e:
//            h, d, b, g, 
//            a

private final class c
    implements Runnable
{

    final h a;
    private final AdvertSiteIdKey b;
    private final d c;

    public final void run()
    {
        com.shazam.android.advert.e.d d1 = (com.shazam.android.advert.e.d)h.a(a).create(b);
        if (d1 != null)
        {
            String s = d1.b();
            d1.a(new b(new g[] {
                a, new a(s, h.b(a))
            }));
            h.b(a).a();
            d1.a();
            return;
        } else
        {
            c.a();
            return;
        }
    }

    public teIdKey(h h1, AdvertSiteIdKey advertsiteidkey, d d1)
    {
        a = h1;
        super();
        b = advertsiteidkey;
        c = d1;
    }
}
