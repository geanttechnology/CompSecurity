// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.exceptions;

import com.comcast.cim.cmasl.utils.exceptions.CimException;

public class TaskExecutionException extends CimException
{

    public TaskExecutionException()
    {
    }

    public TaskExecutionException(Throwable throwable)
    {
        super(throwable);
    }
}
