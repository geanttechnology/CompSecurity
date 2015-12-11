// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.content.Context;
import android.os.Looper;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.UsernamePasswordCredentials;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.RedirectHandler;
import cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;
import cz.msebera.android.httpclient.client.methods.HttpHead;
import cz.msebera.android.httpclient.client.methods.HttpPatch;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.client.methods.HttpPut;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.params.ConnManagerParams;
import cz.msebera.android.httpclient.conn.params.ConnPerRouteBean;
import cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.impl.auth.BasicScheme;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.SyncBasicHttpContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;

// Referenced classes of package com.loopj.android.http:
//            LogHandler, Utils, RetryHandler, RequestHandle, 
//            LogInterface, MySSLSocketFactory, RequestParams, ResponseHandlerInterface, 
//            HttpDelete, HttpGet, AsyncHttpRequest, PreemptiveAuthorizationHttpRequestInterceptor, 
//            MyRedirectHandler, AsyncHttpResponseHandler

public class AsyncHttpClient
{
    private static class InflatingEntity extends HttpEntityWrapper
    {

        GZIPInputStream gzippedStream;
        PushbackInputStream pushbackStream;
        InputStream wrappedStream;

        public void consumeContent()
            throws IOException
        {
            AsyncHttpClient.silentCloseInputStream(wrappedStream);
            AsyncHttpClient.silentCloseInputStream(pushbackStream);
            AsyncHttpClient.silentCloseInputStream(gzippedStream);
            super.consumeContent();
        }

        public InputStream getContent()
            throws IOException
        {
            wrappedStream = wrappedEntity.getContent();
            pushbackStream = new PushbackInputStream(wrappedStream, 2);
            if (AsyncHttpClient.isInputStreamGZIPCompressed(pushbackStream))
            {
                gzippedStream = new GZIPInputStream(pushbackStream);
                return gzippedStream;
            } else
            {
                return pushbackStream;
            }
        }

        public long getContentLength()
        {
            if (wrappedEntity == null)
            {
                return 0L;
            } else
            {
                return wrappedEntity.getContentLength();
            }
        }

        public InflatingEntity(HttpEntity httpentity)
        {
            super(httpentity);
        }
    }


    public static final int DEFAULT_MAX_CONNECTIONS = 10;
    public static final int DEFAULT_MAX_RETRIES = 5;
    public static final int DEFAULT_RETRY_SLEEP_TIME_MILLIS = 1500;
    public static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    public static final int DEFAULT_SOCKET_TIMEOUT = 10000;
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_CONTENT_DISPOSITION = "Content-Disposition";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_CONTENT_RANGE = "Content-Range";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String LOG_TAG = "AsyncHttpClient";
    public static LogInterface log = new LogHandler();
    private final Map clientHeaderMap;
    private int connectTimeout;
    private final DefaultHttpClient httpClient;
    private final HttpContext httpContext;
    private boolean isUrlEncodingEnabled;
    private int maxConnections;
    private final Map requestMap;
    private int responseTimeout;
    private ExecutorService threadPool;

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
        boolean flag = true;
        super();
        maxConnections = 10;
        connectTimeout = 10000;
        responseTimeout = 10000;
        isUrlEncodingEnabled = true;
        BasicHttpParams basichttpparams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basichttpparams, connectTimeout);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(maxConnections));
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 10);
        HttpConnectionParams.setSoTimeout(basichttpparams, responseTimeout);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, connectTimeout);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        schemeregistry = createConnectionManager(schemeregistry, basichttpparams);
        if (schemeregistry == null)
        {
            flag = false;
        }
        Utils.asserts(flag, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
        threadPool = getDefaultThreadPool();
        requestMap = Collections.synchronizedMap(new WeakHashMap());
        clientHeaderMap = new HashMap();
        httpContext = new SyncBasicHttpContext(new BasicHttpContext());
        httpClient = new DefaultHttpClient(schemeregistry, basichttpparams);
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
                    if (httprequest.containsHeader(s))
                    {
                        Header header = httprequest.getFirstHeader(s);
                        AsyncHttpClient.log.d("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[] {
                            s, clientHeaderMap.get(s), header.getName(), header.getValue()
                        }));
                        httprequest.removeHeader(header);
                    }
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
                Header header;
                return;
