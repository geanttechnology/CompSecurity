// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.BackoffManager;
import cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding;
import cz.msebera.android.httpclient.client.protocol.RequestAddCookies;
import cz.msebera.android.httpclient.client.protocol.RequestAuthCache;
import cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import cz.msebera.android.httpclient.client.protocol.RequestDefaultHeaders;
import cz.msebera.android.httpclient.client.protocol.RequestExpectContinue;
import cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding;
import cz.msebera.android.httpclient.client.protocol.ResponseProcessCookies;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.config.RegistryBuilder;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.socket.PlainConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.ssl.SSLConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.ssl.SSLContexts;
import cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.NoConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.auth.BasicSchemeFactory;
import cz.msebera.android.httpclient.impl.auth.DigestSchemeFactory;
import cz.msebera.android.httpclient.impl.auth.NTLMSchemeFactory;
import cz.msebera.android.httpclient.impl.conn.DefaultProxyRoutePlanner;
import cz.msebera.android.httpclient.impl.conn.DefaultRoutePlanner;
import cz.msebera.android.httpclient.impl.conn.DefaultSchemePortResolver;
import cz.msebera.android.httpclient.impl.conn.PoolingHttpClientConnectionManager;
import cz.msebera.android.httpclient.impl.conn.SystemDefaultRoutePlanner;
import cz.msebera.android.httpclient.impl.cookie.BestMatchSpecFactory;
import cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory;
import cz.msebera.android.httpclient.impl.cookie.IgnoreSpecFactory;
import cz.msebera.android.httpclient.impl.cookie.NetscapeDraftSpecFactory;
import cz.msebera.android.httpclient.impl.cookie.RFC2109SpecFactory;
import cz.msebera.android.httpclient.impl.cookie.RFC2965SpecFactory;
import cz.msebera.android.httpclient.impl.execchain.BackoffStrategyExec;
import cz.msebera.android.httpclient.impl.execchain.ClientExecChain;
import cz.msebera.android.httpclient.impl.execchain.MainClientExec;
import cz.msebera.android.httpclient.impl.execchain.ProtocolExec;
import cz.msebera.android.httpclient.impl.execchain.RedirectExec;
import cz.msebera.android.httpclient.impl.execchain.RetryExec;
import cz.msebera.android.httpclient.impl.execchain.ServiceUnavailableRetryExec;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpProcessorBuilder;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.RequestContent;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.protocol.RequestUserAgent;
import cz.msebera.android.httpclient.util.TextUtils;
import cz.msebera.android.httpclient.util.VersionInfo;
import java.io.Closeable;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            DefaultConnectionKeepAliveStrategy, TargetAuthenticationStrategy, ProxyAuthenticationStrategy, DefaultUserTokenHandler, 
//            NoopUserTokenHandler, DefaultHttpRequestRetryHandler, DefaultRedirectStrategy, BasicCookieStore, 
//            SystemDefaultCredentialsProvider, InternalHttpClient, BasicCredentialsProvider, CloseableHttpClient

public class HttpClientBuilder
{

    static final String DEFAULT_USER_AGENT;
    private boolean authCachingDisabled;
    private Lookup authSchemeRegistry;
    private boolean automaticRetriesDisabled;
    private BackoffManager backoffManager;
    private List closeables;
    private HttpClientConnectionManager connManager;
    private ConnectionBackoffStrategy connectionBackoffStrategy;
    private boolean connectionStateDisabled;
    private boolean contentCompressionDisabled;
    private boolean cookieManagementDisabled;
    private Lookup cookieSpecRegistry;
    private CookieStore cookieStore;
    private CredentialsProvider credentialsProvider;
    private ConnectionConfig defaultConnectionConfig;
    private Collection defaultHeaders;
    private RequestConfig defaultRequestConfig;
    private SocketConfig defaultSocketConfig;
    private X509HostnameVerifier hostnameVerifier;
    private HttpProcessor httpprocessor;
    private ConnectionKeepAliveStrategy keepAliveStrategy;
    private int maxConnPerRoute;
    private int maxConnTotal;
    private HttpHost proxy;
    private AuthenticationStrategy proxyAuthStrategy;
    private boolean redirectHandlingDisabled;
    private RedirectStrategy redirectStrategy;
    private HttpRequestExecutor requestExec;
    private LinkedList requestFirst;
    private LinkedList requestLast;
    private LinkedList responseFirst;
    private LinkedList responseLast;
    private HttpRequestRetryHandler retryHandler;
    private ConnectionReuseStrategy reuseStrategy;
    private HttpRoutePlanner routePlanner;
    private SchemePortResolver schemePortResolver;
    private ServiceUnavailableRetryStrategy serviceUnavailStrategy;
    private LayeredConnectionSocketFactory sslSocketFactory;
    private SSLContext sslcontext;
    private boolean systemProperties;
    private AuthenticationStrategy targetAuthStrategy;
    private String userAgent;
    private UserTokenHandler userTokenHandler;

