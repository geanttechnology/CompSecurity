// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.BaseMeasurement;
import com.newrelic.agent.android.measurement.CustomMetricMeasurement;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.MethodMeasurement;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricStore;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.newrelic.agent.android.measurement.consumer:
//            MetricMeasurementConsumer

public class SummaryMetricMeasurementConsumer extends MetricMeasurementConsumer
    implements TraceLifecycleAware
{

    private static final String ACTIVITY_METRIC_PREFIX = "Mobile/Activity/Summary/Name/";
    private static final String METRIC_PREFIX = "Mobile/Summary/";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final List completedTraces = new CopyOnWriteArrayList();

    public SummaryMetricMeasurementConsumer()
    {
        super(MeasurementType.Any);
        recordUnscopedMetrics = false;
        TraceMachine.addTraceListener(this);
    }

    private void consumeCustomMeasurement(CustomMetricMeasurement custommetricmeasurement)
    {
        if (custommetricmeasurement.getCategory() == null || custommetricmeasurement.getCategory() == MetricCategory.NONE)
        {
            return;
        } else
        {
            BaseMeasurement basemeasurement = new BaseMeasurement(custommetricmeasurement);
            basemeasurement.setName(custommetricmeasurement.getCategory().getCategoryName());
            super.consumeMeasurement(basemeasurement);
            return;
        }
    }

    private void consumeMethodMeasurement(MethodMeasurement methodmeasurement)
    {
        if (methodmeasurement.getCategory() == null || methodmeasurement.getCategory() == MetricCategory.NONE)
        {
            methodmeasurement.setCategory(MetricCategory.categoryForMethod(methodmeasurement.getName()));
            if (methodmeasurement.getCategory() == MetricCategory.NONE)
            {
                return;
            }
        }
        BaseMeasurement basemeasurement = new BaseMeasurement(methodmeasurement);
        basemeasurement.setName(methodmeasurement.getCategory().getCategoryName());
        super.consumeMeasurement(basemeasurement);
    }

    private void consumeNetworkMeasurement(HttpTransactionMeasurement httptransactionmeasurement)
    {
        httptransactionmeasurement = new BaseMeasurement(httptransactionmeasurement);
        httptransactionmeasurement.setName(MetricCategory.NETWORK.getCategoryName());
        super.consumeMeasurement(httptransactionmeasurement);
    }

    private void summarizeActivityMetrics(ActivityTrace activitytrace)
    {
        Trace trace = activitytrace.rootTrace;
        Object obj2 = metrics.removeAllWithScope(trace.metricName);
        Object obj1 = metrics.removeAllWithScope(trace.metricBackgroundName);
        Object obj = new HashMap();
        Metric metric2;
        for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); ((Map) (obj)).put(metric2.getName(), metric2))
        {
            metric2 = (Metric)((Iterator) (obj2)).next();
        }

        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            Metric metric1 = (Metric)((Iterator) (obj1)).next();
            if (((Map) (obj)).containsKey(metric1.getName()))
            {
                ((Metric)((Map) (obj)).get(metric1.getName())).aggregate(metric1);
            } else
            {
                ((Map) (obj)).put(metric1.getName(), metric1);
            }
        }

        obj1 = ((Map) (obj)).values().iterator();
        double d;
        for (d = 0.0D; ((Iterator) (obj1)).hasNext(); d = ((Metric)((Iterator) (obj1)).next()).getExclusive() + d) { }
        double d2 = (double)(trace.exitTimestamp - trace.entryTimestamp) / 1000D;
        obj = ((Map) (obj)).values().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            Metric metric = (Metric)((Iterator) (obj)).next();
            double d1;
            if (metric.getExclusive() != 0.0D && d != 0.0D)
            {
                d1 = metric.getExclusive() / d;
            } else
            {
                d1 = 0.0D;
            }
            d1 *= d2;
            metric.setTotal(Double.valueOf(d1));
            metric.setExclusive(Double.valueOf(d1));
            metric.setMinFieldValue(Double.valueOf(0.0D));
            metric.setMaxFieldValue(Double.valueOf(0.0D));
            metric.setSumOfSquares(Double.valueOf(0.0D));
            metric.setScope((new StringBuilder()).append("Mobile/Activity/Summary/Name/").append(trace.displayName).toString());
            Harvest.addMetric(metric);
            metric = new Metric(metric);
            metric.setScope(null);
            Harvest.addMetric(metric);
        }
        summarizeActivityNetworkMetrics(activitytrace);
    }

    private void summarizeActivityNetworkMetrics(ActivityTrace activitytrace)
    {
        String s = activitytrace.getActivityName();
        if (activitytrace.networkCountMetric.getCount() > 0L)
        {
            String s1 = activitytrace.networkCountMetric.getName();
            activitytrace.networkCountMetric.setName(s1.replace("<activity>", s));
            activitytrace.networkCountMetric.setCount(1L);
            activitytrace.networkCountMetric.setMinFieldValue(Double.valueOf(activitytrace.networkCountMetric.getTotal()));
            activitytrace.networkCountMetric.setMaxFieldValue(Double.valueOf(activitytrace.networkCountMetric.getTotal()));
            Harvest.addMetric(activitytrace.networkCountMetric);
        }
        if (activitytrace.networkTimeMetric.getCount() > 0L)
        {
            String s2 = activitytrace.networkTimeMetric.getName();
            activitytrace.networkTimeMetric.setName(s2.replace("<activity>", s));
            activitytrace.networkTimeMetric.setCount(1L);
            activitytrace.networkTimeMetric.setMinFieldValue(Double.valueOf(activitytrace.networkTimeMetric.getTotal()));
            activitytrace.networkTimeMetric.setMaxFieldValue(Double.valueOf(activitytrace.networkTimeMetric.getTotal()));
            Harvest.addMetric(activitytrace.networkTimeMetric);
        }
    }

    public void consumeMeasurement(Measurement measurement)
    {
        if (measurement == null)
        {
            return;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType[];

            static 
            {
                $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType = new int[MeasurementType.values().length];
                try
                {
                    $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType[MeasurementType.Method.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType[MeasurementType.Network.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType[MeasurementType.Custom.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.newrelic.agent.android.measurement.MeasurementType[measurement.getType().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            consumeMethodMeasurement((MethodMeasurement)measurement);
            return;

        case 2: // '\002'
            consumeNetworkMeasurement((HttpTransactionMeasurement)measurement);
            return;

        case 3: // '\003'
            consumeCustomMeasurement((CustomMetricMeasurement)measurement);
            break;
        }
    }

    protected String formatMetricName(String s)
    {
        return (new StringBuilder()).append("Mobile/Summary/").append(s.replace("#", "/")).toString();
    }

    public void onEnterMethod()
    {
    }

    public void onExitMethod()
    {
    }

    public void onHarvest()
    {
        while (metrics.getAll().size() == 0 || completedTraces.size() == 0) 
        {
            return;
        }
        for (Iterator iterator = completedTraces.iterator(); iterator.hasNext(); summarizeActivityMetrics((ActivityTrace)iterator.next())) { }
        if (metrics.getAll().size() != 0)
        {
            log.debug("Not all metrics were summarized!");
        }
        completedTraces.clear();
    }

    public void onHarvestComplete()
    {
    }

    public void onHarvestError()
    {
    }

    public void onTraceComplete(ActivityTrace activitytrace)
    {
        if (!completedTraces.contains(activitytrace))
        {
            completedTraces.add(activitytrace);
        }
    }

    public void onTraceStart(ActivityTrace activitytrace)
    {
    }

}
