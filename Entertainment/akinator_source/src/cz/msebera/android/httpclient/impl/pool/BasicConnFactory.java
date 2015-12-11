// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.pool;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpConnectionFactory;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.impl.DefaultBHttpClientConnection;
import cz.msebera.android.httpclient.impl.DefaultBHttpClientConnectionFactory;
import cz.msebera.android.httpclient.params.HttpParamConfig;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.pool.ConnFactory;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class BasicConnFactory
    implements ConnFactory
{

    private final HttpConnectionFactory connFactory;
    private final int connectTimeout;
    private final SocketFactory plainfactory;
    private final SocketConfig sconfig;
    private final SSLSocketFactory sslfactory;

    public BasicConnFactory()
    {
        this(null, null, 0, SocketConfig.DEFAULT, ConnectionConfig.DEFAULT);
    }

    public BasicConnFactory(int i, SocketConfig socketconfig, ConnectionConfig connectionconfig)
    {
        this(null, null, i, socketconfig, connectionconfig);
    }

    public BasicConnFactory(SocketConfig socketconfig, ConnectionConfig connectionconfig)
    {
        this(null, null, 0, socketconfig, connectionconfig);
    }

    public BasicConnFactory(HttpParams httpparams)
    {
        this(((SSLSocketFactory) (null)), httpparams);
    }

    public BasicConnFactory(SocketFactory socketfactory, SSLSocketFactory sslsocketfactory, int i, SocketConfig socketconfig, ConnectionConfig connectionconfig)
    {
        plainfactory = socketfactory;
        sslfactory = sslsocketfactory;
        connectTimeout = i;
        if (socketconfig == null)
        {
            socketconfig = SocketConfig.DEFAULT;
        }
        sconfig = socketconfig;
        if (connectionconfig == null)
        {
            connectionconfig = ConnectionConfig.DEFAULT;
        }
        connFactory = new DefaultBHttpClientConnectionFactory(connectionconfig);
    }

    public BasicConnFactory(SSLSocketFactory sslsocketfactory, HttpParams httpparams)
    {
        Args.notNull(httpparams, "HTTP params");
        plainfactory = null;
        sslfactory = sslsocketfactory;
        connectTimeout = httpparams.getIntParameter("http.connection.timeout", 0);
        sconfig = HttpParamConfig.getSocketConfig(httpparams);
        connFactory = new DefaultBHttpClientConnectionFactory(HttpParamConfig.getConnectionConfig(httpparams));
    }

    public HttpClientConnection create(HttpHost httphost)
        throws IOException
    {
        String s = httphost.getSchemeName();
        Object obj = null;
        if ("http".equalsIgnoreCase(s))
        {
            if (plainfactory != null)
            {
                obj = plainfactory.createSocket();
            } else
            {
                obj = new Socket();
            }
        }
        if ("https".equalsIgnoreCase(s))
        {
            if (sslfactory != null)
            {
                obj = sslfactory;
            } else
            {
                obj = SSLSocketFactory.getDefault();
            }
            obj = ((SocketFactory) (obj)).createSocket();
        }
        if (obj == null)
        {
            throw new IOException((new StringBuilder()).append(s).append(" scheme is not supported").toString());
        }
        s = httphost.getHostName();
        int j = httphost.getPort();
        int i = j;
        if (j == -1)
        {
            if (httphost.getSchemeName().equalsIgnoreCase("http"))
            {
                i = 80;
            } else
            {
                i = j;
                if (httphost.getSchemeName().equalsIgnoreCase("https"))
                {
                    i = 443;
                }
            }
        }
        ((Socket) (obj)).setSoTimeout(sconfig.getSoTimeout());
        ((Socket) (obj)).setTcpNoDelay(sconfig.isTcpNoDelay());
        j = sconfig.getSoLinger();
        if (j >= 0)
        {
            boolean flag;
            if (j > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((Socket) (obj)).setSoLinger(flag, j);
        }
        ((Socket) (obj)).setKeepAlive(sconfig.isSoKeepAlive());
        ((Socket) (obj)).connect(new InetSocketAddress(s, i), connectTimeout);
        return (HttpClientConnection)connFactory.createConnection(((Socket) (obj)));
    }

    protected HttpClientConnection create(Socket socket, HttpParams httpparams)
        throws IOException
    {
        httpparams = new DefaultBHttpClientConnection(httpparams.getIntParameter("http.socket.buffer-size", 8192));
        httpparams.bind(socket);
        return httpparams;
    }

    public volatile Object create(Object obj)
        throws IOException
    {
        return create((HttpHost)obj);
    }
}
