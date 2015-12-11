// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.d;
import b.a.a.l;

// Referenced classes of package b.a.a.c:
//            b, g

public abstract class m extends b
{

    final long a;
    private final l b;

    public m(d d1, l l1)
    {
        super(d1);
        if (!l1.c())
        {
            throw new IllegalArgumentException("Unit duration field must be precise");
        }
        a = l1.d();
        if (a < 1L)
        {
            throw new IllegalArgumentException("The unit milliseconds must be at least 1");
        } else
        {
            b = l1;
            return;
        }
    }

    public long b(long l1, int j)
    {
        b.a.a.c.g.a(this, j, g(), c(l1, j));
        return (long)(j - a(l1)) * a + l1;
    }

    public int c(long l1, int j)
    {
        return c(l1);
    }

    public long d(long l1)
    {
        if (l1 >= 0L)
        {
            return l1 - l1 % a;
        } else
        {
            l1 = 1L + l1;
            return l1 - l1 % a - a;
        }
    }

    public final l d()
    {
        return b;
    }

    public long e(long l1)
    {
        if (l1 > 0L)
        {
            l1--;
            return (l1 - l1 % a) + a;
        } else
        {
            return l1 - l1 % a;
        }
    }

    public int g()
    {
        return 0;
    }

    public long i(long l1)
    {
        if (l1 >= 0L)
        {
            return l1 % a;
        } else
        {
            return ((l1 + 1L) % a + a) - 1L;
        }
    }
}
