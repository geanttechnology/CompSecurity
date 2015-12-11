// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestInterceptor;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAllRequestsInterceptor
    implements HttpRequestInterceptor
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/apachehttp/LogAllRequestsInterceptor);

    public LogAllRequestsInterceptor()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        try
        {
            httpcontext = ((HttpHost)httpcontext.getAttribute("http.target_host")).toURI();
        }
        // Misplaced declaration of an exception variable
        catch (HttpContext httpcontext)
        {
            httpcontext = httprequest.getFirstHeader("Host");
            if (httpcontext != null)
            {
                httpcontext = (new StringBuilder()).append("[").append(httpcontext.getValue()).append("]").toString();
            } else
            {
                httpcontext = "";
            }
        }
        LOG.debug((new StringBuilder()).append(httpcontext).append(httprequest.getRequestLine().toString()).toString());
    }

}
