// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.measurement.MeasurementType;

// Referenced classes of package com.newrelic.agent.android.measurement.consumer:
//            SummaryMetricMeasurementConsumer

static class 
{

    static final int $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType[];

    static 
    {
        $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType = new int[MeasurementType.values().length];
        try
        {
            $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType[MeasurementType.Method.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType[MeasurementType.Network.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType[MeasurementType.Custom.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
