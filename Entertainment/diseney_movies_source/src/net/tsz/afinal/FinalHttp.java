// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.aio.downloader.utils.MD5;
import com.aio.downloader.utils.publicTools;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import net.tsz.afinal.http.HttpHandler;
import net.tsz.afinal.http.RetryHandler;
import net.tsz.afinal.http.SyncRequestHandler;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
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

public class FinalHttp
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


    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static Context ctx;
    private static Executor executor;
    private static int httpThreadCount;
    private static int maxConnections = 10;
    private static int maxRetries = 5;
    private static final ThreadFactory sThreadFactory;
    private static int socketTimeout = 10000;
    public static SharedPreferences spkey;
    private String charset;
    private final Map clientHeaderMap = new HashMap();
    private final DefaultHttpClient httpClient;
    private final HttpContext httpContext = new SyncBasicHttpContext(new BasicHttpContext());

    public FinalHttp()
    {
        charset = "utf-8";
        BasicHttpParams basichttpparams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basichttpparams, socketTimeout);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(maxConnections));
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 10);
        HttpConnectionParams.setSoTimeout(basichttpparams, socketTimeout);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, socketTimeout);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        Object obj = new SchemeRegistry();
        ((SchemeRegistry) (obj)).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        ((SchemeRegistry) (obj)).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        obj = new ThreadSafeClientConnManager(basichttpparams, ((SchemeRegistry) (obj)));
        httpClient = new DefaultHttpClient(((ClientConnectionManager) (obj)), basichttpparams);
        httpClient.addRequestInterceptor(new HttpRequestInterceptor() {

            final FinalHttp this$0;

            public void process(HttpRequest httprequest, HttpContext httpcontext)
            {
                httprequest.addHeader("AIO", MD5.getMD5((new StringBuilder(String.valueOf(publicTools.keyid))).append(publicTools.downkey).toString()));
                httprequest.addHeader("User-Agent", (new StringBuilder(String.valueOf(FinalHttp.set_a_random_user_agent()))).append("AIOCLEANER").toString());
                Log.e("vfvf", (new StringBuilder("id=====")).append(publicTools.keyid).append("///////md5id=====").append(MD5.getMD5(publicTools.keyid)).append("//////webkey====").append(publicTools.downkey).append("\u4E24\u4E2A=====").append(MD5.getMD5((new StringBuilder(String.valueOf(publicTools.keyid))).append(publicTools.downkey).toString())).toString());
                if (!httprequest.containsHeader("Accept-Encoding"))
                {
                    httprequest.addHeader("Accept-Encoding", "gzip");
                }
                httpcontext = clientHeaderMap.keySet().iterator();
                do
                {
                    if (!httpcontext.hasNext())
                    {
                        return;
                    }
                    String s = (String)httpcontext.next();
                    httprequest.addHeader(s, (String)clientHeaderMap.get(s));
                } while (true);
            }

            
            {
                this$0 = FinalHttp.this;
                super();
            }
        });
        httpClient.addResponseInterceptor(new HttpResponseInterceptor() {

            final FinalHttp this$0;

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
                this$0 = FinalHttp.this;
                super();
            }
        });
        httpClient.setHttpRequestRetryHandler(new RetryHandler(maxRetries));
    }

    private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase httpentityenclosingrequestbase, HttpEntity httpentity)
    {
        if (httpentity != null)
        {
            httpentityenclosingrequestbase.setEntity(httpentity);
        }
        return httpentityenclosingrequestbase;
    }

    public static String getUrlWithQueryString(String s, AjaxParams ajaxparams)
    {
        String s1 = s;
        if (ajaxparams != null)
        {
            ajaxparams = ajaxparams.getParamString();
            s1 = (new StringBuilder(String.valueOf(s))).append("?").append(ajaxparams).toString();
        }
        return s1;
    }

    public static FinalHttp newInstance()
    {
        return new FinalHttp();
    }

    private HttpEntity paramsToEntity(AjaxParams ajaxparams)
    {
        HttpEntity httpentity = null;
        if (ajaxparams != null)
        {
            httpentity = ajaxparams.getEntity();
        }
        return httpentity;
    }

    public static String set_a_random_user_agent()
    {
        return "Mozilla/5.0 (Linux; Android 4.4.2; es-us; SAMSUNG SM-N900T Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36";
    }

    public void addHeader(String s, String s1)
    {
        clientHeaderMap.put(s, s1);
    }

    public void configCharset(String s)
    {
        if (s != null && s.trim().length() != 0)
        {
            charset = s;
        }
    }

    public void configCookieStore(CookieStore cookiestore)
    {
        httpContext.setAttribute("http.cookie-store", cookiestore);
    }

    public void configRequestExecutionRetryCount(int i)
    {
        httpClient.setHttpRequestRetryHandler(new RetryHandler(i));
    }

    public void configSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        sslsocketfactory = new Scheme("https", sslsocketfactory, 443);
        httpClient.getConnectionManager().getSchemeRegistry().register(sslsocketfactory);
    }

    public void configTimeout(int i)
    {
        org.apache.http.params.HttpParams httpparams = httpClient.getParams();
        ConnManagerParams.setTimeout(httpparams, i);
        HttpConnectionParams.setSoTimeout(httpparams, i);
        HttpConnectionParams.setConnectionTimeout(httpparams, i);
    }

    public void configUserAgent(String s)
    {
        HttpProtocolParams.setUserAgent(httpClient.getParams(), s);
    }

    public void delete(String s, AjaxCallBack ajaxcallback)
    {
        s = new HttpDelete(s);
        sendRequest(httpClient, httpContext, s, null, ajaxcallback);
    }

    public void delete(String s, Header aheader[], AjaxCallBack ajaxcallback)
    {
        s = new HttpDelete(s);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        sendRequest(httpClient, httpContext, s, null, ajaxcallback);
    }

    public Object deleteSync(String s)
    {
        return deleteSync(s, null);
    }

    public Object deleteSync(String s, Header aheader[])
    {
        s = new HttpDelete(s);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendSyncRequest(httpClient, httpContext, s, null);
    }

    public HttpHandler download(String s, String s1, AjaxCallBack ajaxcallback)
    {
        return download(s, null, s1, false, ajaxcallback);
    }

    public HttpHandler download(String s, String s1, boolean flag, AjaxCallBack ajaxcallback)
    {
        return download(s, null, s1, flag, ajaxcallback);
    }

    public HttpHandler download(String s, AjaxParams ajaxparams, String s1, AjaxCallBack ajaxcallback)
    {
        return download(s, ajaxparams, s1, false, ajaxcallback);
    }

    public HttpHandler download(String s, AjaxParams ajaxparams, String s1, boolean flag, AjaxCallBack ajaxcallback)
    {
        s = new HttpGet(getUrlWithQueryString(s, ajaxparams));
        ajaxparams = new HttpHandler(httpClient, httpContext, ajaxcallback, charset);
        ajaxparams.executeOnExecutor(executor, new Object[] {
            s, s1, Boolean.valueOf(flag)
        });
        return ajaxparams;
    }

    public void get(String s, AjaxCallBack ajaxcallback)
    {
        get(s, null, ajaxcallback);
    }

    public void get(String s, AjaxParams ajaxparams, AjaxCallBack ajaxcallback)
    {
        sendRequest(httpClient, httpContext, new HttpGet(getUrlWithQueryString(s, ajaxparams)), null, ajaxcallback);
    }

    public void get(String s, Header aheader[], AjaxParams ajaxparams, AjaxCallBack ajaxcallback)
    {
        s = new HttpGet(getUrlWithQueryString(s, ajaxparams));
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        sendRequest(httpClient, httpContext, s, null, ajaxcallback);
    }

    public HttpClient getHttpClient()
    {
        return httpClient;
    }

    public HttpContext getHttpContext()
    {
        return httpContext;
    }

    public Object getSync(String s)
    {
        return getSync(s, null);
    }

    public Object getSync(String s, AjaxParams ajaxparams)
    {
        s = new HttpGet(getUrlWithQueryString(s, ajaxparams));
        return sendSyncRequest(httpClient, httpContext, s, null);
    }

    public Object getSync(String s, Header aheader[], AjaxParams ajaxparams)
    {
        s = new HttpGet(getUrlWithQueryString(s, ajaxparams));
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendSyncRequest(httpClient, httpContext, s, null);
    }

    public void post(String s, AjaxCallBack ajaxcallback)
    {
        post(s, null, ajaxcallback);
    }

    public void post(String s, AjaxParams ajaxparams, AjaxCallBack ajaxcallback)
    {
        post(s, paramsToEntity(ajaxparams), null, ajaxcallback);
    }

    public void post(String s, HttpEntity httpentity, String s1, AjaxCallBack ajaxcallback)
    {
        sendRequest(httpClient, httpContext, addEntityToRequestBase(new HttpPost(s), httpentity), s1, ajaxcallback);
    }

    public void post(String s, Header aheader[], AjaxParams ajaxparams, String s1, AjaxCallBack ajaxcallback)
    {
        s = new HttpPost(s);
        if (ajaxparams != null)
        {
            s.setEntity(paramsToEntity(ajaxparams));
        }
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        sendRequest(httpClient, httpContext, s, s1, ajaxcallback);
    }

    public void post(String s, Header aheader[], HttpEntity httpentity, String s1, AjaxCallBack ajaxcallback)
    {
        s = addEntityToRequestBase(new HttpPost(s), httpentity);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        sendRequest(httpClient, httpContext, s, s1, ajaxcallback);
    }

    public Object postSync(String s)
    {
        return postSync(s, null);
    }

    public Object postSync(String s, AjaxParams ajaxparams)
    {
        return postSync(s, paramsToEntity(ajaxparams), null);
    }

    public Object postSync(String s, HttpEntity httpentity, String s1)
    {
        return sendSyncRequest(httpClient, httpContext, addEntityToRequestBase(new HttpPost(s), httpentity), s1);
    }

    public Object postSync(String s, Header aheader[], AjaxParams ajaxparams, String s1)
    {
        s = new HttpPost(s);
        if (ajaxparams != null)
        {
            s.setEntity(paramsToEntity(ajaxparams));
        }
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendSyncRequest(httpClient, httpContext, s, s1);
    }

    public Object postSync(String s, Header aheader[], HttpEntity httpentity, String s1)
    {
        s = addEntityToRequestBase(new HttpPost(s), httpentity);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendSyncRequest(httpClient, httpContext, s, s1);
    }

    public void put(String s, AjaxCallBack ajaxcallback)
    {
        put(s, null, ajaxcallback);
    }

    public void put(String s, AjaxParams ajaxparams, AjaxCallBack ajaxcallback)
    {
        put(s, paramsToEntity(ajaxparams), null, ajaxcallback);
    }

    public void put(String s, HttpEntity httpentity, String s1, AjaxCallBack ajaxcallback)
    {
        sendRequest(httpClient, httpContext, addEntityToRequestBase(new HttpPut(s), httpentity), s1, ajaxcallback);
    }

    public void put(String s, Header aheader[], HttpEntity httpentity, String s1, AjaxCallBack ajaxcallback)
    {
        s = addEntityToRequestBase(new HttpPut(s), httpentity);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        sendRequest(httpClient, httpContext, s, s1, ajaxcallback);
    }

    public Object putSync(String s)
    {
        return putSync(s, null);
    }

    public Object putSync(String s, AjaxParams ajaxparams)
    {
        return putSync(s, paramsToEntity(ajaxparams), null);
    }

    public Object putSync(String s, HttpEntity httpentity, String s1)
    {
        return putSync(s, null, httpentity, s1);
    }

    public Object putSync(String s, Header aheader[], HttpEntity httpentity, String s1)
    {
        s = addEntityToRequestBase(new HttpPut(s), httpentity);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendSyncRequest(httpClient, httpContext, s, s1);
    }

    protected void sendRequest(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s, AjaxCallBack ajaxcallback)
    {
        if (s != null)
        {
            httpurirequest.addHeader("Content-Type", s);
        }
        (new HttpHandler(defaulthttpclient, httpcontext, ajaxcallback, charset)).executeOnExecutor(executor, new Object[] {
            httpurirequest
        });
    }

    protected Object sendSyncRequest(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s)
    {
        if (s != null)
        {
            httpurirequest.addHeader("Content-Type", s);
        }
        return (new SyncRequestHandler(defaulthttpclient, httpcontext, charset)).sendRequest(new HttpUriRequest[] {
            httpurirequest
        });
    }

    static 
    {
        httpThreadCount = 4;
        sThreadFactory = new ThreadFactory() {

            private final AtomicInteger mCount = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                runnable = new Thread(runnable, (new StringBuilder("FinalHttp #")).append(mCount.getAndIncrement()).toString());
                runnable.setPriority(4);
                return runnable;
            }

        };
        executor = Executors.newFixedThreadPool(httpThreadCount, sThreadFactory);
    }

}
