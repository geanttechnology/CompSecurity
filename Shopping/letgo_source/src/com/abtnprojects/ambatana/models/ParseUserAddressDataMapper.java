// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import com.parse.ParseGeoPoint;

// Referenced classes of package com.abtnprojects.ambatana.models:
//            LetgoAddress, LatitudeLongitude, ParseUserAddressData, CurrentUserLocation

public class ParseUserAddressDataMapper
{

    public ParseUserAddressDataMapper()
    {
    }

    public ParseUserAddressData fromLetgoAddress(LetgoAddress letgoaddress)
    {
        Object obj = null;
        if (letgoaddress == null)
        {
            return null;
        }
        LatitudeLongitude latitudelongitude = letgoaddress.getPoint();
        ParseGeoPoint parsegeopoint = obj;
        if (latitudelongitude != null)
        {
            parsegeopoint = obj;
            if (latitudelongitude.isValid())
            {
                parsegeopoint = new ParseGeoPoint(latitudelongitude.getLatitude(), latitudelongitude.getLongitude());
            }
        }
        return new ParseUserAddressData(letgoaddress.getStreetName(), letgoaddress.getCity(), letgoaddress.getCountryCode(), letgoaddress.getZipCode(), CurrentUserLocation.isPreciselyLocated(letgoaddress), parsegeopoint);
    }
}
