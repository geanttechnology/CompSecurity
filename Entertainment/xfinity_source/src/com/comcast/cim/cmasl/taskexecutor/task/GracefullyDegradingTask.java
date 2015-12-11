// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.task;


// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.task:
//            Task

public abstract class GracefullyDegradingTask
    implements Task
{

    private final Task delegateTask;

    public GracefullyDegradingTask(Task task)
    {
        delegateTask = task;
    }

    public void clearCachedResult()
    {
        delegateTask.clearCachedResult();
    }

    public Object execute()
    {
        Object obj;
        try
        {
            obj = delegateTask.execute();
        }
        catch (Exception exception)
        {
            handleException(exception);
            return getDefaultValue();
        }
        return obj;
    }

    public Object getCachedResultIfAvailable()
    {
        return delegateTask.getCachedResultIfAvailable();
    }

    protected abstract Object getDefaultValue();

    public Object getSecondLevelStaleResultIfAvailable()
    {
        return delegateTask.getSecondLevelStaleResultIfAvailable();
    }

    public Object getStaleResultIfAvailable()
    {
        return delegateTask.getStaleResultIfAvailable();
    }

    protected abstract void handleException(Throwable throwable);
}
