// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.eventbuilder;

import com.amazon.analytics.AnalyticsConfiguration;
import com.amazon.analytics.AnalyticsConfigurationInitializer;
import com.amazon.analytics.session.PriorityQueue;
import com.amazon.android.dagger.DaggerAndroid;
import com.amazon.device.analytics.events.EventRecorder;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.amazon.analytics.eventbuilder:
//            AnalyticsEventBuilder

public static class I
{

    private static final execService injectPoint = new <init>();
    AnalyticsConfiguration config;
    ScheduledExecutorService execService;
    AnalyticsConfigurationInitializer initializer;
    PriorityQueue queue;
    EventRecorder recorder;

    public static void inject(AnalyticsEventBuilder analyticseventbuilder)
    {
        DaggerAndroid.inject(injectPoint);
        analyticseventbuilder.initializer = injectPoint.initializer;
        analyticseventbuilder.recorder = injectPoint.recorder;
        analyticseventbuilder.config = injectPoint.config;
        analyticseventbuilder.queue = injectPoint.queue;
        analyticseventbuilder.execService = injectPoint.execService;
    }


    public I()
    {
    }
}
