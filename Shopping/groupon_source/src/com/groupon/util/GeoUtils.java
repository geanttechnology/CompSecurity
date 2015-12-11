// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.location.Address;
import android.location.Location;
import com.crittercism.app.Crittercism;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            GeoPoint

public class GeoUtils
{

    private CurrentCountryManager currentCountryManager;
    private Logger logger;

    public GeoUtils()
    {
    }

    public double distanceBetween(GeoPoint geopoint, GeoPoint geopoint1)
    {
        if (currentCountryManager.getCurrentCountry().usesMetricSystem())
        {
            return metersBetween(geopoint, geopoint1);
        } else
        {
            return milesBetween(geopoint, geopoint1);
        }
    }

    public String distanceBetweenAsString(double d)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("%.1f");
        double d1;
        String s;
        if (currentCountryManager.getCurrentCountry().usesMetricSystem())
        {
            s = "km";
        } else
        {
            s = "mi";
        }
        s = stringbuilder.append(s).toString();
        d1 = d;
        if (currentCountryManager.getCurrentCountry().usesMetricSystem())
        {
            d1 = d / 1000D;
        }
        return String.format(s, new Object[] {
            Double.valueOf(d1)
        });
    }

    public String distanceBetweenAsString(GeoPoint geopoint, GeoPoint geopoint1)
    {
        double d;
        if (currentCountryManager.getCurrentCountry().usesMetricSystem())
        {
            d = metersBetween(geopoint, geopoint1);
        } else
        {
            d = milesBetween(geopoint, geopoint1);
        }
        return distanceBetweenAsString(d);
    }

    public double getClosestDistance(GeoPoint geopoint, List list)
    {
        double d = 1.7976931348623157E+308D;
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            GeoPoint geopoint1 = (GeoPoint)list.next();
            if (geopoint1.getLatitudeDegrees() != 0.0F || geopoint1.getLongitudeDegrees() != 0.0F)
            {
                d = Math.min(d, distanceBetween(geopoint1, geopoint));
            }
        } while (true);
        return d;
    }

    public double getClosestDistanceMeters(GeoPoint geopoint, List list)
    {
        double d = 1.7976931348623157E+308D;
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            GeoPoint geopoint1 = (GeoPoint)list.next();
            if (geopoint1.getLatitudeDegrees() != 0.0F || geopoint1.getLongitudeDegrees() != 0.0F)
            {
                d = Math.min(d, metersBetween(geopoint1, geopoint));
            }
        } while (true);
        return d;
    }

    public void logGeocodeException(Exception exception, String s)
    {
        logger.logGeneralEvent("android_events", "geocode_failed", s, 0, Logger.NULL_NST_FIELD);
        Crittercism.logHandledException(exception);
    }

    protected double metersBetween(GeoPoint geopoint, GeoPoint geopoint1)
    {
        Location location = new Location("");
        Location location1 = new Location("");
        location.setLatitude((double)geopoint.getLatitudeE6() / 1000000D);
        location.setLongitude((double)geopoint.getLongitudeE6() / 1000000D);
        location1.setLatitude((double)geopoint1.getLatitudeE6() / 1000000D);
        location1.setLongitude((double)geopoint1.getLongitudeE6() / 1000000D);
        return (double)location.distanceTo(location1);
    }

    public double milesBetween(GeoPoint geopoint, GeoPoint geopoint1)
    {
        return metersBetween(geopoint, geopoint1) / 1609.3440000000001D;
    }

    public String toString(Address address)
    {
        if (address == null)
        {
            return "";
        }
        ArrayList arraylist = new ArrayList(address.getMaxAddressLineIndex() + 1);
        for (int i = 0; i <= address.getMaxAddressLineIndex(); i++)
        {
            String s = address.getAddressLine(i);
            if (!Strings.equalsIgnoreCase(s, "USA") && !Strings.equalsIgnoreCase(s, "US") && !Strings.equalsIgnoreCase(s, "United States") || address.getMaxAddressLineIndex() == 0)
            {
                arraylist.add(s);
            }
        }

        return Strings.join(", ", arraylist);
    }
}
