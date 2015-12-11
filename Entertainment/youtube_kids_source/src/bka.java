// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

public final class bka
    implements HttpRequestInterceptor
{

    public bka()
    {
    }

    public final void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        if (!httprequest.containsHeader("Accept-Encoding"))
        {
            httprequest.addHeader("Accept-Encoding", "gzip");
        }
    }
}
