// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.measurement.http;

import com.newrelic.agent.android.measurement.BaseMeasurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.Util;

public class HttpTransactionMeasurement extends BaseMeasurement
{

    private String appData;
    private long bytesReceived;
    private long bytesSent;
    private int errorCode;
    private String httpMethod;
    private int statusCode;
    private double totalTime;
    private String url;

    public HttpTransactionMeasurement(String s, String s1, int i, int j, long l, double d, long l1, long l2, String s2)
    {
        this(s, s1, i, l, d, l1, l2, s2);
        errorCode = j;
    }

    public HttpTransactionMeasurement(String s, String s1, int i, long l, double d, 
            long l1, long l2, String s2)
    {
        super(MeasurementType.Network);
        s = Util.sanitizeUrl(s);
        setName(s);
        setScope(TraceMachine.getCurrentScope());
        setStartTime(l);
        setEndTime((long)(int)d + l);
        setExclusiveTime((int)(1000D * d));
        url = s;
        httpMethod = s1;
        statusCode = i;
        bytesSent = l1;
        bytesReceived = l2;
        totalTime = d;
        appData = s2;
    }

    public double asDouble()
    {
        return totalTime;
    }

    public String getAppData()
    {
        return appData;
    }

    public long getBytesReceived()
    {
        return bytesReceived;
    }

    public long getBytesSent()
    {
        return bytesSent;
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public String getHttpMethod()
    {
        return httpMethod;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public double getTotalTime()
    {
        return totalTime;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("HttpTransactionMeasurement{url='").append(url).append('\'').append(", httpMethod='").append(httpMethod).append('\'').append(", totalTime=").append(totalTime).append(", statusCode=").append(statusCode).append(", errorCode=").append(errorCode).append(", bytesSent=").append(bytesSent).append(", bytesReceived=").append(bytesReceived).append(", appData='").append(appData).append('\'').append('}').toString();
    }
}
