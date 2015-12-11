// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.paypal.android.sdk:
//            gb, ha

public final class gz
{

    private final List a;
    private int b;
    private boolean c;
    private boolean d;

    public gz(List list)
    {
        b = 0;
        a = list;
    }

    private boolean b(SSLSocket sslsocket)
    {
        for (int i = b; i < a.size(); i++)
        {
            if (((gb)a.get(i)).a(sslsocket))
            {
                return true;
            }
        }

        return false;
    }

    public final gb a(SSLSocket sslsocket)
    {
        int i;
        int j;
        i = b;
        j = a.size();
_L3:
        gb gb1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        gb1 = (gb)a.get(i);
        if (!gb1.a(sslsocket)) goto _L2; else goto _L1
_L1:
        b = i + 1;
_L4:
        if (gb1 == null)
        {
            throw new UnknownServiceException((new StringBuilder("Unable to find acceptable protocols. isFallback=")).append(d).append(", modes=").append(a).append(", supported protocols=").append(Arrays.toString(sslsocket.getEnabledProtocols())).toString());
        } else
        {
            c = b(sslsocket);
            ha.b.a(gb1, sslsocket, d);
            return gb1;
        }
_L2:
        i++;
          goto _L3
        gb1 = null;
          goto _L4
    }

    public final boolean a(IOException ioexception)
    {
        for (d = true; (ioexception instanceof ProtocolException) || (ioexception instanceof InterruptedIOException) || (ioexception instanceof SSLHandshakeException) && (ioexception.getCause() instanceof CertificateException) || (ioexception instanceof SSLPeerUnverifiedException) || !(ioexception instanceof SSLHandshakeException) && !(ioexception instanceof SSLProtocolException) || !c;)
        {
            return false;
        }

        return true;
    }
}
