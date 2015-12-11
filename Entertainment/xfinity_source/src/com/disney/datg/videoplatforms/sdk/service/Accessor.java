// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.service:
//            HttpRequestHandler

public abstract class Accessor
{

    private HttpRequestHandler requestHandler;
    private String serviceEndpoint;
    private int timeout;

    public Accessor(String s, HttpRequestHandler httprequesthandler)
    {
        timeout = 0x7fffffff;
        setServiceEndpoint(s);
        setRequestHandler(httprequesthandler);
    }

    protected HttpRequestHandler getRequestHandler()
    {
        return requestHandler;
    }

    protected String getServiceEndpoint()
    {
        return serviceEndpoint;
    }

    protected int getTimeout()
    {
        return timeout;
    }

    protected void setRequestHandler(HttpRequestHandler httprequesthandler)
    {
        requestHandler = httprequesthandler;
    }

    protected void setServiceEndpoint(String s)
    {
        if (s != null)
        {
            serviceEndpoint = s.trim();
        }
    }
}
