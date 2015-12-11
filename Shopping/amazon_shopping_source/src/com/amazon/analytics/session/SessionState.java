// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session;

import com.amazon.analytics.util.Message;
import com.amazon.device.analytics.events.Event;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import java.util.Map;

// Referenced classes of package com.amazon.analytics.session:
//            PackageSession

public abstract class SessionState
{
    private static class MaybeEndSessionState extends SessionState
    {

        public SessionState getNextState(PackageSession packagesession, int i, Message message)
        {
            i;
            JVM INSTR tableswitch 0 2: default 28
        //                       0 81
        //                       1 28
        //                       2 32;
               goto _L1 _L2 _L1 _L3
_L1:
            return MAYBE_END_SESSION;
_L3:
            if (SessionState.isSamePackage(message, packagesession.getPackageName()))
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
            if (SessionState.isSamePackage(message, packagesession.getPackageName()))
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

        private MaybeEndSessionState()
        {
        }

    }

    private static class NoSessionState extends SessionState
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
            if (i == 1 && packagesession.getCurrentStartEvent() == null && SessionState.isSamePackage(message, packagesession.getPackageName()))
            {
                return ORPHANED_SESSION;
            }
            if (i == 0 && SessionState.isSamePackage(message, packagesession.getPackageName()))
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

        private NoSessionState()
        {
        }

    }

    private static class OrphanedSessionState extends SessionState
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

        private OrphanedSessionState()
        {
        }

    }

    private static class RunningSessionState extends SessionState
    {

        public SessionState getNextState(PackageSession packagesession, int i, Message message)
        {
            if (i == 1 && SessionState.isSamePackage(message, packagesession.getPackageName()))
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

        private RunningSessionState()
        {
        }

    }


    static final SessionState MAYBE_END_SESSION = new MaybeEndSessionState();
    static final SessionState NO_SESSION = new NoSessionState();
    static final SessionState ORPHANED_SESSION = new OrphanedSessionState();
    static final SessionState RUNNING_SESSION = new RunningSessionState();
    private static Logger logger = Logging.getLogger(com/amazon/analytics/session/SessionState);

    private SessionState()
    {
    }


    private static boolean isSamePackage(Message message, String s)
    {
        message = message.getExtras().get("PackageName").toString();
        logger.v((new StringBuilder()).append("isSamePackage check - message package name is ").append(message).toString());
        return s.equals(message);
    }

    public abstract SessionState getNextState(PackageSession packagesession, int i, Message message);

    public abstract Event triggerOnStateAction(PackageSession packagesession, SessionState sessionstate, Message message);


}
