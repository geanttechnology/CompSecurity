// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractListeningExecutorService, MoreExecutors

private static final class <init> extends AbstractListeningExecutorService
{

    private final Object lock;
    private int runningTasks;
    private boolean shutdown;

    private void endTask()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        int i;
        i = runningTasks - 1;
        runningTasks = i;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        lock.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void startTask()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        if (shutdown)
        {
            throw new RejectedExecutionException("Executor already shutdown");
        }
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        runningTasks = runningTasks + 1;
        obj;
        JVM INSTR monitorexit ;
    }

    public boolean awaitTermination(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        l = timeunit.toNanos(l);
        timeunit = ((TimeUnit) (lock));
        timeunit;
        JVM INSTR monitorenter ;
_L2:
        if (shutdown && runningTasks == 0)
        {
            return true;
        }
        if (l > 0L)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        timeunit;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        timeunit;
        JVM INSTR monitorexit ;
        throw exception;
        long l1;
        long l2;
        l1 = System.nanoTime();
        TimeUnit.NANOSECONDS.timedWait(lock, l);
        l2 = System.nanoTime();
        l -= l2 - l1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void execute(Runnable runnable)
    {
        startTask();
        runnable.run();
        endTask();
        return;
        runnable;
        endTask();
        throw runnable;
    }

    public boolean isShutdown()
    {
        boolean flag;
        synchronized (lock)
        {
            flag = shutdown;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isTerminated()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (shutdown && runningTasks == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void shutdown()
    {
        synchronized (lock)
        {
            shutdown = true;
            if (runningTasks == 0)
            {
                lock.notifyAll();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public List shutdownNow()
    {
        shutdown();
        return Collections.emptyList();
    }

    private ()
    {
        lock = new Object();
        runningTasks = 0;
        shutdown = false;
    }

    shutdown(shutdown shutdown1)
    {
        this();
    }
}
