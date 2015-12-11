// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;

import java.util.Set;

// Referenced classes of package com.amazon.client.metrics.configuration:
//            NetworkConfiguration, TransportType

public class MetricsNetworkConfiguration
    implements NetworkConfiguration
{

    final Set mNetworkTypes;
    TransportType mTransportType;

    public MetricsNetworkConfiguration(TransportType transporttype, Set set)
    {
        if (transporttype == null)
        {
            throw new IllegalArgumentException("tranportType is null in configuration");
        }
        if (set == null || set.isEmpty())
        {
            throw new IllegalArgumentException("networkTypes is null or empty in configuration");
        } else
        {
            mTransportType = transporttype;
            mNetworkTypes = set;
            return;
        }
    }

    public Set getNetworkTypes()
    {
        return mNetworkTypes;
    }

    public TransportType getTransportType()
    {
        return mTransportType;
    }
}
