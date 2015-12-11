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
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stats.TicToc;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.newrelic.agent.android.crashes:
//            CrashStore

public class CrashReporter
{
    private class CrashSender
        implements Runnable
    {

        private final Crash crash;
        final CrashReporter this$0;

        public void run()
        {
            Object obj;
            if (CrashReporter.agentConfiguration.useSsl())
            {
                obj = "https://";
            } else
            {
                obj = "http://";
            }
            obj = (HttpURLConnection)(new URL((new StringBuilder()).append(((String) (obj))).append(CrashReporter.agentConfiguration.getCrashCollectorHost()).append("/mobile_crash").toString())).openConnection();
            ((HttpURLConnection) (obj)).setDoOutput(true);
            ((HttpURLConnection) (obj)).setChunkedStreamingMode(0);
            ((HttpURLConnection) (obj)).setRequestProperty("Content-Type", "application/json");
            ((HttpURLConnection) (obj)).setConnectTimeout(5000);
            BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(((HttpURLConnection) (obj)).getOutputStream());
            bufferedoutputstream.write(crash.toJsonString().getBytes());
            bufferedoutputstream.close();
            if (((HttpURLConnection) (obj)).getResponseCode() != 200)
            {
                break MISSING_BLOCK_LABEL_191;
            }
            log.info((new StringBuilder()).append("Crash ").append(crash.getUuid().toString()).append(" successfully submitted.").toString());
            crashStore.delete(crash);
_L1:
            Exception exception1;
            try
            {
                ((HttpURLConnection) (obj)).disconnect();
                return;
            }
            catch (Exception exception)
            {
                log.error("Unable to report crash to New Relic, will try again later.", exception);
            }
            break MISSING_BLOCK_LABEL_251;
            log.error((new StringBuilder()).append("Something went wrong while submitting a crash (will try again later) - Response code ").append(((HttpURLConnection) (obj)).getResponseCode()).toString());
              goto _L1
            exception1;
            ((HttpURLConnection) (obj)).disconnect();
            throw exception1;
        }

        CrashSender(Crash crash1)
        {
            this$0 = CrashReporter.this;
            super();
            crash = crash1;
        }
    }

    private class UncaughtExceptionHandler
        implements Thread.UncaughtExceptionHandler
    {

        private final AtomicBoolean handledException;
        final CrashReporter this$0;

        private void chainExceptionHandler(Thread thread, Throwable throwable)
        {
            if (previousExceptionHandler != null)
            {
                log.debug((new StringBuilder()).append("Chaining crash reporting duties to ").append(previousExceptionHandler.getClass().getSimpleName()).toString());
                previousExceptionHandler.uncaughtException(thread, throwable);
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
                    log.debug("A crash has been detected but crash reporting is disabled!");
                    chainExceptionHandler(thread, throwable);
                    return;
                }
            }
            catch (Throwable throwable1)
            {
                log.error("Error encountered while preparing crash for New Relic!", throwable1);
                chainExceptionHandler(thread, throwable);
                return;
            }
            TicToc tictoc;
            AgentLog agentlog;
            StringBuilder stringbuilder;
            tictoc = new TicToc();
            tictoc.tic();
            log.debug((new StringBuilder()).append("A crash has been detected in ").append(thread.getStackTrace()[0].getClassName()).append(" and will be reported ASAP.").toString());
            agentlog = log;
            stringbuilder = (new StringBuilder()).append("Analytics data is currently ");
            Object obj;
            if (CrashReporter.agentConfiguration.getEnableAnalyticsEvents())
            {
                obj = "enabled ";
            } else
            {
                obj = "disabled";
            }
            agentlog.debug(stringbuilder.append(((String) (obj))).toString());
            obj = new Crash(throwable, AnalyticsControllerImpl.getInstance().getSessionAttributes(), AnalyticsControllerImpl.getInstance().getEventManager().getQueuedEvents(), CrashReporter.agentConfiguration.getEnableAnalyticsEvents());
            reportCrash(((Crash) (obj)), true);
            log.debug((new StringBuilder()).append("Crash collection took ").append(tictoc.toc()).append("ms").toString());
            chainExceptionHandler(thread, throwable);
            return;
        }

        private UncaughtExceptionHandler()
        {
            this$0 = CrashReporter.this;
            super();
            handledException = new AtomicBoolean(false);
        }

    }


    private static final String CRASH_COLLECTOR_PATH = "/mobile_crash";
    private static final int CRASH_COLLECTOR_TIMEOUT = 5000;
    private static AgentConfiguration agentConfiguration;
    protected static final AtomicBoolean initialized = new AtomicBoolean(false);
    protected static CrashReporter instance = new CrashReporter();
    private CrashStore crashStore;
    protected boolean isEnabled;
    private final AgentLog log = AgentLogManager.getAgentLog();
    private Thread.UncaughtExceptionHandler previousExceptionHandler;
    private boolean reportCrashes;

    public CrashReporter()
    {
        isEnabled = false;
        reportCrashes = true;
    }

    public static void clear()
    {
        instance.crashStore.clear();
    }

    public static List fetchAllCrashes()
    {
        return instance.crashStore.fetchAll();
    }

    public static AgentConfiguration getAgentConfiguration()
    {
        return agentConfiguration;
    }

    public static UncaughtExceptionHandler getInstanceHandler()
    {
        return instance.getHandler();
    }

    public static int getStoredCrashCount()
    {
        return instance.crashStore.count();
    }

    public static void initialize(AgentConfiguration agentconfiguration)
    {
        if (initialized.compareAndSet(false, true))
        {
            agentConfiguration = agentconfiguration;
            instance.isEnabled = agentConfiguration.getReportCrashes();
            instance.crashStore = agentConfiguration.getCrashStore();
            instance.reportSavedCrashes();
            if (instance.isEnabled)
            {
                instance.installCrashHandler();
                return;
            }
        }
    }

    private void installCrashHandler()
    {
        Thread.UncaughtExceptionHandler uncaughtexceptionhandler = Thread.getDefaultUncaughtExceptionHandler();
        if (uncaughtexceptionhandler != null)
        {
            if (uncaughtexceptionhandler instanceof UncaughtExceptionHandler)
            {
                log.debug("New Relic crash handler already installed.");
                return;
            }
            previousExceptionHandler = uncaughtexceptionhandler;
            log.debug((new StringBuilder()).append("Installing New Relic crash handler and chaining ").append(previousExceptionHandler.getClass().getName()).append(".").toString());
        } else
        {
            log.debug("Installing New Relic crash handler.");
        }
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler());
    }

    private void reportCrash(Crash crash, boolean flag)
    {
        crashStore.store(crash);
        if (!reportCrashes)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        crash = new Thread(new CrashSender(crash));
        crash.start();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        crash.join();
        return;
        crash;
        log.error("Exception caught while waiting to send crash", crash);
        return;
    }

    private void reportSavedCrashes()
    {
        for (Iterator iterator = crashStore.fetchAll().iterator(); iterator.hasNext(); reportCrash((Crash)iterator.next(), false)) { }
    }

    public static void setReportCrashes(boolean flag)
    {
        instance.reportCrashes = flag;
    }

    public UncaughtExceptionHandler getHandler()
    {
        return new UncaughtExceptionHandler();
    }






}
