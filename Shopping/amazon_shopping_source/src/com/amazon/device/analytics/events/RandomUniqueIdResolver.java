// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events;

import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.device.analytics.util.JSONSerializable;
import java.util.UUID;

// Referenced classes of package com.amazon.device.analytics.events:
//            UniqueIdResolverChain

public class RandomUniqueIdResolver extends UniqueIdResolverChain
    implements JSONSerializable
{

    private static Logger logger = Logging.getLogger(com/amazon/device/analytics/events/RandomUniqueIdResolver);
    private String uniqueId;

    public RandomUniqueIdResolver()
    {
        uniqueId = null;
        logger.v("Generating a random UUID for uniqueId");
        uniqueId = UUID.randomUUID().toString();
    }

    protected String tryResolve()
    {
        return uniqueId;
    }

    protected boolean tryStore(String s)
    {
        uniqueId = s;
        return true;
    }

}
