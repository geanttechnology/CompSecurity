// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.stats;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.metric.Metric;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class StatsEngine extends HarvestAdapter
{

    public static final StatsEngine INSTANCE = new StatsEngine();
    public boolean enabled;
    private ConcurrentHashMap statsMap;

    private StatsEngine()
    {
        enabled = true;
        statsMap = new ConcurrentHashMap();
    }

    public static void disable()
    {
        com/newrelic/agent/android/stats/StatsEngine;
        JVM INSTR monitorenter ;
        INSTANCE.enabled = false;
        com/newrelic/agent/android/stats/StatsEngine;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void enable()
    {
        com/newrelic/agent/android/stats/StatsEngine;
        JVM INSTR monitorenter ;
        INSTANCE.enabled = true;
        com/newrelic/agent/android/stats/StatsEngine;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static StatsEngine get()
    {
        return INSTANCE;
    }

    private Metric lazyGet(String s)
    {
        Metric metric1 = (Metric)statsMap.get(s);
        Metric metric = metric1;
        if (metric1 == null)
        {
            Metric metric2 = new Metric(s);
            metric = metric2;
            if (enabled)
            {
                statsMap.put(s, metric2);
                metric = metric2;
            }
        }
        return metric;
    }

    public static void populateMetrics()
    {
        for (Iterator iterator = INSTANCE.getStatsMap().entrySet().iterator(); iterator.hasNext(); TaskQueue.queue((Metric)((java.util.Map.Entry)iterator.next()).getValue())) { }
    }

    public static void reset()
    {
        INSTANCE.getStatsMap().clear();
    }

    public ConcurrentHashMap getStatsMap()
    {
        return statsMap;
    }

    public void inc(String s)
    {
        synchronized (lazyGet(s))
        {
            s.increment();
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void inc(String s, long l)
    {
        synchronized (lazyGet(s))
        {
            s.increment(l);
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onHarvest()
    {
        populateMetrics();
        reset();
    }

    public void sample(String s, float f)
    {
        s = lazyGet(s);
        s;
        JVM INSTR monitorenter ;
        double d = f;
        s.sample(d);
        s;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void sampleTimeMs(String s, long l)
    {
        sample(s, (float)l / 1000F);
    }

}
