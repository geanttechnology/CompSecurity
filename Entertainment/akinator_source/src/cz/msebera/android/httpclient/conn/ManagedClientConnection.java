// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;

// Referenced classes of package cz.msebera.android.httpclient.conn:
//            HttpRoutedConnection, ManagedHttpClientConnection, ConnectionReleaseTrigger

public interface ManagedClientConnection
    extends HttpClientConnection, HttpRoutedConnection, ManagedHttpClientConnection, ConnectionReleaseTrigger
{

    public abstract HttpRoute getRoute();

    public abstract SSLSession getSSLSession();

    public abstract Object getState();

    public abstract boolean isMarkedReusable();

    public abstract boolean isSecure();

    public abstract void layerProtocol(HttpContext httpcontext, HttpParams httpparams)
        throws IOException;

    public abstract void markReusable();

    public abstract void open(HttpRoute httproute, HttpContext httpcontext, HttpParams httpparams)
        throws IOException;

    public abstract void setIdleDuration(long l, TimeUnit timeunit);

    public abstract void setState(Object obj);

    public abstract void tunnelProxy(HttpHost httphost, boolean flag, HttpParams httpparams)
        throws IOException;

    public abstract void tunnelTarget(boolean flag, HttpParams httpparams)
        throws IOException;

    public abstract void unmarkReusable();
}
