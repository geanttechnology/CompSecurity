// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import cz.msebera.android.httpclient.protocol.RequestContent;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.protocol.RequestUserAgent;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.VersionInfo;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.execchain:
//            ClientExecChain, RequestAbortedException, ConnectionHolder, HttpResponseProxy

public class MinimalClientExec
    implements ClientExecChain
{

    private final HttpClientConnectionManager connManager;
    private final HttpProcessor httpProcessor = new ImmutableHttpProcessor(new HttpRequestInterceptor[] {
        new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(VersionInfo.getUserAgent("Apache-HttpClient", "cz.msebera.android.httpclient.client", getClass()))
    });
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;

    public MinimalClientExec(HttpRequestExecutor httprequestexecutor, HttpClientConnectionManager httpclientconnectionmanager, ConnectionReuseStrategy connectionreusestrategy, ConnectionKeepAliveStrategy connectionkeepalivestrategy)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(httprequestexecutor, "HTTP request executor");
        Args.notNull(httpclientconnectionmanager, "Client connection manager");
        Args.notNull(connectionreusestrategy, "Connection reuse strategy");
        Args.notNull(connectionkeepalivestrategy, "Connection keep alive strategy");
        requestExecutor = httprequestexecutor;
        connManager = httpclientconnectionmanager;
        reuseStrategy = connectionreusestrategy;
        keepAliveStrategy = connectionkeepalivestrategy;
    }

    static void rewriteRequestURI(HttpRequestWrapper httprequestwrapper, HttpRoute httproute)
        throws ProtocolException
    {
        try
        {
            httproute = httprequestwrapper.getURI();
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid URI: ").append(httprequestwrapper.getRequestLine().getUri()).toString(), httproute);
        }
        if (httproute == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (!httproute.isAbsolute())
        {
            break MISSING_BLOCK_LABEL_29;
        }
        httproute = URIUtils.rewriteURI(httproute, null, true);
_L2:
        httprequestwrapper.setURI(httproute);
        return;
        httproute = URIUtils.rewriteURI(httproute);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public CloseableHttpResponse execute(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware)
        throws IOException, HttpException
    {
        Object obj;
        HttpClientConnection httpclientconnection;
        Args.notNull(httproute, "HTTP route");
        Args.notNull(httprequestwrapper, "HTTP request");
        Args.notNull(httpclientcontext, "HTTP context");
        rewriteRequestURI(httprequestwrapper, httproute);
        ConnectionRequest connectionrequest = connManager.requestConnection(httproute, null);
        if (httpexecutionaware != null)
        {
            if (httpexecutionaware.isAborted())
            {
                connectionrequest.cancel();
                throw new RequestAbortedException("Request aborted");
            }
            httpexecutionaware.setCancellable(connectionrequest);
        }
        obj = httpclientcontext.getRequestConfig();
        int i;
        long l;
        try
        {
            i = ((RequestConfig) (obj)).getConnectionRequestTimeout();
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            Thread.currentThread().interrupt();
            throw new RequestAbortedException("Request aborted", httproute);
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequestWrapper httprequestwrapper)
        {
            httpclientcontext = httprequestwrapper.getCause();
            httproute = httpclientcontext;
            if (httpclientcontext == null)
            {
                httproute = httprequestwrapper;
            }
            throw new RequestAbortedException("Request execution failed", httproute);
        }
        if (i > 0)
        {
            l = i;
        } else
        {
            l = 0L;
        }
        httpclientconnection = connectionrequest.get(l, TimeUnit.MILLISECONDS);
        int j;
        ConnectionHolder connectionholder = new ConnectionHolder(log, connManager, httpclientconnection);
        if (httpexecutionaware == null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        Object obj1;
        try
        {
            if (httpexecutionaware.isAborted())
            {
                connectionholder.close();
                throw new RequestAbortedException("Request aborted");
            }
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            httprequestwrapper = new InterruptedIOException("Connection has been shut down");
            httprequestwrapper.initCause(httproute);
            throw httprequestwrapper;
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            connectionholder.abortConnection();
            throw httproute;
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            connectionholder.abortConnection();
            throw httproute;
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            connectionholder.abortConnection();
            throw httproute;
        }
        httpexecutionaware.setCancellable(connectionholder);
        if (httpclientconnection.isOpen())
        {
            break MISSING_BLOCK_LABEL_298;
        }
        j = ((RequestConfig) (obj)).getConnectTimeout();
        httpexecutionaware = connManager;
        if (j <= 0)
        {
            j = 0;
        }
        httpexecutionaware.connect(httpclientconnection, httproute, j, httpclientcontext);
        connManager.routeComplete(httpclientconnection, httproute, httpclientcontext);
        j = ((RequestConfig) (obj)).getSocketTimeout();
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        httpclientconnection.setSocketTimeout(j);
        obj = null;
        obj1 = httprequestwrapper.getOriginal();
        httpexecutionaware = ((HttpExecutionAware) (obj));
        if (!(obj1 instanceof HttpUriRequest))
        {
            break MISSING_BLOCK_LABEL_388;
        }
        obj1 = ((HttpUriRequest)obj1).getURI();
        httpexecutionaware = ((HttpExecutionAware) (obj));
        if (((URI) (obj1)).isAbsolute())
        {
            httpexecutionaware = new HttpHost(((URI) (obj1)).getHost(), ((URI) (obj1)).getPort(), ((URI) (obj1)).getScheme());
        }
        obj = httpexecutionaware;
        if (httpexecutionaware != null)
        {
            break MISSING_BLOCK_LABEL_403;
        }
        obj = httproute.getTargetHost();
        httpclientcontext.setAttribute("http.target_host", obj);
        httpclientcontext.setAttribute("http.request", httprequestwrapper);
        httpclientcontext.setAttribute("http.connection", httpclientconnection);
        httpclientcontext.setAttribute("http.route", httproute);
        httpProcessor.process(httprequestwrapper, httpclientcontext);
        httproute = requestExecutor.execute(httprequestwrapper, httpclientconnection, httpclientcontext);
        httpProcessor.process(httproute, httpclientcontext);
        if (!reuseStrategy.keepAlive(httproute, httpclientcontext))
        {
            break MISSING_BLOCK_LABEL_544;
        }
        connectionholder.setValidFor(keepAliveStrategy.getKeepAliveDuration(httproute, httpclientcontext), TimeUnit.MILLISECONDS);
        connectionholder.markReusable();
_L1:
        httprequestwrapper = httproute.getEntity();
        if (httprequestwrapper == null)
        {
            break MISSING_BLOCK_LABEL_529;
        }
        if (httprequestwrapper.isStreaming())
        {
            break MISSING_BLOCK_LABEL_560;
        }
        connectionholder.releaseConnection();
        return new HttpResponseProxy(httproute, null);
        connectionholder.markNonReusable();
          goto _L1
        httproute = new HttpResponseProxy(httproute, connectionholder);
        return httproute;
    }
}
