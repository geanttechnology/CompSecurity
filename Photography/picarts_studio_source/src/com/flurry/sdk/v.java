// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdType;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            s, t, i, fa, 
//            dn, w, lk, jy, 
//            kc, lp, j, az, 
//            ar, ax, ez, ji, 
//            ay, ex, cl, cn, 
//            cz, jo, gu, hd, 
//            hc, ln, d, y, 
//            do, jb, ab, z, 
//            gq, jx, e

public class v
    implements s, t
{

    private static final String a = com/flurry/sdk/v.getSimpleName();
    private final int b;
    private final WeakReference c;
    private final WeakReference d;
    private final String e;
    private a f;
    private final dn g;
    private ar h;
    private ar i;
    private boolean j;
    private boolean k;
    private long l;
    private final jx m = new _cls1();
    private final jx n = new _cls2();
    private final jx o = new _cls3();
    private WeakReference p;
    private boolean q;
    private long r;
    private long s;

    public v(Context context, ViewGroup viewgroup, String s1)
    {
        j = false;
        k = false;
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
            f = a.a;
            g = new dn(s1);
            p = new WeakReference(null);
            i1.e().a(context, s1, this);
            z();
            B();
            D();
            return;
        }
    }

    private void A()
    {
        lk.a().b(m);
    }

    private void B()
    {
        jy.a().a("com.flurry.android.impl.ads.AdStateEvent", o);
    }

    private void C()
    {
        jy.a().a(o);
    }

    private void D()
    {
        jy.a().a("com.flurry.android.sdk.FlurrySessionEvent", n);
    }

    private void E()
    {
        jy.a().a(n);
    }

    private void F()
    {
        if (r > 0L)
        {
            s = s - (System.currentTimeMillis() - l);
            if (s <= 0L)
            {
                if (J())
                {
                    kc.a(3, a, (new StringBuilder("Rotating banner for adSpace: ")).append(h()).toString());
                    i().a(this, b(), j());
                }
                s = r;
            }
        }
    }

    private void G()
    {
        i = h;
        h = null;
    }

    private void H()
    {
        lp.b();
        this;
        JVM INSTR monitorenter ;
        if (a.b.equals(f) || a.d.equals(f))
        {
            break MISSING_BLOCK_LABEL_34;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (!a.b.equals(f) || h == null) goto _L2; else goto _L1
_L1:
        FlurryAdListener flurryadlistener;
        flurryadlistener = com.flurry.sdk.j.a().b();
        kc.a(3, a, (new StringBuilder("Firing shouldDisplayAd, listener=")).append(flurryadlistener).toString());
        if (flurryadlistener == null) goto _L2; else goto _L3
_L3:
        String s1 = e;
        if (!az.a.equals(h.d())) goto _L5; else goto _L4
_L4:
        Object obj = FlurryAdType.WEB_BANNER;
_L7:
        boolean flag = flurryadlistener.shouldDisplayAd(s1, ((FlurryAdType) (obj)));
_L8:
        if (flag) goto _L2; else goto _L6
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L5:
        obj = FlurryAdType.WEB_TAKEOVER;
          goto _L7
        Throwable throwable;
        throwable;
        kc.a(6, a, "AdListener.shouldDisplayAd", throwable);
        flag = false;
          goto _L8
_L2:
        f = a.c;
        this;
        JVM INSTR monitorexit ;
        kc.a(3, a, (new StringBuilder("render banner (")).append(this).append(")").toString());
        Object obj1 = f();
        Object obj2 = g();
        if (obj1 == null || !(obj1 instanceof Activity))
        {
            ez.b(this, ax.d);
            return;
        }
        if (obj2 == null)
        {
            ez.b(this, ax.t);
            return;
        }
        obj2 = h;
        if (obj2 == null)
        {
            ez.b(this, ax.c);
            return;
        }
        if (((ar) (obj2)).w())
        {
            ez.b(this, ax.x);
            return;
        }
        if (!ji.a().c())
        {
            kc.a(5, a, "There is no network connectivity (ad will not display)");
            HashMap hashmap = new HashMap();
            hashmap.put("errorCode", Integer.toString(ax.b.a()));
            ex.a(ay.g, hashmap, ((Context) (obj1)), this, ((ar) (obj2)), 1);
            return;
        }
        obj1 = ((ar) (obj2)).a();
        if (obj1 == null)
        {
            ez.b(this, ax.e);
            return;
        }
        if (((cl) (obj1)).f == 1)
        {
            ez.b(this, ax.e);
            return;
        }
        if (!cn.a.equals(((cl) (obj1)).a))
        {
            ez.b(this, ax.v);
            return;
        }
        if (!az.a.equals(((ar) (obj2)).d()) && !az.b.equals(((ar) (obj2)).d()))
        {
            ez.a(this, ax.v);
            return;
        }
        if (!fa.b().equals(((cl) (obj1)).v))
        {
            ez.b(this, ax.s);
            return;
        }
        t();
        jo.a().a(new _cls8());
        return;
          goto _L7
    }

    private void I()
    {
        lp.a();
        a(0L);
        G();
        if (!az.a.equals(i.d())) goto _L2; else goto _L1
_L1:
        gu.a(f(), this);
_L4:
        ez.b(this);
        return;
_L2:
        hc hc1 = com.flurry.sdk.i.a().q().a(f(), this);
        if (hc1 != null)
        {
            hc1.a();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean J()
    {
        if (ln.a())
        {
            kc.a(3, a, (new StringBuilder("Device is locked: banner will NOT rotate for adSpace: ")).append(h()).toString());
            return false;
        }
        if (p.get() == null)
        {
            kc.a(3, a, (new StringBuilder("No banner holder: banner will NOT rotate for adSpace: ")).append(h()).toString());
            return false;
        } else
        {
            return true;
        }
    }

    private void K()
    {
        if (j && l().e(ay.v.a()))
        {
            ex.a(ay.v, Collections.emptyMap(), f(), this, l(), 0);
            l().f(ay.v.a());
        }
    }

    private void L()
    {
        j = true;
        l().g(ay.v.a());
    }

    static long a(v v1, long l1)
    {
        v1.l = l1;
        return l1;
    }

    private void a(long l1)
    {
        kc.a(3, a, (new StringBuilder("Scheduled banner rotation for adSpace: ")).append(h()).toString());
        r = l1;
        s = l1;
    }

    private void a(d d1)
    {
        if (d.a.c.equals(d1.b) || d.a.b.equals(d1.b))
        {
            int i1 = j().b();
            if (i1 == 0)
            {
                kc.a(3, a, (new StringBuilder("Starting ad request from EnsureCacheNotEmpty size: ")).append(i1).toString());
                b().a(this, j(), null);
            }
        }
        if (!d.a.a.equals(d1.b)) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(f)) goto _L4; else goto _L3
_L3:
        f = a.b;
_L6:
        this;
        JVM INSTR monitorexit ;
        if (q || a.d.equals(f))
        {
            jo.a().b(new _cls7());
        }
_L2:
        if (d.a.g.equals(d1.b))
        {
            L();
        }
        return;
_L4:
        if (!a.c.equals(f)) goto _L6; else goto _L5
_L5:
        f = a.d;
          goto _L6
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
    }

    static void a(v v1)
    {
        v1.F();
    }

    static void a(v v1, d d1)
    {
        v1.a(d1);
    }

    private void a(boolean flag)
    {
        if (TextUtils.isEmpty(jb.a().c()))
        {
            kc.a(3, a, (new StringBuilder("Session Id not created yet. Delaying the fetch until session is created.")).append(this).toString());
            k = true;
            return;
        }
        i().d();
        if (j().b() == 0 && !flag)
        {
            kc.a(3, "VerifyPackageLog", "nextAdUnit() cacheSize is empty");
            d d1 = new d();
            d1.a = this;
            d1.b = d.a.b;
            d1.b();
            return;
        } else
        {
            kc.a(3, a, (new StringBuilder("Fetching ad now for ")).append(this).toString());
            i().a(this, b(), j());
            return;
        }
    }

    static void b(v v1)
    {
        v1.L();
    }

    static void c(v v1)
    {
        v1.H();
    }

    static void d(v v1)
    {
        v1.I();
    }

    private void w()
    {
        if (TextUtils.isEmpty(jb.a().c()))
        {
            kc.a(3, a, (new StringBuilder("Session Id not created yet. Delaying the fetch until session is created.")).append(this).toString());
            k = true;
            return;
        } else
        {
            kc.a(3, a, (new StringBuilder("Fetching ad now for ")).append(this).toString());
            i().a(this, b(), j());
            return;
        }
    }

    private void z()
    {
        l = System.currentTimeMillis();
        lk.a().a(m);
    }

    public void a()
    {
        A();
        C();
        E();
        j = false;
        k = false;
        com.flurry.sdk.i.a().e().a(h(), this);
        ab ab1 = com.flurry.sdk.i.a().l();
        if (ab1 != null)
        {
            ab1.a(this);
        }
        jo.a().a(new _cls4());
        if (g != null)
        {
            g.a();
        }
    }

    public void a(RelativeLayout relativelayout)
    {
        p = new WeakReference(relativelayout);
    }

    public void a(ar ar1)
    {
        h = ar1;
    }

    public void a(ar ar1, long l1, boolean flag)
    {
        if (ar1.d().equals(az.a))
        {
            boolean flag1;
            if (y() != null && y().getChildCount() > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                a(l1);
                return;
            } else
            {
                w();
                return;
            }
        } else
        {
            a(flag);
            return;
        }
    }

    public void a(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return;
        } else
        {
            i().b();
            j().a(s1);
            return;
        }
    }

    public do b()
    {
        return com.flurry.sdk.i.a().c().a(h(), fa.b(), m()).a();
    }

    public void c()
    {
        A();
    }

    public void d()
    {
        z();
        s = r;
        K();
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
        return g;
    }

    public y j()
    {
        return com.flurry.sdk.i.a().c().a(h(), fa.b(), m()).b();
    }

    public boolean k()
    {
        return l().d().equals(az.a);
    }

    public ar l()
    {
        return i;
    }

    public e m()
    {
        return com.flurry.sdk.j.a().d();
    }

    public void n()
    {
        g.c();
    }

    public void o()
    {
        RelativeLayout relativelayout = (RelativeLayout)p.get();
        if (relativelayout != null)
        {
            do
            {
                if (relativelayout.getChildCount() <= 0)
                {
                    break;
                }
                android.view.View view = relativelayout.getChildAt(0);
                relativelayout.removeView(view);
                if (view instanceof gq)
                {
                    ((gq)view).onActivityDestroy();
                }
            } while (true);
            ViewGroup viewgroup = g();
            if (viewgroup != null)
            {
                viewgroup.removeView(relativelayout);
                viewgroup.setBackgroundColor(0);
            }
        }
        p.clear();
    }

    public boolean p()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.b.equals(f);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void q()
    {
        q = false;
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(f)) goto _L2; else goto _L1
_L1:
        i().a(this, b(), j());
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!a.b.equals(f)) goto _L4; else goto _L3
_L3:
        ez.a(this);
          goto _L5
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        if (!a.c.equals(f) && !a.d.equals(f)) goto _L5; else goto _L6
_L6:
        f = a.a;
        i().a(this, b(), j());
          goto _L5
    }

    public void r()
    {
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(f) && !a.d.equals(f)) goto _L2; else goto _L1
_L1:
        ez.b(this, ax.r);
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!a.b.equals(f)) goto _L4; else goto _L3
_L3:
        jo.a().b(new _cls5());
          goto _L5
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        if (!a.c.equals(f)) goto _L5; else goto _L6
_L6:
        ez.b(this);
          goto _L5
    }

    public boolean s()
    {
        boolean flag = true;
        q = true;
        this;
        JVM INSTR monitorenter ;
        if (a.a.equals(f)) goto _L2; else goto _L1
_L1:
        if (!a.b.equals(f)) goto _L4; else goto _L3
_L3:
        jo.a().b(new _cls6());
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        if (!a.c.equals(f) && !a.d.equals(f))
        {
            break MISSING_BLOCK_LABEL_103;
        }
_L2:
        i().a(this, b(), j());
        break MISSING_BLOCK_LABEL_103;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        flag = false;
          goto _L5
    }

    protected void t()
    {
        lp.b();
        if (!h.o() && h.n())
        {
            kc.a(3, a, "Precaching optional for ad, copying assets before display");
            com.flurry.sdk.i.a().l().a(this, h);
        }
    }

    protected void u()
    {
        if (k)
        {
            i().a(this, b(), j());
            k = false;
        }
    }

    protected void v()
    {
        j = false;
        k = false;
    }

    public boolean x()
    {
        if (a.a.equals(f))
        {
            return false;
        } else
        {
            return l().w();
        }
    }

    public RelativeLayout y()
    {
        return (RelativeLayout)p.get();
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class a {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}

}
