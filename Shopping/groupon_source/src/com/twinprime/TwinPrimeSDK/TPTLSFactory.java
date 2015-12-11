// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class TPTLSFactory extends SSLSocketFactory
{

    private static TPTLSFactory tptlsf = null;
    private SSLSocketFactory sslSocketFactory;

    TPTLSFactory()
    {
        sslSocketFactory = null;
        sslSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
    }

    public static SSLSocketFactory getInstance()
    {
        com/twinprime/TwinPrimeSDK/TPTLSFactory;
        JVM INSTR monitorenter ;
        TPTLSFactory tptlsfactory;
        if (tptlsf == null)
        {
            tptlsf = new TPTLSFactory();
        }
        tptlsfactory = tptlsf;
        com/twinprime/TwinPrimeSDK/TPTLSFactory;
        JVM INSTR monitorexit ;
        return tptlsfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public Socket createSocket(String s, int i)
        throws IOException, UnknownHostException
    {
        s = sslSocketFactory.createSocket(s, i);
        s.setTcpNoDelay(true);
        return s;
    }

    public Socket createSocket(String s, int i, InetAddress inetaddress, int j)
        throws IOException, UnknownHostException
    {
        s = sslSocketFactory.createSocket(s, i, inetaddress, j);
        s.setTcpNoDelay(true);
        return s;
    }

    public Socket createSocket(InetAddress inetaddress, int i)
        throws IOException
    {
        inetaddress = sslSocketFactory.createSocket(inetaddress, i);
        inetaddress.setTcpNoDelay(true);
        return inetaddress;
    }

    public Socket createSocket(InetAddress inetaddress, int i, InetAddress inetaddress1, int j)
        throws IOException
    {
        inetaddress = sslSocketFactory.createSocket(inetaddress, i, inetaddress1, j);
        inetaddress.setTcpNoDelay(true);
        return inetaddress;
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException
    {
        socket.setTcpNoDelay(true);
        socket = sslSocketFactory.createSocket(socket, s, i, flag);
        socket.setTcpNoDelay(true);
        return socket;
    }

    public String[] getDefaultCipherSuites()
    {
        return sslSocketFactory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites()
    {
        return sslSocketFactory.getSupportedCipherSuites();
    }

}
