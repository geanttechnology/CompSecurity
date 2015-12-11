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
        if (event1 == null)
        {
            event = new Event(event.getApplicationKey(), "com.amazon.analytics.session.stop", event);
            if (message.getExtras().containsKey("TimeStamp"))
            {
                event.addMetric("TimeStamp", Long.valueOf(message.getExtras().get("TimeStamp").toString()));
            }
            event.addAttribute("session_end_reason", "artificial");
        } else
        {
            event = event1;
            event.addAttribute("session_end_reason", "normal");
        }
        if (!event.hasMetric("TimeStamp") && message.getExtras().containsKey("TimeStamp"))
        {
            event.addMetric("TimeStamp", Long.valueOf(message.getExtras().get("TimeStamp").toString()));
        }
        return event;
    }

    public SessionState getNextState(PackageSession packagesession, int i, Message message)
    {
        if (i == 1 && packagesession.getCurrentStartEvent() == null && SessionState.access$500(message, packagesession.getPackageName()))
        {
            return ORPHANED_SESSION;
        }
        if (i == 0 && SessionState.access$500(message, packagesession.getPackageName()))
        {
            return RUNNING_SESSION;
        } else
        {
            return NO_SESSION;
        }
    }

    public Event triggerOnStateAction(PackageSession packagesession, SessionState sessionstate, Message message)
    {
        Event event = null;
        if (sessionstate == MAYBE_END_SESSION)
        {
            Event event1 = packagesession.getCurrentStartEvent();
            event = createStopEvent(message, event1);
            message = null;
            sessionstate = message;
            if (event.hasMetric("TimeStamp"))
            {
                sessionstate = message;
                if (event1.hasMetric("TimeStamp"))
                {
                    sessionstate = Long.valueOf(((Long)event.getMetric("TimeStamp")).longValue() - ((Long)event1.getMetric("TimeStamp")).longValue());
                }
            }
            event.addMetric("sessionlength", sessionstate);
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
