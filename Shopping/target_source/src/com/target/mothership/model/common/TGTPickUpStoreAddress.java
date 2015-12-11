// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.common:
//            PickUpStoreAddress, PhoneNumber

public class TGTPickUpStoreAddress
    implements Parcelable, PickUpStoreAddress
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPickUpStoreAddress a(Parcel parcel)
        {
            return new TGTPickUpStoreAddress(parcel);
        }

        public TGTPickUpStoreAddress[] a(int i)
        {
            return new TGTPickUpStoreAddress[i];
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
    private List mAddressLines;
    private String mCity;
    private String mCountry;
    private String mFormattedAddress;
    private PhoneNumber mPhoneNumber;
    private String mPostalCode;
    private String mStateOrProvince;

    public TGTPickUpStoreAddress()
    {
    }

    private TGTPickUpStoreAddress(Parcel parcel)
    {
        mAddressLines = new ArrayList();
        parcel.readStringList(mAddressLines);
        mCity = parcel.readString();
        mStateOrProvince = parcel.readString();
        mPostalCode = parcel.readString();
        mCountry = parcel.readString();
        mFormattedAddress = parcel.readString();
        mPhoneNumber = (PhoneNumber)parcel.readParcelable(com/target/mothership/model/common/PhoneNumber.getClassLoader());
    }


    public void a(PhoneNumber phonenumber)
    {
        mPhoneNumber = phonenumber;
    }

    public void a(String s)
    {
        mCity = s;
    }

    public void a(List list)
    {
        mAddressLines = list;
    }

    public void b(String s)
    {
        mStateOrProvince = s;
    }

    public void c(String s)
    {
        mPostalCode = s;
    }

    public void d(String s)
    {
        mCountry = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public List getAddressLines()
    {
        return mAddressLines;
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
        parcel.writeParcelable(mPhoneNumber, 0);
    }

}
