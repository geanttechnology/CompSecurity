// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.session.client;

import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.configuration.Configuration;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.util.Preconditions;
import com.amazon.insights.event.InternalEventClient;
import com.amazon.insights.session.FileSessionStore;
import com.amazon.insights.session.InternalSessionClient;
import com.amazon.insights.session.Session;
import com.amazon.insights.session.SessionStore;

// Referenced classes of package com.amazon.insights.session.client:
//            InactiveSessionState, ActiveSessionState, PausedSessionState, SessionClientState

public class DefaultSessionClient
    implements InternalSessionClient
{
    protected static final class SessionState extends Enum
    {

        private static final SessionState $VALUES[];
        public static final SessionState ACTIVE;
        public static final SessionState INACTIVE;
        public static final SessionState PAUSED;

        public static SessionState valueOf(String s)
        {
            return (SessionState)Enum.valueOf(com/amazon/insights/session/client/DefaultSessionClient$SessionState, s);
        }

        public static SessionState[] values()
        {
            return (SessionState[])$VALUES.clone();
        }

        static 
        {
            INACTIVE = new SessionState("INACTIVE", 0);
            ACTIVE = new SessionState("ACTIVE", 1);
            PAUSED = new SessionState("PAUSED", 2);
            $VALUES = (new SessionState[] {
                INACTIVE, ACTIVE, PAUSED
            });
        }

        private SessionState(String s, int i)
        {
            super(s, i);
        }
    }


    protected static final Logger logger = Logger.getLogger(com/amazon/insights/session/client/DefaultSessionClient);
    private final SessionClientState ACTIVE_STATE = new ActiveSessionState(this);
    private final SessionClientState INACTIVE_STATE = new InactiveSessionState(this);
    private final SessionClientState PAUSED_STATE = new PausedSessionState(this);
    protected final InsightsContext context;
    protected final InternalEventClient eventClient;
    private final long restartDelay;
    private final long resumeDelay;
    protected Session session;
    protected final SessionStore sessionStore;
    protected SessionClientState state;

    protected DefaultSessionClient(InsightsContext insightscontext, InternalEventClient internaleventclient, SessionStore sessionstore)
    {
        Preconditions.checkNotNull(insightscontext, "A valid InsightsContext must be provided!");
        Preconditions.checkNotNull(internaleventclient, "A valid EventClient must be provided!");
        Preconditions.checkNotNull(sessionstore, "A valid SessionStore must be provided!");
        sessionStore = sessionstore;
        eventClient = internaleventclient;
        context = insightscontext;
        session = sessionStore.getSession();
        if (session == null)
        {
            internaleventclient = INACTIVE_STATE;
        } else
        {
            internaleventclient = PAUSED_STATE;
        }
        state = internaleventclient;
        restartDelay = insightscontext.getConfiguration().optLong("sessionRestartDelay", Long.valueOf(30000L)).longValue();
        resumeDelay = insightscontext.getConfiguration().optLong("sessionResumeDelay", Long.valueOf(5000L)).longValue();
    }

    public static DefaultSessionClient newInstance(InsightsContext insightscontext, InternalEventClient internaleventclient)
    {
        return new DefaultSessionClient(insightscontext, internaleventclient, new FileSessionStore(insightscontext));
    }

    protected void changeState(SessionState sessionstate)
    {
        this;
        JVM INSTR monitorenter ;
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$insights$session$client$DefaultSessionClient$SessionState[];

            static 
            {
                $SwitchMap$com$amazon$insights$session$client$DefaultSessionClient$SessionState = new int[SessionState.values().length];
                try
                {
                    $SwitchMap$com$amazon$insights$session$client$DefaultSessionClient$SessionState[SessionState.INACTIVE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$insights$session$client$DefaultSessionClient$SessionState[SessionState.ACTIVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$insights$session$client$DefaultSessionClient$SessionState[SessionState.PAUSED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        int i = _cls1..SwitchMap.com.amazon.insights.session.client.DefaultSessionClient.SessionState[sessionstate.ordinal()];
        i;
        JVM INSTR tableswitch 1 3: default 40
    //                   1 43
    //                   2 59
    //                   3 70;
           goto _L1 _L2 _L3 _L4
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        state = INACTIVE_STATE;
          goto _L1
        sessionstate;
        throw sessionstate;
_L3:
        state = ACTIVE_STATE;
          goto _L1
_L4:
        state = PAUSED_STATE;
          goto _L1
    }

    public long getRestartDelay()
    {
        return restartDelay;
    }

    public long getResumeDelay()
    {
        return resumeDelay;
    }

    public void pauseSession()
    {
        this;
        JVM INSTR monitorenter ;
        state.pause();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void resumeSession()
    {
        this;
        JVM INSTR monitorenter ;
        state.resume();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void startSession()
    {
        this;
        JVM INSTR monitorenter ;
        state.start();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("[DefaultSessionClient]\n- session: ");
        String s;
        if (session == null)
        {
            s = "<null>";
        } else
        {
            s = session.getSessionID();
        }
        stringbuilder = stringbuilder.append(s);
        if (session != null && session.isPaused())
        {
            s = ": paused";
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).toString();
    }

}
