// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.concurrent.Executor;

public class ud
{

    final Context a;
    final bje b;
    final cug c;
    final cud d;
    final bzg e;
    final s f = null;
    final blx g;
    final bmw h;
    final csb i;
    final Executor j;
    final cvi k;
    final rv l;
    final ctw m;
    final rw n;
    final qs o;
    final crt p;

    public ud(Context context, bje bje1, cug cug, cud cud, bzg bzg1, s s, blx blx1, 
            bmw bmw1, csb csb1, Executor executor, cvi cvi1, rv rv1, ctw ctw1, rw rw1, 
            qs qs1, crt crt1)
    {
        a = (Context)b.a(context);
        b = (bje)b.a(bje1);
        e = (bzg)b.a(bzg1);
        g = (blx)b.a(blx1);
        h = (bmw)b.a(bmw1);
        i = (csb)b.a(csb1);
        j = (Executor)b.a(executor);
        k = (cvi)b.a(cvi1);
        l = (rv)b.a(rv1);
        m = (ctw)b.a(ctw1);
        n = (rw)b.a(rw1);
        o = (qs)b.a(qs1);
        p = (crt)b.a(crt1);
        d = cud;
        c = cug;
    }

    crs a()
    {
        if (!o.a())
        {
            return p.b();
        } else
        {
            crt crt1 = p;
            o.b();
            return crt1.a();
        }
    }

    public ub a(cto cto1)
    {
        b.a();
        if (cto1.a.g)
        {
            return c(cto1);
        }
        if (cto1.b == ctq.c)
        {
            return b(cto1);
        }
        if (cto1.a.n)
        {
            return e(cto1);
        } else
        {
            return d(cto1);
        }
    }

    public ub a(cwh cwh)
    {
        if (cwh == null)
        {
            return null;
        }
        Object obj = cwh.getClass();
        if (obj == cwk)
        {
            obj = n.b();
            rg rg = n.a();
            bje bje1 = b;
            rv rv1 = l;
            ctw ctw1 = m;
            if (c != null)
            {
                cug cug = c;
                n.c();
            }
            return new ug(((rh) (obj)), rg, bje1, rv1, ctw1, null, g, k, h, i, j, n.c(), d, (cwk)cwh);
        }
        if (obj == cwf)
        {
            return new tu(a, n.b(), n.a(), b, m, g, k, h, j, d, f, a(), (cwf)cwh);
        }
        if (obj == cwd)
        {
            return new ts(n.b(), n.a(), b, m, g, k, h, n.c(), e, (cwd)cwh);
        }
        if (obj == cwm)
        {
            return new uq(n.b(), n.a(), b, m, g, k, h, j, n.c(), d, (cwm)cwh);
        }
        if (obj == cwi)
        {
            return new ue(n.b(), n.a(), b, m, g, k, h, n.c(), (cwi)cwh);
        } else
        {
            return null;
        }
    }

    ub b(cto cto1)
    {
        if (cto1.a.n)
        {
            return new ue(n.b(), n.a(), b, m, g, k, h, n.c(), cto1.d(), cto1.a.d, cto1.e(), cto1.a.l, cto1.a.m, cto1.a.k);
        } else
        {
            b.a(d);
            return new uq(n.b(), n.a(), b, m, g, k, h, j, n.c(), d, cto1.d(), cto1.a.d, cto1.e(), cto1.a.l, cto1.a.m, cto1.a.k);
        }
    }

    ub c(cto cto1)
    {
        b.a(d);
        return new tu(a, n.b(), n.a(), b, m, g, k, h, j, d, f, a(), cto1);
    }

    ub d(cto cto1)
    {
        b.a(d);
        rh rh = n.b();
        rg rg = n.a();
        bje bje1 = b;
        rv rv1 = l;
        ctw ctw1 = m;
        if (c != null)
        {
            cug cug = c;
            n.c();
        }
        return new ug(rh, rg, bje1, rv1, ctw1, null, g, k, h, i, j, n.c(), d, n.d(), cto1);
    }

    ub e(cto cto1)
    {
        return new ts(n.b(), n.a(), b, m, g, k, h, n.c(), e, cto1.a.c, cto1.a.d, cto1.a.m, cto1.a.k);
    }
}
