// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            AdRegistrationExecutor, AmazonOOAdRegistration, AppEventRegistrationHandler, Configuration, 
//            AndroidBuildInfo, AdvertisingIdentifier, ThreadUtils, MobileAdsInfoStore, 
//            Settings, MobileAdsLoggerFactory, PermissionChecker, SystemTime, 
//            DebugProperties, WebUtils2, MAPUtils, AmazonOOPreferredMarketplaceRetrieverFactory, 
//            DirectedIdParameter, MobileAdsLogger, AndroidTargetUtils, DeviceInfo, 
//            TrustedPackageManager, AppInfo, AmazonOODMSUserIdentifier, AmazonOOMAPUserIdentifier, 
//            AmazonOOMAPAdapter, SessionIdUserIdentifier, AmazonOOAppEvent, RegistrationInfo, 
//            StringUtils, AppEvent, AmazonOOAdPreferencesURLListener, AmazonOOAdRegistrationListener, 
//            StartUpWaiter

class AmazonOOAdRegistrationExecutor extends AdRegistrationExecutor
{
    private static class AdPreferencesURLFetcher extends StartUpWaiter
    {

        private final AdvertisingIdentifier advertisingIdentifier;
        private final MobileAdsInfoStore infoStore;
        private final AmazonOOAdPreferencesURLListener listener;
        private final MobileAdsLogger logger;
        private final ThreadUtils.ThreadRunner threadRunner;
        private final WebUtils2 webUtils;

        private void onFetched(String s)
        {
            threadRunner.execute(s. new Runnable() {

                final AdPreferencesURLFetcher this$0;
                final String val$adPreferencesURL;

                public void run()
                {
                    listener.onAdPreferencesURLFetched(adPreferencesURL);
                }

            
            {
                this$0 = final_adpreferencesurlfetcher;
                adPreferencesURL = String.this;
                super();
            }
            }, ThreadUtils.ExecutionStyle.SCHEDULE, ThreadUtils.ExecutionThread.MAIN_THREAD);
        }

        protected void startUpFailed()
        {
            onFetched(null);
        }

        protected void startUpReady()
        {
            AdvertisingIdentifier.Info info = advertisingIdentifier.getAdvertisingIdentifierInfo();
            String s = getConfiguration().getString(Configuration.ConfigOption.AD_PREF_URL);
            StringBuilder stringbuilder = new StringBuilder(s);
            if (s.indexOf('?') == -1)
            {
                stringbuilder.append("?");
            } else
            {
                stringbuilder.append("&");
            }
            stringbuilder.append("adId=");
            s = info.getSISDeviceIdentifier();
            if (!info.hasSISDeviceIdentifier())
            {
                logger.w("Ad-id not found, using blank");
                s = "";
            }
            stringbuilder.append(webUtils.getURLEncodedString(s));
            stringbuilder.append("&appId=");
            stringbuilder.append(webUtils.getURLEncodedString(infoStore.getRegistrationInfo().getAppKey()));
            onFetched(stringbuilder.toString());
        }


        protected AdPreferencesURLFetcher(AmazonOOAdPreferencesURLListener amazonooadpreferencesurllistener, AdvertisingIdentifier advertisingidentifier, ThreadUtils.ThreadRunner threadrunner, Settings settings, Configuration configuration1, MobileAdsInfoStore mobileadsinfostore, MobileAdsLogger mobileadslogger, 
                WebUtils2 webutils2)
        {
            super(settings, configuration1);
            listener = amazonooadpreferencesurllistener;
            advertisingIdentifier = advertisingidentifier;
            threadRunner = threadrunner;
            infoStore = mobileadsinfostore;
            logger = mobileadslogger;
            webUtils = webutils2;
        }
    }

    private static class AmazonOOStartUpWaiter extends StartUpWaiter
    {

        private final AdvertisingIdentifier advertisingIdentifier;
        private final AmazonOOAdRegistrationExecutor executor;
        private final MobileAdsInfoStore infoStore;
        private final AmazonOOAdRegistrationListener listener;
        private final SystemTime systemTime;

