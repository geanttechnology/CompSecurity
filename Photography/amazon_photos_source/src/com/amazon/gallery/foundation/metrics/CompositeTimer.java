// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.foundation.metrics:
//            Timer

public class CompositeTimer
    implements Timer
{

    private final List timers;

    public transient CompositeTimer(Timer atimer[])
    {
        timers = Arrays.asList(atimer);
    }

    public void addExtra(String s, String s1)
    {
        for (Iterator iterator = timers.iterator(); iterator.hasNext(); ((Timer)iterator.next()).addExtra(s, s1)) { }
    }

    public void remove()
    {
        for (Iterator iterator = timers.iterator(); iterator.hasNext(); ((Timer)iterator.next()).remove()) { }
    }

    public void start()
    {
        for (Iterator iterator = timers.iterator(); iterator.hasNext(); ((Timer)iterator.next()).start()) { }
    }

    public void stop()
    {
        for (Iterator iterator = timers.iterator(); iterator.hasNext(); ((Timer)iterator.next()).stop()) { }
    }

    public void stop(boolean flag)
    {
        for (Iterator iterator = timers.iterator(); iterator.hasNext(); ((Timer)iterator.next()).stop()) { }
    }
}
