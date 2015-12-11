// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.profiling;

import java.util.HashMap;
import java.util.Map;

public final class PageMetrics
{
    public static class TimerMeasurement
    {

        private long durationNanos;
        private long startNanos;
        private String threadName;

        public long getDurationNanos()
        {
            return durationNanos;
        }

        public long getStartNanos()
        {
            return startNanos;
        }

        public String getThreadName()
        {
            return threadName;
        }
    }


    private long pageStartTime;
    private Map resourceLoadStartNanos;
    private Map resourceLoadsByUrl;
    private Map timersByName;

    public PageMetrics()
    {
        timersByName = new HashMap();
        resourceLoadsByUrl = new HashMap();
        resourceLoadStartNanos = new HashMap();
    }

    public long getPageStartTime()
    {
        return pageStartTime;
    }

    public Map getResourceLoads()
    {
        return resourceLoadsByUrl;
    }

    public Map getTimers()
    {
        return timersByName;
    }

    public void setPageStartTime(long l)
    {
        pageStartTime = l;
    }
}
