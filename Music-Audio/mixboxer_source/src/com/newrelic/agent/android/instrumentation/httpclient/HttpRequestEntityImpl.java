// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.io.CountingOutputStream;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListenerSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public final class HttpRequestEntityImpl
    implements HttpEntity, StreamCompleteListener
{

    private final HttpEntity impl;
    private final TransactionState transactionState;

    public HttpRequestEntityImpl(HttpEntity httpentity, TransactionState transactionstate)
    {
        impl = httpentity;
        transactionState = transactionstate;
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
            TransactionStateUtil.setErrorCodeFromException(transactionState, ioexception);
            if (!transactionState.isComplete())
            {
                Agent.addTransactionData(transactionState.end());
            }
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
            TransactionStateUtil.setErrorCodeFromException(transactionState, ioexception);
            if (!transactionState.isComplete())
            {
                Agent.addTransactionData(transactionState.end());
            }
            throw ioexception;
        }
        catch (IllegalStateException illegalstateexception)
        {
            TransactionStateUtil.setErrorCodeFromException(transactionState, illegalstateexception);
            if (!transactionState.isComplete())
            {
                Agent.addTransactionData(transactionState.end());
            }
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
        TransactionStateUtil.setErrorCodeFromException(transactionState, streamcompleteevent.getException());
        if (!transactionState.isComplete())
        {
            transactionState.setBytesSent(streamcompleteevent.getBytes());
            Agent.addTransactionData(transactionState.end());
        }
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
            TransactionStateUtil.setErrorCodeFromException(transactionState, outputstream);
        }
        if (!transactionState.isComplete())
        {
            Agent.addTransactionData(transactionState.end());
        }
        throw outputstream;
    }
}
