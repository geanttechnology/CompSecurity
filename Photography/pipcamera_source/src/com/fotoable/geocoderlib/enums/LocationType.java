// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.geocoderlib.enums;


public final class LocationType extends Enum
{

    private static final LocationType $VALUES[];
    public static final LocationType APPROXIMATE;
    public static final LocationType GEOMETRIC_CENTER;
    public static final LocationType NONE;
    public static final LocationType RANGE_INTERPOLATED;
    public static final LocationType ROOFTOP;

    private LocationType(String s, int i)
    {
        super(s, i);
    }

    public static LocationType valueOf(String s)
    {
        return (LocationType)Enum.valueOf(com/fotoable/geocoderlib/enums/LocationType, s);
    }

    public static LocationType[] values()
    {
        return (LocationType[])$VALUES.clone();
    }

    static 
    {
        NONE = new LocationType("NONE", 0);
        ROOFTOP = new LocationType("ROOFTOP", 1);
        RANGE_INTERPOLATED = new LocationType("RANGE_INTERPOLATED", 2);
        GEOMETRIC_CENTER = new LocationType("GEOMETRIC_CENTER", 3);
        APPROXIMATE = new LocationType("APPROXIMATE", 4);
        $VALUES = (new LocationType[] {
            NONE, ROOFTOP, RANGE_INTERPOLATED, GEOMETRIC_CENTER, APPROXIMATE
        });
    }
}
