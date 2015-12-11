// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;

import com.shazam.android.analytics.event.factory.StartupEventFactory;

// Referenced classes of package com.shazam.android.analytics.event:
//            StartupEventAnalytics, StartupEvent, EventAnalytics

public class OneTimeStartupEventAnalytics
    implements StartupEventAnalytics
{

    private final EventAnalytics eventAnalytics;
    private final StartupEvent startupEvent;

    public OneTimeStartupEventAnalytics(StartupEvent startupevent, EventAnalytics eventanalytics)
    {
        startupEvent = startupevent;
        eventAnalytics = eventanalytics;
    }

    public void sendStartupEvent()
    {
        if (startupEvent.hasNotBeenSent())
        {
            startupEvent.markDisplayedActivitiesCreationEnded();
            Event event = StartupEventFactory.createStartupEvent(startupEvent);
            eventAnalytics.logEvent(event);
        }
    }
}