        private AmazonOOAdRegistration.AmazonOOAdRegistrationInfo getAmazonOOAdRegistrationInfo()
        {
            return new AmazonOOAdRegistration.AmazonOOAdRegistrationInfo(advertisingIdentifier, infoStore, getSettings(), getConfiguration(), systemTime, executor);
        }

        protected void startUpFailed()
        {
            listener.onRegistrationInfoReady(getAmazonOOAdRegistrationInfo());
        }

        protected void startUpReady()
        {
            listener.onRegistrationInfoReady(getAmazonOOAdRegistrationInfo());
        }

        public AmazonOOStartUpWaiter(AmazonOOAdRegistrationListener amazonooadregistrationlistener, AdvertisingIdentifier advertisingidentifier, MobileAdsInfoStore mobileadsinfostore, Settings settings, Configuration configuration1, SystemTime systemtime, AmazonOOAdRegistrationExecutor amazonooadregistrationexecutor)
        {
            super(settings, configuration1);
            listener = amazonooadregistrationlistener;
            advertisingIdentifier = advertisingidentifier;
            infoStore = mobileadsinfostore;
            systemTime = systemtime;
            executor = amazonooadregistrationexecutor;
        }
    }


    private static final String LOGTAG = com/amazon/device/ads/AmazonOOAdRegistration.getSimpleName();
    private final AdvertisingIdentifier advertisingIdentifier;
    private final AndroidBuildInfo androidBuildInfo;
    private final AppEventRegistrationHandler appEventRegistrationHandler;
    private final Configuration configuration;
    private final DebugProperties debugProperties;
    private final SystemTime systemTime;
    private final ThreadUtils.ThreadRunner threadRunner;
    private final WebRequest.WebRequestFactory webRequestFactory;
    private final WebUtils2 webUtils;

    public AmazonOOAdRegistrationExecutor()
    {
        this(AppEventRegistrationHandler.getInstance(), Configuration.getInstance(), new AndroidBuildInfo(), new AdvertisingIdentifier(), ThreadUtils.getThreadRunner(), MobileAdsInfoStore.getInstance(), Settings.getInstance(), new MobileAdsLoggerFactory(), new PermissionChecker(), new SystemTime(), DebugProperties.getInstance(), new WebUtils2(), new WebRequest.WebRequestFactory(), new MAPUtils(), new AmazonOOPreferredMarketplaceRetrieverFactory());
    }

    AmazonOOAdRegistrationExecutor(AppEventRegistrationHandler appeventregistrationhandler, Configuration configuration1, AndroidBuildInfo androidbuildinfo, AdvertisingIdentifier advertisingidentifier, ThreadUtils.ThreadRunner threadrunner, MobileAdsInfoStore mobileadsinfostore, Settings settings, 
            MobileAdsLoggerFactory mobileadsloggerfactory, PermissionChecker permissionchecker, SystemTime systemtime, DebugProperties debugproperties, WebUtils2 webutils2, WebRequest.WebRequestFactory webrequestfactory, MAPUtils maputils, 
            AmazonOOPreferredMarketplaceRetrieverFactory amazonoopreferredmarketplaceretrieverfactory)
    {
        super(LOGTAG, mobileadsinfostore, settings, mobileadsloggerfactory, permissionchecker);
        appEventRegistrationHandler = appeventregistrationhandler;
        configuration = configuration1;
        androidBuildInfo = androidbuildinfo;
        advertisingIdentifier = advertisingidentifier;
        threadRunner = threadrunner;
        systemTime = systemtime;
        debugProperties = debugproperties;
        webUtils = webutils2;
        webRequestFactory = webrequestfactory;
        configuration.setIsFirstParty(true);
        configuration.setPreferredMarketplaceRetriever(amazonoopreferredmarketplaceretrieverfactory.createPreferredMarketplaceRetriever());
        if (maputils.isMAPAvailable())
        {
            getSettings().putTransientObject("userIdParam", new DirectedIdParameter());
            return;
        } else
        {
            getLogger().d("MAP Library not available");
            return;
        }
    }

    private String decodeIfNeeded(boolean flag, String s)
    {
        String s1 = s;
        if (flag)
        {
            s1 = webUtils.getURLDecodedString(s);
        }
        return s1;
    }

