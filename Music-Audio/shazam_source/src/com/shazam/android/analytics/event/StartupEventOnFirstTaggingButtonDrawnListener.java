// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;

import com.shazam.android.view.tagging.i;

// Referenced classes of package com.shazam.android.analytics.event:
//            StartupEventAnalytics

public class StartupEventOnFirstTaggingButtonDrawnListener
    implements i
{

    private final StartupEventAnalytics startupEventAnalytics;

    public StartupEventOnFirstTaggingButtonDrawnListener(StartupEventAnalytics startupeventanalytics)
    {
        startupEventAnalytics = startupeventanalytics;
    }

    public void onTaggingButtonDrawnFirstTime()
    {
        startupEventAnalytics.sendStartupEvent();
    }
}
