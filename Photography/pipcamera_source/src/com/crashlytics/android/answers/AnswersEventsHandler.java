// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import aad;
import aag;
import abb;
import acl;
import acy;
import adi;
import android.content.Context;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import zw;

// Referenced classes of package com.crashlytics.android.answers:
//            DisabledSessionAnalyticsManagerStrategy, AnswersFilesManagerProvider, SessionMetadataCollector, SessionAnalyticsManagerStrategy, 
//            SessionAnalyticsFilesManager, EnabledSessionAnalyticsManagerStrategy

class AnswersEventsHandler
    implements acl
{

    private static final String EXECUTOR_SERVICE = "Answers Events Handler";
    private final Context context;
    final ScheduledExecutorService executor;
    private final AnswersFilesManagerProvider filesManagerProvider;
    private final aad kit;
    private final SessionMetadataCollector metadataCollector;
    private final acy requestFactory;
    SessionAnalyticsManagerStrategy strategy;

    public AnswersEventsHandler(aad aad, Context context1, AnswersFilesManagerProvider answersfilesmanagerprovider, SessionMetadataCollector sessionmetadatacollector, acy acy)
    {
        this(aad, context1, answersfilesmanagerprovider, sessionmetadatacollector, acy, abb.b("Answers Events Handler"));
    }

    AnswersEventsHandler(aad aad, Context context1, AnswersFilesManagerProvider answersfilesmanagerprovider, SessionMetadataCollector sessionmetadatacollector, acy acy, ScheduledExecutorService scheduledexecutorservice)
    {
        strategy = new DisabledSessionAnalyticsManagerStrategy();
        kit = aad;
        context = context1;
        filesManagerProvider = answersfilesmanagerprovider;
        metadataCollector = sessionmetadatacollector;
        requestFactory = acy;
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
            zw.h().e("Answers", "Failed to submit events task", runnable);
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
            zw.h().e("Answers", "Failed to run events task", runnable);
        }
    }

    public void disable()
    {
        executeAsync(new Runnable() {

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
                    zw.h().e("Answers", "Failed to disable events", exception);
                }
            }

            
            {
                this$0 = AnswersEventsHandler.this;
                super();
            }
        });
    }

    public void enable()
    {
        executeAsync(new Runnable() {

            final AnswersEventsHandler this$0;

            public void run()
            {
                try
                {
                    SessionEventMetadata sessioneventmetadata = metadataCollector.getMetadata();
                    SessionAnalyticsFilesManager sessionanalyticsfilesmanager = filesManagerProvider.getAnalyticsFilesManager();
                    sessionanalyticsfilesmanager.registerRollOverListener(AnswersEventsHandler.this);
                    strategy = new EnabledSessionAnalyticsManagerStrategy(kit, context, executor, sessionanalyticsfilesmanager, requestFactory, sessioneventmetadata);
                    return;
                }
                catch (Exception exception)
                {
                    zw.h().e("Answers", "Failed to enable events", exception);
                }
            }

            
            {
                this$0 = AnswersEventsHandler.this;
                super();
            }
        });
    }

    public void onRollOver(String s)
    {
        executeAsync(new Runnable() {

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
                    zw.h().e("Answers", "Failed to send events files", exception);
                }
            }

            
            {
                this$0 = AnswersEventsHandler.this;
                super();
            }
        });
    }

    void processEvent(final SessionEvent.Builder eventBuilder, boolean flag, final boolean flush)
    {
        eventBuilder = new Runnable() {

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
                    zw.h().e("Answers", "Failed to process event", exception);
                }
            }

            
            {
                this$0 = AnswersEventsHandler.this;
                eventBuilder = builder;
                flush = flag;
                super();
            }
        };
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

    public void setAnalyticsSettingsData(final adi analyticsSettingsData, final String protocolAndHostOverride)
    {
        executeAsync(new Runnable() {

            final AnswersEventsHandler this$0;
            final adi val$analyticsSettingsData;
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
                    zw.h().e("Answers", "Failed to set analytics settings data", exception);
                }
            }

            
            {
                this$0 = AnswersEventsHandler.this;
                analyticsSettingsData = adi;
                protocolAndHostOverride = s;
                super();
            }
        });
    }





}
