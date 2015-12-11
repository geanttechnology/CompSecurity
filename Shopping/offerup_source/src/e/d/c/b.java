// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.c;

import e.c.a;
import e.d.d.p;
import e.h;
import e.h.e;
import e.k;
import java.util.concurrent.TimeUnit;

// Referenced classes of package e.d.c:
//            d

final class b extends h
{

    private final p a = new p();
    private final e.h.b b = new e.h.b();
    private final p c;
    private final d d;

    b(d d1)
    {
        c = new p(new k[] {
            a, b
        });
        d = d1;
    }

    public final k a(a a1)
    {
        if (c.c())
        {
            return e.b();
        } else
        {
            return d.a(a1, 0L, null, a);
        }
    }

    public final k a(a a1, long l, TimeUnit timeunit)
    {
        if (c.c())
        {
            return e.b();
        } else
        {
            return d.a(a1, l, timeunit, b);
        }
    }

    public final void b()
    {
        c.b();
    }

    public final boolean c()
    {
        return c.c();
    }
}
