// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e;

import e.c.a;
import e.h.c;
import java.util.concurrent.TimeUnit;

// Referenced classes of package e:
//            k, i

public abstract class h
    implements k
{

    public h()
    {
    }

    public abstract k a(a a1);

    public final k a(a a1, long l, long l1, TimeUnit timeunit)
    {
        l1 = timeunit.toNanos(l1);
        long l2 = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        long l3 = timeunit.toNanos(l);
        c c1 = new c();
        a1 = new i(this, c1, a1, l2 + l3, l1);
        c c2 = new c();
        c1.a(c2);
        c2.a(a(a1, l, timeunit));
        return c1;
    }

    public abstract k a(a a1, long l, TimeUnit timeunit);
}
