// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import com.amazon.identity.kcpsdk.common.LocaleUtil;
import java.util.Locale;

public final class InternationalizationUtil
{

    private InternationalizationUtil()
    {
    }

    public static String fromAmazonDomainToLocale(String s)
    {
        if (s == null)
        {
            return LocaleUtil.getLocaleAsLanguageTag();
        }
        if (s.endsWith("amazon.co.jp"))
        {
            return LocaleUtil.getLocaleAsLanguageTag(Locale.JAPAN);
        }
        if (s.endsWith("amazon.cn"))
        {
            return LocaleUtil.getLocaleAsLanguageTag(Locale.CHINA);
        } else
        {
            return LocaleUtil.getLocaleAsLanguageTag();
        }
    }

    public static String getAuthPortalAssociationHandleForSpecificAmazonDomain(String s)
    {
        if (s != null)
        {
            if (s.endsWith("amazon.co.jp"))
            {
                return "amzn_device_jp";
            }
            if (s.endsWith("amazon.cn"))
            {
                return "amzn_device_cn";
            }
        }
        return null;
    }
}
