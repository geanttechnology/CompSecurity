// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;

// Referenced classes of package org.apache.commons.httpclient.protocol:
//            ProtocolSocketFactory, ReflectionSocketFactory, ControllerThreadSocketFactory

public class DefaultProtocolSocketFactory
    implements ProtocolSocketFactory
{

    private static final DefaultProtocolSocketFactory factory = new DefaultProtocolSocketFactory();

    public DefaultProtocolSocketFactory()
    {
    }

    static DefaultProtocolSocketFactory getSocketFactory()
    {
        return factory;
    }

    public Socket createSocket(String s, int i)
        throws IOException, UnknownHostException
    {
        return new Socket(s, i);
    }

    public Socket createSocket(String s, int i, InetAddress inetaddress, int j)
        throws IOException, UnknownHostException
    {
        return new Socket(s, i, inetaddress, j);
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
            Socket socket = ReflectionSocketFactory.createSocket("javax.net.SocketFactory", s, i, inetaddress, j, k);
            httpconnectionparams = socket;
            if (socket == null)
            {
                return ControllerThreadSocketFactory.createSocket(this, s, i, inetaddress, j, k);
            }
        }
        return httpconnectionparams;
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
