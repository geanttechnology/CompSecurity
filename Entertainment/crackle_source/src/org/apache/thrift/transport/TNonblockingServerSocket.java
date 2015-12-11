// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

// Referenced classes of package org.apache.thrift.transport:
//            TNonblockingServerTransport, TTransportException, TNonblockingSocket, TTransport

public class TNonblockingServerSocket extends TNonblockingServerTransport
{

    private ServerSocketChannel a;
    private ServerSocket b;
    private int c;
    private int d;

    public TNonblockingServerSocket(int i)
        throws TTransportException
    {
        this(i, 0);
    }

    public TNonblockingServerSocket(int i, int j)
        throws TTransportException
    {
        a = null;
        b = null;
        c = 0;
        d = 0;
        c = i;
        d = j;
        try
        {
            a = ServerSocketChannel.open();
            a.configureBlocking(false);
            b = a.socket();
            b.setReuseAddress(true);
            b.bind(new InetSocketAddress(c));
            return;
        }
        catch (IOException ioexception)
        {
            b = null;
        }
        throw new TTransportException((new StringBuilder()).append("Could not create ServerSocket on port ").append(i).append(".").toString());
    }

    protected TNonblockingSocket acceptImpl()
        throws TTransportException
    {
        if (b == null)
        {
            throw new TTransportException(1, "No underlying server socket.");
        }
        Object obj;
        try
        {
            obj = a.accept();
        }
        catch (IOException ioexception)
        {
            throw new TTransportException(ioexception);
        }
        if (obj == null)
        {
            return null;
        }
        obj = new TNonblockingSocket(((java.nio.channels.SocketChannel) (obj)));
        ((TNonblockingSocket) (obj)).setTimeout(d);
        return ((TNonblockingSocket) (obj));
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
                System.err.println((new StringBuilder()).append("WARNING: Could not close server socket: ").append(ioexception.getMessage()).toString());
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
        socketexception.printStackTrace();
        return;
    }

    public void registerSelector(Selector selector)
    {
        try
        {
            a.register(selector, 16);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Selector selector)
        {
            return;
        }
    }
}
