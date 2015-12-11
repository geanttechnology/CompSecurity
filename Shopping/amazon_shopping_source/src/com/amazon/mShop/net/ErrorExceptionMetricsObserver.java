// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.os.Build;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.ClientMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.net:
//            WebViewErrorException, MetricsCollector, MetricsAggregator, NetInfo, 
//            MShopAggregatedClientMetrics, AggregatedMetrics

public class ErrorExceptionMetricsObserver extends MetricsAggregator.MetricEvent
{

    static final MetricsAggregator METRICS_AGGREGATOR = new MetricsAggregator() {

        public AggregatedMetrics aggregate(List list)
        {
            ArrayList arraylist = new ArrayList();
            HashMap hashmap = new HashMap();
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                list = (MetricsAggregator.MetricEvent)iterator.next();
                if (list instanceof ErrorExceptionMetricsObserver)
                {
                    list = (ErrorExceptionMetricsObserver)list;
                    if (list.getException() != null)
                    {
                        String s = ErrorExceptionMetricsObserver.getErrorMessage(list.getException());
                        String s1 = String.format("%s/%s:%s", new Object[] {
                            NetInfo.getCurrentCarrierName(), "ErrorExceptionType", list.getException().getClass().getSimpleName()
                        });
                        ClientMetric clientmetric = (ClientMetric)hashmap.get(s1);
                        StringBuilder stringbuilder = new StringBuilder();
                        stringbuilder.append("Info: { Model: ").append(Build.MODEL).append(",\n SDK: ").append(android.os.Build.VERSION.SDK).append(",\n Release: ").append(android.os.Build.VERSION.RELEASE);
                        if (clientmetric == null)
                        {
                            list = new ClientMetric();
                            list.setName(s1);
                            hashmap.put(s1, list);
                            if (!Util.isEmpty(s))
                            {
                                stringbuilder.append(",\n Error Message: ").append(s);
                            }
                            list.setCount(Integer.valueOf(1));
                        } else
                        {
                            clientmetric.setCount(Integer.valueOf(clientmetric.getCount().intValue() + 1));
                            if (!Util.isEmpty(s))
                            {
                                stringbuilder.append(",\n Error Message: ").append(s);
                            }
                            list = clientmetric;
                            if (!Util.isEmpty(clientmetric.getInfo()))
                            {
                                stringbuilder.insert(0, (new StringBuilder()).append(clientmetric.getInfo()).append(", ").toString());
                                list = clientmetric;
                            }
                        }
                        list.setInfo(stringbuilder.append("}").toString());
                    }
                }
            }

            arraylist.addAll(hashmap.values());
            list = new MShopAggregatedClientMetrics();
            list.setMetrics(arraylist);
            return list;
        }

    };
    private Exception mException;

    public ErrorExceptionMetricsObserver(Exception exception)
    {
        mException = exception;
    }

    private static String getErrorMessage(Exception exception)
    {
        if (exception instanceof WebViewErrorException)
        {
            return ((WebViewErrorException)exception).toString();
        } else
        {
            return getFormattedStackTraces(exception.getStackTrace());
        }
    }

    private Exception getException()
    {
        return mException;
    }

    private static String getFormattedStackTraces(StackTraceElement astacktraceelement[])
    {
        if (Util.isEmpty(astacktraceelement))
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < astacktraceelement.length; i++)
        {
            stringbuilder.append(astacktraceelement[i].getFileName());
            stringbuilder.append(" ").append(astacktraceelement[i].getMethodName()).append(" ").append(astacktraceelement[i].getLineNumber()).append("\n");
        }

        return stringbuilder.toString();
    }

    public static void logMetric(Exception exception)
    {
        if (exception != null)
        {
            exception.setStackTrace(Thread.currentThread().getStackTrace());
            MetricsCollector.queueEvent(new ErrorExceptionMetricsObserver(exception));
        }
    }

    public MetricsAggregator getAggregator()
    {
        return METRICS_AGGREGATOR;
    }

    public MetricsAggregator.Type getEventAggregatorType()
    {
        return MetricsAggregator.Type.ErrorExceptionMetric;
    }



}
