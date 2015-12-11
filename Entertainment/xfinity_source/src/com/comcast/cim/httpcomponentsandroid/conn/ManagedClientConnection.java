// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn;

import com.comcast.cim.httpcomponentsandroid.HttpClientConnection;
import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.conn:
//            ConnectionReleaseTrigger, HttpRoutedConnection

public interface ManagedClientConnection
    extends HttpClientConnection, ConnectionReleaseTrigger, HttpRoutedConnection
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
}
