// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.BasicRouteDirector;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRouteDirector;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.entity.BufferedHttpEntity;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.auth.HttpAuthenticator;
import cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import cz.msebera.android.httpclient.message.BasicHttpRequest;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.execchain:
//            ClientExecChain, TunnelRefusedException, RequestEntityProxy, RequestAbortedException, 
//            ConnectionHolder, HttpResponseProxy

public class MainClientExec
    implements ClientExecChain
{

    private final HttpAuthenticator authenticator = new HttpAuthenticator();
    private final HttpClientConnectionManager connManager;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log;
    private final AuthenticationStrategy proxyAuthStrategy;
    private final HttpProcessor proxyHttpProcessor = new ImmutableHttpProcessor(new HttpRequestInterceptor[] {
        new RequestTargetHost(), new RequestClientConnControl()
    });
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;
    private final HttpRouteDirector routeDirector = new BasicRouteDirector();
    private final AuthenticationStrategy targetAuthStrategy;
    private final UserTokenHandler userTokenHandler;

    public MainClientExec(HttpRequestExecutor httprequestexecutor, HttpClientConnectionManager httpclientconnectionmanager, ConnectionReuseStrategy connectionreusestrategy, ConnectionKeepAliveStrategy connectionkeepalivestrategy, AuthenticationStrategy authenticationstrategy, AuthenticationStrategy authenticationstrategy1, UserTokenHandler usertokenhandler)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(httprequestexecutor, "HTTP request executor");
        Args.notNull(httpclientconnectionmanager, "Client connection manager");
        Args.notNull(connectionreusestrategy, "Connection reuse strategy");
        Args.notNull(connectionkeepalivestrategy, "Connection keep alive strategy");
        Args.notNull(authenticationstrategy, "Target authentication strategy");
        Args.notNull(authenticationstrategy1, "Proxy authentication strategy");
        Args.notNull(usertokenhandler, "User token handler");
        requestExecutor = httprequestexecutor;
        connManager = httpclientconnectionmanager;
        reuseStrategy = connectionreusestrategy;
        keepAliveStrategy = connectionkeepalivestrategy;
        targetAuthStrategy = authenticationstrategy;
        proxyAuthStrategy = authenticationstrategy1;
        userTokenHandler = usertokenhandler;
    }

    private boolean createTunnelToProxy(HttpRoute httproute, int i, HttpClientContext httpclientcontext)
        throws HttpException
    {
        throw new HttpException("Proxy chains are not supported.");
    }

    private boolean createTunnelToTarget(AuthState authstate, HttpClientConnection httpclientconnection, HttpRoute httproute, HttpRequest httprequest, HttpClientContext httpclientcontext)
        throws HttpException, IOException
    {
        RequestConfig requestconfig = httpclientcontext.getRequestConfig();
        int j = requestconfig.getConnectTimeout();
        Object obj1 = httproute.getTargetHost();
        HttpHost httphost = httproute.getProxyHost();
        Object obj = null;
        obj1 = new BasicHttpRequest("CONNECT", ((HttpHost) (obj1)).toHostString(), httprequest.getProtocolVersion());
        requestExecutor.preProcess(((HttpRequest) (obj1)), proxyHttpProcessor, httpclientcontext);
        httprequest = obj;
        do
        {
            if (httprequest != null)
            {
                break;
            }
            HttpResponse httpresponse;
            if (!httpclientconnection.isOpen())
            {
                httprequest = connManager;
                int i;
                if (j > 0)
                {
                    i = j;
                } else
                {
                    i = 0;
                }
                httprequest.connect(httpclientconnection, httproute, i, httpclientcontext);
            }
            ((HttpRequest) (obj1)).removeHeaders("Proxy-Authorization");
            authenticator.generateAuthResponse(((HttpRequest) (obj1)), authstate, httpclientcontext);
            httpresponse = requestExecutor.execute(((HttpRequest) (obj1)), httpclientconnection, httpclientcontext);
            if (httpresponse.getStatusLine().getStatusCode() < 200)
            {
                throw new HttpException((new StringBuilder()).append("Unexpected response to CONNECT request: ").append(httpresponse.getStatusLine()).toString());
            }
            httprequest = httpresponse;
            if (requestconfig.isAuthenticationEnabled())
            {
                httprequest = httpresponse;
                if (authenticator.isAuthenticationRequested(httphost, httpresponse, proxyAuthStrategy, authstate, httpclientcontext))
                {
                    httprequest = httpresponse;
                    if (authenticator.handleAuthChallenge(httphost, httpresponse, proxyAuthStrategy, authstate, httpclientcontext))
                    {
                        if (reuseStrategy.keepAlive(httpresponse, httpclientcontext))
                        {
                            log.debug("Connection kept alive");
                            EntityUtils.consume(httpresponse.getEntity());
                        } else
                        {
                            httpclientconnection.close();
                        }
                        httprequest = null;
                    }
                }
            }
        } while (true);
        if (httprequest.getStatusLine().getStatusCode() > 299)
        {
            authstate = httprequest.getEntity();
            if (authstate != null)
            {
                httprequest.setEntity(new BufferedHttpEntity(authstate));
            }
            httpclientconnection.close();
            throw new TunnelRefusedException((new StringBuilder()).append("CONNECT refused by proxy: ").append(httprequest.getStatusLine()).toString(), httprequest);
        } else
        {
            return false;
        }
    }

    private boolean needAuthentication(AuthState authstate, AuthState authstate1, HttpRoute httproute, HttpResponse httpresponse, HttpClientContext httpclientcontext)
    {
        if (httpclientcontext.getRequestConfig().isAuthenticationEnabled())
        {
            HttpHost httphost1 = httpclientcontext.getTargetHost();
            HttpHost httphost = httphost1;
            if (httphost1 == null)
            {
                httphost = httproute.getTargetHost();
            }
            httphost1 = httphost;
            if (httphost.getPort() < 0)
            {
                httphost1 = new HttpHost(httphost.getHostName(), httproute.getTargetHost().getPort(), httphost.getSchemeName());
            }
            boolean flag = authenticator.isAuthenticationRequested(httphost1, httpresponse, targetAuthStrategy, authstate, httpclientcontext);
            HttpHost httphost2 = httproute.getProxyHost();
            httphost = httphost2;
            if (httphost2 == null)
            {
                httphost = httproute.getTargetHost();
            }
            boolean flag1 = authenticator.isAuthenticationRequested(httphost, httpresponse, proxyAuthStrategy, authstate1, httpclientcontext);
            if (flag)
            {
                return authenticator.handleAuthChallenge(httphost1, httpresponse, targetAuthStrategy, authstate, httpclientcontext);
            }
            if (flag1)
            {
                return authenticator.handleAuthChallenge(httphost, httpresponse, proxyAuthStrategy, authstate1, httpclientcontext);
            }
        }
        return false;
    }

    void establishRoute(AuthState authstate, HttpClientConnection httpclientconnection, HttpRoute httproute, HttpRequest httprequest, HttpClientContext httpclientcontext)
        throws HttpException, IOException
    {
        RouteTracker routetracker;
        int i;
        i = httpclientcontext.getRequestConfig().getConnectTimeout();
        routetracker = new RouteTracker(httproute);
_L10:
        Object obj;
        int i1;
        obj = routetracker.toRoute();
        i1 = routeDirector.nextStep(httproute, ((cz.msebera.android.httpclient.conn.routing.RouteInfo) (obj)));
        i1;
        JVM INSTR tableswitch -1 5: default 84
    //                   -1 319
    //                   0 358
    //                   1 119
    //                   2 168
    //                   3 215
    //                   4 248
    //                   5 294;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        break MISSING_BLOCK_LABEL_358;
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalStateException((new StringBuilder()).append("Unknown step indicator ").append(i1).append(" from RouteDirector.").toString());
_L4:
        obj = connManager;
        int j;
        if (i > 0)
        {
            j = i;
        } else
        {
            j = 0;
        }
        ((HttpClientConnectionManager) (obj)).connect(httpclientconnection, httproute, j, httpclientcontext);
        routetracker.connectTarget(httproute.isSecure());
_L11:
        if (i1 <= 0)
        {
            return;
        }
        if (true) goto _L10; else goto _L9
_L9:
        obj = connManager;
        int k;
        if (i > 0)
        {
            k = i;
        } else
        {
            k = 0;
        }
        ((HttpClientConnectionManager) (obj)).connect(httpclientconnection, httproute, k, httpclientcontext);
        routetracker.connectProxy(httproute.getProxyHost(), false);
          goto _L11
_L6:
        boolean flag = createTunnelToTarget(authstate, httpclientconnection, httproute, httprequest, httpclientcontext);
        log.debug("Tunnel to target created.");
        routetracker.tunnelTarget(flag);
          goto _L11
_L7:
        int l = ((HttpRoute) (obj)).getHopCount() - 1;
        boolean flag1 = createTunnelToProxy(httproute, l, httpclientcontext);
        log.debug("Tunnel to proxy created.");
        routetracker.tunnelProxy(httproute.getHopTarget(l), flag1);
          goto _L11
_L8:
        connManager.upgrade(httpclientconnection, httproute, httpclientcontext);
        routetracker.layerProtocol(httproute.isSecure());
          goto _L11
_L2:
        throw new HttpException((new StringBuilder()).append("Unable to establish route: planned = ").append(httproute).append("; current = ").append(obj).toString());
        connManager.routeComplete(httpclientconnection, httproute, httpclientcontext);
          goto _L11
    }

    public CloseableHttpResponse execute(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware)
        throws IOException, HttpException
    {
        AuthState authstate;
        AuthState authstate1;
        Object obj2;
        RequestConfig requestconfig;
        HttpClientConnection httpclientconnection;
        int i;
        Args.notNull(httproute, "HTTP route");
        Args.notNull(httprequestwrapper, "HTTP request");
        Args.notNull(httpclientcontext, "HTTP context");
        authstate1 = httpclientcontext.getTargetAuthState();
        authstate = authstate1;
        if (authstate1 == null)
        {
            authstate = new AuthState();
            httpclientcontext.setAttribute("http.auth.target-scope", authstate);
        }
        Object obj = httpclientcontext.getProxyAuthState();
        authstate1 = ((AuthState) (obj));
        if (obj == null)
        {
            authstate1 = new AuthState();
            httpclientcontext.setAttribute("http.auth.proxy-scope", authstate1);
        }
        if (httprequestwrapper instanceof HttpEntityEnclosingRequest)
        {
            RequestEntityProxy.enhance((HttpEntityEnclosingRequest)httprequestwrapper);
        }
        obj2 = httpclientcontext.getUserToken();
        obj = connManager.requestConnection(httproute, obj2);
        if (httpexecutionaware != null)
        {
            if (httpexecutionaware.isAborted())
            {
                ((ConnectionRequest) (obj)).cancel();
                throw new RequestAbortedException("Request aborted");
            }
            httpexecutionaware.setCancellable(((cz.msebera.android.httpclient.concurrent.Cancellable) (obj)));
        }
        requestconfig = httpclientcontext.getRequestConfig();
        long l;
        try
        {
            i = requestconfig.getConnectionRequestTimeout();
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
        httpclientconnection = ((ConnectionRequest) (obj)).get(l, TimeUnit.MILLISECONDS);
        break MISSING_BLOCK_LABEL_204;
_L17:
        if (i <= 1)
        {
            break MISSING_BLOCK_LABEL_399;
        }
        if (!RequestEntityProxy.isRepeatable(httprequestwrapper))
        {
            throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
        }
        if (httpexecutionaware == null)
        {
            break MISSING_BLOCK_LABEL_433;
        }
        if (httpexecutionaware.isAborted())
        {
            throw new RequestAbortedException("Request aborted");
        }
        if (httpclientconnection.isOpen())
        {
            break MISSING_BLOCK_LABEL_481;
        }
        log.debug((new StringBuilder()).append("Opening connection ").append(httproute).toString());
        establishRoute(authstate1, httpclientconnection, httproute, httprequestwrapper, httpclientcontext);
        j = requestconfig.getSocketTimeout();
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_502;
        }
        httpclientconnection.setSocketTimeout(j);
        if (httpexecutionaware == null) goto _L2; else goto _L1
_L1:
        if (httpexecutionaware.isAborted())
        {
            throw new RequestAbortedException("Request aborted");
        }
          goto _L2
        httproute;
        Object obj1;
        if (log.isDebugEnabled())
        {
            log.debug(httproute.getMessage());
        }
        obj1 = httproute.getResponse();
_L11:
        httproute = ((HttpRoute) (obj2));
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_591;
        }
        httproute = ((HttpRoute) (userTokenHandler.getUserToken(httpclientcontext)));
        httpclientcontext.setAttribute("http.user-token", httproute);
        if (httproute == null)
        {
            break MISSING_BLOCK_LABEL_601;
        }
        connectionholder.setState(httproute);
        httproute = ((HttpResponse) (obj1)).getEntity();
        if (httproute == null) goto _L4; else goto _L3
