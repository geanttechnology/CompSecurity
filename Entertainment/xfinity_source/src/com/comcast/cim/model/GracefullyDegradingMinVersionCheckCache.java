// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model;

import com.comcast.cim.cmasl.taskexecutor.task.GracefullyDegradingTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GracefullyDegradingMinVersionCheckCache extends GracefullyDegradingTask
{

    private final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/model/GracefullyDegradingMinVersionCheckCache);

    public GracefullyDegradingMinVersionCheckCache(Task task)
    {
        super(task);
    }

    protected Integer getDefaultValue()
    {
        return Integer.valueOf(0);
    }

    protected volatile Object getDefaultValue()
    {
        return getDefaultValue();
    }

    protected void handleException(Throwable throwable)
    {
        LOG.error("Exception while retrieving minimum version, assuming no minimum version set", throwable);
    }
}
