// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.c.c;
import b.a.a.i;
import b.a.a.l;

// Referenced classes of package b.a.a.b:
//            v

final class x extends c
{

    final l a;
    final boolean b;
    final i c;

    x(l l1, i j)
    {
        super(l1.a());
        if (!l1.b())
        {
            throw new IllegalArgumentException();
        } else
        {
            a = l1;
            b = v.a(l1);
            c = j;
            return;
        }
    }

    private int a(long l1)
    {
        int j = c.b(l1);
        if (((long)j + l1 ^ l1) < 0L && ((long)j ^ l1) >= 0L)
        {
            throw new ArithmeticException("Adding time zone offset caused overflow");
        } else
        {
            return j;
        }
    }

    private int b(long l1)
    {
        int j = c.c(l1);
        if ((l1 - (long)j ^ l1) < 0L && ((long)j ^ l1) < 0L)
        {
            throw new ArithmeticException("Subtracting time zone offset caused overflow");
        } else
        {
            return j;
        }
    }

    public final long a(long l1, int j)
    {
        int k = a(l1);
        l1 = a.a((long)k + l1, j);
        if (b)
        {
            j = k;
        } else
        {
            j = b(l1);
        }
        return l1 - (long)j;
    }

    public final long a(long l1, long l2)
    {
        int j = a(l1);
        l1 = a.a((long)j + l1, l2);
        if (!b)
        {
            j = b(l1);
        }
        return l1 - (long)j;
    }

    public final int b(long l1, long l2)
    {
        int k = a(l2);
        l l3 = a;
        int j;
        if (b)
        {
            j = k;
        } else
        {
            j = a(l1);
        }
        return l3.b((long)j + l1, (long)k + l2);
    }

    public final long c(long l1, long l2)
    {
        int k = a(l2);
        l l3 = a;
        int j;
        if (b)
        {
            j = k;
        } else
        {
            j = a(l1);
        }
        return l3.c((long)j + l1, (long)k + l2);
    }

    public final boolean c()
    {
        if (b)
        {
            return a.c();
        }
        return a.c() && c.c();
    }

    public final long d()
    {
        return a.d();
    }
}
