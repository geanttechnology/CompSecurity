// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import android.content.Context;
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
import org.apache.http.Header;
import org.apache.http.HttpEntity;
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
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

// Referenced classes of package com.a.a.a:
//            b, c, k, e, 
//            f

public class a
{

    private static final String a = "1.4.1";
    private static final int b = 100;
    private static final int c = 10000;
    private static final int d = 8192;
    private static final String e = "Accept-Encoding";
    private static final String f = "gzip";
    private static int g = 100;
    private static int h = 10000;
    private final DefaultHttpClient i;
    private final HttpContext j = new SyncBasicHttpContext(new BasicHttpContext());
    private ThreadPoolExecutor k;
    private final Map l = new WeakHashMap();
    private final Map m = new HashMap();

    public a()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        basichttpparams.setParameter("http.protocol.cookie-policy", "netscape");
        ConnManagerParams.setTimeout(basichttpparams, h);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(g));
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 100);
        HttpConnectionParams.setSoTimeout(basichttpparams, h);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, h);
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
        i = new DefaultHttpClient(((ClientConnectionManager) (obj)), basichttpparams);
        i.addRequestInterceptor(new b(this));
        i.addResponseInterceptor(new c(this));
        k = (ThreadPoolExecutor)Executors.newCachedThreadPool();
    }

    public static String a(String s, k k1)
    {
label0:
        {
            String s1 = s;
            if (k1 != null)
            {
                k1 = k1.c();
                if (s.indexOf("?") != -1)
                {
                    break label0;
                }
                s1 = (new StringBuilder(String.valueOf(s))).append("?").append(k1).toString();
            }
            return s1;
        }
        return (new StringBuilder(String.valueOf(s))).append("&").append(k1).toString();
    }

    static Map a(a a1)
    {
        return a1.m;
    }

    private HttpEntity a(k k1)
    {
        HttpEntity httpentity = null;
        if (k1 != null)
        {
            httpentity = k1.a();
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

    public HttpClient a()
    {
        return i;
    }

    public void a(int i1)
    {
        org.apache.http.params.HttpParams httpparams = i.getParams();
        ConnManagerParams.setTimeout(httpparams, i1);
        HttpConnectionParams.setSoTimeout(httpparams, i1);
        HttpConnectionParams.setConnectionTimeout(httpparams, i1);
    }

    public void a(Context context, String s, f f1)
    {
        a(context, s, ((k) (null)), f1);
    }

    public void a(Context context, String s, k k1, f f1)
    {
        a(i, j, ((HttpUriRequest) (new HttpGet(a(s, k1)))), ((String) (null)), f1, context);
    }

    public void a(Context context, String s, HttpEntity httpentity, String s1, f f1)
    {
        a(i, j, ((HttpUriRequest) (a(((HttpEntityEnclosingRequestBase) (new HttpPost(s))), httpentity))), s1, f1, context);
    }

    public void a(Context context, String s, Header aheader[], f f1)
    {
        s = new HttpDelete(s);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        a(i, j, ((HttpUriRequest) (s)), ((String) (null)), f1, context);
    }

    public void a(Context context, String s, Header aheader[], k k1, f f1)
    {
        s = new HttpGet(a(s, k1));
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        a(i, j, ((HttpUriRequest) (s)), ((String) (null)), f1, context);
    }

    public void a(Context context, String s, Header aheader[], k k1, String s1, f f1)
    {
        s = new HttpPost(s);
        if (k1 != null)
        {
            s.setEntity(a(k1));
        }
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        a(i, j, ((HttpUriRequest) (s)), s1, f1, context);
    }

    public void a(Context context, String s, Header aheader[], HttpEntity httpentity, String s1, f f1)
    {
        s = a(((HttpEntityEnclosingRequestBase) (new HttpPost(s))), httpentity);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        a(i, j, ((HttpUriRequest) (s)), s1, f1, context);
    }

    public void a(Context context, boolean flag)
    {
        Object obj = (List)l.get(context);
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((List) (obj)).iterator();
_L5:
        if (((Iterator) (obj)).hasNext()) goto _L3; else goto _L2
_L2:
        l.remove(context);
        return;
_L3:
        Future future = (Future)((WeakReference)((Iterator) (obj)).next()).get();
        if (future != null)
        {
            future.cancel(flag);
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a(String s)
    {
        HttpProtocolParams.setUserAgent(i.getParams(), s);
    }

    public void a(String s, f f1)
    {
        a(null, s, ((k) (null)), f1);
    }

    public void a(String s, k k1, f f1)
    {
        a(null, s, k1, f1);
    }

    public void a(String s, String s1)
    {
        m.put(s, s1);
    }

    public void a(String s, String s1, AuthScope authscope)
    {
        s = new UsernamePasswordCredentials(s, s1);
        i.getCredentialsProvider().setCredentials(authscope, s);
    }

    public void a(ThreadPoolExecutor threadpoolexecutor)
    {
        k = threadpoolexecutor;
    }

    public void a(CookieStore cookiestore)
    {
        j.setAttribute("http.cookie-store", cookiestore);
    }

    public void a(SSLSocketFactory sslsocketfactory)
    {
        i.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sslsocketfactory, 443));
    }

    protected void a(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s, f f1, Context context)
    {
        if (s != null)
        {
            httpurirequest.addHeader("Content-Type", s);
        }
        httpurirequest = k.submit(new e(defaulthttpclient, httpcontext, httpurirequest, f1));
        if (context != null)
        {
            httpcontext = (List)l.get(context);
            defaulthttpclient = httpcontext;
            if (httpcontext == null)
            {
                defaulthttpclient = new LinkedList();
                l.put(context, defaulthttpclient);
            }
            defaulthttpclient.add(new WeakReference(httpurirequest));
        }
    }

    public HttpContext b()
    {
        return j;
    }

    public void b(Context context, String s, f f1)
    {
        s = new HttpDelete(s);
        a(i, j, s, ((String) (null)), f1, context);
    }

    public void b(Context context, String s, k k1, f f1)
    {
        a(context, s, a(k1), ((String) (null)), f1);
    }

    public void b(Context context, String s, HttpEntity httpentity, String s1, f f1)
    {
        a(i, j, a(new HttpPut(s), httpentity), s1, f1, context);
    }

    public void b(Context context, String s, Header aheader[], HttpEntity httpentity, String s1, f f1)
    {
        s = a(new HttpPut(s), httpentity);
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        a(i, j, s, s1, f1, context);
    }

    public void b(String s, f f1)
    {
        b(null, s, null, f1);
    }

    public void b(String s, k k1, f f1)
    {
        b(null, s, k1, f1);
    }

    public void b(String s, String s1)
    {
        a(s, s1, AuthScope.ANY);
    }

    public void c(Context context, String s, k k1, f f1)
    {
        b(context, s, a(k1), null, f1);
    }

    public void c(String s, f f1)
    {
        c(null, s, null, f1);
    }

    public void c(String s, k k1, f f1)
    {
        c(null, s, k1, f1);
    }

    public void d(String s, f f1)
    {
        b(((Context) (null)), s, f1);
    }

}