    public void addParam(HashMap hashmap, String s, String s1, boolean flag)
    {
        if (s1 != null)
        {
            hashmap.put(s, decodeIfNeeded(flag, s1));
        }
    }

    public void enableTLS(boolean flag)
    {
        if (AndroidTargetUtils.isAtLeastAndroidAPI(androidBuildInfo, 8))
        {
            getSettings().putTransientBoolean("tlsEnabled", flag);
            MobileAdsLogger mobileadslogger = getLogger();
            MobileAdsLogger.Level level = MobileAdsLogger.Level.INFO;
            String s;
            if (flag)
            {
                s = "enabled";
            } else
            {
                s = "disabled";
            }
            mobileadslogger.forceLog(level, "Transport Layer Security %s by default.", new Object[] {
                s
            });
            return;
        } else
        {
            getLogger().forceLog(MobileAdsLogger.Level.INFO, "Enabling Transport Layer Security is only supported on Android API Level 8 and higher.", new Object[0]);
            return;
        }
    }

    public void fetchAdPreferencesURL(AmazonOOAdPreferencesURLListener amazonooadpreferencesurllistener)
    {
        (new AdPreferencesURLFetcher(amazonooadpreferencesurllistener, advertisingIdentifier, threadRunner, getSettings(), configuration, getMobileAdsInfoStore(), getLogger(), webUtils)).start();
    }

    public Map getDeviceNativeParams()
    {
        DeviceInfo deviceinfo = getMobileAdsInfoStore().getDeviceInfo();
        HashMap hashmap = new HashMap();
        addParam(hashmap, "os", deviceinfo.getOS(), false);
        addParam(hashmap, "model", deviceinfo.getModel(), false);
        addParam(hashmap, "make", deviceinfo.getMake(), false);
        addParam(hashmap, "osVersion", deviceinfo.getOSVersion(), false);
        return hashmap;
    }

    public void identifyAmazonUserUsingDMS(Context context, String s, String s1)
    {
        if (!getPermissionChecker().hasInternetPermission(context))
        {
            getLogger().e("Network task cannot commence because the INTERNET permission is missing from the app's manifest.");
            return;
        } else
        {
            prepareRegistrationInfo(context);
            context = new TrustedPackageManager(getMobileAdsInfoStore().getAppInfo().getPackageName(), getMobileAdsInfoStore().getAppInfo().getPackageManager(), TrustedPackageManager.getTrustedCerts());
            (new AmazonOODMSUserIdentifier(s, s1, advertisingIdentifier, configuration, getSettings(), context, systemTime, debugProperties, getLoggerFactory())).executeRequest();
            return;
        }
    }

    public void identifyAmazonUserUsingMAP()
    {
        if (!getMobileAdsInfoStore().isRegistered())
        {
            throw new IllegalStateException("AmazonOOAdRegistration.registerApp must be called before identify user.");
        } else
        {
            Object obj = new TrustedPackageManager(getMobileAdsInfoStore().getAppInfo().getPackageName(), getMobileAdsInfoStore().getAppInfo().getPackageManager(), TrustedPackageManager.getTrustedCerts());
            obj = new AmazonOOMAPUserIdentifier((new AmazonOOMAPAdapter()).setContext(getMobileAdsInfoStore().getApplicationContext()), advertisingIdentifier, configuration, getSettings(), ((TrustedPackageManager) (obj)), systemTime, debugProperties, getLoggerFactory());
            ((AmazonOOMAPUserIdentifier) (obj)).setMobileAdsInfoStore(getMobileAdsInfoStore());
            ((AmazonOOMAPUserIdentifier) (obj)).executeRequest();
            return;
        }
    }

    public void identifyAmazonUserUsingSessionId(String s)
    {
        if (!getMobileAdsInfoStore().isRegistered())
        {
            throw new IllegalStateException("AmazonOOAdRegistration.registerApp must be called before identify user.");
        } else
        {
            TrustedPackageManager trustedpackagemanager = new TrustedPackageManager(getMobileAdsInfoStore().getAppInfo().getPackageName(), getMobileAdsInfoStore().getAppInfo().getPackageManager(), TrustedPackageManager.getTrustedCerts());
            s = new SessionIdUserIdentifier(s, advertisingIdentifier, configuration, getSettings(), trustedpackagemanager, systemTime, debugProperties, webRequestFactory, getLoggerFactory());
            s.setMobileAdsInfoStore(getMobileAdsInfoStore());
            s.executeRequest();
            return;
        }
    }

