// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.platform.metric.MetricUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            Tracer

public abstract class RetryLogic
{

    public RetryLogic()
    {
    }

    public static boolean isHTTP500ErrorCodeSeries(int i)
    {
        return i >= 500 && i <= 599;
    }

    public static void recordAvailability(int i, URL url, Tracer tracer)
    {
        if (i > 0)
        {
            double d = 1.0D / (double)i;
            tracer.incrementCounter(MetricUtils.getAvailabilityMetricName(url), d);
        }
    }

    public abstract boolean shouldRetry(HttpURLConnection httpurlconnection, int i, Tracer tracer)
        throws IOException;
}
