// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.model.common.PhoneNumber;
import com.target.mothership.model.common.c;

public class TGTPhoneNumber
    implements PhoneNumber
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPhoneNumber a(Parcel parcel)
        {
            return new TGTPhoneNumber(parcel);
        }

        public TGTPhoneNumber[] a(int i)
        {
            return new TGTPhoneNumber[i];
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

    TGTPhoneNumber()
    {
    }

    private TGTPhoneNumber(Parcel parcel)
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


    public String a()
    {
        return mPhoneNumber;
    }

    public void a(c c1)
    {
        mPhoneNumberType = c1;
    }

    public void a(String s)
    {
        mPhoneNumber = s;
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
