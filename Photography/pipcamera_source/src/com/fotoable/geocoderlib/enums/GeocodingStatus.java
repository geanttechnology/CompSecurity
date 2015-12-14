// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.geocoderlib.enums;


public final class GeocodingStatus extends Enum
{

    private static final GeocodingStatus $VALUES[];
    public static final GeocodingStatus INVALID_REQUEST;
    public static final GeocodingStatus OK;
    public static final GeocodingStatus OVER_QUERY_LIMIT;
    public static final GeocodingStatus REQUEST_DENIED;
    public static final GeocodingStatus ZERO_RESULTS;

    private GeocodingStatus(String s, int i)
    {
        super(s, i);
    }

    public static GeocodingStatus valueOf(String s)
    {
        return (GeocodingStatus)Enum.valueOf(com/fotoable/geocoderlib/enums/GeocodingStatus, s);
    }

    public static GeocodingStatus[] values()
    {
        return (GeocodingStatus[])$VALUES.clone();
    }

    static 
    {
        OK = new GeocodingStatus("OK", 0);
        ZERO_RESULTS = new GeocodingStatus("ZERO_RESULTS", 1);
        OVER_QUERY_LIMIT = new GeocodingStatus("OVER_QUERY_LIMIT", 2);
        REQUEST_DENIED = new GeocodingStatus("REQUEST_DENIED", 3);
        INVALID_REQUEST = new GeocodingStatus("INVALID_REQUEST", 4);
        $VALUES = (new GeocodingStatus[] {
            OK, ZERO_RESULTS, OVER_QUERY_LIMIT, REQUEST_DENIED, INVALID_REQUEST
        });
    }
}
