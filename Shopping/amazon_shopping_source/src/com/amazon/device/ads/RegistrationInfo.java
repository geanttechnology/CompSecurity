// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            Settings, DebugProperties, Utils

class RegistrationInfo
{

    private static final String ADID_ORIGIN_PREF_NAME = "amzn-ad-id-origin";
    private static final String ADID_PREF_NAME = "amzn-ad-id";
    private static final String NEW_SIS_DID_REQUESTED_SETTING = "newSISDIDRequested";
    private static final String NON_ADVERTISING_IDENTIFIER_ORIGIN = "non-advertising-identifier";
    private static final String THIRD_PARTY_APP_NAME = "app";
    private String appKey;
    private String appName;

    public RegistrationInfo()
    {
        appName = "app";
    }

    public static boolean isAdIdCurrent(AdvertisingIdentifier.Info info)
    {
label0:
        {
            boolean flag1 = isAdIdOriginatedFromNonAdvertisingIdentifier();
            boolean flag = flag1;
            if (info.hasAdvertisingIdentifier())
            {
                if (!flag1)
                {
                    break label0;
                }
                flag = false;
            }
            return flag;
        }
        String s = Settings.getInstance().getString("amzn-ad-id-origin", null);
        return info.getAdvertisingIdentifier().equals(s);
    }

    public static boolean isAdIdOriginatedFromNonAdvertisingIdentifier()
    {
        String s = Settings.getInstance().getString("amzn-ad-id-origin", null);
        return s == null || "non-advertising-identifier".equals(s);
    }

    protected static void setOrigin(AdvertisingIdentifier.Info info)
    {
        if (info.hasAdvertisingIdentifier())
        {
            Settings.getInstance().putStringWithNoFlush("amzn-ad-id-origin", info.getAdvertisingIdentifier());
            return;
        } else
        {
            Settings.getInstance().putStringWithNoFlush("amzn-ad-id-origin", "non-advertising-identifier");
            return;
        }
    }

    public String getAdId()
    {
        return DebugProperties.getDebugPropertyAsString("debug.adid", Settings.getInstance().getString("amzn-ad-id", null));
    }

    public String getAppKey()
    {
        return DebugProperties.getDebugPropertyAsString("debug.appid", appKey);
    }

    public String getAppName()
    {
        return appName;
    }

    public boolean hasAdId()
    {
        return getAdId() != null;
    }

    public boolean isRegisteredWithSIS()
    {
        return !Utils.isNullOrEmpty(getAdId());
    }

    public void putAdId(String s, AdvertisingIdentifier.Info info)
    {
        Settings settings = Settings.getInstance();
        settings.putStringWithNoFlush("amzn-ad-id", s);
        setOrigin(info);
        settings.putBooleanWithNoFlush("newSISDIDRequested", false);
        settings.flush();
    }

    public void putAppKey(String s)
    {
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("Application Key must not be null or empty.");
        } else
        {
            appKey = Utils.getURLEncodedString(s);
            return;
        }
    }

    public void putAppName(String s)
    {
        appName = Utils.getURLEncodedString(s);
    }

    public void requestNewSISDeviceIdentifier()
    {
        Settings.getInstance().putBoolean("newSISDIDRequested", true);
    }

    public boolean shouldGetNewSISDeviceIdentifer()
    {
        return Settings.getInstance().getBoolean("newSISDIDRequested", false);
    }

    public boolean shouldGetNewSISRegistration()
    {
        return !isRegisteredWithSIS();
    }
}
