// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.b;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.b:
//            d

class tSocketFactory
    implements LayeredSocketFactory
{

    SSLSocketFactory a;
    final d b;

    private void a(Socket socket, String s)
    {
        try
        {
            Field field = java/net/InetAddress.getDeclaredField("hostName");
            field.setAccessible(true);
            field.set(socket.getInetAddress(), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            return;
        }
    }

    public Socket connectSocket(Socket socket, String s, int i, InetAddress inetaddress, int j, HttpParams httpparams)
        throws IOException
    {
        return a.connectSocket(socket, s, i, inetaddress, j, httpparams);
    }

    public Socket createSocket()
        throws IOException
    {
        return a.createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException
    {
        a(socket, s);
        return a.createSocket(socket, s, i, flag);
    }

    public boolean isSecure(Socket socket)
        throws IllegalArgumentException
    {
        return a.isSecure(socket);
    }

    tory(d d1)
    {
        b = d1;
        super();
        a = SSLSocketFactory.getSocketFactory();
    }
}
