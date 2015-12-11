// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.DefaultHttpRequestWriterFactory;
import cz.msebera.android.httpclient.impl.io.DefaultHttpResponseParserFactory;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

// Referenced classes of package cz.msebera.android.httpclient.impl:
//            BHttpConnectionBase

public class DefaultBHttpClientConnection extends BHttpConnectionBase
    implements HttpClientConnection
{

    private final HttpMessageWriter requestWriter;
    private final HttpMessageParser responseParser;

    public DefaultBHttpClientConnection(int i)
    {
        this(i, i, null, null, null, null, null, null, null);
    }

    public DefaultBHttpClientConnection(int i, int j, CharsetDecoder charsetdecoder, CharsetEncoder charsetencoder, MessageConstraints messageconstraints, ContentLengthStrategy contentlengthstrategy, ContentLengthStrategy contentlengthstrategy1, 
            HttpMessageWriterFactory httpmessagewriterfactory, HttpMessageParserFactory httpmessageparserfactory)
    {
        super(i, j, charsetdecoder, charsetencoder, messageconstraints, contentlengthstrategy, contentlengthstrategy1);
        if (httpmessagewriterfactory == null)
        {
            httpmessagewriterfactory = DefaultHttpRequestWriterFactory.INSTANCE;
        }
        requestWriter = httpmessagewriterfactory.create(getSessionOutputBuffer());
        if (httpmessageparserfactory == null)
        {
            httpmessageparserfactory = DefaultHttpResponseParserFactory.INSTANCE;
        }
        responseParser = httpmessageparserfactory.create(getSessionInputBuffer(), messageconstraints);
    }

    public DefaultBHttpClientConnection(int i, CharsetDecoder charsetdecoder, CharsetEncoder charsetencoder, MessageConstraints messageconstraints)
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

    public boolean isResponseAvailable(int i)
        throws IOException
    {
        ensureOpen();
        boolean flag;
        try
        {
            flag = awaitInput(i);
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            return false;
        }
        return flag;
    }

    protected void onRequestSubmitted(HttpRequest httprequest)
    {
    }

    protected void onResponseReceived(HttpResponse httpresponse)
    {
    }

    public void receiveResponseEntity(HttpResponse httpresponse)
        throws HttpException, IOException
    {
        Args.notNull(httpresponse, "HTTP response");
        ensureOpen();
        httpresponse.setEntity(prepareInput(httpresponse));
    }

    public HttpResponse receiveResponseHeader()
        throws HttpException, IOException
    {
        ensureOpen();
        HttpResponse httpresponse = (HttpResponse)responseParser.parse();
        onResponseReceived(httpresponse);
        if (httpresponse.getStatusLine().getStatusCode() >= 200)
        {
            incrementResponseCount();
        }
        return httpresponse;
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpentityenclosingrequest)
        throws HttpException, IOException
    {
        Args.notNull(httpentityenclosingrequest, "HTTP request");
        ensureOpen();
        HttpEntity httpentity = httpentityenclosingrequest.getEntity();
        if (httpentity == null)
        {
            return;
        } else
        {
            httpentityenclosingrequest = prepareOutput(httpentityenclosingrequest);
            httpentity.writeTo(httpentityenclosingrequest);
            httpentityenclosingrequest.close();
            return;
        }
    }

    public void sendRequestHeader(HttpRequest httprequest)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        ensureOpen();
        requestWriter.write(httprequest);
        onRequestSubmitted(httprequest);
        incrementRequestCount();
    }
}
