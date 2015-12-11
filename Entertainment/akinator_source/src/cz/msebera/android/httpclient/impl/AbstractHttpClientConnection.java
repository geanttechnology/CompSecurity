// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.impl.entity.EntityDeserializer;
import cz.msebera.android.httpclient.impl.entity.EntitySerializer;
import cz.msebera.android.httpclient.impl.entity.LaxContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.StrictContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.DefaultHttpResponseParser;
import cz.msebera.android.httpclient.impl.io.HttpRequestWriter;
import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.SocketTimeoutException;

// Referenced classes of package cz.msebera.android.httpclient.impl:
//            HttpConnectionMetricsImpl, DefaultHttpResponseFactory

public abstract class AbstractHttpClientConnection
    implements HttpClientConnection
{

    private final EntityDeserializer entitydeserializer = createEntityDeserializer();
    private final EntitySerializer entityserializer = createEntitySerializer();
    private EofSensor eofSensor;
    private SessionInputBuffer inbuffer;
    private HttpConnectionMetricsImpl metrics;
    private SessionOutputBuffer outbuffer;
    private HttpMessageWriter requestWriter;
    private HttpMessageParser responseParser;

    public AbstractHttpClientConnection()
    {
        inbuffer = null;
        outbuffer = null;
        eofSensor = null;
        responseParser = null;
        requestWriter = null;
        metrics = null;
    }

    protected abstract void assertOpen()
        throws IllegalStateException;

    protected HttpConnectionMetricsImpl createConnectionMetrics(HttpTransportMetrics httptransportmetrics, HttpTransportMetrics httptransportmetrics1)
    {
        return new HttpConnectionMetricsImpl(httptransportmetrics, httptransportmetrics1);
    }

    protected EntityDeserializer createEntityDeserializer()
    {
        return new EntityDeserializer(new LaxContentLengthStrategy());
    }

    protected EntitySerializer createEntitySerializer()
    {
        return new EntitySerializer(new StrictContentLengthStrategy());
    }

    protected HttpResponseFactory createHttpResponseFactory()
    {
        return DefaultHttpResponseFactory.INSTANCE;
    }

    protected HttpMessageWriter createRequestWriter(SessionOutputBuffer sessionoutputbuffer, HttpParams httpparams)
    {
        return new HttpRequestWriter(sessionoutputbuffer, null, httpparams);
    }

    protected HttpMessageParser createResponseParser(SessionInputBuffer sessioninputbuffer, HttpResponseFactory httpresponsefactory, HttpParams httpparams)
    {
        return new DefaultHttpResponseParser(sessioninputbuffer, null, httpresponsefactory, httpparams);
    }

    protected void doFlush()
        throws IOException
    {
        outbuffer.flush();
    }

    public void flush()
        throws IOException
    {
        assertOpen();
        doFlush();
    }

    public HttpConnectionMetrics getMetrics()
    {
        return metrics;
    }

    protected void init(SessionInputBuffer sessioninputbuffer, SessionOutputBuffer sessionoutputbuffer, HttpParams httpparams)
    {
        inbuffer = (SessionInputBuffer)Args.notNull(sessioninputbuffer, "Input session buffer");
        outbuffer = (SessionOutputBuffer)Args.notNull(sessionoutputbuffer, "Output session buffer");
        if (sessioninputbuffer instanceof EofSensor)
        {
            eofSensor = (EofSensor)sessioninputbuffer;
        }
        responseParser = createResponseParser(sessioninputbuffer, createHttpResponseFactory(), httpparams);
        requestWriter = createRequestWriter(sessionoutputbuffer, httpparams);
        metrics = createConnectionMetrics(sessioninputbuffer.getMetrics(), sessionoutputbuffer.getMetrics());
    }

    protected boolean isEof()
    {
        return eofSensor != null && eofSensor.isEof();
    }

    public boolean isResponseAvailable(int i)
        throws IOException
    {
        assertOpen();
        boolean flag;
        try
        {
            flag = inbuffer.isDataAvailable(i);
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            return false;
        }
        return flag;
    }

    public boolean isStale()
    {
        while (!isOpen() || isEof()) 
        {
            return true;
        }
        boolean flag;
        try
        {
            inbuffer.isDataAvailable(1);
            flag = isEof();
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            return false;
        }
        catch (IOException ioexception)
        {
            return true;
        }
        return flag;
    }

    public void receiveResponseEntity(HttpResponse httpresponse)
        throws HttpException, IOException
    {
        Args.notNull(httpresponse, "HTTP response");
        assertOpen();
        httpresponse.setEntity(entitydeserializer.deserialize(inbuffer, httpresponse));
    }

    public HttpResponse receiveResponseHeader()
        throws HttpException, IOException
    {
        assertOpen();
        HttpResponse httpresponse = (HttpResponse)responseParser.parse();
        if (httpresponse.getStatusLine().getStatusCode() >= 200)
        {
            metrics.incrementResponseCount();
        }
        return httpresponse;
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpentityenclosingrequest)
        throws HttpException, IOException
    {
        Args.notNull(httpentityenclosingrequest, "HTTP request");
        assertOpen();
        if (httpentityenclosingrequest.getEntity() == null)
        {
            return;
        } else
        {
            entityserializer.serialize(outbuffer, httpentityenclosingrequest, httpentityenclosingrequest.getEntity());
            return;
        }
    }

    public void sendRequestHeader(HttpRequest httprequest)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        assertOpen();
        requestWriter.write(httprequest);
        metrics.incrementRequestCount();
    }
}
