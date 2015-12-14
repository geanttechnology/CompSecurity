// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;

// Referenced classes of package org.apache.commons.httpclient.protocol:
//            SecureProtocolSocketFactory, ReflectionSocketFactory, ControllerThreadSocketFactory

public class SSLProtocolSocketFactory
    implements SecureProtocolSocketFactory
{

    private static final SSLProtocolSocketFactory factory = new SSLProtocolSocketFactory();

    public SSLProtocolSocketFactory()
    {
    }

    static SSLProtocolSocketFactory getSocketFactory()
    {
        return factory;
    }

    public Socket createSocket(String s, int i)
        throws IOException, UnknownHostException
    {
        return SSLSocketFactory.getDefault().createSocket(s, i);
    }

    public Socket createSocket(String s, int i, InetAddress inetaddress, int j)
        throws IOException, UnknownHostException
    {
        return SSLSocketFactory.getDefault().createSocket(s, i, inetaddress, j);
    }

    public Socket createSocket(String s, int i, InetAddress inetaddress, int j, HttpConnectionParams httpconnectionparams)
        throws IOException, UnknownHostException, ConnectTimeoutException
    {
        if (httpconnectionparams == null)
        {
            throw new IllegalArgumentException("Parameters may not be null");
        }
        int k = httpconnectionparams.getConnectionTimeout();
        if (k == 0)
        {
            httpconnectionparams = createSocket(s, i, inetaddress, j);
        } else
        {
            Socket socket = ReflectionSocketFactory.createSocket("javax.net.ssl.SSLSocketFactory", s, i, inetaddress, j, k);
            httpconnectionparams = socket;
            if (socket == null)
            {
                return ControllerThreadSocketFactory.createSocket(this, s, i, inetaddress, j, k);
            }
        }
        return httpconnectionparams;
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException, UnknownHostException
    {
        return ((SSLSocketFactory)SSLSocketFactory.getDefault()).createSocket(socket, s, i, flag);
    }

    public boolean equals(Object obj)
    {
        return obj != null && obj.getClass().equals(getClass());
    }

    public int hashCode()
    {
        return getClass().hashCode();
    }

}
