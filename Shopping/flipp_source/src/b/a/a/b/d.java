// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.a;
import b.a.a.c;
import b.a.a.c.f;
import b.a.a.c.j;
import b.a.a.c.k;
import b.a.a.c.l;
import b.a.a.c.n;
import b.a.a.c.o;
import b.a.a.c.s;
import b.a.a.i;
import b.a.a.m;

// Referenced classes of package b.a.a.b:
//            a, e, f, b, 
//            m, r, o, n, 
//            g, h, q, l, 
//            k

abstract class d extends b.a.a.b.a
{

    private static final c A;
    private static final c B;
    private static final c C = new e();
    private static final b.a.a.l l;
    private static final b.a.a.l m;
    private static final b.a.a.l n;
    private static final b.a.a.l o;
    private static final b.a.a.l p;
    private static final b.a.a.l q;
    private static final b.a.a.l r = new n(b.a.a.m.g(), 0x240c8400L);
    private static final c s;
    private static final c t;
    private static final c u;
    private static final c v;
    private static final c w;
    private static final c x;
    private static final c y;
    private static final c z;
    private final transient b.a.a.b.f D[] = new b.a.a.b.f[1024];
    private final int E;

    d(a a1, int i1)
    {
        super(a1, null);
        if (i1 <= 0 || i1 > 7)
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid min days in first week: ")).append(i1).toString());
        } else
        {
            E = i1;
            return;
        }
    }

    static int L()
    {
        return 366;
    }

    static int M()
    {
        return 31;
    }

    static int P()
    {
        return 12;
    }

    static b.a.a.l S()
    {
        return p;
    }

    static b.a.a.l T()
    {
        return q;
    }

    static int d(long l1)
    {
        if (l1 >= 0L)
        {
            l1 /= 0x5265c00L;
        } else
        {
            long l2 = (l1 - 0x5265bffL) / 0x5265c00L;
            l1 = l2;
            if (l2 < -3L)
            {
                return (int)((l2 + 4L) % 7L) + 7;
            }
        }
        return (int)((l1 + 3L) % 7L) + 1;
    }

    static int e(long l1)
    {
        if (l1 >= 0L)
        {
            return (int)(l1 % 0x5265c00L);
        } else
        {
            return 0x5265bff + (int)((1L + l1) % 0x5265c00L);
        }
    }

    private int e(long l1, int i1)
    {
        long l2 = e(i1);
        if (l1 < l2)
        {
            return a(i1 - 1);
        }
        if (l1 >= e(i1 + 1))
        {
            return 1;
        } else
        {
            return (int)((l1 - l2) / 0x240c8400L) + 1;
        }
    }

    private long e(int i1)
    {
        long l1 = b(i1);
        i1 = d(l1);
        if (i1 > 8 - E)
        {
            return l1 + (long)(8 - i1) * 0x5265c00L;
        } else
        {
            return l1 - (long)(i1 - 1) * 0x5265c00L;
        }
    }

    abstract int N();

    abstract int O();

    abstract long Q();

    abstract long R();

    final int a(int i1)
    {
        long l1 = e(i1);
        return (int)((e(i1 + 1) - l1) / 0x240c8400L);
    }

    final int a(long l1)
    {
        long l4 = 0x757b12c00L;
        long l5 = (l1 >> 1) + 0x1c4536cce9c0L;
        long l2 = l5;
        if (l5 < 0L)
        {
            l2 = (l5 - 0x3ac786fe0L) + 1L;
        }
        int j1 = (int)(l2 / 0x3ac786fe0L);
        l5 = b(j1);
        l2 = l1 - l5;
        int i1;
        if (l2 < 0L)
        {
            i1 = j1 - 1;
        } else
        {
            i1 = j1;
            if (l2 >= 0x757b12c00L)
            {
                long l3 = l4;
                if (c(j1))
                {
                    l3 = 0x75cd78800L;
                }
                i1 = j1;
                if (l3 + l5 <= l1)
                {
                    return j1 + 1;
                }
            }
        }
        return i1;
    }

    abstract int a(long l1, int i1);

    final int a(long l1, int i1, int j1)
    {
        return (int)((l1 - (b(i1) + c(i1, j1))) / 0x5265c00L) + 1;
    }

    final long a(int i1, int j1)
    {
        return b(i1) + c(i1, j1);
    }

    final long a(int i1, int j1, int k1)
    {
        return b(i1) + c(i1, j1) + (long)(k1 - 1) * 0x5265c00L;
    }

    abstract long a(long l1, long l2);

    public final i a()
    {
        a a1 = super.a;
        if (a1 != null)
        {
            return a1.a();
        } else
        {
            return i.a;
        }
    }

    protected void a(b b1)
    {
        b1.a = l;
        b1.b = m;
        b1.c = n;
        b1.d = o;
        b1.e = p;
        b1.f = q;
        b1.g = r;
        b1.m = s;
        b1.n = t;
        b1.o = u;
        b1.p = v;
        b1.q = w;
        b1.r = x;
        b1.s = y;
        b1.u = z;
        b1.t = A;
        b1.v = B;
        b1.w = C;
        b1.E = new b.a.a.b.m(this);
        b1.F = new r(b1.E, this);
        b1.H = new f(new k(b1.F), b.a.a.d.v());
        b1.G = new k(new o((f)b1.H), b.a.a.d.u());
        b1.I = new b.a.a.b.o(this);
        b1.x = new b.a.a.b.n(this, b1.f);
        b1.y = new g(this, b1.f);
        b1.z = new h(this, b1.f);
        b1.D = new q(this);
        b1.B = new b.a.a.b.l(this);
        b1.A = new b.a.a.b.k(this, b1.g);
        b1.C = new k(new o(b1.B, b.a.a.d.q()), b.a.a.d.q());
        b1.j = b1.E.d();
        b1.k = b1.H.d();
        b1.i = b1.D.d();
        b1.h = b1.B.d();
    }

    abstract int b(int i1, int j1);

    final int b(long l1)
    {
        int i1 = a(l1);
        int j1 = e(l1, i1);
        if (j1 == 1)
        {
            i1 = a(0x240c8400L + l1);
        } else
        if (j1 > 51)
        {
            return a(l1 - 0x48190800L);
        }
        return i1;
    }

    final int b(long l1, int i1)
    {
        return (int)((l1 - b(i1)) / 0x5265c00L) + 1;
    }

    final long b(int i1)
    {
        b.a.a.b.f f1;
label0:
        {
            b.a.a.b.f f2 = D[i1 & 0x3ff];
            if (f2 != null)
            {
                f1 = f2;
                if (f2.a == i1)
                {
                    break label0;
                }
            }
            f1 = new b.a.a.b.f(i1, d(i1));
            D[i1 & 0x3ff] = f1;
        }
        return f1.b;
    }

    final int c(long l1)
    {
        return e(l1, a(l1));
    }

    int c(long l1, int i1)
    {
        return f(l1);
    }

    abstract long c(int i1, int j1);

    abstract boolean c(int i1);

    abstract long d(int i1);

    abstract long d(long l1, int i1);

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj != null && getClass() == obj.getClass())
            {
                if (E != ((d) (obj = (d)obj)).E || !a().equals(((d) (obj)).a()))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    final int f(long l1)
    {
        int i1 = a(l1);
        return b(i1, a(l1, i1));
    }

    public int hashCode()
    {
        return getClass().getName().hashCode() * 11 + a().hashCode() + E;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(60);
        String s1 = getClass().getName();
        int i1 = s1.lastIndexOf('.');
        Object obj = s1;
        if (i1 >= 0)
        {
            obj = s1.substring(i1 + 1);
        }
        stringbuilder.append(((String) (obj)));
        stringbuilder.append('[');
        obj = a();
        if (obj != null)
        {
            stringbuilder.append(((i) (obj)).c);
        }
        if (E != 4)
        {
            stringbuilder.append(",mdfw=");
            stringbuilder.append(E);
        }
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    static 
    {
        l = j.a;
        m = new n(b.a.a.m.b(), 1000L);
        n = new n(b.a.a.m.c(), 60000L);
        o = new n(b.a.a.m.d(), 0x36ee80L);
        p = new n(b.a.a.m.e(), 0x2932e00L);
        q = new n(b.a.a.m.f(), 0x5265c00L);
        s = new l(b.a.a.d.a(), l, m);
        t = new l(b.a.a.d.b(), l, q);
        u = new l(b.a.a.d.c(), m, n);
        v = new l(b.a.a.d.d(), m, q);
        w = new l(b.a.a.d.e(), n, o);
        x = new l(b.a.a.d.f(), n, q);
        y = new l(b.a.a.d.g(), o, q);
        z = new l(b.a.a.d.i(), o, p);
        A = new s(y, b.a.a.d.h());
        B = new s(z, b.a.a.d.j());
    }
}
