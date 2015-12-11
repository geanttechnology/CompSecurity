// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.groupon.cookies.CookieFactory;
import com.groupon.models.country.Country;
import com.groupon.service.AdvertisingIdService;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.DeviceSettings;
import java.util.Locale;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedProvider;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class ConsumerDeviceSettings
    implements DeviceSettings
{

    private final ContextScopedProvider advertisingIdServiceProvider;
    private final Application application;
    private final CookieFactory cookieFactory;
    private final String deviceId;
    private final ContextScopedProvider loginServiceProvider;
    private final String userAgent;
    private final String versionName;

    public ConsumerDeviceSettings(Application application1, PackageInfo packageinfo, String s, String s1, CookieFactory cookiefactory, ContextScopedProvider contextscopedprovider, ContextScopedProvider contextscopedprovider1)
    {
        application = application1;
        versionName = packageinfo.versionName;
        cookieFactory = cookiefactory;
        userAgent = s1;
        deviceId = s;
        loginServiceProvider = contextscopedprovider;
        advertisingIdServiceProvider = contextscopedprovider1;
    }

    public String getAdvertisingId()
    {
        return ((AdvertisingIdService)advertisingIdServiceProvider.get(application)).getAdvertisingId();
    }

    public String getBcookie()
    {
        return cookieFactory.getBrowserCookie();
    }

    public String getClientID()
    {
        return "b9ab4fb791ccb18cac3a83c999a9d559";
    }

    public String getConsumerId()
    {
        String s;
        String s1;
        try
        {
            s1 = ((LoginService)loginServiceProvider.get(application)).getConsumerId();
        }
        catch (Exception exception)
        {
            return "";
        }
        s = s1;
        if (Strings.isEmpty(s1))
        {
            s = "";
        }
        return s;
    }

    public String getCountryCode()
    {
        Object obj;
        try
        {
            obj = ((CurrentCountryManager)RoboGuice.getInjector(application).getInstance(com/groupon/service/countryanddivision/CurrentCountryManager)).getCurrentCountry();
        }
        catch (Exception exception)
        {
            return "";
        }
        if (obj == null)
        {
            return "";
        }
        obj = ((Country) (obj)).shortName.toUpperCase();
        return ((String) (obj));
    }

    public String getDeviceID()
    {
        return deviceId;
    }

    public String getLocale()
    {
        String s;
        try
        {
            s = application.getResources().getConfiguration().locale.toString();
        }
        catch (Exception exception)
        {
            return "";
        }
        return s;
    }

    public String getPlatform()
    {
        return "ANDCON";
    }

    public String getUserAgent()
    {
        return userAgent;
    }

    public String getUserPermalink()
    {
        String s;
        String s1;
        try
        {
            s1 = ((LoginService)loginServiceProvider.get(application)).getUserId();
        }
        catch (Exception exception)
        {
            return "";
        }
        s = s1;
        if (Strings.isEmpty(s1))
        {
            s = "";
        }
        return s;
    }

    public String getVersion()
    {
        return versionName;
    }
}