    protected HttpClientBuilder()
    {
        maxConnTotal = 0;
        maxConnPerRoute = 0;
    }

    public static HttpClientBuilder create()
    {
        return new HttpClientBuilder();
    }

    private static String[] split(String s)
    {
        if (TextUtils.isBlank(s))
        {
            return null;
        } else
        {
            return s.split(" *, *");
        }
    }

    protected void addCloseable(Closeable closeable)
    {
        if (closeable == null)
        {
            return;
        }
        if (closeables == null)
        {
            closeables = new ArrayList();
        }
        closeables.add(closeable);
    }

    public final HttpClientBuilder addInterceptorFirst(HttpRequestInterceptor httprequestinterceptor)
    {
        if (httprequestinterceptor == null)
        {
            return this;
        }
        if (requestFirst == null)
        {
            requestFirst = new LinkedList();
        }
        requestFirst.addFirst(httprequestinterceptor);
        return this;
    }

    public final HttpClientBuilder addInterceptorFirst(HttpResponseInterceptor httpresponseinterceptor)
    {
        if (httpresponseinterceptor == null)
        {
            return this;
        }
        if (responseFirst == null)
        {
            responseFirst = new LinkedList();
        }
        responseFirst.addFirst(httpresponseinterceptor);
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpRequestInterceptor httprequestinterceptor)
    {
        if (httprequestinterceptor == null)
        {
            return this;
        }
        if (requestLast == null)
        {
            requestLast = new LinkedList();
        }
        requestLast.addLast(httprequestinterceptor);
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpResponseInterceptor httpresponseinterceptor)
    {
        if (httpresponseinterceptor == null)
        {
            return this;
        }
        if (responseLast == null)
        {
            responseLast = new LinkedList();
        }
        responseLast.addLast(httpresponseinterceptor);
        return this;
    }

