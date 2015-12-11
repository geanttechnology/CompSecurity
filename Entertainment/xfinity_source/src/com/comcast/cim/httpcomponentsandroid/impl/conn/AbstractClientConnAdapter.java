// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn;

import com.comcast.cim.httpcomponentsandroid.HttpConnectionMetrics;
import com.comcast.cim.httpcomponentsandroid.HttpEntityEnclosingRequest;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionManager;
import com.comcast.cim.httpcomponentsandroid.conn.ManagedClientConnection;
import com.comcast.cim.httpcomponentsandroid.conn.OperatedClientConnection;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.conn:
//            ConnectionShutdownException

public abstract class AbstractClientConnAdapter
    implements ManagedClientConnection, HttpContext
{

    private final ClientConnectionManager connManager;
    private volatile long duration;
    private volatile boolean markedReusable;
    private volatile boolean released;
    private volatile OperatedClientConnection wrappedConnection;

    protected AbstractClientConnAdapter(ClientConnectionManager clientconnectionmanager, OperatedClientConnection operatedclientconnection)
    {
        connManager = clientconnectionmanager;
        wrappedConnection = operatedclientconnection;
        markedReusable = false;
        released = false;
        duration = 0x7fffffffffffffffL;
    }

    public void abortConnection()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = released;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        released = true;
        unmarkReusable();
        Exception exception;
        try
        {
            shutdown();
        }
        catch (IOException ioexception) { }
        connManager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
        if (true) goto _L1; else goto _L3
_L3:
        exception;
        throw exception;
    }

    protected final void assertValid(OperatedClientConnection operatedclientconnection)
        throws ConnectionShutdownException
    {
        if (isReleased() || operatedclientconnection == null)
        {
            throw new ConnectionShutdownException();
        } else
        {
            return;
        }
    }

    protected void detach()
    {
        this;
        JVM INSTR monitorenter ;
        wrappedConnection = null;
        duration = 0x7fffffffffffffffL;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void flush()
        throws IOException
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        operatedclientconnection.flush();
    }

    public Object getAttribute(String s)
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        if (operatedclientconnection instanceof HttpContext)
        {
            return ((HttpContext)operatedclientconnection).getAttribute(s);
        } else
        {
            return null;
        }
    }

    public InetAddress getLocalAddress()
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        return operatedclientconnection.getLocalAddress();
    }

    public int getLocalPort()
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        return operatedclientconnection.getLocalPort();
    }

    protected ClientConnectionManager getManager()
    {
        return connManager;
    }

    public HttpConnectionMetrics getMetrics()
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        return operatedclientconnection.getMetrics();
    }

    public InetAddress getRemoteAddress()
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        return operatedclientconnection.getRemoteAddress();
    }

    public int getRemotePort()
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        return operatedclientconnection.getRemotePort();
    }

    public SSLSession getSSLSession()
    {
        Object obj = getWrappedConnection();
        assertValid(((OperatedClientConnection) (obj)));
        if (isOpen())
        {
            if ((obj = ((OperatedClientConnection) (obj)).getSocket()) instanceof SSLSocket)
            {
                return ((SSLSocket)obj).getSession();
            }
        }
        return null;
    }

    public int getSocketTimeout()
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        return operatedclientconnection.getSocketTimeout();
    }

    protected OperatedClientConnection getWrappedConnection()
    {
        return wrappedConnection;
    }

    public boolean isMarkedReusable()
    {
        return markedReusable;
    }

    public boolean isOpen()
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        if (operatedclientconnection == null)
        {
            return false;
        } else
        {
            return operatedclientconnection.isOpen();
        }
    }

    protected boolean isReleased()
    {
        return released;
    }

    public boolean isResponseAvailable(int i)
        throws IOException
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        return operatedclientconnection.isResponseAvailable(i);
    }

    public boolean isSecure()
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        return operatedclientconnection.isSecure();
    }

    public boolean isStale()
    {
        OperatedClientConnection operatedclientconnection;
        if (!isReleased())
        {
            if ((operatedclientconnection = getWrappedConnection()) != null)
            {
                return operatedclientconnection.isStale();
            }
        }
        return true;
    }

    public void markReusable()
    {
        markedReusable = true;
    }

    public void receiveResponseEntity(HttpResponse httpresponse)
        throws HttpException, IOException
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        unmarkReusable();
        operatedclientconnection.receiveResponseEntity(httpresponse);
    }

    public HttpResponse receiveResponseHeader()
        throws HttpException, IOException
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        unmarkReusable();
        return operatedclientconnection.receiveResponseHeader();
    }

    public void releaseConnection()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = released;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        released = true;
        connManager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpentityenclosingrequest)
        throws HttpException, IOException
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        unmarkReusable();
        operatedclientconnection.sendRequestEntity(httpentityenclosingrequest);
    }

    public void sendRequestHeader(HttpRequest httprequest)
        throws HttpException, IOException
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        unmarkReusable();
        operatedclientconnection.sendRequestHeader(httprequest);
    }

    public void setAttribute(String s, Object obj)
    {
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
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
        OperatedClientConnection operatedclientconnection = getWrappedConnection();
        assertValid(operatedclientconnection);
        operatedclientconnection.setSocketTimeout(i);
    }

    public void unmarkReusable()
    {
        markedReusable = false;
    }
}
