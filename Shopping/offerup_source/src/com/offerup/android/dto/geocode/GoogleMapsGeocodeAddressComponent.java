// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.geocode;

import java.util.List;

public class GoogleMapsGeocodeAddressComponent
{

    String longName;
    String shortName;
    List types;

    public GoogleMapsGeocodeAddressComponent()
    {
    }

    public String getLongName()
    {
        return longName;
    }

    public String getShortName()
    {
        return shortName;
    }

    public List getTypes()
    {
        return types;
    }

    public void setLongName(String s)
    {
        longName = s;
    }

    public void setShortName(String s)
    {
        shortName = s;
    }

    public void setTypes(List list)
    {
        types = list;
    }
}
