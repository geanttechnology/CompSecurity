// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.geocoderlib.enums;


public final class GeocodingType extends Enum
{

    private static final GeocodingType $VALUES[];
    public static final GeocodingType BY_ADDRESS;
    public static final GeocodingType BY_COORDINATES;

    private GeocodingType(String s, int i)
    {
        super(s, i);
    }

    public static GeocodingType valueOf(String s)
    {
        return (GeocodingType)Enum.valueOf(com/fotoable/geocoderlib/enums/GeocodingType, s);
    }

    public static GeocodingType[] values()
    {
        return (GeocodingType[])$VALUES.clone();
    }

    static 
    {
        BY_ADDRESS = new GeocodingType("BY_ADDRESS", 0);
        BY_COORDINATES = new GeocodingType("BY_COORDINATES", 1);
        $VALUES = (new GeocodingType[] {
            BY_ADDRESS, BY_COORDINATES
        });
    }
}
