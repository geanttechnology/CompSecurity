// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.ConnectionReuseStrategy;
import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.HttpEntityEnclosingRequest;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.ProtocolException;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import com.comcast.cim.httpcomponentsandroid.auth.AuthScheme;
import com.comcast.cim.httpcomponentsandroid.auth.AuthScope;
import com.comcast.cim.httpcomponentsandroid.auth.AuthState;
import com.comcast.cim.httpcomponentsandroid.auth.AuthenticationException;
import com.comcast.cim.httpcomponentsandroid.auth.MalformedChallengeException;
import com.comcast.cim.httpcomponentsandroid.client.AuthenticationHandler;
import com.comcast.cim.httpcomponentsandroid.client.CredentialsProvider;
import com.comcast.cim.httpcomponentsandroid.client.HttpRequestRetryHandler;
import com.comcast.cim.httpcomponentsandroid.client.NonRepeatableRequestException;
import com.comcast.cim.httpcomponentsandroid.client.RedirectException;
import com.comcast.cim.httpcomponentsandroid.client.RedirectHandler;
import com.comcast.cim.httpcomponentsandroid.client.RedirectStrategy;
import com.comcast.cim.httpcomponentsandroid.client.RequestDirector;
import com.comcast.cim.httpcomponentsandroid.client.UserTokenHandler;
import com.comcast.cim.httpcomponentsandroid.client.methods.AbortableHttpRequest;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import com.comcast.cim.httpcomponentsandroid.client.params.HttpClientParams;
import com.comcast.cim.httpcomponentsandroid.client.utils.URIUtils;
import com.comcast.cim.httpcomponentsandroid.conn.BasicManagedEntity;
import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionManager;
import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionRequest;
import com.comcast.cim.httpcomponentsandroid.conn.ConnectionKeepAliveStrategy;
import com.comcast.cim.httpcomponentsandroid.conn.ManagedClientConnection;
import com.comcast.cim.httpcomponentsandroid.conn.params.ConnManagerParams;
import com.comcast.cim.httpcomponentsandroid.conn.routing.BasicRouteDirector;
import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;
import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRouteDirector;
import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoutePlanner;
import com.comcast.cim.httpcomponentsandroid.conn.scheme.Scheme;
import com.comcast.cim.httpcomponentsandroid.conn.scheme.SchemeRegistry;
import com.comcast.cim.httpcomponentsandroid.entity.BufferedHttpEntity;
import com.comcast.cim.httpcomponentsandroid.impl.conn.ConnectionShutdownException;
import com.comcast.cim.httpcomponentsandroid.message.BasicHttpRequest;
import com.comcast.cim.httpcomponentsandroid.params.HttpConnectionParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpProtocolParams;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpProcessor;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpRequestExecutor;
import com.comcast.cim.httpcomponentsandroid.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.client:
//            RoutedRequest, RequestWrapper, EntityEnclosingRequestWrapper, TunnelRefusedException

