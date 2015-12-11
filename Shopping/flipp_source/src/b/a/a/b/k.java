// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.c.m;
import b.a.a.d;
import b.a.a.l;

// Referenced classes of package b.a.a.b:
//            d, a

final class k extends m
{

    private final b.a.a.b.d b;

    k(b.a.a.b.d d1, l l)
    {
        super(b.a.a.d.o(), l);
        b = d1;
    }

    public final int a(long l)
    {
        return b.c(l);
    }

    public final int c(long l)
    {
        int j = b.b(l);
        return b.a(j);
    }

    protected final int c(long l, int j)
    {
        int i1 = 52;
        if (j > 52)
        {
            i1 = c(l);
        }
        return i1;
    }

    public final long d(long l)
    {
        return super.d(l + 0xf731400L) - 0xf731400L;
    }

    public final long e(long l)
    {
        return super.e(l + 0xf731400L) - 0xf731400L;
    }

    public final l e()
    {
        return ((a) (b)).e;
    }

    public final int g()
    {
        return 1;
    }

    public final int h()
    {
        return 53;
    }

    public final long i(long l)
    {
        return super.i(0xf731400L + l);
    }
}
