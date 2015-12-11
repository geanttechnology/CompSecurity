// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.d;

import com.shazam.android.v.d.a;
import com.shazam.c.f.b;
import com.shazam.c.j.a.c;
import com.shazam.c.j.a.d;
import com.shazam.c.j.a.e;
import com.shazam.c.j.a.g;
import com.shazam.c.j.a.h;
import com.shazam.c.j.a.i;
import com.shazam.c.j.a.j;
import com.shazam.c.j.a.k;
import com.shazam.c.j.a.l;
import com.shazam.c.j.a.m;
import com.shazam.c.j.a.n;
import com.shazam.c.j.a.o;
import com.shazam.c.j.a.p;
import com.shazam.c.j.a.q;
import com.shazam.model.news.FeedCardType;
import com.shazam.model.preview.PreviewViewDataUrlDecorator;
import java.util.EnumMap;
import java.util.Map;

// Referenced classes of package com.shazam.i.d:
//            d, c

public final class f
{

    private static final g a;

    public static com.shazam.b.a.a a()
    {
        return new com.shazam.c.j.a(com.shazam.c.j.a(a), com.shazam.i.b.n.b.c(), com.shazam.i.b.w.e.a.a());
    }

    public static com.shazam.b.a.a b()
    {
        return new j();
    }

    private static com.shazam.b.a.a c()
    {
        return new com.shazam.c.j.a.a(new p(), new q(new p()));
    }

    private static com.shazam.b.a.a d()
    {
        return new com.shazam.c.j.b(e(), new com.shazam.c.k.b(), new b());
    }

    private static com.shazam.b.a.a e()
    {
        return new com.shazam.c.j.a.b(com.shazam.i.k.c.a.a(new com.shazam.c.o.b()));
    }

    private static com.shazam.b.a.a f()
    {
        return new c(com.shazam.i.d.d.d());
    }

    static 
    {
        EnumMap enummap = new EnumMap(com/shazam/model/news/FeedCardType);
        enummap.put(FeedCardType.TAG, new k(d(), new a()));
        enummap.put(FeedCardType.ARTIST_POST, new e(d(), new a(), com.shazam.i.d.d.A()));
        enummap.put(FeedCardType.ARTIST_JUST_JOINED, new d(f(), com.shazam.i.d.c.a(3), new b()));
        enummap.put(FeedCardType.SOCIAL_LOGIN, new i());
        enummap.put(FeedCardType.GENERAL, new h(e(), c(), new PreviewViewDataUrlDecorator(), f()));
        enummap.put(FeedCardType.TV, new m(f()));
        enummap.put(FeedCardType.RAIL, new com.shazam.c.j.a.f(f()));
        enummap.put(FeedCardType.TRACK, new l(c(), d(), new a()));
        enummap.put(FeedCardType.WHATS_NEW, new o(f()));
        enummap.put(FeedCardType.SPONSORED, new j());
        enummap.put(FeedCardType.VIDEO, new n());
        a = new g(enummap);
    }
}
