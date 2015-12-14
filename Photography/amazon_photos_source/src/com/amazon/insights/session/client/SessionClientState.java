// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.session.client;

import com.amazon.insights.Event;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.event.InternalEventClient;
import com.amazon.insights.session.Session;
import com.amazon.insights.session.SessionStore;

// Referenced classes of package com.amazon.insights.session.client:
//            DefaultSessionClient

public abstract class SessionClientState
{

    protected final DefaultSessionClient client;

    public SessionClientState(DefaultSessionClient defaultsessionclient)
    {
        client = defaultsessionclient;
    }

    protected void executePause()
    {
        client.session.pause();
        DefaultSessionClient.logger.i((new StringBuilder()).append("Session Paused: ").append(client.session.getSessionID()).toString());
        DefaultSessionClient.logger.devi("Session Paused.");
        DefaultSessionClient.logger.devv("Firing Session Event: _session.pause");
        Event event = client.eventClient.createEvent("_session.pause");
        event.addMetric("_session.duration", client.session.getSessionDuration());
        client.eventClient.recordEvent(event);
        client.sessionStore.storeSession(client.session);
        client.changeState(DefaultSessionClient.SessionState.PAUSED);
    }

    protected void executeResume()
    {
        client.session.resume();
        DefaultSessionClient.logger.devv("Firing Session Event: _session.resume");
        Event event = client.eventClient.createEvent("_session.resume");
        client.eventClient.recordEvent(event);
        DefaultSessionClient.logger.i((new StringBuilder()).append("Session Resumed: ").append(client.session.getSessionID()).toString());
        DefaultSessionClient.logger.devi("Session Resumed.");
        client.changeState(DefaultSessionClient.SessionState.ACTIVE);
    }

    protected void executeStart()
    {
        client.session = Session.newInstance(client.context);
        client.eventClient.addGlobalAttribute("_session.id", client.session.getSessionID());
        DefaultSessionClient.logger.devv("Firing Session Event: _session.start");
        Event event = client.eventClient.createEvent("_session.start");
        client.eventClient.recordEvent(event);
        client.changeState(DefaultSessionClient.SessionState.ACTIVE);
    }

    protected void executeStop()
    {
        if (!client.session.isPaused())
        {
            client.session.pause();
        }
        DefaultSessionClient.logger.devv("Firing Session Event: _session.stop");
        Event event = client.eventClient.createEvent("_session.stop");
        event.addMetric("_session.duration", client.session.getSessionDuration());
        event.addAttribute("_session.id", client.session.getSessionID());
        long l;
        if (client.session.getStopTime() == null)
        {
            l = 0L;
        } else
        {
            l = client.session.getStopTime().longValue();
        }
        event.addAttribute("_session.startTime", Long.toString(client.session.getStartTime()));
        event.addAttribute("_session.stopTime", Long.toString(Long.valueOf(l).longValue()));
        client.eventClient.recordEvent(event);
        client.eventClient.removeGlobalAttribute("_session.id");
        client.session = null;
        client.changeState(DefaultSessionClient.SessionState.INACTIVE);
    }

    public abstract void pause();

    public abstract void resume();

    public abstract void start();
}
