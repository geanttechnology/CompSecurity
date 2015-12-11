// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.tapjoy.internal:
//            gt, do, ec

public static final class List extends List
    implements List
{

    private int b;
    private t c;
    private Object d;
    private long e;
    private long f;
    private Object g;
    private long h;
    private long i;
    private t j;
    private t k;
    private t l;
    private int m;
    private int n;
    private t o;
    private t p;
    private Object q;
    private Object r;
    private t s;
    private Object t;
    private Object u;
    private Object v;
    private List w;

    static List k()
    {
        return new <init>();
    }

    private <init> l()
    {
        <init> <init>1 = new <init>();
        <init> <init>2 = m();
        if (<init>2 == m())
        {
            return <init>1;
        }
        if (<init>2.m())
        {
            <init>1.a(<init>2.a());
        }
        if (<init>2.a())
        {
            <init>1.b = <init>1.b | 2;
            <init>1.d = d(<init>2);
        }
        if (<init>2.d())
        {
            <init>1.a(<init>2.a());
        }
        if (<init>2.a())
        {
            <init>1.b(<init>2.b());
        }
        if (<init>2.b())
        {
            <init>1.b = <init>1.b | 0x10;
            <init>1.g = g(<init>2);
        }
        if (<init>2.g())
        {
            <init>1.c(<init>2.c());
        }
        if (<init>2.c())
        {
            <init>1.d(<init>2.d());
        }
        Object obj;
        if (<init>2.d())
        {
            obj = <init>2.d();
            int i1;
            if ((<init>1.b & 0x80) == 128 && <init>1.j != j())
            {
                <init>1.j = j(<init>1.j).a(((a) (obj))).e();
            } else
            {
                <init>1.j = ((j) (obj));
            }
            <init>1.b = <init>1.b | 0x80;
        }
        if (<init>2.b())
        {
            obj = <init>2.b();
            if ((<init>1.b & 0x100) == 256 && <init>1.k != k())
            {
                <init>1.k = k(<init>1.k).a(((a) (obj))).e();
            } else
            {
                <init>1.k = ((k) (obj));
            }
            <init>1.b = <init>1.b | 0x100;
        }
        if (<init>2.b())
        {
            obj = <init>2.b();
            if ((<init>1.b & 0x200) == 512 && <init>1.l != l())
            {
                <init>1.l = l(<init>1.l).a(((a) (obj))).e();
            } else
            {
                <init>1.l = ((l) (obj));
            }
            <init>1.b = <init>1.b | 0x200;
        }
        if (<init>2.b())
        {
            i1 = <init>2.b();
            <init>1.b = <init>1.b | 0x400;
            <init>1.m = i1;
        }
        if (<init>2.m())
        {
            <init>1.a(<init>2.a());
        }
        if (<init>2.a())
        {
            obj = <init>2.a();
            if ((<init>1.b & 0x1000) == 4096 && <init>1.o != o())
            {
                <init>1.o = o(<init>1.o).a(((a) (obj))).e();
            } else
            {
                <init>1.o = ((o) (obj));
            }
            <init>1.b = <init>1.b | 0x1000;
        }
        if (<init>2.b())
        {
            obj = <init>2.b();
            if ((<init>1.b & 0x2000) == 8192 && <init>1.p != p())
            {
                <init>1.p = p(<init>1.p).a(((a) (obj))).e();
            } else
            {
                <init>1.p = ((p) (obj));
            }
            <init>1.b = <init>1.b | 0x2000;
        }
        if (<init>2.b())
        {
            <init>1.b = <init>1.b | 0x4000;
            <init>1.q = q(<init>2);
        }
        if (<init>2.q())
        {
            <init>1.b = <init>1.b | 0x8000;
            <init>1.r = r(<init>2);
        }
        if (<init>2.r())
        {
            obj = <init>2.r();
            if ((<init>1.b & 0x10000) == 0x10000 && <init>1.s != s())
            {
                <init>1.s = s(<init>1.s).a(((a) (obj))).f();
            } else
            {
                <init>1.s = ((s) (obj));
            }
            <init>1.b = <init>1.b | 0x10000;
        }
        if (<init>2.b())
        {
            <init>1.b = <init>1.b | 0x20000;
            <init>1.t = t(<init>2);
        }
        if (<init>2.t())
        {
            <init>1.b = <init>1.b | 0x40000;
            <init>1.u = u(<init>2);
        }
        if (<init>2.u())
        {
            <init>1.b = <init>1.b | 0x80000;
            <init>1.v = v(<init>2);
        }
        if (!v(<init>2).isEmpty())
        {
            if (<init>1.w.isEmpty())
            {
                <init>1.w = w(<init>2);
                <init>1.b = <init>1.b & 0xffefffff;
            } else
            {
                <init>1.n();
                <init>1.w.addAll(w(<init>2));
            }
        }
        <init>1.w = ((w) (<init>1)).w.a(w(<init>2));
        return <init>1;
    }

    private w m()
    {
        w w1 = new nit>(this, (byte)0);
        int k1 = b;
        int j1 = 0;
        if ((k1 & 1) == 1)
        {
            j1 = 1;
        }
        b(w1, c);
        int i1 = j1;
        if ((k1 & 2) == 2)
        {
            i1 = j1 | 2;
        }
        c(w1, d);
        j1 = i1;
        if ((k1 & 4) == 4)
        {
            j1 = i1 | 4;
        }
        d(w1, e);
        i1 = j1;
        if ((k1 & 8) == 8)
        {
            i1 = j1 | 8;
        }
        e(w1, f);
        j1 = i1;
        if ((k1 & 0x10) == 16)
        {
            j1 = i1 | 0x10;
        }
        f(w1, g);
        i1 = j1;
        if ((k1 & 0x20) == 32)
        {
            i1 = j1 | 0x20;
        }
        g(w1, h);
        j1 = i1;
        if ((k1 & 0x40) == 64)
        {
            j1 = i1 | 0x40;
        }
        h(w1, i);
        i1 = j1;
        if ((k1 & 0x80) == 128)
        {
            i1 = j1 | 0x80;
        }
        i(w1, j);
        j1 = i1;
        if ((k1 & 0x100) == 256)
        {
            j1 = i1 | 0x100;
        }
        j(w1, k);
        i1 = j1;
        if ((k1 & 0x200) == 512)
        {
            i1 = j1 | 0x200;
        }
        k(w1, l);
        j1 = i1;
        if ((k1 & 0x400) == 1024)
        {
            j1 = i1 | 0x400;
        }
        l(w1, m);
        i1 = j1;
        if ((k1 & 0x800) == 2048)
        {
            i1 = j1 | 0x800;
        }
        m(w1, n);
        j1 = i1;
        if ((k1 & 0x1000) == 4096)
        {
            j1 = i1 | 0x1000;
        }
        n(w1, o);
        i1 = j1;
        if ((k1 & 0x2000) == 8192)
        {
            i1 = j1 | 0x2000;
        }
        o(w1, p);
        j1 = i1;
        if ((k1 & 0x4000) == 16384)
        {
            j1 = i1 | 0x4000;
        }
        p(w1, q);
        i1 = j1;
        if ((k1 & 0x8000) == 32768)
        {
            i1 = j1 | 0x8000;
        }
        q(w1, r);
        j1 = i1;
        if ((k1 & 0x10000) == 0x10000)
        {
            j1 = i1 | 0x10000;
        }
        r(w1, s);
        i1 = j1;
        if ((k1 & 0x20000) == 0x20000)
        {
            i1 = j1 | 0x20000;
        }
        s(w1, t);
        j1 = i1;
        if ((k1 & 0x40000) == 0x40000)
        {
            j1 = i1 | 0x40000;
        }
        t(w1, u);
        i1 = j1;
        if ((k1 & 0x80000) == 0x80000)
        {
            i1 = j1 | 0x80000;
        }
        u(w1, v);
        if ((b & 0x100000) == 0x100000)
        {
            w = Collections.unmodifiableList(w);
            b = b & 0xffefffff;
        }
        b(w1, w);
        w(w1, i1);
        return w1;
    }

    private void n()
    {
        if ((b & 0x100000) != 0x100000)
        {
            w = new ArrayList(w);
            b = b | 0x100000;
        }
    }

    public final b a()
    {
        return l();
    }

    public final l a(int i1)
    {
        b = b | 0x800;
        n = i1;
        return this;
    }

    public final n a(long l1)
    {
        b = b | 4;
        e = l1;
        return this;
    }

    public final e a(e e1)
    {
        if (e1 == null)
        {
            throw new NullPointerException();
        } else
        {
            k = e1;
            b = b | 0x100;
            return this;
        }
    }

    public final b a(b b1)
    {
        b1 = b1.e();
        if (!b1.e())
        {
            throw new ec();
        } else
        {
            o = b1;
            b = b | 0x1000;
            return this;
        }
    }

    public final b a(b b1)
    {
        if (b1 == null)
        {
            throw new NullPointerException();
        } else
        {
            b = b | 1;
            c = b1;
            return this;
        }
    }

    public final c a(c c1)
    {
        n();
        List list = w;
        c1 = c1.e();
        if (!c1.e())
        {
            throw new ec();
        } else
        {
            list.add(c1);
            return this;
        }
    }

    public final t> a(t> t>)
    {
        if (t> == null)
        {
            throw new NullPointerException();
        } else
        {
            j = t>;
            b = b | 0x80;
            return this;
        }
    }

    public final b a(b b1)
    {
        s = b1.e();
        b = b | 0x10000;
        return this;
    }

    public final b a(b b1)
    {
        if (b1 == null)
        {
            throw new NullPointerException();
        } else
        {
            s = b1;
            b = b | 0x10000;
            return this;
        }
    }

    public final b a(b b1)
    {
        b1 = b1.e();
        if (!b1.e())
        {
            throw new ec();
        } else
        {
            p = b1;
            b = b | 0x2000;
            return this;
        }
    }

    public final b a(b b1)
    {
        if (b1 == null)
        {
            throw new NullPointerException();
        } else
        {
            l = b1;
            b = b | 0x200;
            return this;
        }
    }

    public final b a(String s1)
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

    public final d b()
    {
        return l();
    }

    public final l b(long l1)
    {
        b = b | 8;
        f = l1;
        return this;
    }

    public final f b(String s1)
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

    public final g c(long l1)
    {
        b = b | 0x20;
        h = l1;
        return this;
    }

    public final h c(String s1)
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

    public final l d(long l1)
    {
        b = b | 0x40;
        i = l1;
        return this;
    }

    public final i d(String s1)
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
                if (i1 == 0 || l.l())
                {
                    if ((b & 0x1000) == 4096)
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = 0;
                    }
                    if (i1 == 0 || o.o())
                    {
                        if ((b & 0x2000) == 8192)
                        {
                            i1 = 1;
                        } else
                        {
                            i1 = 0;
                        }
                        if (i1 == 0 || p.p())
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
                                    if (!((w)w.get(i1)).w())
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

    public final w e(String s1)
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

    public final u e()
    {
        u u1 = m();
        if (!u1.m())
        {
            throw new ec();
        } else
        {
            return u1;
        }
    }

    public final t> f(String s1)
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

    public final v f()
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

    private ion()
    {
        c = c;
        d = "";
        g = "";
        j = j();
        k = k();
        l = l();
        o = o();
        p = p();
        q = "";
        r = "";
        s = s();
        t = "";
        u = "";
        v = "";
        w = Collections.emptyList();
    }
}
