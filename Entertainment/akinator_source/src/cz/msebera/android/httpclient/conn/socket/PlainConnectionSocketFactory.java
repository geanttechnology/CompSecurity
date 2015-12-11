// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.socket;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

// Referenced classes of package cz.msebera.android.httpclient.conn.socket:
//            ConnectionSocketFactory

public class PlainConnectionSocketFactory
    implements ConnectionSocketFactory
{

    public static final PlainConnectionSocketFactory INSTANCE = new PlainConnectionSocketFactory();

    public PlainConnectionSocketFactory()
    {
    }

    public static PlainConnectionSocketFactory getSocketFactory()
    {
        return INSTANCE;
    }

    public Socket connectSocket(int i, Socket socket, HttpHost httphost, InetSocketAddress inetsocketaddress, InetSocketAddress inetsocketaddress1, HttpContext httpcontext)
        throws IOException
    {
        if (socket == null)
        {
            socket = createSocket(httpcontext);
        }
        if (inetsocketaddress1 != null)
        {
            socket.bind(inetsocketaddress1);
        }
        try
        {
            socket.connect(inetsocketaddress, i);
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            try
            {
                socket.close();
            }
            // Misplaced declaration of an exception variable
            catch (Socket socket) { }
            throw httphost;
        }
        return socket;
    }

    public Socket createSocket(HttpContext httpcontext)
        throws IOException
    {
        return new Socket();
    }

}
