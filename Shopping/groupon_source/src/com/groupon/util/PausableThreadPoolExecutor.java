// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PausableThreadPoolExecutor extends ThreadPoolExecutor
{
    protected class SafeShutdownRunnable
        implements Runnable
    {

        private Runnable runnable;
        final PausableThreadPoolExecutor this$0;

        public void run()
        {
            if (!isShutdown())
            {
                runnable.run();
            }
        }

        public SafeShutdownRunnable(Runnable runnable1)
        {
            this$0 = PausableThreadPoolExecutor.this;
            super();
            runnable = runnable1;
        }
    }


    private boolean isPaused;
    private final ReentrantLock pauseLock;
    private AtomicInteger taskCounter;
    private final Condition unpaused;

    public PausableThreadPoolExecutor(int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue)
    {
        super(i, j, l, timeunit, blockingqueue);
        pauseLock = new ReentrantLock();
        unpaused = pauseLock.newCondition();
        taskCounter = new AtomicInteger();
    }

    public PausableThreadPoolExecutor(int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue, RejectedExecutionHandler rejectedexecutionhandler)
    {
        super(i, j, l, timeunit, blockingqueue, rejectedexecutionhandler);
        pauseLock = new ReentrantLock();
        unpaused = pauseLock.newCondition();
        taskCounter = new AtomicInteger();
    }

    public PausableThreadPoolExecutor(int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue, ThreadFactory threadfactory)
    {
        super(i, j, l, timeunit, blockingqueue, threadfactory);
        pauseLock = new ReentrantLock();
        unpaused = pauseLock.newCondition();
        taskCounter = new AtomicInteger();
    }

    public PausableThreadPoolExecutor(int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue, ThreadFactory threadfactory, 
            RejectedExecutionHandler rejectedexecutionhandler)
    {
        super(i, j, l, timeunit, blockingqueue, threadfactory, rejectedexecutionhandler);
        pauseLock = new ReentrantLock();
        unpaused = pauseLock.newCondition();
        taskCounter = new AtomicInteger();
    }

    protected void beforeExecute(Thread thread, Runnable runnable)
    {
        super.beforeExecute(thread, runnable);
        pauseLock.lock();
        try
        {
            while (isPaused) 
            {
                unpaused.await();
            }
            break MISSING_BLOCK_LABEL_53;
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable) { }
        finally
        {
            taskCounter.decrementAndGet();
            pauseLock.unlock();
            throw thread;
        }
        thread.interrupt();
        taskCounter.decrementAndGet();
        pauseLock.unlock();
        return;
        taskCounter.decrementAndGet();
        pauseLock.unlock();
        return;
    }

    public void execute(Runnable runnable)
    {
        taskCounter.incrementAndGet();
        super.execute(new SafeShutdownRunnable(runnable));
    }

    public boolean isEmpty()
    {
        pauseLock.lock();
        if (taskCounter.get() != 0) goto _L2; else goto _L1
_L1:
        boolean flag = getQueue().isEmpty();
        if (!flag) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        pauseLock.unlock();
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        pauseLock.unlock();
        throw exception;
    }

    public boolean isPaused()
    {
        pauseLock.lock();
        boolean flag = isPaused;
        pauseLock.unlock();
        return flag;
        Exception exception;
        exception;
        pauseLock.unlock();
        throw exception;
    }

    public void pause()
    {
        pauseLock.lock();
        isPaused = true;
        pauseLock.unlock();
        return;
        Exception exception;
        exception;
        pauseLock.unlock();
        throw exception;
    }

    public void resume()
    {
        pauseLock.lock();
        isPaused = false;
        unpaused.signalAll();
        pauseLock.unlock();
        return;
        Exception exception;
        exception;
        pauseLock.unlock();
        throw exception;
    }

    public void shutdown()
    {
        super.shutdown();
        resume();
    }
}
