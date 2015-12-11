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
        HarvestData harvestdata = Harvest.getInstance().getHarvestData();
        ActivityTraces activitytraces = harvestdata.getActivityTraces();
        MachineMeasurements machinemeasurements;
        if (activitytraces != null && activitytraces.count() != 0)
        {
            if ((machinemeasurements = harvestdata.getMetrics()) != null && !machinemeasurements.isEmpty())
            {
                Iterator iterator = activitytraces.getActivityTraces().iterator();
                while (iterator.hasNext()) 
                {
                    String s;
                    boolean flag;
label0:
                    {
                        Object obj = ((ActivityTrace)iterator.next()).rootTrace.displayName;
                        int i = ((String) (obj)).indexOf("#");
                        s = ((String) (obj));
                        if (i > 0)
                        {
                            s = ((String) (obj)).substring(0, i);
                        }
                        s = (new StringBuilder()).append("Mobile/Activity/Name/").append(s).toString();
                        boolean flag1 = false;
                        obj = machinemeasurements.getMetrics().getAllUnscoped();
                        flag = flag1;
                        if (obj == null)
                        {
                            break label0;
                        }
                        flag = flag1;
                        if (((List) (obj)).size() <= 0)
                        {
                            break label0;
                        }
                        obj = ((List) (obj)).iterator();
                        do
                        {
                            flag = flag1;
                            if (!((Iterator) (obj)).hasNext())
                            {
                                break label0;
                            }
                        } while (!((Metric)((Iterator) (obj)).next()).getName().startsWith(s));
                        flag = true;
                    }
                    if (!flag)
                    {
                        machinemeasurements.addMetric(new Metric(s));
                    }
                }
            }
        }
_L2:
        return;
        if (true) goto _L2; else goto _L1
_L1:
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
