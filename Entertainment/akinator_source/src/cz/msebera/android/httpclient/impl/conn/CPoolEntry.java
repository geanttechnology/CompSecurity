// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class CPoolEntry extends PoolEntry
{

    public HttpClientAndroidLog log;
    private volatile boolean routeComplete;

    public CPoolEntry(HttpClientAndroidLog httpclientandroidlog, String s, HttpRoute httproute, ManagedHttpClientConnection managedhttpclientconnection, long l, TimeUnit timeunit)
    {
        super(s, httproute, managedhttpclientconnection, l, timeunit);
        log = httpclientandroidlog;
    }

    public void close()
    {
        try
        {
            closeConnection();
            return;
        }
        catch (IOException ioexception)
        {
            log.debug("I/O error closing connection", ioexception);
        }
    }

    public void closeConnection()
        throws IOException
    {
        ((HttpClientConnection)getConnection()).close();
    }

    public boolean isClosed()
    {
        return !((HttpClientConnection)getConnection()).isOpen();
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

    public boolean isRouteComplete()
    {
        return routeComplete;
    }

    public void markRouteComplete()
    {
        routeComplete = true;
    }

    public void shutdownConnection()
        throws IOException
    {
        ((HttpClientConnection)getConnection()).shutdown();
    }
}
