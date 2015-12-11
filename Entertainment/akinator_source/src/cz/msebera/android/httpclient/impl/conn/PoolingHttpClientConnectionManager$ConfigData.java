// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.SocketConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            PoolingHttpClientConnectionManager

static class 
{

    private final Map connectionConfigMap = new ConcurrentHashMap();
    private volatile ConnectionConfig defaultConnectionConfig;
    private volatile SocketConfig defaultSocketConfig;
    private final Map socketConfigMap = new ConcurrentHashMap();

    public ConnectionConfig getConnectionConfig(HttpHost httphost)
    {
        return (ConnectionConfig)connectionConfigMap.get(httphost);
    }

    public ConnectionConfig getDefaultConnectionConfig()
    {
        return defaultConnectionConfig;
    }

    public SocketConfig getDefaultSocketConfig()
    {
        return defaultSocketConfig;
    }

    public SocketConfig getSocketConfig(HttpHost httphost)
    {
        return (SocketConfig)socketConfigMap.get(httphost);
    }

    public void setConnectionConfig(HttpHost httphost, ConnectionConfig connectionconfig)
    {
        connectionConfigMap.put(httphost, connectionconfig);
    }

    public void setDefaultConnectionConfig(ConnectionConfig connectionconfig)
    {
        defaultConnectionConfig = connectionconfig;
    }

    public void setDefaultSocketConfig(SocketConfig socketconfig)
    {
        defaultSocketConfig = socketconfig;
    }

    public void setSocketConfig(HttpHost httphost, SocketConfig socketconfig)
    {
        socketConfigMap.put(httphost, socketconfig);
    }

    ()
    {
    }
}
