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
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 81
    //                   1 28
    //                   2 32;
           goto _L1 _L2 _L1 _L3
_L1:
        return MAYBE_END_SESSION;
_L3:
        if (SessionState.access$500(message, packagesession.getPackageName()))
        {
            i = ((Integer)message.getExtras().get("SessionRunId")).intValue();
            if (packagesession.getRunId() == i)
            {
                return NO_SESSION;
            } else
            {
                return MAYBE_END_SESSION;
            }
        } else
        {
            return MAYBE_END_SESSION;
        }
_L2:
        if (SessionState.access$500(message, packagesession.getPackageName()))
        {
            return RUNNING_SESSION;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public Event triggerOnStateAction(PackageSession packagesession, SessionState sessionstate, Message message)
    {
        if (sessionstate == RUNNING_SESSION)
        {
            packagesession.scheduleTimerTask(message);
        }
        return null;
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
