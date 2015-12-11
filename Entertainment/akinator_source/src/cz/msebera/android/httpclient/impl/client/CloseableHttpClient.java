// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;

public abstract class CloseableHttpClient
    implements HttpClient, Closeable
{

    public HttpClientAndroidLog log;

    public CloseableHttpClient()
    {
        log = new HttpClientAndroidLog(getClass());
    }

    private static HttpHost determineTarget(HttpUriRequest httpurirequest)
        throws ClientProtocolException
    {
        Object obj = null;
        URI uri = httpurirequest.getURI();
        httpurirequest = obj;
        if (uri.isAbsolute())
        {
            HttpHost httphost = URIUtils.extractHost(uri);
            httpurirequest = httphost;
            if (httphost == null)
            {
                throw new ClientProtocolException((new StringBuilder()).append("URI does not specify a valid host name: ").append(uri).toString());
            }
        }
        return httpurirequest;
    }

    protected abstract CloseableHttpResponse doExecute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException;

    public volatile HttpResponse execute(HttpHost httphost, HttpRequest httprequest)
        throws IOException, ClientProtocolException
    {
        return execute(httphost, httprequest);
    }

    public volatile HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        return execute(httphost, httprequest, httpcontext);
    }

    public volatile HttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException, ClientProtocolException
    {
        return execute(httpurirequest);
    }

    public volatile HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        return execute(httpurirequest, httpcontext);
    }

    public CloseableHttpResponse execute(HttpHost httphost, HttpRequest httprequest)
        throws IOException, ClientProtocolException
    {
        return doExecute(httphost, httprequest, (HttpContext)null);
    }

    public CloseableHttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        return doExecute(httphost, httprequest, httpcontext);
    }

    public CloseableHttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException, ClientProtocolException
    {
        return execute(httpurirequest, (HttpContext)null);
    }

    public CloseableHttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        Args.notNull(httpurirequest, "HTTP request");
        return doExecute(determineTarget(httpurirequest), httpurirequest, httpcontext);
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
        throws IOException, ClientProtocolException
    {
        return execute(httphost, httprequest, responsehandler, null);
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        Args.notNull(responsehandler, "Response handler");
        httphost = execute(httphost, httprequest, httpcontext);
        try
        {
            httprequest = ((HttpRequest) (responsehandler.handleResponse(httphost)));
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequest httprequest)
        {
            httphost = httphost.getEntity();
            try
            {
                EntityUtils.consume(httphost);
            }
            // Misplaced declaration of an exception variable
            catch (HttpHost httphost)
            {
                log.warn("Error consuming content after an exception.", httphost);
            }
            if (httprequest instanceof RuntimeException)
            {
                throw (RuntimeException)httprequest;
            }
            if (httprequest instanceof IOException)
            {
                throw (IOException)httprequest;
            } else
            {
                throw new UndeclaredThrowableException(httprequest);
            }
        }
        EntityUtils.consume(httphost.getEntity());
        return httprequest;
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler)
        throws IOException, ClientProtocolException
    {
        return execute(httpurirequest, responsehandler, ((HttpContext) (null)));
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        return execute(determineTarget(httpurirequest), ((HttpRequest) (httpurirequest)), responsehandler, httpcontext);
    }
}
