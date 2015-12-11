// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl;

import com.comcast.cim.httpcomponentsandroid.HttpConnectionMetrics;
import com.comcast.cim.httpcomponentsandroid.HttpServerConnection;
import com.comcast.cim.httpcomponentsandroid.impl.entity.EntityDeserializer;
import com.comcast.cim.httpcomponentsandroid.impl.entity.EntitySerializer;
import com.comcast.cim.httpcomponentsandroid.impl.entity.LaxContentLengthStrategy;
import com.comcast.cim.httpcomponentsandroid.impl.entity.StrictContentLengthStrategy;
import com.comcast.cim.httpcomponentsandroid.io.EofSensor;
import com.comcast.cim.httpcomponentsandroid.io.HttpMessageParser;
import com.comcast.cim.httpcomponentsandroid.io.HttpMessageWriter;
import com.comcast.cim.httpcomponentsandroid.io.SessionInputBuffer;
import com.comcast.cim.httpcomponentsandroid.io.SessionOutputBuffer;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl:
//            HttpConnectionMetricsImpl

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

    protected EntityDeserializer createEntityDeserializer()
    {
        return new EntityDeserializer(new LaxContentLengthStrategy());
    }

    protected EntitySerializer createEntitySerializer()
    {
        return new EntitySerializer(new StrictContentLengthStrategy());
    }

    protected void doFlush()
        throws IOException
    {
        outbuffer.flush();
    }

    public HttpConnectionMetrics getMetrics()
    {
        return metrics;
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
}
