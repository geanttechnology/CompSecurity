// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.concurrent.Cancellable;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

class ConnectionHolder
    implements ConnectionReleaseTrigger, Cancellable, Closeable
{

    public HttpClientAndroidLog log;
    private final HttpClientConnection managedConn;
    private final HttpClientConnectionManager manager;
    private volatile boolean released;
    private volatile boolean reusable;
    private volatile Object state;
    private volatile TimeUnit tunit;
    private volatile long validDuration;

    public ConnectionHolder(HttpClientAndroidLog httpclientandroidlog, HttpClientConnectionManager httpclientconnectionmanager, HttpClientConnection httpclientconnection)
    {
        log = httpclientandroidlog;
        manager = httpclientconnectionmanager;
        managedConn = httpclientconnection;
    }

    public void abortConnection()
    {
label0:
        {
            synchronized (managedConn)
            {
                if (!released)
                {
                    break label0;
                }
            }
            return;
        }
        released = true;
        managedConn.shutdown();
        log.debug("Connection discarded");
        manager.releaseConnection(managedConn, null, 0L, TimeUnit.MILLISECONDS);
_L1:
        httpclientconnection;
        JVM INSTR monitorexit ;
        return;
        exception;
        httpclientconnection;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj;
        obj;
        if (log.isDebugEnabled())
        {
            log.debug(((IOException) (obj)).getMessage(), ((Throwable) (obj)));
        }
        manager.releaseConnection(managedConn, null, 0L, TimeUnit.MILLISECONDS);
          goto _L1
        obj;
        manager.releaseConnection(managedConn, null, 0L, TimeUnit.MILLISECONDS);
        throw obj;
    }

    public boolean cancel()
    {
        boolean flag = released;
        log.debug("Cancelling request execution");
        abortConnection();
        return !flag;
    }

    public void close()
        throws IOException
    {
        abortConnection();
    }

    public boolean isReleased()
    {
        return released;
    }

    public boolean isReusable()
    {
        return reusable;
    }

    public void markNonReusable()
    {
        reusable = false;
    }

    public void markReusable()
    {
        reusable = true;
    }

    public void releaseConnection()
    {
label0:
        {
            synchronized (managedConn)
            {
                if (!released)
                {
                    break label0;
                }
            }
            return;
        }
        released = true;
        if (!reusable) goto _L2; else goto _L1
_L1:
        manager.releaseConnection(managedConn, state, validDuration, tunit);
_L3:
        httpclientconnection;
        JVM INSTR monitorexit ;
        return;
        exception;
        httpclientconnection;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        managedConn.close();
        log.debug("Connection discarded");
        manager.releaseConnection(managedConn, null, 0L, TimeUnit.MILLISECONDS);
          goto _L3
        Object obj;
        obj;
        if (log.isDebugEnabled())
        {
            log.debug(((IOException) (obj)).getMessage(), ((Throwable) (obj)));
        }
        manager.releaseConnection(managedConn, null, 0L, TimeUnit.MILLISECONDS);
          goto _L3
        obj;
        manager.releaseConnection(managedConn, null, 0L, TimeUnit.MILLISECONDS);
        throw obj;
    }

    public void setState(Object obj)
    {
        state = obj;
    }

    public void setValidFor(long l, TimeUnit timeunit)
    {
        synchronized (managedConn)
        {
            validDuration = l;
            tunit = timeunit;
        }
        return;
        timeunit;
        httpclientconnection;
        JVM INSTR monitorexit ;
        throw timeunit;
    }
}
