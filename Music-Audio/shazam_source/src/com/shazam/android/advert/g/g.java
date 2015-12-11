// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.g;

import android.app.Activity;
import com.shazam.model.advert.Ad;
import com.shazam.model.advert.AdType;
import com.shazam.model.advert.AdvertSiteIdKey;

// Referenced classes of package com.shazam.android.advert.g:
//            e, c, d

public final class g
    implements Runnable
{
    private final class a
        implements d
    {

        final g b;
        private final int c;

        public final void a()
        {
            if (!g.c(b) && g.b(b, c))
            {
                c c1 = g.b(b);
                com.shazam.model.advert.Ad.Builder builder = com.shazam.model.advert.Ad.Builder.a();
                builder.adType = AdType.FALLBACK;
                c1.b(builder.b());
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

        public a(int i)
        {
            b = g.this;
            super();
            c = i;
        }
    }


    c a;
    private final e b[];
    private final AdvertSiteIdKey c;
    private final int d;
    private int e;
    private final Activity f;

    public g(Activity activity, e ae[], AdvertSiteIdKey advertsiteidkey, int i, c c1)
    {
        e = 0x7fffffff;
        f = activity;
        b = ae;
        c = advertsiteidkey;
        d = i;
        a = c1;
    }

    static int a(g g1)
    {
        return g1.e;
    }

    static int a(g g1, int i)
    {
        g1.e = i;
        return i;
    }

    static c b(g g1)
    {
        return g1.a;
    }

    static boolean b(g g1, int i)
    {
        return i == g1.b.length - 1;
    }

    static boolean c(g g1)
    {
        return g1.e < 0x7fffffff;
    }

    public final void run()
    {
        int i = 0;
        for (int j = b.length; i < j; i++)
        {
            b[i].a(f, c, d, new a(i));
        }

    }
}
