// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.SocketHttpClientConnection;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            DefaultHttpResponseParser, LoggingSessionInputBuffer, Wire, LoggingSessionOutputBuffer

public class DefaultClientConnection extends SocketHttpClientConnection
    implements OperatedClientConnection, ManagedHttpClientConnection, HttpContext
{

    private final Map attributes = new HashMap();
    private boolean connSecure;
    public HttpClientAndroidLog headerLog;
    public HttpClientAndroidLog log;
    private volatile boolean shutdown;
    private volatile Socket socket;
    private HttpHost targetHost;
    public HttpClientAndroidLog wireLog;

    public DefaultClientConnection()
    {
        log = new HttpClientAndroidLog(getClass());
        headerLog = new HttpClientAndroidLog("cz.msebera.android.httpclient.headers");
        wireLog = new HttpClientAndroidLog("cz.msebera.android.httpclient.wire");
    }

    public void bind(Socket socket1)
        throws IOException
    {
        bind(socket1, ((HttpParams) (new BasicHttpParams())));
    }

    public void close()
        throws IOException
    {
        try
        {
            super.close();
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Connection ").append(this).append(" closed").toString());
            }
            return;
        }
        catch (IOException ioexception)
        {
            log.debug("I/O error closing connection", ioexception);
        }
    }

    protected HttpMessageParser createResponseParser(SessionInputBuffer sessioninputbuffer, HttpResponseFactory httpresponsefactory, HttpParams httpparams)
    {
        return new DefaultHttpResponseParser(sessioninputbuffer, null, httpresponsefactory, httpparams);
    }

    protected SessionInputBuffer createSessionInputBuffer(Socket socket1, int i, HttpParams httpparams)
        throws IOException
    {
        SessionInputBuffer sessioninputbuffer;
        if (i <= 0)
        {
            i = 8192;
        }
        sessioninputbuffer = super.createSessionInputBuffer(socket1, i, httpparams);
        socket1 = sessioninputbuffer;
        if (wireLog.isDebugEnabled())
        {
            socket1 = new LoggingSessionInputBuffer(sessioninputbuffer, new Wire(wireLog), HttpProtocolParams.getHttpElementCharset(httpparams));
        }
        return socket1;
    }

    protected SessionOutputBuffer createSessionOutputBuffer(Socket socket1, int i, HttpParams httpparams)
        throws IOException
    {
        SessionOutputBuffer sessionoutputbuffer;
        if (i <= 0)
        {
            i = 8192;
        }
        sessionoutputbuffer = super.createSessionOutputBuffer(socket1, i, httpparams);
        socket1 = sessionoutputbuffer;
        if (wireLog.isDebugEnabled())
        {
            socket1 = new LoggingSessionOutputBuffer(sessionoutputbuffer, new Wire(wireLog), HttpProtocolParams.getHttpElementCharset(httpparams));
        }
        return socket1;
    }

    public Object getAttribute(String s)
    {
        return attributes.get(s);
    }

    public String getId()
    {
        return null;
    }

    public SSLSession getSSLSession()
    {
        if (socket instanceof SSLSocket)
        {
            return ((SSLSocket)socket).getSession();
        } else
        {
            return null;
        }
    }

    public final Socket getSocket()
    {
        return socket;
    }

    public final HttpHost getTargetHost()
    {
        return targetHost;
    }

    public final boolean isSecure()
    {
        return connSecure;
    }

    public void openCompleted(boolean flag, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(httpparams, "Parameters");
        assertNotOpen();
        connSecure = flag;
        bind(socket, httpparams);
    }

    public void opening(Socket socket1, HttpHost httphost)
        throws IOException
    {
        assertNotOpen();
        socket = socket1;
        targetHost = httphost;
        if (shutdown)
        {
            socket1.close();
            throw new InterruptedIOException("Connection already shutdown");
        } else
        {
            return;
        }
    }

    public HttpResponse receiveResponseHeader()
        throws HttpException, IOException
    {
        HttpResponse httpresponse = super.receiveResponseHeader();
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Receiving response: ").append(httpresponse.getStatusLine()).toString());
        }
        if (headerLog.isDebugEnabled())
        {
            headerLog.debug((new StringBuilder()).append("<< ").append(httpresponse.getStatusLine().toString()).toString());
            cz.msebera.android.httpclient.Header aheader[] = httpresponse.getAllHeaders();
            int j = aheader.length;
            for (int i = 0; i < j; i++)
            {
                cz.msebera.android.httpclient.Header header = aheader[i];
                headerLog.debug((new StringBuilder()).append("<< ").append(header.toString()).toString());
            }

        }
        return httpresponse;
    }

    public Object removeAttribute(String s)
    {
        return attributes.remove(s);
    }

    public void sendRequestHeader(HttpRequest httprequest)
        throws HttpException, IOException
    {
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Sending request: ").append(httprequest.getRequestLine()).toString());
        }
        super.sendRequestHeader(httprequest);
        if (headerLog.isDebugEnabled())
        {
            headerLog.debug((new StringBuilder()).append(">> ").append(httprequest.getRequestLine().toString()).toString());
            httprequest = httprequest.getAllHeaders();
            int j = httprequest.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = httprequest[i];
                headerLog.debug((new StringBuilder()).append(">> ").append(obj.toString()).toString());
            }

        }
    }

    public void setAttribute(String s, Object obj)
    {
        attributes.put(s, obj);
    }

    public void shutdown()
        throws IOException
    {
        shutdown = true;
        Socket socket1;
        try
        {
            super.shutdown();
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Connection ").append(this).append(" shut down").toString());
            }
            socket1 = socket;
        }
        catch (IOException ioexception)
        {
            log.debug("I/O error shutting down connection", ioexception);
            return;
        }
        if (socket1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        socket1.close();
    }

    public void update(Socket socket1, HttpHost httphost, boolean flag, HttpParams httpparams)
        throws IOException
    {
        assertOpen();
        Args.notNull(httphost, "Target host");
        Args.notNull(httpparams, "Parameters");
        if (socket1 != null)
        {
            socket = socket1;
            bind(socket1, httpparams);
        }
        targetHost = httphost;
        connSecure = flag;
    }
}
