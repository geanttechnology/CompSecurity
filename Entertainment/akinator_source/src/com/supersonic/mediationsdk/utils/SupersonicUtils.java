// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import com.supersonic.mediationsdk.config.ConfigFile;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;
import com.supersonic.mediationsdk.logger.ThreadExceptionHandler;
import java.math.BigInteger;
import java.security.MessageDigest;
import org.json.JSONException;
import org.json.JSONObject;

public class SupersonicUtils
{

    private static final String LAST_RESPONSE = "last_response";
    private static final String SDK_VERSION = "6.0";
    private static final String SHARED_PREFERENCES_NAME = "Mediation_Shared_Preferences";
    private static final String TAG = "SupersonicUtils";

    public SupersonicUtils()
    {
    }

    public static void createAndStartWorker(Runnable runnable, String s)
    {
        runnable = new Thread(runnable, s);
        runnable.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        runnable.start();
    }

    public static String get(JSONObject jsonobject, String s)
    {
        String s1;
        try
        {
            s1 = jsonobject.optString(s);
        }
        catch (Throwable throwable)
        {
            SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append("SupersonicUtils:put(jsonSettings:").append(jsonobject).append(", ").append("key:").append(s).append(")").toString(), throwable);
            return "";
        }
        return s1;
    }

    public static String getBase64Auth(String s, String s1)
    {
        s = (new StringBuilder()).append(s).append(":").append(s1).toString();
        return (new StringBuilder()).append("Basic ").append(Base64.encodeToString(s.getBytes(), 10)).toString();
    }

    public static int getCurrentTimestamp()
    {
        return (int)(System.currentTimeMillis() / 1000L);
    }

    public static String getLastResponse(Context context)
    {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString("last_response", "");
    }

    public static String getMD5(String s)
    {
        String s1 = (new BigInteger(1, MessageDigest.getInstance("MD5").digest(s.getBytes()))).toString(16);
_L2:
        String s2 = s1;
        if (s1.length() >= 32)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (new StringBuilder()).append("0").append(s1).toString();
        if (true) goto _L2; else goto _L1
        Throwable throwable;
        throwable;
        if (s == null)
        {
            SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "getMD5(input:null)", throwable);
        } else
        {
            SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append("getMD5(input:").append(s).append(")").toString(), throwable);
        }
        s2 = "";
_L1:
        return s2;
    }

    public static String getSDKVersion()
    {
        return "6.0";
    }

    public static String getSupersonicApplicationKey(Context context)
    {
        return ConfigFile.getConfigFile(context).getProviderJsonSettings("SupersonicAds").optString("applicationKey");
    }

    public static String getSupersonicUserId(Context context)
    {
        return ConfigFile.getConfigFile(context).getProviderJsonSettings("SupersonicAds").optString("userId");
    }

    public static boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean isNetworkConnected(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    public static void put(JSONObject jsonobject, String s, String s1)
    {
        try
        {
            jsonobject.put(s, s1);
            return;
        }
        catch (Throwable throwable)
        {
            SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append("SupersonicUtils:put(jsonSettings:").append(jsonobject).append(", ").append("key:").append(s).append(", ").append("value:").append(s1).append(")").toString(), throwable);
        }
    }

    public static void saveLastResponse(Context context, String s)
    {
        com/supersonic/mediationsdk/utils/SupersonicUtils;
        JVM INSTR monitorenter ;
        context = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        context.putString("last_response", s);
        context.apply();
        com/supersonic/mediationsdk/utils/SupersonicUtils;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void setSupersonicUserId(Context context, String s)
    {
        if (s == null)
        {
            return;
        }
        try
        {
            ConfigFile.getConfigFile(context).getProviderJsonSettings("SupersonicAds").put("userId", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }
}
