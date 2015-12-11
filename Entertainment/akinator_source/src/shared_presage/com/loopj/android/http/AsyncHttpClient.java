// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import android.content.Context;
import android.util.Log;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
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
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            a, b, s, MySSLSocketFactory, 
//            RequestParams, ResponseHandlerInterface, d, RequestHandle, 
//            c

public class AsyncHttpClient
{
    private static final class a extends HttpEntityWrapper
    {

        public final InputStream getContent()
        {
            return new GZIPInputStream(wrappedEntity.getContent());
        }

        public final long getContentLength()
        {
            return -1L;
        }

        public a(HttpEntity httpentity)
        {
            super(httpentity);
        }
    }


    private static final int DEFAULT_MAX_CONNECTIONS = 10;
    private static final int DEFAULT_MAX_RETRIES = 5;
    private static final int DEFAULT_RETRY_SLEEP_TIME_MILLIS = 1500;
    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final int DEFAULT_SOCKET_TIMEOUT = 10000;
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    private static final String LOG_TAG = "AsyncHttpClient";
    private static final String VERSION = "1.4.4";
    private final Map clientHeaderMap;
    private final DefaultHttpClient httpClient;
    private final HttpContext httpContext;
    private boolean isUrlEncodingEnabled;
    private int maxConnections;
    private final Map requestMap;
    private ThreadPoolExecutor threadPool;
    private int timeout;

    public AsyncHttpClient()
    {
        this(false, 80, 443);
    }

    public AsyncHttpClient(int i)
    {
        this(false, i, 443);
    }

    public AsyncHttpClient(int i, int j)
    {
        this(false, i, j);
    }

