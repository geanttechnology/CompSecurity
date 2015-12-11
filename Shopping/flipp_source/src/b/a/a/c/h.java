// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.d;
import b.a.a.l;

// Referenced classes of package b.a.a.c:
//            b, i, g

public abstract class h extends b
{

    private final l a;
    final long b;

    public h(d d1, long l)
    {
        super(d1);
        b = l;
        a = new i(this, d1.x());
    }

    public abstract long a(long l, int j);

    public abstract long a(long l, long l1);

    public final int b(long l, long l1)
    {
        return g.a(c(l, l1));
    }

    public long c(long l, long l1)
    {
        long l3;
        if (l < l1)
        {
            l3 = -c(l1, l);
        } else
        {
            long l2 = (l - l1) / b;
            if (a(l1, l2) < l)
            {
                do
                {
                    l3 = l2 + 1L;
                    l2 = l3;
                } while (a(l1, l3) <= l);
                return l3 - 1L;
            }
            l3 = l2;
            if (a(l1, l2) > l)
            {
                long l4;
                do
                {
                    l4 = l2 - 1L;
                    l2 = l4;
                } while (a(l1, l4) > l);
                return l4;
            }
        }
        return l3;
    }

    public final l d()
    {
        return a;
    }
}
