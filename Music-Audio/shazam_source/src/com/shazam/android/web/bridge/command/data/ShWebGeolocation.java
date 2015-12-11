// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;


public class ShWebGeolocation
{

    private Float accuracy;
    private Double altitude;
    private Float course;
    private double latitude;
    private double longitude;
    private Float speed;

    public ShWebGeolocation()
    {
    }

    private ShWebGeolocation(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        longitude = Builder.access._mth000(builder);
        latitude = Builder.access._mth100(builder);
        altitude = Builder.access._mth200(builder);
        accuracy = Builder.access._mth300(builder);
        course = Builder.access._mth400(builder);
        speed = Builder.access._mth500(builder);
    }

    ShWebGeolocation(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public Float getAccuracy()
    {
        return accuracy;
    }

    public Double getAltitude()
    {
        return altitude;
    }

    public Float getCourse()
    {
        return course;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public Float getSpeed()
    {
        return speed;
    }
}
