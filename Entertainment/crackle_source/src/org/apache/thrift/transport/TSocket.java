// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.transport:
//            TIOStreamTransport, TTransportException

public class TSocket extends TIOStreamTransport
{

    private static final Logger a = LoggerFactory.getLogger(org/apache/thrift/transport/TSocket.getName());
    private Socket b;
    private String c;
    private int d;
    private int e;

    public TSocket(String s, int i)
    {
        this(s, i, 0);
    }

    public TSocket(String s, int i, int j)
    {
        b = null;
        c = null;
        d = 0;
        e = 0;
        c = s;
        d = i;
        e = j;
        a();
    }

    public TSocket(Socket socket)
        throws TTransportException
    {
        b = null;
        c = null;
        d = 0;
        e = 0;
        b = socket;
        try
        {
            b.setSoLinger(false, 0);
            b.setTcpNoDelay(true);
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            a.warn("Could not configure socket.", socket);
        }
        if (!isOpen())
        {
            break MISSING_BLOCK_LABEL_95;
        }
        inputStream_ = new BufferedInputStream(b.getInputStream(), 1024);
        outputStream_ = new BufferedOutputStream(b.getOutputStream(), 1024);
        return;
        socket;
        close();
        throw new TTransportException(1, socket);
    }

    private void a()
    {
        b = new Socket();
        try
        {
            b.setSoLinger(false, 0);
            b.setTcpNoDelay(true);
            b.setSoTimeout(e);
            return;
        }
        catch (SocketException socketexception)
        {
            a.error("Could not configure socket.", socketexception);
        }
    }

    public void close()
    {
        super.close();
        if (b != null)
        {
            try
            {
                b.close();
            }
            catch (IOException ioexception)
            {
                a.warn("Could not close socket.", ioexception);
            }
            b = null;
        }
    }

    public Socket getSocket()
    {
        if (b == null)
        {
            a();
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
        if (isOpen())
        {
            throw new TTransportException(2, "Socket already connected.");
        }
        if (c.length() == 0)
        {
            throw new TTransportException(1, "Cannot open null host.");
        }
        if (d <= 0)
        {
            throw new TTransportException(1, "Cannot open without port.");
        }
        if (b == null)
        {
            a();
        }
        try
        {
            b.connect(new InetSocketAddress(c, d));
            inputStream_ = new BufferedInputStream(b.getInputStream(), 1024);
            outputStream_ = new BufferedOutputStream(b.getOutputStream(), 1024);
            return;
        }
        catch (IOException ioexception)
        {
            close();
            throw new TTransportException(1, ioexception);
        }
    }

    public void setTimeout(int i)
    {
        e = i;
        try
        {
            b.setSoTimeout(i);
            return;
        }
        catch (SocketException socketexception)
        {
            a.warn("Could not set socket timeout.", socketexception);
        }
    }

}
