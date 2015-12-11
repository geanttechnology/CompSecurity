// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.events.activity.OnDestroyEvent;
import com.groupon.events.activity.OnResumeEvent;

// Referenced classes of package com.groupon.util:
//            ExecutorManager, TaskListener, PausableThreadPoolExecutor

public class MasterExecutorManager extends ExecutorManager
    implements TaskListener
{

    public MasterExecutorManager()
    {
        super(null);
    }

    public void activityOnDestroy(OnDestroyEvent ondestroyevent)
    {
    }

    public void activityOnResume(OnResumeEvent onresumeevent)
    {
    }

    public void notifyUpdate()
    {
        this;
        JVM INSTR monitorenter ;
        if (!hasTaskRunning())
        {
            turnOnNextExecutor();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onTaskComplete(PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        turnOnNextExecutor();
    }
}
