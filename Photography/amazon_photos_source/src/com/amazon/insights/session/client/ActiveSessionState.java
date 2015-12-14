// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.session.client;

import com.amazon.insights.core.log.Logger;
import com.amazon.insights.session.Session;

// Referenced classes of package com.amazon.insights.session.client:
//            SessionClientState, DefaultSessionClient

public final class ActiveSessionState extends SessionClientState
{

    public ActiveSessionState(DefaultSessionClient defaultsessionclient)
    {
        super(defaultsessionclient);
    }

    public void pause()
    {
        super.executePause();
    }

    public void resume()
    {
        DefaultSessionClient.logger.devi("Session Resume Failed: Session is already running.");
    }

    public void start()
    {
        if (System.currentTimeMillis() - client.session.getStartTime() > client.getRestartDelay())
        {
            super.executeStop();
            super.executeStart();
            return;
        } else
        {
            DefaultSessionClient.logger.devi("Session Start Failed: Previous session was started too recently");
            return;
        }
    }
}
