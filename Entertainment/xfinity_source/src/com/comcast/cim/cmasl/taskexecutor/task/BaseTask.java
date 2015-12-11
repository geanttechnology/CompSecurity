// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.task;


// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.task:
//            Task

public abstract class BaseTask
    implements Task
{

    public BaseTask()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("@").append(Integer.toHexString(hashCode())).toString();
    }
}
