// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.ProtocolException;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.client.RedirectHandler;
import com.comcast.cim.httpcomponentsandroid.client.RedirectStrategy;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpGet;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpHead;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;

class DefaultRedirectStrategyAdaptor
    implements RedirectStrategy
{

    private final RedirectHandler handler;

    public DefaultRedirectStrategyAdaptor(RedirectHandler redirecthandler)
    {
        handler = redirecthandler;
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
