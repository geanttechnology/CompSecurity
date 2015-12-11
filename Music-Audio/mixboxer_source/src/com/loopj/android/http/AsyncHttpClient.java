// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

// Referenced classes of package com.loopj.android.http:
//            RetryHandler, RequestParams, AsyncHttpRequest, AsyncHttpResponseHandler

public class AsyncHttpClient
{
    private static class InflatingEntity extends HttpEntityWrapper
    {

        public InputStream getContent()
            throws IOException
        {
            return new GZIPInputStream(wrappedEntity.getContent());
        }

        public long getContentLength()
        {
            return -1L;
        }

        public InflatingEntity(HttpEntity httpentity)
        {
            super(httpentity);
        }
    }


    private static final int DEFAULT_MAX_CONNECTIONS = 10;
    private static final int DEFAULT_MAX_RETRIES = 5;
    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final int DEFAULT_SOCKET_TIMEOUT = 10000;
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    private static final String VERSION = "1.4.1";
    private static int maxConnections = 10;
    private static int socketTimeout = 10000;
    private final Map clientHeaderMap = new HashMap();
    private final DefaultHttpClient httpClient;
    private final HttpContext httpContext = new SyncBasicHttpContext(new BasicHttpContext());
    private final Map requestMap = new WeakHashMap();
    private ThreadPoolExecutor threadPool;

