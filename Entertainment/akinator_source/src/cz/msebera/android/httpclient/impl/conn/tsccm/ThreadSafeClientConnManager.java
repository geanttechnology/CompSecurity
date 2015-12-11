// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.params.ConnPerRouteBean;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.DefaultClientConnectionOperator;
import cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn.tsccm:
//            ConnPoolByRoute, BasicPooledConnAdapter, BasicPoolEntry, AbstractConnPool, 
//            PoolEntryRequest

public class ThreadSafeClientConnManager
    implements ClientConnectionManager
{

    protected final ClientConnectionOperator connOperator;
    protected final ConnPerRouteBean connPerRoute;
    protected final AbstractConnPool connectionPool;
    public HttpClientAndroidLog log;
    protected final ConnPoolByRoute pool;
    protected final SchemeRegistry schemeRegistry;

    public ThreadSafeClientConnManager()
    {
        this(SchemeRegistryFactory.createDefault());
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeregistry)
    {
        this(schemeregistry, -1L, TimeUnit.MILLISECONDS);
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeregistry, long l, TimeUnit timeunit)
    {
        this(schemeregistry, l, timeunit, new ConnPerRouteBean());
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeregistry, long l, TimeUnit timeunit, ConnPerRouteBean connperroutebean)
    {
        Args.notNull(schemeregistry, "Scheme registry");
        log = new HttpClientAndroidLog(getClass());
        schemeRegistry = schemeregistry;
        connPerRoute = connperroutebean;
        connOperator = createConnectionOperator(schemeregistry);
        pool = createConnectionPool(l, timeunit);
        connectionPool = pool;
    }

    public ThreadSafeClientConnManager(HttpParams httpparams, SchemeRegistry schemeregistry)
    {
        Args.notNull(schemeregistry, "Scheme registry");
        log = new HttpClientAndroidLog(getClass());
        schemeRegistry = schemeregistry;
        connPerRoute = new ConnPerRouteBean();
        connOperator = createConnectionOperator(schemeregistry);
        pool = (ConnPoolByRoute)createConnectionPool(httpparams);
        connectionPool = pool;
    }

    public void closeExpiredConnections()
    {
        log.debug("Closing expired connections");
        pool.closeExpiredConnections();
    }

    public void closeIdleConnections(long l, TimeUnit timeunit)
    {
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Closing connections idle longer than ").append(l).append(" ").append(timeunit).toString());
        }
        pool.closeIdleConnections(l, timeunit);
    }

    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeregistry)
    {
        return new DefaultClientConnectionOperator(schemeregistry);
    }

    protected AbstractConnPool createConnectionPool(HttpParams httpparams)
    {
        return new ConnPoolByRoute(connOperator, httpparams);
    }

    protected ConnPoolByRoute createConnectionPool(long l, TimeUnit timeunit)
    {
        return new ConnPoolByRoute(connOperator, connPerRoute, 20, l, timeunit);
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

    public int getConnectionsInPool()
    {
        return pool.getConnectionsInPool();
    }

    public int getConnectionsInPool(HttpRoute httproute)
    {
        return pool.getConnectionsInPool(httproute);
    }

    public int getDefaultMaxPerRoute()
    {
        return connPerRoute.getDefaultMaxPerRoute();
    }

    public int getMaxForRoute(HttpRoute httproute)
    {
        return connPerRoute.getMaxForRoute(httproute);
    }

    public int getMaxTotal()
    {
        return pool.getMaxTotalConnections();
    }

    public SchemeRegistry getSchemeRegistry()
    {
        return schemeRegistry;
    }

    public void releaseConnection(ManagedClientConnection managedclientconnection, long l, TimeUnit timeunit)
    {
        BasicPoolEntry basicpoolentry;
        Args.check(managedclientconnection instanceof BasicPooledConnAdapter, "Connection class mismatch, connection not obtained from this manager");
        managedclientconnection = (BasicPooledConnAdapter)managedclientconnection;
        if (managedclientconnection.getPoolEntry() != null)
        {
            boolean flag;
            if (managedclientconnection.getManager() == this)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Asserts.check(flag, "Connection not obtained from this manager");
        }
        managedclientconnection;
        JVM INSTR monitorenter ;
        basicpoolentry = (BasicPoolEntry)managedclientconnection.getPoolEntry();
        if (basicpoolentry != null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        managedclientconnection;
        JVM INSTR monitorexit ;
        return;
        if (managedclientconnection.isOpen() && !managedclientconnection.isMarkedReusable())
        {
            managedclientconnection.shutdown();
        }
        boolean flag1 = managedclientconnection.isMarkedReusable();
        if (!log.isDebugEnabled()) goto _L2; else goto _L1
_L1:
        if (!flag1) goto _L4; else goto _L3
_L3:
        log.debug("Released connection is reusable.");
_L2:
        managedclientconnection.detach();
        pool.freeEntry(basicpoolentry, flag1, l, timeunit);
_L5:
        managedclientconnection;
        JVM INSTR monitorexit ;
        return;
        timeunit;
        managedclientconnection;
        JVM INSTR monitorexit ;
        throw timeunit;
_L4:
        log.debug("Released connection is not reusable.");
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        if (log.isDebugEnabled())
        {
            log.debug("Exception shutting down released connection.", ((Throwable) (obj)));
        }
        flag1 = managedclientconnection.isMarkedReusable();
        if (!log.isDebugEnabled())
        {
            break MISSING_BLOCK_LABEL_205;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        log.debug("Released connection is reusable.");
_L6:
        managedclientconnection.detach();
        pool.freeEntry(basicpoolentry, flag1, l, timeunit);
          goto _L5
        log.debug("Released connection is not reusable.");
          goto _L6
        obj;
        flag1 = managedclientconnection.isMarkedReusable();
        if (!log.isDebugEnabled()) goto _L8; else goto _L7
_L7:
        if (!flag1) goto _L10; else goto _L9
_L9:
        log.debug("Released connection is reusable.");
_L8:
        managedclientconnection.detach();
        pool.freeEntry(basicpoolentry, flag1, l, timeunit);
        throw obj;
_L10:
        log.debug("Released connection is not reusable.");
        if (true) goto _L8; else goto _L11
_L11:
        if (true) goto _L2; else goto _L12
_L12:
    }

    public ClientConnectionRequest requestConnection(HttpRoute httproute, Object obj)
    {
        return new ClientConnectionRequest() {

            final ThreadSafeClientConnManager this$0;
            final PoolEntryRequest val$poolRequest;
            final HttpRoute val$route;

            public void abortRequest()
            {
                poolRequest.abortRequest();
            }

            public ManagedClientConnection getConnection(long l, TimeUnit timeunit)
                throws InterruptedException, ConnectionPoolTimeoutException
            {
                Args.notNull(route, "Route");
                if (log.isDebugEnabled())
                {
                    log.debug((new StringBuilder()).append("Get connection: ").append(route).append(", timeout = ").append(l).toString());
                }
                timeunit = poolRequest.getPoolEntry(l, timeunit);
                return new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, timeunit);
            }

            
            {
                this$0 = ThreadSafeClientConnManager.this;
                poolRequest = poolentryrequest;
                route = httproute;
                super();
            }
        };
    }

    public void setDefaultMaxPerRoute(int i)
    {
        connPerRoute.setDefaultMaxPerRoute(i);
    }

    public void setMaxForRoute(HttpRoute httproute, int i)
    {
        connPerRoute.setMaxForRoute(httproute, i);
    }

    public void setMaxTotal(int i)
    {
        pool.setMaxTotalConnections(i);
    }

    public void shutdown()
    {
        log.debug("Shutting down");
        pool.shutdown();
    }
}
