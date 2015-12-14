// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.metric;


// Referenced classes of package com.amazon.identity.platform.metric:
//            PlatformMetricsTimer

public interface PlatformMetricsCollector
{

    public abstract PlatformMetricsTimer createTimer(String s);

    public abstract void incrementCounter(String s);

    public abstract void incrementCounter(String s, double d);

    public transient abstract void incrementCounter(String s, String as[]);

    public transient abstract void incrementMetricCounter(String s, String s1, String as[]);

    public abstract void recordEvent();

    public abstract void recordMetricTimerEvent(String s, String s1, long l);
}
