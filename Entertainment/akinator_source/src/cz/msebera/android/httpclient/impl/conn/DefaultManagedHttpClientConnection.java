// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.DefaultBHttpClientConnection;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class DefaultManagedHttpClientConnection extends DefaultBHttpClientConnection
    implements ManagedHttpClientConnection, HttpContext
{

    private final Map attributes;
    private final String id;
    private volatile boolean shutdown;

    public DefaultManagedHttpClientConnection(String s, int i)
    {
        this(s, i, i, null, null, null, null, null, null, null);
    }

    public DefaultManagedHttpClientConnection(String s, int i, int j, CharsetDecoder charsetdecoder, CharsetEncoder charsetencoder, MessageConstraints messageconstraints, ContentLengthStrategy contentlengthstrategy, 
            ContentLengthStrategy contentlengthstrategy1, HttpMessageWriterFactory httpmessagewriterfactory, HttpMessageParserFactory httpmessageparserfactory)
    {
        super(i, j, charsetdecoder, charsetencoder, messageconstraints, contentlengthstrategy, contentlengthstrategy1, httpmessagewriterfactory, httpmessageparserfactory);
        id = s;
        attributes = new ConcurrentHashMap();
    }

    public void bind(Socket socket)
        throws IOException
    {
        if (shutdown)
        {
            socket.close();
            throw new InterruptedIOException("Connection already shutdown");
        } else
        {
            super.bind(socket);
            return;
        }
    }

    public Object getAttribute(String s)
    {
        return attributes.get(s);
    }

    public String getId()
    {
        return id;
    }

    public SSLSession getSSLSession()
    {
        Socket socket = super.getSocket();
        if (socket instanceof SSLSocket)
        {
            return ((SSLSocket)socket).getSession();
        } else
        {
            return null;
        }
    }

    public Socket getSocket()
    {
        return super.getSocket();
    }

    public Object removeAttribute(String s)
    {
        return attributes.remove(s);
    }

    public void setAttribute(String s, Object obj)
    {
        attributes.put(s, obj);
    }

    public void shutdown()
        throws IOException
    {
        shutdown = true;
        super.shutdown();
    }
}
