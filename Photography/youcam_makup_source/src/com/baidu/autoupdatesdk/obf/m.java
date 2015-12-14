// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
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
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            s, r, n, o

public class m
{

    private static final String a = "1.3.1";
    private static final int b = 15;
    private static final int c = 15000;
    private static final int d = 1;
    private static final int e = 8192;
    private static final String f = "Accept-Encoding";
    private static final String g = "gzip";
    private static int h = 15;
    private static int i = 15000;
    private final DefaultHttpClient j;
    private final HttpContext k = new SyncBasicHttpContext(new BasicHttpContext());
    private ThreadPoolExecutor l;
    private final Map m = new WeakHashMap();
    private final Map n = new HashMap();

    public m()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basichttpparams, i);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(h));
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 15);
        HttpConnectionParams.setSoTimeout(basichttpparams, i);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, i);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basichttpparams, String.format("android-async-http/%s (http://loopj.com/android-async-http)", new Object[] {
            "1.3.1"
        }));
        HttpProtocolParams.setUseExpectContinue(basichttpparams, false);
        Object obj = new SchemeRegistry();
        ((SchemeRegistry) (obj)).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        obj = new ThreadSafeClientConnManager(basichttpparams, ((SchemeRegistry) (obj)));
        j = new DefaultHttpClient(((ClientConnectionManager) (obj)), basichttpparams);
        j.addRequestInterceptor(new HttpRequestInterceptor() {

            final m a;

            public void process(HttpRequest httprequest, HttpContext httpcontext)
            {
                if (!httprequest.containsHeader("Accept-Encoding"))
                {
                    httprequest.addHeader("Accept-Encoding", "gzip");
                }
                String s1;
                for (httpcontext = m.a(a).keySet().iterator(); httpcontext.hasNext(); httprequest.addHeader(s1, (String)m.a(a).get(s1)))
                {
                    s1 = (String)httpcontext.next();
                }

            }

            
            {
                a = m.this;
                super();
            }
        });
        j.addResponseInterceptor(new HttpResponseInterceptor() {

            final m a;

            public void process(HttpResponse httpresponse, HttpContext httpcontext)
            {
                httpcontext = httpresponse.getEntity().getContentEncoding();
                if (httpcontext == null) goto _L2; else goto _L1
_L1:
                int i1;
                int j1;
                httpcontext = httpcontext.getElements();
                j1 = httpcontext.length;
                i1 = 0;
_L7:
                if (i1 >= j1) goto _L2; else goto _L3
_L3:
                if (!httpcontext[i1].getName().equalsIgnoreCase("gzip")) goto _L5; else goto _L4
_L4:
                httpresponse.setEntity(new a(httpresponse.getEntity()));
_L2:
                return;
_L5:
                i1++;
                if (true) goto _L7; else goto _L6
_L6:
            }

            
            {
                a = m.this;
                super();
            }

            private class a extends HttpEntityWrapper
            {

                public InputStream getContent()
                {
                    return new GZIPInputStream(wrappedEntity.getContent());
                }

                public long getContentLength()
                {
                    return -1L;
                }

                public a(HttpEntity httpentity)
                {
                    super(httpentity);
                }
            }

        });
        j.setHttpRequestRetryHandler(new s(1));
        l = (ThreadPoolExecutor)Executors.newCachedThreadPool(new ThreadFactory() {

            final m a;
            private final AtomicInteger b = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                runnable = new Thread(runnable, (new StringBuilder()).append("AsyncHttpClient #").append(b.getAndIncrement()).toString());
                if (runnable.isDaemon())
                {
                    runnable.setDaemon(false);
                }
                if (runnable.getPriority() != 4)
                {
                    runnable.setPriority(4);
                }
                return runnable;
            }

            
            {
                a = m.this;
                super();
            }
        });
    }

    private String a(String s1, r r1)
    {
        String s2 = s1;
        if (r1 != null)
        {
            r1 = r1.c();
            s2 = (new StringBuilder()).append(s1).append("?").append(r1).toString();
        }
        return s2;
    }

    static Map a(m m1)
    {
        return m1.n;
    }

    private Future a(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s1, o o, Context context)
    {
        if (s1 != null)
        {
            httpurirequest.addHeader("Content-Type", s1);
        }
        httpurirequest = l.submit(new n(defaulthttpclient, httpcontext, httpurirequest, o));
        if (context != null)
        {
            httpcontext = (List)m.get(context);
            defaulthttpclient = httpcontext;
            if (httpcontext == null)
            {
                defaulthttpclient = new LinkedList();
                m.put(context, defaulthttpclient);
            }
            defaulthttpclient.add(new WeakReference(httpurirequest));
        }
        return httpurirequest;
    }

    private HttpEntity a(r r1)
    {
        HttpEntity httpentity = null;
        if (r1 != null)
        {
            httpentity = r1.a();
        }
        return httpentity;
    }

    private HttpEntityEnclosingRequestBase a(HttpEntityEnclosingRequestBase httpentityenclosingrequestbase, HttpEntity httpentity)
    {
        if (httpentity != null)
        {
            httpentityenclosingrequestbase.setEntity(httpentity);
        }
        return httpentityenclosingrequestbase;
    }

    public WeakReference a(Context context, String s1, o o)
    {
        return a(context, s1, null, o);
    }

    public WeakReference a(Context context, String s1, r r1, o o)
    {
        return new WeakReference(a(j, k, ((HttpUriRequest) (new HttpGet(a(s1, r1)))), null, o, context));
    }

    public WeakReference a(Context context, String s1, r r1, Map map, o o)
    {
        s1 = new HttpGet(a(s1, r1));
        if (map != null)
        {
            for (r1 = map.entrySet().iterator(); r1.hasNext(); s1.addHeader((String)map.getKey(), (String)map.getValue()))
            {
                map = (java.util.Map.Entry)r1.next();
            }

        }
        return new WeakReference(a(j, k, ((HttpUriRequest) (s1)), null, o, context));
    }

    public WeakReference a(Context context, String s1, HttpEntity httpentity, String s2, o o)
    {
        return new WeakReference(a(j, k, ((HttpUriRequest) (a(((HttpEntityEnclosingRequestBase) (new HttpPost(s1))), httpentity))), s2, o, context));
    }

    public WeakReference a(String s1, o o)
    {
        return a(null, s1, null, o);
    }

    public WeakReference a(String s1, r r1, o o)
    {
        return a(null, s1, r1, o);
    }

    public HttpClient a()
    {
        return j;
    }

    public void a(Context context, boolean flag)
    {
        Object obj = (List)m.get(context);
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
        m.remove(context);
    }

    public void a(String s1)
    {
        HttpProtocolParams.setUserAgent(j.getParams(), s1);
    }

    public void a(String s1, String s2)
    {
        n.put(s1, s2);
    }

    public void a(ThreadPoolExecutor threadpoolexecutor)
    {
        l = threadpoolexecutor;
    }

    public void a(CookieStore cookiestore)
    {
        k.setAttribute("http.cookie-store", cookiestore);
    }

    public void a(SSLSocketFactory sslsocketfactory)
    {
        j.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sslsocketfactory, 443));
    }

    public WeakReference b(Context context, String s1, o o)
    {
        s1 = new HttpDelete(s1);
        return new WeakReference(a(j, k, s1, null, o, context));
    }

    public WeakReference b(Context context, String s1, r r1, o o)
    {
        return a(context, s1, a(r1), ((String) (null)), o);
    }

    public WeakReference b(Context context, String s1, HttpEntity httpentity, String s2, o o)
    {
        return new WeakReference(a(j, k, a(new HttpPut(s1), httpentity), s2, o, context));
    }

    public WeakReference b(String s1, o o)
    {
        return b(null, s1, null, o);
    }

    public WeakReference b(String s1, r r1, o o)
    {
        return b(null, s1, r1, o);
    }

    public WeakReference c(Context context, String s1, r r1, o o)
    {
        return b(context, s1, a(r1), null, o);
    }

    public WeakReference c(String s1, o o)
    {
        return c(null, s1, null, o);
    }

    public WeakReference c(String s1, r r1, o o)
    {
        return c(null, s1, r1, o);
    }

    public WeakReference d(String s1, o o)
    {
        return b(((Context) (null)), s1, o);
    }

}
