// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class SelfSignedCertSocketFactory
    implements LayeredSocketFactory, SocketFactory
{
    public static class TrustAllCerts
        implements X509TrustManager
    {

        private static final X509Certificate _acceptedIssuers[] = new X509Certificate[0];

        public void checkClientTrusted(X509Certificate ax509certificate[], String s)
            throws CertificateException
        {
        }

        public void checkServerTrusted(X509Certificate ax509certificate[], String s)
            throws CertificateException
        {
        }

        public X509Certificate[] getAcceptedIssuers()
        {
            return _acceptedIssuers;
        }

        public boolean isClientTrusted(X509Certificate ax509certificate[])
        {
            return true;
        }

        public boolean isServerTrusted(X509Certificate ax509certificate[])
        {
            return true;
        }


        public TrustAllCerts()
        {
        }
    }


    private SSLContext sslContext;

    SelfSignedCertSocketFactory()
    {
        sslContext = null;
    }

    private static SSLContext createTrustingSslContext()
        throws IOException
    {
        SSLContext sslcontext;
        try
        {
            sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, new TrustManager[] {
                new TrustAllCerts()
            }, null);
        }
        catch (Exception exception)
        {
            throw new IOException(exception.getMessage());
        }
        return sslcontext;
    }

    private SSLContext getSSLContext()
        throws IOException
    {
        if (sslContext == null)
        {
            sslContext = createTrustingSslContext();
        }
        return sslContext;
    }

    public Socket connectSocket(Socket socket, String s, int i, InetAddress inetaddress, int j, HttpParams httpparams)
        throws IOException, UnknownHostException, ConnectTimeoutException
    {
        int k = HttpConnectionParams.getConnectionTimeout(httpparams);
        int l = HttpConnectionParams.getSoTimeout(httpparams);
        s = new InetSocketAddress(s, i);
        if (socket == null)
        {
            socket = createSocket();
        }
        socket = (SSLSocket)(SSLSocket)socket;
        if (inetaddress != null || j > 0)
        {
            i = j;
            if (j < 0)
            {
                i = 0;
            }
            socket.bind(new InetSocketAddress(inetaddress, i));
        }
        socket.connect(s, k);
        socket.setSoTimeout(l);
        return socket;
    }

    public Socket createSocket()
        throws IOException
    {
        return getSSLContext().getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException, UnknownHostException
    {
        return getSSLContext().getSocketFactory().createSocket(socket, s, i, flag);
    }

    public boolean isSecure(Socket socket)
        throws IllegalArgumentException
    {
        return true;
    }
}
