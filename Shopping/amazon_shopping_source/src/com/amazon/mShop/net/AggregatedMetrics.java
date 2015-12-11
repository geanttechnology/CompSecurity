// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


// Referenced classes of package com.amazon.mShop.net:
//            MetricsSender

public abstract class AggregatedMetrics
{

    public AggregatedMetrics()
    {
        if (MetricsSender.getMetricsSenderByType(getSenderType()) == null)
        {
            MetricsSender.registerMetricsSender(getSenderType(), getMetricsSender());
        }
    }

    public abstract MetricsSender getMetricsSender();

    public abstract MetricsSender.SenderType getSenderType();
}
