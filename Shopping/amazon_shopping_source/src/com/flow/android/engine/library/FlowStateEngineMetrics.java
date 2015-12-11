// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library;

import java.util.Map;

public class FlowStateEngineMetrics
{

    private Map m_counters;
    private Map m_timing;

    public FlowStateEngineMetrics()
    {
    }

    public Map getCounters()
    {
        return m_counters;
    }

    public Map getTiming()
    {
        return m_timing;
    }

    public void setCounters(Map map)
    {
        m_counters = map;
    }

    public void setTiming(Map map)
    {
        m_timing = map;
    }
}
