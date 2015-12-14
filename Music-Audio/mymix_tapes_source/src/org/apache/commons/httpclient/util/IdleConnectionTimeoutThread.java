// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.httpclient.HttpConnectionManager;

public class IdleConnectionTimeoutThread extends Thread
{

    private List connectionManagers;
    private long connectionTimeout;
    private boolean shutdown;
    private long timeoutInterval;

    public IdleConnectionTimeoutThread()
    {
        connectionManagers = new ArrayList();
        shutdown = false;
        timeoutInterval = 1000L;
        connectionTimeout = 3000L;
        setDaemon(true);
    }

    public void addConnectionManager(HttpConnectionManager httpconnectionmanager)
    {
        this;
        JVM INSTR monitorenter ;
        if (shutdown)
        {
            throw new IllegalStateException("IdleConnectionTimeoutThread has been shutdown");
        }
        break MISSING_BLOCK_LABEL_24;
        httpconnectionmanager;
        this;
        JVM INSTR monitorexit ;
        throw httpconnectionmanager;
        connectionManagers.add(httpconnectionmanager);
        this;
        JVM INSTR monitorexit ;
    }

    protected void handleCloseIdleConnections(HttpConnectionManager httpconnectionmanager)
    {
        httpconnectionmanager.closeIdleConnections(connectionTimeout);
    }

    public void removeConnectionManager(HttpConnectionManager httpconnectionmanager)
    {
        this;
        JVM INSTR monitorenter ;
        if (shutdown)
        {
            throw new IllegalStateException("IdleConnectionTimeoutThread has been shutdown");
        }
        break MISSING_BLOCK_LABEL_24;
        httpconnectionmanager;
        this;
        JVM INSTR monitorexit ;
        throw httpconnectionmanager;
        connectionManagers.remove(httpconnectionmanager);
        this;
        JVM INSTR monitorexit ;
    }

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
_L2:
        Exception exception;
        if (shutdown)
        {
            break; /* Loop/switch isn't completed */
        }
        for (Iterator iterator = connectionManagers.iterator(); iterator.hasNext(); handleCloseIdleConnections((HttpConnectionManager)iterator.next())) { }
        if (true)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        JVM INSTR monitorexit ;
        throw exception;
        try
        {
            wait(timeoutInterval);
        }
        catch (InterruptedException interruptedexception) { }
        finally
        {
            this;
        }
        if (true) goto _L2; else goto _L1
_L1:
        connectionManagers.clear();
        this;
        JVM INSTR monitorexit ;
    }

    public void setConnectionTimeout(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (shutdown)
        {
            throw new IllegalStateException("IdleConnectionTimeoutThread has been shutdown");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        connectionTimeout = l;
        this;
        JVM INSTR monitorexit ;
    }

    public void setTimeoutInterval(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (shutdown)
        {
            throw new IllegalStateException("IdleConnectionTimeoutThread has been shutdown");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        timeoutInterval = l;
        this;
        JVM INSTR monitorexit ;
    }

    public void shutdown()
    {
        this;
        JVM INSTR monitorenter ;
        shutdown = true;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
