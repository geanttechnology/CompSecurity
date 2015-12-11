// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.amazon.device.ads:
//            MetricsCollector

static class collectors extends MetricsCollector
{

    private final ArrayList collectors;

    public void incrementMetric(collectors collectors1)
    {
        for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).incrementMetric(collectors1)) { }
    }

    public void publishMetricInMilliseconds(collectors collectors1, long l)
    {
        for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).publishMetricInMilliseconds(collectors1, l)) { }
    }

    public void publishMetricInMillisecondsFromNanoseconds(s s, long l)
    {
        for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).publishMetricInMillisecondsFromNanoseconds(s, l)) { }
    }

    public void setMetricString(sFromNanoseconds sfromnanoseconds, String s)
    {
        for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).setMetricString(sfromnanoseconds, s)) { }
    }

    public void startMetric(collectors collectors1)
    {
        for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).startMetric(collectors1)) { }
    }

    public void startMetricInMillisecondsFromNanoseconds(collectors collectors1, long l)
    {
        for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).startMetricInMillisecondsFromNanoseconds(collectors1, l)) { }
    }

    public void stopMetric(romNanoseconds romnanoseconds)
    {
        for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).stopMetric(romnanoseconds)) { }
    }

    public void stopMetricInMillisecondsFromNanoseconds(collectors collectors1, long l)
    {
        for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).stopMetricInMillisecondsFromNanoseconds(collectors1, l)) { }
    }

    public (ArrayList arraylist)
    {
        collectors = arraylist;
    }
}
