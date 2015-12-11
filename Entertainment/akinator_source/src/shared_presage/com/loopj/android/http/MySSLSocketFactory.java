// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            q

public class MySSLSocketFactory extends SSLSocketFactory
{

    SSLContext sslContext;

    public MySSLSocketFactory(KeyStore keystore)
    {
        super(keystore);
        sslContext = SSLContext.getInstance("TLS");
        keystore = new q(this);
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

    public Socket createSocket()
    {
        return sslContext.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
    {
        return sslContext.getSocketFactory().createSocket(socket, s, i, flag);
    }
}
