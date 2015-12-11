// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.stats;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class StatsEngine
{
    private class Stat
    {

        public long callCount;
        public boolean haveTime;
        public float maxTime;
        public float minTime;
        public float sumOfSquares;
        final StatsEngine this$0;
        public float totalTime;

        public JSONObject toJSONObject()
            throws JSONException
        {
            float f1 = 0.0F;
            this;
            JVM INSTR monitorenter ;
            float f;
            Object obj;
            obj = new HashMap();
            ((HashMap) (obj)).put("count", Long.valueOf(callCount));
            ((HashMap) (obj)).put("total", Float.valueOf(totalTime));
            if (!haveTime)
            {
                break MISSING_BLOCK_LABEL_115;
            }
            f = minTime;
_L1:
            ((HashMap) (obj)).put("min", Float.valueOf(f));
            f = f1;
            if (haveTime)
            {
                f = maxTime;
            }
            ((HashMap) (obj)).put("max", Float.valueOf(f));
            ((HashMap) (obj)).put("sum_of_squares", Float.valueOf(sumOfSquares));
            obj = new JSONObject(((java.util.Map) (obj)));
            this;
            JVM INSTR monitorexit ;
            return ((JSONObject) (obj));
            f = 0.0F;
              goto _L1
            Exception exception;
            exception;
            throw exception;
        }

        private Stat()
        {
            this$0 = StatsEngine.this;
            super();
            callCount = 0L;
            totalTime = 0.0F;
            minTime = 3.402823E+38F;
            maxTime = 1.401298E-45F;
            sumOfSquares = 0.0F;
            haveTime = false;
        }

    }


    public static final StatsEngine INSTANCE = new StatsEngine();
    private static final AgentLog log = AgentLogManager.getAgentLog();
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

    private ConcurrentHashMap getStatsMap()
    {
        return statsMap;
    }

    private Stat lazyGet(String s)
    {
        Stat stat1 = (Stat)statsMap.get(s);
        Stat stat = stat1;
        if (stat1 == null)
        {
            Stat stat2 = new Stat();
            stat = stat2;
            if (enabled)
            {
                statsMap.put(s, stat2);
                stat = stat2;
            }
        }
        return stat;
    }

    public static void populateMetrics(JSONObject jsonobject)
    {
        for (Iterator iterator = INSTANCE.getStatsMap().entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            try
            {
                jsonobject.put((String)entry.getKey(), ((Stat)entry.getValue()).toJSONObject());
            }
            catch (JSONException jsonexception)
            {
                log.warning((new StringBuilder()).append("Unable to build metric for ").append((String)entry.getKey()).append(":").append(jsonexception.toString()).toString());
            }
        }

    }

    public static void reset()
    {
        INSTANCE.getStatsMap().clear();
    }

    public void inc(String s)
    {
        synchronized (lazyGet(s))
        {
            s.callCount = ((Stat) (s)).callCount + 1L;
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
            s.callCount = ((Stat) (s)).callCount + l;
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void recordTime(String s, float f)
    {
        synchronized (lazyGet(s))
        {
            s.haveTime = true;
            s.callCount = ((Stat) (s)).callCount + 1L;
            s.totalTime = ((Stat) (s)).totalTime + f;
            s.minTime = Math.min(f, ((Stat) (s)).minTime);
            s.maxTime = Math.max(f, ((Stat) (s)).maxTime);
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void recordTimeMs(String s, long l)
    {
        recordTime(s, (float)l / 1000F);
    }

}
