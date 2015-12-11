// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.api.common;

import java.util.ArrayList;
import java.util.List;

public class TransactionData
{

    private final String appData;
    private final long bytesReceived;
    private final long bytesSent;
    private final String carrier;
    private int errorCode;
    private final Object errorCodeLock = new Object();
    private final int statusCode;
    private final float time;
    private final long timestamp = System.currentTimeMillis();
    private final String url;

    public TransactionData(String s, String s1, float f, int i, int j, long l, 
            long l1, String s2)
    {
        int i1 = s.indexOf('?');
        int k = i1;
        if (i1 < 0)
        {
            int j1 = s.indexOf(';');
            k = j1;
            if (j1 < 0)
            {
                k = s.length();
            }
        }
        url = s.substring(0, k);
        carrier = s1;
        time = f;
        statusCode = i;
        errorCode = j;
        bytesSent = l;
        bytesReceived = l1;
        appData = s2;
    }

    public List asList()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(url);
        arraylist.add(carrier);
        arraylist.add(Float.valueOf(time));
        arraylist.add(Integer.valueOf(statusCode));
        arraylist.add(Integer.valueOf(errorCode));
        arraylist.add(Long.valueOf(bytesSent));
        arraylist.add(Long.valueOf(bytesReceived));
        arraylist.add(appData);
        return arraylist;
    }

    public TransactionData clone()
    {
        return new TransactionData(url, carrier, time, statusCode, errorCode, bytesSent, bytesReceived, appData);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
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
        int i;
        synchronized (errorCodeLock)
        {
            i = errorCode;
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public String getUrl()
    {
        return url;
    }

    public void setErrorCode(int i)
    {
        synchronized (errorCodeLock)
        {
            errorCode = i;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
