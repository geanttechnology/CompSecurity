// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.util.PausableThreadPoolExecutor;
import com.groupon.util.TaskListener;

// Referenced classes of package com.groupon.manager:
//            GrouponSyncManager

protected static class listener
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

    public (Runnable runnable1, PausableThreadPoolExecutor pausablethreadpoolexecutor, TaskListener tasklistener)
    {
        runnable = runnable1;
        executor = pausablethreadpoolexecutor;
        listener = tasklistener;
    }
}
