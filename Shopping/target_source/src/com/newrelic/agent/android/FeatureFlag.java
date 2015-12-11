// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import java.util.HashSet;
import java.util.Set;

public final class FeatureFlag extends Enum
{

    private static final FeatureFlag $VALUES[];
    public static final FeatureFlag AnalyticsEvents;
    public static final FeatureFlag CrashReporting;
    public static final FeatureFlag HttpResponseBodyCapture;
    public static final Set enabledFeatures = new HashSet();

    private FeatureFlag(String s, int i)
    {
        super(s, i);
    }

    public static void disableFeature(FeatureFlag featureflag)
    {
        enabledFeatures.remove(featureflag);
    }

    public static void enableFeature(FeatureFlag featureflag)
    {
        enabledFeatures.add(featureflag);
    }

    public static boolean featureEnabled(FeatureFlag featureflag)
    {
        return enabledFeatures.contains(featureflag);
    }

    public static FeatureFlag valueOf(String s)
    {
        return (FeatureFlag)Enum.valueOf(com/newrelic/agent/android/FeatureFlag, s);
    }

    public static FeatureFlag[] values()
    {
        return (FeatureFlag[])$VALUES.clone();
    }

    static 
    {
        HttpResponseBodyCapture = new FeatureFlag("HttpResponseBodyCapture", 0);
        CrashReporting = new FeatureFlag("CrashReporting", 1);
        AnalyticsEvents = new FeatureFlag("AnalyticsEvents", 2);
        $VALUES = (new FeatureFlag[] {
            HttpResponseBodyCapture, CrashReporting, AnalyticsEvents
        });
        enableFeature(HttpResponseBodyCapture);
        enableFeature(CrashReporting);
        enableFeature(AnalyticsEvents);
    }
}
