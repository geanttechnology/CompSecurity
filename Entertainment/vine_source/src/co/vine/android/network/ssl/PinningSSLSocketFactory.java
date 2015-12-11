// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network.ssl;

import android.content.Context;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package co.vine.android.network.ssl:
//            SystemKeyStore, PinningTrustManager, VinePins

public class PinningSSLSocketFactory extends SSLSocketFactory
{

    private static final Set PINNING_HOSTS;
    private final javax.net.ssl.SSLSocketFactory mPinningSocketFactory;
    private final javax.net.ssl.SSLSocketFactory mSystemSocketFactory;

    public PinningSSLSocketFactory(Context context)
        throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException
    {
        super(null);
        SystemKeyStore systemkeystore = SystemKeyStore.getInstance(context);
        context = SSLContext.getInstance("TLS");
        SSLContext sslcontext = SSLContext.getInstance("TLS");
        TrustManager atrustmanager[] = initializePinningTrustManagers(systemkeystore);
        TrustManager atrustmanager1[] = initializeSystemTrustManagers(systemkeystore);
        context.init(null, atrustmanager, null);
        sslcontext.init(null, atrustmanager1, null);
        mPinningSocketFactory = context.getSocketFactory();
        mSystemSocketFactory = sslcontext.getSocketFactory();
    }

    private TrustManager[] initializePinningTrustManagers(SystemKeyStore systemkeystore)
    {
        return (new TrustManager[] {
            new PinningTrustManager(systemkeystore, VinePins.PINS)
        });
    }

    private TrustManager[] initializeSystemTrustManagers(SystemKeyStore systemkeystore)
        throws NoSuchAlgorithmException, KeyStoreException
    {
        TrustManagerFactory trustmanagerfactory = TrustManagerFactory.getInstance("X509");
        trustmanagerfactory.init(systemkeystore.mTrustStore);
        return trustmanagerfactory.getTrustManagers();
    }

    public Socket connectSocket(Socket socket, String s, int i, InetAddress inetaddress, int j, HttpParams httpparams)
        throws IOException
    {
        int l;
        if (socket == null)
        {
            socket = createSocket();
        }
        socket = (SSLSocket)(SSLSocket)socket;
        if (inetaddress != null || j > 0)
        {
            int k = j;
            if (j < 0)
            {
                k = 0;
            }
            socket.bind(new InetSocketAddress(inetaddress, k));
        }
        j = HttpConnectionParams.getConnectionTimeout(httpparams);
        l = HttpConnectionParams.getSoTimeout(httpparams);
        socket.connect(new InetSocketAddress(s, i), j);
        socket.setSoTimeout(l);
        try
        {
            SSLSocketFactory.STRICT_HOSTNAME_VERIFIER.verify(s, socket);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            try
            {
                socket.close();
            }
            // Misplaced declaration of an exception variable
            catch (Socket socket) { }
            throw s;
        }
        return socket;
    }

    public Socket createSocket()
        throws IOException
    {
        return mSystemSocketFactory.createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException
    {
        javax.net.ssl.SSLSocketFactory sslsocketfactory;
        int j;
        if (PINNING_HOSTS.contains(s))
        {
            sslsocketfactory = mPinningSocketFactory;
        } else
        {
            sslsocketfactory = mSystemSocketFactory;
        }
        j = i;
        if (i == -1)
        {
            j = 443;
        }
        socket = (SSLSocket)sslsocketfactory.createSocket(socket, s, j, flag);
        SSLSocketFactory.STRICT_HOSTNAME_VERIFIER.verify(s, socket);
        return socket;
    }

    public X509HostnameVerifier getHostnameVerifier()
    {
        return SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
    }

    public void setHostnameVerifier(X509HostnameVerifier x509hostnameverifier)
    {
        throw new IllegalArgumentException("Only strict hostname verification (default)  is supported!");
    }

    static 
    {
        PINNING_HOSTS = new HashSet();
        PINNING_HOSTS.add("api.twitter.com");
        PINNING_HOSTS.add("api.vineapp.com");
        PINNING_HOSTS.add("media.vineapp.com");
        PINNING_HOSTS.add("vine.co");
        PINNING_HOSTS.add("rtc.vineapp.com");
    }
}
