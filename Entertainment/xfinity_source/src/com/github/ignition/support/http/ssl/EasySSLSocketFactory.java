// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support.http.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.github.ignition.support.http.ssl:
//            TrivialTrustManager

public class EasySSLSocketFactory
    implements LayeredSocketFactory, SocketFactory
{

    private SSLContext sslcontext;

    public EasySSLSocketFactory()
    {
        sslcontext = null;
    }

    private static SSLContext createEasySSLContext()
        throws IOException
    {
        SSLContext sslcontext1;
        try
        {
            sslcontext1 = SSLContext.getInstance("TLS");
            sslcontext1.init(null, new TrustManager[] {
                new TrivialTrustManager()
            }, null);
        }
        catch (Exception exception)
        {
            throw new IOException(exception.getMessage());
        }
        return sslcontext1;
    }

    private SSLContext getSSLContext()
        throws IOException
    {
        if (sslcontext == null)
        {
            sslcontext = createEasySSLContext();
        }
        return sslcontext;
    }

    public Socket connectSocket(Socket socket, String s, int i, InetAddress inetaddress, int j, HttpParams httpparams)
        throws IOException, UnknownHostException, ConnectTimeoutException
    {
        int k = HttpConnectionParams.getConnectionTimeout(httpparams);
        int l = HttpConnectionParams.getSoTimeout(httpparams);
        s = new InetSocketAddress(s, i);
        if (socket == null)
        {
            socket = createSocket();
        }
        socket = (SSLSocket)(SSLSocket)socket;
        if (inetaddress != null || j > 0)
        {
            i = j;
            if (j < 0)
            {
                i = 0;
            }
            socket.bind(new InetSocketAddress(inetaddress, i));
        }
        socket.connect(s, k);
        socket.setSoTimeout(l);
        return socket;
    }

    public Socket createSocket()
        throws IOException
    {
        return getSSLContext().getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException, UnknownHostException
    {
        return getSSLContext().getSocketFactory().createSocket();
    }

    public boolean equals(Object obj)
    {
        return obj != null && obj.getClass().equals(com/github/ignition/support/http/ssl/EasySSLSocketFactory);
    }

    public int hashCode()
    {
        return com/github/ignition/support/http/ssl/EasySSLSocketFactory.hashCode();
    }

    public boolean isSecure(Socket socket)
        throws IllegalArgumentException
    {
        return true;
    }
}
