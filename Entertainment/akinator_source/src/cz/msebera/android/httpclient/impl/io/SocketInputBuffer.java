// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.Socket;

// Referenced classes of package cz.msebera.android.httpclient.impl.io:
//            AbstractSessionInputBuffer

public class SocketInputBuffer extends AbstractSessionInputBuffer
    implements EofSensor
{

    private boolean eof;
    private final Socket socket;

    public SocketInputBuffer(Socket socket1, int i, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(socket1, "Socket");
        socket = socket1;
        eof = false;
        int j = i;
        i = j;
        if (j < 0)
        {
            i = socket1.getReceiveBufferSize();
        }
        j = i;
        if (i < 1024)
        {
            j = 1024;
        }
        init(socket1.getInputStream(), j, httpparams);
    }

    protected int fillBuffer()
        throws IOException
    {
        int i = super.fillBuffer();
        boolean flag;
        if (i == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eof = flag;
        return i;
    }

    public boolean isDataAvailable(int i)
        throws IOException
    {
        int j;
        boolean flag;
        boolean flag1 = hasBufferedData();
        flag = flag1;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        j = socket.getSoTimeout();
        socket.setSoTimeout(i);
        fillBuffer();
        flag = hasBufferedData();
        socket.setSoTimeout(j);
        return flag;
        Exception exception;
        exception;
        socket.setSoTimeout(j);
        throw exception;
    }

    public boolean isEof()
    {
        return eof;
    }
}
