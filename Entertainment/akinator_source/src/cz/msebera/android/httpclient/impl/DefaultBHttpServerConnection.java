// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpServerConnection;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.DisallowIdentityContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.DefaultHttpRequestParserFactory;
import cz.msebera.android.httpclient.impl.io.DefaultHttpResponseWriterFactory;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

// Referenced classes of package cz.msebera.android.httpclient.impl:
//            BHttpConnectionBase

public class DefaultBHttpServerConnection extends BHttpConnectionBase
    implements HttpServerConnection
{

    private final HttpMessageParser requestParser;
    private final HttpMessageWriter responseWriter;

    public DefaultBHttpServerConnection(int i)
    {
        this(i, i, null, null, null, null, null, null, null);
    }

    public DefaultBHttpServerConnection(int i, int j, CharsetDecoder charsetdecoder, CharsetEncoder charsetencoder, MessageConstraints messageconstraints, ContentLengthStrategy contentlengthstrategy, ContentLengthStrategy contentlengthstrategy1, 
            HttpMessageParserFactory httpmessageparserfactory, HttpMessageWriterFactory httpmessagewriterfactory)
    {
        if (contentlengthstrategy == null)
        {
            contentlengthstrategy = DisallowIdentityContentLengthStrategy.INSTANCE;
        }
        super(i, j, charsetdecoder, charsetencoder, messageconstraints, contentlengthstrategy, contentlengthstrategy1);
        if (httpmessageparserfactory == null)
        {
            httpmessageparserfactory = DefaultHttpRequestParserFactory.INSTANCE;
        }
        requestParser = httpmessageparserfactory.create(getSessionInputBuffer(), messageconstraints);
        if (httpmessagewriterfactory == null)
        {
            httpmessagewriterfactory = DefaultHttpResponseWriterFactory.INSTANCE;
        }
        responseWriter = httpmessagewriterfactory.create(getSessionOutputBuffer());
    }

    public DefaultBHttpServerConnection(int i, CharsetDecoder charsetdecoder, CharsetEncoder charsetencoder, MessageConstraints messageconstraints)
    {
        this(i, i, charsetdecoder, charsetencoder, messageconstraints, null, null, null, null);
    }

    public void bind(Socket socket)
        throws IOException
    {
        super.bind(socket);
    }

    public void flush()
        throws IOException
    {
        ensureOpen();
        doFlush();
    }

    protected void onRequestReceived(HttpRequest httprequest)
    {
    }

    protected void onResponseSubmitted(HttpResponse httpresponse)
    {
    }

    public void receiveRequestEntity(HttpEntityEnclosingRequest httpentityenclosingrequest)
        throws HttpException, IOException
    {
        Args.notNull(httpentityenclosingrequest, "HTTP request");
        ensureOpen();
        httpentityenclosingrequest.setEntity(prepareInput(httpentityenclosingrequest));
    }

    public HttpRequest receiveRequestHeader()
        throws HttpException, IOException
    {
        ensureOpen();
        HttpRequest httprequest = (HttpRequest)requestParser.parse();
        onRequestReceived(httprequest);
        incrementRequestCount();
        return httprequest;
    }

    public void sendResponseEntity(HttpResponse httpresponse)
        throws HttpException, IOException
    {
        Args.notNull(httpresponse, "HTTP response");
        ensureOpen();
        HttpEntity httpentity = httpresponse.getEntity();
        if (httpentity == null)
        {
            return;
        } else
        {
            httpresponse = prepareOutput(httpresponse);
            httpentity.writeTo(httpresponse);
            httpresponse.close();
            return;
        }
    }

    public void sendResponseHeader(HttpResponse httpresponse)
        throws HttpException, IOException
    {
        Args.notNull(httpresponse, "HTTP response");
        ensureOpen();
        responseWriter.write(httpresponse);
        onResponseSubmitted(httpresponse);
        if (httpresponse.getStatusLine().getStatusCode() >= 200)
        {
            incrementResponseCount();
        }
    }
}
