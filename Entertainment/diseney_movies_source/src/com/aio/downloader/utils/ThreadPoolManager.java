// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolManager
{

    private static final ThreadPoolManager mThreadPoolManager = new ThreadPoolManager();
    private ExecutorService executorService;

    public ThreadPoolManager()
    {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    }

    public static ThreadPoolManager getInstance()
    {
        return mThreadPoolManager;
    }

    public void addTask(Runnable runnable)
    {
        executorService.execute(runnable);
    }

}
