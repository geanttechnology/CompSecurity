// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;

import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.pointinside.feeds:
//            ZoneEntity

public static final class index extends ilder
{

    private int displayOrder;
    private int index;
    private double point1Latitude;
    private double point1Longitude;
    private double point2Latitude;
    private double point2Longitude;
    private double point3Latitude;
    private double point3Longitude;
    private double point4Latitude;
    private double point4Longitude;
    private List services;
    private List zoneImages;

    public ZoneEntity build()
    {
        return new ZoneEntity(this, null);
    }

    public ilder setDisplayOrder(int i)
    {
        displayOrder = i;
        return this;
    }

    public void setIndex(int i)
    {
        index = i;
    }

    public index setPoint1Latitude(double d)
    {
        point1Latitude = d;
        return this;
    }

    public point1Latitude setPoint1Longitude(double d)
    {
        point1Longitude = d;
        return this;
    }

    public point1Longitude setPoint2Latitude(double d)
    {
        point2Latitude = d;
        return this;
    }

    public point2Latitude setPoint2Longitude(double d)
    {
        point2Longitude = d;
        return this;
    }

    public point2Longitude setPoint3Latitude(double d)
    {
        point3Latitude = d;
        return this;
    }

    public point3Latitude setPoint3Longitude(double d)
    {
        point3Longitude = d;
        return this;
    }

    public point3Longitude setPoint4Latitude(double d)
    {
        point4Latitude = d;
        return this;
    }

    public point4Latitude setPoint4Longitude(double d)
    {
        point4Longitude = d;
        return this;
    }

    public point4Longitude setServices(List list)
    {
        services = list;
        return this;
    }

    public services setZoneImages(List list)
    {
        zoneImages = list;
        return this;
    }













    public ilder()
    {
        point1Latitude = (0.0D / 0.0D);
        point1Longitude = (0.0D / 0.0D);
        point2Latitude = (0.0D / 0.0D);
        point2Longitude = (0.0D / 0.0D);
        point3Latitude = (0.0D / 0.0D);
        point3Longitude = (0.0D / 0.0D);
        point4Latitude = (0.0D / 0.0D);
        point4Longitude = (0.0D / 0.0D);
        displayOrder = 0x80000000;
        zoneImages = new LinkedList();
        services = new LinkedList();
        index = 0x80000000;
    }

    public index(ZoneEntity zoneentity)
    {
        super(zoneentity);
        point1Latitude = (0.0D / 0.0D);
        point1Longitude = (0.0D / 0.0D);
        point2Latitude = (0.0D / 0.0D);
        point2Longitude = (0.0D / 0.0D);
        point3Latitude = (0.0D / 0.0D);
        point3Longitude = (0.0D / 0.0D);
        point4Latitude = (0.0D / 0.0D);
        point4Longitude = (0.0D / 0.0D);
        displayOrder = 0x80000000;
        zoneImages = new LinkedList();
        services = new LinkedList();
        index = 0x80000000;
        point1Latitude = zoneentity.point1Latitude;
        point1Longitude = zoneentity.point1Longitude;
        point2Latitude = zoneentity.point2Latitude;
        point2Longitude = zoneentity.point2Longitude;
        point3Latitude = zoneentity.point3Latitude;
        point3Longitude = zoneentity.point3Longitude;
        point4Latitude = zoneentity.point4Latitude;
        point4Longitude = zoneentity.point4Longitude;
        displayOrder = zoneentity.displayOrder;
        zoneImages = zoneentity.zoneImages;
        services = zoneentity.services;
        index = zoneentity.index;
    }
}
