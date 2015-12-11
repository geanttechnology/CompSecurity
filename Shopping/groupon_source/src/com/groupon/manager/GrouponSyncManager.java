// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.crittercism.app.Crittercism;
import com.groupon.util.ExecutorManager;
import com.groupon.util.MasterExecutorManager;
import com.groupon.util.PausableThreadPoolExecutor;
import com.groupon.util.TaskListener;
import commonlib.manager.SyncManager;
import java.io.IOException;
import java.util.concurrent.Callable;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class GrouponSyncManager extends SyncManager
{
    protected static class PriorityExecutorCallable
        implements Callable
    {

        private Callable callable;
        private PausableThreadPoolExecutor executor;
        private TaskListener listener;

        public Object call()
            throws Exception
        {
            Object obj = callable.call();
            listener.onTaskComplete(executor);
            return obj;
            Exception exception;
            exception;
            listener.onTaskComplete(executor);
            throw exception;
        }

        public PriorityExecutorCallable(Callable callable1, PausableThreadPoolExecutor pausablethreadpoolexecutor, TaskListener tasklistener)
        {
            callable = callable1;
            executor = pausablethreadpoolexecutor;
            listener = tasklistener;
        }
    }

    protected static class PriorityExecutorRunnable
        implements Runnable
    {

        private PausableThreadPoolExecutor executor;
        private TaskListener listener;
        private Runnable runnable;

        public void run()
        {
            runnable.run();
            listener.onTaskComplete(executor);
            return;
            Exception exception;
            exception;
            listener.onTaskComplete(executor);
            throw exception;
        }

        public PriorityExecutorRunnable(Runnable runnable1, PausableThreadPoolExecutor pausablethreadpoolexecutor, TaskListener tasklistener)
        {
            runnable = runnable1;
            executor = pausablethreadpoolexecutor;
            listener = tasklistener;
        }
    }


    private MasterExecutorManager masterExecutorManager;

    public GrouponSyncManager(Context context)
    {
        super(context);
    }

    public GrouponSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        this(context, pausablethreadpoolexecutor, (ExecutorManager)RoboGuice.getInjector(context).getInstance(com/groupon/util/ExecutorManager));
    }

    public GrouponSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, ExecutorManager executormanager)
    {
        super(context, pausablethreadpoolexecutor);
        masterExecutorManager = (MasterExecutorManager)RoboGuice.getInjector(context).getInstance(com/groupon/util/MasterExecutorManager);
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
            super.execute(new PriorityExecutorRunnable(runnable, (PausableThreadPoolExecutor)executor, masterExecutorManager));
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
            super.submit(new PriorityExecutorRunnable(runnable, (PausableThreadPoolExecutor)executor, masterExecutorManager));
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
            super.submit(new PriorityExecutorCallable(callable, (PausableThreadPoolExecutor)executor, masterExecutorManager));
            masterExecutorManager.notifyUpdate();
            return;
        }
    }
}
