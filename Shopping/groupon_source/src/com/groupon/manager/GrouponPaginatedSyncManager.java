// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.crittercism.app.Crittercism;
import com.groupon.util.ExecutorManager;
import com.groupon.util.MasterExecutorManager;
import com.groupon.util.PausableThreadPoolExecutor;
import commonlib.manager.PaginatedSyncManager;
import java.io.IOException;
import java.util.concurrent.Callable;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class GrouponPaginatedSyncManager extends PaginatedSyncManager
{

    private MasterExecutorManager masterExecutorManager;

    public GrouponPaginatedSyncManager(Context context)
    {
        super(context);
    }

    public GrouponPaginatedSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        this(context, pausablethreadpoolexecutor, (ExecutorManager)RoboGuice.getInjector(context).getInstance(com/groupon/util/ExecutorManager));
    }

    public GrouponPaginatedSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, ExecutorManager executormanager)
    {
        super(context, pausablethreadpoolexecutor);
        RoboGuice.getInjector(context).injectMembers(this);
        pausablethreadpoolexecutor.pause();
        executormanager.addExecutor(pausablethreadpoolexecutor);
    }

    public void execute(Runnable runnable)
    {
        if (!(executor instanceof PausableThreadPoolExecutor))
        {
            super.execute(runnable);
            return;
        } else
        {
            super.execute(new GrouponSyncManager.PriorityExecutorRunnable(runnable, (PausableThreadPoolExecutor)executor, masterExecutorManager));
            masterExecutorManager.notifyUpdate();
            return;
        }
    }

    public PausableThreadPoolExecutor getExecutor()
    {
        return (PausableThreadPoolExecutor)executor;
    }

    protected void onException(Object obj, Exception exception)
    {
        super.onException(obj, exception);
        if (!(exception instanceof IOException))
        {
            Crittercism.logHandledException(exception);
        }
    }

    public void submit(Runnable runnable)
    {
        if (!(executor instanceof PausableThreadPoolExecutor))
        {
            super.submit(runnable);
            return;
        } else
        {
            super.submit(new GrouponSyncManager.PriorityExecutorRunnable(runnable, (PausableThreadPoolExecutor)executor, masterExecutorManager));
            masterExecutorManager.notifyUpdate();
            return;
        }
    }

    public void submit(Callable callable)
    {
        if (!(executor instanceof PausableThreadPoolExecutor))
        {
            super.submit(callable);
            return;
        } else
        {
            super.submit(new GrouponSyncManager.PriorityExecutorCallable(callable, (PausableThreadPoolExecutor)executor, masterExecutorManager));
            masterExecutorManager.notifyUpdate();
            return;
        }
    }
}