    public AsyncHttpClient()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basichttpparams, socketTimeout);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(maxConnections));
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 10);
        HttpConnectionParams.setSoTimeout(basichttpparams, socketTimeout);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, socketTimeout);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basichttpparams, String.format("android-async-http/%s (http://loopj.com/android-async-http)", new Object[] {
            "1.4.1"
        }));
        Object obj = new SchemeRegistry();
        ((SchemeRegistry) (obj)).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        ((SchemeRegistry) (obj)).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        obj = new ThreadSafeClientConnManager(basichttpparams, ((SchemeRegistry) (obj)));
        httpClient = new DefaultHttpClient(((ClientConnectionManager) (obj)), basichttpparams);
        httpClient.addRequestInterceptor(new HttpRequestInterceptor() {

            final AsyncHttpClient this$0;

            public void process(HttpRequest httprequest, HttpContext httpcontext)
            {
                if (!httprequest.containsHeader("Accept-Encoding"))
                {
                    httprequest.addHeader("Accept-Encoding", "gzip");
                }
                String s;
                for (httpcontext = clientHeaderMap.keySet().iterator(); httpcontext.hasNext(); httprequest.addHeader(s, (String)clientHeaderMap.get(s)))
                {
                    s = (String)httpcontext.next();
                }

            }

            
            {
                this$0 = AsyncHttpClient.this;
                super();
            }
        });
        httpClient.addResponseInterceptor(new HttpResponseInterceptor() {

            final AsyncHttpClient this$0;

            public void process(HttpResponse httpresponse, HttpContext httpcontext)
            {
                httpcontext = httpresponse.getEntity();
                if (httpcontext != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                if ((httpcontext = httpcontext.getContentEncoding()) != null)
                {
                    httpcontext = httpcontext.getElements();
                    int j = httpcontext.length;
                    int i = 0;
                    while (i < j) 
                    {
                        if (httpcontext[i].getName().equalsIgnoreCase("gzip"))
                        {
                            httpresponse.setEntity(new InflatingEntity(httpresponse.getEntity()));
                            return;
                        }
                        i++;
                    }
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = AsyncHttpClient.this;
                super();
            }
        });
        httpClient.setHttpRequestRetryHandler(new RetryHandler(5));
        threadPool = (ThreadPoolExecutor)Executors.newCachedThreadPool();
    }

    private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase httpentityenclosingrequestbase, HttpEntity httpentity)
    {
        if (httpentity != null)
        {
            httpentityenclosingrequestbase.setEntity(httpentity);
        }
        return httpentityenclosingrequestbase;
    }

    public static String getUrlWithQueryString(String s, RequestParams requestparams)
    {
label0:
        {
            String s1 = s;
            if (requestparams != null)
            {
                requestparams = requestparams.getParamString();
                if (s.indexOf("?") != -1)
                {
                    break label0;
                }
                s1 = (new StringBuilder()).append(s).append("?").append(requestparams).toString();
            }
            return s1;
        }
        return (new StringBuilder()).append(s).append("&").append(requestparams).toString();
    }

    private HttpEntity paramsToEntity(RequestParams requestparams)
    {
        HttpEntity httpentity = null;
        if (requestparams != null)
        {
            httpentity = requestparams.getEntity();
        }
        return httpentity;
    }

    public void addHeader(String s, String s1)
    {
        clientHeaderMap.put(s, s1);
    }

    public void cancelRequests(Context context, boolean flag)
    {
        Object obj = (List)requestMap.get(context);
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Future future = (Future)((WeakReference)((Iterator) (obj)).next()).get();
                if (future != null)
                {
                    future.cancel(flag);
                }
            } while (true);
        }
        requestMap.remove(context);
    }

    public void delete(Context context, String s, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        s = new HttpDelete(s);
        sendRequest(httpClient, httpContext, s, null, asynchttpresponsehandler, context);
    }

    public void delete(Context context, String s, Header aheader[], AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        s = new HttpDelete(s);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        sendRequest(httpClient, httpContext, s, null, asynchttpresponsehandler, context);
    }

    public void delete(String s, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        delete(null, s, asynchttpresponsehandler);
    }

    public void get(Context context, String s, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        get(context, s, null, asynchttpresponsehandler);
    }

    public void get(Context context, String s, RequestParams requestparams, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        sendRequest(httpClient, httpContext, new HttpGet(getUrlWithQueryString(s, requestparams)), null, asynchttpresponsehandler, context);
    }

    public void get(Context context, String s, Header aheader[], RequestParams requestparams, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        s = new HttpGet(getUrlWithQueryString(s, requestparams));
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        sendRequest(httpClient, httpContext, s, null, asynchttpresponsehandler, context);
    }

    public void get(String s, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        get(null, s, null, asynchttpresponsehandler);
    }

    public void get(String s, RequestParams requestparams, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        get(null, s, requestparams, asynchttpresponsehandler);
    }

    public HttpClient getHttpClient()
    {
        return httpClient;
    }

    public HttpContext getHttpContext()
    {
        return httpContext;
    }

    public void post(Context context, String s, RequestParams requestparams, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        post(context, s, paramsToEntity(requestparams), null, asynchttpresponsehandler);
    }

    public void post(Context context, String s, HttpEntity httpentity, String s1, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        sendRequest(httpClient, httpContext, addEntityToRequestBase(new HttpPost(s), httpentity), s1, asynchttpresponsehandler, context);
    }

    public void post(Context context, String s, Header aheader[], RequestParams requestparams, String s1, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        s = new HttpPost(s);
        if (requestparams != null)
        {
            s.setEntity(paramsToEntity(requestparams));
        }
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        sendRequest(httpClient, httpContext, s, s1, asynchttpresponsehandler, context);
    }

    public void post(Context context, String s, Header aheader[], HttpEntity httpentity, String s1, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        s = addEntityToRequestBase(new HttpPost(s), httpentity);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        sendRequest(httpClient, httpContext, s, s1, asynchttpresponsehandler, context);
    }

    public void post(String s, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        post(null, s, null, asynchttpresponsehandler);
    }

    public void post(String s, RequestParams requestparams, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        post(null, s, requestparams, asynchttpresponsehandler);
    }

    public void put(Context context, String s, RequestParams requestparams, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        put(context, s, paramsToEntity(requestparams), null, asynchttpresponsehandler);
    }

    public void put(Context context, String s, HttpEntity httpentity, String s1, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        sendRequest(httpClient, httpContext, addEntityToRequestBase(new HttpPut(s), httpentity), s1, asynchttpresponsehandler, context);
    }

    public void put(Context context, String s, Header aheader[], HttpEntity httpentity, String s1, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        s = addEntityToRequestBase(new HttpPut(s), httpentity);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        sendRequest(httpClient, httpContext, s, s1, asynchttpresponsehandler, context);
    }

    public void put(String s, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        put(null, s, null, asynchttpresponsehandler);
    }

    public void put(String s, RequestParams requestparams, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        put(null, s, requestparams, asynchttpresponsehandler);
    }

    protected void sendRequest(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s, AsyncHttpResponseHandler asynchttpresponsehandler, Context context)
    {
        if (s != null)
        {
            httpurirequest.addHeader("Content-Type", s);
        }
        httpurirequest = threadPool.submit(new AsyncHttpRequest(defaulthttpclient, httpcontext, httpurirequest, asynchttpresponsehandler));
        if (context != null)
        {
            httpcontext = (List)requestMap.get(context);
            defaulthttpclient = httpcontext;
            if (httpcontext == null)
            {
                defaulthttpclient = new LinkedList();
                requestMap.put(context, defaulthttpclient);
            }
            defaulthttpclient.add(new WeakReference(httpurirequest));
        }
    }

    public void setBasicAuth(String s, String s1)
    {
        setBasicAuth(s, s1, AuthScope.ANY);
    }

    public void setBasicAuth(String s, String s1, AuthScope authscope)
    {
        s = new UsernamePasswordCredentials(s, s1);
        httpClient.getCredentialsProvider().setCredentials(authscope, s);
    }

    public void setCookieStore(CookieStore cookiestore)
    {
        httpContext.setAttribute("http.cookie-store", cookiestore);
    }

    public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sslsocketfactory, 443));
    }

    public void setThreadPool(ThreadPoolExecutor threadpoolexecutor)
    {
        threadPool = threadpoolexecutor;
    }

    public void setTimeout(int i)
    {
        org.apache.http.params.HttpParams httpparams = httpClient.getParams();
        ConnManagerParams.setTimeout(httpparams, i);
        HttpConnectionParams.setSoTimeout(httpparams, i);
        HttpConnectionParams.setConnectionTimeout(httpparams, i);
    }

    public void setUserAgent(String s)
    {
        HttpProtocolParams.setUserAgent(httpClient.getParams(), s);
    }


}
