// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import android.os.Parcel;
import com.target.mothership.model.coupons.interfaces.CouponOffer;

// Referenced classes of package com.target.mothership.model.coupons.handler:
//            TGTBaseCouponOffer

class TGTCouponOffer extends TGTBaseCouponOffer
    implements CouponOffer
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCouponOffer a(Parcel parcel)
        {
            return new TGTCouponOffer(parcel);
        }

        public TGTCouponOffer[] a(int i)
        {
            return new TGTCouponOffer[i];
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
    private String mBarcodeValue;
    private String mContentUri;

    TGTCouponOffer()
    {
    }

    private TGTCouponOffer(Parcel parcel)
    {
        super(parcel);
        mContentUri = parcel.readString();
        mBarcodeValue = parcel.readString();
    }


    public String a()
    {
        return mContentUri;
    }

    public void a(String s)
    {
        mContentUri = s;
    }

    public String b()
    {
        return mBarcodeValue;
    }

    public void c(String s)
    {
        mBarcodeValue = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeString(mContentUri);
        parcel.writeString(mBarcodeValue);
    }

}
