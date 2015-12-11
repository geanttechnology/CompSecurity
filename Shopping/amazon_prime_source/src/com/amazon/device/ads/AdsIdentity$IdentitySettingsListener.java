// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdsIdentity, MobileAdsLoggerFactory, MobileAdsLogger, AdsIdentityContainer, 
//            Configuration

private static class sLogger
    implements sLogger
{

    private final AdsIdentity adsIdentity;
    private final AdsIdentityContainer adsIdentityContainer;
    private final configurationListener configurationListener;
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

    public (AdsIdentityContainer adsidentitycontainer,  , AdsIdentity adsidentity, MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        adsIdentityContainer = adsidentitycontainer;
        configurationListener = ;
        adsIdentity = adsidentity;
        logger = mobileadsloggerfactory.createMobileAdsLogger(AdsIdentity.access$000());
    }
}
