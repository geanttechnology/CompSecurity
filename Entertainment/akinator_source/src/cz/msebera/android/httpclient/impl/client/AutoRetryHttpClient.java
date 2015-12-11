// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            DefaultHttpClient, DefaultServiceUnavailableRetryStrategy

public class AutoRetryHttpClient
    implements HttpClient
{

    private final HttpClient backend;
    public HttpClientAndroidLog log;
    private final ServiceUnavailableRetryStrategy retryStrategy;

    public AutoRetryHttpClient()
    {
        this(((HttpClient) (new DefaultHttpClient())), ((ServiceUnavailableRetryStrategy) (new DefaultServiceUnavailableRetryStrategy())));
    }

    public AutoRetryHttpClient(HttpClient httpclient)
    {
        this(httpclient, ((ServiceUnavailableRetryStrategy) (new DefaultServiceUnavailableRetryStrategy())));
    }

    public AutoRetryHttpClient(HttpClient httpclient, ServiceUnavailableRetryStrategy serviceunavailableretrystrategy)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(httpclient, "HttpClient");
        Args.notNull(serviceunavailableretrystrategy, "ServiceUnavailableRetryStrategy");
        backend = httpclient;
        retryStrategy = serviceunavailableretrystrategy;
    }

    public AutoRetryHttpClient(ServiceUnavailableRetryStrategy serviceunavailableretrystrategy)
    {
        this(((HttpClient) (new DefaultHttpClient())), serviceunavailableretrystrategy);
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest)
        throws IOException
    {
        return execute(httphost, httprequest, ((HttpContext) (null)));
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException
    {
        int i = 1;
_L2:
        HttpResponse httpresponse = backend.execute(httphost, httprequest, httpcontext);
        long l;
        if (!retryStrategy.retryRequest(httpresponse, i, httpcontext))
        {
            break; /* Loop/switch isn't completed */
        }
        EntityUtils.consume(httpresponse.getEntity());
        l = retryStrategy.getRetryInterval();
        try
        {
            log.trace((new StringBuilder()).append("Wait for ").append(l).toString());
            Thread.sleep(l);
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            try
            {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
            // Misplaced declaration of an exception variable
            catch (HttpHost httphost) { }
            try
            {
                EntityUtils.consume(httpresponse.getEntity());
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequest httprequest)
            {
                log.warn("I/O error consuming response content", httprequest);
            }
            throw httphost;
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return httpresponse;
    }

    public HttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException
    {
        return execute(httpurirequest, ((HttpContext) (null)));
    }

    public HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException
    {
        URI uri = httpurirequest.getURI();
        return execute(new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()), ((HttpRequest) (httpurirequest)), httpcontext);
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
        throws IOException
    {
        return execute(httphost, httprequest, responsehandler, null);
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException
    {
        return responsehandler.handleResponse(execute(httphost, httprequest, httpcontext));
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler)
        throws IOException
    {
        return execute(httpurirequest, responsehandler, ((HttpContext) (null)));
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException
    {
        return responsehandler.handleResponse(execute(httpurirequest, httpcontext));
    }

    public ClientConnectionManager getConnectionManager()
    {
        return backend.getConnectionManager();
    }

    public HttpParams getParams()
    {
        return backend.getParams();
    }
}
