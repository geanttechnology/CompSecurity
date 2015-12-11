// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework.security;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.amazon.identity.auth.device.framework.security:
//            AmazonApprovedCiphers

class StrongCipherSSLSocketFactory extends SSLSocketFactory
{

    static final boolean $assertionsDisabled;
    private static final String TAG = com/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory.getName();
    private final SSLSocketFactory mInnerSSocketFactory;

    StrongCipherSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        mInnerSSocketFactory = sslsocketfactory;
    }

    private void enforceStrongCipher(Socket socket)
    {
        if (!$assertionsDisabled && !(socket instanceof SSLSocket))
        {
            throw new AssertionError();
        }
        if (!AmazonApprovedCiphers.enableAllowed((SSLSocket)socket))
        {
            MAPLog.e(TAG, (new StringBuilder("The socket only support deprecated ciphers: ")).append(Arrays.toString(((SSLSocket)socket).getSupportedCipherSuites())).toString());
            throw new SecurityException("Unable to enforce strong cipher over https.");
        } else
        {
            return;
        }
    }

    public Socket createSocket(String s, int i)
        throws IOException, UnknownHostException
    {
        s = mInnerSSocketFactory.createSocket(s, i);
        enforceStrongCipher(s);
        return s;
    }

    public Socket createSocket(String s, int i, InetAddress inetaddress, int j)
        throws IOException, UnknownHostException
    {
        s = mInnerSSocketFactory.createSocket(s, i, inetaddress, j);
        enforceStrongCipher(s);
        return s;
    }

    public Socket createSocket(InetAddress inetaddress, int i)
        throws IOException
    {
        inetaddress = mInnerSSocketFactory.createSocket(inetaddress, i);
        enforceStrongCipher(inetaddress);
        return inetaddress;
    }

    public Socket createSocket(InetAddress inetaddress, int i, InetAddress inetaddress1, int j)
        throws IOException
    {
        inetaddress = mInnerSSocketFactory.createSocket(inetaddress, i, inetaddress1, j);
        enforceStrongCipher(inetaddress);
        return inetaddress;
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException
    {
        socket = mInnerSSocketFactory.createSocket(socket, s, i, flag);
        enforceStrongCipher(socket);
        return socket;
    }

    public String[] getDefaultCipherSuites()
    {
        return mInnerSSocketFactory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites()
    {
        return mInnerSSocketFactory.getSupportedCipherSuites();
    }

    static 
    {
        boolean flag;
        if (!com/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
