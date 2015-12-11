// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;


public final class AnalyticsEventCategory extends Enum
{

    private static final AnalyticsEventCategory $VALUES[];
    public static final AnalyticsEventCategory Crash;
    public static final AnalyticsEventCategory Custom;
    public static final AnalyticsEventCategory Interaction;
    public static final AnalyticsEventCategory Session;

    private AnalyticsEventCategory(String s, int i)
    {
        super(s, i);
    }

    public static AnalyticsEventCategory valueOf(String s)
    {
        return (AnalyticsEventCategory)Enum.valueOf(com/newrelic/agent/android/analytics/AnalyticsEventCategory, s);
    }

    public static AnalyticsEventCategory[] values()
    {
        return (AnalyticsEventCategory[])$VALUES.clone();
    }

    static 
    {
        Session = new AnalyticsEventCategory("Session", 0);
        Interaction = new AnalyticsEventCategory("Interaction", 1);
        Crash = new AnalyticsEventCategory("Crash", 2);
        Custom = new AnalyticsEventCategory("Custom", 3);
        $VALUES = (new AnalyticsEventCategory[] {
            Session, Interaction, Crash, Custom
        });
    }
}
