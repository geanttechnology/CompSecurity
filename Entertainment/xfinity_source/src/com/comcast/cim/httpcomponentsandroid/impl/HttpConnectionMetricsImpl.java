// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl;

import com.comcast.cim.httpcomponentsandroid.HttpConnectionMetrics;
import com.comcast.cim.httpcomponentsandroid.io.HttpTransportMetrics;

public class HttpConnectionMetricsImpl
    implements HttpConnectionMetrics
{

    private final HttpTransportMetrics inTransportMetric;
    private final HttpTransportMetrics outTransportMetric;
    private long requestCount;
    private long responseCount;

    public HttpConnectionMetricsImpl(HttpTransportMetrics httptransportmetrics, HttpTransportMetrics httptransportmetrics1)
    {
        requestCount = 0L;
        responseCount = 0L;
        inTransportMetric = httptransportmetrics;
        outTransportMetric = httptransportmetrics1;
    }

    public long getReceivedBytesCount()
    {
        if (inTransportMetric != null)
        {
            return inTransportMetric.getBytesTransferred();
        } else
        {
            return -1L;
        }
    }

    public long getRequestCount()
    {
        return requestCount;
    }

    public long getResponseCount()
    {
        return responseCount;
    }

    public long getSentBytesCount()
    {
        if (outTransportMetric != null)
        {
            return outTransportMetric.getBytesTransferred();
        } else
        {
            return -1L;
        }
    }

    public void incrementRequestCount()
    {
        requestCount = requestCount + 1L;
    }

    public void incrementResponseCount()
    {
        responseCount = responseCount + 1L;
    }
}
