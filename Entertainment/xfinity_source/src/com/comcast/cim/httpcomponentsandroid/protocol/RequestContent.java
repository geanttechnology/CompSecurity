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
import com.comcast.cim.httpcomponentsandroid.ProtocolException;
import com.comcast.cim.httpcomponentsandroid.ProtocolVersion;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.protocol:
//            HttpContext

public class RequestContent
    implements HttpRequestInterceptor
{

    public RequestContent()
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
            if (httprequest.containsHeader("Transfer-Encoding"))
            {
                throw new ProtocolException("Transfer-encoding header already present");
            }
            if (httprequest.containsHeader("Content-Length"))
            {
                throw new ProtocolException("Content-Length header already present");
            }
            httpcontext = httprequest.getRequestLine().getProtocolVersion();
            HttpEntity httpentity = ((HttpEntityEnclosingRequest)httprequest).getEntity();
            if (httpentity == null)
            {
                httprequest.addHeader("Content-Length", "0");
            } else
            {
                if (httpentity.isChunked() || httpentity.getContentLength() < 0L)
                {
                    if (httpcontext.lessEquals(HttpVersion.HTTP_1_0))
                    {
                        throw new ProtocolException("Chunked transfer encoding not allowed for " + httpcontext);
                    }
                    httprequest.addHeader("Transfer-Encoding", "chunked");
                } else
                {
                    httprequest.addHeader("Content-Length", Long.toString(httpentity.getContentLength()));
                }
                if (httpentity.getContentType() != null && !httprequest.containsHeader("Content-Type"))
                {
                    httprequest.addHeader(httpentity.getContentType());
                }
                if (httpentity.getContentEncoding() != null && !httprequest.containsHeader("Content-Encoding"))
                {
                    httprequest.addHeader(httpentity.getContentEncoding());
                    return;
                }
            }
        }
    }
}
