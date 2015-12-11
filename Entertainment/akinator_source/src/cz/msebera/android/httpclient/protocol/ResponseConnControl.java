// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.protocol:
//            HttpCoreContext, HttpContext

public class ResponseConnControl
    implements HttpResponseInterceptor
{

    public ResponseConnControl()
    {
    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httpresponse, "HTTP response");
        httpcontext = HttpCoreContext.adapt(httpcontext);
        int i = httpresponse.getStatusLine().getStatusCode();
        if (i == 400 || i == 408 || i == 411 || i == 413 || i == 414 || i == 503 || i == 501)
        {
            httpresponse.setHeader("Connection", "Close");
        } else
        {
            Header header = httpresponse.getFirstHeader("Connection");
            if (header == null || !"Close".equalsIgnoreCase(header.getValue()))
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
                httpcontext = httpcontext.getRequest();
                if (httpcontext != null)
                {
                    Header header1 = httpcontext.getFirstHeader("Connection");
                    if (header1 != null)
                    {
                        httpresponse.setHeader("Connection", header1.getValue());
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
}
