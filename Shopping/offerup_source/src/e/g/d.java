// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.g;

import e.c.a;
import e.d.c.g;
import e.h;
import e.h.b;
import e.h.e;
import e.k;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

// Referenced classes of package e.g:
//            e, b

final class d extends h
{

    private static AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(e/g/d, "a");
    volatile int a;
    private final b b = new b();
    private final e.g.e c;

    d(e.g.e e1)
    {
        c = e1;
    }

    public final k a(a a1)
    {
        return a(a1, 0L, null);
    }

    public final k a(a a1, long l, TimeUnit timeunit)
    {
        if (b.c())
        {
            return e.b();
        } else
        {
            a1 = c.b(a1, l, timeunit);
            b.a(a1);
            a1.a(b);
            return a1;
        }
    }

    public final void b()
    {
        if (d.compareAndSet(this, 0, 1))
        {
            e.g.b.c().a(c);
        }
        b.b();
    }

    public final boolean c()
    {
        return b.c();
    }

}
