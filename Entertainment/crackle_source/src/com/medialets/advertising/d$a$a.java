// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import java.io.File;
import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRequestDirector;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

// Referenced classes of package com.medialets.advertising:
//            a, d

final class Handler extends DefaultRequestDirector
{

    public final HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        if (httphost == null)
        {
            httphost = new BasicHttpResponse(HttpVersion.HTTP_1_0, 200, "OK");
            httprequest = new File(httprequest.getRequestLine().getUri());
            com.medialets.advertising.a.d((new StringBuilder()).append("Loading file ").append(httprequest).append(" from local disk").toString());
            if (httprequest.exists())
            {
                httphost.setEntity(new FileEntity(httprequest, "application/x-www-form-urlencoded"));
                httphost.setParams(params);
                requestExec.postProcess(httphost, httpProcessor, httpcontext);
                return httphost;
            } else
            {
                httphost.setStatusCode(404);
                httphost.setReasonPhrase((new StringBuilder()).append("Could not find file ").append(httprequest.getAbsolutePath()).append(" on device").toString());
                return httphost;
            }
        } else
        {
            return super.execute(httphost, httprequest, httpcontext);
        }
    }

    s(s s, HttpRequestExecutor httprequestexecutor, ClientConnectionManager clientconnectionmanager, ConnectionReuseStrategy connectionreusestrategy, ConnectionKeepAliveStrategy connectionkeepalivestrategy, HttpRoutePlanner httprouteplanner, HttpProcessor httpprocessor, 
            HttpRequestRetryHandler httprequestretryhandler, RedirectHandler redirecthandler, AuthenticationHandler authenticationhandler, AuthenticationHandler authenticationhandler1, UserTokenHandler usertokenhandler, HttpParams httpparams)
    {
        super(httprequestexecutor, clientconnectionmanager, connectionreusestrategy, connectionkeepalivestrategy, httprouteplanner, httpprocessor, httprequestretryhandler, redirecthandler, authenticationhandler, authenticationhandler1, usertokenhandler, httpparams);
    }

    // Unreferenced inner class com/medialets/advertising/d$a
    final class d.a extends DefaultHttpClient
    {

        protected final RequestDirector createClientRequestDirector(HttpRequestExecutor httprequestexecutor, ClientConnectionManager clientconnectionmanager, ConnectionReuseStrategy connectionreusestrategy, ConnectionKeepAliveStrategy connectionkeepalivestrategy, HttpRoutePlanner httprouteplanner, HttpProcessor httpprocessor, HttpRequestRetryHandler httprequestretryhandler, 
                RedirectHandler redirecthandler, AuthenticationHandler authenticationhandler, AuthenticationHandler authenticationhandler1, UserTokenHandler usertokenhandler, HttpParams httpparams)
        {
            return new d.a.a(this, httprequestexecutor, clientconnectionmanager, connectionreusestrategy, connectionkeepalivestrategy, httprouteplanner, httpprocessor, httprequestretryhandler, redirecthandler, authenticationhandler, authenticationhandler1, usertokenhandler, httpparams);
        }

        protected final BasicHttpProcessor createHttpProcessor()
        {
            BasicHttpProcessor basichttpprocessor = super.createHttpProcessor();
            basichttpprocessor.addRequestInterceptor(d.c());
            return basichttpprocessor;
        }

            d.a(d d1, ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
            {
                super(clientconnectionmanager, httpparams);
            }
    }

}
