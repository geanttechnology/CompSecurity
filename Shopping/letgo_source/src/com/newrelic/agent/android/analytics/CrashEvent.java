// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import java.util.Set;

// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticsEvent, AnalyticsEventCategory

public class CrashEvent extends AnalyticsEvent
{

    public CrashEvent(String s)
    {
        super(s, AnalyticsEventCategory.Crash);
    }

    public CrashEvent(String s, Set set)
    {
        super(s, AnalyticsEventCategory.Crash, "Mobile", set);
    }
}
