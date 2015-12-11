// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.d;

// Referenced classes of package b.a.a.c:
//            m, g

public class l extends m
{

    private final int b;
    private final b.a.a.l c;

    public l(d d, b.a.a.l l1, b.a.a.l l2)
    {
        super(d, l1);
        if (!l2.c())
        {
            throw new IllegalArgumentException("Range duration field must be precise");
        }
        b = (int)(l2.d() / super.a);
        if (b < 2)
        {
            throw new IllegalArgumentException("The effective range must be at least 2");
        } else
        {
            c = l2;
            return;
        }
    }

    public final int a(long l1)
    {
        if (l1 >= 0L)
        {
            return (int)((l1 / super.a) % (long)b);
        } else
        {
            return (b - 1) + (int)(((1L + l1) / super.a) % (long)b);
        }
    }

    public final long b(long l1, int i)
    {
        g.a(this, i, g(), b - 1);
        return (long)(i - a(l1)) * a + l1;
    }

    public final b.a.a.l e()
    {
        return c;
    }

    public final int h()
    {
        return b - 1;
    }
}
