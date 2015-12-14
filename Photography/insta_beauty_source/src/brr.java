// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class brr extends SSLSocketFactory
{

    SSLContext a;

    public brr(KeyStore keystore)
    {
        super(keystore);
        a = SSLContext.getInstance("TLS");
        keystore = new brs(this);
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
