// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.support.ParcelableCreator;
import com.groupon.util.GeoPoint;

public class Place
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/Place);
    public String label;
    public double lat;
    public double lng;
    public String locationString;
    public String name;
    public String nameWithLocationString;
    public String source;
    public String value;

    public Place()
    {
        name = "";
        lat = 0.0D;
        lng = 0.0D;
        nameWithLocationString = "";
        locationString = "";
        source = "";
        value = "";
        label = "";
    }

    public Place(Parcel parcel)
    {
        name = "";
        lat = 0.0D;
        lng = 0.0D;
        nameWithLocationString = "";
        locationString = "";
        source = "";
        value = "";
        label = "";
        name = parcel.readString();
        lat = parcel.readDouble();
        lng = parcel.readDouble();
        nameWithLocationString = parcel.readString();
        locationString = parcel.readString();
        source = parcel.readString();
        value = parcel.readString();
        label = parcel.readString();
    }

    public Place(String s, double d, double d1)
    {
        name = "";
        lat = 0.0D;
        lng = 0.0D;
        nameWithLocationString = "";
        locationString = "";
        source = "";
        value = "";
        label = "";
        name = s;
        lat = d;
        lng = d1;
    }

    public Place(String s, double d, double d1, String s1, String s2)
    {
        name = "";
        lat = 0.0D;
        lng = 0.0D;
        nameWithLocationString = "";
        locationString = "";
        source = "";
        value = "";
        label = "";
        source = s;
        lat = d;
        lng = d1;
        value = s1;
        label = s2;
    }

    public Place(String s, String s1, double d, double d1)
    {
        name = "";
        lat = 0.0D;
        lng = 0.0D;
        nameWithLocationString = "";
        locationString = "";
        source = "";
        value = "";
        label = "";
        name = s;
        value = s1;
        lat = d;
        lng = d1;
    }

    public static final Place geoPointToPlace(GeoPoint geopoint)
    {
        Place place = new Place();
        place.lat = geopoint.getLatitudeDegrees();
        place.lng = geopoint.getLongitudeDegrees();
        return place;
    }

    public static final Place locationToPlace(Location location)
    {
        Place place = new Place();
        place.lat = location.getLatitude();
        place.lng = location.getLongitude();
        return place;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean isValid()
    {
        return lat != 0.0D || lng != 0.0D;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeDouble(lat);
        parcel.writeDouble(lng);
        parcel.writeString(nameWithLocationString);
        parcel.writeString(locationString);
        parcel.writeString(source);
        parcel.writeString(value);
        parcel.writeString(label);
    }

}
