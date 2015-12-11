// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import com.amazon.dp.logger.DPLogger;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.amazon.communication:
//            WakeLockHoldingScheduledThreadPoolExecutor

private static class mCallable
    implements ScheduledFuture
{

    private e mCallable;
    private ScheduledFuture mDelegate;

    public boolean cancel(boolean flag)
    {
        WakeLockHoldingScheduledThreadPoolExecutor.access$000().debug("WakeLockHoldingFuture.cancel", "cancel scheduled task", new Object[] {
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

    public e(ScheduledFuture scheduledfuture, e e)
    {
        mDelegate = scheduledfuture;
        mCallable = e;
    }
}
