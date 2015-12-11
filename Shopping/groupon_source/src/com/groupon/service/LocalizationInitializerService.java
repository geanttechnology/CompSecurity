// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Application;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.telephony.TelephonyManager;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CountriesService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CountryUtil;
import com.groupon.util.GeoUtils;
import java.util.List;
import java.util.Set;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            LocationService

public class LocalizationInitializerService
{

    public static final Country NO_COUNTRY_DETECTED = new Country();
    public static final String QUEBEC = "Qu\351bec";
    private Application context;
    private volatile Country country;
    private CountriesService countryService;
    private CountryUtil countryUtil;
    Geocoder englishGeocoder;
    private GeoUtils geoUtils;
    private LocationService locationService;
    private Logger logger;

    public LocalizationInitializerService()
    {
        country = null;
    }

    private String getNetworkCountryCode(Context context1)
    {
        TelephonyManager telephonymanager = (TelephonyManager)RoboGuice.getInjector(context1).getInstance(android/telephony/TelephonyManager);
        String s = telephonymanager.getSimCountryIso();
        context1 = s;
        if (Strings.isEmpty(s))
        {
            context1 = telephonymanager.getNetworkCountryIso();
        }
        return countryUtil.transformIsoImperfections(context1);
    }

    private void refreshCountry()
    {
        Object obj;
        Object obj1;
        Set set;
        locationService.getLocationAsync(null, 10000);
        obj1 = locationService.getLocation();
        country = new Country();
        set = countryService.getKnownCountries();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        obj = null;
        obj1 = englishGeocoder.getFromLocation(((Location) (obj1)).getLatitude(), ((Location) (obj1)).getLongitude(), 1);
        obj = obj1;
_L1:
        int i;
        if (obj != null && ((List) (obj)).size() > 0)
        {
            Ln.d("StartupService:Found location and locale, setting up preferences.", new Object[0]);
            Address address = (Address)((List) (obj)).get(0);
            String s = ((Address)((List) (obj)).get(0)).getAdminArea();
            obj = Strings.toString(address.getCountryCode()).toLowerCase();
            if (set.contains(obj))
            {
                Exception exception;
                if (Strings.equalsIgnoreCase(obj, "ca") && Strings.equals(s, "Qu\351bec"))
                {
                    country.shortName = "ca_eu";
                    country.isoName = "ca";
                } else
                {
                    Country country1 = country;
                    Country country5 = country;
                    obj = countryUtil.transformIsoImperfections(((String) (obj)));
                    country5.isoName = ((String) (obj));
                    country1.shortName = ((String) (obj));
                }
                i = 1;
                obj = "";
            } else
            {
                obj = country;
                Country country2 = country;
                String s1 = getNetworkCountryCode(context);
                country2.isoName = s1;
                obj.shortName = s1;
                obj = "cntry";
                i = 0;
            }
        } else
        {
            obj = country;
            Country country3 = country;
            String s2 = getNetworkCountryCode(context);
            country3.isoName = s2;
            obj.shortName = s2;
            obj = "addr";
            i = 0;
        }
_L2:
        if (Strings.isEmpty(country.shortName))
        {
            country = NO_COUNTRY_DETECTED;
        }
        if (i != 1 && !set.contains(country.isoName))
        {
            country = NO_COUNTRY_DETECTED;
        }
        logger.logGeneralEvent("gps", "fte", ((String) (obj)), i, Logger.NULL_NST_FIELD);
        return;
        exception;
        geoUtils.logGeocodeException(exception, getClass().getSimpleName());
          goto _L1
        obj = country;
        Country country4 = country;
        String s3 = getNetworkCountryCode(context);
        country4.isoName = s3;
        obj.shortName = s3;
        obj = "loc";
        i = 0;
          goto _L2
    }

    public Country getCountry()
    {
        if (country != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (country == null)
        {
            refreshCountry();
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return country;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
