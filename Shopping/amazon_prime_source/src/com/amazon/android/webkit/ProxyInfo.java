// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


public class ProxyInfo
{

    private final boolean amazonProxy;
    private final String authToken;
    private final String endpoint;

    public ProxyInfo(String s, String s1, boolean flag)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("endpoint can't be null");
        } else
        {
            endpoint = s;
            authToken = s1;
            amazonProxy = flag;
            return;
        }
    }

    public String getAuthToken()
    {
        return authToken;
    }

    public String getEndpoint()
    {
        return endpoint;
    }

    public boolean isAmazonProxy()
    {
        return amazonProxy;
    }
}
