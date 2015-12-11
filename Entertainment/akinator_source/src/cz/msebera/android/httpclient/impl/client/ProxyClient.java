// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.auth.AuthSchemeRegistry;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.params.HttpClientParamConfig;
import cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.conn.HttpConnectionFactory;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.entity.BufferedHttpEntity;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.auth.BasicSchemeFactory;
import cz.msebera.android.httpclient.impl.auth.DigestSchemeFactory;
import cz.msebera.android.httpclient.impl.auth.HttpAuthenticator;
import cz.msebera.android.httpclient.impl.auth.NTLMSchemeFactory;
import cz.msebera.android.httpclient.impl.conn.ManagedHttpClientConnectionFactory;
import cz.msebera.android.httpclient.impl.execchain.TunnelRefusedException;
import cz.msebera.android.httpclient.message.BasicHttpRequest;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParamConfig;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.protocol.RequestUserAgent;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.net.Socket;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            ProxyAuthenticationStrategy, BasicCredentialsProvider

public class ProxyClient
{

    private final AuthSchemeRegistry authSchemeRegistry;
    private final HttpAuthenticator authenticator;
    private final HttpConnectionFactory connFactory;
    private final ConnectionConfig connectionConfig;
    private final HttpProcessor httpProcessor;
    private final AuthState proxyAuthState;
    private final ProxyAuthenticationStrategy proxyAuthStrategy;
    private final RequestConfig requestConfig;
    private final HttpRequestExecutor requestExec;
    private final ConnectionReuseStrategy reuseStrategy;

    public ProxyClient()
    {
        this(null, null, null);
    }

    public ProxyClient(RequestConfig requestconfig)
    {
        this(null, null, requestconfig);
    }

    public ProxyClient(HttpConnectionFactory httpconnectionfactory, ConnectionConfig connectionconfig, RequestConfig requestconfig)
    {
        if (httpconnectionfactory == null)
        {
            httpconnectionfactory = ManagedHttpClientConnectionFactory.INSTANCE;
        }
        connFactory = httpconnectionfactory;
        if (connectionconfig == null)
        {
            connectionconfig = ConnectionConfig.DEFAULT;
        }
        connectionConfig = connectionconfig;
        if (requestconfig == null)
        {
            requestconfig = RequestConfig.DEFAULT;
        }
        requestConfig = requestconfig;
        httpProcessor = new ImmutableHttpProcessor(new HttpRequestInterceptor[] {
            new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent()
        });
        requestExec = new HttpRequestExecutor();
        proxyAuthStrategy = new ProxyAuthenticationStrategy();
        authenticator = new HttpAuthenticator();
        proxyAuthState = new AuthState();
        authSchemeRegistry = new AuthSchemeRegistry();
        authSchemeRegistry.register("Basic", new BasicSchemeFactory());
        authSchemeRegistry.register("Digest", new DigestSchemeFactory());
        authSchemeRegistry.register("NTLM", new NTLMSchemeFactory());
        reuseStrategy = new DefaultConnectionReuseStrategy();
    }

    public ProxyClient(HttpParams httpparams)
    {
        this(null, HttpParamConfig.getConnectionConfig(httpparams), HttpClientParamConfig.getRequestConfig(httpparams));
    }

    public AuthSchemeRegistry getAuthSchemeRegistry()
    {
        return authSchemeRegistry;
    }

    public HttpParams getParams()
    {
        return new BasicHttpParams();
    }

    public Socket tunnel(HttpHost httphost, HttpHost httphost1, Credentials credentials)
        throws IOException, HttpException
    {
        Args.notNull(httphost, "Proxy host");
        Args.notNull(httphost1, "Target host");
        Args.notNull(credentials, "Credentials");
        Object obj1 = httphost1;
        Object obj = obj1;
        if (((HttpHost) (obj1)).getPort() <= 0)
        {
            obj = new HttpHost(((HttpHost) (obj1)).getHostName(), 80, ((HttpHost) (obj1)).getSchemeName());
        }
        HttpRoute httproute = new HttpRoute(((HttpHost) (obj)), requestConfig.getLocalAddress(), httphost, false, cz.msebera.android.httpclient.conn.routing.RouteInfo.TunnelType.TUNNELLED, cz.msebera.android.httpclient.conn.routing.RouteInfo.LayerType.PLAIN);
        obj1 = (ManagedHttpClientConnection)connFactory.create(httproute, connectionConfig);
        BasicHttpContext basichttpcontext = new BasicHttpContext();
        obj = new BasicHttpRequest("CONNECT", ((HttpHost) (obj)).toHostString(), HttpVersion.HTTP_1_1);
        BasicCredentialsProvider basiccredentialsprovider = new BasicCredentialsProvider();
        basiccredentialsprovider.setCredentials(new AuthScope(httphost), credentials);
        basichttpcontext.setAttribute("http.target_host", httphost1);
        basichttpcontext.setAttribute("http.connection", obj1);
        basichttpcontext.setAttribute("http.request", obj);
        basichttpcontext.setAttribute("http.route", httproute);
        basichttpcontext.setAttribute("http.auth.proxy-scope", proxyAuthState);
        basichttpcontext.setAttribute("http.auth.credentials-provider", basiccredentialsprovider);
        basichttpcontext.setAttribute("http.authscheme-registry", authSchemeRegistry);
        basichttpcontext.setAttribute("http.request-config", requestConfig);
        requestExec.preProcess(((HttpRequest) (obj)), httpProcessor, basichttpcontext);
        do
        {
            if (!((ManagedHttpClientConnection) (obj1)).isOpen())
            {
                ((ManagedHttpClientConnection) (obj1)).bind(new Socket(httphost.getHostName(), httphost.getPort()));
            }
            authenticator.generateAuthResponse(((HttpRequest) (obj)), proxyAuthState, basichttpcontext);
            httphost1 = requestExec.execute(((HttpRequest) (obj)), ((cz.msebera.android.httpclient.HttpClientConnection) (obj1)), basichttpcontext);
            if (httphost1.getStatusLine().getStatusCode() < 200)
            {
                throw new HttpException((new StringBuilder()).append("Unexpected response to CONNECT request: ").append(httphost1.getStatusLine()).toString());
            }
            if (!authenticator.isAuthenticationRequested(httphost, httphost1, proxyAuthStrategy, proxyAuthState, basichttpcontext) || !authenticator.handleAuthChallenge(httphost, httphost1, proxyAuthStrategy, proxyAuthState, basichttpcontext))
            {
                break;
            }
            if (reuseStrategy.keepAlive(httphost1, basichttpcontext))
            {
                EntityUtils.consume(httphost1.getEntity());
            } else
            {
                ((ManagedHttpClientConnection) (obj1)).close();
            }
            ((HttpRequest) (obj)).removeHeaders("Proxy-Authorization");
        } while (true);
        if (httphost1.getStatusLine().getStatusCode() > 299)
        {
            httphost = httphost1.getEntity();
            if (httphost != null)
            {
                httphost1.setEntity(new BufferedHttpEntity(httphost));
            }
            ((ManagedHttpClientConnection) (obj1)).close();
            throw new TunnelRefusedException((new StringBuilder()).append("CONNECT refused by proxy: ").append(httphost1.getStatusLine()).toString(), httphost1);
        } else
        {
            return ((ManagedHttpClientConnection) (obj1)).getSocket();
        }
    }
}
