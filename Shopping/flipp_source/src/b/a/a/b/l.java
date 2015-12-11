// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.c;
import b.a.a.c.g;
import b.a.a.c.h;
import b.a.a.d;

// Referenced classes of package b.a.a.b:
//            d, a

final class l extends h
{

    private final b.a.a.b.d a;

    l(b.a.a.b.d d1)
    {
        super(b.a.a.d.p(), d1.Q());
        a = d1;
    }

    public final int a(long l1)
    {
        return a.b(l1);
    }

    public final long a(long l1, int j)
    {
        if (j == 0)
        {
            return l1;
        } else
        {
            return b(l1, a(l1) + j);
        }
    }

    public final long a(long l1, long l2)
    {
        return a(l1, b.a.a.c.g.a(l2));
    }

    public final long b(long l1, int j)
    {
        b.a.a.c.g.a(this, Math.abs(j), a.N(), a.O());
        int k = a(l1);
        if (k == j)
        {
            return l1;
        }
        int j1 = b.a.a.b.d.d(l1);
        k = a.a(k);
        int i1 = a.a(j);
        if (i1 < k)
        {
            k = i1;
        }
        i1 = a.c(l1);
        long l2;
        if (i1 <= k)
        {
            k = i1;
        }
        l2 = a.d(l1, j);
        i1 = a(l2);
        if (i1 >= j) goto _L2; else goto _L1
_L1:
        l1 = l2 + 0x240c8400L;
_L4:
        l2 = k - a.c(l1);
        return ((a) (a)).h.b(l2 * 0x240c8400L + l1, j1);
_L2:
        l1 = l2;
        if (i1 > j)
        {
            l1 = l2 - 0x240c8400L;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final boolean b(long l1)
    {
        return a.a(a.b(l1)) > 52;
    }

    public final long c(long l1, long l2)
    {
        if (l1 < l2)
        {
            return (long)(-b(l2, l1));
        }
        int j = a(l1);
        int k = a(l2);
        long l3 = d(l1);
        l2 -= d(l2);
        if (l2 >= 0x7528ad000L && a.a(j) <= 52)
        {
            l2 -= 0x240c8400L;
        }
        k = j - k;
        j = k;
        if (l1 - l3 < l2)
        {
            j = k - 1;
        }
        return (long)j;
    }

    public final long d(long l1)
    {
        long l2 = ((a) (a)).j.d(l1);
        int j = a.c(l2);
        l1 = l2;
        if (j > 1)
        {
            l1 = l2 - (long)(j - 1) * 0x240c8400L;
        }
        return l1;
    }

    public final b.a.a.l e()
    {
        return null;
    }

    public final b.a.a.l f()
    {
        return ((a) (a)).d;
    }

    public final int g()
    {
        return a.N();
    }

    public final int h()
    {
        return a.O();
    }

    public final long i(long l1)
    {
        return l1 - d(l1);
    }
}
