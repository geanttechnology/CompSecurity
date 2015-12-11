// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.activity.strategy;

import android.app.Activity;
import com.shazam.android.analytics.session.SessionManager;

// Referenced classes of package com.shazam.android.analytics.session.activity.strategy:
//            NoOpActivitySessionStrategy

public class ActivityStartStopWindowFocusedWindowUnfocusedSessionStrategy extends NoOpActivitySessionStrategy
{

    private final SessionManager sessionManager;

    public ActivityStartStopWindowFocusedWindowUnfocusedSessionStrategy(SessionManager sessionmanager)
    {
        sessionManager = sessionmanager;
    }

    public void onStart(Activity activity)
    {
        sessionManager.startSession(activity);
    }

    public void onStop(Activity activity)
    {
        sessionManager.stopSession(activity);
    }

    public void onWindowFocused(Activity activity)
    {
        if (!sessionManager.isSessionActive())
        {
            sessionManager.startSession(activity);
        }
    }

    public void onWindowUnfocused(Activity activity)
    {
        sessionManager.stopSession(activity);
    }
}
