// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nielsen.app.sdk;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

// Referenced classes of package com.nielsen.app.sdk:
//            AppRequestManager

public class a extends SSLSocketFactory
{
    private class a
        implements X509TrustManager
    {

        final AppRequestManager.AppClient.AppSocketFactory a;

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
            return null;
        }

        private a()
        {
            a = AppRequestManager.AppClient.AppSocketFactory.this;
            super();
        }

        a(AppRequestManager._cls1 _pcls1)
        {
            this();
        }
    }


    SSLContext a;
    a b;
    final a c;

    public Socket createSocket()
        throws IOException
    {
        return a.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException, UnknownHostException
    {
        return a.getSocketFactory().createSocket(socket, s, i, flag);
    }

    public a(a a1, KeyStore keystore)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        c = a1;
        super(keystore);
        a = SSLContext.getInstance("TLS");
        b = new a(null);
        a1 = b;
        keystore = a;
        SecureRandom securerandom = new SecureRandom();
        keystore.init(null, new TrustManager[] {
            a1
        }, securerandom);
    }
}
