// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.geocode;

import java.util.List;

// Referenced classes of package com.offerup.android.dto.geocode:
//            GoogleMapsGeocodeGeometry

public class GoogleMapsGeocodeResult
{

    List addressComponents;
    String formattedAddress;
    GoogleMapsGeocodeGeometry geometry;
    List types;

    public GoogleMapsGeocodeResult()
    {
    }

    public List getAddressComponents()
    {
        return addressComponents;
    }

    public String getFormattedAddress()
    {
        return formattedAddress;
    }

    public GoogleMapsGeocodeGeometry getGeometry()
    {
        return geometry;
    }

    public List getTypes()
    {
        return types;
    }

    public void setAddressComponents(List list)
    {
        addressComponents = list;
    }

    public void setFormattedAddress(String s)
    {
        formattedAddress = s;
    }

    public void setGeometry(GoogleMapsGeocodeGeometry googlemapsgeocodegeometry)
    {
        geometry = googlemapsgeocodegeometry;
    }

    public void setTypes(List list)
    {
        types = list;
    }
}
