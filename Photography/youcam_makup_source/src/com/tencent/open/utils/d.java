// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

// Referenced classes of package com.tencent.open.utils:
//            e

public class d extends SSLSocketFactory
{

    private final SSLContext a = SSLContext.getInstance("TLS");

    public d(KeyStore keystore)
    {
        super(keystore);
        try
        {
            keystore = new e();
        }
        // Misplaced declaration of an exception variable
        catch (KeyStore keystore)
        {
            keystore = null;
        }
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
