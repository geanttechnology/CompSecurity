// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedInput;

public class RetrofitTransactionStateUtil extends TransactionStateUtil
{

    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String NO_BODY_TEXT = "Response BODY not found.";
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public RetrofitTransactionStateUtil()
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
                String s = getAppDataHeader(response.getHeaders(), "Content-Type");
                TreeMap treemap = new TreeMap();
                if (s != null && s.length() > 0 && !"".equals(s))
                {
                    treemap.put("content_type", null);
                }
                treemap.put("content_length", (new StringBuilder()).append(transactionstate.getBytesReceived()).append("").toString());
                Measurements.addHttpError(transactiondata.getUrl(), transactiondata.getHttpMethod(), transactiondata.getStatusCode(), response.getReason(), treemap);
                return;
            }
        }
    }

    private static String getAppDataHeader(List list, String s)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            Header header;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                header = (Header)list.next();
            } while (header.getName() == null || !header.getName().equalsIgnoreCase(s));
            return header.getValue();
        }
        return null;
    }

    public static void inspectAndInstrument(TransactionState transactionstate, Request request)
    {
        transactionstate.setUrl(request.getUrl());
        transactionstate.setHttpMethod(request.getMethod());
        transactionstate.setCarrier(Agent.getActiveNetworkCarrier());
        transactionstate.setWanType(Agent.getActiveNetworkWanType());
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionstate, Response response)
    {
        String s = getAppDataHeader(response.getHeaders(), "X-NewRelic-App-Data");
        if (s != null && !"".equals(s))
        {
            transactionstate.setAppData(s);
        }
        transactionstate.setStatusCode(response.getStatus());
        long l = response.getBody().length();
        if (l >= 0L)
        {
            transactionstate.setBytesReceived(l);
        }
        addTransactionAndErrorData(transactionstate, response);
    }

}
