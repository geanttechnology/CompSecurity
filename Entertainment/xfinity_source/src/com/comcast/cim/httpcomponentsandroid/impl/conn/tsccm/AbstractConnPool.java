// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm;

import com.comcast.cim.httpcomponentsandroid.conn.OperatedClientConnection;
import com.comcast.cim.httpcomponentsandroid.impl.conn.IdleConnectionHandler;
import java.io.IOException;
import java.lang.ref.Reference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm:
//            RefQueueHandler, BasicPoolEntry

public abstract class AbstractConnPool
    implements RefQueueHandler
{

    protected IdleConnectionHandler idleConnHandler;
    protected volatile boolean isShutDown;
    protected Set leasedConnections;
    private final Log log = LogFactory.getLog(getClass());
    protected final Lock poolLock = new ReentrantLock();

    protected AbstractConnPool()
    {
        leasedConnections = new HashSet();
        idleConnHandler = new IdleConnectionHandler();
    }

    protected void closeConnection(OperatedClientConnection operatedclientconnection)
    {
        if (operatedclientconnection == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        operatedclientconnection.close();
        return;
        operatedclientconnection;
        log.debug("I/O error closing connection", operatedclientconnection);
        return;
    }

    public void handleReference(Reference reference)
    {
    }

    public void shutdown()
    {
        poolLock.lock();
        boolean flag = isShutDown;
        if (flag)
        {
            poolLock.unlock();
            return;
        }
        BasicPoolEntry basicpoolentry;
        for (Iterator iterator = leasedConnections.iterator(); iterator.hasNext(); closeConnection(basicpoolentry.getConnection()))
        {
            basicpoolentry = (BasicPoolEntry)iterator.next();
            iterator.remove();
        }

        break MISSING_BLOCK_LABEL_86;
        Exception exception;
        exception;
        poolLock.unlock();
        throw exception;
        idleConnHandler.removeAll();
        isShutDown = true;
        poolLock.unlock();
        return;
    }
}
