// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.d;

import android.content.Context;
import com.facebook.ads.a.c.f;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.f.h;
import com.facebook.ads.a.f.p;
import com.facebook.ads.a.f.q;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
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
import org.apache.http.protocol.HttpContext;

public final class com.facebook.ads.a.d.a
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


    public static final ThreadPoolExecutor a;
    private static final p e;
    public final DefaultHttpClient b;
    public final Map c = new WeakHashMap();
    public Context d;
    private final Map f = new HashMap();

    public com.facebook.ads.a.d.a(Context context, com.facebook.ads.a.f f1)
    {
        d = context;
        BasicHttpParams basichttpparams = new BasicHttpParams();
        basichttpparams.setParameter("http.protocol.cookie-policy", "compatibility");
        ConnManagerParams.setTimeout(basichttpparams, 10000L);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(100));
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 100);
        HttpConnectionParams.setSoTimeout(basichttpparams, 10000);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 10000);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpProtocolParams.setUserAgent(basichttpparams, (new StringBuilder()).append(h.a(context, f1)).append(" [FBAN/AudienceNetworkForAndroid;FBSN/Android;FBSV/").append(f.a).append(";FBAB/").append(f.d).append(";FBAV/").append(f.f).append(";FBBV/").append(f.g).append(";FBLC/").append(Locale.getDefault().toString()).append("]").toString());
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        context = new SchemeRegistry();
        context.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (g.a())
        {
            try
            {
                f1 = KeyStore.getInstance(KeyStore.getDefaultType());
                f1.load(null, null);
                f1 = new q(f1);
                f1.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
                context.register(new Scheme("https", f1, 443));
            }
            // Misplaced declaration of an exception variable
            catch (com.facebook.ads.a.f f1) { }
        } else
        {
            context.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        b = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, context), basichttpparams);
        b.addRequestInterceptor(new HttpRequestInterceptor() {

            final com.facebook.ads.a.d.a a;

            public final void process(HttpRequest httprequest, HttpContext httpcontext)
            {
                if (!httprequest.containsHeader("Accept-Encoding"))
                {
                    httprequest.addHeader("Accept-Encoding", "gzip");
                }
                String s;
                for (httpcontext = com.facebook.ads.a.d.a.a(a).keySet().iterator(); httpcontext.hasNext(); httprequest.addHeader(s, (String)com.facebook.ads.a.d.a.a(a).get(s)))
                {
                    s = (String)httpcontext.next();
                }

            }

            
            {
                a = com.facebook.ads.a.d.a.this;
                super();
            }
        });
        b.addResponseInterceptor(new HttpResponseInterceptor() {

            final com.facebook.ads.a.d.a a;

            public final void process(HttpResponse httpresponse, HttpContext httpcontext)
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
                a = com.facebook.ads.a.d.a.this;
                super();
            }
        });
    }

    static Map a(com.facebook.ads.a.d.a a1)
    {
        return a1.f;
    }

    static 
    {
        p p1 = new p();
        e = p1;
        a = (ThreadPoolExecutor)Executors.newCachedThreadPool(p1);
    }
}
