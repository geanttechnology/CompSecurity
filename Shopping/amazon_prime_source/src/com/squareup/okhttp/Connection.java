// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpAuthenticator;
import com.squareup.okhttp.internal.http.HttpConnection;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.Request;
import com.squareup.okhttp.internal.http.Response;
import com.squareup.okhttp.internal.http.SpdyTransport;
import com.squareup.okhttp.internal.okio.BufferedSink;
import com.squareup.okhttp.internal.okio.BufferedSource;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Okio;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.squareup.okhttp:
//            TunnelRequest, Route, Address, Protocol, 
//            Handshake, ConnectionPool

public final class Connection
    implements Closeable
{

    private boolean connected;
    private Handshake handshake;
    private HttpConnection httpConnection;
    private int httpMinorVersion;
    private long idleStartTimeNs;
    private InputStream in;
    private OutputStream out;
    private Object owner;
    private final ConnectionPool pool;
    private int recycleCount;
    private final Route route;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    private SpdyConnection spdyConnection;

    public Connection(ConnectionPool connectionpool, Route route1)
    {
        connected = false;
        httpMinorVersion = 1;
        pool = connectionpool;
        route = route1;
    }

    private void initSourceAndSink()
        throws IOException
    {
        source = Okio.buffer(Okio.source(in));
        sink = Okio.buffer(Okio.sink(out));
    }

    private void makeTunnel(TunnelRequest tunnelrequest)
        throws IOException
    {
        BufferedSource bufferedsource = Okio.buffer(Okio.source(in));
        Object obj = Okio.buffer(Okio.sink(out));
        HttpConnection httpconnection = new HttpConnection(pool, this, bufferedsource, ((BufferedSink) (obj)));
        obj = tunnelrequest.getRequest();
        String s = tunnelrequest.requestLine();
        tunnelrequest = ((TunnelRequest) (obj));
        do
        {
            httpconnection.writeRequest(tunnelrequest.headers(), s);
            httpconnection.flush();
            tunnelrequest = httpconnection.readResponse().request(tunnelrequest).build();
            httpconnection.emptyResponseBody();
            Request request;
            switch (tunnelrequest.code())
            {
            default:
                throw new IOException((new StringBuilder()).append("Unexpected response code for CONNECT: ").append(tunnelrequest.code()).toString());

            case 200: 
                if (bufferedsource.buffer().size() > 0L)
                {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                } else
                {
                    return;
                }

            case 407: 
                request = HttpAuthenticator.processAuthHeader(route.address.authenticator, tunnelrequest, route.proxy);
                tunnelrequest = request;
                break;
            }
        } while (request != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    private void upgradeToTls(TunnelRequest tunnelrequest)
        throws IOException
    {
        Object obj = Platform.get();
        if (requiresTunnel())
        {
            makeTunnel(tunnelrequest);
        }
        socket = route.address.sslSocketFactory.createSocket(socket, route.address.uriHost, route.address.uriPort, true);
        SSLSocket sslsocket = (SSLSocket)socket;
        boolean flag;
        if (route.modernTls)
        {
            ((Platform) (obj)).enableTlsExtensions(sslsocket, route.address.uriHost);
        } else
        {
            ((Platform) (obj)).supportTlsIntolerantServer(sslsocket);
        }
        if (route.modernTls && (route.address.protocols.contains(Protocol.HTTP_2) || route.address.protocols.contains(Protocol.SPDY_3)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (route.address.protocols.contains(Protocol.HTTP_2) && route.address.protocols.contains(Protocol.SPDY_3))
            {
                ((Platform) (obj)).setNpnProtocols(sslsocket, Util.HTTP2_SPDY3_AND_HTTP);
            } else
            if (route.address.protocols.contains(Protocol.HTTP_2))
            {
                ((Platform) (obj)).setNpnProtocols(sslsocket, Util.HTTP2_AND_HTTP_11);
            } else
            {
                ((Platform) (obj)).setNpnProtocols(sslsocket, Util.SPDY3_AND_HTTP11);
            }
        }
        sslsocket.startHandshake();
        if (!route.address.hostnameVerifier.verify(route.address.uriHost, sslsocket.getSession()))
        {
            throw new IOException((new StringBuilder()).append("Hostname '").append(route.address.uriHost).append("' was not verified").toString());
        }
        out = sslsocket.getOutputStream();
        in = sslsocket.getInputStream();
        handshake = Handshake.get(sslsocket.getSession());
        initSourceAndSink();
        Protocol protocol = Protocol.HTTP_11;
        tunnelrequest = protocol;
        if (flag)
        {
            obj = ((Platform) (obj)).getNpnSelectedProtocol(sslsocket);
            tunnelrequest = protocol;
            if (obj != null)
            {
                tunnelrequest = Util.getProtocol(((com.squareup.okhttp.internal.okio.ByteString) (obj)));
            }
        }
        if (((Protocol) (tunnelrequest)).spdyVariant)
        {
            sslsocket.setSoTimeout(0);
            spdyConnection = (new com.squareup.okhttp.internal.spdy.SpdyConnection.Builder(route.address.getUriHost(), true, source, sink)).protocol(tunnelrequest).build();
            spdyConnection.sendConnectionHeader();
            return;
        } else
        {
            httpConnection = new HttpConnection(pool, this, source, sink);
            return;
        }
    }

    public boolean clearOwner()
    {
label0:
        {
            synchronized (pool)
            {
                if (owner != null)
                {
                    break label0;
                }
            }
            return false;
        }
        owner = null;
        connectionpool;
        JVM INSTR monitorexit ;
        return true;
        exception;
        connectionpool;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void close()
        throws IOException
    {
        socket.close();
    }

    public void closeIfOwnedBy(Object obj)
        throws IOException
    {
label0:
        {
            if (isSpdy())
            {
                throw new IllegalStateException();
            }
            synchronized (pool)
            {
                if (owner == obj)
                {
                    break label0;
                }
            }
            return;
        }
        owner = null;
        connectionpool;
        JVM INSTR monitorexit ;
        socket.close();
        return;
        obj;
        connectionpool;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void connect(int i, int j, TunnelRequest tunnelrequest)
        throws IOException
    {
        if (connected)
        {
            throw new IllegalStateException("already connected");
        }
        Socket socket1;
        if (route.proxy.type() != java.net.Proxy.Type.HTTP)
        {
            socket1 = new Socket(route.proxy);
        } else
        {
            socket1 = new Socket();
        }
        socket = socket1;
        Platform.get().connectSocket(socket, route.inetSocketAddress, i);
        socket.setSoTimeout(j);
        in = socket.getInputStream();
        out = socket.getOutputStream();
        if (route.address.sslSocketFactory != null)
        {
            upgradeToTls(tunnelrequest);
        } else
        {
            initSourceAndSink();
            httpConnection = new HttpConnection(pool, this, source, sink);
        }
        connected = true;
    }

    public Handshake getHandshake()
    {
        return handshake;
    }

    public int getHttpMinorVersion()
    {
        return httpMinorVersion;
    }

    public long getIdleStartTimeNs()
    {
        if (spdyConnection == null)
        {
            return idleStartTimeNs;
        } else
        {
            return spdyConnection.getIdleStartTimeNs();
        }
    }

    public Object getOwner()
    {
        Object obj;
        synchronized (pool)
        {
            obj = owner;
        }
        return obj;
        exception;
        connectionpool;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Route getRoute()
    {
        return route;
    }

    public Socket getSocket()
    {
        return socket;
    }

    public void incrementRecycleCount()
    {
        recycleCount = recycleCount + 1;
    }

    public boolean isAlive()
    {
        return !socket.isClosed() && !socket.isInputShutdown() && !socket.isOutputShutdown();
    }

    public boolean isConnected()
    {
        return connected;
    }

    public boolean isExpired(long l)
    {
        return getIdleStartTimeNs() < System.nanoTime() - l;
    }

    public boolean isIdle()
    {
        return spdyConnection == null || spdyConnection.isIdle();
    }

    public boolean isReadable()
    {
        while (source == null || isSpdy()) 
        {
            return true;
        }
        Exception exception;
        int i;
        boolean flag;
        try
        {
            i = socket.getSoTimeout();
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            return true;
        }
        catch (IOException ioexception)
        {
            return false;
        }
        socket.setSoTimeout(1);
        flag = source.exhausted();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        socket.setSoTimeout(i);
        return false;
        socket.setSoTimeout(i);
        return true;
        exception;
        socket.setSoTimeout(i);
        throw exception;
    }

    public boolean isSpdy()
    {
        return spdyConnection != null;
    }

    public Object newTransport(HttpEngine httpengine)
        throws IOException
    {
        if (spdyConnection != null)
        {
            return new SpdyTransport(httpengine, spdyConnection);
        } else
        {
            return new HttpTransport(httpengine, httpConnection);
        }
    }

    public int recycleCount()
    {
        return recycleCount;
    }

    public boolean requiresTunnel()
    {
        return route.address.sslSocketFactory != null && route.proxy.type() == java.net.Proxy.Type.HTTP;
    }

    public void resetIdleStartTime()
    {
        if (spdyConnection != null)
        {
            throw new IllegalStateException("spdyConnection != null");
        } else
        {
            idleStartTimeNs = System.nanoTime();
            return;
        }
    }

    public void setHttpMinorVersion(int i)
    {
        httpMinorVersion = i;
    }

    public void setOwner(Object obj)
    {
        if (isSpdy())
        {
            return;
        }
        ConnectionPool connectionpool = pool;
        connectionpool;
        JVM INSTR monitorenter ;
        if (owner != null)
        {
            throw new IllegalStateException("Connection already has an owner!");
        }
        break MISSING_BLOCK_LABEL_38;
        obj;
        connectionpool;
        JVM INSTR monitorexit ;
        throw obj;
        owner = obj;
        connectionpool;
        JVM INSTR monitorexit ;
    }

    public void updateReadTimeout(int i)
        throws IOException
    {
        if (!connected)
        {
            throw new IllegalStateException("updateReadTimeout - not connected");
        } else
        {
            socket.setSoTimeout(i);
            return;
        }
    }
}
