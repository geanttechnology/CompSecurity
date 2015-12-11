// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons;

import android.os.Parcel;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;

public class CouponCompletedSignUp
    implements CompletedSignUp
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CouponCompletedSignUp a(Parcel parcel)
        {
            return new CouponCompletedSignUp(parcel);
        }

        public CouponCompletedSignUp[] a(int i)
        {
            return new CouponCompletedSignUp[i];
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

    public CouponCompletedSignUp()
    {
    }

    public CouponCompletedSignUp(Parcel parcel)
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

}
