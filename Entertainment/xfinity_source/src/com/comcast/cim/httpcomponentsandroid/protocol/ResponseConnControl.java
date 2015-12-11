// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.protocol;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.HttpResponseInterceptor;
import com.comcast.cim.httpcomponentsandroid.HttpVersion;
import com.comcast.cim.httpcomponentsandroid.ProtocolVersion;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.protocol:
//            HttpContext

public class ResponseConnControl
    implements HttpResponseInterceptor
{

    public ResponseConnControl()
    {
    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        if (httpresponse == null)
        {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        if (httpcontext == null)
        {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
        int i = httpresponse.getStatusLine().getStatusCode();
        if (i == 400 || i == 408 || i == 411 || i == 413 || i == 414 || i == 503 || i == 501)
        {
            httpresponse.setHeader("Connection", "Close");
        } else
        {
            HttpEntity httpentity = httpresponse.getEntity();
            if (httpentity != null)
            {
                ProtocolVersion protocolversion = httpresponse.getStatusLine().getProtocolVersion();
                if (httpentity.getContentLength() < 0L && (!httpentity.isChunked() || protocolversion.lessEquals(HttpVersion.HTTP_1_0)))
                {
                    httpresponse.setHeader("Connection", "Close");
                    return;
                }
            }
            httpcontext = (HttpRequest)httpcontext.getAttribute("http.request");
            if (httpcontext != null)
            {
                Header header = httpcontext.getFirstHeader("Connection");
                if (header != null)
                {
                    httpresponse.setHeader("Connection", header.getValue());
                    return;
                }
                if (httpcontext.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0))
                {
                    httpresponse.setHeader("Connection", "Close");
                    return;
                }
            }
        }
    }
}
