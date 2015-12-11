// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.inject;

import com.google.inject.Provider;
import com.groupon.util.PausableThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class SingleThreadPausableThreadPoolExecutorProvider
    implements Provider
{

    public SingleThreadPausableThreadPoolExecutorProvider()
    {
    }

    public PausableThreadPoolExecutor get()
    {
        return new PausableThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public volatile Object get()
    {
        return get();
    }
}
