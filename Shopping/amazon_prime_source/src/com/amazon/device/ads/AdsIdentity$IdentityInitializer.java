// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdsIdentity, MobileAdsLoggerFactory, AdsIdentityContainer, MobileAdsInfoStore, 
//            MobileAdsLogger, Settings, AdsIdentityUserIdentifier, StringUtils

private static class ileAdsLogger
    implements Runnable
{

    private final AdsIdentityContainer adsIdentityContainer;
    private final MobileAdsLogger logger;
    private final logger settingsListener;

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
            logger.forceLog(logger, "No Amazon account found.", new Object[0]);
            return;
        }
    }

    public (AdsIdentityContainer adsidentitycontainer,  , MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        adsIdentityContainer = adsidentitycontainer;
        settingsListener = ;
        logger = mobileadsloggerfactory.createMobileAdsLogger(AdsIdentity.access$000());
    }
}