    public CloseableHttpClient build()
    {
        Object obj = requestExec;
        Object obj2 = obj;
        if (obj == null)
        {
            obj2 = new HttpRequestExecutor();
        }
        obj = connManager;
        Object obj4 = obj;
        Object obj1;
        if (obj == null)
        {
            obj1 = sslSocketFactory;
            obj = obj1;
            if (obj1 == null)
            {
                Object obj5;
                Object obj7;
                Object obj9;
                UserTokenHandler usertokenhandler;
                int i;
                if (systemProperties)
                {
                    obj = split(System.getProperty("https.protocols"));
                } else
                {
                    obj = null;
                }
                if (systemProperties)
                {
                    obj1 = split(System.getProperty("https.cipherSuites"));
                } else
                {
                    obj1 = null;
                }
                obj5 = hostnameVerifier;
                obj4 = obj5;
                if (obj5 == null)
                {
                    obj4 = SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
                }
                if (sslcontext != null)
                {
                    obj = new SSLConnectionSocketFactory(sslcontext, ((String []) (obj)), ((String []) (obj1)), ((X509HostnameVerifier) (obj4)));
                } else
                if (systemProperties)
                {
                    obj = new SSLConnectionSocketFactory((SSLSocketFactory)SSLSocketFactory.getDefault(), ((String []) (obj)), ((String []) (obj1)), ((X509HostnameVerifier) (obj4)));
                } else
                {
                    obj = new SSLConnectionSocketFactory(SSLContexts.createDefault(), ((X509HostnameVerifier) (obj4)));
                }
            }
            obj4 = new PoolingHttpClientConnectionManager(RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", obj).build());
            if (defaultSocketConfig != null)
            {
                ((PoolingHttpClientConnectionManager) (obj4)).setDefaultSocketConfig(defaultSocketConfig);
            }
            if (defaultConnectionConfig != null)
            {
                ((PoolingHttpClientConnectionManager) (obj4)).setDefaultConnectionConfig(defaultConnectionConfig);
            }
            if (systemProperties && "true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true")))
            {
                i = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
                ((PoolingHttpClientConnectionManager) (obj4)).setDefaultMaxPerRoute(i);
                ((PoolingHttpClientConnectionManager) (obj4)).setMaxTotal(i * 2);
            }
            if (maxConnTotal > 0)
            {
                ((PoolingHttpClientConnectionManager) (obj4)).setMaxTotal(maxConnTotal);
            }
            if (maxConnPerRoute > 0)
            {
                ((PoolingHttpClientConnectionManager) (obj4)).setDefaultMaxPerRoute(maxConnPerRoute);
            }
        }
        obj1 = reuseStrategy;
        obj = obj1;
        if (obj1 == null)
        {
            if (systemProperties)
            {
                if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true")))
                {
                    obj = DefaultConnectionReuseStrategy.INSTANCE;
                } else
                {
                    obj = NoConnectionReuseStrategy.INSTANCE;
                }
            } else
            {
                obj = DefaultConnectionReuseStrategy.INSTANCE;
            }
        }
        obj1 = keepAliveStrategy;
        obj5 = obj1;
        if (obj1 == null)
        {
            obj5 = DefaultConnectionKeepAliveStrategy.INSTANCE;
        }
        obj1 = targetAuthStrategy;
        obj7 = obj1;
        if (obj1 == null)
        {
            obj7 = TargetAuthenticationStrategy.INSTANCE;
        }
        obj1 = proxyAuthStrategy;
        obj9 = obj1;
        if (obj1 == null)
        {
            obj9 = ProxyAuthenticationStrategy.INSTANCE;
        }
        usertokenhandler = userTokenHandler;
        obj1 = usertokenhandler;
        if (usertokenhandler == null)
        {
            if (!connectionStateDisabled)
            {
                obj1 = DefaultUserTokenHandler.INSTANCE;
            } else
            {
                obj1 = NoopUserTokenHandler.INSTANCE;
            }
        }
        obj2 = decorateMainExec(new MainClientExec(((HttpRequestExecutor) (obj2)), ((HttpClientConnectionManager) (obj4)), ((ConnectionReuseStrategy) (obj)), ((ConnectionKeepAliveStrategy) (obj5)), ((AuthenticationStrategy) (obj7)), ((AuthenticationStrategy) (obj9)), ((UserTokenHandler) (obj1))));
        obj1 = httpprocessor;
        obj = obj1;
        if (obj1 == null)
        {
            obj1 = userAgent;
            obj = obj1;
            if (obj1 == null)
            {
                if (systemProperties)
                {
                    obj1 = System.getProperty("http.agent");
                }
                obj = obj1;
                if (obj1 == null)
                {
                    obj = DEFAULT_USER_AGENT;
                }
            }
            obj1 = HttpProcessorBuilder.create();
            if (requestFirst != null)
            {
                for (obj5 = requestFirst.iterator(); ((Iterator) (obj5)).hasNext(); ((HttpProcessorBuilder) (obj1)).addFirst((HttpRequestInterceptor)((Iterator) (obj5)).next())) { }
            }
            if (responseFirst != null)
            {
                for (Iterator iterator = responseFirst.iterator(); iterator.hasNext(); ((HttpProcessorBuilder) (obj1)).addFirst((HttpResponseInterceptor)iterator.next())) { }
            }
            ((HttpProcessorBuilder) (obj1)).addAll(new HttpRequestInterceptor[] {
                new RequestDefaultHeaders(defaultHeaders), new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(((String) (obj))), new RequestExpectContinue()
            });
            if (!cookieManagementDisabled)
            {
                ((HttpProcessorBuilder) (obj1)).add(new RequestAddCookies());
            }
            if (!contentCompressionDisabled)
            {
                ((HttpProcessorBuilder) (obj1)).add(new RequestAcceptEncoding());
            }
            if (!authCachingDisabled)
            {
                ((HttpProcessorBuilder) (obj1)).add(new RequestAuthCache());
            }
            if (!cookieManagementDisabled)
            {
                ((HttpProcessorBuilder) (obj1)).add(new ResponseProcessCookies());
            }
            if (!contentCompressionDisabled)
            {
                ((HttpProcessorBuilder) (obj1)).add(new ResponseContentEncoding());
            }
            if (requestLast != null)
            {
                for (obj = requestLast.iterator(); ((Iterator) (obj)).hasNext(); ((HttpProcessorBuilder) (obj1)).addLast((HttpRequestInterceptor)((Iterator) (obj)).next())) { }
            }
            if (responseLast != null)
            {
                for (obj = responseLast.iterator(); ((Iterator) (obj)).hasNext(); ((HttpProcessorBuilder) (obj1)).addLast((HttpResponseInterceptor)((Iterator) (obj)).next())) { }
            }
            obj = ((HttpProcessorBuilder) (obj1)).build();
        }
        obj2 = decorateProtocolExec(new ProtocolExec(((ClientExecChain) (obj2)), ((HttpProcessor) (obj))));
        obj1 = obj2;
        if (!automaticRetriesDisabled)
        {
            obj1 = retryHandler;
            obj = obj1;
            if (obj1 == null)
            {
                obj = DefaultHttpRequestRetryHandler.INSTANCE;
            }
            obj1 = new RetryExec(((ClientExecChain) (obj2)), ((HttpRequestRetryHandler) (obj)));
        }
        obj2 = routePlanner;
        obj = obj2;
        Object obj11;
        ArrayList arraylist;
        if (obj2 == null)
        {
            Object obj3 = schemePortResolver;
            obj = obj3;
            if (obj3 == null)
            {
                obj = DefaultSchemePortResolver.INSTANCE;
            }
            Object obj6;
            Object obj8;
            Object obj10;
            if (proxy != null)
            {
                obj = new DefaultProxyRoutePlanner(proxy, ((SchemePortResolver) (obj)));
            } else
            if (systemProperties)
            {
                obj = new SystemDefaultRoutePlanner(((SchemePortResolver) (obj)), ProxySelector.getDefault());
            } else
            {
                obj = new DefaultRoutePlanner(((SchemePortResolver) (obj)));
            }
        }
        obj3 = obj1;
        if (!redirectHandlingDisabled)
        {
            obj6 = redirectStrategy;
            obj3 = obj6;
            if (obj6 == null)
            {
                obj3 = DefaultRedirectStrategy.INSTANCE;
            }
            obj3 = new RedirectExec(((ClientExecChain) (obj1)), ((HttpRoutePlanner) (obj)), ((RedirectStrategy) (obj3)));
        }
        obj6 = serviceUnavailStrategy;
        obj1 = obj3;
        if (obj6 != null)
        {
            obj1 = new ServiceUnavailableRetryExec(((ClientExecChain) (obj3)), ((ServiceUnavailableRetryStrategy) (obj6)));
        }
        obj6 = backoffManager;
        obj8 = connectionBackoffStrategy;
        obj3 = obj1;
        if (obj6 != null)
        {
            obj3 = obj1;
            if (obj8 != null)
            {
                obj3 = new BackoffStrategyExec(((ClientExecChain) (obj1)), ((ConnectionBackoffStrategy) (obj8)), ((BackoffManager) (obj6)));
            }
        }
        obj1 = authSchemeRegistry;
        obj6 = obj1;
        if (obj1 == null)
        {
            obj6 = RegistryBuilder.create().register("Basic", new BasicSchemeFactory()).register("Digest", new DigestSchemeFactory()).register("NTLM", new NTLMSchemeFactory()).build();
        }
        obj1 = cookieSpecRegistry;
        obj8 = obj1;
        if (obj1 == null)
        {
            obj8 = RegistryBuilder.create().register("best-match", new BestMatchSpecFactory()).register("standard", new RFC2965SpecFactory()).register("compatibility", new BrowserCompatSpecFactory()).register("netscape", new NetscapeDraftSpecFactory()).register("ignoreCookies", new IgnoreSpecFactory()).register("rfc2109", new RFC2109SpecFactory()).register("rfc2965", new RFC2965SpecFactory()).build();
        }
        obj1 = cookieStore;
        obj10 = obj1;
        if (obj1 == null)
        {
            obj10 = new BasicCookieStore();
        }
        obj11 = credentialsProvider;
        obj1 = obj11;
        if (obj11 == null)
        {
            if (systemProperties)
            {
                obj1 = new SystemDefaultCredentialsProvider();
            } else
            {
                obj1 = new BasicCredentialsProvider();
            }
        }
        if (defaultRequestConfig != null)
        {
            obj11 = defaultRequestConfig;
        } else
        {
            obj11 = RequestConfig.DEFAULT;
        }
        if (closeables != null)
        {
            arraylist = new ArrayList(closeables);
        } else
        {
            arraylist = null;
        }
        return new InternalHttpClient(((ClientExecChain) (obj3)), ((HttpClientConnectionManager) (obj4)), ((HttpRoutePlanner) (obj)), ((Lookup) (obj8)), ((Lookup) (obj6)), ((CookieStore) (obj10)), ((CredentialsProvider) (obj1)), ((RequestConfig) (obj11)), arraylist);
    }

    protected ClientExecChain decorateMainExec(ClientExecChain clientexecchain)
    {
        return clientexecchain;
    }

    protected ClientExecChain decorateProtocolExec(ClientExecChain clientexecchain)
    {
        return clientexecchain;
    }

    public final HttpClientBuilder disableAuthCaching()
    {
        authCachingDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableAutomaticRetries()
    {
        automaticRetriesDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableConnectionState()
    {
        connectionStateDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableContentCompression()
    {
        contentCompressionDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableCookieManagement()
    {
        cookieManagementDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableRedirectHandling()
    {
        redirectHandlingDisabled = true;
        return this;
    }

    public final HttpClientBuilder setBackoffManager(BackoffManager backoffmanager)
    {
        backoffManager = backoffmanager;
        return this;
    }

    public final HttpClientBuilder setConnectionBackoffStrategy(ConnectionBackoffStrategy connectionbackoffstrategy)
    {
        connectionBackoffStrategy = connectionbackoffstrategy;
        return this;
    }

    public final HttpClientBuilder setConnectionManager(HttpClientConnectionManager httpclientconnectionmanager)
    {
        connManager = httpclientconnectionmanager;
        return this;
    }

    public final HttpClientBuilder setConnectionReuseStrategy(ConnectionReuseStrategy connectionreusestrategy)
    {
        reuseStrategy = connectionreusestrategy;
        return this;
    }

    public final HttpClientBuilder setDefaultAuthSchemeRegistry(Lookup lookup)
    {
        authSchemeRegistry = lookup;
        return this;
    }

    public final HttpClientBuilder setDefaultConnectionConfig(ConnectionConfig connectionconfig)
    {
        defaultConnectionConfig = connectionconfig;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieSpecRegistry(Lookup lookup)
    {
        cookieSpecRegistry = lookup;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieStore(CookieStore cookiestore)
    {
        cookieStore = cookiestore;
        return this;
    }

    public final HttpClientBuilder setDefaultCredentialsProvider(CredentialsProvider credentialsprovider)
    {
        credentialsProvider = credentialsprovider;
        return this;
    }

    public final HttpClientBuilder setDefaultHeaders(Collection collection)
    {
        defaultHeaders = collection;
        return this;
    }

    public final HttpClientBuilder setDefaultRequestConfig(RequestConfig requestconfig)
    {
        defaultRequestConfig = requestconfig;
        return this;
    }

    public final HttpClientBuilder setDefaultSocketConfig(SocketConfig socketconfig)
    {
        defaultSocketConfig = socketconfig;
        return this;
    }

    public final HttpClientBuilder setHostnameVerifier(X509HostnameVerifier x509hostnameverifier)
    {
        hostnameVerifier = x509hostnameverifier;
        return this;
    }

    public final HttpClientBuilder setHttpProcessor(HttpProcessor httpprocessor1)
    {
        httpprocessor = httpprocessor1;
        return this;
    }

    public final HttpClientBuilder setKeepAliveStrategy(ConnectionKeepAliveStrategy connectionkeepalivestrategy)
    {
        keepAliveStrategy = connectionkeepalivestrategy;
        return this;
    }

    public final HttpClientBuilder setMaxConnPerRoute(int i)
    {
        maxConnPerRoute = i;
        return this;
    }

    public final HttpClientBuilder setMaxConnTotal(int i)
    {
        maxConnTotal = i;
        return this;
    }

    public final HttpClientBuilder setProxy(HttpHost httphost)
    {
        proxy = httphost;
        return this;
    }

    public final HttpClientBuilder setProxyAuthenticationStrategy(AuthenticationStrategy authenticationstrategy)
    {
        proxyAuthStrategy = authenticationstrategy;
        return this;
    }

    public final HttpClientBuilder setRedirectStrategy(RedirectStrategy redirectstrategy)
    {
        redirectStrategy = redirectstrategy;
        return this;
    }

    public final HttpClientBuilder setRequestExecutor(HttpRequestExecutor httprequestexecutor)
    {
        requestExec = httprequestexecutor;
        return this;
    }

    public final HttpClientBuilder setRetryHandler(HttpRequestRetryHandler httprequestretryhandler)
    {
        retryHandler = httprequestretryhandler;
        return this;
    }

    public final HttpClientBuilder setRoutePlanner(HttpRoutePlanner httprouteplanner)
    {
        routePlanner = httprouteplanner;
        return this;
    }

    public final HttpClientBuilder setSSLSocketFactory(LayeredConnectionSocketFactory layeredconnectionsocketfactory)
    {
        sslSocketFactory = layeredconnectionsocketfactory;
        return this;
    }

    public final HttpClientBuilder setSchemePortResolver(SchemePortResolver schemeportresolver)
    {
        schemePortResolver = schemeportresolver;
        return this;
    }

    public final HttpClientBuilder setServiceUnavailableRetryStrategy(ServiceUnavailableRetryStrategy serviceunavailableretrystrategy)
    {
        serviceUnavailStrategy = serviceunavailableretrystrategy;
        return this;
    }

    public final HttpClientBuilder setSslcontext(SSLContext sslcontext1)
    {
        sslcontext = sslcontext1;
        return this;
    }

    public final HttpClientBuilder setTargetAuthenticationStrategy(AuthenticationStrategy authenticationstrategy)
    {
        targetAuthStrategy = authenticationstrategy;
        return this;
    }

    public final HttpClientBuilder setUserAgent(String s)
    {
        userAgent = s;
        return this;
    }

    public final HttpClientBuilder setUserTokenHandler(UserTokenHandler usertokenhandler)
    {
        userTokenHandler = usertokenhandler;
        return this;
    }

    public final HttpClientBuilder useSystemProperties()
    {
        systemProperties = true;
        return this;
    }

    static 
    {
        Object obj = VersionInfo.loadVersionInfo("cz.msebera.android.httpclient.client", cz/msebera/android/httpclient/impl/client/HttpClientBuilder.getClassLoader());
        if (obj != null)
        {
            obj = ((VersionInfo) (obj)).getRelease();
        } else
        {
            obj = "UNAVAILABLE";
        }
        DEFAULT_USER_AGENT = (new StringBuilder()).append("Apache-HttpClient/").append(((String) (obj))).append(" (java 1.5)").toString();
    }
}
