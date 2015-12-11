// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.util.android;

import android.os.Handler;
import android.os.Looper;

public class ThreadManager
{

    private static ThreadManager instance;
    private static Handler uiThread;

    public ThreadManager()
    {
        uiThread = new Handler(Looper.getMainLooper());
    }

    public static ThreadManager getInstance()
    {
        com/comcast/playerplatform/util/android/ThreadManager;
        JVM INSTR monitorenter ;
        ThreadManager threadmanager;
        if (instance == null)
        {
            instance = new ThreadManager();
        }
        threadmanager = instance;
        com/comcast/playerplatform/util/android/ThreadManager;
        JVM INSTR monitorexit ;
        return threadmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public void executeOnUIThread(Runnable runnable)
    {
        uiThread.post(runnable);
    }
}
