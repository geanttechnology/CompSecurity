// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.TimeTracker;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.di.BeanKey;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.TruthDataMigrationUtilities;
import com.amazon.gallery.framework.data.dao.DynamicAlbumDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.GalleryDBConnectionManager;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.data.dao.sqlite.migration.TruthUploadQueueMigrationTask;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.metrics.LaunchTimeMetrics;
import com.amazon.gallery.framework.kindle.EmptyBeanFactory;
import com.amazon.gallery.framework.kindle.GalleryApplication;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.amazon.KindleFrameworkDependencyInjector;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.cms.CMSRequestHandlerWrapper;
import com.amazon.gallery.framework.kindle.cms.KindleCMSClient;
import com.amazon.gallery.framework.kindle.notifications.NewPromotionNotificationHandler;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.senna.SennaSyncListener;
import com.amazon.gallery.framework.network.intercept.AviaryNetworkInterceptor;
import com.amazon.gallery.framework.network.intercept.LocalyticsInterceptor;
import com.amazon.gallery.thor.app.authentication.AospPreferences;
import com.amazon.gallery.thor.app.service.WhisperCacheBeanService;
import com.amazon.gallery.thor.app.ui.UiReadyExecutor;
import com.amazon.gallery.thor.cds.StethoInitializer;
import com.amazon.gallery.thor.dagger.AmazonDependencyProvider;
import com.amazon.gallery.thor.dagger.ApplicationModule;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.thor.di.ApplicationBeans;
import com.amazon.gallery.thor.multidex.MultiDexSetup;
import com.amazon.gallery.thor.settings.PreferenceMigrator;
import com.amazon.gallery.thor.thisday.ThisDayAlarmManager;
import com.amazon.gallery.thor.thisday.ThisDaySharedPrefsManager;
import com.amazon.gallery.thor.thisday.ThisDayUtils;
import dagger.ObjectGraph;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.app:
//            ProcessHelper, FeatureChecker, FreeTime, ContentChangeListener, 
//            MemoryLeakDetectionHelper

