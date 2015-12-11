// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.webkit.CookieManager;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.analytics.MimsUtil;
import com.ebay.common.content.EbayBroadcast;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.net.api.usage.Usage;
import com.ebay.common.util.ImageCache;
import com.ebay.common.util.LruHistoryCache;
import com.ebay.common.util.SdCardLogger;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.activities.SignInActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.analytics.AnalyticsUtil;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.apls.AplsLogTrackSweeper;
import com.ebay.mobile.appspeed.AppSpeedShim;
import com.ebay.mobile.cal.CalMessageLogger;
import com.ebay.mobile.crashlytics.CrashlyticsWrapper;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.notifications.EbayNotificationManager;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.search.LruVisitedItemCache;
import com.ebay.mobile.service.AppForegroundService;
import com.ebay.mobile.service.GoogleNowAuthenticationService;
import com.ebay.mobile.service.PreferenceSyncService;
import com.ebay.mobile.sitespeed.SiteSpeedActivityUtil;
import com.ebay.mobile.ui_stuff.samsungbadger.Badge;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ImageCacheConfiguration;
import com.ebay.mobile.util.LocationUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.ServiceContentOverride;
import com.ebay.nautilus.domain.content.dm.UserContext;
import com.ebay.nautilus.domain.content.dm.listingdraft.ListingDraftPreferences;
import com.ebay.nautilus.domain.data.SiteSpeedData;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.LogglyLogTrackSweeper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.AsBeaconManager;
import com.ebay.nautilus.kernel.net.AsMark;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.LogTrackManager;
import com.ebay.nautilus.kernel.net.RequestLoggerFactory;
import com.ebay.nautilus.kernel.test.utils.TestSharedPreferences;
import com.ebay.nautilus.shell.app.ActivityShim;
import com.ebay.nautilus.shell.app.ActivityShimManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile:
//            eBayDictionaryProvider, ServiceStarter, AppForegroundShim, DysonUpdateShim, 
//            RateThisAppDialogFragment, AppContext, AppSettings, StrictModeCompat, 
//            TestOverride

