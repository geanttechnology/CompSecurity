// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

public class MySSLSocketFactory extends SSLSocketFactory
{

    SSLContext sslContext;

    public MySSLSocketFactory(KeyStore keystore)
    {
        super(keystore);
        sslContext = SSLContext.getInstance("TLS");
        keystore = new X509TrustManager() {

            final MySSLSocketFactory this$0;

            public void checkClientTrusted(X509Certificate ax509certificate[], String s)
            {
            }

            public void checkServerTrusted(X509Certificate ax509certificate[], String s)
            {
            }

            public X509Certificate[] getAcceptedIssuers()
            {
                return null;
            }

            
            {
                this$0 = MySSLSocketFactory.this;
                super();
            }
        };
        sslContext.init(null, new TrustManager[] {
            keystore
        }, null);
    }

    public static SSLSocketFactory getFixedSocketFactory()
    {
        MySSLSocketFactory mysslsocketfactory;
        try
        {
            mysslsocketfactory = new MySSLSocketFactory(getKeystore());
            mysslsocketfactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return SSLSocketFactory.getSocketFactory();
        }
        return mysslsocketfactory;
    }

    public static KeyStore getKeystore()
    {
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(null, null);
        return keystore;
        Throwable throwable;
        throwable;
        keystore = null;
_L2:
        throwable.printStackTrace();
        return keystore;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static KeyStore getKeystoreOfCA(InputStream inputstream)
    {
        Object obj1 = null;
        Object obj;
        CertificateFactory certificatefactory;
        certificatefactory = CertificateFactory.getInstance("X.509");
        obj = new BufferedInputStream(inputstream);
        inputstream = ((InputStream) (obj));
        obj1 = certificatefactory.generateCertificate(((InputStream) (obj)));
        inputstream = ((InputStream) (obj1));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        ((InputStream) (obj)).close();
        inputstream = ((InputStream) (obj1));
_L1:
        obj = KeyStore.getDefaultType();
        obj = KeyStore.getInstance(((String) (obj)));
        ((KeyStore) (obj)).load(null, null);
        ((KeyStore) (obj)).setCertificateEntry("ca", inputstream);
        return ((KeyStore) (obj));
        inputstream;
        inputstream.printStackTrace();
        inputstream = ((InputStream) (obj1));
          goto _L1
        obj1;
        obj = null;
_L6:
        inputstream = ((InputStream) (obj));
        ((CertificateException) (obj1)).printStackTrace();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        ((InputStream) (obj)).close();
        inputstream = null;
          goto _L1
        inputstream;
        inputstream.printStackTrace();
        inputstream = null;
          goto _L1
        inputstream;
        obj = obj1;
_L5:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw inputstream;
        obj;
        inputstream = null;
_L3:
        ((Exception) (obj)).printStackTrace();
        return inputstream;
        obj1;
        inputstream = ((InputStream) (obj));
        obj = obj1;
        if (true) goto _L3; else goto _L2
_L2:
        obj1;
        obj = inputstream;
        inputstream = ((InputStream) (obj1));
        if (true) goto _L5; else goto _L4
_L4:
        obj1;
          goto _L6
    }

    public static DefaultHttpClient getNewHttpClient(KeyStore keystore)
    {
        try
        {
            Object obj = new MySSLSocketFactory(keystore);
            keystore = new SchemeRegistry();
            keystore.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            keystore.register(new Scheme("https", ((org.apache.http.conn.scheme.SocketFactory) (obj)), 443));
            obj = new BasicHttpParams();
            HttpProtocolParams.setVersion(((org.apache.http.params.HttpParams) (obj)), HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(((org.apache.http.params.HttpParams) (obj)), "UTF-8");
            keystore = new DefaultHttpClient(new ThreadSafeClientConnManager(((org.apache.http.params.HttpParams) (obj)), keystore), ((org.apache.http.params.HttpParams) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (KeyStore keystore)
        {
            return new DefaultHttpClient();
        }
        return keystore;
    }

    public Socket createSocket()
    {
        return sslContext.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
    {
        return sslContext.getSocketFactory().createSocket(socket, s, i, flag);
    }

    public void fixHttpsURLConnection()
    {
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    }
}
