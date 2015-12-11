// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.crashes;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.EventManager;
import com.newrelic.agent.android.harvest.crash.Crash;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stats.TicToc;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.newrelic.agent.android.crashes:
//            CrashReporter

private class <init>
    implements UncaughtExceptionHandler
{

    private final AtomicBoolean handledException;
    final CrashReporter this$0;

    private void chainExceptionHandler(Thread thread, Throwable throwable)
    {
        if (CrashReporter.access$400(CrashReporter.this) != null)
        {
            CrashReporter.access$100(CrashReporter.this).debug((new StringBuilder()).append("Chaining crash reporting duties to ").append(CrashReporter.access$400(CrashReporter.this).getClass().getSimpleName()).toString());
            CrashReporter.access$400(CrashReporter.this).uncaughtException(thread, throwable);
        }
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        if (!handledException.compareAndSet(false, true))
        {
            StatsEngine.get().inc("Supportability/AgentHealth/Recursion/UncaughtExceptionHandler");
            return;
        }
        try
        {
            if (!CrashReporter.instance.isEnabled || !FeatureFlag.featureEnabled(FeatureFlag.CrashReporting))
            {
                CrashReporter.access$100(CrashReporter.this).debug("A crash has been detected but crash reporting is disabled!");
                chainExceptionHandler(thread, throwable);
                return;
            }
        }
        catch (Throwable throwable1)
        {
            CrashReporter.access$100(CrashReporter.this).error("Error encountered while preparing crash for New Relic!", throwable1);
            chainExceptionHandler(thread, throwable);
            return;
        }
        TicToc tictoc;
        AgentLog agentlog;
        StringBuilder stringbuilder;
        tictoc = new TicToc();
        tictoc.tic();
        CrashReporter.access$100(CrashReporter.this).debug((new StringBuilder()).append("A crash has been detected in ").append(thread.getStackTrace()[0].getClassName()).append(" and will be reported ASAP.").toString());
        agentlog = CrashReporter.access$100(CrashReporter.this);
        stringbuilder = (new StringBuilder()).append("Analytics data is currently ");
        Object obj;
        if (CrashReporter.access$200().getEnableAnalyticsEvents())
        {
            obj = "enabled ";
        } else
        {
            obj = "disabled";
        }
        agentlog.debug(stringbuilder.append(((String) (obj))).toString());
        obj = new Crash(throwable, AnalyticsControllerImpl.getInstance().getSessionAttributes(), AnalyticsControllerImpl.getInstance().getEventManager().getQueuedEvents(), CrashReporter.access$200().getEnableAnalyticsEvents());
        CrashReporter.access$300(CrashReporter.this, ((Crash) (obj)), true);
        CrashReporter.access$100(CrashReporter.this).debug((new StringBuilder()).append("Crash collection took ").append(tictoc.toc()).append("ms").toString());
        chainExceptionHandler(thread, throwable);
        return;
    }

    private ()
    {
        this$0 = CrashReporter.this;
        super();
        handledException = new AtomicBoolean(false);
    }

    handledException(handledException handledexception)
    {
        this();
    }
}
