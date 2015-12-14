// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.content.Context;
import bso;
import bsy;
import btb;
import btr;
import bvo;
import bvy;
import bwl;
import bwv;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionAnalyticsManagerStrategy, KeepAllEventFilter, SessionEvent, EventFilter, 
//            SessionAnalyticsFilesSender, AnswersRetryFilesSender, SessionAnalyticsFilesManager, SamplingEventFilter, 
//            SessionEventMetadata

class EnabledSessionAnalyticsManagerStrategy extends bvo
    implements SessionAnalyticsManagerStrategy
{

    btr apiKey;
    boolean customEventsEnabled;
    EventFilter eventFilter;
    bvy filesSender;
    private final bwl httpRequestFactory;
    private final bsy kit;
    final SessionEventMetadata metadata;
    boolean predefinedEventsEnabled;

    public EnabledSessionAnalyticsManagerStrategy(bsy bsy, Context context, ScheduledExecutorService scheduledexecutorservice, SessionAnalyticsFilesManager sessionanalyticsfilesmanager, bwl bwl, SessionEventMetadata sessioneventmetadata)
    {
        super(context, scheduledexecutorservice, sessionanalyticsfilesmanager);
        eventFilter = new KeepAllEventFilter();
        apiKey = new btr();
        customEventsEnabled = true;
        predefinedEventsEnabled = true;
        kit = bsy;
        httpRequestFactory = bwl;
        metadata = sessioneventmetadata;
    }

    public bvy getFilesSender()
    {
        return filesSender;
    }

    public void processEvent(SessionEvent.Builder builder)
    {
        builder = builder.build(metadata);
        if (!customEventsEnabled && SessionEvent.Type.CUSTOM.equals(((SessionEvent) (builder)).type))
        {
            bso.h().a("Answers", (new StringBuilder()).append("Custom events tracking disabled - skipping event: ").append(builder).toString());
            return;
        }
        if (!predefinedEventsEnabled && SessionEvent.Type.PREDEFINED.equals(((SessionEvent) (builder)).type))
        {
            bso.h().a("Answers", (new StringBuilder()).append("Predefined events tracking disabled - skipping event: ").append(builder).toString());
            return;
        }
        if (eventFilter.skipEvent(builder))
        {
            bso.h().a("Answers", (new StringBuilder()).append("Skipping filtered event: ").append(builder).toString());
            return;
        } else
        {
            recordEvent(builder);
            return;
        }
    }

    public void setAnalyticsSettingsData(bwv bwv1, String s)
    {
        filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(kit, s, bwv1.a, httpRequestFactory, apiKey.a(context)));
        ((SessionAnalyticsFilesManager)filesManager).setAnalyticsSettingsData(bwv1);
        customEventsEnabled = bwv1.f;
        btb btb1 = bso.h();
        StringBuilder stringbuilder = (new StringBuilder()).append("Custom event tracking ");
        if (customEventsEnabled)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        btb1.a("Answers", stringbuilder.append(s).toString());
        predefinedEventsEnabled = bwv1.g;
        btb1 = bso.h();
        stringbuilder = (new StringBuilder()).append("Predefined event tracking ");
        if (predefinedEventsEnabled)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        btb1.a("Answers", stringbuilder.append(s).toString());
        if (bwv1.h > 1)
        {
            bso.h().a("Answers", "Event sampling enabled");
            eventFilter = new SamplingEventFilter(bwv1.h);
        }
        configureRollover(bwv1.b);
    }
}
