// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils.executor;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExceptionHandlingSingleThreadExecutor extends ThreadPoolExecutor
{

    private String name;

    public ExceptionHandlingSingleThreadExecutor(String s)
    {
        super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        name = s;
    }

    protected void afterExecute(Runnable runnable, Throwable throwable)
    {
        super.afterExecute(runnable, throwable);
        if (throwable != null || !(runnable instanceof Future))
        {
            break MISSING_BLOCK_LABEL_27;
        }
        ((Future)runnable).get();
        return;
        runnable;
        runnable = runnable.getCause();
        throw new RuntimeException((new StringBuilder()).append(name).append(": exception occurred in background task").toString(), runnable);
        runnable;
        return;
        runnable;
    }
}
