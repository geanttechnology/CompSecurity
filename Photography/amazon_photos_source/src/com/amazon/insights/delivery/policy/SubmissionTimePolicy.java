// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery.policy;

import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.system.Preferences;
import com.amazon.insights.core.system.System;

// Referenced classes of package com.amazon.insights.delivery.policy:
//            DeliveryPolicy

public class SubmissionTimePolicy
    implements DeliveryPolicy
{

    private final InsightsContext context;
    private Long lastSubmittedTime;
    private final Long waitInterval;

    public SubmissionTimePolicy(InsightsContext insightscontext, Long long1)
    {
        context = insightscontext;
        waitInterval = long1;
        lastSubmittedTime = Long.valueOf(insightscontext.getSystem().getPreferences().getLong("SubmissionTimePolicy.submissionTime", 0L));
    }

    public void handleDeliveryAttempt(boolean flag)
    {
        if (flag)
        {
            lastSubmittedTime = Long.valueOf(System.currentTimeMillis());
            context.getSystem().getPreferences().putLong("SubmissionTimePolicy.submissionTime", lastSubmittedTime.longValue());
        }
    }

    public boolean isAllowed()
    {
        return System.currentTimeMillis() - lastSubmittedTime.longValue() > waitInterval.longValue();
    }
}
