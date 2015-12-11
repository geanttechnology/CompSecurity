// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import android.graphics.PointF;
import android.os.Parcel;
import com.pointinside.feeds.PlaceEntity;
import com.pointinside.maps.Location;
import com.pointinside.nav.BaseRouteWaypoint;
import com.pointinside.nav.IRouteWaypoint;
import com.pointinside.nav.RouteException;
import com.pointinside.nav.RouteWaypoint;

public class Place
    implements IRouteWaypoint
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Place createFromParcel(Parcel parcel)
        {
            return new Place(((com.pointinside.feeds.PlaceEntity.Builder)((com.pointinside.feeds.PlaceEntity.Builder)((com.pointinside.feeds.PlaceEntity.Builder)((com.pointinside.feeds.PlaceEntity.Builder)((com.pointinside.feeds.PlaceEntity.Builder)((com.pointinside.feeds.PlaceEntity.Builder)((com.pointinside.feeds.PlaceEntity.Builder)(new com.pointinside.feeds.PlaceEntity.Builder()).setId(parcel.readString())).setZoneId(parcel.readString()).setVenueId(parcel.readString())).setLocationPixelX(parcel.readFloat()).setLocationPixelY(parcel.readFloat()).setCreatedDate(parcel.readLong())).setPlaceType((com.pointinside.feeds.PlaceEntity.PlaceType)parcel.readSerializable()).setLatitude(parcel.readDouble()).setLongitude(parcel.readDouble()).setServiceType(parcel.readString()).setServiceTypeId(parcel.readString()).seteTag(parcel.readString())).setModifiedDate(parcel.readLong())).setName(parcel.readString())).setServerAction((com.pointinside.feeds.BaseEntity.ServerAction)parcel.readSerializable())).build());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Place[] newArray(int i)
        {
            return new Place[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private PlaceEntity mEntity;

    public Place(PlaceEntity placeentity)
    {
        mEntity = placeentity;
    }

    public int describeContents()
    {
        return 0;
    }

    public Location getLocation()
    {
        return (new com.pointinside.maps.Location.Builder()).place(mEntity.id).venue(mEntity.venueId).x(mEntity.locationPixelX).y(mEntity.locationPixelY).zone(mEntity.zoneId).build();
    }

    public PointF getMapPoint()
    {
        return new PointF(mEntity.locationPixelX, mEntity.locationPixelY);
    }

    public String getName()
    {
        return mEntity.name;
    }

    public String getServiceType()
    {
        return mEntity.serviceType;
    }

    public String getServiceTypeId()
    {
        return mEntity.serviceTypeId;
    }

    public com.pointinside.feeds.PlaceEntity.PlaceType getType()
    {
        return mEntity.placeType;
    }

    public volatile BaseRouteWaypoint getWaypoint()
        throws RouteException
    {
        return getWaypoint();
    }

    public RouteWaypoint getWaypoint()
        throws RouteException
    {
        static class _cls2
        {

            static final int $SwitchMap$com$pointinside$feeds$PlaceEntity$PlaceType[];

            static 
            {
                $SwitchMap$com$pointinside$feeds$PlaceEntity$PlaceType = new int[com.pointinside.feeds.PlaceEntity.PlaceType.values().length];
                try
                {
                    $SwitchMap$com$pointinside$feeds$PlaceEntity$PlaceType[com.pointinside.feeds.PlaceEntity.PlaceType.Place.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$pointinside$feeds$PlaceEntity$PlaceType[com.pointinside.feeds.PlaceEntity.PlaceType.Service.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.pointinside.feeds.PlaceEntity.PlaceType[mEntity.placeType.ordinal()])
        {
        default:
            return RouteWaypoint.buildWithTerm(mEntity.name);

        case 1: // '\001'
            return RouteWaypoint.buildWithPlaceUuid(mEntity.id);

        case 2: // '\002'
            return RouteWaypoint.buildWithServiceTypeId(mEntity.serviceTypeId);
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mEntity.id);
        parcel.writeString(mEntity.zoneId);
        parcel.writeString(mEntity.venueId);
        parcel.writeFloat(mEntity.locationPixelX);
        parcel.writeFloat(mEntity.locationPixelY);
        parcel.writeLong(mEntity.createdDate);
        parcel.writeSerializable(mEntity.placeType);
        parcel.writeDouble(mEntity.latitude);
        parcel.writeDouble(mEntity.longitude);
        parcel.writeString(mEntity.serviceType);
        parcel.writeString(mEntity.serviceTypeId);
        parcel.writeString(mEntity.eTag);
        parcel.writeLong(mEntity.modifiedDate);
        parcel.writeString(mEntity.name);
        parcel.writeSerializable(mEntity.serverAction);
    }

}
