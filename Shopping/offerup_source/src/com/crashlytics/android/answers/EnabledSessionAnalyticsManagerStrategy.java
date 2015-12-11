// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.content.Context;
import c.a.a.a.a.b.j;
import c.a.a.a.a.d.b;
import c.a.a.a.a.d.k;
import c.a.a.a.a.e.a;
import c.a.a.a.e;
import c.a.a.a.n;
import c.a.a.a.q;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionAnalyticsManagerStrategy, KeepAllEventFilter, SessionEvent, EventFilter, 
//            SessionAnalyticsFilesSender, AnswersRetryFilesSender, SessionAnalyticsFilesManager, SamplingEventFilter, 
//            SessionEventMetadata

class EnabledSessionAnalyticsManagerStrategy extends b
    implements SessionAnalyticsManagerStrategy
{

    j apiKey;
    boolean customEventsEnabled;
    EventFilter eventFilter;
    k filesSender;
    private final a httpRequestFactory$6bbea658;
    private final n kit;
    final SessionEventMetadata metadata;
    boolean predefinedEventsEnabled;

    public EnabledSessionAnalyticsManagerStrategy(n n, Context context, ScheduledExecutorService scheduledexecutorservice, SessionAnalyticsFilesManager sessionanalyticsfilesmanager, a a, SessionEventMetadata sessioneventmetadata)
    {
        super(context, scheduledexecutorservice, sessionanalyticsfilesmanager);
        eventFilter = new KeepAllEventFilter();
        apiKey = new j();
        customEventsEnabled = true;
        predefinedEventsEnabled = true;
        kit = n;
        httpRequestFactory$6bbea658 = a;
        metadata = sessioneventmetadata;
    }

    public k getFilesSender()
    {
        return filesSender;
    }

    public void processEvent(SessionEvent.Builder builder)
    {
        builder = builder.build(metadata);
        if (!customEventsEnabled && SessionEvent.Type.CUSTOM.equals(((SessionEvent) (builder)).type))
        {
            e.d().a("Answers", (new StringBuilder("Custom events tracking disabled - skipping event: ")).append(builder).toString());
            return;
        }
        if (!predefinedEventsEnabled && SessionEvent.Type.PREDEFINED.equals(((SessionEvent) (builder)).type))
        {
            e.d().a("Answers", (new StringBuilder("Predefined events tracking disabled - skipping event: ")).append(builder).toString());
            return;
        }
        if (eventFilter.skipEvent(builder))
        {
            e.d().a("Answers", (new StringBuilder("Skipping filtered event: ")).append(builder).toString());
            return;
        } else
        {
            recordEvent(builder);
            return;
        }
    }

    public void setAnalyticsSettingsData(c.a.a.a.a.g.b b1, String s)
    {
        filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(kit, s, b1.a, httpRequestFactory$6bbea658, apiKey.a(context)));
        ((SessionAnalyticsFilesManager)filesManager).setAnalyticsSettingsData(b1);
        customEventsEnabled = b1.e;
        q q1 = e.d();
        StringBuilder stringbuilder = new StringBuilder("Custom event tracking ");
        if (customEventsEnabled)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        q1.a("Answers", stringbuilder.append(s).toString());
        predefinedEventsEnabled = b1.f;
        q1 = e.d();
        stringbuilder = new StringBuilder("Predefined event tracking ");
        if (predefinedEventsEnabled)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        q1.a("Answers", stringbuilder.append(s).toString());
        if (b1.g > 1)
        {
            e.d().a("Answers", "Event sampling enabled");
            eventFilter = new SamplingEventFilter(b1.g);
        }
        configureRollover(b1.b);
    }
}
