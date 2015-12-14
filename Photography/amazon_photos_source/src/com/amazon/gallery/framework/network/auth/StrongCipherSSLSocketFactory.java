// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.auth;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.amazon.gallery.framework.network.auth:
//            AmazonApprovedCiphers

class StrongCipherSSLSocketFactory extends SSLSocketFactory
{

    private final SSLSocketFactory mInnerSSocketFactory;

    StrongCipherSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        mInnerSSocketFactory = sslsocketfactory;
    }

    public Socket createSocket(String s, int i)
        throws IOException, UnknownHostException
    {
        s = mInnerSSocketFactory.createSocket(s, i);
        AmazonApprovedCiphers.enforceStrongCipher(s);
        return s;
    }

    public Socket createSocket(String s, int i, InetAddress inetaddress, int j)
        throws IOException, UnknownHostException
    {
        s = mInnerSSocketFactory.createSocket(s, i, inetaddress, j);
        AmazonApprovedCiphers.enforceStrongCipher(s);
        return s;
    }

    public Socket createSocket(InetAddress inetaddress, int i)
        throws IOException
    {
        inetaddress = mInnerSSocketFactory.createSocket(inetaddress, i);
        AmazonApprovedCiphers.enforceStrongCipher(inetaddress);
        return inetaddress;
    }

    public Socket createSocket(InetAddress inetaddress, int i, InetAddress inetaddress1, int j)
        throws IOException
    {
        inetaddress = mInnerSSocketFactory.createSocket(inetaddress, i, inetaddress1, j);
        AmazonApprovedCiphers.enforceStrongCipher(inetaddress);
        return inetaddress;
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException
    {
        socket = mInnerSSocketFactory.createSocket(socket, s, i, flag);
        AmazonApprovedCiphers.enforceStrongCipher(socket);
        return socket;
    }

    public String[] getDefaultCipherSuites()
    {
        return mInnerSSocketFactory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites()
    {
        return mInnerSSocketFactory.getSupportedCipherSuites();
    }
}
