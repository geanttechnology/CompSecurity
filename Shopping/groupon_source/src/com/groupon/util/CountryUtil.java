// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Application;
import com.groupon.models.country.Country;
import com.groupon.service.core.StaticSupportInfoService;
import java.util.List;
import java.util.Locale;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            DeviceInfoUtil, ContextUtils

public class CountryUtil
{

    public static final String LEFT_TO_RIGHT_UNICODE_MARK = "\u200E";
    private Application application;
    private DeviceInfoUtil deviceInfoUtil;
    private StaticSupportInfoService staticSupportInfoService;

    public CountryUtil()
    {
    }

    public String addLeftToRightMarkForRTLLanguages(String s)
    {
        String s1 = s;
        if (deviceInfoUtil.isRTLLanguage())
        {
            s1 = (new StringBuilder()).append("\u200E").append(s).toString();
        }
        return s1;
    }

    public Locale getCountryLocale(Country country)
    {
        return new Locale((String)country.localeLanguages.get(0), reverseTransformIsoImperfections(country.shortName));
    }

    public String getDisplayName(String s)
    {
        int i = ContextUtils.getIdentifier(application, (new StringBuilder()).append(Strings.toString(s).toLowerCase()).append("_display_name").toString(), "string");
        if (i == 0)
        {
            return s;
        } else
        {
            return application.getString(i);
        }
    }

    public String getDisplayNameByIsoName(Country country)
    {
        return getDisplayName(country.isoName);
    }

    public String getDisplayNameByShortName(Country country)
    {
        return getDisplayName(country.shortName);
    }

    public Locale getLocale(Country country)
    {
        if (country.isUSACompatible())
        {
            return Locale.US;
        } else
        {
            return getCountryLocale(country);
        }
    }

    public boolean isCountrySupported(String s)
    {
        return staticSupportInfoService.isCountrySupported(s);
    }

    public String reverseTransformIsoImperfections(String s)
    {
        if (Strings.equalsIgnoreCase(s, "uk"))
        {
            return "GB";
        } else
        {
            return reverseTransformIsoImperfectionsFrenchCanada(s);
        }
    }

    public String reverseTransformIsoImperfectionsFrenchCanada(String s)
    {
        String s1 = s;
        if (Strings.equalsIgnoreCase(s.toLowerCase(), "ca_eu"))
        {
            s1 = "CA";
        }
        return s1.toUpperCase();
    }

    public String transformIsoImperfections(String s)
    {
        String s1 = s;
        if (Strings.equalsIgnoreCase(s, "GB"))
        {
            s1 = "uk".toLowerCase();
        }
        return s1;
    }
}
