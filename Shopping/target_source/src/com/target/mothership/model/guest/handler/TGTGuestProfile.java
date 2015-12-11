// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.common.a;
import com.target.mothership.model.guest.interfaces.GuestProfile;

public class TGTGuestProfile
    implements Parcelable, GuestProfile
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTGuestProfile a(Parcel parcel)
        {
            return new TGTGuestProfile(parcel);
        }

        public TGTGuestProfile[] a(int i)
        {
            return new TGTGuestProfile[i];
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
    private a mAddressType;
    private String mCity;
    private String mFirstName;
    private Boolean mIsPrimary;
    private String mLastName;
    private String mScreenName;
    private String mState;

    TGTGuestProfile()
    {
    }

    private TGTGuestProfile(Parcel parcel)
    {
        mAddressId = parcel.readString();
        int i = parcel.readInt();
        a a1;
        if (i == -1)
        {
            a1 = null;
        } else
        {
            a1 = a.values()[i];
        }
        mAddressType = a1;
        mCity = parcel.readString();
        mFirstName = parcel.readString();
        mIsPrimary = (Boolean)parcel.readValue(java/lang/Boolean.getClassLoader());
        mLastName = parcel.readString();
        mState = parcel.readString();
        mScreenName = parcel.readString();
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mAddressId);
        if (mAddressType == null)
        {
            i = -1;
        } else
        {
            i = mAddressType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeString(mCity);
        parcel.writeString(mFirstName);
        parcel.writeValue(mIsPrimary);
        parcel.writeString(mLastName);
        parcel.writeString(mState);
        parcel.writeString(mScreenName);
    }

}
