// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;
import com.aviary.android.feather.common.threading.ThreadPool;

// Referenced classes of package com.aviary.android.feather.library.services:
//            BaseContextService, IAviaryController

public class ThreadPoolService extends BaseContextService
{

    private final ThreadPool mExecutor = new ThreadPool(5, 19);

    public ThreadPoolService(IAviaryController iaviarycontroller)
    {
        super(iaviarycontroller);
    }

    public void dispose()
    {
        mExecutor.dispose();
    }

    public int getActiveCount()
    {
        return mExecutor.getActiveCount();
    }

    public long getCompletedTaskCount()
    {
        return mExecutor.getCompletedTaskCount();
    }

    public int getPoolSize()
    {
        return mExecutor.getPoolSize();
    }

    public long getTaskCount()
    {
        return mExecutor.getTaskCount();
    }

    public void printStats()
    {
    }

    public transient Future submit(com.aviary.android.feather.common.threading.ThreadPool.Job job, FutureListener futurelistener, Object aobj[])
    {
        return mExecutor.submit(job, futurelistener, aobj);
    }
}
