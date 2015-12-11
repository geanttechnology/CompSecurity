// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.guest;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.guest.interfaces.AccountDetails;

public class CacheAccountDetails
    implements Parcelable, AccountDetails
{

    public static final String ACCOUNT_DETAILS_TABLE = "account_details";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CacheAccountDetails createFromParcel(Parcel parcel)
        {
            return new CacheAccountDetails(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CacheAccountDetails[] newArray(int i)
        {
            return new CacheAccountDetails[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private int mCartQuantity;
    private String mEmailAddress;
    private String mFirstName;
    private int mKey;
    private String mLastName;

    public CacheAccountDetails()
    {
    }

    private CacheAccountDetails(Parcel parcel)
    {
        mKey = parcel.readInt();
        mFirstName = parcel.readString();
        mLastName = parcel.readString();
        mEmailAddress = parcel.readString();
        mCartQuantity = parcel.readInt();
    }


    public CacheAccountDetails(AccountDetails accountdetails)
    {
        mEmailAddress = accountdetails.getEmailAddress();
        mFirstName = accountdetails.getFirstName();
        mLastName = accountdetails.getLastName();
        mCartQuantity = accountdetails.getCartQuantity();
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
        parcel.writeInt(mKey);
        parcel.writeString(mFirstName);
        parcel.writeString(mLastName);
        parcel.writeString(mEmailAddress);
        parcel.writeInt(mCartQuantity);
    }

}
