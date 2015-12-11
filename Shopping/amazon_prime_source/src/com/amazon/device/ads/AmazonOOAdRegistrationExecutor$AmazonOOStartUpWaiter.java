// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            StartUpWaiter, AmazonOOAdRegistrationExecutor, AmazonOOAdRegistrationListener, AdvertisingIdentifier, 
//            MobileAdsInfoStore, SystemTime, Settings, Configuration

private static class executor extends StartUpWaiter
{

    private final AdvertisingIdentifier advertisingIdentifier;
    private final AmazonOOAdRegistrationExecutor executor;
    private final MobileAdsInfoStore infoStore;
    private final AmazonOOAdRegistrationListener listener;
    private final SystemTime systemTime;

    private executor getAmazonOOAdRegistrationInfo()
    {
        return new it>(advertisingIdentifier, infoStore, getSettings(), getConfiguration(), systemTime, executor);
    }

    protected void startUpFailed()
    {
        listener.onRegistrationInfoReady(getAmazonOOAdRegistrationInfo());
    }

    protected void startUpReady()
    {
        listener.onRegistrationInfoReady(getAmazonOOAdRegistrationInfo());
    }

    public (AmazonOOAdRegistrationListener amazonooadregistrationlistener, AdvertisingIdentifier advertisingidentifier, MobileAdsInfoStore mobileadsinfostore, Settings settings, Configuration configuration, SystemTime systemtime, AmazonOOAdRegistrationExecutor amazonooadregistrationexecutor)
    {
        super(settings, configuration);
        listener = amazonooadregistrationlistener;
        advertisingIdentifier = advertisingidentifier;
        infoStore = mobileadsinfostore;
        systemTime = systemtime;
        executor = amazonooadregistrationexecutor;
    }
}
