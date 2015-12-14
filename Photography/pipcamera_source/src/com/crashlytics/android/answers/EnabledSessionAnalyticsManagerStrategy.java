// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import aad;
import aag;
import aau;
import acf;
import aco;
import acy;
import adi;
import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import zw;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionAnalyticsManagerStrategy, KeepAllEventFilter, SessionEvent, EventFilter, 
//            SessionAnalyticsFilesSender, AnswersRetryFilesSender, SessionAnalyticsFilesManager, SamplingEventFilter, 
//            SessionEventMetadata

class EnabledSessionAnalyticsManagerStrategy extends acf
    implements SessionAnalyticsManagerStrategy
{

    aau apiKey;
    boolean customEventsEnabled;
    EventFilter eventFilter;
    aco filesSender;
    private final acy httpRequestFactory;
    private final aad kit;
    final SessionEventMetadata metadata;
    boolean predefinedEventsEnabled;

    public EnabledSessionAnalyticsManagerStrategy(aad aad, Context context, ScheduledExecutorService scheduledexecutorservice, SessionAnalyticsFilesManager sessionanalyticsfilesmanager, acy acy, SessionEventMetadata sessioneventmetadata)
    {
        super(context, scheduledexecutorservice, sessionanalyticsfilesmanager);
        eventFilter = new KeepAllEventFilter();
        apiKey = new aau();
        customEventsEnabled = true;
        predefinedEventsEnabled = true;
        kit = aad;
        httpRequestFactory = acy;
        metadata = sessioneventmetadata;
    }

    public aco getFilesSender()
    {
        return filesSender;
    }

    public void processEvent(SessionEvent.Builder builder)
    {
        builder = builder.build(metadata);
        if (!customEventsEnabled && SessionEvent.Type.CUSTOM.equals(((SessionEvent) (builder)).type))
        {
            zw.h().a("Answers", (new StringBuilder()).append("Custom events tracking disabled - skipping event: ").append(builder).toString());
            return;
        }
        if (!predefinedEventsEnabled && SessionEvent.Type.PREDEFINED.equals(((SessionEvent) (builder)).type))
        {
            zw.h().a("Answers", (new StringBuilder()).append("Predefined events tracking disabled - skipping event: ").append(builder).toString());
            return;
        }
        if (eventFilter.skipEvent(builder))
        {
            zw.h().a("Answers", (new StringBuilder()).append("Skipping filtered event: ").append(builder).toString());
            return;
        } else
        {
            recordEvent(builder);
            return;
        }
    }

    public void setAnalyticsSettingsData(adi adi1, String s)
    {
        filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(kit, s, adi1.a, httpRequestFactory, apiKey.a(context)));
        ((SessionAnalyticsFilesManager)filesManager).setAnalyticsSettingsData(adi1);
        customEventsEnabled = adi1.f;
        aag aag1 = zw.h();
        StringBuilder stringbuilder = (new StringBuilder()).append("Custom event tracking ");
        if (customEventsEnabled)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        aag1.a("Answers", stringbuilder.append(s).toString());
        predefinedEventsEnabled = adi1.g;
        aag1 = zw.h();
        stringbuilder = (new StringBuilder()).append("Predefined event tracking ");
        if (predefinedEventsEnabled)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        aag1.a("Answers", stringbuilder.append(s).toString());
        if (adi1.h > 1)
        {
            zw.h().a("Answers", "Event sampling enabled");
            eventFilter = new SamplingEventFilter(adi1.h);
        }
        configureRollover(adi1.b);
    }
}
