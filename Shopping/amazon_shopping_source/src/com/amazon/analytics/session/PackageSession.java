// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session;

import com.amazon.analytics.AnalyticsConfiguration;
import com.amazon.analytics.util.Message;
import com.amazon.android.dagger.DaggerAndroid;
import com.amazon.device.analytics.events.Event;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.analytics.session:
//            SessionState, SessionObserver

public class PackageSession
{

    private static Logger logger = Logging.getLogger(com/amazon/analytics/session/PackageSession);
    private final int WAIT_TIME_SECONDS;
    AnalyticsConfiguration config;
    private Future future;
    private final String packageName;
    private int runId;
    private Event sessionEvent;
    SessionObserver sessionObserver;
    private SessionState state;
    ScheduledExecutorService timerService;

    PackageSession(String s)
    {
        DaggerAndroid.inject(this);
        WAIT_TIME_SECONDS = config.getInt(com.amazon.analytics.AnalyticsConfiguration.Setting.IgnoreSessionInterval);
        packageName = s;
        state = SessionState.NO_SESSION;
        clearTrackingInfo();
    }

    public void clearTrackingInfo()
    {
        sessionEvent = null;
        future = null;
        runId = 0;
    }

    public Event getCurrentStartEvent()
    {
        return sessionEvent;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public int getRunId()
    {
        return runId;
    }

    public SessionState getSessionState()
    {
        return state;
    }

    public void incrementRunId()
    {
        runId = runId + 1;
    }

    public boolean scheduleTimerTask(final Message message)
    {
        boolean flag = false;
        if (future == null)
        {
            flag = true;
            future = timerService.schedule(new Runnable() {

                final Message m;
                final int runId;
                final PackageSession this$0;
                final Message val$message;

                public void run()
                {
                    m.getExtras().put("SessionFlag", Integer.valueOf(2));
                    m.getExtras().put("SessionRunId", Integer.valueOf(runId));
                    sessionObserver.onUpdate(m);
                }

            
            {
                this$0 = PackageSession.this;
                message = message1;
                super();
                m = new Message(message.getType(), new HashMap(message.getExtras()));
                runId = getRunId();
            }
            }, WAIT_TIME_SECONDS, TimeUnit.SECONDS);
        }
        return flag;
    }

    public void setCurrentStartEvent(Event event)
    {
        sessionEvent = event;
    }

    public boolean tryCancelTimerTask()
    {
        boolean flag = false;
        if (future != null)
        {
            flag = future.cancel(false);
            future = null;
        }
        return flag;
    }

    public Event tryChangeSessionState(Message message)
    {
        int i = ((Integer)message.getExtras().get("SessionFlag")).intValue();
        logger.v((new StringBuilder()).append("Incoming message has session flag ").append(i).toString());
        SessionState sessionstate = state.getNextState(this, i, message);
        Event event = null;
        if (state != sessionstate)
        {
            event = sessionstate.triggerOnStateAction(this, state, message);
        }
        state = sessionstate;
        return event;
    }

}
