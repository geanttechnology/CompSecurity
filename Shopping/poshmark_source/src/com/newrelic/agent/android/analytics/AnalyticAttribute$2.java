// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;


// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticAttribute

static class tributeDataType
{

    static final int $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[];

    static 
    {
        $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType = new int[tributeDataType.values().length];
        try
        {
            $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[tributeDataType.VOID.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[tributeDataType.STRING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[tributeDataType.FLOAT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[tributeDataType.BOOLEAN.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
