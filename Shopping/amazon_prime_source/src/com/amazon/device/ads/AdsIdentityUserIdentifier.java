// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            BasicUserIdentifier, AccountBasedUserIdentifier, JSONUtils, AdvertisingIdentifier, 
//            Configuration, Settings, TrustedPackageManager, SystemTime, 
//            DebugProperties, MobileAdsLoggerFactory

abstract class AdsIdentityUserIdentifier extends BasicUserIdentifier
    implements AccountBasedUserIdentifier
{

    private boolean calledFromIdModule;

    AdsIdentityUserIdentifier(AdvertisingIdentifier advertisingidentifier, Configuration configuration, Settings settings, TrustedPackageManager trustedpackagemanager, SystemTime systemtime, DebugProperties debugproperties, String s, 
            String s1, WebRequest.WebRequestFactory webrequestfactory, MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        super(advertisingidentifier, configuration, settings, trustedpackagemanager, systemtime, debugproperties, s, s1, webrequestfactory, mobileadsloggerfactory);
        calledFromIdModule = false;
    }

    public void identifyUserFromIdModule()
    {
        calledFromIdModule = true;
        startUpReady();
    }

    void processExtraParameters(JSONObject jsonobject)
    {
        if (calledFromIdModule)
        {
            JSONUtils.put(jsonobject, "idModule", true);
        }
    }
}
