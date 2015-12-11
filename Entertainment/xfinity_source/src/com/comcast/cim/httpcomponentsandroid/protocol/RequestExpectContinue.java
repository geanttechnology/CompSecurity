// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.protocol;

import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.HttpEntityEnclosingRequest;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestInterceptor;
import com.comcast.cim.httpcomponentsandroid.HttpVersion;
import com.comcast.cim.httpcomponentsandroid.ProtocolVersion;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.params.HttpProtocolParams;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.protocol:
//            HttpContext

public class RequestExpectContinue
    implements HttpRequestInterceptor
{

    public RequestExpectContinue()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        if (httprequest == null)
        {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (httprequest instanceof HttpEntityEnclosingRequest)
        {
            httpcontext = ((HttpEntityEnclosingRequest)httprequest).getEntity();
            if (httpcontext != null && httpcontext.getContentLength() != 0L)
            {
                httpcontext = httprequest.getRequestLine().getProtocolVersion();
                if (HttpProtocolParams.useExpectContinue(httprequest.getParams()) && !httpcontext.lessEquals(HttpVersion.HTTP_1_0))
                {
                    httprequest.addHeader("Expect", "100-continue");
                }
            }
        }
    }
}
