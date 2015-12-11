// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.EnabledEventsStrategy;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionAnalyticsManagerStrategy, KeepAllEventFilter, EventFilter, Answers, 
//            SessionEvent, SessionAnalyticsFilesSender, AnswersRetryFilesSender, SessionAnalyticsFilesManager, 
//            SamplingEventFilter

class EnabledSessionAnalyticsManagerStrategy extends EnabledEventsStrategy
    implements SessionAnalyticsManagerStrategy
{

    EventFilter eventFilter;
    FilesSender filesSender;
    private final HttpRequestFactory httpRequestFactory;

    public EnabledSessionAnalyticsManagerStrategy(Context context, ScheduledExecutorService scheduledexecutorservice, SessionAnalyticsFilesManager sessionanalyticsfilesmanager, HttpRequestFactory httprequestfactory)
    {
        super(context, scheduledexecutorservice, sessionanalyticsfilesmanager);
        eventFilter = new KeepAllEventFilter();
        httpRequestFactory = httprequestfactory;
    }

    public FilesSender getFilesSender()
    {
        return filesSender;
    }

    public void recordEvent(SessionEvent sessionevent)
    {
        if (eventFilter.skipEvent(sessionevent))
        {
            CommonUtils.logControlled(Answers.getInstance().getContext(), (new StringBuilder()).append("skipping filtered event ").append(sessionevent).toString());
            return;
        } else
        {
            super.recordEvent(sessionevent);
            return;
        }
    }

    public volatile void recordEvent(Object obj)
    {
        recordEvent((SessionEvent)obj);
    }

    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticssettingsdata, String s)
    {
        filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(Answers.getInstance(), s, analyticssettingsdata.analyticsURL, httpRequestFactory, (new ApiKey()).getValue(context)));
        ((SessionAnalyticsFilesManager)filesManager).setAnalyticsSettingsData(analyticssettingsdata);
        configureRollover(analyticssettingsdata.flushIntervalSeconds);
        if (analyticssettingsdata.samplingRate > 1)
        {
            eventFilter = new SamplingEventFilter(analyticssettingsdata.samplingRate);
        }
    }
}
