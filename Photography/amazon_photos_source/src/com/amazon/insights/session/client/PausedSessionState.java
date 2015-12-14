// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.session.client;

import com.amazon.insights.core.log.Logger;
import com.amazon.insights.session.Session;

// Referenced classes of package com.amazon.insights.session.client:
//            SessionClientState, DefaultSessionClient

public class PausedSessionState extends SessionClientState
{

    public PausedSessionState(DefaultSessionClient defaultsessionclient)
    {
        super(defaultsessionclient);
    }

    public void pause()
    {
        DefaultSessionClient.logger.devi("Session Pause Failed: Session is already paused.");
    }

    public void resume()
    {
        if (System.currentTimeMillis() - client.session.getStopTime().longValue() < client.getResumeDelay())
        {
            super.executeResume();
            return;
        } else
        {
            DefaultSessionClient.logger.devi("Session has expired. Starting a fresh one...");
            start();
            return;
        }
    }

    public void start()
    {
        super.executeStop();
        super.executeStart();
    }
}
