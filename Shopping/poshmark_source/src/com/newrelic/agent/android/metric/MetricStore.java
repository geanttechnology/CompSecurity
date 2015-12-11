// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.metric;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.newrelic.agent.android.metric:
//            Metric

public class MetricStore
{

    private final Map metricStore = new ConcurrentHashMap();

    public MetricStore()
    {
    }

    public void add(Metric metric)
    {
        String s = metric.getStringScope();
        String s1 = metric.getName();
        if (!metricStore.containsKey(s))
        {
            metricStore.put(s, new HashMap());
        }
        if (((Map)metricStore.get(s)).containsKey(s1))
        {
            ((Metric)((Map)metricStore.get(s)).get(s1)).aggregate(metric);
            return;
        } else
        {
            ((Map)metricStore.get(s)).put(s1, metric);
            return;
        }
    }

    public void clear()
    {
        metricStore.clear();
    }

    public Metric get(String s)
    {
        return get(s, "");
    }

    public Metric get(String s, String s1)
    {
        String s2;
        Map map;
        try
        {
            map = metricStore;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        s = (Metric)((Map)map.get(s2)).get(s);
        return s;
    }

    public List getAll()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = metricStore.entrySet().iterator(); iterator.hasNext();)
        {
            Iterator iterator1 = ((Map)((java.util.Map.Entry)iterator.next()).getValue()).entrySet().iterator();
            while (iterator1.hasNext()) 
            {
                arraylist.add(((java.util.Map.Entry)iterator1.next()).getValue());
            }
        }

        return arraylist;
    }

    public List getAllByScope(String s)
    {
        ArrayList arraylist = new ArrayList();
        try
        {
            for (s = ((Map)metricStore.get(s)).entrySet().iterator(); s.hasNext(); arraylist.add(((java.util.Map.Entry)s.next()).getValue())) { }
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        return arraylist;
    }

    public List getAllUnscoped()
    {
        return getAllByScope("");
    }

    public boolean isEmpty()
    {
        return metricStore.isEmpty();
    }

    public void remove(Metric metric)
    {
        String s = metric.getStringScope();
        for (metric = metric.getName(); !metricStore.containsKey(s) || !((Map)metricStore.get(s)).containsKey(metric);)
        {
            return;
        }

        ((Map)metricStore.get(s)).remove(metric);
    }

    public void removeAll(List list)
    {
        Map map = metricStore;
        map;
        JVM INSTR monitorenter ;
        for (list = list.iterator(); list.hasNext(); remove((Metric)list.next())) { }
        break MISSING_BLOCK_LABEL_44;
        list;
        map;
        JVM INSTR monitorexit ;
        throw list;
        map;
        JVM INSTR monitorexit ;
    }

    public List removeAllWithScope(String s)
    {
        s = getAllByScope(s);
        if (!s.isEmpty())
        {
            removeAll(s);
        }
        return s;
    }
}
