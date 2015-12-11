// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.trigger;

import com.amazon.client.metrics.DataPoint;
import com.amazon.client.metrics.DataPointType;
import com.amazon.client.metrics.MetricEntry;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.PeriodicMetricReporter;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics.trigger:
//            TriggerEvaluator, TriggerRuleId, TriggerRuleDataSource, TriggerExpressionCodec, 
//            TriggerExpression, TriggerAction

public class MetricEntryTriggerEvaluator
    implements TriggerEvaluator
{

    private static final String TRIGGER_ACTION_METRIC_NAME = "TriggerActionCount";
    private static final String TRIGGER_EVALUATOR_METRIC_NAME = "TriggerEvaluator";
    private static final String TRIGGER_REASON_METRIC_NAME = "TriggerReason";
    private static final String TRIGGER_RULE_ID_DELIMITER = ".";
    private final TriggerAction mDefaultTriggerAction;
    private final PeriodicMetricReporter mPeriodicMetricReporter;
    private final TriggerExpressionCodec mTriggerExpressionCodec;
    private final TriggerRuleDataSource mTriggerRuleDataSource;
    private final TriggerRuleId mTriggerRuleId;

    public MetricEntryTriggerEvaluator(TriggerExpressionCodec triggerexpressioncodec, TriggerRuleDataSource triggerruledatasource, TriggerRuleId triggerruleid, TriggerAction triggeraction, PeriodicMetricReporter periodicmetricreporter)
    {
        if (triggerexpressioncodec == null)
        {
            throw new IllegalArgumentException("triggerExpressionCodec must not be null.");
        }
        if (triggerruledatasource == null)
        {
            throw new IllegalArgumentException("triggerRuleDataSource must not be null.");
        }
        if (triggerruleid == null)
        {
            throw new IllegalArgumentException("triggerRuleId must not be null.");
        }
        if (triggeraction == null)
        {
            throw new IllegalArgumentException("defaultTriggerAction must not be null.");
        }
        if (periodicmetricreporter == null)
        {
            throw new IllegalArgumentException("periodicMetricReporter must not be null.");
        } else
        {
            mTriggerExpressionCodec = triggerexpressioncodec;
            mTriggerRuleDataSource = triggerruledatasource;
            mTriggerRuleId = triggerruleid;
            mDefaultTriggerAction = triggeraction;
            mPeriodicMetricReporter = periodicmetricreporter;
            return;
        }
    }

    private void addCommonPrefixToTriggerRuleId(MetricEntry metricentry, TriggerRuleId triggerruleid)
    {
        triggerruleid.reset();
        triggerruleid.append(metricentry.getProgram()).append(".").append(metricentry.getSource());
        triggerruleid.markCommonPrefix();
    }

    private void addDataPointSpecificDataToTriggerRuleId(DataPoint datapoint, TriggerRuleId triggerruleid)
    {
        triggerruleid.resetToCommonPrefix();
        triggerruleid.append(".").append(datapoint.getName()).append(".").append(datapoint.getType().name().toString());
    }

    private boolean isAcceptedDataPointType(DataPointType datapointtype)
    {
        return datapointtype == DataPointType.getCounterType() || datapointtype == DataPointType.getTimerType();
    }

    private TriggerExpression retrieveTriggerExpression(TriggerRuleId triggerruleid)
    {
        triggerruleid = mTriggerRuleDataSource.getTriggerRuleDataForTriggerRuleId(triggerruleid);
        if (triggerruleid == null)
        {
            return null;
        } else
        {
            return mTriggerExpressionCodec.deserializeTriggerExpression(triggerruleid);
        }
    }

    public void evaluate(MetricEntry metricentry)
    {
        this;
        JVM INSTR monitorenter ;
        if (metricentry != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mPeriodicMetricReporter.getMetricEvent().startTimer("TriggerEvaluator");
        boolean flag;
        addCommonPrefixToTriggerRuleId(metricentry, mTriggerRuleId);
        flag = mTriggerRuleDataSource.triggerRulesExistForTriggerRuleIdPrefix(mTriggerRuleId);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        mPeriodicMetricReporter.getMetricEvent().stopTimer("TriggerEvaluator");
          goto _L1
        metricentry;
        throw metricentry;
        Object obj;
        int i;
        obj = null;
        i = 0;
        Iterator iterator = metricentry.getDatapoints().iterator();
_L4:
        Object obj1;
        Object obj2;
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_226;
                }
                obj1 = (DataPoint)iterator.next();
            } while (!isAcceptedDataPointType(((DataPoint) (obj1)).getType()));
            addDataPointSpecificDataToTriggerRuleId(((DataPoint) (obj1)), mTriggerRuleId);
            obj2 = retrieveTriggerExpression(mTriggerRuleId);
        } while (obj2 == null);
        if (!((TriggerExpression) (obj2)).evaluate(Double.parseDouble(((DataPoint) (obj1)).getValue())))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = mTriggerRuleId.toString();
        mDefaultTriggerAction.execute(((CharSequence) (obj2)));
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        obj1 = new StringBuilder();
        ((StringBuilder) (obj1)).append(((String) (obj2))).append(" ");
        i++;
        obj = obj1;
        if (true) goto _L4; else goto _L3
_L3:
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        obj = new DataPoint("TriggerReason", ((StringBuilder) (obj)).toString(), 1, DataPointType.getDiscreteValueType());
        metricentry.getDatapoints().add(obj);
        mPeriodicMetricReporter.getMetricEvent().addCounter("TriggerActionCount", i);
        mPeriodicMetricReporter.getMetricEvent().stopTimer("TriggerEvaluator");
          goto _L1
        metricentry;
        mPeriodicMetricReporter.getMetricEvent().stopTimer("TriggerEvaluator");
        throw metricentry;
    }

    public volatile void evaluate(Object obj)
    {
        evaluate((MetricEntry)obj);
    }
}
