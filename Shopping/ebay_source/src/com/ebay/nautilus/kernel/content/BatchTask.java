// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;

import com.ebay.nautilus.kernel.NautilusKernel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class BatchTask
    implements Runnable
{

    private static final int SHARED_POOL_SIZE = 5;
    private static final ScheduledExecutorService _sharedScheduler = Executors.newScheduledThreadPool(5);
    private long _delayMs;
    private volatile boolean _scheduled;
    private final ScheduledExecutorService _scheduler;
    private volatile ArrayList _workList;

    public BatchTask(long l)
    {
        _workList = new ArrayList();
        _delayMs = l;
        _scheduler = _sharedScheduler;
    }

    public BatchTask(long l, int i)
    {
        _workList = new ArrayList();
        _delayMs = l;
        _scheduler = Executors.newScheduledThreadPool(i);
    }

    private void scheduleWork()
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag = flag1;
        if (_scheduled)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        flag = flag1;
        if (_workList.isEmpty())
        {
            break MISSING_BLOCK_LABEL_32;
        }
        _scheduled = true;
        flag = true;
        this;
        JVM INSTR monitorexit ;
        if (flag)
        {
            _scheduler.schedule(this, getDelay(), TimeUnit.MILLISECONDS);
        }
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public long getDelay()
    {
        return _delayMs;
    }

    public void offer(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        _workList.add(obj);
        this;
        JVM INSTR monitorexit ;
        scheduleWork();
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void offerAndWait(Object obj)
        throws InterruptedException
    {
        NautilusKernel.verifyNotMain();
        offer(obj);
        obj;
        JVM INSTR monitorenter ;
        obj.wait();
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public abstract boolean onBatch(List list);

    public void run()
    {
        ArrayList arraylist = new ArrayList();
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        obj1 = _workList;
        _workList = arraylist;
        _scheduled = false;
        this;
        JVM INSTR monitorexit ;
        if (onBatch(((List) (obj1))))
        {
            for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
            {
                synchronized (((Iterator) (obj1)).next())
                {
                    obj.notify();
                }
            }

        }
        break MISSING_BLOCK_LABEL_77;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setDelay(long l)
    {
        _delayMs = l;
    }

    public void shutdownNow()
    {
        if (_scheduler != _sharedScheduler)
        {
            _scheduler.shutdownNow();
        }
    }

}
