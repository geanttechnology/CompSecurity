// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package android.support.v7:
//            amp, alt, amc

public final class amv
{

    public static ExecutorService a(String s)
    {
        ExecutorService executorservice = Executors.newSingleThreadExecutor(c(s));
        a(s, executorservice);
        return executorservice;
    }

    private static final void a(String s, ExecutorService executorservice)
    {
        a(s, executorservice, 2L, TimeUnit.SECONDS);
    }

    public static final void a(String s, ExecutorService executorservice, long l, TimeUnit timeunit)
    {
        Runtime.getRuntime().addShutdownHook(new Thread(new amp(s, executorservice, l, timeunit) {

            final String a;
            final ExecutorService b;
            final long c;
            final TimeUnit d;

            public void onRun()
            {
                try
                {
                    alt.h().a("Fabric", (new StringBuilder()).append("Executing shutdown hook for ").append(a).toString());
                    b.shutdown();
                    if (!b.awaitTermination(c, d))
                    {
                        alt.h().a("Fabric", (new StringBuilder()).append(a).append(" did not shut down in the").append(" allocated time. Requesting immediate shutdown.").toString());
                        b.shutdownNow();
                    }
                    return;
                }
                catch (InterruptedException interruptedexception)
                {
                    alt.h().a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[] {
                        a
                    }));
                }
                b.shutdownNow();
            }

            
            {
                a = s;
                b = executorservice;
                c = l;
                d = timeunit;
                super();
            }
        }, (new StringBuilder()).append("Crashlytics Shutdown Hook for ").append(s).toString()));
    }

    public static ScheduledExecutorService b(String s)
    {
        ScheduledExecutorService scheduledexecutorservice = Executors.newSingleThreadScheduledExecutor(c(s));
        a(s, scheduledexecutorservice);
        return scheduledexecutorservice;
    }

    public static final ThreadFactory c(String s)
    {
        return new ThreadFactory(s, new AtomicLong(1L)) {

            final String a;
            final AtomicLong b;

            public Thread newThread(Runnable runnable)
            {
                runnable = Executors.defaultThreadFactory().newThread(new amp(this, runnable) {

                    final Runnable a;
                    final _cls1 b;

                    public void onRun()
                    {
                        a.run();
                    }

            
            {
                b = _pcls1;
                a = runnable;
                super();
            }
                });
                runnable.setName((new StringBuilder()).append(a).append(b.getAndIncrement()).toString());
                return runnable;
            }

            
            {
                a = s;
                b = atomiclong;
                super();
            }
        };
    }
}
