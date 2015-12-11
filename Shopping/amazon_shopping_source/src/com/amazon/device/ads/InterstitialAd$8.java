// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            InterstitialAd, AdData, MetricsCollector

class val.startTime
    implements Runnable
{

    final InterstitialAd this$0;
    final e val$metricType;
    final long val$startTime;

    public void run()
    {
        submitAndResetMetrics();
        if (val$metricType != null)
        {
            getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(val$metricType, val$startTime);
        }
    }

    e()
    {
        this$0 = final_interstitialad;
        val$metricType = e;
        val$startTime = J.this;
        super();
    }
}
