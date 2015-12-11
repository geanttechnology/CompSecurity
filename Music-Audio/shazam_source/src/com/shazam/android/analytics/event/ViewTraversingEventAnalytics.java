// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;

import android.view.View;
import com.shazam.model.analytics.AnalyticsInfo;

// Referenced classes of package com.shazam.android.analytics.event:
//            EventAnalyticsFromView, Event, AnalyticsInfoFromHierarchy, EventAnalytics

public class ViewTraversingEventAnalytics
    implements EventAnalyticsFromView
{

    private final EventAnalytics eventAnalytics[];

    public transient ViewTraversingEventAnalytics(EventAnalytics aeventanalytics[])
    {
        eventAnalytics = aeventanalytics;
    }

    private Event merge(Event event, AnalyticsInfo analyticsinfo)
    {
        return Event.Builder.from(event).withParameters(EventParameters.Builder.eventParameters().withNotEmptyOrNullParameters(analyticsinfo.eventParameters).appendParametersFrom(event.getParameters()).build()).build();
    }

    public void logEvent(View view, Event event)
    {
        view = merge(event, AnalyticsInfoFromHierarchy.addAnalyticsInfoFromViewHierarchy(view));
        event = eventAnalytics;
        int j = event.length;
        for (int i = 0; i < j; i++)
        {
            event[i].logEvent(view);
        }

    }
}
