// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comscore.utils.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor
{

    private volatile int a;

    public CustomThreadPoolExecutor(int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue)
    {
        super(i, j, l, timeunit, blockingqueue);
    }

    protected void afterExecute(Runnable runnable, Throwable throwable)
    {
        super.afterExecute(runnable, throwable);
        a = a - 1;
    }

    protected void beforeExecute(Thread thread, Runnable runnable)
    {
        super.beforeExecute(thread, runnable);
    }

    public void execute(Runnable runnable)
    {
        super.execute(runnable);
        a = a + 1;
    }
}
