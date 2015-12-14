// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.session.client;

import com.amazon.insights.core.log.Logger;
import com.amazon.insights.event.InternalEventClient;

// Referenced classes of package com.amazon.insights.session.client:
//            SessionClientState, DefaultSessionClient

public class InactiveSessionState extends SessionClientState
{

    public InactiveSessionState(DefaultSessionClient defaultsessionclient)
    {
        super(defaultsessionclient);
    }

    public void pause()
    {
        com.amazon.insights.Event event = client.eventClient.createEvent("_session.pause");
        client.eventClient.recordEvent(event);
        DefaultSessionClient.logger.devi("Session Pause Failed: No session is running.");
    }

    public void resume()
    {
        com.amazon.insights.Event event = client.eventClient.createEvent("_session.resume");
        client.eventClient.recordEvent(event);
        DefaultSessionClient.logger.devi("Session Resume Failed: No session is paused.");
    }

    public void start()
    {
        super.executeStart();
    }
}