public class MyApp extends Application
    implements com.ebay.nautilus.shell.app.ActivityShimManager.InitUiCallback
{
    public static class AppGlobalUncaughtExceptionHandler
        implements Thread.UncaughtExceptionHandler
    {

        private volatile boolean handled;
        private volatile Thread.UncaughtExceptionHandler previous;

        public void attach()
        {
            previous = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            if (!handled)
            {
                handled = true;
                try
                {
                    LogTrackManager.setCrashing();
                    LogTrackManager.addLogErrorData(new LogTrackError("Application", "crash", null, null, "Application", "CrashError", throwable));
                }
                catch (Throwable throwable1)
                {
                    throwable1.printStackTrace();
                }
                previous.uncaughtException(thread, throwable);
            }
        }

        public AppGlobalUncaughtExceptionHandler()
        {
        }
    }

    private final class DcsRefreshObserver extends DataSetObserver
    {

        final MyApp this$0;

        public void onChanged()
        {
            AnalyticsUtil.setEnabledProviders();
            ServiceStarter.instructNotificationManagerService(MyApp.this, 11);
        }

        private DcsRefreshObserver()
        {
            this$0 = MyApp.this;
            super();
        }

    }

    private final class InitializationHelper
        implements TestOverride.TestHelper, com.ebay.nautilus.domain.dcs.DeviceConfiguration.ApplicationHelper
    {

        private SharedPreferences listingDraftPrefs;
        private SharedPreferences prefs;
        final MyApp this$0;

        public void disableDeveloperOptions()
        {
            MyApp.getPrefs().removeGlobalPref("developerOptions");
        }

        public EbayCountry getCurrentCountry()
        {
            return EbayApiUtil.getCurrentCountry();
        }

        public void initTestFramework()
        {
            prefs = new TestSharedPreferences();
            m_prefs = new Preferences(prefs);
            listingDraftPrefs = new TestSharedPreferences();
            ListingDraftPreferences.setTestingFrameworkPreferences(listingDraftPrefs);
            aplsSweeper.unregister();
            RequestLoggerFactory.remove(MyApp.calMessageLogger);
        }

        public void setUpTest()
        {
            prefs.edit().clear().apply();
            listingDraftPrefs.edit().clear().apply();
        }

        public void tearDownTest()
        {
            prefs.edit().clear().apply();
            listingDraftPrefs.edit().clear().apply();
        }

        private InitializationHelper()
        {
            this$0 = MyApp.this;
            super();
        }

    }

    public static class InvertThemeShim extends QaThemeShim
    {

        public static void debugInvertTheme(Context context, boolean flag)
        {
            throw new RuntimeException("This is for debug only!");
        }

        protected void preOnCreate(Bundle bundle)
        {
            bundle = getActivity();
            bundle.getPackageManager().getActivityInfo(new ComponentName(bundle, bundle.getClass()), 0).theme;
            JVM INSTR lookupswitch 12: default 177
        //                       0: 136
        //                       16973939: 163
        //                       2131361835: 136
        //                       2131361924: 149
        //                       2131361925: 156
        //                       2131361974: 163
        //                       2131362426: 163
        //                       2131362430: 163
        //                       2131362432: 136
        //                       2131362436: 149
        //                       2131362437: 156
        //                       2131362438: 170;
               goto _L1 _L2 _L3 _L2 _L4 _L5 _L3 _L3 _L3 _L2 _L4 _L5 _L6
_L2:
            bundle.setTheme(0x7f0a026a);
            return;
_L4:
            try
            {
                bundle.setTheme(0x7f0a0288);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
                return;
            }
_L5:
            bundle.setTheme(0x7f0a0289);
            return;
_L3:
            bundle.setTheme(0x7f0a027b);
            return;
_L6:
            bundle.setTheme(0x103006b);
            return;
_L1:
        }

        public InvertThemeShim()
        {
        }
    }

    public static class InvertThemeShim.Qa extends InvertThemeShim
    {

        protected void preOnCreate(Bundle bundle)
        {
            Activity activity = getActivity();
            activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0).theme;
            JVM INSTR lookupswitch 3: default 83
        //                       0: 70
        //                       2131361835: 70
        //                       2131362432: 70;
               goto _L1 _L2 _L2 _L2
_L1:
            super.preOnCreate(bundle);
            return;
_L2:
            try
            {
                activity.setTheme(0x7f0a028a);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
            return;
        }

        public InvertThemeShim.Qa()
        {
        }
    }

    public static class QaThemeShim extends ActivityShim
    {

        public static void init(Context context)
        {
            if (NautilusKernel.isQaMode())
            {
                context = context.getApplicationInfo();
                if (((ApplicationInfo) (context)).theme == 0x7f0a002b || ((ApplicationInfo) (context)).theme == 0x7f0a0084)
                {
                    ActivityShimManager.addActivityShimClass(com/ebay/mobile/MyApp$QaThemeShim);
                }
            }
        }

        protected void preOnCreate(Bundle bundle)
        {
            bundle = getActivity();
            bundle.getPackageManager().getActivityInfo(new ComponentName(bundle, bundle.getClass()), 0).theme;
            JVM INSTR lookupswitch 3: default 84
        //                       0: 64
        //                       2131361835: 64
        //                       2131361924: 77;
               goto _L1 _L2 _L2 _L3
_L2:
            bundle.setTheme(0x7f0a0088);
            return;
_L3:
            try
            {
                bundle.setTheme(0x7f0a0089);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
                return;
            }
_L1:
        }

        public QaThemeShim()
        {
        }
    }


    private static final CalMessageLogger calMessageLogger = new CalMessageLogger();
    private static final Handler handler = new Handler();
    private static String logTag = com/ebay/mobile/MyApp.getSimpleName();
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logToSdCard = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("eBaySdCard", 3, "Log to SD Card");
    private static DcsHelper m_deviceConfig;
    private static MyApp m_myself = null;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo strictMode = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("eBayStrictMode", 3, "Log StrictMode violations");
    private AplsLogTrackSweeper aplsSweeper;
    private EbayContext baseEbayContext;
    private Preferences m_prefs;

    public MyApp()
    {
        m_prefs = null;
    }

    private boolean forceUseQaServers()
    {
        return (new File(getFilesDir(), "DebugSettings")).isFile();
    }

    public static MyApp getApp()
    {
        return m_myself;
    }

    public static String getCurrentSite()
    {
        return m_myself.m_prefs.getCurrentSite().id;
    }

    public static DcsHelper getDeviceConfiguration()
    {
        m_deviceConfig.refresh();
        return m_deviceConfig;
    }

    public static String getDisplayableServiceError(EbayContext ebaycontext, EbaySimpleNetLoader ebaysimplenetloader)
    {
        return getDisplayableServiceError(ebaycontext, ebaysimplenetloader.getResultStatus());
    }

    public static String getDisplayableServiceError(EbayContext ebaycontext, ResultStatus resultstatus)
    {
        String s = "";
        if (resultstatus.hasError())
        {
            s = ResultStatus.getSafeLongMessage(ebaycontext, resultstatus.getFirstError());
        } else
        if (resultstatus.hasWarning())
        {
            StringBuilder stringbuilder = new StringBuilder();
            boolean flag = true;
            for (resultstatus = resultstatus.getMessages().iterator(); resultstatus.hasNext();)
            {
                com.ebay.nautilus.kernel.content.ResultStatus.Message message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)resultstatus.next();
                if (flag)
                {
                    stringbuilder.append(getMessageFromResponseError(ebaycontext, message));
                    flag = false;
                } else
                if (message.displayToUser())
                {
                    stringbuilder.append('\n').append(ebaycontext.getString(0x7f070a4e, new Object[] {
                        Integer.valueOf(message.getId()), ResultStatus.getSafeLongMessage(ebaycontext, message)
                    }));
                } else
                {
                    stringbuilder.append('\n').append(ebaycontext.getString(0x7f070a4d, new Object[] {
                        Integer.valueOf(message.getId())
                    }));
                }
            }

            return stringbuilder.toString();
        }
        return s;
    }

    public static String getMaintenanceTitle(Context context)
    {
        if (getDeviceConfiguration().isMaintenanceWindow())
        {
            return context.getString(0x7f0705fd);
        } else
        {
            return null;
        }
    }

    public static String getMessageFromResponseError(EbayContext ebaycontext, com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        String s = ResultStatus.getSafeLongMessage(ebaycontext, message);
        if (EbayTradingApi.errorCodeRepresentsCongestion(message.getId()))
        {
            s = ebaycontext.getString(0x7f07014c);
        }
        return s;
    }

    public static Preferences getPrefs()
    {
        return m_myself.m_prefs;
    }

    public static int getVersionCode(Context context)
    {
        context = context.getPackageManager();
        int i;
        try
        {
            i = context.getPackageInfo("com.ebay.mobile", 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return -1;
        }
        return i;
    }

    public static boolean isInForeground(Context context)
    {
        for (context = ((ActivityManager)context.getSystemService("activity")).getRunningServices(0x7fffffff).iterator(); context.hasNext();)
        {
            android.app.ActivityManager.RunningServiceInfo runningserviceinfo = (android.app.ActivityManager.RunningServiceInfo)context.next();
            if (com/ebay/mobile/service/AppForegroundService.getName().equals(runningserviceinfo.service.getClassName()))
            {
                return true;
            }
        }

        return false;
    }

    private static void log(String s)
    {
        Log.v(logTag, s);
    }

    public static void setAppBadgeCount(int i)
    {
        if (!DeviceConfiguration.getAsync().get(DcsBoolean.showLauncherAppBadge))
        {
            return;
        } else
        {
            (new AsyncTask(i) {

                final int val$value;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    avoid = MyApp.getApp();
                    if (avoid != null && Badge.isBadgingSupported(avoid))
                    {
                        String s = avoid.getPackageName();
                        String s1 = com/ebay/mobile/activities/eBay.getName();
                        Badge badge = Badge.getBadge(avoid);
                        if (badge == null)
                        {
                            badge = new Badge();
                            badge.mPackage = s;
                            badge.mClass = s1;
                            badge.mBadgeCount = value;
                            badge.save(avoid);
                        } else
                        {
                            badge.mPackage = s;
                            badge.mClass = s1;
                            badge.mBadgeCount = value;
                            badge.update(avoid);
                        }
                    }
                    return null;
                }

            
            {
                value = i;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public static void signOut(boolean flag)
    {
        MyEbayLandingActivity.deleteUserPreferences();
        MyApp myapp = getApp();
        eBayDictionaryProvider.clearHistory(myapp);
        LruVisitedItemCache.get().clear();
        Object obj = new Bundle();
        if (!flag)
        {
            ((Bundle) (obj)).putParcelable("authCore", getPrefs().getAuthentication());
        }
        ServiceStarter.instructNotificationManagerService(myapp, 12, ((Bundle) (obj)));
        GoogleNowAuthenticationService.stop(myapp, getPrefs().getAuthentication());
        obj = (UserContext)myapp.baseEbayContext.getExtension(com/ebay/nautilus/domain/content/dm/UserContext);
        if (Looper.getMainLooper() != Looper.myLooper())
        {
            obj = new Runnable(((UserContext) (obj))) {

                final UserContext val$userContext;

                public void run()
                {
                    userContext.signOutCurrentUser();
                }

            
            {
                userContext = usercontext;
                super();
            }
            };
            handler.post(((Runnable) (obj)));
        } else
        {
            ((UserContext) (obj)).signOutCurrentUser();
        }
        UserCache.clearDetailsForLogout();
        ServiceContentOverride.clear();
        (new EbayNotificationManager(myapp, myapp.baseEbayContext)).cancelAllNotifications();
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            CookieManager.getInstance().removeAllCookies(null);
        } else
        {
            CookieManager.getInstance().removeAllCookie();
        }
        CrashlyticsWrapper.updateMetadata(myapp);
        obj = new TrackingData("UserSignOut", TrackingType.EVENT);
        if (flag)
        {
            ((TrackingData) (obj)).addKeyValuePair("sor", "iaf");
        } else
        {
            ((TrackingData) (obj)).addKeyValuePair("sor", "user");
        }
        ((TrackingData) (obj)).send(myapp.baseEbayContext);
    }

    public static void signOutForIafTokenFailure(Activity activity)
    {
        signOut(true);
        MyApp myapp = getApp();
        (new EbayNotificationManager(myapp, myapp.baseEbayContext)).createUserLoggedOutNotification();
        if (activity != null)
        {
            Class class1 = activity.getClass();
            if (class1 != com/ebay/mobile/activities/SignInActivity && class1 != com/ebay/mobile/activities/SignInModalActivity)
            {
                eBay.Restart(activity);
            }
        }
    }

    public void initForUi()
    {
        ActivityShimManager.addActivityShimClass(com/ebay/mobile/appspeed/AppSpeedShim);
        QaThemeShim.init(this);
        ActivityShimManager.addActivityShimClass(com/ebay/mobile/sitespeed/SiteSpeedActivityUtil);
        ActivityShimManager.addActivityShimClass(com/ebay/mobile/AppForegroundShim);
        ActivityShimManager.addActivityShimClass(com/ebay/common/view/util/DialogManager);
        ActivityShimManager.addActivityShimClass(com/ebay/mobile/dcs/DcsHelper$KillSwitch);
        ActivityShimManager.addActivityShimClass(com/ebay/mobile/DysonUpdateShim);
        ActivityShimManager.addActivityShimClass(com/ebay/mobile/crashlytics/CrashlyticsWrapper);
        ImageCache.init(new ImageCacheConfiguration(this));
        Authentication authentication = m_prefs.getAuthentication();
        if (authentication != null)
        {
            startService((new Intent(this, com/ebay/mobile/service/PreferenceSyncService)).setAction("com.ebay.mobile.service.PreferenceSyncService.updatePrefsAll"));
            sendBroadcast(new Intent("com.ebay.mobile.APPLICATION_LAUNCH"));
            MimsUtil.addIdentity(MimsUtil.PROVIDER_ID_MARKETPLACE, authentication.user);
        }
        EbayBroadcast.sendBroadcast(this, new Intent("com.ebay.common.intent.action.EBAY_UI_INITIALIZED"));
        LocationUtil.primeLastLocationFromNetwork(this);
    }

    public void onApplicationUpgrade(int i, int j)
    {
        if (j == i)
        {
            return;
        }
        RateThisAppDialogFragment.cleanupRateAppPreferences();
        if (j >= 74)
        {
            m_prefs.removeUserPref("rateAppSkipCount");
            m_prefs.removeUserPref("rateAppBannerStart");
        }
        if (i == 27)
        {
            m_prefs.removeGlobalPref("appUpgraded");
            m_prefs.removeGlobalPref("preference_paypal_account");
        }
        if (i < 70)
        {
            m_prefs.setCguid(true, null);
        }
        if (i == 70 || i == 71)
        {
            GoogleNowAuthenticationService.stop(this, m_prefs.getAuthentication());
        }
        m_prefs.setGlobalPref(j, "installedVersionCode");
        m_prefs.removeUserPref("eulaBannerDismissedPre");
        m_prefs.removeUserPref("eulaBannerDismissedPost");
    }

    public void onCreate()
    {
        super.onCreate();
        (new AppGlobalUncaughtExceptionHandler()).attach();
        AppContext appcontext = new AppContext(this);
        baseEbayContext = appcontext;
        if (forceUseQaServers())
        {
            NautilusKernel.forceQaMode();
        }
        m_myself = this;
        m_prefs = new Preferences(getBaseContext(), NautilusKernel.isQaMode());
        int i = getVersionCode(this);
        String s;
        AsBeaconManager asbeaconmanager;
        com.ebay.nautilus.kernel.net.AsBeacon asbeacon;
        AsMark asmark;
        SiteSpeedData sitespeeddata;
        Object obj;
        boolean flag;
        boolean flag1;
        if (m_prefs.getGlobalPref("installedVersionCode", -1) == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            m_prefs.setGlobalPref(i, "installedVersionCode");
        }
        onApplicationUpgrade(m_prefs.getGlobalPref("installedVersionCode", -1), i);
        asbeaconmanager = (AsBeaconManager)appcontext.getExtension(com/ebay/nautilus/kernel/net/AsBeaconManager);
        if (flag)
        {
            s = "FirstLaunch";
        } else
        {
            s = "Launch";
        }
        asbeacon = asbeaconmanager.createCurrentBeacon(s, getPrefs().getCurrentCountry().getCountryCode(), AppSpeedShim.deriveBeaconTags(this), Process.getElapsedCpuTime());
        asmark = new AsMark(com.ebay.nautilus.kernel.net.AsMark.AsMarkName.activity_start);
        obj = m_prefs.getAuthentication();
        if (obj != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        sitespeeddata = new SiteSpeedData("Launch", flag1, m_prefs.getCurrentCountryIfSet());
        sitespeeddata.adjustTimeBaseToElapsedCpu();
        sitespeeddata.viewAppeared();
        m_prefs.setLastHomeChannel(0x7fffffff);
        s = null;
        if (obj != null)
        {
            s = ((Authentication) (obj)).user;
        }
        obj = new InitializationHelper();
        DeviceConfiguration.init(this, appcontext, ((com.ebay.nautilus.domain.dcs.DeviceConfiguration.ApplicationHelper) (obj)), s);
        m_deviceConfig = new DcsHelper(this);
        if (m_prefs.getGlobalPref("developerOptions", false) || Log.isLoggable("eBayDevOptions", 3))
        {
            DeviceConfiguration.getNoSync().developerOptionsEnabled(true);
        }
        AppSettings.init(this);
        LogTrackManager.registerConfig(m_deviceConfig);
        aplsSweeper = new AplsLogTrackSweeper(appcontext);
        aplsSweeper.register();
        if (Log.isLoggable("UseLoggly", 3))
        {
            (new LogglyLogTrackSweeper(appcontext)).register();
        }
        ActivityShimManager.setInitUiCallback(this);
        RequestLoggerFactory.add(calMessageLogger);
        if (strictMode.isLoggable)
        {
            StrictModeCompat.enable();
        }
        if (logToSdCard.isLoggable)
        {
            SdCardLogger.initialize();
        }
        Usage.init(this);
        AnalyticsUtil.setEnabledProviders();
        (new NotificationPreferenceManager(this)).onApplicationUpgradeBackground(i);
        DeviceConfiguration.registerObserver(new DcsRefreshObserver());
        sitespeeddata.primaryLoaded();
        sitespeeddata.allLoaded();
        sitespeeddata.upload(appcontext);
        asbeaconmanager.addMark(asbeacon, asmark);
        asbeaconmanager.addMark(asbeacon, new AsMark(com.ebay.nautilus.kernel.net.AsMark.AsMarkName.activity_closed));
        asbeaconmanager.retireBeacon(asbeacon);
        TestOverride.setTestHelper(((TestOverride.TestHelper) (obj)));
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        log("onLowMemory called");
        ActivityManager activitymanager = (ActivityManager)getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        activitymanager.getMemoryInfo(memoryinfo);
        log((new StringBuilder()).append("available memory: ").append(memoryinfo.availMem).toString());
        log((new StringBuilder()).append("low mem threshold: ").append(memoryinfo.threshold).toString());
        log((new StringBuilder()).append("is low memory: ").append(memoryinfo.lowMemory).toString());
    }

    public void onTerminate()
    {
        log("MyApp.onTerminate <<<<<<<<<<<<<<<<<<<<<<<");
        m_myself = null;
        super.onTerminate();
    }



/*
    static Preferences access$202(MyApp myapp, Preferences preferences)
    {
        myapp.m_prefs = preferences;
        return preferences;
    }

*/


}
