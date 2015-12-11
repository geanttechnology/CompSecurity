// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.graphics.PointF;
import android.os.Parcel;
import com.pointinside.internal.utils.Objects;
import com.pointinside.internal.utils.StringUtils;
import com.pointinside.nav.BaseRouteWaypoint;
import com.pointinside.nav.IRouteWaypoint;
import com.pointinside.nav.RouteException;
import com.pointinside.nav.RouteWaypoint;
import com.pointinside.products.Ancestor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Location
    implements IRouteWaypoint
{
    public static class Builder
    {

        private List ancestry;
        private double lat;
        private double lng;
        private String place;
        private String storeId;
        private String venue;
        private float x;
        private float y;
        private String zone;

        public Builder ancestry(List list)
        {
            if (list != null)
            {
                ancestry = list;
            }
            return this;
        }

        public Location build()
        {
            return new Location(this);
        }

        public Builder lat(double d)
        {
            lat = d;
            return this;
        }

        public Builder lng(double d)
        {
            lng = d;
            return this;
        }

        public Builder place(String s)
        {
            place = s;
            return this;
        }

        public Builder storeId(String s)
        {
            storeId = s;
            return this;
        }

        public Builder venue(String s)
        {
            venue = s;
            return this;
        }

        public Builder x(float f)
        {
            x = f;
            return this;
        }

        public Builder y(float f)
        {
            y = f;
            return this;
        }

        public Builder zone(String s)
        {
            zone = s;
            return this;
        }










        public Builder()
        {
            ancestry = new ArrayList();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Location createFromParcel(Parcel parcel)
        {
            ArrayList arraylist = new ArrayList();
            parcel.readTypedList(arraylist, Ancestor.CREATOR);
            return (new Builder()).place(parcel.readString()).venue(parcel.readString()).storeId(parcel.readString()).zone(parcel.readString()).x(parcel.readFloat()).y(parcel.readFloat()).ancestry(arraylist).build();
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Location[] newArray(int i)
        {
            return new Location[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final List ancestry;
    public final double lat;
    public final double lng;
    public final String place;
    public final String storeId;
    public final String venue;
    public final float x;
    public final float y;
    public final String zone;

    protected Location(Builder builder)
    {
        ancestry = Collections.unmodifiableList(builder.ancestry);
        place = builder.place;
        storeId = builder.storeId;
        venue = builder.venue;
        x = builder.x;
        y = builder.y;
        lat = builder.lat;
        lng = builder.lng;
        zone = builder.zone;
    }

    public static Location copy(Location location)
    {
        return (new Builder()).venue(location.venue).zone(location.zone).place(location.place).ancestry(location.ancestry).x(location.x).y(location.y).lat(location.lat).lng(location.lng).build();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Location))
            {
                return false;
            }
            obj = (Location)obj;
            if (((Location) (obj)).x != x || ((Location) (obj)).y != y || !Objects.equals(((Location) (obj)).venue, venue) || !Objects.equals(((Location) (obj)).storeId, storeId) || !Objects.equals(((Location) (obj)).zone, zone))
            {
                return false;
            }
        }
        return true;
    }

    public PointF getMapPoint()
    {
        return new PointF(x, y);
    }

    public volatile BaseRouteWaypoint getWaypoint()
        throws RouteException
    {
        return getWaypoint();
    }

    public RouteWaypoint getWaypoint()
        throws RouteException
    {
        return RouteWaypoint.buildWithMapPoint(zone, new PointF(x, y));
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            venue, storeId, zone, Float.valueOf(x), Float.valueOf(y)
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(System.getProperty("line.separator"));
        StringUtils.appendIfNotNull(stringbuilder, " venue", venue);
        StringUtils.appendIfNotNull(stringbuilder, " place", place);
        StringUtils.appendIfNotNull(stringbuilder, " zone", zone);
        StringUtils.appendIfNotNull(stringbuilder, " x", Float.valueOf(x));
        StringUtils.appendIfNotNull(stringbuilder, " y", Float.valueOf(y));
        StringUtils.appendIfNotNull(stringbuilder, " storeId", storeId);
        if (ancestry != null)
        {
            Ancestor ancestor;
            for (Iterator iterator = ancestry.iterator(); iterator.hasNext(); stringbuilder.append(ancestor.toString()))
            {
                ancestor = (Ancestor)iterator.next();
                stringbuilder.append(" ~ Ancestor ~");
                stringbuilder.append(System.getProperty("line.separator"));
            }

        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeTypedList(ancestry);
        parcel.writeString(place);
        parcel.writeString(venue);
        parcel.writeString(storeId);
        parcel.writeString(zone);
        parcel.writeFloat(x);
        parcel.writeFloat(y);
    }

}
