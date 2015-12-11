// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.io.CountingOutputStream;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListenerSource;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.message.AbstractHttpMessage;

public final class HttpResponseEntityImpl
    implements StreamCompleteListener, HttpEntity
{

    private static final String ENCODING_CHUNKED = "chunked";
    private static final String TRANSFER_ENCODING_HEADER = "Transfer-Encoding";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final long contentLengthFromHeader;
    private CountingInputStream contentStream;
    private final HttpEntity impl;
    private final TransactionState transactionState;

    public HttpResponseEntityImpl(HttpEntity httpentity, TransactionState transactionstate, long l)
    {
        impl = httpentity;
        transactionState = transactionstate;
        contentLengthFromHeader = l;
    }

    private void addTransactionAndErrorData(TransactionState transactionstate)
    {
        TransactionData transactiondata = transactionstate.end();
        if (transactiondata != null)
        {
            TaskQueue.queue(new HttpTransactionMeasurement(transactiondata.getUrl(), transactiondata.getHttpMethod(), transactiondata.getStatusCode(), transactiondata.getErrorCode(), transactiondata.getTimestamp(), transactiondata.getTime(), transactiondata.getBytesSent(), transactiondata.getBytesReceived(), transactiondata.getAppData()));
            if ((long)transactionstate.getStatusCode() >= 400L)
            {
                StringBuilder stringbuilder = new StringBuilder();
                Header header;
                TreeMap treemap;
                try
                {
                    InputStream inputstream = getContent();
                    if (inputstream instanceof CountingInputStream)
                    {
                        stringbuilder.append(((CountingInputStream)inputstream).getBufferAsString());
                    }
                }
                catch (Exception exception)
                {
                    log.error(exception.toString());
                }
                header = impl.getContentType();
                treemap = new TreeMap();
                if (header != null && header.getValue() != null && !"".equals(header.getValue()))
                {
                    treemap.put("content_type", header.getValue());
                }
                treemap.put("content_length", (new StringBuilder()).append(transactionstate.getBytesReceived()).append("").toString());
                Measurements.addHttpError(transactiondata, stringbuilder.toString(), treemap);
                return;
            }
        }
    }

    private void handleException(Exception exception)
    {
        handleException(exception, null);
    }

    private void handleException(Exception exception, Long long1)
    {
        TransactionStateUtil.setErrorCodeFromException(transactionState, exception);
        if (!transactionState.isComplete())
        {
            if (long1 != null)
            {
                transactionState.setBytesReceived(long1.longValue());
            }
            exception = transactionState.end();
            if (exception != null)
            {
                TaskQueue.queue(new HttpTransactionMeasurement(exception.getUrl(), exception.getHttpMethod(), exception.getStatusCode(), exception.getErrorCode(), exception.getTimestamp(), exception.getTime(), exception.getBytesSent(), exception.getBytesReceived(), exception.getAppData()));
            }
        }
    }

    public void consumeContent()
        throws IOException
    {
        try
        {
            impl.consumeContent();
            return;
        }
        catch (IOException ioexception)
        {
            handleException(ioexception);
            throw ioexception;
        }
    }

    public InputStream getContent()
        throws IOException, IllegalStateException
    {
        boolean flag1;
        flag1 = true;
        if (contentStream != null)
        {
            return contentStream;
        }
        if (!(impl instanceof AbstractHttpMessage)) goto _L2; else goto _L1
_L1:
        Header header = ((AbstractHttpMessage)impl).getLastHeader("Transfer-Encoding");
        if (header == null) goto _L4; else goto _L3
_L3:
        if (!"chunked".equalsIgnoreCase(header.getValue())) goto _L4; else goto _L5
_L5:
        boolean flag = false;
_L7:
        boolean flag2;
        try
        {
            contentStream = new CountingInputStream(impl.getContent(), flag);
            contentStream.addStreamCompleteListener(this);
            return contentStream;
        }
        catch (IOException ioexception)
        {
            handleException(ioexception);
            throw ioexception;
        }
_L2:
        flag = flag1;
        if (!(impl instanceof HttpEntityWrapper))
        {
            continue; /* Loop/switch isn't completed */
        }
        flag2 = ((HttpEntityWrapper)impl).isChunked();
        flag = flag1;
        if (flag2)
        {
            flag = false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public Header getContentEncoding()
    {
        return impl.getContentEncoding();
    }

    public long getContentLength()
    {
        return impl.getContentLength();
    }

    public Header getContentType()
    {
        return impl.getContentType();
    }

    public boolean isChunked()
    {
        return impl.isChunked();
    }

    public boolean isRepeatable()
    {
        return impl.isRepeatable();
    }

    public boolean isStreaming()
    {
        return impl.isStreaming();
    }

    public void streamComplete(StreamCompleteEvent streamcompleteevent)
    {
        ((StreamCompleteListenerSource)streamcompleteevent.getSource()).removeStreamCompleteListener(this);
        if (!transactionState.isComplete())
        {
            if (contentLengthFromHeader >= 0L)
            {
                transactionState.setBytesReceived(contentLengthFromHeader);
            } else
            {
                transactionState.setBytesReceived(streamcompleteevent.getBytes());
            }
            addTransactionAndErrorData(transactionState);
        }
    }

    public void streamError(StreamCompleteEvent streamcompleteevent)
    {
        ((StreamCompleteListenerSource)streamcompleteevent.getSource()).removeStreamCompleteListener(this);
        TransactionStateUtil.setErrorCodeFromException(transactionState, streamcompleteevent.getException());
        if (!transactionState.isComplete())
        {
            transactionState.setBytesReceived(streamcompleteevent.getBytes());
        }
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        if (!transactionState.isComplete())
        {
            outputstream = new CountingOutputStream(outputstream);
            try
            {
                impl.writeTo(outputstream);
            }
            catch (IOException ioexception)
            {
                handleException(ioexception, Long.valueOf(outputstream.getCount()));
                ioexception.printStackTrace();
                throw ioexception;
            }
            if (!transactionState.isComplete())
            {
                if (contentLengthFromHeader >= 0L)
                {
                    transactionState.setBytesReceived(contentLengthFromHeader);
                } else
                {
                    transactionState.setBytesReceived(outputstream.getCount());
                }
                addTransactionAndErrorData(transactionState);
            }
            return;
        } else
        {
            impl.writeTo(outputstream);
            return;
        }
    }

}
