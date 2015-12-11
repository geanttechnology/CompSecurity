// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            gt, do

public static final class p extends p
    implements p
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

    static p f()
    {
        return new <init>();
    }

    private <init> g()
    {
        return (new <init>()).a(e());
    }

    public final e a()
    {
        return g();
    }

    public final g a(double d1)
    {
        b = b | 4;
        e = d1;
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
            b = b | 1;
            c = c(e1);
        }
        if (e1.c())
        {
            int i1 = e1.c();
            b = b | 2;
            d = i1;
        }
        if (e1.d())
        {
            a(e1.a());
        }
        if (e1.a())
        {
            b = b | 8;
            f = f(e1);
        }
        if (e1.f())
        {
            b = b | 0x10;
            g = g(e1);
        }
        if (e1.g())
        {
            b = b | 0x20;
            h = h(e1);
        }
        if (e1.h())
        {
            b = b | 0x40;
            i = i(e1);
        }
        if (e1.i())
        {
            b = b | 0x80;
            j = j(e1);
        }
        if (e1.j())
        {
            int j1 = e1.j();
            b = b | 0x100;
            k = j1;
        }
        if (e1.k())
        {
            long l1 = e1.k();
            b = b | 0x200;
            l = l1;
        }
        if (e1.l())
        {
            b = b | 0x400;
            m = m(e1);
        }
        if (e1.m())
        {
            b = b | 0x800;
            n = n(e1);
        }
        if (e1.n())
        {
            b = b | 0x1000;
            o = o(e1);
        }
        if (e1.o())
        {
            b = b | 0x2000;
            p = p(e1);
        }
        super.p = super.p.a(p(e1));
        return this;
    }

    public final p a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            b = b | 1;
            c = s;
            return this;
        }
    }

    public final c b()
    {
        return g();
    }

    public final g b(String s)
    {
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            b = b | 8;
            f = s;
            return this;
        }
    }

    public final f c(String s)
    {
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            b = b | 0x400;
            m = s;
            return this;
        }
    }

    public final Object clone()
    {
        return g();
    }

    public final g d(String s)
    {
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            b = b | 0x1000;
            o = s;
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

    public final b e(String s)
    {
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            b = b | 0x2000;
            p = s;
            return this;
        }
    }

    public final p e()
    {
        int j1 = 1;
        p p1 = new nit>(this, (byte)0);
        int k1 = b;
        int i1;
        if ((k1 & 1) != 1)
        {
            j1 = 0;
        }
        b(p1, c);
        i1 = j1;
        if ((k1 & 2) == 2)
        {
            i1 = j1 | 2;
        }
        c(p1, d);
        j1 = i1;
        if ((k1 & 4) == 4)
        {
            j1 = i1 | 4;
        }
        d(p1, e);
        i1 = j1;
        if ((k1 & 8) == 8)
        {
            i1 = j1 | 8;
        }
        e(p1, f);
        j1 = i1;
        if ((k1 & 0x10) == 16)
        {
            j1 = i1 | 0x10;
        }
        f(p1, g);
        i1 = j1;
        if ((k1 & 0x20) == 32)
        {
            i1 = j1 | 0x20;
        }
        g(p1, h);
        j1 = i1;
        if ((k1 & 0x40) == 64)
        {
            j1 = i1 | 0x40;
        }
        h(p1, i);
        i1 = j1;
        if ((k1 & 0x80) == 128)
        {
            i1 = j1 | 0x80;
        }
        i(p1, j);
        j1 = i1;
        if ((k1 & 0x100) == 256)
        {
            j1 = i1 | 0x100;
        }
        j(p1, k);
        i1 = j1;
        if ((k1 & 0x200) == 512)
        {
            i1 = j1 | 0x200;
        }
        k(p1, l);
        j1 = i1;
        if ((k1 & 0x400) == 1024)
        {
            j1 = i1 | 0x400;
        }
        l(p1, m);
        i1 = j1;
        if ((k1 & 0x800) == 2048)
        {
            i1 = j1 | 0x800;
        }
        m(p1, n);
        j1 = i1;
        if ((k1 & 0x1000) == 4096)
        {
            j1 = i1 | 0x1000;
        }
        n(p1, o);
        i1 = j1;
        if ((k1 & 0x2000) == 8192)
        {
            i1 = j1 | 0x2000;
        }
        o(p1, p);
        p(p1, i1);
        return p1;
    }

    private ion()
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
