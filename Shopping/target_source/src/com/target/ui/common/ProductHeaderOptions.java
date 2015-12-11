// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.pointinside.maps.Location;

public class ProductHeaderOptions
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductHeaderOptions a(Parcel parcel)
        {
            return new ProductHeaderOptions(parcel);
        }

        public ProductHeaderOptions[] a(int i)
        {
            return new ProductHeaderOptions[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private final Location mPiLocation;
    private final String mStoreName;
    private final String mTitle;

    protected ProductHeaderOptions(Parcel parcel)
    {
        mTitle = parcel.readString();
        mPiLocation = (Location)parcel.readParcelable(com/pointinside/maps/Location.getClassLoader());
        mStoreName = parcel.readString();
    }

    public ProductHeaderOptions(String s, Location location, String s1)
    {
        mTitle = s;
        mPiLocation = location;
        mStoreName = s1;
    }

    public String a()
    {
        return mTitle;
    }

    public Location b()
    {
        return mPiLocation;
    }

    public String c()
    {
        return mStoreName;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mTitle);
        parcel.writeParcelable(mPiLocation, 0);
        parcel.writeString(mStoreName);
    }

}
