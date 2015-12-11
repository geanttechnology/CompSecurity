// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSession;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            ConnectionShutdownException, CPoolEntry

class CPoolProxy
    implements ManagedHttpClientConnection, HttpContext
{

    private volatile CPoolEntry poolEntry;

    CPoolProxy(CPoolEntry cpoolentry)
    {
        poolEntry = cpoolentry;
    }

    public static CPoolEntry detach(HttpClientConnection httpclientconnection)
    {
        return getProxy(httpclientconnection).detach();
    }

    public static CPoolEntry getPoolEntry(HttpClientConnection httpclientconnection)
    {
        httpclientconnection = getProxy(httpclientconnection).getPoolEntry();
        if (httpclientconnection == null)
        {
            throw new ConnectionShutdownException();
        } else
        {
            return httpclientconnection;
        }
    }

    private static CPoolProxy getProxy(HttpClientConnection httpclientconnection)
    {
        if (!cz/msebera/android/httpclient/impl/conn/CPoolProxy.isInstance(httpclientconnection))
        {
            throw new IllegalStateException((new StringBuilder()).append("Unexpected connection proxy class: ").append(httpclientconnection.getClass()).toString());
        } else
        {
            return (CPoolProxy)cz/msebera/android/httpclient/impl/conn/CPoolProxy.cast(httpclientconnection);
        }
    }

    public static HttpClientConnection newProxy(CPoolEntry cpoolentry)
    {
        return new CPoolProxy(cpoolentry);
    }

    public void bind(Socket socket)
        throws IOException
    {
        getValidConnection().bind(socket);
    }

    public void close()
        throws IOException
    {
        CPoolEntry cpoolentry = poolEntry;
        if (cpoolentry != null)
        {
            cpoolentry.closeConnection();
        }
    }

    CPoolEntry detach()
    {
        CPoolEntry cpoolentry = poolEntry;
        poolEntry = null;
        return cpoolentry;
    }

    public void flush()
        throws IOException
    {
        getValidConnection().flush();
    }

    public Object getAttribute(String s)
    {
        ManagedHttpClientConnection managedhttpclientconnection = getValidConnection();
        if (managedhttpclientconnection instanceof HttpContext)
        {
            return ((HttpContext)managedhttpclientconnection).getAttribute(s);
        } else
        {
            return null;
        }
    }

    ManagedHttpClientConnection getConnection()
    {
        CPoolEntry cpoolentry = poolEntry;
        if (cpoolentry == null)
        {
            return null;
        } else
        {
            return (ManagedHttpClientConnection)cpoolentry.getConnection();
        }
    }

    public String getId()
    {
        return getValidConnection().getId();
    }

    public InetAddress getLocalAddress()
    {
        return getValidConnection().getLocalAddress();
    }

    public int getLocalPort()
    {
        return getValidConnection().getLocalPort();
    }

    public HttpConnectionMetrics getMetrics()
    {
        return getValidConnection().getMetrics();
    }

    CPoolEntry getPoolEntry()
    {
        return poolEntry;
    }

    public InetAddress getRemoteAddress()
    {
        return getValidConnection().getRemoteAddress();
    }

    public int getRemotePort()
    {
        return getValidConnection().getRemotePort();
    }

    public SSLSession getSSLSession()
    {
        return getValidConnection().getSSLSession();
    }

    public Socket getSocket()
    {
        return getValidConnection().getSocket();
    }

    public int getSocketTimeout()
    {
        return getValidConnection().getSocketTimeout();
    }

    ManagedHttpClientConnection getValidConnection()
    {
        ManagedHttpClientConnection managedhttpclientconnection = getConnection();
        if (managedhttpclientconnection == null)
        {
            throw new ConnectionShutdownException();
        } else
        {
            return managedhttpclientconnection;
        }
    }

    public boolean isOpen()
    {
        boolean flag1 = false;
        CPoolEntry cpoolentry = poolEntry;
        boolean flag = flag1;
        if (cpoolentry != null)
        {
            flag = flag1;
            if (!cpoolentry.isClosed())
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isResponseAvailable(int i)
        throws IOException
    {
        return getValidConnection().isResponseAvailable(i);
    }

    public boolean isStale()
    {
        ManagedHttpClientConnection managedhttpclientconnection = getConnection();
        if (managedhttpclientconnection != null)
        {
            return managedhttpclientconnection.isStale();
        } else
        {
            return true;
        }
    }

    public void receiveResponseEntity(HttpResponse httpresponse)
        throws HttpException, IOException
    {
        getValidConnection().receiveResponseEntity(httpresponse);
    }

    public HttpResponse receiveResponseHeader()
        throws HttpException, IOException
    {
        return getValidConnection().receiveResponseHeader();
    }

    public Object removeAttribute(String s)
    {
        ManagedHttpClientConnection managedhttpclientconnection = getValidConnection();
        if (managedhttpclientconnection instanceof HttpContext)
        {
            return ((HttpContext)managedhttpclientconnection).removeAttribute(s);
        } else
        {
            return null;
        }
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpentityenclosingrequest)
        throws HttpException, IOException
    {
        getValidConnection().sendRequestEntity(httpentityenclosingrequest);
    }

    public void sendRequestHeader(HttpRequest httprequest)
        throws HttpException, IOException
    {
        getValidConnection().sendRequestHeader(httprequest);
    }

    public void setAttribute(String s, Object obj)
    {
        ManagedHttpClientConnection managedhttpclientconnection = getValidConnection();
        if (managedhttpclientconnection instanceof HttpContext)
        {
            ((HttpContext)managedhttpclientconnection).setAttribute(s, obj);
        }
    }

    public void setSocketTimeout(int i)
    {
        getValidConnection().setSocketTimeout(i);
    }

    public void shutdown()
        throws IOException
    {
        CPoolEntry cpoolentry = poolEntry;
        if (cpoolentry != null)
        {
            cpoolentry.shutdownConnection();
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("CPoolProxy{");
        ManagedHttpClientConnection managedhttpclientconnection = getConnection();
        if (managedhttpclientconnection != null)
        {
            stringbuilder.append(managedhttpclientconnection);
        } else
        {
            stringbuilder.append("detached");
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }
}
