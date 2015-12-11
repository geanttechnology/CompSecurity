// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import com.parse.ParseGeoPoint;

public class ParseUserAddressData
{

    private final String address;
    private final String city;
    private final String countryCode;
    private final ParseGeoPoint parseGeoPoint;
    private final boolean preciselyLocated;
    private final String zipCode;

    public ParseUserAddressData(String s, String s1, String s2, String s3, boolean flag, ParseGeoPoint parsegeopoint)
    {
        address = s;
        city = s1;
        countryCode = s2;
        zipCode = s3;
        preciselyLocated = flag;
        parseGeoPoint = parsegeopoint;
    }

    public String getAddress()
    {
        return address;
    }

    public String getCity()
    {
        return city;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public ParseGeoPoint getParseGeoPoint()
    {
        return parseGeoPoint;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public boolean isPreciselyLocated()
    {
        return preciselyLocated;
    }
}
