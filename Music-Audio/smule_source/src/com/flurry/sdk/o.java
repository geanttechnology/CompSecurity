// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

// Referenced classes of package com.flurry.sdk:
//            r, i, cr, ch, 
//            p, hk, fz, aa, 
//            d, x, gd, ci, 
//            y, hp, ap, fy, 
//            e, hj, fx

public abstract class o
    implements r
{

    private static final String a = com/flurry/sdk/o.getSimpleName();
    private final int b;
    private final WeakReference c;
    private final WeakReference d;
    private final String e;
    private final ch f;
    private long g;
    private final fy h = new fy() {

        final o a;

        public void a(hj hj1)
        {
            a.r();
            o.a(a, System.currentTimeMillis());
        }

        public void notify(fx fx)
        {
            a((hj)fx);
        }

            
            {
                a = o.this;
                super();
            }
    };
    private final fy i = new fy() {

        final o a;

        public void a(d d1)
        {
            while (d1.a != a || d1.b == null) 
            {
                return;
            }
            a.a(d1);
        }

        public void notify(fx fx)
        {
            a((d)fx);
        }

            
            {
                a = o.this;
                super();
            }
    };
    private ap j;
    private ap k;
    private e l;

    protected o(Context context, ViewGroup viewgroup, String s1)
    {
        i i1 = com.flurry.sdk.i.a();
        if (i1 == null)
        {
            throw new IllegalStateException("A session must be started before ad objects may be instantiated.");
        } else
        {
            b = cr.a();
            c = new WeakReference(context);
            d = new WeakReference(viewgroup);
            e = s1;
            f = new ch(s1);
            i1.d().a(context, this);
            s();
            u();
            return;
        }
    }

    static long a(o o1, long l1)
    {
        o1.g = l1;
        return l1;
    }

    private void s()
    {
        g = System.currentTimeMillis();
        hk.a().a(h);
    }

    private void t()
    {
        hk.a().b(h);
    }

    private void u()
    {
        fz.a().a("com.flurry.android.impl.ads.AdStateEvent", i);
    }

    private void v()
    {
        fz.a().a(i);
    }

    public void a()
    {
        t();
        v();
        com.flurry.sdk.i.a().d().b(e(), this);
        aa aa1 = com.flurry.sdk.i.a().l();
        if (aa1 != null)
        {
            aa1.a(this);
        }
        if (f != null)
        {
            f.a();
        }
        l = null;
    }

    public void a(ap ap1)
    {
        j = ap1;
    }

    public void a(ap ap1, long l1)
    {
        h().a(this, i(), j());
    }

    protected void a(d d1)
    {
        if (d.a.a.equals(d1.b) || d.a.b.equals(d1.b))
        {
            int i1 = j().b();
            if (i1 == 0)
            {
                gd.a(3, a, (new StringBuilder()).append("Starting ad request from EnsureCacheNotEmpty size: ").append(i1).toString());
                i().a(this, j(), null);
            }
        }
    }

    public void a(e e1)
    {
        l = e1;
    }

    public void a(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return;
        } else
        {
            h().b();
            j().a(s1);
            return;
        }
    }

    public void b()
    {
        t();
    }

    public void c()
    {
        s();
    }

    public int d()
    {
        return b;
    }

    public Context e()
    {
        return (Context)c.get();
    }

    public ViewGroup f()
    {
        return (ViewGroup)d.get();
    }

    protected void finalize()
    {
        super.finalize();
        a();
    }

    public String g()
    {
        return e;
    }

    public ch h()
    {
        return f;
    }

    public ci i()
    {
        return com.flurry.sdk.i.a().c().a(g(), null, l()).a();
    }

    public x j()
    {
        return com.flurry.sdk.i.a().c().a(g(), null, l()).b();
    }

    public ap k()
    {
        return k;
    }

    public e l()
    {
        return l;
    }

    public void m()
    {
        f.c();
    }

    protected ap n()
    {
        return j;
    }

    protected void o()
    {
        hp.b();
        if (!j.o() && j.n())
        {
            gd.a(3, a, "Precaching optional for ad, copying assets before display");
            com.flurry.sdk.i.a().l().a(this, j);
        }
    }

    protected void p()
    {
        k = j;
        j = null;
    }

    protected long q()
    {
        return g;
    }

    protected void r()
    {
    }

}
