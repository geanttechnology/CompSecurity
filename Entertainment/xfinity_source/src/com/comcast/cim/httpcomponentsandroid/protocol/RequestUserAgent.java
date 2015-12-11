// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.protocol;

import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestInterceptor;
import com.comcast.cim.httpcomponentsandroid.params.HttpProtocolParams;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.protocol:
//            HttpContext

public class RequestUserAgent
    implements HttpRequestInterceptor
{

    public RequestUserAgent()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        if (httprequest == null)
        {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (!httprequest.containsHeader("User-Agent"))
        {
            httpcontext = HttpProtocolParams.getUserAgent(httprequest.getParams());
            if (httpcontext != null)
            {
                httprequest.addHeader("User-Agent", httpcontext);
            }
        }
    }
}
