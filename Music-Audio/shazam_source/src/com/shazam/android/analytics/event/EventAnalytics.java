// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;

import com.shazam.b.b;

// Referenced classes of package com.shazam.android.analytics.event:
//            Event

public interface EventAnalytics
{

    public static final EventAnalytics NO_OP = (EventAnalytics)b.a(com/shazam/android/analytics/event/EventAnalytics);

    public abstract void logEvent(Event event);

}
