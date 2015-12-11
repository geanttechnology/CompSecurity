// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.params;

import android.os.Parcel;
import android.os.Parcelable;

public class CouponsSignUpParams
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CouponsSignUpParams a(Parcel parcel)
        {
            return new CouponsSignUpParams(parcel);
        }

        public CouponsSignUpParams[] a(int i)
        {
            return new CouponsSignUpParams[i];
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
    private static final String DEFAULT_PERIOD = "AM";
    private static final String DEFAULT_TIMEZONE = "CST";
    private String mFirstName;
    private String mLastName;
    private String mPeriod;
    private String mTimeZone;
    private String mZipCode;

    public CouponsSignUpParams(Parcel parcel)
    {
        mFirstName = parcel.readString();
        mLastName = parcel.readString();
        mZipCode = parcel.readString();
    }

    public CouponsSignUpParams(String s, String s1, String s2)
    {
        mFirstName = s;
        mLastName = s1;
        mZipCode = s2;
        mTimeZone = "CST";
        mPeriod = "AM";
    }

    public String a()
    {
        return mFirstName;
    }

    public String b()
    {
        return mLastName;
    }

    public String c()
    {
        return mZipCode;
    }

    public String d()
    {
        return mTimeZone;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return mPeriod;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a());
        parcel.writeString(b());
        parcel.writeString(c());
    }

}
