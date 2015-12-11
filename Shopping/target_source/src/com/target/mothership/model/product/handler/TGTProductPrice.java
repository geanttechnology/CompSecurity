// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductPrice;
import com.target.mothership.util.k;
import java.math.BigDecimal;
import java.util.Currency;

public class TGTProductPrice
    implements ProductPrice
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductPrice a(Parcel parcel)
        {
            return new TGTProductPrice(parcel);
        }

        public TGTProductPrice[] a(int i)
        {
            return new TGTProductPrice[i];
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
    private BigDecimal mAmountSaved;
    private Currency mCurrency;
    private BigDecimal mCurrentPrice;
    private String mCurrentPriceText;
    private BigDecimal mOriginalPrice;
    private String mOriginalPriceText;
    private Integer mPercentageSaved;
    private String mPriceQualifier;

    public TGTProductPrice()
    {
    }

    private TGTProductPrice(Parcel parcel)
    {
        mOriginalPrice = (BigDecimal)parcel.readSerializable();
        mOriginalPriceText = parcel.readString();
        mCurrentPrice = (BigDecimal)parcel.readSerializable();
        mCurrentPriceText = parcel.readString();
        mAmountSaved = (BigDecimal)parcel.readSerializable();
        mPercentageSaved = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        mCurrency = (Currency)parcel.readSerializable();
        mPriceQualifier = parcel.readString();
    }


    public e a()
    {
        return k.a(mOriginalPrice);
    }

    public void a(Integer integer)
    {
        mPercentageSaved = integer;
    }

    public void a(String s)
    {
        mOriginalPriceText = s;
    }

    public void a(BigDecimal bigdecimal)
    {
        mOriginalPrice = bigdecimal;
    }

    public void a(Currency currency)
    {
        mCurrency = currency;
    }

    public e b()
    {
        return k.a(mCurrentPrice);
    }

    public void b(String s)
    {
        mCurrentPriceText = s;
    }

    public void b(BigDecimal bigdecimal)
    {
        mCurrentPrice = bigdecimal;
    }

    public void c(String s)
    {
        mPriceQualifier = s;
    }

    public void c(BigDecimal bigdecimal)
    {
        mAmountSaved = bigdecimal;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mOriginalPrice);
        parcel.writeString(mOriginalPriceText);
        parcel.writeSerializable(mCurrentPrice);
        parcel.writeString(mCurrentPriceText);
        parcel.writeSerializable(mAmountSaved);
        parcel.writeValue(mPercentageSaved);
        parcel.writeSerializable(mCurrency);
        parcel.writeString(mPriceQualifier);
    }

}
