// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp:
//            Connection, Route, Address

public final class ConnectionPool
{

    private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 0x493e0L;
    private static final int MAX_CONNECTIONS_TO_CLEANUP = 2;
    private static final ConnectionPool systemDefault;
    private final LinkedList connections = new LinkedList();
    private final Runnable connectionsCleanupRunnable = new Runnable() {

        final ConnectionPool this$0;

        public void run()
        {
            ArrayList arraylist;
            int j;
            arraylist = new ArrayList(2);
            j = 0;
            Object obj = ConnectionPool.this;
            obj;
            JVM INSTR monitorenter ;
            ListIterator listiterator = connections.listIterator(connections.size());
_L5:
            if (!listiterator.hasPrevious()) goto _L2; else goto _L1
_L1:
            Connection connection = (Connection)listiterator.previous();
            if (connection.isAlive() && !connection.isExpired(keepAliveDurationNs)) goto _L4; else goto _L3
_L3:
            listiterator.remove();
            arraylist.add(connection);
            if (arraylist.size() != 2) goto _L5; else goto _L2
_L2:
            listiterator = connections.listIterator(connections.size());
_L6:
            do
            {
                if (!listiterator.hasPrevious() || j <= maxIdleConnections)
                {
                    break MISSING_BLOCK_LABEL_210;
                }
                connection = (Connection)listiterator.previous();
            } while (!connection.isIdle());
            arraylist.add(connection);
            listiterator.remove();
            j--;
              goto _L6
_L4:
            if (!connection.isIdle()) goto _L5; else goto _L7
_L7:
            j++;
              goto _L5
            obj;
            JVM INSTR monitorexit ;
            for (obj = arraylist.iterator(); ((Iterator) (obj)).hasNext(); Util.closeQuietly(((Connection)((Iterator) (obj)).next()).getSocket())) { }
            break MISSING_BLOCK_LABEL_251;
            Exception exception;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                this$0 = ConnectionPool.this;
                super();
            }
    };
    private final ExecutorService executorService;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    public ConnectionPool(int i, long l)
    {
        executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
        maxIdleConnections = i;
        keepAliveDurationNs = l * 1000L * 1000L;
    }

    public static ConnectionPool getDefault()
    {
        return systemDefault;
    }

    private void waitForCleanupCallableToRun()
    {
        try
        {
            executorService.submit(new Runnable() {

                final ConnectionPool this$0;

                public void run()
                {
                }

            
            {
                this$0 = ConnectionPool.this;
                super();
            }
            }).get();
            return;
        }
        catch (Exception exception)
        {
            throw new AssertionError();
        }
    }

    public void evictAll()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = new ArrayList(connections);
        connections.clear();
        this;
        JVM INSTR monitorexit ;
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            Util.closeQuietly(((Connection)arraylist.get(i)).getSocket());
        }

        break MISSING_BLOCK_LABEL_65;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Connection get(Address address)
    {
        this;
        JVM INSTR monitorenter ;
        ListIterator listiterator = connections.listIterator(connections.size());
_L1:
        Connection connection;
        boolean flag;
        do
        {
            if (!listiterator.hasPrevious())
            {
                break MISSING_BLOCK_LABEL_185;
            }
            connection = (Connection)listiterator.previous();
        } while (!connection.getRoute().getAddress().equals(address) || !connection.isAlive() || System.nanoTime() - connection.getIdleStartTimeNs() >= keepAliveDurationNs);
        listiterator.remove();
        flag = connection.isSpdy();
        Object obj;
        obj = connection;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        Platform.get().tagSocket(connection.getSocket());
        for (obj = connection; obj == null; obj = null)
        {
            break MISSING_BLOCK_LABEL_127;
        }

        if (((Connection) (obj)).isSpdy())
        {
            connections.addFirst(obj);
        }
        executorService.execute(connectionsCleanupRunnable);
        this;
        JVM INSTR monitorexit ;
        return ((Connection) (obj));
        obj;
        Util.closeQuietly(connection.getSocket());
        Platform.get().logW((new StringBuilder()).append("Unable to tagSocket(): ").append(obj).toString());
          goto _L1
        address;
        throw address;
    }

    public int getConnectionCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = connections.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    List getConnections()
    {
        waitForCleanupCallableToRun();
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(connections);
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getHttpConnectionCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
        Iterator iterator = connections.iterator();
_L1:
        boolean flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_45;
        }
        flag = ((Connection)iterator.next()).isSpdy();
        if (!flag)
        {
            i++;
        }
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getSpdyConnectionCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
        Iterator iterator = connections.iterator();
_L1:
        boolean flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_45;
        }
        flag = ((Connection)iterator.next()).isSpdy();
        if (flag)
        {
            i++;
        }
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    void recycle(Connection connection)
    {
        while (connection.isSpdy() || !connection.clearOwner()) 
        {
            return;
        }
        if (!connection.isAlive())
        {
            Util.closeQuietly(connection.getSocket());
            return;
        }
        try
        {
            Platform.get().untagSocket(connection.getSocket());
        }
        catch (SocketException socketexception)
        {
            Platform.get().logW((new StringBuilder()).append("Unable to untagSocket(): ").append(socketexception).toString());
            Util.closeQuietly(connection.getSocket());
            return;
        }
        this;
        JVM INSTR monitorenter ;
        connections.addFirst(connection);
        connection.incrementRecycleCount();
        connection.resetIdleStartTime();
        this;
        JVM INSTR monitorexit ;
        executorService.execute(connectionsCleanupRunnable);
        return;
        connection;
        this;
        JVM INSTR monitorexit ;
        throw connection;
    }

    void share(Connection connection)
    {
        if (!connection.isSpdy())
        {
            throw new IllegalArgumentException();
        }
        executorService.execute(connectionsCleanupRunnable);
        if (!connection.isAlive())
        {
            break MISSING_BLOCK_LABEL_53;
        }
        this;
        JVM INSTR monitorenter ;
        connections.addFirst(connection);
        this;
        JVM INSTR monitorexit ;
        return;
        connection;
        this;
        JVM INSTR monitorexit ;
        throw connection;
    }

    static 
    {
        String s = System.getProperty("http.keepAlive");
        String s1 = System.getProperty("http.keepAliveDuration");
        String s2 = System.getProperty("http.maxConnections");
        long l;
        if (s1 != null)
        {
            l = Long.parseLong(s1);
        } else
        {
            l = 0x493e0L;
        }
        if (s != null && !Boolean.parseBoolean(s))
        {
            systemDefault = new ConnectionPool(0, l);
        } else
        if (s2 != null)
        {
            systemDefault = new ConnectionPool(Integer.parseInt(s2), l);
        } else
        {
            systemDefault = new ConnectionPool(5, l);
        }
    }



}
