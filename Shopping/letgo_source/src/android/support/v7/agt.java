// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
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

// Referenced classes of package android.support.v7:
//            agy, agx, agu, agv

public class agt
{
    private static class a extends HttpEntityWrapper
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

        public a(HttpEntity httpentity)
        {
            super(httpentity);
        }
    }


    private static int a = 10;
    private static int b = 10000;
    private final DefaultHttpClient c;
    private final HttpContext d = new SyncBasicHttpContext(new BasicHttpContext());
    private ThreadPoolExecutor e;
    private final Map f = new WeakHashMap();
    private final Map g = new HashMap();

    public agt()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basichttpparams, b);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(a));
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 10);
        HttpConnectionParams.setSoTimeout(basichttpparams, b);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, b);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basichttpparams, String.format("android-async-http/%s (http://loopj.com/android-async-http)", new Object[] {
            "1.4.3"
        }));
        Object obj = new SchemeRegistry();
        ((SchemeRegistry) (obj)).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        ((SchemeRegistry) (obj)).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        obj = new ThreadSafeClientConnManager(basichttpparams, ((SchemeRegistry) (obj)));
        c = new DefaultHttpClient(((org.apache.http.conn.ClientConnectionManager) (obj)), basichttpparams);
        c.addRequestInterceptor(new HttpRequestInterceptor() {

            final agt a;

            public void process(HttpRequest httprequest, HttpContext httpcontext)
            {
                if (!httprequest.containsHeader("Accept-Encoding"))
                {
                    httprequest.addHeader("Accept-Encoding", "gzip");
                }
                String s;
                for (httpcontext = agt.a(a).keySet().iterator(); httpcontext.hasNext(); httprequest.addHeader(s, (String)agt.a(a).get(s)))
                {
                    s = (String)httpcontext.next();
                }

            }

            
            {
                a = agt.this;
                super();
            }
        });
        c.addResponseInterceptor(new HttpResponseInterceptor() {

            final agt a;

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
                            httpresponse.setEntity(new a(httpresponse.getEntity()));
                            return;
                        }
                        i++;
                    }
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                a = agt.this;
                super();
            }
        });
        c.setHttpRequestRetryHandler(new agy(5));
        e = (ThreadPoolExecutor)Executors.newCachedThreadPool();
    }

    static Map a(agt agt1)
    {
        return agt1.g;
    }

    private HttpEntity a(agx agx1)
    {
        HttpEntity httpentity = null;
        if (agx1 != null)
        {
            httpentity = agx1.b();
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

    public void a(int i)
    {
        org.apache.http.params.HttpParams httpparams = c.getParams();
        ConnManagerParams.setTimeout(httpparams, i);
        HttpConnectionParams.setSoTimeout(httpparams, i);
        HttpConnectionParams.setConnectionTimeout(httpparams, i);
    }

    public void a(Context context, String s, agx agx1, agv agv)
    {
        a(context, s, a(agx1), null, agv);
    }

    public void a(Context context, String s, HttpEntity httpentity, String s1, agv agv)
    {
        a(c, d, ((HttpUriRequest) (a(((HttpEntityEnclosingRequestBase) (new HttpPost(s))), httpentity))), s1, agv, context);
    }

    public void a(Context context, String s, Header aheader[], agx agx1, String s1, agv agv)
    {
        s = new HttpPost(s);
        if (agx1 != null)
        {
            s.setEntity(a(agx1));
        }
        if (aheader != null)
        {
            s.setHeaders(aheader);
        }
        a(c, d, ((HttpUriRequest) (s)), s1, agv, context);
    }

    public void a(String s, agx agx1, agv agv)
    {
        a(null, s, agx1, agv);
    }

    protected void a(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s, agv agv, Context context)
    {
        if (s != null)
        {
            httpurirequest.addHeader("Content-Type", s);
        }
        httpurirequest = e.submit(new agu(defaulthttpclient, httpcontext, httpurirequest, agv));
        if (context != null)
        {
            httpcontext = (List)f.get(context);
            defaulthttpclient = httpcontext;
            if (httpcontext == null)
            {
                defaulthttpclient = new LinkedList();
                f.put(context, defaulthttpclient);
            }
            defaulthttpclient.add(new WeakReference(httpurirequest));
        }
    }

}
