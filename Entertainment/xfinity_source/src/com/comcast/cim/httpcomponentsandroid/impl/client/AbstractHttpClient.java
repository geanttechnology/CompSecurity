// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.ConnectionReuseStrategy;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestInterceptor;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.HttpResponseInterceptor;
import com.comcast.cim.httpcomponentsandroid.auth.AuthSchemeRegistry;
import com.comcast.cim.httpcomponentsandroid.client.AuthenticationHandler;
import com.comcast.cim.httpcomponentsandroid.client.ClientProtocolException;
import com.comcast.cim.httpcomponentsandroid.client.CookieStore;
import com.comcast.cim.httpcomponentsandroid.client.CredentialsProvider;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.client.HttpRequestRetryHandler;
import com.comcast.cim.httpcomponentsandroid.client.RedirectHandler;
import com.comcast.cim.httpcomponentsandroid.client.RedirectStrategy;
import com.comcast.cim.httpcomponentsandroid.client.RequestDirector;
import com.comcast.cim.httpcomponentsandroid.client.UserTokenHandler;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import com.comcast.cim.httpcomponentsandroid.client.utils.URIUtils;
import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionManager;
import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionManagerFactory;
import com.comcast.cim.httpcomponentsandroid.conn.ConnectionKeepAliveStrategy;
import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoutePlanner;
import com.comcast.cim.httpcomponentsandroid.cookie.CookieSpecRegistry;
import com.comcast.cim.httpcomponentsandroid.impl.DefaultConnectionReuseStrategy;
import com.comcast.cim.httpcomponentsandroid.impl.auth.BasicSchemeFactory;
import com.comcast.cim.httpcomponentsandroid.impl.auth.DigestSchemeFactory;
import com.comcast.cim.httpcomponentsandroid.impl.auth.NTLMSchemeFactory;
import com.comcast.cim.httpcomponentsandroid.impl.auth.NegotiateSchemeFactory;
import com.comcast.cim.httpcomponentsandroid.impl.conn.DefaultHttpRoutePlanner;
import com.comcast.cim.httpcomponentsandroid.impl.conn.SchemeRegistryFactory;
import com.comcast.cim.httpcomponentsandroid.impl.conn.SingleClientConnManager;
import com.comcast.cim.httpcomponentsandroid.impl.cookie.BestMatchSpecFactory;
import com.comcast.cim.httpcomponentsandroid.impl.cookie.BrowserCompatSpecFactory;
import com.comcast.cim.httpcomponentsandroid.impl.cookie.IgnoreSpecFactory;
import com.comcast.cim.httpcomponentsandroid.impl.cookie.NetscapeDraftSpecFactory;
import com.comcast.cim.httpcomponentsandroid.impl.cookie.RFC2109SpecFactory;
import com.comcast.cim.httpcomponentsandroid.impl.cookie.RFC2965SpecFactory;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.protocol.BasicHttpContext;
import com.comcast.cim.httpcomponentsandroid.protocol.BasicHttpProcessor;
import com.comcast.cim.httpcomponentsandroid.protocol.DefaultedHttpContext;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpProcessor;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpRequestExecutor;
import com.comcast.cim.httpcomponentsandroid.protocol.ImmutableHttpProcessor;
import java.io.IOException;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.client:
//            DefaultRequestDirector, DefaultConnectionKeepAliveStrategy, BasicCookieStore, BasicCredentialsProvider, 
//            DefaultHttpRequestRetryHandler, DefaultProxyAuthenticationHandler, DefaultRedirectHandler, DefaultTargetAuthenticationHandler, 
//            DefaultUserTokenHandler, ClientParamsStack, DefaultRedirectStrategy, DefaultRedirectStrategyAdaptor

