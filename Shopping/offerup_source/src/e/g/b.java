// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.g;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package e.g:
//            a, c, e

final class b
{

    private static b d;
    private final long a;
    private final ConcurrentLinkedQueue b = new ConcurrentLinkedQueue();
    private final ScheduledExecutorService c = Executors.newScheduledThreadPool(1, e.g.a.b());

    private b(long l, TimeUnit timeunit)
    {
        a = timeunit.toNanos(60L);
        c.scheduleWithFixedDelay(new c(this), a, a, TimeUnit.NANOSECONDS);
    }

    static b c()
    {
        return d;
    }

    final e a()
    {
        while (!b.isEmpty()) 
        {
            e e1 = (e)b.poll();
            if (e1 != null)
            {
                return e1;
            }
        }
        return new e(e.g.a.c());
    }

    final void a(e e1)
    {
        e1.a(System.nanoTime() + a);
        b.offer(e1);
    }

    final void b()
    {
        if (!b.isEmpty())
        {
            long l = System.nanoTime();
            Iterator iterator = b.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                e e1 = (e)iterator.next();
                if (e1.d() > l)
                {
                    break;
                }
                if (b.remove(e1))
                {
                    e1.b();
                }
            } while (true);
        }
    }

    static 
    {
        d = new b(60L, TimeUnit.SECONDS);
    }
}
