// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.c;
import b.a.a.d;
import b.a.a.l;

// Referenced classes of package b.a.a.c:
//            d, g

public final class s extends b.a.a.c.d
{

    public s(c c1, d d1)
    {
        super(c1, d1);
        if (c1.g() != 0)
        {
            throw new IllegalArgumentException("Wrapped field's minumum value must be zero");
        } else
        {
            return;
        }
    }

    public final int a(long l)
    {
        int k = super.b.a(l);
        int j = k;
        if (k == 0)
        {
            j = h();
        }
        return j;
    }

    public final long a(long l, int j)
    {
        return super.b.a(l, j);
    }

    public final long a(long l, long l1)
    {
        return super.b.a(l, l1);
    }

    public final int b(long l, long l1)
    {
        return super.b.b(l, l1);
    }

    public final long b(long l, int j)
    {
        int i1 = h();
        b.a.a.c.g.a(this, j, 1, i1);
        int k = j;
        if (j == i1)
        {
            k = 0;
        }
        return super.b.b(l, k);
    }

    public final boolean b(long l)
    {
        return super.b.b(l);
    }

    public final int c(long l)
    {
        return super.b.c(l) + 1;
    }

    public final long c(long l, long l1)
    {
        return super.b.c(l, l1);
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
        return 1;
    }

    public final long g(long l)
    {
        return super.b.g(l);
    }

    public final int h()
    {
        return super.b.h() + 1;
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
