// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import android.app.AlarmManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.SystemClock;
import com.crittercism.app.Crittercism;
import com.crittercism.app.CrittercismConfig;
import com.facebook.FacebookSdk;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Stage;
import com.google.inject.name.Names;
import com.groupon.activity.FacebookAppUtils;
import com.groupon.callbacks.UIStateActivityLifecycleCallback;
import com.groupon.cookies.CookieFactory;
import com.groupon.db.GrouponOrmLiteHelper;
import com.groupon.getaways.search.GetawaysSearchModule;
import com.groupon.models.StartupContext;
import com.groupon.receiver.InstallAlarms;
import com.groupon.receiver.PullNotificationReceiver;
import com.groupon.service.PurgeItemsService;
import com.groupon.service.cachebust.EmergencyDialogDisplayManager;
import com.groupon.service.core.CoreServicesInitializer;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.tracking.mobile.sdk.LoggingModule;
import com.groupon.tracking.mobile.sdk.NoScheduledUploadLogger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CacheUtils;
import com.groupon.util.GoogleNowAuthAlarmUtil;
import com.groupon.util.MarkUsedAlarmUtil;
import com.littlefluffytoys.littlefluffylocationlibrary.LocationLibrary;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon:
//            GrouponApplicationParent, GrouponModule

public class GrouponApplication extends GrouponApplicationParent
{

    private static final String FACEBOOK_APP_VERSION = "facebookAppVersion";
    private static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    public static final int MARK_USED_GROUPON_ALARM_INTERVAL = 12;
    public static final int MARK_USED_GROUPON_ALARM_TRIGGER_DELAY = 1;
    public static final StartupContext startupContext = new StartupContext();
    private MarkUsedAlarmUtil markUsedAlarmUtil;
    private long startTime;

    public GrouponApplication()
    {
        markUsedAlarmUtil = new MarkUsedAlarmUtil();
        init();
    }

    public GrouponApplication(Context context)
    {
        this();
        attachBaseContext(context);
    }

    private void checkCacheBustFlag(Injector injector)
    {
        ArraySharedPreferences arraysharedpreferences = (ArraySharedPreferences)injector.getInstance(Key.get(com/groupon/util/ArraySharedPreferences, Names.named("cacheBust")));
        if (arraysharedpreferences.getBoolean("clearCache", false))
        {
            clearCachesAndDatabases(injector);
            injector = arraysharedpreferences.edit();
            injector.remove("clearCache");
            injector.apply();
        }
    }

    private void clearCachesAndDatabases(Injector injector)
    {
        ((CoreServicesInitializer)injector.getInstance(com/groupon/service/core/CoreServicesInitializer)).resetAllServicesToNotUpToDate(new Class[0]);
        CacheUtils.clearCacheDir(this);
        ((GrouponOrmLiteHelper)injector.getInstance(com/groupon/db/GrouponOrmLiteHelper)).clearCacheManagementTables();
    }

    private void init()
    {
        System.setProperty("com.j256.ormlite.logger.level", com.j256.ormlite.logger.Log.Level.INFO.name());
        startTime = SystemClock.elapsedRealtime() - Process.getElapsedCpuTime();
        Ln.d("GrouponApplication()", new Object[0]);
    }

