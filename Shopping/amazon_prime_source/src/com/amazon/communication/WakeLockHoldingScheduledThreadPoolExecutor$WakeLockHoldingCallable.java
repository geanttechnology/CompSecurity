// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import com.amazon.dp.logger.DPLogger;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.communication:
//            WakeLockHoldingScheduledThreadPoolExecutor

private static class mWakeLock
    implements Callable
{

    private final Callable mDelegate;
    private final mWakeLock mWakeLock;
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
            WakeLockHoldingScheduledThreadPoolExecutor.access$000().verbose("WakeLockHoldingCallable.releaseWakeLock", "releasing wakeLock", new Object[] {
                "wakeLock", mWakeLock
            });
            mWakeLock.mWakeLock();
            return;
        } else
        {
            WakeLockHoldingScheduledThreadPoolExecutor.access$000().verbose("WakeLockHoldingCallable.releaseWakeLock", "wakeLock already released", new Object[] {
                "wakeLock", mWakeLock
            });
            return;
        }
    }

    public a(Callable callable, a a)
    {
        mDelegate = callable;
        mWakeLock = a;
    }
}
