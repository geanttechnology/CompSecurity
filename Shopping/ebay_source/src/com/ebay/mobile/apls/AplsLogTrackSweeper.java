// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.apls;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbayBroadcast;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.net.api.apls.AplsClientInfo;
import com.ebay.nautilus.domain.net.api.apls.AplsErrorReport;
import com.ebay.nautilus.domain.net.api.apls.AplsLogMessageRequest;
import com.ebay.nautilus.domain.net.api.apls.AplsLogMessageResponse;
import com.ebay.nautilus.domain.net.api.apls.AplsReportInfo;
import com.ebay.nautilus.domain.net.api.apls.AplsService;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.AsBeacon;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.LogTrackConfiguration;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.LogTrackManager;
import com.ebay.nautilus.kernel.net.LogTrackPerf;
import com.ebay.nautilus.kernel.net.LogTrackSweeper;
import com.ebay.nautilus.kernel.util.DelayedAsyncTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class AplsLogTrackSweeper extends LogTrackSweeper
{
    private final class ErrorTask extends LogTask
    {

        final AplsLogTrackSweeper this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (AplsLogTrackSweeper.logger.isLoggable)
            {
                AplsLogTrackSweeper.logger.log("Sending APLS error data");
            }
            backgroundPrepare();
            avoid = AplsErrorReport.buildErrorReports((Context)toString.getExtension(android/content/Context), takeErrorList(), MyApp.getPrefs().getCurrentCountry());
            try
            {
                avoid = ((AplsLogMessageResponse)toString.getConnector().sendRequest(new AplsLogMessageRequest(clientInfo, avoid))).getResultStatus();
                if (AplsLogTrackSweeper.logger.isLoggable && avoid.hasError())
                {
                    AplsLogTrackSweeper.logger.log((new StringBuilder()).append("Error while sending APLS error data: ").append(avoid.toString()).toString());
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            handleErrorTaskComplete(this);
        }

        public ErrorTask(String s)
        {
            this$0 = AplsLogTrackSweeper.this;
            super(s);
        }
    }

    private final class ForegroundBackgroundReceiver extends BroadcastReceiver
    {

        final AplsLogTrackSweeper this$0;

        public void onReceive(Context context, Intent intent)
        {
            context = intent.getAction();
            if ("com.ebay.common.intent.action.EBAY_APPBACKGROUND".equals(context))
            {
                onBackground();
            } else
            if ("com.ebay.common.intent.action.EBAY_APPFOREGROUND".equals(context))
            {
                onForeground();
                return;
            }
        }

        private ForegroundBackgroundReceiver()
        {
            this$0 = AplsLogTrackSweeper.this;
            super();
        }

    }


    private static final String BACKGROUND = "BACKGROUND";
    private static final String CLIENT_TYPE = "Mobile";
    private static final String ENV_PRODUCTION = "PRODUCTION";
    private static final String ENV_STAGING = "STAGING";
    private static final long ERROR_SWEEP_DELAY = 100L;
    private static final String FOREGROUND = "FOREGROUND";
    private static final int MAX_ERR_ITEMS = 20;
    private static final int MAX_PERF_ITEMS = 750;
    private static final int PERF_FLUSH_LIMIT = 600;
    private static final String TRAFFIC = "TRAFFIC";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("AplsSweeper", 3, "Log AplsLogTrackSweeper events");
    static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private ForegroundBackgroundReceiver appStateReceiver;
    private final LogTrackConfiguration config;
    private ErrorTask errorTask;
    private final Runnable foregroundReporter;
    private long inBackgroundAt;
    private long inForegroundAt;
    private final Object lock;
    private long packageStartAt;
    private String sessionGuid;

    public AplsLogTrackSweeper(EbayContext ebaycontext)
    {
        AplsLogTrackSweeper(ebaycontext, 750, 20);
    }

    public AplsLogTrackSweeper(EbayContext ebaycontext, int i, int j)
    {
        LogTrackSweeper(ebaycontext, i, j);
        lock = new Object();
        foregroundReporter = new Runnable() {

            final AplsLogTrackSweeper this$0;

            public void run()
            {
                synchronized (lock)
                {
                    if (inForegroundAt != 0L)
                    {
                        runTrafficReportTask(false, false);
                        scheduleNextForegroundRun(getSweepInterval());
                    }
                }
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = AplsLogTrackSweeper.this;
                super();
            }
        };
        config = LogTrackManager.getConfig();
        onForeground();
    }

    private long getSweepInterval()
    {
        return getConfig().aplsTrafficInterval() * 1000L;
    }

    private void runErrorTaskIfData()
    {
label0:
        {
            if (errorTask == null && !isErrorListEmpty())
            {
                errorTask = new ErrorTask(sessionGuid);
                if (!LogTrackManager.isCrashing())
                {
                    break label0;
                }
                errorTask.executeDelayedTask(0L, new Void[0]);
            }
            return;
        }
        errorTask.executeDelayedTask(100L, new Void[0]);
    }

    private void runTrafficReportTask(boolean flag, boolean flag1)
    {
        long l1 = System.currentTimeMillis();
        ArrayList arraylist = takePerfList();
        if (flag1 || arraylist != null)
        {
            long l;
            if (flag)
            {
                l = l1;
            } else
            {
                l = 0L;
            }
            (new TrafficTask(arraylist, new AplsReportInfo("FOREGROUND", "TRAFFIC", inForegroundAt, l, packageStartAt, l1), sessionGuid)).executeDelayedTask(0L, new Void[0]);
        }
        packageStartAt = l1;
    }

    private void scheduleNextForegroundRun(long l)
    {
        mainHandler.removeCallbacks(foregroundReporter);
        mainHandler.postDelayed(foregroundReporter, l);
    }

    public void addError(LogTrackError logtrackerror)
    {
        if (getConfig().isAplsLogErrorMessage())
        {
            if (logger.isLoggable)
            {
                logger.log((new StringBuilder()).append("Logging error data: ").append(logtrackerror.getServiceName()).append(" - ").append(logtrackerror.getOperationName()).append(" - foreground: ").append(inForegroundAt).append(" - background: ").append(inBackgroundAt).toString());
            }
            super.addError(logtrackerror);
            synchronized (lock)
            {
                runErrorTaskIfData();
            }
            return;
        } else
        {
            return;
        }
        exception;
        logtrackerror;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void addPerf(LogTrackPerf logtrackperf)
    {
        if (getConfig().isAplsTraffic())
        {
            if (logger.isLoggable)
            {
                logger.log((new StringBuilder()).append("Logging perf data: ").append(logtrackperf.getServiceName()).append(" - ").append(logtrackperf.getOperationName()).append(" - foreground: ").append(inForegroundAt).append(" - background: ").append(inBackgroundAt).toString());
            }
            super.addPerf(logtrackperf);
            if (perfListSize() >= 600)
            {
                synchronized (lock)
                {
                    if (inForegroundAt != 0L)
                    {
                        scheduleNextForegroundRun(0L);
                    }
                }
                return;
            }
        }
        break MISSING_BLOCK_LABEL_130;
        exception;
        logtrackperf;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected ArrayList buildBeacons(List list)
    {
        if (list != null && !list.isEmpty())
        {
            HashMap hashmap = new HashMap();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                AsBeacon asbeacon = ((LogTrackPerf)list.next()).getBeacon();
                if (asbeacon != null)
                {
                    AsBeacon asbeacon1 = (AsBeacon)hashmap.get(Integer.valueOf(asbeacon.id));
                    if (asbeacon1 != null)
                    {
                        asbeacon1.addMarksFrom(asbeacon);
                    } else
                    {
                        hashmap.put(Integer.valueOf(asbeacon.id), asbeacon.clone());
                    }
                }
            } while (true);
            if (hashmap.size() != 0)
            {
                return new ArrayList(hashmap.values());
            }
        }
        return null;
    }

    protected AplsClientInfo buildClientInfo(String s)
    {
        Preferences preferences = MyApp.getPrefs();
        String s1;
        EbaySite ebaysite;
        EbayAppInfo ebayappinfo;
        String s2;
        String s3;
        Context context;
        if (NautilusKernel.isQaMode())
        {
            s1 = "STAGING";
        } else
        {
            s1 = "PRODUCTION";
        }
        ebaysite = preferences.getCurrentSite();
        ebayappinfo = ebayContext.getAppInfo();
        s2 = ebayappinfo.getAppVersionBuildNumber();
        s3 = MyApp.getPrefs().getCurrentCountry().getCountryCode();
        context = (Context)ebayContext.getExtension(android/content/Context);
        return new AplsClientInfo(context, s, s1, "Mobile", ebaysite.idString, ebaysite.idInt, DeviceInfoUtil.getOsType(), android.os.Build.VERSION.RELEASE, DeviceInfoUtil.getDeviceModel(), ebayappinfo.getAppVersionWithoutBuildNumber(), s2, ebaysite.getLocale().toString(), DeviceInfoUtil.getPreferredLanguage(), preferences.getCurrentUser(), DeviceInfoUtil.getCarrier(context), s3, config.getRolloutThreshold(), getConfig().getConfigVersion());
    }

    protected ArrayList buildServices(long l, List list)
    {
        if (list == null || list.isEmpty())
        {
            return null;
        }
        HashMap hashmap = new HashMap();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LogTrackPerf logtrackperf = (LogTrackPerf)iterator.next();
            if (!logtrackperf.beaconOnly)
            {
                String s = logtrackperf.getServiceName();
                AplsService aplsservice = (AplsService)hashmap.get(s);
                list = aplsservice;
                if (aplsservice == null)
                {
                    list = new AplsService(s);
                    hashmap.put(s, list);
                }
                list.addPerf(l, logtrackperf);
            }
        } while (true);
        return new ArrayList(hashmap.values());
    }

    void handleErrorTaskComplete(ErrorTask errortask)
    {
        synchronized (lock)
        {
            errorTask = null;
            runErrorTaskIfData();
        }
        return;
        exception;
        errortask;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onBackground()
    {
        synchronized (lock)
        {
            if (inForegroundAt != 0L)
            {
                mainHandler.removeCallbacks(foregroundReporter);
                runTrafficReportTask(true, true);
                inForegroundAt = 0L;
                packageStartAt = 0L;
            }
            if (inBackgroundAt == 0L)
            {
                sessionGuid = EbayIdentity.generateEbayGuidString();
                inBackgroundAt = System.currentTimeMillis();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onForeground()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        if (inBackgroundAt == 0L)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        arraylist = takePerfList();
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        long l = System.currentTimeMillis();
        (new TrafficTask(arraylist, new AplsReportInfo("BACKGROUND", "TRAFFIC", inBackgroundAt, l, inBackgroundAt, l), sessionGuid)).executeDelayedTask(0L, new Void[0]);
        inBackgroundAt = 0L;
        if (inForegroundAt == 0L)
        {
            sessionGuid = EbayIdentity.generateEbayGuidString();
            inForegroundAt = System.currentTimeMillis();
            packageStartAt = inForegroundAt;
            scheduleNextForegroundRun(getSweepInterval());
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void register()
    {
        if (appStateReceiver != null)
        {
            throw new IllegalStateException("AplsLogTrackSweeper already registered.");
        } else
        {
            super.register();
            appStateReceiver = new ForegroundBackgroundReceiver();
            Context context = (Context)ebayContext.getExtension(android/content/Context);
            EbayBroadcast.registerReceiver(context, appStateReceiver, "com.ebay.common.intent.action.EBAY_APPBACKGROUND", 0);
            EbayBroadcast.registerReceiver(context, appStateReceiver, "com.ebay.common.intent.action.EBAY_APPFOREGROUND", 0);
            return;
        }
    }

    public void unregister()
    {
        super.unregister();
        if (appStateReceiver != null)
        {
            EbayBroadcast.unregisterReceiver((Context)ebayContext.getExtension(android/content/Context), appStateReceiver);
            appStateReceiver = null;
        }
    }












}
