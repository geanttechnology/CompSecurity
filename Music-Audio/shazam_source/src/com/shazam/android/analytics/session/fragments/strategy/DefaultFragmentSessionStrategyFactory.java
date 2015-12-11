// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.fragments.strategy;

import com.shazam.android.analytics.session.SessionStrategyType;
import com.shazam.i.b.g.c.b;

// Referenced classes of package com.shazam.android.analytics.session.fragments.strategy:
//            FragmentSessionStrategyFactory, FragmentResumePauseSessionStrategy, FragmentResumePauseWindowFocusedWindowUnfocusedSessionStrategy, FragmentStartStopSessionStrategy, 
//            FragmentStartStopWindowFocusedWindowUnfocusedSessionStrategy, FragmentSelectedUnselectedSessionStrategy, FragmentSelectedUnselectedFocusedUnfocusedSessionStrategy, FragmentSelectedUnSelectedStartStopSessionStrategy, 
//            NoOpFragmentSessionStrategy, FragmentSessionStrategy

public class DefaultFragmentSessionStrategyFactory
    implements FragmentSessionStrategyFactory
{

    public DefaultFragmentSessionStrategyFactory()
    {
    }

    public FragmentSessionStrategy createSessionStrategy(SessionStrategyType sessionstrategytype)
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
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[SessionStrategyType.RESUME_PAUSE_FOCUSED_UNFOCUSED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[SessionStrategyType.START_STOP.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[SessionStrategyType.START_STOP_FOCUSED_UNFOCUSED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[SessionStrategyType.SELECTED_UNSELECTED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[SessionStrategyType.SELECTED_UNSELECTED_FOCUSED_UNFOCUSED.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[SessionStrategyType.SELECTED_UNSELECTED_START_STOP.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[SessionStrategyType.MANUAL.ordinal()] = 8;
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
            throw new RuntimeException((new StringBuilder("Unknown session strategy type:")).append(sessionstrategytype).toString());

        case 1: // '\001'
            return new FragmentResumePauseSessionStrategy(b.a());

        case 2: // '\002'
            return new FragmentResumePauseWindowFocusedWindowUnfocusedSessionStrategy(b.a());

        case 3: // '\003'
            return new FragmentStartStopSessionStrategy(b.a());

        case 4: // '\004'
            return new FragmentStartStopWindowFocusedWindowUnfocusedSessionStrategy(b.a());

        case 5: // '\005'
            return new FragmentSelectedUnselectedSessionStrategy(b.a());

        case 6: // '\006'
            return new FragmentSelectedUnselectedFocusedUnfocusedSessionStrategy(b.a());

        case 7: // '\007'
            return new FragmentSelectedUnSelectedStartStopSessionStrategy(b.a());

        case 8: // '\b'
            return new NoOpFragmentSessionStrategy();
        }
    }
}
