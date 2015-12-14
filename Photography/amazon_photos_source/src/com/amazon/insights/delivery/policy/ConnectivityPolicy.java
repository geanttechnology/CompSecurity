// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery.policy;

import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.configuration.Configuration;
import com.amazon.insights.core.system.Connectivity;
import com.amazon.insights.core.system.System;

// Referenced classes of package com.amazon.insights.delivery.policy:
//            DeliveryPolicy

public class ConnectivityPolicy
    implements DeliveryPolicy
{

    private final Connectivity connectivity;
    private final InsightsContext context;
    private final boolean isWanAllowed;

    public ConnectivityPolicy(InsightsContext insightscontext, boolean flag)
    {
        context = insightscontext;
        connectivity = insightscontext.getSystem().getConnectivity();
        isWanAllowed = flag;
    }

    public void handleDeliveryAttempt(boolean flag)
    {
    }

    public boolean isAllowed()
    {
label0:
        {
            boolean flag1 = false;
            boolean flag;
            if (context.getConfiguration().optBoolean("allowWANEventDelivery", Boolean.valueOf(true)).booleanValue() && isWanAllowed)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (connectivity.isConnected())
            {
                if (!connectivity.hasWifi() && !connectivity.hasWired() && (!connectivity.hasWAN() || !flag))
                {
                    break label0;
                }
                flag1 = true;
            }
            return flag1;
        }
        return false;
    }
}
