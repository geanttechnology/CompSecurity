// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dp.utils;

import java.util.concurrent.ScheduledThreadPoolExecutor;

// Referenced classes of package com.dp.utils:
//            DpThreadFactory, DpThreadPoolUtil

public class DpScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor
{

    protected final Thread.UncaughtExceptionHandler mExceptionHandler;
    protected final ThreadGroup mThreadGroup;

    public DpScheduledThreadPoolExecutor(int i, DpThreadFactory dpthreadfactory, Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        super(i);
        if (dpthreadfactory == null)
        {
            throw new IllegalArgumentException("threadFactory must not be null");
        } else
        {
            mThreadGroup = dpthreadfactory.getThreadGroup();
            mExceptionHandler = uncaughtexceptionhandler;
            setThreadFactory(dpthreadfactory);
            return;
        }
    }

    public DpScheduledThreadPoolExecutor(int i, String s, Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        this(i, new DpThreadFactory(s), uncaughtexceptionhandler);
    }

    protected void afterExecute(Runnable runnable, Throwable throwable)
    {
        super.afterExecute(runnable, throwable);
        DpThreadPoolUtil.afterExecute(runnable, throwable, mExceptionHandler);
    }

    public void properShutdown()
    {
        DpThreadPoolUtil.properShutdown(this, mThreadGroup);
    }

    public void properShutdown(long l, long l1, long l2)
    {
        DpThreadPoolUtil.properShutdown(this, mThreadGroup, l, l1, l2);
    }
}
