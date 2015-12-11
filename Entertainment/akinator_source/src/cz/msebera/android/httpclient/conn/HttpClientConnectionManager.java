// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.conn:
//            ConnectionRequest

public interface HttpClientConnectionManager
{

    public abstract void closeExpiredConnections();

    public abstract void closeIdleConnections(long l, TimeUnit timeunit);

    public abstract void connect(HttpClientConnection httpclientconnection, HttpRoute httproute, int i, HttpContext httpcontext)
        throws IOException;

    public abstract void releaseConnection(HttpClientConnection httpclientconnection, Object obj, long l, TimeUnit timeunit);

    public abstract ConnectionRequest requestConnection(HttpRoute httproute, Object obj);

    public abstract void routeComplete(HttpClientConnection httpclientconnection, HttpRoute httproute, HttpContext httpcontext)
        throws IOException;

    public abstract void shutdown();

    public abstract void upgrade(HttpClientConnection httpclientconnection, HttpRoute httproute, HttpContext httpcontext)
        throws IOException;
}
