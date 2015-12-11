// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Intent;
import android.content.SharedPreferences;
import com.crittercism.app.Crittercism;
import com.google.inject.Injector;
import com.groupon.Channel;
import com.groupon.abtest.RapiAbTestHelper;
import com.groupon.db.GrouponOrmLiteHelper;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.foundations.service.BaseIntentService;
import com.groupon.manager.FeaturedSyncManager;
import com.groupon.manager.PullNotificationSyncManager;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.RapiPaginatedSyncManagerProcess;
import com.groupon.models.Place;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.receiver.DailySyncReceiver;
import com.groupon.receiver.GcmReceiver;
import com.groupon.receiver.InstallAlarms;
import com.groupon.service.core.AbTestService;
import com.groupon.service.core.CoreService;
import com.groupon.service.core.CoreServiceException;
import com.groupon.service.core.CoreServicesInitializer;
import com.groupon.service.core.listener.CoreServiceInitializerListener;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.service.startup.StartupDirector;
import com.groupon.tracking.mobile.events.GeneralEvent;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ApiRequestUtil;
import com.groupon.util.CacheUtils;
import com.groupon.util.DealCardListUtils;
import com.groupon.util.EmailSyncManager;
import com.groupon.util.GeoPoint;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.RapiRequestProperties;
import commonlib.manager.PaginatedSyncManager;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import roboguice.RoboGuice;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            GCMNotificationService

public class DailySyncService extends BaseIntentService
{
    private class DailySyncCoreServicesInitializerImpl
        implements CoreServiceInitializerListener
    {

        private final String logCategory;
        private final int logValue;
        private final CountDownLatch startupCountDownLatch;
        final DailySyncService this$0;

        public void onAllServicesRefreshCompletedSuccessfully()
        {
            startupCountDownLatch.countDown();
        }

        public void onAllServicesRefreshCompletedWithError(Collection collection)
        {
            logger.logGeneralEvent(logCategory, "suppress", (new StringBuilder()).append("startup:").append(((CoreServiceException)collection.iterator().next()).getCoreServiceClass().getSimpleName()).toString(), logValue, Logger.NULL_NST_FIELD);
            if (!InstallAlarms.installWhenException(DailySyncService.this, intent))
            {
                logger.logGeneralEvent("daily_syncer", "suppress", "too_many_retries", 1, Logger.NULL_NST_FIELD);
            }
            collection = collection.iterator();
            do
            {
                if (!collection.hasNext())
                {
                    break;
                }
                CoreServiceException coreserviceexception = (CoreServiceException)collection.next();
                if (!(coreserviceexception.getCause() instanceof IOException))
                {
                    Crittercism.logHandledException(coreserviceexception);
                    logSuppressException("startup:", coreserviceexception);
                }
            } while (true);
            error = true;
            startupCountDownLatch.countDown();
        }

        public void onServiceRefreshStarted(CoreService coreservice)
        {
        }

        public DailySyncCoreServicesInitializerImpl(CountDownLatch countdownlatch, String s, int i)
        {
            this$0 = DailySyncService.this;
            super();
            startupCountDownLatch = countdownlatch;
            logCategory = s;
            logValue = i;
        }
    }


    private static final int STARTUP_SERVICES_TIMEOUT_IN_SECONDS = 1800;
    private static final int SYNC_MANAGER_TIMEOUT_IN_SECONDS = 60;
    private static final String emailStage = "email:";
    private static final String featuredStage = "featured:";
    private static final String pullNotificationStage = "pull_notification:";
    private static final String startupStage = "startup:";
    private AbTestService abTestService;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    protected GrouponOrmLiteHelper dbHelper;
    private DealCardListUtils dealCardListUtils;
    private boolean error;
    private IncentivesUtil incentivesUtil;
    private Intent intent;
    private Logger logger;
    private SharedPreferences prefs;
    private RapiAbTestHelper rapiAbTestHelper;
    private CoreServicesInitializer serviceInitializer;
    private StartupDirector startupDirector;

    public DailySyncService()
    {
        super(com/groupon/service/DailySyncService.getSimpleName());
        error = false;
    }

