// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

public class RequestAcceptEncoding
    implements HttpRequestInterceptor
{

    public RequestAcceptEncoding()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        if (!httprequest.containsHeader("Accept-Encoding"))
        {
            httprequest.addHeader("Accept-Encoding", "gzip,deflate");
        }
    }
}
