// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.l;
import b.a.a.m;

// Referenced classes of package b.a.a.c:
//            c

public class e extends c
{

    final l a;

    public e(l l1, m m)
    {
        super(m);
        if (l1 == null)
        {
            throw new IllegalArgumentException("The field must not be null");
        }
        if (!l1.b())
        {
            throw new IllegalArgumentException("The field must be supported");
        } else
        {
            a = l1;
            return;
        }
    }

    public long a(long l1, int i)
    {
        return a.a(l1, i);
    }

    public long a(long l1, long l2)
    {
        return a.a(l1, l2);
    }

    public long c(long l1, long l2)
    {
        return a.c(l1, l2);
    }

    public final boolean c()
    {
        return a.c();
    }

    public long d()
    {
        return a.d();
    }
}
