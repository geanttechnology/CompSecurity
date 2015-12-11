// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpInetConnection;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.entity.BasicHttpEntity;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.LaxContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.StrictContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.ChunkedInputStream;
import cz.msebera.android.httpclient.impl.io.ChunkedOutputStream;
import cz.msebera.android.httpclient.impl.io.ContentLengthInputStream;
import cz.msebera.android.httpclient.impl.io.ContentLengthOutputStream;
import cz.msebera.android.httpclient.impl.io.HttpTransportMetricsImpl;
import cz.msebera.android.httpclient.impl.io.IdentityInputStream;
import cz.msebera.android.httpclient.impl.io.IdentityOutputStream;
import cz.msebera.android.httpclient.impl.io.SessionInputBufferImpl;
import cz.msebera.android.httpclient.impl.io.SessionOutputBufferImpl;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.NetUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package cz.msebera.android.httpclient.impl:
//            HttpConnectionMetricsImpl

public class BHttpConnectionBase
    implements HttpConnection, HttpInetConnection
{

    private final HttpConnectionMetricsImpl connMetrics;
    private final SessionInputBufferImpl inbuffer;
    private final ContentLengthStrategy incomingContentStrategy;
    private final SessionOutputBufferImpl outbuffer;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final AtomicReference socketHolder = new AtomicReference();

    protected BHttpConnectionBase(int i, int j, CharsetDecoder charsetdecoder, CharsetEncoder charsetencoder, MessageConstraints messageconstraints, ContentLengthStrategy contentlengthstrategy, ContentLengthStrategy contentlengthstrategy1)
    {
        Args.positive(i, "Buffer size");
        HttpTransportMetricsImpl httptransportmetricsimpl = new HttpTransportMetricsImpl();
        HttpTransportMetricsImpl httptransportmetricsimpl1 = new HttpTransportMetricsImpl();
        if (messageconstraints == null)
        {
            messageconstraints = MessageConstraints.DEFAULT;
        }
        inbuffer = new SessionInputBufferImpl(httptransportmetricsimpl, i, -1, messageconstraints, charsetdecoder);
        outbuffer = new SessionOutputBufferImpl(httptransportmetricsimpl1, i, j, charsetencoder);
        connMetrics = new HttpConnectionMetricsImpl(httptransportmetricsimpl, httptransportmetricsimpl1);
        if (contentlengthstrategy == null)
        {
            contentlengthstrategy = LaxContentLengthStrategy.INSTANCE;
        }
        incomingContentStrategy = contentlengthstrategy;
        if (contentlengthstrategy1 == null)
        {
            contentlengthstrategy1 = StrictContentLengthStrategy.INSTANCE;
        }
        outgoingContentStrategy = contentlengthstrategy1;
    }

    private int fillInputBuffer(int i)
        throws IOException
    {
        Socket socket;
        int j;
        socket = (Socket)socketHolder.get();
        j = socket.getSoTimeout();
        socket.setSoTimeout(i);
        i = inbuffer.fillBuffer();
        socket.setSoTimeout(j);
        return i;
        Exception exception;
        exception;
        socket.setSoTimeout(j);
        throw exception;
    }

    protected boolean awaitInput(int i)
        throws IOException
    {
        if (inbuffer.hasBufferedData())
        {
            return true;
        } else
        {
            fillInputBuffer(i);
            return inbuffer.hasBufferedData();
        }
    }

    protected void bind(Socket socket)
        throws IOException
    {
        Args.notNull(socket, "Socket");
        socketHolder.set(socket);
        inbuffer.bind(null);
        outbuffer.bind(null);
    }

    public void close()
        throws IOException
    {
        Socket socket = (Socket)socketHolder.getAndSet(null);
        if (socket == null) goto _L2; else goto _L1
_L1:
        inbuffer.clear();
        outbuffer.flush();
        Exception exception;
        try
        {
            socket.shutdownOutput();
        }
        catch (IOException ioexception) { }
        try
        {
            socket.shutdownInput();
        }
        catch (IOException ioexception1) { }
_L4:
        socket.close();
_L2:
        return;
        exception;
        socket.close();
        throw exception;
        UnsupportedOperationException unsupportedoperationexception;
        unsupportedoperationexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected InputStream createInputStream(long l, SessionInputBuffer sessioninputbuffer)
    {
        if (l == -2L)
        {
            return new ChunkedInputStream(sessioninputbuffer);
        }
        if (l == -1L)
        {
            return new IdentityInputStream(sessioninputbuffer);
        } else
        {
            return new ContentLengthInputStream(sessioninputbuffer, l);
        }
    }

    protected OutputStream createOutputStream(long l, SessionOutputBuffer sessionoutputbuffer)
    {
        if (l == -2L)
        {
            return new ChunkedOutputStream(2048, sessionoutputbuffer);
        }
        if (l == -1L)
        {
            return new IdentityOutputStream(sessionoutputbuffer);
        } else
        {
            return new ContentLengthOutputStream(sessionoutputbuffer, l);
        }
    }

    protected void doFlush()
        throws IOException
    {
        outbuffer.flush();
    }

    protected void ensureOpen()
        throws IOException
    {
        Socket socket = (Socket)socketHolder.get();
        boolean flag;
        if (socket != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Connection is not open");
        if (!inbuffer.isBound())
        {
            inbuffer.bind(getSocketInputStream(socket));
        }
        if (!outbuffer.isBound())
        {
            outbuffer.bind(getSocketOutputStream(socket));
        }
    }

    public InetAddress getLocalAddress()
    {
        Socket socket = (Socket)socketHolder.get();
        if (socket != null)
        {
            return socket.getLocalAddress();
        } else
        {
            return null;
        }
    }

    public int getLocalPort()
    {
        Socket socket = (Socket)socketHolder.get();
        if (socket != null)
        {
            return socket.getLocalPort();
        } else
        {
            return -1;
        }
    }

    public HttpConnectionMetrics getMetrics()
    {
        return connMetrics;
    }

    public InetAddress getRemoteAddress()
    {
        Socket socket = (Socket)socketHolder.get();
        if (socket != null)
        {
            return socket.getInetAddress();
        } else
        {
            return null;
        }
    }

    public int getRemotePort()
    {
        Socket socket = (Socket)socketHolder.get();
        if (socket != null)
        {
            return socket.getPort();
        } else
        {
            return -1;
        }
    }

    protected SessionInputBuffer getSessionInputBuffer()
    {
        return inbuffer;
    }

    protected SessionOutputBuffer getSessionOutputBuffer()
    {
        return outbuffer;
    }

    protected Socket getSocket()
    {
        return (Socket)socketHolder.get();
    }

    protected InputStream getSocketInputStream(Socket socket)
        throws IOException
    {
        return socket.getInputStream();
    }

    protected OutputStream getSocketOutputStream(Socket socket)
        throws IOException
    {
        return socket.getOutputStream();
    }

    public int getSocketTimeout()
    {
        int i = -1;
        Socket socket = (Socket)socketHolder.get();
        if (socket != null)
        {
            try
            {
                i = socket.getSoTimeout();
            }
            catch (SocketException socketexception)
            {
                return -1;
            }
        }
        return i;
    }

    protected void incrementRequestCount()
    {
        connMetrics.incrementRequestCount();
    }

    protected void incrementResponseCount()
    {
        connMetrics.incrementResponseCount();
    }

    public boolean isOpen()
    {
        return socketHolder.get() != null;
    }

    public boolean isStale()
    {
        if (isOpen())
        {
            int i;
            try
            {
                i = fillInputBuffer(1);
            }
            catch (SocketTimeoutException sockettimeoutexception)
            {
                return false;
            }
            catch (IOException ioexception)
            {
                return true;
            }
            if (i >= 0)
            {
                return false;
            }
        }
        return true;
    }

    protected HttpEntity prepareInput(HttpMessage httpmessage)
        throws HttpException
    {
        BasicHttpEntity basichttpentity = new BasicHttpEntity();
        long l = incomingContentStrategy.determineLength(httpmessage);
        Object obj = createInputStream(l, inbuffer);
        if (l == -2L)
        {
            basichttpentity.setChunked(true);
            basichttpentity.setContentLength(-1L);
            basichttpentity.setContent(((InputStream) (obj)));
        } else
        if (l == -1L)
        {
            basichttpentity.setChunked(false);
            basichttpentity.setContentLength(-1L);
            basichttpentity.setContent(((InputStream) (obj)));
        } else
        {
            basichttpentity.setChunked(false);
            basichttpentity.setContentLength(l);
            basichttpentity.setContent(((InputStream) (obj)));
        }
        obj = httpmessage.getFirstHeader("Content-Type");
        if (obj != null)
        {
            basichttpentity.setContentType(((cz.msebera.android.httpclient.Header) (obj)));
        }
        httpmessage = httpmessage.getFirstHeader("Content-Encoding");
        if (httpmessage != null)
        {
            basichttpentity.setContentEncoding(httpmessage);
        }
        return basichttpentity;
    }

    protected OutputStream prepareOutput(HttpMessage httpmessage)
        throws HttpException
    {
        return createOutputStream(outgoingContentStrategy.determineLength(httpmessage), outbuffer);
    }

    public void setSocketTimeout(int i)
    {
        Socket socket;
        socket = (Socket)socketHolder.get();
        if (socket == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        socket.setSoTimeout(i);
        return;
        SocketException socketexception;
        socketexception;
    }

    public void shutdown()
        throws IOException
    {
        Socket socket = (Socket)socketHolder.getAndSet(null);
        if (socket != null)
        {
            socket.close();
        }
    }

    public String toString()
    {
        Object obj = (Socket)socketHolder.get();
        if (obj != null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            java.net.SocketAddress socketaddress = ((Socket) (obj)).getRemoteSocketAddress();
            obj = ((Socket) (obj)).getLocalSocketAddress();
            if (socketaddress != null && obj != null)
            {
                NetUtils.formatAddress(stringbuilder, ((java.net.SocketAddress) (obj)));
                stringbuilder.append("<->");
                NetUtils.formatAddress(stringbuilder, socketaddress);
            }
            return stringbuilder.toString();
        } else
        {
            return "[Not bound]";
        }
    }
}
