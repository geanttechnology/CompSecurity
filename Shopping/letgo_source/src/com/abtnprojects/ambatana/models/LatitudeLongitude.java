// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.parse.ParseGeoPoint;

public class LatitudeLongitude
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LatitudeLongitude createFromParcel(Parcel parcel)
        {
            return new LatitudeLongitude(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public LatitudeLongitude[] newArray(int i)
        {
            return new LatitudeLongitude[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final double latitude;
    private final double longitude;

    public LatitudeLongitude(double d, double d1)
    {
        latitude = d;
        longitude = d1;
    }

    private LatitudeLongitude(Parcel parcel)
    {
        latitude = parcel.readDouble();
        longitude = parcel.readDouble();
    }


    public LatitudeLongitude(ParseGeoPoint parsegeopoint)
    {
        if (parsegeopoint == null)
        {
            longitude = 4.9406564584124654E-324D;
            latitude = 4.9406564584124654E-324D;
            return;
        } else
        {
            latitude = parsegeopoint.getLatitude();
            longitude = parsegeopoint.getLongitude();
            return;
        }
    }

    public static boolean isValidLocation(double d, double d1)
    {
        return d != 4.9406564584124654E-324D && d1 != 4.9406564584124654E-324D;
    }

    public String asMapsQuery()
    {
        return (new StringBuilder()).append(latitude).append(",").append(longitude).toString();
    }

    public int describeContents()
    {
        return 0;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public boolean isValid()
    {
        return (latitude != 0.0D || longitude != 0.0D) && latitude != 4.9406564584124654E-324D && longitude != 4.9406564584124654E-324D;
    }

    public String latitudeAsString()
    {
        return (new StringBuilder()).append("").append(latitude).toString();
    }

    public String longitudeAsString()
    {
        return (new StringBuilder()).append("").append(longitude).toString();
    }

    public LatLng toLatLng()
    {
        return new LatLng(latitude, longitude);
    }

    public String toString()
    {
        return (new StringBuilder()).append("LatitudeLongitude{latitude=").append(latitude).append(", longitude=").append(longitude).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
    }

}