public class DefaultRequestDirector
    implements RequestDirector
{

    protected final ClientConnectionManager connManager;
    private int execCount;
    protected final HttpProcessor httpProcessor;
    protected final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final Log log;
    protected ManagedClientConnection managedConn;
    private int maxRedirects;
    protected final HttpParams params;
    protected final AuthenticationHandler proxyAuthHandler;
    protected final AuthState proxyAuthState;
    private int redirectCount;
    protected final RedirectHandler redirectHandler = null;
    protected final RedirectStrategy redirectStrategy;
    protected final HttpRequestExecutor requestExec;
    protected final HttpRequestRetryHandler retryHandler;
    protected final ConnectionReuseStrategy reuseStrategy;
    protected final HttpRoutePlanner routePlanner;
    protected final AuthenticationHandler targetAuthHandler;
    protected final AuthState targetAuthState;
    protected final UserTokenHandler userTokenHandler;
    private HttpHost virtualHost;

    public DefaultRequestDirector(Log log1, HttpRequestExecutor httprequestexecutor, ClientConnectionManager clientconnectionmanager, ConnectionReuseStrategy connectionreusestrategy, ConnectionKeepAliveStrategy connectionkeepalivestrategy, HttpRoutePlanner httprouteplanner, HttpProcessor httpprocessor, 
            HttpRequestRetryHandler httprequestretryhandler, RedirectStrategy redirectstrategy, AuthenticationHandler authenticationhandler, AuthenticationHandler authenticationhandler1, UserTokenHandler usertokenhandler, HttpParams httpparams)
    {
        if (log1 == null)
        {
            throw new IllegalArgumentException("Log may not be null.");
        }
        if (httprequestexecutor == null)
        {
            throw new IllegalArgumentException("Request executor may not be null.");
        }
        if (clientconnectionmanager == null)
        {
            throw new IllegalArgumentException("Client connection manager may not be null.");
        }
        if (connectionreusestrategy == null)
        {
            throw new IllegalArgumentException("Connection reuse strategy may not be null.");
        }
        if (connectionkeepalivestrategy == null)
        {
            throw new IllegalArgumentException("Connection keep alive strategy may not be null.");
        }
        if (httprouteplanner == null)
        {
            throw new IllegalArgumentException("Route planner may not be null.");
        }
        if (httpprocessor == null)
        {
            throw new IllegalArgumentException("HTTP protocol processor may not be null.");
        }
        if (httprequestretryhandler == null)
        {
            throw new IllegalArgumentException("HTTP request retry handler may not be null.");
        }
        if (redirectstrategy == null)
        {
            throw new IllegalArgumentException("Redirect strategy may not be null.");
        }
        if (authenticationhandler == null)
        {
            throw new IllegalArgumentException("Target authentication handler may not be null.");
        }
        if (authenticationhandler1 == null)
        {
            throw new IllegalArgumentException("Proxy authentication handler may not be null.");
        }
        if (usertokenhandler == null)
        {
            throw new IllegalArgumentException("User token handler may not be null.");
        }
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            log = log1;
            requestExec = httprequestexecutor;
            connManager = clientconnectionmanager;
            reuseStrategy = connectionreusestrategy;
            keepAliveStrategy = connectionkeepalivestrategy;
            routePlanner = httprouteplanner;
            httpProcessor = httpprocessor;
            retryHandler = httprequestretryhandler;
            redirectStrategy = redirectstrategy;
            targetAuthHandler = authenticationhandler;
            proxyAuthHandler = authenticationhandler1;
            userTokenHandler = usertokenhandler;
            params = httpparams;
            managedConn = null;
            execCount = 0;
            redirectCount = 0;
            maxRedirects = params.getIntParameter("http.protocol.max-redirects", 100);
            targetAuthState = new AuthState();
            proxyAuthState = new AuthState();
            return;
        }
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

    private void invalidateAuthIfSuccessful(AuthState authstate)
    {
        AuthScheme authscheme = authstate.getAuthScheme();
        if (authscheme != null && authscheme.isConnectionBased() && authscheme.isComplete() && authstate.getCredentials() != null)
        {
            authstate.invalidate();
        }
    }

    private void processChallenges(Map map, AuthState authstate, AuthenticationHandler authenticationhandler, HttpResponse httpresponse, HttpContext httpcontext)
        throws MalformedChallengeException, AuthenticationException
    {
        AuthScheme authscheme1 = authstate.getAuthScheme();
        AuthScheme authscheme = authscheme1;
        if (authscheme1 == null)
        {
            authscheme = authenticationhandler.selectScheme(map, httpresponse, httpcontext);
            authstate.setAuthScheme(authscheme);
        }
        authstate = authscheme.getSchemeName();
        map = (Header)map.get(authstate.toLowerCase(Locale.ENGLISH));
        if (map == null)
        {
            throw new AuthenticationException((new StringBuilder()).append(authstate).append(" authorization challenge expected, but not found").toString());
        } else
        {
            authscheme.processChallenge(map);
            log.debug("Authorization challenge processed");
            return;
        }
    }

    private void tryConnect(RoutedRequest routedrequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        HttpRoute httproute;
        int i;
        httproute = routedrequest.getRoute();
        httpcontext.setAttribute("http.request", routedrequest.getRequest());
        i = 0;
_L4:
        i++;
        if (managedConn.isOpen())
        {
            break MISSING_BLOCK_LABEL_61;
        }
        managedConn.open(httproute, httpcontext, params);
_L2:
        establishRoute(httproute, httpcontext);
        return;
        managedConn.setSocketTimeout(HttpConnectionParams.getSoTimeout(params));
        if (true) goto _L2; else goto _L1
_L1:
        routedrequest;
        try
        {
            managedConn.close();
        }
        catch (IOException ioexception) { }
        if (retryHandler.retryRequest(routedrequest, i, httpcontext))
        {
            if (log.isInfoEnabled())
            {
                log.info((new StringBuilder()).append("I/O exception (").append(routedrequest.getClass().getName()).append(") caught when connecting to the target host: ").append(routedrequest.getMessage()).toString());
            }
            if (log.isDebugEnabled())
            {
                log.debug(routedrequest.getMessage(), routedrequest);
            }
            log.info("Retrying connect");
        } else
        {
            throw routedrequest;
        }
        if (true) goto _L4; else goto _L3
_L3:
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
        if (retryHandler.retryRequest(routedrequest, requestwrapper.getExecCount(), httpcontext))
        {
            if (log.isInfoEnabled())
            {
                log.info((new StringBuilder()).append("I/O exception (").append(routedrequest.getClass().getName()).append(") caught when processing request: ").append(routedrequest.getMessage()).toString());
            }
            if (log.isDebugEnabled())
            {
                log.debug(routedrequest.getMessage(), routedrequest);
            }
            log.info("Retrying request");
        } else
        {
            throw routedrequest;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void updateAuthState(AuthState authstate, HttpHost httphost, CredentialsProvider credentialsprovider)
    {
        Object obj;
        AuthScheme authscheme;
        if (!authstate.isValid())
        {
            return;
        }
        obj = httphost.getHostName();
        int j = httphost.getPort();
        int i = j;
        if (j < 0)
        {
            i = connManager.getSchemeRegistry().getScheme(httphost).getDefaultPort();
        }
        authscheme = authstate.getAuthScheme();
        obj = new AuthScope(((String) (obj)), i, authscheme.getRealm(), authscheme.getSchemeName());
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Authentication scope: ").append(obj).toString());
        }
        httphost = authstate.getCredentials();
        if (httphost != null) goto _L2; else goto _L1
_L1:
        credentialsprovider = credentialsprovider.getCredentials(((AuthScope) (obj)));
        httphost = credentialsprovider;
        if (log.isDebugEnabled())
        {
            if (credentialsprovider != null)
            {
                log.debug("Found credentials");
                httphost = credentialsprovider;
            } else
            {
                log.debug("Credentials not found");
                httphost = credentialsprovider;
            }
        }
_L4:
        authstate.setAuthScope(((AuthScope) (obj)));
        authstate.setCredentials(httphost);
        return;
_L2:
        if (authscheme.isComplete())
        {
            log.debug("Authentication failed");
            httphost = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
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
        Object obj;
        HttpHost httphost;
        HttpHost httphost1;
        boolean flag;
        httphost = httproute.getProxyHost();
        httphost1 = httproute.getTargetHost();
        obj = null;
        flag = false;
_L2:
        HttpResponse httpresponse;
        CredentialsProvider credentialsprovider;
        boolean flag1;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_470;
        }
        flag1 = true;
        if (!managedConn.isOpen())
        {
            managedConn.open(httproute, httpcontext, params);
        }
        obj = createConnectRequest(httproute, httpcontext);
        ((HttpRequest) (obj)).setParams(params);
        httpcontext.setAttribute("http.target_host", httphost1);
        httpcontext.setAttribute("http.proxy_host", httphost);
        httpcontext.setAttribute("http.connection", managedConn);
        httpcontext.setAttribute("http.auth.target-scope", targetAuthState);
        httpcontext.setAttribute("http.auth.proxy-scope", proxyAuthState);
        httpcontext.setAttribute("http.request", obj);
        requestExec.preProcess(((HttpRequest) (obj)), httpProcessor, httpcontext);
        httpresponse = requestExec.execute(((HttpRequest) (obj)), managedConn, httpcontext);
        httpresponse.setParams(params);
        requestExec.postProcess(httpresponse, httpProcessor, httpcontext);
        if (httpresponse.getStatusLine().getStatusCode() < 200)
        {
            throw new HttpException((new StringBuilder()).append("Unexpected response to CONNECT request: ").append(httpresponse.getStatusLine()).toString());
        }
        credentialsprovider = (CredentialsProvider)httpcontext.getAttribute("http.auth.credentials-provider");
        obj = httpresponse;
        flag = flag1;
        if (credentialsprovider == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = httpresponse;
        flag = flag1;
        if (!HttpClientParams.isAuthenticating(params))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!proxyAuthHandler.isAuthenticationRequested(httpresponse, httpcontext))
        {
            break MISSING_BLOCK_LABEL_570;
        }
        log.debug("Proxy requested authentication");
        obj = proxyAuthHandler.getChallenges(httpresponse, httpcontext);
        processChallenges(((Map) (obj)), proxyAuthState, proxyAuthHandler, httpresponse, httpcontext);
        updateAuthState(proxyAuthState, httphost, credentialsprovider);
        obj = httpresponse;
        flag = flag1;
        if (proxyAuthState.getCredentials() != null)
        {
            flag = false;
            if (reuseStrategy.keepAlive(httpresponse, httpcontext))
            {
                log.debug("Connection kept alive");
                EntityUtils.consume(httpresponse.getEntity());
                obj = httpresponse;
            } else
            {
                managedConn.close();
                obj = httpresponse;
            }
        }
        continue; /* Loop/switch isn't completed */
        httproute;
        obj = httpresponse;
        if (log.isWarnEnabled())
        {
            log.warn((new StringBuilder()).append("Authentication error: ").append(httproute.getMessage()).toString());
            obj = httpresponse;
        }
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
        proxyAuthState.setAuthScope(null);
        obj = httpresponse;
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected HttpRoute determineRoute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException
    {
        HttpHost httphost1 = httphost;
        if (httphost == null)
        {
            httphost1 = (HttpHost)httprequest.getParams().getParameter("http.default-host");
        }
        if (httphost1 == null)
        {
            throw new IllegalStateException("Target host must not be null, or set in parameters.");
        } else
        {
            return routePlanner.determineRoute(httphost1, httprequest, httpcontext);
        }
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
    //                   -1 242
    //                   0 126
    //                   1 111
    //                   2 111
    //                   3 132
    //                   4 170
    //                   5 225;
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
        Object obj;
        boolean flag;
        boolean flag2;
        obj = wrapRequest(httprequest);
        ((RequestWrapper) (obj)).setParams(params);
        HttpRoute httproute = determineRoute(httphost, ((HttpRequest) (obj)), httpcontext);
        virtualHost = (HttpHost)httprequest.getParams().getParameter("http.virtual-host");
        if (virtualHost != null && virtualHost.getPort() == -1)
        {
            int i = httphost.getPort();
            if (i != -1)
            {
                virtualHost = new HttpHost(virtualHost.getHostName(), i, virtualHost.getSchemeName());
            }
        }
        obj = new RoutedRequest(((RequestWrapper) (obj)), httproute);
        flag2 = false;
        flag = false;
        httphost = null;
_L4:
        if (flag) goto _L2; else goto _L1
_L1:
        Object obj2;
        Object obj3;
        HttpRoute httproute1;
        long l;
        obj2 = ((RoutedRequest) (obj)).getRequest();
        httproute1 = ((RoutedRequest) (obj)).getRoute();
        obj3 = httpcontext.getAttribute("http.user-token");
        if (managedConn != null)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        httphost = connManager.requestConnection(httproute1, obj3);
        if (httprequest instanceof AbortableHttpRequest)
        {
            ((AbortableHttpRequest)httprequest).setConnectionRequest(httphost);
        }
        l = ConnManagerParams.getTimeout(params);
        Object obj1;
        boolean flag1;
        boolean flag3;
        try
        {
            managedConn = httphost.getConnection(l, TimeUnit.MILLISECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            try
            {
                httprequest = new InterruptedIOException();
                httprequest.initCause(httphost);
                throw httprequest;
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
        tryConnect(((RoutedRequest) (obj)), httpcontext);
        ((RequestWrapper) (obj2)).resetHeaders();
        rewriteRequestURI(((RequestWrapper) (obj2)), httproute1);
        obj1 = virtualHost;
        httphost = ((HttpHost) (obj1));
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        httphost = httproute1.getTargetHost();
        obj1 = httproute1.getProxyHost();
        httpcontext.setAttribute("http.target_host", httphost);
        httpcontext.setAttribute("http.proxy_host", obj1);
        httpcontext.setAttribute("http.connection", managedConn);
        httpcontext.setAttribute("http.auth.target-scope", targetAuthState);
        httpcontext.setAttribute("http.auth.proxy-scope", proxyAuthState);
        requestExec.preProcess(((HttpRequest) (obj2)), httpProcessor, httpcontext);
        obj2 = tryExecute(((RoutedRequest) (obj)), httpcontext);
        httphost = ((HttpHost) (obj2));
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        ((HttpResponse) (obj2)).setParams(params);
        requestExec.postProcess(((HttpResponse) (obj2)), httpProcessor, httpcontext);
        flag3 = reuseStrategy.keepAlive(((HttpResponse) (obj2)), httpcontext);
        if (!flag3) goto _L6; else goto _L5
_L5:
        l = keepAliveStrategy.getKeepAliveDuration(((HttpResponse) (obj2)), httpcontext);
        if (!log.isDebugEnabled()) goto _L8; else goto _L7
_L7:
        if (l <= 0L) goto _L10; else goto _L9
_L9:
        httphost = (new StringBuilder()).append("for ").append(l).append(" ").append(TimeUnit.MILLISECONDS).toString();
_L20:
        log.debug((new StringBuilder()).append("Connection can be kept alive ").append(httphost).toString());
_L8:
        managedConn.setIdleDuration(l, TimeUnit.MILLISECONDS);
_L6:
        obj1 = handleResponse(((RoutedRequest) (obj)), ((HttpResponse) (obj2)), httpcontext);
        if (obj1 != null) goto _L12; else goto _L11
_L11:
        flag1 = true;
        obj1 = obj;
_L21:
        flag = flag1;
        httphost = ((HttpHost) (obj2));
        flag2 = flag3;
        obj = obj1;
        if (managedConn == null) goto _L4; else goto _L13
_L13:
        flag = flag1;
        httphost = ((HttpHost) (obj2));
        flag2 = flag3;
        obj = obj1;
        if (obj3 != null) goto _L4; else goto _L14
_L14:
        obj3 = userTokenHandler.getUserToken(httpcontext);
        httpcontext.setAttribute("http.user-token", obj3);
        flag = flag1;
        httphost = ((HttpHost) (obj2));
        flag2 = flag3;
        obj = obj1;
        if (obj3 == null) goto _L4; else goto _L15
_L15:
        managedConn.setState(obj3);
        flag = flag1;
        httphost = ((HttpHost) (obj2));
        flag2 = flag3;
        obj = obj1;
          goto _L4
        httphost;
        if (log.isDebugEnabled())
        {
            log.debug(httphost.getMessage());
        }
        httphost = httphost.getResponse();
_L2:
        if (httphost == null) goto _L17; else goto _L16
_L16:
        if (httphost.getEntity() != null && httphost.getEntity().isStreaming()) goto _L18; else goto _L17
_L17:
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_849;
        }
        managedConn.markReusable();
        releaseConnection();
        return httphost;
_L12:
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_902;
        }
        EntityUtils.consume(((HttpResponse) (obj2)).getEntity());
        managedConn.markReusable();
_L19:
        if (!((RoutedRequest) (obj1)).getRoute().equals(((RoutedRequest) (obj)).getRoute()))
        {
            releaseConnection();
        }
        break MISSING_BLOCK_LABEL_978;
        managedConn.close();
        invalidateAuthIfSuccessful(proxyAuthState);
        invalidateAuthIfSuccessful(targetAuthState);
          goto _L19
_L18:
        httphost.setEntity(new BasicManagedEntity(httphost.getEntity(), managedConn, flag2));
        return httphost;
_L10:
        httphost = "indefinitely";
          goto _L20
        flag1 = flag;
          goto _L21
    }

    protected RoutedRequest handleResponse(RoutedRequest routedrequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Object obj;
        Object obj1;
        Object obj3;
        obj3 = routedrequest.getRoute();
        obj1 = routedrequest.getRequest();
        obj = ((RequestWrapper) (obj1)).getParams();
        if (!HttpClientParams.isRedirecting(((HttpParams) (obj))) || !redirectStrategy.isRedirected(((HttpRequest) (obj1)), httpresponse, httpcontext)) goto _L2; else goto _L1
_L1:
        if (redirectCount >= maxRedirects)
        {
            throw new RedirectException((new StringBuilder()).append("Maximum redirects (").append(maxRedirects).append(") exceeded").toString());
        }
        redirectCount = redirectCount + 1;
        virtualHost = null;
        routedrequest = redirectStrategy.getRedirect(((HttpRequest) (obj1)), httpresponse, httpcontext);
        routedrequest.setHeaders(((RequestWrapper) (obj1)).getOriginal().getAllHeaders());
        httpresponse = routedrequest.getURI();
        if (httpresponse.getHost() == null)
        {
            throw new ProtocolException((new StringBuilder()).append("Redirect URI does not specify a valid host name: ").append(httpresponse).toString());
        }
        obj1 = new HttpHost(httpresponse.getHost(), httpresponse.getPort(), httpresponse.getScheme());
        targetAuthState.setAuthScope(null);
        proxyAuthState.setAuthScope(null);
        if (!((HttpRoute) (obj3)).getTargetHost().equals(obj1))
        {
            targetAuthState.invalidate();
            obj3 = proxyAuthState.getAuthScheme();
            if (obj3 != null && ((AuthScheme) (obj3)).isConnectionBased())
            {
                proxyAuthState.invalidate();
            }
        }
        routedrequest = wrapRequest(routedrequest);
        routedrequest.setParams(((HttpParams) (obj)));
        httpcontext = determineRoute(((HttpHost) (obj1)), routedrequest, httpcontext);
        routedrequest = new RoutedRequest(routedrequest, httpcontext);
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Redirecting to '").append(httpresponse).append("' via ").append(httpcontext).toString());
        }
_L4:
        return routedrequest;
_L2:
        CredentialsProvider credentialsprovider = (CredentialsProvider)httpcontext.getAttribute("http.auth.credentials-provider");
        if (credentialsprovider == null || !HttpClientParams.isAuthenticating(((HttpParams) (obj))))
        {
            break MISSING_BLOCK_LABEL_682;
        }
        if (targetAuthHandler.isAuthenticationRequested(httpresponse, httpcontext))
        {
            Object obj2 = (HttpHost)httpcontext.getAttribute("http.target_host");
            obj = obj2;
            if (obj2 == null)
            {
                obj = ((HttpRoute) (obj3)).getTargetHost();
            }
            log.debug("Target requested authentication");
            obj2 = targetAuthHandler.getChallenges(httpresponse, httpcontext);
            try
            {
                processChallenges(((Map) (obj2)), targetAuthState, targetAuthHandler, httpresponse, httpcontext);
            }
            // Misplaced declaration of an exception variable
            catch (RoutedRequest routedrequest)
            {
                if (log.isWarnEnabled())
                {
                    log.warn((new StringBuilder()).append("Authentication error: ").append(routedrequest.getMessage()).toString());
                }
                return null;
            }
            updateAuthState(targetAuthState, ((HttpHost) (obj)), credentialsprovider);
            if (targetAuthState.getCredentials() == null)
            {
                return null;
            }
            continue; /* Loop/switch isn't completed */
        }
        targetAuthState.setAuthScope(null);
        if (!proxyAuthHandler.isAuthenticationRequested(httpresponse, httpcontext))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((HttpRoute) (obj3)).getProxyHost();
        log.debug("Proxy requested authentication");
        Map map = proxyAuthHandler.getChallenges(httpresponse, httpcontext);
        try
        {
            processChallenges(map, proxyAuthState, proxyAuthHandler, httpresponse, httpcontext);
        }
        // Misplaced declaration of an exception variable
        catch (RoutedRequest routedrequest)
        {
            if (log.isWarnEnabled())
            {
                log.warn((new StringBuilder()).append("Authentication error: ").append(routedrequest.getMessage()).toString());
            }
            return null;
        }
        updateAuthState(proxyAuthState, ((HttpHost) (obj)), credentialsprovider);
        if (proxyAuthState.getCredentials() == null)
        {
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
        proxyAuthState.setAuthScope(null);
        return null;
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
        URI uri;
        uri = requestwrapper.getURI();
        if (httproute.getProxyHost() != null && !httproute.isTunnelled())
        {
            if (!uri.isAbsolute())
            {
                requestwrapper.setURI(URIUtils.rewriteURI(uri, httproute.getTargetHost()));
                return;
            }
            break MISSING_BLOCK_LABEL_94;
        }
        try
        {
            if (uri.isAbsolute())
            {
                requestwrapper.setURI(URIUtils.rewriteURI(uri, null));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid URI: ").append(requestwrapper.getRequestLine().getUri()).toString(), httproute);
        }
    }
}
