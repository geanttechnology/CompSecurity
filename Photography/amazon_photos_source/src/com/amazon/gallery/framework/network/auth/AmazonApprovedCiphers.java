// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.auth;

import java.net.Socket;
import javax.net.ssl.SSLSocket;

final class AmazonApprovedCiphers
{

    private static final boolean ENABLED_ON_THIS_PLATFORM;

    static void enforceStrongCipher(Socket socket)
    {
        if (!(socket instanceof SSLSocket))
        {
            throw new SecurityException(String.format("SSLSocket is required, %s is not supported", new Object[] {
                socket.getClass().getCanonicalName()
            }));
        } else
        {
            setEnabledProtocols((SSLSocket)socket);
            return;
        }
    }

    static void setEnabledProtocols(SSLSocket sslsocket)
    {
        if (ENABLED_ON_THIS_PLATFORM)
        {
            String as1[] = sslsocket.getSupportedProtocols();
            String as[] = new String[as1.length];
            int l = as1.length;
            int j = 0;
            int i = 0;
            for (; j < l; j++)
            {
                String s = as1[j];
                if (s.equals("TLSv1") || s.equals("TLSv1.1") || s.equals("TLSv1.2"))
                {
                    int k = i + 1;
                    as[i] = s;
                    i = k;
                }
            }

            if (i == 0)
            {
                throw new SecurityException("Device does not support TLS");
            }
            as1 = new String[i];
            System.arraycopy(as, 0, as1, 0, i);
            sslsocket.setEnabledProtocols(as1);
        }
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ENABLED_ON_THIS_PLATFORM = flag;
    }
}
