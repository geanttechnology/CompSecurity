// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;

public interface RedirectStrategy
{

    public abstract HttpUriRequest getRedirect(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws ProtocolException;

    public abstract boolean isRedirected(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws ProtocolException;
}
