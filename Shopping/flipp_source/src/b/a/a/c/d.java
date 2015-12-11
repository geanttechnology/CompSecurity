// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.c;
import b.a.a.l;

// Referenced classes of package b.a.a.c:
//            b

public abstract class d extends b
{

    public final c b;

    public d(c c1, b.a.a.d d1)
    {
        super(d1);
        if (c1 == null)
        {
            throw new IllegalArgumentException("The field must not be null");
        }
        if (!c1.c())
        {
            throw new IllegalArgumentException("The field must be supported");
        } else
        {
            b = c1;
            return;
        }
    }

    public int a(long l)
    {
        return b.a(l);
    }

    public long b(long l, int i)
    {
        return b.b(l, i);
    }

    public long d(long l)
    {
        return b.d(l);
    }

    public l d()
    {
        return b.d();
    }

    public l e()
    {
        return b.e();
    }

    public int g()
    {
        return b.g();
    }

    public int h()
    {
        return b.h();
    }
}
