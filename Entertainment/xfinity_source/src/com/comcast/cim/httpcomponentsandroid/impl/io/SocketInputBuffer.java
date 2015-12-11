// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.io;

import com.comcast.cim.httpcomponentsandroid.io.EofSensor;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.io:
//            AbstractSessionInputBuffer

public class SocketInputBuffer extends AbstractSessionInputBuffer
    implements EofSensor
{

    private static final Class SOCKET_TIMEOUT_CLASS = SocketTimeoutExceptionClass();
    private boolean eof;
    private final Socket socket;

    public SocketInputBuffer(Socket socket1, int i, HttpParams httpparams)
        throws IOException
    {
        if (socket1 == null)
        {
            throw new IllegalArgumentException("Socket may not be null");
        }
        socket = socket1;
        eof = false;
        int j = i;
        if (i < 0)
        {
            j = socket1.getReceiveBufferSize();
        }
        i = j;
        if (j < 1024)
        {
            i = 1024;
        }
        init(socket1.getInputStream(), i, httpparams);
    }

    private static Class SocketTimeoutExceptionClass()
    {
        Class class1;
        try
        {
            class1 = Class.forName("java.net.SocketTimeoutException");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return null;
        }
        return class1;
    }

    private static boolean isSocketTimeoutException(InterruptedIOException interruptedioexception)
    {
        if (SOCKET_TIMEOUT_CLASS != null)
        {
            return SOCKET_TIMEOUT_CLASS.isInstance(interruptedioexception);
        } else
        {
            return true;
        }
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
        boolean flag1;
        flag1 = hasBufferedData();
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
        Object obj;
        obj;
        if (!isSocketTimeoutException(((InterruptedIOException) (obj))))
        {
            throw obj;
        }
        break MISSING_BLOCK_LABEL_74;
        obj;
        socket.setSoTimeout(j);
        throw obj;
        socket.setSoTimeout(j);
        return flag1;
    }

    public boolean isEof()
    {
        return eof;
    }

}
