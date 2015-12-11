// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            BasicUserIdentifier, JSONUtils, AdvertisingIdentifier, Configuration, 
//            Settings, TrustedPackageManager, SystemTime, DebugProperties, 
//            MobileAdsLoggerFactory

class SessionIdUserIdentifier extends BasicUserIdentifier
{

    private static final String LOGTAG = com/amazon/device/ads/SessionIdUserIdentifier.getSimpleName();
    private static final String PATH = "/RegisterSessionID";
    private final String sessionId;

    public SessionIdUserIdentifier(String s, AdvertisingIdentifier advertisingidentifier, Configuration configuration, Settings settings, TrustedPackageManager trustedpackagemanager, SystemTime systemtime, DebugProperties debugproperties, 
            WebRequest.WebRequestFactory webrequestfactory, MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        super(advertisingidentifier, configuration, settings, trustedpackagemanager, systemtime, debugproperties, LOGTAG, "/RegisterSessionID", webrequestfactory, mobileadsloggerfactory);
        sessionId = s;
    }

    void processExtraParameters(JSONObject jsonobject)
    {
        JSONUtils.put(jsonobject, "sessionId", sessionId);
    }

}
