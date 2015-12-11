// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import android.os.Process;
import android.util.Log;

public class ThreadUtil
{

    public static final int BACKGROUND_THREAD_PRIORITY = 4;

    public ThreadUtil()
    {
    }

    public static void setCurrentThreadPriorityToBackground()
    {
        Log.d("setCurrentThreadPriorityToBackground", (new StringBuilder()).append("Lowered priority of ").append(Thread.currentThread().toString()).append(" to background.").toString());
        Thread.currentThread().setPriority(4);
    }

    public static void tryToBackgroundAllThreads()
    {
        Process.setThreadPriority(10);
        setCurrentThreadPriorityToBackground();
        tryToBackgroundAllThreadsInParentThreadGroup();
    }

    public static void tryToBackgroundAllThreadsInParentThreadGroup()
    {
        Thread athread[] = new Thread[Thread.currentThread().getThreadGroup().getParent().activeCount() * 2];
        Thread.currentThread().getThreadGroup().getParent().enumerate(athread, true);
        int j = athread.length;
        int i = 0;
        while (i < j) 
        {
            Thread thread = athread[i];
            if (thread != null)
            {
                try
                {
                    Log.d("tryToBackgroundAllThreadsInParentThreadGroup", (new StringBuilder()).append("Lowering thread priority of ").append(thread.toString()).append(" to ").append(4).toString());
                    thread.setPriority(4);
                }
                catch (SecurityException securityexception)
                {
                    Log.d("tryToBackgroundAllThreadsInParentThreadGroup", (new StringBuilder()).append("SecurityException while setting thread priority to background for ").append(thread.toString()).toString(), securityexception);
                }
            }
            i++;
        }
    }
}
