// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


// Referenced classes of package com.amazon.device.ads.identity:
//            AdsIdentity, Log, AdsIdentityContainer, AmazonOOUserIdentifier

private static class adsIdentityContainer
    implements adsIdentityContainer
{

    private final AdsIdentityContainer adsIdentityContainer;

    public void onConfigurationFailure()
    {
        Log.w(AdsIdentity.access$100(), "Configuration was not able to be loaded.", new Object[0]);
    }

    public void onConfigurationReady()
    {
        Log.d(AdsIdentity.access$100(), "Attempting to identify user.", new Object[0]);
        AmazonOOUserIdentifier amazonoouseridentifier = adsIdentityContainer.getAmazonOOUserIdentifier();
        amazonoouseridentifier.setAmazonRegistration(adsIdentityContainer.getAmazonRegistration());
        amazonoouseridentifier.identifyUserFromIdModule();
    }

    public (AdsIdentityContainer adsidentitycontainer)
    {
        adsIdentityContainer = adsidentitycontainer;
    }
}
