// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.CartOfferPrice;
import com.target.mothership.util.c;
import java.math.BigDecimal;
import java.util.Currency;

class TGTCartOfferPrice
    implements CartOfferPrice
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCartOfferPrice a(Parcel parcel)
        {
            return new TGTCartOfferPrice(parcel);
        }

        public TGTCartOfferPrice[] a(int i)
        {
            return new TGTCartOfferPrice[i];
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
    private Currency mCurrency;
    private BigDecimal mValue;

    TGTCartOfferPrice()
    {
    }

    private TGTCartOfferPrice(Parcel parcel)
    {
        mCurrency = (Currency)parcel.readSerializable();
        mValue = (BigDecimal)parcel.readSerializable();
    }


    public void a(String s)
    {
        if (s != null)
        {
            s = Currency.getInstance(s);
        } else
        {
            s = c.USD;
        }
        mCurrency = s;
    }

    public void b(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mValue = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mCurrency);
        parcel.writeSerializable(mValue);
    }

}
