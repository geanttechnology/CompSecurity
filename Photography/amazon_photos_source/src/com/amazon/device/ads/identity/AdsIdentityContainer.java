// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads.identity:
//            AdsIdentity, AmazonOOUserIdentifier, Configuration, DebugProperties, 
//            PreferredMarketplaceRetriever, Settings, SystemTime, TrustedPackageManager, 
//            IAmazonRegistration

abstract class AdsIdentityContainer
{

    private AdsIdentity adsIdentity;
    private AmazonOOUserIdentifier amazonOOUserIdentifier;
    private Configuration configuration;
    private Context context;
    private DebugProperties debugProperties;
    private AmazonOOUserIdentifier.IdentifyUserListener identifyUserListener;
    private PreferredMarketplaceRetriever preferredMarketplaceRetriever;
    private Settings settings;
    private SystemTime systemTime;
    private TrustedPackageManager trustedPackageManager;

    AdsIdentityContainer()
    {
    }

    public AdsIdentity getAdsIdentity()
    {
        return adsIdentity;
    }

    public AmazonOOUserIdentifier getAmazonOOUserIdentifier()
    {
        return amazonOOUserIdentifier;
    }

    public abstract IAmazonRegistration getAmazonRegistration();

    public Configuration getConfiguration()
    {
        return configuration;
    }

    public Context getContext()
    {
        return context;
    }

    public DebugProperties getDebugProperties()
    {
        return debugProperties;
    }

    public AmazonOOUserIdentifier.IdentifyUserListener getIdentifyUserListener()
    {
        return identifyUserListener;
    }

    public PreferredMarketplaceRetriever getPreferredMarketplaceRetriever()
    {
        return preferredMarketplaceRetriever;
    }

    public Settings getSettings()
    {
        return settings;
    }

    public SystemTime getSystemTime()
    {
        return systemTime;
    }

    public AdsIdentityContainer setAdsIdentity(AdsIdentity adsidentity)
    {
        adsIdentity = adsidentity;
        return this;
    }

    public AdsIdentityContainer setAmazonOOUserIdentifier(AmazonOOUserIdentifier amazonoouseridentifier)
    {
        amazonOOUserIdentifier = amazonoouseridentifier;
        return this;
    }

    public AdsIdentityContainer setConfiguration(Configuration configuration1)
    {
        configuration = configuration1;
        return this;
    }

    public AdsIdentityContainer setContext(Context context1)
    {
        context = context1;
        return this;
    }

    public AdsIdentityContainer setDebugProperties(DebugProperties debugproperties)
    {
        debugProperties = debugproperties;
        return this;
    }

    public AdsIdentityContainer setIdentifyUserListener(AmazonOOUserIdentifier.IdentifyUserListener identifyuserlistener)
    {
        identifyUserListener = identifyuserlistener;
        return this;
    }

    public AdsIdentityContainer setPreferredMarketplaceRetriever(PreferredMarketplaceRetriever preferredmarketplaceretriever)
    {
        preferredMarketplaceRetriever = preferredmarketplaceretriever;
        return this;
    }

    public AdsIdentityContainer setSettings(Settings settings1)
    {
        settings = settings1;
        return this;
    }

    public AdsIdentityContainer setSystemTime(SystemTime systemtime)
    {
        systemTime = systemtime;
        return this;
    }

    public AdsIdentityContainer setTrustedPackageManager(TrustedPackageManager trustedpackagemanager)
    {
        trustedPackageManager = trustedpackagemanager;
        return this;
    }
}
