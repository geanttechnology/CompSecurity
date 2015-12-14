// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery.policy;

import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.configuration.Configuration;

// Referenced classes of package com.amazon.insights.delivery.policy:
//            DeliveryPolicyFactory, ConnectivityPolicy, SubmissionTimePolicy, DeliveryPolicy

public class DefaultDeliveryPolicyFactory
    implements DeliveryPolicyFactory
{

    private final long backgroundSubmissionInterval;
    private final InsightsContext context;
    private final long forceSubmissionInterval;
    private final boolean isWanAllowed;

    public DefaultDeliveryPolicyFactory(InsightsContext insightscontext, boolean flag)
    {
        context = insightscontext;
        isWanAllowed = flag;
        forceSubmissionInterval = insightscontext.getConfiguration().optLong("forceSubmissionWaitTime", Long.valueOf(60L)).longValue() * 1000L;
        backgroundSubmissionInterval = insightscontext.getConfiguration().optLong("backgroundSubmissionWaitTime", Long.valueOf(0L)).longValue() * 1000L;
    }

    public DeliveryPolicy newConnectivityPolicy()
    {
        return new ConnectivityPolicy(context, isWanAllowed);
    }

    public DeliveryPolicy newForceSubmissionTimePolicy()
    {
        return new SubmissionTimePolicy(context, Long.valueOf(forceSubmissionInterval));
    }
}
