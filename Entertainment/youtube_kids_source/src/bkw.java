// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

public final class bkw
    implements HttpRequestInterceptor
{

    private final bkd a;

    public bkw(bkd bkd1)
    {
        a = (bkd)b.a(bkd1);
    }

    public final void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        if (a.e || a.a)
        {
            httpcontext = (HttpHost)httpcontext.getAttribute("http.target_host");
            if (httpcontext == null)
            {
                bmo.b("HttpsEnforcer: unexpected null host");
                return;
            }
            if (!httpcontext.getSchemeName().equals("https"))
            {
                if (a.d)
                {
                    httprequest = String.valueOf(httprequest);
                    bmo.b((new StringBuilder(String.valueOf(httprequest).length() + 23)).append("Insecure http request: ").append(httprequest).toString());
                }
                if (a.e)
                {
                    throw new HttpException("SSL required");
                }
            }
        }
    }
}
