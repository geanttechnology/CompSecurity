// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import com.amazon.geo.mapsv2.model.LatLng;

public class MarkerInfo
{
    public static final class MarkerType extends Enum
    {

        private static final MarkerType $VALUES[];
        public static final MarkerType Courier;
        public static final MarkerType Destination;
        public static final MarkerType Origin;

        public static MarkerType valueOf(String s)
        {
            return (MarkerType)Enum.valueOf(com/amazon/now/map/MarkerInfo$MarkerType, s);
        }

        public static MarkerType[] values()
        {
            return (MarkerType[])$VALUES.clone();
        }

        static 
        {
            Destination = new MarkerType("Destination", 0);
            Courier = new MarkerType("Courier", 1);
            Origin = new MarkerType("Origin", 2);
            $VALUES = (new MarkerType[] {
                Destination, Courier, Origin
            });
        }

        private MarkerType(String s, int i)
        {
            super(s, i);
        }
    }


    private final LatLng mCoords;
    private final String mId;
    private final String mImageUrl;
    private final String mTitle;
    private final MarkerType mType;

    public MarkerInfo(String s, double d, double d1)
    {
        this(s, d, d1, null, null, MarkerType.Destination);
    }

    public MarkerInfo(String s, double d, double d1, String s1)
    {
        this(s, d, d1, s1, null, MarkerType.Origin);
    }

    public MarkerInfo(String s, double d, double d1, String s1, String s2)
    {
        this(s, d, d1, s1, s2, MarkerType.Courier);
    }

    private MarkerInfo(String s, double d, double d1, String s1, String s2, 
            MarkerType markertype)
    {
        mTitle = s;
        mCoords = new LatLng(d, d1);
        mImageUrl = s1;
        mId = s2;
        mType = markertype;
    }

    public static boolean isValid(double d, double d1)
    {
        return Math.abs(d) <= 90D && Math.abs(d1) <= 180D;
    }

    public LatLng getCoords()
    {
        return mCoords;
    }

    public String getId()
    {
        return mId;
    }

    public String getImageUrl()
    {
        return mImageUrl;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public MarkerType getType()
    {
        return mType;
    }
}
