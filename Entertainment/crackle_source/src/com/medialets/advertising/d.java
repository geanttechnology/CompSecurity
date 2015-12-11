// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRequestDirector;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

// Referenced classes of package com.medialets.advertising:
//            m, a

final class d
    implements HttpClient
{

    public static final String DEFAULT_USERAGENT = null;
    private static final ThreadLocal a = new ThreadLocal();
    private static final HttpRequestInterceptor b = new m();
    private final DefaultHttpClient c;

    private d(ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
    {
        final class a extends DefaultHttpClient
        {

            protected final RequestDirector createClientRequestDirector(HttpRequestExecutor httprequestexecutor, ClientConnectionManager clientconnectionmanager1, ConnectionReuseStrategy connectionreusestrategy, ConnectionKeepAliveStrategy connectionkeepalivestrategy, HttpRoutePlanner httprouteplanner, HttpProcessor httpprocessor, HttpRequestRetryHandler httprequestretryhandler, 
                    RedirectHandler redirecthandler, AuthenticationHandler authenticationhandler, AuthenticationHandler authenticationhandler1, UserTokenHandler usertokenhandler, HttpParams httpparams1)
            {
                final class a.a extends DefaultRequestDirector
                {

                    public final HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
                        throws HttpException, IOException
                    {
                        if (httphost == null)
                        {
                            httphost = new BasicHttpResponse(HttpVersion.HTTP_1_0, 200, "OK");
                            httprequest = new File(httprequest.getRequestLine().getUri());
                            com.medialets.advertising.a.d((new StringBuilder()).append("Loading file ").append(httprequest).append(" from local disk").toString());
                            if (httprequest.exists())
                            {
                                httphost.setEntity(new FileEntity(httprequest, "application/x-www-form-urlencoded"));
                                httphost.setParams(params);
                                requestExec.postProcess(httphost, httpProcessor, httpcontext);
                                return httphost;
                            } else
                            {
                                httphost.setStatusCode(404);
                                httphost.setReasonPhrase((new StringBuilder()).append("Could not find file ").append(httprequest.getAbsolutePath()).append(" on device").toString());
                                return httphost;
                            }
                        } else
                        {
                            return super.execute(httphost, httprequest, httpcontext);
                        }
                    }

            a.a(a a1, HttpRequestExecutor httprequestexecutor, ClientConnectionManager clientconnectionmanager, ConnectionReuseStrategy connectionreusestrategy, ConnectionKeepAliveStrategy connectionkeepalivestrategy, HttpRoutePlanner httprouteplanner, HttpProcessor httpprocessor, 
                    HttpRequestRetryHandler httprequestretryhandler, RedirectHandler redirecthandler, AuthenticationHandler authenticationhandler, AuthenticationHandler authenticationhandler1, UserTokenHandler usertokenhandler, HttpParams httpparams)
            {
                super(httprequestexecutor, clientconnectionmanager, connectionreusestrategy, connectionkeepalivestrategy, httprouteplanner, httpprocessor, httprequestretryhandler, redirecthandler, authenticationhandler, authenticationhandler1, usertokenhandler, httpparams);
            }
                }

                return new a(this, httprequestexecutor, clientconnectionmanager1, connectionreusestrategy, connectionkeepalivestrategy, httprouteplanner, httpprocessor, httprequestretryhandler, redirecthandler, authenticationhandler, authenticationhandler1, usertokenhandler, httpparams1);
            }

            protected final BasicHttpProcessor createHttpProcessor()
            {
                BasicHttpProcessor basichttpprocessor = super.createHttpProcessor();
                basichttpprocessor.addRequestInterceptor(d.c());
                return basichttpprocessor;
            }

            a(ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
            {
                super(clientconnectionmanager, httpparams);
            }
        }

        c = new a(clientconnectionmanager, httpparams);
    }

    public static d a(String s, boolean flag)
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basichttpparams, false);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 20000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpClientParams.setRedirecting(basichttpparams, flag);
        if (s != null)
        {
            HttpProtocolParams.setUserAgent(basichttpparams, s);
        }
        s = new SchemeRegistry();
        s.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        s.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return new d(new ThreadSafeClientConnManager(basichttpparams, s), basichttpparams);
    }

    private HttpContext a(Context context, List list)
    {
        BasicHttpContext basichttpcontext = new BasicHttpContext();
        basichttpcontext.setAttribute("http.authscheme-registry", c.getAuthSchemes());
        basichttpcontext.setAttribute("http.cookiespec-registry", c.getCookieSpecs());
        basichttpcontext.setAttribute("http.auth.credentials-provider", c.getCredentialsProvider());
        if (context != null && list != null)
        {
            context = CookieSyncManager.createInstance(context);
            context.startSync();
            CookieManager cookiemanager = CookieManager.getInstance();
            cookiemanager.setAcceptCookie(true);
            BasicCookieStore basiccookiestore = new BasicCookieStore();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                Object obj = (String)list.next();
                String s = cookiemanager.getCookie(((String) (obj)));
                if (s != null)
                {
                    com.medialets.advertising.a.d((new StringBuilder()).append("Cookie=").append(s).toString());
                    obj = (new HttpGet(((String) (obj)))).getURI();
                    String as[] = s.split(";");
                    for (int i = 0; i < as.length; i++)
                    {
                        String as1[] = as[i].split("=", 2);
                        if (as1.length == 2)
                        {
                            com.medialets.advertising.a.d((new StringBuilder()).append("Adding cookie: ").append(as1[0]).append("|").append(as1[1]).toString());
                            BasicClientCookie basicclientcookie = new BasicClientCookie(as1[0], as1[1]);
                            basicclientcookie.setDomain(((URI) (obj)).getHost());
                            basicclientcookie.setPath(((URI) (obj)).getPath());
                            basiccookiestore.addCookie(basicclientcookie);
                        }
                    }

                    if (as.length == 0)
                    {
                        com.medialets.advertising.a.c((new StringBuilder()).append("Bad cookie value=").append(s).toString());
                    }
                }
            } while (true);
            basichttpcontext.setAttribute("http.cookie-store", basiccookiestore);
            context.stopSync();
        }
        return basichttpcontext;
    }

    static ThreadLocal b()
    {
        return a;
    }

    static HttpRequestInterceptor c()
    {
        return b;
    }

    public final HttpContext a(Context context, String s)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(s);
        return a(context, ((List) (arraylist)));
    }

    public final void a()
    {
        getConnectionManager().shutdown();
    }

    public final Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
        throws IOException
    {
        return c.execute(httphost, httprequest, responsehandler);
    }

    public final Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException
    {
        return c.execute(httphost, httprequest, responsehandler, httpcontext);
    }

    public final Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler)
        throws IOException
    {
        return c.execute(httpurirequest, responsehandler);
    }

    public final Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException
    {
        return c.execute(httpurirequest, responsehandler, httpcontext);
    }

    public final HttpResponse execute(HttpHost httphost, HttpRequest httprequest)
        throws IOException
    {
        return c.execute(httphost, httprequest);
    }

    public final HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException
    {
        return c.execute(httphost, httprequest, httpcontext);
    }

    public final HttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException
    {
        return c.execute(httpurirequest);
    }

    public final HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException
    {
        return c.execute(httpurirequest, httpcontext);
    }

    public final ClientConnectionManager getConnectionManager()
    {
        return c.getConnectionManager();
    }

    public final HttpParams getParams()
    {
        return c.getParams();
    }


    // Unreferenced inner class com/medialets/advertising/m
    static final class m
        implements HttpRequestInterceptor
    {

        public final void process(HttpRequest httprequest, HttpContext httpcontext)
        {
            if (Boolean.TRUE.equals(d.b().get()))
            {
                throw new RuntimeException("This thread forbids HTTP requests");
            } else
            {
                return;
            }
        }

            m()
            {
            }
    }

}
