// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public class am
{

    private static WeakReference a;

    public am()
    {
    }

    public static HttpClient a()
    {
        Object obj = new BasicHttpParams();
        ConnManagerParams.setTimeout(((HttpParams) (obj)), 15000L);
        ConnManagerParams.setMaxConnectionsPerRoute(((HttpParams) (obj)), new ConnPerRoute() {

            public int getMaxForRoute(HttpRoute httproute)
            {
                return 5;
            }

        });
        HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj)), 15000);
        HttpConnectionParams.setSoTimeout(((HttpParams) (obj)), 15000);
        HttpClientParams.setRedirecting(((HttpParams) (obj)), true);
        HttpClientParams.setCookiePolicy(((HttpParams) (obj)), "compatibility");
        HttpProtocolParams.setUseExpectContinue(((HttpParams) (obj)), false);
        HttpConnectionParams.setSocketBufferSize(((HttpParams) (obj)), 8192);
        HttpConnectionParams.setTcpNoDelay(((HttpParams) (obj)), true);
        HttpConnectionParams.setStaleCheckingEnabled(((HttpParams) (obj)), true);
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        obj = new DefaultHttpClient(new ThreadSafeClientConnManager(((HttpParams) (obj)), schemeregistry), ((HttpParams) (obj)));
        ((DefaultHttpClient) (obj)).setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy() {

            public long getKeepAliveDuration(HttpResponse httpresponse, HttpContext httpcontext)
            {
                long l1 = super.getKeepAliveDuration(httpresponse, httpcontext);
                long l = l1;
                if (l1 == -1L)
                {
                    l = 30000L;
                }
                return l;
            }

        });
        return ((HttpClient) (obj));
    }

    public static void a(Context context, HttpClient httpclient)
    {
        context = d(context);
        httpclient = httpclient.getParams();
        if (c(context))
        {
            httpclient.setParameter("http.route.default-proxy", new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort()));
            return;
        } else
        {
            httpclient.removeParameter("http.route.default-proxy");
            return;
        }
    }

    public static boolean a(Context context)
    {
        context = (ConnectivityManager)d(context).getSystemService("connectivity");
        if (context == null)
        {
            return false;
        }
        context = context.getActiveNetworkInfo();
        return context != null && context.isAvailable();
    }

    public static String b()
    {
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
_L2:
        Enumeration enumeration1;
        if (!enumeration.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_73;
        }
        enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
_L4:
        if (!enumeration1.hasMoreElements()) goto _L2; else goto _L1
_L1:
        Object obj = (InetAddress)enumeration1.nextElement();
        if (((InetAddress) (obj)).isLoopbackAddress()) goto _L4; else goto _L3
_L3:
        boolean flag;
        obj = ((InetAddress) (obj)).getHostAddress();
        flag = InetAddressUtils.isIPv4Address(((String) (obj)));
        if (!flag) goto _L4; else goto _L5
_L5:
        return ((String) (obj));
        SocketException socketexception;
        socketexception;
        socketexception.printStackTrace();
        return null;
    }

    public static boolean b(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(1);
        return context.isAvailable() && context.isConnected();
    }

    private static boolean c(Context context)
    {
        if (context == null)
        {
            return false;
        }
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            return false;
        }
        context = context.getActiveNetworkInfo();
        if (context == null || context.getType() == 1)
        {
            return false;
        }
        return context.getType() == 0 && !TextUtils.isEmpty(Proxy.getDefaultHost()) && Proxy.getDefaultPort() != -1;
    }

    private static Context d(Context context)
    {
        if (context != null)
        {
            a = new WeakReference(context.getApplicationContext());
        } else
        if (a != null)
        {
            return (Context)a.get();
        }
        return context;
    }
}
