// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;

import com.shazam.model.analytics.BeaconEventKey;

// Referenced classes of package com.shazam.android.analytics.event:
//            Event, EventParameters

public static class s.EMPTY_PARAMETERS
{

    private BeaconEventKey eventKey;
    private EventParameters parameters;

    static BeaconEventKey a(s.EMPTY_PARAMETERS empty_parameters)
    {
        return empty_parameters.eventKey;
    }

    public static eventKey anEvent()
    {
        return new <init>();
    }

    static EventParameters b(<init> <init>1)
    {
        return <init>1.parameters;
    }

    public static parameters from(Event event)
    {
        return anEvent().withEventType(Event.b(event)).withParameters(Event.a(event));
    }

    public Event build()
    {
        return new Event(this, (byte)0);
    }

    public s withEventType(BeaconEventKey beaconeventkey)
    {
        eventKey = beaconeventkey;
        return this;
    }

    public s withParameters(EventParameters eventparameters)
    {
        parameters = eventparameters;
        return this;
    }

    public s()
    {
        parameters = EventParameters.EMPTY_PARAMETERS;
    }
}
