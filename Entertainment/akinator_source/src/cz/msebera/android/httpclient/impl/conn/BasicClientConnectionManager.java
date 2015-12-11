// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            SchemeRegistryFactory, HttpPoolEntry, DefaultClientConnectionOperator, ManagedClientConnectionImpl

public class BasicClientConnectionManager
    implements ClientConnectionManager
{

    private static final AtomicLong COUNTER = new AtomicLong();
    public static final String MISUSE_MESSAGE = "Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
    private ManagedClientConnectionImpl conn;
    private final ClientConnectionOperator connOperator;
    public HttpClientAndroidLog log;
    private HttpPoolEntry poolEntry;
    private final SchemeRegistry schemeRegistry;
    private volatile boolean shutdown;

    public BasicClientConnectionManager()
    {
        this(SchemeRegistryFactory.createDefault());
    }

    public BasicClientConnectionManager(SchemeRegistry schemeregistry)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(schemeregistry, "Scheme registry");
        schemeRegistry = schemeregistry;
        connOperator = createConnectionOperator(schemeregistry);
    }

    private void assertNotShutdown()
    {
        boolean flag;
        if (!shutdown)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Connection manager has been shut down");
    }

    private void shutdownConnection(HttpClientConnection httpclientconnection)
    {
        httpclientconnection.shutdown();
_L1:
        return;
        httpclientconnection;
        if (log.isDebugEnabled())
        {
            log.debug("I/O exception shutting down connection", httpclientconnection);
            return;
        }
          goto _L1
    }

    public void closeExpiredConnections()
    {
        this;
        JVM INSTR monitorenter ;
        assertNotShutdown();
        long l = System.currentTimeMillis();
        if (poolEntry != null && poolEntry.isExpired(l))
        {
            poolEntry.close();
            poolEntry.getTracker().reset();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void closeIdleConnections(long l, TimeUnit timeunit)
    {
        Args.notNull(timeunit, "Time unit");
        this;
        JVM INSTR monitorenter ;
        long l1;
        assertNotShutdown();
        l1 = timeunit.toMillis(l);
        l = l1;
        if (l1 < 0L)
        {
            l = 0L;
        }
        long l2 = System.currentTimeMillis();
        if (poolEntry != null && poolEntry.getUpdated() <= l2 - l)
        {
            poolEntry.close();
            poolEntry.getTracker().reset();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        timeunit;
        this;
        JVM INSTR monitorexit ;
        throw timeunit;
    }

    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeregistry)
    {
        return new DefaultClientConnectionOperator(schemeregistry);
    }

    protected void finalize()
        throws Throwable
    {
        shutdown();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    ManagedClientConnection getConnection(HttpRoute httproute, Object obj)
    {
        Args.notNull(httproute, "Route");
        this;
        JVM INSTR monitorenter ;
        assertNotShutdown();
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Get connection for route ").append(httproute).toString());
        }
        long l;
        boolean flag;
        if (conn == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.");
        if (poolEntry != null && !poolEntry.getPlannedRoute().equals(httproute))
        {
            poolEntry.close();
            poolEntry = null;
        }
        if (poolEntry == null)
        {
            obj = Long.toString(COUNTER.getAndIncrement());
            cz.msebera.android.httpclient.conn.OperatedClientConnection operatedclientconnection = connOperator.createConnection();
            poolEntry = new HttpPoolEntry(log, ((String) (obj)), httproute, operatedclientconnection, 0L, TimeUnit.MILLISECONDS);
        }
        l = System.currentTimeMillis();
        if (poolEntry.isExpired(l))
        {
            poolEntry.close();
            poolEntry.getTracker().reset();
        }
        conn = new ManagedClientConnectionImpl(this, connOperator, poolEntry);
        httproute = conn;
        this;
        JVM INSTR monitorexit ;
        return httproute;
        httproute;
        this;
        JVM INSTR monitorexit ;
        throw httproute;
    }

    public SchemeRegistry getSchemeRegistry()
    {
        return schemeRegistry;
    }

    public void releaseConnection(ManagedClientConnection managedclientconnection, long l, TimeUnit timeunit)
    {
label0:
        {
            Args.check(managedclientconnection instanceof ManagedClientConnectionImpl, "Connection class mismatch, connection not obtained from this manager");
            synchronized ((ManagedClientConnectionImpl)managedclientconnection)
            {
                if (log.isDebugEnabled())
                {
                    log.debug((new StringBuilder()).append("Releasing connection ").append(managedclientconnection).toString());
                }
                if (managedclientconnectionimpl.getPoolEntry() != null)
                {
                    break label0;
                }
            }
            return;
        }
        boolean flag;
        if (managedclientconnectionimpl.getManager() == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Connection not obtained from this manager");
        this;
        JVM INSTR monitorenter ;
        if (!shutdown)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        shutdownConnection(managedclientconnectionimpl);
        this;
        JVM INSTR monitorexit ;
        managedclientconnectionimpl;
        JVM INSTR monitorexit ;
        return;
        managedclientconnection;
        managedclientconnectionimpl;
        JVM INSTR monitorexit ;
        throw managedclientconnection;
        if (managedclientconnectionimpl.isOpen() && !managedclientconnectionimpl.isMarkedReusable())
        {
            shutdownConnection(managedclientconnectionimpl);
        }
        if (!managedclientconnectionimpl.isMarkedReusable()) goto _L2; else goto _L1
_L1:
        HttpPoolEntry httppoolentry = poolEntry;
        if (timeunit == null) goto _L4; else goto _L3
_L3:
        managedclientconnection = timeunit;
_L8:
        httppoolentry.updateExpiry(l, managedclientconnection);
        if (!log.isDebugEnabled()) goto _L2; else goto _L5
_L5:
        if (l <= 0L) goto _L7; else goto _L6
_L6:
        managedclientconnection = (new StringBuilder()).append("for ").append(l).append(" ").append(timeunit).toString();
_L9:
        log.debug((new StringBuilder()).append("Connection can be kept alive ").append(managedclientconnection).toString());
_L2:
        managedclientconnectionimpl.detach();
        conn = null;
        if (poolEntry.isClosed())
        {
            poolEntry = null;
        }
        this;
        JVM INSTR monitorexit ;
        managedclientconnectionimpl;
        JVM INSTR monitorexit ;
        return;
_L4:
        managedclientconnection = TimeUnit.MILLISECONDS;
          goto _L8
_L7:
        managedclientconnection = "indefinitely";
          goto _L9
        managedclientconnection;
        managedclientconnectionimpl.detach();
        conn = null;
        if (poolEntry.isClosed())
        {
            poolEntry = null;
        }
        throw managedclientconnection;
        managedclientconnection;
        this;
        JVM INSTR monitorexit ;
        throw managedclientconnection;
          goto _L8
    }

    public final ClientConnectionRequest requestConnection(final HttpRoute route, final Object state)
    {
        return new ClientConnectionRequest() {

            final BasicClientConnectionManager this$0;
            final HttpRoute val$route;
            final Object val$state;

            public void abortRequest()
            {
            }

            public ManagedClientConnection getConnection(long l, TimeUnit timeunit)
            {
                return BasicClientConnectionManager.this.getConnection(route, state);
            }

            
            {
                this$0 = BasicClientConnectionManager.this;
                route = httproute;
                state = obj;
                super();
            }
        };
    }

    public void shutdown()
    {
        this;
        JVM INSTR monitorenter ;
        shutdown = true;
        if (poolEntry != null)
        {
            poolEntry.close();
        }
        poolEntry = null;
        conn = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        poolEntry = null;
        conn = null;
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
