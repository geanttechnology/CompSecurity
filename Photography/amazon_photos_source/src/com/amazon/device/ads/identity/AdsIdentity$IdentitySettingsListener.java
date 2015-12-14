// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


// Referenced classes of package com.amazon.device.ads.identity:
//            AdsIdentity, IdentifyUserTimeManager, Log, AdsIdentityContainer, 
//            Configuration

private static class identifyUserTimeManager
    implements identifyUserTimeManager
{

    private final AdsIdentityContainer adsIdentityContainer;
    private final configurationListener configurationListener;
    private final IdentifyUserTimeManager identifyUserTimeManager;

    public void settingsLoaded()
    {
        if (!identifyUserTimeManager.shouldIdentifyUser())
        {
            Log.d(AdsIdentity.access$100(), "Not identifying user since a call was made previously and has not yet expired.", new Object[0]);
            return;
        } else
        {
            Log.d(AdsIdentity.access$100(), "Loading Configuration.", new Object[0]);
            adsIdentityContainer.getConfiguration().setIsFirstParty$1385ff();
            adsIdentityContainer.getConfiguration().setPreferredMarketplaceRetriever(adsIdentityContainer.getPreferredMarketplaceRetriever());
            adsIdentityContainer.getConfiguration().queueConfigurationListener(configurationListener);
            return;
        }
    }

    public I(AdsIdentityContainer adsidentitycontainer, I i, IdentifyUserTimeManager identifyusertimemanager)
    {
        adsIdentityContainer = adsidentitycontainer;
        configurationListener = i;
        identifyUserTimeManager = identifyusertimemanager;
    }
}
