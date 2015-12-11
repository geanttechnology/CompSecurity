// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;

import com.shazam.android.e.a;
import com.shazam.model.analytics.BeaconEventKey;

// Referenced classes of package com.shazam.android.analytics.event:
//            EventAnalytics, Event, EventParameters

public class BeaconEventAnalytics
    implements EventAnalytics
{

    private final a beaconClient;

    public BeaconEventAnalytics(a a1)
    {
        beaconClient = a1;
    }

    public void logEvent(Event event)
    {
        String s = event.getEventKey().getEventKey();
        event = event.getParameters();
        beaconClient.a(s, event.getParameters());
    }
}
