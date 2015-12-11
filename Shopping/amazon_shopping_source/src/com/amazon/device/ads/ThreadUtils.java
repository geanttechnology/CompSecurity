// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.device.ads:
//            AndroidTargetUtils

public class ThreadUtils
{
    static class MainThreadRunnableExecutor
        implements RunnableExecutor
    {

        public void execute(Runnable runnable)
        {
            (new Handler(Looper.getMainLooper())).post(runnable);
        }

        MainThreadRunnableExecutor()
        {
        }
    }

    static interface RunnableExecutor
    {

        public abstract void execute(Runnable runnable);
    }

    static class ThreadPoolRunnableExecutor
        implements RunnableExecutor
    {

        private static final int keepAliveTimeSeconds = 30;
        private static final int maxNumberThreads = 3;
        private static final int numberThreads = 1;
        private ExecutorService executorService;

        public void execute(Runnable runnable)
        {
            executorService.submit(runnable);
        }

        ThreadPoolRunnableExecutor()
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

        static void setInstance(ThreadVerify threadverify)
        {
            instance = threadverify;
        }

        boolean isOnMainThread()
        {
            return Looper.getMainLooper().getThread() == Thread.currentThread();
        }


        ThreadVerify()
        {
        }
    }


    private static RunnableExecutor runnableExecutor = new ThreadPoolRunnableExecutor();

    public ThreadUtils()
    {
    }

    public static final transient void executeAsyncTask(AsyncTask asynctask, Object aobj[])
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            AndroidTargetUtils.executeAsyncTask(asynctask, aobj);
            return;
        } else
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable(asynctask, aobj) {

                final Object val$params[];
                final AsyncTask val$task;

                public void run()
                {
                    AndroidTargetUtils.executeAsyncTask(task, params);
                }

            
            {
                task = asynctask;
                params = aobj;
                super();
            }
            });
            return;
        }
    }

    public static void executeRunnable(Runnable runnable)
    {
        runnableExecutor.execute(runnable);
    }

    public static boolean isOnMainThread()
    {
        return ThreadVerify.getInstance().isOnMainThread();
    }

    static void setRunnableExecutor(RunnableExecutor runnableexecutor)
    {
        runnableExecutor = runnableexecutor;
    }

}
