// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.c;

import com.target.a.a.b;
import com.target.b.a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class d
    implements a
{

    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final String LOG_TAG = "ExecutorProvider";
    private static final Thread.UncaughtExceptionHandler sExceptionHandler = new Thread.UncaughtExceptionHandler() {

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            com.target.a.a.b.a("ExecutorProvider", (new StringBuilder()).append("Uncaught exception in thread '").append(thread.getName()).toString(), throwable);
        }

    };
    private static final ScheduledExecutorService sExecutor;
    private static final ThreadFactory sThreadFactory;

    public d()
    {
    }

    static Thread.UncaughtExceptionHandler c()
    {
        return sExceptionHandler;
    }

    public ScheduledExecutorService a()
    {
        return sExecutor;
    }

    public Object b()
    {
        return a();
    }

    static 
    {
        CPU_COUNT = Runtime.getRuntime().availableProcessors();
        CORE_POOL_SIZE = CPU_COUNT + 1;
        sThreadFactory = new ThreadFactory() {

            private final AtomicInteger mCount = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                runnable = new Thread(runnable, (new StringBuilder()).append("ExecutorProvider thread #").append(mCount.getAndIncrement()).toString());
                runnable.setUncaughtExceptionHandler(d.c());
                return runnable;
            }

        };
        sExecutor = Executors.newScheduledThreadPool(CORE_POOL_SIZE, sThreadFactory);
    }
}
