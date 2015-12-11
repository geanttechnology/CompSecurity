// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.c;
import b.a.a.d;
import b.a.a.l;

// Referenced classes of package b.a.a.c:
//            d, g

public final class k extends b.a.a.c.d
{

    private final int a;
    private final int c;
    private final int d;

    public k(c c1)
    {
        d d1;
        if (c1 == null)
        {
            d1 = null;
        } else
        {
            d1 = c1.a();
        }
        this(c1, d1, 99);
    }

    public k(c c1, d d1)
    {
        this(c1, d1, 1);
    }

    private k(c c1, d d1, int j)
    {
        super(c1, d1);
        if (j == 0)
        {
            throw new IllegalArgumentException("The offset cannot be zero");
        }
        a = j;
        if (0x80000000 < c1.g() + j)
        {
            c = c1.g() + j;
        } else
        {
            c = 0x80000000;
        }
        if (0x7fffffff > c1.h() + j)
        {
            d = c1.h() + j;
            return;
        } else
        {
            d = 0x7fffffff;
            return;
        }
    }

    public final int a(long l)
    {
        return super.a(l) + a;
    }

    public final long a(long l, int j)
    {
        l = super.a(l, j);
        b.a.a.c.g.a(this, a(l), c, d);
        return l;
    }

    public final long a(long l, long l1)
    {
        l = super.a(l, l1);
        b.a.a.c.g.a(this, a(l), c, d);
        return l;
    }

    public final long b(long l, int j)
    {
        b.a.a.c.g.a(this, j, c, d);
        return super.b(l, j - a);
    }

    public final boolean b(long l)
    {
        return super.b.b(l);
    }

    public final long d(long l)
    {
        return super.b.d(l);
    }

    public final long e(long l)
    {
        return super.b.e(l);
    }

    public final long f(long l)
    {
        return super.b.f(l);
    }

    public final l f()
    {
        return super.b.f();
    }

    public final int g()
    {
        return c;
    }

    public final long g(long l)
    {
        return super.b.g(l);
    }

    public final int h()
    {
        return d;
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
