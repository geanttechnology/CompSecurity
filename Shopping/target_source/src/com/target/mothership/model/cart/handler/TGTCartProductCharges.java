// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.CartProductCharges;
import com.target.mothership.util.c;
import java.math.BigDecimal;
import java.util.Currency;

public class TGTCartProductCharges
    implements CartProductCharges
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCartProductCharges a(Parcel parcel)
        {
            return new TGTCartProductCharges(parcel);
        }

        public TGTCartProductCharges[] a(int i)
        {
            return new TGTCartProductCharges[i];
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
    private BigDecimal mSalesTax;
    private Currency mSalesTaxCurrency;
    private BigDecimal mShippingCharge;
    private Currency mShippingChargeCurrency;
    private BigDecimal mShippingTax;
    private Currency mShippingTaxCurrency;

    TGTCartProductCharges()
    {
    }

    private TGTCartProductCharges(Parcel parcel)
    {
        mSalesTax = (BigDecimal)parcel.readSerializable();
        mSalesTaxCurrency = (Currency)parcel.readSerializable();
        mShippingCharge = (BigDecimal)parcel.readSerializable();
        mShippingChargeCurrency = (Currency)parcel.readSerializable();
        mShippingTax = (BigDecimal)parcel.readSerializable();
        mShippingTaxCurrency = (Currency)parcel.readSerializable();
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
        mShippingTaxCurrency = s;
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
        mSalesTax = s;
    }

    public void c(String s)
    {
        if (s != null)
        {
            s = Currency.getInstance(s);
        } else
        {
            s = c.USD;
        }
        mSalesTaxCurrency = s;
    }

    public void d(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mShippingCharge = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(String s)
    {
        if (s != null)
        {
            s = Currency.getInstance(s);
        } else
        {
            s = c.USD;
        }
        mShippingChargeCurrency = s;
    }

    public void f(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mShippingTax = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mSalesTax);
        parcel.writeSerializable(mSalesTaxCurrency);
        parcel.writeSerializable(mShippingCharge);
        parcel.writeSerializable(mShippingChargeCurrency);
        parcel.writeSerializable(mShippingTax);
        parcel.writeSerializable(mShippingTaxCurrency);
    }

}
