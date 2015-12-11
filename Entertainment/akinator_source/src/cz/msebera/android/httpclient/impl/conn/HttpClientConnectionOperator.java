// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.HttpHostConnectException;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.SocketTimeoutException;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            DefaultSchemePortResolver, SystemDefaultDnsResolver

class HttpClientConnectionOperator
{

    static final String SOCKET_FACTORY_REGISTRY = "http.socket-factory-registry";
    private final DnsResolver dnsResolver;
    public HttpClientAndroidLog log;
    private final SchemePortResolver schemePortResolver;
    private final Lookup socketFactoryRegistry;

    HttpClientConnectionOperator(Lookup lookup, SchemePortResolver schemeportresolver, DnsResolver dnsresolver)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(lookup, "Socket factory registry");
        socketFactoryRegistry = lookup;
        if (schemeportresolver == null)
        {
            schemeportresolver = DefaultSchemePortResolver.INSTANCE;
        }
        schemePortResolver = schemeportresolver;
        if (dnsresolver == null)
        {
            dnsresolver = SystemDefaultDnsResolver.INSTANCE;
        }
        dnsResolver = dnsresolver;
    }

    private Lookup getSocketFactoryRegistry(HttpContext httpcontext)
    {
        Lookup lookup = (Lookup)httpcontext.getAttribute("http.socket-factory-registry");
        httpcontext = lookup;
        if (lookup == null)
        {
            httpcontext = socketFactoryRegistry;
        }
        return httpcontext;
    }

    public void connect(ManagedHttpClientConnection managedhttpclientconnection, HttpHost httphost, InetSocketAddress inetsocketaddress, int i, SocketConfig socketconfig, HttpContext httpcontext)
        throws IOException
    {
        InetAddress ainetaddress[];
        Object obj;
        int j;
        boolean flag;
        ConnectionSocketFactory connectionsocketfactory = (ConnectionSocketFactory)getSocketFactoryRegistry(httpcontext).lookup(httphost.getSchemeName());
        if (connectionsocketfactory == null)
        {
            throw new UnsupportedSchemeException((new StringBuilder()).append(httphost.getSchemeName()).append(" protocol is not supported").toString());
        }
        Socket socket;
        int k;
        int l;
        if (httphost.getAddress() != null)
        {
            ainetaddress = new InetAddress[1];
            ainetaddress[0] = httphost.getAddress();
        } else
        {
            ainetaddress = dnsResolver.resolve(httphost.getHostName());
        }
        k = schemePortResolver.resolve(httphost);
        j = 0;
_L2:
        if (j >= ainetaddress.length)
        {
            break MISSING_BLOCK_LABEL_316;
        }
        obj = ainetaddress[j];
        if (j == ainetaddress.length - 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        socket = connectionsocketfactory.createSocket(httpcontext);
        socket.setSoTimeout(socketconfig.getSoTimeout());
        socket.setReuseAddress(socketconfig.isSoReuseAddress());
        socket.setTcpNoDelay(socketconfig.isTcpNoDelay());
        socket.setKeepAlive(socketconfig.isSoKeepAlive());
        l = socketconfig.getSoLinger();
        if (l >= 0)
        {
            boolean flag1;
            if (l > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            socket.setSoLinger(flag1, l);
        }
        managedhttpclientconnection.bind(socket);
        obj = new InetSocketAddress(((InetAddress) (obj)), k);
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Connecting to ").append(obj).toString());
        }
        managedhttpclientconnection.bind(connectionsocketfactory.connectSocket(i, socket, httphost, ((InetSocketAddress) (obj)), inetsocketaddress, httpcontext));
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Connection established ").append(managedhttpclientconnection).toString());
        }
        return;
        Object obj1;
        obj1;
        if (flag)
        {
            throw new ConnectTimeoutException(((IOException) (obj1)), httphost, ainetaddress);
        }
        break MISSING_BLOCK_LABEL_423;
        obj1;
        if (flag)
        {
            if ("Connection timed out".equals(((ConnectException) (obj1)).getMessage()))
            {
                throw new ConnectTimeoutException(((IOException) (obj1)), httphost, ainetaddress);
            } else
            {
                throw new HttpHostConnectException(((IOException) (obj1)), httphost, ainetaddress);
            }
        }
        break MISSING_BLOCK_LABEL_423;
        obj1;
        if (flag)
        {
            throw obj1;
        }
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Connect to ").append(obj).append(" timed out. ").append("Connection will be retried using another IP address").toString());
        }
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void upgrade(ManagedHttpClientConnection managedhttpclientconnection, HttpHost httphost, HttpContext httpcontext)
        throws IOException
    {
        Object obj = (ConnectionSocketFactory)getSocketFactoryRegistry(HttpClientContext.adapt(httpcontext)).lookup(httphost.getSchemeName());
        if (obj == null)
        {
            throw new UnsupportedSchemeException((new StringBuilder()).append(httphost.getSchemeName()).append(" protocol is not supported").toString());
        }
        if (!(obj instanceof LayeredConnectionSocketFactory))
        {
            throw new UnsupportedSchemeException((new StringBuilder()).append(httphost.getSchemeName()).append(" protocol does not support connection upgrade").toString());
        } else
        {
            obj = (LayeredConnectionSocketFactory)obj;
            Socket socket = managedhttpclientconnection.getSocket();
            int i = schemePortResolver.resolve(httphost);
            managedhttpclientconnection.bind(((LayeredConnectionSocketFactory) (obj)).createLayeredSocket(socket, httphost.getHostName(), i, httpcontext));
            return;
        }
    }
}
