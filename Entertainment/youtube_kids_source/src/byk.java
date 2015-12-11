// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.List;
import java.util.concurrent.Executor;
import org.apache.http.client.HttpClient;

public final class byk extends cod
    implements bzg
{

    private crb A;
    private crb B;
    private crb C;
    private crb D;
    private crb E;
    private crb F;
    private crb G;
    private crb H;
    private crb I;
    private crb J;
    private cqk K;
    private final cql L;
    final bzl a;
    private final bng g;
    private bzk h;
    private bzk i;
    private bzk j;
    private bzk k;
    private ccd l;
    private caf m;
    private caf n;
    private cae o;
    private bid p;
    private bid q;
    private bid r;
    private bid s;
    private bid t;
    private bid u;
    private bid v;
    private bid w;
    private bid x;
    private bid y;
    private bid z;

    public byk(Context context, Executor executor, HttpClient httpclient, bmi bmi, bns bns, bzl bzl1, qs qs, 
            String s1)
    {
        super(executor, httpclient, bns, s1, bmi);
        b.a(context);
        g = new bng(context.getContentResolver());
        a = (bzl)b.a(bzl1);
        L = new cql(qs);
    }

    private crb d()
    {
        cqg cqg1 = a(a(j, new ccb(f)));
        return new cbz(p, cqg1, a, c, 0x6ddd00L);
    }

    public final bzl a()
    {
        return a;
    }

    public final void a(String s1, bhv bhv)
    {
        A.a(a.a(s1), bhv);
    }

    public final void a(List list, cqk cqk1, cby cby, bzj bzj)
    {
        b.a(bzj);
        K = (cqk)b.a(cqk1);
        b.b(super.d, "this instance does not support persistent caching");
        super.b.execute(new bij(super.d, 0x1400000L));
        h = new bzk(bkf.a, list, g, bzj, cby);
        i = new bzk(bkf.c, "application/atom+xml", list, g, bzj, cby);
        j = new bzk(bkf.b, "application/atom+xml", list, g, bzj, cby);
        k = new bzk(bkf.e, "application/atom+xml", list, g, bzj, cby);
        l = new ccd(f);
        u = a(20);
        p = a(500);
        q = a(500);
        list = new cdh(a(((crb) (a(((cot) (h)), ((coo) (l)))))), q, a, c);
        A = a(p, ((crb) (list)), 0xdbba00L);
        cqi.a(a(p, ((crb) (list)), 0L), cqk1, L);
        cqi.a(a(p, ((crb) (list)), 0x1b7740L), cqk1, L);
        t = a(50);
        v = new bip(t, p, new byr(this));
        B = a(((cot) (h)), ((coo) (new ccc(f))));
        w = a(100);
        x = a(50);
        y = new bip(x, w, new byq(this));
        z = a(100);
        o = new cae(f);
        n = caf.c(f);
        C = a(((cot) (h)), ((coo) (o)));
        list = a(C);
        a(y, ((crb) (list)), 0x1b7740L);
        list = a(C);
        a(y, ((crb) (list)), 0x493e0L);
        list = a(C);
        cqi.a(a(y, ((crb) (list)), 0x1b7740L), K, L);
        list = a(((crb) (a(((cot) (h)), ((coo) (n))))));
        F = a(w, ((crb) (list)), 0x1b7740L);
        cqi.a(F, cqk1, L);
        list = a(B);
        D = a(v, ((crb) (list)), 0x6ddd00L);
        list = a(B);
        a(v, ((crb) (list)), 0x1b7740L);
        list = new cbl(f);
        list = a(((crb) (a(((cot) (h)), ((coo) (list))))));
        E = a(z, ((crb) (list)), 0x493e0L);
        list = new byw(f);
        list = a(((crb) (a(((cot) (h)), ((coo) (list))))));
        a(u, ((crb) (list)), 0x6ddd00L);
        cqi.a(E, cqk1, L);
        list = a(B);
        G = cqi.a(a(v, ((crb) (list)), 0x1b7740L), K, L);
        list = a(B);
        cqi.a(a(v, ((crb) (list)), 0x493e0L), K, L);
        new byi("uploads");
        new cba(G, 50);
        a(((crb) (new caw(a, D))));
        list = bzn.a(f);
        H = cqi.a(a(((cot) (j)), ((coo) (list))), cqk1, L);
        I = cqg.a(b, H);
        new byl(this, p, I);
        J = cqi.a(a(((cot) (k)), ((coo) (list))), cqk1, L);
        m = caf.b(f);
        list = cqi.a(a(((cot) (j)), ((coo) (m))), K, L);
        a(((crb) (a(((bjo) (new byi("playlists"))), x, ((crb) (list))))));
        a(((crb) (a(((bjo) (new byi("playlists"))), x, J))));
        list = cqi.a(a(((cot) (j)), ((coo) (l))), K, L);
        a(((crb) (a(((bjo) (new byi("favorites"))), t, ((crb) (list))))));
        a(((crb) (a(((bjo) (new byi("watch_later"))), t, H))));
        a(((crb) (a(((bjo) (new byi("watch_history"))), t, H))));
        a(((crb) (a(((bjo) (new byi("favorites"))), t, J))));
        a(((crb) (cqi.a(a(((cot) (j)), ((coo) (new cbe()))), K, L))));
        a(((crb) (a(((bjo) (new byi("uploads"))), t, J))));
        list = cqi.a(a(((cot) (i)), ((coo) (l))), K, L);
        a(((crb) (a(((bjo) (new byi("uploads"))), t, ((crb) (list))))));
        r = a(300);
        s = new bip(r, p, new byp(this));
        list = new bzx(f);
        list = a(((crb) (a(((cot) (h)), ((coo) (list))))));
        coa.a(s, list, c, 60000L);
        list = new bzw(f);
        list = a(((crb) (a(((cot) (h)), ((coo) (list))))));
        a(((bid) (new bip(a(20), s, new byo(this)))), ((crb) (list)), 60000L);
        list = new byn(this);
        cqk1 = a(H);
        a(((bjo) (list)), z, ((crb) (cqk1)));
        d();
        new cay(d());
    }

    public final crb b()
    {
        return D;
    }
}
