// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

// Referenced classes of package com.b.e:
//            s

final class r extends SSLSocketFactory
{

    SSLContext a;

    public r(KeyStore keystore)
    {
        super(keystore);
        a = SSLContext.getInstance("TLS");
        keystore = new s(this);
        a.init(null, new TrustManager[] {
            keystore
        }, null);
    }

    public final Socket createSocket()
    {
        return a.getSocketFactory().createSocket();
    }

    public final Socket createSocket(Socket socket, String s1, int i, boolean flag)
    {
        return a.getSocketFactory().createSocket(socket, s1, i, flag);
    }
}
