// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.entitlement;

import com.comcast.cim.cmasl.taskexecutor.task.GracefullyDegradingTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.xip.XipHttpErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.entitlement:
//            NullVideoEntitlement, VideoEntitlement

public class GracefullyDegradingVideoEntitlementCache extends GracefullyDegradingTask
{

    private final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/entitlement/GracefullyDegradingVideoEntitlementCache);

    public GracefullyDegradingVideoEntitlementCache(Task task)
    {
        super(task);
    }

    protected VideoEntitlement getDefaultValue()
    {
        return new NullVideoEntitlement();
    }

    protected volatile Object getDefaultValue()
    {
        return getDefaultValue();
    }

    protected void handleException(Throwable throwable)
    {
        if ((throwable instanceof XipHttpErrorException) && ((XipHttpErrorException)throwable).getDetailedStatusCode() == 3009)
        {
            throw (XipHttpErrorException)throwable;
        } else
        {
            LOG.error("Exception while retrieving video entitlement, using null entitlement", throwable);
            return;
        }
    }
}
