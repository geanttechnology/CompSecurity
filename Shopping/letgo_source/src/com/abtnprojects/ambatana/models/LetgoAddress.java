// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.support.v7.in;
import org.json.JSONObject;

// Referenced classes of package com.abtnprojects.ambatana.models:
//            LatitudeLongitude

public class LetgoAddress
{

    private final String city;
    private final String countryCode;
    private final LatitudeLongitude point;
    private final String provider;
    private final String streetName;
    private final String zipCode;

    public LetgoAddress(String s, String s1, LatitudeLongitude latitudelongitude, String s2, String s3, String s4)
    {
        city = s;
        countryCode = s1;
        point = latitudelongitude;
        streetName = s2;
        zipCode = s3;
        provider = s4;
    }

    public static LetgoAddress obtainFromJson(JSONObject jsonobject, String s)
    {
        if (jsonobject != null)
        {
            Double double1 = in.b(jsonobject, "latitude");
            Double double2 = in.b(jsonobject, "longitude");
            if (double1 != null && double2 != null)
            {
                String s1 = in.c(jsonobject, "country_code");
                String s2 = in.c(jsonobject, "city");
                jsonobject = in.c(jsonobject, "zipcode");
                return new LetgoAddress(s2, s1, new LatitudeLongitude(double1.doubleValue(), double2.doubleValue()), null, jsonobject, s);
            }
        }
        return null;
    }

    public String getCity()
    {
        return city;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public LatitudeLongitude getPoint()
    {
        return point;
    }

    public String getProvider()
    {
        return provider;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public String toString()
    {
        return (new StringBuilder()).append("LetgoAddress{point=").append(point).append(", city='").append(city).append('\'').append(", countryCode='").append(countryCode).append('\'').append(", streetName='").append(streetName).append('\'').append(", zipCode='").append(zipCode).append('\'').append(", provider='").append(provider).append('\'').append('}').toString();
    }
}
