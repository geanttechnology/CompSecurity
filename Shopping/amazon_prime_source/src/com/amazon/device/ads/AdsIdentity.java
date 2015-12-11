// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils, SystemTime, Settings, Configuration, 
//            AdvertisingIdentifier, TrustedPackageManager, AmazonOOMAPUserIdentifier, DebugProperties, 
//            AuthenticationPlatformPreferredMarketplaceRetriever, AdsIdentityContainer, MobileAdsLoggerFactory, AmazonOOMAPAdapter, 
//            AdsIdentityUserIdentifier, AuthenticationPlatformAdapter, MobileAdsLogger, MobileAdsInfoStore, 
//            StringUtils

public class AdsIdentity
{
    private static class IdentityConfigurationListener
        implements Configuration.ConfigurationListener
    {

        private final AdsIdentityContainer adsIdentityContainer;
        private final MobileAdsLogger logger;

        public void onConfigurationFailure()
        {
            logger.w("Configuration was not able to be loaded.");
        }

        public void onConfigurationReady()
        {
            logger.d("Attempting to identify user.");
            AdsIdentityUserIdentifier adsidentityuseridentifier = adsIdentityContainer.getUserIdentifier();
            adsidentityuseridentifier.setMobileAdsInfoStore(adsIdentityContainer.getMobileAdsInfoStore());
            adsidentityuseridentifier.identifyUserFromIdModule();
        }

        public IdentityConfigurationListener(AdsIdentityContainer adsidentitycontainer, MobileAdsLoggerFactory mobileadsloggerfactory)
        {
            adsIdentityContainer = adsidentitycontainer;
            logger = mobileadsloggerfactory.createMobileAdsLogger(AdsIdentity.LOGTAG);
        }
    }

    private static class IdentityIdentifyUserListener
        implements AmazonOOUserIdentifier.IdentifyUserListener
    {

        private final MobileAdsLogger logger;

        public void userIdentified()
        {
            logger.d("User successfully identified.");
        }

        public IdentityIdentifyUserListener(MobileAdsLoggerFactory mobileadsloggerfactory)
        {
            logger = mobileadsloggerfactory.createMobileAdsLogger(AdsIdentity.LOGTAG);
        }
    }

    private static class IdentityInitializer
        implements Runnable
    {

        private final AdsIdentityContainer adsIdentityContainer;
        private final MobileAdsLogger logger;
        private final Settings.SettingsListener settingsListener;

        private void startIdentifyUser()
        {
            adsIdentityContainer.getMobileAdsInfoStore().contextReceived(adsIdentityContainer.getContext());
            logger.d("Listening for settings to load.");
            adsIdentityContainer.getSettings().listenForSettings(settingsListener);
        }

        public void run()
        {
            if (!StringUtils.isNullOrEmpty(adsIdentityContainer.getUserIdentifier().getAccount()))
            {
                startIdentifyUser();
                return;
            } else
            {
                logger.forceLog(MobileAdsLogger.Level.DEBUG, "No Amazon account found.", new Object[0]);
                return;
            }
        }

        public IdentityInitializer(AdsIdentityContainer adsidentitycontainer, Settings.SettingsListener settingslistener, MobileAdsLoggerFactory mobileadsloggerfactory)
        {
            adsIdentityContainer = adsidentitycontainer;
            settingsListener = settingslistener;
            logger = mobileadsloggerfactory.createMobileAdsLogger(AdsIdentity.LOGTAG);
        }
    }

    private static class IdentitySettingsListener
        implements Settings.SettingsListener
    {

        private final AdsIdentity adsIdentity;
        private final AdsIdentityContainer adsIdentityContainer;
        private final Configuration.ConfigurationListener configurationListener;
        private final MobileAdsLogger logger;

        public void settingsLoaded()
        {
            if (!adsIdentity.shouldIdentifyUser())
            {
                logger.d("Not identifying user since a call was made previously and has not yet expired.");
                return;
            } else
            {
                logger.d("Loading Configuration.");
                adsIdentityContainer.getConfiguration().setIsFirstParty(true);
                adsIdentityContainer.getConfiguration().setPreferredMarketplaceRetriever(adsIdentityContainer.getPreferredMarketplaceRetriever());
                adsIdentityContainer.getConfiguration().queueConfigurationListener(configurationListener);
                return;
            }
        }

        public IdentitySettingsListener(AdsIdentityContainer adsidentitycontainer, Configuration.ConfigurationListener configurationlistener, AdsIdentity adsidentity, MobileAdsLoggerFactory mobileadsloggerfactory)
        {
            adsIdentityContainer = adsidentitycontainer;
            configurationListener = configurationlistener;
            adsIdentity = adsidentity;
            logger = mobileadsloggerfactory.createMobileAdsLogger(AdsIdentity.LOGTAG);
        }
    }


    private static final long DEFAULT_LAST_IU_TIME = -1L;
    private static final String LOGTAG = com/amazon/device/ads/AdsIdentity.getSimpleName();
    private AdsIdentityContainer adsIdentityContainer;
    private Runnable runnableTask;
    private final ThreadUtils.ThreadRunner threadRunner;

