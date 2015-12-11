// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl;

import com.comcast.cim.httpcomponentsandroid.HttpClientConnection;
import com.comcast.cim.httpcomponentsandroid.HttpConnectionMetrics;
import com.comcast.cim.httpcomponentsandroid.HttpEntityEnclosingRequest;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.HttpResponseFactory;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import com.comcast.cim.httpcomponentsandroid.impl.entity.EntityDeserializer;
import com.comcast.cim.httpcomponentsandroid.impl.entity.EntitySerializer;
import com.comcast.cim.httpcomponentsandroid.impl.entity.LaxContentLengthStrategy;
import com.comcast.cim.httpcomponentsandroid.impl.entity.StrictContentLengthStrategy;
import com.comcast.cim.httpcomponentsandroid.impl.io.HttpRequestWriter;
import com.comcast.cim.httpcomponentsandroid.impl.io.HttpResponseParser;
import com.comcast.cim.httpcomponentsandroid.io.EofSensor;
import com.comcast.cim.httpcomponentsandroid.io.HttpMessageParser;
import com.comcast.cim.httpcomponentsandroid.io.HttpMessageWriter;
import com.comcast.cim.httpcomponentsandroid.io.HttpTransportMetrics;
import com.comcast.cim.httpcomponentsandroid.io.SessionInputBuffer;
import com.comcast.cim.httpcomponentsandroid.io.SessionOutputBuffer;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl:
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
        return new DefaultHttpResponseFactory();
    }

    protected HttpMessageWriter createRequestWriter(SessionOutputBuffer sessionoutputbuffer, HttpParams httpparams)
    {
        return new HttpRequestWriter(sessionoutputbuffer, null, httpparams);
    }

    protected HttpMessageParser createResponseParser(SessionInputBuffer sessioninputbuffer, HttpResponseFactory httpresponsefactory, HttpParams httpparams)
    {
        return new HttpResponseParser(sessioninputbuffer, null, httpresponsefactory, httpparams);
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
        if (sessioninputbuffer == null)
        {
            throw new IllegalArgumentException("Input session buffer may not be null");
        }
        if (sessionoutputbuffer == null)
        {
            throw new IllegalArgumentException("Output session buffer may not be null");
        }
        inbuffer = sessioninputbuffer;
        outbuffer = sessionoutputbuffer;
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
        return inbuffer.isDataAvailable(i);
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

    public void receiveResponseEntity(HttpResponse httpresponse)
        throws HttpException, IOException
    {
        if (httpresponse == null)
        {
            throw new IllegalArgumentException("HTTP response may not be null");
        } else
        {
            assertOpen();
            httpresponse.setEntity(entitydeserializer.deserialize(inbuffer, httpresponse));
            return;
        }
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
        if (httpentityenclosingrequest == null)
        {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
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
        if (httprequest == null)
        {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else
        {
            assertOpen();
            requestWriter.write(httprequest);
            metrics.incrementRequestCount();
            return;
        }
    }
}
