// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.common.Address;
import java.util.List;

class TGTStoreAddress
    implements Parcelable, Address
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTStoreAddress a(Parcel parcel)
        {
            return new TGTStoreAddress(parcel);
        }

        public TGTStoreAddress[] a(int i)
        {
            return new TGTStoreAddress[i];
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
    private Address mAddress;

    private TGTStoreAddress(Parcel parcel)
    {
        mAddress = (Address)parcel.readParcelable(com/target/mothership/model/common/Address.getClassLoader());
    }


    public TGTStoreAddress(Address address)
    {
        mAddress = address;
    }

    public int describeContents()
    {
        return 0;
    }

    public List getAddressLines()
    {
        return mAddress.getAddressLines();
    }

    public String getCity()
    {
        return mAddress.getCity();
    }

    public String getCountry()
    {
        return mAddress.getCountry();
    }

    public String getPostalCode()
    {
        return mAddress.getPostalCode();
    }

    public String getStateOrProvince()
    {
        return mAddress.getStateOrProvince();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mAddress, 0);
    }

}
