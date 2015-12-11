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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.newrelic.agent.android.crashes:
//            CrashReporter, CrashStore

public class this._cls0
    implements UncaughtExceptionHandler
{

    private final AtomicBoolean handledException = new AtomicBoolean(false);
    final CrashReporter this$0;

    private void chainExceptionHandler(Thread thread, Throwable throwable)
    {
        if (CrashReporter.access$400(CrashReporter.this) != null)
        {
            CrashReporter.access$000(CrashReporter.this).debug((new StringBuilder()).append("Chaining crash reporting duties to ").append(CrashReporter.access$400(CrashReporter.this).getClass().getSimpleName()).toString());
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
        if (CrashReporter.instance.isEnabled && FeatureFlag.featureEnabled(FeatureFlag.CrashReporting))
        {
            break MISSING_BLOCK_LABEL_73;
        }
        CrashReporter.access$000(CrashReporter.this).debug("A crash has been detected but crash reporting is disabled!");
        chainExceptionHandler(thread, throwable);
        storeSupportabilityMetrics();
        chainExceptionHandler(thread, throwable);
        return;
        AgentLog agentlog;
        StringBuilder stringbuilder;
        CrashReporter.access$000(CrashReporter.this).debug((new StringBuilder()).append("A crash has been detected in ").append(thread.getStackTrace()[0].getClassName()).append(" and will be reported ASAP.").toString());
        agentlog = CrashReporter.access$000(CrashReporter.this);
        stringbuilder = (new StringBuilder()).append("Analytics data is currently ");
        Object obj;
        if (CrashReporter.access$100().getEnableAnalyticsEvents())
        {
            obj = "enabled ";
        } else
        {
            obj = "disabled";
        }
        agentlog.debug(stringbuilder.append(((String) (obj))).toString());
        obj = new Crash(throwable, AnalyticsControllerImpl.getInstance().getSessionAttributes(), AnalyticsControllerImpl.getInstance().getEventManager().getQueuedEvents(), CrashReporter.access$100().getEnableAnalyticsEvents());
        CrashReporter.access$200(CrashReporter.this).store(((Crash) (obj)));
        reportCrash(((Crash) (obj)));
        CrashReporter.access$300().shutdown();
        if (!CrashReporter.access$300().awaitTermination(5000L, TimeUnit.MILLISECONDS))
        {
            recordFailedUpload("Crash upload thread(s) timed-out before completion");
        }
_L2:
        storeSupportabilityMetrics();
        chainExceptionHandler(thread, throwable);
        return;
        Object obj1;
        obj1;
        recordFailedUpload((new StringBuilder()).append("Exception caught while sending crash: ").append(((Exception) (obj1)).getMessage()).toString());
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        recordFailedUpload((new StringBuilder()).append("Error encountered while preparing crash for New Relic! ").append(((Throwable) (obj1)).getMessage()).toString());
        storeSupportabilityMetrics();
        chainExceptionHandler(thread, throwable);
        return;
        obj1;
        storeSupportabilityMetrics();
        chainExceptionHandler(thread, throwable);
        throw obj1;
    }

    public ()
    {
        this$0 = CrashReporter.this;
        super();
    }
}