    public static void purgeItemsSetup(Context context)
    {
        if (!PurgeItemsService.isAlarmSet(context))
        {
            AlarmManager alarmmanager = (AlarmManager)context.getSystemService("alarm");
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 1);
            calendar.set(12, (new Random()).nextInt(60));
            calendar.add(10, (new Random()).nextInt(2));
            if (calendar.getTime().before(new Date()))
            {
                calendar.add(7, 1);
            }
            Ln.i("Will schedule purge items for %s", new Object[] {
                calendar.getTime()
            });
            alarmmanager.setRepeating(0, calendar.getTimeInMillis(), 0x5265c00L, PurgeItemsService.getIntentForAppCreate(context));
        }
    }

    public static void refreshLocalNotificationSetup(Context context)
    {
        SharedPreferences sharedpreferences = (SharedPreferences)RoboGuice.getInjector(context).getInstance(android/content/SharedPreferences);
        Object obj = sharedpreferences.getString("notificationTime", null);
        AlarmManager alarmmanager;
        int i;
        int j;
        if (Strings.isEmpty(obj))
        {
            j = (new Random()).nextInt(30);
            i = 9;
            obj = String.format("%02d:%02d", new Object[] {
                Integer.valueOf(9), Integer.valueOf(j)
            });
        } else
        {
            String as[] = ((String) (obj)).split(":");
            i = Integer.parseInt(as[0]);
            j = Integer.parseInt(as[1]);
        }
        alarmmanager = (AlarmManager)context.getSystemService("alarm");
        Ln.i("Setting notification time to %s", new Object[] {
            obj
        });
        sharedpreferences.edit().putString("notificationTime", ((String) (obj))).apply();
        obj = Calendar.getInstance();
        ((Calendar) (obj)).set(11, i);
        ((Calendar) (obj)).set(12, j);
        if (((Calendar) (obj)).getTime().before(new Date()))
        {
            ((Calendar) (obj)).add(7, 1);
        }
        alarmmanager.setRepeating(0, ((Calendar) (obj)).getTimeInMillis(), 0x5265c00L, PullNotificationReceiver.getIntentForAppCreate(context));
        Ln.i("Will schedule notification of daily deal for %s", new Object[] {
            ((Calendar) (obj)).getTime()
        });
    }

    public static void refreshLocalNotificationSetupIfNoPullNotificationAlarmSet(Context context)
    {
        if (!PullNotificationReceiver.isAlarmSet(context))
        {
            refreshLocalNotificationSetup(context);
        }
    }

    public static Injector setGrouponApplicationInjector(Application application)
    {
        return RoboGuice.getOrCreateBaseApplicationInjector(application, Stage.DEVELOPMENT, new Module[] {
            RoboGuice.newDefaultRoboModule(application), new LoggingModule(), new GrouponModule(application), new GetawaysSearchModule()
        });
    }

    public static transient Injector setGrouponApplicationInjector(Application application, Module amodule[])
    {
        return RoboGuice.getOrCreateBaseApplicationInjector(application, Stage.DEVELOPMENT, amodule);
    }

    private void setUpCrittercism(Injector injector)
    {
        Crittercism.setUsername(((CookieFactory)injector.getInstance(com/groupon/cookies/CookieFactory)).getBrowserCookie());
        injector = new JSONObject();
        injector.put("facebookAppVersion", getPackageManager().getPackageInfo("com.facebook.katana", 0).versionName);
        if (injector.length() > 0)
        {
            Crittercism.setMetadata(injector);
        }
_L2:
        return;
        Object obj;
        obj;
        throw new RuntimeException(((Throwable) (obj)));
        obj;
        if (injector.length() > 0)
        {
            Crittercism.setMetadata(injector);
        }
        throw obj;
        obj;
        Ln.d((new StringBuilder()).append("Facebook not installed: ").append(obj).toString(), new Object[0]);
        if (injector.length() > 0)
        {
            Crittercism.setMetadata(injector);
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onCreate()
    {
        long l = SystemClock.elapsedRealtime();
        Object obj = new CrittercismConfig();
        ((CrittercismConfig) (obj)).setLogcatReportingEnabled(true);
        ((CrittercismConfig) (obj)).setOptmzEnabled(true);
        Crittercism.initialize(getApplicationContext(), "509012de01ed850321000008", ((CrittercismConfig) (obj)));
        obj = setGrouponApplicationInjector(this);
        setUpCrittercism(((Injector) (obj)));
        FacebookSdk.setApplicationId(((FacebookAppUtils)RoboGuice.getInjector(getApplicationContext()).getInstance(com/groupon/activity/FacebookAppUtils)).getFacebookAppId());
        FacebookSdk.setLegacyTokenUpgradeSupported(true);
        FacebookSdk.sdkInitialize(getApplicationContext(), 30000);
        ((NoScheduledUploadLogger)((Injector) (obj)).getInstance(com/groupon/tracking/mobile/sdk/NoScheduledUploadLogger)).logGeneralEvent("process", "startup", Strings.toString(Long.valueOf(startTime)), 0, Logger.NULL_NST_FIELD);
        refreshLocalNotificationSetupIfNoPullNotificationAlarmSet(this);
        purgeItemsSetup(this);
        InstallAlarms.install(this);
        markUsedAlarmUtil.setUpAlarmIfNotSet(this, 1L, 12L);
        ((GoogleNowAuthAlarmUtil)((Injector) (obj)).getInstance(com/groupon/util/GoogleNowAuthAlarmUtil)).setUpAlarmIfNotSet();
        LocationLibrary.initialiseLibrary(this, getPackageName());
        registerActivityLifecycleCallbacks(new UIStateActivityLifecycleCallback((EmergencyDialogDisplayManager)((Injector) (obj)).getInstance(com/groupon/service/cachebust/EmergencyDialogDisplayManager)));
        checkCacheBustFlag(((Injector) (obj)));
        startupContext.applicationStartDuration = SystemClock.elapsedRealtime() - l;
    }

}
