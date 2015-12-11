// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.entities;

import android.support.v7.aeu;

// Referenced classes of package com.abtnprojects.ambatana.datasource.entities:
//            PointEntity

public class AddressEntity
{

    final String city;
    final String countryCode;
    final PointEntity pointEntity;
    final String provider;
    final String streetName;
    final String zipCode;

    public AddressEntity(PointEntity pointentity, String s, String s1, String s2, String s3, String s4)
    {
        pointEntity = pointentity;
        city = s;
        countryCode = s1;
        streetName = s2;
        zipCode = s3;
        provider = s4;
    }

    public String asJson()
    {
        return (new aeu()).a(this);
    }

    public String getCity()
    {
        return city;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public PointEntity getPointEntity()
    {
        return pointEntity;
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
}
