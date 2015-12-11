// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.analytics;

import com.comcast.cim.cmasl.http.request.RequestProvider;
import java.util.Map;

public abstract class AnalyticsRequestProvider
    implements RequestProvider
{

    private RequestProvider delegateRequestProvider;

    public AnalyticsRequestProvider(RequestProvider requestprovider)
    {
        delegateRequestProvider = requestprovider;
    }

    public abstract void addDataPairs(Map map);

    public void addHeader(String s, String s1)
    {
        delegateRequestProvider.addHeader(s, s1);
    }

    public void addHttpEntityParameter(String s, String s1)
    {
        delegateRequestProvider.addHttpEntityParameter(s, s1);
    }

    public void addQueryParameter(String s, String s1)
    {
        delegateRequestProvider.addQueryParameter(s, s1);
    }

    public Object createRequest()
    {
        return delegateRequestProvider.createRequest();
    }

    public void setSocketTimeout(long l)
    {
        delegateRequestProvider.setSocketTimeout(l);
    }
}
