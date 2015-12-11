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
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
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

        private boolean requestWasSuccessful(HttpURLConnection httpurlconnection)
            throws IOException
        {
            switch (httpurlconnection.getResponseCode())
            {
            default:
                return false;

            case 200: 
                return true;
            }
        }

        public void run()
        {
            Object obj;
            TicToc tictoc;
            BufferedOutputStream bufferedoutputstream;
            if (CrashReporter.agentConfiguration.useSsl())
            {
                obj = "https://";
            } else
            {
                obj = "http://";
            }
            Exception exception1;
            try
            {
                obj = (HttpURLConnection)(new URL((new StringBuilder()).append(((String) (obj))).append(CrashReporter.agentConfiguration.getCrashCollectorHost()).append("/mobile_crash").toString())).openConnection();
                tictoc = new TicToc();
                tictoc.tic();
                ((HttpURLConnection) (obj)).setDoOutput(true);
                ((HttpURLConnection) (obj)).setChunkedStreamingMode(0);
                ((HttpURLConnection) (obj)).setRequestProperty("Content-Type", "application/json");
                ((HttpURLConnection) (obj)).setConnectTimeout(5000);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                recordFailedUpload((new StringBuilder()).append("Unable to report crash to New Relic, will try again later. ").append(((Exception) (obj)).getMessage()).toString());
                return;
            }
            bufferedoutputstream = new BufferedOutputStream(((HttpURLConnection) (obj)).getOutputStream());
            bufferedoutputstream.write(crash.toJsonString().getBytes());
            bufferedoutputstream.close();
            if (!requestWasSuccessful(((HttpURLConnection) (obj)))) goto _L2; else goto _L1
_L1:
            StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Crash/UploadTime", tictoc.toc());
            log.info((new StringBuilder()).append("Crash ").append(crash.getUuid().toString()).append(" successfully submitted.").toString());
            crashStore.delete(crash);
_L3:
            ((HttpURLConnection) (obj)).disconnect();
_L4:
            log.debug((new StringBuilder()).append("Crash collection took ").append(tictoc.toc()).append("ms").toString());
            return;
_L2:
            recordFailedUpload((new StringBuilder()).append("Something went wrong while submitting a crash (will try again later) - Response code ").append(((HttpURLConnection) (obj)).getResponseCode()).toString());
              goto _L3
            exception1;
            recordFailedUpload((new StringBuilder()).append("Crash upload failed: ").append(exception1.getMessage()).toString());
            ((HttpURLConnection) (obj)).disconnect();
              goto _L4
            Exception exception;
            exception;
            ((HttpURLConnection) (obj)).disconnect();
            throw exception;
              goto _L3
        }

        CrashSender(Crash crash1)
        {
            this$0 = CrashReporter.this;
            super();
            crash = crash1;
        }
    }

    public class UncaughtExceptionHandler
        implements Thread.UncaughtExceptionHandler
    {

        private final AtomicBoolean handledException = new AtomicBoolean(false);
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
            if (CrashReporter.instance.isEnabled && FeatureFlag.featureEnabled(FeatureFlag.CrashReporting))
            {
                break MISSING_BLOCK_LABEL_73;
            }
            log.debug("A crash has been detected but crash reporting is disabled!");
            chainExceptionHandler(thread, throwable);
            storeSupportabilityMetrics();
            chainExceptionHandler(thread, throwable);
            return;
            AgentLog agentlog;
            StringBuilder stringbuilder;
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
            crashStore.store(((Crash) (obj)));
            reportCrash(((Crash) (obj)));
            CrashReporter.executor.shutdown();
            if (!CrashReporter.executor.awaitTermination(5000L, TimeUnit.MILLISECONDS))
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

        public UncaughtExceptionHandler()
        {
            this$0 = CrashReporter.this;
            super();
        }
    }


    private static final String CRASH_COLLECTOR_PATH = "/mobile_crash";
    private static final int CRASH_COLLECTOR_TIMEOUT = 5000;
    private static AgentConfiguration agentConfiguration;
    private static ExecutorService executor;
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
            executor = Executors.newCachedThreadPool(new NamedThreadFactory("CrashUploader"));
            agentConfiguration = agentconfiguration;
            instance.isEnabled = agentConfiguration.getReportCrashes();
            instance.crashStore = agentConfiguration.getCrashStore();
            instance.reportSavedCrashes();
            instance.reportSupportabilityMetrics();
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

    public static void setReportCrashes(boolean flag)
    {
        instance.reportCrashes = flag;
    }

    public UncaughtExceptionHandler getHandler()
    {
        return new UncaughtExceptionHandler();
    }

    protected void recordFailedUpload(String s)
    {
        log.error(s);
        StatsEngine.get().inc("Supportability/AgentHealth/Crash/FailedUpload");
    }

    protected Future reportCrash(Crash crash)
    {
        Future future = null;
        if (reportCrashes)
        {
            crash = new CrashSender(crash);
            future = executor.submit(crash);
        }
        return future;
    }

    protected void reportSavedCrashes()
    {
        for (Iterator iterator = crashStore.fetchAll().iterator(); iterator.hasNext(); reportCrash((Crash)iterator.next())) { }
    }

    protected void reportSupportabilityMetrics()
    {
    }

    protected void storeSupportabilityMetrics()
    {
        StatsEngine.get().getStatsMap();
    }






}
