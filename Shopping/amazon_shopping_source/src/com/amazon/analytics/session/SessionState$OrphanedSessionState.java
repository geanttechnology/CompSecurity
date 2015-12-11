// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session;

import com.amazon.analytics.util.Message;
import com.amazon.device.analytics.events.Event;
import java.util.Map;

// Referenced classes of package com.amazon.analytics.session:
//            SessionState, PackageSession

private static class <init> extends SessionState
{

    private Event createStopEvent(Message message, Event event)
    {
        Event event1 = (Event)message.getExtras().get("TailwindEvent");
        event = null;
        if (event1 != null)
        {
            event1 = new Event(event1.getApplicationKey(), "com.amazon.analytics.session.stop", event1);
            event = event1;
            if (message.getExtras().containsKey("TimeStamp"))
            {
                event1.addMetric("TimeStamp", Long.valueOf(message.getExtras().get("TimeStamp").toString()));
                event = event1;
            }
        }
        return event;
    }

    public SessionState getNextState(PackageSession packagesession, int i, Message message)
    {
        return NO_SESSION;
    }

    public Event triggerOnStateAction(PackageSession packagesession, SessionState sessionstate, Message message)
    {
        Event event = null;
        if (sessionstate == NO_SESSION)
        {
            event = createStopEvent(message, null);
            event.addAttribute("session_end_reason", "orphan");
            packagesession.clearTrackingInfo();
        }
        return event;
    }

    private ()
    {
        super(null);
    }

    ( )
    {
        this();
    }
}
