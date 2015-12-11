// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.model.product.interfaces.BlackFridayPrice;
import java.math.BigDecimal;

public class TGTBlackFridayPrice
    implements BlackFridayPrice
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTBlackFridayPrice a(Parcel parcel)
        {
            return new TGTBlackFridayPrice(parcel);
        }

        public TGTBlackFridayPrice[] a(int i)
        {
            return new TGTBlackFridayPrice[i];
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
    private Dpci mDpci;
    private BigDecimal mPrice;

    TGTBlackFridayPrice()
    {
    }

    private TGTBlackFridayPrice(Parcel parcel)
    {
        mDpci = (Dpci)parcel.readParcelable(com/target/mothership/common/product/Dpci.getClassLoader());
        mPrice = (BigDecimal)parcel.readSerializable();
    }


    public Dpci a()
    {
        return mDpci;
    }

    public void a(Dpci dpci)
    {
        mDpci = dpci;
    }

    public void a(BigDecimal bigdecimal)
    {
        mPrice = bigdecimal;
    }

    public BigDecimal b()
    {
        return mPrice;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mDpci, i);
        parcel.writeSerializable(mPrice);
    }

}