_L3:
        if (httproute.isStreaming()) goto _L5; else goto _L4
_L4:
        connectionholder.releaseConnection();
        return new HttpResponseProxy(((HttpResponse) (obj1)), null);
_L2:
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Executing request ").append(httprequestwrapper.getRequestLine()).toString());
        }
        if (!httprequestwrapper.containsHeader("Authorization"))
        {
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Target auth state: ").append(authstate.getState()).toString());
            }
            authenticator.generateAuthResponse(httprequestwrapper, authstate, httpclientcontext);
        }
        if (!httprequestwrapper.containsHeader("Proxy-Authorization") && !httproute.isTunnelled())
        {
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Proxy auth state: ").append(authstate1.getState()).toString());
            }
            authenticator.generateAuthResponse(httprequestwrapper, authstate1, httpclientcontext);
        }
        httpresponse = requestExecutor.execute(httprequestwrapper, httpclientconnection, httpclientcontext);
        if (!reuseStrategy.keepAlive(httpresponse, httpclientcontext)) goto _L7; else goto _L6
_L6:
        l1 = keepAliveStrategy.getKeepAliveDuration(httpresponse, httpclientcontext);
        if (!log.isDebugEnabled()) goto _L9; else goto _L8
_L8:
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_1182;
        }
        obj1 = (new StringBuilder()).append("for ").append(l1).append(" ").append(TimeUnit.MILLISECONDS).toString();
