// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.tapjoy.internal:
//            ds, gt, do, du, 
//            dq, dp, dx, dt, 
//            dz, dr, dm

public static final class <init> extends ds
    implements <init>
{
    public static final class a extends ds.a
        implements gt.y
    {

        private boolean A;
        private int b;
        private long c;
        private Object d;
        private int e;
        private int f;
        private List g;
        private int h;
        private long i;
        private long j;
        private long k;
        private Object l;
        private int m;
        private double n;
        private long o;
        private double p;
        private Object q;
        private boolean r;
        private Object s;
        private int t;
        private int u;
        private Object v;
        private Object w;
        private Object x;
        private Object y;
        private Object z;

        static a L()
        {
            return new a();
        }

        private a M()
        {
            return (new a()).a(e());
        }

        private void N()
        {
            if ((b & 0x10) != 16)
            {
                g = new ArrayList(g);
                b = b | 0x10;
            }
        }

        public final a A()
        {
            b = b & 0xffefffff;
            w = gt.x.c().T();
            return this;
        }

        public final boolean B()
        {
            return (b & 0x200000) == 0x200000;
        }

        public final String C()
        {
            Object obj = x;
            if (!(obj instanceof String))
            {
                obj = (do)obj;
                String s1 = ((do) (obj)).f();
                if (((do) (obj)).g())
                {
                    x = s1;
                }
                return s1;
            } else
            {
                return (String)obj;
            }
        }

        public final a D()
        {
            b = b & 0xffdfffff;
            x = gt.x.c().V();
            return this;
        }

        public final boolean E()
        {
            return (b & 0x400000) == 0x400000;
        }

        public final String F()
        {
            Object obj = y;
            if (!(obj instanceof String))
            {
                obj = (do)obj;
                String s1 = ((do) (obj)).f();
                if (((do) (obj)).g())
                {
                    y = s1;
                }
                return s1;
            } else
            {
                return (String)obj;
            }
        }

        public final a G()
        {
            b = b & 0xffbfffff;
            y = gt.x.c().X();
            return this;
        }

        public final boolean H()
        {
            return (b & 0x800000) == 0x800000;
        }

        public final String I()
        {
            Object obj = z;
            if (!(obj instanceof String))
            {
                obj = (do)obj;
                String s1 = ((do) (obj)).f();
                if (((do) (obj)).g())
                {
                    z = s1;
                }
                return s1;
            } else
            {
                return (String)obj;
            }
        }

        public final a J()
        {
            b = b & 0xff7fffff;
            z = gt.x.c().Z();
            return this;
        }

        public final boolean K()
        {
            return A;
        }

        public final dl.a a()
        {
            return M();
        }

        public final a a(double d1)
        {
            b = b | 0x800;
            n = d1;
            return this;
        }

        public final a a(int i1)
        {
            b = b | 4;
            e = i1;
            return this;
        }

        public final a a(int i1, gt.t.a a1)
        {
            N();
            g.set(i1, a1.e());
            return this;
        }

        public final a a(int i1, gt.t t1)
        {
            if (t1 == null)
            {
                throw new NullPointerException();
            } else
            {
                N();
                g.set(i1, t1);
                return this;
            }
        }

        public final a a(long l1)
        {
            b = b | 1;
            c = l1;
            return this;
        }

        public final a a(gt.t.a a1)
        {
            N();
            g.add(a1.e());
            return this;
        }

        public final a a(gt.x x1)
        {
            if (x1 == gt.x.c())
            {
                return this;
            }
            if (x1.e())
            {
                a(x1.f());
            }
            if (x1.g())
            {
                b = b | 2;
                d = gt.x.b(x1);
            }
            if (x1.i())
            {
                a(x1.j());
            }
            if (x1.k())
            {
                b(x1.l());
            }
            if (!gt.x.c(x1).isEmpty())
            {
                if (g.isEmpty())
                {
                    g = gt.x.c(x1);
                    b = b & 0xffffffef;
                } else
                {
                    N();
                    g.addAll(gt.x.c(x1));
                }
            }
            if (x1.o())
            {
                e(x1.p());
            }
            if (x1.q())
            {
                b(x1.r());
            }
            if (x1.s())
            {
                c(x1.t());
            }
            if (x1.u())
            {
                d(x1.v());
            }
            if (x1.w())
            {
                b = b | 0x200;
                l = gt.x.d(x1);
            }
            if (x1.y())
            {
                f(x1.z());
            }
            if (x1.A())
            {
                a(x1.B());
            }
            if (x1.C())
            {
                e(x1.D());
            }
            if (x1.E())
            {
                b(x1.F());
            }
            if (x1.G())
            {
                b = b | 0x4000;
                q = gt.x.e(x1);
            }
            if (x1.I())
            {
                a(x1.J());
            }
            if (x1.K())
            {
                b = b | 0x10000;
                s = gt.x.f(x1);
            }
            if (x1.M())
            {
                g(x1.N());
            }
            if (x1.O())
            {
                h(x1.P());
            }
            if (x1.Q())
            {
                b = b | 0x80000;
                v = gt.x.g(x1);
            }
            if (x1.S())
            {
                b = b | 0x100000;
                w = gt.x.h(x1);
            }
            if (x1.U())
            {
                b = b | 0x200000;
                x = gt.x.i(x1);
            }
            if (x1.W())
            {
                b = b | 0x400000;
                y = gt.x.j(x1);
            }
            if (x1.Y())
            {
                b = b | 0x800000;
                z = gt.x.k(x1);
            }
            if (x1.aa())
            {
                b(x1.ab());
            }
            super.a = super.a.a(gt.x.l(x1));
            return this;
        }

        public final a a(Iterable iterable)
        {
            N();
            dl.a.a(iterable, g);
            return this;
        }

        public final a a(String s1)
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

        public final a a(boolean flag)
        {
            b = b | 0x8000;
            r = flag;
            return this;
        }

        public final ds.a b()
        {
            return M();
        }

        public final a b(double d1)
        {
            b = b | 0x2000;
            p = d1;
            return this;
        }

        public final a b(int i1)
        {
            b = b | 8;
            f = i1;
            return this;
        }

        public final a b(long l1)
        {
            b = b | 0x40;
            i = l1;
            return this;
        }

        public final a b(String s1)
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

        public final a b(boolean flag)
        {
            b = b | 0x1000000;
            A = flag;
            return this;
        }

        public final gt.t c(int i1)
        {
            return (gt.t)g.get(i1);
        }

        public final a c(long l1)
        {
            b = b | 0x80;
            j = l1;
            return this;
        }

        public final a c(String s1)
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

        public final Object clone()
        {
            return M();
        }

        public final a d(int i1)
        {
            N();
            g.remove(i1);
            return this;
        }

        public final a d(long l1)
        {
            b = b | 0x100;
            k = l1;
            return this;
        }

        public final a d(String s1)
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

        public final boolean d()
        {
            for (int i1 = 0; i1 < g(); i1++)
            {
                if (!c(i1).d())
                {
                    return false;
                }
            }

            return true;
        }

        public final a e(int i1)
        {
            b = b | 0x20;
            h = i1;
            return this;
        }

        public final a e(long l1)
        {
            b = b | 0x1000;
            o = l1;
            return this;
        }

        public final a e(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x80000;
                v = s1;
                return this;
            }
        }

        public final gt.x e()
        {
            gt.x x1 = new gt.x(this, (byte)0);
            int k1 = b;
            int j1 = 0;
            if ((k1 & 1) == 1)
            {
                j1 = 1;
            }
            gt.x.a(x1, c);
            int i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            gt.x.a(x1, d);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            gt.x.a(x1, e);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            gt.x.b(x1, f);
            if ((b & 0x10) == 16)
            {
                g = Collections.unmodifiableList(g);
                b = b & 0xffffffef;
            }
            gt.x.a(x1, g);
            j1 = i1;
            if ((k1 & 0x20) == 32)
            {
                j1 = i1 | 0x10;
            }
            gt.x.c(x1, h);
            i1 = j1;
            if ((k1 & 0x40) == 64)
            {
                i1 = j1 | 0x20;
            }
            gt.x.b(x1, i);
            j1 = i1;
            if ((k1 & 0x80) == 128)
            {
                j1 = i1 | 0x40;
            }
            gt.x.c(x1, j);
            i1 = j1;
            if ((k1 & 0x100) == 256)
            {
                i1 = j1 | 0x80;
            }
            gt.x.d(x1, k);
            j1 = i1;
            if ((k1 & 0x200) == 512)
            {
                j1 = i1 | 0x100;
            }
            gt.x.b(x1, l);
            i1 = j1;
            if ((k1 & 0x400) == 1024)
            {
                i1 = j1 | 0x200;
            }
            gt.x.d(x1, m);
            j1 = i1;
            if ((k1 & 0x800) == 2048)
            {
                j1 = i1 | 0x400;
            }
            gt.x.a(x1, n);
            i1 = j1;
            if ((k1 & 0x1000) == 4096)
            {
                i1 = j1 | 0x800;
            }
            gt.x.e(x1, o);
            j1 = i1;
            if ((k1 & 0x2000) == 8192)
            {
                j1 = i1 | 0x1000;
            }
            gt.x.b(x1, p);
            i1 = j1;
            if ((k1 & 0x4000) == 16384)
            {
                i1 = j1 | 0x2000;
            }
            gt.x.c(x1, q);
            j1 = i1;
            if ((k1 & 0x8000) == 32768)
            {
                j1 = i1 | 0x4000;
            }
            gt.x.a(x1, r);
            i1 = j1;
            if ((k1 & 0x10000) == 0x10000)
            {
                i1 = j1 | 0x8000;
            }
            gt.x.d(x1, s);
            j1 = i1;
            if ((k1 & 0x20000) == 0x20000)
            {
                j1 = i1 | 0x10000;
            }
            gt.x.e(x1, t);
            i1 = j1;
            if ((k1 & 0x40000) == 0x40000)
            {
                i1 = j1 | 0x20000;
            }
            gt.x.f(x1, u);
            j1 = i1;
            if ((k1 & 0x80000) == 0x80000)
            {
                j1 = i1 | 0x40000;
            }
            gt.x.e(x1, v);
            i1 = j1;
            if ((0x100000 & k1) == 0x100000)
            {
                i1 = j1 | 0x80000;
            }
            gt.x.f(x1, w);
            j1 = i1;
            if ((0x200000 & k1) == 0x200000)
            {
                j1 = i1 | 0x100000;
            }
            gt.x.g(x1, x);
            i1 = j1;
            if ((0x400000 & k1) == 0x400000)
            {
                i1 = j1 | 0x200000;
            }
            gt.x.h(x1, y);
            j1 = i1;
            if ((0x800000 & k1) == 0x800000)
            {
                j1 = i1 | 0x400000;
            }
            gt.x.i(x1, z);
            i1 = j1;
            if ((k1 & 0x1000000) == 0x1000000)
            {
                i1 = j1 | 0x800000;
            }
            gt.x.b(x1, A);
            gt.x.g(x1, i1);
            return x1;
        }

        public final a f(int i1)
        {
            b = b | 0x400;
            m = i1;
            return this;
        }

        public final a f(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x100000;
                w = s1;
                return this;
            }
        }

        public final List f()
        {
            return Collections.unmodifiableList(g);
        }

        public final int g()
        {
            return g.size();
        }

        public final a g(int i1)
        {
            b = b | 0x20000;
            t = i1;
            return this;
        }

        public final a g(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x200000;
                x = s1;
                return this;
            }
        }

        public final a h()
        {
            g = Collections.emptyList();
            b = b & 0xffffffef;
            return this;
        }

        public final a h(int i1)
        {
            b = b | 0x40000;
            u = i1;
            return this;
        }

        public final a h(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x400000;
                y = s1;
                return this;
            }
        }

        public final a i()
        {
            b = b & 0xffffefff;
            o = 0L;
            return this;
        }

        public final a i(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x800000;
                z = s1;
                return this;
            }
        }

        public final a j()
        {
            b = b & 0xffffdfff;
            p = 0.0D;
            return this;
        }

        public final a k()
        {
            b = b & 0xffffbfff;
            q = gt.x.c().H();
            return this;
        }

        public final a l()
        {
            b = b & 0xffff7fff;
            r = false;
            return this;
        }

        public final boolean m()
        {
            return (b & 0x10000) == 0x10000;
        }

        public final String n()
        {
            Object obj = s;
            if (!(obj instanceof String))
            {
                obj = (do)obj;
                String s1 = ((do) (obj)).f();
                if (((do) (obj)).g())
                {
                    s = s1;
                }
                return s1;
            } else
            {
                return (String)obj;
            }
        }

        public final a o()
        {
            b = b & 0xfffeffff;
            s = gt.x.c().L();
            return this;
        }

        public final boolean p()
        {
            return (b & 0x20000) == 0x20000;
        }

        public final int q()
        {
            return t;
        }

        public final a r()
        {
            b = b & 0xfffdffff;
            t = 0;
            return this;
        }

        public final boolean s()
        {
            return (b & 0x40000) == 0x40000;
        }

        public final int t()
        {
            return u;
        }

        public final a u()
        {
            b = b & 0xfffbffff;
            u = 0;
            return this;
        }

        public final boolean v()
        {
            return (b & 0x80000) == 0x80000;
        }

        public final String w()
        {
            Object obj = v;
            if (!(obj instanceof String))
            {
                obj = (do)obj;
                String s1 = ((do) (obj)).f();
                if (((do) (obj)).g())
                {
                    v = s1;
                }
                return s1;
            } else
            {
                return (String)obj;
            }
        }

        public final a x()
        {
            b = b & 0xfff7ffff;
            v = gt.x.c().R();
            return this;
        }

        public final boolean y()
        {
            return (b & 0x100000) == 0x100000;
        }

        public final String z()
        {
            Object obj = w;
            if (!(obj instanceof String))
            {
                obj = (do)obj;
                String s1 = ((do) (obj)).f();
                if (((do) (obj)).g())
                {
                    w = s1;
                }
                return s1;
            } else
            {
                return (String)obj;
            }
        }

        private a()
        {
            d = "";
            g = Collections.emptyList();
            l = "";
            q = "";
            s = "";
            v = "";
            w = "";
            x = "";
            y = "";
            z = "";
        }
    }


    public static dz b = new dm() {

        public final Object a(dp dp1, dr dr)
        {
            return new gt.x(dp1, dr, (byte)0);
        }

    };
    private static final <init> c;
    private Object A;
    private Object B;
    private Object C;
    private boolean D;
    private byte E;
    private int F;
    private final do d;
    private int e;
    private long f;
    private Object g;
    private int h;
    private int i;
    private List j;
    private int k;
    private long l;
    private long m;
    private long n;
    private Object o;
    private int p;
    private double q;
    private long r;
    private double s;
    private Object t;
    private boolean u;
    private Object v;
    private int w;
    private int x;
    private Object y;
    private Object z;

    static double a(a.w w1, double d1)
    {
        w1.q = d1;
        return d1;
    }

    static int a(q q1, int i1)
    {
        q1.h = i1;
        return i1;
    }

    static long a(h h1, long l1)
    {
        h1.f = l1;
        return l1;
    }

    public static a a(f f1)
    {
        return a.L().a(f1);
    }

    static Object a(a.a a1, Object obj)
    {
        a1.g = obj;
        return obj;
    }

    static List a(g g1, List list)
    {
        g1.j = list;
        return list;
    }

    static boolean a(j j1, boolean flag)
    {
        j1.u = flag;
        return flag;
    }

    public static a ac()
    {
        return a.L();
    }

    private do ae()
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

    private do af()
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

    private do ag()
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

    private do ah()
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

    private do ai()
    {
        Object obj = y;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            y = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do aj()
    {
        Object obj = z;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            z = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do ak()
    {
        Object obj = A;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            A = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do al()
    {
        Object obj = B;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            B = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do am()
    {
        Object obj = C;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            C = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private void an()
    {
        f = 0L;
        g = "";
        h = 0;
        i = 0;
        j = Collections.emptyList();
        k = 0;
        l = 0L;
        m = 0L;
        n = 0L;
        o = "";
        p = 0;
        q = 0.0D;
        r = 0L;
        s = 0.0D;
        t = "";
        u = false;
        v = "";
        w = 0;
        x = 0;
        y = "";
        z = "";
        A = "";
        B = "";
        C = "";
        D = false;
    }

    static double b(D d1, double d2)
    {
        d1.s = d2;
        return d2;
    }

    static int b(s s1, int i1)
    {
        s1.i = i1;
        return i1;
    }

    static long b(i i1, long l1)
    {
        i1.l = l1;
        return l1;
    }

    static Object b(l l1)
    {
        return l1.g;
    }

    static Object b(g g1, Object obj)
    {
        g1.o = obj;
        return obj;
    }

    static boolean b(o o1, boolean flag)
    {
        o1.D = flag;
        return flag;
    }

    static int c(D d1, int i1)
    {
        d1.k = i1;
        return i1;
    }

    static long c(k k1, long l1)
    {
        k1.m = l1;
        return l1;
    }

    public static m c()
    {
        return c;
    }

    static Object c(c c1, Object obj)
    {
        c1.t = obj;
        return obj;
    }

    static List c(t t1)
    {
        return t1.j;
    }

    static int d(j j1, int i1)
    {
        j1.p = i1;
        return i1;
    }

    static long d(p p1, long l1)
    {
        p1.n = l1;
        return l1;
    }

    static Object d(n n1)
    {
        return n1.o;
    }

    static Object d(o o1, Object obj)
    {
        o1.v = obj;
        return obj;
    }

    static int e(v v1, int i1)
    {
        v1.w = i1;
        return i1;
    }

    static long e(w w1, long l1)
    {
        w1.r = l1;
        return l1;
    }

    static Object e(r r1)
    {
        return r1.t;
    }

    static Object e(t t1, Object obj)
    {
        t1.y = obj;
        return obj;
    }

    static int f(y y1, int i1)
    {
        y1.x = i1;
        return i1;
    }

    static Object f(x x1)
    {
        return x1.v;
    }

    static Object f(v v1, Object obj)
    {
        v1.z = obj;
        return obj;
    }

    static int g(z z1, int i1)
    {
        z1.e = i1;
        return i1;
    }

    static Object g(e e1)
    {
        return e1.y;
    }

    static Object g(y y1, Object obj)
    {
        y1.A = obj;
        return obj;
    }

    static Object h(A a1)
    {
        return a1.z;
    }

    static Object h(z z1, Object obj)
    {
        z1.B = obj;
        return obj;
    }

    static Object i(B b1)
    {
        return b1.A;
    }

    static Object i(A a1, Object obj)
    {
        a1.C = obj;
        return obj;
    }

    static Object j(C c1)
    {
        return c1.B;
    }

    static Object k(B b1)
    {
        return b1.C;
    }

    static do l(C c1)
    {
        return c1.d;
    }

    public final boolean A()
    {
        return (e & 0x400) == 1024;
    }

    public final double B()
    {
        return q;
    }

    public final boolean C()
    {
        return (e & 0x800) == 2048;
    }

    public final long D()
    {
        return r;
    }

    public final boolean E()
    {
        return (e & 0x1000) == 4096;
    }

    public final double F()
    {
        return s;
    }

    public final boolean G()
    {
        return (e & 0x2000) == 8192;
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
        return (e & 0x4000) == 16384;
    }

    public final boolean J()
    {
        return u;
    }

    public final boolean K()
    {
        return (e & 0x8000) == 32768;
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

    public final boolean M()
    {
        return (e & 0x10000) == 0x10000;
    }

    public final int N()
    {
        return w;
    }

    public final boolean O()
    {
        return (e & 0x20000) == 0x20000;
    }

    public final int P()
    {
        return x;
    }

    public final boolean Q()
    {
        return (e & 0x40000) == 0x40000;
    }

    public final String R()
    {
        Object obj = y;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            y = s1;
        }
        return s1;
    }

    public final boolean S()
    {
        return (e & 0x80000) == 0x80000;
    }

    public final String T()
    {
        Object obj = z;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            z = s1;
        }
        return s1;
    }

    public final boolean U()
    {
        return (e & 0x100000) == 0x100000;
    }

    public final String V()
    {
        Object obj = A;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            A = s1;
        }
        return s1;
    }

    public final boolean W()
    {
        return (e & 0x200000) == 0x200000;
    }

    public final String X()
    {
        Object obj = B;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            B = s1;
        }
        return s1;
    }

    public final boolean Y()
    {
        return (e & 0x400000) == 0x400000;
    }

    public final String Z()
    {
        Object obj = C;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            C = s1;
        }
        return s1;
    }

    public final void a(dq dq1)
    {
        b();
        if ((e & 1) == 1)
        {
            dq1.a(1, f);
        }
        if ((e & 2) == 2)
        {
            dq1.a(2, ae());
        }
        if ((e & 0x200) == 512)
        {
            dq1.a(3, p);
        }
        if ((e & 0x800) == 2048)
        {
            dq1.a(4, r);
        }
        if ((e & 0x8000) == 32768)
        {
            dq1.a(5, ah());
        }
        if ((e & 0x10000) == 0x10000)
        {
            dq1.a(6, w);
        }
        if ((e & 0x20000) == 0x20000)
        {
            dq1.a(7, x);
        }
        if ((e & 0x40000) == 0x40000)
        {
            dq1.a(8, ai());
        }
        if ((e & 0x80000) == 0x80000)
        {
            dq1.a(9, aj());
        }
        if ((e & 0x100000) == 0x100000)
        {
            dq1.a(10, ak());
        }
        if ((e & 0x200000) == 0x200000)
        {
            dq1.a(11, al());
        }
        if ((e & 0x400000) == 0x400000)
        {
            dq1.a(12, am());
        }
        if ((e & 4) == 4)
        {
            dq1.a(13, h);
        }
        if ((e & 8) == 8)
        {
            dq1.a(14, i);
        }
        for (int i1 = 0; i1 < j.size(); i1++)
        {
            dq1.a(15, (dx)j.get(i1));
        }

        if ((e & 0x10) == 16)
        {
            dq1.a(16, k);
        }
        if ((e & 0x20) == 32)
        {
            dq1.a(17, l);
        }
        if ((e & 0x40) == 64)
        {
            dq1.a(18, m);
        }
        if ((e & 0x80) == 128)
        {
            dq1.a(19, n);
        }
        if ((e & 0x100) == 256)
        {
            dq1.a(20, af());
        }
        if ((e & 0x400) == 1024)
        {
            dq1.a(21, q);
        }
        if ((e & 0x1000) == 4096)
        {
            dq1.a(22, s);
        }
        if ((e & 0x2000) == 8192)
        {
            dq1.a(23, ag());
        }
        if ((e & 0x4000) == 16384)
        {
            dq1.a(24, u);
        }
        if ((e & 0x800000) == 0x800000)
        {
            dq1.a(25, D);
        }
        dq1.b(d);
    }

    public final boolean aa()
    {
        return (e & 0x800000) == 0x800000;
    }

    public final boolean ab()
    {
        return D;
    }

    public final a ad()
    {
        return a.L().a(this);
    }

    public final int b()
    {
        boolean flag = false;
        int i1 = F;
        if (i1 != -1)
        {
            return i1;
        }
        int j1;
        if ((e & 1) == 1)
        {
            j1 = dq.b(1, f) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if ((e & 2) == 2)
        {
            i1 = j1 + dq.b(2, ae());
        }
        j1 = i1;
        if ((e & 0x200) == 512)
        {
            j1 = i1 + dq.b(3, p);
        }
        i1 = j1;
        if ((e & 0x800) == 2048)
        {
            i1 = j1 + dq.b(4, r);
        }
        j1 = i1;
        if ((e & 0x8000) == 32768)
        {
            j1 = i1 + dq.b(5, ah());
        }
        i1 = j1;
        if ((e & 0x10000) == 0x10000)
        {
            i1 = j1 + dq.b(6, w);
        }
        j1 = i1;
        if ((e & 0x20000) == 0x20000)
        {
            j1 = i1 + dq.b(7, x);
        }
        i1 = j1;
        if ((e & 0x40000) == 0x40000)
        {
            i1 = j1 + dq.b(8, ai());
        }
        j1 = i1;
        if ((e & 0x80000) == 0x80000)
        {
            j1 = i1 + dq.b(9, aj());
        }
        i1 = j1;
        if ((e & 0x100000) == 0x100000)
        {
            i1 = j1 + dq.b(10, ak());
        }
        j1 = i1;
        if ((e & 0x200000) == 0x200000)
        {
            j1 = i1 + dq.b(11, al());
        }
        i1 = j1;
        if ((e & 0x400000) == 0x400000)
        {
            i1 = j1 + dq.b(12, am());
        }
        j1 = i1;
        if ((e & 4) == 4)
        {
            j1 = i1 + dq.b(13, h);
        }
        i1 = j1;
        if ((e & 8) == 8)
        {
            i1 = j1 + dq.b(14, i);
        }
        for (j1 = ((flag) ? 1 : 0); j1 < j.size();)
        {
            int k1 = dq.b(15, (dx)j.get(j1));
            j1++;
            i1 = k1 + i1;
        }

        j1 = i1;
        if ((e & 0x10) == 16)
        {
            j1 = i1 + dq.b(16, k);
        }
        i1 = j1;
        if ((e & 0x20) == 32)
        {
            i1 = j1 + dq.b(17, l);
        }
        j1 = i1;
        if ((e & 0x40) == 64)
        {
            j1 = i1 + dq.b(18, m);
        }
        i1 = j1;
        if ((e & 0x80) == 128)
        {
            i1 = j1 + dq.b(19, n);
        }
        j1 = i1;
        if ((e & 0x100) == 256)
        {
            j1 = i1 + dq.b(20, af());
        }
        i1 = j1;
        if ((e & 0x400) == 1024)
        {
            double d1 = q;
            i1 = j1 + (dq.d(21) + 8);
        }
        j1 = i1;
        if ((e & 0x1000) == 4096)
        {
            double d2 = s;
            j1 = i1 + (dq.d(22) + 8);
        }
        i1 = j1;
        if ((e & 0x2000) == 8192)
        {
            i1 = j1 + dq.b(23, ag());
        }
        j1 = i1;
        if ((e & 0x4000) == 16384)
        {
            boolean flag1 = u;
            j1 = i1 + (dq.d(24) + 1);
        }
        i1 = j1;
        if ((e & 0x800000) == 0x800000)
        {
            boolean flag2 = D;
            i1 = j1 + (dq.d(25) + 1);
        }
        i1 = d.a() + i1;
        F = i1;
        return i1;
    }

    public final boolean d()
    {
        boolean flag = false;
        byte byte0 = E;
        if (byte0 == 1)
        {
            flag = true;
        } else
        if (byte0 != 0)
        {
            for (int i1 = 0; i1 < n(); i1++)
            {
                if (!((n)j.get(i1)).d())
                {
                    E = 0;
                    return false;
                }
            }

            E = 1;
            return true;
        }
        return flag;
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
                if (flag && f == ((f) (obj)).f)
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
                if (flag && h == ((h) (obj)).h)
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
                if (flag && i == ((i) (obj)).i)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && j.equals(((j) (obj)).j))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && o() == ((o) (obj)).o())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (o())
            {
                if (flag && k == ((k) (obj)).k)
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
                if (flag && p == ((p) (obj)).p)
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
                if (flag && Double.doubleToLongBits(q) == Double.doubleToLongBits(((LongBits) (obj)).q))
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
                if (flag && r == ((r) (obj)).r)
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
                if (flag && Double.doubleToLongBits(s) == Double.doubleToLongBits(((LongBits) (obj)).s))
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
                if (flag && u == ((u) (obj)).u)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && K() == ((K) (obj)).K())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (K())
            {
                if (flag && L().equals(((L) (obj)).L()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && M() == ((M) (obj)).M())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (M())
            {
                if (flag && w == ((w) (obj)).w)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && O() == ((O) (obj)).O())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (O())
            {
                if (flag && x == ((x) (obj)).x)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && Q() == ((Q) (obj)).Q())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (Q())
            {
                if (flag && R().equals(((R) (obj)).R()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && S() == ((S) (obj)).S())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (S())
            {
                if (flag && T().equals(((T) (obj)).T()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && U() == ((U) (obj)).U())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (U())
            {
                if (flag && V().equals(((V) (obj)).V()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && W() == ((W) (obj)).W())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (W())
            {
                if (flag && X().equals(((X) (obj)).X()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && Y() == ((Y) (obj)).Y())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (Y())
            {
                if (flag && Z().equals(((Z) (obj)).Z()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && aa() == ((aa) (obj)).aa())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (aa())
            {
                if (!flag2 || D != ((D) (obj)).D)
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

    public final long f()
    {
        return f;
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
        int j1 = com/tapjoy/internal/gt$x.hashCode() + 779;
        int i1 = j1;
        if (e())
        {
            i1 = (j1 * 37 + 1) * 53 + dt.a(f);
        }
        j1 = i1;
        if (g())
        {
            j1 = (i1 * 37 + 2) * 53 + h().hashCode();
        }
        i1 = j1;
        if (i())
        {
            i1 = (j1 * 37 + 13) * 53 + h;
        }
        j1 = i1;
        if (k())
        {
            j1 = (i1 * 37 + 14) * 53 + i;
        }
        i1 = j1;
        if (n() > 0)
        {
            i1 = (j1 * 37 + 15) * 53 + j.hashCode();
        }
        j1 = i1;
        if (o())
        {
            j1 = (i1 * 37 + 16) * 53 + k;
        }
        i1 = j1;
        if (q())
        {
            i1 = (j1 * 37 + 17) * 53 + dt.a(l);
        }
        j1 = i1;
        if (s())
        {
            j1 = (i1 * 37 + 18) * 53 + dt.a(m);
        }
        i1 = j1;
        if (u())
        {
            i1 = (j1 * 37 + 19) * 53 + dt.a(n);
        }
        j1 = i1;
        if (w())
        {
            j1 = (i1 * 37 + 20) * 53 + x().hashCode();
        }
        i1 = j1;
        if (y())
        {
            i1 = (j1 * 37 + 3) * 53 + p;
        }
        j1 = i1;
        if (A())
        {
            j1 = (i1 * 37 + 21) * 53 + dt.a(Double.doubleToLongBits(q));
        }
        i1 = j1;
        if (C())
        {
            i1 = (j1 * 37 + 4) * 53 + dt.a(r);
        }
        j1 = i1;
        if (E())
        {
            j1 = (i1 * 37 + 22) * 53 + dt.a(Double.doubleToLongBits(s));
        }
        i1 = j1;
        if (G())
        {
            i1 = (j1 * 37 + 23) * 53 + H().hashCode();
        }
        j1 = i1;
        if (I())
        {
            j1 = (i1 * 37 + 24) * 53 + dt.a(u);
        }
        i1 = j1;
        if (K())
        {
            i1 = (j1 * 37 + 5) * 53 + L().hashCode();
        }
        j1 = i1;
        if (M())
        {
            j1 = (i1 * 37 + 6) * 53 + w;
        }
        i1 = j1;
        if (O())
        {
            i1 = (j1 * 37 + 7) * 53 + x;
        }
        j1 = i1;
        if (Q())
        {
            j1 = (i1 * 37 + 8) * 53 + R().hashCode();
        }
        i1 = j1;
        if (S())
        {
            i1 = (j1 * 37 + 9) * 53 + T().hashCode();
        }
        j1 = i1;
        if (U())
        {
            j1 = (i1 * 37 + 10) * 53 + V().hashCode();
        }
        i1 = j1;
        if (W())
        {
            i1 = (j1 * 37 + 11) * 53 + X().hashCode();
        }
        j1 = i1;
        if (Y())
        {
            j1 = (i1 * 37 + 12) * 53 + Z().hashCode();
        }
        i1 = j1;
        if (aa())
        {
            i1 = (j1 * 37 + 25) * 53 + dt.a(D);
        }
        i1 = i1 * 29 + d.hashCode();
        a = i1;
        return i1;
    }

    public final boolean i()
    {
        return (e & 4) == 4;
    }

    public final int j()
    {
        return h;
    }

    public final boolean k()
    {
        return (e & 8) == 8;
    }

    public final int l()
    {
        return i;
    }

    public final List m()
    {
        return j;
    }

    public final int n()
    {
        return j.size();
    }

    public final boolean o()
    {
        return (e & 0x10) == 16;
    }

    public final int p()
    {
        return k;
    }

    public final boolean q()
    {
        return (e & 0x20) == 32;
    }

    public final long r()
    {
        return l;
    }

    public final boolean s()
    {
        return (e & 0x40) == 64;
    }

    public final long t()
    {
        return m;
    }

    public final boolean u()
    {
        return (e & 0x80) == 128;
    }

    public final long v()
    {
        return n;
    }

    public final boolean w()
    {
        return (e & 0x100) == 256;
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
        return (e & 0x200) == 512;
    }

    public final int z()
    {
        return p;
    }

    static 
    {
        p p1 = new <init>();
        c = p1;
        p1.an();
    }

    private _cls1()
    {
        E = -1;
        F = -1;
        d = do.a;
    }

    private d(dp dp1, dr dr)
    {
        d d1;
        dq dq1;
        int i1;
        boolean flag;
        flag = false;
        super();
        E = -1;
        F = -1;
        an();
        d1 = com.tapjoy.internal.do.h();
        dq1 = dq.a(d1, 4096);
        i1 = 0;
_L35:
        if (flag) goto _L2; else goto _L1
_L1:
        int k1;
        int l1;
        int i2;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        int j1 = dp1.a();
        j1;
        JVM INSTR lookupswitch 26: default 1797
    //                   0: 1800
    //                   8: 309
    //                   18: 402
    //                   24: 484
    //                   32: 531
    //                   42: 578
    //                   48: 640
    //                   56: 686
    //                   66: 732
    //                   74: 794
    //                   82: 856
    //                   90: 918
    //                   98: 980
    //                   104: 1042
    //                   112: 1087
    //                   122: 1133
    //                   128: 1214
    //                   136: 1260
    //                   144: 1306
    //                   152: 1352
    //                   162: 1399
    //                   169: 1462
    //                   177: 1512
    //                   186: 1562
    //                   192: 1625
    //                   200: 1672;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29
_L3:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        if (!dp1.a(j1, dq1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 1;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        f = dp1.f();
        continue; /* Loop/switch isn't completed */
        dp1;
        k1 = l1;
        throw dp1.a(this);
        dp1;
        if ((k1 & 0x10) == 16)
        {
            j = Collections.unmodifiableList(j);
        }
        dq1.a();
        d = d1.a();
_L33:
        throw dp1;
_L6:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        do do1 = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 2;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        g = do1;
        continue; /* Loop/switch isn't completed */
        dp1;
        k1 = i2;
        throw (new du(dp1.getMessage())).a(this);
_L7:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x200;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        p = dp1.e();
        continue; /* Loop/switch isn't completed */
_L8:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x800;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        r = dp1.f();
        continue; /* Loop/switch isn't completed */
_L9:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        do1 = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x8000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        v = do1;
        continue; /* Loop/switch isn't completed */
_L10:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x10000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        w = dp1.e();
        continue; /* Loop/switch isn't completed */
_L11:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x20000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        x = dp1.e();
        continue; /* Loop/switch isn't completed */
_L12:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        do1 = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x40000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        y = do1;
        continue; /* Loop/switch isn't completed */
_L13:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        do1 = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x80000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        z = do1;
        continue; /* Loop/switch isn't completed */
_L14:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        do1 = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x100000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        A = do1;
        continue; /* Loop/switch isn't completed */
_L15:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        do1 = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x200000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        B = do1;
        continue; /* Loop/switch isn't completed */
_L16:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        do1 = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x400000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        C = do1;
        continue; /* Loop/switch isn't completed */
_L17:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 4;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        h = dp1.e();
        continue; /* Loop/switch isn't completed */
_L18:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 8;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        i = dp1.e();
        continue; /* Loop/switch isn't completed */
_L19:
        j1 = i1;
        if ((i1 & 0x10) == 16) goto _L31; else goto _L30
_L30:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        j = new ArrayList();
        j1 = i1 | 0x10;
_L31:
        l1 = j1;
        k1 = j1;
        i2 = j1;
        j.add(dp1.a(b, dr));
        i1 = j1;
        continue; /* Loop/switch isn't completed */
_L20:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x10;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        k = dp1.e();
        continue; /* Loop/switch isn't completed */
_L21:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x20;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        l = dp1.b();
        continue; /* Loop/switch isn't completed */
_L22:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x40;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        m = dp1.b();
        continue; /* Loop/switch isn't completed */
_L23:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x80;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        n = dp1.b();
        continue; /* Loop/switch isn't completed */
_L24:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        do1 = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x100;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        o = do1;
        continue; /* Loop/switch isn't completed */
_L25:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x400;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        q = Double.longBitsToDouble(dp1.g());
        continue; /* Loop/switch isn't completed */
_L26:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x1000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        s = Double.longBitsToDouble(dp1.g());
        continue; /* Loop/switch isn't completed */
_L27:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        do1 = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x2000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        t = do1;
        continue; /* Loop/switch isn't completed */
_L28:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x4000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        u = dp1.c();
        continue; /* Loop/switch isn't completed */
_L29:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x800000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        D = dp1.c();
        continue; /* Loop/switch isn't completed */
_L2:
        if ((i1 & 0x10) == 16)
        {
            j = Collections.unmodifiableList(j);
        }
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
        dr;
        d = d1.a();
        if (true) goto _L33; else goto _L32
_L32:
        dp1;
        d = d1.a();
        throw dp1;
_L4:
        flag = true;
        if (true) goto _L35; else goto _L34
_L34:
    }

    a(dp dp1, dr dr, byte byte0)
    {
        this(dp1, dr);
    }

    private <init>(<init> <init>1)
    {
        super((byte)0);
        E = -1;
        F = -1;
        d = <init>1.c();
    }

    c(c c1, byte byte0)
    {
        this(c1);
    }
}
