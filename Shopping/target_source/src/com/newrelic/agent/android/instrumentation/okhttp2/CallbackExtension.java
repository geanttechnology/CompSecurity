// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import com.h.b.f;
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
//            OkHttp2TransactionStateUtil

public class CallbackExtension
    implements f
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private f impl;
    private TransactionState transactionState;

    public CallbackExtension(f f1, TransactionState transactionstate)
    {
        impl = f1;
        transactionState = transactionstate;
    }

    private void checkResponse(w w)
    {
        if (!getTransactionState().isComplete())
        {
            if (log.getLevel() >= 4)
            {
                log.verbose("CallbackExtension.checkResponse() - transaction is not complete.  Inspecting and instrumenting response.");
            }
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
        return transactionState;
    }

    public void onFailure(u u, IOException ioexception)
    {
        if (log.getLevel() >= 4)
        {
            log.verbose("CallbackExtension.onFailure() - logging error.");
        }
        error(ioexception);
        impl.onFailure(u, ioexception);
    }

    public void onResponse(w w)
        throws IOException
    {
        if (log.getLevel() >= 4)
        {
            log.verbose("CallbackExtension.onResponse() - checking response.");
        }
        checkResponse(w);
        impl.onResponse(w);
    }

}
