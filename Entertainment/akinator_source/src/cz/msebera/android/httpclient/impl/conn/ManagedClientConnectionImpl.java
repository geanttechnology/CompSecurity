// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            ConnectionShutdownException, HttpPoolEntry

class ManagedClientConnectionImpl
    implements ManagedClientConnection
{

    private volatile long duration;
    private final ClientConnectionManager manager;
    private final ClientConnectionOperator operator;
    private volatile HttpPoolEntry poolEntry;
    private volatile boolean reusable;

    ManagedClientConnectionImpl(ClientConnectionManager clientconnectionmanager, ClientConnectionOperator clientconnectionoperator, HttpPoolEntry httppoolentry)
    {
        Args.notNull(clientconnectionmanager, "Connection manager");
        Args.notNull(clientconnectionoperator, "Connection operator");
        Args.notNull(httppoolentry, "HTTP pool entry");
        manager = clientconnectionmanager;
        operator = clientconnectionoperator;
        poolEntry = httppoolentry;
        reusable = false;
        duration = 0x7fffffffffffffffL;
    }

    private OperatedClientConnection ensureConnection()
    {
        HttpPoolEntry httppoolentry = poolEntry;
        if (httppoolentry == null)
        {
            throw new ConnectionShutdownException();
        } else
        {
            return (OperatedClientConnection)httppoolentry.getConnection();
        }
    }

    private HttpPoolEntry ensurePoolEntry()
    {
        HttpPoolEntry httppoolentry = poolEntry;
        if (httppoolentry == null)
        {
            throw new ConnectionShutdownException();
        } else
        {
            return httppoolentry;
        }
    }

    private OperatedClientConnection getConnection()
    {
        HttpPoolEntry httppoolentry = poolEntry;
        if (httppoolentry == null)
        {
            return null;
        } else
        {
            return (OperatedClientConnection)httppoolentry.getConnection();
        }
    }

    public void abortConnection()
    {
        this;
        JVM INSTR monitorenter ;
        if (poolEntry != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        OperatedClientConnection operatedclientconnection;
        reusable = false;
        operatedclientconnection = (OperatedClientConnection)poolEntry.getConnection();
        Exception exception;
        try
        {
            operatedclientconnection.shutdown();
        }
        catch (IOException ioexception) { }
        manager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
        poolEntry = null;
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void bind(Socket socket)
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public void close()
        throws IOException
    {
        HttpPoolEntry httppoolentry = poolEntry;
        if (httppoolentry != null)
        {
            OperatedClientConnection operatedclientconnection = (OperatedClientConnection)httppoolentry.getConnection();
            httppoolentry.getTracker().reset();
            operatedclientconnection.close();
        }
    }

    HttpPoolEntry detach()
    {
        HttpPoolEntry httppoolentry = poolEntry;
        poolEntry = null;
        return httppoolentry;
    }

    public void flush()
        throws IOException
    {
        ensureConnection().flush();
    }

    public Object getAttribute(String s)
    {
        OperatedClientConnection operatedclientconnection = ensureConnection();
        if (operatedclientconnection instanceof HttpContext)
        {
            return ((HttpContext)operatedclientconnection).getAttribute(s);
        } else
        {
            return null;
        }
    }

    public String getId()
    {
        return null;
    }

    public InetAddress getLocalAddress()
    {
        return ensureConnection().getLocalAddress();
    }

    public int getLocalPort()
    {
        return ensureConnection().getLocalPort();
    }

    public ClientConnectionManager getManager()
    {
        return manager;
    }

    public HttpConnectionMetrics getMetrics()
    {
        return ensureConnection().getMetrics();
    }

    HttpPoolEntry getPoolEntry()
    {
        return poolEntry;
    }

    public InetAddress getRemoteAddress()
    {
        return ensureConnection().getRemoteAddress();
    }

    public int getRemotePort()
    {
        return ensureConnection().getRemotePort();
    }

    public HttpRoute getRoute()
    {
        return ensurePoolEntry().getEffectiveRoute();
    }

    public SSLSession getSSLSession()
    {
        Object obj = ensureConnection();
        SSLSession sslsession = null;
        obj = ((OperatedClientConnection) (obj)).getSocket();
        if (obj instanceof SSLSocket)
        {
            sslsession = ((SSLSocket)obj).getSession();
        }
        return sslsession;
    }

    public Socket getSocket()
    {
        return ensureConnection().getSocket();
    }

    public int getSocketTimeout()
    {
        return ensureConnection().getSocketTimeout();
    }

    public Object getState()
    {
        return ensurePoolEntry().getState();
    }

    public boolean isMarkedReusable()
    {
        return reusable;
    }

    public boolean isOpen()
    {
        OperatedClientConnection operatedclientconnection = getConnection();
        if (operatedclientconnection != null)
        {
            return operatedclientconnection.isOpen();
        } else
        {
            return false;
        }
    }

    public boolean isResponseAvailable(int i)
        throws IOException
    {
        return ensureConnection().isResponseAvailable(i);
    }

    public boolean isSecure()
    {
        return ensureConnection().isSecure();
    }

    public boolean isStale()
    {
        OperatedClientConnection operatedclientconnection = getConnection();
        if (operatedclientconnection != null)
        {
            return operatedclientconnection.isStale();
        } else
        {
            return true;
        }
    }

    public void layerProtocol(HttpContext httpcontext, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(httpparams, "HTTP parameters");
        this;
        JVM INSTR monitorenter ;
        if (poolEntry == null)
        {
            throw new ConnectionShutdownException();
        }
        break MISSING_BLOCK_LABEL_29;
        httpcontext;
        this;
        JVM INSTR monitorexit ;
        throw httpcontext;
        Object obj;
        obj = poolEntry.getTracker();
        Asserts.notNull(obj, "Route tracker");
        Asserts.check(((RouteTracker) (obj)).isConnected(), "Connection not open");
        Asserts.check(((RouteTracker) (obj)).isTunnelled(), "Protocol layering without a tunnel not supported");
        OperatedClientConnection operatedclientconnection;
        boolean flag;
        if (!((RouteTracker) (obj)).isLayered())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Multiple protocol layering not supported");
        obj = ((RouteTracker) (obj)).getTargetHost();
        operatedclientconnection = (OperatedClientConnection)poolEntry.getConnection();
        this;
        JVM INSTR monitorexit ;
        operator.updateSecureConnection(operatedclientconnection, ((HttpHost) (obj)), httpcontext, httpparams);
        this;
        JVM INSTR monitorenter ;
        if (poolEntry == null)
        {
            throw new InterruptedIOException();
        }
        break MISSING_BLOCK_LABEL_139;
        httpcontext;
        this;
        JVM INSTR monitorexit ;
        throw httpcontext;
        poolEntry.getTracker().layerProtocol(operatedclientconnection.isSecure());
        this;
        JVM INSTR monitorexit ;
    }

    public void markReusable()
    {
        reusable = true;
    }

    public void open(HttpRoute httproute, HttpContext httpcontext, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(httproute, "Route");
        Args.notNull(httpparams, "HTTP parameters");
        this;
        JVM INSTR monitorenter ;
        if (poolEntry == null)
        {
            throw new ConnectionShutdownException();
        }
        break MISSING_BLOCK_LABEL_36;
        httproute;
        this;
        JVM INSTR monitorexit ;
        throw httproute;
        RouteTracker routetracker;
        routetracker = poolEntry.getTracker();
        Asserts.notNull(routetracker, "Route tracker");
        HttpHost httphost1;
        OperatedClientConnection operatedclientconnection;
        boolean flag;
        if (!routetracker.isConnected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Connection already open");
        operatedclientconnection = (OperatedClientConnection)poolEntry.getConnection();
        this;
        JVM INSTR monitorexit ;
        httphost1 = httproute.getProxyHost();
        ClientConnectionOperator clientconnectionoperator = operator;
        HttpHost httphost;
        if (httphost1 != null)
        {
            httphost = httphost1;
        } else
        {
            httphost = httproute.getTargetHost();
        }
        clientconnectionoperator.openConnection(operatedclientconnection, httphost, httproute.getLocalAddress(), httpcontext, httpparams);
        this;
        JVM INSTR monitorenter ;
        if (poolEntry == null)
        {
            throw new InterruptedIOException();
        }
        break MISSING_BLOCK_LABEL_159;
        httproute;
        this;
        JVM INSTR monitorexit ;
        throw httproute;
        httproute = poolEntry.getTracker();
        if (httphost1 != null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        httproute.connectTarget(operatedclientconnection.isSecure());
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        httproute.connectProxy(httphost1, operatedclientconnection.isSecure());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void receiveResponseEntity(HttpResponse httpresponse)
        throws HttpException, IOException
    {
        ensureConnection().receiveResponseEntity(httpresponse);
    }

    public HttpResponse receiveResponseHeader()
        throws HttpException, IOException
    {
        return ensureConnection().receiveResponseHeader();
    }

    public void releaseConnection()
    {
        this;
        JVM INSTR monitorenter ;
        if (poolEntry != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        manager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
        poolEntry = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object removeAttribute(String s)
    {
        OperatedClientConnection operatedclientconnection = ensureConnection();
        if (operatedclientconnection instanceof HttpContext)
        {
            return ((HttpContext)operatedclientconnection).removeAttribute(s);
        } else
        {
            return null;
        }
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpentityenclosingrequest)
        throws HttpException, IOException
    {
        ensureConnection().sendRequestEntity(httpentityenclosingrequest);
    }

    public void sendRequestHeader(HttpRequest httprequest)
        throws HttpException, IOException
    {
        ensureConnection().sendRequestHeader(httprequest);
    }

    public void setAttribute(String s, Object obj)
    {
        OperatedClientConnection operatedclientconnection = ensureConnection();
        if (operatedclientconnection instanceof HttpContext)
        {
            ((HttpContext)operatedclientconnection).setAttribute(s, obj);
        }
    }

    public void setIdleDuration(long l, TimeUnit timeunit)
    {
        if (l > 0L)
        {
            duration = timeunit.toMillis(l);
            return;
        } else
        {
            duration = -1L;
            return;
        }
    }

    public void setSocketTimeout(int i)
    {
        ensureConnection().setSocketTimeout(i);
    }

    public void setState(Object obj)
    {
        ensurePoolEntry().setState(obj);
    }

    public void shutdown()
        throws IOException
    {
        HttpPoolEntry httppoolentry = poolEntry;
        if (httppoolentry != null)
        {
            OperatedClientConnection operatedclientconnection = (OperatedClientConnection)httppoolentry.getConnection();
            httppoolentry.getTracker().reset();
            operatedclientconnection.shutdown();
        }
    }

    public void tunnelProxy(HttpHost httphost, boolean flag, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(httphost, "Next proxy");
        Args.notNull(httpparams, "HTTP parameters");
        this;
        JVM INSTR monitorenter ;
        if (poolEntry == null)
        {
            throw new ConnectionShutdownException();
        }
        break MISSING_BLOCK_LABEL_37;
        httphost;
        this;
        JVM INSTR monitorexit ;
        throw httphost;
        Object obj;
        obj = poolEntry.getTracker();
        Asserts.notNull(obj, "Route tracker");
        Asserts.check(((RouteTracker) (obj)).isConnected(), "Connection not open");
        obj = (OperatedClientConnection)poolEntry.getConnection();
        this;
        JVM INSTR monitorexit ;
        ((OperatedClientConnection) (obj)).update(null, httphost, flag, httpparams);
        this;
        JVM INSTR monitorenter ;
        if (poolEntry == null)
        {
            throw new InterruptedIOException();
        }
        break MISSING_BLOCK_LABEL_110;
        httphost;
        this;
        JVM INSTR monitorexit ;
        throw httphost;
        poolEntry.getTracker().tunnelProxy(httphost, flag);
        this;
        JVM INSTR monitorexit ;
    }

    public void tunnelTarget(boolean flag, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(httpparams, "HTTP parameters");
        this;
        JVM INSTR monitorenter ;
        if (poolEntry == null)
        {
            throw new ConnectionShutdownException();
        }
        break MISSING_BLOCK_LABEL_29;
        httpparams;
        this;
        JVM INSTR monitorexit ;
        throw httpparams;
        Object obj;
        obj = poolEntry.getTracker();
        Asserts.notNull(obj, "Route tracker");
        Asserts.check(((RouteTracker) (obj)).isConnected(), "Connection not open");
        OperatedClientConnection operatedclientconnection;
        boolean flag1;
        if (!((RouteTracker) (obj)).isTunnelled())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Asserts.check(flag1, "Connection is already tunnelled");
        obj = ((RouteTracker) (obj)).getTargetHost();
        operatedclientconnection = (OperatedClientConnection)poolEntry.getConnection();
        this;
        JVM INSTR monitorexit ;
        operatedclientconnection.update(null, ((HttpHost) (obj)), flag, httpparams);
        this;
        JVM INSTR monitorenter ;
        if (poolEntry == null)
        {
            throw new InterruptedIOException();
        }
        break MISSING_BLOCK_LABEL_128;
        httpparams;
        this;
        JVM INSTR monitorexit ;
        throw httpparams;
        poolEntry.getTracker().tunnelTarget(flag);
        this;
        JVM INSTR monitorexit ;
    }

    public void unmarkReusable()
    {
        reusable = false;
    }
}
