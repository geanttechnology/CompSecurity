// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.os.Handler;
import android.os.Looper;
import com.millennialmedia.MMLog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadUtils
{

    private static final String TAG = com/millennialmedia/internal/utils/ThreadUtils.getSimpleName();
    private static Handler uiHandler;
    private static ExecutorService workerExecutor;
    private static Handler workerHandler;

    public ThreadUtils()
    {
    }

    public static void initialize()
    {
        if (uiHandler == null) goto _L2; else goto _L1
_L1:
        MMLog.w(TAG, "ThreadUtils already initialized");
_L4:
        return;
_L2:
        CountDownLatch countdownlatch;
        boolean flag;
        uiHandler = new Handler(Looper.getMainLooper());
        countdownlatch = new CountDownLatch(1);
        (new _cls1(countdownlatch)).start();
        workerExecutor = Executors.newCachedThreadPool();
        flag = false;
        boolean flag1 = countdownlatch.await(5000L, TimeUnit.MILLISECONDS);
        flag = flag1;
_L5:
        if (!flag)
        {
            throw new IllegalStateException("Failed to initialize ThreadUtils");
        }
        if (true) goto _L4; else goto _L3
_L3:
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception.printStackTrace();
          goto _L5
    }

    public static boolean isUiThread()
    {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void runOffUiThread(Runnable runnable)
    {
        if (isUiThread())
        {
            workerExecutor.execute(runnable);
            return;
        } else
        {
            runnable.run();
            return;
        }
    }

    public static void runOnUiThread(Runnable runnable)
    {
        if (isUiThread())
        {
            runnable.run();
            return;
        } else
        {
            uiHandler.post(runnable);
            return;
        }
    }

    public static ScheduledRunnable runOnUiThreadDelayed(Runnable runnable, long l)
    {
        runnable = new _cls2(runnable);
        uiHandler.postDelayed(runnable, l);
        return runnable;
    }

    public static void runOnWorkerThread(Runnable runnable)
    {
        workerExecutor.execute(runnable);
    }

    public static ScheduledRunnable runOnWorkerThreadDelayed(Runnable runnable, long l)
    {
        runnable = new _cls3(runnable);
        workerHandler.postDelayed(runnable, l);
        return runnable;
    }




/*
    static Handler access$002(Handler handler)
    {
        workerHandler = handler;
        return handler;
    }

*/



    // Unreferenced inner class com/millennialmedia/internal/utils/ThreadUtils$ScheduledRunnable
    /* block-local class not found */
    class ScheduledRunnable {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
