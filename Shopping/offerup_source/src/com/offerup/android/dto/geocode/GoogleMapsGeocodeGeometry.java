// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.geocode;


// Referenced classes of package com.offerup.android.dto.geocode:
//            GoogleMapsGeocodeLocation

public class GoogleMapsGeocodeGeometry
{

    GoogleMapsGeocodeLocation location;
    String locationType;

    public GoogleMapsGeocodeGeometry()
    {
    }

    public GoogleMapsGeocodeLocation getLocation()
    {
        return location;
    }

    public String getLocationType()
    {
        return locationType;
    }

    public void setLocation(GoogleMapsGeocodeLocation googlemapsgeocodelocation)
    {
        location = googlemapsgeocodelocation;
    }

    public void setLocationType(String s)
    {
        locationType = s;
    }
}
