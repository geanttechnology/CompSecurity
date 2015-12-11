// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.c.g;
import b.a.a.c.h;
import b.a.a.d;
import b.a.a.l;

// Referenced classes of package b.a.a.b:
//            d, a

final class m extends h
{

    protected final b.a.a.b.d a;

    m(b.a.a.b.d d1)
    {
        super(b.a.a.d.s(), d1.Q());
        a = d1;
    }

    public final int a(long l)
    {
        return a.a(l);
    }

    public final long a(long l, int j)
    {
        if (j == 0)
        {
            return l;
        }
        int k = a(l);
        int i1 = k + j;
        if ((k ^ i1) < 0 && (k ^ j) >= 0)
        {
            throw new ArithmeticException((new StringBuilder("The calculation caused an overflow: ")).append(k).append(" + ").append(j).toString());
        } else
        {
            return b(l, i1);
        }
    }

    public final long a(long l, long l1)
    {
        return a(l, b.a.a.c.g.a(l1));
    }

    public final long b(long l, int j)
    {
        b.a.a.c.g.a(this, j, a.N(), a.O());
        return a.d(l, j);
    }

    public final boolean b(long l)
    {
        return a.c(a(l));
    }

    public final long c(long l, long l1)
    {
        if (l < l1)
        {
            return -a.a(l1, l);
        } else
        {
            return a.a(l, l1);
        }
    }

    public final long d(long l)
    {
        return a.b(a(l));
    }

    public final long e(long l)
    {
        int j = a(l);
        long l1 = l;
        if (l != a.b(j))
        {
            l1 = a.b(j + 1);
        }
        return l1;
    }

    public final l e()
    {
        return null;
    }

    public final l f()
    {
        return ((a) (a)).c;
    }

    public final int g()
    {
        return a.N();
    }

    public final int h()
    {
        return a.O();
    }

    public final long i(long l)
    {
        return l - d(l);
    }
}
