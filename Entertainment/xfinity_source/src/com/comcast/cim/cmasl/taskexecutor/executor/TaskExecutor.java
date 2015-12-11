// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.executor;

import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;

public interface TaskExecutor
{

    public abstract void cancelNotificationsFor(TaskExecutionListener taskexecutionlistener);

    public abstract TaskExecutionListener execute(TaskExecutionListener taskexecutionlistener);
}
