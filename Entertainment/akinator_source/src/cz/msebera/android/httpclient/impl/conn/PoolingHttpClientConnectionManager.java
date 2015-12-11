// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.config.Registry;
import cz.msebera.android.httpclient.config.RegistryBuilder;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.HttpConnectionFactory;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.socket.PlainConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.ssl.SSLConnectionSocketFactory;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.ConnFactory;
import cz.msebera.android.httpclient.pool.ConnPoolControl;
import cz.msebera.android.httpclient.pool.PoolStats;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            CPool, HttpClientConnectionOperator, CPoolEntry, CPoolProxy, 
//            ManagedHttpClientConnectionFactory

public class PoolingHttpClientConnectionManager
    implements HttpClientConnectionManager, ConnPoolControl, Closeable
{
    static class ConfigData
    {

        private final Map connectionConfigMap = new ConcurrentHashMap();
        private volatile ConnectionConfig defaultConnectionConfig;
        private volatile SocketConfig defaultSocketConfig;
        private final Map socketConfigMap = new ConcurrentHashMap();

        public ConnectionConfig getConnectionConfig(HttpHost httphost)
        {
            return (ConnectionConfig)connectionConfigMap.get(httphost);
        }

        public ConnectionConfig getDefaultConnectionConfig()
        {
            return defaultConnectionConfig;
        }

        public SocketConfig getDefaultSocketConfig()
        {
            return defaultSocketConfig;
        }

        public SocketConfig getSocketConfig(HttpHost httphost)
        {
            return (SocketConfig)socketConfigMap.get(httphost);
        }

        public void setConnectionConfig(HttpHost httphost, ConnectionConfig connectionconfig)
        {
            connectionConfigMap.put(httphost, connectionconfig);
        }

        public void setDefaultConnectionConfig(ConnectionConfig connectionconfig)
        {
            defaultConnectionConfig = connectionconfig;
        }

        public void setDefaultSocketConfig(SocketConfig socketconfig)
        {
            defaultSocketConfig = socketconfig;
        }

        public void setSocketConfig(HttpHost httphost, SocketConfig socketconfig)
        {
            socketConfigMap.put(httphost, socketconfig);
        }

        ConfigData()
        {
        }
    }

    static class InternalConnectionFactory
        implements ConnFactory
    {

        private final ConfigData configData;
        private final HttpConnectionFactory connFactory;

        public ManagedHttpClientConnection create(HttpRoute httproute)
            throws IOException
        {
            ConnectionConfig connectionconfig1 = null;
            if (httproute.getProxyHost() != null)
            {
                connectionconfig1 = configData.getConnectionConfig(httproute.getProxyHost());
            }
            ConnectionConfig connectionconfig = connectionconfig1;
            if (connectionconfig1 == null)
            {
                connectionconfig = configData.getConnectionConfig(httproute.getTargetHost());
            }
            connectionconfig1 = connectionconfig;
            if (connectionconfig == null)
            {
                connectionconfig1 = configData.getDefaultConnectionConfig();
            }
            connectionconfig = connectionconfig1;
            if (connectionconfig1 == null)
            {
                connectionconfig = ConnectionConfig.DEFAULT;
            }
            return (ManagedHttpClientConnection)connFactory.create(httproute, connectionconfig);
        }

        public volatile Object create(Object obj)
            throws IOException
        {
            return create((HttpRoute)obj);
        }

        InternalConnectionFactory(ConfigData configdata, HttpConnectionFactory httpconnectionfactory)
        {
            if (configdata == null)
            {
                configdata = new ConfigData();
            }
            configData = configdata;
            if (httpconnectionfactory == null)
            {
                httpconnectionfactory = ManagedHttpClientConnectionFactory.INSTANCE;
            }
            connFactory = httpconnectionfactory;
        }
    }


    private final ConfigData configData;
    private final HttpClientConnectionOperator connectionOperator;
    private final AtomicBoolean isShutDown;
    public HttpClientAndroidLog log;
    private final CPool pool;

    public PoolingHttpClientConnectionManager()
    {
        this(getDefaultRegistry());
    }

    public PoolingHttpClientConnectionManager(long l, TimeUnit timeunit)
    {
        this(getDefaultRegistry(), null, null, null, l, timeunit);
    }

    public PoolingHttpClientConnectionManager(Registry registry)
    {
        this(registry, null, null);
    }

    public PoolingHttpClientConnectionManager(Registry registry, DnsResolver dnsresolver)
    {
        this(registry, null, dnsresolver);
    }

    public PoolingHttpClientConnectionManager(Registry registry, HttpConnectionFactory httpconnectionfactory)
    {
        this(registry, httpconnectionfactory, null);
    }

    public PoolingHttpClientConnectionManager(Registry registry, HttpConnectionFactory httpconnectionfactory, DnsResolver dnsresolver)
    {
        this(registry, httpconnectionfactory, null, dnsresolver, -1L, TimeUnit.MILLISECONDS);
    }

    public PoolingHttpClientConnectionManager(Registry registry, HttpConnectionFactory httpconnectionfactory, SchemePortResolver schemeportresolver, DnsResolver dnsresolver, long l, TimeUnit timeunit)
    {
        log = new HttpClientAndroidLog(getClass());
        configData = new ConfigData();
        pool = new CPool(new InternalConnectionFactory(configData, httpconnectionfactory), 2, 20, l, timeunit);
        connectionOperator = new HttpClientConnectionOperator(registry, schemeportresolver, dnsresolver);
        isShutDown = new AtomicBoolean(false);
    }

    public PoolingHttpClientConnectionManager(HttpConnectionFactory httpconnectionfactory)
    {
        this(getDefaultRegistry(), httpconnectionfactory, null);
    }

    PoolingHttpClientConnectionManager(CPool cpool, Lookup lookup, SchemePortResolver schemeportresolver, DnsResolver dnsresolver)
    {
        log = new HttpClientAndroidLog(getClass());
        configData = new ConfigData();
        pool = cpool;
        connectionOperator = new HttpClientConnectionOperator(lookup, schemeportresolver, dnsresolver);
        isShutDown = new AtomicBoolean(false);
    }

    private String format(HttpRoute httproute, Object obj)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[route: ").append(httproute).append("]");
        if (obj != null)
        {
            stringbuilder.append("[state: ").append(obj).append("]");
        }
        return stringbuilder.toString();
    }

    private String format(CPoolEntry cpoolentry)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[id: ").append(cpoolentry.getId()).append("]");
        stringbuilder.append("[route: ").append(cpoolentry.getRoute()).append("]");
        cpoolentry = ((CPoolEntry) (cpoolentry.getState()));
        if (cpoolentry != null)
        {
            stringbuilder.append("[state: ").append(cpoolentry).append("]");
        }
        return stringbuilder.toString();
    }

    private String formatStats(HttpRoute httproute)
    {
        StringBuilder stringbuilder = new StringBuilder();
        PoolStats poolstats = pool.getTotalStats();
        httproute = pool.getStats(httproute);
        stringbuilder.append("[total kept alive: ").append(poolstats.getAvailable()).append("; ");
        stringbuilder.append("route allocated: ").append(httproute.getLeased() + httproute.getAvailable());
        stringbuilder.append(" of ").append(httproute.getMax()).append("; ");
        stringbuilder.append("total allocated: ").append(poolstats.getLeased() + poolstats.getAvailable());
        stringbuilder.append(" of ").append(poolstats.getMax()).append("]");
        return stringbuilder.toString();
    }

    private static Registry getDefaultRegistry()
    {
        return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    public void close()
    {
        shutdown();
    }

    public void closeExpiredConnections()
    {
        log.debug("Closing expired connections");
        pool.closeExpired();
    }

    public void closeIdleConnections(long l, TimeUnit timeunit)
    {
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Closing connections idle longer than ").append(l).append(" ").append(timeunit).toString());
        }
        pool.closeIdle(l, timeunit);
    }

    public void connect(HttpClientConnection httpclientconnection, HttpRoute httproute, int i, HttpContext httpcontext)
        throws IOException
    {
        Args.notNull(httpclientconnection, "Managed Connection");
        Args.notNull(httproute, "HTTP route");
        httpclientconnection;
        JVM INSTR monitorenter ;
        ManagedHttpClientConnection managedhttpclientconnection = (ManagedHttpClientConnection)CPoolProxy.getPoolEntry(httpclientconnection).getConnection();
        httpclientconnection;
        JVM INSTR monitorexit ;
        HttpHost httphost;
        java.net.InetSocketAddress inetsocketaddress;
        if (httproute.getProxyHost() != null)
        {
            httphost = httproute.getProxyHost();
        } else
        {
            httphost = httproute.getTargetHost();
        }
        inetsocketaddress = httproute.getLocalSocketAddress();
        httproute = configData.getSocketConfig(httphost);
        httpclientconnection = httproute;
        if (httproute == null)
        {
            httpclientconnection = configData.getDefaultSocketConfig();
        }
        httproute = httpclientconnection;
        if (httpclientconnection == null)
        {
            httproute = SocketConfig.DEFAULT;
        }
        connectionOperator.connect(managedhttpclientconnection, httphost, inetsocketaddress, i, httproute, httpcontext);
        return;
        httproute;
        httpclientconnection;
        JVM INSTR monitorexit ;
        throw httproute;
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

    public ConnectionConfig getConnectionConfig(HttpHost httphost)
    {
        return configData.getConnectionConfig(httphost);
    }

    public ConnectionConfig getDefaultConnectionConfig()
    {
        return configData.getDefaultConnectionConfig();
    }

    public int getDefaultMaxPerRoute()
    {
        return pool.getDefaultMaxPerRoute();
    }

    public SocketConfig getDefaultSocketConfig()
    {
        return configData.getDefaultSocketConfig();
    }

    public int getMaxPerRoute(HttpRoute httproute)
    {
        return pool.getMaxPerRoute(httproute);
    }

    public volatile int getMaxPerRoute(Object obj)
    {
        return getMaxPerRoute((HttpRoute)obj);
    }

    public int getMaxTotal()
    {
        return pool.getMaxTotal();
    }

    public SocketConfig getSocketConfig(HttpHost httphost)
    {
        return configData.getSocketConfig(httphost);
    }

    public PoolStats getStats(HttpRoute httproute)
    {
        return pool.getStats(httproute);
    }

    public volatile PoolStats getStats(Object obj)
    {
        return getStats((HttpRoute)obj);
    }

    public PoolStats getTotalStats()
    {
        return pool.getTotalStats();
    }

    protected HttpClientConnection leaseConnection(Future future, long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException
    {
        try
        {
            timeunit = (CPoolEntry)future.get(l, timeunit);
        }
        // Misplaced declaration of an exception variable
        catch (Future future)
        {
            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
        }
        if (timeunit == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (!future.isCancelled())
        {
            break MISSING_BLOCK_LABEL_48;
        }
        throw new InterruptedException();
        boolean flag;
        if (timeunit.getConnection() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Pool entry with no connection");
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Connection leased: ").append(format(timeunit)).append(formatStats((HttpRoute)timeunit.getRoute())).toString());
        }
        future = CPoolProxy.newProxy(timeunit);
        return future;
    }

    public void releaseConnection(HttpClientConnection httpclientconnection, Object obj, long l, TimeUnit timeunit)
    {
        Args.notNull(httpclientconnection, "Managed connection");
        httpclientconnection;
        JVM INSTR monitorenter ;
        CPoolEntry cpoolentry = CPoolProxy.detach(httpclientconnection);
        if (cpoolentry != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        httpclientconnection;
        JVM INSTR monitorexit ;
        return;
        ManagedHttpClientConnection managedhttpclientconnection = (ManagedHttpClientConnection)cpoolentry.getConnection();
        if (!managedhttpclientconnection.isOpen()) goto _L2; else goto _L1
_L1:
        if (timeunit == null) goto _L4; else goto _L3
_L3:
        cpoolentry.setState(obj);
        cpoolentry.updateExpiry(l, timeunit);
        if (!log.isDebugEnabled()) goto _L2; else goto _L5
_L5:
        if (l <= 0L) goto _L7; else goto _L6
_L6:
        obj = (new StringBuilder()).append("for ").append((double)timeunit.toMillis(l) / 1000D).append(" seconds").toString();
_L8:
        log.debug((new StringBuilder()).append("Connection ").append(format(cpoolentry)).append(" can be kept alive ").append(((String) (obj))).toString());
_L2:
        obj = pool;
        boolean flag;
        if (managedhttpclientconnection.isOpen() && cpoolentry.isRouteComplete())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((CPool) (obj)).release(cpoolentry, flag);
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Connection released: ").append(format(cpoolentry)).append(formatStats((HttpRoute)cpoolentry.getRoute())).toString());
        }
        httpclientconnection;
        JVM INSTR monitorexit ;
        return;
        obj;
        httpclientconnection;
        JVM INSTR monitorexit ;
        throw obj;
_L4:
        timeunit = TimeUnit.MILLISECONDS;
          goto _L3
_L7:
        obj = "indefinitely";
          goto _L8
        obj;
        timeunit = pool;
        if (managedhttpclientconnection.isOpen() && cpoolentry.isRouteComplete())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        timeunit.release(cpoolentry, flag);
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Connection released: ").append(format(cpoolentry)).append(formatStats((HttpRoute)cpoolentry.getRoute())).toString());
        }
        throw obj;
          goto _L3
    }

    public ConnectionRequest requestConnection(HttpRoute httproute, Object obj)
    {
        Args.notNull(httproute, "HTTP route");
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Connection request: ").append(format(httproute, obj)).append(formatStats(httproute)).toString());
        }
        return new ConnectionRequest() {

            final PoolingHttpClientConnectionManager this$0;
            final Future val$future;

            public boolean cancel()
            {
                return future.cancel(true);
            }

            public HttpClientConnection get(long l, TimeUnit timeunit)
                throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException
            {
                return leaseConnection(future, l, timeunit);
            }

            
            {
                this$0 = PoolingHttpClientConnectionManager.this;
                future = future1;
                super();
            }
        };
    }

    public void routeComplete(HttpClientConnection httpclientconnection, HttpRoute httproute, HttpContext httpcontext)
        throws IOException
    {
        Args.notNull(httpclientconnection, "Managed Connection");
        Args.notNull(httproute, "HTTP route");
        httpclientconnection;
        JVM INSTR monitorenter ;
        CPoolProxy.getPoolEntry(httpclientconnection).markRouteComplete();
        httpclientconnection;
        JVM INSTR monitorexit ;
        return;
        httproute;
        httpclientconnection;
        JVM INSTR monitorexit ;
        throw httproute;
    }

    public void setConnectionConfig(HttpHost httphost, ConnectionConfig connectionconfig)
    {
        configData.setConnectionConfig(httphost, connectionconfig);
    }

    public void setDefaultConnectionConfig(ConnectionConfig connectionconfig)
    {
        configData.setDefaultConnectionConfig(connectionconfig);
    }

    public void setDefaultMaxPerRoute(int i)
    {
        pool.setDefaultMaxPerRoute(i);
    }

    public void setDefaultSocketConfig(SocketConfig socketconfig)
    {
        configData.setDefaultSocketConfig(socketconfig);
    }

    public void setMaxPerRoute(HttpRoute httproute, int i)
    {
        pool.setMaxPerRoute(httproute, i);
    }

    public volatile void setMaxPerRoute(Object obj, int i)
    {
        setMaxPerRoute((HttpRoute)obj, i);
    }

    public void setMaxTotal(int i)
    {
        pool.setMaxTotal(i);
    }

    public void setSocketConfig(HttpHost httphost, SocketConfig socketconfig)
    {
        configData.setSocketConfig(httphost, socketconfig);
    }

    public void shutdown()
    {
        if (isShutDown.compareAndSet(false, true))
        {
            log.debug("Connection manager is shutting down");
            try
            {
                pool.shutdown();
            }
            catch (IOException ioexception)
            {
                log.debug("I/O exception shutting down connection manager", ioexception);
            }
            log.debug("Connection manager shut down");
        }
    }

    public void upgrade(HttpClientConnection httpclientconnection, HttpRoute httproute, HttpContext httpcontext)
        throws IOException
    {
        Args.notNull(httpclientconnection, "Managed Connection");
        Args.notNull(httproute, "HTTP route");
        httpclientconnection;
        JVM INSTR monitorenter ;
        ManagedHttpClientConnection managedhttpclientconnection = (ManagedHttpClientConnection)CPoolProxy.getPoolEntry(httpclientconnection).getConnection();
        httpclientconnection;
        JVM INSTR monitorexit ;
        connectionOperator.upgrade(managedhttpclientconnection, httproute.getTargetHost(), httpcontext);
        return;
        httproute;
        httpclientconnection;
        JVM INSTR monitorexit ;
        throw httproute;
    }
}
