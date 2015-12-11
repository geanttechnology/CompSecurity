// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;

import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.pointinside.feeds:
//            VenueEntity

public static final class email extends email
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
    private e type;
    private String website;
    private List zones;

    public VenueEntity build()
    {
        return new VenueEntity(this, null);
    }

    public email setActive(boolean flag)
    {
        isActive = flag;
        return this;
    }

    public isActive setDescription(String s)
    {
        description = s;
        return this;
    }

    public description setDistance(int i)
    {
        distance = i;
        return this;
    }

    public distance setEmail(String s)
    {
        email = s;
        return this;
    }

    public email setGeofence(int i)
    {
        geofence = i;
        return this;
    }

    public geofence setLatitude(double d)
    {
        latitude = d;
        return this;
    }

    public latitude setLinks(List list)
    {
        links = list;
        return this;
    }

    public links setLongitude(double d)
    {
        longitude = d;
        return this;
    }

    public longitude setMapCode(String s)
    {
        mapCode = s;
        return this;
    }

    public mapCode setPhone(String s)
    {
        phone = s;
        return this;
    }

    public phone setStoreId(String s)
    {
        storeId = s;
        return this;
    }

    public e setType(e e)
    {
        type = e;
        return this;
    }

    public e setVenueType(e e)
    {
        type = e;
        return this;
    }

    public type setWebsite(String s)
    {
        website = s;
        return this;
    }

    public website setZones(List list)
    {
        zones = list;
        return this;
    }













    public e()
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

    public email(VenueEntity venueentity)
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
