// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.conn.HttpConnectionFactory;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.pool.ConnFactory;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            PoolingHttpClientConnectionManager, ManagedHttpClientConnectionFactory

static class connFactory
    implements ConnFactory
{

    private final create configData;
    private final HttpConnectionFactory connFactory;

    public ManagedHttpClientConnection create(HttpRoute httproute)
        throws IOException
    {
        ConnectionConfig connectionconfig1 = null;
        if (httproute.getProxyHost() != null)
        {
            connectionconfig1 = configData.nfig(httproute.getProxyHost());
        }
        ConnectionConfig connectionconfig = connectionconfig1;
        if (connectionconfig1 == null)
        {
            connectionconfig = configData.nfig(httproute.getTargetHost());
        }
        connectionconfig1 = connectionconfig;
        if (connectionconfig == null)
        {
            connectionconfig1 = configData.ctionConfig();
        }
        connectionconfig = connectionconfig1;
        if (connectionconfig1 == null)
        {
            connectionconfig = ConnectionConfig.DEFAULT;
        }
        return (ManagedHttpClientConnection)connFactory.create(httproute, connectionconfig);
    }

    public volatile Object create(Object obj)
        throws IOException
    {
        return create((HttpRoute)obj);
    }

    ( , HttpConnectionFactory httpconnectionfactory)
    {
        if ( == null)
        {
             = new ();
        }
        configData = ;
        if (httpconnectionfactory == null)
        {
            httpconnectionfactory = ManagedHttpClientConnectionFactory.INSTANCE;
        }
        connFactory = httpconnectionfactory;
    }
}
