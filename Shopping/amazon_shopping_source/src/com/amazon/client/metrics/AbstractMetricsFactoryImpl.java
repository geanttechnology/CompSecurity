// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.os.RemoteException;
import android.util.Log;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics:
//            BaseMetricsFactoryImpl, MetricEvent, ConcurrentMetricEvent, DataPointEnvelope, 
//            Priority, IMetricsService, MetricsFactory

public abstract class AbstractMetricsFactoryImpl extends BaseMetricsFactoryImpl
{

    private static final boolean DEFAULT_ALLOW_RUNNING_TIMERS = false;
    private static final String TAG = "AbstractMetricsFactoryImpl";
    protected static MetricsFactory sMetricsFactory;
    protected static IMetricsService sMetricsService;

    public AbstractMetricsFactoryImpl()
    {
    }

    public static String getSystemServiceName()
    {
        return "com.amazon.dp.metrics.MetricsFactory";
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
