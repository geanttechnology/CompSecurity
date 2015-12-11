// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.content.Context;
import android.support.v7.alt;
import android.support.v7.alz;
import android.support.v7.amc;
import android.support.v7.amo;
import android.support.v7.anv;
import android.support.v7.aod;
import android.support.v7.aol;
import android.support.v7.aov;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionAnalyticsManagerStrategy, KeepAllEventFilter, SessionEvent, EventFilter, 
//            SessionAnalyticsFilesSender, AnswersRetryFilesSender, SessionAnalyticsFilesManager, SamplingEventFilter, 
//            SessionEventMetadata

class EnabledSessionAnalyticsManagerStrategy extends anv
    implements SessionAnalyticsManagerStrategy
{

    amo apiKey;
    boolean customEventsEnabled;
    EventFilter eventFilter;
    aod filesSender;
    private final aol httpRequestFactory;
    private final alz kit;
    final SessionEventMetadata metadata;
    boolean predefinedEventsEnabled;

    public EnabledSessionAnalyticsManagerStrategy(alz alz, Context context, ScheduledExecutorService scheduledexecutorservice, SessionAnalyticsFilesManager sessionanalyticsfilesmanager, aol aol, SessionEventMetadata sessioneventmetadata)
    {
        super(context, scheduledexecutorservice, sessionanalyticsfilesmanager);
        eventFilter = new KeepAllEventFilter();
        apiKey = new amo();
        customEventsEnabled = true;
        predefinedEventsEnabled = true;
        kit = alz;
        httpRequestFactory = aol;
        metadata = sessioneventmetadata;
    }

    public aod getFilesSender()
    {
        return filesSender;
    }

    public void processEvent(SessionEvent.Builder builder)
    {
        builder = builder.build(metadata);
        if (!customEventsEnabled && SessionEvent.Type.CUSTOM.equals(((SessionEvent) (builder)).type))
        {
            alt.h().a("Answers", (new StringBuilder()).append("Custom events tracking disabled - skipping event: ").append(builder).toString());
            return;
        }
        if (!predefinedEventsEnabled && SessionEvent.Type.PREDEFINED.equals(((SessionEvent) (builder)).type))
        {
            alt.h().a("Answers", (new StringBuilder()).append("Predefined events tracking disabled - skipping event: ").append(builder).toString());
            return;
        }
        if (eventFilter.skipEvent(builder))
        {
            alt.h().a("Answers", (new StringBuilder()).append("Skipping filtered event: ").append(builder).toString());
            return;
        } else
        {
            recordEvent(builder);
            return;
        }
    }

    public void setAnalyticsSettingsData(aov aov1, String s)
    {
        filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(kit, s, aov1.a, httpRequestFactory, apiKey.a(context)));
        ((SessionAnalyticsFilesManager)filesManager).setAnalyticsSettingsData(aov1);
        customEventsEnabled = aov1.f;
        amc amc1 = alt.h();
        StringBuilder stringbuilder = (new StringBuilder()).append("Custom event tracking ");
        if (customEventsEnabled)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        amc1.a("Answers", stringbuilder.append(s).toString());
        predefinedEventsEnabled = aov1.g;
        amc1 = alt.h();
        stringbuilder = (new StringBuilder()).append("Predefined event tracking ");
        if (predefinedEventsEnabled)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        amc1.a("Answers", stringbuilder.append(s).toString());
        if (aov1.h > 1)
        {
            alt.h().a("Answers", "Event sampling enabled");
            eventFilter = new SamplingEventFilter(aov1.h);
        }
        configureRollover(aov1.b);
    }
}
