// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;

import java.util.Set;

// Referenced classes of package com.amazon.client.metrics.configuration:
//            TransportType

public interface NetworkConfiguration
{

    public abstract Set getNetworkTypes();

    public abstract TransportType getTransportType();
}