    private String getLimitedStackTraceString(Throwable throwable, int i)
    {
        StringBuilder stringbuilder = new StringBuilder();
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        int k = astacktraceelement.length;
        int j = i;
        if (i == 0)
        {
            j = astacktraceelement.length;
        }
        j = Math.min(k, j);
        stringbuilder.append((new StringBuilder()).append(throwable).append("\n").toString());
        for (i = 0; i < j; i++)
        {
            stringbuilder.append((new StringBuilder()).append("\tat ").append(astacktraceelement[i]).append("\n").toString());
        }

        return stringbuilder.toString();
    }

    private void logSuppressException(String s, Exception exception)
    {
        if (exception instanceof ConnectException)
        {
            return;
        }
        String s1 = (new StringBuilder()).append(s).append(exception.getClass().getSimpleName()).toString();
        s = exception;
        if (exception.getCause() != null)
        {
            s = exception.getCause();
        }
        s = new GeneralEvent("daily_syncer_exception", s1, getLimitedStackTraceString(s, 5), 1, Logger.NULL_NST_FIELD);
        logger.log(s);
    }

    public void checkCacheBustFlagInPrefs()
    {
        if (prefs.getBoolean("clearCache", false))
        {
            Ln.d("Cache bust flag present. Clearing all data.", new Object[0]);
            serviceInitializer.resetAllServicesToNotUpToDate(new Class[0]);
            CacheUtils.clearCacheDir(this);
            dbHelper.clearCacheManagementTables();
            prefs.edit().remove("clearCache").apply();
        }
    }

    public void clearPullNotificationDownloaded()
    {
        prefs.edit().putBoolean("pullNotificationDownloaded", false).apply();
    }

