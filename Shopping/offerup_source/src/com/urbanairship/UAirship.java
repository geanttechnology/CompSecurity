// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import com.urbanairship.actions.ActionRegistry;
import com.urbanairship.amazon.ADMUtils;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.google.GCMUtils;
import com.urbanairship.google.PlayServicesUtils;
import com.urbanairship.js.Whitelist;
import com.urbanairship.location.UALocationManager;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.iam.InAppMessageManager;
import com.urbanairship.richpush.RichPushManager;
import com.urbanairship.util.ManifestUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.urbanairship:
//            ApplicationMetrics, ChannelCapture, AirshipConfigOptions, Logger, 
//            PreferenceDataStore, BaseManager, CancelableOperation, UrbanAirshipProvider, 
//            Cancelable

public class UAirship
{

    public static final int AMAZON_PLATFORM = 1;
    public static final int ANDROID_PLATFORM = 2;
    private static final String LIBRARY_VERSION_KEY = "com.urbanairship.application.device.LIBRARY_VERSION";
    private static final String PLATFORM_KEY = "com.urbanairship.application.device.PLATFORM";
    private static final Object airshipLock = new Object();
    static Application application;
    static volatile boolean isFlying = false;
    static volatile boolean isTakingOff = false;
    private static List pendingAirshipRequests;
    static UAirship sharedAirship;
    ActionRegistry actionRegistry;
    AirshipConfigOptions airshipConfigOptions;
    Analytics analytics;
    ApplicationMetrics applicationMetrics;
    ChannelCapture channelCapture;
    InAppMessageManager inAppMessageManager;
    UALocationManager locationManager;
    PreferenceDataStore preferenceDataStore;
    PushManager pushManager;
    RichPushManager richPushManager;
    Whitelist whitelist;

    UAirship(Context context, AirshipConfigOptions airshipconfigoptions, PreferenceDataStore preferencedatastore)
    {
        airshipConfigOptions = airshipconfigoptions;
        preferenceDataStore = preferencedatastore;
        analytics = new Analytics(context, preferencedatastore, airshipconfigoptions);
        applicationMetrics = new ApplicationMetrics(context, preferencedatastore);
        richPushManager = new RichPushManager(context, preferencedatastore);
        locationManager = new UALocationManager(context, preferencedatastore);
        inAppMessageManager = new InAppMessageManager(preferencedatastore);
        pushManager = new PushManager(context, preferencedatastore, airshipconfigoptions);
        whitelist = Whitelist.createDefaultWhitelist(airshipconfigoptions);
        actionRegistry = new ActionRegistry();
        channelCapture = new ChannelCapture(context, airshipconfigoptions, pushManager);
    }

    private static void executeTakeOff(Application application1, AirshipConfigOptions airshipconfigoptions, OnReadyCallback onreadycallback)
    {
        AirshipConfigOptions airshipconfigoptions1;
        airshipconfigoptions1 = airshipconfigoptions;
        if (airshipconfigoptions == null)
        {
            airshipconfigoptions1 = AirshipConfigOptions.loadDefaultOptions(application1.getApplicationContext());
        }
        if (!airshipconfigoptions1.isValid())
        {
            synchronized (airshipLock)
            {
                isTakingOff = false;
                airshipLock.notifyAll();
            }
            Logger.error("AirshipConfigOptions are not valid. Unable to take off! Check your airshipconfig.properties file for the errors listed above.");
            throw new IllegalArgumentException("Application configuration is invalid.");
        }
        break MISSING_BLOCK_LABEL_59;
        airshipconfigoptions;
        application1;
        JVM INSTR monitorexit ;
        throw airshipconfigoptions;
        Logger.logLevel = airshipconfigoptions1.getLoggerLevel();
        Logger.TAG = (new StringBuilder()).append(getAppName()).append(" - UALib").toString();
        Logger.info("Airship taking off!");
        Logger.info((new StringBuilder("Airship log level: ")).append(Logger.logLevel).toString());
        Logger.info((new StringBuilder("UA Version: ")).append(getVersion()).append(" / App key = ").append(airshipconfigoptions1.getAppKey()).append(" Production = ").append(airshipconfigoptions1.inProduction).toString());
        airshipconfigoptions = new PreferenceDataStore(application1.getApplicationContext());
        airshipconfigoptions.loadAll();
        sharedAirship = new UAirship(application1.getApplicationContext(), airshipconfigoptions1, airshipconfigoptions);
        application1 = getVersion();
        String s = airshipconfigoptions.getString("com.urbanairship.application.device.LIBRARY_VERSION", null);
        if (s != null && !s.equals(application1))
        {
            Logger.info((new StringBuilder("Urban Airship library changed from ")).append(s).append(" to ").append(application1).append(".").toString());
        }
        airshipconfigoptions.put("com.urbanairship.application.device.LIBRARY_VERSION", getVersion());
        if (!airshipconfigoptions1.inProduction)
        {
            sharedAirship.validateManifest();
        }
        application1 = ((Application) (airshipLock));
        application1;
        JVM INSTR monitorenter ;
        isFlying = true;
        isTakingOff = false;
        sharedAirship.init();
        Logger.info("Airship ready!");
        if (onreadycallback == null)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        onreadycallback.onAirshipReady(sharedAirship);
        if (pendingAirshipRequests == null)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        for (airshipconfigoptions = (new ArrayList(pendingAirshipRequests)).iterator(); airshipconfigoptions.hasNext(); ((Runnable)airshipconfigoptions.next()).run()) { }
        break MISSING_BLOCK_LABEL_368;
        airshipconfigoptions;
        application1;
        JVM INSTR monitorexit ;
        throw airshipconfigoptions;
        pendingAirshipRequests = null;
        airshipLock.notifyAll();
        application1;
        JVM INSTR monitorexit ;
    }

