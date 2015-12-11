// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.PersonName;
import com.target.mothership.model.common.PhoneNumber;
import com.target.mothership.model.common.a;
import java.util.ArrayList;
import java.util.List;

public class TGTCartGuestAddress
    implements Parcelable, GuestAddress
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCartGuestAddress a(Parcel parcel)
        {
            return new TGTCartGuestAddress(parcel);
        }

        public TGTCartGuestAddress[] a(int i)
        {
            return new TGTCartGuestAddress[i];
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
    private String mAddressId;
    private List mAddressLines;
    private String mCity;
    private String mCountry;
    private String mFormattedAddress;
    private a mGuestAddressType;
    private Boolean mIsPrimary;
    private PersonName mPersonName;
    private PhoneNumber mPhoneNumber;
    private String mPostalCode;
    private String mStateOrProvince;

    TGTCartGuestAddress()
    {
    }

    private TGTCartGuestAddress(Parcel parcel)
    {
        mAddressLines = new ArrayList();
        parcel.readStringList(mAddressLines);
        mCity = parcel.readString();
        mStateOrProvince = parcel.readString();
        mPostalCode = parcel.readString();
        mCountry = parcel.readString();
        mFormattedAddress = parcel.readString();
        mAddressId = parcel.readString();
        int i = parcel.readInt();
        a a1;
        if (i == -1)
        {
            a1 = null;
        } else
        {
            a1 = com.target.mothership.model.common.a.values()[i];
        }
        mGuestAddressType = a1;
        mPersonName = (PersonName)parcel.readParcelable(com/target/mothership/model/common/PersonName.getClassLoader());
        mPhoneNumber = (PhoneNumber)parcel.readParcelable(com/target/mothership/model/common/PhoneNumber.getClassLoader());
        mIsPrimary = (Boolean)parcel.readValue(java/lang/Boolean.getClassLoader());
    }


    public String a()
    {
        return mAddressId;
    }

    public void a(PersonName personname)
    {
        mPersonName = personname;
    }

    public void a(PhoneNumber phonenumber)
    {
        mPhoneNumber = phonenumber;
    }

    public void a(a a1)
    {
        mGuestAddressType = a1;
    }

    public void a(String s)
    {
        mCity = s;
    }

    public void a(List list)
    {
        mAddressLines = list;
    }

    public a b()
    {
        return mGuestAddressType;
    }

    public void b(String s)
    {
        mStateOrProvince = s;
    }

    public e c()
    {
        return com.google.a.a.e.c(mPersonName);
    }

    public void c(String s)
    {
        mPostalCode = s;
    }

    public PhoneNumber d()
    {
        return mPhoneNumber;
    }

    public void d(String s)
    {
        mCountry = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public Boolean e()
    {
        return mIsPrimary;
    }

    public void e(String s)
    {
        mAddressId = s;
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
        parcel.writeString(mAddressId);
        if (mGuestAddressType == null)
        {
            i = -1;
        } else
        {
            i = mGuestAddressType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeParcelable(mPersonName, 0);
        parcel.writeParcelable(mPhoneNumber, 0);
        parcel.writeValue(mIsPrimary);
    }

}
