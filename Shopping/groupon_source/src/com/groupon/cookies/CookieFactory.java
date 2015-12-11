// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.cookies;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

public class CookieFactory
{

    private static final String BROKEN_ANDROID_ID = "9774d56d682e549c";
    private static final int DEFAULT_EXPIRATION = 0x1b7740;
    private static final String PREFS_BROWSER_COOKIE = "browser_cookie";
    protected static final String PREFS_DEVICE_ID = "device_id";
    protected static final String PREFS_FILE = "groupon_id.xml";
    protected static volatile String browserCookie;
    protected static volatile String uniqueAndroidId;
    private static volatile String userPermalinkCookieValue;
    private String lastSessionCookie;
    private long lastSessionCookieAccess;

    public CookieFactory(Context context)
    {
        init(context);
    }

    public String generateNewSessionId()
    {
        return UUID.randomUUID().toString();
    }

    public String getBrowserCookie()
    {
        return browserCookie;
    }

    public String getSessionCookie()
    {
        long l = System.currentTimeMillis();
        if (lastSessionCookie == null || lastSessionCookieAccess < l - 0x1b7740L)
        {
            lastSessionCookie = generateNewSessionId();
        }
        lastSessionCookieAccess = l;
        return lastSessionCookie;
    }

    public String getUniqueAndroidId()
    {
        return uniqueAndroidId;
    }

    public String getUserPermalinkCookie()
    {
        return userPermalinkCookieValue;
    }

    public void init(Context context)
    {
        Object obj = null;
        if (browserCookie != null && uniqueAndroidId != null) goto _L2; else goto _L1
_L1:
        com/groupon/cookies/CookieFactory;
        JVM INSTR monitorenter ;
        if (browserCookie != null && uniqueAndroidId != null) goto _L4; else goto _L3
_L3:
        SharedPreferences sharedpreferences;
        Object obj1;
        String s;
        sharedpreferences = context.getSharedPreferences("groupon_id.xml", 0);
        obj1 = sharedpreferences.getString("browser_cookie", null);
        s = sharedpreferences.getString("device_id", null);
        if (obj1 == null || s == null) goto _L6; else goto _L5
_L5:
        uniqueAndroidId = s;
        browserCookie = ((String) (obj1));
_L4:
        com/groupon/cookies/CookieFactory;
        JVM INSTR monitorexit ;
        return;
_L6:
        obj1 = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (obj1 == null) goto _L8; else goto _L7
_L7:
        if ("9774d56d682e549c".equals(obj1)) goto _L8; else goto _L9
_L9:
        uniqueAndroidId = UUID.nameUUIDFromBytes(((String) (obj1)).getBytes("utf8")).toString();
_L10:
        browserCookie = UUID.nameUUIDFromBytes(MessageDigest.getInstance("SHA-256").digest((new StringBuilder()).append(uniqueAndroidId).append("-GR0UP0N").toString().getBytes("utf8"))).toString();
        sharedpreferences.edit().putString("browser_cookie", browserCookie).putString("device_id", uniqueAndroidId).apply();
        continue; /* Loop/switch isn't completed */
        context;
        com/groupon/cookies/CookieFactory;
        JVM INSTR monitorexit ;
        throw context;
_L8:
        obj1 = (TelephonyManager)context.getSystemService("phone");
        context = obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        context = ((TelephonyManager) (obj1)).getDeviceId();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        context = UUID.nameUUIDFromBytes(context.getBytes("utf8"));
_L11:
        uniqueAndroidId = context.toString();
          goto _L10
        context;
        throw new RuntimeException(context);
        context = UUID.randomUUID();
          goto _L11
        context;
        throw new RuntimeException(context);
_L2:
        return;
        if (true) goto _L4; else goto _L12
_L12:
    }

    public void refreshBrowserCookie(Context context, String s)
    {
        com/groupon/cookies/CookieFactory;
        JVM INSTR monitorenter ;
        browserCookie = s;
        if (browserCookie != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        init(context);
_L2:
        com/groupon/cookies/CookieFactory;
        JVM INSTR monitorexit ;
        return;
        context.getSharedPreferences("groupon_id.xml", 0).edit().putString("browser_cookie", browserCookie).apply();
        if (true) goto _L2; else goto _L1
_L1:
        context;
        com/groupon/cookies/CookieFactory;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void setUserPermalink(String s)
    {
        com/groupon/cookies/CookieFactory;
        JVM INSTR monitorenter ;
        userPermalinkCookieValue = s;
        com/groupon/cookies/CookieFactory;
        JVM INSTR monitorexit ;
        return;
        s;
        com/groupon/cookies/CookieFactory;
        JVM INSTR monitorexit ;
        throw s;
    }
}
