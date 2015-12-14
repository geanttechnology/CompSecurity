// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics;

import java.util.Map;

// Referenced classes of package com.amazon.gallery.foundation.metrics:
//            Profiler, Timer

public class ComponentProfiler
{

    private final String component;
    private final Profiler profiler;

    public ComponentProfiler(Profiler profiler1, Class class1)
    {
        this(profiler1, class1.getSimpleName());
    }

    public ComponentProfiler(Profiler profiler1, String s)
    {
        profiler = profiler1;
        component = s;
    }

    public Timer newTimer(Enum enum)
    {
        return profiler.newTimer(component, enum.toString());
    }

    public Timer newTimer(Enum enum, Map map)
    {
        return profiler.newTimer(component, enum.toString(), map);
    }

    public void trackEvent(Enum enum)
    {
        profiler.trackEvent(component, enum.toString());
    }

    public void trackEvent(Enum enum, Map map)
    {
        profiler.trackEvent(component, enum.toString(), map);
    }

    public void trackTimer(Enum enum, long l)
    {
        profiler.trackTimer(component, enum.toString(), l);
    }

    public void trackTimer(Enum enum, long l, Map map)
    {
        profiler.trackTimer(component, enum.toString(), l, map);
    }
}
