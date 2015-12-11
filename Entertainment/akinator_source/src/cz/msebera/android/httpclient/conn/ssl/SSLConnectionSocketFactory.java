// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package cz.msebera.android.httpclient.conn.ssl:
//            AllowAllHostnameVerifier, BrowserCompatHostnameVerifier, StrictHostnameVerifier, SSLInitializationException, 
//            SSLContexts, X509HostnameVerifier

public class SSLConnectionSocketFactory
    implements LayeredConnectionSocketFactory
{

    public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = new AllowAllHostnameVerifier();
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final String SSL = "SSL";
    public static final String SSLV2 = "SSLv2";
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
    public static final String TLS = "TLS";
    private final X509HostnameVerifier hostnameVerifier;
    private final SSLSocketFactory socketfactory;
    private final String supportedCipherSuites[];
    private final String supportedProtocols[];

    public SSLConnectionSocketFactory(SSLContext sslcontext)
    {
        this(sslcontext, BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLConnectionSocketFactory(SSLContext sslcontext, X509HostnameVerifier x509hostnameverifier)
    {
        this(((SSLContext)Args.notNull(sslcontext, "SSL context")).getSocketFactory(), null, null, x509hostnameverifier);
    }

    public SSLConnectionSocketFactory(SSLContext sslcontext, String as[], String as1[], X509HostnameVerifier x509hostnameverifier)
    {
        this(((SSLContext)Args.notNull(sslcontext, "SSL context")).getSocketFactory(), as, as1, x509hostnameverifier);
    }

    public SSLConnectionSocketFactory(SSLSocketFactory sslsocketfactory, X509HostnameVerifier x509hostnameverifier)
    {
        this(sslsocketfactory, null, null, x509hostnameverifier);
    }

    public SSLConnectionSocketFactory(SSLSocketFactory sslsocketfactory, String as[], String as1[], X509HostnameVerifier x509hostnameverifier)
    {
        socketfactory = (SSLSocketFactory)Args.notNull(sslsocketfactory, "SSL socket factory");
        supportedProtocols = as;
        supportedCipherSuites = as1;
        if (x509hostnameverifier == null)
        {
            x509hostnameverifier = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
        }
        hostnameVerifier = x509hostnameverifier;
    }

    public static SSLConnectionSocketFactory getSocketFactory()
        throws SSLInitializationException
    {
        return new SSLConnectionSocketFactory(SSLContexts.createDefault(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public static SSLConnectionSocketFactory getSystemSocketFactory()
        throws SSLInitializationException
    {
        return new SSLConnectionSocketFactory((SSLSocketFactory)SSLSocketFactory.getDefault(), split(System.getProperty("https.protocols")), split(System.getProperty("https.cipherSuites")), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
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
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        if (socket.getSoTimeout() == 0)
        {
            socket.setSoTimeout(i);
        }
        socket.connect(inetsocketaddress, i);
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
        httphost;
        try
        {
            socket.close();
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket) { }
        throw httphost;
    }

    public Socket createLayeredSocket(Socket socket, String s, int i, HttpContext httpcontext)
        throws IOException
    {
        socket = (SSLSocket)socketfactory.createSocket(socket, s, i, true);
        if (supportedProtocols != null)
        {
            socket.setEnabledProtocols(supportedProtocols);
        } else
        {
            httpcontext = socket.getSupportedProtocols();
            ArrayList arraylist = new ArrayList(httpcontext.length);
            int j = httpcontext.length;
            for (i = 0; i < j; i++)
            {
                String s1 = httpcontext[i];
                if (!s1.startsWith("SSL"))
                {
                    arraylist.add(s1);
                }
            }

            socket.setEnabledProtocols((String[])arraylist.toArray(new String[arraylist.size()]));
        }
        if (supportedCipherSuites != null)
        {
            socket.setEnabledCipherSuites(supportedCipherSuites);
        }
        prepareSocket(socket);
        socket.startHandshake();
        verifyHostname(socket, s);
        return socket;
    }

    public Socket createSocket(HttpContext httpcontext)
        throws IOException
    {
        return SocketFactory.getDefault().createSocket();
    }

    X509HostnameVerifier getHostnameVerifier()
    {
        return hostnameVerifier;
    }

    protected void prepareSocket(SSLSocket sslsocket)
        throws IOException
    {
    }

}
