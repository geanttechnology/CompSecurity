// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager
{

    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static ThreadManager instance;
    private static Handler uiThreadHandler;

    public ThreadManager()
    {
        uiThreadHandler = new Handler(Looper.getMainLooper());
    }

    public static ThreadManager getInstance()
    {
        com/comcast/playerplatform/primetime/android/util/ThreadManager;
        JVM INSTR monitorenter ;
        ThreadManager threadmanager;
        if (instance == null)
        {
            instance = new ThreadManager();
        }
        threadmanager = instance;
        com/comcast/playerplatform/primetime/android/util/ThreadManager;
        JVM INSTR monitorexit ;
        return threadmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public void executeOnUIThread(Runnable runnable)
    {
        uiThreadHandler.post(runnable);
    }

    public void executeRunnable(Runnable runnable)
    {
        synchronized (executorService)
        {
            executorService.execute(runnable);
        }
        return;
        runnable;
        executorservice;
        JVM INSTR monitorexit ;
        throw runnable;
    }

}
