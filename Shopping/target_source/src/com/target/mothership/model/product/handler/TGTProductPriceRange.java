// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductPriceRange;
import com.target.mothership.util.k;
import java.math.BigDecimal;
import java.util.Currency;

public class TGTProductPriceRange
    implements ProductPriceRange
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductPriceRange a(Parcel parcel)
        {
            return new TGTProductPriceRange(parcel);
        }

        public TGTProductPriceRange[] a(int i)
        {
            return new TGTProductPriceRange[i];
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
    private BigDecimal mCurrentPriceRangeMax;
    private BigDecimal mCurrentPriceRangeMin;
    private String mCurrentPriceRangeText;
    private BigDecimal mOriginalPriceRangeMax;
    private BigDecimal mOriginalPriceRangeMin;
    private String mOriginalPriceRangeText;
    private String mPriceQualifier;

    public TGTProductPriceRange()
    {
    }

    private TGTProductPriceRange(Parcel parcel)
    {
        mOriginalPriceRangeMin = (BigDecimal)parcel.readSerializable();
        mOriginalPriceRangeMax = (BigDecimal)parcel.readSerializable();
        mOriginalPriceRangeText = parcel.readString();
        mCurrentPriceRangeMin = (BigDecimal)parcel.readSerializable();
        mCurrentPriceRangeMax = (BigDecimal)parcel.readSerializable();
        mCurrentPriceRangeText = parcel.readString();
        mCurrency = (Currency)parcel.readSerializable();
        mPriceQualifier = parcel.readString();
    }


    public e a()
    {
        return k.a(mOriginalPriceRangeMin);
    }

    public void a(String s)
    {
        mOriginalPriceRangeText = s;
    }

    public void a(BigDecimal bigdecimal)
    {
        mOriginalPriceRangeMin = bigdecimal;
    }

    public void a(Currency currency)
    {
        mCurrency = currency;
    }

    public e b()
    {
        return k.a(mCurrentPriceRangeMin);
    }

    public void b(String s)
    {
        mCurrentPriceRangeText = s;
    }

    public void b(BigDecimal bigdecimal)
    {
        mOriginalPriceRangeMax = bigdecimal;
    }

    public e c()
    {
        return k.a(mCurrentPriceRangeMax);
    }

    public void c(String s)
    {
        mPriceQualifier = s;
    }

    public void c(BigDecimal bigdecimal)
    {
        mCurrentPriceRangeMin = bigdecimal;
    }

    public void d(BigDecimal bigdecimal)
    {
        mCurrentPriceRangeMax = bigdecimal;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mOriginalPriceRangeMin);
        parcel.writeSerializable(mOriginalPriceRangeMax);
        parcel.writeString(mOriginalPriceRangeText);
        parcel.writeSerializable(mCurrentPriceRangeMin);
        parcel.writeSerializable(mCurrentPriceRangeMax);
        parcel.writeString(mCurrentPriceRangeText);
        parcel.writeSerializable(mCurrency);
        parcel.writeString(mPriceQualifier);
    }

}
