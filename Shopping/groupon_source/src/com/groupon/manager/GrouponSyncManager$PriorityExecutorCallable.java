// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.util.PausableThreadPoolExecutor;
import com.groupon.util.TaskListener;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.manager:
//            GrouponSyncManager

protected static class listener
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

    public (Callable callable1, PausableThreadPoolExecutor pausablethreadpoolexecutor, TaskListener tasklistener)
    {
        callable = callable1;
        executor = pausablethreadpoolexecutor;
        listener = tasklistener;
    }
}
