// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;

public final class Location extends b
{

    private Double latitude;
    private Double longitude;
    private String name;
    private Integer radiusMeters;

    public Location()
    {
    }

    public final volatile b clone()
    {
        return clone();
    }

    public final volatile l clone()
    {
        return clone();
    }

    public final Location clone()
    {
        return (Location)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final Double getLatitude()
    {
        return latitude;
    }

    public final Double getLongitude()
    {
        return longitude;
    }

    public final String getName()
    {
        return name;
    }

    public final Integer getRadiusMeters()
    {
        return radiusMeters;
    }

    public final volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final Location set(String s, Object obj)
    {
        return (Location)super.set(s, obj);
    }

    public final Location setLatitude(Double double1)
    {
        latitude = double1;
        return this;
    }

    public final Location setLongitude(Double double1)
    {
        longitude = double1;
        return this;
    }

    public final Location setName(String s)
    {
        name = s;
        return this;
    }

    public final Location setRadiusMeters(Integer integer)
    {
        radiusMeters = integer;
        return this;
    }
}
