// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework.security;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.amazon.identity.auth.device.framework.security:
//            AmazonApprovedCiphers, CertificatePinnedKeyStore

public final class EnhancedApacheSSLSocketFactory
    implements LayeredSocketFactory, SocketFactory
{

    static final boolean $assertionsDisabled;
    private static final String TAG = com/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory.getName();
    private static SocketFactory sTheOnlyInstance;
    private final SSLSocketFactory mInnerSSLSocketFactory;

    private EnhancedApacheSSLSocketFactory(KeyStore keystore)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        mInnerSSLSocketFactory = new SSLSocketFactory(keystore);
        mInnerSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
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

    public static SocketFactory getInstance()
        throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException
    {
        com/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;
        JVM INSTR monitorenter ;
        SocketFactory socketfactory;
        if (sTheOnlyInstance == null)
        {
            sTheOnlyInstance = new EnhancedApacheSSLSocketFactory(CertificatePinnedKeyStore.getInstance());
        }
        socketfactory = sTheOnlyInstance;
        com/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;
        JVM INSTR monitorexit ;
        return socketfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public Socket connectSocket(Socket socket, String s, int i, InetAddress inetaddress, int j, HttpParams httpparams)
        throws IOException
    {
        socket = mInnerSSLSocketFactory.connectSocket(socket, s, i, inetaddress, j, httpparams);
        enforceStrongCipher(socket);
        return socket;
    }

    public Socket createSocket()
        throws IOException
    {
        Socket socket = mInnerSSLSocketFactory.createSocket();
        enforceStrongCipher(socket);
        return socket;
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException, UnknownHostException
    {
        socket = mInnerSSLSocketFactory.createSocket(socket, s, i, flag);
        enforceStrongCipher(socket);
        return socket;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof EnhancedApacheSSLSocketFactory)
        {
            return mInnerSSLSocketFactory.equals(((EnhancedApacheSSLSocketFactory)obj).mInnerSSLSocketFactory);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return mInnerSSLSocketFactory.hashCode();
    }

    public boolean isSecure(Socket socket)
        throws IllegalArgumentException
    {
        return true;
    }

    static 
    {
        boolean flag;
        if (!com/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
