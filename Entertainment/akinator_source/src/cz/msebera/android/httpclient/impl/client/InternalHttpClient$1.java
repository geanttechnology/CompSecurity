// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            InternalHttpClient

class this._cls0
    implements ClientConnectionManager
{

    final InternalHttpClient this$0;

    public void closeExpiredConnections()
    {
        InternalHttpClient.access$000(InternalHttpClient.this).closeExpiredConnections();
    }

    public void closeIdleConnections(long l, TimeUnit timeunit)
    {
        InternalHttpClient.access$000(InternalHttpClient.this).closeIdleConnections(l, timeunit);
    }

    public SchemeRegistry getSchemeRegistry()
    {
        throw new UnsupportedOperationException();
    }

    public void releaseConnection(ManagedClientConnection managedclientconnection, long l, TimeUnit timeunit)
    {
        throw new UnsupportedOperationException();
    }

    public ClientConnectionRequest requestConnection(HttpRoute httproute, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public void shutdown()
    {
        InternalHttpClient.access$000(InternalHttpClient.this).shutdown();
    }

    ()
    {
        this$0 = InternalHttpClient.this;
        super();
    }
}
