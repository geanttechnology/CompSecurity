// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import com.h.b.e;
import com.h.b.f;
import com.h.b.s;
import com.h.b.u;
import com.h.b.w;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;

// Referenced classes of package com.newrelic.agent.android.instrumentation.okhttp2:
//            OkHttp2TransactionStateUtil, CallbackExtension

public class CallExtension extends e
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private s client;
    private e impl;
    private u request;
    private TransactionState transactionState;

    CallExtension(s s, u u, e e1)
    {
        super(s, u);
        client = s;
        request = u;
        impl = e1;
    }

    private void checkResponse(w w)
    {
        if (!getTransactionState().isComplete())
        {
            OkHttp2TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), w);
        }
    }

    private void error(Exception exception)
    {
        TransactionState transactionstate = getTransactionState();
        TransactionStateUtil.setErrorCodeFromException(transactionstate, exception);
        if (!transactionstate.isComplete())
        {
            exception = transactionstate.end();
            if (exception != null)
            {
                TaskQueue.queue(new HttpTransactionMeasurement(exception.getUrl(), exception.getHttpMethod(), exception.getStatusCode(), exception.getErrorCode(), exception.getTimestamp(), exception.getTime(), exception.getBytesSent(), exception.getBytesReceived(), exception.getAppData()));
            }
        }
    }

    private TransactionState getTransactionState()
    {
        if (transactionState == null)
        {
            transactionState = new TransactionState();
            OkHttp2TransactionStateUtil.inspectAndInstrument(transactionState, request);
        }
        return transactionState;
    }

    public void cancel()
    {
        impl.cancel();
    }

    public void enqueue(f f)
    {
        getTransactionState();
        impl.enqueue(new CallbackExtension(f, transactionState));
    }

    public w execute()
        throws IOException
    {
        getTransactionState();
        w w;
        try
        {
            w = impl.execute();
        }
        catch (IOException ioexception)
        {
            error(ioexception);
            throw ioexception;
        }
        checkResponse(w);
        return w;
    }

    public boolean isCanceled()
    {
        return impl.isCanceled();
    }

}
