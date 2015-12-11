// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            ESPNPlayerSdk

public class EPSDKPrefs
{

    static Context ctx = null;
    static final String fAnalyticsAffiliateID = "affiliateId";
    static final String fAnalyticsAffiliateURL = "affiliateUrl";
    static final String fAnalyticsOverwriteAffiliateID = "overwriteaffiliateID";
    static final String fConfigApiKey = "apiKey";
    static final String fConfigApiUrl = "url";
    static final String fConfigConvivaCustomerKey = "convivakey";
    static final String fConfigConvivaPlayerName = "playerName";
    static final String fConfigDeviceOverride = "deviceOverride";
    static final String fConfigDeviceType = "deviceType";
    static final String fConfigIsDeviceIdentified = "isDeviceIdentified";
    static final String fConfigNetworks = "network";
    static final String fConfigOmnitureCurrencyCode = "currencyCode";
    static final String fConfigOmnitureSuite = "suite";
    static final String fConfigOmnitureTrackingServer = "trackingServer";
    static final String fConfigOmnitureTrackingServerSecure = "trackingServerSecure";
    static final String fConfigPoolingInterval = "poolingInterval";
    static final String fConfigStreamLimiting = "streamLimiting";
    static final String fConfigTTL = "ttl";
    static final String fConfigUUID = "uuid";
    static final String fConfigVODApiUrl = "vodUrl";
    static final String fLoggingLevel = "loggingLevel";
    static final String fStartSessionAdobePassId = "adobepasscontentproviderid";
    static final String fStartSessionAdobePassresource = "resource";
    static final String fStartSessionCookie = "startsessioncookie";
    static final String fStartSessionInitType = "inittype";
    static final String fStartSessionPartner = "affiliate";
    static final String fStartSessionToken = "token";
    static final String fStartSessionTokenType = "tokenType";
    static final String fStartSessionUdid = "udid";
    static final String fVideoSessionEventId = "id";
    static final String fVideoSessionMaintainURL = "maintainurl";
    static final String fVideoSessionProgramChangeURL = "programchangeurl";
    static final String fVideoSessionTTL = "ttl";
    static final String fVideoSessionToken = "token";
    static final String kAnalytics = "analytics";
    static final String kConfig = "config";
    static final String kLogging = "logging";
    static final String kStartSession = "startSession";
    static final String kVideoSession = "Session";
    SharedPreferences pref;

    EPSDKPrefs()
    {
    }

    static void clearConfigData()
    {
        (new EPSDKPrefs()).putField("config", "url", "");
        (new EPSDKPrefs()).putField("config", "vodUrl", "");
        (new EPSDKPrefs()).putField("config", "ttl", "");
        (new EPSDKPrefs()).putField("config", "poolingInterval", "");
        (new EPSDKPrefs()).putField("config", "apiKey", "");
        (new EPSDKPrefs()).putField("config", "convivakey", "");
        (new EPSDKPrefs()).putField("config", "playerName", "");
    }

    static void clearStartSessionData()
    {
        (new EPSDKPrefs()).putField("startSession", "affiliate", "");
        (new EPSDKPrefs()).putField("startSession", "udid", "");
        (new EPSDKPrefs()).putField("startSession", "token", "");
        (new EPSDKPrefs()).putField("startSession", "adobepasscontentproviderid", "");
        (new EPSDKPrefs()).putField("startSession", "resource", "");
        (new EPSDKPrefs()).putField("startSession", "tokenType", "");
        (new EPSDKPrefs()).putField("startSession", "inittype", "");
    }

    static String getAffiliateID()
    {
        return (new EPSDKPrefs()).getField("analytics", "affiliateId");
    }

    static String getApiConfigConvivPlayerName()
    {
        return (new EPSDKPrefs()).getField("config", "playerName");
    }

    static String getApiConfigConvivaCustomerKey()
    {
        return (new EPSDKPrefs()).getField("config", "convivakey");
    }

    static String getApiConfigPoolingInterval()
    {
        return (new EPSDKPrefs()).getField("config", "poolingInterval");
    }

