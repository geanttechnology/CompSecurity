// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


// Referenced classes of package com.pointinside.feeds:
//            PlaceEntity

public static final class ypeId extends lder
{

    private double latitude;
    private float locationPixelX;
    private float locationPixelY;
    private double longitude;
    private e placeType;
    private String serviceType;
    private String serviceTypeId;
    private String zoneId;

    public PlaceEntity build()
    {
        return new PlaceEntity(this);
    }

    public lder setLatitude(double d)
    {
        latitude = d;
        return this;
    }

    public latitude setLocationPixelX(float f)
    {
        locationPixelX = f;
        return this;
    }

    public locationPixelX setLocationPixelY(float f)
    {
        locationPixelY = f;
        return this;
    }

    public locationPixelY setLongitude(double d)
    {
        longitude = d;
        return this;
    }

    public e setPlaceType(e e)
    {
        placeType = e;
        return this;
    }

    public placeType setServiceType(String s)
    {
        serviceType = s;
        return this;
    }

    public serviceType setServiceTypeId(String s)
    {
        serviceTypeId = s;
        return this;
    }

    public serviceTypeId setZoneId(String s)
    {
        zoneId = s;
        return this;
    }









    public e()
    {
        zoneId = null;
        serviceType = null;
        serviceTypeId = null;
        latitude = (0.0D / 0.0D);
        longitude = (0.0D / 0.0D);
        locationPixelX = (0.0F / 0.0F);
        locationPixelY = (0.0F / 0.0F);
        placeType = null;
    }

    public placeType(PlaceEntity placeentity)
    {
        super(placeentity);
        zoneId = null;
        serviceType = null;
        serviceTypeId = null;
        latitude = (0.0D / 0.0D);
        longitude = (0.0D / 0.0D);
        locationPixelX = (0.0F / 0.0F);
        locationPixelY = (0.0F / 0.0F);
        placeType = null;
        zoneId = placeentity.zoneId;
        latitude = placeentity.latitude;
        longitude = placeentity.longitude;
        locationPixelX = placeentity.locationPixelX;
        locationPixelY = placeentity.locationPixelY;
        placeType = placeentity.placeType;
        serviceType = placeentity.serviceType;
        serviceTypeId = placeentity.serviceTypeId;
    }
}