    public static int getAppIcon()
    {
        ApplicationInfo applicationinfo = getAppInfo();
        if (applicationinfo != null)
        {
            return applicationinfo.icon;
        } else
        {
            return -1;
        }
    }

    public static ApplicationInfo getAppInfo()
    {
        return getApplicationContext().getApplicationInfo();
    }

    public static String getAppName()
    {
        if (getAppInfo() != null)
        {
            return getPackageManager().getApplicationLabel(getAppInfo()).toString();
        } else
        {
            return null;
        }
    }

    public static Context getApplicationContext()
    {
        if (application == null)
        {
            throw new IllegalStateException("TakeOff must be called first.");
        } else
        {
            return application.getApplicationContext();
        }
    }

    public static PackageInfo getPackageInfo()
    {
        PackageInfo packageinfo;
        try
        {
            packageinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            Logger.warn("UAirship - Unable to get package info.", namenotfoundexception);
            return null;
        }
        return packageinfo;
    }

    public static PackageManager getPackageManager()
    {
        return getApplicationContext().getPackageManager();
    }

    public static String getPackageName()
    {
        return getApplicationContext().getPackageName();
    }

    public static String getUrbanAirshipPermission()
    {
        return (new StringBuilder()).append(getApplicationContext().getPackageName()).append(".permission.UA_DATA").toString();
    }

    public static String getVersion()
    {
        return "6.3.1";
    }

    private void init()
    {
        richPushManager.init();
        pushManager.init();
        locationManager.init();
        inAppMessageManager.init();
        channelCapture.init();
        actionRegistry.registerDefaultActions();
    }

    public static boolean isFlying()
    {
        return isFlying;
    }

    public static boolean isTakingOff()
    {
        return isTakingOff;
    }

