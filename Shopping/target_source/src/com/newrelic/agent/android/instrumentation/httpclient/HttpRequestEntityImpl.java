// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.io.CountingOutputStream;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListenerSource;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public final class HttpRequestEntityImpl
    implements StreamCompleteListener, HttpEntity
{

    private final HttpEntity impl;
    private final TransactionState transactionState;

    public HttpRequestEntityImpl(HttpEntity httpentity, TransactionState transactionstate)
    {
        impl = httpentity;
        transactionState = transactionstate;
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
                transactionState.setBytesSent(long1.longValue());
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
        CountingInputStream countinginputstream;
        if (transactionState.isSent())
        {
            break MISSING_BLOCK_LABEL_34;
        }
        countinginputstream = new CountingInputStream(impl.getContent());
        countinginputstream.addStreamCompleteListener(this);
        return countinginputstream;
        InputStream inputstream;
        try
        {
            inputstream = impl.getContent();
        }
        catch (IOException ioexception)
        {
            handleException(ioexception);
            throw ioexception;
        }
        catch (IllegalStateException illegalstateexception)
        {
            handleException(illegalstateexception);
            throw illegalstateexception;
        }
        return inputstream;
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
        transactionState.setBytesSent(streamcompleteevent.getBytes());
    }

    public void streamError(StreamCompleteEvent streamcompleteevent)
    {
        ((StreamCompleteListenerSource)streamcompleteevent.getSource()).removeStreamCompleteListener(this);
        handleException(streamcompleteevent.getException(), Long.valueOf(streamcompleteevent.getBytes()));
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        if (!transactionState.isSent())
        {
            outputstream = new CountingOutputStream(outputstream);
            impl.writeTo(outputstream);
            transactionState.setBytesSent(outputstream.getCount());
            return;
        }
        try
        {
            impl.writeTo(outputstream);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            handleException(outputstream);
        }
        throw outputstream;
    }
}
