// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.util.IdleConnectionHandler;
import org.apache.commons.logging.Log;

// Referenced classes of package org.apache.commons.httpclient:
//            MultiThreadedHttpConnectionManager, HttpConnection, HostConfiguration

private class <init>
{

    private LinkedList freeConnections;
    private IdleConnectionHandler idleConnectionHandler;
    private final Map mapHosts;
    private int numConnections;
    private final MultiThreadedHttpConnectionManager this$0;
    private LinkedList waitingThreads;

    private void deleteConnection(HttpConnection httpconnection)
    {
        this;
        JVM INSTR monitorenter ;
        HostConfiguration hostconfiguration = MultiThreadedHttpConnectionManager.access$1100(MultiThreadedHttpConnectionManager.this, httpconnection);
        if (MultiThreadedHttpConnectionManager.access$700().isDebugEnabled())
        {
            MultiThreadedHttpConnectionManager.access$700().debug("Reclaiming connection, hostConfig=" + hostconfiguration);
        }
        httpconnection.close();
        ool ool = getHostPool(hostconfiguration, true);
        ool.freeConnections.remove(httpconnection);
        ool.numConnections = ool.numConnections - 1;
        numConnections = numConnections - 1;
        if (ool.numConnections == 0 && ool.waitingThreads.isEmpty())
        {
            mapHosts.remove(hostconfiguration);
        }
        idleConnectionHandler.remove(httpconnection);
        this;
        JVM INSTR monitorexit ;
        return;
        httpconnection;
        throw httpconnection;
    }

