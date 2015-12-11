// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.UsernamePasswordCredentials;
import cz.msebera.android.httpclient.client.AuthenticationHandler;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import cz.msebera.android.httpclient.client.RedirectException;
import cz.msebera.android.httpclient.client.RedirectHandler;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.RequestDirector;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.methods.AbortableHttpRequest;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.params.HttpClientParams;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.BasicManagedEntity;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.BasicRouteDirector;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRouteDirector;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.entity.BufferedHttpEntity;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.auth.BasicScheme;
import cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import cz.msebera.android.httpclient.message.BasicHttpRequest;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            AuthenticationStrategyAdaptor, HttpAuthenticator, DefaultRedirectStrategyAdaptor, RoutedRequest, 
//            RequestWrapper, EntityEnclosingRequestWrapper, TunnelRefusedException

public class DefaultRequestDirector
    implements RequestDirector
{

    private final HttpAuthenticator authenticator;
    protected final ClientConnectionManager connManager;
    private int execCount;
    protected final HttpProcessor httpProcessor;
    protected final ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log;
    protected ManagedClientConnection managedConn;
    private final int maxRedirects;
    protected final HttpParams params;
    protected final AuthenticationHandler proxyAuthHandler;
    protected final AuthState proxyAuthState;
    protected final AuthenticationStrategy proxyAuthStrategy;
    private int redirectCount;
    protected final RedirectHandler redirectHandler;
    protected final RedirectStrategy redirectStrategy;
    protected final HttpRequestExecutor requestExec;
    protected final HttpRequestRetryHandler retryHandler;
    protected final ConnectionReuseStrategy reuseStrategy;
    protected final HttpRoutePlanner routePlanner;
    protected final AuthenticationHandler targetAuthHandler;
    protected final AuthState targetAuthState;
    protected final AuthenticationStrategy targetAuthStrategy;
    protected final UserTokenHandler userTokenHandler;
    private HttpHost virtualHost;

    public DefaultRequestDirector(HttpClientAndroidLog httpclientandroidlog, HttpRequestExecutor httprequestexecutor, ClientConnectionManager clientconnectionmanager, ConnectionReuseStrategy connectionreusestrategy, ConnectionKeepAliveStrategy connectionkeepalivestrategy, HttpRoutePlanner httprouteplanner, HttpProcessor httpprocessor, 
            HttpRequestRetryHandler httprequestretryhandler, RedirectStrategy redirectstrategy, AuthenticationHandler authenticationhandler, AuthenticationHandler authenticationhandler1, UserTokenHandler usertokenhandler, HttpParams httpparams)
    {
        this(new HttpClientAndroidLog(cz/msebera/android/httpclient/impl/client/DefaultRequestDirector), httprequestexecutor, clientconnectionmanager, connectionreusestrategy, connectionkeepalivestrategy, httprouteplanner, httpprocessor, httprequestretryhandler, redirectstrategy, ((AuthenticationStrategy) (new AuthenticationStrategyAdaptor(authenticationhandler))), ((AuthenticationStrategy) (new AuthenticationStrategyAdaptor(authenticationhandler1))), usertokenhandler, httpparams);
    }

    public DefaultRequestDirector(HttpClientAndroidLog httpclientandroidlog, HttpRequestExecutor httprequestexecutor, ClientConnectionManager clientconnectionmanager, ConnectionReuseStrategy connectionreusestrategy, ConnectionKeepAliveStrategy connectionkeepalivestrategy, HttpRoutePlanner httprouteplanner, HttpProcessor httpprocessor, 
            HttpRequestRetryHandler httprequestretryhandler, RedirectStrategy redirectstrategy, AuthenticationStrategy authenticationstrategy, AuthenticationStrategy authenticationstrategy1, UserTokenHandler usertokenhandler, HttpParams httpparams)
    {
        Args.notNull(httpclientandroidlog, "Log");
        Args.notNull(httprequestexecutor, "Request executor");
        Args.notNull(clientconnectionmanager, "Client connection manager");
        Args.notNull(connectionreusestrategy, "Connection reuse strategy");
        Args.notNull(connectionkeepalivestrategy, "Connection keep alive strategy");
        Args.notNull(httprouteplanner, "Route planner");
        Args.notNull(httpprocessor, "HTTP protocol processor");
        Args.notNull(httprequestretryhandler, "HTTP request retry handler");
        Args.notNull(redirectstrategy, "Redirect strategy");
        Args.notNull(authenticationstrategy, "Target authentication strategy");
        Args.notNull(authenticationstrategy1, "Proxy authentication strategy");
        Args.notNull(usertokenhandler, "User token handler");
        Args.notNull(httpparams, "HTTP parameters");
        log = httpclientandroidlog;
        authenticator = new HttpAuthenticator(httpclientandroidlog);
        requestExec = httprequestexecutor;
        connManager = clientconnectionmanager;
        reuseStrategy = connectionreusestrategy;
        keepAliveStrategy = connectionkeepalivestrategy;
        routePlanner = httprouteplanner;
        httpProcessor = httpprocessor;
        retryHandler = httprequestretryhandler;
        redirectStrategy = redirectstrategy;
        targetAuthStrategy = authenticationstrategy;
        proxyAuthStrategy = authenticationstrategy1;
        userTokenHandler = usertokenhandler;
        params = httpparams;
        if (redirectstrategy instanceof DefaultRedirectStrategyAdaptor)
        {
            redirectHandler = ((DefaultRedirectStrategyAdaptor)redirectstrategy).getHandler();
        } else
        {
            redirectHandler = null;
        }
        if (authenticationstrategy instanceof AuthenticationStrategyAdaptor)
        {
            targetAuthHandler = ((AuthenticationStrategyAdaptor)authenticationstrategy).getHandler();
        } else
        {
            targetAuthHandler = null;
        }
        if (authenticationstrategy1 instanceof AuthenticationStrategyAdaptor)
        {
            proxyAuthHandler = ((AuthenticationStrategyAdaptor)authenticationstrategy1).getHandler();
        } else
        {
            proxyAuthHandler = null;
        }
        managedConn = null;
        execCount = 0;
        redirectCount = 0;
        targetAuthState = new AuthState();
        proxyAuthState = new AuthState();
        maxRedirects = params.getIntParameter("http.protocol.max-redirects", 100);
    }

    public DefaultRequestDirector(HttpRequestExecutor httprequestexecutor, ClientConnectionManager clientconnectionmanager, ConnectionReuseStrategy connectionreusestrategy, ConnectionKeepAliveStrategy connectionkeepalivestrategy, HttpRoutePlanner httprouteplanner, HttpProcessor httpprocessor, HttpRequestRetryHandler httprequestretryhandler, 
            RedirectHandler redirecthandler, AuthenticationHandler authenticationhandler, AuthenticationHandler authenticationhandler1, UserTokenHandler usertokenhandler, HttpParams httpparams)
    {
        this(new HttpClientAndroidLog(cz/msebera/android/httpclient/impl/client/DefaultRequestDirector), httprequestexecutor, clientconnectionmanager, connectionreusestrategy, connectionkeepalivestrategy, httprouteplanner, httpprocessor, httprequestretryhandler, ((RedirectStrategy) (new DefaultRedirectStrategyAdaptor(redirecthandler))), ((AuthenticationStrategy) (new AuthenticationStrategyAdaptor(authenticationhandler))), ((AuthenticationStrategy) (new AuthenticationStrategyAdaptor(authenticationhandler1))), usertokenhandler, httpparams);
    }

    private void abortConnection()
    {
        ManagedClientConnection managedclientconnection = managedConn;
        if (managedclientconnection == null) goto _L2; else goto _L1
_L1:
        managedConn = null;
        managedclientconnection.abortConnection();
_L4:
        managedclientconnection.releaseConnection();
_L2:
        return;
        IOException ioexception1;
        ioexception1;
        if (log.isDebugEnabled())
        {
            log.debug(ioexception1.getMessage(), ioexception1);
        }
        if (true) goto _L4; else goto _L3
_L3:
        IOException ioexception;
        ioexception;
        log.debug("Error releasing connection", ioexception);
        return;
    }

    private void tryConnect(RoutedRequest routedrequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        HttpRoute httproute;
        int i;
        httproute = routedrequest.getRoute();
        routedrequest = routedrequest.getRequest();
        i = 0;
_L4:
        int j;
        httpcontext.setAttribute("http.request", routedrequest);
        j = i + 1;
        if (managedConn.isOpen())
        {
            break MISSING_BLOCK_LABEL_62;
        }
        managedConn.open(httproute, httpcontext, params);
_L2:
        establishRoute(httproute, httpcontext);
        return;
        managedConn.setSocketTimeout(HttpConnectionParams.getSoTimeout(params));
        if (true) goto _L2; else goto _L1
_L1:
        IOException ioexception;
        ioexception;
        try
        {
            managedConn.close();
        }
        catch (IOException ioexception1) { }
        if (!retryHandler.retryRequest(ioexception, j, httpcontext))
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (log.isInfoEnabled())
        {
            log.info((new StringBuilder()).append("I/O exception (").append(ioexception.getClass().getName()).append(") caught when connecting to ").append(httproute).append(": ").append(ioexception.getMessage()).toString());
            if (log.isDebugEnabled())
            {
                log.debug(ioexception.getMessage(), ioexception);
            }
            log.info((new StringBuilder()).append("Retrying connect to ").append(httproute).toString());
            i = j;
        }
        if (true) goto _L4; else goto _L3
_L3:
        throw ioexception;
    }

    private HttpResponse tryExecute(RoutedRequest routedrequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        RequestWrapper requestwrapper;
        HttpRoute httproute;
        requestwrapper = routedrequest.getRequest();
        httproute = routedrequest.getRoute();
        routedrequest = null;
_L2:
        execCount = execCount + 1;
        requestwrapper.incrementExecCount();
        if (!requestwrapper.isRepeatable())
        {
            log.debug("Cannot retry non-repeatable request");
            if (routedrequest != null)
            {
                throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.  The cause lists the reason the original request failed.", routedrequest);
            } else
            {
                throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
            }
        }
label0:
        {
            if (!managedConn.isOpen())
            {
                if (httproute.isTunnelled())
                {
                    break label0;
                }
                log.debug("Reopening the direct connection.");
                managedConn.open(httproute, httpcontext, params);
            }
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Attempt ").append(execCount).append(" to execute request").toString());
            }
            return requestExec.execute(requestwrapper, managedConn, httpcontext);
        }
        log.debug("Proxied connection. Need to start over.");
        return null;
        routedrequest;
        log.debug("Closing the connection.");
        try
        {
            managedConn.close();
        }
        catch (IOException ioexception) { }
        if (!retryHandler.retryRequest(routedrequest, requestwrapper.getExecCount(), httpcontext))
        {
            break; /* Loop/switch isn't completed */
        }
        if (log.isInfoEnabled())
        {
            log.info((new StringBuilder()).append("I/O exception (").append(routedrequest.getClass().getName()).append(") caught when processing request to ").append(httproute).append(": ").append(routedrequest.getMessage()).toString());
        }
        if (log.isDebugEnabled())
        {
            log.debug(routedrequest.getMessage(), routedrequest);
        }
        if (log.isInfoEnabled())
        {
            log.info((new StringBuilder()).append("Retrying request to ").append(httproute).toString());
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (routedrequest instanceof NoHttpResponseException)
        {
            httpcontext = new NoHttpResponseException((new StringBuilder()).append(httproute.getTargetHost().toHostString()).append(" failed to respond").toString());
            httpcontext.setStackTrace(routedrequest.getStackTrace());
            throw httpcontext;
        } else
        {
            throw routedrequest;
        }
    }

    private RequestWrapper wrapRequest(HttpRequest httprequest)
        throws ProtocolException
    {
        if (httprequest instanceof HttpEntityEnclosingRequest)
        {
            return new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)httprequest);
        } else
        {
            return new RequestWrapper(httprequest);
        }
    }

    protected HttpRequest createConnectRequest(HttpRoute httproute, HttpContext httpcontext)
    {
        httpcontext = httproute.getTargetHost();
        httproute = httpcontext.getHostName();
        int j = httpcontext.getPort();
        int i = j;
        if (j < 0)
        {
            i = connManager.getSchemeRegistry().getScheme(httpcontext.getSchemeName()).getDefaultPort();
        }
        httpcontext = new StringBuilder(httproute.length() + 6);
        httpcontext.append(httproute);
        httpcontext.append(':');
        httpcontext.append(Integer.toString(i));
        return new BasicHttpRequest("CONNECT", httpcontext.toString(), HttpProtocolParams.getVersion(params));
    }

    protected boolean createTunnelToProxy(HttpRoute httproute, int i, HttpContext httpcontext)
        throws HttpException, IOException
    {
        throw new HttpException("Proxy chains are not supported.");
    }

    protected boolean createTunnelToTarget(HttpRoute httproute, HttpContext httpcontext)
        throws HttpException, IOException
    {
        HttpHost httphost = httproute.getProxyHost();
        HttpHost httphost1 = httproute.getTargetHost();
        Object obj;
        do
        {
            do
            {
                if (!managedConn.isOpen())
                {
                    managedConn.open(httproute, httpcontext, params);
                }
                obj = createConnectRequest(httproute, httpcontext);
                ((HttpRequest) (obj)).setParams(params);
                httpcontext.setAttribute("http.target_host", httphost1);
                httpcontext.setAttribute("http.route", httproute);
                httpcontext.setAttribute("http.proxy_host", httphost);
                httpcontext.setAttribute("http.connection", managedConn);
                httpcontext.setAttribute("http.request", obj);
                requestExec.preProcess(((HttpRequest) (obj)), httpProcessor, httpcontext);
                obj = requestExec.execute(((HttpRequest) (obj)), managedConn, httpcontext);
                ((HttpResponse) (obj)).setParams(params);
                requestExec.postProcess(((HttpResponse) (obj)), httpProcessor, httpcontext);
                if (((HttpResponse) (obj)).getStatusLine().getStatusCode() < 200)
                {
                    throw new HttpException((new StringBuilder()).append("Unexpected response to CONNECT request: ").append(((HttpResponse) (obj)).getStatusLine()).toString());
                }
            } while (!HttpClientParams.isAuthenticating(params));
            if (!authenticator.isAuthenticationRequested(httphost, ((HttpResponse) (obj)), proxyAuthStrategy, proxyAuthState, httpcontext) || !authenticator.authenticate(httphost, ((HttpResponse) (obj)), proxyAuthStrategy, proxyAuthState, httpcontext))
            {
                break;
            }
            if (reuseStrategy.keepAlive(((HttpResponse) (obj)), httpcontext))
            {
                log.debug("Connection kept alive");
                EntityUtils.consume(((HttpResponse) (obj)).getEntity());
            } else
            {
                managedConn.close();
            }
        } while (true);
        if (((HttpResponse) (obj)).getStatusLine().getStatusCode() > 299)
        {
            httproute = ((HttpResponse) (obj)).getEntity();
            if (httproute != null)
            {
                ((HttpResponse) (obj)).setEntity(new BufferedHttpEntity(httproute));
            }
            managedConn.close();
            throw new TunnelRefusedException((new StringBuilder()).append("CONNECT refused by proxy: ").append(((HttpResponse) (obj)).getStatusLine()).toString(), ((HttpResponse) (obj)));
        } else
        {
            managedConn.markReusable();
            return false;
        }
    }

    protected HttpRoute determineRoute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException
    {
        HttpRoutePlanner httprouteplanner = routePlanner;
        if (httphost == null)
        {
            httphost = (HttpHost)httprequest.getParams().getParameter("http.default-host");
        }
        return httprouteplanner.determineRoute(httphost, httprequest, httpcontext);
    }

    protected void establishRoute(HttpRoute httproute, HttpContext httpcontext)
        throws HttpException, IOException
    {
        BasicRouteDirector basicroutedirector = new BasicRouteDirector();
_L9:
        HttpRoute httproute1;
        int i;
        httproute1 = managedConn.getRoute();
        i = basicroutedirector.nextStep(httproute, httproute1);
        i;
        JVM INSTR tableswitch -1 5: default 76
    //                   -1 238
    //                   0 126
    //                   1 111
    //                   2 111
    //                   3 132
    //                   4 168
    //                   5 221;
           goto _L1 _L2 _L3 _L4 _L4 _L5 _L6 _L7
_L1:
        throw new IllegalStateException((new StringBuilder()).append("Unknown step indicator ").append(i).append(" from RouteDirector.").toString());
_L4:
        managedConn.open(httproute, httpcontext, params);
_L3:
        if (i > 0) goto _L9; else goto _L8
_L8:
        return;
_L5:
        boolean flag = createTunnelToTarget(httproute, httpcontext);
        log.debug("Tunnel to target created.");
        managedConn.tunnelTarget(flag, params);
          goto _L3
_L6:
        int j = httproute1.getHopCount() - 1;
        boolean flag1 = createTunnelToProxy(httproute, j, httpcontext);
        log.debug("Tunnel to proxy created.");
        managedConn.tunnelProxy(httproute.getHopTarget(j), flag1, params);
          goto _L3
_L7:
        managedConn.layerProtocol(httpcontext, params);
          goto _L3
          goto _L9
_L2:
        throw new HttpException((new StringBuilder()).append("Unable to establish route: planned = ").append(httproute).append("; current = ").append(httproute1).toString());
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Object obj1;
        Object obj2;
        Object obj3;
        HttpResponse httpresponse;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        httpcontext.setAttribute("http.auth.target-scope", targetAuthState);
        httpcontext.setAttribute("http.auth.proxy-scope", proxyAuthState);
        obj1 = wrapRequest(httprequest);
        ((RequestWrapper) (obj1)).setParams(params);
        obj2 = determineRoute(httphost, ((HttpRequest) (obj1)), httpcontext);
        virtualHost = (HttpHost)((RequestWrapper) (obj1)).getParams().getParameter("http.virtual-host");
        if (virtualHost != null && virtualHost.getPort() == -1)
        {
            Object obj;
            Object obj4;
            Object obj5;
            int i;
            long l;
            if (httphost != null)
            {
                obj = httphost;
            } else
            {
                obj = ((HttpRoute) (obj2)).getTargetHost();
            }
            i = ((HttpHost) (obj)).getPort();
            if (i != -1)
            {
                virtualHost = new HttpHost(virtualHost.getHostName(), i, virtualHost.getSchemeName());
            }
        }
        obj2 = new RoutedRequest(((RequestWrapper) (obj1)), ((HttpRoute) (obj2)));
        flag2 = false;
        flag = false;
        obj1 = null;
        if (flag) goto _L2; else goto _L1
_L1:
        obj1 = ((RoutedRequest) (obj2)).getRequest();
        obj3 = ((RoutedRequest) (obj2)).getRoute();
        obj5 = httpcontext.getAttribute("http.user-token");
        if (managedConn != null)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        obj = connManager.requestConnection(((HttpRoute) (obj3)), obj5);
        if (httprequest instanceof AbortableHttpRequest)
        {
            ((AbortableHttpRequest)httprequest).setConnectionRequest(((ClientConnectionRequest) (obj)));
        }
        l = HttpClientParams.getConnectionManagerTimeout(params);
        try
        {
            managedConn = ((ClientConnectionRequest) (obj)).getConnection(l, TimeUnit.MILLISECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            URI uri;
            try
            {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
            // Misplaced declaration of an exception variable
            catch (HttpHost httphost)
            {
                httprequest = new InterruptedIOException("Connection has been shut down");
                httprequest.initCause(httphost);
                throw httprequest;
            }
            // Misplaced declaration of an exception variable
            catch (HttpHost httphost)
            {
                abortConnection();
                throw httphost;
            }
            // Misplaced declaration of an exception variable
            catch (HttpHost httphost)
            {
                abortConnection();
                throw httphost;
            }
            // Misplaced declaration of an exception variable
            catch (HttpHost httphost)
            {
                abortConnection();
            }
            throw httphost;
        }
        if (HttpConnectionParams.isStaleCheckingEnabled(params) && managedConn.isOpen())
        {
            log.debug("Stale connection check");
            if (managedConn.isStale())
            {
                log.debug("Stale connection detected");
                managedConn.close();
            }
        }
        if (httprequest instanceof AbortableHttpRequest)
        {
            ((AbortableHttpRequest)httprequest).setReleaseTrigger(managedConn);
        }
        tryConnect(((RoutedRequest) (obj2)), httpcontext);
        obj = ((RequestWrapper) (obj1)).getURI().getUserInfo();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_382;
        }
        targetAuthState.update(new BasicScheme(), new UsernamePasswordCredentials(((String) (obj))));
        if (virtualHost == null) goto _L4; else goto _L3
_L3:
        httphost = virtualHost;
_L16:
        obj = httphost;
        if (httphost != null)
        {
            break MISSING_BLOCK_LABEL_408;
        }
        obj = ((HttpRoute) (obj3)).getTargetHost();
        ((RequestWrapper) (obj1)).resetHeaders();
        rewriteRequestURI(((RequestWrapper) (obj1)), ((HttpRoute) (obj3)));
        httpcontext.setAttribute("http.target_host", obj);
        httpcontext.setAttribute("http.route", obj3);
        httpcontext.setAttribute("http.connection", managedConn);
        requestExec.preProcess(((HttpRequest) (obj1)), httpProcessor, httpcontext);
        httpresponse = tryExecute(((RoutedRequest) (obj2)), httpcontext);
        obj1 = httpresponse;
        httphost = ((HttpHost) (obj));
        if (httpresponse == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        httpresponse.setParams(params);
        requestExec.postProcess(httpresponse, httpProcessor, httpcontext);
        flag3 = reuseStrategy.keepAlive(httpresponse, httpcontext);
        if (!flag3) goto _L6; else goto _L5
_L5:
        l = keepAliveStrategy.getKeepAliveDuration(httpresponse, httpcontext);
        if (!log.isDebugEnabled()) goto _L8; else goto _L7
_L7:
        if (l <= 0L) goto _L10; else goto _L9
_L9:
        httphost = (new StringBuilder()).append("for ").append(l).append(" ").append(TimeUnit.MILLISECONDS).toString();
_L18:
        log.debug((new StringBuilder()).append("Connection can be kept alive ").append(httphost).toString());
_L8:
        managedConn.setIdleDuration(l, TimeUnit.MILLISECONDS);
_L6:
        obj3 = handleResponse(((RoutedRequest) (obj2)), httpresponse, httpcontext);
        if (obj3 != null) goto _L12; else goto _L11
_L11:
        flag1 = true;
        obj3 = obj2;
_L19:
        flag = flag1;
        obj1 = httpresponse;
        flag2 = flag3;
        obj2 = obj3;
        httphost = ((HttpHost) (obj));
        if (managedConn == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        obj4 = obj5;
        if (obj5 != null)
        {
            break MISSING_BLOCK_LABEL_722;
        }
        obj4 = userTokenHandler.getUserToken(httpcontext);
        httpcontext.setAttribute("http.user-token", obj4);
        flag = flag1;
        obj1 = httpresponse;
        flag2 = flag3;
        obj2 = obj3;
        httphost = ((HttpHost) (obj));
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        managedConn.setState(obj4);
        flag = flag1;
        obj1 = httpresponse;
        flag2 = flag3;
        obj2 = obj3;
        httphost = ((HttpHost) (obj));
        break MISSING_BLOCK_LABEL_159;
        httphost;
        if (log.isDebugEnabled())
        {
            log.debug(httphost.getMessage());
        }
        obj1 = httphost.getResponse();
_L2:
        if (obj1 == null) goto _L14; else goto _L13
_L13:
        if (((HttpResponse) (obj1)).getEntity() != null && ((HttpResponse) (obj1)).getEntity().isStreaming()) goto _L15; else goto _L14
_L14:
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_903;
        }
        managedConn.markReusable();
        releaseConnection();
        return ((HttpResponse) (obj1));
_L4:
        uri = ((RequestWrapper) (obj1)).getURI();
        if (uri.isAbsolute())
        {
            httphost = URIUtils.extractHost(uri);
        }
          goto _L16
_L12:
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_981;
        }
        EntityUtils.consume(httpresponse.getEntity());
        managedConn.markReusable();
_L17:
        if (!((RoutedRequest) (obj3)).getRoute().equals(((RoutedRequest) (obj2)).getRoute()))
        {
            releaseConnection();
        }
        break MISSING_BLOCK_LABEL_1160;
        managedConn.close();
        if (proxyAuthState.getState().compareTo(AuthProtocolState.CHALLENGED) > 0 && proxyAuthState.getAuthScheme() != null && proxyAuthState.getAuthScheme().isConnectionBased())
        {
            log.debug("Resetting proxy auth state");
            proxyAuthState.reset();
        }
        if (targetAuthState.getState().compareTo(AuthProtocolState.CHALLENGED) > 0 && targetAuthState.getAuthScheme() != null && targetAuthState.getAuthScheme().isConnectionBased())
        {
            log.debug("Resetting target auth state");
            targetAuthState.reset();
        }
          goto _L17
_L15:
        ((HttpResponse) (obj1)).setEntity(new BasicManagedEntity(((HttpResponse) (obj1)).getEntity(), managedConn, flag2));
        return ((HttpResponse) (obj1));
_L10:
        httphost = "indefinitely";
          goto _L18
        flag1 = flag;
          goto _L19
    }

    protected RoutedRequest handleResponse(RoutedRequest routedrequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        HttpRoute httproute = routedrequest.getRoute();
        RequestWrapper requestwrapper = routedrequest.getRequest();
        HttpParams httpparams = requestwrapper.getParams();
        if (HttpClientParams.isAuthenticating(httpparams))
        {
            Object obj = (HttpHost)httpcontext.getAttribute("http.target_host");
            HttpHost httphost = ((HttpHost) (obj));
            if (obj == null)
            {
                httphost = httproute.getTargetHost();
            }
            obj = httphost;
            if (httphost.getPort() < 0)
            {
                obj = connManager.getSchemeRegistry().getScheme(httphost);
                obj = new HttpHost(httphost.getHostName(), ((Scheme) (obj)).getDefaultPort(), httphost.getSchemeName());
            }
            boolean flag = authenticator.isAuthenticationRequested(((HttpHost) (obj)), httpresponse, targetAuthStrategy, targetAuthState, httpcontext);
            HttpHost httphost2 = httproute.getProxyHost();
            httphost = httphost2;
            if (httphost2 == null)
            {
                httphost = httproute.getTargetHost();
            }
            for (boolean flag1 = authenticator.isAuthenticationRequested(httphost, httpresponse, proxyAuthStrategy, proxyAuthState, httpcontext); flag && authenticator.authenticate(((HttpHost) (obj)), httpresponse, targetAuthStrategy, targetAuthState, httpcontext) || flag1 && authenticator.authenticate(httphost, httpresponse, proxyAuthStrategy, proxyAuthState, httpcontext);)
            {
                return routedrequest;
            }

        }
        if (HttpClientParams.isRedirecting(httpparams) && redirectStrategy.isRedirected(requestwrapper, httpresponse, httpcontext))
        {
            if (redirectCount >= maxRedirects)
            {
                throw new RedirectException((new StringBuilder()).append("Maximum redirects (").append(maxRedirects).append(") exceeded").toString());
            }
            redirectCount = redirectCount + 1;
            virtualHost = null;
            httpresponse = redirectStrategy.getRedirect(requestwrapper, httpresponse, httpcontext);
            httpresponse.setHeaders(requestwrapper.getOriginal().getAllHeaders());
            routedrequest = httpresponse.getURI();
            HttpHost httphost1 = URIUtils.extractHost(routedrequest);
            if (httphost1 == null)
            {
                throw new ProtocolException((new StringBuilder()).append("Redirect URI does not specify a valid host name: ").append(routedrequest).toString());
            }
            if (!httproute.getTargetHost().equals(httphost1))
            {
                log.debug("Resetting target auth state");
                targetAuthState.reset();
                AuthScheme authscheme = proxyAuthState.getAuthScheme();
                if (authscheme != null && authscheme.isConnectionBased())
                {
                    log.debug("Resetting proxy auth state");
                    proxyAuthState.reset();
                }
            }
            httpresponse = wrapRequest(httpresponse);
            httpresponse.setParams(httpparams);
            httpcontext = determineRoute(httphost1, httpresponse, httpcontext);
            httpresponse = new RoutedRequest(httpresponse, httpcontext);
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Redirecting to '").append(routedrequest).append("' via ").append(httpcontext).toString());
            }
            return httpresponse;
        } else
        {
            return null;
        }
    }

    protected void releaseConnection()
    {
        try
        {
            managedConn.releaseConnection();
        }
        catch (IOException ioexception)
        {
            log.debug("IOException releasing connection", ioexception);
        }
        managedConn = null;
    }

    protected void rewriteRequestURI(RequestWrapper requestwrapper, HttpRoute httproute)
        throws ProtocolException
    {
        URI uri = requestwrapper.getURI();
        if (httproute.getProxyHost() == null || httproute.isTunnelled()) goto _L2; else goto _L1
_L1:
        if (uri.isAbsolute()) goto _L4; else goto _L3
_L3:
        httproute = URIUtils.rewriteURI(uri, httproute.getTargetHost(), true);
_L5:
        requestwrapper.setURI(httproute);
        return;
_L4:
        try
        {
            httproute = URIUtils.rewriteURI(uri);
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid URI: ").append(requestwrapper.getRequestLine().getUri()).toString(), httproute);
        }
          goto _L5
_L2:
label0:
        {
            if (!uri.isAbsolute())
            {
                break label0;
            }
            httproute = URIUtils.rewriteURI(uri, null, true);
        }
          goto _L5
        httproute = URIUtils.rewriteURI(uri);
          goto _L5
    }
}