    static void land()
    {
label0:
        {
            synchronized (airshipLock)
            {
                if (isTakingOff || isFlying)
                {
                    break label0;
                }
            }
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            Analytics.unregisterLifeCycleCallbacks();
            InAppMessageManager.unregisterLifeCycleCallbacks();
        }
        shared().tearDown();
        isFlying = false;
        isTakingOff = false;
        sharedAirship = null;
        application = null;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static Cancelable shared(OnReadyCallback onreadycallback)
    {
        return shared(onreadycallback, null);
    }

    public static Cancelable shared(OnReadyCallback onreadycallback, final Looper final_looper)
    {
        final_looper = new _cls1(onreadycallback);
        onreadycallback = ((OnReadyCallback) (airshipLock));
        onreadycallback;
        JVM INSTR monitorenter ;
        if (!isFlying)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        final_looper.run();
_L2:
        return final_looper;
        if (pendingAirshipRequests == null)
        {
            pendingAirshipRequests = new ArrayList();
        }
        pendingAirshipRequests.add(final_looper);
        if (true) goto _L2; else goto _L1
_L1:
        final_looper;
        onreadycallback;
        JVM INSTR monitorexit ;
        throw final_looper;
    }

    public static UAirship shared()
    {
label0:
        {
            UAirship uairship;
            synchronized (airshipLock)
            {
                if (!isFlying)
                {
                    break label0;
                }
                uairship = sharedAirship;
            }
            return uairship;
        }
        if (!isTakingOff)
        {
            throw new IllegalStateException("Take off must be called before shared()");
        }
        break MISSING_BLOCK_LABEL_42;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        boolean flag = false;
_L3:
        boolean flag1 = isFlying;
        if (flag1) goto _L2; else goto _L1
_L1:
        UAirship uairship1;
        Exception exception1;
        try
        {
            airshipLock.wait();
        }
        catch (InterruptedException interruptedexception)
        {
            flag = true;
        }
        finally
        {
            if (!flag) goto _L0; else goto _L0
        }
        if (true) goto _L3; else goto _L2
_L2:
        uairship1 = sharedAirship;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        Thread.currentThread().interrupt();
        obj;
        JVM INSTR monitorexit ;
        return uairship1;
        Thread.currentThread().interrupt();
        throw exception1;
    }

    public static void takeOff(Application application1)
    {
        takeOff(application1, null, null);
    }

    public static void takeOff(Application application1, AirshipConfigOptions airshipconfigoptions)
    {
        takeOff(application1, airshipconfigoptions, null);
    }

    public static void takeOff(final Application application, final AirshipConfigOptions options, final OnReadyCallback readyCallback)
    {
label0:
        {
            if (application == null)
            {
                throw new IllegalArgumentException("Application argument must not be null");
            }
            if (Looper.myLooper() != null && Looper.getMainLooper() == Looper.myLooper())
            {
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    try
                    {
                        Class.forName("android.os.AsyncTask");
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        Logger.error("AsyncTask workaround failed.", ((Throwable) (obj)));
                    }
                }
            } else
            {
                Logger.error("takeOff() must be called on the main thread!");
            }
            synchronized (airshipLock)
            {
                if (!isFlying && !isTakingOff)
                {
                    break label0;
                }
                Logger.error("You can only call takeOff() once.");
            }
            return;
        }
        Logger.info("Airship taking off!");
        isTakingOff = true;
        application = application;
        UrbanAirshipProvider.init();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            Analytics.registerLifeCycleCallbacks(application);
            InAppMessageManager.registerLifeCycleCallbacks(application);
        }
        (new Thread(new _cls2())).start();
        obj;
        JVM INSTR monitorexit ;
        return;
        application;
        obj;
        JVM INSTR monitorexit ;
        throw application;
    }

    public static void takeOff(Application application1, OnReadyCallback onreadycallback)
    {
        takeOff(application1, null, onreadycallback);
    }

    private void tearDown()
    {
        richPushManager.tearDown();
        pushManager.tearDown();
        locationManager.tearDown();
        inAppMessageManager.tearDown();
        channelCapture.tearDown();
    }

    private void validateManifest()
    {
        ManifestUtils.validateManifest(airshipConfigOptions);
        switch (sharedAirship.getPlatformType())
        {
        default:
            return;

        case 2: // '\002'
            if (airshipConfigOptions.isTransportAllowed("GCM"))
            {
                GCMUtils.validateManifest(airshipConfigOptions);
                return;
            } else
            {
                Logger.error("Android platform detected but GCM transport is disabled. The device will not be able to receive push notifications.");
                return;
            }

        case 1: // '\001'
            break;
        }
        if (airshipConfigOptions.isTransportAllowed("ADM"))
        {
            ADMUtils.validateManifest();
            return;
        } else
        {
            Logger.error("Amazon platform detected but ADM transport is disabled. The device will not be able to receive push notifications.");
            return;
        }
    }

    public ActionRegistry getActionRegistry()
    {
        return actionRegistry;
    }

    public AirshipConfigOptions getAirshipConfigOptions()
    {
        return airshipConfigOptions;
    }

    public Analytics getAnalytics()
    {
        return analytics;
    }

    public ApplicationMetrics getApplicationMetrics()
    {
        return applicationMetrics;
    }

    public InAppMessageManager getInAppMessageManager()
    {
        return inAppMessageManager;
    }

    public UALocationManager getLocationManager()
    {
        return locationManager;
    }

    public int getPlatformType()
    {
        int i = 1;
        boolean flag = true;
        switch (preferenceDataStore.getInt("com.urbanairship.application.device.PLATFORM", -1))
        {
        default:
            if (ADMUtils.isADMAvailable())
            {
                Logger.info("ADM available. Setting platform to Amazon.");
                i = ((flag) ? 1 : 0);
            } else
            if (PlayServicesUtils.isGooglePlayStoreAvailable())
            {
                Logger.info("Google Play Store available. Setting platform to Android.");
                i = 2;
            } else
            if ("amazon".equalsIgnoreCase(Build.MANUFACTURER))
            {
                Logger.info("Build.MANUFACTURER is AMAZON. Setting platform to Amazon.");
                i = ((flag) ? 1 : 0);
            } else
            {
                Logger.info("Defaulting platform to Android.");
                i = 2;
            }
            preferenceDataStore.put("com.urbanairship.application.device.PLATFORM", i);
            // fall through

        case 1: // '\001'
            return i;

        case 2: // '\002'
            return 2;
        }
    }

    public PushManager getPushManager()
    {
        return pushManager;
    }

    public RichPushManager getRichPushManager()
    {
        return richPushManager;
    }

    public Whitelist getWhitelist()
    {
        return whitelist;
    }



    private class OnReadyCallback
    {

        public abstract void onAirshipReady(UAirship uairship);
    }


    private class _cls1 extends CancelableOperation
    {

        final OnReadyCallback val$callback;

        public final void onRun()
        {
            if (callback != null)
            {
                callback.onAirshipReady(UAirship.shared());
            }
        }

        _cls1(OnReadyCallback onreadycallback)
        {
            callback = onreadycallback;
            super(final_looper);
        }
    }


    private class _cls2
        implements Runnable
    {

        final Application val$application;
        final AirshipConfigOptions val$options;
        final OnReadyCallback val$readyCallback;

        public final void run()
        {
            UAirship.executeTakeOff(application, options, readyCallback);
        }

        _cls2()
        {
            application = application1;
            options = airshipconfigoptions;
            readyCallback = onreadycallback;
            super();
        }
    }

}
