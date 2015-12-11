// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.config.Registry;
import cz.msebera.android.httpclient.config.RegistryBuilder;
import cz.msebera.android.httpclient.config.SocketConfig;
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
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            HttpClientConnectionOperator, ManagedHttpClientConnectionFactory

public class BasicHttpClientConnectionManager
    implements HttpClientConnectionManager, Closeable
{

    private ManagedHttpClientConnection conn;
    private ConnectionConfig connConfig;
    private final HttpConnectionFactory connFactory;
    private final HttpClientConnectionOperator connectionOperator;
    private long expiry;
    private final AtomicBoolean isShutdown;
    private boolean leased;
    public HttpClientAndroidLog log;
    private HttpRoute route;
    private SocketConfig socketConfig;
    private Object state;
    private long updated;

    public BasicHttpClientConnectionManager()
    {
        this(((Lookup) (getDefaultRegistry())), null, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup lookup)
    {
        this(lookup, null, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup lookup, HttpConnectionFactory httpconnectionfactory)
    {
        this(lookup, httpconnectionfactory, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup lookup, HttpConnectionFactory httpconnectionfactory, SchemePortResolver schemeportresolver, DnsResolver dnsresolver)
    {
        log = new HttpClientAndroidLog(getClass());
        connectionOperator = new HttpClientConnectionOperator(lookup, schemeportresolver, dnsresolver);
        if (httpconnectionfactory == null)
        {
            httpconnectionfactory = ManagedHttpClientConnectionFactory.INSTANCE;
        }
        connFactory = httpconnectionfactory;
        expiry = 0x7fffffffffffffffL;
        socketConfig = SocketConfig.DEFAULT;
        connConfig = ConnectionConfig.DEFAULT;
        isShutdown = new AtomicBoolean(false);
    }

    private void checkExpiry()
    {
        if (conn != null && System.currentTimeMillis() >= expiry)
        {
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Connection expired @ ").append(new Date(expiry)).toString());
            }
            closeConnection();
        }
    }

    private void closeConnection()
    {
        if (conn == null) goto _L2; else goto _L1
_L1:
        log.debug("Closing connection");
        conn.close();
_L4:
        conn = null;
_L2:
        return;
        IOException ioexception;
        ioexception;
        if (log.isDebugEnabled())
        {
            log.debug("I/O exception closing connection", ioexception);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static Registry getDefaultRegistry()
    {
        return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    private void shutdownConnection()
    {
        if (conn == null) goto _L2; else goto _L1
_L1:
        log.debug("Shutting down connection");
        conn.shutdown();
_L4:
        conn = null;
_L2:
        return;
        IOException ioexception;
        ioexception;
        if (log.isDebugEnabled())
        {
            log.debug("I/O exception shutting down connection", ioexception);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void close()
    {
        shutdown();
    }

    public void closeExpiredConnections()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isShutdown.get();
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!leased)
        {
            checkExpiry();
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void closeIdleConnections(long l, TimeUnit timeunit)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        Args.notNull(timeunit, "Time unit");
        flag = isShutdown.get();
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        long l1;
        if (leased)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = timeunit.toMillis(l);
        l = l1;
        if (l1 < 0L)
        {
            l = 0L;
        }
        long l2 = System.currentTimeMillis();
        if (updated <= l2 - l)
        {
            closeConnection();
        }
        if (true) goto _L1; else goto _L3
_L3:
        timeunit;
        throw timeunit;
    }

    public void connect(HttpClientConnection httpclientconnection, HttpRoute httproute, int i, HttpContext httpcontext)
        throws IOException
    {
        Args.notNull(httpclientconnection, "Connection");
        Args.notNull(httproute, "HTTP route");
        boolean flag;
        if (httpclientconnection == conn)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Connection not obtained from this manager");
        if (httproute.getProxyHost() != null)
        {
            httpclientconnection = httproute.getProxyHost();
        } else
        {
            httpclientconnection = httproute.getTargetHost();
        }
        httproute = httproute.getLocalSocketAddress();
        connectionOperator.connect(conn, httpclientconnection, httproute, i, socketConfig, httpcontext);
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

    HttpClientConnection getConnection(HttpRoute httproute, Object obj)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (!isShutdown.get())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Connection manager has been shut down");
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Get connection for route ").append(httproute).toString());
        }
        if (!leased)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Connection is still allocated");
        if (!LangUtils.equals(route, httproute) || !LangUtils.equals(state, obj))
        {
            closeConnection();
        }
        route = httproute;
        state = obj;
        checkExpiry();
        if (conn == null)
        {
            conn = (ManagedHttpClientConnection)connFactory.create(httproute, connConfig);
        }
        leased = true;
        httproute = conn;
        this;
        JVM INSTR monitorexit ;
        return httproute;
        httproute;
        throw httproute;
    }

    public ConnectionConfig getConnectionConfig()
    {
        this;
        JVM INSTR monitorenter ;
        ConnectionConfig connectionconfig = connConfig;
        this;
        JVM INSTR monitorexit ;
        return connectionconfig;
        Exception exception;
        exception;
        throw exception;
    }

    HttpRoute getRoute()
    {
        return route;
    }

    public SocketConfig getSocketConfig()
    {
        this;
        JVM INSTR monitorenter ;
        SocketConfig socketconfig = socketConfig;
        this;
        JVM INSTR monitorexit ;
        return socketconfig;
        Exception exception;
        exception;
        throw exception;
    }

    Object getState()
    {
        return state;
    }

    public void releaseConnection(HttpClientConnection httpclientconnection, Object obj, long l, TimeUnit timeunit)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        Args.notNull(httpclientconnection, "Connection");
        if (httpclientconnection == conn)
        {
            flag = true;
        }
        Asserts.check(flag, "Connection not obtained from this manager");
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Releasing connection ").append(httpclientconnection).toString());
        }
        flag = isShutdown.get();
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        updated = System.currentTimeMillis();
        if (conn.isOpen())
        {
            break; /* Loop/switch isn't completed */
        }
        conn = null;
        route = null;
        conn = null;
        expiry = 0x7fffffffffffffffL;
_L6:
        leased = false;
        if (true) goto _L1; else goto _L3
        httpclientconnection;
        throw httpclientconnection;
_L3:
        state = obj;
        if (!log.isDebugEnabled()) goto _L5; else goto _L4
_L4:
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        httpclientconnection = (new StringBuilder()).append("for ").append(l).append(" ").append(timeunit).toString();
_L7:
        log.debug((new StringBuilder()).append("Connection can be kept alive ").append(httpclientconnection).toString());
_L5:
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        expiry = updated + timeunit.toMillis(l);
          goto _L6
        httpclientconnection;
        leased = false;
        throw httpclientconnection;
        httpclientconnection = "indefinitely";
          goto _L7
        expiry = 0x7fffffffffffffffL;
          goto _L6
    }

    public final ConnectionRequest requestConnection(final HttpRoute route, final Object state)
    {
        Args.notNull(route, "Route");
        return new ConnectionRequest() {

            final BasicHttpClientConnectionManager this$0;
            final HttpRoute val$route;
            final Object val$state;

            public boolean cancel()
            {
                return false;
            }

            public HttpClientConnection get(long l, TimeUnit timeunit)
            {
                return getConnection(route, state);
            }

            
            {
                this$0 = BasicHttpClientConnectionManager.this;
                route = httproute;
                state = obj;
                super();
            }
        };
    }

    public void routeComplete(HttpClientConnection httpclientconnection, HttpRoute httproute, HttpContext httpcontext)
        throws IOException
    {
    }

    public void setConnectionConfig(ConnectionConfig connectionconfig)
    {
        this;
        JVM INSTR monitorenter ;
        if (connectionconfig == null) goto _L2; else goto _L1
_L1:
        connConfig = connectionconfig;
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        connectionconfig = ConnectionConfig.DEFAULT;
        if (true) goto _L1; else goto _L3
_L3:
        connectionconfig;
        throw connectionconfig;
    }

    public void setSocketConfig(SocketConfig socketconfig)
    {
        this;
        JVM INSTR monitorenter ;
        if (socketconfig == null) goto _L2; else goto _L1
_L1:
        socketConfig = socketconfig;
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        socketconfig = SocketConfig.DEFAULT;
        if (true) goto _L1; else goto _L3
_L3:
        socketconfig;
        throw socketconfig;
    }

    public void shutdown()
    {
        this;
        JVM INSTR monitorenter ;
        if (isShutdown.compareAndSet(false, true))
        {
            shutdownConnection();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void upgrade(HttpClientConnection httpclientconnection, HttpRoute httproute, HttpContext httpcontext)
        throws IOException
    {
        Args.notNull(httpclientconnection, "Connection");
        Args.notNull(httproute, "HTTP route");
        boolean flag;
        if (httpclientconnection == conn)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Connection not obtained from this manager");
        connectionOperator.upgrade(conn, httproute.getTargetHost(), httpcontext);
    }
}
