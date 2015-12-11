// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.activity.strategy;

import com.shazam.android.analytics.session.SessionManager;
import com.shazam.android.analytics.session.SessionStrategyType;
import com.shazam.i.b.g.c.b;

// Referenced classes of package com.shazam.android.analytics.session.activity.strategy:
//            ActivitySessionStrategyFactory, ActivityResumePauseSessionStrategy, ActivityResumePauseWindowFocusedWindowUnfocusedSessionStrategy, ActivityStartStopSessionStrategy, 
//            ActivityStartStopWindowFocusedWindowUnfocusedSessionStrategy, ActivitySessionStrategy

public class DefaultActivitySessionStrategyFactory
    implements ActivitySessionStrategyFactory
{

    private final SessionManager sessionManager = b.a();

    public DefaultActivitySessionStrategyFactory()
    {
    }

    public ActivitySessionStrategy createSessionStrategy(SessionStrategyType sessionstrategytype)
    {
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[SessionStrategyType.values().length];
                try
                {
                    a[SessionStrategyType.RESUME_PAUSE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[SessionStrategyType.RESUME_PAUSE_FOCUSED_UNFOCUSED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[SessionStrategyType.START_STOP.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[SessionStrategyType.START_STOP_FOCUSED_UNFOCUSED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[sessionstrategytype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new ActivityResumePauseSessionStrategy(sessionManager);

        case 2: // '\002'
            return new ActivityResumePauseWindowFocusedWindowUnfocusedSessionStrategy(sessionManager);

        case 3: // '\003'
            return new ActivityStartStopSessionStrategy(sessionManager);

        case 4: // '\004'
            return new ActivityStartStopWindowFocusedWindowUnfocusedSessionStrategy(sessionManager);
        }
    }
}
