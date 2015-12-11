// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.common.Address;
import java.util.ArrayList;
import java.util.List;

class TGTAddress
    implements Parcelable, Address
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAddress a(Parcel parcel)
        {
            return new TGTAddress(parcel);
        }

        public TGTAddress[] a(int i)
        {
            return new TGTAddress[i];
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
    private ArrayList mAddressLines;
    private String mCity;
    private String mCountry;
    private String mFormattedAddress;
    private String mPostalCode;
    private String mStateOrProvince;

    private TGTAddress(Parcel parcel)
    {
        mAddressLines = new ArrayList();
        parcel.readStringList(mAddressLines);
        mCity = parcel.readString();
        mStateOrProvince = parcel.readString();
        mPostalCode = parcel.readString();
        mCountry = parcel.readString();
        mFormattedAddress = parcel.readString();
    }


    TGTAddress(ArrayList arraylist, String s, String s1, String s2, String s3, String s4)
    {
        mAddressLines = arraylist;
        mCity = s;
        mStateOrProvince = s1;
        mPostalCode = s2;
        mCountry = s3;
        mFormattedAddress = s4;
    }

    public ArrayList a()
    {
        return mAddressLines;
    }

    public int describeContents()
    {
        return 0;
    }

    public List getAddressLines()
    {
        return a();
    }

    public String getCity()
    {
        return mCity;
    }

    public String getCountry()
    {
        return mCountry;
    }

    public String getPostalCode()
    {
        return mPostalCode;
    }

    public String getStateOrProvince()
    {
        return mStateOrProvince;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeStringList(mAddressLines);
        parcel.writeString(mCity);
        parcel.writeString(mStateOrProvince);
        parcel.writeString(mPostalCode);
        parcel.writeString(mCountry);
        parcel.writeString(mFormattedAddress);
    }

}
