// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import android.os.Parcel;
import com.target.mothership.model.coupons.interfaces.RegisteredPhone;

class TGTRegisteredPhone
    implements RegisteredPhone
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTRegisteredPhone a(Parcel parcel)
        {
            return new TGTRegisteredPhone(parcel);
        }

        public TGTRegisteredPhone[] a(int i)
        {
            return new TGTRegisteredPhone[i];
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
    private String mPhoneNumber;

    TGTRegisteredPhone()
    {
    }

    private TGTRegisteredPhone(Parcel parcel)
    {
        mPhoneNumber = parcel.readString();
    }


    public String a()
    {
        return mPhoneNumber;
    }

    public void a(String s)
    {
        mPhoneNumber = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mPhoneNumber);
    }

}
