// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.platforms;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class ConvivaSSLSocketFactory extends SSLSocketFactory
{

    private SSLContext sslContext;

    public ConvivaSSLSocketFactory(SSLContext sslcontext)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        super(null);
        sslContext = SSLContext.getInstance("TLS");
        sslContext = sslcontext;
    }

    public Socket createSocket()
        throws IOException
    {
        return sslContext.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException, UnknownHostException
    {
        return sslContext.getSocketFactory().createSocket(socket, s, i, flag);
    }
}
