// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricStore;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Trace;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.newrelic.agent.android.harvest:
//            HarvestAdapter, Harvest, HarvestData, ActivityTraces, 
//            MachineMeasurements

public class HarvestDataValidator extends HarvestAdapter
{

    public HarvestDataValidator()
    {
    }

    public void ensureActivityNameMetricsExist()
    {
        Object obj;
        HarvestData harvestdata;
        harvestdata = Harvest.getInstance().getHarvestData();
        obj = harvestdata.getActivityTraces();
        if (obj != null && ((ActivityTraces) (obj)).count() != 0) goto _L2; else goto _L1
_L1:
        MachineMeasurements machinemeasurements;
        return;
_L2:
        if ((machinemeasurements = harvestdata.getMetrics()) == null || machinemeasurements.isEmpty()) goto _L1; else goto _L3
_L3:
        Iterator iterator = ((ActivityTraces) (obj)).getActivityTraces().iterator();
_L5:
        if (!iterator.hasNext()) goto _L1; else goto _L4
_L4:
        boolean flag;
        Object obj1 = ((ActivityTrace)iterator.next()).rootTrace.displayName;
        int i = ((String) (obj1)).indexOf("#");
        obj = obj1;
        if (i > 0)
        {
            obj = ((String) (obj1)).substring(0, i);
        }
        obj = (new StringBuilder()).append("Mobile/Activity/Name/").append(((String) (obj))).toString();
        obj1 = machinemeasurements.getMetrics().getAllUnscoped();
        if (obj1 == null || ((List) (obj1)).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break MISSING_BLOCK_LABEL_200;
            }
        } while (!((Metric)((Iterator) (obj1)).next()).getName().startsWith(((String) (obj))));
        flag = true;
_L6:
        if (!flag)
        {
            machinemeasurements.addMetric(new Metric(((String) (obj))));
        }
          goto _L5
          goto _L1
        flag = false;
          goto _L6
    }

    public void onHarvestFinalize()
    {
        if (!Harvest.isInitialized())
        {
            return;
        } else
        {
            ensureActivityNameMetricsExist();
            return;
        }
    }
}
