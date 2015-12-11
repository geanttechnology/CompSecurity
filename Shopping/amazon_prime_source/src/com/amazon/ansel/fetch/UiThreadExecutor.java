// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class UiThreadExecutor
    implements Executor
{

    private static UiThreadExecutor instance;
    private final Handler handler = new Handler(Looper.getMainLooper());

    public UiThreadExecutor()
    {
    }

    public static UiThreadExecutor getInstance()
    {
        com/amazon/ansel/fetch/UiThreadExecutor;
        JVM INSTR monitorenter ;
        UiThreadExecutor uithreadexecutor;
        if (instance == null)
        {
            instance = new UiThreadExecutor();
        }
        uithreadexecutor = instance;
        com/amazon/ansel/fetch/UiThreadExecutor;
        JVM INSTR monitorexit ;
        return uithreadexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public void execute(Runnable runnable)
    {
        if (Thread.currentThread() == handler.getLooper().getThread())
        {
            runnable.run();
            return;
        } else
        {
            handler.post(runnable);
            return;
        }
    }
}