public abstract class AbstractHttpClient
    implements HttpClient
{

    private ClientConnectionManager connManager;
    private CookieStore cookieStore;
    private CredentialsProvider credsProvider;
    private HttpParams defaultParams;
    private ConnectionKeepAliveStrategy keepAliveStrategy;
    private final Log log = LogFactory.getLog(getClass());
    private BasicHttpProcessor mutableProcessor;
    private ImmutableHttpProcessor protocolProcessor;
    private AuthenticationHandler proxyAuthHandler;
    private RedirectStrategy redirectStrategy;
    private HttpRequestExecutor requestExec;
    private HttpRequestRetryHandler retryHandler;
    private ConnectionReuseStrategy reuseStrategy;
    private HttpRoutePlanner routePlanner;
    private AuthSchemeRegistry supportedAuthSchemes;
    private CookieSpecRegistry supportedCookieSpecs;
    private AuthenticationHandler targetAuthHandler;
    private UserTokenHandler userTokenHandler;

    protected AbstractHttpClient(ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
    {
        defaultParams = httpparams;
        connManager = clientconnectionmanager;
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

    private final HttpProcessor getProtocolProcessor()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        HttpRequestInterceptor ahttprequestinterceptor[];
        int j;
        if (protocolProcessor != null)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj = getHttpProcessor();
        j = ((BasicHttpProcessor) (obj)).getRequestInterceptorCount();
        ahttprequestinterceptor = new HttpRequestInterceptor[j];
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ahttprequestinterceptor[i] = ((BasicHttpProcessor) (obj)).getRequestInterceptor(i);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        HttpResponseInterceptor ahttpresponseinterceptor[];
        j = ((BasicHttpProcessor) (obj)).getResponseInterceptorCount();
        ahttpresponseinterceptor = new HttpResponseInterceptor[j];
        i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ahttpresponseinterceptor[i] = ((BasicHttpProcessor) (obj)).getResponseInterceptor(i);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        protocolProcessor = new ImmutableHttpProcessor(ahttprequestinterceptor, ahttpresponseinterceptor);
        obj = protocolProcessor;
        this;
        JVM INSTR monitorexit ;
        return ((HttpProcessor) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    public void addRequestInterceptor(HttpRequestInterceptor httprequestinterceptor)
    {
        this;
        JVM INSTR monitorenter ;
        getHttpProcessor().addInterceptor(httprequestinterceptor);
        protocolProcessor = null;
        this;
        JVM INSTR monitorexit ;
        return;
        httprequestinterceptor;
        throw httprequestinterceptor;
    }

    protected AuthSchemeRegistry createAuthSchemeRegistry()
    {
        AuthSchemeRegistry authschemeregistry = new AuthSchemeRegistry();
        authschemeregistry.register("Basic", new BasicSchemeFactory());
        authschemeregistry.register("Digest", new DigestSchemeFactory());
        authschemeregistry.register("NTLM", new NTLMSchemeFactory());
        authschemeregistry.register("negotiate", new NegotiateSchemeFactory());
        return authschemeregistry;
    }

    protected ClientConnectionManager createClientConnectionManager()
    {
        com.comcast.cim.httpcomponentsandroid.conn.scheme.SchemeRegistry schemeregistry = SchemeRegistryFactory.createDefault();
        HttpParams httpparams = getParams();
        ClientConnectionManagerFactory clientconnectionmanagerfactory = null;
        String s = (String)httpparams.getParameter("http.connection-manager.factory-class-name");
        if (s != null)
        {
            try
            {
                clientconnectionmanagerfactory = (ClientConnectionManagerFactory)Class.forName(s).newInstance();
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                throw new IllegalStateException((new StringBuilder()).append("Invalid class name: ").append(s).toString());
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                throw new IllegalAccessError(illegalaccessexception.getMessage());
            }
            catch (InstantiationException instantiationexception)
            {
                throw new InstantiationError(instantiationexception.getMessage());
            }
        }
        if (clientconnectionmanagerfactory != null)
        {
            return clientconnectionmanagerfactory.newInstance(httpparams, schemeregistry);
        } else
        {
            return new SingleClientConnManager(schemeregistry);
        }
    }

    protected RequestDirector createClientRequestDirector(HttpRequestExecutor httprequestexecutor, ClientConnectionManager clientconnectionmanager, ConnectionReuseStrategy connectionreusestrategy, ConnectionKeepAliveStrategy connectionkeepalivestrategy, HttpRoutePlanner httprouteplanner, HttpProcessor httpprocessor, HttpRequestRetryHandler httprequestretryhandler, 
            RedirectStrategy redirectstrategy, AuthenticationHandler authenticationhandler, AuthenticationHandler authenticationhandler1, UserTokenHandler usertokenhandler, HttpParams httpparams)
    {
        return new DefaultRequestDirector(log, httprequestexecutor, clientconnectionmanager, connectionreusestrategy, connectionkeepalivestrategy, httprouteplanner, httpprocessor, httprequestretryhandler, redirectstrategy, authenticationhandler, authenticationhandler1, usertokenhandler, httpparams);
    }

    protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy()
    {
        return new DefaultConnectionKeepAliveStrategy();
    }

    protected ConnectionReuseStrategy createConnectionReuseStrategy()
    {
        return new DefaultConnectionReuseStrategy();
    }

    protected CookieSpecRegistry createCookieSpecRegistry()
    {
        CookieSpecRegistry cookiespecregistry = new CookieSpecRegistry();
        cookiespecregistry.register("best-match", new BestMatchSpecFactory());
        cookiespecregistry.register("compatibility", new BrowserCompatSpecFactory());
        cookiespecregistry.register("netscape", new NetscapeDraftSpecFactory());
        cookiespecregistry.register("rfc2109", new RFC2109SpecFactory());
        cookiespecregistry.register("rfc2965", new RFC2965SpecFactory());
        cookiespecregistry.register("ignoreCookies", new IgnoreSpecFactory());
        return cookiespecregistry;
    }

    protected CookieStore createCookieStore()
    {
        return new BasicCookieStore();
    }

    protected CredentialsProvider createCredentialsProvider()
    {
        return new BasicCredentialsProvider();
    }

    protected HttpContext createHttpContext()
    {
        BasicHttpContext basichttpcontext = new BasicHttpContext();
        basichttpcontext.setAttribute("http.scheme-registry", getConnectionManager().getSchemeRegistry());
        basichttpcontext.setAttribute("http.authscheme-registry", getAuthSchemes());
        basichttpcontext.setAttribute("http.cookiespec-registry", getCookieSpecs());
        basichttpcontext.setAttribute("http.cookie-store", getCookieStore());
        basichttpcontext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
        return basichttpcontext;
    }

    protected abstract HttpParams createHttpParams();

    protected abstract BasicHttpProcessor createHttpProcessor();

    protected HttpRequestRetryHandler createHttpRequestRetryHandler()
    {
        return new DefaultHttpRequestRetryHandler();
    }

    protected HttpRoutePlanner createHttpRoutePlanner()
    {
        return new DefaultHttpRoutePlanner(getConnectionManager().getSchemeRegistry());
    }

    protected AuthenticationHandler createProxyAuthenticationHandler()
    {
        return new DefaultProxyAuthenticationHandler();
    }

    protected RedirectHandler createRedirectHandler()
    {
        return new DefaultRedirectHandler();
    }

    protected HttpRequestExecutor createRequestExecutor()
    {
        return new HttpRequestExecutor();
    }

    protected AuthenticationHandler createTargetAuthenticationHandler()
    {
        return new DefaultTargetAuthenticationHandler();
    }

    protected UserTokenHandler createUserTokenHandler()
    {
        return new DefaultUserTokenHandler();
    }

    protected HttpParams determineParams(HttpRequest httprequest)
    {
        return new ClientParamsStack(null, getParams(), httprequest.getParams(), null);
    }

    public final HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        if (httprequest == null)
        {
            throw new IllegalArgumentException("Request must not be null.");
        }
        this;
        JVM INSTR monitorenter ;
        Object obj = createHttpContext();
        if (httpcontext != null) goto _L2; else goto _L1
_L1:
        httpcontext = ((HttpContext) (obj));
_L4:
        obj = createClientRequestDirector(getRequestExecutor(), getConnectionManager(), getConnectionReuseStrategy(), getConnectionKeepAliveStrategy(), getRoutePlanner(), getProtocolProcessor(), getHttpRequestRetryHandler(), getRedirectStrategy(), getTargetAuthenticationHandler(), getProxyAuthenticationHandler(), getUserTokenHandler(), determineParams(httprequest));
        this;
        JVM INSTR monitorexit ;
        try
        {
            httphost = ((RequestDirector) (obj)).execute(httphost, httprequest, httpcontext);
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            throw new ClientProtocolException(httphost);
        }
        return httphost;
_L2:
        httpcontext = new DefaultedHttpContext(httpcontext, ((HttpContext) (obj)));
        if (true) goto _L4; else goto _L3
_L3:
        httphost;
        this;
        JVM INSTR monitorexit ;
        throw httphost;
    }

    public final HttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException, ClientProtocolException
    {
        return execute(httpurirequest, (HttpContext)null);
    }

    public final HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        if (httpurirequest == null)
        {
            throw new IllegalArgumentException("Request must not be null.");
        } else
        {
            return execute(determineTarget(httpurirequest), ((HttpRequest) (httpurirequest)), httpcontext);
        }
    }

    public final AuthSchemeRegistry getAuthSchemes()
    {
        this;
        JVM INSTR monitorenter ;
        AuthSchemeRegistry authschemeregistry;
        if (supportedAuthSchemes == null)
        {
            supportedAuthSchemes = createAuthSchemeRegistry();
        }
        authschemeregistry = supportedAuthSchemes;
        this;
        JVM INSTR monitorexit ;
        return authschemeregistry;
        Exception exception;
        exception;
        throw exception;
    }

    public final ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy()
    {
        this;
        JVM INSTR monitorenter ;
        ConnectionKeepAliveStrategy connectionkeepalivestrategy;
        if (keepAliveStrategy == null)
        {
            keepAliveStrategy = createConnectionKeepAliveStrategy();
        }
        connectionkeepalivestrategy = keepAliveStrategy;
        this;
        JVM INSTR monitorexit ;
        return connectionkeepalivestrategy;
        Exception exception;
        exception;
        throw exception;
    }

    public final ClientConnectionManager getConnectionManager()
    {
        this;
        JVM INSTR monitorenter ;
        ClientConnectionManager clientconnectionmanager;
        if (connManager == null)
        {
            connManager = createClientConnectionManager();
        }
        clientconnectionmanager = connManager;
        this;
        JVM INSTR monitorexit ;
        return clientconnectionmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public final ConnectionReuseStrategy getConnectionReuseStrategy()
    {
        this;
        JVM INSTR monitorenter ;
        ConnectionReuseStrategy connectionreusestrategy;
        if (reuseStrategy == null)
        {
            reuseStrategy = createConnectionReuseStrategy();
        }
        connectionreusestrategy = reuseStrategy;
        this;
        JVM INSTR monitorexit ;
        return connectionreusestrategy;
        Exception exception;
        exception;
        throw exception;
    }

    public final CookieSpecRegistry getCookieSpecs()
    {
        this;
        JVM INSTR monitorenter ;
        CookieSpecRegistry cookiespecregistry;
        if (supportedCookieSpecs == null)
        {
            supportedCookieSpecs = createCookieSpecRegistry();
        }
        cookiespecregistry = supportedCookieSpecs;
        this;
        JVM INSTR monitorexit ;
        return cookiespecregistry;
        Exception exception;
        exception;
        throw exception;
    }

    public final CookieStore getCookieStore()
    {
        this;
        JVM INSTR monitorenter ;
        CookieStore cookiestore;
        if (cookieStore == null)
        {
            cookieStore = createCookieStore();
        }
        cookiestore = cookieStore;
        this;
        JVM INSTR monitorexit ;
        return cookiestore;
        Exception exception;
        exception;
        throw exception;
    }

    public final CredentialsProvider getCredentialsProvider()
    {
        this;
        JVM INSTR monitorenter ;
        CredentialsProvider credentialsprovider;
        if (credsProvider == null)
        {
            credsProvider = createCredentialsProvider();
        }
        credentialsprovider = credsProvider;
        this;
        JVM INSTR monitorexit ;
        return credentialsprovider;
        Exception exception;
        exception;
        throw exception;
    }

    protected final BasicHttpProcessor getHttpProcessor()
    {
        this;
        JVM INSTR monitorenter ;
        BasicHttpProcessor basichttpprocessor;
        if (mutableProcessor == null)
        {
            mutableProcessor = createHttpProcessor();
        }
        basichttpprocessor = mutableProcessor;
        this;
        JVM INSTR monitorexit ;
        return basichttpprocessor;
        Exception exception;
        exception;
        throw exception;
    }

    public final HttpRequestRetryHandler getHttpRequestRetryHandler()
    {
        this;
        JVM INSTR monitorenter ;
        HttpRequestRetryHandler httprequestretryhandler;
        if (retryHandler == null)
        {
            retryHandler = createHttpRequestRetryHandler();
        }
        httprequestretryhandler = retryHandler;
        this;
        JVM INSTR monitorexit ;
        return httprequestretryhandler;
        Exception exception;
        exception;
        throw exception;
    }

    public final HttpParams getParams()
    {
        this;
        JVM INSTR monitorenter ;
        HttpParams httpparams;
        if (defaultParams == null)
        {
            defaultParams = createHttpParams();
        }
        httpparams = defaultParams;
        this;
        JVM INSTR monitorexit ;
        return httpparams;
        Exception exception;
        exception;
        throw exception;
    }

    public final AuthenticationHandler getProxyAuthenticationHandler()
    {
        this;
        JVM INSTR monitorenter ;
        AuthenticationHandler authenticationhandler;
        if (proxyAuthHandler == null)
        {
            proxyAuthHandler = createProxyAuthenticationHandler();
        }
        authenticationhandler = proxyAuthHandler;
        this;
        JVM INSTR monitorexit ;
        return authenticationhandler;
        Exception exception;
        exception;
        throw exception;
    }

    public final RedirectHandler getRedirectHandler()
    {
        this;
        JVM INSTR monitorenter ;
        RedirectHandler redirecthandler = createRedirectHandler();
        this;
        JVM INSTR monitorexit ;
        return redirecthandler;
        Exception exception;
        exception;
        throw exception;
    }

    public final RedirectStrategy getRedirectStrategy()
    {
        this;
        JVM INSTR monitorenter ;
        RedirectStrategy redirectstrategy;
        if (redirectStrategy == null)
        {
            redirectStrategy = new DefaultRedirectStrategy();
        }
        redirectstrategy = redirectStrategy;
        this;
        JVM INSTR monitorexit ;
        return redirectstrategy;
        Exception exception;
        exception;
        throw exception;
    }

    public final HttpRequestExecutor getRequestExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        HttpRequestExecutor httprequestexecutor;
        if (requestExec == null)
        {
            requestExec = createRequestExecutor();
        }
        httprequestexecutor = requestExec;
        this;
        JVM INSTR monitorexit ;
        return httprequestexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public int getRequestInterceptorCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = getHttpProcessor().getRequestInterceptorCount();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getResponseInterceptorCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = getHttpProcessor().getResponseInterceptorCount();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final HttpRoutePlanner getRoutePlanner()
    {
        this;
        JVM INSTR monitorenter ;
        HttpRoutePlanner httprouteplanner;
        if (routePlanner == null)
        {
            routePlanner = createHttpRoutePlanner();
        }
        httprouteplanner = routePlanner;
        this;
        JVM INSTR monitorexit ;
        return httprouteplanner;
        Exception exception;
        exception;
        throw exception;
    }

    public final AuthenticationHandler getTargetAuthenticationHandler()
    {
        this;
        JVM INSTR monitorenter ;
        AuthenticationHandler authenticationhandler;
        if (targetAuthHandler == null)
        {
            targetAuthHandler = createTargetAuthenticationHandler();
        }
        authenticationhandler = targetAuthHandler;
        this;
        JVM INSTR monitorexit ;
        return authenticationhandler;
        Exception exception;
        exception;
        throw exception;
    }

    public final UserTokenHandler getUserTokenHandler()
    {
        this;
        JVM INSTR monitorenter ;
        UserTokenHandler usertokenhandler;
        if (userTokenHandler == null)
        {
            userTokenHandler = createUserTokenHandler();
        }
        usertokenhandler = userTokenHandler;
        this;
        JVM INSTR monitorexit ;
        return usertokenhandler;
        Exception exception;
        exception;
        throw exception;
    }

    public void setAuthSchemes(AuthSchemeRegistry authschemeregistry)
    {
        this;
        JVM INSTR monitorenter ;
        supportedAuthSchemes = authschemeregistry;
        this;
        JVM INSTR monitorexit ;
        return;
        authschemeregistry;
        throw authschemeregistry;
    }

    public void setCookieSpecs(CookieSpecRegistry cookiespecregistry)
    {
        this;
        JVM INSTR monitorenter ;
        supportedCookieSpecs = cookiespecregistry;
        this;
        JVM INSTR monitorexit ;
        return;
        cookiespecregistry;
        throw cookiespecregistry;
    }

    public void setCookieStore(CookieStore cookiestore)
    {
        this;
        JVM INSTR monitorenter ;
        cookieStore = cookiestore;
        this;
        JVM INSTR monitorexit ;
        return;
        cookiestore;
        throw cookiestore;
    }

    public void setCredentialsProvider(CredentialsProvider credentialsprovider)
    {
        this;
        JVM INSTR monitorenter ;
        credsProvider = credentialsprovider;
        this;
        JVM INSTR monitorexit ;
        return;
        credentialsprovider;
        throw credentialsprovider;
    }

    public void setHttpRequestRetryHandler(HttpRequestRetryHandler httprequestretryhandler)
    {
        this;
        JVM INSTR monitorenter ;
        retryHandler = httprequestretryhandler;
        this;
        JVM INSTR monitorexit ;
        return;
        httprequestretryhandler;
        throw httprequestretryhandler;
    }

    public void setKeepAliveStrategy(ConnectionKeepAliveStrategy connectionkeepalivestrategy)
    {
        this;
        JVM INSTR monitorenter ;
        keepAliveStrategy = connectionkeepalivestrategy;
        this;
        JVM INSTR monitorexit ;
        return;
        connectionkeepalivestrategy;
        throw connectionkeepalivestrategy;
    }

    public void setParams(HttpParams httpparams)
    {
        this;
        JVM INSTR monitorenter ;
        defaultParams = httpparams;
        this;
        JVM INSTR monitorexit ;
        return;
        httpparams;
        throw httpparams;
    }

    public void setProxyAuthenticationHandler(AuthenticationHandler authenticationhandler)
    {
        this;
        JVM INSTR monitorenter ;
        proxyAuthHandler = authenticationhandler;
        this;
        JVM INSTR monitorexit ;
        return;
        authenticationhandler;
        throw authenticationhandler;
    }

    public void setRedirectHandler(RedirectHandler redirecthandler)
    {
        this;
        JVM INSTR monitorenter ;
        redirectStrategy = new DefaultRedirectStrategyAdaptor(redirecthandler);
        this;
        JVM INSTR monitorexit ;
        return;
        redirecthandler;
        throw redirecthandler;
    }

    public void setRedirectStrategy(RedirectStrategy redirectstrategy)
    {
        this;
        JVM INSTR monitorenter ;
        redirectStrategy = redirectstrategy;
        this;
        JVM INSTR monitorexit ;
        return;
        redirectstrategy;
        throw redirectstrategy;
    }

    public void setReuseStrategy(ConnectionReuseStrategy connectionreusestrategy)
    {
        this;
        JVM INSTR monitorenter ;
        reuseStrategy = connectionreusestrategy;
        this;
        JVM INSTR monitorexit ;
        return;
        connectionreusestrategy;
        throw connectionreusestrategy;
    }

    public void setRoutePlanner(HttpRoutePlanner httprouteplanner)
    {
        this;
        JVM INSTR monitorenter ;
        routePlanner = httprouteplanner;
        this;
        JVM INSTR monitorexit ;
        return;
        httprouteplanner;
        throw httprouteplanner;
    }

    public void setTargetAuthenticationHandler(AuthenticationHandler authenticationhandler)
    {
        this;
        JVM INSTR monitorenter ;
        targetAuthHandler = authenticationhandler;
        this;
        JVM INSTR monitorexit ;
        return;
        authenticationhandler;
        throw authenticationhandler;
    }

    public void setUserTokenHandler(UserTokenHandler usertokenhandler)
    {
        this;
        JVM INSTR monitorenter ;
        userTokenHandler = usertokenhandler;
        this;
        JVM INSTR monitorexit ;
        return;
        usertokenhandler;
        throw usertokenhandler;
    }
}
