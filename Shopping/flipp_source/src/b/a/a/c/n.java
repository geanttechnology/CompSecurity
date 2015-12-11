// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.m;

// Referenced classes of package b.a.a.c:
//            c, g

public final class n extends c
{

    private final long a;

    public n(m m, long l)
    {
        super(m);
        a = l;
    }

    public final long a(long l, int i)
    {
        return g.a(l, (long)i * a);
    }

    public final long a(long l, long l1)
    {
        long l2 = a;
        if (l2 != 1L)
        {
            if (l1 == 1L)
            {
                l1 = l2;
            } else
            if (l1 == 0L || l2 == 0L)
            {
                l1 = 0L;
            } else
            {
                long l3 = l1 * l2;
                if (l3 / l2 != l1 || l1 == 0x8000000000000000L && l2 == -1L || l2 == 0x8000000000000000L && l1 == -1L)
                {
                    throw new ArithmeticException((new StringBuilder("Multiplication overflows a long: ")).append(l1).append(" * ").append(l2).toString());
                }
                l1 = l3;
            }
        }
        return g.a(l, l1);
    }

    public final long c(long l, long l1)
    {
        return g.b(l, l1) / a;
    }

    public final boolean c()
    {
        return true;
    }

    public final long d()
    {
        return a;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof n)
            {
                if (super.d != ((c) (obj = (n)obj)).d || a != ((n) (obj)).a)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        long l = a;
        return (int)(l ^ l >>> 32) + super.d.hashCode();
    }
}
