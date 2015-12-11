// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TwinPrimeSDKPvt, TPLog, TPOptionManager, TPProxyDaemon

public class TwinPrimeSDK
{

    static String EVENTLOG_HTTP_CLIENT_HTTPURLCONNECTION = "HttpURLConnection";
    static String EVENTLOG_HTTP_CLIENT_OKHTTP = "OkHttp";
    static String EVENTLOG_HTTP_CLIENT_PICASSO = "Picasso";
    static String EVENTLOG_HTTP_CLIENT_PICASSO_OKHTTP = "Picasso-OkHttp";
    static String EVENTLOG_HTTP_CLIENT_VOLLEY = "Volley";
    static int EVENTLOG_RESPONSE_SOURCE_CACHE = 2;
    static int EVENTLOG_RESPONSE_SOURCE_CONDITIONAL_CACHE = 3;
    static int EVENTLOG_RESPONSE_SOURCE_CONDITIONAL_FAIL = 4;
    static int EVENTLOG_RESPONSE_SOURCE_NETWORK = 1;
    static int EVENTLOG_RESPONSE_SOURCE_UNKOWN = 0;
    public static final String OptionURLBlackList = "com.twinprime.options.urls.exclude";
    public static final String OptionURLWhiteList = "com.twinprime.options.urls.include";
    public static boolean isInitialized = false;
    private static boolean logHandlerSet = false;
    private static String sdkKey = null;

    public TwinPrimeSDK(Context context, String s)
    {
        new TwinPrimeSDK(context, s, null);
    }

    public TwinPrimeSDK(Context context, String s, Map map)
    {
        isInitialized = true;
        if (sdkKey != null)
        {
            sdkKey = s;
        }
        if (TwinPrimeSDKPvt.isSDKReady())
        {
            return;
        }
        if (TPLog.LOG1.isLoggable("TwinPrimeSDK"))
        {
            TPLog.LOG1.i("TwinPrimeSDK", "Initializing");
        }
        if (TPLog.LOG3.isLoggable())
        {
            TPLog.LOG3.d("TwinPrimeSDK", "Version: 1.18.0.1");
            TPLog.LOG3.d("TwinPrimeSDK", "Built: 7/29/15 12:04:49 PM");
        }
        TPOptionManager.getInstance();
        TPOptionManager.setOption(map);
        TwinPrimeSDKPvt.getInstance().initWithKey(context, s);
        getHTTPSProxyPort();
    }

    public static int getHTTPSProxyPort()
    {
        return TPProxyDaemon.getInstance().getPermProxyPort();
    }

    public static void setLogLevel(int i)
    {
        int j = i;
        if (i > 9)
        {
            j = 9;
        }
        TPLog.setAppLogLevel(j);
    }

}
