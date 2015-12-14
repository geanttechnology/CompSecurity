// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import android.net.SSLCertificateSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class CustomSSLSocketFactory extends SSLSocketFactory
{

    private SSLSocketFactory mCertificateSocketFactory;

    private CustomSSLSocketFactory()
    {
    }

    private void enableTlsIfAvailable(Socket socket)
    {
        if (socket instanceof SSLSocket)
        {
            socket = (SSLSocket)socket;
            socket.setEnabledProtocols(socket.getSupportedProtocols());
        }
    }

    public static CustomSSLSocketFactory getDefault(int i)
    {
        CustomSSLSocketFactory customsslsocketfactory = new CustomSSLSocketFactory();
        customsslsocketfactory.mCertificateSocketFactory = SSLCertificateSocketFactory.getDefault(i, null);
        return customsslsocketfactory;
    }

    public Socket createSocket()
        throws IOException
    {
        Socket socket = mCertificateSocketFactory.createSocket();
        enableTlsIfAvailable(socket);
        return socket;
    }

    public Socket createSocket(String s, int i)
        throws IOException, UnknownHostException
    {
        s = mCertificateSocketFactory.createSocket(s, i);
        enableTlsIfAvailable(s);
        return s;
    }

    public Socket createSocket(String s, int i, InetAddress inetaddress, int j)
        throws IOException, UnknownHostException
    {
        s = mCertificateSocketFactory.createSocket(s, i, inetaddress, j);
        enableTlsIfAvailable(s);
        return s;
    }

    public Socket createSocket(InetAddress inetaddress, int i)
        throws IOException
    {
        inetaddress = mCertificateSocketFactory.createSocket(inetaddress, i);
        enableTlsIfAvailable(inetaddress);
        return inetaddress;
    }

    public Socket createSocket(InetAddress inetaddress, int i, InetAddress inetaddress1, int j)
        throws IOException
    {
        inetaddress = mCertificateSocketFactory.createSocket(inetaddress, i, inetaddress1, j);
        enableTlsIfAvailable(inetaddress);
        return inetaddress;
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException
    {
        socket = mCertificateSocketFactory.createSocket(socket, s, i, flag);
        enableTlsIfAvailable(socket);
        return socket;
    }

    public String[] getDefaultCipherSuites()
    {
        return mCertificateSocketFactory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites()
    {
        return mCertificateSocketFactory.getSupportedCipherSuites();
    }
}