    static String getApiConfigTTL()
    {
        return (new EPSDKPrefs()).getField("config", "ttl");
    }

    static String getApiKey()
    {
        return (new StringBuilder("apikey=")).append((new EPSDKPrefs()).getField("config", "apiKey")).toString();
    }

    public static String getApiPartnerName()
    {
        return (new EPSDKPrefs()).getField("startSession", "affiliate");
    }

    static String getApiUrl()
    {
        return (new EPSDKPrefs()).getField("config", "url");
    }

    static String getApinetworks()
    {
        return (new StringBuilder("networks=")).append((new EPSDKPrefs()).getField("config", "network")).toString();
    }

    static String getDeviceTypeParam()
    {
        if ("".equalsIgnoreCase((new EPSDKPrefs()).getField("config", "deviceType").trim()))
        {
            return "device=handset";
        } else
        {
            return (new StringBuilder("device=")).append((new EPSDKPrefs()).getField("config", "deviceType")).toString();
        }
    }

    public static int getLoggingLevel()
    {
        int i;
        try
        {
            i = Integer.parseInt((new EPSDKPrefs()).getField("logging", "loggingLevel"));
        }
        catch (Exception exception)
        {
            Log.e(ESPNPlayerSdk.SDKTAG, "Logging level can't be determined. Defaulting to Verbose");
            return 1;
        }
        return i;
    }

    static String getOmnitureCurrencyCode()
    {
        return (new EPSDKPrefs()).getField("config", "currencyCode");
    }

    static String getOmnitureSuiteID()
    {
        return (new EPSDKPrefs()).getField("config", "suite");
    }

    static String getOmnitureTrackingServer()
    {
        return (new EPSDKPrefs()).getField("config", "trackingServer");
    }

    static String getPlatformForStartSession()
    {
        if ((new EPSDKPrefs()).getBooleanField("config", "deviceOverride", false))
        {
            return (new EPSDKPrefs()).getField("config", "deviceType");
        }
        if ("".equalsIgnoreCase((new EPSDKPrefs()).getField("config", "deviceType").trim()))
        {
            return "android_handset";
        } else
        {
            return (new StringBuilder("android_")).append((new EPSDKPrefs()).getField("config", "deviceType")).toString();
        }
    }

    static String getStartSessionCookie()
    {
        return (new EPSDKPrefs()).getField("startSession", "startsessioncookie");
    }

    static String getUUID()
    {
        return (new EPSDKPrefs()).getField("config", "uuid");
    }

    static String getVODApiUrl()
    {
        return (new EPSDKPrefs()).getField("config", "vodUrl");
    }

    private SharedPreferences loadPrefs(String s)
    {
        SharedPreferences sharedpreferences = null;
        if (s == "logging")
        {
            sharedpreferences = ctx.getSharedPreferences("logging", 0);
        }
        if (s == "config")
        {
            sharedpreferences = ctx.getSharedPreferences("config", 0);
        }
        if (s == "startSession")
        {
            sharedpreferences = ctx.getSharedPreferences("startSession", 0);
        }
        if (s == "Session")
        {
            sharedpreferences = ctx.getSharedPreferences("Session", 0);
        }
        if (s == "analytics")
        {
            sharedpreferences = ctx.getSharedPreferences("analytics", 0);
        }
        return sharedpreferences;
    }

    static boolean shouldOverwriteAffiliateID()
    {
        return (new EPSDKPrefs()).getBooleanField("analytics", "overwriteaffiliateID", true);
    }

    boolean getBooleanField(String s, String s1, boolean flag)
    {
        return loadPrefs(s).getBoolean(s1, flag);
    }

    String getField(String s, String s1)
    {
        return loadPrefs(s).getString(s1, "");
    }

    void putBooleanField(String s, String s1, boolean flag)
    {
        s = loadPrefs(s).edit();
        s.putBoolean(s1, flag);
        s.commit();
    }

    void putField(String s, String s1, String s2)
    {
        s = loadPrefs(s).edit();
        s.putString(s1, s2);
        s.commit();
    }

}
