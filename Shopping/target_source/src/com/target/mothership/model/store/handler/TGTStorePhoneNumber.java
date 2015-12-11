// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.common.PhoneNumber;
import com.target.mothership.model.common.c;

public class TGTStorePhoneNumber
    implements Parcelable, PhoneNumber
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTStorePhoneNumber a(Parcel parcel)
        {
            return new TGTStorePhoneNumber(parcel);
        }

        public TGTStorePhoneNumber[] a(int i)
        {
            return new TGTStorePhoneNumber[i];
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
    private c mPhoneNumberType;

    private TGTStorePhoneNumber(Parcel parcel)
    {
        mPhoneNumber = parcel.readString();
        int i = parcel.readInt();
        if (i == -1)
        {
            parcel = null;
        } else
        {
            parcel = c.values()[i];
        }
        mPhoneNumberType = parcel;
    }


    TGTStorePhoneNumber(String s, String s1)
    {
        mPhoneNumber = s;
        mPhoneNumberType = c.a(s1);
    }

    public String a()
    {
        return mPhoneNumber;
    }

    public c b()
    {
        return mPhoneNumberType;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mPhoneNumber);
        if (mPhoneNumberType == null)
        {
            i = -1;
        } else
        {
            i = mPhoneNumberType.ordinal();
        }
        parcel.writeInt(i);
    }

}
