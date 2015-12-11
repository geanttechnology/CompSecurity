// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import java.util.Set;

// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticsEvent, AnalyticsEventCategory

public class InteractionEvent extends AnalyticsEvent
{

    public InteractionEvent(String s)
    {
        super(s, AnalyticsEventCategory.Interaction);
    }

    public InteractionEvent(String s, Set set)
    {
        super(s, AnalyticsEventCategory.Interaction, "Mobile", set);
    }
}
