// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import android.net.SSLCertificateSocketFactory;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class d extends SSLSocketFactory
{

    private SSLSocketFactory a;

    private d()
    {
    }

    public static d a()
    {
        d d1 = new d();
        d1.a = SSLCertificateSocketFactory.getDefault(10000, null);
        return d1;
    }

    private static void a(Socket socket)
    {
        if (socket instanceof SSLSocket)
        {
            socket = (SSLSocket)socket;
            socket.setEnabledProtocols(socket.getSupportedProtocols());
        }
    }

    public final Socket createSocket()
    {
        Socket socket = a.createSocket();
        a(socket);
        return socket;
    }

    public final Socket createSocket(String s, int i)
    {
        s = a.createSocket(s, i);
        a(s);
        return s;
    }

    public final Socket createSocket(String s, int i, InetAddress inetaddress, int j)
    {
        s = a.createSocket(s, i, inetaddress, j);
        a(s);
        return s;
    }

    public final Socket createSocket(InetAddress inetaddress, int i)
    {
        inetaddress = a.createSocket(inetaddress, i);
        a(inetaddress);
        return inetaddress;
    }

    public final Socket createSocket(InetAddress inetaddress, int i, InetAddress inetaddress1, int j)
    {
        inetaddress = a.createSocket(inetaddress, i, inetaddress1, j);
        a(inetaddress);
        return inetaddress;
    }

    public final Socket createSocket(Socket socket, String s, int i, boolean flag)
    {
        socket = a.createSocket(socket, s, i, flag);
        a(socket);
        return socket;
    }

    public final String[] getDefaultCipherSuites()
    {
        return a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites()
    {
        return a.getSupportedCipherSuites();
    }
}
