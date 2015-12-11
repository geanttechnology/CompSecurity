// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client;

import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.ProtocolException;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;

public interface RedirectStrategy
{

    public abstract HttpUriRequest getRedirect(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws ProtocolException;

    public abstract boolean isRedirected(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws ProtocolException;
}
