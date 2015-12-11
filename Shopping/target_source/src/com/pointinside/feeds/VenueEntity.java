// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;

import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.pointinside.feeds:
//            BaseEntity

public final class VenueEntity extends BaseEntity
{
    public static final class Builder extends BaseEntity.Builder
    {

        private String description;
        private int distance;
        private String email;
        private int geofence;
        private boolean isActive;
        private double latitude;
        private List links;
        private double longitude;
        private String mapCode;
        private String phone;
        private String storeId;
        private VenueType type;
        private String website;
        private List zones;

        public VenueEntity build()
        {
            return new VenueEntity(this);
        }

        public Builder setActive(boolean flag)
        {
            isActive = flag;
            return this;
        }

        public Builder setDescription(String s)
        {
            description = s;
            return this;
        }

        public Builder setDistance(int i)
        {
            distance = i;
            return this;
        }

        public Builder setEmail(String s)
        {
            email = s;
            return this;
        }

        public Builder setGeofence(int i)
        {
            geofence = i;
            return this;
        }

        public Builder setLatitude(double d)
        {
            latitude = d;
            return this;
        }

        public Builder setLinks(List list)
        {
            links = list;
            return this;
        }

        public Builder setLongitude(double d)
        {
            longitude = d;
            return this;
        }

        public Builder setMapCode(String s)
        {
            mapCode = s;
            return this;
        }

        public Builder setPhone(String s)
        {
            phone = s;
            return this;
        }

        public Builder setStoreId(String s)
        {
            storeId = s;
            return this;
        }

        public Builder setType(VenueType venuetype)
        {
            type = venuetype;
            return this;
        }

        public Builder setVenueType(VenueType venuetype)
        {
            type = venuetype;
            return this;
        }

        public Builder setWebsite(String s)
        {
            website = s;
            return this;
        }

        public Builder setZones(List list)
        {
            zones = list;
            return this;
        }













        public Builder()
        {
            mapCode = null;
            description = null;
            storeId = null;
            phone = null;
            geofence = 0x80000000;
            distance = 0x80000000;
            latitude = (0.0D / 0.0D);
            longitude = (0.0D / 0.0D);
            isActive = false;
            zones = new LinkedList();
            links = new LinkedList();
            type = null;
            website = null;
            email = null;
        }

        public Builder(VenueEntity venueentity)
        {
            super(venueentity);
            mapCode = null;
            description = null;
            storeId = null;
            phone = null;
            geofence = 0x80000000;
            distance = 0x80000000;
            latitude = (0.0D / 0.0D);
            longitude = (0.0D / 0.0D);
            isActive = false;
            zones = new LinkedList();
            links = new LinkedList();
            type = null;
            website = null;
            email = null;
            mapCode = venueentity.mapCode;
            description = venueentity.description;
            storeId = venueentity.storeId;
            phone = venueentity.phone;
            geofence = venueentity.geofence;
            latitude = venueentity.latitude;
            longitude = venueentity.longitude;
            isActive = venueentity.isActive;
            links = venueentity.links;
            type = venueentity.type;
            distance = venueentity.distance;
            zones = venueentity.zones;
            website = "";
            email = "";
        }
    }

    public static final class VenueType extends Enum
    {

        private static final VenueType $VALUES[];
        public static final VenueType Airport;
        public static final VenueType AmusementPark;
        public static final VenueType BigBox;
        public static final VenueType ConventionCenter;
        public static final VenueType Corporate;
        public static final VenueType CruiseShip;
        public static final VenueType Event;
        public static final VenueType Hospital;
        public static final VenueType Mall;
        public static final VenueType Stadium;
        public static final VenueType Tradeshow;

        public static VenueType valueOf(String s)
        {
            return (VenueType)Enum.valueOf(com/pointinside/feeds/VenueEntity$VenueType, s);
        }

        public static VenueType[] values()
        {
            return (VenueType[])$VALUES.clone();
        }

        static 
        {
            Mall = new VenueType("Mall", 0);
            Airport = new VenueType("Airport", 1);
            BigBox = new VenueType("BigBox", 2);
            Hospital = new VenueType("Hospital", 3);
            Stadium = new VenueType("Stadium", 4);
            ConventionCenter = new VenueType("ConventionCenter", 5);
            Event = new VenueType("Event", 6);
            CruiseShip = new VenueType("CruiseShip", 7);
            Tradeshow = new VenueType("Tradeshow", 8);
            AmusementPark = new VenueType("AmusementPark", 9);
            Corporate = new VenueType("Corporate", 10);
            $VALUES = (new VenueType[] {
                Mall, Airport, BigBox, Hospital, Stadium, ConventionCenter, Event, CruiseShip, Tradeshow, AmusementPark, 
                Corporate
            });
        }

        private VenueType(String s, int i)
        {
            super(s, i);
        }
    }


    public final String description;
    public final int distance;
    public final String email;
    public final int geofence;
    public final boolean isActive;
    public final double latitude;
    public final List links;
    public final double longitude;
    public final String mapCode;
    public final String phone;
    public final String storeId;
    public final VenueType type;
    public final String website;
    public final List zones;

    VenueEntity()
    {
        this(new Builder());
    }

    private VenueEntity(Builder builder)
    {
        super(builder);
        mapCode = builder.mapCode;
        description = builder.description;
        storeId = builder.storeId;
        phone = builder.phone;
        geofence = builder.geofence;
        latitude = builder.latitude;
        longitude = builder.longitude;
        isActive = builder.isActive;
        links = builder.links;
        type = builder.type;
        distance = builder.distance;
        zones = builder.zones;
        website = "";
        email = "";
    }


    public static VenueEntity copy(VenueEntity venueentity)
    {
        return (new Builder(venueentity)).build();
    }
}
