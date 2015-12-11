// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import android.os.Parcel;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;

// Referenced classes of package com.target.mothership.model.coupons.handler:
//            TGTBaseCouponOffer

class TGTAvailableCouponOffer extends TGTBaseCouponOffer
    implements AvailableCouponOffer
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAvailableCouponOffer a(Parcel parcel)
        {
            return new TGTAvailableCouponOffer(parcel);
        }

        public TGTAvailableCouponOffer[] a(int i)
        {
            return new TGTAvailableCouponOffer[i];
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
    private boolean mAssigned;
    private String mCouponCode;

    TGTAvailableCouponOffer()
    {
    }

    private TGTAvailableCouponOffer(Parcel parcel)
    {
        boolean flag = true;
        super(parcel);
        if (parcel.readByte() != 1)
        {
            flag = false;
        }
        mAssigned = flag;
        mCouponCode = parcel.readString();
    }


    public String a()
    {
        return mCouponCode;
    }

    public void a(String s)
    {
        mCouponCode = s;
    }

    public void a(boolean flag)
    {
        mAssigned = flag;
    }

    public boolean b()
    {
        return mAssigned;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        byte byte0;
        if (mAssigned)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mCouponCode);
    }

}
