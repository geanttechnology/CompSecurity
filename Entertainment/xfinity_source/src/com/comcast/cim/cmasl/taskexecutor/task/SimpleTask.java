// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.task;


// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.task:
//            Task

public abstract class SimpleTask
    implements Task
{

    public SimpleTask()
    {
    }

    public void clearCachedResult()
    {
    }

    public Object getCachedResultIfAvailable()
    {
        return null;
    }

    public Object getSecondLevelStaleResultIfAvailable()
    {
        return null;
    }

    public Object getStaleResultIfAvailable()
    {
        return null;
    }
}
