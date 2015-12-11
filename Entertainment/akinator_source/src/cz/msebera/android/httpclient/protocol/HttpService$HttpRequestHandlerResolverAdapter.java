// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.RequestLine;

// Referenced classes of package cz.msebera.android.httpclient.protocol:
//            HttpRequestHandlerMapper, HttpService, HttpRequestHandlerResolver, HttpRequestHandler

private static class resolver
    implements HttpRequestHandlerMapper
{

    private final HttpRequestHandlerResolver resolver;

    public HttpRequestHandler lookup(HttpRequest httprequest)
    {
        return resolver.lookup(httprequest.getRequestLine().getUri());
    }

    public (HttpRequestHandlerResolver httprequesthandlerresolver)
    {
        resolver = httprequesthandlerresolver;
    }
}
