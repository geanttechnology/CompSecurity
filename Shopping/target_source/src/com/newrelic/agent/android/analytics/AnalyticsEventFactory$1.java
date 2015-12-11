// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;


// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticsEventFactory, AnalyticsEventCategory

static class 
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
