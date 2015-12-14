// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class zm extends SSLSocketFactory
{

    SSLContext a;

    public zm(KeyStore keystore)
    {
        super(keystore);
        a = SSLContext.getInstance("TLS");
        keystore = new X509TrustManager() {

            final zm a;

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
                a = zm.this;
                super();
            }
        };
        a.init(null, new TrustManager[] {
            keystore
        }, null);
    }

    public Socket createSocket()
    {
        return a.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
    {
        return a.getSocketFactory().createSocket(socket, s, i, flag);
    }
}
