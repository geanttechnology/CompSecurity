// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.Socket;

// Referenced classes of package cz.msebera.android.httpclient.impl:
//            SocketHttpServerConnection

public class DefaultHttpServerConnection extends SocketHttpServerConnection
{

    public DefaultHttpServerConnection()
    {
    }

    public void bind(Socket socket, HttpParams httpparams)
        throws IOException
    {
        boolean flag1 = true;
        Args.notNull(socket, "Socket");
        Args.notNull(httpparams, "HTTP parameters");
        assertNotOpen();
        socket.setTcpNoDelay(httpparams.getBooleanParameter("http.tcp.nodelay", true));
        socket.setSoTimeout(httpparams.getIntParameter("http.socket.timeout", 0));
        socket.setKeepAlive(httpparams.getBooleanParameter("http.socket.keepalive", false));
        int i = httpparams.getIntParameter("http.socket.linger", -1);
        boolean flag;
        if (i >= 0)
        {
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            socket.setSoLinger(flag, i);
        }
        if (i >= 0)
        {
            if (i > 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            socket.setSoLinger(flag, i);
        }
        super.bind(socket, httpparams);
    }
}
