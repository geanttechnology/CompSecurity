// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.content.Context;
import c.a.a.a.a.b.c;
import c.a.a.a.a.d.i;
import c.a.a.a.a.e.a;
import c.a.a.a.a.g.b;
import c.a.a.a.e;
import c.a.a.a.n;
import c.a.a.a.q;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.crashlytics.android.answers:
//            DisabledSessionAnalyticsManagerStrategy, AnswersFilesManagerProvider, SessionMetadataCollector, SessionAnalyticsManagerStrategy

class AnswersEventsHandler
    implements i
{

    private static final String EXECUTOR_SERVICE = "Answers Events Handler";
    private final Context context;
    final ScheduledExecutorService executor;
    private final AnswersFilesManagerProvider filesManagerProvider;
    private final n kit;
    private final SessionMetadataCollector metadataCollector;
    private final a requestFactory$6bbea658;
    SessionAnalyticsManagerStrategy strategy;

    public AnswersEventsHandler(n n, Context context1, AnswersFilesManagerProvider answersfilesmanagerprovider, SessionMetadataCollector sessionmetadatacollector, a a)
    {
        this(n, context1, answersfilesmanagerprovider, sessionmetadatacollector, a, c.b("Answers Events Handler"));
    }

    AnswersEventsHandler(n n, Context context1, AnswersFilesManagerProvider answersfilesmanagerprovider, SessionMetadataCollector sessionmetadatacollector, a a, ScheduledExecutorService scheduledexecutorservice)
    {
        strategy = new DisabledSessionAnalyticsManagerStrategy();
        kit = n;
        context = context1;
        filesManagerProvider = answersfilesmanagerprovider;
        metadataCollector = sessionmetadatacollector;
        requestFactory$6bbea658 = a;
        executor = scheduledexecutorservice;
    }

    private void executeAsync(Runnable runnable)
    {
        try
        {
            executor.submit(runnable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable)
        {
            e.d().c("Answers", "Failed to submit events task", runnable);
        }
    }

    private void executeSync(Runnable runnable)
    {
        try
        {
            executor.submit(runnable).get();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable)
        {
            e.d().c("Answers", "Failed to run events task", runnable);
        }
    }

    public void disable()
    {
        executeAsync(new _cls2());
    }

    public void enable()
    {
        executeAsync(new _cls4());
    }

    public void onRollOver(String s)
    {
        executeAsync(new _cls3());
    }

    void processEvent(final SessionEvent.Builder eventBuilder, boolean flag, final boolean flush)
    {
        eventBuilder = new _cls5();
        if (flag)
        {
            executeSync(eventBuilder);
            return;
        } else
        {
            executeAsync(eventBuilder);
            return;
        }
    }

    public void processEventAsync(SessionEvent.Builder builder)
    {
        processEvent(builder, false, false);
    }

    public void processEventAsyncAndFlush(SessionEvent.Builder builder)
    {
        processEvent(builder, false, true);
    }

    public void processEventSync(SessionEvent.Builder builder)
    {
        processEvent(builder, true, false);
    }

    public void setAnalyticsSettingsData(final b analyticsSettingsData, final String protocolAndHostOverride)
    {
        executeAsync(new _cls1());
    }






    private class _cls2
        implements Runnable
    {

        final AnswersEventsHandler this$0;

        public void run()
        {
            try
            {
                SessionAnalyticsManagerStrategy sessionanalyticsmanagerstrategy = strategy;
                strategy = new DisabledSessionAnalyticsManagerStrategy();
                sessionanalyticsmanagerstrategy.deleteAllEvents();
                return;
            }
            catch (Exception exception)
            {
                e.d().c("Answers", "Failed to disable events", exception);
            }
        }

        _cls2()
        {
            this$0 = AnswersEventsHandler.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final AnswersEventsHandler this$0;

        public void run()
        {
            try
            {
                SessionEventMetadata sessioneventmetadata = metadataCollector.getMetadata();
                SessionAnalyticsFilesManager sessionanalyticsfilesmanager = filesManagerProvider.getAnalyticsFilesManager();
                sessionanalyticsfilesmanager.registerRollOverListener(AnswersEventsHandler.this);
                strategy = new EnabledSessionAnalyticsManagerStrategy(kit, context, executor, sessionanalyticsfilesmanager, requestFactory$6bbea658, sessioneventmetadata);
                return;
            }
            catch (Exception exception)
            {
                e.d().c("Answers", "Failed to enable events", exception);
            }
        }

        _cls4()
        {
            this$0 = AnswersEventsHandler.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final AnswersEventsHandler this$0;

        public void run()
        {
            try
            {
                strategy.sendEvents();
                return;
            }
            catch (Exception exception)
            {
                e.d().c("Answers", "Failed to send events files", exception);
            }
        }

        _cls3()
        {
            this$0 = AnswersEventsHandler.this;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final AnswersEventsHandler this$0;
        final SessionEvent.Builder val$eventBuilder;
        final boolean val$flush;

        public void run()
        {
            try
            {
                strategy.processEvent(eventBuilder);
                if (flush)
                {
                    strategy.rollFileOver();
                }
                return;
            }
            catch (Exception exception)
            {
                e.d().c("Answers", "Failed to process event", exception);
            }
        }

        _cls5()
        {
            this$0 = AnswersEventsHandler.this;
            eventBuilder = builder;
            flush = flag;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final AnswersEventsHandler this$0;
        final b val$analyticsSettingsData;
        final String val$protocolAndHostOverride;

        public void run()
        {
            try
            {
                strategy.setAnalyticsSettingsData(analyticsSettingsData, protocolAndHostOverride);
                return;
            }
            catch (Exception exception)
            {
                e.d().c("Answers", "Failed to set analytics settings data", exception);
            }
        }

        _cls1()
        {
            this$0 = AnswersEventsHandler.this;
            analyticsSettingsData = b;
            protocolAndHostOverride = s;
            super();
        }
    }

}
