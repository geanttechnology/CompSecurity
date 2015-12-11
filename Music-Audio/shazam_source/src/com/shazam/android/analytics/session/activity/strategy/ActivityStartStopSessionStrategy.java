// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.activity.strategy;

import android.app.Activity;
import com.shazam.android.analytics.session.SessionManager;

// Referenced classes of package com.shazam.android.analytics.session.activity.strategy:
//            NoOpActivitySessionStrategy

public class ActivityStartStopSessionStrategy extends NoOpActivitySessionStrategy
{

    private final SessionManager sessionManager;

    public ActivityStartStopSessionStrategy(SessionManager sessionmanager)
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
}
