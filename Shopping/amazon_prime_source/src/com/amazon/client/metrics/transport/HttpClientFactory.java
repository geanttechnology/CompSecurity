// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.transport;

import android.net.http.AndroidHttpClient;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpClientFactory
{
    static final class Protocol extends Enum
    {

        private static final Protocol $VALUES[];
        public static final Protocol HTTP;
        public static final Protocol HTTPS;
        private final int mPort;
        private final String mScheme;

        public static Protocol valueOf(String s)
        {
            return (Protocol)Enum.valueOf(com/amazon/client/metrics/transport/HttpClientFactory$Protocol, s);
        }

        public static Protocol[] values()
        {
            return (Protocol[])$VALUES.clone();
        }

        public final int getPort()
        {
            return mPort;
        }

        public final String getScheme()
        {
            return mScheme;
        }

        static 
        {
            HTTP = new Protocol("HTTP", 0, 80, "http");
            HTTPS = new Protocol("HTTPS", 1, 443, "https");
            $VALUES = (new Protocol[] {
                HTTP, HTTPS
            });
        }

        private Protocol(String s, int i, int j, String s1)
        {
            super(s, i);
            mPort = j;
            mScheme = s1;
        }
    }


    public HttpClientFactory()
    {
    }

    public static HttpClient getHttpClient(String s)
    {
        return AndroidHttpClient.newInstance(s);
    }

    public static HttpClient getSecureHttpClient(String s)
        throws NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException, UnrecoverableKeyException
    {
        SSLSocketFactory sslsocketfactory = SSLSocketFactory.getSocketFactory();
        sslsocketfactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
        HttpProtocolParams.setUserAgent(basichttpparams, s);
        s = new SchemeRegistry();
        s.register(new Scheme(Protocol.HTTPS.getScheme(), sslsocketfactory, Protocol.HTTPS.getPort()));
        s.register(new Scheme(Protocol.HTTP.getScheme(), sslsocketfactory, Protocol.HTTP.getPort()));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, s), basichttpparams);
    }
}
