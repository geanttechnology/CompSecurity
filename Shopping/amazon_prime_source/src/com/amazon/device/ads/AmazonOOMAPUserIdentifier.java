// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdsIdentityUserIdentifier, AuthenticationPlatformAdapter, AdvertisingIdentifier, Configuration, 
//            Settings, TrustedPackageManager, SystemTime, DebugProperties, 
//            MobileAdsLoggerFactory, WebRequest

class AmazonOOMAPUserIdentifier extends AdsIdentityUserIdentifier
{

    private static final String LOGTAG = com/amazon/device/ads/AmazonOOMAPUserIdentifier.getSimpleName();
    private static final String PATH = "/RegisterOAuth";
    private final AuthenticationPlatformAdapter authenticationPlatform;

    public AmazonOOMAPUserIdentifier(AuthenticationPlatformAdapter authenticationplatformadapter, AdvertisingIdentifier advertisingidentifier, Configuration configuration, Settings settings, TrustedPackageManager trustedpackagemanager, SystemTime systemtime, DebugProperties debugproperties, 
            MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        super(advertisingidentifier, configuration, settings, trustedpackagemanager, systemtime, debugproperties, LOGTAG, "/RegisterOAuth", null, mobileadsloggerfactory);
        authenticationPlatform = authenticationplatformadapter;
    }

    public String getAccount()
    {
        return authenticationPlatform.getAccountName();
    }

    WebRequest initializeWebRequest()
    {
        String s = getAccount();
        if (s == null)
        {
            return null;
        } else
        {
            return makeAuthenticatedWebRequest(s);
        }
    }

    protected WebRequest makeAuthenticatedWebRequest(String s)
    {
        return authenticationPlatform.makeAuthenticatedWebRequest(s);
    }

}
