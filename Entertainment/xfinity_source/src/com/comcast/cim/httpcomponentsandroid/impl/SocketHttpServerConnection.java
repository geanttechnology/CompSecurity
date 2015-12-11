// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl;

import com.comcast.cim.httpcomponentsandroid.HttpInetConnection;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl:
//            AbstractHttpServerConnection

public class SocketHttpServerConnection extends AbstractHttpServerConnection
    implements HttpInetConnection
{

    private volatile boolean open;
    private volatile Socket socket;

    public SocketHttpServerConnection()
    {
        socket = null;
    }

    protected void assertOpen()
    {
        if (!open)
        {
            throw new IllegalStateException("Connection is not open");
        } else
        {
            return;
        }
    }

    public void close()
        throws IOException
    {
        Socket socket1;
        if (!open)
        {
            return;
        }
        open = false;
        open = false;
        socket1 = socket;
        doFlush();
        Exception exception;
        try
        {
            socket1.shutdownOutput();
        }
        catch (IOException ioexception) { }
        try
        {
            socket1.shutdownInput();
        }
        catch (IOException ioexception1) { }
_L2:
        socket1.close();
        return;
        exception;
        socket1.close();
        throw exception;
        UnsupportedOperationException unsupportedoperationexception;
        unsupportedoperationexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public InetAddress getLocalAddress()
    {
        if (socket != null)
        {
            return socket.getLocalAddress();
        } else
        {
            return null;
        }
    }

    public int getLocalPort()
    {
        if (socket != null)
        {
            return socket.getLocalPort();
        } else
        {
            return -1;
        }
    }

    public InetAddress getRemoteAddress()
    {
        if (socket != null)
        {
            return socket.getInetAddress();
        } else
        {
            return null;
        }
    }

    public int getRemotePort()
    {
        if (socket != null)
        {
            return socket.getPort();
        } else
        {
            return -1;
        }
    }

    protected Socket getSocket()
    {
        return socket;
    }

    public int getSocketTimeout()
    {
        int i = -1;
        if (socket != null)
        {
            try
            {
                i = socket.getSoTimeout();
            }
            catch (SocketException socketexception)
            {
                return -1;
            }
        }
        return i;
    }

    public boolean isOpen()
    {
        return open;
    }

    public void setSocketTimeout(int i)
    {
        assertOpen();
        if (socket == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        socket.setSoTimeout(i);
        return;
        SocketException socketexception;
        socketexception;
    }

    public void shutdown()
        throws IOException
    {
        open = false;
        Socket socket1 = socket;
        if (socket1 != null)
        {
            socket1.close();
        }
    }
}
