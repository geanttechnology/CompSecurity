// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;

public class HttpTransaction extends HarvestableArray
{

    private String appData;
    private long bytesReceived;
    private long bytesSent;
    private String carrier;
    private int errorCode;
    private String httpMethod;
    private int statusCode;
    private Long timestamp;
    private double totalTime;
    private String url;
    private String wanType;

    public HttpTransaction()
    {
    }

    public JsonArray asJsonArray()
    {
        JsonArray jsonarray = new JsonArray();
        jsonarray.add(new JsonPrimitive(url));
        jsonarray.add(new JsonPrimitive(carrier));
        jsonarray.add(new JsonPrimitive(Double.valueOf(totalTime)));
        jsonarray.add(new JsonPrimitive(Integer.valueOf(statusCode)));
        jsonarray.add(new JsonPrimitive(Integer.valueOf(errorCode)));
        jsonarray.add(new JsonPrimitive(Long.valueOf(bytesSent)));
        jsonarray.add(new JsonPrimitive(Long.valueOf(bytesReceived)));
        Object obj;
        if (appData == null)
        {
            obj = null;
        } else
        {
            obj = new JsonPrimitive(appData);
        }
        jsonarray.add(((com.newrelic.com.google.gson.JsonElement) (obj)));
        jsonarray.add(new JsonPrimitive(wanType));
        jsonarray.add(new JsonPrimitive(httpMethod));
        return jsonarray;
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

    public String getCarrier()
    {
        return carrier;
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

    public Long getTimestamp()
    {
        return timestamp;
    }

    public double getTotalTime()
    {
        return totalTime;
    }

    public String getUrl()
    {
        return url;
    }

    public String getWanType()
    {
        return wanType;
    }

    public void setAppData(String s)
    {
        appData = s;
    }

    public void setBytesReceived(long l)
    {
        bytesReceived = l;
    }

    public void setBytesSent(long l)
    {
        bytesSent = l;
    }

    public void setCarrier(String s)
    {
        carrier = s;
    }

    public void setErrorCode(int i)
    {
        errorCode = i;
    }

    public void setHttpMethod(String s)
    {
        httpMethod = s;
    }

    public void setStatusCode(int i)
    {
        statusCode = i;
    }

    public void setTimestamp(Long long1)
    {
        timestamp = long1;
    }

    public void setTotalTime(double d)
    {
        totalTime = d;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setWanType(String s)
    {
        wanType = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("HttpTransaction{url='").append(url).append('\'').append(", carrier='").append(carrier).append('\'').append(", wanType='").append(wanType).append('\'').append(", httpMethod='").append(httpMethod).append('\'').append(", totalTime=").append(totalTime).append(", statusCode=").append(statusCode).append(", errorCode=").append(errorCode).append(", bytesSent=").append(bytesSent).append(", bytesReceived=").append(bytesReceived).append(", appData='").append(appData).append('\'').append(", timestamp=").append(timestamp).append('}').toString();
    }
}
