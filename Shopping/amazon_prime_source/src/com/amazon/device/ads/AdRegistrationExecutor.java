// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsInfoStore, Settings, MobileAdsLoggerFactory, PermissionChecker, 
//            MobileAdsLogger, Version, AdUserAgentManager, DeviceInfo, 
//            RegistrationInfo

class AdRegistrationExecutor
{

    private final MobileAdsInfoStore infoStore;
    private volatile boolean isInitialized;
    private final MobileAdsLogger logger;
    private final MobileAdsLoggerFactory loggerFactory;
    private final PermissionChecker permissionChecker;
    private final Settings settings;

    public AdRegistrationExecutor(String s)
    {
        this(s, MobileAdsInfoStore.getInstance(), Settings.getInstance(), new MobileAdsLoggerFactory(), new PermissionChecker());
    }

    AdRegistrationExecutor(String s, MobileAdsInfoStore mobileadsinfostore, Settings settings1, MobileAdsLoggerFactory mobileadsloggerfactory, PermissionChecker permissionchecker)
    {
        isInitialized = false;
        infoStore = mobileadsinfostore;
        settings = settings1;
        loggerFactory = mobileadsloggerfactory;
        logger = loggerFactory.createMobileAdsLogger(s);
        permissionChecker = permissionchecker;
    }

    public void enableLogging(boolean flag)
    {
        logger.enableLoggingWithSetterNotification(flag);
    }

    public void enableTesting(boolean flag)
    {
        settings.putTransientBoolean("testingEnabled", flag);
        logger.logSetterNotification("Test mode", Boolean.valueOf(flag));
    }

    MobileAdsLogger getLogger()
    {
        return logger;
    }

    MobileAdsLoggerFactory getLoggerFactory()
    {
        return loggerFactory;
    }

    MobileAdsInfoStore getMobileAdsInfoStore()
    {
        return infoStore;
    }

    PermissionChecker getPermissionChecker()
    {
        return permissionChecker;
    }

    Settings getSettings()
    {
        return settings;
    }

    public String getVersion()
    {
        return Version.getSDKVersion();
    }

    public void initializeAds(Context context)
    {
        if (!isInitialized)
        {
            infoStore.contextReceived(context);
            infoStore.getDeviceInfo().setUserAgentManager(new AdUserAgentManager());
            isInitialized = true;
        }
    }

    public void registerApp(Context context)
    {
        if (!permissionChecker.hasInternetPermission(context))
        {
            logger.e("Network task cannot commence because the INTERNET permission is missing from the app's manifest.");
            return;
        } else
        {
            initializeAds(context);
            infoStore.register();
            return;
        }
    }

    public void setAppKey(String s)
        throws IllegalArgumentException
    {
        infoStore.getRegistrationInfo().putAppKey(s);
    }
}
