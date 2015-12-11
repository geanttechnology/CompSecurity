// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.a;

import android.app.Activity;
import android.os.Handler;
import com.jirbo.adcolony.h;
import com.jirbo.adcolony.n;
import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.advert.g.d;
import com.shazam.android.advert.g.e;
import com.shazam.android.advert.l;
import com.shazam.android.advert.m;
import com.shazam.android.v.a.a;
import com.shazam.android.v.a.b;
import com.shazam.model.advert.AdType;
import com.shazam.model.advert.AdvertSiteIdKey;

// Referenced classes of package com.shazam.android.advert.a:
//            d, b, e, f

public final class c
    implements h, e
{

    private static final ShazamAdView a = null;
    private final com.shazam.android.advert.a.e b;
    private final com.shazam.android.j.a.a c;
    private com.shazam.android.advert.a.b d;
    private Activity e;
    private final Handler f;
    private final b g;
    private final l h;
    private String i;
    private int j;
    private d k;

    public c(com.shazam.android.advert.a.e e1, com.shazam.android.j.a.a a1, Handler handler, b b1, l l1)
    {
        b = e1;
        c = a1;
        f = handler;
        g = b1;
        h = l1;
    }

    static String a(c c1)
    {
        return c1.i;
    }

    static ShazamAdView b()
    {
        return a;
    }

    static l b(c c1)
    {
        return c1.h;
    }

    static com.shazam.android.advert.a.b c(c c1)
    {
        return c1.d;
    }

    private void c()
    {
        Object obj = new com.shazam.android.v.a.a.a();
        obj.b = i;
        obj.c = j;
        obj.a = e;
        obj = new a(((com.shazam.android.v.a.a.a) (obj)), (byte)0);
        d = new com.shazam.android.advert.a.d(new n(((a) (obj)).a, ((a) (obj)).b, ((a) (obj)).c));
        if (d.b())
        {
            f.post(new Runnable() {

                final c a;

                public final void run()
                {
                    com.shazam.android.advert.a.c.b(a).a(com.shazam.android.advert.a.c.b(), m.c, com.shazam.android.advert.a.c.a(a));
                    d d1 = com.shazam.android.advert.a.c.d(a);
                    com.shazam.model.advert.Ad.Builder builder = com.shazam.model.advert.Ad.Builder.a();
                    builder.adType = AdType.AD_COLONY;
                    com.shazam.android.advert.g.a.a a1 = new com.shazam.android.advert.g.a.a();
                    a1.b = com.shazam.android.advert.a.c.a(a);
                    a1.a = c.c(a);
                    builder.adData = new com.shazam.android.advert.g.a(a1, (byte)0);
                    d1.a(builder.b());
                }

            
            {
                a = c.this;
                super();
            }
            });
            return;
        } else
        {
            d();
            return;
        }
    }

    static d d(c c1)
    {
        return c1.k;
    }

    private void d()
    {
        h.a(a, m.c, (new com.shazam.android.advert.a.a()).a(), i);
        k.a();
    }

    public final void a()
    {
        b.b(this);
        k = d.a;
        if (d != null)
        {
            d.c();
            d = null;
        }
    }

    public final void a(Activity activity, AdvertSiteIdKey advertsiteidkey, int i1, d d1)
    {
        e = activity;
        j = i1;
        k = d1;
        i = c.a(advertsiteidkey);
        if (com.shazam.b.e.a.a(i))
        {
            d1.a();
            return;
        }
        h.a();
        activity = com.shazam.android.advert.a.f.a(b.a(i));
        static final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[com.shazam.android.advert.a.f.values().length];
                try
                {
                    a[com.shazam.android.advert.a.f.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[f.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.shazam.android.advert.a.f.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.shazam.android.advert.a._cls2.a[activity.ordinal()])
        {
        default:
            d();
            return;

        case 1: // '\001'
            c();
            return;

        case 2: // '\002'
        case 3: // '\003'
            b.a(this);
            break;
        }
    }

    public final void a(boolean flag, String s)
    {
        if (i.equals(s) && flag)
        {
            b.b(this);
            c();
        }
    }

}
