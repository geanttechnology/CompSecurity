// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d.a;

import sun.misc.Unsafe;

// Referenced classes of package e.d.d.a:
//            a, x

public abstract class c extends a
{

    private static final long e;
    private static final int f;
    protected final long d[];

    public c(int i)
    {
        super(i);
        i = (int)(b + 1L);
        d = new long[(i << a) + 64];
        for (long l = 0L; l < (long)i; l++)
        {
            a(d, d(l), l);
        }

    }

    protected static long a(long al[], long l)
    {
        return x.a.getLongVolatile(al, l);
    }

    protected static void a(long al[], long l, long l1)
    {
        x.a.putOrderedLong(al, l, l1);
    }

    protected final long d(long l)
    {
        return e + ((b & l) << f);
    }

    static 
    {
        if (8 == x.a.arrayIndexScale([J))
        {
            f = a + 3;
            e = x.a.arrayBaseOffset([J) + (32 << f - a);
            return;
        } else
        {
            throw new IllegalStateException("Unexpected long[] element size");
        }
    }
}
