// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.support.v7:
//            ane, ann, anl, anj

public class anm extends ThreadPoolExecutor
{
    protected static final class a
        implements ThreadFactory
    {

        private final int a;

        public Thread newThread(Runnable runnable)
        {
            runnable = new Thread(runnable);
            runnable.setPriority(a);
            runnable.setName("Queue");
            return runnable;
        }

        public a(int i)
        {
            a = i;
        }
    }


    private static final int a;
    private static final int b;
    private static final int c;

    anm(int i, int j, long l, TimeUnit timeunit, ane ane1, ThreadFactory threadfactory)
    {
        super(i, j, l, timeunit, ane1, threadfactory);
        prestartAllCoreThreads();
    }

    public static anm a()
    {
        return a(b, c);
    }

    public static anm a(int i, int j)
    {
        return new anm(i, j, 1L, TimeUnit.SECONDS, new ane(), new a(10));
    }

    protected void afterExecute(Runnable runnable, Throwable throwable)
    {
        ann ann1 = (ann)runnable;
        ann1.setFinished(true);
        ann1.setError(throwable);
        b().d();
        super.afterExecute(runnable, throwable);
    }

    public ane b()
    {
        return (ane)super.getQueue();
    }

    public void execute(Runnable runnable)
    {
        if (anl.isProperDelegate(runnable))
        {
            super.execute(runnable);
            return;
        } else
        {
            super.execute(newTaskFor(runnable, null));
            return;
        }
    }

    public BlockingQueue getQueue()
    {
        return b();
    }

    protected RunnableFuture newTaskFor(Runnable runnable, Object obj)
    {
        return new anj(runnable, obj);
    }

    protected RunnableFuture newTaskFor(Callable callable)
    {
        return new anj(callable);
    }

    static 
    {
        a = Runtime.getRuntime().availableProcessors();
        b = a + 1;
        c = a * 2 + 1;
    }
}
