// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;

import android.os.Parcel;
import android.os.Parcelable;

public class Geo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Geo createFromParcel(Parcel parcel)
        {
            return new Geo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Geo[] newArray(int i)
        {
            return new Geo[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final String city;
    private final String countryCode;
    private final double lat;
    private final double lng;
    private final String zipCode;

    public Geo(double d, double d1, String s, String s1, String s2)
    {
        lat = d;
        lng = d1;
        countryCode = s;
        city = s1;
        zipCode = s2;
    }

    protected Geo(Parcel parcel)
    {
        lat = parcel.readDouble();
        lng = parcel.readDouble();
        countryCode = parcel.readString();
        city = parcel.readString();
        zipCode = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCity()
    {
        return city;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public double getLat()
    {
        return lat;
    }

    public String getLatString()
    {
        return Double.toString(lat);
    }

    public double getLng()
    {
        return lng;
    }

    public String getLngString()
    {
        return Double.toString(lat);
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Geo{lat=").append(lat).append(", lng=").append(lng).append(", countryCode='").append(countryCode).append('\'').append(", city='").append(city).append('\'').append(", zipCode='").append(zipCode).append('\'').append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeDouble(lat);
        parcel.writeDouble(lng);
        parcel.writeString(countryCode);
        parcel.writeString(city);
        parcel.writeString(zipCode);
    }

}
