// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;

import android.app.Activity;
import android.content.Context;
import com.bitstrips.imoji.util.AppiumLogger;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.google.android.gms.analytics.Tracker;

// Referenced classes of package com.bitstrips.imoji.analytics:
//            GoogleAnalyticsService, Category, Action, Variable

public class GoogleAnalyticsServiceMock extends GoogleAnalyticsService
{

    private String filename;
    PreferenceUtils preferenceUtils;

    public GoogleAnalyticsServiceMock(Tracker tracker, Context context)
    {
        super(tracker, context);
        filename = "analytics-report.txt";
    }

    public void reportStart(Activity activity)
    {
        AppiumLogger.writeAnalytics("START", activity.toString());
    }

    public void reportStop(Activity activity)
    {
        AppiumLogger.writeAnalytics("STOP", activity.toString());
    }

    public void sendEvent(Category category, Action action, String s)
    {
        AppiumLogger.writeAnalytics("EVENT", (new com.google.android.gms.analytics.HitBuilders.EventBuilder(category.toString(), action.toString())).setLabel(s).build().toString());
    }

    public void sendEvent(Category category, Action action, String s, long l)
    {
        AppiumLogger.writeAnalytics("EVENT", (new com.google.android.gms.analytics.HitBuilders.EventBuilder(category.toString(), action.toString())).setLabel(s).setValue(l).build().toString());
    }

    public void sendTiming(Category category, Variable variable, long l, String s)
    {
        AppiumLogger.writeAnalytics("TIMING", (new com.google.android.gms.analytics.HitBuilders.TimingBuilder()).setCategory(category.toString()).setValue(l).setVariable(variable.toString()).setLabel(s).build().toString());
    }
}