    public AsyncHttpClient(SchemeRegistry schemeregistry)
    {
        maxConnections = 10;
        timeout = 10000;
        isUrlEncodingEnabled = true;
        BasicHttpParams basichttpparams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basichttpparams, timeout);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(maxConnections));
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 10);
        HttpConnectionParams.setSoTimeout(basichttpparams, timeout);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, timeout);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basichttpparams, String.format("android-async-http/%s (http://loopj.com/android-async-http)", new Object[] {
            "1.4.4"
        }));
        schemeregistry = new ThreadSafeClientConnManager(basichttpparams, schemeregistry);
        threadPool = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        requestMap = new WeakHashMap();
        clientHeaderMap = new HashMap();
        httpContext = new SyncBasicHttpContext(new BasicHttpContext());
        httpClient = new DefaultHttpClient(schemeregistry, basichttpparams);
        httpClient.addRequestInterceptor(new shared_presage.com.loopj.android.http.a(this));
        httpClient.addResponseInterceptor(new b(this));
        httpClient.setHttpRequestRetryHandler(new s(5, 1500));
    }

    public AsyncHttpClient(boolean flag, int i, int j)
    {
        this(getDefaultSchemeRegistry(flag, i, j));
    }

    private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase httpentityenclosingrequestbase, HttpEntity httpentity)
    {
        if (httpentity != null)
        {
            httpentityenclosingrequestbase.setEntity(httpentity);
        }
        return httpentityenclosingrequestbase;
    }

    private static SchemeRegistry getDefaultSchemeRegistry(boolean flag, int i, int j)
    {
        if (flag)
        {
            Log.d("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        int k = i;
        if (i <= 0)
        {
            k = 80;
            Log.d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
        }
        i = j;
        if (j <= 0)
        {
            i = 443;
            Log.d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
        }
        SSLSocketFactory sslsocketfactory;
        SchemeRegistry schemeregistry;
        if (flag)
        {
            sslsocketfactory = MySSLSocketFactory.getFixedSocketFactory();
        } else
        {
            sslsocketfactory = SSLSocketFactory.getSocketFactory();
        }
        schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), k));
        schemeregistry.register(new Scheme("https", sslsocketfactory, i));
        return schemeregistry;
    }

    public static String getUrlWithQueryString(boolean flag, String s1, RequestParams requestparams)
    {
label0:
        {
            if (flag)
            {
                s1 = s1.replace(" ", "%20");
            }
            String s2 = s1;
            if (requestparams != null)
            {
                requestparams = requestparams.getParamString();
                if (s1.contains("?"))
                {
                    break label0;
                }
                s2 = (new StringBuilder()).append(s1).append("?").append(requestparams).toString();
            }
            return s2;
        }
        return (new StringBuilder()).append(s1).append("&").append(requestparams).toString();
    }

    private HttpEntity paramsToEntity(RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        HttpEntity httpentity = null;
        if (requestparams != null)
        {
            try
            {
                httpentity = requestparams.getEntity(responsehandlerinterface);
            }
            // Misplaced declaration of an exception variable
            catch (RequestParams requestparams)
            {
                if (responsehandlerinterface != null)
                {
                    responsehandlerinterface.sendFailureMessage(0, null, null, requestparams);
                    return null;
                } else
                {
                    requestparams.printStackTrace();
                    return null;
                }
            }
        }
        return httpentity;
    }

    public void addHeader(String s1, String s2)
    {
        clientHeaderMap.put(s1, s2);
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

    public void clearBasicAuth()
    {
        httpClient.getCredentialsProvider().clear();
    }

    public RequestHandle delete(Context context, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        s1 = new HttpDelete(s1);
        return sendRequest(httpClient, httpContext, s1, null, responsehandlerinterface, context);
    }

    public RequestHandle delete(Context context, String s1, Header aheader[], RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        s1 = new HttpDelete(getUrlWithQueryString(isUrlEncodingEnabled, s1, requestparams));
        if (aheader != null)
        {
            s1.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s1, null, responsehandlerinterface, context);
    }

    public RequestHandle delete(Context context, String s1, Header aheader[], ResponseHandlerInterface responsehandlerinterface)
    {
        s1 = new HttpDelete(s1);
        if (aheader != null)
        {
            s1.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s1, null, responsehandlerinterface, context);
    }

    public RequestHandle delete(String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return delete(null, s1, responsehandlerinterface);
    }

    public RequestHandle get(Context context, String s1, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(httpClient, httpContext, new HttpGet(getUrlWithQueryString(isUrlEncodingEnabled, s1, requestparams)), null, responsehandlerinterface, context);
    }

    public RequestHandle get(Context context, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return get(context, s1, null, responsehandlerinterface);
    }

    public RequestHandle get(Context context, String s1, Header aheader[], RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        s1 = new HttpGet(getUrlWithQueryString(isUrlEncodingEnabled, s1, requestparams));
        if (aheader != null)
        {
            s1.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s1, null, responsehandlerinterface, context);
    }

    public RequestHandle get(String s1, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return get(null, s1, requestparams, responsehandlerinterface);
    }

    public RequestHandle get(String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return get(null, s1, null, responsehandlerinterface);
    }

    public HttpClient getHttpClient()
    {
        return httpClient;
    }

    public HttpContext getHttpContext()
    {
        return httpContext;
    }

    public int getMaxConnections()
    {
        return maxConnections;
    }

    public int getTimeout()
    {
        return timeout;
    }

    public RequestHandle head(Context context, String s1, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(httpClient, httpContext, new HttpHead(getUrlWithQueryString(isUrlEncodingEnabled, s1, requestparams)), null, responsehandlerinterface, context);
    }

    public RequestHandle head(Context context, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return head(context, s1, null, responsehandlerinterface);
    }

    public RequestHandle head(Context context, String s1, Header aheader[], RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        s1 = new HttpHead(getUrlWithQueryString(isUrlEncodingEnabled, s1, requestparams));
        if (aheader != null)
        {
            s1.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s1, null, responsehandlerinterface, context);
    }

    public RequestHandle head(String s1, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return head(null, s1, requestparams, responsehandlerinterface);
    }

    public RequestHandle head(String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return head(null, s1, null, responsehandlerinterface);
    }

    public boolean isUrlEncodingEnabled()
    {
        return isUrlEncodingEnabled;
    }

    public RequestHandle post(Context context, String s1, HttpEntity httpentity, String s2, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(httpClient, httpContext, addEntityToRequestBase(new HttpPost(s1), httpentity), s2, responsehandlerinterface, context);
    }

    public RequestHandle post(Context context, String s1, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return post(context, s1, paramsToEntity(requestparams, responsehandlerinterface), null, responsehandlerinterface);
    }

    public RequestHandle post(Context context, String s1, Header aheader[], HttpEntity httpentity, String s2, ResponseHandlerInterface responsehandlerinterface)
    {
        s1 = addEntityToRequestBase(new HttpPost(s1), httpentity);
        if (aheader != null)
        {
            s1.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s1, s2, responsehandlerinterface, context);
    }

    public RequestHandle post(Context context, String s1, Header aheader[], RequestParams requestparams, String s2, ResponseHandlerInterface responsehandlerinterface)
    {
        s1 = new HttpPost(s1);
        if (requestparams != null)
        {
            s1.setEntity(paramsToEntity(requestparams, responsehandlerinterface));
        }
        if (aheader != null)
        {
            s1.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s1, s2, responsehandlerinterface, context);
    }

    public RequestHandle post(String s1, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return post(null, s1, requestparams, responsehandlerinterface);
    }

    public RequestHandle post(String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return post(null, s1, null, responsehandlerinterface);
    }

    public RequestHandle put(Context context, String s1, HttpEntity httpentity, String s2, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(httpClient, httpContext, addEntityToRequestBase(new HttpPut(s1), httpentity), s2, responsehandlerinterface, context);
    }

    public RequestHandle put(Context context, String s1, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return put(context, s1, paramsToEntity(requestparams, responsehandlerinterface), null, responsehandlerinterface);
    }

    public RequestHandle put(Context context, String s1, Header aheader[], HttpEntity httpentity, String s2, ResponseHandlerInterface responsehandlerinterface)
    {
        s1 = addEntityToRequestBase(new HttpPut(s1), httpentity);
        if (aheader != null)
        {
            s1.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s1, s2, responsehandlerinterface, context);
    }

    public RequestHandle put(String s1, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return put(null, s1, requestparams, responsehandlerinterface);
    }

    public RequestHandle put(String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return put(null, s1, null, responsehandlerinterface);
    }

    public void removeHeader(String s1)
    {
        clientHeaderMap.remove(s1);
    }

    protected RequestHandle sendRequest(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s1, ResponseHandlerInterface responsehandlerinterface, Context context)
    {
        if (s1 != null)
        {
            httpurirequest.addHeader("Content-Type", s1);
        }
        responsehandlerinterface.setRequestHeaders(httpurirequest.getAllHeaders());
        responsehandlerinterface.setRequestURI(httpurirequest.getURI());
        httpurirequest = threadPool.submit(new d(defaulthttpclient, httpcontext, httpurirequest, responsehandlerinterface));
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
        return new RequestHandle(httpurirequest);
    }

    public void setBasicAuth(String s1, String s2)
    {
        setBasicAuth(s1, s2, AuthScope.ANY);
    }

    public void setBasicAuth(String s1, String s2, AuthScope authscope)
    {
        s1 = new UsernamePasswordCredentials(s1, s2);
        httpClient.getCredentialsProvider().setCredentials(authscope, s1);
    }

    public void setCookieStore(CookieStore cookiestore)
    {
        httpContext.setAttribute("http.cookie-store", cookiestore);
    }

    public void setEnableRedirects(boolean flag)
    {
        httpClient.setRedirectHandler(new c(this, flag));
    }

    public void setMaxConnections(int i)
    {
        int j = i;
        if (i <= 0)
        {
            j = 10;
        }
        maxConnections = j;
        ConnManagerParams.setMaxConnectionsPerRoute(httpClient.getParams(), new ConnPerRouteBean(maxConnections));
    }

    public void setMaxRetriesAndTimeout(int i, int j)
    {
        httpClient.setHttpRequestRetryHandler(new s(i, j));
    }

    public void setProxy(String s1, int i)
    {
        s1 = new HttpHost(s1, i);
        httpClient.getParams().setParameter("http.route.default-proxy", s1);
    }

    public void setProxy(String s1, int i, String s2, String s3)
    {
        httpClient.getCredentialsProvider().setCredentials(new AuthScope(s1, i), new UsernamePasswordCredentials(s2, s3));
        s1 = new HttpHost(s1, i);
        httpClient.getParams().setParameter("http.route.default-proxy", s1);
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
        int j = i;
        if (i < 1000)
        {
            j = 10000;
        }
        timeout = j;
        HttpParams httpparams = httpClient.getParams();
        ConnManagerParams.setTimeout(httpparams, timeout);
        HttpConnectionParams.setSoTimeout(httpparams, timeout);
        HttpConnectionParams.setConnectionTimeout(httpparams, timeout);
    }

    public void setURLEncodingEnabled(boolean flag)
    {
        isUrlEncodingEnabled = flag;
    }

    public void setUserAgent(String s1)
    {
        HttpProtocolParams.setUserAgent(httpClient.getParams(), s1);
    }

}