    public void listenForRegistrationInfo(AmazonOOAdRegistrationListener amazonooadregistrationlistener)
    {
        (new AmazonOOStartUpWaiter(amazonooadregistrationlistener, advertisingIdentifier, getMobileAdsInfoStore(), getSettings(), configuration, systemTime, this)).start();
    }

    public void prepareRegistrationInfo(Context context)
    {
        getMobileAdsInfoStore().contextReceived(context);
    }

    public void prepareRegistrationInfo(Context context, AmazonOOAdRegistrationListener amazonooadregistrationlistener)
    {
        prepareRegistrationInfo(context);
        listenForRegistrationInfo(amazonooadregistrationlistener);
    }

    public void registerApp(Context context)
    {
        registerApp(context, null);
    }

    public void registerApp(Context context, AmazonOOAdRegistrationListener amazonooadregistrationlistener)
    {
        if (!getPermissionChecker().hasInternetPermission(context))
        {
            getLogger().e("Network task cannot commence because the INTERNET permission is missing from the app's manifest.");
        } else
        {
            prepareRegistrationInfo(context);
            getMobileAdsInfoStore().register();
            if (amazonooadregistrationlistener != null)
            {
                listenForRegistrationInfo(amazonooadregistrationlistener);
                return;
            }
        }
    }

    public void registerEvent(Context context, AmazonOOAppEvent amazonooappevent)
    {
        if (amazonooappevent == null)
        {
            getLogger().e("Application event was null. Could not register the application event.");
            return;
        }
        if (amazonooappevent.getEventName() == null || amazonooappevent.getEventName().equals(""))
        {
            getLogger().e("Event name should not be null or empty. Could not register the application event.");
            return;
        }
        if (amazonooappevent.getTimestamp() <= 0L)
        {
            getLogger().e("Invalid time stamp value for the event. Could not register the application event.");
            return;
        } else
        {
            prepareRegistrationInfo(context);
            appEventRegistrationHandler.addEventToAppEventsCacheFile(amazonooappevent);
            getLogger().logSetterNotification("New event", amazonooappevent.getEventName());
            return;
        }
    }

    public void setAppDefinedMarketplace(String s)
    {
        configuration.setAppDefinedMarketplace(s);
    }

    public void setAppName(String s)
    {
        getMobileAdsInfoStore().getRegistrationInfo().putAppName(s);
    }

    public void setReferrer(Context context, String s)
    {
        if (StringUtils.isNullOrEmpty(s))
        {
            getLogger().e("Referrer was null or emtpy. Could not set the referrer.");
            return;
        } else
        {
            prepareRegistrationInfo(context);
            context = new AmazonOOAppEvent("INSTALL_REFERRER", systemTime.currentTimeMillis());
            context.setProperty("referrer", s);
            appEventRegistrationHandler.addEventToAppEventsCacheFile(context);
            getLogger().logSetterNotification("Referrer", s);
            return;
        }
    }

    public void setShouldPauseWebViewTimersInWebViewRelatedActivities(Context context, boolean flag)
    {
        prepareRegistrationInfo(context);
        getSettings().putBoolean("shouldPauseWebViewTimersInWebViewRelatedActivities", flag);
        getLogger().logSetterNotification("WebView timer pausing", Boolean.valueOf(flag));
    }

    public void updateLastIdentifyUserWithSISTime(final Context context)
    {
        threadRunner.execute(new Runnable() {

            final AmazonOOAdRegistrationExecutor this$0;
            final Context val$context;

            public void run()
            {
                prepareRegistrationInfo(context);
                getSettings().putLong("amzn-ad-iu-last-checkin", systemTime.currentTimeMillis());
            }

            
            {
                this$0 = AmazonOOAdRegistrationExecutor.this;
                context = context1;
                super();
            }
        }, ThreadUtils.ExecutionStyle.SCHEDULE, ThreadUtils.ExecutionThread.MAIN_THREAD);
    }


}
