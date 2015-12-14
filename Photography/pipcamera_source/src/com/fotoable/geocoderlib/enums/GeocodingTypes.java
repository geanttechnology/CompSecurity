// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.geocoderlib.enums;


public final class GeocodingTypes extends Enum
{

    private static final GeocodingTypes $VALUES[];
    public static final GeocodingTypes ADMINISTRATIVE_AREA_LEVEL_1;
    public static final GeocodingTypes ADMINISTRATIVE_AREA_LEVEL_2;
    public static final GeocodingTypes ADMINISTRATIVE_AREA_LEVEL_3;
    public static final GeocodingTypes AIRPORT;
    public static final GeocodingTypes COLLOQUIAL_AREA;
    public static final GeocodingTypes COUNTRY;
    public static final GeocodingTypes FLOOR;
    public static final GeocodingTypes INTERSECTION;
    public static final GeocodingTypes LOCALITY;
    public static final GeocodingTypes NATURAL_FEATURE;
    public static final GeocodingTypes NEIGHBORHOOD;
    public static final GeocodingTypes NONE;
    public static final GeocodingTypes PARK;
    public static final GeocodingTypes POINT_OF_INTEREST;
    public static final GeocodingTypes POLITICAL;
    public static final GeocodingTypes POSTAL_CODE;
    public static final GeocodingTypes POST_BOX;
    public static final GeocodingTypes PREMISE;
    public static final GeocodingTypes ROOM;
    public static final GeocodingTypes ROUTE;
    public static final GeocodingTypes STREET_ADDRESS;
    public static final GeocodingTypes STREET_NUMBER;
    public static final GeocodingTypes SUBLOCALITY;
    public static final GeocodingTypes SUBPREMISE;

    private GeocodingTypes(String s, int i)
    {
        super(s, i);
    }

    public static GeocodingTypes valueOf(String s)
    {
        return (GeocodingTypes)Enum.valueOf(com/fotoable/geocoderlib/enums/GeocodingTypes, s);
    }

    public static GeocodingTypes[] values()
    {
        return (GeocodingTypes[])$VALUES.clone();
    }

    static 
    {
        NONE = new GeocodingTypes("NONE", 0);
        STREET_ADDRESS = new GeocodingTypes("STREET_ADDRESS", 1);
        ROUTE = new GeocodingTypes("ROUTE", 2);
        INTERSECTION = new GeocodingTypes("INTERSECTION", 3);
        POLITICAL = new GeocodingTypes("POLITICAL", 4);
        COUNTRY = new GeocodingTypes("COUNTRY", 5);
        ADMINISTRATIVE_AREA_LEVEL_1 = new GeocodingTypes("ADMINISTRATIVE_AREA_LEVEL_1", 6);
        ADMINISTRATIVE_AREA_LEVEL_2 = new GeocodingTypes("ADMINISTRATIVE_AREA_LEVEL_2", 7);
        ADMINISTRATIVE_AREA_LEVEL_3 = new GeocodingTypes("ADMINISTRATIVE_AREA_LEVEL_3", 8);
        COLLOQUIAL_AREA = new GeocodingTypes("COLLOQUIAL_AREA", 9);
        LOCALITY = new GeocodingTypes("LOCALITY", 10);
        SUBLOCALITY = new GeocodingTypes("SUBLOCALITY", 11);
        NEIGHBORHOOD = new GeocodingTypes("NEIGHBORHOOD", 12);
        PREMISE = new GeocodingTypes("PREMISE", 13);
        SUBPREMISE = new GeocodingTypes("SUBPREMISE", 14);
        POSTAL_CODE = new GeocodingTypes("POSTAL_CODE", 15);
        NATURAL_FEATURE = new GeocodingTypes("NATURAL_FEATURE", 16);
        AIRPORT = new GeocodingTypes("AIRPORT", 17);
        PARK = new GeocodingTypes("PARK", 18);
        POINT_OF_INTEREST = new GeocodingTypes("POINT_OF_INTEREST", 19);
        POST_BOX = new GeocodingTypes("POST_BOX", 20);
        STREET_NUMBER = new GeocodingTypes("STREET_NUMBER", 21);
        FLOOR = new GeocodingTypes("FLOOR", 22);
        ROOM = new GeocodingTypes("ROOM", 23);
        $VALUES = (new GeocodingTypes[] {
            NONE, STREET_ADDRESS, ROUTE, INTERSECTION, POLITICAL, COUNTRY, ADMINISTRATIVE_AREA_LEVEL_1, ADMINISTRATIVE_AREA_LEVEL_2, ADMINISTRATIVE_AREA_LEVEL_3, COLLOQUIAL_AREA, 
            LOCALITY, SUBLOCALITY, NEIGHBORHOOD, PREMISE, SUBPREMISE, POSTAL_CODE, NATURAL_FEATURE, AIRPORT, PARK, POINT_OF_INTEREST, 
            POST_BOX, STREET_NUMBER, FLOOR, ROOM
        });
    }
}