_L18:
        log.debug((new StringBuilder()).append("Connection can be kept alive ").append(((String) (obj1))).toString());
_L9:
        connectionholder.setValidFor(l1, TimeUnit.MILLISECONDS);
        connectionholder.markReusable();
_L15:
        obj1 = httpresponse;
        if (!needAuthentication(authstate, authstate1, httproute, httpresponse, httpclientcontext)) goto _L11; else goto _L10
_L10:
        obj1 = httpresponse.getEntity();
        if (!connectionholder.isReusable()) goto _L13; else goto _L12
_L12:
        EntityUtils.consume(((HttpEntity) (obj1)));
_L16:
        obj1 = httprequestwrapper.getOriginal();
        if (!((HttpRequest) (obj1)).containsHeader("Authorization"))
        {
            httprequestwrapper.removeHeaders("Authorization");
        }
        if (!((HttpRequest) (obj1)).containsHeader("Proxy-Authorization"))
        {
            httprequestwrapper.removeHeaders("Proxy-Authorization");
        }
          goto _L14
_L7:
        connectionholder.markNonReusable();
          goto _L15
_L13:
        httpclientconnection.close();
        if (authstate1.getState() == AuthProtocolState.SUCCESS && authstate1.getAuthScheme() != null && authstate1.getAuthScheme().isConnectionBased())
        {
            log.debug("Resetting proxy auth state");
            authstate1.reset();
        }
        if (authstate.getState() == AuthProtocolState.SUCCESS && authstate.getAuthScheme() != null && authstate.getAuthScheme().isConnectionBased())
        {
            log.debug("Resetting target auth state");
            authstate.reset();
        }
          goto _L16
_L5:
        httproute = new HttpResponseProxy(((HttpResponse) (obj1)), connectionholder);
        return httproute;
        httpclientcontext.setAttribute("http.connection", httpclientconnection);
        if (requestconfig.isStaleConnectionCheckEnabled() && httpclientconnection.isOpen())
        {
            log.debug("Stale connection check");
            if (httpclientconnection.isStale())
            {
                log.debug("Stale connection detected");
                httpclientconnection.close();
            }
        }
        ConnectionHolder connectionholder = new ConnectionHolder(log, connManager, httpclientconnection);
        HttpResponse httpresponse;
        int j;
        long l1;
        if (httpexecutionaware != null)
        {
            try
            {
                httpexecutionaware.setCancellable(connectionholder);
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
        }
        i = 1;
          goto _L17
_L14:
        i++;
          goto _L17
        obj1 = "indefinitely";
          goto _L18
    }
}
