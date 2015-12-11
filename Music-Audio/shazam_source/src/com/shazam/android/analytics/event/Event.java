// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;

import com.shazam.model.analytics.BeaconEventKey;

// Referenced classes of package com.shazam.android.analytics.event:
//            EventParameters

public class Event
{
    public static class Builder
    {

        private BeaconEventKey eventKey;
        private EventParameters parameters;

        static BeaconEventKey a(Builder builder)
        {
            return builder.eventKey;
        }

        public static Builder anEvent()
        {
            return new Builder();
        }

        static EventParameters b(Builder builder)
        {
            return builder.parameters;
        }

        public static Builder from(Event event)
        {
            return anEvent().withEventType(Event.b(event)).withParameters(Event.a(event));
        }

        public Event build()
        {
            return new Event(this, (byte)0);
        }

        public Builder withEventType(BeaconEventKey beaconeventkey)
        {
            eventKey = beaconeventkey;
            return this;
        }

        public Builder withParameters(EventParameters eventparameters)
        {
            parameters = eventparameters;
            return this;
        }

        public Builder()
        {
            parameters = EventParameters.EMPTY_PARAMETERS;
        }
    }


    private final BeaconEventKey eventKey;
    private final EventParameters parameters;

    private Event(Builder builder)
    {
        eventKey = Builder.a(builder);
        parameters = Builder.b(builder);
    }

    Event(Builder builder, byte byte0)
    {
        this(builder);
    }

    static EventParameters a(Event event)
    {
        return event.parameters;
    }

    static BeaconEventKey b(Event event)
    {
        return event.eventKey;
    }

    public BeaconEventKey getEventKey()
    {
        return eventKey;
    }

    public EventParameters getParameters()
    {
        return parameters;
    }

    public String toString()
    {
        return (new StringBuilder("Event{eventKey=")).append(eventKey).append(", parameters=").append(parameters).append('}').toString();
    }
}
