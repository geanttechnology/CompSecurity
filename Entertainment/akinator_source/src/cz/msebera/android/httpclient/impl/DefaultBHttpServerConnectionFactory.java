// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.HttpConnectionFactory;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import java.io.IOException;
import java.net.Socket;

// Referenced classes of package cz.msebera.android.httpclient.impl:
//            DefaultBHttpServerConnection, ConnSupport

public class DefaultBHttpServerConnectionFactory
    implements HttpConnectionFactory
{

    public static final DefaultBHttpServerConnectionFactory INSTANCE = new DefaultBHttpServerConnectionFactory();
    private final ConnectionConfig cconfig;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageParserFactory requestParserFactory;
    private final HttpMessageWriterFactory responseWriterFactory;

    public DefaultBHttpServerConnectionFactory()
    {
        this(null, null, null, null, null);
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionconfig)
    {
        this(connectionconfig, null, null, null, null);
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionconfig, ContentLengthStrategy contentlengthstrategy, ContentLengthStrategy contentlengthstrategy1, HttpMessageParserFactory httpmessageparserfactory, HttpMessageWriterFactory httpmessagewriterfactory)
    {
        if (connectionconfig == null)
        {
            connectionconfig = ConnectionConfig.DEFAULT;
        }
        cconfig = connectionconfig;
        incomingContentStrategy = contentlengthstrategy;
        outgoingContentStrategy = contentlengthstrategy1;
        requestParserFactory = httpmessageparserfactory;
        responseWriterFactory = httpmessagewriterfactory;
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionconfig, HttpMessageParserFactory httpmessageparserfactory, HttpMessageWriterFactory httpmessagewriterfactory)
    {
        this(connectionconfig, null, null, httpmessageparserfactory, httpmessagewriterfactory);
    }

    public volatile HttpConnection createConnection(Socket socket)
        throws IOException
    {
        return createConnection(socket);
    }

    public DefaultBHttpServerConnection createConnection(Socket socket)
        throws IOException
    {
        DefaultBHttpServerConnection defaultbhttpserverconnection = new DefaultBHttpServerConnection(cconfig.getBufferSize(), cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(cconfig), ConnSupport.createEncoder(cconfig), cconfig.getMessageConstraints(), incomingContentStrategy, outgoingContentStrategy, requestParserFactory, responseWriterFactory);
        defaultbhttpserverconnection.bind(socket);
        return defaultbhttpserverconnection;
    }

}
