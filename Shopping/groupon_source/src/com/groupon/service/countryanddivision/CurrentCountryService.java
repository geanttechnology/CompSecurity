// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.groupon.Constants;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.country.Country;
import com.groupon.models.country.converter.CountryConverter;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.DeviceInfoUtil;
import roboguice.util.Strings;

public class CurrentCountryService
{

    private Application context;
    private CountryConverter countryConverter;
    protected DeviceInfoUtil deviceInfoUtil;
    private SharedPreferences sharedPreferences;

    public CurrentCountryService()
    {
    }

    private Country getCountryInfoSyncTask(Context context1, String s)
        throws Exception
    {
        this;
        JVM INSTR monitorenter ;
        context1 = (com.groupon.models.country.json.Country.Wrapper)(new SyncHttp(context1, com/groupon/models/country/json/Country$Wrapper, s, new Object[] {
            "lang", deviceInfoUtil.getLanguageFromLocale()
        })).call();
        context1 = countryConverter.fromJson(context1);
        this;
        JVM INSTR monitorexit ;
        return context1;
        context1;
        throw context1;
    }

    public String getBaseUrl(Country country)
        throws CountryNotSupportedException
    {
        return getBaseUrl(country, true);
    }

    String getBaseUrl(Country country, boolean flag)
        throws CountryNotSupportedException
    {
        if (country == null || country.isUSACompatible())
        {
            return getUSBaseUrl();
        }
        if (!Strings.isEmpty(country.isoName))
        {
            String s;
            if (flag)
            {
                s = (new StringBuilder()).append("/").append(country.isoName).toString();
            } else
            {
                s = "";
            }
            if (country.isEuCompatible())
            {
                return (new StringBuilder()).append(sharedPreferences.getString("base_url_eu", context.getString(0x7f0804c1))).append(s.toLowerCase()).toString();
            }
            if (country.isLATAMCompatible())
            {
                return (new StringBuilder()).append(sharedPreferences.getString("base_url_cl", context.getString(0x7f0804bf))).append(s.toUpperCase()).toString();
            }
            if (country.isINCompatible())
            {
                return (new StringBuilder()).append(sharedPreferences.getString("base_url_in", context.getString(0x7f0804c3))).append(s.toUpperCase()).toString();
            }
            if (country.isJPCompatible())
            {
                return (new StringBuilder()).append(sharedPreferences.getString("base_url_jp", context.getString(0x7f0804c4))).append(s.toUpperCase()).toString();
            }
            if (country.isRussia())
            {
                return (new StringBuilder()).append(sharedPreferences.getString("base_url_ru", context.getString(0x7f0804c7))).append(s.toUpperCase()).toString();
            } else
            {
                return (new StringBuilder()).append(sharedPreferences.getString("base_url_as", context.getString(0x7f0804bd))).append(s.toLowerCase()).toString();
            }
        } else
        {
            throw new CountryNotSupportedException((new StringBuilder()).append("Current country is not supported: ").append(country).toString());
        }
    }

    public Country getCountryFromServer(Country country)
        throws Exception
    {
        if (Strings.equalsIgnoreCase(country.shortName, "us"))
        {
            return Constants.DEFAULT_US_COUNTRY;
        }
        if (Strings.equalsIgnoreCase(country.shortName, "ca"))
        {
            return Constants.DEFAULT_CA_COUNTRY;
        } else
        {
            country = getCountryUrl(country);
            return getCountryInfoSyncTask(context, country);
        }
    }

    String getCountryUrl(Country country)
        throws CountryNotSupportedException
    {
        return (new StringBuilder()).append(getBaseUrl(country, false)).append("/countries/").append(country.isoName.toUpperCase()).toString();
    }

    public String getUSBaseUrl()
    {
        return sharedPreferences.getString("baseUrl", context.getString(0x7f0804bc));
    }
}
