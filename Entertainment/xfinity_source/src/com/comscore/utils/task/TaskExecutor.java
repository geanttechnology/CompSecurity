// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comscore.utils.task;

import com.comscore.analytics.Core;
import com.comscore.utils.CSLog;
import com.comscore.utils.Constants;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.comscore.utils.task:
//            CustomThreadPoolExecutor

public class TaskExecutor
{

    Core a;
    private BlockingQueue e;
    private CustomThreadPoolExecutor f;

    public TaskExecutor(Core core)
    {
        e = new LinkedBlockingQueue();
        f = new CustomThreadPoolExecutor(1, 1, 20000L, TimeUnit.MILLISECONDS, e);
        a = core;
    }

    public void clear()
    {
        e.clear();
    }

    public boolean execute(Runnable runnable, boolean flag)
    {
        if (!flag)
        {
            runnable.run();
            return true;
        }
        f.execute(runnable);
        return true;
        runnable;
        if (Constants.DEBUG)
        {
            CSLog.e(getClass(), "Unable to queue a task: ");
            CSLog.printStackTrace(runnable);
            throw runnable;
        }
        break MISSING_BLOCK_LABEL_66;
        runnable;
        if (Constants.DEBUG)
        {
            CSLog.e(getClass(), "Unexpected null error: ");
            CSLog.printStackTrace(runnable);
            throw runnable;
        }
        return false;
    }
}
