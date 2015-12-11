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
//            dz, dr, ec, dm

public static final class <init> extends ds
    implements <init>
{
    public static final class a extends ds.a
        implements gt.h
    {

        private int b;
        private gt.i c;
        private Object d;
        private long e;
        private long f;
        private Object g;
        private long h;
        private long i;
        private gt.l j;
        private gt.a k;
        private gt.x l;
        private int m;
        private int n;
        private gt.f o;
        private gt.r p;
        private Object q;
        private Object r;
        private gt.p s;
        private Object t;
        private Object u;
        private Object v;
        private List w;

        static a k()
        {
            return new a();
        }

        private a l()
        {
            a a1 = new a();
            gt.c c1 = m();
            if (c1 == gt.c.c())
            {
                return a1;
            }
            if (c1.e())
            {
                a1.a(c1.f());
            }
            if (c1.g())
            {
                a1.b = a1.b | 2;
                a1.d = gt.c.a(c1);
            }
            if (c1.i())
            {
                a1.a(c1.j());
            }
            if (c1.k())
            {
                a1.b(c1.l());
            }
            if (c1.m())
            {
                a1.b = a1.b | 0x10;
                a1.g = gt.c.b(c1);
            }
            if (c1.o())
            {
                a1.c(c1.p());
            }
            if (c1.q())
            {
                a1.d(c1.r());
            }
            Object obj;
            if (c1.s())
            {
                obj = c1.t();
                int i1;
                if ((a1.b & 0x80) == 128 && a1.j != gt.l.c())
                {
                    a1.j = gt.l.a(a1.j).a(((gt.l) (obj))).e();
                } else
                {
                    a1.j = ((gt.l) (obj));
                }
                a1.b = a1.b | 0x80;
            }
            if (c1.u())
            {
                obj = c1.v();
                if ((a1.b & 0x100) == 256 && a1.k != gt.a.c())
                {
                    a1.k = gt.a.a(a1.k).a(((gt.a) (obj))).e();
                } else
                {
                    a1.k = ((gt.a) (obj));
                }
                a1.b = a1.b | 0x100;
            }
            if (c1.w())
            {
                obj = c1.x();
                if ((a1.b & 0x200) == 512 && a1.l != gt.x.c())
                {
                    a1.l = gt.x.a(a1.l).a(((gt.x) (obj))).e();
                } else
                {
                    a1.l = ((gt.x) (obj));
                }
                a1.b = a1.b | 0x200;
            }
            if (c1.y())
            {
                i1 = c1.z();
                a1.b = a1.b | 0x400;
                a1.m = i1;
            }
            if (c1.A())
            {
                a1.a(c1.B());
            }
            if (c1.C())
            {
                obj = c1.D();
                if ((a1.b & 0x1000) == 4096 && a1.o != gt.f.c())
                {
                    a1.o = gt.f.a(a1.o).a(((gt.f) (obj))).e();
                } else
                {
                    a1.o = ((gt.f) (obj));
                }
                a1.b = a1.b | 0x1000;
            }
            if (c1.E())
            {
                obj = c1.F();
                if ((a1.b & 0x2000) == 8192 && a1.p != gt.r.c())
                {
                    a1.p = gt.r.a(a1.p).a(((gt.r) (obj))).e();
                } else
                {
                    a1.p = ((gt.r) (obj));
                }
                a1.b = a1.b | 0x2000;
            }
            if (c1.G())
            {
                a1.b = a1.b | 0x4000;
                a1.q = gt.c.c(c1);
            }
            if (c1.I())
            {
                a1.b = a1.b | 0x8000;
                a1.r = gt.c.d(c1);
            }
            if (c1.K())
            {
                obj = c1.L();
                if ((a1.b & 0x10000) == 0x10000 && a1.s != gt.p.c())
                {
                    a1.s = gt.p.a(a1.s).a(((gt.p) (obj))).f();
                } else
                {
                    a1.s = ((gt.p) (obj));
                }
                a1.b = a1.b | 0x10000;
            }
            if (c1.M())
            {
                a1.b = a1.b | 0x20000;
                a1.t = gt.c.e(c1);
            }
            if (c1.O())
            {
                a1.b = a1.b | 0x40000;
                a1.u = gt.c.f(c1);
            }
            if (c1.Q())
            {
                a1.b = a1.b | 0x80000;
                a1.v = gt.c.g(c1);
            }
            if (!gt.c.h(c1).isEmpty())
            {
                if (a1.w.isEmpty())
                {
                    a1.w = gt.c.h(c1);
                    a1.b = a1.b & 0xffefffff;
                } else
                {
                    a1.n();
                    a1.w.addAll(gt.c.h(c1));
                }
            }
            a1.a = ((ds.a) (a1)).a.a(gt.c.i(c1));
            return a1;
        }

        private gt.c m()
        {
            gt.c c1 = new gt.c(this, (byte)0);
            int k1 = b;
            int j1 = 0;
            if ((k1 & 1) == 1)
            {
                j1 = 1;
            }
            gt.c.a(c1, c);
            int i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            gt.c.a(c1, d);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            gt.c.a(c1, e);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            gt.c.b(c1, f);
            j1 = i1;
            if ((k1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            gt.c.b(c1, g);
            i1 = j1;
            if ((k1 & 0x20) == 32)
            {
                i1 = j1 | 0x20;
            }
            gt.c.c(c1, h);
            j1 = i1;
            if ((k1 & 0x40) == 64)
            {
                j1 = i1 | 0x40;
            }
            gt.c.d(c1, i);
            i1 = j1;
            if ((k1 & 0x80) == 128)
            {
                i1 = j1 | 0x80;
            }
            gt.c.a(c1, j);
            j1 = i1;
            if ((k1 & 0x100) == 256)
            {
                j1 = i1 | 0x100;
            }
            gt.c.a(c1, k);
            i1 = j1;
            if ((k1 & 0x200) == 512)
            {
                i1 = j1 | 0x200;
            }
            gt.c.a(c1, l);
            j1 = i1;
            if ((k1 & 0x400) == 1024)
            {
                j1 = i1 | 0x400;
            }
            gt.c.a(c1, m);
            i1 = j1;
            if ((k1 & 0x800) == 2048)
            {
                i1 = j1 | 0x800;
            }
            gt.c.b(c1, n);
            j1 = i1;
            if ((k1 & 0x1000) == 4096)
            {
                j1 = i1 | 0x1000;
            }
            gt.c.a(c1, o);
            i1 = j1;
            if ((k1 & 0x2000) == 8192)
            {
                i1 = j1 | 0x2000;
            }
            gt.c.a(c1, p);
            j1 = i1;
            if ((k1 & 0x4000) == 16384)
            {
                j1 = i1 | 0x4000;
            }
            gt.c.c(c1, q);
            i1 = j1;
            if ((k1 & 0x8000) == 32768)
            {
                i1 = j1 | 0x8000;
            }
            gt.c.d(c1, r);
            j1 = i1;
            if ((k1 & 0x10000) == 0x10000)
            {
                j1 = i1 | 0x10000;
            }
            gt.c.a(c1, s);
            i1 = j1;
            if ((k1 & 0x20000) == 0x20000)
            {
                i1 = j1 | 0x20000;
            }
            gt.c.e(c1, t);
            j1 = i1;
            if ((k1 & 0x40000) == 0x40000)
            {
                j1 = i1 | 0x40000;
            }
            gt.c.f(c1, u);
            i1 = j1;
            if ((k1 & 0x80000) == 0x80000)
            {
                i1 = j1 | 0x80000;
            }
            gt.c.g(c1, v);
            if ((b & 0x100000) == 0x100000)
            {
                w = Collections.unmodifiableList(w);
                b = b & 0xffefffff;
            }
            gt.c.a(c1, w);
            gt.c.c(c1, i1);
            return c1;
        }

        private void n()
        {
            if ((b & 0x100000) != 0x100000)
            {
                w = new ArrayList(w);
                b = b | 0x100000;
            }
        }

        public final dl.a a()
        {
            return l();
        }

        public final a a(int i1)
        {
            b = b | 0x800;
            n = i1;
            return this;
        }

        public final a a(long l1)
        {
            b = b | 4;
            e = l1;
            return this;
        }

        public final a a(gt.a a1)
        {
            if (a1 == null)
            {
                throw new NullPointerException();
            } else
            {
                k = a1;
                b = b | 0x100;
                return this;
            }
        }

        public final a a(gt.f.a a1)
        {
            a1 = a1.e();
            if (!a1.d())
            {
                throw new ec();
            } else
            {
                o = a1;
                b = b | 0x1000;
                return this;
            }
        }

        public final a a(gt.i i1)
        {
            if (i1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 1;
                c = i1;
                return this;
            }
        }

        public final a a(gt.j.a a1)
        {
            n();
            List list = w;
            a1 = a1.e();
            if (!a1.d())
            {
                throw new ec();
            } else
            {
                list.add(a1);
                return this;
            }
        }

        public final a a(gt.l l1)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                j = l1;
                b = b | 0x80;
                return this;
            }
        }

        public final a a(gt.p.a a1)
        {
            s = a1.e();
            b = b | 0x10000;
            return this;
        }

        public final a a(gt.p p1)
        {
            if (p1 == null)
            {
                throw new NullPointerException();
            } else
            {
                s = p1;
                b = b | 0x10000;
                return this;
            }
        }

        public final a a(gt.r.a a1)
        {
            a1 = a1.e();
            if (!a1.d())
            {
                throw new ec();
            } else
            {
                p = a1;
                b = b | 0x2000;
                return this;
            }
        }

        public final a a(gt.x x1)
        {
            if (x1 == null)
            {
                throw new NullPointerException();
            } else
            {
                l = x1;
                b = b | 0x200;
                return this;
            }
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

        public final ds.a b()
        {
            return l();
        }

        public final a b(long l1)
        {
            b = b | 8;
            f = l1;
            return this;
        }

        public final a b(String s1)
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

        public final a c(long l1)
        {
            b = b | 0x20;
            h = l1;
            return this;
        }

        public final a c(String s1)
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

        public final Object clone()
        {
            return l();
        }

        public final a d(long l1)
        {
            b = b | 0x40;
            i = l1;
            return this;
        }

        public final a d(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x20000;
                t = s1;
                return this;
            }
        }

        public final boolean d()
        {
            boolean flag;
            if ((b & 1) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            int i1;
            if ((b & 2) == 2)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                if ((b & 4) == 4)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                if (i1 != 0)
                {
                    if ((b & 0x200) == 512)
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = 0;
                    }
                    if (i1 == 0 || l.d())
                    {
                        if ((b & 0x1000) == 4096)
                        {
                            i1 = 1;
                        } else
                        {
                            i1 = 0;
                        }
                        if (i1 == 0 || o.d())
                        {
                            if ((b & 0x2000) == 8192)
                            {
                                i1 = 1;
                            } else
                            {
                                i1 = 0;
                            }
                            if (i1 == 0 || p.d())
                            {
                                i1 = 0;
label0:
                                do
                                {
label1:
                                    {
                                        if (i1 >= w.size())
                                        {
                                            break label1;
                                        }
                                        if (!((gt.j)w.get(i1)).d())
                                        {
                                            break label0;
                                        }
                                        i1++;
                                    }
                                } while (true);
                            }
                        }
                    }
                }
            }
            if (true) goto _L1; else goto _L3
_L3:
            return true;
        }

        public final a e(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x40000;
                u = s1;
                return this;
            }
        }

        public final gt.c e()
        {
            gt.c c1 = m();
            if (!c1.d())
            {
                throw new ec();
            } else
            {
                return c1;
            }
        }

        public final a f(String s1)
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

        public final gt.i f()
        {
            return c;
        }

        public final String g()
        {
            Object obj = d;
            if (!(obj instanceof String))
            {
                obj = (do)obj;
                String s1 = ((do) (obj)).f();
                if (((do) (obj)).g())
                {
                    d = s1;
                }
                return s1;
            } else
            {
                return (String)obj;
            }
        }

        public final long h()
        {
            return e;
        }

        public final boolean i()
        {
            return (b & 0x20000) == 0x20000;
        }

        public final String j()
        {
            Object obj = t;
            if (!(obj instanceof String))
            {
                obj = (do)obj;
                String s1 = ((do) (obj)).f();
                if (((do) (obj)).g())
                {
                    t = s1;
                }
                return s1;
            } else
            {
                return (String)obj;
            }
        }

        private a()
        {
            c = gt.i.a;
            d = "";
            g = "";
            j = gt.l.c();
            k = gt.a.c();
            l = gt.x.c();
            o = gt.f.c();
            p = gt.r.c();
            q = "";
            r = "";
            s = gt.p.c();
            t = "";
            u = "";
            v = "";
            w = Collections.emptyList();
        }
    }


    public static dz b = new dm() {

        public final Object a(dp dp1, dr dr)
        {
            return new gt.c(dp1, dr, (byte)0);
        }

    };
    private static final <init> c;
    private byte A;
    private int B;
    private final do d;
    private int e;
    private <init> f;
    private Object g;
    private long h;
    private long i;
    private Object j;
    private long k;
    private long l;
    private <init> m;
    private <init> n;
    private <init> o;
    private int p;
    private int q;
    private <init> r;
    private <init> s;
    private Object t;
    private Object u;
    private <init> v;
    private Object w;
    private Object x;
    private Object y;
    private List z;

    public static a U()
    {
        return a.k();
    }

    private do V()
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

    private do W()
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

    private do X()
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

    private do Y()
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

    private do Z()
    {
        Object obj = w;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            w = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    static int a(w w1, int i1)
    {
        w1.p = i1;
        return i1;
    }

    static long a(p p1, long l1)
    {
        p1.h = l1;
        return l1;
    }

    static h a(h h1, h h2)
    {
        h1.n = h2;
        return h2;
    }

    static n a(n n1, n n2)
    {
        n1.r = n2;
        return n2;
    }

    static r a(r r1, r r2)
    {
        r1.f = r2;
        return r2;
    }

    static f a(f f1, f f2)
    {
        f1.m = f2;
        return f2;
    }

    static m a(m m1, m m2)
    {
        m1.v = m2;
        return m2;
    }

    static v a(v v1, v v2)
    {
        v1.s = v2;
        return v2;
    }

    static s a(s s1, s s2)
    {
        s1.o = s2;
        return s2;
    }

    static Object a(o o1)
    {
        return o1.g;
    }

    static Object a(g g1, Object obj)
    {
        g1.g = obj;
        return obj;
    }

    static List a(g g1, List list)
    {
        g1.z = list;
        return list;
    }

    private do aa()
    {
        Object obj = x;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            x = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do ab()
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

    private void ac()
    {
        f = a;
        g = "";
        h = 0L;
        i = 0L;
        j = "";
        k = 0L;
        l = 0L;
        m = c();
        n = c();
        o = c();
        p = 0;
        q = 0;
        r = c();
        s = c();
        t = "";
        u = "";
        v = c();
        w = "";
        x = "";
        y = "";
        z = Collections.emptyList();
    }

    static int b(tyList tylist, int i1)
    {
        tylist.q = i1;
        return i1;
    }

    static long b(q q1, long l1)
    {
        q1.i = l1;
        return l1;
    }

    static Object b(i i1)
    {
        return i1.j;
    }

    static Object b(j j1, Object obj)
    {
        j1.j = obj;
        return obj;
    }

    static int c(j j1, int i1)
    {
        j1.e = i1;
        return i1;
    }

    static long c(e e1, long l1)
    {
        e1.k = l1;
        return l1;
    }

    public static k c()
    {
        return c;
    }

    static Object c(c c1)
    {
        return c1.t;
    }

    static Object c(t t1, Object obj)
    {
        t1.t = obj;
        return obj;
    }

    static long d(t t1, long l1)
    {
        t1.l = l1;
        return l1;
    }

    static Object d(l l1)
    {
        return l1.u;
    }

    static Object d(u u1, Object obj)
    {
        u1.u = obj;
        return obj;
    }

    static Object e(u u1)
    {
        return u1.w;
    }

    static Object e(w w1, Object obj)
    {
        w1.w = obj;
        return obj;
    }

    static Object f(w w1)
    {
        return w1.x;
    }

    static Object f(x x1, Object obj)
    {
        x1.x = obj;
        return obj;
    }

    static Object g(x x1)
    {
        return x1.y;
    }

    static Object g(y y1, Object obj)
    {
        y1.y = obj;
        return obj;
    }

    static List h(y y1)
    {
        return y1.z;
    }

    static do i(z z1)
    {
        return z1.d;
    }

    public final boolean A()
    {
        return (e & 0x800) == 2048;
    }

    public final int B()
    {
        return q;
    }

    public final boolean C()
    {
        return (e & 0x1000) == 4096;
    }

    public final e D()
    {
        return r;
    }

    public final boolean E()
    {
        return (e & 0x2000) == 8192;
    }

    public final e F()
    {
        return s;
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

    public final e L()
    {
        return v;
    }

    public final boolean M()
    {
        return (e & 0x20000) == 0x20000;
    }

    public final String N()
    {
        Object obj = w;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            w = s1;
        }
        return s1;
    }

    public final boolean O()
    {
        return (e & 0x40000) == 0x40000;
    }

    public final String P()
    {
        Object obj = x;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            x = s1;
        }
        return s1;
    }

    public final boolean Q()
    {
        return (e & 0x80000) == 0x80000;
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

    public final List S()
    {
        return z;
    }

    public final int T()
    {
        return z.size();
    }

    public final void a(dq dq1)
    {
        b();
        if ((e & 1) == 1)
        {
            dq1.a(f.a());
        }
        if ((e & 2) == 2)
        {
            dq1.a(2, V());
        }
        if ((e & 4) == 4)
        {
            dq1.a(3, h);
        }
        if ((e & 0x40) == 64)
        {
            dq1.a(4, l);
        }
        if ((e & 0x80) == 128)
        {
            dq1.a(5, m);
        }
        if ((e & 0x100) == 256)
        {
            dq1.a(6, n);
        }
        if ((e & 0x200) == 512)
        {
            dq1.a(7, o);
        }
        if ((e & 0x400) == 1024)
        {
            dq1.a(8, p);
        }
        if ((e & 0x800) == 2048)
        {
            dq1.a(9, q);
        }
        if ((e & 0x1000) == 4096)
        {
            dq1.a(10, r);
        }
        if ((e & 0x2000) == 8192)
        {
            dq1.a(11, s);
        }
        if ((e & 0x4000) == 16384)
        {
            dq1.a(12, X());
        }
        if ((e & 0x8000) == 32768)
        {
            dq1.a(13, Y());
        }
        if ((e & 0x20000) == 0x20000)
        {
            dq1.a(14, Z());
        }
        if ((e & 0x40000) == 0x40000)
        {
            dq1.a(15, aa());
        }
        if ((e & 0x80000) == 0x80000)
        {
            dq1.a(16, ab());
        }
        for (int i1 = 0; i1 < z.size(); i1++)
        {
            dq1.a(17, (dx)z.get(i1));
        }

        if ((e & 0x10000) == 0x10000)
        {
            dq1.a(18, v);
        }
        if ((e & 8) == 8)
        {
            dq1.a(19, i);
        }
        if ((e & 0x10) == 16)
        {
            dq1.a(20, W());
        }
        if ((e & 0x20) == 32)
        {
            dq1.a(21, k);
        }
        dq1.b(d);
    }

    public final int b()
    {
        boolean flag = false;
        int i1 = B;
        if (i1 != -1)
        {
            return i1;
        }
        int j1;
        if ((e & 1) == 1)
        {
            j1 = dq.b(f.a()) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if ((e & 2) == 2)
        {
            i1 = j1 + dq.b(2, V());
        }
        j1 = i1;
        if ((e & 4) == 4)
        {
            j1 = i1 + dq.b(3, h);
        }
        i1 = j1;
        if ((e & 0x40) == 64)
        {
            i1 = j1 + dq.b(4, l);
        }
        j1 = i1;
        if ((e & 0x80) == 128)
        {
            j1 = i1 + dq.b(5, m);
        }
        i1 = j1;
        if ((e & 0x100) == 256)
        {
            i1 = j1 + dq.b(6, n);
        }
        j1 = i1;
        if ((e & 0x200) == 512)
        {
            j1 = i1 + dq.b(7, o);
        }
        i1 = j1;
        if ((e & 0x400) == 1024)
        {
            i1 = j1 + dq.b(8, p);
        }
        j1 = i1;
        if ((e & 0x800) == 2048)
        {
            j1 = i1 + dq.b(9, q);
        }
        i1 = j1;
        if ((e & 0x1000) == 4096)
        {
            i1 = j1 + dq.b(10, r);
        }
        j1 = i1;
        if ((e & 0x2000) == 8192)
        {
            j1 = i1 + dq.b(11, s);
        }
        i1 = j1;
        if ((e & 0x4000) == 16384)
        {
            i1 = j1 + dq.b(12, X());
        }
        j1 = i1;
        if ((e & 0x8000) == 32768)
        {
            j1 = i1 + dq.b(13, Y());
        }
        i1 = j1;
        if ((e & 0x20000) == 0x20000)
        {
            i1 = j1 + dq.b(14, Z());
        }
        j1 = i1;
        if ((e & 0x40000) == 0x40000)
        {
            j1 = i1 + dq.b(15, aa());
        }
        i1 = j1;
        if ((e & 0x80000) == 0x80000)
        {
            i1 = j1 + dq.b(16, ab());
        }
        for (j1 = ((flag) ? 1 : 0); j1 < z.size();)
        {
            int k1 = dq.b(17, (dx)z.get(j1));
            j1++;
            i1 = k1 + i1;
        }

        j1 = i1;
        if ((e & 0x10000) == 0x10000)
        {
            j1 = i1 + dq.b(18, v);
        }
        i1 = j1;
        if ((e & 8) == 8)
        {
            i1 = j1 + dq.b(19, i);
        }
        j1 = i1;
        if ((e & 0x10) == 16)
        {
            j1 = i1 + dq.b(20, W());
        }
        i1 = j1;
        if ((e & 0x20) == 32)
        {
            i1 = j1 + dq.b(21, k);
        }
        i1 = d.a() + i1;
        B = i1;
        return i1;
    }

    public final boolean d()
    {
        boolean flag = false;
        byte byte0 = A;
        if (byte0 == 1)
        {
            flag = true;
        } else
        if (byte0 != 0)
        {
            if (!e())
            {
                A = 0;
                return false;
            }
            if (!g())
            {
                A = 0;
                return false;
            }
            if (!i())
            {
                A = 0;
                return false;
            }
            if (w() && !o.d())
            {
                A = 0;
                return false;
            }
            if (C() && !r.d())
            {
                A = 0;
                return false;
            }
            if (E() && !s.d())
            {
                A = 0;
                return false;
            }
            for (int i1 = 0; i1 < T(); i1++)
            {
                if (!((T)z.get(i1)).d())
                {
                    A = 0;
                    return false;
                }
            }

            A = 1;
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
                if (flag && m.equals(((equals) (obj)).m))
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
                if (flag && n.equals(((equals) (obj)).n))
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
                if (flag && o.equals(((equals) (obj)).o))
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
                if (flag && q == ((q) (obj)).q)
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
                if (flag && r.equals(((equals) (obj)).r))
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
                if (flag && s.equals(((equals) (obj)).s))
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
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (K())
            {
                if (flag && v.equals(((equals) (obj)).v))
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
                if (flag && N().equals(((N) (obj)).N()))
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
                if (flag && P().equals(((P) (obj)).P()))
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
            if (!flag1 || !z.equals(((z) (obj)).z))
            {
                return false;
            }
        }
        return true;
    }

    public final z f()
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
        int j1 = com/tapjoy/internal/gt$c.hashCode() + 779;
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
            i1 = (j1 * 37 + 3) * 53 + dt.a(h);
        }
        j1 = i1;
        if (k())
        {
            j1 = (i1 * 37 + 19) * 53 + dt.a(i);
        }
        i1 = j1;
        if (m())
        {
            i1 = (j1 * 37 + 20) * 53 + n().hashCode();
        }
        j1 = i1;
        if (o())
        {
            j1 = (i1 * 37 + 21) * 53 + dt.a(k);
        }
        i1 = j1;
        if (q())
        {
            i1 = (j1 * 37 + 4) * 53 + dt.a(l);
        }
        j1 = i1;
        if (s())
        {
            j1 = (i1 * 37 + 5) * 53 + m.hashCode();
        }
        i1 = j1;
        if (u())
        {
            i1 = (j1 * 37 + 6) * 53 + n.hashCode();
        }
        j1 = i1;
        if (w())
        {
            j1 = (i1 * 37 + 7) * 53 + o.hashCode();
        }
        i1 = j1;
        if (y())
        {
            i1 = (j1 * 37 + 8) * 53 + p;
        }
        j1 = i1;
        if (A())
        {
            j1 = (i1 * 37 + 9) * 53 + q;
        }
        i1 = j1;
        if (C())
        {
            i1 = (j1 * 37 + 10) * 53 + r.hashCode();
        }
        j1 = i1;
        if (E())
        {
            j1 = (i1 * 37 + 11) * 53 + s.hashCode();
        }
        i1 = j1;
        if (G())
        {
            i1 = (j1 * 37 + 12) * 53 + H().hashCode();
        }
        j1 = i1;
        if (I())
        {
            j1 = (i1 * 37 + 13) * 53 + J().hashCode();
        }
        i1 = j1;
        if (K())
        {
            i1 = (j1 * 37 + 18) * 53 + v.hashCode();
        }
        j1 = i1;
        if (M())
        {
            j1 = (i1 * 37 + 14) * 53 + N().hashCode();
        }
        i1 = j1;
        if (O())
        {
            i1 = (j1 * 37 + 15) * 53 + P().hashCode();
        }
        j1 = i1;
        if (Q())
        {
            j1 = (i1 * 37 + 16) * 53 + R().hashCode();
        }
        i1 = j1;
        if (T() > 0)
        {
            i1 = (j1 * 37 + 17) * 53 + z.hashCode();
        }
        i1 = i1 * 29 + d.hashCode();
        a = i1;
        return i1;
    }

    public final boolean i()
    {
        return (e & 4) == 4;
    }

    public final long j()
    {
        return h;
    }

    public final boolean k()
    {
        return (e & 8) == 8;
    }

    public final long l()
    {
        return i;
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

    public final long p()
    {
        return k;
    }

    public final boolean q()
    {
        return (e & 0x40) == 64;
    }

    public final long r()
    {
        return l;
    }

    public final boolean s()
    {
        return (e & 0x80) == 128;
    }

    public final e t()
    {
        return m;
    }

    public final boolean u()
    {
        return (e & 0x100) == 256;
    }

    public final e v()
    {
        return n;
    }

    public final boolean w()
    {
        return (e & 0x200) == 512;
    }

    public final e x()
    {
        return o;
    }

    public final boolean y()
    {
        return (e & 0x400) == 1024;
    }

    public final int z()
    {
        return p;
    }

    static 
    {
        p p1 = new <init>();
        c = p1;
        p1.ac();
    }

    private _cls1()
    {
        A = -1;
        B = -1;
        d = do.a;
    }

    private a(dp dp1, dr dr)
    {
        d d1;
        dq dq1;
        int i1;
        boolean flag;
        A = -1;
        B = -1;
        ac();
        d1 = com.tapjoy.internal.do.h();
        dq1 = dq.a(d1, 4096);
        flag = false;
        i1 = 0;
_L62:
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
        JVM INSTR lookupswitch 22: default 2236
    //                   0: 2239
    //                   8: 281
    //                   18: 474
    //                   24: 533
    //                   32: 578
    //                   42: 624
    //                   50: 769
    //                   58: 914
    //                   64: 1059
    //                   72: 1106
    //                   82: 1153
    //                   90: 1298
    //                   98: 1443
    //                   106: 1504
    //                   114: 1564
    //                   122: 1624
    //                   130: 1684
    //                   138: 1744
    //                   146: 1825
    //                   152: 1970
    //                   162: 2016
    //                   168: 2076;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25
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
        int j2 = dp1.e();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        Object obj = a(j2);
        if (obj != null) goto _L27; else goto _L26
_L26:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        dq1.e(j1);
        l1 = i1;
        k1 = i1;
        i2 = i1;
        dq1.e(j2);
        continue; /* Loop/switch isn't completed */
        dp1;
        k1 = l1;
        throw dp1.a(this);
        dp1;
        if ((k1 & 0x100000) == 0x100000)
        {
            z = Collections.unmodifiableList(z);
        }
        dq1.a();
        d = d1.a();
_L54:
        throw dp1;
_L27:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 1;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        f = ((f) (obj));
        continue; /* Loop/switch isn't completed */
        dp1;
        k1 = i2;
        throw (new du(dp1.getMessage())).a(this);
_L6:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 2;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        g = obj;
        continue; /* Loop/switch isn't completed */
_L7:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 4;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        h = dp1.f();
        continue; /* Loop/switch isn't completed */
_L8:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x40;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        l = dp1.f();
        continue; /* Loop/switch isn't completed */
_L9:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        if ((e & 0x80) != 128) goto _L29; else goto _L28
_L28:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = m.N();
_L60:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        m = (m)dp1.a(b, dr);
        if (obj == null) goto _L31; else goto _L30
_L30:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        ((a) (obj)).a(m);
        l1 = i1;
        k1 = i1;
        i2 = i1;
        m = ((a) (obj)).e();
_L31:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x80;
        continue; /* Loop/switch isn't completed */
_L10:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        if ((e & 0x100) != 256) goto _L33; else goto _L32
_L32:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = n.p();
_L59:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        n = (n)dp1.a(b, dr);
        if (obj == null) goto _L35; else goto _L34
_L34:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        ((a) (obj)).a(n);
        l1 = i1;
        k1 = i1;
        i2 = i1;
        n = ((a) (obj)).e();
_L35:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x100;
        continue; /* Loop/switch isn't completed */
_L11:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        if ((e & 0x200) != 512) goto _L37; else goto _L36
_L36:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = o.ad();
_L58:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        o = (o)dp1.a(b, dr);
        if (obj == null) goto _L39; else goto _L38
_L38:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        ((a) (obj)).a(o);
        l1 = i1;
        k1 = i1;
        i2 = i1;
        o = ((a) (obj)).e();
_L39:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x200;
        continue; /* Loop/switch isn't completed */
_L12:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x400;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        p = dp1.e();
        continue; /* Loop/switch isn't completed */
_L13:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x800;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        q = dp1.e();
        continue; /* Loop/switch isn't completed */
_L14:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        if ((e & 0x1000) != 4096) goto _L41; else goto _L40
_L40:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = r.l();
_L57:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        r = (r)dp1.a(b, dr);
        if (obj == null) goto _L43; else goto _L42
_L42:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        ((a) (obj)).a(r);
        l1 = i1;
        k1 = i1;
        i2 = i1;
        r = ((a) (obj)).e();
_L43:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x1000;
        continue; /* Loop/switch isn't completed */
_L15:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        if ((e & 0x2000) != 8192) goto _L45; else goto _L44
_L44:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = s.H();
_L56:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        s = (s)dp1.a(b, dr);
        if (obj == null) goto _L47; else goto _L46
_L46:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        ((a) (obj)).a(s);
        l1 = i1;
        k1 = i1;
        i2 = i1;
        s = ((a) (obj)).e();
_L47:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x2000;
        continue; /* Loop/switch isn't completed */
_L16:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x4000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        t = obj;
        continue; /* Loop/switch isn't completed */
_L17:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x8000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        u = obj;
        continue; /* Loop/switch isn't completed */
_L18:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x20000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        w = obj;
        continue; /* Loop/switch isn't completed */
_L19:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x40000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        x = obj;
        continue; /* Loop/switch isn't completed */
_L20:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x80000;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        y = obj;
        continue; /* Loop/switch isn't completed */
_L21:
        j1 = i1;
        if ((i1 & 0x100000) == 0x100000) goto _L49; else goto _L48
_L48:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        z = new ArrayList();
        j1 = i1 | 0x100000;
_L49:
        l1 = j1;
        k1 = j1;
        i2 = j1;
        z.add(dp1.a(b, dr));
        i1 = j1;
        continue; /* Loop/switch isn't completed */
_L22:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        if ((e & 0x10000) != 0x10000) goto _L51; else goto _L50
_L50:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = v.l();
_L55:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        v = (v)dp1.a(b, dr);
        if (obj == null) goto _L53; else goto _L52
_L52:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        ((a) (obj)).a(v);
        l1 = i1;
        k1 = i1;
        i2 = i1;
        v = ((a) (obj)).f();
_L53:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x10000;
        continue; /* Loop/switch isn't completed */
_L23:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 8;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        i = dp1.b();
        continue; /* Loop/switch isn't completed */
_L24:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        obj = dp1.d();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x10;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        j = obj;
        continue; /* Loop/switch isn't completed */
_L25:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        e = e | 0x20;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        k = dp1.b();
        continue; /* Loop/switch isn't completed */
_L2:
        if ((i1 & 0x100000) == 0x100000)
        {
            z = Collections.unmodifiableList(z);
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
          goto _L54
        dp1;
        d = d1.a();
        throw dp1;
_L51:
        obj = null;
          goto _L55
_L45:
        obj = null;
          goto _L56
_L41:
        obj = null;
          goto _L57
_L37:
        obj = null;
          goto _L58
_L33:
        obj = null;
          goto _L59
_L29:
        obj = null;
          goto _L60
_L4:
        flag = true;
        if (true) goto _L62; else goto _L61
_L61:
    }

    a(dp dp1, dr dr, byte byte0)
    {
        this(dp1, dr);
    }

    private <init>(<init> <init>1)
    {
        super((byte)0);
        A = -1;
        B = -1;
        d = <init>1.c();
    }

    c(c c1, byte byte0)
    {
        this(c1);
    }
}
