// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.net:
//            HttpFetcher

public class UrlLogger
{

    private static String sPrefix;

    public UrlLogger()
    {
    }

    private static String getBaseUrl()
    {
        return (new StringBuilder()).append(ConfigUtils.getString(AndroidPlatform.getInstance().getApplicationContext(), com.amazon.mShop.android.lib.R.string.config_mobile_serviceURL)).append("/tag").toString();
    }

    public static String getRefTagPrefix()
    {
        if (Util.isEmpty(sPrefix))
        {
            sPrefix = ConfigUtils.getStringForApp(AndroidPlatform.getInstance().getApplicationContext(), com.amazon.mShop.android.lib.R.string.config_refTagPrefix);
        }
        return sPrefix;
    }

    public static void logRefTag(String s)
    {
        String s1 = getRefTagPrefix();
        if (Util.isEmpty(s1))
        {
            return;
        } else
        {
            logURL((new StringBuilder()).append("/ref=").append(s1).append(s).toString());
            return;
        }
    }

    public static void logURL(String s)
    {
        String s1 = getBaseUrl();
        if (Util.isEmpty(s1))
        {
            return;
        } else
        {
            HttpFetcher.fetch((new StringBuilder()).append(s1).append(s).toString());
            return;
        }
    }
}
