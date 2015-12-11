// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e;

import e.c.a;
import e.h.c;
import java.util.concurrent.TimeUnit;

// Referenced classes of package e:
//            h

final class i
    implements a
{

    private long a;
    private c b;
    private a c;
    private long d;
    private long e;
    private h f;

    i(h h1, c c1, a a1, long l, long l1)
    {
        f = h1;
        b = c1;
        c = a1;
        d = l;
        e = l1;
        super();
        a = 0L;
    }

    public final void a()
    {
        if (!b.c())
        {
            c.a();
            long l = d;
            long l1 = a + 1L;
            a = l1;
            long l2 = e;
            b.a(f.a(this, (l + l1 * l2) - TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis()), TimeUnit.NANOSECONDS));
        }
    }
}
