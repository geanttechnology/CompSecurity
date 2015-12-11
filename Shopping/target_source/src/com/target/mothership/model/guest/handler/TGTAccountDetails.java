// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.guest.interfaces.AccountDetails;

class TGTAccountDetails
    implements Parcelable, AccountDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAccountDetails a(Parcel parcel)
        {
            return new TGTAccountDetails(parcel);
        }

        public TGTAccountDetails[] a(int i)
        {
            return new TGTAccountDetails[i];
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
    private int mCartQuantity;
    private String mEmailAddress;
    private String mFirstName;
    private String mLastName;

    public TGTAccountDetails()
    {
    }

    private TGTAccountDetails(Parcel parcel)
    {
        mFirstName = parcel.readString();
        mLastName = parcel.readString();
        mEmailAddress = parcel.readString();
        mCartQuantity = parcel.readInt();
    }


    public void a(int i)
    {
        mCartQuantity = i;
    }

    public void a(String s)
    {
        mFirstName = s;
    }

    public void b(String s)
    {
        mLastName = s;
    }

    public void c(String s)
    {
        mEmailAddress = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getCartQuantity()
    {
        return mCartQuantity;
    }

    public String getEmailAddress()
    {
        return mEmailAddress;
    }

    public String getFirstName()
    {
        return mFirstName;
    }

    public String getLastName()
    {
        return mLastName;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mFirstName);
        parcel.writeString(mLastName);
        parcel.writeString(mEmailAddress);
        parcel.writeInt(mCartQuantity);
    }

}
