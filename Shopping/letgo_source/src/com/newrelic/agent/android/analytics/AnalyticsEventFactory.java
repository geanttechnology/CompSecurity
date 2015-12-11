// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import java.util.Set;

// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticsEventCategory, SessionEvent, InteractionEvent, CrashEvent, 
//            CustomEvent, AnalyticsEvent

public class AnalyticsEventFactory
{

    private AnalyticsEventFactory()
    {
    }

    static AnalyticsEvent createEvent(String s, AnalyticsEventCategory analyticseventcategory, String s1, Set set)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory[];

            static 
            {
                $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory = new int[AnalyticsEventCategory.values().length];
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory[AnalyticsEventCategory.Session.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory[AnalyticsEventCategory.Interaction.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory[AnalyticsEventCategory.Crash.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory[AnalyticsEventCategory.Custom.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.newrelic.agent.android.analytics.AnalyticsEventCategory[analyticseventcategory.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new SessionEvent(set);

        case 2: // '\002'
            return new InteractionEvent(s, set);

        case 3: // '\003'
            return new CrashEvent(s, set);

        case 4: // '\004'
            return new CustomEvent(s, s1, set);
        }
    }
}
