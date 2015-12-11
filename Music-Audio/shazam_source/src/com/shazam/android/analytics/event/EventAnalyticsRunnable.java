// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;

import android.view.View;

// Referenced classes of package com.shazam.android.analytics.event:
//            EventAnalyticsFromView, Event

public class EventAnalyticsRunnable
    implements Runnable
{

    private final Event event;
    private final EventAnalyticsFromView eventAnalytics;
    private final View view;

    public EventAnalyticsRunnable(View view1, EventAnalyticsFromView eventanalyticsfromview, Event event1)
    {
        view = view1;
        eventAnalytics = eventanalyticsfromview;
        event = event1;
    }

    public void run()
    {
        eventAnalytics.logEvent(view, event);
    }
}
