// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.Configurable;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.execchain.MinimalClientExec;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            CloseableHttpClient, DefaultConnectionKeepAliveStrategy

class MinimalHttpClient extends CloseableHttpClient
{

    private final HttpClientConnectionManager connManager;
    private final HttpParams params = new BasicHttpParams();
    private final MinimalClientExec requestExecutor;

    public MinimalHttpClient(HttpClientConnectionManager httpclientconnectionmanager)
    {
        connManager = (HttpClientConnectionManager)Args.notNull(httpclientconnectionmanager, "HTTP connection manager");
        requestExecutor = new MinimalClientExec(new HttpRequestExecutor(), httpclientconnectionmanager, DefaultConnectionReuseStrategy.INSTANCE, DefaultConnectionKeepAliveStrategy.INSTANCE);
    }

    public void close()
    {
        connManager.shutdown();
    }

    protected CloseableHttpResponse doExecute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        Args.notNull(httphost, "Target host");
        Args.notNull(httprequest, "HTTP request");
        HttpExecutionAware httpexecutionaware = null;
        if (httprequest instanceof HttpExecutionAware)
        {
            httpexecutionaware = (HttpExecutionAware)httprequest;
        }
        HttpRequestWrapper httprequestwrapper;
        HttpRoute httproute;
        try
        {
            httprequestwrapper = HttpRequestWrapper.wrap(httprequest);
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            throw new ClientProtocolException(httphost);
        }
        if (httpcontext == null)
        {
            httpcontext = new BasicHttpContext();
        }
        httpcontext = HttpClientContext.adapt(httpcontext);
        httproute = new HttpRoute(httphost);
        httphost = null;
        if (httprequest instanceof Configurable)
        {
            httphost = ((Configurable)httprequest).getConfig();
        }
        if (httphost == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        httpcontext.setRequestConfig(httphost);
        return requestExecutor.execute(httproute, httprequestwrapper, httpcontext, httpexecutionaware);
    }

    public ClientConnectionManager getConnectionManager()
    {
        return new ClientConnectionManager() {

            final MinimalHttpClient this$0;

            public void closeExpiredConnections()
            {
                connManager.closeExpiredConnections();
            }

            public void closeIdleConnections(long l, TimeUnit timeunit)
            {
                connManager.closeIdleConnections(l, timeunit);
            }

            public SchemeRegistry getSchemeRegistry()
            {
                throw new UnsupportedOperationException();
            }

            public void releaseConnection(ManagedClientConnection managedclientconnection, long l, TimeUnit timeunit)
            {
                throw new UnsupportedOperationException();
            }

            public ClientConnectionRequest requestConnection(HttpRoute httproute, Object obj)
            {
                throw new UnsupportedOperationException();
            }

            public void shutdown()
            {
                connManager.shutdown();
            }

            
            {
                this$0 = MinimalHttpClient.this;
                super();
            }
        };
    }

    public HttpParams getParams()
    {
        return params;
    }

}
