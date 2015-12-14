// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ThreadUtils
{
    public static class MainThreadRunnableExecutor
        implements RunnableExecutor
    {

        public void execute(Runnable runnable)
        {
            (new Handler(Looper.getMainLooper())).post(runnable);
        }

        public MainThreadRunnableExecutor()
        {
        }
    }

    public static interface RunnableExecutor
    {

        public abstract void execute(Runnable runnable);
    }

    public static class ThreadPoolRunnableExecutor
        implements RunnableExecutor
    {

        private ExecutorService executorService;

        public void execute(Runnable runnable)
        {
            executorService.submit(runnable);
        }

        public ThreadPoolRunnableExecutor()
        {
            executorService = new ThreadPoolExecutor(1, 3, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
    }

    static class ThreadVerify
    {

        private static ThreadVerify instance = new ThreadVerify();

        static ThreadVerify getInstance()
        {
            return instance;
        }

        boolean isOnMainThread()
        {
            return Looper.getMainLooper().getThread() == Thread.currentThread();
        }


        ThreadVerify()
        {
        }
    }


    private static RunnableExecutor mainThreadExecutor = new MainThreadRunnableExecutor();
    private static RunnableExecutor runnableExecutor = new ThreadPoolRunnableExecutor();

    public static void executeRunnable(Runnable runnable)
    {
        runnableExecutor.execute(runnable);
    }

    public static boolean isOnMainThread()
    {
        return ThreadVerify.getInstance().isOnMainThread();
    }

}
