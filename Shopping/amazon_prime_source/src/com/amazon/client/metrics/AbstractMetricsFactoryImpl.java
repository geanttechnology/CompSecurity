// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.os.RemoteException;
import android.util.Log;
import com.amazon.client.metrics.clickstream.ClickStreamData;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics:
//            BaseMetricsFactoryImpl, MetricEvent, Priority, ConcurrentMetricEvent, 
//            DataPoint, DataPointType, DataPointEnvelope, IMetricsService, 
//            MetricsFactory

public abstract class AbstractMetricsFactoryImpl extends BaseMetricsFactoryImpl
{

    private static final boolean ANONYMOUS = true;
    private static final boolean DEFAULT_ALLOW_RUNNING_TIMERS = false;
    private static final boolean NON_ANONYMOUS = false;
    private static final String TAG = "AbstractMetricsFactoryImpl";
    protected static MetricsFactory sMetricsFactory;
    protected static IMetricsService sMetricsService;

    public AbstractMetricsFactoryImpl()
    {
    }

    public static String getSystemServiceName()
    {
        return "com.amazon.client.metrics.api";
    }

    public static void setInstance(MetricsFactory metricsfactory)
    {
        sMetricsFactory = metricsfactory;
    }

    public static void setService(IMetricsService imetricsservice)
    {
        com/amazon/client/metrics/AbstractMetricsFactoryImpl;
        JVM INSTR monitorenter ;
        sMetricsService = imetricsservice;
        com/amazon/client/metrics/AbstractMetricsFactoryImpl;
        JVM INSTR monitorexit ;
        return;
        imetricsservice;
        throw imetricsservice;
    }

    protected abstract IMetricsService getService();

    public void record(MetricEvent metricevent, Priority priority)
    {
        if (metricevent == null)
        {
            Log.d("AbstractMetricsFactoryImpl", "record : Null metric event");
            return;
        }
        if (!metricevent.hasDataPoints())
        {
            Log.d("AbstractMetricsFactoryImpl", "record : No data points in metrics event");
            return;
        }
        List list;
        if (!priority.name().equals(Priority.RESERVED_FOR_NON_ANONYMOUS_METRICS.toString()))
        {
            metricevent.setNonAnonymousCustomerId(null);
            metricevent.setNonAnonymousSessionId(null);
            metricevent.setAnonymous(true);
            Log.d("AbstractMetricsFactoryImpl", "Setting non-anonymous customer ID and session ID to null, and anonymous tag to true as the metric entry was not recorded in non-anonymous queue.");
        } else
        {
            metricevent.setAnonymous(false);
            Log.d("AbstractMetricsFactoryImpl", "Setting anonymous tag to false as the metric entry was recorded in non-anonymous queue.");
        }
        if (metricevent instanceof ConcurrentMetricEvent)
        {
            list = ((ConcurrentMetricEvent)metricevent).getAsDataPointsAndClear();
        } else
        {
            list = metricevent.getAsDataPoints();
            metricevent.clear();
        }
        if (list == null || list.isEmpty())
        {
            Log.d("AbstractMetricsFactoryImpl", "record : No valid data points in metrics event");
            return;
        }
        String s = metricevent.getNonAnonymousCustomerId();
        String s1 = metricevent.getNonAnonymousSessionId();
        if (s != null && !s.isEmpty() && !s.equals(""))
        {
            list.add(new DataPoint(ClickStreamData.NON_ANONYMOUS_CUSTOMER_ID.getName(), s, 1, DataPointType.DV));
        }
        if (s1 != null && !s1.isEmpty() && !s1.equals(""))
        {
            list.add(new DataPoint(ClickStreamData.NON_ANONYMOUS_SESSION_ID.getName(), s1, 1, DataPointType.DV));
        }
        list.add(new DataPoint(ClickStreamData.ANONYMOUS.getName(), String.valueOf(metricevent.getAnonymous()), 1, DataPointType.DV));
        try
        {
            list = DataPointEnvelope.convertToEnvelopes(list);
            getService().record(priority.ordinal(), metricevent.getProgram(), metricevent.getSource(), System.currentTimeMillis(), list);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MetricEvent metricevent)
        {
            Log.e("AbstractMetricsFactoryImpl", "record : SecurityException caught while trying to record metric: ", metricevent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MetricEvent metricevent)
        {
            Log.e("AbstractMetricsFactoryImpl", "record : RemoteException caught while trying to record metric: ", metricevent);
        }
    }
}
