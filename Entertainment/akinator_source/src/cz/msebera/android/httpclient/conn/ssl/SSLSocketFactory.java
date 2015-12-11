// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.conn.HttpInetSocketAddress;
import cz.msebera.android.httpclient.conn.scheme.HostNameResolver;
import cz.msebera.android.httpclient.conn.scheme.LayeredSchemeSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.LayeredSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory;
import cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.TextUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

// Referenced classes of package cz.msebera.android.httpclient.conn.ssl:
//            AllowAllHostnameVerifier, BrowserCompatHostnameVerifier, StrictHostnameVerifier, SSLContexts, 
//            SSLContextBuilder, SSLInitializationException, X509HostnameVerifier, TrustStrategy

public class SSLSocketFactory
    implements LayeredConnectionSocketFactory, SchemeLayeredSocketFactory, LayeredSchemeSocketFactory, LayeredSocketFactory
{

    public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = new AllowAllHostnameVerifier();
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final String SSL = "SSL";
    public static final String SSLV2 = "SSLv2";
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
    public static final String TLS = "TLS";
    private volatile X509HostnameVerifier hostnameVerifier;
    private final HostNameResolver nameResolver;
    private final javax.net.ssl.SSLSocketFactory socketfactory;
    private final String supportedCipherSuites[];
    private final String supportedProtocols[];

    public SSLSocketFactory(TrustStrategy truststrategy)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        this(SSLContexts.custom().loadTrustMaterial(null, truststrategy).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLSocketFactory(TrustStrategy truststrategy, X509HostnameVerifier x509hostnameverifier)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        this(SSLContexts.custom().loadTrustMaterial(null, truststrategy).build(), x509hostnameverifier);
    }

    public SSLSocketFactory(String s, KeyStore keystore, String s1, KeyStore keystore1, SecureRandom securerandom, HostNameResolver hostnameresolver)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        securerandom = SSLContexts.custom().useProtocol(s).setSecureRandom(securerandom);
        if (s1 != null)
        {
            s = s1.toCharArray();
        } else
        {
            s = null;
        }
        this(securerandom.loadKeyMaterial(keystore, s).loadTrustMaterial(keystore1).build(), hostnameresolver);
    }

    public SSLSocketFactory(String s, KeyStore keystore, String s1, KeyStore keystore1, SecureRandom securerandom, TrustStrategy truststrategy, X509HostnameVerifier x509hostnameverifier)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        securerandom = SSLContexts.custom().useProtocol(s).setSecureRandom(securerandom);
        if (s1 != null)
        {
            s = s1.toCharArray();
        } else
        {
            s = null;
        }
        this(securerandom.loadKeyMaterial(keystore, s).loadTrustMaterial(keystore1, truststrategy).build(), x509hostnameverifier);
    }

    public SSLSocketFactory(String s, KeyStore keystore, String s1, KeyStore keystore1, SecureRandom securerandom, X509HostnameVerifier x509hostnameverifier)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        securerandom = SSLContexts.custom().useProtocol(s).setSecureRandom(securerandom);
        if (s1 != null)
        {
            s = s1.toCharArray();
        } else
        {
            s = null;
        }
        this(securerandom.loadKeyMaterial(keystore, s).loadTrustMaterial(keystore1).build(), x509hostnameverifier);
    }

    public SSLSocketFactory(KeyStore keystore)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        this(SSLContexts.custom().loadTrustMaterial(keystore).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLSocketFactory(KeyStore keystore, String s)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        SSLContextBuilder sslcontextbuilder = SSLContexts.custom();
        if (s != null)
        {
            s = s.toCharArray();
        } else
        {
            s = null;
        }
        this(sslcontextbuilder.loadKeyMaterial(keystore, s).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLSocketFactory(KeyStore keystore, String s, KeyStore keystore1)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        SSLContextBuilder sslcontextbuilder = SSLContexts.custom();
        if (s != null)
        {
            s = s.toCharArray();
        } else
        {
            s = null;
        }
        this(sslcontextbuilder.loadKeyMaterial(keystore, s).loadTrustMaterial(keystore1).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLSocketFactory(SSLContext sslcontext)
    {
        this(sslcontext, BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLSocketFactory(SSLContext sslcontext, HostNameResolver hostnameresolver)
    {
        socketfactory = sslcontext.getSocketFactory();
        hostnameVerifier = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
        nameResolver = hostnameresolver;
        supportedProtocols = null;
        supportedCipherSuites = null;
    }

    public SSLSocketFactory(SSLContext sslcontext, X509HostnameVerifier x509hostnameverifier)
    {
        this(((SSLContext)Args.notNull(sslcontext, "SSL context")).getSocketFactory(), null, null, x509hostnameverifier);
    }

    public SSLSocketFactory(SSLContext sslcontext, String as[], String as1[], X509HostnameVerifier x509hostnameverifier)
    {
        this(((SSLContext)Args.notNull(sslcontext, "SSL context")).getSocketFactory(), as, as1, x509hostnameverifier);
    }

    public SSLSocketFactory(javax.net.ssl.SSLSocketFactory sslsocketfactory, X509HostnameVerifier x509hostnameverifier)
    {
        this(sslsocketfactory, null, null, x509hostnameverifier);
    }

    public SSLSocketFactory(javax.net.ssl.SSLSocketFactory sslsocketfactory, String as[], String as1[], X509HostnameVerifier x509hostnameverifier)
    {
        socketfactory = (javax.net.ssl.SSLSocketFactory)Args.notNull(sslsocketfactory, "SSL socket factory");
        supportedProtocols = as;
        supportedCipherSuites = as1;
        if (x509hostnameverifier == null)
        {
            x509hostnameverifier = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
        }
        hostnameVerifier = x509hostnameverifier;
        nameResolver = null;
    }

    public static SSLSocketFactory getSocketFactory()
        throws SSLInitializationException
    {
        return new SSLSocketFactory(SSLContexts.createDefault(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public static SSLSocketFactory getSystemSocketFactory()
        throws SSLInitializationException
    {
        return new SSLSocketFactory((javax.net.ssl.SSLSocketFactory)javax.net.ssl.SSLSocketFactory.getDefault(), split(System.getProperty("https.protocols")), split(System.getProperty("https.cipherSuites")), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    private void internalPrepareSocket(SSLSocket sslsocket)
        throws IOException
    {
        if (supportedProtocols != null)
        {
            sslsocket.setEnabledProtocols(supportedProtocols);
        }
        if (supportedCipherSuites != null)
        {
            sslsocket.setEnabledCipherSuites(supportedCipherSuites);
        }
        prepareSocket(sslsocket);
    }

    private static String[] split(String s)
    {
        if (TextUtils.isBlank(s))
        {
            return null;
        } else
        {
            return s.split(" *, *");
        }
    }

    private void verifyHostname(SSLSocket sslsocket, String s)
        throws IOException
    {
        try
        {
            hostnameVerifier.verify(s, sslsocket);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        try
        {
            sslsocket.close();
        }
        // Misplaced declaration of an exception variable
        catch (SSLSocket sslsocket) { }
        throw s;
    }

    public Socket connectSocket(int i, Socket socket, HttpHost httphost, InetSocketAddress inetsocketaddress, InetSocketAddress inetsocketaddress1, HttpContext httpcontext)
        throws IOException
    {
        Args.notNull(httphost, "HTTP host");
        Args.notNull(inetsocketaddress, "Remote address");
        if (socket == null)
        {
            socket = createSocket(httpcontext);
        }
        if (inetsocketaddress1 != null)
        {
            socket.bind(inetsocketaddress1);
        }
        try
        {
            socket.connect(inetsocketaddress, i);
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            try
            {
                socket.close();
            }
            // Misplaced declaration of an exception variable
            catch (Socket socket) { }
            throw httphost;
        }
        if (socket instanceof SSLSocket)
        {
            inetsocketaddress = (SSLSocket)socket;
            inetsocketaddress.startHandshake();
            verifyHostname(inetsocketaddress, httphost.getHostName());
            return socket;
        } else
        {
            return createLayeredSocket(socket, httphost.getHostName(), inetsocketaddress.getPort(), httpcontext);
        }
    }

    public Socket connectSocket(Socket socket, String s, int i, InetAddress inetaddress, int j, HttpParams httpparams)
        throws IOException, UnknownHostException, ConnectTimeoutException
    {
        InetAddress inetaddress1;
        InetSocketAddress inetsocketaddress;
        if (nameResolver != null)
        {
            inetaddress1 = nameResolver.resolve(s);
        } else
        {
            inetaddress1 = InetAddress.getByName(s);
        }
        inetsocketaddress = null;
        if (inetaddress != null || j > 0)
        {
            if (j <= 0)
            {
                j = 0;
            }
            inetsocketaddress = new InetSocketAddress(inetaddress, j);
        }
        return connectSocket(socket, ((InetSocketAddress) (new HttpInetSocketAddress(new HttpHost(s, i), inetaddress1, i))), inetsocketaddress, httpparams);
    }

    public Socket connectSocket(Socket socket, InetSocketAddress inetsocketaddress, InetSocketAddress inetsocketaddress1, HttpParams httpparams)
        throws IOException, UnknownHostException, ConnectTimeoutException
    {
        Args.notNull(inetsocketaddress, "Remote address");
        Args.notNull(httpparams, "HTTP parameters");
        HttpHost httphost;
        int i;
        int j;
        if (inetsocketaddress instanceof HttpInetSocketAddress)
        {
            httphost = ((HttpInetSocketAddress)inetsocketaddress).getHttpHost();
        } else
        {
            httphost = new HttpHost(inetsocketaddress.getHostName(), inetsocketaddress.getPort(), "https");
        }
        i = HttpConnectionParams.getSoTimeout(httpparams);
        j = HttpConnectionParams.getConnectionTimeout(httpparams);
        socket.setSoTimeout(i);
        return connectSocket(j, socket, httphost, inetsocketaddress, inetsocketaddress1, ((HttpContext) (null)));
    }

    public Socket createLayeredSocket(Socket socket, String s, int i, HttpParams httpparams)
        throws IOException, UnknownHostException
    {
        return createLayeredSocket(socket, s, i, (HttpContext)null);
    }

    public Socket createLayeredSocket(Socket socket, String s, int i, HttpContext httpcontext)
        throws IOException
    {
        socket = (SSLSocket)socketfactory.createSocket(socket, s, i, true);
        internalPrepareSocket(socket);
        socket.startHandshake();
        verifyHostname(socket, s);
        return socket;
    }

    public Socket createLayeredSocket(Socket socket, String s, int i, boolean flag)
        throws IOException, UnknownHostException
    {
        return createLayeredSocket(socket, s, i, (HttpContext)null);
    }

    public Socket createSocket()
        throws IOException
    {
        return createSocket((HttpContext)null);
    }

    public Socket createSocket(HttpParams httpparams)
        throws IOException
    {
        return createSocket((HttpContext)null);
    }

    public Socket createSocket(HttpContext httpcontext)
        throws IOException
    {
        httpcontext = (SSLSocket)socketfactory.createSocket();
        internalPrepareSocket(httpcontext);
        return httpcontext;
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException, UnknownHostException
    {
        return createLayeredSocket(socket, s, i, flag);
    }

    public X509HostnameVerifier getHostnameVerifier()
    {
        return hostnameVerifier;
    }

    public boolean isSecure(Socket socket)
        throws IllegalArgumentException
    {
        Args.notNull(socket, "Socket");
        Asserts.check(socket instanceof SSLSocket, "Socket not created by this factory");
        boolean flag;
        if (!socket.isClosed())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Socket is closed");
        return true;
    }

    protected void prepareSocket(SSLSocket sslsocket)
        throws IOException
    {
    }

    public void setHostnameVerifier(X509HostnameVerifier x509hostnameverifier)
    {
        Args.notNull(x509hostnameverifier, "Hostname verifier");
        hostnameVerifier = x509hostnameverifier;
    }

}
