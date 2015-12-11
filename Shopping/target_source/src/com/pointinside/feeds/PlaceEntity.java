// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


// Referenced classes of package com.pointinside.feeds:
//            BaseEntityWithId

public class PlaceEntity extends BaseEntityWithId
{
    public static final class Builder extends BaseEntityWithId.Builder
    {

        private double latitude;
        private float locationPixelX;
        private float locationPixelY;
        private double longitude;
        private PlaceType placeType;
        private String serviceType;
        private String serviceTypeId;
        private String zoneId;

        public PlaceEntity build()
        {
            return new PlaceEntity(this);
        }

        public Builder setLatitude(double d)
        {
            latitude = d;
            return this;
        }

        public Builder setLocationPixelX(float f)
        {
            locationPixelX = f;
            return this;
        }

        public Builder setLocationPixelY(float f)
        {
            locationPixelY = f;
            return this;
        }

        public Builder setLongitude(double d)
        {
            longitude = d;
            return this;
        }

        public Builder setPlaceType(PlaceType placetype)
        {
            placeType = placetype;
            return this;
        }

        public Builder setServiceType(String s)
        {
            serviceType = s;
            return this;
        }

        public Builder setServiceTypeId(String s)
        {
            serviceTypeId = s;
            return this;
        }

        public Builder setZoneId(String s)
        {
            zoneId = s;
            return this;
        }









        public Builder()
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

        public Builder(PlaceEntity placeentity)
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

    public static final class PlaceType extends Enum
    {

        private static final PlaceType $VALUES[];
        public static final PlaceType Place;
        public static final PlaceType Product;
        public static final PlaceType Service;

        public static PlaceType valueOf(String s)
        {
            return (PlaceType)Enum.valueOf(com/pointinside/feeds/PlaceEntity$PlaceType, s);
        }

        public static PlaceType[] values()
        {
            return (PlaceType[])$VALUES.clone();
        }

        static 
        {
            Place = new PlaceType("Place", 0);
            Service = new PlaceType("Service", 1);
            Product = new PlaceType("Product", 2);
            $VALUES = (new PlaceType[] {
                Place, Service, Product
            });
        }

        private PlaceType(String s, int i)
        {
            super(s, i);
        }
    }


    public final double latitude;
    public final float locationPixelX;
    public final float locationPixelY;
    public final double longitude;
    public final PlaceType placeType;
    public final String serviceType;
    public final String serviceTypeId;
    public final String zoneId;

    public PlaceEntity(Builder builder)
    {
        super(builder);
        zoneId = builder.zoneId;
        latitude = builder.latitude;
        longitude = builder.longitude;
        locationPixelX = builder.locationPixelX;
        locationPixelY = builder.locationPixelY;
        placeType = builder.placeType;
        serviceType = builder.serviceType;
        serviceTypeId = builder.serviceTypeId;
    }

    public static PlaceEntity copy(PlaceEntity placeentity)
    {
        return (new Builder(placeentity)).build();
    }
}
