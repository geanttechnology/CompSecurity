// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import retrofit.client.Client;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;

// Referenced classes of package com.newrelic.agent.android.instrumentation.retrofit:
//            RetrofitTransactionStateUtil, ContentBufferingTypedInput

public class ClientExtension
    implements Client
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private Client impl;
    private Request request;
    private TransactionState transactionState;

    public ClientExtension(Client client)
    {
        impl = client;
    }

    private void checkResponse(Response response)
    {
        if (!getTransactionState().isComplete())
        {
            RetrofitTransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), response);
        }
    }

    private void error(Exception exception)
    {
        log.debug((new StringBuilder()).append("handling exception: ").append(exception.toString()).toString());
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
            RetrofitTransactionStateUtil.inspectAndInstrument(transactionState, request);
        }
        return transactionState;
    }

    private Request setCrossProcessHeader(Request request1)
    {
        String s = Agent.getCrossProcessId();
        Object obj = request1;
        if (s != null)
        {
            obj = new ArrayList(request1.getHeaders());
            ((List) (obj)).add(new Header("X-NewRelic-ID".toLowerCase(Locale.ENGLISH), s));
            obj = new Request(request1.getMethod(), request1.getUrl(), ((List) (obj)), request1.getBody());
        }
        return ((Request) (obj));
    }

    public Response execute(Request request1)
        throws IOException
    {
        request = request1;
        getTransactionState();
        request1 = setCrossProcessHeader(request1);
        request1 = impl.execute(request1);
        request1 = new Response(request1.getUrl(), request1.getStatus(), request1.getReason(), request1.getHeaders(), new ContentBufferingTypedInput(request1.getBody()));
        checkResponse(request1);
        return request1;
        request1;
_L2:
        error(request1);
        throw request1;
        request1;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
