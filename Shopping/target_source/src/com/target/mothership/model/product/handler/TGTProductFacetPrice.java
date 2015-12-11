// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductFacetPrice;
import java.math.BigDecimal;
import java.util.Currency;

public class TGTProductFacetPrice
    implements ProductFacetPrice
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductFacetPrice a(Parcel parcel)
        {
            return new TGTProductFacetPrice(parcel);
        }

        public TGTProductFacetPrice[] a(int i)
        {
            return new TGTProductFacetPrice[i];
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
    private String mFormattedPrice;
    private BigDecimal mGetPriceValue;

    TGTProductFacetPrice()
    {
    }

    private TGTProductFacetPrice(Parcel parcel)
    {
        mCurrency = (Currency)parcel.readSerializable();
        mFormattedPrice = parcel.readString();
        mGetPriceValue = (BigDecimal)parcel.readSerializable();
    }


    public void a(String s)
    {
        mFormattedPrice = s;
    }

    public void a(BigDecimal bigdecimal)
    {
        mGetPriceValue = bigdecimal;
    }

    public void a(Currency currency)
    {
        mCurrency = currency;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mCurrency);
        parcel.writeString(mFormattedPrice);
        parcel.writeSerializable(mGetPriceValue);
    }

}
