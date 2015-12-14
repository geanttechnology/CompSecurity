// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.services.concurrency.DependencyPriorityBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class abw extends ThreadPoolExecutor
{

    private static final int a;
    private static final int b;
    private static final int c;

    abw(int i, int j, long l, TimeUnit timeunit, DependencyPriorityBlockingQueue dependencypriorityblockingqueue, ThreadFactory threadfactory)
    {
        super(i, j, l, timeunit, dependencypriorityblockingqueue, threadfactory);
        prestartAllCoreThreads();
    }

    public static abw a()
    {
        return a(b, c);
    }

    public static abw a(int i, int j)
    {
        return new abw(i, j, 1L, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue(), new abx(10));
    }

    protected void afterExecute(Runnable runnable, Throwable throwable)
    {
        aby aby1 = (aby)runnable;
        aby1.setFinished(true);
        aby1.setError(throwable);
        b().recycleBlockedQueue();
        super.afterExecute(runnable, throwable);
    }

    public DependencyPriorityBlockingQueue b()
    {
        return (DependencyPriorityBlockingQueue)super.getQueue();
    }

    public void execute(Runnable runnable)
    {
        if (abv.isProperDelegate(runnable))
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
        return new abt(runnable, obj);
    }

    protected RunnableFuture newTaskFor(Callable callable)
    {
        return new abt(callable);
    }

    static 
    {
        a = Runtime.getRuntime().availableProcessors();
        b = a + 1;
        c = a * 2 + 1;
    }
}
