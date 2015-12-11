// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.protocol:
//            HttpContext

public class RequestContent
    implements HttpRequestInterceptor
{

    private final boolean overwrite;

    public RequestContent()
    {
        this(false);
    }

    public RequestContent(boolean flag)
    {
        overwrite = flag;
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        if (httprequest instanceof HttpEntityEnclosingRequest)
        {
            HttpEntity httpentity;
            if (overwrite)
            {
                httprequest.removeHeaders("Transfer-Encoding");
                httprequest.removeHeaders("Content-Length");
            } else
            {
                if (httprequest.containsHeader("Transfer-Encoding"))
                {
                    throw new ProtocolException("Transfer-encoding header already present");
                }
                if (httprequest.containsHeader("Content-Length"))
                {
                    throw new ProtocolException("Content-Length header already present");
                }
            }
            httpcontext = httprequest.getRequestLine().getProtocolVersion();
            httpentity = ((HttpEntityEnclosingRequest)httprequest).getEntity();
            if (httpentity == null)
            {
                httprequest.addHeader("Content-Length", "0");
            } else
            {
                if (httpentity.isChunked() || httpentity.getContentLength() < 0L)
                {
                    if (httpcontext.lessEquals(HttpVersion.HTTP_1_0))
                    {
                        throw new ProtocolException((new StringBuilder()).append("Chunked transfer encoding not allowed for ").append(httpcontext).toString());
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
