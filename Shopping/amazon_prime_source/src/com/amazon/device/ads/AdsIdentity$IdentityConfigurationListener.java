// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdsIdentity, MobileAdsLoggerFactory, MobileAdsLogger, AdsIdentityContainer, 
//            AdsIdentityUserIdentifier

private static class er
    implements er
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

    public (AdsIdentityContainer adsidentitycontainer, MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        adsIdentityContainer = adsidentitycontainer;
        logger = mobileadsloggerfactory.createMobileAdsLogger(AdsIdentity.access$000());
    }
}
