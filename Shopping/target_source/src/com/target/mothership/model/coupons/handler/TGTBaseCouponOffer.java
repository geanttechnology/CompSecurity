// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.coupons.CouponIdentifier;
import com.target.mothership.model.coupons.interfaces.BaseCouponOffer;
import java.util.Date;

class TGTBaseCouponOffer
    implements BaseCouponOffer
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTBaseCouponOffer a(Parcel parcel)
        {
            return new TGTBaseCouponOffer(parcel);
        }

        public TGTBaseCouponOffer[] a(int i)
        {
            return new TGTBaseCouponOffer[i];
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
    private CouponIdentifier mCouponIdentifier;
    private String mDescription;
    private Date mEffectiveDate;
    private Date mExpirationDate;

    TGTBaseCouponOffer()
    {
    }

    protected TGTBaseCouponOffer(Parcel parcel)
    {
        Object obj = null;
        super();
        mCouponIdentifier = (CouponIdentifier)parcel.readParcelable(com/target/mothership/common/coupons/CouponIdentifier.getClassLoader());
        mDescription = parcel.readString();
        long l = parcel.readLong();
        Date date;
        if (l == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l);
        }
        mEffectiveDate = date;
        l = parcel.readLong();
        if (l == -1L)
        {
            parcel = obj;
        } else
        {
            parcel = new Date(l);
        }
        mExpirationDate = parcel;
    }

    public void a(CouponIdentifier couponidentifier)
    {
        mCouponIdentifier = couponidentifier;
    }

    public void a(Date date)
    {
        mEffectiveDate = date;
    }

    public void b(String s)
    {
        mDescription = s;
    }

    public void b(Date date)
    {
        mExpirationDate = date;
    }

    public CouponIdentifier c()
    {
        return mCouponIdentifier;
    }

    public String d()
    {
        return mDescription;
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return com.google.a.a.e.c(mExpirationDate);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
        parcel.writeParcelable(mCouponIdentifier, i);
        parcel.writeString(mDescription);
        long l;
        if (mEffectiveDate == null)
        {
            l = -1L;
        } else
        {
            l = mEffectiveDate.getTime();
        }
        parcel.writeLong(l);
        if (mExpirationDate == null)
        {
            l = l1;
        } else
        {
            l = mExpirationDate.getTime();
        }
        parcel.writeLong(l);
    }

}
