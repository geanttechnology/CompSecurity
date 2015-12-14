// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            p, t, lp, kc, 
//            ax, ez, ar, ji, 
//            ay, ex, cn, cl, 
//            az, fa, cz, jo, 
//            gu, ln, dn, d, 
//            y, do, i, z, 
//            gq

public class r extends p
    implements t
{

    private static final String a = com/flurry/sdk/r.getSimpleName();
    private a b;
    private WeakReference c;
    private boolean d;
    private long e;
    private long f;

    public r(Context context, ViewGroup viewgroup, String s1)
    {
        super(context, viewgroup, s1);
        b = a.a;
        c = new WeakReference(null);
    }

    private void E()
    {
        lp.b();
        this;
        JVM INSTR monitorenter ;
        if (a.b.equals(b) || a.d.equals(b))
        {
            break MISSING_BLOCK_LABEL_34;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        b = a.c;
        this;
        JVM INSTR monitorexit ;
        Object obj;
        Object obj1;
        kc.a(3, a, (new StringBuilder("render banner (")).append(this).append(")").toString());
        obj = f();
        obj1 = g();
        if (obj == null || !(obj instanceof Activity))
        {
            ez.b(this, ax.d);
            return;
        }
        break MISSING_BLOCK_LABEL_105;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (obj1 == null)
        {
            ez.b(this, ax.t);
            return;
        }
        obj1 = o();
        if (obj1 == null)
        {
            ez.b(this, ax.c);
            return;
        }
        if (((ar) (obj1)).w())
        {
            ez.b(this, ax.x);
            return;
        }
        if (!ji.a().c())
        {
            kc.a(5, a, "There is no network connectivity (ad will not display)");
            HashMap hashmap = new HashMap();
            hashmap.put("errorCode", Integer.toString(ax.b.a()));
            ex.a(ay.g, hashmap, ((Context) (obj)), this, ((ar) (obj1)), 1);
            return;
        }
        obj = ((ar) (obj1)).a();
        if (obj == null)
        {
            ez.b(this, ax.e);
            return;
        }
        if (!cn.b.equals(((cl) (obj)).a))
        {
            ez.a(this, ax.v);
            return;
        }
        if (!az.a.equals(((ar) (obj1)).d()))
        {
            ez.a(this, ax.v);
            return;
        }
        if (!fa.b().equals(((cl) (obj)).v))
        {
            ez.b(this, ax.s);
            return;
        } else
        {
            p();
            jo.a().a(new _cls5());
            return;
        }
    }

    private void F()
    {
        lp.a();
        a(0L);
        q();
        gu.a(f(), this);
        kc.a(a, (new StringBuilder("BannerAdObject rendered: ")).append(this).toString());
        ez.b(this);
    }

    private boolean G()
    {
        if (ln.a())
        {
            kc.a(3, a, (new StringBuilder("Device is locked: banner will NOT rotate for adSpace: ")).append(h()).toString());
            return false;
        }
        if (c.get() == null)
        {
            kc.a(3, a, (new StringBuilder("No banner holder: banner will NOT rotate for adSpace: ")).append(h()).toString());
            return false;
        } else
        {
            return true;
        }
    }

    private void a(long l)
    {
        kc.a(3, a, (new StringBuilder("Scheduled banner rotation for adSpace: ")).append(h()).toString());
        e = l;
        f = l;
    }

    static void a(r r1)
    {
        r1.E();
    }

    static void b(r r1)
    {
        r1.F();
    }

    public boolean A()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.b.equals(b);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void B()
    {
        d = false;
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(b)) goto _L2; else goto _L1
_L1:
        t();
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!a.b.equals(b)) goto _L4; else goto _L3
_L3:
        kc.a(a, (new StringBuilder("BannerAdObject fetched: ")).append(this).toString());
        ez.a(this);
          goto _L5
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        if (!a.c.equals(b) && !a.d.equals(b)) goto _L5; else goto _L6
_L6:
        ez.b(this);
          goto _L5
    }

    public void C()
    {
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(b)) goto _L2; else goto _L1
_L1:
        ez.b(this, ax.r);
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!a.b.equals(b)) goto _L4; else goto _L3
_L3:
        jo.a().b(new _cls3());
          goto _L5
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        if (!a.c.equals(b) && !a.d.equals(b)) goto _L5; else goto _L6
_L6:
        ez.b(this);
          goto _L5
    }

    public void D()
    {
        d = true;
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(b)) goto _L2; else goto _L1
_L1:
        t();
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!a.b.equals(b)) goto _L4; else goto _L3
_L3:
        jo.a().b(new _cls4());
          goto _L5
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        if (!a.c.equals(b) && !a.d.equals(b)) goto _L5; else goto _L6
_L6:
        ez.b(this);
          goto _L5
    }

    public void a()
    {
        jo.a().a(new _cls1());
        super.a();
    }

    public void a(RelativeLayout relativelayout)
    {
        c = new WeakReference(relativelayout);
    }

    public void a(ar ar1, long l, boolean flag)
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
            a(l);
            return;
        } else
        {
            i().a(this, j(), k());
            return;
        }
    }

    protected void a(d d1)
    {
        if (d.a.c.equals(d1.b) || d.a.b.equals(d1.b))
        {
            int l = k().b();
            if (l == 0)
            {
                kc.a(3, a, (new StringBuilder("Starting ad request from EnsureCacheNotEmpty size: ")).append(l).toString());
                j().a(this, k(), null);
            }
        }
        if (!d.a.a.equals(d1.b)) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(b)) goto _L4; else goto _L3
_L3:
        b = a.b;
_L6:
        this;
        JVM INSTR monitorexit ;
        if (d || a.d.equals(b))
        {
            jo.a().b(new _cls2());
        }
_L2:
        if (d.a.g.equals(d1.b) && d1.a.equals(this))
        {
            u();
        }
        return;
_L4:
        if (!a.c.equals(b)) goto _L6; else goto _L5
_L5:
        b = a.d;
          goto _L6
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
    }

    public void c()
    {
        super.c();
    }

    public void d()
    {
        super.d();
        f = e;
    }

    public do j()
    {
        return i.a().c().a(h(), fa.b(), m()).a();
    }

    public y k()
    {
        return i.a().c().a(h(), fa.b(), m()).b();
    }

    protected void s()
    {
        super.s();
        if (e > 0L)
        {
            f = f - (System.currentTimeMillis() - r());
            if (f <= 0L)
            {
                if (G())
                {
                    kc.a(3, a, (new StringBuilder("Rotating banner for adSpace: ")).append(h()).toString());
                    i().a(this, j(), k());
                }
                f = e;
            }
        }
    }

    public boolean x()
    {
        if (a.a.equals(b))
        {
            return false;
        } else
        {
            return l().w();
        }
    }

    public RelativeLayout y()
    {
        return (RelativeLayout)c.get();
    }

    public void z()
    {
        lp.a();
        RelativeLayout relativelayout = (RelativeLayout)c.get();
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
        c.clear();
    }


    /* member class not found */
    class a {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
