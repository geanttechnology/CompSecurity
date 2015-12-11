// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Application;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentCountryService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.service.countryanddivision.DivisionsService;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            GeoUtils, CountryUtil, GeoPoint, CountryNotSupportedException, 
//            ArraySharedPreferences

public class DivisionUtil
{

    private AbTestService abTestService;
    private Application application;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private CurrentCountryService currentCountryService;
    private CurrentDivisionManager currentDivisionManager;
    private DivisionsService divisionsService;
    private GeoUtils geoUtils;
    private DateFormat iso8601DateFormat;

    public DivisionUtil()
    {
    }

    private String extractCityNameFromAddress(Address address)
    {
        if (address.getSubLocality() != null)
        {
            return address.getSubLocality();
        }
        if (address.getLocality() != null)
        {
            return address.getLocality();
        }
        if (address.getSubAdminArea() != null)
        {
            return address.getSubAdminArea();
        } else
        {
            return address.getAdminArea();
        }
    }

    protected Double distanceBetween(GeoPoint geopoint, Division division)
    {
        long l = division.latE6;
        long l1 = division.lngE6;
        if (l != 0L && l1 != 0L)
        {
            division = division.geoPoint;
            return Double.valueOf(geoUtils.distanceBetween(geopoint, division));
        } else
        {
            return null;
        }
    }

    public String getCityNameFromAddress(Address address)
    {
        return extractCityNameFromAddress(address);
    }

    public String getCityNameFromGeoPoint(GeoPoint geopoint)
        throws IOException
    {
        Country country = currentCountryManager.getCurrentCountry();
        List list1 = (new Geocoder(application, countryUtil.getLocale(country))).getFromLocation(geopoint.getLatitudeDegrees(), geopoint.getLongitudeDegrees(), 1);
        Object obj1 = null;
        Object obj = obj1;
        if (list1 != null)
        {
            obj = obj1;
            if (!list1.isEmpty())
            {
                obj = obj1;
                if (Strings.equalsIgnoreCase(((Address)list1.get(0)).getCountryCode(), countryUtil.reverseTransformIsoImperfections(country.shortName)))
                {
                    obj = (Address)list1.get(0);
                    if (country.shortName.equalsIgnoreCase("ca"))
                    {
                        List list = ((Geocoder)RoboGuice.getInjector(application).getInstance(Key.get(android/location/Geocoder, Names.named("ENGLISH_GEOCODER")))).getFromLocation(geopoint.getLatitudeDegrees(), geopoint.getLongitudeDegrees(), 1);
                        if (list != null && !list.isEmpty() && Strings.equals(((Address)list.get(0)).getAdminArea(), "Qu\351bec"))
                        {
                            return null;
                        }
                    }
                    Ln.d("mask division: lookup lat %f lng %f and get %s", new Object[] {
                        Float.valueOf(geopoint.getLatitudeDegrees()), Float.valueOf(geopoint.getLongitudeDegrees()), obj
                    });
                    obj = extractCityNameFromAddress(((Address) (obj)));
                }
            }
        }
        return ((String) (obj));
    }

    public Division getDivisionFrom(GeoPoint geopoint)
    {
        Division division1 = null;
        Division division = null;
        if (geopoint != null)
        {
            double d = 1.7976931348623157E+308D;
            Iterator iterator = divisionsService.getDivisions().iterator();
            do
            {
                division1 = division;
                if (!iterator.hasNext())
                {
                    break;
                }
                division1 = (Division)iterator.next();
                Double double1 = distanceBetween(geopoint, division1);
                if (double1 != null && double1.doubleValue() < d)
                {
                    division = division1;
                    d = double1.doubleValue();
                }
            } while (true);
        }
        return division1;
    }

    public ArrayList getDivisionNameValuePairs(Location location)
        throws CountryNotSupportedException
    {
        currentCountryService.getBaseUrl(currentCountryManager.getCurrentCountry());
        String s1 = ((ArraySharedPreferences)RoboGuice.getInjector(application).getInstance(Key.get(com/groupon/util/ArraySharedPreferences, Names.named("loginStore")))).getString("referralCode", null);
        Object obj = currentDivisionManager.getCurrentDivision();
        String s;
        ArrayList arraylist;
        if (((Division) (obj)).hasParent())
        {
            s = ((Division) (obj)).getParentId();
            obj = ((Division) (obj)).id;
        } else
        {
            s = ((Division) (obj)).id;
            obj = null;
        }
        arraylist = new ArrayList();
        if (Strings.notEmpty(s1))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referral_id", s1
            }));
        }
        if (Strings.notEmpty(s))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "division_id", s
            }));
            if (Strings.notEmpty(obj))
            {
                arraylist.addAll(Arrays.asList(new String[] {
                    "area", obj
                }));
            }
        }
        if (location != null)
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "lat", Double.valueOf(location.getLatitude()), "lng", Double.valueOf(location.getLongitude()), "loc_time", iso8601DateFormat.format(Long.valueOf(location.getTime()))
            }));
        }
        return arraylist;
    }

    public ArrayList getDivisionNameValuePairsUnchecked(Location location)
    {
        try
        {
            location = getDivisionNameValuePairs(location);
        }
        // Misplaced declaration of an exception variable
        catch (Location location)
        {
            throw new RuntimeException(location);
        }
        return location;
    }

    public boolean isNearbyAllowedForCurrentDivision()
    {
        String s = currentDivisionManager.getCurrentDivision().id;
        Country country = currentCountryManager.getCurrentCountry();
        boolean flag1 = abTestService.isINTLVariantEnabled("nearby1403%s", "on");
        boolean flag;
        if (country.isUSACompatible() || country.isNearbyEnabledCountry() && flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && Strings.notEmpty(s);
    }
}
