// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn;

import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.HttpResponseFactory;
import com.comcast.cim.httpcomponentsandroid.conn.OperatedClientConnection;
import com.comcast.cim.httpcomponentsandroid.impl.SocketHttpClientConnection;
import com.comcast.cim.httpcomponentsandroid.io.HttpMessageParser;
import com.comcast.cim.httpcomponentsandroid.io.SessionInputBuffer;
import com.comcast.cim.httpcomponentsandroid.io.SessionOutputBuffer;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpProtocolParams;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.conn:
//            DefaultResponseParser, LoggingSessionInputBuffer, Wire, LoggingSessionOutputBuffer

public class DefaultClientConnection extends SocketHttpClientConnection
    implements OperatedClientConnection, HttpContext
{

    private final Map attributes = new HashMap();
    private boolean connSecure;
    private final Log headerLog = LogFactory.getLog("com.comcast.cim.httpcomponentsandroid.headers");
    private final Log log = LogFactory.getLog(getClass());
    private volatile boolean shutdown;
    private volatile Socket socket;
    private HttpHost targetHost;
    private final Log wireLog = LogFactory.getLog("com.comcast.cim.httpcomponentsandroid.wire");

    public DefaultClientConnection()
    {
    }

    public void close()
        throws IOException
    {
        try
        {
            super.close();
            log.debug("Connection closed");
            return;
        }
        catch (IOException ioexception)
        {
            log.debug("I/O error closing connection", ioexception);
        }
    }

    protected HttpMessageParser createResponseParser(SessionInputBuffer sessioninputbuffer, HttpResponseFactory httpresponsefactory, HttpParams httpparams)
    {
        return new DefaultResponseParser(sessioninputbuffer, null, httpresponsefactory, httpparams);
    }

    protected SessionInputBuffer createSessionInputBuffer(Socket socket1, int i, HttpParams httpparams)
        throws IOException
    {
        int j = i;
        if (i == -1)
        {
            j = 8192;
        }
        SessionInputBuffer sessioninputbuffer = super.createSessionInputBuffer(socket1, j, httpparams);
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
        int j = i;
        if (i == -1)
        {
            j = 8192;
        }
        SessionOutputBuffer sessionoutputbuffer = super.createSessionOutputBuffer(socket1, j, httpparams);
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
        assertNotOpen();
        if (httpparams == null)
        {
            throw new IllegalArgumentException("Parameters must not be null.");
        } else
        {
            connSecure = flag;
            bind(socket, httpparams);
            return;
        }
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
            throw new IOException("Connection already shutdown");
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
            com.comcast.cim.httpcomponentsandroid.Header aheader[] = httpresponse.getAllHeaders();
            int j = aheader.length;
            for (int i = 0; i < j; i++)
            {
                com.comcast.cim.httpcomponentsandroid.Header header = aheader[i];
                headerLog.debug((new StringBuilder()).append("<< ").append(header.toString()).toString());
            }

        }
        return httpresponse;
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
            log.debug("Connection shut down");
            socket1 = socket;
        }
        catch (IOException ioexception)
        {
            log.debug("I/O error shutting down connection", ioexception);
            return;
        }
        if (socket1 == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        socket1.close();
    }

    public void update(Socket socket1, HttpHost httphost, boolean flag, HttpParams httpparams)
        throws IOException
    {
        assertOpen();
        if (httphost == null)
        {
            throw new IllegalArgumentException("Target host must not be null.");
        }
        if (httpparams == null)
        {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        if (socket1 != null)
        {
            socket = socket1;
            bind(socket1, httpparams);
        }
        targetHost = httphost;
        connSecure = flag;
    }
}
