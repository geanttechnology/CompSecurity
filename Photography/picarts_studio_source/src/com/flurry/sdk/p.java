// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Collections;

// Referenced classes of package com.flurry.sdk:
//            s, i, fa, dn, 
//            q, jy, ay, ar, 
//            ex, lk, y, kc, 
//            d, do, ab, z, 
//            lp, jb, jx, e

public abstract class p
    implements s
{

    private static final String a = com/flurry/sdk/p.getSimpleName();
    private final int b;
    private final WeakReference c;
    private final WeakReference d;
    private final String e;
    private final dn f;
    private boolean g;
    private boolean h;
    private long i;
    private final jx j = new _cls1();
    private final jx k = new _cls2();
    private final jx l = new _cls3();
    private ar m;
    private ar n;
    private e o;

    protected p(Context context, ViewGroup viewgroup, String s1)
    {
        g = false;
        h = false;
        i i1 = com.flurry.sdk.i.a();
        if (i1 == null)
        {
            throw new IllegalStateException("A session must be started before ad objects may be instantiated.");
        } else
        {
            b = fa.a();
            c = new WeakReference(context);
            d = new WeakReference(viewgroup);
            e = s1;
            f = new dn(s1);
            i1.d().a(context, this);
            y();
            A();
            C();
            return;
        }
    }

    private void A()
    {
        jy.a().a("com.flurry.android.impl.ads.AdStateEvent", k);
    }

    private void B()
    {
        jy.a().a(k);
    }

    private void C()
    {
        jy.a().a("com.flurry.android.sdk.FlurrySessionEvent", l);
    }

    private void D()
    {
        jy.a().a(l);
    }

    private void E()
    {
        if (g && l().e(ay.v.a()))
        {
            ex.a(ay.v, Collections.emptyMap(), f(), this, l(), 0);
            l().f(ay.v.a());
        }
    }

    static long a(p p1, long l1)
    {
        p1.i = l1;
        return l1;
    }

    private void y()
    {
        i = System.currentTimeMillis();
        lk.a().a(j);
    }

    private void z()
    {
        lk.a().b(j);
    }

    public void a()
    {
        z();
        B();
        D();
        g = false;
        h = false;
        com.flurry.sdk.i.a().d().b(f(), this);
        b();
        if (f != null)
        {
            f.a();
        }
        o = null;
    }

    public void a(ar ar1)
    {
        m = ar1;
    }

    public void a(ar ar1, long l1, boolean flag)
    {
        kc.a(3, "VerifyPackageLog", (new StringBuilder("Getting nextAdUnit...  current cacheSize: ")).append(k().b()).toString());
        i().d();
        if (k().b() == 0 && !flag)
        {
            kc.a(3, "VerifyPackageLog", "nextAdUnit() cacheSize is empty");
            ar1 = new d();
            ar1.a = this;
            ar1.b = d.a.b;
            ar1.b();
            return;
        } else
        {
            i().a(this, j(), k());
            return;
        }
    }

    protected void a(d d1)
    {
        if (d.a.a.equals(d1.b) || d.a.b.equals(d1.b))
        {
            int i1 = k().b();
            if (i1 == 0)
            {
                kc.a(3, a, (new StringBuilder("Starting ad request from EnsureCacheNotEmpty size: ")).append(i1).toString());
                j().a(this, k(), null);
            }
        }
        if (d.a.g.equals(d1.b) && d1.a.equals(this))
        {
            u();
        }
    }

    public void a(e e1)
    {
        o = e1;
    }

    public void a(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return;
        } else
        {
            i().b();
            k().a(s1);
            return;
        }
    }

    protected void b()
    {
        ab ab1 = com.flurry.sdk.i.a().l();
        if (ab1 != null)
        {
            ab1.a(this);
        }
    }

    public void c()
    {
        z();
    }

    public void d()
    {
        E();
        y();
    }

    public int e()
    {
        return b;
    }

    public Context f()
    {
        return (Context)c.get();
    }

    protected void finalize()
    {
        super.finalize();
        a();
    }

    public ViewGroup g()
    {
        return (ViewGroup)d.get();
    }

    public String h()
    {
        return e;
    }

    public dn i()
    {
        return f;
    }

    public do j()
    {
        return com.flurry.sdk.i.a().c().a(h(), null, m()).a();
    }

    public y k()
    {
        return com.flurry.sdk.i.a().c().a(h(), null, m()).b();
    }

    public ar l()
    {
        return n;
    }

    public e m()
    {
        return o;
    }

    public void n()
    {
        f.c();
    }

    protected ar o()
    {
        return m;
    }

    protected void p()
    {
        lp.b();
        if (!m.o() && m.n())
        {
            kc.a(3, a, "Precaching optional for ad, copying assets before display");
            com.flurry.sdk.i.a().l().a(this, m);
        }
    }

    protected void q()
    {
        n = m;
        m = null;
    }

    protected long r()
    {
        return i;
    }

    protected void s()
    {
    }

    protected void t()
    {
        if (TextUtils.isEmpty(jb.a().c()))
        {
            kc.a(3, a, (new StringBuilder("Session Id not created yet. Delaying the fetch until session is created.")).append(this).toString());
            h = true;
            return;
        } else
        {
            kc.a(3, a, (new StringBuilder("Fetching ad now for ")).append(this).toString());
            i().a(this, j(), k());
            return;
        }
    }

    protected void u()
    {
        g = true;
        l().g(ay.v.a());
    }

    protected void v()
    {
        if (h)
        {
            kc.a(3, a, (new StringBuilder("Session created. Fetching ad now for ")).append(this).toString());
            i().a(this, j(), k());
            h = false;
        }
    }

    protected void w()
    {
        g = false;
        h = false;
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
