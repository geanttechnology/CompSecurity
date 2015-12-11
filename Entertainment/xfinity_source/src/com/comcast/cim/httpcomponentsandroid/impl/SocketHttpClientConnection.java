// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl;

import com.comcast.cim.httpcomponentsandroid.HttpInetConnection;
import com.comcast.cim.httpcomponentsandroid.impl.io.SocketInputBuffer;
import com.comcast.cim.httpcomponentsandroid.impl.io.SocketOutputBuffer;
import com.comcast.cim.httpcomponentsandroid.io.SessionInputBuffer;
import com.comcast.cim.httpcomponentsandroid.io.SessionOutputBuffer;
import com.comcast.cim.httpcomponentsandroid.params.HttpConnectionParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl:
//            AbstractHttpClientConnection

public class SocketHttpClientConnection extends AbstractHttpClientConnection
    implements HttpInetConnection
{

    private volatile boolean open;
    private volatile Socket socket;

    public SocketHttpClientConnection()
    {
        socket = null;
    }

    protected void assertNotOpen()
    {
        if (open)
        {
            throw new IllegalStateException("Connection is already open");
        } else
        {
            return;
        }
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

    protected void bind(Socket socket1, HttpParams httpparams)
        throws IOException
    {
        if (socket1 == null)
        {
            throw new IllegalArgumentException("Socket may not be null");
        }
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            socket = socket1;
            int i = HttpConnectionParams.getSocketBufferSize(httpparams);
            init(createSessionInputBuffer(socket1, i, httpparams), createSessionOutputBuffer(socket1, i, httpparams), httpparams);
            open = true;
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

    protected SessionInputBuffer createSessionInputBuffer(Socket socket1, int i, HttpParams httpparams)
        throws IOException
    {
        return new SocketInputBuffer(socket1, i, httpparams);
    }

    protected SessionOutputBuffer createSessionOutputBuffer(Socket socket1, int i, HttpParams httpparams)
        throws IOException
    {
        return new SocketOutputBuffer(socket1, i, httpparams);
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