_L2:
                if ((header = httpcontext.getContentEncoding()) != null)
                {
                    HeaderElement aheaderelement[] = header.getElements();
                    int j = aheaderelement.length;
                    int i = 0;
                    while (i < j) 
                    {
                        if (aheaderelement[i].getName().equalsIgnoreCase("gzip"))
                        {
                            httpresponse.setEntity(new InflatingEntity(httpcontext));
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
        httpClient.addRequestInterceptor(new HttpRequestInterceptor() {

            final AsyncHttpClient this$0;

            public void process(HttpRequest httprequest, HttpContext httpcontext)
                throws HttpException, IOException
            {
                httprequest = (AuthState)httpcontext.getAttribute("http.auth.target-scope");
                CredentialsProvider credentialsprovider = (CredentialsProvider)httpcontext.getAttribute("http.auth.credentials-provider");
                httpcontext = (HttpHost)httpcontext.getAttribute("http.target_host");
                if (httprequest.getAuthScheme() == null)
                {
                    httpcontext = credentialsprovider.getCredentials(new AuthScope(httpcontext.getHostName(), httpcontext.getPort()));
                    if (httpcontext != null)
                    {
                        httprequest.setAuthScheme(new BasicScheme());
                        httprequest.setCredentials(httpcontext);
                    }
                }
            }

            
            {
                this$0 = AsyncHttpClient.this;
                super();
            }
        }, 0);
        httpClient.setHttpRequestRetryHandler(new RetryHandler(5, 1500));
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

    public static void allowRetryExceptionClass(Class class1)
    {
        if (class1 != null)
        {
            RetryHandler.addClassToWhitelist(class1);
        }
    }

    public static void blockRetryExceptionClass(Class class1)
    {
        if (class1 != null)
        {
            RetryHandler.addClassToBlacklist(class1);
        }
    }

    private void cancelRequests(List list, boolean flag)
    {
        if (list != null)
        {
            for (list = list.iterator(); list.hasNext(); ((RequestHandle)list.next()).cancel(flag)) { }
        }
    }

    public static void endEntityViaReflection(HttpEntity httpentity)
    {
        {
            if (!(httpentity instanceof HttpEntityWrapper))
            {
                break MISSING_BLOCK_LABEL_78;
            }
            Object obj = null;
            Field field;
            Field afield[];
            int i;
            int j;
            try
            {
                afield = cz/msebera/android/httpclient/entity/HttpEntityWrapper.getDeclaredFields();
                j = afield.length;
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                log.e("AsyncHttpClient", "wrappedEntity consume", httpentity);
                return;
            }
            i = 0;
        }
        field = obj;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        field = afield[i];
        if (!field.getName().equals("wrappedEntity"))
        {
            break MISSING_BLOCK_LABEL_79;
        }
        if (field == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        field.setAccessible(true);
        httpentity = (HttpEntity)field.get(httpentity);
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        httpentity.consumeContent();
        return;
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_23;
        }
    }

    private static SchemeRegistry getDefaultSchemeRegistry(boolean flag, int i, int j)
    {
        if (flag)
        {
            log.d("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        int k = i;
        if (i < 1)
        {
            k = 80;
            log.d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
        }
        i = j;
        if (j < 1)
        {
            i = 443;
            log.d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
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

    public static String getUrlWithQueryString(boolean flag, String s, RequestParams requestparams)
    {
        if (s == null)
        {
            return null;
        }
        Object obj = s;
        if (flag)
        {
            try
            {
                obj = new URL(URLDecoder.decode(s, "UTF-8"));
                obj = (new URI(((URL) (obj)).getProtocol(), ((URL) (obj)).getUserInfo(), ((URL) (obj)).getHost(), ((URL) (obj)).getPort(), ((URL) (obj)).getPath(), ((URL) (obj)).getQuery(), ((URL) (obj)).getRef())).toASCIIString();
            }
            catch (Exception exception)
            {
                log.e("AsyncHttpClient", "getUrlWithQueryString encoding URL", exception);
                exception = s;
            }
        }
        s = ((String) (obj));
        if (requestparams != null)
        {
            requestparams = requestparams.getParamString().trim();
            s = ((String) (obj));
            if (!requestparams.equals(""))
            {
                s = ((String) (obj));
                if (!requestparams.equals("?"))
                {
                    StringBuilder stringbuilder = (new StringBuilder()).append(((String) (obj)));
                    if (((String) (obj)).contains("?"))
                    {
                        s = "&";
                    } else
                    {
                        s = "?";
                    }
                    s = stringbuilder.append(s).toString();
                    s = (new StringBuilder()).append(s).append(requestparams).toString();
                }
            }
        }
        return s;
    }

    public static boolean isInputStreamGZIPCompressed(PushbackInputStream pushbackinputstream)
        throws IOException
    {
        byte abyte0[];
        int i;
        boolean flag;
        flag = true;
        if (pushbackinputstream == null)
        {
            return false;
        }
        abyte0 = new byte[2];
        i = 0;
_L2:
        if (i >= 2)
        {
            break; /* Loop/switch isn't completed */
        }
        int j = pushbackinputstream.read(abyte0, i, 2 - i);
        if (j < 0)
        {
            pushbackinputstream.unread(abyte0, 0, i);
            return false;
        }
        i += j;
        if (true) goto _L2; else goto _L1
_L1:
        pushbackinputstream.unread(abyte0, 0, i);
        Exception exception;
        if (35615 != (abyte0[0] & 0xff | abyte0[1] << 8 & 0xff00))
        {
            flag = false;
        }
        return flag;
        exception;
        pushbackinputstream.unread(abyte0, 0, i);
        throw exception;
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

    public static void silentCloseInputStream(InputStream inputstream)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        return;
        inputstream;
        log.w("AsyncHttpClient", "Cannot close input stream", inputstream);
        return;
    }

    public static void silentCloseOutputStream(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        outputstream.close();
        return;
        outputstream;
        log.w("AsyncHttpClient", "Cannot close output stream", outputstream);
        return;
    }

    public void addHeader(String s, String s1)
    {
        clientHeaderMap.put(s, s1);
    }

    public void cancelAllRequests(boolean flag)
    {
        Iterator iterator = requestMap.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (List)iterator.next();
            if (obj != null)
            {
                obj = ((List) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    ((RequestHandle)((Iterator) (obj)).next()).cancel(flag);
                }
            }
        } while (true);
        requestMap.clear();
    }

    public void cancelRequests(Context context, final boolean mayInterruptIfRunning)
    {
        if (context == null)
        {
            log.e("AsyncHttpClient", "Passed null Context to cancelRequests");
            return;
        }
        final List requestList = (List)requestMap.get(context);
        requestMap.remove(context);
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            context = new Runnable() {

                final AsyncHttpClient this$0;
                final boolean val$mayInterruptIfRunning;
                final List val$requestList;

                public void run()
                {
                    cancelRequests(requestList, mayInterruptIfRunning);
                }

            
            {
                this$0 = AsyncHttpClient.this;
                requestList = list;
                mayInterruptIfRunning = flag;
                super();
            }
            };
            threadPool.submit(context);
            return;
        } else
        {
            cancelRequests(requestList, mayInterruptIfRunning);
            return;
        }
    }

    public void cancelRequestsByTAG(Object obj, boolean flag)
    {
        if (obj == null)
        {
            log.d("AsyncHttpClient", "cancelRequestsByTAG, passed TAG is null, cannot proceed");
        } else
        {
            Iterator iterator = requestMap.values().iterator();
            while (iterator.hasNext()) 
            {
                Object obj1 = (List)iterator.next();
                if (obj1 != null)
                {
                    obj1 = ((List) (obj1)).iterator();
                    while (((Iterator) (obj1)).hasNext()) 
                    {
                        RequestHandle requesthandle = (RequestHandle)((Iterator) (obj1)).next();
                        if (obj.equals(requesthandle.getTag()))
                        {
                            requesthandle.cancel(flag);
                        }
                    }
                }
            }
        }
    }

    public void clearCredentialsProvider()
    {
        httpClient.getCredentialsProvider().clear();
    }

    protected ClientConnectionManager createConnectionManager(SchemeRegistry schemeregistry, BasicHttpParams basichttpparams)
    {
        return new ThreadSafeClientConnManager(basichttpparams, schemeregistry);
    }

    public RequestHandle delete(Context context, String s, ResponseHandlerInterface responsehandlerinterface)
    {
        s = new HttpDelete(getURI(s));
        return sendRequest(httpClient, httpContext, s, null, responsehandlerinterface, context);
    }

    public RequestHandle delete(Context context, String s, HttpEntity httpentity, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(httpClient, httpContext, addEntityToRequestBase(new HttpDelete(URI.create(s).normalize()), httpentity), s1, responsehandlerinterface, context);
    }

    public RequestHandle delete(Context context, String s, Header aheader[], RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        s = new HttpDelete(getUrlWithQueryString(isUrlEncodingEnabled, s, requestparams));
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s, null, responsehandlerinterface, context);
    }

    public RequestHandle delete(Context context, String s, Header aheader[], ResponseHandlerInterface responsehandlerinterface)
    {
        s = new HttpDelete(getURI(s));
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s, null, responsehandlerinterface, context);
    }

    public RequestHandle delete(String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return delete(((Context) (null)), s, responsehandlerinterface);
    }

    public void delete(String s, RequestParams requestparams, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        s = new HttpDelete(getUrlWithQueryString(isUrlEncodingEnabled, s, requestparams));
        sendRequest(httpClient, httpContext, s, null, asynchttpresponsehandler, null);
    }

    public RequestHandle get(Context context, String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(httpClient, httpContext, new HttpGet(getUrlWithQueryString(isUrlEncodingEnabled, s, requestparams)), null, responsehandlerinterface, context);
    }

    public RequestHandle get(Context context, String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return get(context, s, null, responsehandlerinterface);
    }

    public RequestHandle get(Context context, String s, HttpEntity httpentity, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(httpClient, httpContext, addEntityToRequestBase(new HttpGet(URI.create(s).normalize()), httpentity), s1, responsehandlerinterface, context);
    }

    public RequestHandle get(Context context, String s, Header aheader[], RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        s = new HttpGet(getUrlWithQueryString(isUrlEncodingEnabled, s, requestparams));
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s, null, responsehandlerinterface, context);
    }

    public RequestHandle get(String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return get(null, s, requestparams, responsehandlerinterface);
    }

    public RequestHandle get(String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return get(null, s, null, responsehandlerinterface);
    }

    public int getConnectTimeout()
    {
        return connectTimeout;
    }

    protected ExecutorService getDefaultThreadPool()
    {
        return Executors.newCachedThreadPool();
    }

    public HttpClient getHttpClient()
    {
        return httpClient;
    }

    public HttpContext getHttpContext()
    {
        return httpContext;
    }

    public LogInterface getLogInterface()
    {
        return log;
    }

    public int getLoggingLevel()
    {
        return log.getLoggingLevel();
    }

    public int getMaxConnections()
    {
        return maxConnections;
    }

    public int getResponseTimeout()
    {
        return responseTimeout;
    }

    public ExecutorService getThreadPool()
    {
        return threadPool;
    }

    protected URI getURI(String s)
    {
        return URI.create(s).normalize();
    }

    public RequestHandle head(Context context, String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(httpClient, httpContext, new HttpHead(getUrlWithQueryString(isUrlEncodingEnabled, s, requestparams)), null, responsehandlerinterface, context);
    }

    public RequestHandle head(Context context, String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return head(context, s, null, responsehandlerinterface);
    }

    public RequestHandle head(Context context, String s, Header aheader[], RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        s = new HttpHead(getUrlWithQueryString(isUrlEncodingEnabled, s, requestparams));
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s, null, responsehandlerinterface, context);
    }

    public RequestHandle head(String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return head(null, s, requestparams, responsehandlerinterface);
    }

    public RequestHandle head(String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return head(null, s, null, responsehandlerinterface);
    }

    public boolean isLoggingEnabled()
    {
        return log.isLoggingEnabled();
    }

    public boolean isUrlEncodingEnabled()
    {
        return isUrlEncodingEnabled;
    }

    protected AsyncHttpRequest newAsyncHttpRequest(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s, ResponseHandlerInterface responsehandlerinterface, Context context)
    {
        return new AsyncHttpRequest(defaulthttpclient, httpcontext, httpurirequest, responsehandlerinterface);
    }

    public RequestHandle patch(Context context, String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return patch(context, s, paramsToEntity(requestparams, responsehandlerinterface), null, responsehandlerinterface);
    }

    public RequestHandle patch(Context context, String s, HttpEntity httpentity, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(httpClient, httpContext, addEntityToRequestBase(new HttpPatch(getURI(s)), httpentity), s1, responsehandlerinterface, context);
    }

    public RequestHandle patch(Context context, String s, Header aheader[], HttpEntity httpentity, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        s = addEntityToRequestBase(new HttpPatch(getURI(s)), httpentity);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s, s1, responsehandlerinterface, context);
    }

    public RequestHandle patch(String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return patch(null, s, requestparams, responsehandlerinterface);
    }

    public RequestHandle patch(String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return patch(null, s, null, responsehandlerinterface);
    }

    public RequestHandle post(Context context, String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return post(context, s, paramsToEntity(requestparams, responsehandlerinterface), null, responsehandlerinterface);
    }

    public RequestHandle post(Context context, String s, HttpEntity httpentity, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(httpClient, httpContext, addEntityToRequestBase(new HttpPost(getURI(s)), httpentity), s1, responsehandlerinterface, context);
    }

    public RequestHandle post(Context context, String s, Header aheader[], RequestParams requestparams, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        s = new HttpPost(getURI(s));
        if (requestparams != null)
        {
            s.setEntity(paramsToEntity(requestparams, responsehandlerinterface));
        }
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s, s1, responsehandlerinterface, context);
    }

    public RequestHandle post(Context context, String s, Header aheader[], HttpEntity httpentity, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        s = addEntityToRequestBase(new HttpPost(getURI(s)), httpentity);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s, s1, responsehandlerinterface, context);
    }

    public RequestHandle post(String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return post(null, s, requestparams, responsehandlerinterface);
    }

    public RequestHandle post(String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return post(null, s, null, responsehandlerinterface);
    }

    public RequestHandle put(Context context, String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return put(context, s, paramsToEntity(requestparams, responsehandlerinterface), null, responsehandlerinterface);
    }

    public RequestHandle put(Context context, String s, HttpEntity httpentity, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(httpClient, httpContext, addEntityToRequestBase(new HttpPut(getURI(s)), httpentity), s1, responsehandlerinterface, context);
    }

    public RequestHandle put(Context context, String s, Header aheader[], HttpEntity httpentity, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        s = addEntityToRequestBase(new HttpPut(getURI(s)), httpentity);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        return sendRequest(httpClient, httpContext, s, s1, responsehandlerinterface, context);
    }

    public RequestHandle put(String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return put(null, s, requestparams, responsehandlerinterface);
    }

    public RequestHandle put(String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return put(null, s, null, responsehandlerinterface);
    }

    public void removeAllHeaders()
    {
        clientHeaderMap.clear();
    }

    public void removeHeader(String s)
    {
        clientHeaderMap.remove(s);
    }

    protected RequestHandle sendRequest(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s, ResponseHandlerInterface responsehandlerinterface, Context context)
    {
        if (httpurirequest == null)
        {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        }
        if (responsehandlerinterface == null)
        {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        }
        if (responsehandlerinterface.getUseSynchronousMode() && !responsehandlerinterface.getUsePoolThread())
        {
            throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
        }
        if (s != null)
        {
            if ((httpurirequest instanceof HttpEntityEnclosingRequestBase) && ((HttpEntityEnclosingRequestBase)httpurirequest).getEntity() != null && httpurirequest.containsHeader("Content-Type"))
            {
                log.w("AsyncHttpClient", "Passed contentType will be ignored because HttpEntity sets content type");
            } else
            {
                httpurirequest.setHeader("Content-Type", s);
            }
        }
        responsehandlerinterface.setRequestHeaders(httpurirequest.getAllHeaders());
        responsehandlerinterface.setRequestURI(httpurirequest.getURI());
        defaulthttpclient = newAsyncHttpRequest(defaulthttpclient, httpcontext, httpurirequest, s, responsehandlerinterface, context);
        threadPool.submit(defaulthttpclient);
        httpurirequest = new RequestHandle(defaulthttpclient);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        s = requestMap;
        s;
        JVM INSTR monitorenter ;
        httpcontext = (List)requestMap.get(context);
        defaulthttpclient = httpcontext;
        if (httpcontext != null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        defaulthttpclient = Collections.synchronizedList(new LinkedList());
        requestMap.put(context, defaulthttpclient);
        s;
        JVM INSTR monitorexit ;
        defaulthttpclient.add(httpurirequest);
        defaulthttpclient = defaulthttpclient.iterator();
        do
        {
            if (!defaulthttpclient.hasNext())
            {
                break;
            }
            if (((RequestHandle)defaulthttpclient.next()).shouldBeGarbageCollected())
            {
                defaulthttpclient.remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_297;
        defaulthttpclient;
        s;
        JVM INSTR monitorexit ;
        throw defaulthttpclient;
        return httpurirequest;
    }

    public void setAuthenticationPreemptive(boolean flag)
    {
        if (flag)
        {
            httpClient.addRequestInterceptor(new PreemptiveAuthorizationHttpRequestInterceptor(), 0);
            return;
        } else
        {
            httpClient.removeRequestInterceptorByClass(com/loopj/android/http/PreemptiveAuthorizationHttpRequestInterceptor);
            return;
        }
    }

    public void setBasicAuth(String s, String s1)
    {
        setBasicAuth(s, s1, false);
    }

    public void setBasicAuth(String s, String s1, AuthScope authscope)
    {
        setBasicAuth(s, s1, authscope, false);
    }

    public void setBasicAuth(String s, String s1, AuthScope authscope, boolean flag)
    {
        setCredentials(authscope, new UsernamePasswordCredentials(s, s1));
        setAuthenticationPreemptive(flag);
    }

    public void setBasicAuth(String s, String s1, boolean flag)
    {
        setBasicAuth(s, s1, null, flag);
    }

    public void setConnectTimeout(int i)
    {
        int j = i;
        if (i < 1000)
        {
            j = 10000;
        }
        connectTimeout = j;
        HttpParams httpparams = httpClient.getParams();
        ConnManagerParams.setTimeout(httpparams, connectTimeout);
        HttpConnectionParams.setConnectionTimeout(httpparams, connectTimeout);
    }

    public void setCookieStore(CookieStore cookiestore)
    {
        httpContext.setAttribute("http.cookie-store", cookiestore);
    }

    public void setCredentials(AuthScope authscope, Credentials credentials)
    {
        if (credentials == null)
        {
            log.d("AsyncHttpClient", "Provided credentials are null, not setting");
            return;
        }
        CredentialsProvider credentialsprovider = httpClient.getCredentialsProvider();
        AuthScope authscope1 = authscope;
        if (authscope == null)
        {
            authscope1 = AuthScope.ANY;
        }
        credentialsprovider.setCredentials(authscope1, credentials);
    }

    public void setEnableRedirects(boolean flag)
    {
        setEnableRedirects(flag, flag, flag);
    }

    public void setEnableRedirects(boolean flag, boolean flag1)
    {
        setEnableRedirects(flag, flag1, true);
    }

    public void setEnableRedirects(boolean flag, boolean flag1, boolean flag2)
    {
        HttpParams httpparams = httpClient.getParams();
        if (!flag1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        httpparams.setBooleanParameter("http.protocol.reject-relative-redirect", flag1);
        httpClient.getParams().setBooleanParameter("http.protocol.allow-circular-redirects", flag2);
        httpClient.setRedirectHandler(new MyRedirectHandler(flag));
    }

    public void setLogInterface(LogInterface loginterface)
    {
        if (loginterface != null)
        {
            log = loginterface;
        }
    }

    public void setLoggingEnabled(boolean flag)
    {
        log.setLoggingEnabled(flag);
    }

    public void setLoggingLevel(int i)
    {
        log.setLoggingLevel(i);
    }

    public void setMaxConnections(int i)
    {
        int j = i;
        if (i < 1)
        {
            j = 10;
        }
        maxConnections = j;
        ConnManagerParams.setMaxConnectionsPerRoute(httpClient.getParams(), new ConnPerRouteBean(maxConnections));
    }

    public void setMaxRetriesAndTimeout(int i, int j)
    {
        httpClient.setHttpRequestRetryHandler(new RetryHandler(i, j));
    }

    public void setProxy(String s, int i)
    {
        s = new HttpHost(s, i);
        httpClient.getParams().setParameter("http.route.default-proxy", s);
    }

    public void setProxy(String s, int i, String s1, String s2)
    {
        httpClient.getCredentialsProvider().setCredentials(new AuthScope(s, i), new UsernamePasswordCredentials(s1, s2));
        s = new HttpHost(s, i);
        httpClient.getParams().setParameter("http.route.default-proxy", s);
    }

    public void setRedirectHandler(RedirectHandler redirecthandler)
    {
        httpClient.setRedirectHandler(redirecthandler);
    }

    public void setResponseTimeout(int i)
    {
        int j = i;
        if (i < 1000)
        {
            j = 10000;
        }
        responseTimeout = j;
        HttpConnectionParams.setSoTimeout(httpClient.getParams(), responseTimeout);
    }

    public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sslsocketfactory, 443));
    }

    public void setThreadPool(ExecutorService executorservice)
    {
        threadPool = executorservice;
    }

    public void setTimeout(int i)
    {
        int j = i;
        if (i < 1000)
        {
            j = 10000;
        }
        setConnectTimeout(j);
        setResponseTimeout(j);
    }

    public void setURLEncodingEnabled(boolean flag)
    {
        isUrlEncodingEnabled = flag;
    }

    public void setUserAgent(String s)
    {
        HttpProtocolParams.setUserAgent(httpClient.getParams(), s);
    }



}
