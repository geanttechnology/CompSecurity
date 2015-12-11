// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

// Referenced classes of package org.apache.thrift.transport:
//            TNonblockingTransport, TTransportException

public class TNonblockingSocket extends TNonblockingTransport
{

    private SocketChannel a;
    private Socket b;
    private int c;

    public TNonblockingSocket(SocketChannel socketchannel)
        throws TTransportException
    {
        a = null;
        b = null;
        c = 0;
        try
        {
            socketchannel.configureBlocking(false);
        }
        // Misplaced declaration of an exception variable
        catch (SocketChannel socketchannel)
        {
            throw new TTransportException(socketchannel);
        }
        a = socketchannel;
        b = socketchannel.socket();
        try
        {
            b.setSoLinger(false, 0);
            b.setTcpNoDelay(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SocketChannel socketchannel)
        {
            socketchannel.printStackTrace();
        }
    }

    public void close()
    {
        try
        {
            a.close();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    public void flush()
        throws TTransportException
    {
    }

    public Socket getSocket()
    {
        if (b == null)
        {
            b = new Socket();
            try
            {
                b.setSoLinger(false, 0);
                b.setTcpNoDelay(true);
                b.setSoTimeout(c);
            }
            catch (SocketException socketexception)
            {
                socketexception.printStackTrace();
            }
        }
        return b;
    }

    public boolean isOpen()
    {
        if (b == null)
        {
            return false;
        } else
        {
            return b.isConnected();
        }
    }

    public void open()
        throws TTransportException
    {
        throw new RuntimeException("Not implemented yet");
    }

    public int read(ByteBuffer bytebuffer)
        throws IOException
    {
        return a.read(bytebuffer);
    }

    public int read(byte abyte0[], int i, int j)
        throws TTransportException
    {
        if ((a.validOps() & 1) != 1)
        {
            throw new TTransportException(1, "Cannot read from write-only socket channel");
        }
        try
        {
            i = a.read(ByteBuffer.wrap(abyte0, i, j));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new TTransportException(0, abyte0);
        }
        return i;
    }

    public SelectionKey registerSelector(Selector selector, int i)
        throws IOException
    {
        return a.register(selector, i);
    }

    public void setTimeout(int i)
    {
        c = i;
        try
        {
            b.setSoTimeout(i);
            return;
        }
        catch (SocketException socketexception)
        {
            socketexception.printStackTrace();
        }
    }

    public int write(ByteBuffer bytebuffer)
        throws IOException
    {
        return a.write(bytebuffer);
    }

    public void write(byte abyte0[], int i, int j)
        throws TTransportException
    {
        if ((a.validOps() & 4) != 4)
        {
            throw new TTransportException(1, "Cannot write to write-only socket channel");
        }
        try
        {
            a.write(ByteBuffer.wrap(abyte0, i, j));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new TTransportException(0, abyte0);
        }
    }
}
