// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class HttpPoolEntry extends PoolEntry
{

    public HttpClientAndroidLog log;
    private final RouteTracker tracker;

    public HttpPoolEntry(HttpClientAndroidLog httpclientandroidlog, String s, HttpRoute httproute, OperatedClientConnection operatedclientconnection, long l, TimeUnit timeunit)
    {
        super(s, httproute, operatedclientconnection, l, timeunit);
        log = httpclientandroidlog;
        tracker = new RouteTracker(httproute);
    }

    public void close()
    {
        OperatedClientConnection operatedclientconnection = (OperatedClientConnection)getConnection();
        try
        {
            operatedclientconnection.close();
            return;
        }
        catch (IOException ioexception)
        {
            log.debug("I/O error closing connection", ioexception);
        }
    }

    HttpRoute getEffectiveRoute()
    {
        return tracker.toRoute();
    }

    HttpRoute getPlannedRoute()
    {
        return (HttpRoute)getRoute();
    }

    RouteTracker getTracker()
    {
        return tracker;
    }

    public boolean isClosed()
    {
        return !((OperatedClientConnection)getConnection()).isOpen();
    }

    public boolean isExpired(long l)
    {
        boolean flag = super.isExpired(l);
        if (flag && log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Connection ").append(this).append(" expired @ ").append(new Date(getExpiry())).toString());
        }
        return flag;
    }
}
