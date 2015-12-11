// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.util.Log;
import com.github.ignition.support.IgnitedDiagnostics;
import com.github.ignition.support.http.ssl.EasySSLSocketFactory;
import java.util.HashMap;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class IgnitedHttp
{

    static final String LOG_TAG = com/github/ignition/support/http/IgnitedHttp.getSimpleName();
    private HashMap defaultHeaders;
    private AbstractHttpClient httpClient;

    public IgnitedHttp()
    {
        defaultHeaders = new HashMap();
        setupHttpClient();
    }

    protected void setupHttpClient()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basichttpparams, 30000L);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(4));
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 4);
        HttpConnectionParams.setSoTimeout(basichttpparams, 30000);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basichttpparams, "Android/Ignition");
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (IgnitedDiagnostics.ANDROID_API_LEVEL >= 7)
        {
            schemeregistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        } else
        {
            schemeregistry.register(new Scheme("https", new EasySSLSocketFactory(), 443));
        }
        httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
    }

    public void updateProxySettings(Context context)
    {
        if (context != null)
        {
            HttpParams httpparams = httpClient.getParams();
            NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkinfo != null)
            {
                Log.i(LOG_TAG, networkinfo.toString());
                if (networkinfo.getType() == 0)
                {
                    String s1 = Proxy.getHost(context);
                    String s = s1;
                    if (s1 == null)
                    {
                        s = Proxy.getDefaultHost();
                    }
                    int j = Proxy.getPort(context);
                    int i = j;
                    if (j == -1)
                    {
                        i = Proxy.getDefaultPort();
                    }
                    if (s != null && i > -1)
                    {
                        httpparams.setParameter("http.route.default-proxy", new HttpHost(s, i));
                        return;
                    } else
                    {
                        httpparams.setParameter("http.route.default-proxy", null);
                        return;
                    }
                } else
                {
                    httpparams.setParameter("http.route.default-proxy", null);
                    return;
                }
            }
        }
    }

}
