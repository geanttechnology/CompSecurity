// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.common.a.e;
import com.target.mothership.model.cart.interfaces.FreeShippingPromotion;
import com.target.mothership.util.c;
import java.math.BigDecimal;

class TGTFreeShippingPromotion
    implements FreeShippingPromotion
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTFreeShippingPromotion a(Parcel parcel)
        {
            return new TGTFreeShippingPromotion(parcel);
        }

        public TGTFreeShippingPromotion[] a(int i)
        {
            return new TGTFreeShippingPromotion[i];
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
    private e mStatus;
    private BigDecimal mThresholdValue;

    TGTFreeShippingPromotion()
    {
    }

    private TGTFreeShippingPromotion(Parcel parcel)
    {
        mThresholdValue = (BigDecimal)parcel.readSerializable();
        int i = parcel.readInt();
        if (i == -1)
        {
            parcel = null;
        } else
        {
            parcel = e.values()[i];
        }
        mStatus = parcel;
    }


    public BigDecimal a()
    {
        return mThresholdValue;
    }

    public void a(e e1)
    {
        mStatus = e1;
    }

    public void a(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mThresholdValue = s;
    }

    public e b()
    {
        return mStatus;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mThresholdValue);
        if (mStatus == null)
        {
            i = -1;
        } else
        {
            i = mStatus.ordinal();
        }
        parcel.writeInt(i);
    }

}
