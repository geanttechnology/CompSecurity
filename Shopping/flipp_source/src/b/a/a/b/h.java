// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.c.m;
import b.a.a.d;
import b.a.a.l;

// Referenced classes of package b.a.a.b:
//            d, a

final class h extends m
{

    private final b.a.a.b.d b;

    h(b.a.a.b.d d1, l l)
    {
        super(d.n(), l);
        b = d1;
    }

    public final int a(long l)
    {
        b.a.a.b.d d1 = b;
        return d1.b(l, d1.a(l));
    }

    public final int c(long l)
    {
        int i = b.a(l);
        return !b.c(i) ? 365 : 366;
    }

    protected final int c(long l, int i)
    {
        int j = 365;
        d.L();
        if (i > 365 || i <= 0)
        {
            j = c(l);
        }
        return j;
    }

    public final l e()
    {
        return ((a) (b)).g;
    }

    public final int g()
    {
        return 1;
    }

    public final int h()
    {
        return d.L();
    }
}
