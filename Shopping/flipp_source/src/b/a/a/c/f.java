// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.c;
import b.a.a.d;
import b.a.a.l;

// Referenced classes of package b.a.a.c:
//            d, p, g

public final class f extends b.a.a.c.d
{

    final int a = 100;
    final l c;
    private final int d;
    private final int e;

    public f(c c1, d d1)
    {
        super(c1, d1);
        l l = c1.d();
        int j;
        int k;
        if (l == null)
        {
            c = null;
        } else
        {
            c = new p(l, d1.x());
        }
        j = c1.g();
        if (j >= 0)
        {
            j /= 100;
        } else
        {
            j = (j + 1) / 100 - 1;
        }
        k = c1.h();
        if (k >= 0)
        {
            k /= 100;
        } else
        {
            k = (k + 1) / 100 - 1;
        }
        d = j;
        e = k;
    }

    public final int a(long l)
    {
        int j = super.b.a(l);
        if (j >= 0)
        {
            return j / a;
        } else
        {
            return (j + 1) / a - 1;
        }
    }

    public final long a(long l, int j)
    {
        return super.b.a(l, a * j);
    }

    public final long a(long l, long l1)
    {
        return super.b.a(l, (long)a * l1);
    }

    public final int b(long l, long l1)
    {
        return super.b.b(l, l1) / a;
    }

    public final long b(long l, int j)
    {
        b.a.a.c.g.a(this, j, d, e);
        int k = super.b.a(l);
        if (k >= 0)
        {
            k %= a;
        } else
        {
            int i1 = a;
            k = (k + 1) % a + (i1 - 1);
        }
        return super.b.b(l, k + a * j);
    }

    public final long c(long l, long l1)
    {
        return super.b.c(l, l1) / (long)a;
    }

    public final long d(long l)
    {
        c c1 = super.b;
        return c1.d(c1.b(l, a(l) * a));
    }

    public final l d()
    {
        return c;
    }

    public final int g()
    {
        return d;
    }

    public final int h()
    {
        return e;
    }

    public final long i(long l)
    {
        return b(l, a(super.b.i(l)));
    }
}
