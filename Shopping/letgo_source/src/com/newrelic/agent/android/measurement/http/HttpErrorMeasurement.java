// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.measurement.http;

import com.newrelic.agent.android.measurement.BaseMeasurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import java.util.Map;

public class HttpErrorMeasurement extends BaseMeasurement
{

    private int httpStatusCode;
    private Map params;
    private String responseBody;
    private String stackTrace;
    private String url;

    public HttpErrorMeasurement(String s, int i)
    {
        super(MeasurementType.HttpError);
        setUrl(s);
        setName(s);
        setHttpStatusCode(i);
        setStartTime(System.currentTimeMillis());
    }

    public int getHttpStatusCode()
    {
        return httpStatusCode;
    }

    public Map getParams()
    {
        return params;
    }

    public String getResponseBody()
    {
        return responseBody;
    }

    public String getStackTrace()
    {
        return stackTrace;
    }

    public String getUrl()
    {
        return url;
    }

    public void setHttpStatusCode(int i)
    {
        httpStatusCode = i;
    }

    public void setParams(Map map)
    {
        params = map;
    }

    public void setResponseBody(String s)
    {
        responseBody = s;
    }

    public void setStackTrace(String s)
    {
        stackTrace = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
