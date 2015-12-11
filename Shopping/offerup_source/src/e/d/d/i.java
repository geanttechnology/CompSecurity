// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d;

import e.a;
import e.c.d;
import e.g;

// Referenced classes of package e.d.d:
//            j, k, m, n

public final class i extends a
{

    private final Object b;

    private i(Object obj)
    {
        super(new j(obj));
        b = obj;
    }

    static Object a(i l)
    {
        return l.b;
    }

    public static final i b(Object obj)
    {
        return new i(obj);
    }

    public final Object b()
    {
        return b;
    }

    public final a c(d d)
    {
        return a(new k(this, d));
    }

    public final a c(g g)
    {
        if (g instanceof e.d.c.a)
        {
            return a(new m((e.d.c.a)g, b));
        } else
        {
            return a(new n(g, b));
        }
    }
}
