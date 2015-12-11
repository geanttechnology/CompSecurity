// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.nautilus.domain.dcs.DcsNautilusInteger;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            GetFollowsLoadTask

static final class cheConfig extends cheConfig
{

    public boolean enablePersistence()
    {
        return true;
    }

    public long getMaxTtl()
    {
        return (long)DeviceConfiguration.getAsync().get(DcsNautilusInteger.searchFollowMaxFollowCacheTtlInMinutes) * 60000L;
    }

    cheConfig()
    {
    }
}
