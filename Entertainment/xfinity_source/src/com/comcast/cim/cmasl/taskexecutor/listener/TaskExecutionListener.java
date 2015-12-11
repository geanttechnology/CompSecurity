// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.listener;

import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;

public interface TaskExecutionListener
{

    public abstract void onError(TaskExecutionException taskexecutionexception);

    public abstract void onPostExecute(Object obj);

    public abstract void onPreAsynchronousExecute();

    public abstract void onStaleResultAvailable(Object obj);
}
