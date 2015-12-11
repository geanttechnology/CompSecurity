// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdType;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import com.flurry.android.impl.ads.protocol.v13.AdViewType;
import com.flurry.android.impl.ads.protocol.v13.ScreenOrientationType;
import java.lang.ref.WeakReference;

// Referenced classes of package com.flurry.sdk:
//            r, s, i, cr, 
//            ch, v, hp, j, 
//            gd, ax, ap, fj, 
//            av, cq, fp, eg, 
//            eo, en, hn, d, 
//            x, ci, hk, fz, 
//            aa, y, ec, fy, 
//            e, hj, fx, hq

public class u
    implements r, s
{

    private static final String a = com/flurry/sdk/u.getSimpleName();
    private final int b;
    private final WeakReference c;
    private final WeakReference d;
    private final String e;
    private a f;
    private final ch g;
    private ap h;
    private ap i;
    private long j;
    private final fy k = new fy() {

        final u a;

        public void a(hj hj1)
        {
            u.a(a);
            u.a(a, System.currentTimeMillis());
        }

        public void notify(fx fx)
        {
            a((hj)fx);
        }

            
            {
                a = u.this;
                super();
            }
    };
    private final fy l = new fy() {

        final u a;

        public void a(d d1)
        {
            if (d1.a == a && d1.b != null)
            {
                u.a(a, d1);
                FlurryAdListener flurryadlistener = com.flurry.sdk.j.a().b();
                if (flurryadlistener != null)
                {
                    String s2 = d1.a.g();
                    fp.a().a(new hq(this, d1, flurryadlistener, s2) {

                        final d a;
                        final FlurryAdListener b;
                        final String c;
                        final _cls2 d;

                        public void safeRun()
                        {
                            class _cls8
                            {

                                static final int a[];

                                static 
                                {
                                    a = new int[com.flurry.sdk.d.a.values().length];
                                    try
                                    {
                                        a[d.a.a.ordinal()] = 1;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror8) { }
                                    try
                                    {
                                        a[d.a.b.ordinal()] = 2;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror7) { }
                                    try
                                    {
                                        a[d.a.c.ordinal()] = 3;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror6) { }
                                    try
                                    {
                                        a[d.a.d.ordinal()] = 4;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror5) { }
                                    try
                                    {
                                        a[d.a.g.ordinal()] = 5;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror4) { }
                                    try
                                    {
                                        a[d.a.h.ordinal()] = 6;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror3) { }
                                    try
                                    {
                                        a[d.a.k.ordinal()] = 7;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror2) { }
                                    try
                                    {
                                        a[d.a.e.ordinal()] = 8;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror1) { }
                                    try
                                    {
                                        a[d.a.f.ordinal()] = 9;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror)
                                    {
                                        return;
                                    }
                                }
                            }

                            switch (_cls8.a[a.b.ordinal()])
                            {
                            default:
                                return;

                            case 1: // '\001'
                                b.spaceDidReceiveAd(c);
                                return;

                            case 2: // '\002'
                                b.spaceDidFailToReceiveAd(c);
                                return;

                            case 3: // '\003'
                                b.onRendered(c);
                                return;

                            case 4: // '\004'
                                b.onRenderFailed(c);
                                return;

                            case 5: // '\005'
                                b.onApplicationExit(c);
                                return;

                            case 6: // '\006'
                                b.onAdClicked(c);
                                return;

                            case 7: // '\007'
                                b.onVideoCompleted(c);
                                return;

                            case 8: // '\b'
                                b.onAdOpened(c);
                                return;

                            case 9: // '\t'
                                b.onAdClosed(c);
                                break;
                            }
                        }

            
            {
                d = _pcls2;
                a = d1;
                b = flurryadlistener;
                c = s1;
                super();
            }
                    });
                    return;
                }
            }
        }

        public void notify(fx fx)
        {
            a((d)fx);
        }

            
            {
                a = u.this;
                super();
            }
    };
    private WeakReference m;
    private boolean n;
    private long o;
    private long p;

    public u(Context context, ViewGroup viewgroup, String s1)
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
            f = a.a;
            g = new ch(s1);
            m = new WeakReference(null);
            i1.e().a(context, s1, this);
            u();
            w();
            return;
        }
    }

    private void A()
    {
        hp.b();
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
        gd.a(3, a, (new StringBuilder()).append("Firing shouldDisplayAd, listener=").append(flurryadlistener).toString());
        if (flurryadlistener == null) goto _L2; else goto _L3
_L3:
        String s1 = e;
        if (!ax.a.equals(h.d())) goto _L5; else goto _L4
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
        gd.a(6, a, "AdListener.shouldDisplayAd", throwable);
        flag = false;
          goto _L8
_L2:
        f = a.c;
        this;
        JVM INSTR monitorexit ;
        gd.a(3, a, (new StringBuilder()).append("render banner (").append(this).append(")").toString());
        Object obj1 = e();
        Object obj2 = f();
        if (!fj.a().c())
        {
            gd.a(5, a, "There is no network connectivity (ad will not display)");
            cq.b(this, av.c);
            return;
        }
        if (obj1 == null)
        {
            cq.b(this, av.e);
            return;
        }
        if (obj2 == null)
        {
            cq.b(this, av.u);
            return;
        }
        obj1 = h;
        if (obj1 == null)
        {
            cq.b(this, av.d);
            return;
        }
        obj2 = ((ap) (obj1)).a();
        if (obj2 == null)
        {
            cq.b(this, av.f);
            return;
        }
        if (((AdUnit) (obj2)).combinable == 1)
        {
            cq.b(this, av.f);
            return;
        }
        if (!AdViewType.LEGACY.equals(((AdUnit) (obj2)).adViewType))
        {
            cq.b(this, av.w);
            return;
        }
        if (!ax.a.equals(((ap) (obj1)).d()) && !ax.b.equals(((ap) (obj1)).d()))
        {
            cq.a(this, av.w);
            return;
        }
        if (!cr.b().equals(((AdUnit) (obj2)).screenOrientation))
        {
            cq.b(this, av.t);
            return;
        }
        t();
        fp.a().a(new hq() {

            final u a;

            public void safeRun()
            {
                u.c(a);
            }

            
            {
                a = u.this;
                super();
            }
        });
        return;
          goto _L7
    }

    private void B()
    {
        hp.a();
        a(0L);
        z();
        if (!ax.a.equals(i.d())) goto _L2; else goto _L1
_L1:
        eg.a(e(), this);
_L4:
        cq.b(this);
        return;
_L2:
        en en1 = com.flurry.sdk.i.a().q().a(e(), this);
        if (en1 != null)
        {
            en1.a();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean C()
    {
        if (hn.a())
        {
            gd.a(3, a, (new StringBuilder()).append("Device is locked: banner will NOT rotate for adSpace: ").append(g()).toString());
            return false;
        }
        if (m.get() == null)
        {
            gd.a(3, a, (new StringBuilder()).append("No banner holder: banner will NOT rotate for adSpace: ").append(g()).toString());
            return false;
        } else
        {
            return true;
        }
    }

    static long a(u u1, long l1)
    {
        u1.j = l1;
        return l1;
    }

    private void a(long l1)
    {
        gd.a(3, a, (new StringBuilder()).append("Scheduled banner rotation for adSpace: ").append(g()).toString());
        o = l1;
        p = l1;
    }

    private void a(d d1)
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
        if (n || a.d.equals(f))
        {
            fp.a().b(new hq() {

                final u a;

                public void safeRun()
                {
                    u.b(a);
                }

            
            {
                a = u.this;
                super();
            }
            });
        }
_L2:
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

    static void a(u u1)
    {
        u1.y();
    }

    static void a(u u1, d d1)
    {
        u1.a(d1);
    }

    static void b(u u1)
    {
        u1.A();
    }

    static void c(u u1)
    {
        u1.B();
    }

    private void u()
    {
        j = System.currentTimeMillis();
        hk.a().a(k);
    }

    private void v()
    {
        hk.a().b(k);
    }

    private void w()
    {
        fz.a().a("com.flurry.android.impl.ads.AdStateEvent", l);
    }

    private void x()
    {
        fz.a().a(l);
    }

    private void y()
    {
        if (o > 0L)
        {
            p = p - (System.currentTimeMillis() - j);
            if (p <= 0L)
            {
                if (C())
                {
                    gd.a(3, a, (new StringBuilder()).append("Rotating banner for adSpace: ").append(g()).toString());
                    h().a(this, i(), j());
                }
                p = o;
            }
        }
    }

    private void z()
    {
        i = h;
        h = null;
    }

    public void a()
    {
        v();
        x();
        com.flurry.sdk.i.a().e().a(g(), this);
        aa aa1 = com.flurry.sdk.i.a().l();
        if (aa1 != null)
        {
            aa1.a(this);
        }
        fp.a().a(new hq() {

            final u a;

            public void safeRun()
            {
                a.n();
            }

            
            {
                a = u.this;
                super();
            }
        });
        if (g != null)
        {
            g.a();
        }
    }

    public void a(RelativeLayout relativelayout)
    {
        m = new WeakReference(relativelayout);
    }

    public void a(ap ap1)
    {
        h = ap1;
    }

    public void a(ap ap1, long l1)
    {
        if (ap1.d().equals(ax.a))
        {
            boolean flag;
            if (s() != null && s().getChildCount() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                a(l1);
                return;
            } else
            {
                h().a(this, i(), j());
                return;
            }
        } else
        {
            h().a(this, i(), j());
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
            h().b();
            j().a(s1);
            return;
        }
    }

    public void b()
    {
        v();
    }

    public void c()
    {
        u();
        p = o;
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
        return g;
    }

    public ci i()
    {
        return com.flurry.sdk.i.a().c().a(g(), cr.b(), l()).a();
    }

    public x j()
    {
        return com.flurry.sdk.i.a().c().a(g(), cr.b(), l()).b();
    }

    public ap k()
    {
        return i;
    }

    public e l()
    {
        return com.flurry.sdk.j.a().d();
    }

    public void m()
    {
        g.c();
    }

    public void n()
    {
        RelativeLayout relativelayout = (RelativeLayout)m.get();
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
                if (view instanceof ec)
                {
                    ((ec)view).onActivityDestroy();
                }
            } while (true);
            ViewGroup viewgroup = f();
            if (viewgroup != null)
            {
                viewgroup.removeView(relativelayout);
                viewgroup.setBackgroundColor(0);
            }
        }
        m.clear();
    }

    public boolean o()
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

    public void p()
    {
        n = false;
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(f)) goto _L2; else goto _L1
_L1:
        h().a(this, i(), j());
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!a.b.equals(f)) goto _L4; else goto _L3
_L3:
        cq.a(this);
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
        h().a(this, i(), j());
          goto _L5
    }

    public void q()
    {
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(f) && !a.d.equals(f)) goto _L2; else goto _L1
_L1:
        cq.b(this, av.s);
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!a.b.equals(f)) goto _L4; else goto _L3
_L3:
        fp.a().b(new hq() {

            final u a;

            public void safeRun()
            {
                u.b(a);
            }

            
            {
                a = u.this;
                super();
            }
        });
          goto _L5
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        if (!a.c.equals(f)) goto _L5; else goto _L6
_L6:
        cq.b(this);
          goto _L5
    }

    public boolean r()
    {
        n = true;
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(f)) goto _L2; else goto _L1
_L1:
        h().a(this, i(), j());
        boolean flag = flag1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (!a.b.equals(f))
        {
            break MISSING_BLOCK_LABEL_76;
        }
        fp.a().b(new hq() {

            final u a;

            public void safeRun()
            {
                u.b(a);
            }

            
            {
                a = u.this;
                super();
            }
        });
        flag = true;
        continue; /* Loop/switch isn't completed */
        if (a.c.equals(f))
        {
            break MISSING_BLOCK_LABEL_104;
        }
        flag = flag1;
        if (!a.d.equals(f))
        {
            continue; /* Loop/switch isn't completed */
        }
        h().a(this, i(), j());
        flag = flag1;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public RelativeLayout s()
    {
        return (RelativeLayout)m.get();
    }

    protected void t()
    {
        hp.b();
        if (!h.o() && h.n())
        {
            gd.a(3, a, "Precaching optional for ad, copying assets before display");
            com.flurry.sdk.i.a().l().a(this, h);
        }
    }


    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/flurry/sdk/u$a, s1);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("INIT", 0);
            b = new a("READY", 1);
            c = new a("DISPLAY", 2);
            d = new a("NEXT", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
