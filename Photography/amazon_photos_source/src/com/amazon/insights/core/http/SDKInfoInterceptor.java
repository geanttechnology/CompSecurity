// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;

import com.amazon.insights.core.util.SDKInfo;

public final class SDKInfoInterceptor
    implements HttpClient.Interceptor
{

    private final SDKInfo sdkInfo;

    public SDKInfoInterceptor(SDKInfo sdkinfo)
    {
        sdkInfo = sdkinfo;
    }

    public void after(HttpClient.Response response)
    {
    }

    public void before(HttpClient.Request request)
    {
        if (request != null)
        {
            request.addHeader("x-amzn-ClientSDKVersion", String.format("%s", new Object[] {
                sdkInfo.toString()
            }));
        }
    }
}