    private AdsIdentity()
    {
        this(ThreadUtils.getThreadRunner());
    }

    AdsIdentity(ThreadUtils.ThreadRunner threadrunner)
    {
        threadRunner = threadrunner;
    }

    static AdsIdentityContainer createAdsIdentityContainer(Context context, AuthenticationPlatformAdapter authenticationplatformadapter, MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        SystemTime systemtime = new SystemTime();
        Object obj = Settings.getInstance();
        Object obj1 = Configuration.getInstance();
        AdvertisingIdentifier advertisingidentifier = new AdvertisingIdentifier();
        TrustedPackageManager trustedpackagemanager = new TrustedPackageManager(context.getPackageName(), context.getPackageManager(), TrustedPackageManager.getTrustedCerts());
        obj = new AmazonOOMAPUserIdentifier(authenticationplatformadapter, advertisingidentifier, ((Configuration) (obj1)), ((Settings) (obj)), trustedpackagemanager, systemtime, DebugProperties.getInstance(), mobileadsloggerfactory);
        obj1 = new AdsIdentityContainer() {

            public MobileAdsInfoStore getMobileAdsInfoStore()
            {
                return MobileAdsInfoStore.getInstance();
            }

        };
        authenticationplatformadapter = new AuthenticationPlatformPreferredMarketplaceRetriever(authenticationplatformadapter);
        ((AdsIdentityContainer) (obj1)).setAdsIdentity(new AdsIdentity()).setContext(context).setSettings(Settings.getInstance()).setConfiguration(Configuration.getInstance()).setDebugProperties(DebugProperties.getInstance()).setSystemTime(systemtime).setUserIdentifier(((AdsIdentityUserIdentifier) (obj))).setTrustedPackageManager(trustedpackagemanager).setPreferredMarketplaceRetriever(authenticationplatformadapter);
        createIdentifyUserListener(((AdsIdentityContainer) (obj1)), mobileadsloggerfactory);
        return ((AdsIdentityContainer) (obj1));
    }

    static void createIdentifyUserListener(AdsIdentityContainer adsidentitycontainer, MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        adsidentitycontainer.setIdentifyUserListener(new IdentityIdentifyUserListener(mobileadsloggerfactory));
    }

    public static void initialize(Context context)
    {
        MobileAdsLoggerFactory mobileadsloggerfactory = new MobileAdsLoggerFactory();
        initialize(createAdsIdentityContainer(context, (new AmazonOOMAPAdapter()).setContext(context), mobileadsloggerfactory), mobileadsloggerfactory);
    }

    static void initialize(AdsIdentityContainer adsidentitycontainer, MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        if (shouldIdentifyUser(adsidentitycontainer))
        {
            AdsIdentity adsidentity = adsidentitycontainer.getAdsIdentity();
            adsidentitycontainer.getUserIdentifier().addIdentifyUserListener(adsidentitycontainer.getIdentifyUserListener());
            adsidentity.setRunnableTask(new IdentityInitializer(adsidentitycontainer, new IdentitySettingsListener(adsidentitycontainer, new IdentityConfigurationListener(adsidentitycontainer, mobileadsloggerfactory), adsidentity, mobileadsloggerfactory), mobileadsloggerfactory));
            adsidentity.setAdsIdentityContainer(adsidentitycontainer);
            adsidentity.initializeIdentityModule(adsidentitycontainer.getContext());
        }
    }

    private static boolean shouldIdentifyUser(AdsIdentityContainer adsidentitycontainer)
    {
        if (shouldIdentifyUser(adsidentitycontainer, adsidentitycontainer.getSettings().getLong("amzn-ad-iu-last-checkin", -1L)))
        {
            return shouldIdentifyUser(adsidentitycontainer, adsidentitycontainer.getSettings().getWrittenLong("amzn-ad-iu-last-checkin", -1L));
        } else
        {
            return false;
        }
    }

    private static boolean shouldIdentifyUser(AdsIdentityContainer adsidentitycontainer, long l)
    {
        return adsidentitycontainer.getSystemTime().currentTimeMillis() > adsidentitycontainer.getConfiguration().getLong(Configuration.ConfigOption.IDENTIFY_USER_INTERVAL) + l;
    }

    void initializeIdentityModule(Context context)
    {
        if (shouldIdentifyUser())
        {
            threadRunner.execute(runnableTask, ThreadUtils.ExecutionStyle.SCHEDULE, ThreadUtils.ExecutionThread.BACKGROUND_THREAD);
        }
    }

    void setAdsIdentityContainer(AdsIdentityContainer adsidentitycontainer)
    {
        adsIdentityContainer = adsidentitycontainer;
    }

    void setRunnableTask(Runnable runnable)
    {
        runnableTask = runnable;
    }

    public boolean shouldIdentifyUser()
    {
        boolean flag = shouldIdentifyUser(adsIdentityContainer);
        return adsIdentityContainer.getDebugProperties().getDebugPropertyAsBoolean("debug.shouldIdentifyUser", Boolean.valueOf(flag)).booleanValue();
    }


}
