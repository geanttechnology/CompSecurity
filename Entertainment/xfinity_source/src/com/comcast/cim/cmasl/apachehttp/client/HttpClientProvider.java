// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.client;

import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestInterceptor;
import com.comcast.cim.httpcomponentsandroid.auth.AuthSchemeRegistry;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.conn.scheme.PlainSocketFactory;
import com.comcast.cim.httpcomponentsandroid.conn.scheme.Scheme;
import com.comcast.cim.httpcomponentsandroid.conn.scheme.SchemeRegistry;
import com.comcast.cim.httpcomponentsandroid.conn.ssl.SSLSocketFactory;
import com.comcast.cim.httpcomponentsandroid.conn.ssl.TrustStrategy;
import com.comcast.cim.httpcomponentsandroid.impl.auth.BasicSchemeFactory;
import com.comcast.cim.httpcomponentsandroid.impl.auth.DigestSchemeFactory;
import com.comcast.cim.httpcomponentsandroid.impl.client.DefaultHttpClient;
import com.comcast.cim.httpcomponentsandroid.impl.conn.ProxySelectorRoutePlanner;
import com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm.ThreadSafeClientConnManager;
import com.comcast.cim.httpcomponentsandroid.message.BasicHeader;
import com.comcast.cim.httpcomponentsandroid.params.BasicHttpParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpConnectionParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;
import java.net.ProxySelector;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientProvider
    implements Provider
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/apachehttp/client/HttpClientProvider);
    private boolean disableSSLVerification;
    private HttpHost optionalProxy;
    private List optionalRequestInterceptors;
    private BasicHeader userAgent;

    public HttpClientProvider(boolean flag, BasicHeader basicheader, HttpHost httphost, List list)
    {
        disableSSLVerification = false;
        disableSSLVerification = flag;
        userAgent = basicheader;
        optionalProxy = httphost;
        optionalRequestInterceptors = list;
    }

    public HttpClient get()
    {
        if (!disableSSLVerification) goto _L2; else goto _L1
_L1:
        Object obj = new SSLSocketFactory(new TrustStrategy() {

            final HttpClientProvider this$0;

            public boolean isTrusted(X509Certificate ax509certificate[], String s)
                throws CertificateException
            {
                return true;
            }

            
            {
                this$0 = HttpClientProvider.this;
                super();
            }
        });
_L4:
        SchemeRegistry schemeregistry;
        schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        schemeregistry.register(new Scheme("https", 443, ((com.comcast.cim.httpcomponentsandroid.conn.scheme.SchemeSocketFactory) (obj))));
        obj = new ThreadSafeClientConnManager(schemeregistry);
        ((ThreadSafeClientConnManager) (obj)).setMaxTotal(20);
        ((ThreadSafeClientConnManager) (obj)).setDefaultMaxPerRoute(5);
        Object obj1 = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj1)), 5000);
        HttpConnectionParams.setSoTimeout(((HttpParams) (obj1)), 10000);
        HttpConnectionParams.setSocketBufferSize(((HttpParams) (obj1)), 8192);
        obj = new DefaultHttpClient(((com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionManager) (obj)), ((HttpParams) (obj1)));
        if (userAgent != null)
        {
            LOG.debug((new StringBuilder()).append("Configuring HttpClient to use ").append(userAgent.getValue()).append(" as the User-Agent header").toString());
            ((DefaultHttpClient) (obj)).addRequestInterceptor(new HttpRequestInterceptor() {

                final HttpClientProvider this$0;

                public void process(HttpRequest httprequest, HttpContext httpcontext)
                    throws HttpException, IOException
                {
                    httprequest.addHeader(userAgent);
                }

            
            {
                this$0 = HttpClientProvider.this;
                super();
            }
            });
        }
        obj1 = new AuthSchemeRegistry();
        ((AuthSchemeRegistry) (obj1)).register("Basic", new BasicSchemeFactory());
        ((AuthSchemeRegistry) (obj1)).register("Digest", new DigestSchemeFactory());
        ((DefaultHttpClient) (obj)).setAuthSchemes(((AuthSchemeRegistry) (obj1)));
        if (optionalRequestInterceptors != null)
        {
            for (Iterator iterator = optionalRequestInterceptors.iterator(); iterator.hasNext(); ((DefaultHttpClient) (obj)).addRequestInterceptor((HttpRequestInterceptor)iterator.next())) { }
        }
        break MISSING_BLOCK_LABEL_282;
_L2:
        try
        {
            obj = SSLSocketFactory.getSocketFactory();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new CimException(((Throwable) (obj)));
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (optionalProxy == null)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        ((DefaultHttpClient) (obj)).getParams().setParameter("http.route.default-proxy", optionalProxy);
        return ((HttpClient) (obj));
        ((DefaultHttpClient) (obj)).setRoutePlanner(new ProxySelectorRoutePlanner(schemeregistry, ProxySelector.getDefault()));
        return ((HttpClient) (obj));
    }

    public volatile Object get()
    {
        return get();
    }


}
