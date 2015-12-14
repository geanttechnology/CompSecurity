// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics;

import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.gallery.foundation.metrics:
//            Profiler, MetricName, AggregatedCounter, ProfilerTimer, 
//            AggregatedTimer, Timer

public abstract class AbstractProfiler
    implements Profiler
{

    private static final String TAG = com/amazon/gallery/foundation/metrics/AbstractProfiler.getName();
    protected final ConcurrentHashMap countersMap = new ConcurrentHashMap();
    protected String domain;
    protected final ConcurrentHashMap timersMap = new ConcurrentHashMap();

    public AbstractProfiler()
    {
        reset();
    }

    public static String getPageNameFromExtras(Map map)
    {
        if (map != null)
        {
            return (String)map.get("pageName");
        } else
        {
            return null;
        }
    }

    public void endSession()
    {
        GLogger.v(TAG, "Recording aggregated counters / timers for this session", new Object[0]);
        record(countersMap.values(), timersMap.values());
        reset();
    }

    protected AggregatedCounter getCounter(String s, String s1, Map map)
    {
        map = new MetricName(domain, s, s1, getPageNameFromExtras(map));
        s1 = (AggregatedCounter)countersMap.get(map);
        s = s1;
        if (s1 == null)
        {
            s1 = new AggregatedCounter(map);
            map = (AggregatedCounter)countersMap.putIfAbsent(map, s1);
            s = map;
            if (map == null)
            {
                s = s1;
            }
        }
        return s;
    }

    public Timer newTimer(String s, String s1)
    {
        return new ProfilerTimer(this, s, s1);
    }

    public Timer newTimer(String s, String s1, Map map)
    {
        return newTimer(s, s1);
    }

    protected abstract void record(Collection collection, Collection collection1);

    protected void reset()
    {
        countersMap.clear();
        timersMap.clear();
    }

    public void setDomain(String s)
    {
        domain = s;
    }

    public void startSession()
    {
    }

    public void trackEvent(String s, String s1)
    {
        trackEvent(s, s1, true);
    }

    public void trackEvent(String s, String s1, Map map)
    {
        trackEvent(s, s1, map, true);
    }

    public void trackEvent(String s, String s1, Map map, boolean flag)
    {
        getCounter(s, s1, map).increment(flag);
    }

    public void trackEvent(String s, String s1, boolean flag)
    {
        trackEvent(s, s1, null, flag);
    }

    public void trackTimer(String s, String s1, long l)
    {
        trackTimer(s, s1, l, true);
    }

    public void trackTimer(String s, String s1, long l, Map map)
    {
        trackTimer(s, s1, l, map, true);
    }

    public void trackTimer(String s, String s1, long l, Map map, boolean flag)
    {
        map = new MetricName(domain, s, s1, getPageNameFromExtras(map));
        s1 = (AggregatedTimer)timersMap.get(map);
        s = s1;
        if (s1 == null)
        {
            s1 = new AggregatedTimer(map);
            map = (AggregatedTimer)timersMap.putIfAbsent(map, s1);
            s = map;
            if (map == null)
            {
                s = s1;
            }
        }
        s.update(l, flag);
    }

    public void trackTimer(String s, String s1, long l, boolean flag)
    {
        trackTimer(s, s1, l, null, flag);
    }

}
