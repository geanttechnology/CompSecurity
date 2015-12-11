// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.util.Log;

public class LogMessages
{

    public static final String DEV_KEY_MISSING = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.setAppsFlyerKey(...) to set it. ";
    public static final String EVENT_CREATED_WITH_NAME = "******* sendTrackingWithEvent: ";
    public static final String EVENT_DATA = "data: ";
    public static final String LOG_TAG_PREFIX = "AppsFlyer_";
    public static final String PERMISSION_ACCESS_NETWORK_MISSING = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml";
    public static final String PERMISSION_ACCESS_WIFI_MISSING = "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml";
    public static final String PERMISSION_INTERNET_MISSING = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml";
    public static final String PLAY_STORE_REFERRER_RECIEVED = "Play store referrer: ";
    public static final String SERVER_CALL_FAILRED = "failed to send requeset to server. ";
    public static final String SERVER_RESPONSE_CODE = "response code: ";
    public static final String START_LOG_MESSAGE = "Start tracking package: ";
    private static String devKey;
    private static String replacedKey;

    public LogMessages()
    {
    }

    public static void logMessageMaskKey(String s)
    {
        if (s.contains(devKey))
        {
            Log.i("AppsFlyer_", s.replace(devKey, replacedKey));
        }
    }

    public static void setDevKey(String s)
    {
        devKey = s;
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        while (i < s.length()) 
        {
            if (i == 0 || i == 1 || i > s.length() - 5)
            {
                stringbuilder.append(s.charAt(i));
            } else
            {
                stringbuilder.append("*");
            }
            i++;
        }
        replacedKey = stringbuilder.toString();
    }
}
