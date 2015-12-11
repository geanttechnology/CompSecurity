// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

// Referenced classes of package com.newrelic.agent.android.instrumentation.okhttp2:
//            OkHttp2TransactionStateUtil, CallbackExtension

public class CallExtension extends Call
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private OkHttpClient client;
    private Call impl;
    private Request request;
    private TransactionState transactionState;

    CallExtension(OkHttpClient okhttpclient, Request request1, Call call)
    {
        super(okhttpclient, request1);
        client = okhttpclient;
        request = request1;
        impl = call;
    }

    private void checkResponse(Response response)
    {
        if (!getTransactionState().isComplete())
        {
            OkHttp2TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), response);
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

    public void enqueue(Callback callback)
    {
        getTransactionState();
        impl.enqueue(new CallbackExtension(callback, transactionState));
    }

    public Response execute()
        throws IOException
    {
        getTransactionState();
        Response response;
        try
        {
            response = impl.execute();
        }
        catch (IOException ioexception)
        {
            error(ioexception);
            throw ioexception;
        }
        checkResponse(response);
        return response;
    }

    public boolean isCanceled()
    {
        return impl.isCanceled();
    }

}
