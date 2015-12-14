// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AsyncToSyncAdapter
    implements Runnable
{

    private static final String TAG = com/amazon/identity/snds/api/AsyncToSyncAdapter.getName();
    private volatile CountDownLatch mAsyncTaskDoneLatch;
    private AtomicBoolean mHasRun;

    public AsyncToSyncAdapter()
    {
        mAsyncTaskDoneLatch = new CountDownLatch(1);
        mHasRun = new AtomicBoolean(false);
    }

    protected void asyncOperationComplete()
    {
        mAsyncTaskDoneLatch.countDown();
    }

    protected void interruptAsyncOperation()
    {
    }

    protected void onTimeout()
    {
    }

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        run(null, null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void run(Long long1, TimeUnit timeunit)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mHasRun.getAndSet(true);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        startAsyncOperation();
_L5:
        if (long1 == null) goto _L4; else goto _L3
_L3:
        if (!mAsyncTaskDoneLatch.await(long1.longValue(), timeunit))
        {
            onTimeout();
        }
_L6:
        long l = mAsyncTaskDoneLatch.getCount();
        if (l > 0L) goto _L5; else goto _L1
_L4:
        mAsyncTaskDoneLatch.await();
          goto _L6
        InterruptedException interruptedexception;
        interruptedexception;
        interruptAsyncOperation();
          goto _L6
        long1;
        throw long1;
    }

    protected abstract void startAsyncOperation();

}
