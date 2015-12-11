// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.coupons;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.util.o;

public class CouponIdentifier
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CouponIdentifier a(Parcel parcel)
        {
            return new CouponIdentifier(parcel);
        }

        public CouponIdentifier[] a(int i)
        {
            return new CouponIdentifier[i];
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
    private String mRawId;

    public CouponIdentifier(Parcel parcel)
    {
        a(parcel);
    }

    public CouponIdentifier(String s)
    {
        if (o.c(s))
        {
            throw new IllegalArgumentException("coupon id may not be blank or null");
        } else
        {
            mRawId = s;
            return;
        }
    }

    public void a(Parcel parcel)
    {
        mRawId = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (CouponIdentifier)obj;
            if (mRawId == null ? ((CouponIdentifier) (obj)).mRawId != null : !mRawId.equals(((CouponIdentifier) (obj)).mRawId))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return mRawId.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mRawId);
    }

}
