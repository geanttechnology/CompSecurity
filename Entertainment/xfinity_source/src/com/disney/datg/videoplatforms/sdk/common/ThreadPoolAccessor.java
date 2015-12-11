// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolAccessor
{

    private static final ThreadPoolAccessor _instance = new ThreadPoolAccessor();
    private ThreadPoolExecutor executorService;

    public ThreadPoolAccessor()
    {
    }

    public static ThreadPoolAccessor getManager()
    {
        synchronized (_instance)
        {
            if (_instance.executorService == null)
            {
                _instance.setUpPool();
            }
        }
        return _instance;
        exception;
        threadpoolaccessor;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Future execute(Callable callable)
    {
        if (executorService == null)
        {
            _instance.setUpPool();
        }
        if (callable != null && (!executorService.isShutdown() || !executorService.isTerminated() || !executorService.isTerminating()))
        {
            return executorService.submit(callable);
        } else
        {
            return null;
        }
    }

    public void forceCancel()
    {
        if (executorService != null && !executorService.isShutdown())
        {
            executorService.shutdownNow();
        }
        executorService = null;
    }

    public void setUpPool()
    {
        executorService = new ThreadPoolExecutor(6, 6, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue(6));
        executorService.allowCoreThreadTimeOut(true);
    }

}
