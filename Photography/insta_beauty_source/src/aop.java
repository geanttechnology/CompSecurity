// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.geocoderlib.enums.GeocodingLanguage;
import com.fotoable.geocoderlib.enums.GeocodingStatus;
import com.fotoable.geocoderlib.enums.GeocodingType;
import com.fotoable.geocoderlib.enums.GeocodingTypes;
import com.fotoable.geocoderlib.enums.LocationType;
import java.util.ArrayList;
import java.util.Collections;

public class aop
{

    public static GeocodingStatus a(String s)
    {
        if (s.equalsIgnoreCase(GeocodingStatus.INVALID_REQUEST.name()))
        {
            return GeocodingStatus.INVALID_REQUEST;
        }
        if (s.equalsIgnoreCase(GeocodingStatus.OK.name()))
        {
            return GeocodingStatus.OK;
        }
        if (s.equalsIgnoreCase(GeocodingStatus.OVER_QUERY_LIMIT.name()))
        {
            return GeocodingStatus.OVER_QUERY_LIMIT;
        }
        if (s.equalsIgnoreCase(GeocodingStatus.REQUEST_DENIED.name()))
        {
            return GeocodingStatus.REQUEST_DENIED;
        }
        if (s.equalsIgnoreCase(GeocodingStatus.ZERO_RESULTS.name()))
        {
            return GeocodingStatus.ZERO_RESULTS;
        } else
        {
            return GeocodingStatus.INVALID_REQUEST;
        }
    }

    public static transient String a(aoq aoq1, GeocodingTypes ageocodingtypes[])
    {
        ArrayList arraylist = new ArrayList();
        Collections.addAll(arraylist, ageocodingtypes);
        for (int i = 0; i < aoq1.b().size(); i++)
        {
            if (((aoz)aoq1.b().get(i)).b().containsAll(arraylist))
            {
                return ((aoz)aoq1.b().get(i)).a();
            }
        }

        return "";
    }

    public static String a(aos aos1)
    {
        if (aos1 == null)
        {
            return "http://maps.googleapis.com/maps/api/geocode/json?{type}={address_or_latlng}&sensor={sensor}".replace("{sensor}", "true").replace("{type}", "address");
        }
        String s;
        String s1;
        if (aos1.c())
        {
            s = "true";
        } else
        {
            s = "false";
        }
        s = "http://maps.googleapis.com/maps/api/geocode/json?{type}={address_or_latlng}&sensor={sensor}".replace("{sensor}", s);
        if (aos1.b() == GeocodingType.BY_ADDRESS)
        {
            s = s.replace("{type}", "address");
        } else
        {
            s = s.replace("{type}", "latlng");
        }
        s1 = aos1.a().toString();
        aos1 = s1;
        if (s1.length() == 4)
        {
            aos1 = (new StringBuilder()).append(s1.substring(0, 1)).append("-").append(s1.substring(2, 3)).toString();
        }
        return (new StringBuilder()).append(s).append("&").append("language").append("=").append(aos1).toString();
    }

    public static String a(GeocodingStatus geocodingstatus)
    {
        return geocodingstatus.name();
    }

    public static LocationType b(String s)
    {
        if (s.equalsIgnoreCase(LocationType.APPROXIMATE.name()))
        {
            return LocationType.APPROXIMATE;
        }
        if (s.equalsIgnoreCase(LocationType.GEOMETRIC_CENTER.name()))
        {
            return LocationType.GEOMETRIC_CENTER;
        }
        if (s.equalsIgnoreCase(LocationType.RANGE_INTERPOLATED.name()))
        {
            return LocationType.RANGE_INTERPOLATED;
        }
        if (s.equalsIgnoreCase(LocationType.ROOFTOP.name()))
        {
            return LocationType.ROOFTOP;
        } else
        {
            return LocationType.NONE;
        }
    }

    public static ArrayList c(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = s.trim().replace("[", "").replace("]", "").replaceAll("\"", "").split(",");
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            arraylist.add(d(s[i]));
        }

        return arraylist;
    }

    private static GeocodingTypes d(String s)
    {
        if (s.equalsIgnoreCase(GeocodingTypes.ADMINISTRATIVE_AREA_LEVEL_1.name()))
        {
            return GeocodingTypes.ADMINISTRATIVE_AREA_LEVEL_1;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.ADMINISTRATIVE_AREA_LEVEL_2.name()))
        {
            return GeocodingTypes.ADMINISTRATIVE_AREA_LEVEL_2;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.ADMINISTRATIVE_AREA_LEVEL_3.name()))
        {
            return GeocodingTypes.ADMINISTRATIVE_AREA_LEVEL_3;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.AIRPORT.name()))
        {
            return GeocodingTypes.AIRPORT;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.COLLOQUIAL_AREA.name()))
        {
            return GeocodingTypes.COLLOQUIAL_AREA;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.COUNTRY.name()))
        {
            return GeocodingTypes.COUNTRY;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.FLOOR.name()))
        {
            return GeocodingTypes.FLOOR;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.INTERSECTION.name()))
        {
            return GeocodingTypes.INTERSECTION;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.LOCALITY.name()))
        {
            return GeocodingTypes.LOCALITY;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.NATURAL_FEATURE.name()))
        {
            return GeocodingTypes.NATURAL_FEATURE;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.NEIGHBORHOOD.name()))
        {
            return GeocodingTypes.NEIGHBORHOOD;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.PARK.name()))
        {
            return GeocodingTypes.PARK;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.POINT_OF_INTEREST.name()))
        {
            return GeocodingTypes.POINT_OF_INTEREST;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.POLITICAL.name()))
        {
            return GeocodingTypes.POLITICAL;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.POST_BOX.name()))
        {
            return GeocodingTypes.POST_BOX;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.POSTAL_CODE.name()))
        {
            return GeocodingTypes.POSTAL_CODE;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.PREMISE.name()))
        {
            return GeocodingTypes.PREMISE;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.ROOM.name()))
        {
            return GeocodingTypes.ROOM;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.ROUTE.name()))
        {
            return GeocodingTypes.ROUTE;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.STREET_ADDRESS.name()))
        {
            return GeocodingTypes.STREET_ADDRESS;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.STREET_NUMBER.name()))
        {
            return GeocodingTypes.STREET_NUMBER;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.SUBLOCALITY.name()))
        {
            return GeocodingTypes.SUBLOCALITY;
        }
        if (s.equalsIgnoreCase(GeocodingTypes.SUBPREMISE.name()))
        {
            return GeocodingTypes.SUBPREMISE;
        } else
        {
            return GeocodingTypes.NONE;
        }
    }
}
