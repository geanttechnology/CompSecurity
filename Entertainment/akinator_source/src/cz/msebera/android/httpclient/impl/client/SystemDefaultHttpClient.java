// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.NoConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.conn.PoolingClientConnectionManager;
import cz.msebera.android.httpclient.impl.conn.ProxySelectorRoutePlanner;
import cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import cz.msebera.android.httpclient.params.HttpParams;
import java.net.ProxySelector;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            DefaultHttpClient

public class SystemDefaultHttpClient extends DefaultHttpClient
{

    public SystemDefaultHttpClient()
    {
        super(null, null);
    }

    public SystemDefaultHttpClient(HttpParams httpparams)
    {
        super(null, httpparams);
    }

    protected ClientConnectionManager createClientConnectionManager()
    {
        PoolingClientConnectionManager poolingclientconnectionmanager = new PoolingClientConnectionManager(SchemeRegistryFactory.createSystemDefault());
        if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true")))
        {
            int i = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
            poolingclientconnectionmanager.setDefaultMaxPerRoute(i);
            poolingclientconnectionmanager.setMaxTotal(i * 2);
        }
        return poolingclientconnectionmanager;
    }

    protected ConnectionReuseStrategy createConnectionReuseStrategy()
    {
        if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true")))
        {
            return new DefaultConnectionReuseStrategy();
        } else
        {
            return new NoConnectionReuseStrategy();
        }
    }

    protected HttpRoutePlanner createHttpRoutePlanner()
    {
        return new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), ProxySelector.getDefault());
    }
}
