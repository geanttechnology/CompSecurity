// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.foundation.metrics:
//            Event, Profiler

public class ProfilerEvent
    implements Event
{

    protected final String component;
    protected final String eventName;
    protected Map extra;
    protected final Profiler profiler;

    public ProfilerEvent(Profiler profiler1, String s, String s1)
    {
        profiler = profiler1;
        component = s;
        eventName = s1;
    }

    public void addExtra(String s, String s1)
    {
        if (extra == null)
        {
            extra = new HashMap(1);
        }
        extra.put(s, s1);
    }
}
