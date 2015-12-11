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

    public SessionState getNextState(PackageSession packagesession, int i, Message message)
    {
        if (i == 1 && SessionState.access$500(message, packagesession.getPackageName()))
        {
            return MAYBE_END_SESSION;
        } else
        {
            return RUNNING_SESSION;
        }
    }

    public Event triggerOnStateAction(PackageSession packagesession, SessionState sessionstate, Message message)
    {
        Object obj = null;
        if (sessionstate == NO_SESSION)
        {
            sessionstate = (Event)message.getExtras().get("TailwindEvent");
            message = new Event(sessionstate.getApplicationKey(), "com.amazon.analytics.session.start", sessionstate);
            packagesession.setCurrentStartEvent(message);
        } else
        {
            message = obj;
            if (sessionstate == MAYBE_END_SESSION)
            {
                message = obj;
                if (packagesession.tryCancelTimerTask())
                {
                    packagesession.incrementRunId();
                    return null;
                }
            }
        }
        return message;
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
