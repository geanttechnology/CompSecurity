// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            c, co, i, ca, 
//            w, r, q, p, 
//            h, ac, x, bd, 
//            ae, cl, d, cn, 
//            v, o, g, ds, 
//            k, da, l

public class cb
    implements c
{
    final class a
        implements g
    {

        final cb a;
        private v b;

        public final void a()
        {
            ds.c(a. new Runnable(b) {

                final v a;
                final cb b;

                public final void run()
                {
                    cb.a(b, a);
                }

            
            {
                b = cb.this;
                a = v;
                super();
            }
            });
        }

        public final void a(k k1)
        {
            if (k.a.b.equals(k1.a))
            {
                cb.c(a);
            }
            ds.c(a. new Runnable(k1) {

                final k a;
                final cb b;

                public final void run()
                {
                    cb cb1 = b;
                    k k1 = a;
                    cb1.e.a(cb1, k1);
                }

            
            {
                b = cb.this;
                a = k1;
                super();
            }
            });
        }

        public final void a(l l1)
        {
        }

        public final void a(v v)
        {
            b = v;
            cb.a(a);
            cb.b(a).a(true, da.b);
            cb.b(a).l();
        }

        public final boolean a(boolean flag)
        {
            return a.e();
        }

        public final void b()
        {
            cb.d(a).b(ck.a.o);
        }

        public final int c()
        {
            cb cb1 = a;
            cb1.a().f.c(ck.a.q);
            com.amazon.device.ads.i.b();
            cb.a.set(false);
            cb1.b = false;
            ds.c(cb1. new Runnable() {

                final cb a;

                public final void run()
                {
                    cb cb1 = a;
                    cb1.e.c(cb1);
                    cb1 = a;
                    if (cb1.a().f != null && !cb1.a().f.b())
                    {
                        cb1.g();
                        cb1.a().c(true);
                    }
                }

            
            {
                a = cb.this;
                super();
            }
            });
            return 1;
        }

        public final void d()
        {
            cb.d(a).a(ck.a.af);
            cb.e(a).set(true);
            cb.c(a);
            ds.c(a. new Runnable() {

                final cb a;

                public final void run()
                {
                    cb cb1 = a;
                    cb1.e.d(cb1);
                }

            
            {
                a = cb.this;
                super();
            }
            });
        }

        a()
        {
            a = cb.this;
            super();
        }
    }


    public static final AtomicBoolean a = new AtomicBoolean(false);
    private static final String i = com/amazon/device/ads/cb.getSimpleName();
    public boolean b;
    public final Activity c;
    public int d;
    p e;
    public final cn f;
    public final r g;
    public final AtomicBoolean h;
    private final q j;
    private final i k;
    private h l;
    private boolean m;
    private final co n;
    private final ca o;
    private final x p;

    public cb(Activity activity)
    {
        this(activity, new co(), new i(), new ca(), w.a(), new r());
    }

    private cb(Activity activity, co co1, i i1, ca ca1, x x1, r r1)
    {
        this(activity, co1, new q(co1), i1, ca1, x1, r1);
    }

    private cb(Activity activity, co co1, q q1, i i1, ca ca1, x x1, r r1)
    {
        b = false;
        d = 20000;
        m = false;
        h = new AtomicBoolean(false);
        if (activity == null)
        {
            throw new IllegalArgumentException("InterstitialAd requires a non-null Activity");
        } else
        {
            c = activity;
            n = co1;
            f = co.a(i);
            j = q1;
            k = i1;
            o = ca1;
            p = x1;
            g = r1;
            return;
        }
    }

    static void a(cb cb1)
    {
        cb1.g();
    }

    static void a(cb cb1, v v)
    {
        cb1.e.a(cb1, v);
    }

    static h b(cb cb1)
    {
        return cb1.a();
    }

    static void b()
    {
        a.set(false);
    }

    static h c(cb cb1)
    {
        cb1.l = null;
        return null;
    }

    static cl d(cb cb1)
    {
        return cb1.a().f;
    }

    static AtomicBoolean e(cb cb1)
    {
        return cb1.h;
    }

    private void h()
    {
        h h1 = com.amazon.device.ads.i.a(c, ac.i);
        l = h1;
        h1.s = new a();
    }

    public final h a()
    {
        if (!m)
        {
            m = true;
            p.a(c.getApplicationContext());
            if (e == null)
            {
                a(((o) (null)));
            }
            h();
            g();
        }
        if (l == null)
        {
            h();
        }
        return l;
    }

    public final void a(o o1)
    {
        Object obj = o1;
        if (o1 == null)
        {
            obj = new bd(i);
        }
        e = j.a(((o) (obj)));
    }

    public final boolean c()
    {
        return a().x.equals(ae.b) || a().x.equals(ae.c) || a().x.equals(ae.d);
    }

    public final boolean d()
    {
        return a().x.equals(ae.g);
    }

    public final boolean e()
    {
        return a().x.equals(ae.a);
    }

    public final boolean f()
    {
        boolean flag;
        if (b && !a.get())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a().f.a(ck.a.aa);
            a().j.a();
        }
        return flag;
    }

    final void g()
    {
        a().f.b = v.a.d.f;
        a().f.a(ck.a.Z);
    }

    public void setTimeout(int i1)
    {
        d = i1;
    }


    // Unreferenced inner class com/amazon/device/ads/cb$5

/* anonymous class */
    public static final class _cls5
    {

        public static final int a[];

        static 
        {
            a = new int[ae.values().length];
            try
            {
                a[ae.e.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                a[ae.g.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[ae.j.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[ae.k.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
