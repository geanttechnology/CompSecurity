// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hal.http;

import com.comcast.cim.cmasl.http.request.RequestProvider;

public class HalRequestProvider
    implements RequestProvider
{

    private final RequestProvider delegateProvider;

    public HalRequestProvider(RequestProvider requestprovider)
    {
        delegateProvider = requestprovider;
        delegateProvider.addHeader("Accept", "application/hal+json");
    }

    public void addHeader(String s, String s1)
    {
        delegateProvider.addHeader(s, s1);
    }

    public void addHttpEntityParameter(String s, String s1)
    {
        delegateProvider.addHttpEntityParameter(s, s1);
    }

    public void addQueryParameter(String s, String s1)
    {
        delegateProvider.addHeader(s, s1);
    }

    public Object createRequest()
    {
        return delegateProvider.createRequest();
    }

    public void setSocketTimeout(long l)
    {
        delegateProvider.setSocketTimeout(l);
    }
}
