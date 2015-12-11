// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.c;
import b.a.a.c.d;
import b.a.a.c.g;

// Referenced classes of package b.a.a.b:
//            d

final class r extends d
{

    private final b.a.a.b.d a;

    r(c c1, b.a.a.b.d d1)
    {
        super(c1, b.a.a.d.t());
        a = d1;
    }

    public final int a(long l)
    {
        int k = super.b.a(l);
        int j = k;
        if (k <= 0)
        {
            j = 1 - k;
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
        b.a.a.c.g.a(this, j, 1, super.b.h());
        int k = j;
        if (a.a(l) <= 0)
        {
            k = 1 - j;
        }
        return super.b(l, k);
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

    public final int g()
    {
        return 1;
    }

    public final int h()
    {
        return super.b.h();
    }

    public final long i(long l)
    {
        return super.b.i(l);
    }
}
