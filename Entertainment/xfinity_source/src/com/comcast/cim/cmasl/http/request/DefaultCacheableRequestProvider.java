// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.request;


// Referenced classes of package com.comcast.cim.cmasl.http.request:
//            CacheableRequestProvider, RequestProvider

public class DefaultCacheableRequestProvider
    implements CacheableRequestProvider
{

    private final String cacheKey;
    private final RequestProvider _flddelegate;

    public DefaultCacheableRequestProvider(RequestProvider requestprovider, String s)
    {
        _flddelegate = requestprovider;
        cacheKey = s;
    }

    public void addHeader(String s, String s1)
    {
        _flddelegate.addHeader(s, s1);
    }

    public void addHttpEntityParameter(String s, String s1)
    {
        _flddelegate.addHttpEntityParameter(s, s1);
    }

    public void addQueryParameter(String s, String s1)
    {
        _flddelegate.addQueryParameter(s, s1);
    }

    public Object createRequest()
    {
        return _flddelegate.createRequest();
    }

    public String getCacheKey()
    {
        return cacheKey;
    }

    public void setSocketTimeout(long l)
    {
        _flddelegate.setSocketTimeout(l);
    }
}
