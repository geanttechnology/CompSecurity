// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import com.h.b.u;
import com.h.b.w;
import com.h.b.x;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.util.Map;
import java.util.TreeMap;

public class OkHttp2TransactionStateUtil extends TransactionStateUtil
{

    private static final String NO_BODY_TEXT = "Response BODY not found.";
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public OkHttp2TransactionStateUtil()
    {
    }

    private static void addTransactionAndErrorData(TransactionState transactionstate, w w1)
    {
        TransactionData transactiondata = transactionstate.end();
        if (transactiondata != null)
        {
            TaskQueue.queue(new HttpTransactionMeasurement(transactiondata.getUrl(), transactiondata.getHttpMethod(), transactiondata.getStatusCode(), transactiondata.getErrorCode(), transactiondata.getTimestamp(), transactiondata.getTime(), transactiondata.getBytesSent(), transactiondata.getBytesReceived(), transactiondata.getAppData()));
            if ((long)transactionstate.getStatusCode() >= 400L)
            {
                String s = w1.a("Content-Type");
                TreeMap treemap = new TreeMap();
                if (s != null && s.length() > 0 && !"".equals(s))
                {
                    treemap.put("content_type", null);
                }
                treemap.put("content_length", (new StringBuilder()).append(transactionstate.getBytesReceived()).append("").toString());
                Measurements.addHttpError(transactiondata.getUrl(), transactiondata.getHttpMethod(), transactiondata.getStatusCode(), w1.d(), treemap);
                return;
            }
        }
    }

    public static void inspectAndInstrument(TransactionState transactionstate, u u1)
    {
        inspectAndInstrument(transactionstate, u1.c(), u1.d());
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionstate, w w1)
    {
        String s = w1.a("X-NewRelic-App-Data");
        int i = w1.c();
        inspectAndInstrumentResponse(transactionstate, s, (int)w1.g().contentLength(), i);
        addTransactionAndErrorData(transactionstate, w1);
    }

}
