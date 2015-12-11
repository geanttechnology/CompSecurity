// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.d;

import android.content.Context;
import com.shazam.android.k.f.p;
import com.shazam.android.l.ab;
import com.shazam.android.l.f;
import com.shazam.android.l.g;
import com.shazam.android.l.i;
import com.shazam.android.l.q;
import com.shazam.android.l.r;
import com.shazam.android.l.s;
import com.shazam.android.l.t;
import com.shazam.android.l.v;
import com.shazam.c.e;
import com.shazam.c.f.c;
import com.shazam.c.h;
import com.shazam.c.j;
import com.shazam.c.k;
import com.shazam.c.k.b;
import com.shazam.c.l;
import com.shazam.c.m;
import com.shazam.c.n;
import com.shazam.c.o;
import com.shazam.c.o.a;
import com.shazam.model.news.TrackInfoCard;
import com.shazam.model.store.AvailableProviders;
import com.shazam.model.tag.AlternativeTrackAddOnFinder;
import java.util.Collections;

// Referenced classes of package com.shazam.i.d:
//            a, f, e, g

public final class d
{

    private static final l a;
    private static final a b;
    private static final t c;

    public static com.shazam.b.a.a A()
    {
        return new com.shazam.c.g.a();
    }

    public static com.shazam.c.i B()
    {
        return new com.shazam.c.g.b(new com.shazam.c.g.a());
    }

    public static com.shazam.b.a.a C()
    {
        return new com.shazam.android.ae.d(com.shazam.i.b.c.a().getResources());
    }

    public static com.shazam.b.a.a D()
    {
        return new com.shazam.c.t.a();
    }

    public static com.shazam.b.a.a E()
    {
        return new com.shazam.c.l.a();
    }

    public static com.shazam.b.a.a F()
    {
        return new com.shazam.android.l.i.b(new com.shazam.android.widget.share.a(com.shazam.i.b.c.a().getPackageManager(), new com.shazam.android.l.i.a(), new r()), com.shazam.i.b.n.b.V());
    }

    public static com.shazam.b.a.a G()
    {
        return new com.shazam.c.b.a(F(), new com.shazam.c.b.b(System.getProperty("line.separator")));
    }

    public static com.shazam.b.a.a H()
    {
        return new com.shazam.c.f.a(new c());
    }

    public static com.shazam.c.i I()
    {
        return new com.shazam.i.d.e();
    }

    public static com.shazam.b.a.a J()
    {
        return new com.shazam.android.l.d(com.shazam.i.b.c.a().getPackageName());
    }

    public static com.shazam.b.a.a K()
    {
        return new com.shazam.android.l.i.a();
    }

    public static com.shazam.b.a.a L()
    {
        return new k();
    }

    public static com.shazam.b.a.a M()
    {
        return new com.shazam.c.p.b(new AlternativeTrackAddOnFinder(), com.shazam.i.k.c.b.a(new com.shazam.c.o.d()), com.shazam.i.b.au.e.a());
    }

    public static com.shazam.b.a.a N()
    {
        return new com.shazam.c.p.a();
    }

    public static com.shazam.b.a.a O()
    {
        return new com.shazam.c.n.b(new com.shazam.c.n.e(Q(), R()), Q(), R());
    }

    public static com.shazam.b.a.a P()
    {
        return new com.shazam.c.n.a(O());
    }

    private static com.shazam.b.a.a Q()
    {
        return new com.shazam.c.n.d(com.shazam.c.j.a(a));
    }

    private static com.shazam.b.a.a R()
    {
        return new com.shazam.c.n.c(com.shazam.c.j.a(a));
    }

    public static com.shazam.b.a.a a()
    {
        return new v(new p(), com.shazam.i.d.g.a(), com.shazam.i.k.c.a.a(new com.shazam.c.o.b()));
    }

    public static com.shazam.c.i a(TrackInfoCard trackinfocard)
    {
        return com.shazam.c.j.a(new l(trackinfocard));
    }

    public static com.shazam.b.a.a b()
    {
        return new f(new p(), com.shazam.i.d.g.a(), com.shazam.i.k.c.a.a(new com.shazam.c.o.b()));
    }

    public static com.shazam.b.a.a c()
    {
        return new s();
    }

    public static com.shazam.c.i d()
    {
        return com.shazam.c.j.a(a);
    }

    public static com.shazam.b.a.a e()
    {
        return new ab(com.shazam.i.b.w.c.a.a());
    }

    public static com.shazam.b.a.a f()
    {
        return new i(new com.shazam.android.l.b[] {
            new com.shazam.android.l.h(com.shazam.i.b.c.a(), com.shazam.i.b.ab.a.a(), com.shazam.i.k.c.a.a(new com.shazam.c.o.b()))
        });
    }

    public static com.shazam.b.a.a g()
    {
        return new com.shazam.android.advert.d.c();
    }

    public static com.shazam.b.a.a h()
    {
        return new com.shazam.android.advert.d.b(com.shazam.i.b.al.d.a().primary);
    }

    public static com.shazam.b.a.a i()
    {
        return new com.shazam.android.advert.d.b(com.shazam.i.b.al.d.a().facebook);
    }

    public static com.shazam.b.a.a j()
    {
        return new com.shazam.android.advert.d.b(com.shazam.i.b.al.d.a().adColony);
    }

    public static com.shazam.b.a.a k()
    {
        return new com.shazam.android.l.l();
    }

    public static com.shazam.b.a.a l()
    {
        return new com.shazam.b.a.a.a();
    }

    public static com.shazam.b.a.a m()
    {
        return new n();
    }

    public static com.shazam.b.a.a n()
    {
        return new com.shazam.android.l.k.a.a();
    }

    public static com.shazam.b.a.a o()
    {
        return new q();
    }

    public static com.shazam.b.a.a p()
    {
        return new com.shazam.c.v.b();
    }

    public static com.shazam.b.a.a q()
    {
        return new o();
    }

    public static com.shazam.b.a.a r()
    {
        return new com.shazam.c.v.a();
    }

    public static com.shazam.b.a.a s()
    {
        return new com.shazam.android.l.b.a(new com.shazam.android.l.b.b(com.shazam.c.j.a(a)));
    }

    public static com.shazam.b.a.a t()
    {
        return a;
    }

    public static com.shazam.b.a.a u()
    {
        return b;
    }

    public static com.shazam.b.a.a v()
    {
        return new g();
    }

    public static com.shazam.b.a.a w()
    {
        return new com.shazam.android.l.p();
    }

    public static com.shazam.c.k.a x()
    {
        return new com.shazam.c.k.a(com.shazam.i.k.c.a.a(new com.shazam.c.o.d()), com.shazam.i.b.ai.c.a(), new b());
    }

    public static com.shazam.c.k.d y()
    {
        return new com.shazam.c.k.d(com.shazam.i.b.ai.c.a());
    }

    public static t z()
    {
        return c;
    }

    static 
    {
        a = new l();
        b = new a(com.shazam.c.j.a(a), new h(new com.shazam.c.a(com.shazam.i.b.ab.a.a(), com.shazam.i.d.a.a(Collections.emptyMap()))), com.shazam.i.b.ab.a.a());
        c = new t(com.shazam.i.j.a.b(), new com.shazam.android.v.l(), b, new m(com.shazam.c.j.a(a)), com.shazam.i.d.f.b(), new c(), F(), new e(new b(), b));
    }
}
