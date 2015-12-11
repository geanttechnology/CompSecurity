// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.c;
import b.a.a.d;
import b.a.a.l;

// Referenced classes of package b.a.a.c:
//            d, b, f, p, 
//            g

public final class o extends b.a.a.c.d
{

    final int a;
    final l c;

    public o(f f1)
    {
        this(f1, ((b) (f1)).g);
    }

    public o(f f1, d d1)
    {
        super(((b.a.a.c.d) (f1)).b, d1);
        a = f1.a;
        c = f1.c;
    }

    public o(c c1, d d1)
    {
        super(c1, d1);
        c1 = c1.d();
        if (c1 == null)
        {
            c = null;
        } else
        {
            c = new p(c1, d1.y());
        }
        a = 100;
    }

    public final int a(long l)
    {
        int j = super.b.a(l);
        if (j >= 0)
        {
            return j % a;
        } else
        {
            int k = a;
            return (j + 1) % a + (k - 1);
        }
    }

    public final long b(long l, int j)
    {
        b.a.a.c.g.a(this, j, 0, a - 1);
        int k = super.b.a(l);
        if (k >= 0)
        {
            k /= a;
        } else
        {
            k = (k + 1) / a - 1;
        }
        return super.b.b(l, k * a + j);
    }

    public final long d(long l)
    {
        return super.b.d(l);
    }

    public final long e(long l)
    {
        return super.b.e(l);
    }

    public final l e()
    {
        return c;
    }

    public final long f(long l)
    {
        return super.b.f(l);
    }

    public final int g()
    {
        return 0;
    }

    public final long g(long l)
    {
        return super.b.g(l);
    }

    public final int h()
    {
        return a - 1;
    }

    public final long h(long l)
    {
        return super.b.h(l);
    }

    public final long i(long l)
    {
        return super.b.i(l);
    }
}
