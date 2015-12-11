// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.protocol:
//            HttpContext

public class RequestUserAgent
    implements HttpRequestInterceptor
{

    private final String userAgent;

    public RequestUserAgent()
    {
        this(null);
    }

    public RequestUserAgent(String s)
    {
        userAgent = s;
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        if (!httprequest.containsHeader("User-Agent"))
        {
            httpcontext = null;
            Object obj = httprequest.getParams();
            if (obj != null)
            {
                httpcontext = (String)((HttpParams) (obj)).getParameter("http.useragent");
            }
            obj = httpcontext;
            if (httpcontext == null)
            {
                obj = userAgent;
            }
            if (obj != null)
            {
                httprequest.addHeader("User-Agent", ((String) (obj)));
            }
        }
    }
}
