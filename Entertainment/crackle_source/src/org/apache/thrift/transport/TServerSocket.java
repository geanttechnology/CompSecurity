// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.transport:
//            TServerTransport, TTransportException, TSocket, TTransport

public class TServerSocket extends TServerTransport
{

    private static final Logger a = LoggerFactory.getLogger(org/apache/thrift/transport/TServerSocket.getName());
    private ServerSocket b;
    private int c;

    public TServerSocket(int i)
        throws TTransportException
    {
        this(i, 0);
    }

    public TServerSocket(int i, int j)
        throws TTransportException
    {
        this(new InetSocketAddress(i), j);
    }

    public TServerSocket(InetSocketAddress inetsocketaddress)
        throws TTransportException
    {
        this(inetsocketaddress, 0);
    }

    public TServerSocket(InetSocketAddress inetsocketaddress, int i)
        throws TTransportException
    {
        b = null;
        c = 0;
        c = i;
        try
        {
            b = new ServerSocket();
            b.setReuseAddress(true);
            b.bind(inetsocketaddress);
            return;
        }
        catch (IOException ioexception)
        {
            b = null;
        }
        throw new TTransportException((new StringBuilder()).append("Could not create ServerSocket on address ").append(inetsocketaddress.toString()).append(".").toString());
    }

    public TServerSocket(ServerSocket serversocket)
    {
        this(serversocket, 0);
    }

    public TServerSocket(ServerSocket serversocket, int i)
    {
        b = null;
        c = 0;
        b = serversocket;
        c = i;
    }

    protected TSocket acceptImpl()
        throws TTransportException
    {
        if (b == null)
        {
            throw new TTransportException(1, "No underlying server socket.");
        }
        TSocket tsocket;
        try
        {
            tsocket = new TSocket(b.accept());
            tsocket.setTimeout(c);
        }
        catch (IOException ioexception)
        {
            throw new TTransportException(ioexception);
        }
        return tsocket;
    }

    protected volatile TTransport acceptImpl()
        throws TTransportException
    {
        return acceptImpl();
    }

    public void close()
    {
        if (b != null)
        {
            try
            {
                b.close();
            }
            catch (IOException ioexception)
            {
                a.warn("Could not close server socket.", ioexception);
            }
            b = null;
        }
    }

    public void interrupt()
    {
        close();
    }

    public void listen()
        throws TTransportException
    {
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        b.setSoTimeout(0);
        return;
        SocketException socketexception;
        socketexception;
        a.error("Could not set socket timeout.", socketexception);
        return;
    }

}
