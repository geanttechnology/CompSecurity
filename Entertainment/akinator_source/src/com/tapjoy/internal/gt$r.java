// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;

// Referenced classes of package com.tapjoy.internal:
//            ds, gt, do, du, 
//            dq, dp, dt, dz, 
//            dm, dr

public static final class <init> extends ds
    implements <init>
{
    public static final class a extends ds.a
        implements gt.s
    {

        private int b;
        private Object c;
        private int d;
        private double e;
        private Object f;
        private Object g;
        private Object h;
        private Object i;
        private Object j;
        private int k;
        private long l;
        private Object m;
        private Object n;
        private Object o;
        private Object p;

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

        public final a a(double d1)
        {
            b = b | 4;
            e = d1;
            return this;
        }

        public final a a(gt.r r1)
        {
            if (r1 == gt.r.c())
            {
                return this;
            }
            if (r1.e())
            {
                b = b | 1;
                c = gt.r.b(r1);
            }
            if (r1.g())
            {
                int i1 = r1.h();
                b = b | 2;
                d = i1;
            }
            if (r1.i())
            {
                a(r1.j());
            }
            if (r1.k())
            {
                b = b | 8;
                f = gt.r.c(r1);
            }
            if (r1.m())
            {
                b = b | 0x10;
                g = gt.r.d(r1);
            }
            if (r1.o())
            {
                b = b | 0x20;
                h = gt.r.e(r1);
            }
            if (r1.q())
            {
                b = b | 0x40;
                i = gt.r.f(r1);
            }
            if (r1.s())
            {
                b = b | 0x80;
                j = gt.r.g(r1);
            }
            if (r1.u())
            {
                int j1 = r1.v();
                b = b | 0x100;
                k = j1;
            }
            if (r1.w())
            {
                long l1 = r1.x();
                b = b | 0x200;
                l = l1;
            }
            if (r1.y())
            {
                b = b | 0x400;
                m = gt.r.h(r1);
            }
            if (r1.A())
            {
                b = b | 0x800;
                n = gt.r.i(r1);
            }
            if (r1.C())
            {
                b = b | 0x1000;
                o = gt.r.j(r1);
            }
            if (r1.E())
            {
                b = b | 0x2000;
                p = gt.r.k(r1);
            }
            super.a = super.a.a(gt.r.l(r1));
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

        public final a b(String s1)
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

        public final a c(String s1)
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
                b = b | 0x1000;
                o = s1;
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
            return flag;
        }

        public final a e(String s1)
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

        public final gt.r e()
        {
            int j1 = 1;
            gt.r r1 = new gt.r(this, (byte)0);
            int k1 = b;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            gt.r.a(r1, c);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            gt.r.a(r1, d);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            gt.r.a(r1, e);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            gt.r.b(r1, f);
            j1 = i1;
            if ((k1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            gt.r.c(r1, g);
            i1 = j1;
            if ((k1 & 0x20) == 32)
            {
                i1 = j1 | 0x20;
            }
            gt.r.d(r1, h);
            j1 = i1;
            if ((k1 & 0x40) == 64)
            {
                j1 = i1 | 0x40;
            }
            gt.r.e(r1, i);
            i1 = j1;
            if ((k1 & 0x80) == 128)
            {
                i1 = j1 | 0x80;
            }
            gt.r.f(r1, j);
            j1 = i1;
            if ((k1 & 0x100) == 256)
            {
                j1 = i1 | 0x100;
            }
            gt.r.b(r1, k);
            i1 = j1;
            if ((k1 & 0x200) == 512)
            {
                i1 = j1 | 0x200;
            }
            gt.r.a(r1, l);
            j1 = i1;
            if ((k1 & 0x400) == 1024)
            {
                j1 = i1 | 0x400;
            }
            gt.r.g(r1, m);
            i1 = j1;
            if ((k1 & 0x800) == 2048)
            {
                i1 = j1 | 0x800;
            }
            gt.r.h(r1, n);
            j1 = i1;
            if ((k1 & 0x1000) == 4096)
            {
                j1 = i1 | 0x1000;
            }
            gt.r.i(r1, o);
            i1 = j1;
            if ((k1 & 0x2000) == 8192)
            {
                i1 = j1 | 0x2000;
            }
            gt.r.j(r1, p);
            gt.r.c(r1, i1);
            return r1;
        }

        private a()
        {
            c = "";
            d = 1;
            f = "";
            g = "";
            h = "";
            i = "";
            j = "";
            m = "";
            n = "";
            o = "";
            p = "";
        }
    }


    public static dz b = new dm() {

        public final Object a(dp dp1, dr dr)
        {
            return new gt.r(dp1, (byte)0);
        }

    };
    private static final <init> c;
    private final do d;
    private int e;
    private Object f;
    private int g;
    private double h;
    private Object i;
    private Object j;
    private Object k;
    private Object l;
    private Object m;
    private int n;
    private long o;
    private Object p;
    private Object q;
    private Object r;
    private Object s;
    private byte t;
    private int u;

    public static a G()
    {
        return a.f();
    }

    private do I()
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

    private do J()
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

    private do K()
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

    private do L()
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

    private do M()
    {
        Object obj = l;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            l = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do N()
    {
        Object obj = m;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            m = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do O()
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

    private do P()
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

    private do Q()
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

    private do R()
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

    private void S()
    {
        f = "";
        g = 1;
        h = 0.0D;
        i = "";
        j = "";
        k = "";
        l = "";
        m = "";
        n = 0;
        o = 0L;
        p = "";
        q = "";
        r = "";
        s = "";
    }

    static double a(s s1, double d1)
    {
        s1.h = d1;
        return d1;
    }

    static int a(h h1, int i1)
    {
        h1.g = i1;
        return i1;
    }

    static long a(g g1, long l1)
    {
        g1.o = l1;
        return l1;
    }

    public static a a(o o1)
    {
        return a.f().a(o1);
    }

    static Object a(a.a a1, Object obj)
    {
        a1.f = obj;
        return obj;
    }

    static int b(f f1, int i1)
    {
        f1.n = i1;
        return i1;
    }

    static Object b(n n1)
    {
        return n1.f;
    }

    static Object b(f f1, Object obj)
    {
        f1.i = obj;
        return obj;
    }

    static int c(i i1, int j1)
    {
        i1.e = j1;
        return j1;
    }

    public static e c()
    {
        return c;
    }

    static Object c(c c1)
    {
        return c1.i;
    }

    static Object c(i i1, Object obj)
    {
        i1.j = obj;
        return obj;
    }

    static Object d(j j1)
    {
        return j1.j;
    }

    static Object d(j j1, Object obj)
    {
        j1.k = obj;
        return obj;
    }

    static Object e(k k1)
    {
        return k1.k;
    }

    static Object e(k k1, Object obj)
    {
        k1.l = obj;
        return obj;
    }

    static Object f(l l1)
    {
        return l1.l;
    }

    static Object f(l l1, Object obj)
    {
        l1.m = obj;
        return obj;
    }

    static Object g(m m1)
    {
        return m1.m;
    }

    static Object g(m m1, Object obj)
    {
        m1.p = obj;
        return obj;
    }

    static Object h(p p1)
    {
        return p1.p;
    }

    static Object h(p p1, Object obj)
    {
        p1.q = obj;
        return obj;
    }

    static Object i(q q1)
    {
        return q1.q;
    }

    static Object i(q q1, Object obj)
    {
        q1.r = obj;
        return obj;
    }

    static Object j(r r1)
    {
        return r1.r;
    }

    static Object j(r r1, Object obj)
    {
        r1.s = obj;
        return obj;
    }

    static Object k(s s1)
    {
        return s1.s;
    }

    static do l(s s1)
    {
        return s1.d;
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

    public final a H()
    {
        return a.f().a(this);
    }

    public final void a(dq dq1)
    {
        b();
        if ((e & 1) == 1)
        {
            dq1.a(1, I());
        }
        if ((e & 2) == 2)
        {
            dq1.a(2, g);
        }
        if ((e & 4) == 4)
        {
            dq1.a(3, h);
        }
        if ((e & 8) == 8)
        {
            dq1.a(4, J());
        }
        if ((e & 0x10) == 16)
        {
            dq1.a(5, K());
        }
        if ((e & 0x20) == 32)
        {
            dq1.a(6, L());
        }
        if ((e & 0x40) == 64)
        {
            dq1.a(7, M());
        }
        if ((e & 0x80) == 128)
        {
            dq1.a(8, N());
        }
        if ((e & 0x100) == 256)
        {
            dq1.a(9, n);
        }
        if ((e & 0x200) == 512)
        {
            dq1.a(10, o);
        }
        if ((e & 0x400) == 1024)
        {
            dq1.a(11, O());
        }
        if ((e & 0x800) == 2048)
        {
            dq1.a(12, P());
        }
        if ((e & 0x1000) == 4096)
        {
            dq1.a(13, Q());
        }
        if ((e & 0x2000) == 8192)
        {
            dq1.a(14, R());
        }
        dq1.b(d);
    }

    public final int b()
    {
        int i1 = u;
        if (i1 != -1)
        {
            return i1;
        }
        int j1 = 0;
        if ((e & 1) == 1)
        {
            j1 = dq.b(1, I()) + 0;
        }
        i1 = j1;
        if ((e & 2) == 2)
        {
            i1 = j1 + dq.b(2, g);
        }
        j1 = i1;
        if ((e & 4) == 4)
        {
            double d1 = h;
            j1 = i1 + (dq.d(3) + 8);
        }
        i1 = j1;
        if ((e & 8) == 8)
        {
            i1 = j1 + dq.b(4, J());
        }
        j1 = i1;
        if ((e & 0x10) == 16)
        {
            j1 = i1 + dq.b(5, K());
        }
        i1 = j1;
        if ((e & 0x20) == 32)
        {
            i1 = j1 + dq.b(6, L());
        }
        j1 = i1;
        if ((e & 0x40) == 64)
        {
            j1 = i1 + dq.b(7, M());
        }
        i1 = j1;
        if ((e & 0x80) == 128)
        {
            i1 = j1 + dq.b(8, N());
        }
        j1 = i1;
        if ((e & 0x100) == 256)
        {
            j1 = i1 + dq.b(9, n);
        }
        i1 = j1;
        if ((e & 0x200) == 512)
        {
            i1 = j1 + dq.b(10, o);
        }
        j1 = i1;
        if ((e & 0x400) == 1024)
        {
            j1 = i1 + dq.b(11, O());
        }
        i1 = j1;
        if ((e & 0x800) == 2048)
        {
            i1 = j1 + dq.b(12, P());
        }
        j1 = i1;
        if ((e & 0x1000) == 4096)
        {
            j1 = i1 + dq.b(13, Q());
        }
        i1 = j1;
        if ((e & 0x2000) == 8192)
        {
            i1 = j1 + dq.b(14, R());
        }
        i1 += d.a();
        u = i1;
        return i1;
    }

    public final boolean d()
    {
        byte byte0 = t;
        if (byte0 == 1)
        {
            return true;
        }
        if (byte0 == 0)
        {
            return false;
        }
        if (!e())
        {
            t = 0;
            return false;
        } else
        {
            t = 1;
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
                if (flag && g == ((g) (obj)).g)
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
                if (flag && Double.doubleToLongBits(h) == Double.doubleToLongBits(((LongBits) (obj)).h))
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
                if (flag && r().equals(((r) (obj)).r()))
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
                if (flag && t().equals(((t) (obj)).t()))
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
                if (flag && o == ((o) (obj)).o)
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
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (E())
            {
                if (!flag2 || !F().equals(((F) (obj)).F()))
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

    public final int h()
    {
        return g;
    }

    public final int hashCode()
    {
        if (a != 0)
        {
            return a;
        }
        int j1 = com/tapjoy/internal/gt$r.hashCode() + 779;
        int i1 = j1;
        if (e())
        {
            i1 = (j1 * 37 + 1) * 53 + f().hashCode();
        }
        j1 = i1;
        if (g())
        {
            j1 = (i1 * 37 + 2) * 53 + g;
        }
        i1 = j1;
        if (i())
        {
            i1 = (j1 * 37 + 3) * 53 + dt.a(Double.doubleToLongBits(h));
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
            i1 = (j1 * 37 + 7) * 53 + r().hashCode();
        }
        j1 = i1;
        if (s())
        {
            j1 = (i1 * 37 + 8) * 53 + t().hashCode();
        }
        i1 = j1;
        if (u())
        {
            i1 = (j1 * 37 + 9) * 53 + n;
        }
        j1 = i1;
        if (w())
        {
            j1 = (i1 * 37 + 10) * 53 + dt.a(o);
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
        i1 = j1 * 29 + d.hashCode();
        a = i1;
        return i1;
    }

    public final boolean i()
    {
        return (e & 4) == 4;
    }

    public final double j()
    {
        return h;
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

    public final String r()
    {
        Object obj = l;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            l = s1;
        }
        return s1;
    }

    public final boolean s()
    {
        return (e & 0x80) == 128;
    }

    public final String t()
    {
        Object obj = m;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            m = s1;
        }
        return s1;
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

    public final long x()
    {
        return o;
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
        p1.S();
    }

    private _cls1()
    {
        t = -1;
        u = -1;
        d = do.a;
    }

    private d(dp dp1)
    {
        d d1;
        dq dq1;
        boolean flag;
        t = -1;
        u = -1;
        S();
        d1 = com.tapjoy.internal.do.h();
        dq1 = dq.a(d1, 4096);
        flag = false;
_L22:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = dp1.a();
        i1;
        JVM INSTR lookupswitch 15: default 643
    //                   0: 646
    //                   10: 192
    //                   16: 239
    //                   25: 277
    //                   34: 301
    //                   42: 327
    //                   50: 353
    //                   58: 379
    //                   66: 405
    //                   72: 432
    //                   80: 455
    //                   90: 478
    //                   98: 505
    //                   106: 532
    //                   114: 559;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
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
_L20:
        throw dp1;
_L6:
        e = e | 2;
        g = dp1.e();
        continue; /* Loop/switch isn't completed */
        dp1;
        throw (new du(dp1.getMessage())).a(this);
_L7:
        e = e | 4;
        h = Double.longBitsToDouble(dp1.g());
        continue; /* Loop/switch isn't completed */
_L8:
        do do2 = dp1.d();
        e = e | 8;
        i = do2;
        continue; /* Loop/switch isn't completed */
_L9:
        do do3 = dp1.d();
        e = e | 0x10;
        j = do3;
        continue; /* Loop/switch isn't completed */
_L10:
        do do4 = dp1.d();
        e = e | 0x20;
        k = do4;
        continue; /* Loop/switch isn't completed */
_L11:
        do do5 = dp1.d();
        e = e | 0x40;
        l = do5;
        continue; /* Loop/switch isn't completed */
_L12:
        do do6 = dp1.d();
        e = e | 0x80;
        m = do6;
        continue; /* Loop/switch isn't completed */
_L13:
        e = e | 0x100;
        n = dp1.e();
        continue; /* Loop/switch isn't completed */
_L14:
        e = e | 0x200;
        o = dp1.f();
        continue; /* Loop/switch isn't completed */
_L15:
        do do7 = dp1.d();
        e = e | 0x400;
        p = do7;
        continue; /* Loop/switch isn't completed */
_L16:
        do do8 = dp1.d();
        e = e | 0x800;
        q = do8;
        continue; /* Loop/switch isn't completed */
_L17:
        do do9 = dp1.d();
        e = e | 0x1000;
        r = do9;
        continue; /* Loop/switch isn't completed */
_L18:
        do do10 = dp1.d();
        e = e | 0x2000;
        s = do10;
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
        if (true) goto _L20; else goto _L19
_L19:
        dp1;
        d = d1.a();
        throw dp1;
_L4:
        flag = true;
        if (true) goto _L22; else goto _L21
_L21:
    }

    a(dp dp1, byte byte0)
    {
        this(dp1);
    }

    private <init>(<init> <init>1)
    {
        super((byte)0);
        t = -1;
        u = -1;
        d = <init>1.c();
    }

    c(c c1, byte byte0)
    {
        this(c1);
    }
}
