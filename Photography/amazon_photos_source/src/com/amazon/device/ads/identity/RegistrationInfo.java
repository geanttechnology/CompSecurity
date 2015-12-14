// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


// Referenced classes of package com.amazon.device.ads.identity:
//            Settings, DebugProperties, StringUtils

class RegistrationInfo
{

    private String appKey;
    private String appName;

    public RegistrationInfo()
    {
        appName = "app";
    }

    public static boolean isAdIdOriginatedFromNonAdvertisingIdentifier()
    {
        String s = Settings.getInstance().getString("amzn-ad-id-origin", null);
        return s == null || "non-advertising-identifier".equals(s);
    }

    public String getAdId()
    {
        return DebugProperties.getInstance().getDebugPropertyAsString("debug.adid", Settings.getInstance().getString("amzn-ad-id", null));
    }

    public String getAppKey()
    {
        return DebugProperties.getInstance().getDebugPropertyAsString("debug.appid", appKey);
    }

    public String getAppName()
    {
        return appName;
    }

    public boolean hasAdId()
    {
        return !StringUtils.isNullOrEmpty(getAdId());
    }

    public void requestNewSISDeviceIdentifier()
    {
        Settings.getInstance().putBoolean$505cbf4b("newSISDIDRequested");
    }
}
