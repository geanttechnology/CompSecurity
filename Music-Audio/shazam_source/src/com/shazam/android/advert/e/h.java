// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.e;

import android.app.Activity;
import android.os.Handler;
import com.shazam.android.advert.g.d;
import com.shazam.android.advert.g.e;
import com.shazam.android.advert.l;
import com.shazam.model.Factory;
import com.shazam.model.advert.AdType;
import com.shazam.model.advert.AdvertSiteIdKey;

// Referenced classes of package com.shazam.android.advert.e:
//            g, f, d, b, 
//            a

public final class h
    implements g, e
{
    private final class a
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
                    a, new com.shazam.android.advert.e.a(s, h.b(a))
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

        public a(AdvertSiteIdKey advertsiteidkey, d d1)
        {
            a = h.this;
            super();
            b = advertsiteidkey;
            c = d1;
        }
    }


    private final Handler b;
    private final Factory c;
    private final l d;
    private d e;

    public h(Handler handler, Factory factory, l l)
    {
        e = d.a;
        b = handler;
        c = factory;
        d = l;
    }

    static Factory a(h h1)
    {
        return h1.c;
    }

    static l b(h h1)
    {
        return h1.d;
    }

    public final void a()
    {
        e = d.a;
    }

    public final void a(int i)
    {
        e.a();
    }

    public final void a(Activity activity, AdvertSiteIdKey advertsiteidkey, int i, d d1)
    {
        e = d1;
        b.post(new a(advertsiteidkey, d1));
    }

    public final void a(f f)
    {
        d d1 = e;
        com.shazam.model.advert.Ad.Builder builder = com.shazam.model.advert.Ad.Builder.a();
        builder.adType = AdType.FACEBOOK;
        builder.adData = f;
        d1.a(builder.b());
    }
}
