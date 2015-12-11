// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.division;


// Referenced classes of package com.groupon.models.division:
//            Division

public class City extends Division
{

    public City()
    {
    }

    public City(Division division, String s)
    {
        id = division.id;
        name = s;
        geoPoint = division.geoPoint;
        isReserveEnabled = division.isReserveEnabled;
        latE6 = division.latE6;
        lngE6 = division.lngE6;
        timezone = division.timezone;
        timezoneIdentifier = division.timezoneIdentifier;
        timezoneOffsetInSeconds = division.timezoneOffsetInSeconds;
        parent = division;
    }
}
