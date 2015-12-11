// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestFactory;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpServerConnection;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.impl.entity.DisallowIdentityContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.EntityDeserializer;
import cz.msebera.android.httpclient.impl.entity.EntitySerializer;
import cz.msebera.android.httpclient.impl.entity.LaxContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.StrictContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.DefaultHttpRequestParser;
import cz.msebera.android.httpclient.impl.io.HttpResponseWriter;
import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.impl:
//            HttpConnectionMetricsImpl, DefaultHttpRequestFactory

public abstract class AbstractHttpServerConnection
    implements HttpServerConnection
{

    private final EntityDeserializer entitydeserializer = createEntityDeserializer();
    private final EntitySerializer entityserializer = createEntitySerializer();
    private EofSensor eofSensor;
    private SessionInputBuffer inbuffer;
    private HttpConnectionMetricsImpl metrics;
    private SessionOutputBuffer outbuffer;
    private HttpMessageParser requestParser;
    private HttpMessageWriter responseWriter;

    public AbstractHttpServerConnection()
    {
        inbuffer = null;
        outbuffer = null;
        eofSensor = null;
        requestParser = null;
        responseWriter = null;
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
        return new EntityDeserializer(new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0)));
    }

    protected EntitySerializer createEntitySerializer()
    {
        return new EntitySerializer(new StrictContentLengthStrategy());
    }

    protected HttpRequestFactory createHttpRequestFactory()
    {
        return DefaultHttpRequestFactory.INSTANCE;
    }

    protected HttpMessageParser createRequestParser(SessionInputBuffer sessioninputbuffer, HttpRequestFactory httprequestfactory, HttpParams httpparams)
    {
        return new DefaultHttpRequestParser(sessioninputbuffer, null, httprequestfactory, httpparams);
    }

    protected HttpMessageWriter createResponseWriter(SessionOutputBuffer sessionoutputbuffer, HttpParams httpparams)
    {
        return new HttpResponseWriter(sessionoutputbuffer, null, httpparams);
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
        requestParser = createRequestParser(sessioninputbuffer, createHttpRequestFactory(), httpparams);
        responseWriter = createResponseWriter(sessionoutputbuffer, httpparams);
        metrics = createConnectionMetrics(sessioninputbuffer.getMetrics(), sessionoutputbuffer.getMetrics());
    }

    protected boolean isEof()
    {
        return eofSensor != null && eofSensor.isEof();
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
        catch (IOException ioexception)
        {
            return true;
        }
        return flag;
    }

    public void receiveRequestEntity(HttpEntityEnclosingRequest httpentityenclosingrequest)
        throws HttpException, IOException
    {
        Args.notNull(httpentityenclosingrequest, "HTTP request");
        assertOpen();
        httpentityenclosingrequest.setEntity(entitydeserializer.deserialize(inbuffer, httpentityenclosingrequest));
    }

    public HttpRequest receiveRequestHeader()
        throws HttpException, IOException
    {
        assertOpen();
        HttpRequest httprequest = (HttpRequest)requestParser.parse();
        metrics.incrementRequestCount();
        return httprequest;
    }

    public void sendResponseEntity(HttpResponse httpresponse)
        throws HttpException, IOException
    {
        if (httpresponse.getEntity() == null)
        {
            return;
        } else
        {
            entityserializer.serialize(outbuffer, httpresponse, httpresponse.getEntity());
            return;
        }
    }

    public void sendResponseHeader(HttpResponse httpresponse)
        throws HttpException, IOException
    {
        Args.notNull(httpresponse, "HTTP response");
        assertOpen();
        responseWriter.write(httpresponse);
        if (httpresponse.getStatusLine().getStatusCode() >= 200)
        {
            metrics.incrementResponseCount();
        }
    }
}
