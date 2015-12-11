// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import java.util.Set;

// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticsEvent, AnalyticsEventCategory

public class CustomEvent extends AnalyticsEvent
{

    public CustomEvent(String s)
    {
        super(s, AnalyticsEventCategory.Custom);
    }

    public CustomEvent(String s, String s1, Set set)
    {
        super(s, AnalyticsEventCategory.Custom, s1, set);
    }

    public CustomEvent(String s, Set set)
    {
        super(s, AnalyticsEventCategory.Custom, null, set);
    }
}
