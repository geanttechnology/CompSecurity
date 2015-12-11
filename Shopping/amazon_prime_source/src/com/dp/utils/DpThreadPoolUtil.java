// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dp.utils;

import com.amazon.dp.logger.DPLogger;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class DpThreadPoolUtil
{

    private static final DPLogger log = new DPLogger();

    private DpThreadPoolUtil()
    {
    }

    public static void afterExecute(Runnable runnable, Throwable throwable, Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        Object obj;
        if (uncaughtexceptionhandler != null)
        {
            Thread.currentThread().setUncaughtExceptionHandler(uncaughtexceptionhandler);
        }
        obj = null;
        if (throwable != null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        throwable = obj;
        if (!(runnable instanceof Future))
        {
            break MISSING_BLOCK_LABEL_51;
        }
        runnable = (Future)runnable;
        throwable = obj;
        if (!runnable.isDone())
        {
            break MISSING_BLOCK_LABEL_51;
        }
        runnable.get();
        throwable = obj;
_L2:
        if (throwable != null)
        {
            log.error("afterExecute", "unexpected exception", new Object[] {
                "thread", Thread.currentThread().getName(), throwable
            });
            if (uncaughtexceptionhandler != null)
            {
                uncaughtexceptionhandler.uncaughtException(Thread.currentThread(), throwable);
            }
        }
        return;
        runnable;
        log.debug("afterExecute", "hit CancellationException on this thread, this  is expected if you canceled a task", new Object[] {
            "thread", Thread.currentThread().getName()
        });
        throwable = obj;
        continue; /* Loop/switch isn't completed */
        runnable;
        throwable = runnable.getCause();
        continue; /* Loop/switch isn't completed */
        runnable;
        log.verbose("afterExecute", "interrupted", new Object[0]);
        Thread.currentThread().interrupt();
        throwable = obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static ThreadGroup buildThreadGroup(String s)
    {
        return new ThreadGroup((new StringBuilder()).append(s).append("-Group").toString());
    }

    public static void properShutdown(ExecutorService executorservice, ThreadGroup threadgroup)
    {
        properShutdown(executorservice, threadgroup, 2000L, 2000L, 2000L);
    }

    public static void properShutdown(ExecutorService executorservice, ThreadGroup threadgroup, long l, long l1, long l2)
    {
        if (executorservice == null)
        {
            throw new IllegalArgumentException("threadPool must not be null.");
        }
        if (l <= 0L)
        {
            throw new IllegalArgumentException("shutdownTimeoutMs must be greater than zero");
        }
        if (l1 <= 0L)
        {
            throw new IllegalArgumentException("shutdownNowTimeoutMs must be greater than zero");
        }
        if (l2 <= 0L)
        {
            throw new IllegalArgumentException("threadJoinTimeoutMs must be greater than zero");
        }
        try
        {
            shutdownThreadpool(executorservice, l, l1);
        }
        // Misplaced declaration of an exception variable
        catch (ExecutorService executorservice)
        {
            log.error("properShutdown", "interrupted while trying to shut down the thread pool", new Object[] {
                executorservice
            });
            Thread.currentThread().interrupt();
            return;
        }
        if (threadgroup == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        waitForThreadsToTerminate(threadgroup, l2);
    }

    private static void shutdownThreadpool(ExecutorService executorservice, long l, long l1)
        throws InterruptedException
    {
        executorservice.shutdown();
        if (!executorservice.awaitTermination(l, TimeUnit.MILLISECONDS))
        {
            executorservice.shutdownNow();
            if (!executorservice.awaitTermination(l1, TimeUnit.MILLISECONDS))
            {
                log.error("shutdownThreadpool", "failed to shut down the thread pool", new Object[0]);
            }
        }
    }

    private static void waitForThreadsToTerminate(ThreadGroup threadgroup, long l)
        throws InterruptedException
    {
        long l1 = System.currentTimeMillis();
        Thread athread[] = new Thread[1];
        Thread thread;
        do
        {
            long l2;
            do
            {
                if (threadgroup.enumerate(athread) > 0)
                {
                    thread = athread[0];
                    l2 = (l1 + l) - System.currentTimeMillis();
                    if (l2 > 0L)
                    {
                        continue;
                    }
                    log.error("waitForThreadsToTerminate", "timed out waiting for threads to join", new Object[0]);
                }
                return;
            } while (thread.isDaemon());
            thread.join(l2);
        } while (thread.getState() == Thread.State.TERMINATED);
        log.error("waitForThreadsToTerminate", "thread never reached TERMINATED state", new Object[0]);
    }

}
