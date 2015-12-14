// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.metric;

import android.content.Context;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;

// Referenced classes of package com.amazon.identity.platform.metric:
//            PlatformMetricsCollector, PlatformDCPMetricsTimer, PlatformMetricsTimer

class PlatformDCPMetricsCollector
    implements PlatformMetricsCollector
{

    private static final String TAG = com/amazon/identity/platform/metric/PlatformDCPMetricsCollector.getName();
    private final MetricEvent mMetricEvent;
    private final MetricsFactory mMetricsFactory;

    PlatformDCPMetricsCollector(Context context)
    {
        mMetricsFactory = AndroidMetricsFactoryImpl.getInstance(context);
        context = context.getPackageName();
        mMetricEvent = mMetricsFactory.createConcurrentMetricEvent(context, "MAPClientLib");
    }

    PlatformDCPMetricsCollector(Context context, String s)
    {
        mMetricsFactory = AndroidMetricsFactoryImpl.getInstance(context);
        context = context.getPackageName();
        mMetricEvent = mMetricsFactory.createConcurrentMetricEvent(context, s);
    }

    private MetricEvent convertMetricIdentifierToEvent(String s, String s1)
    {
        return mMetricsFactory.createMetricEvent(s, s1);
    }

    public PlatformMetricsTimer createTimer(String s)
    {
        return new PlatformDCPMetricsTimer(mMetricEvent, s);
    }

    public void incrementCounter(String s)
    {
        mMetricEvent.incrementCounter(s, 1.0D);
    }

    public void incrementCounter(String s, double d)
    {
        mMetricEvent.incrementCounter(s, (double)Math.round(d * 10D) / 10D);
    }

    public transient void incrementCounter(String s, String as[])
    {
        mMetricEvent.addCounter(s, 1.0D);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s1 = as[i];
            mMetricEvent.addCounter((new StringBuilder()).append(s).append(":").append(s1).toString(), 1.0D);
        }

    }

    public transient void incrementMetricCounter(String s, String s1, String as[])
    {
        s = convertMetricIdentifierToEvent(s, s1);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            s.incrementCounter(as[i], 1.0D);
        }

        mMetricsFactory.record(s);
    }

    public void recordEvent()
    {
        mMetricsFactory.record(mMetricEvent);
        mMetricEvent.clear();
    }

    public void recordMetricTimerEvent(String s, String s1, long l)
    {
        s = convertMetricIdentifierToEvent(s, s1);
        s.addTimer(s1, l);
        mMetricsFactory.record(s);
    }

}
