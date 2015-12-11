// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            gt, do

public static final class s extends s
    implements s
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

    static s f()
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

    public final g a(int i1)
    {
        b = b | 0x40;
        i = i1;
        return this;
    }

    public final i a(i i1)
    {
        if (i1 == i())
        {
            return this;
        }
        if (i1.i())
        {
            b = b | 1;
            c = c(i1);
        }
        if (i1.c())
        {
            b = b | 2;
            d = d(i1);
        }
        if (i1.d())
        {
            b = b | 4;
            e = e(i1);
        }
        if (i1.e())
        {
            b = b | 8;
            f = f(i1);
        }
        if (i1.f())
        {
            b = b | 0x10;
            g = g(i1);
        }
        if (i1.g())
        {
            b = b | 0x20;
            h = h(i1);
        }
        if (i1.h())
        {
            a(i1.a());
        }
        if (i1.a())
        {
            b(i1.b());
        }
        if (i1.b())
        {
            c(i1.c());
        }
        if (i1.c())
        {
            b = b | 0x200;
            l = l(i1);
        }
        if (i1.l())
        {
            b = b | 0x400;
            m = m(i1);
        }
        if (i1.m())
        {
            b = b | 0x800;
            n = n(i1);
        }
        if (i1.n())
        {
            b = b | 0x1000;
            o = o(i1);
        }
        if (i1.o())
        {
            b = b | 0x2000;
            p = p(i1);
        }
        if (i1.p())
        {
            b = b | 0x4000;
            q = q(i1);
        }
        if (i1.q())
        {
            b = b | 0x8000;
            r = r(i1);
        }
        if (i1.r())
        {
            b = b | 0x10000;
            s = s(i1);
        }
        super.s = super.s.a(s(i1));
        return this;
    }

    public final s a(String s1)
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

    public final c b()
    {
        return g();
    }

    public final g b(int i1)
    {
        b = b | 0x80;
        j = i1;
        return this;
    }

    public final j b(String s1)
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

    public final d c(int i1)
    {
        b = b | 0x100;
        k = i1;
        return this;
    }

    public final k c(String s1)
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

    public final g d(String s1)
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

    public final f e(String s1)
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

    public final g e()
    {
        int j1 = 1;
        g g1 = new nit>(this, (byte)0);
        int k1 = b;
        int i1;
        if ((k1 & 1) != 1)
        {
            j1 = 0;
        }
        b(g1, c);
        i1 = j1;
        if ((k1 & 2) == 2)
        {
            i1 = j1 | 2;
        }
        c(g1, d);
        j1 = i1;
        if ((k1 & 4) == 4)
        {
            j1 = i1 | 4;
        }
        d(g1, e);
        i1 = j1;
        if ((k1 & 8) == 8)
        {
            i1 = j1 | 8;
        }
        e(g1, f);
        j1 = i1;
        if ((k1 & 0x10) == 16)
        {
            j1 = i1 | 0x10;
        }
        f(g1, g);
        i1 = j1;
        if ((k1 & 0x20) == 32)
        {
            i1 = j1 | 0x20;
        }
        g(g1, h);
        j1 = i1;
        if ((k1 & 0x40) == 64)
        {
            j1 = i1 | 0x40;
        }
        h(g1, i);
        i1 = j1;
        if ((k1 & 0x80) == 128)
        {
            i1 = j1 | 0x80;
        }
        i(g1, j);
        j1 = i1;
        if ((k1 & 0x100) == 256)
        {
            j1 = i1 | 0x100;
        }
        j(g1, k);
        i1 = j1;
        if ((k1 & 0x200) == 512)
        {
            i1 = j1 | 0x200;
        }
        k(g1, l);
        j1 = i1;
        if ((k1 & 0x400) == 1024)
        {
            j1 = i1 | 0x400;
        }
        l(g1, m);
        i1 = j1;
        if ((k1 & 0x800) == 2048)
        {
            i1 = j1 | 0x800;
        }
        m(g1, n);
        j1 = i1;
        if ((k1 & 0x1000) == 4096)
        {
            j1 = i1 | 0x1000;
        }
        n(g1, o);
        i1 = j1;
        if ((k1 & 0x2000) == 8192)
        {
            i1 = j1 | 0x2000;
        }
        o(g1, p);
        j1 = i1;
        if ((k1 & 0x4000) == 16384)
        {
            j1 = i1 | 0x4000;
        }
        p(g1, q);
        i1 = j1;
        if ((k1 & 0x8000) == 32768)
        {
            i1 = j1 | 0x8000;
        }
        q(g1, r);
        j1 = i1;
        if ((k1 & 0x10000) == 0x10000)
        {
            j1 = i1 | 0x10000;
        }
        r(g1, s);
        s(g1, j1);
        return g1;
    }

    public final s f(String s1)
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

    public final h g(String s1)
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

    public final l h(String s1)
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

    public final m i(String s1)
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

    public final n j(String s1)
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

    public final o k(String s1)
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

    public final p l(String s1)
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

    public final q m(String s1)
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

    public final r n(String s1)
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

    private ion()
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
