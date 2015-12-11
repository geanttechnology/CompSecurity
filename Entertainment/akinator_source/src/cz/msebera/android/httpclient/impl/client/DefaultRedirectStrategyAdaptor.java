// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.RedirectHandler;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpHead;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;

class DefaultRedirectStrategyAdaptor
    implements RedirectStrategy
{

    private final RedirectHandler handler;

    public DefaultRedirectStrategyAdaptor(RedirectHandler redirecthandler)
    {
        handler = redirecthandler;
    }

    public RedirectHandler getHandler()
    {
        return handler;
    }

    public HttpUriRequest getRedirect(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws ProtocolException
    {
        httpresponse = handler.getLocationURI(httpresponse, httpcontext);
        if (httprequest.getRequestLine().getMethod().equalsIgnoreCase("HEAD"))
        {
            return new HttpHead(httpresponse);
        } else
        {
            return new HttpGet(httpresponse);
        }
    }

    public boolean isRedirected(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws ProtocolException
    {
        return handler.isRedirectRequested(httpresponse, httpcontext);
    }
}
