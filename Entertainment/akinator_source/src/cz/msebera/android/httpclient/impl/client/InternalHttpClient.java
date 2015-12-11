// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.Configurable;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.params.HttpClientParamConfig;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.execchain.ClientExecChain;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpParamsNames;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            CloseableHttpClient

class InternalHttpClient extends CloseableHttpClient
{

    private final Lookup authSchemeRegistry;
    private final List closeables;
    private final HttpClientConnectionManager connManager;
    private final Lookup cookieSpecRegistry;
    private final CookieStore cookieStore;
    private final CredentialsProvider credentialsProvider;
    private final RequestConfig defaultConfig;
    private final ClientExecChain execChain;
    public HttpClientAndroidLog log;
    private final HttpRoutePlanner routePlanner;

    public InternalHttpClient(ClientExecChain clientexecchain, HttpClientConnectionManager httpclientconnectionmanager, HttpRoutePlanner httprouteplanner, Lookup lookup, Lookup lookup1, CookieStore cookiestore, CredentialsProvider credentialsprovider, 
            RequestConfig requestconfig, List list)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(clientexecchain, "HTTP client exec chain");
        Args.notNull(httpclientconnectionmanager, "HTTP connection manager");
        Args.notNull(httprouteplanner, "HTTP route planner");
        execChain = clientexecchain;
        connManager = httpclientconnectionmanager;
        routePlanner = httprouteplanner;
        cookieSpecRegistry = lookup;
        authSchemeRegistry = lookup1;
        cookieStore = cookiestore;
        credentialsProvider = credentialsprovider;
        defaultConfig = requestconfig;
        closeables = list;
    }

    private HttpRoute determineRoute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException
    {
        HttpHost httphost1 = httphost;
        if (httphost == null)
        {
            httphost1 = (HttpHost)httprequest.getParams().getParameter("http.default-host");
        }
        return routePlanner.determineRoute(httphost1, httprequest, httpcontext);
    }

    private void setupContext(HttpClientContext httpclientcontext)
    {
        if (httpclientcontext.getAttribute("http.auth.target-scope") == null)
        {
            httpclientcontext.setAttribute("http.auth.target-scope", new AuthState());
        }
        if (httpclientcontext.getAttribute("http.auth.proxy-scope") == null)
        {
            httpclientcontext.setAttribute("http.auth.proxy-scope", new AuthState());
        }
        if (httpclientcontext.getAttribute("http.authscheme-registry") == null)
        {
            httpclientcontext.setAttribute("http.authscheme-registry", authSchemeRegistry);
        }
        if (httpclientcontext.getAttribute("http.cookiespec-registry") == null)
        {
            httpclientcontext.setAttribute("http.cookiespec-registry", cookieSpecRegistry);
        }
        if (httpclientcontext.getAttribute("http.cookie-store") == null)
        {
            httpclientcontext.setAttribute("http.cookie-store", cookieStore);
        }
        if (httpclientcontext.getAttribute("http.auth.credentials-provider") == null)
        {
            httpclientcontext.setAttribute("http.auth.credentials-provider", credentialsProvider);
        }
        if (httpclientcontext.getAttribute("http.request-config") == null)
        {
            httpclientcontext.setAttribute("http.request-config", defaultConfig);
        }
    }

    public void close()
    {
        connManager.shutdown();
        if (closeables != null)
        {
            for (Iterator iterator = closeables.iterator(); iterator.hasNext();)
            {
                Closeable closeable = (Closeable)iterator.next();
                try
                {
                    closeable.close();
                }
                catch (IOException ioexception)
                {
                    log.error(ioexception.getMessage(), ioexception);
                }
            }

        }
    }

    protected CloseableHttpResponse doExecute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        Object obj;
        Args.notNull(httprequest, "HTTP request");
        HttpExecutionAware httpexecutionaware = null;
        if (httprequest instanceof HttpExecutionAware)
        {
            httpexecutionaware = (HttpExecutionAware)httprequest;
        }
        HttpRequestWrapper httprequestwrapper;
        HttpClientContext httpclientcontext;
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
        httpclientcontext = HttpClientContext.adapt(httpcontext);
        httpcontext = null;
        if (httprequest instanceof Configurable)
        {
            httpcontext = ((Configurable)httprequest).getConfig();
        }
        obj = httpcontext;
        if (httpcontext != null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        httprequest = httprequest.getParams();
        if (!(httprequest instanceof HttpParamsNames))
        {
            break MISSING_BLOCK_LABEL_171;
        }
        obj = httpcontext;
        if (!((HttpParamsNames)httprequest).getNames().isEmpty())
        {
            obj = HttpClientParamConfig.getRequestConfig(httprequest);
        }
_L1:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        httpclientcontext.setRequestConfig(((RequestConfig) (obj)));
        setupContext(httpclientcontext);
        httphost = determineRoute(httphost, httprequestwrapper, httpclientcontext);
        return execChain.execute(httphost, httprequestwrapper, httpclientcontext, httpexecutionaware);
        obj = HttpClientParamConfig.getRequestConfig(httprequest);
          goto _L1
    }

    public ClientConnectionManager getConnectionManager()
    {
        return new ClientConnectionManager() {

            final InternalHttpClient this$0;

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
                this$0 = InternalHttpClient.this;
                super();
            }
        };
    }

    public HttpParams getParams()
    {
        throw new UnsupportedOperationException();
    }

}
