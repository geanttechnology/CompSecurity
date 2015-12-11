// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class GeoPoint
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public GeoPoint createFromParcel(Parcel parcel)
        {
            return new GeoPoint(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public GeoPoint[] newArray(int i)
        {
            return new GeoPoint[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private int latitude;
    private int longitude;

    public GeoPoint()
    {
        longitude = 0;
        latitude = 0;
    }

    public GeoPoint(int i, int j)
    {
        latitude = i;
        longitude = j;
    }

    public GeoPoint(Location location)
    {
        latitude = (int)(location.getLatitude() * 1000000D);
        longitude = (int)(location.getLongitude() * 1000000D);
    }

    protected GeoPoint(Parcel parcel)
    {
        latitude = parcel.readInt();
        longitude = parcel.readInt();
    }

    public GeoPoint(com.groupon.db.models.Location location)
    {
        latitude = (int)(location.lat * 1000000D);
        longitude = (int)(location.lng * 1000000D);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof GeoPoint) && latitude == ((GeoPoint)obj).getLatitudeE6() && longitude == ((GeoPoint)obj).getLongitudeE6();
    }

    public float getLatitudeDegrees()
    {
        return (float)((double)latitude / 1000000D);
    }

    public int getLatitudeE6()
    {
        return latitude;
    }

    public float getLongitudeDegrees()
    {
        return (float)((double)longitude / 1000000D);
    }

    public int getLongitudeE6()
    {
        return longitude;
    }

    public int hashCode()
    {
        return Integer.valueOf(latitude).hashCode() * 31 + Integer.valueOf(longitude).hashCode();
    }

    public void setLatitudeE6(int i)
    {
        latitude = i;
    }

    public void setLongitudeE6(int i)
    {
        longitude = i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("GeoPoint (").append(latitude).append(",").append(longitude).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(latitude);
        parcel.writeInt(longitude);
    }

}
