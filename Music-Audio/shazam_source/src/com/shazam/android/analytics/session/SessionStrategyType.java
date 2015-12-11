// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session;


public final class SessionStrategyType extends Enum
{

    private static final SessionStrategyType $VALUES[];
    public static final SessionStrategyType MANUAL;
    public static final SessionStrategyType RESUME_PAUSE;
    public static final SessionStrategyType RESUME_PAUSE_FOCUSED_UNFOCUSED;
    public static final SessionStrategyType SELECTED_UNSELECTED;
    public static final SessionStrategyType SELECTED_UNSELECTED_FOCUSED_UNFOCUSED;
    public static final SessionStrategyType SELECTED_UNSELECTED_START_STOP;
    public static final SessionStrategyType START_STOP;
    public static final SessionStrategyType START_STOP_FOCUSED_UNFOCUSED;

    private SessionStrategyType(String s, int i)
    {
        super(s, i);
    }

    public static SessionStrategyType valueOf(String s)
    {
        return (SessionStrategyType)Enum.valueOf(com/shazam/android/analytics/session/SessionStrategyType, s);
    }

    public static SessionStrategyType[] values()
    {
        return (SessionStrategyType[])$VALUES.clone();
    }

    static 
    {
        START_STOP = new SessionStrategyType("START_STOP", 0);
        START_STOP_FOCUSED_UNFOCUSED = new SessionStrategyType("START_STOP_FOCUSED_UNFOCUSED", 1);
        RESUME_PAUSE = new SessionStrategyType("RESUME_PAUSE", 2);
        RESUME_PAUSE_FOCUSED_UNFOCUSED = new SessionStrategyType("RESUME_PAUSE_FOCUSED_UNFOCUSED", 3);
        SELECTED_UNSELECTED = new SessionStrategyType("SELECTED_UNSELECTED", 4);
        SELECTED_UNSELECTED_FOCUSED_UNFOCUSED = new SessionStrategyType("SELECTED_UNSELECTED_FOCUSED_UNFOCUSED", 5);
        MANUAL = new SessionStrategyType("MANUAL", 6);
        SELECTED_UNSELECTED_START_STOP = new SessionStrategyType("SELECTED_UNSELECTED_START_STOP", 7);
        $VALUES = (new SessionStrategyType[] {
            START_STOP, START_STOP_FOCUSED_UNFOCUSED, RESUME_PAUSE, RESUME_PAUSE_FOCUSED_UNFOCUSED, SELECTED_UNSELECTED, SELECTED_UNSELECTED_FOCUSED_UNFOCUSED, MANUAL, SELECTED_UNSELECTED_START_STOP
        });
    }
}
