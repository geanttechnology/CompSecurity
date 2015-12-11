// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.util.Map;
import java.util.TreeMap;

public class OkHttp2TransactionStateUtil extends TransactionStateUtil
{

    private static final String NO_BODY_TEXT = "Response BODY not found.";
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public OkHttp2TransactionStateUtil()
    {
    }

    private static void addTransactionAndErrorData(TransactionState transactionstate, Response response)
    {
        TransactionData transactiondata = transactionstate.end();
        if (transactiondata != null)
        {
            TaskQueue.queue(new HttpTransactionMeasurement(transactiondata.getUrl(), transactiondata.getHttpMethod(), transactiondata.getStatusCode(), transactiondata.getErrorCode(), transactiondata.getTimestamp(), transactiondata.getTime(), transactiondata.getBytesSent(), transactiondata.getBytesReceived(), transactiondata.getAppData()));
            if ((long)transactionstate.getStatusCode() >= 400L)
            {
                String s = response.header("Content-Type");
                TreeMap treemap = new TreeMap();
                if (s != null && s.length() > 0 && !"".equals(s))
                {
                    treemap.put("content_type", null);
                }
                treemap.put("content_length", (new StringBuilder()).append(transactionstate.getBytesReceived()).append("").toString());
                Measurements.addHttpError(transactiondata.getUrl(), transactiondata.getHttpMethod(), transactiondata.getStatusCode(), response.message(), treemap);
                return;
            }
        }
    }

    public static void inspectAndInstrument(TransactionState transactionstate, Request request)
    {
        inspectAndInstrument(transactionstate, request.urlString(), request.method());
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionstate, Response response)
    {
        String s = response.header("X-NewRelic-App-Data");
        int i = response.code();
        inspectAndInstrumentResponse(transactionstate, s, (int)response.body().contentLength(), i);
        addTransactionAndErrorData(transactionstate, response);
    }

}
