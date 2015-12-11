// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.g;

import e.h;
import e.h.a;
import e.h.e;
import e.k;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

// Referenced classes of package e.g:
//            n, m, g

class l extends h
    implements k
{

    private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(e/g/l, "a");
    volatile int a;
    private final PriorityBlockingQueue c;
    private final a d;
    private final AtomicInteger e;

    private l()
    {
        c = new PriorityBlockingQueue();
        d = new a();
        e = new AtomicInteger();
    }

    l(byte byte0)
    {
        this();
    }

    private k a(e.c.a a1, long l1)
    {
        if (d.c())
        {
            return e.h.e.b();
        }
        a1 = new n(a1, Long.valueOf(l1), b.incrementAndGet(this), (byte)0);
        c.add(a1);
        if (e.getAndIncrement() == 0)
        {
            do
            {
                a1 = (n)c.poll();
                if (a1 != null)
                {
                    ((n) (a1)).a.a();
                }
            } while (e.decrementAndGet() > 0);
            return e.h.e.b();
        } else
        {
            return e.h.e.a(new m(this, a1));
        }
    }

    static PriorityBlockingQueue a(l l1)
    {
        return l1.c;
    }

    public final k a(e.c.a a1)
    {
        return a(a1, System.currentTimeMillis());
    }

    public final k a(e.c.a a1, long l1, TimeUnit timeunit)
    {
        l1 = System.currentTimeMillis() + timeunit.toMillis(l1);
        return a(((e.c.a) (new g(a1, this, l1))), l1);
    }

    public final void b()
    {
        d.b();
    }

    public final boolean c()
    {
        return d.c();
    }

}
