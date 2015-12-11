// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;

// Referenced classes of package com.tapjoy.internal:
//            ds, gt, do, du, 
//            dq, dp, dz, dm, 
//            dr

public static final class <init> extends ds
    implements <init>
{
    public static final class a extends ds.a
        implements gt.m
    {

        private int b;
        private Object c;
        private Object d;
        private Object e;
        private Object f;
        private Object g;
        private Object h;
        private int i;
        private int j;
        private int k;
        private Object l;
        private Object m;
        private Object n;
        private Object o;
        private Object p;
        private Object q;
        private Object r;
        private Object s;

        static a f()
        {
            return new a();
        }

        private a g()
        {
            return (new a()).a(e());
        }

        public final dl.a a()
        {
            return g();
        }

        public final a a(int i1)
        {
            b = b | 0x40;
            i = i1;
            return this;
        }

        public final a a(gt.l l1)
        {
            if (l1 == gt.l.c())
            {
                return this;
            }
            if (l1.e())
            {
                b = b | 1;
                c = gt.l.b(l1);
            }
            if (l1.g())
            {
                b = b | 2;
                d = gt.l.c(l1);
            }
            if (l1.i())
            {
                b = b | 4;
                e = gt.l.d(l1);
            }
            if (l1.k())
            {
                b = b | 8;
                f = gt.l.e(l1);
            }
            if (l1.m())
            {
                b = b | 0x10;
                g = gt.l.f(l1);
            }
            if (l1.o())
            {
                b = b | 0x20;
                h = gt.l.g(l1);
            }
            if (l1.q())
            {
                a(l1.r());
            }
            if (l1.s())
            {
                b(l1.t());
            }
            if (l1.u())
            {
                c(l1.v());
            }
            if (l1.w())
            {
                b = b | 0x200;
                l = gt.l.h(l1);
            }
            if (l1.y())
            {
                b = b | 0x400;
                m = gt.l.i(l1);
            }
            if (l1.A())
            {
                b = b | 0x800;
                n = gt.l.j(l1);
            }
            if (l1.C())
            {
                b = b | 0x1000;
                o = gt.l.k(l1);
            }
            if (l1.E())
            {
                b = b | 0x2000;
                p = gt.l.l(l1);
            }
            if (l1.G())
            {
                b = b | 0x4000;
                q = gt.l.m(l1);
            }
            if (l1.I())
            {
                b = b | 0x8000;
                r = gt.l.n(l1);
            }
            if (l1.K())
            {
                b = b | 0x10000;
                s = gt.l.o(l1);
            }
            super.a = super.a.a(gt.l.p(l1));
            return this;
        }

        public final a a(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 1;
                c = s1;
                return this;
            }
        }

        public final ds.a b()
        {
            return g();
        }

        public final a b(int i1)
        {
            b = b | 0x80;
            j = i1;
            return this;
        }

        public final a b(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 2;
                d = s1;
                return this;
            }
        }

        public final a c(int i1)
        {
            b = b | 0x100;
            k = i1;
            return this;
        }

        public final a c(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 4;
                e = s1;
                return this;
            }
        }

        public final Object clone()
        {
            return g();
        }

        public final a d(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 8;
                f = s1;
                return this;
            }
        }

        public final boolean d()
        {
            return true;
        }

        public final a e(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x10;
                g = s1;
                return this;
            }
        }

        public final gt.l e()
        {
            int j1 = 1;
            gt.l l1 = new gt.l(this, (byte)0);
            int k1 = b;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            gt.l.a(l1, c);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            gt.l.b(l1, d);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            gt.l.c(l1, e);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            gt.l.d(l1, f);
            j1 = i1;
            if ((k1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            gt.l.e(l1, g);
            i1 = j1;
            if ((k1 & 0x20) == 32)
            {
                i1 = j1 | 0x20;
            }
            gt.l.f(l1, h);
            j1 = i1;
            if ((k1 & 0x40) == 64)
            {
                j1 = i1 | 0x40;
            }
            gt.l.a(l1, i);
            i1 = j1;
            if ((k1 & 0x80) == 128)
            {
                i1 = j1 | 0x80;
            }
            gt.l.b(l1, j);
            j1 = i1;
            if ((k1 & 0x100) == 256)
            {
                j1 = i1 | 0x100;
            }
            gt.l.c(l1, k);
            i1 = j1;
            if ((k1 & 0x200) == 512)
            {
                i1 = j1 | 0x200;
            }
            gt.l.g(l1, l);
            j1 = i1;
            if ((k1 & 0x400) == 1024)
            {
                j1 = i1 | 0x400;
            }
            gt.l.h(l1, m);
            i1 = j1;
            if ((k1 & 0x800) == 2048)
            {
                i1 = j1 | 0x800;
            }
            gt.l.i(l1, n);
            j1 = i1;
            if ((k1 & 0x1000) == 4096)
            {
                j1 = i1 | 0x1000;
            }
            gt.l.j(l1, o);
            i1 = j1;
            if ((k1 & 0x2000) == 8192)
            {
                i1 = j1 | 0x2000;
            }
            gt.l.k(l1, p);
            j1 = i1;
            if ((k1 & 0x4000) == 16384)
            {
                j1 = i1 | 0x4000;
            }
            gt.l.l(l1, q);
            i1 = j1;
            if ((k1 & 0x8000) == 32768)
            {
                i1 = j1 | 0x8000;
            }
            gt.l.m(l1, r);
            j1 = i1;
            if ((k1 & 0x10000) == 0x10000)
            {
                j1 = i1 | 0x10000;
            }
            gt.l.n(l1, s);
            gt.l.d(l1, j1);
            return l1;
        }

        public final a f(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x20;
                h = s1;
                return this;
            }
        }

        public final a g(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x200;
                l = s1;
                return this;
            }
        }

        public final a h(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x400;
                m = s1;
                return this;
            }
        }

        public final a i(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x800;
                n = s1;
                return this;
            }
        }

        public final a j(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x1000;
                o = s1;
                return this;
            }
        }

        public final a k(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x2000;
                p = s1;
                return this;
            }
        }

        public final a l(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x4000;
                q = s1;
                return this;
            }
        }

        public final a m(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x8000;
                r = s1;
                return this;
            }
        }

        public final a n(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x10000;
                s = s1;
                return this;
            }
        }

        private a()
        {
            c = "";
            d = "";
            e = "";
            f = "";
            g = "";
            h = "";
            l = "";
            m = "";
            n = "";
            o = "";
            p = "";
            q = "";
            r = "";
            s = "";
        }
    }


    public static dz b = new dm() {

        public final Object a(dp dp1, dr dr)
        {
            return new gt.l(dp1, (byte)0);
        }

    };
    private static final <init> c;
    private final do d;
    private int e;
    private Object f;
    private Object g;
    private Object h;
    private Object i;
    private Object j;
    private Object k;
    private int l;
    private int m;
    private int n;
    private Object o;
    private Object p;
    private Object q;
    private Object r;
    private Object s;
    private Object t;
    private Object u;
    private Object v;
    private byte w;
    private int x;

    public static a M()
    {
        return a.f();
    }

    private do O()
    {
        Object obj = f;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            f = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do P()
    {
        Object obj = g;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            g = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do Q()
    {
        Object obj = h;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            h = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do R()
    {
        Object obj = i;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            i = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do S()
    {
        Object obj = j;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            j = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do T()
    {
        Object obj = k;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            k = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do U()
    {
        Object obj = o;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            o = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do V()
    {
        Object obj = p;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            p = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do W()
    {
        Object obj = q;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            q = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do X()
    {
        Object obj = r;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            r = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do Y()
    {
        Object obj = s;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            s = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do Z()
    {
        Object obj = t;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            t = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    static int a(t t1, int i1)
    {
        t1.l = i1;
        return i1;
    }

    public static a a(l l1)
    {
        return a.f().a(l1);
    }

    static Object a(a.a a1, Object obj)
    {
        a1.f = obj;
        return obj;
    }

    private do aa()
    {
        Object obj = u;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            u = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do ab()
    {
        Object obj = v;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            v = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private void ac()
    {
        f = "";
        g = "";
        h = "";
        i = "";
        j = "";
        k = "";
        l = 0;
        m = 0;
        n = 0;
        o = "";
        p = "";
        q = "";
        r = "";
        s = "";
        t = "";
        u = "";
        v = "";
    }

    static int b(v v1, int i1)
    {
        v1.m = i1;
        return i1;
    }

    static Object b(m m1)
    {
        return m1.f;
    }

    static Object b(f f1, Object obj)
    {
        f1.g = obj;
        return obj;
    }

    static int c(g g1, int i1)
    {
        g1.n = i1;
        return i1;
    }

    public static n c()
    {
        return c;
    }

    static Object c(c c1)
    {
        return c1.g;
    }

    static Object c(g g1, Object obj)
    {
        g1.h = obj;
        return obj;
    }

    static int d(h h1, int i1)
    {
        h1.e = i1;
        return i1;
    }

    static Object d(e e1)
    {
        return e1.h;
    }

    static Object d(h h1, Object obj)
    {
        h1.i = obj;
        return obj;
    }

    static Object e(i i1)
    {
        return i1.i;
    }

    static Object e(i i1, Object obj)
    {
        i1.j = obj;
        return obj;
    }

    static Object f(j j1)
    {
        return j1.j;
    }

    static Object f(j j1, Object obj)
    {
        j1.k = obj;
        return obj;
    }

    static Object g(k k1)
    {
        return k1.k;
    }

    static Object g(k k1, Object obj)
    {
        k1.o = obj;
        return obj;
    }

    static Object h(o o1)
    {
        return o1.o;
    }

    static Object h(o o1, Object obj)
    {
        o1.p = obj;
        return obj;
    }

    static Object i(p p1)
    {
        return p1.p;
    }

    static Object i(p p1, Object obj)
    {
        p1.q = obj;
        return obj;
    }

    static Object j(q q1)
    {
        return q1.q;
    }

    static Object j(q q1, Object obj)
    {
        q1.r = obj;
        return obj;
    }

    static Object k(r r1)
    {
        return r1.r;
    }

    static Object k(r r1, Object obj)
    {
        r1.s = obj;
        return obj;
    }

    static Object l(s s1)
    {
        return s1.s;
    }

    static Object l(s s1, Object obj)
    {
        s1.t = obj;
        return obj;
    }

    static Object m(t t1)
    {
        return t1.t;
    }

    static Object m(t t1, Object obj)
    {
        t1.u = obj;
        return obj;
    }

    static Object n(u u1)
    {
        return u1.u;
    }

    static Object n(u u1, Object obj)
    {
        u1.v = obj;
        return obj;
    }

    static Object o(v v1)
    {
        return v1.v;
    }

    static do p(v v1)
    {
        return v1.d;
    }

    public final boolean A()
    {
        return (e & 0x800) == 2048;
    }

    public final String B()
    {
        Object obj = q;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            q = s1;
        }
        return s1;
    }

    public final boolean C()
    {
        return (e & 0x1000) == 4096;
    }

    public final String D()
    {
        Object obj = r;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            r = s1;
        }
        return s1;
    }

    public final boolean E()
    {
        return (e & 0x2000) == 8192;
    }

    public final String F()
    {
        Object obj = s;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            s = s1;
        }
        return s1;
    }

    public final boolean G()
    {
        return (e & 0x4000) == 16384;
    }

    public final String H()
    {
        Object obj = t;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            t = s1;
        }
        return s1;
    }

    public final boolean I()
    {
        return (e & 0x8000) == 32768;
    }

    public final String J()
    {
        Object obj = u;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            u = s1;
        }
        return s1;
    }

    public final boolean K()
    {
        return (e & 0x10000) == 0x10000;
    }

    public final String L()
    {
        Object obj = v;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            v = s1;
        }
        return s1;
    }

    public final a N()
    {
        return a.f().a(this);
    }

    public final void a(dq dq1)
    {
        b();
        if ((e & 1) == 1)
        {
            dq1.a(1, O());
        }
        if ((e & 2) == 2)
        {
            dq1.a(2, P());
        }
        if ((e & 4) == 4)
        {
            dq1.a(3, Q());
        }
        if ((e & 8) == 8)
        {
            dq1.a(4, R());
        }
        if ((e & 0x10) == 16)
        {
            dq1.a(5, S());
        }
        if ((e & 0x20) == 32)
        {
            dq1.a(6, T());
        }
        if ((e & 0x40) == 64)
        {
            dq1.a(7, l);
        }
        if ((e & 0x80) == 128)
        {
            dq1.a(8, m);
        }
        if ((e & 0x100) == 256)
        {
            dq1.a(9, n);
        }
        if ((e & 0x200) == 512)
        {
            dq1.a(10, U());
        }
        if ((e & 0x400) == 1024)
        {
            dq1.a(11, V());
        }
        if ((e & 0x800) == 2048)
        {
            dq1.a(12, W());
        }
        if ((e & 0x1000) == 4096)
        {
            dq1.a(13, X());
        }
        if ((e & 0x2000) == 8192)
        {
            dq1.a(14, Y());
        }
        if ((e & 0x4000) == 16384)
        {
            dq1.a(15, Z());
        }
        if ((e & 0x8000) == 32768)
        {
            dq1.a(16, aa());
        }
        if ((e & 0x10000) == 0x10000)
        {
            dq1.a(17, ab());
        }
        dq1.b(d);
    }

    public final int b()
    {
        int i1 = x;
        if (i1 != -1)
        {
            return i1;
        }
        int j1 = 0;
        if ((e & 1) == 1)
        {
            j1 = dq.b(1, O()) + 0;
        }
        i1 = j1;
        if ((e & 2) == 2)
        {
            i1 = j1 + dq.b(2, P());
        }
        j1 = i1;
        if ((e & 4) == 4)
        {
            j1 = i1 + dq.b(3, Q());
        }
        i1 = j1;
        if ((e & 8) == 8)
        {
            i1 = j1 + dq.b(4, R());
        }
        j1 = i1;
        if ((e & 0x10) == 16)
        {
            j1 = i1 + dq.b(5, S());
        }
        i1 = j1;
        if ((e & 0x20) == 32)
        {
            i1 = j1 + dq.b(6, T());
        }
        j1 = i1;
        if ((e & 0x40) == 64)
        {
            j1 = i1 + dq.b(7, l);
        }
        i1 = j1;
        if ((e & 0x80) == 128)
        {
            i1 = j1 + dq.b(8, m);
        }
        j1 = i1;
        if ((e & 0x100) == 256)
        {
            j1 = i1 + dq.b(9, n);
        }
        i1 = j1;
        if ((e & 0x200) == 512)
        {
            i1 = j1 + dq.b(10, U());
        }
        j1 = i1;
        if ((e & 0x400) == 1024)
        {
            j1 = i1 + dq.b(11, V());
        }
        i1 = j1;
        if ((e & 0x800) == 2048)
        {
            i1 = j1 + dq.b(12, W());
        }
        j1 = i1;
        if ((e & 0x1000) == 4096)
        {
            j1 = i1 + dq.b(13, X());
        }
        i1 = j1;
        if ((e & 0x2000) == 8192)
        {
            i1 = j1 + dq.b(14, Y());
        }
        j1 = i1;
        if ((e & 0x4000) == 16384)
        {
            j1 = i1 + dq.b(15, Z());
        }
        i1 = j1;
        if ((e & 0x8000) == 32768)
        {
            i1 = j1 + dq.b(16, aa());
        }
        j1 = i1;
        if ((e & 0x10000) == 0x10000)
        {
            j1 = i1 + dq.b(17, ab());
        }
        i1 = j1 + d.a();
        x = i1;
        return i1;
    }

    public final boolean d()
    {
        byte byte0 = w;
        if (byte0 == 1)
        {
            return true;
        }
        if (byte0 == 0)
        {
            return false;
        } else
        {
            w = 1;
            return true;
        }
    }

    public final boolean e()
    {
        return (e & 1) == 1;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof e))
            {
                return super.equals(obj);
            }
            obj = (e)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (e() == ((e) (obj)).e())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (e())
            {
                if (flag && f().equals(((f) (obj)).f()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && g() == ((g) (obj)).g())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (g())
            {
                if (flag && h().equals(((h) (obj)).h()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && i() == ((i) (obj)).i())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (i())
            {
                if (flag && j().equals(((j) (obj)).j()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && k() == ((k) (obj)).k())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (k())
            {
                if (flag && l().equals(((l) (obj)).l()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && m() == ((m) (obj)).m())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (m())
            {
                if (flag && n().equals(((n) (obj)).n()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && o() == ((o) (obj)).o())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (o())
            {
                if (flag && p().equals(((p) (obj)).p()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && q() == ((q) (obj)).q())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (q())
            {
                if (flag && l == ((l) (obj)).l)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && s() == ((s) (obj)).s())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (s())
            {
                if (flag && m == ((m) (obj)).m)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && u() == ((u) (obj)).u())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (u())
            {
                if (flag && n == ((n) (obj)).n)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && w() == ((w) (obj)).w())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (w())
            {
                if (flag && x().equals(((x) (obj)).x()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && y() == ((y) (obj)).y())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (y())
            {
                if (flag && z().equals(((z) (obj)).z()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && A() == ((A) (obj)).A())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (A())
            {
                if (flag && B().equals(((B) (obj)).B()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && C() == ((C) (obj)).C())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (C())
            {
                if (flag && D().equals(((D) (obj)).D()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && E() == ((E) (obj)).E())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (E())
            {
                if (flag && F().equals(((F) (obj)).F()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && G() == ((G) (obj)).G())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (G())
            {
                if (flag && H().equals(((H) (obj)).H()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && I() == ((I) (obj)).I())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (I())
            {
                if (flag && J().equals(((J) (obj)).J()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && K() == ((K) (obj)).K())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (K())
            {
                if (!flag2 || !L().equals(((L) (obj)).L()))
                {
                    return false;
                }
            } else
            {
                return flag2;
            }
        }
        return true;
    }

    public final String f()
    {
        Object obj = f;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            f = s1;
        }
        return s1;
    }

    public final boolean g()
    {
        return (e & 2) == 2;
    }

    public final String h()
    {
        Object obj = g;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            g = s1;
        }
        return s1;
    }

    public final int hashCode()
    {
        if (a != 0)
        {
            return a;
        }
        int j1 = com/tapjoy/internal/gt$l.hashCode() + 779;
        int i1 = j1;
        if (e())
        {
            i1 = (j1 * 37 + 1) * 53 + f().hashCode();
        }
        j1 = i1;
        if (g())
        {
            j1 = (i1 * 37 + 2) * 53 + h().hashCode();
        }
        i1 = j1;
        if (i())
        {
            i1 = (j1 * 37 + 3) * 53 + j().hashCode();
        }
        j1 = i1;
        if (k())
        {
            j1 = (i1 * 37 + 4) * 53 + l().hashCode();
        }
        i1 = j1;
        if (m())
        {
            i1 = (j1 * 37 + 5) * 53 + n().hashCode();
        }
        j1 = i1;
        if (o())
        {
            j1 = (i1 * 37 + 6) * 53 + p().hashCode();
        }
        i1 = j1;
        if (q())
        {
            i1 = (j1 * 37 + 7) * 53 + l;
        }
        j1 = i1;
        if (s())
        {
            j1 = (i1 * 37 + 8) * 53 + m;
        }
        i1 = j1;
        if (u())
        {
            i1 = (j1 * 37 + 9) * 53 + n;
        }
        j1 = i1;
        if (w())
        {
            j1 = (i1 * 37 + 10) * 53 + x().hashCode();
        }
        i1 = j1;
        if (y())
        {
            i1 = (j1 * 37 + 11) * 53 + z().hashCode();
        }
        j1 = i1;
        if (A())
        {
            j1 = (i1 * 37 + 12) * 53 + B().hashCode();
        }
        i1 = j1;
        if (C())
        {
            i1 = (j1 * 37 + 13) * 53 + D().hashCode();
        }
        j1 = i1;
        if (E())
        {
            j1 = (i1 * 37 + 14) * 53 + F().hashCode();
        }
        i1 = j1;
        if (G())
        {
            i1 = (j1 * 37 + 15) * 53 + H().hashCode();
        }
        j1 = i1;
        if (I())
        {
            j1 = (i1 * 37 + 16) * 53 + J().hashCode();
        }
        i1 = j1;
        if (K())
        {
            i1 = (j1 * 37 + 17) * 53 + L().hashCode();
        }
        i1 = i1 * 29 + d.hashCode();
        a = i1;
        return i1;
    }

    public final boolean i()
    {
        return (e & 4) == 4;
    }

    public final String j()
    {
        Object obj = h;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            h = s1;
        }
        return s1;
    }

    public final boolean k()
    {
        return (e & 8) == 8;
    }

    public final String l()
    {
        Object obj = i;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            i = s1;
        }
        return s1;
    }

    public final boolean m()
    {
        return (e & 0x10) == 16;
    }

    public final String n()
    {
        Object obj = j;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            j = s1;
        }
        return s1;
    }

    public final boolean o()
    {
        return (e & 0x20) == 32;
    }

    public final String p()
    {
        Object obj = k;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            k = s1;
        }
        return s1;
    }

    public final boolean q()
    {
        return (e & 0x40) == 64;
    }

    public final int r()
    {
        return l;
    }

    public final boolean s()
    {
        return (e & 0x80) == 128;
    }

    public final int t()
    {
        return m;
    }

    public final boolean u()
    {
        return (e & 0x100) == 256;
    }

    public final int v()
    {
        return n;
    }

    public final boolean w()
    {
        return (e & 0x200) == 512;
    }

    public final String x()
    {
        Object obj = o;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            o = s1;
        }
        return s1;
    }

    public final boolean y()
    {
        return (e & 0x400) == 1024;
    }

    public final String z()
    {
        Object obj = p;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            p = s1;
        }
        return s1;
    }

    static 
    {
        p p1 = new <init>();
        c = p1;
        p1.ac();
    }

    private _cls1()
    {
        w = -1;
        x = -1;
        d = do.a;
    }

    private d(dp dp1)
    {
        d d1;
        dq dq1;
        boolean flag;
        w = -1;
        x = -1;
        ac();
        d1 = com.tapjoy.internal.do.h();
        dq1 = dq.a(d1, 4096);
        flag = false;
_L25:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = dp1.a();
        i1;
        JVM INSTR lookupswitch 18: default 747
    //                   0: 750
    //                   10: 216
    //                   18: 263
    //                   26: 305
    //                   34: 330
    //                   42: 356
    //                   50: 382
    //                   56: 408
    //                   64: 430
    //                   72: 453
    //                   82: 476
    //                   90: 503
    //                   98: 530
    //                   106: 557
    //                   114: 584
    //                   122: 611
    //                   130: 638
    //                   138: 664;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L3:
        if (!dp1.a(i1, dq1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        do do1 = dp1.d();
        e = e | 1;
        f = do1;
        continue; /* Loop/switch isn't completed */
        dp1;
        throw dp1.a(this);
        dp1;
        dq1.a();
        d = d1.a();
_L23:
        throw dp1;
_L6:
        do do2 = dp1.d();
        e = e | 2;
        g = do2;
        continue; /* Loop/switch isn't completed */
        dp1;
        throw (new du(dp1.getMessage())).a(this);
_L7:
        do do3 = dp1.d();
        e = e | 4;
        h = do3;
        continue; /* Loop/switch isn't completed */
_L8:
        do do4 = dp1.d();
        e = e | 8;
        i = do4;
        continue; /* Loop/switch isn't completed */
_L9:
        do do5 = dp1.d();
        e = e | 0x10;
        j = do5;
        continue; /* Loop/switch isn't completed */
_L10:
        do do6 = dp1.d();
        e = e | 0x20;
        k = do6;
        continue; /* Loop/switch isn't completed */
_L11:
        e = e | 0x40;
        l = dp1.e();
        continue; /* Loop/switch isn't completed */
_L12:
        e = e | 0x80;
        m = dp1.e();
        continue; /* Loop/switch isn't completed */
_L13:
        e = e | 0x100;
        n = dp1.e();
        continue; /* Loop/switch isn't completed */
_L14:
        do do7 = dp1.d();
        e = e | 0x200;
        o = do7;
        continue; /* Loop/switch isn't completed */
_L15:
        do do8 = dp1.d();
        e = e | 0x400;
        p = do8;
        continue; /* Loop/switch isn't completed */
_L16:
        do do9 = dp1.d();
        e = e | 0x800;
        q = do9;
        continue; /* Loop/switch isn't completed */
_L17:
        do do10 = dp1.d();
        e = e | 0x1000;
        r = do10;
        continue; /* Loop/switch isn't completed */
_L18:
        do do11 = dp1.d();
        e = e | 0x2000;
        s = do11;
        continue; /* Loop/switch isn't completed */
_L19:
        do do12 = dp1.d();
        e = e | 0x4000;
        t = do12;
        continue; /* Loop/switch isn't completed */
_L20:
        do do13 = dp1.d();
        e = e | 0x8000;
        u = do13;
        continue; /* Loop/switch isn't completed */
_L21:
        do do14 = dp1.d();
        e = e | 0x10000;
        v = do14;
        continue; /* Loop/switch isn't completed */
_L2:
        try
        {
            dq1.a();
        }
        // Misplaced declaration of an exception variable
        catch (dp dp1)
        {
            d = d1.a();
            return;
        }
        finally
        {
            d = d1.a();
        }
        d = d1.a();
        return;
        throw dp1;
        IOException ioexception;
        ioexception;
        d = d1.a();
        if (true) goto _L23; else goto _L22
_L22:
        dp1;
        d = d1.a();
        throw dp1;
_L4:
        flag = true;
        if (true) goto _L25; else goto _L24
_L24:
    }

    a(dp dp1, byte byte0)
    {
        this(dp1);
    }

    private <init>(<init> <init>1)
    {
        super((byte)0);
        w = -1;
        x = -1;
        d = <init>1.c();
    }

    c(c c1, byte byte0)
    {
        this(c1);
    }
}
