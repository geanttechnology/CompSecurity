// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.metric;

import java.util.Map;

// Referenced classes of package com.amazon.identity.platform.metric:
//            PlatformMetricsTimer

public interface PlatformMetricsCollector
{

    public abstract PlatformMetricsTimer createPeriodicTimer(String s);

    public abstract PlatformMetricsTimer createTimer(String s);

    public transient abstract void increasePeriodicCounter(String s, String as[]);

    public abstract void incrementCounter(String s);

    public abstract void incrementCounter(String s, double d);

    public abstract void incrementMetricCounter(String s, String s1, Map map);

    public transient abstract void incrementMetricCounter(String s, String s1, String as[]);

    public abstract void incrementStateMetricCounter(String s, String s1, Map map);

    public abstract void recordEvent();

    public abstract void recordMetricTimerEvent(String s, String s1, long l);
}
