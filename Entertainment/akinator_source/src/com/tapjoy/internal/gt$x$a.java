// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.tapjoy.internal:
//            gt, do

public static final class z extends z
    implements z
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

    static z L()
    {
        return new <init>();
    }

    private <init> M()
    {
        return (new <init>()).a(e());
    }

    private void N()
    {
        if ((b & 0x10) != 16)
        {
            g = new ArrayList(g);
            b = b | 0x10;
        }
    }

    public final b A()
    {
        b = b & 0xffefffff;
        w = w().w();
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

    public final x D()
    {
        b = b & 0xffdfffff;
        x = x().x();
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

    public final y G()
    {
        b = b & 0xffbfffff;
        y = y().y();
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

    public final z J()
    {
        b = b & 0xff7fffff;
        z = z().z();
        return this;
    }

    public final boolean K()
    {
        return A;
    }

    public final A a()
    {
        return M();
    }

    public final M a(double d1)
    {
        b = b | 0x800;
        n = d1;
        return this;
    }

    public final n a(int i1)
    {
        b = b | 4;
        e = i1;
        return this;
    }

    public final e a(int i1, e e1)
    {
        N();
        g.set(i1, e1.e());
        return this;
    }

    public final e a(int i1, e e1)
    {
        if (e1 == null)
        {
            throw new NullPointerException();
        } else
        {
            N();
            g.set(i1, e1);
            return this;
        }
    }

    public final g a(long l1)
    {
        b = b | 1;
        c = l1;
        return this;
    }

    public final c a(c c1)
    {
        N();
        g.add(c1.e());
        return this;
    }

    public final e a(e e1)
    {
        if (e1 == e())
        {
            return this;
        }
        if (e1.e())
        {
            a(e1.a());
        }
        if (e1.a())
        {
            b = b | 2;
            d = d(e1);
        }
        if (e1.d())
        {
            a(e1.a());
        }
        if (e1.a())
        {
            b(e1.b());
        }
        if (!b(e1).isEmpty())
        {
            if (g.isEmpty())
            {
                g = g(e1);
                b = b & 0xffffffef;
            } else
            {
                N();
                g.addAll(g(e1));
            }
        }
        if (e1.g())
        {
            e(e1.e());
        }
        if (e1.e())
        {
            b(e1.b());
        }
        if (e1.b())
        {
            c(e1.c());
        }
        if (e1.c())
        {
            d(e1.d());
        }
        if (e1.d())
        {
            b = b | 0x200;
            l = l(e1);
        }
        if (e1.l())
        {
            f(e1.f());
        }
        if (e1.f())
        {
            a(e1.a());
        }
        if (e1.a())
        {
            e(e1.e());
        }
        if (e1.e())
        {
            b(e1.b());
        }
        if (e1.b())
        {
            b = b | 0x4000;
            q = q(e1);
        }
        if (e1.q())
        {
            a(e1.a());
        }
        if (e1.a())
        {
            b = b | 0x10000;
            s = s(e1);
        }
        if (e1.s())
        {
            g(e1.g());
        }
        if (e1.g())
        {
            h(e1.h());
        }
        if (e1.h())
        {
            b = b | 0x80000;
            v = v(e1);
        }
        if (e1.v())
        {
            b = b | 0x100000;
            w = w(e1);
        }
        if (e1.w())
        {
            b = b | 0x200000;
            x = x(e1);
        }
        if (e1.x())
        {
            b = b | 0x400000;
            y = y(e1);
        }
        if (e1.y())
        {
            b = b | 0x800000;
            z = z(e1);
        }
        if (e1.())
        {
            b(e1.());
        }
        super. = super..a((e1));
        return this;
    }

    public final  a(Iterable iterable)
    {
        N();
        N(iterable, g);
        return this;
    }

    public final g a(String s1)
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

    public final d a(boolean flag)
    {
        b = b | 0x8000;
        r = flag;
        return this;
    }

    public final r b()
    {
        return M();
    }

    public final M b(double d1)
    {
        b = b | 0x2000;
        p = d1;
        return this;
    }

    public final p b(int i1)
    {
        b = b | 8;
        f = i1;
        return this;
    }

    public final f b(long l1)
    {
        b = b | 0x40;
        i = l1;
        return this;
    }

    public final i b(String s1)
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

    public final l b(boolean flag)
    {
        b = b | 0x1000000;
        A = flag;
        return this;
    }

    public final A c(int i1)
    {
        return (A)g.get(i1);
    }

    public final g c(long l1)
    {
        b = b | 0x80;
        j = l1;
        return this;
    }

    public final j c(String s1)
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

    public final M d(int i1)
    {
        N();
        g.remove(i1);
        return this;
    }

    public final g d(long l1)
    {
        b = b | 0x100;
        k = l1;
        return this;
    }

    public final k d(String s1)
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
            if (!c(i1).c())
            {
                return false;
            }
        }

        return true;
    }

    public final c e(int i1)
    {
        b = b | 0x20;
        h = i1;
        return this;
    }

    public final h e(long l1)
    {
        b = b | 0x1000;
        o = l1;
        return this;
    }

    public final o e(String s1)
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

    public final v e()
    {
        v v1 = new nit>(this, (byte)0);
        int k1 = b;
        int j1 = 0;
        if ((k1 & 1) == 1)
        {
            j1 = 1;
        }
        b(v1, c);
        int i1 = j1;
        if ((k1 & 2) == 2)
        {
            i1 = j1 | 2;
        }
        c(v1, d);
        j1 = i1;
        if ((k1 & 4) == 4)
        {
            j1 = i1 | 4;
        }
        d(v1, e);
        i1 = j1;
        if ((k1 & 8) == 8)
        {
            i1 = j1 | 8;
        }
        e(v1, f);
        if ((b & 0x10) == 16)
        {
            g = Collections.unmodifiableList(g);
            b = b & 0xffffffef;
        }
        b(v1, g);
        j1 = i1;
        if ((k1 & 0x20) == 32)
        {
            j1 = i1 | 0x10;
        }
        g(v1, h);
        i1 = j1;
        if ((k1 & 0x40) == 64)
        {
            i1 = j1 | 0x20;
        }
        h(v1, i);
        j1 = i1;
        if ((k1 & 0x80) == 128)
        {
            j1 = i1 | 0x40;
        }
        i(v1, j);
        i1 = j1;
        if ((k1 & 0x100) == 256)
        {
            i1 = j1 | 0x80;
        }
        j(v1, k);
        j1 = i1;
        if ((k1 & 0x200) == 512)
        {
            j1 = i1 | 0x100;
        }
        k(v1, l);
        i1 = j1;
        if ((k1 & 0x400) == 1024)
        {
            i1 = j1 | 0x200;
        }
        l(v1, m);
        j1 = i1;
        if ((k1 & 0x800) == 2048)
        {
            j1 = i1 | 0x400;
        }
        m(v1, n);
        i1 = j1;
        if ((k1 & 0x1000) == 4096)
        {
            i1 = j1 | 0x800;
        }
        n(v1, o);
        j1 = i1;
        if ((k1 & 0x2000) == 8192)
        {
            j1 = i1 | 0x1000;
        }
        o(v1, p);
        i1 = j1;
        if ((k1 & 0x4000) == 16384)
        {
            i1 = j1 | 0x2000;
        }
        p(v1, q);
        j1 = i1;
        if ((k1 & 0x8000) == 32768)
        {
            j1 = i1 | 0x4000;
        }
        q(v1, r);
        i1 = j1;
        if ((k1 & 0x10000) == 0x10000)
        {
            i1 = j1 | 0x8000;
        }
        r(v1, s);
        j1 = i1;
        if ((k1 & 0x20000) == 0x20000)
        {
            j1 = i1 | 0x10000;
        }
        s(v1, t);
        i1 = j1;
        if ((k1 & 0x40000) == 0x40000)
        {
            i1 = j1 | 0x20000;
        }
        t(v1, u);
        j1 = i1;
        if ((k1 & 0x80000) == 0x80000)
        {
            j1 = i1 | 0x40000;
        }
        u(v1, v);
        i1 = j1;
        if ((0x100000 & k1) == 0x100000)
        {
            i1 = j1 | 0x80000;
        }
        v(v1, w);
        j1 = i1;
        if ((0x200000 & k1) == 0x200000)
        {
            j1 = i1 | 0x100000;
        }
        w(v1, x);
        i1 = j1;
        if ((0x400000 & k1) == 0x400000)
        {
            i1 = j1 | 0x200000;
        }
        x(v1, y);
        j1 = i1;
        if ((0x800000 & k1) == 0x800000)
        {
            j1 = i1 | 0x400000;
        }
        y(v1, z);
        i1 = j1;
        if ((k1 & 0x1000000) == 0x1000000)
        {
            i1 = j1 | 0x800000;
        }
        z(v1, A);
        A(v1, i1);
        return v1;
    }

    public final A f(int i1)
    {
        b = b | 0x400;
        m = i1;
        return this;
    }

    public final m f(String s1)
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

    public final g g(int i1)
    {
        b = b | 0x20000;
        t = i1;
        return this;
    }

    public final t g(String s1)
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

    public final x h()
    {
        g = Collections.emptyList();
        b = b & 0xffffffef;
        return this;
    }

    public final b h(int i1)
    {
        b = b | 0x40000;
        u = i1;
        return this;
    }

    public final u h(String s1)
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

    public final y i()
    {
        b = b & 0xffffefff;
        o = 0L;
        return this;
    }

    public final o i(String s1)
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

    public final z j()
    {
        b = b & 0xffffdfff;
        p = 0.0D;
        return this;
    }

    public final p k()
    {
        b = b & 0xffffbfff;
        q = q().q();
        return this;
    }

    public final q l()
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

    public final s o()
    {
        b = b & 0xfffeffff;
        s = s().s();
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

    public final t r()
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

    public final u u()
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

    public final v x()
    {
        b = b & 0xfff7ffff;
        v = v().v();
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

    private ion()
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