public class ThorGalleryApplication extends GalleryApplication
    implements SennaSyncListener
{

    private static final String TAG = com/amazon/gallery/thor/app/ThorGalleryApplication.getName();
    protected static BeanFactory appBeans;
    private static ObjectGraph objectGraph;
    protected static ProcessHelper processHelper;
    private static boolean secondaryServicesStarted = false;
    private final int MAX_DELAY_FOR_SECONDARY_SERVICES_START_IN_SECONDS = 300;
    private boolean commonAppBeansInited;
    private final CountDownLatch firstSennaSyncLatch = new CountDownLatch(1);
    private LaunchTimeMetrics launchTimeMetrics;

    public ThorGalleryApplication()
    {
        super(appBeans);
        commonAppBeansInited = false;
        launchTimeMetrics = new LaunchTimeMetrics();
        DebugAssert.enableStrictMode();
    }

    public static Object getBean(BeanKey beankey)
    {
        return appBeans.getBean(beankey);
    }

    private void initTruthDataMigrationUtils(Context context)
    {
        if (!TruthDataMigrationUtilities.isMigrationComplete(context))
        {
            TruthDataMigrationUtilities truthdatamigrationutilities = new TruthDataMigrationUtilities(context);
            ArrayList arraylist = new ArrayList(1);
            boolean flag = (new AospPreferences(context)).getAutoSaveEnabled();
            arraylist.add(new TruthUploadQueueMigrationTask((MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO), (TagDao)getBean(Keys.TAG_DAO), flag));
            truthdatamigrationutilities.enqueuePendingDatabaseMigrationTasks(arraylist);
            putBean(Keys.TRUTH_MIGRATION_UTILS, truthdatamigrationutilities);
        }
    }

    public static void inject(Object obj)
    {
        objectGraph.inject(obj);
    }

    public static void putBean(BeanKey beankey, Object obj)
    {
        appBeans.putBean(beankey, obj);
    }

    private void scheduleSecondaryServices()
    {
        (new Thread("Secondary Services Scheduler") {

            final ThorGalleryApplication this$0;

            public void run()
            {
                try
                {
                    startPrimaryServices();
                    if (!firstSennaSyncLatch.await(300L, TimeUnit.SECONDS))
                    {
                        GLogger.w("SecondaryServicesScheduler", "Haven't get first sync notification for 300 seconds.", new Object[0]);
                    }
                }
                catch (InterruptedException interruptedexception)
                {
                    return;
                }
                startSecondaryServices();
            }

            
            {
                this$0 = ThorGalleryApplication.this;
                super(s);
            }
        }).start();
    }

    private void sleep(long l)
    {
        try
        {
            Thread.sleep(l);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Thread.currentThread().interrupt();
        }
    }

    private void startPrimaryServices()
    {
        if (((FeatureChecker)getBean(AppKeys.FEATURE_CHECKER)).hasCloudSync())
        {
            ((FreeTime)getBean(AppKeys.THOR_FREE_TIME)).syncFreeTimeAsynchronously();
        }
        asyncInit();
        NewPromotionNotificationHandler.scheduleNewPromotionCheck(this, getBeanFactory());
    }

    protected void asyncInit()
    {
        ((AmazonInsightsHelper)getBean(Keys.AMAZON_INSIGHTS_HELPER)).init();
        ((GalleryDBConnectionManager)getBean(Keys.DB_CONNECTION_MANAGER)).init();
        ((RestClient)getBean(Keys.REST_CLIENT)).init();
        ((DynamicAlbumDao)getBean(Keys.DYNAMIC_ALBUM_DAO)).reconstruct();
        ((ThisDayAlarmManager)getBean(Keys.THIS_DAY_ALARM_MANAGER)).setAlarm(com.amazon.gallery.thor.thisday.ThisDayAlarmManager.AlarmType.NOTIFICATION_ALARM, false);
        ((ThisDayAlarmManager)getBean(Keys.THIS_DAY_ALARM_MANAGER)).setAlarm(com.amazon.gallery.thor.thisday.ThisDayAlarmManager.AlarmType.PREFETCH_ALARM, false);
    }

    protected void attachBaseContext(Context context)
    {
        super.attachBaseContext(context);
        MultiDexSetup.init(this);
    }

    public LaunchTimeMetrics getLaunchTimeMetrics()
    {
        return launchTimeMetrics;
    }

    public void initCommonAppBeans()
    {
        if (commonAppBeansInited)
        {
            return;
        } else
        {
            commonAppBeansInited = true;
            ((ApplicationBeans)appBeans).initCommonAppBeans();
            new ContentChangeListener(getContentResolver(), new Handler());
            ((GalleryDownloadManager)getBean(Keys.GALLERY_DOWNLOAD_MANAGER)).init();
            return;
        }
    }

    public void onCreate()
    {
        if (processHelper.isLeakCanaryProcess())
        {
            return;
        }
        TimeTracker.log("Application.onCreate start");
        objectGraph = ObjectGraph.create(new Object[] {
            new ApplicationModule(this), new AmazonDependencyProvider()
        });
        KindleFrameworkDependencyInjector.setObjectGraph(objectGraph);
        TimeTracker.log("Dagger init completed");
        putBean(AppKeys.SENNA_SYNC_LISTENER, this);
        putBean(Keys.AMAZON_INSIGHTS_HELPER, new AmazonInsightsHelper(getApplicationContext()));
        super.onCreate();
        TimeTracker.log("ApplicationBeans init completed");
        (new AviaryNetworkInterceptor()).initialize();
        (new LocalyticsInterceptor()).initialize();
        StethoInitializer.initialize(this, (Profiler)getBean(Keys.PROFILER));
        putBean(Keys.MEMORY_LEAK_DETECTION_HELPER, new MemoryLeakDetectionHelper(this));
        if (FeatureManager.isFeatureEnabled(Features.CMS))
        {
            appBeans.putBean(Keys.CMS_REQUEST_HANDLER_FACTORY, CMSRequestHandlerWrapper.FACTORY);
            ((KindleCMSClient)getBean(Keys.KINDLE_CMS_CLIENT)).registerCallbacks((com.amazon.gallery.framework.kindle.cms.CMSRequestHandler.RequestHandlerFactory)getBean(Keys.CMS_REQUEST_HANDLER_FACTORY));
        }
        ((MediaStoreSyncProvider)getBean(Keys.MEDIA_STORE_SYNC_PROVIDER)).start();
        scheduleSecondaryServices();
        registerActivityLifecycleCallbacks((android.app.Application.ActivityLifecycleCallbacks)getBean(Keys.PROFILER_SESSION));
        PreferenceMigrator.updatePreferences(this);
        initTruthDataMigrationUtils(this);
        if (((AuthenticationManager)getBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount() && StringUtils.isEmpty((new ThisDaySharedPrefsManager(this)).getCustomerEmailAddress()))
        {
            ThisDayUtils.prefetchCustomerEmailAddress(this, (RestClient)getBean(Keys.REST_CLIENT));
        }
        TimeTracker.log("Application.onCreate finish");
    }

    public void onFirstSyncCompleted()
    {
        firstSennaSyncLatch.countDown();
    }

    protected void startSecondaryServices()
    {
        ((UiReadyExecutor)getBean(Keys.UI_READY_EXECUTOR)).execute(new Runnable() {

            final ThorGalleryApplication this$0;
            final Context val$appContext;

            public void run()
            {
                if (((FeatureChecker)ThorGalleryApplication.getBean(AppKeys.FEATURE_CHECKER)).hasCloudSync())
                {
                    sleep(5000L);
                    try
                    {
                        appContext.startService(new Intent(appContext, com/amazon/gallery/thor/app/service/WhisperCacheBeanService));
                    }
                    catch (SecurityException securityexception)
                    {
                        GLogger.ex(ThorGalleryApplication.TAG, "Failed to start WhisperCacheBeanService", securityexception);
                    }
                }
                ThorGalleryApplication.secondaryServicesStarted = true;
            }

            
            {
                this$0 = ThorGalleryApplication.this;
                appContext = context;
                super();
            }
        });
    }

    static 
    {
        processHelper = new ProcessHelper();
        if (processHelper.isLeakCanaryProcess())
        {
            appBeans = new EmptyBeanFactory();
        } else
        {
            appBeans = new ApplicationBeans();
        }
    }




/*
    static boolean access$202(boolean flag)
    {
        secondaryServicesStarted = flag;
        return flag;
    }

*/


}
