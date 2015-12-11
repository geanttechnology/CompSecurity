// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.amazon.dp.logger.DPLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AmazonPackageLookup
{

    private static final Map PACKAGE_NAME_TO_FRIENDLY_NAME;
    public static final Set SYSTEM_PACKAGES;
    public static final String SYSTEM_PACKAGE_PREFIX = "/system/";
    public static final String THIRD_PARTY_NAME = "ThirdPartyApp";
    private static final DPLogger log = new DPLogger("AmazonPackageLookup");
    private final String mMyPackageName;
    private final PackageManager mPackageManager;

    public AmazonPackageLookup(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null.");
        } else
        {
            mPackageManager = context.getPackageManager();
            mMyPackageName = context.getPackageName();
            return;
        }
    }

    private String canonicalizePackageName(String s)
    {
        if (s != null && s.contains(":"))
        {
            String as[] = s.split(":");
            if (as.length == 2)
            {
                return as[0];
            }
        }
        return s;
    }

    private int getUidForPackage(String s)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        s = mPackageManager.getApplicationInfo(s, 0);
        if (s == null)
        {
            throw new android.content.pm.PackageManager.NameNotFoundException();
        } else
        {
            return ((ApplicationInfo) (s)).uid;
        }
    }

    public String generateFriendlyName(String s)
    {
        if (isTrustedPackage(s))
        {
            return s;
        } else
        {
            return "ThirdPartyApp";
        }
    }

    public boolean isAmazonPackage(String s)
    {
        if (s != null)
        {
            if (mPackageManager.checkSignatures(mMyPackageName, s = canonicalizePackageName(s)) == 0)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isSystemPackage(String s)
    {
        boolean flag = true;
        if (s == null)
        {
            return false;
        }
        if (s.startsWith("/system/") || SYSTEM_PACKAGES.contains(s))
        {
            return true;
        }
        int i;
        try
        {
            i = getUidForPackage(canonicalizePackageName(s));
            i = mPackageManager.checkSignatures(1000, i);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            log.warn("isSystemPackage", (new StringBuilder()).append("Name not found for package: ").append(s).toString(), new Object[0]);
            return false;
        }
        if (i != 0)
        {
            flag = false;
        }
        return flag;
    }

    public boolean isTrustedPackage(String s)
    {
        return isAmazonPackage(s) || isSystemPackage(s);
    }

    public String packageNameToAmazonFriendlyName(String s)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            String s3 = (String)PACKAGE_NAME_TO_FRIENDLY_NAME.get(s);
            s1 = s3;
            if (s3 == null)
            {
                String s2 = generateFriendlyName(s);
                PACKAGE_NAME_TO_FRIENDLY_NAME.put(s, s2);
                return s2;
            }
        }
        return s1;
    }

    static 
    {
        SYSTEM_PACKAGES = new HashSet();
        SYSTEM_PACKAGES.add("system_server");
        SYSTEM_PACKAGES.add("zygote");
        SYSTEM_PACKAGES.add("ath6kl");
        PACKAGE_NAME_TO_FRIENDLY_NAME = new HashMap();
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.adc", "ADC");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.venezia", "AmazonAppStore");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.avod", "AmazonVideo");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.mp3", "AmazonMp3");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.imdb.mobile", "IMDB");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.kindle", "Kindle");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.dcp", "DCP");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.kindle.otter", "Launcher");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.lab126.otter", "QuickSettings");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.gardemanger", "AppManager");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.kindle.otter.oobe", "OOBE");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.otter.tutorial", "Tutorial");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.kindle.otter.settings", "Settings");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.csapp", "CSApp");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.windowshop", "Shop");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.cloud9", "Silk");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.cloud9[AdobeFlash]", "SilkFlash");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.cloud9[WebKit]", "SilkWebkit");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.alphonso.pulse", "Pulse");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.email", "Email");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.kindle.facebook", "Facebook");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("system_server", "SystemServer");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("/system/bin/mediaserver", "MediaServer");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.android.calendar", "com.android.calendar");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.android.contacts", "com.android.contacts");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.android.email", "com.android.email");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.android.exchange", "com.android.exchange");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.android.providers.contacts", "com.android.providers.contacts");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.android.systemui", "com.android.systemui");
        PACKAGE_NAME_TO_FRIENDLY_NAME.put("com.amazon.kindle.unifiedSearch", "com.amazon.kindle.unifiedSearch");
    }
}