    public void closeIdleConnections(long l)
    {
        this;
        JVM INSTR monitorenter ;
        idleConnectionHandler.closeIdleConnections(l);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public HttpConnection createConnection(HostConfiguration hostconfiguration)
    {
        this;
        JVM INSTR monitorenter ;
        ithReference ithreference;
        ool ool = getHostPool(hostconfiguration, true);
        if (MultiThreadedHttpConnectionManager.access$700().isDebugEnabled())
        {
            MultiThreadedHttpConnectionManager.access$700().debug("Allocating new connection, hostConfig=" + hostconfiguration);
        }
        ithreference = new ithReference(hostconfiguration);
        ithreference.getParams().setDefaults(MultiThreadedHttpConnectionManager.access$800(MultiThreadedHttpConnectionManager.this));
        ithreference.setHttpConnectionManager(MultiThreadedHttpConnectionManager.this);
        numConnections = numConnections + 1;
        ool.numConnections = ool.numConnections + 1;
        MultiThreadedHttpConnectionManager.access$900(ithreference, hostconfiguration, this);
        this;
        JVM INSTR monitorexit ;
        return ithreference;
        hostconfiguration;
        throw hostconfiguration;
    }

    public void deleteClosedConnections()
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = freeConnections.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            HttpConnection httpconnection = (HttpConnection)iterator.next();
            if (!httpconnection.isOpen())
            {
                iterator.remove();
                deleteConnection(httpconnection);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_55;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void deleteLeastUsedConnection()
    {
        this;
        JVM INSTR monitorenter ;
        HttpConnection httpconnection = (HttpConnection)freeConnections.removeFirst();
        if (httpconnection == null) goto _L2; else goto _L1
_L1:
        deleteConnection(httpconnection);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (MultiThreadedHttpConnectionManager.access$700().isDebugEnabled())
        {
            MultiThreadedHttpConnectionManager.access$700().debug("Attempted to reclaim an unused connection but there were none.");
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void freeConnection(HttpConnection httpconnection)
    {
        HostConfiguration hostconfiguration;
        hostconfiguration = MultiThreadedHttpConnectionManager.access$1100(MultiThreadedHttpConnectionManager.this, httpconnection);
        if (MultiThreadedHttpConnectionManager.access$700().isDebugEnabled())
        {
            MultiThreadedHttpConnectionManager.access$700().debug("Freeing connection, hostConfig=" + hostconfiguration);
        }
        this;
        JVM INSTR monitorenter ;
        if (!MultiThreadedHttpConnectionManager.access$1200(MultiThreadedHttpConnectionManager.this))
        {
            break MISSING_BLOCK_LABEL_66;
        }
        httpconnection.close();
        this;
        JVM INSTR monitorexit ;
        return;
        ool ool = getHostPool(hostconfiguration, true);
        ool.freeConnections.add(httpconnection);
        if (ool.numConnections == 0)
        {
            MultiThreadedHttpConnectionManager.access$700().error("Host connection pool not found, hostConfig=" + hostconfiguration);
            ool.numConnections = 1;
        }
        freeConnections.add(httpconnection);
        MultiThreadedHttpConnectionManager.access$1300((ithReference)httpconnection);
        if (numConnections == 0)
        {
            MultiThreadedHttpConnectionManager.access$700().error("Host connection pool not found, hostConfig=" + hostconfiguration);
            numConnections = 1;
        }
        idleConnectionHandler.add(httpconnection);
        notifyWaitingThread(ool);
        this;
        JVM INSTR monitorexit ;
        return;
        httpconnection;
        this;
        JVM INSTR monitorexit ;
        throw httpconnection;
    }

    public HttpConnection getFreeConnection(HostConfiguration hostconfiguration)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1 = null;
        Object obj = getHostPool(hostconfiguration, false);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((ool) (obj)).freeConnections.size() <= 0) goto _L2; else goto _L3
_L3:
        obj = (ithReference)((ool) (obj)).freeConnections.removeLast();
        freeConnections.remove(obj);
        MultiThreadedHttpConnectionManager.access$900(((ithReference) (obj)), hostconfiguration, this);
        if (MultiThreadedHttpConnectionManager.access$700().isDebugEnabled())
        {
            MultiThreadedHttpConnectionManager.access$700().debug("Getting free connection, hostConfig=" + hostconfiguration);
        }
        idleConnectionHandler.remove(((HttpConnection) (obj)));
_L5:
        this;
        JVM INSTR monitorexit ;
        return ((HttpConnection) (obj));
_L2:
        obj = obj1;
        if (!MultiThreadedHttpConnectionManager.access$700().isDebugEnabled())
        {
            continue; /* Loop/switch isn't completed */
        }
        MultiThreadedHttpConnectionManager.access$700().debug("There were no free connections to get, hostConfig=" + hostconfiguration);
        obj = obj1;
        if (true) goto _L5; else goto _L4
_L4:
        hostconfiguration;
        throw hostconfiguration;
    }

    public ool getHostPool(HostConfiguration hostconfiguration, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        ool ool1;
        MultiThreadedHttpConnectionManager.access$700().trace("enter HttpConnectionManager.ConnectionPool.getHostPool(HostConfiguration)");
        ool1 = (ool)mapHosts.get(hostconfiguration);
        ool ool;
        ool = ool1;
        if (ool1 != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ool = ool1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ool = new ool(null);
        ool.hostConfiguration = hostconfiguration;
        mapHosts.put(hostconfiguration, ool);
        this;
        JVM INSTR monitorexit ;
        return ool;
        hostconfiguration;
        throw hostconfiguration;
    }

    public void handleLostConnection(HostConfiguration hostconfiguration)
    {
        this;
        JVM INSTR monitorenter ;
        ool ool = getHostPool(hostconfiguration, true);
        ool.numConnections = ool.numConnections - 1;
        if (ool.numConnections == 0 && ool.waitingThreads.isEmpty())
        {
            mapHosts.remove(hostconfiguration);
        }
        numConnections = numConnections - 1;
        notifyWaitingThread(hostconfiguration);
        this;
        JVM INSTR monitorexit ;
        return;
        hostconfiguration;
        throw hostconfiguration;
    }

    public void notifyWaitingThread(HostConfiguration hostconfiguration)
    {
        this;
        JVM INSTR monitorenter ;
        notifyWaitingThread(getHostPool(hostconfiguration, true));
        this;
        JVM INSTR monitorexit ;
        return;
        hostconfiguration;
        throw hostconfiguration;
    }

    public void notifyWaitingThread(ool ool)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = null;
        if (ool.waitingThreads.size() <= 0) goto _L2; else goto _L1
_L1:
        if (MultiThreadedHttpConnectionManager.access$700().isDebugEnabled())
        {
            MultiThreadedHttpConnectionManager.access$700().debug("Notifying thread waiting on host pool, hostConfig=" + ool.hostConfiguration);
        }
        ool = (ool.hostConfiguration)ool.waitingThreads.removeFirst();
        waitingThreads.remove(ool);
_L4:
        if (ool == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        ool.nterruptedByConnectionPool = true;
        ((nterruptedByConnectionPool) (ool)).hread.interrupt();
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (waitingThreads.size() > 0)
        {
            if (MultiThreadedHttpConnectionManager.access$700().isDebugEnabled())
            {
                MultiThreadedHttpConnectionManager.access$700().debug("No-one waiting on host pool, notifying next waiting thread.");
            }
            ool = (waitingThreads)waitingThreads.removeFirst();
            ((waitingThreads) (ool)).ostConnectionPool.waitingThreads.remove(ool);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_157;
        ool;
        throw ool;
        ool = obj;
        if (!MultiThreadedHttpConnectionManager.access$700().isDebugEnabled())
        {
            continue; /* Loop/switch isn't completed */
        }
        MultiThreadedHttpConnectionManager.access$700().debug("Notifying no-one, there are no waiting threads");
        ool = obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void shutdown()
    {
        this;
        JVM INSTR monitorenter ;
        HttpConnection httpconnection;
        for (Iterator iterator = freeConnections.iterator(); iterator.hasNext(); httpconnection.close())
        {
            httpconnection = (HttpConnection)iterator.next();
            iterator.remove();
        }

        break MISSING_BLOCK_LABEL_47;
        Exception exception;
        exception;
        throw exception;
        MultiThreadedHttpConnectionManager.access$600(this);
        ool.waitingThreads waitingthreads;
        for (Iterator iterator1 = waitingThreads.iterator(); iterator1.hasNext(); waitingthreads.hread.interrupt())
        {
            waitingthreads = (hread)iterator1.next();
            iterator1.remove();
            waitingthreads.nterruptedByConnectionPool = true;
        }

        mapHosts.clear();
        idleConnectionHandler.removeAll();
        this;
        JVM INSTR monitorexit ;
    }




    private ool()
    {
        this$0 = MultiThreadedHttpConnectionManager.this;
        freeConnections = new LinkedList();
        waitingThreads = new LinkedList();
        mapHosts = new HashMap();
        idleConnectionHandler = new IdleConnectionHandler();
        numConnections = 0;
    }

    numConnections(numConnections numconnections)
    {
        this();
    }
}
