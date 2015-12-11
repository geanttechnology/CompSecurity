// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.client;

import com.comcast.cim.cmasl.apachehttp.ResponseContentEncoding;
import com.comcast.cim.httpcomponentsandroid.HttpEntityEnclosingRequest;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestInterceptor;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.HttpResponseInterceptor;
import com.comcast.cim.httpcomponentsandroid.client.ClientProtocolException;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import com.comcast.cim.httpcomponentsandroid.client.protocol.RequestAcceptEncoding;
import com.comcast.cim.httpcomponentsandroid.client.utils.URIUtils;
import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionManager;
import com.comcast.cim.httpcomponentsandroid.impl.client.EntityEnclosingRequestWrapper;
import com.comcast.cim.httpcomponentsandroid.impl.client.RequestWrapper;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.protocol.BasicHttpContext;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import com.comcast.cim.httpcomponentsandroid.util.EntityUtils;
import java.io.IOException;

public class DecompressingHttpClient
    implements HttpClient
{

    private HttpRequestInterceptor acceptEncodingInterceptor;
    private HttpClient backend;
    private HttpResponseInterceptor contentEncodingInterceptor;

    public DecompressingHttpClient(HttpClient httpclient)
    {
        this(httpclient, ((HttpRequestInterceptor) (new RequestAcceptEncoding())), ((HttpResponseInterceptor) (new ResponseContentEncoding())));
    }

    DecompressingHttpClient(HttpClient httpclient, HttpRequestInterceptor httprequestinterceptor, HttpResponseInterceptor httpresponseinterceptor)
    {
        backend = httpclient;
        acceptEncodingInterceptor = httprequestinterceptor;
        contentEncodingInterceptor = httpresponseinterceptor;
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException
    {
        Object obj;
        obj = httpcontext;
        if (httpcontext != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        obj = new BasicHttpContext();
        if (!(httprequest instanceof HttpEntityEnclosingRequest))
        {
            break MISSING_BLOCK_LABEL_117;
        }
        httprequest = new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)httprequest);
_L1:
        acceptEncodingInterceptor.process(httprequest, ((HttpContext) (obj)));
        httphost = backend.execute(httphost, httprequest, ((HttpContext) (obj)));
        contentEncodingInterceptor.process(httphost, ((HttpContext) (obj)));
        if (Boolean.TRUE.equals(((HttpContext) (obj)).getAttribute("http.client.response.uncompressed")))
        {
            httphost.removeHeaders("Content-Length");
            httphost.removeHeaders("Content-Encoding");
            httphost.removeHeaders("Content-MD5");
        }
        return httphost;
        try
        {
            httprequest = new RequestWrapper(httprequest);
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            throw new ClientProtocolException(httphost);
        }
          goto _L1
        httprequest;
        EntityUtils.consume(httphost.getEntity());
        throw httprequest;
        httprequest;
        EntityUtils.consume(httphost.getEntity());
        throw httprequest;
        httprequest;
        EntityUtils.consume(httphost.getEntity());
        throw httprequest;
    }

    public HttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException
    {
        return execute(getHttpHost(httpurirequest), ((HttpRequest) (httpurirequest)), (HttpContext)null);
    }

    public HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException
    {
        return execute(getHttpHost(httpurirequest), ((HttpRequest) (httpurirequest)), httpcontext);
    }

    public ClientConnectionManager getConnectionManager()
    {
        return backend.getConnectionManager();
    }

    HttpHost getHttpHost(HttpUriRequest httpurirequest)
    {
        return URIUtils.extractHost(httpurirequest.getURI());
    }

    public HttpParams getParams()
    {
        return backend.getParams();
    }
}
