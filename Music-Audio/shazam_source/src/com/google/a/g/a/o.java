// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import com.google.a.a.g;
import com.google.a.a.m;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.a.g.a:
//            m, b, n, k, 
//            l, j, a

public final class o
{
    private static final class a extends Enum
        implements Executor
    {

        public static final a a;
        private static final a b[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/google/a/g/a/o$a, s);
        }

        public static a[] values()
        {
            return (a[])b.clone();
        }

        public final void execute(Runnable runnable)
        {
            runnable.run();
        }

        static 
        {
            a = new a("INSTANCE");
            b = (new a[] {
                a
            });
        }

        private a(String s)
        {
            super(s, 0);
        }
    }

    private static class b extends com.google.a.g.a.b
    {

        private final ExecutorService a;

        public boolean awaitTermination(long l, TimeUnit timeunit)
        {
            return a.awaitTermination(l, timeunit);
        }

        public void execute(Runnable runnable)
        {
            a.execute(runnable);
        }

        public boolean isShutdown()
        {
            return a.isShutdown();
        }

        public boolean isTerminated()
        {
            return a.isTerminated();
        }

        public void shutdown()
        {
            a.shutdown();
        }

        public List shutdownNow()
        {
            return a.shutdownNow();
        }

        b(ExecutorService executorservice)
        {
            a = (ExecutorService)g.a(executorservice);
        }
    }

    private static final class c extends b
        implements n
    {

        final ScheduledExecutorService a;

        public final ScheduledFuture schedule(Runnable runnable, long l, TimeUnit timeunit)
        {
            runnable = k.a(runnable, null);
            return new a(runnable, a.schedule(runnable, l, timeunit));
        }

        public final ScheduledFuture schedule(Callable callable, long l, TimeUnit timeunit)
        {
            callable = k.a(callable);
            return new a(callable, a.schedule(callable, l, timeunit));
        }

        public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l, long l1, TimeUnit timeunit)
        {
            runnable = new b(runnable);
            return new a(runnable, a.scheduleAtFixedRate(runnable, l, l1, timeunit));
        }

        public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l, long l1, TimeUnit timeunit)
        {
            runnable = new b(runnable);
            return new a(runnable, a.scheduleWithFixedDelay(runnable, l, l1, timeunit));
        }

        c(ScheduledExecutorService scheduledexecutorservice)
        {
            super(scheduledexecutorservice);
            a = (ScheduledExecutorService)g.a(scheduledexecutorservice);
        }
    }

    private static final class c.a extends g.a
        implements l
    {

        private final ScheduledFuture a;

        public final boolean cancel(boolean flag)
        {
            boolean flag1 = super.cancel(flag);
            if (flag1)
            {
                a.cancel(flag);
            }
            return flag1;
        }

        public final volatile int compareTo(Object obj)
        {
            obj = (Delayed)obj;
            return a.compareTo(obj);
        }

        public final long getDelay(TimeUnit timeunit)
        {
            return a.getDelay(timeunit);
        }

        public c.a(j j, ScheduledFuture scheduledfuture)
        {
            super(j);
            a = scheduledfuture;
        }
    }

    private static final class c.b extends com.google.a.g.a.a
        implements Runnable
    {

        private final Runnable b;

        public final void run()
        {
            try
            {
                b.run();
                return;
            }
            catch (Throwable throwable)
            {
                a(throwable);
                throw m.a(throwable);
            }
        }

        public c.b(Runnable runnable)
        {
            b = (Runnable)g.a(runnable);
        }
    }


    public static com.google.a.g.a.m a(ExecutorService executorservice)
    {
        if (executorservice instanceof com.google.a.g.a.m)
        {
            return (com.google.a.g.a.m)executorservice;
        }
        if (executorservice instanceof ScheduledExecutorService)
        {
            return new c((ScheduledExecutorService)executorservice);
        } else
        {
            return new b(executorservice);
        }
    }
}
