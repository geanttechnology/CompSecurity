// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import java.util.Set;

// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticsEvent, AnalyticsEventCategory

public class SessionEvent extends AnalyticsEvent
{

    public SessionEvent()
    {
        super(null, AnalyticsEventCategory.Session);
    }

    public SessionEvent(Set set)
    {
        super(null, AnalyticsEventCategory.Session, "Mobile", set);
    }
}
