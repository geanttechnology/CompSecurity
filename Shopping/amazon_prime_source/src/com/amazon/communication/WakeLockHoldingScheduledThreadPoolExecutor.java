// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import com.amazon.dp.logger.DPLogger;
import com.dp.utils.DpScheduledThreadPoolExecutor;
import com.dp.utils.DpThreadFactory;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public class WakeLockHoldingScheduledThreadPoolExecutor extends DpScheduledThreadPoolExecutor
{
    private static class WakeLockHoldingCallable
        implements Callable
    {

        private final Callable mDelegate;
        private final PowerManagerWrapper.WakeLock mWakeLock;
        private final AtomicBoolean mWakeLockReleased = new AtomicBoolean(false);

        public Object call()
            throws Exception
        {
            Object obj = mDelegate.call();
            releaseWakeLock();
            return obj;
            Exception exception;
            exception;
            releaseWakeLock();
            throw exception;
        }

        public void releaseWakeLock()
        {
            if (mWakeLockReleased.compareAndSet(false, true))
            {
                WakeLockHoldingScheduledThreadPoolExecutor.log.verbose("WakeLockHoldingCallable.releaseWakeLock", "releasing wakeLock", new Object[] {
                    "wakeLock", mWakeLock
                });
                mWakeLock.release();
                return;
            } else
            {
                WakeLockHoldingScheduledThreadPoolExecutor.log.verbose("WakeLockHoldingCallable.releaseWakeLock", "wakeLock already released", new Object[] {
                    "wakeLock", mWakeLock
                });
                return;
            }
        }

        public WakeLockHoldingCallable(Callable callable, PowerManagerWrapper.WakeLock wakelock)
        {
            mDelegate = callable;
            mWakeLock = wakelock;
        }
    }

    private static class WakeLockHoldingFuture
        implements ScheduledFuture
    {

        private WakeLockHoldingCallable mCallable;
        private ScheduledFuture mDelegate;

        public boolean cancel(boolean flag)
        {
            WakeLockHoldingScheduledThreadPoolExecutor.log.debug("WakeLockHoldingFuture.cancel", "cancel scheduled task", new Object[] {
                "mayInterruptIfRunning", Boolean.valueOf(flag)
            });
            flag = mDelegate.cancel(flag);
            if (flag)
            {
                mCallable.releaseWakeLock();
            }
            return flag;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Delayed)obj);
        }

        public int compareTo(Delayed delayed)
        {
            return mDelegate.compareTo(delayed);
        }

        public Object get()
            throws CancellationException, ExecutionException, InterruptedException
        {
            return mDelegate.get();
        }

        public Object get(long l, TimeUnit timeunit)
            throws CancellationException, ExecutionException, InterruptedException, TimeoutException
        {
            return mDelegate.get(l, timeunit);
        }

        public long getDelay(TimeUnit timeunit)
        {
            return mDelegate.getDelay(timeunit);
        }

        public boolean isCancelled()
        {
            return mDelegate.isCancelled();
        }

        public boolean isDone()
        {
            return mDelegate.isDone();
        }

        public WakeLockHoldingFuture(ScheduledFuture scheduledfuture, WakeLockHoldingCallable wakelockholdingcallable)
        {
            mDelegate = scheduledfuture;
            mCallable = wakelockholdingcallable;
        }
    }


    private static final DPLogger log = new DPLogger("TComm.WakeLockHoldingScheduledThreadPoolExecutor");
    private final PowerManagerWrapper.WakeLock mWakeLock;

    public WakeLockHoldingScheduledThreadPoolExecutor(int i, DpThreadFactory dpthreadfactory, Thread.UncaughtExceptionHandler uncaughtexceptionhandler, PowerManagerWrapper.WakeLock wakelock)
    {
        super(i, dpthreadfactory, uncaughtexceptionhandler);
        mWakeLock = wakelock;
        mWakeLock.setReferenceCounted(true);
    }

    public WakeLockHoldingScheduledThreadPoolExecutor(int i, String s, Thread.UncaughtExceptionHandler uncaughtexceptionhandler, PowerManagerWrapper.WakeLock wakelock)
    {
        super(i, s, uncaughtexceptionhandler);
        mWakeLock = wakelock;
        mWakeLock.setReferenceCounted(true);
    }

    private ScheduledFuture schedule(Callable callable, long l, TimeUnit timeunit, PowerManagerWrapper.WakeLock wakelock)
    {
        log.verbose("schedule", "acquiring wakeLock", new Object[] {
            "wakeLock", wakelock, "delay", Long.valueOf(timeunit.toMillis(l))
        });
        if (wakelock == null)
        {
            throw new IllegalArgumentException("WakeLock cannot be null");
        }
        wakelock.acquire();
        try
        {
            callable = new WakeLockHoldingCallable(callable, wakelock);
            timeunit = super.schedule(callable, l, timeunit);
        }
        // Misplaced declaration of an exception variable
        catch (Callable callable)
        {
            log.error("schedule", "exception", new Object[] {
                callable
            });
            wakelock.release();
            throw callable;
        }
        return new WakeLockHoldingFuture(timeunit, callable);
    }

    public List invokeAll(Collection collection)
        throws InterruptedException
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public List invokeAll(Collection collection, long l, TimeUnit timeunit)
        throws InterruptedException
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Object invokeAny(Collection collection)
        throws InterruptedException, ExecutionException
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Object invokeAny(Collection collection, long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public ScheduledFuture schedule(Runnable runnable, long l, TimeUnit timeunit)
    {
        return schedule(Executors.callable(runnable), l, timeunit, mWakeLock);
    }

    public ScheduledFuture schedule(Callable callable, long l, TimeUnit timeunit)
    {
        return schedule(callable, l, timeunit, mWakeLock);
    }

    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l, long l1, TimeUnit timeunit)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l, long l1, TimeUnit timeunit)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Future submit(Runnable runnable)
    {
        return schedule(Executors.callable(runnable), 0L, TimeUnit.NANOSECONDS, mWakeLock);
    }

    public Future submit(Runnable runnable, Object obj)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Future submit(Callable callable)
    {
        return schedule(callable, 0L, TimeUnit.NANOSECONDS, mWakeLock);
    }


}
