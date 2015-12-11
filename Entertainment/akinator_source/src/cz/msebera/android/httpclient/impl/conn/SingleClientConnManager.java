// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            SchemeRegistryFactory, DefaultClientConnectionOperator, AbstractPooledConnAdapter, AbstractPoolEntry

public class SingleClientConnManager
    implements ClientConnectionManager
{
    protected class ConnAdapter extends AbstractPooledConnAdapter
    {

        final SingleClientConnManager this$0;

        protected ConnAdapter(PoolEntry poolentry, HttpRoute httproute)
        {
            this$0 = SingleClientConnManager.this;
            super(SingleClientConnManager.this, poolentry);
            markReusable();
            poolentry.route = httproute;
        }
    }

    protected class PoolEntry extends AbstractPoolEntry
    {

        final SingleClientConnManager this$0;

        protected void close()
            throws IOException
        {
            shutdownEntry();
            if (connection.isOpen())
            {
                connection.close();
            }
        }

        protected void shutdown()
            throws IOException
        {
            shutdownEntry();
            if (connection.isOpen())
            {
                connection.shutdown();
            }
        }

        protected PoolEntry()
        {
            this$0 = SingleClientConnManager.this;
            super(connOperator, null);
        }
    }


    public static final String MISUSE_MESSAGE = "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
    protected final boolean alwaysShutDown;
    protected final ClientConnectionOperator connOperator;
    protected volatile long connectionExpiresTime;
    protected volatile boolean isShutDown;
    protected volatile long lastReleaseTime;
    public HttpClientAndroidLog log;
    protected volatile ConnAdapter managedConn;
    protected final SchemeRegistry schemeRegistry;
    protected volatile PoolEntry uniquePoolEntry;

    public SingleClientConnManager()
    {
        this(SchemeRegistryFactory.createDefault());
    }

    public SingleClientConnManager(SchemeRegistry schemeregistry)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(schemeregistry, "Scheme registry");
        schemeRegistry = schemeregistry;
        connOperator = createConnectionOperator(schemeregistry);
        uniquePoolEntry = new PoolEntry();
        managedConn = null;
        lastReleaseTime = -1L;
        alwaysShutDown = false;
        isShutDown = false;
    }

    public SingleClientConnManager(HttpParams httpparams, SchemeRegistry schemeregistry)
    {
        this(schemeregistry);
    }

    protected final void assertStillUp()
        throws IllegalStateException
    {
        boolean flag;
        if (!isShutDown)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Manager is shut down");
    }

    public void closeExpiredConnections()
    {
        long l = connectionExpiresTime;
        if (System.currentTimeMillis() >= l)
        {
            closeIdleConnections(0L, TimeUnit.MILLISECONDS);
        }
    }

    public void closeIdleConnections(long l, TimeUnit timeunit)
    {
        assertStillUp();
        Args.notNull(timeunit, "Time unit");
        this;
        JVM INSTR monitorenter ;
        long l1;
        long l2;
        if (managedConn != null || !uniquePoolEntry.connection.isOpen())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        l1 = System.currentTimeMillis();
        l = timeunit.toMillis(l);
        l2 = lastReleaseTime;
        if (l2 > l1 - l)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        uniquePoolEntry.close();
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        timeunit;
        log.debug("Problem closing idle connection.", timeunit);
          goto _L1
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

    public ManagedClientConnection getConnection(HttpRoute httproute, Object obj)
    {
        Args.notNull(httproute, "Route");
        assertStillUp();
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Get connection for route ").append(httproute).toString());
        }
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (managedConn == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        Asserts.check(flag2, "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.");
        flag = false;
        flag1 = false;
        closeExpiredConnections();
        if (!uniquePoolEntry.connection.isOpen()) goto _L2; else goto _L1
_L1:
        obj = uniquePoolEntry.tracker;
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag2 = ((RouteTracker) (obj)).toRoute().equals(httproute);
        if (flag2) goto _L5; else goto _L4
_L4:
        flag1 = true;
_L9:
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        flag = true;
        uniquePoolEntry.shutdown();
_L7:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        uniquePoolEntry = new PoolEntry();
        managedConn = new ConnAdapter(uniquePoolEntry, httproute);
        httproute = managedConn;
        this;
        JVM INSTR monitorexit ;
        return httproute;
        obj;
        log.debug("Problem shutting down connection.", ((Throwable) (obj)));
        if (true) goto _L7; else goto _L6
_L6:
        httproute;
        this;
        JVM INSTR monitorexit ;
        throw httproute;
_L5:
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L2:
        flag = true;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public SchemeRegistry getSchemeRegistry()
    {
        return schemeRegistry;
    }

    public void releaseConnection(ManagedClientConnection managedclientconnection, long l, TimeUnit timeunit)
    {
label0:
        {
            Args.check(managedclientconnection instanceof ConnAdapter, "Connection class mismatch, connection not obtained from this manager");
            assertStillUp();
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Releasing connection ").append(managedclientconnection).toString());
            }
            synchronized ((ConnAdapter)managedclientconnection)
            {
                if (((ConnAdapter) (managedclientconnection)).poolEntry != null)
                {
                    break label0;
                }
            }
            return;
        }
        boolean flag;
        if (managedclientconnection.getManager() == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Connection not obtained from this manager");
        if (managedclientconnection.isOpen() && (alwaysShutDown || !managedclientconnection.isMarkedReusable()))
        {
            if (log.isDebugEnabled())
            {
                log.debug("Released connection open but not reusable.");
            }
            managedclientconnection.shutdown();
        }
        managedclientconnection.detach();
        this;
        JVM INSTR monitorenter ;
        managedConn = null;
        lastReleaseTime = System.currentTimeMillis();
        if (l <= 0L) goto _L2; else goto _L1
_L1:
        connectionExpiresTime = timeunit.toMillis(l) + lastReleaseTime;
_L3:
        this;
        JVM INSTR monitorexit ;
_L4:
        managedclientconnection;
        JVM INSTR monitorexit ;
        return;
        timeunit;
        managedclientconnection;
        JVM INSTR monitorexit ;
        throw timeunit;
_L2:
        connectionExpiresTime = 0x7fffffffffffffffL;
          goto _L3
        timeunit;
        this;
        JVM INSTR monitorexit ;
        throw timeunit;
        Object obj;
        obj;
        if (log.isDebugEnabled())
        {
            log.debug("Exception shutting down released connection.", ((Throwable) (obj)));
        }
        managedclientconnection.detach();
        this;
        JVM INSTR monitorenter ;
        managedConn = null;
        lastReleaseTime = System.currentTimeMillis();
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        connectionExpiresTime = timeunit.toMillis(l) + lastReleaseTime;
_L5:
        this;
        JVM INSTR monitorexit ;
          goto _L4
        timeunit;
        this;
        JVM INSTR monitorexit ;
        throw timeunit;
        connectionExpiresTime = 0x7fffffffffffffffL;
          goto _L5
        obj;
        managedclientconnection.detach();
        this;
        JVM INSTR monitorenter ;
        managedConn = null;
        lastReleaseTime = System.currentTimeMillis();
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        connectionExpiresTime = timeunit.toMillis(l) + lastReleaseTime;
_L6:
        this;
        JVM INSTR monitorexit ;
        throw obj;
        connectionExpiresTime = 0x7fffffffffffffffL;
          goto _L6
        timeunit;
        this;
        JVM INSTR monitorexit ;
        throw timeunit;
          goto _L3
    }

    public final ClientConnectionRequest requestConnection(final HttpRoute route, final Object state)
    {
        return new ClientConnectionRequest() {

            final SingleClientConnManager this$0;
            final HttpRoute val$route;
            final Object val$state;

            public void abortRequest()
            {
            }

            public ManagedClientConnection getConnection(long l, TimeUnit timeunit)
            {
                return SingleClientConnManager.this.getConnection(route, state);
            }

            
            {
                this$0 = SingleClientConnManager.this;
                route = httproute;
                state = obj;
                super();
            }
        };
    }

    protected void revokeConnection()
    {
        ConnAdapter connadapter = managedConn;
        if (connadapter == null)
        {
            return;
        }
        connadapter.detach();
        this;
        JVM INSTR monitorenter ;
        uniquePoolEntry.shutdown();
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        log.debug("Problem while shutting down connection.", ((Throwable) (obj)));
          goto _L1
    }

    public void shutdown()
    {
        isShutDown = true;
        this;
        JVM INSTR monitorenter ;
        if (uniquePoolEntry != null)
        {
            uniquePoolEntry.shutdown();
        }
        uniquePoolEntry = null;
        managedConn = null;
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        log.debug("Problem while shutting down manager.", ((Throwable) (obj)));
        uniquePoolEntry = null;
        managedConn = null;
          goto _L1
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        uniquePoolEntry = null;
        managedConn = null;
        throw obj;
    }
}