    public boolean downloadAndWait(final String logCategory, final int logValue, final String processingStage, PaginatedSyncManager paginatedsyncmanager)
    {
        final boolean errors[];
        errors = new boolean[1];
        errors[0] = false;
        final CountDownLatch syncFinished = new CountDownLatch(1);
        paginatedsyncmanager.requestSync(new commonlib.manager.SyncManager.SyncUiCallbacks() {

            final DailySyncService this$0;
            final boolean val$errors[];
            final String val$logCategory;
            final int val$logValue;
            final String val$processingStage;
            final CountDownLatch val$syncFinished;

            public void enableSyncProgressIndicator(boolean flag)
            {
                if (!flag)
                {
                    syncFinished.countDown();
                }
            }

            public void handleSyncError(Runnable runnable, Exception exception)
            {
                logger.logGeneralEvent(logCategory, "suppress", (new StringBuilder()).append(processingStage).append(exception.getClass().getSimpleName()).toString(), logValue, Logger.NULL_NST_FIELD);
                logSuppressException(processingStage, exception);
                if (!InstallAlarms.installWhenException(DailySyncService.this, intent))
                {
                    logger.logGeneralEvent("daily_syncer", "suppress", "too_many_retries", 1, Logger.NULL_NST_FIELD);
                }
                errors[0] = true;
            }

            
            {
                this$0 = DailySyncService.this;
                syncFinished = countdownlatch;
                logCategory = s;
                processingStage = s1;
                logValue = i;
                errors = aflag;
                super();
            }
        }, null);
        if (syncFinished.await(60L, TimeUnit.SECONDS))
        {
            break MISSING_BLOCK_LABEL_93;
        }
        logger.logGeneralEvent(logCategory, "suppress", (new StringBuilder()).append(processingStage).append("sync_timeout").toString(), logValue, Logger.NULL_NST_FIELD);
        errors[0] = true;
_L2:
        return errors[0];
        paginatedsyncmanager;
        logger.logGeneralEvent(logCategory, "suppress", (new StringBuilder()).append(processingStage).append(paginatedsyncmanager.getClass().getSimpleName()).toString(), logValue, Logger.NULL_NST_FIELD);
        Crittercism.logHandledException(paginatedsyncmanager);
        logSuppressException(processingStage, paginatedsyncmanager);
        errors[0] = true;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void onHandleIntent(Intent intent1)
    {
        boolean flag;
        intent = intent1;
        checkCacheBustFlagInPrefs();
        flag = InstallAlarms.isRetryIntent(intent1);
        final Object logCategory;
        roboguice.inject.ContextScopedRoboInjector contextscopedroboinjector;
        final int logValue;
        if (flag)
        {
            logCategory = "daily_syncer_retry";
        } else
        {
            logCategory = "daily_syncer";
        }
        logValue = InstallAlarms.getRetryCount(intent1);
        logger.logGeneralEvent(((String) (logCategory)), "service_start", "", logValue, Logger.NULL_NST_FIELD);
        contextscopedroboinjector = RoboGuice.getInjector(this);
        if (startupDirector.areCountryAndDivisionReady())
        {
            break MISSING_BLOCK_LABEL_96;
        }
        logger.logGeneralEvent("daily_syncer", "suppress", "no_location_set", 0, Logger.NULL_NST_FIELD);
        DailySyncReceiver.completeWakefulIntent(intent1);
        return;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        clearPullNotificationDownloaded();
        if (!requiresPullNotificationDownload())
        {
            break MISSING_BLOCK_LABEL_196;
        }
        PullNotificationSyncManager pullnotificationsyncmanager = new PullNotificationSyncManager(this);
        contextscopedroboinjector.injectMembers(pullnotificationsyncmanager);
        pullnotificationsyncmanager.setNstChannel(Channel.FEATURED.toString());
        error = downloadAndWait(((String) (logCategory)), logValue, "pull_notification:", pullnotificationsyncmanager);
        flag = error;
        if (flag)
        {
            DailySyncReceiver.completeWakefulIntent(intent1);
            return;
        }
        setPullNotificationDownloaded();
        logger.logGeneralEvent(((String) (logCategory)), "progress", "completed_pull_notification_sync", logValue, Logger.NULL_NST_FIELD);
        if (!rapiAbTestHelper.isFeaturedUsingRAPI1511USCAEnabled())
        {
            break MISSING_BLOCK_LABEL_383;
        }
        String s = Channel.FEATURED.toString();
        Object obj = currentDivisionManager.getCurrentDivision().geoPoint;
        Object obj1 = new Place("", ((GeoPoint) (obj)).getLatitudeDegrees(), ((GeoPoint) (obj)).getLongitudeDegrees());
        obj = new RapiRequestProperties();
        obj.pageType = "featured";
        obj.expressedLocation = ((Place) (obj1));
        ((RapiRequestProperties) (obj)).showParams.add(ApiRequestUtil.getRapiFeaturedShowParams(incentivesUtil.isExperimentEnabled(), false));
        obj1 = new RapiPaginatedSyncManagerProcess(this, s, null);
        ((RapiPaginatedSyncManagerProcess) (obj1)).setRequestParams(((RapiRequestProperties) (obj)));
        obj = new UniversalSyncManager(this);
        contextscopedroboinjector.injectMembers(obj);
        ((UniversalSyncManager) (obj)).configurePaginatedSyncManager(((com.groupon.manager.sync_process.AbstractPaginatedSyncManagerProcess) (obj1)), null, new UniversalUpdateEvent(s));
        error = downloadAndWait(((String) (logCategory)), logValue, "featured:", ((PaginatedSyncManager) (obj)));
_L1:
        flag = error;
        if (flag)
        {
            DailySyncReceiver.completeWakefulIntent(intent1);
            return;
        }
        break MISSING_BLOCK_LABEL_462;
        FeaturedSyncManager featuredsyncmanager = new FeaturedSyncManager(this);
        contextscopedroboinjector.injectMembers(featuredsyncmanager);
        featuredsyncmanager.setNstChannel(Channel.FEATURED.toString());
        featuredsyncmanager.setFirstPageSize(dealCardListUtils.getFirstPageSize());
        featuredsyncmanager.setSubsequencePageSize(dealCardListUtils.getSubsequencePageSize());
        error = downloadAndWait(((String) (logCategory)), logValue, "featured:", featuredsyncmanager);
          goto _L1
        logCategory;
        DailySyncReceiver.completeWakefulIntent(intent1);
        throw logCategory;
        DailySyncCoreServicesInitializerImpl dailysynccoreservicesinitializerimpl;
        CountDownLatch countdownlatch;
        logger.logGeneralEvent(((String) (logCategory)), "progress", "completed_featured_sync", logValue, Logger.NULL_NST_FIELD);
        countdownlatch = new CountDownLatch(1);
        dailysynccoreservicesinitializerimpl = new DailySyncCoreServicesInitializerImpl(countdownlatch, ((String) (logCategory)), logValue);
        startupDirector.addCoreServicesInitializerListener(dailysynccoreservicesinitializerimpl);
        startupDirector.startupCoreServices();
        if (!countdownlatch.await(1800L, TimeUnit.SECONDS))
        {
            logger.logGeneralEvent(((String) (logCategory)), "suppress", "startup:sync_timeout", logValue, Logger.NULL_NST_FIELD);
            error = true;
        }
        startupDirector.removeCoreServicesInitializerListener(dailysynccoreservicesinitializerimpl);
_L2:
        flag = error;
        if (flag)
        {
            DailySyncReceiver.completeWakefulIntent(intent1);
            return;
        }
        break MISSING_BLOCK_LABEL_670;
        Exception exception1;
        exception1;
        logger.logGeneralEvent(((String) (logCategory)), "suppress", (new StringBuilder()).append("startup:").append(exception1.getClass().getSimpleName()).toString(), logValue, Logger.NULL_NST_FIELD);
        Crittercism.logHandledException(exception1);
        logSuppressException("startup:", exception1);
        error = true;
        startupDirector.removeCoreServicesInitializerListener(dailysynccoreservicesinitializerimpl);
          goto _L2
        logCategory;
        startupDirector.removeCoreServicesInitializerListener(dailysynccoreservicesinitializerimpl);
        throw logCategory;
        logger.logGeneralEvent(((String) (logCategory)), "progress", "completed_startup_sync", logValue, Logger.NULL_NST_FIELD);
        final CountDownLatch syncFinished = new CountDownLatch(1);
        EmailSyncManager emailsyncmanager = new EmailSyncManager(this);
        contextscopedroboinjector.injectMembers(emailsyncmanager);
        emailsyncmanager.requestSync(new commonlib.manager.SyncManager.SyncUiCallbacks() {

            final DailySyncService this$0;
            final String val$logCategory;
            final int val$logValue;
            final CountDownLatch val$syncFinished;

            public void enableSyncProgressIndicator(boolean flag1)
            {
                if (!flag1)
                {
                    syncFinished.countDown();
                }
            }

            public void handleSyncError(Runnable runnable, Exception exception2)
            {
                logger.logGeneralEvent(logCategory, "suppress", (new StringBuilder()).append("email:").append(exception2.getClass().getSimpleName()).toString(), logValue, Logger.NULL_NST_FIELD);
                logSuppressException("email:", exception2);
                error = true;
            }

            
            {
                this$0 = DailySyncService.this;
                syncFinished = countdownlatch;
                logCategory = s;
                logValue = i;
                super();
            }
        }, null);
        if (!syncFinished.await(60L, TimeUnit.SECONDS))
        {
            logger.logGeneralEvent(((String) (logCategory)), "suppress", "email:sync_timeout", logValue, Logger.NULL_NST_FIELD);
            error = true;
        }
_L3:
        flag = error;
        if (flag)
        {
            DailySyncReceiver.completeWakefulIntent(intent1);
            return;
        }
        break MISSING_BLOCK_LABEL_850;
        Exception exception;
        exception;
        logger.logGeneralEvent(((String) (logCategory)), "suppress", (new StringBuilder()).append("email:").append(exception.getClass().getSimpleName()).toString(), logValue, Logger.NULL_NST_FIELD);
        Crittercism.logHandledException(exception);
        logSuppressException("email:", exception);
        error = true;
          goto _L3
        logger.logGeneralEvent(((String) (logCategory)), "success", "", logValue, Logger.NULL_NST_FIELD);
        GcmReceiver.startWakefulService(this, (new Intent(this, com/groupon/service/GCMNotificationService)).setAction("com.groupon.REGISTER"));
        DailySyncReceiver.completeWakefulIntent(intent1);
        return;
    }

    public boolean requiresPullNotificationDownload()
    {
        boolean flag;
        if (!currentCountryManager.getCurrentCountry().isUSACompatible() || !Strings.equalsIgnoreCase(abTestService.getVariant("newEnableDailyServerPushNotifications1510USCA"), "on"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && !prefs.getBoolean("pullNotificationDownloaded", true);
    }

    public void setPullNotificationDownloaded()
    {
        prefs.edit().putBoolean("pullNotificationDownloaded", true).apply();
    }




/*
    static boolean access$202(DailySyncService dailysyncservice, boolean flag)
    {
        dailysyncservice.error = flag;
        return flag;
    }

*/

}
