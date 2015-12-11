// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;


class LocationData
{

    private String UUID;
    private int accuracy;
    private int date;
    private long id;
    private double latitude;
    private double longitude;

    LocationData()
    {
    }

    int get_accuracy()
    {
        return accuracy;
    }

    int get_date()
    {
        return date;
    }

    long get_id()
    {
        return id;
    }

    double get_latitude()
    {
        return latitude;
    }

    double get_longitude()
    {
        return longitude;
    }

    String get_uuid()
    {
        return UUID;
    }

    void set_accuracy(int i)
    {
        accuracy = i;
    }

    void set_date(int i)
    {
        date = i;
    }

    void set_id(long l)
    {
        id = l;
    }

    void set_latitude(double d)
    {
        latitude = d;
    }

    void set_longitude(double d)
    {
        longitude = d;
    }

    void set_uuid(String s)
    {
        UUID = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Location : id = ").append(id).append(", location infos : = ").append(accuracy).append(". date de l'event : ").append(date).append(". random uuid : ").append(UUID).append(".").toString();
    }
}
