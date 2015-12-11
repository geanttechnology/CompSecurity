// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.inventory;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.common.model.ParcelableHelper;
import com.ebay.nautilus.domain.data.Address;

public final class LocationAddress extends ParcelableHelper
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LocationAddress createFromParcel(Parcel parcel)
        {
            return new LocationAddress(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public LocationAddress[] newArray(int i)
        {
            return new LocationAddress[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String address1;
    public String address2;
    public String city;
    public String country;
    public double latitude;
    public double longitude;
    public String postalCode;
    public String region;

    public LocationAddress()
    {
    }

    public LocationAddress(Parcel parcel)
    {
        address1 = parcel.readString();
        address2 = readOptString(parcel);
        city = parcel.readString();
        region = parcel.readString();
        postalCode = readOptString(parcel);
        country = parcel.readString();
        latitude = parcel.readDouble();
        longitude = parcel.readDouble();
    }

    public LocationAddress(Address address)
    {
        address1 = address.addressFields.getStreet1();
        address2 = address.addressFields.getStreet2();
        city = address.addressFields.getCity();
        region = address.addressFields.getStateOrProvince();
        postalCode = address.addressFields.getPostalCode();
        country = address.addressFields.getCountry();
        latitude = address.getLatitude();
        longitude = address.getLongitude();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(address1);
        writeOptString(parcel, address2);
        parcel.writeString(city);
        parcel.writeString(region);
        writeOptString(parcel, postalCode);
        parcel.writeString(country);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
    }

}
