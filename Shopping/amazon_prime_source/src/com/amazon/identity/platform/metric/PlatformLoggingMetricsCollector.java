// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.metric;

import android.text.TextUtils;
import android.util.Log;

// Referenced classes of package com.amazon.identity.platform.metric:
//            PlatformMetricsCollector, PlatformMetricsTimer

class PlatformLoggingMetricsCollector
    implements PlatformMetricsCollector
{

    private final String mTag;

    PlatformLoggingMetricsCollector(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            mTag = com/amazon/identity/platform/metric/PlatformLoggingMetricsCollector.getName();
            return;
        } else
        {
            mTag = s;
            return;
        }
    }

    public PlatformMetricsTimer createTimer(String s)
    {
        return new PlatformMetricsTimer.FakeMetricsTimer(s);
    }

    public void incrementCounter(String s)
    {
        Log.i(mTag, (new StringBuilder("Increment counter : ")).append(s).toString());
    }

    public void incrementCounter(String s, double d)
    {
        Log.i(mTag, (new StringBuilder("Increment counter : ")).append(s).append(", by : ").append(d).toString());
    }

    public transient void incrementCounter(String s, String as[])
    {
        Log.i(mTag, s);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s1 = as[i];
            Log.i(mTag, (new StringBuilder()).append(s).append(":").append(s1).toString());
        }

    }

    public transient void incrementMetricCounter(String s, String s1, String as[])
    {
        s1 = new StringBuilder("IncrementCounter: ");
        s1.append(s);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            s = as[i];
            s1.append(",").append(s).append("=1");
        }

        logMetric(s1.toString());
    }

    protected void logMetric(String s)
    {
        Log.i(mTag, s);
    }

    public void recordEvent()
    {
        Log.i(mTag, "Recording metric event object");
    }

    public void recordMetricTimerEvent(String s, String s1, long l)
    {
        logMetric(String.format("RecordTiming: %s:%s=%d", new Object[] {
            s, s1, Long.valueOf(l)
        }));
    }
}
