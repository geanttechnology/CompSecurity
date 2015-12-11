// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;


// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticsControllerImpl

static class eDataType
{

    static final int $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[];

    static 
    {
        $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType = new int[eDataType.values().length];
        try
        {
            $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[eDataType.STRING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[eDataType.FLOAT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[eDataType.BOOLEAN.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
