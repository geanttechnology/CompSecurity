// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d.a;

import com.google.api.a.d.v;
import com.google.api.a.d.y;
import java.net.ProxySelector;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

// Referenced classes of package com.google.api.a.d.a:
//            a, e

public final class c extends v
{

    private final HttpClient b;

    public c()
    {
        Object obj = SSLSocketFactory.getSocketFactory();
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basichttpparams, false);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 200);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(20));
        ProxySelector proxyselector = ProxySelector.getDefault();
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeregistry.register(new Scheme("https", ((org.apache.http.conn.scheme.SocketFactory) (obj)), 443));
        obj = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
        ((DefaultHttpClient) (obj)).setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        if (proxyselector != null)
        {
            ((DefaultHttpClient) (obj)).setRoutePlanner(new ProxySelectorRoutePlanner(schemeregistry, proxyselector));
        }
        this(((HttpClient) (obj)));
    }

    private c(HttpClient httpclient)
    {
        b = httpclient;
        httpclient = httpclient.getParams();
        HttpProtocolParams.setVersion(httpclient, HttpVersion.HTTP_1_1);
        httpclient.setBooleanParameter("http.protocol.handle-redirects", false);
    }

    protected final y a(String s, String s1)
    {
        if (s.equals("DELETE"))
        {
            s = new HttpDelete(s1);
        } else
        if (s.equals("GET"))
        {
            s = new HttpGet(s1);
        } else
        if (s.equals("HEAD"))
        {
            s = new HttpHead(s1);
        } else
        if (s.equals("POST"))
        {
            s = new HttpPost(s1);
        } else
        if (s.equals("PUT"))
        {
            s = new HttpPut(s1);
        } else
        if (s.equals("TRACE"))
        {
            s = new HttpTrace(s1);
        } else
        if (s.equals("OPTIONS"))
        {
            s = new HttpOptions(s1);
        } else
        {
            s = new e(s, s1);
        }
        return new a(b, s);
    }

    public final boolean a(String s)
    {
        return true;
    }
}
