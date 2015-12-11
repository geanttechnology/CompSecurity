// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.measurement.producer;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.ThreadInfo;
import com.newrelic.agent.android.measurement.http.HttpErrorMeasurement;
import com.newrelic.agent.android.util.Util;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.newrelic.agent.android.measurement.producer:
//            BaseMeasurementProducer

public class HttpErrorMeasurementProducer extends BaseMeasurementProducer
{

    public static final String HTTP_METHOD_PARAMS_KEY = "http_method";
    public static final String WAN_TYPE_PARAMS_KEY = "wan_type";
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public HttpErrorMeasurementProducer()
    {
        super(MeasurementType.HttpError);
    }

    private String getSanitizedStackTrace()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        int k = 0;
        int j = 0;
        do
        {
            int i;
label0:
            {
                if (j < astacktraceelement.length)
                {
                    StackTraceElement stacktraceelement = astacktraceelement[j];
                    i = k;
                    if (shouldFilterStackTraceElement(stacktraceelement))
                    {
                        break label0;
                    }
                    stringbuilder.append(stacktraceelement.toString());
                    if (j <= astacktraceelement.length - 1)
                    {
                        stringbuilder.append("\n");
                    }
                    k++;
                    i = k;
                    if (k < Agent.getStackTraceLimit())
                    {
                        break label0;
                    }
                }
                return stringbuilder.toString();
            }
            j++;
            k = i;
        } while (true);
    }

    private boolean shouldFilterStackTraceElement(StackTraceElement stacktraceelement)
    {
        String s = stacktraceelement.getClassName();
        for (stacktraceelement = stacktraceelement.getMethodName(); s.startsWith("com.newrelic") || s.startsWith("dalvik.system.VMStack") && stacktraceelement.startsWith("getThreadStackTrace") || s.startsWith("java.lang.Thread") && stacktraceelement.startsWith("getStackTrace");)
        {
            return true;
        }

        return false;
    }

    public void produceMeasurement(String s, String s1, int i)
    {
        produceMeasurement(s, s1, i, "");
    }

    public void produceMeasurement(String s, String s1, int i, String s2)
    {
        produceMeasurement(s, s1, i, s2, null);
    }

    public void produceMeasurement(String s, String s1, int i, String s2, Map map)
    {
        produceMeasurement(s, s1, i, s2, map, new ThreadInfo());
    }

    public void produceMeasurement(String s, String s1, int i, String s2, Map map, ThreadInfo threadinfo)
    {
        s = Util.sanitizeUrl(s);
        if (s == null)
        {
            return;
        }
        HttpErrorMeasurement httperrormeasurement = new HttpErrorMeasurement(s, i);
        s = map;
        if (map == null)
        {
            s = new HashMap();
        }
        s.put("http_method", s1);
        s.put("wan_type", Agent.getActiveNetworkWanType());
        httperrormeasurement.setThreadInfo(threadinfo);
        httperrormeasurement.setStackTrace(getSanitizedStackTrace());
        httperrormeasurement.setResponseBody(s2);
        httperrormeasurement.setParams(s);
        produceMeasurement(((com.newrelic.agent.android.measurement.Measurement) (httperrormeasurement)));
    }

}
